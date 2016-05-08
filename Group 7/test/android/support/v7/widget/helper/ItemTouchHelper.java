package android.support.v7.widget.helper;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.recyclerview.R$dimen;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$ChildDrawingOrderCallback;
import android.support.v7.widget.RecyclerView$ItemDecoration;
import android.support.v7.widget.RecyclerView$LayoutManager;
import android.support.v7.widget.RecyclerView$OnChildAttachStateChangeListener;
import android.support.v7.widget.RecyclerView$OnItemTouchListener;
import android.support.v7.widget.RecyclerView$State;
import android.support.v7.widget.RecyclerView$ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper$1;
import android.support.v7.widget.helper.ItemTouchHelper$2;
import android.support.v7.widget.helper.ItemTouchHelper$3;
import android.support.v7.widget.helper.ItemTouchHelper$4;
import android.support.v7.widget.helper.ItemTouchHelper$5;
import android.support.v7.widget.helper.ItemTouchHelper$Callback;
import android.support.v7.widget.helper.ItemTouchHelper$ItemTouchHelperGestureListener;
import android.support.v7.widget.helper.ItemTouchHelper$RecoverAnimation;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.List;

public class ItemTouchHelper extends RecyclerView$ItemDecoration implements RecyclerView$OnChildAttachStateChangeListener {
   private static final int ACTION_MODE_DRAG_MASK = 16711680;
   private static final int ACTION_MODE_IDLE_MASK = 255;
   private static final int ACTION_MODE_SWIPE_MASK = 65280;
   public static final int ACTION_STATE_DRAG = 2;
   public static final int ACTION_STATE_IDLE = 0;
   public static final int ACTION_STATE_SWIPE = 1;
   private static final int ACTIVE_POINTER_ID_NONE = -1;
   public static final int ANIMATION_TYPE_DRAG = 8;
   public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
   public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
   private static final boolean DEBUG = false;
   private static final int DIRECTION_FLAG_COUNT = 8;
   public static final int DOWN = 2;
   public static final int END = 32;
   public static final int LEFT = 4;
   private static final int PIXELS_PER_SECOND = 1000;
   public static final int RIGHT = 8;
   public static final int START = 16;
   private static final String TAG = "ItemTouchHelper";
   public static final int UP = 1;
   int mActionState = 0;
   int mActivePointerId = -1;
   ItemTouchHelper$Callback mCallback;
   private RecyclerView$ChildDrawingOrderCallback mChildDrawingOrderCallback = null;
   private List<Integer> mDistances;
   private long mDragScrollStartTimeInMs;
   float mDx;
   float mDy;
   private GestureDetectorCompat mGestureDetector;
   float mInitialTouchX;
   float mInitialTouchY;
   float mMaxSwipeVelocity;
   private final RecyclerView$OnItemTouchListener mOnItemTouchListener = new ItemTouchHelper$2(this);
   private View mOverdrawChild = null;
   private int mOverdrawChildPosition = -1;
   final List<View> mPendingCleanup = new ArrayList();
   List<ItemTouchHelper$RecoverAnimation> mRecoverAnimations = new ArrayList();
   private RecyclerView mRecyclerView;
   private final Runnable mScrollRunnable = new ItemTouchHelper$1(this);
   RecyclerView$ViewHolder mSelected = null;
   int mSelectedFlags;
   float mSelectedStartX;
   float mSelectedStartY;
   private int mSlop;
   private List<RecyclerView$ViewHolder> mSwapTargets;
   float mSwipeEscapeVelocity;
   private final float[] mTmpPosition = new float[2];
   private Rect mTmpRect;
   private VelocityTracker mVelocityTracker;

   public ItemTouchHelper(ItemTouchHelper$Callback var1) {
      this.mCallback = var1;
   }

   private void addChildDrawingOrderCallback() {
      if(VERSION.SDK_INT < 21) {
         if(this.mChildDrawingOrderCallback == null) {
            this.mChildDrawingOrderCallback = new ItemTouchHelper$5(this);
         }

         this.mRecyclerView.setChildDrawingOrderCallback(this.mChildDrawingOrderCallback);
      }
   }

   private int checkHorizontalSwipe(RecyclerView$ViewHolder var1, int var2) {
      if((var2 & 12) != 0) {
         byte var5;
         if(this.mDx > 0.0F) {
            var5 = 8;
         } else {
            var5 = 4;
         }

         float var3;
         float var4;
         if(this.mVelocityTracker != null && this.mActivePointerId > -1) {
            this.mVelocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
            var4 = VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId);
            var3 = VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId);
            byte var6;
            if(var4 > 0.0F) {
               var6 = 8;
            } else {
               var6 = 4;
            }

            var4 = Math.abs(var4);
            if((var6 & var2) != 0 && var5 == var6 && var4 >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && var4 > Math.abs(var3)) {
               return var6;
            }
         }

         var3 = (float)this.mRecyclerView.getWidth();
         var4 = this.mCallback.getSwipeThreshold(var1);
         if((var2 & var5) != 0 && Math.abs(this.mDx) > var3 * var4) {
            return var5;
         }
      }

      return 0;
   }

   private boolean checkSelectForSwipe(int var1, MotionEvent var2, int var3) {
      if(this.mSelected == null && var1 == 2 && this.mActionState != 2 && this.mCallback.isItemViewSwipeEnabled()) {
         if(this.mRecyclerView.getScrollState() == 1) {
            return false;
         } else {
            RecyclerView$ViewHolder var8 = this.findSwipedView(var2);
            if(var8 == null) {
               return false;
            } else {
               var1 = ('\uff00' & this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, var8)) >> 8;
               if(var1 == 0) {
                  return false;
               } else {
                  float var4 = MotionEventCompat.getX(var2, var3);
                  float var5 = MotionEventCompat.getY(var2, var3);
                  var4 -= this.mInitialTouchX;
                  var5 -= this.mInitialTouchY;
                  float var6 = Math.abs(var4);
                  float var7 = Math.abs(var5);
                  if(var6 < (float)this.mSlop && var7 < (float)this.mSlop) {
                     return false;
                  } else {
                     if(var6 > var7) {
                        if(var4 < 0.0F && (var1 & 4) == 0) {
                           return false;
                        }

                        if(var4 > 0.0F && (var1 & 8) == 0) {
                           return false;
                        }
                     } else {
                        if(var5 < 0.0F && (var1 & 1) == 0) {
                           return false;
                        }

                        if(var5 > 0.0F && (var1 & 2) == 0) {
                           return false;
                        }
                     }

                     this.mDy = 0.0F;
                     this.mDx = 0.0F;
                     this.mActivePointerId = MotionEventCompat.getPointerId(var2, 0);
                     this.select(var8, 1);
                     return true;
                  }
               }
            }
         }
      } else {
         return false;
      }
   }

   private int checkVerticalSwipe(RecyclerView$ViewHolder var1, int var2) {
      if((var2 & 3) != 0) {
         byte var5;
         if(this.mDy > 0.0F) {
            var5 = 2;
         } else {
            var5 = 1;
         }

         float var3;
         float var4;
         if(this.mVelocityTracker != null && this.mActivePointerId > -1) {
            this.mVelocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
            var3 = VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId);
            var4 = VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId);
            byte var6;
            if(var4 > 0.0F) {
               var6 = 2;
            } else {
               var6 = 1;
            }

            var4 = Math.abs(var4);
            if((var6 & var2) != 0 && var6 == var5 && var4 >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && var4 > Math.abs(var3)) {
               return var6;
            }
         }

         var3 = (float)this.mRecyclerView.getHeight();
         var4 = this.mCallback.getSwipeThreshold(var1);
         if((var2 & var5) != 0 && Math.abs(this.mDy) > var3 * var4) {
            return var5;
         }
      }

      return 0;
   }

   private void destroyCallbacks() {
      this.mRecyclerView.removeItemDecoration(this);
      this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
      this.mRecyclerView.removeOnChildAttachStateChangeListener(this);

      for(int var1 = this.mRecoverAnimations.size() - 1; var1 >= 0; --var1) {
         ItemTouchHelper$RecoverAnimation var2 = (ItemTouchHelper$RecoverAnimation)this.mRecoverAnimations.get(0);
         this.mCallback.clearView(this.mRecyclerView, var2.mViewHolder);
      }

      this.mRecoverAnimations.clear();
      this.mOverdrawChild = null;
      this.mOverdrawChildPosition = -1;
      this.releaseVelocityTracker();
   }

   private int endRecoverAnimation(RecyclerView$ViewHolder var1, boolean var2) {
      for(int var3 = this.mRecoverAnimations.size() - 1; var3 >= 0; --var3) {
         ItemTouchHelper$RecoverAnimation var4 = (ItemTouchHelper$RecoverAnimation)this.mRecoverAnimations.get(var3);
         if(var4.mViewHolder == var1) {
            var4.mOverridden |= var2;
            if(!ItemTouchHelper$RecoverAnimation.access$1900(var4)) {
               var4.cancel();
            }

            this.mRecoverAnimations.remove(var3);
            return ItemTouchHelper$RecoverAnimation.access$2000(var4);
         }
      }

      return 0;
   }

   private ItemTouchHelper$RecoverAnimation findAnimation(MotionEvent var1) {
      ItemTouchHelper$RecoverAnimation var5;
      if(this.mRecoverAnimations.isEmpty()) {
         var5 = null;
      } else {
         View var4 = this.findChildView(var1);
         int var2 = this.mRecoverAnimations.size() - 1;

         while(true) {
            if(var2 < 0) {
               return null;
            }

            ItemTouchHelper$RecoverAnimation var3 = (ItemTouchHelper$RecoverAnimation)this.mRecoverAnimations.get(var2);
            var5 = var3;
            if(var3.mViewHolder.itemView == var4) {
               break;
            }

            --var2;
         }
      }

      return var5;
   }

   private View findChildView(MotionEvent var1) {
      float var2 = var1.getX();
      float var3 = var1.getY();
      if(this.mSelected != null) {
         View var6 = this.mSelected.itemView;
         if(hitTest(var6, var2, var3, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy)) {
            return var6;
         }
      }

      for(int var4 = this.mRecoverAnimations.size() - 1; var4 >= 0; --var4) {
         ItemTouchHelper$RecoverAnimation var7 = (ItemTouchHelper$RecoverAnimation)this.mRecoverAnimations.get(var4);
         View var5 = var7.mViewHolder.itemView;
         if(hitTest(var5, var2, var3, var7.mX, var7.mY)) {
            return var5;
         }
      }

      return this.mRecyclerView.findChildViewUnder(var2, var3);
   }

   private List<RecyclerView$ViewHolder> findSwapTargets(RecyclerView$ViewHolder var1) {
      if(this.mSwapTargets == null) {
         this.mSwapTargets = new ArrayList();
         this.mDistances = new ArrayList();
      } else {
         this.mSwapTargets.clear();
         this.mDistances.clear();
      }

      int var2 = this.mCallback.getBoundingBoxMargin();
      int var5 = Math.round(this.mSelectedStartX + this.mDx) - var2;
      int var6 = Math.round(this.mSelectedStartY + this.mDy) - var2;
      int var7 = var1.itemView.getWidth() + var5 + var2 * 2;
      int var8 = var1.itemView.getHeight() + var6 + var2 * 2;
      int var9 = (var5 + var7) / 2;
      int var10 = (var6 + var8) / 2;
      RecyclerView$LayoutManager var14 = this.mRecyclerView.getLayoutManager();
      int var11 = var14.getChildCount();

      for(var2 = 0; var2 < var11; ++var2) {
         View var15 = var14.getChildAt(var2);
         if(var15 != var1.itemView && var15.getBottom() >= var6 && var15.getTop() <= var8 && var15.getRight() >= var5 && var15.getLeft() <= var7) {
            RecyclerView$ViewHolder var16 = this.mRecyclerView.getChildViewHolder(var15);
            if(this.mCallback.canDropOver(this.mRecyclerView, this.mSelected, var16)) {
               int var3 = Math.abs(var9 - (var15.getLeft() + var15.getRight()) / 2);
               int var4 = Math.abs(var10 - (var15.getTop() + var15.getBottom()) / 2);
               int var12 = var3 * var3 + var4 * var4;
               var4 = 0;
               int var13 = this.mSwapTargets.size();

               for(var3 = 0; var3 < var13 && var12 > ((Integer)this.mDistances.get(var3)).intValue(); ++var3) {
                  ++var4;
               }

               this.mSwapTargets.add(var4, var16);
               this.mDistances.add(var4, Integer.valueOf(var12));
            }
         }
      }

      return this.mSwapTargets;
   }

   private RecyclerView$ViewHolder findSwipedView(MotionEvent var1) {
      RecyclerView$LayoutManager var7 = this.mRecyclerView.getLayoutManager();
      if(this.mActivePointerId != -1) {
         int var6 = MotionEventCompat.findPointerIndex(var1, this.mActivePointerId);
         float var4 = MotionEventCompat.getX(var1, var6);
         float var5 = this.mInitialTouchX;
         float var2 = MotionEventCompat.getY(var1, var6);
         float var3 = this.mInitialTouchY;
         var4 = Math.abs(var4 - var5);
         var2 = Math.abs(var2 - var3);
         if((var4 >= (float)this.mSlop || var2 >= (float)this.mSlop) && (var4 <= var2 || !var7.canScrollHorizontally()) && (var2 <= var4 || !var7.canScrollVertically())) {
            View var8 = this.findChildView(var1);
            if(var8 != null) {
               return this.mRecyclerView.getChildViewHolder(var8);
            }
         }
      }

      return null;
   }

   private void getSelectedDxDy(float[] var1) {
      if((this.mSelectedFlags & 12) != 0) {
         var1[0] = this.mSelectedStartX + this.mDx - (float)this.mSelected.itemView.getLeft();
      } else {
         var1[0] = ViewCompat.getTranslationX(this.mSelected.itemView);
      }

      if((this.mSelectedFlags & 3) != 0) {
         var1[1] = this.mSelectedStartY + this.mDy - (float)this.mSelected.itemView.getTop();
      } else {
         var1[1] = ViewCompat.getTranslationY(this.mSelected.itemView);
      }
   }

   private boolean hasRunningRecoverAnim() {
      int var2 = this.mRecoverAnimations.size();

      for(int var1 = 0; var1 < var2; ++var1) {
         if(!ItemTouchHelper$RecoverAnimation.access$1900((ItemTouchHelper$RecoverAnimation)this.mRecoverAnimations.get(var1))) {
            return true;
         }
      }

      return false;
   }

   private static boolean hitTest(View var0, float var1, float var2, float var3, float var4) {
      return var1 >= var3 && var1 <= (float)var0.getWidth() + var3 && var2 >= var4 && var2 <= (float)var0.getHeight() + var4;
   }

   private void initGestureDetector() {
      if(this.mGestureDetector == null) {
         this.mGestureDetector = new GestureDetectorCompat(this.mRecyclerView.getContext(), new ItemTouchHelper$ItemTouchHelperGestureListener(this, (ItemTouchHelper$1)null));
      }
   }

   private void moveIfNecessary(RecyclerView$ViewHolder var1) {
      if(!this.mRecyclerView.isLayoutRequested() && this.mActionState == 2) {
         float var2 = this.mCallback.getMoveThreshold(var1);
         int var3 = (int)(this.mSelectedStartX + this.mDx);
         int var4 = (int)(this.mSelectedStartY + this.mDy);
         if((float)Math.abs(var4 - var1.itemView.getTop()) >= (float)var1.itemView.getHeight() * var2 || (float)Math.abs(var3 - var1.itemView.getLeft()) >= (float)var1.itemView.getWidth() * var2) {
            List var7 = this.findSwapTargets(var1);
            if(var7.size() != 0) {
               RecyclerView$ViewHolder var8 = this.mCallback.chooseDropTarget(var1, var7, var3, var4);
               if(var8 == null) {
                  this.mSwapTargets.clear();
                  this.mDistances.clear();
                  return;
               }

               int var5 = var8.getAdapterPosition();
               int var6 = var1.getAdapterPosition();
               if(this.mCallback.onMove(this.mRecyclerView, var1, var8)) {
                  this.mCallback.onMoved(this.mRecyclerView, var1, var6, var8, var5, var3, var4);
                  return;
               }
            }
         }
      }

   }

   private void obtainVelocityTracker() {
      if(this.mVelocityTracker != null) {
         this.mVelocityTracker.recycle();
      }

      this.mVelocityTracker = VelocityTracker.obtain();
   }

   private void postDispatchSwipe(ItemTouchHelper$RecoverAnimation var1, int var2) {
      this.mRecyclerView.post(new ItemTouchHelper$4(this, var1, var2));
   }

   private void releaseVelocityTracker() {
      if(this.mVelocityTracker != null) {
         this.mVelocityTracker.recycle();
         this.mVelocityTracker = null;
      }

   }

   private void removeChildDrawingOrderCallbackIfNecessary(View var1) {
      if(var1 == this.mOverdrawChild) {
         this.mOverdrawChild = null;
         if(this.mChildDrawingOrderCallback != null) {
            this.mRecyclerView.setChildDrawingOrderCallback((RecyclerView$ChildDrawingOrderCallback)null);
         }
      }

   }

   private boolean scrollIfNecessary() {
      if(this.mSelected == null) {
         this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
         return false;
      } else {
         long var7 = System.currentTimeMillis();
         long var5;
         if(this.mDragScrollStartTimeInMs == Long.MIN_VALUE) {
            var5 = 0L;
         } else {
            var5 = var7 - this.mDragScrollStartTimeInMs;
         }

         RecyclerView$LayoutManager var9 = this.mRecyclerView.getLayoutManager();
         if(this.mTmpRect == null) {
            this.mTmpRect = new Rect();
         }

         byte var2 = 0;
         byte var3 = 0;
         var9.calculateItemDecorationsForChild(this.mSelected.itemView, this.mTmpRect);
         int var1 = var2;
         int var4;
         if(var9.canScrollHorizontally()) {
            var4 = (int)(this.mSelectedStartX + this.mDx);
            var1 = var4 - this.mTmpRect.left - this.mRecyclerView.getPaddingLeft();
            if(this.mDx >= 0.0F || var1 >= 0) {
               var1 = var2;
               if(this.mDx > 0.0F) {
                  var4 = this.mSelected.itemView.getWidth() + var4 + this.mTmpRect.right - (this.mRecyclerView.getWidth() - this.mRecyclerView.getPaddingRight());
                  var1 = var2;
                  if(var4 > 0) {
                     var1 = var4;
                  }
               }
            }
         }

         int var10 = var3;
         if(var9.canScrollVertically()) {
            var4 = (int)(this.mSelectedStartY + this.mDy);
            var10 = var4 - this.mTmpRect.top - this.mRecyclerView.getPaddingTop();
            if(this.mDy >= 0.0F || var10 >= 0) {
               var10 = var3;
               if(this.mDy > 0.0F) {
                  var4 = this.mSelected.itemView.getHeight() + var4 + this.mTmpRect.bottom - (this.mRecyclerView.getHeight() - this.mRecyclerView.getPaddingBottom());
                  var10 = var3;
                  if(var4 > 0) {
                     var10 = var4;
                  }
               }
            }
         }

         int var11 = var1;
         if(var1 != 0) {
            var11 = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getWidth(), var1, this.mRecyclerView.getWidth(), var5);
         }

         var1 = var10;
         if(var10 != 0) {
            var1 = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getHeight(), var10, this.mRecyclerView.getHeight(), var5);
         }

         if(var11 == 0 && var1 == 0) {
            this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
            return false;
         } else {
            if(this.mDragScrollStartTimeInMs == Long.MIN_VALUE) {
               this.mDragScrollStartTimeInMs = var7;
            }

            this.mRecyclerView.scrollBy(var11, var1);
            return true;
         }
      }
   }

   private void select(RecyclerView$ViewHolder var1, int var2) {
      if(var1 != this.mSelected || var2 != this.mActionState) {
         this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
         int var9 = this.mActionState;
         this.endRecoverAnimation(var1, true);
         this.mActionState = var2;
         if(var2 == 2) {
            this.mOverdrawChild = var1.itemView;
            this.addChildDrawingOrderCallback();
         }

         boolean var7 = false;
         boolean var8 = false;
         if(this.mSelected != null) {
            RecyclerView$ViewHolder var11 = this.mSelected;
            if(var11.itemView.getParent() != null) {
               int var14;
               if(var9 == 2) {
                  var14 = 0;
               } else {
                  var14 = this.swipeIfNecessary(var11);
               }

               this.releaseVelocityTracker();
               float var3;
               float var4;
               switch(var14) {
               case 1:
               case 2:
                  var3 = 0.0F;
                  var4 = Math.signum(this.mDy) * (float)this.mRecyclerView.getHeight();
                  break;
               case 4:
               case 8:
               case 16:
               case 32:
                  var4 = 0.0F;
                  var3 = Math.signum(this.mDx) * (float)this.mRecyclerView.getWidth();
                  break;
               default:
                  var3 = 0.0F;
                  var4 = 0.0F;
               }

               byte var13;
               if(var9 == 2) {
                  var13 = 8;
               } else if(var14 > 0) {
                  var13 = 2;
               } else {
                  var13 = 4;
               }

               this.getSelectedDxDy(this.mTmpPosition);
               float var5 = this.mTmpPosition[0];
               float var6 = this.mTmpPosition[1];
               ItemTouchHelper$3 var15 = new ItemTouchHelper$3(this, var11, var13, var9, var5, var6, var3, var4, var14, var11);
               var15.setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, var13, var3 - var5, var4 - var6));
               this.mRecoverAnimations.add(var15);
               var15.start();
               var7 = true;
            } else {
               this.removeChildDrawingOrderCallbackIfNecessary(var11.itemView);
               this.mCallback.clearView(this.mRecyclerView, var11);
               var7 = var8;
            }

            this.mSelected = null;
         }

         if(var1 != null) {
            this.mSelectedFlags = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, var1) & (1 << var2 * 8 + 8) - 1) >> this.mActionState * 8;
            this.mSelectedStartX = (float)var1.itemView.getLeft();
            this.mSelectedStartY = (float)var1.itemView.getTop();
            this.mSelected = var1;
            if(var2 == 2) {
               this.mSelected.itemView.performHapticFeedback(0);
            }
         }

         ViewParent var12 = this.mRecyclerView.getParent();
         if(var12 != null) {
            boolean var10;
            if(this.mSelected != null) {
               var10 = true;
            } else {
               var10 = false;
            }

            var12.requestDisallowInterceptTouchEvent(var10);
         }

         if(!var7) {
            this.mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
         }

         this.mCallback.onSelectedChanged(this.mSelected, this.mActionState);
         this.mRecyclerView.invalidate();
      }
   }

   private void setupCallbacks() {
      this.mSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
      this.mRecyclerView.addItemDecoration(this);
      this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
      this.mRecyclerView.addOnChildAttachStateChangeListener(this);
      this.initGestureDetector();
   }

   private int swipeIfNecessary(RecyclerView$ViewHolder var1) {
      int var2;
      if(this.mActionState == 2) {
         var2 = 0;
         return var2;
      } else {
         var2 = this.mCallback.getMovementFlags(this.mRecyclerView, var1);
         int var4 = (this.mCallback.convertToAbsoluteDirection(var2, ViewCompat.getLayoutDirection(this.mRecyclerView)) & '\uff00') >> 8;
         if(var4 == 0) {
            return 0;
         } else {
            int var5 = (var2 & '\uff00') >> 8;
            int var3;
            if(Math.abs(this.mDx) > Math.abs(this.mDy)) {
               var3 = this.checkHorizontalSwipe(var1, var4);
               if(var3 > 0) {
                  var2 = var3;
                  if((var5 & var3) == 0) {
                     return ItemTouchHelper$Callback.convertToRelativeDirection(var3, ViewCompat.getLayoutDirection(this.mRecyclerView));
                  }

                  return var2;
               }

               var3 = this.checkVerticalSwipe(var1, var4);
               var2 = var3;
               if(var3 > 0) {
                  return var2;
               }
            } else {
               var3 = this.checkVerticalSwipe(var1, var4);
               var2 = var3;
               if(var3 > 0) {
                  return var2;
               }

               var3 = this.checkHorizontalSwipe(var1, var4);
               if(var3 > 0) {
                  var2 = var3;
                  if((var5 & var3) == 0) {
                     return ItemTouchHelper$Callback.convertToRelativeDirection(var3, ViewCompat.getLayoutDirection(this.mRecyclerView));
                  }

                  return var2;
               }
            }

            return 0;
         }
      }
   }

   private void updateDxDy(MotionEvent var1, int var2, int var3) {
      float var4 = MotionEventCompat.getX(var1, var3);
      float var5 = MotionEventCompat.getY(var1, var3);
      this.mDx = var4 - this.mInitialTouchX;
      this.mDy = var5 - this.mInitialTouchY;
      if((var2 & 4) == 0) {
         this.mDx = Math.max(0.0F, this.mDx);
      }

      if((var2 & 8) == 0) {
         this.mDx = Math.min(0.0F, this.mDx);
      }

      if((var2 & 1) == 0) {
         this.mDy = Math.max(0.0F, this.mDy);
      }

      if((var2 & 2) == 0) {
         this.mDy = Math.min(0.0F, this.mDy);
      }

   }

   public void attachToRecyclerView(@Nullable RecyclerView var1) {
      if(this.mRecyclerView != var1) {
         if(this.mRecyclerView != null) {
            this.destroyCallbacks();
         }

         this.mRecyclerView = var1;
         if(this.mRecyclerView != null) {
            Resources var2 = var1.getResources();
            this.mSwipeEscapeVelocity = var2.getDimension(R$dimen.item_touch_helper_swipe_escape_velocity);
            this.mMaxSwipeVelocity = var2.getDimension(R$dimen.item_touch_helper_swipe_escape_max_velocity);
            this.setupCallbacks();
            return;
         }
      }

   }

   public void getItemOffsets(Rect var1, View var2, RecyclerView var3, RecyclerView$State var4) {
      var1.setEmpty();
   }

   public void onChildViewAttachedToWindow(View var1) {
   }

   public void onChildViewDetachedFromWindow(View var1) {
      this.removeChildDrawingOrderCallbackIfNecessary(var1);
      RecyclerView$ViewHolder var2 = this.mRecyclerView.getChildViewHolder(var1);
      if(var2 != null) {
         if(this.mSelected != null && var2 == this.mSelected) {
            this.select((RecyclerView$ViewHolder)null, 0);
            return;
         }

         this.endRecoverAnimation(var2, false);
         if(this.mPendingCleanup.remove(var2.itemView)) {
            this.mCallback.clearView(this.mRecyclerView, var2);
            return;
         }
      }

   }

   public void onDraw(Canvas var1, RecyclerView var2, RecyclerView$State var3) {
      this.mOverdrawChildPosition = -1;
      float var4 = 0.0F;
      float var5 = 0.0F;
      if(this.mSelected != null) {
         this.getSelectedDxDy(this.mTmpPosition);
         var4 = this.mTmpPosition[0];
         var5 = this.mTmpPosition[1];
      }

      ItemTouchHelper$Callback.access$1400(this.mCallback, var1, var2, this.mSelected, this.mRecoverAnimations, this.mActionState, var4, var5);
   }

   public void onDrawOver(Canvas var1, RecyclerView var2, RecyclerView$State var3) {
      float var4 = 0.0F;
      float var5 = 0.0F;
      if(this.mSelected != null) {
         this.getSelectedDxDy(this.mTmpPosition);
         var4 = this.mTmpPosition[0];
         var5 = this.mTmpPosition[1];
      }

      ItemTouchHelper$Callback.access$1300(this.mCallback, var1, var2, this.mSelected, this.mRecoverAnimations, this.mActionState, var4, var5);
   }

   public void startDrag(RecyclerView$ViewHolder var1) {
      if(!ItemTouchHelper$Callback.access$2100(this.mCallback, this.mRecyclerView, var1)) {
         Log.e("ItemTouchHelper", "Start drag has been called but swiping is not enabled");
      } else if(var1.itemView.getParent() != this.mRecyclerView) {
         Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
      } else {
         this.obtainVelocityTracker();
         this.mDy = 0.0F;
         this.mDx = 0.0F;
         this.select(var1, 2);
      }
   }

   public void startSwipe(RecyclerView$ViewHolder var1) {
      if(!ItemTouchHelper$Callback.access$2200(this.mCallback, this.mRecyclerView, var1)) {
         Log.e("ItemTouchHelper", "Start swipe has been called but dragging is not enabled");
      } else if(var1.itemView.getParent() != this.mRecyclerView) {
         Log.e("ItemTouchHelper", "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
      } else {
         this.obtainVelocityTracker();
         this.mDy = 0.0F;
         this.mDx = 0.0F;
         this.select(var1, 1);
      }
   }
}
