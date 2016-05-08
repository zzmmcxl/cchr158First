package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcelable;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.widget.LinearLayoutManager$1;
import android.support.v7.widget.LinearLayoutManager$AnchorInfo;
import android.support.v7.widget.LinearLayoutManager$LayoutChunkResult;
import android.support.v7.widget.LinearLayoutManager$LayoutState;
import android.support.v7.widget.LinearLayoutManager$SavedState;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$LayoutManager;
import android.support.v7.widget.RecyclerView$LayoutManager$Properties;
import android.support.v7.widget.RecyclerView$LayoutParams;
import android.support.v7.widget.RecyclerView$Recycler;
import android.support.v7.widget.RecyclerView$State;
import android.support.v7.widget.RecyclerView$ViewHolder;
import android.support.v7.widget.ScrollbarHelper;
import android.support.v7.widget.helper.ItemTouchHelper$ViewDropHandler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends RecyclerView$LayoutManager implements ItemTouchHelper$ViewDropHandler {
   private static final boolean DEBUG = false;
   public static final int HORIZONTAL = 0;
   public static final int INVALID_OFFSET = Integer.MIN_VALUE;
   private static final float MAX_SCROLL_FACTOR = 0.33333334F;
   private static final String TAG = "LinearLayoutManager";
   public static final int VERTICAL = 1;
   final LinearLayoutManager$AnchorInfo mAnchorInfo;
   private boolean mLastStackFromEnd;
   private LinearLayoutManager$LayoutState mLayoutState;
   int mOrientation;
   OrientationHelper mOrientationHelper;
   LinearLayoutManager$SavedState mPendingSavedState;
   int mPendingScrollPosition;
   int mPendingScrollPositionOffset;
   private boolean mRecycleChildrenOnDetach;
   private boolean mReverseLayout;
   boolean mShouldReverseLayout;
   private boolean mSmoothScrollbarEnabled;
   private boolean mStackFromEnd;

   public LinearLayoutManager(Context var1) {
      this(var1, 1, false);
   }

   public LinearLayoutManager(Context var1, int var2, boolean var3) {
      this.mReverseLayout = false;
      this.mShouldReverseLayout = false;
      this.mStackFromEnd = false;
      this.mSmoothScrollbarEnabled = true;
      this.mPendingScrollPosition = -1;
      this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
      this.mPendingSavedState = null;
      this.mAnchorInfo = new LinearLayoutManager$AnchorInfo(this);
      this.setOrientation(var2);
      this.setReverseLayout(var3);
      this.setAutoMeasureEnabled(true);
   }

   public LinearLayoutManager(Context var1, AttributeSet var2, int var3, int var4) {
      this.mReverseLayout = false;
      this.mShouldReverseLayout = false;
      this.mStackFromEnd = false;
      this.mSmoothScrollbarEnabled = true;
      this.mPendingScrollPosition = -1;
      this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
      this.mPendingSavedState = null;
      this.mAnchorInfo = new LinearLayoutManager$AnchorInfo(this);
      RecyclerView$LayoutManager$Properties var5 = getProperties(var1, var2, var3, var4);
      this.setOrientation(var5.orientation);
      this.setReverseLayout(var5.reverseLayout);
      this.setStackFromEnd(var5.stackFromEnd);
      this.setAutoMeasureEnabled(true);
   }

   private int computeScrollExtent(RecyclerView$State var1) {
      boolean var3 = false;
      if(this.getChildCount() == 0) {
         return 0;
      } else {
         this.ensureLayoutState();
         OrientationHelper var4 = this.mOrientationHelper;
         boolean var2;
         if(!this.mSmoothScrollbarEnabled) {
            var2 = true;
         } else {
            var2 = false;
         }

         View var5 = this.findFirstVisibleChildClosestToStart(var2, true);
         var2 = var3;
         if(!this.mSmoothScrollbarEnabled) {
            var2 = true;
         }

         return ScrollbarHelper.computeScrollExtent(var1, var4, var5, this.findFirstVisibleChildClosestToEnd(var2, true), this, this.mSmoothScrollbarEnabled);
      }
   }

   private int computeScrollOffset(RecyclerView$State var1) {
      boolean var3 = false;
      if(this.getChildCount() == 0) {
         return 0;
      } else {
         this.ensureLayoutState();
         OrientationHelper var4 = this.mOrientationHelper;
         boolean var2;
         if(!this.mSmoothScrollbarEnabled) {
            var2 = true;
         } else {
            var2 = false;
         }

         View var5 = this.findFirstVisibleChildClosestToStart(var2, true);
         var2 = var3;
         if(!this.mSmoothScrollbarEnabled) {
            var2 = true;
         }

         return ScrollbarHelper.computeScrollOffset(var1, var4, var5, this.findFirstVisibleChildClosestToEnd(var2, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
      }
   }

   private int computeScrollRange(RecyclerView$State var1) {
      boolean var3 = false;
      if(this.getChildCount() == 0) {
         return 0;
      } else {
         this.ensureLayoutState();
         OrientationHelper var4 = this.mOrientationHelper;
         boolean var2;
         if(!this.mSmoothScrollbarEnabled) {
            var2 = true;
         } else {
            var2 = false;
         }

         View var5 = this.findFirstVisibleChildClosestToStart(var2, true);
         var2 = var3;
         if(!this.mSmoothScrollbarEnabled) {
            var2 = true;
         }

         return ScrollbarHelper.computeScrollRange(var1, var4, var5, this.findFirstVisibleChildClosestToEnd(var2, true), this, this.mSmoothScrollbarEnabled);
      }
   }

   private View findFirstReferenceChild(RecyclerView$Recycler var1, RecyclerView$State var2) {
      return this.findReferenceChild(var1, var2, 0, this.getChildCount(), var2.getItemCount());
   }

   private View findFirstVisibleChildClosestToEnd(boolean var1, boolean var2) {
      return this.mShouldReverseLayout?this.findOneVisibleChild(0, this.getChildCount(), var1, var2):this.findOneVisibleChild(this.getChildCount() - 1, -1, var1, var2);
   }

   private View findFirstVisibleChildClosestToStart(boolean var1, boolean var2) {
      return this.mShouldReverseLayout?this.findOneVisibleChild(this.getChildCount() - 1, -1, var1, var2):this.findOneVisibleChild(0, this.getChildCount(), var1, var2);
   }

   private View findLastReferenceChild(RecyclerView$Recycler var1, RecyclerView$State var2) {
      return this.findReferenceChild(var1, var2, this.getChildCount() - 1, -1, var2.getItemCount());
   }

   private View findReferenceChildClosestToEnd(RecyclerView$Recycler var1, RecyclerView$State var2) {
      return this.mShouldReverseLayout?this.findFirstReferenceChild(var1, var2):this.findLastReferenceChild(var1, var2);
   }

   private View findReferenceChildClosestToStart(RecyclerView$Recycler var1, RecyclerView$State var2) {
      return this.mShouldReverseLayout?this.findLastReferenceChild(var1, var2):this.findFirstReferenceChild(var1, var2);
   }

   private int fixLayoutEndGap(int var1, RecyclerView$Recycler var2, RecyclerView$State var3, boolean var4) {
      int var5 = this.mOrientationHelper.getEndAfterPadding() - var1;
      if(var5 > 0) {
         var5 = -this.scrollBy(-var5, var2, var3);
         if(var4) {
            var1 = this.mOrientationHelper.getEndAfterPadding() - (var1 + var5);
            if(var1 > 0) {
               this.mOrientationHelper.offsetChildren(var1);
               return var1 + var5;
            }
         }

         return var5;
      } else {
         return 0;
      }
   }

   private int fixLayoutStartGap(int var1, RecyclerView$Recycler var2, RecyclerView$State var3, boolean var4) {
      int var5 = var1 - this.mOrientationHelper.getStartAfterPadding();
      if(var5 > 0) {
         var5 = -this.scrollBy(var5, var2, var3);
         if(var4) {
            var1 = var1 + var5 - this.mOrientationHelper.getStartAfterPadding();
            if(var1 > 0) {
               this.mOrientationHelper.offsetChildren(-var1);
               return var5 - var1;
            }
         }

         return var5;
      } else {
         return 0;
      }
   }

   private View getChildClosestToEnd() {
      int var1;
      if(this.mShouldReverseLayout) {
         var1 = 0;
      } else {
         var1 = this.getChildCount() - 1;
      }

      return this.getChildAt(var1);
   }

   private View getChildClosestToStart() {
      int var1;
      if(this.mShouldReverseLayout) {
         var1 = this.getChildCount() - 1;
      } else {
         var1 = 0;
      }

      return this.getChildAt(var1);
   }

   private void layoutForPredictiveAnimations(RecyclerView$Recycler var1, RecyclerView$State var2, int var3, int var4) {
      if(var2.willRunPredictiveAnimations() && this.getChildCount() != 0 && !var2.isPreLayout() && this.supportsPredictiveItemAnimations()) {
         int var6 = 0;
         int var7 = 0;
         List var12 = var1.getScrapList();
         int var9 = var12.size();
         int var10 = this.getPosition(this.getChildAt(0));

         for(int var5 = 0; var5 < var9; ++var5) {
            RecyclerView$ViewHolder var13 = (RecyclerView$ViewHolder)var12.get(var5);
            if(!var13.isRemoved()) {
               boolean var11;
               if(var13.getLayoutPosition() < var10) {
                  var11 = true;
               } else {
                  var11 = false;
               }

               byte var8;
               if(var11 != this.mShouldReverseLayout) {
                  var8 = -1;
               } else {
                  var8 = 1;
               }

               if(var8 == -1) {
                  var6 += this.mOrientationHelper.getDecoratedMeasurement(var13.itemView);
               } else {
                  var7 += this.mOrientationHelper.getDecoratedMeasurement(var13.itemView);
               }
            }
         }

         this.mLayoutState.mScrapList = var12;
         if(var6 > 0) {
            this.updateLayoutStateToFillStart(this.getPosition(this.getChildClosestToStart()), var3);
            this.mLayoutState.mExtra = var6;
            this.mLayoutState.mAvailable = 0;
            this.mLayoutState.assignPositionFromScrapList();
            this.fill(var1, this.mLayoutState, var2, false);
         }

         if(var7 > 0) {
            this.updateLayoutStateToFillEnd(this.getPosition(this.getChildClosestToEnd()), var4);
            this.mLayoutState.mExtra = var7;
            this.mLayoutState.mAvailable = 0;
            this.mLayoutState.assignPositionFromScrapList();
            this.fill(var1, this.mLayoutState, var2, false);
         }

         this.mLayoutState.mScrapList = null;
      }
   }

   private void logChildren() {
      Log.d("LinearLayoutManager", "internal representation of views on the screen");

      for(int var1 = 0; var1 < this.getChildCount(); ++var1) {
         View var2 = this.getChildAt(var1);
         Log.d("LinearLayoutManager", "item " + this.getPosition(var2) + ", coord:" + this.mOrientationHelper.getDecoratedStart(var2));
      }

      Log.d("LinearLayoutManager", "==============");
   }

   private void recycleByLayoutState(RecyclerView$Recycler var1, LinearLayoutManager$LayoutState var2) {
      if(var2.mRecycle && !var2.mInfinite) {
         if(var2.mLayoutDirection == -1) {
            this.recycleViewsFromEnd(var1, var2.mScrollingOffset);
         } else {
            this.recycleViewsFromStart(var1, var2.mScrollingOffset);
         }
      }
   }

   private void recycleChildren(RecyclerView$Recycler var1, int var2, int var3) {
      if(var2 != var3) {
         if(var3 > var2) {
            --var3;

            while(var3 >= var2) {
               this.removeAndRecycleViewAt(var3, var1);
               --var3;
            }
         } else {
            while(var2 > var3) {
               this.removeAndRecycleViewAt(var2, var1);
               --var2;
            }
         }
      }

   }

   private void recycleViewsFromEnd(RecyclerView$Recycler var1, int var2) {
      int var3 = this.getChildCount();
      if(var2 >= 0) {
         int var4 = this.mOrientationHelper.getEnd() - var2;
         View var5;
         if(this.mShouldReverseLayout) {
            for(var2 = 0; var2 < var3; ++var2) {
               var5 = this.getChildAt(var2);
               if(this.mOrientationHelper.getDecoratedStart(var5) < var4) {
                  this.recycleChildren(var1, 0, var2);
                  return;
               }
            }
         } else {
            for(var2 = var3 - 1; var2 >= 0; --var2) {
               var5 = this.getChildAt(var2);
               if(this.mOrientationHelper.getDecoratedStart(var5) < var4) {
                  this.recycleChildren(var1, var3 - 1, var2);
                  return;
               }
            }
         }
      }

   }

   private void recycleViewsFromStart(RecyclerView$Recycler var1, int var2) {
      if(var2 >= 0) {
         int var4 = this.getChildCount();
         int var3;
         View var5;
         if(this.mShouldReverseLayout) {
            for(var3 = var4 - 1; var3 >= 0; --var3) {
               var5 = this.getChildAt(var3);
               if(this.mOrientationHelper.getDecoratedEnd(var5) > var2) {
                  this.recycleChildren(var1, var4 - 1, var3);
                  return;
               }
            }
         } else {
            for(var3 = 0; var3 < var4; ++var3) {
               var5 = this.getChildAt(var3);
               if(this.mOrientationHelper.getDecoratedEnd(var5) > var2) {
                  this.recycleChildren(var1, 0, var3);
                  return;
               }
            }
         }
      }

   }

   private void resolveShouldLayoutReverse() {
      boolean var1 = true;
      if(this.mOrientation != 1 && this.isLayoutRTL()) {
         if(this.mReverseLayout) {
            var1 = false;
         }

         this.mShouldReverseLayout = var1;
      } else {
         this.mShouldReverseLayout = this.mReverseLayout;
      }
   }

   private boolean updateAnchorFromChildren(RecyclerView$Recycler var1, RecyclerView$State var2, LinearLayoutManager$AnchorInfo var3) {
      if(this.getChildCount() != 0) {
         View var5 = this.getFocusedChild();
         if(var5 != null && LinearLayoutManager$AnchorInfo.access$000(var3, var5, var2)) {
            var3.assignFromViewAndKeepVisibleRect(var5);
            return true;
         }

         if(this.mLastStackFromEnd == this.mStackFromEnd) {
            View var6;
            if(var3.mLayoutFromEnd) {
               var6 = this.findReferenceChildClosestToEnd(var1, var2);
            } else {
               var6 = this.findReferenceChildClosestToStart(var1, var2);
            }

            if(var6 != null) {
               var3.assignFromView(var6);
               if(!var2.isPreLayout() && this.supportsPredictiveItemAnimations()) {
                  boolean var4;
                  if(this.mOrientationHelper.getDecoratedStart(var6) < this.mOrientationHelper.getEndAfterPadding() && this.mOrientationHelper.getDecoratedEnd(var6) >= this.mOrientationHelper.getStartAfterPadding()) {
                     var4 = false;
                  } else {
                     var4 = true;
                  }

                  if(var4) {
                     int var7;
                     if(var3.mLayoutFromEnd) {
                        var7 = this.mOrientationHelper.getEndAfterPadding();
                     } else {
                        var7 = this.mOrientationHelper.getStartAfterPadding();
                     }

                     var3.mCoordinate = var7;
                  }
               }

               return true;
            }
         }
      }

      return false;
   }

   private boolean updateAnchorFromPendingData(RecyclerView$State var1, LinearLayoutManager$AnchorInfo var2) {
      boolean var5 = false;
      if(!var1.isPreLayout() && this.mPendingScrollPosition != -1) {
         if(this.mPendingScrollPosition >= 0 && this.mPendingScrollPosition < var1.getItemCount()) {
            var2.mPosition = this.mPendingScrollPosition;
            if(this.mPendingSavedState != null && this.mPendingSavedState.hasValidAnchor()) {
               var2.mLayoutFromEnd = this.mPendingSavedState.mAnchorLayoutFromEnd;
               if(var2.mLayoutFromEnd) {
                  var2.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset;
                  return true;
               } else {
                  var2.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset;
                  return true;
               }
            } else if(this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
               View var6 = this.findViewByPosition(this.mPendingScrollPosition);
               int var3;
               if(var6 != null) {
                  if(this.mOrientationHelper.getDecoratedMeasurement(var6) > this.mOrientationHelper.getTotalSpace()) {
                     var2.assignCoordinateFromPadding();
                     return true;
                  } else if(this.mOrientationHelper.getDecoratedStart(var6) - this.mOrientationHelper.getStartAfterPadding() < 0) {
                     var2.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
                     var2.mLayoutFromEnd = false;
                     return true;
                  } else if(this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(var6) < 0) {
                     var2.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
                     var2.mLayoutFromEnd = true;
                     return true;
                  } else {
                     if(var2.mLayoutFromEnd) {
                        var3 = this.mOrientationHelper.getDecoratedEnd(var6) + this.mOrientationHelper.getTotalSpaceChange();
                     } else {
                        var3 = this.mOrientationHelper.getDecoratedStart(var6);
                     }

                     var2.mCoordinate = var3;
                     return true;
                  }
               } else {
                  if(this.getChildCount() > 0) {
                     var3 = this.getPosition(this.getChildAt(0));
                     boolean var4;
                     if(this.mPendingScrollPosition < var3) {
                        var4 = true;
                     } else {
                        var4 = false;
                     }

                     if(var4 == this.mShouldReverseLayout) {
                        var5 = true;
                     }

                     var2.mLayoutFromEnd = var5;
                  }

                  var2.assignCoordinateFromPadding();
                  return true;
               }
            } else {
               var2.mLayoutFromEnd = this.mShouldReverseLayout;
               if(this.mShouldReverseLayout) {
                  var2.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset;
                  return true;
               } else {
                  var2.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                  return true;
               }
            }
         } else {
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            return false;
         }
      } else {
         return false;
      }
   }

   private void updateAnchorInfoForLayout(RecyclerView$Recycler var1, RecyclerView$State var2, LinearLayoutManager$AnchorInfo var3) {
      if(!this.updateAnchorFromPendingData(var2, var3) && !this.updateAnchorFromChildren(var1, var2, var3)) {
         var3.assignCoordinateFromPadding();
         int var4;
         if(this.mStackFromEnd) {
            var4 = var2.getItemCount() - 1;
         } else {
            var4 = 0;
         }

         var3.mPosition = var4;
      }
   }

   private void updateLayoutState(int var1, int var2, boolean var3, RecyclerView$State var4) {
      byte var6 = 1;
      byte var5 = 1;
      LinearLayoutManager$LayoutState var8 = this.mLayoutState;
      boolean var7;
      if(this.mOrientationHelper.getMode() == 0) {
         var7 = true;
      } else {
         var7 = false;
      }

      var8.mInfinite = var7;
      this.mLayoutState.mExtra = this.getExtraLayoutSpace(var4);
      this.mLayoutState.mLayoutDirection = var1;
      byte var9;
      LinearLayoutManager$LayoutState var10;
      View var11;
      if(var1 == 1) {
         var10 = this.mLayoutState;
         var10.mExtra += this.mOrientationHelper.getEndPadding();
         var11 = this.getChildClosestToEnd();
         var8 = this.mLayoutState;
         var9 = var5;
         if(this.mShouldReverseLayout) {
            var9 = -1;
         }

         var8.mItemDirection = var9;
         this.mLayoutState.mCurrentPosition = this.getPosition(var11) + this.mLayoutState.mItemDirection;
         this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedEnd(var11);
         var1 = this.mOrientationHelper.getDecoratedEnd(var11) - this.mOrientationHelper.getEndAfterPadding();
      } else {
         var11 = this.getChildClosestToStart();
         var8 = this.mLayoutState;
         var8.mExtra += this.mOrientationHelper.getStartAfterPadding();
         var8 = this.mLayoutState;
         if(this.mShouldReverseLayout) {
            var9 = var6;
         } else {
            var9 = -1;
         }

         var8.mItemDirection = var9;
         this.mLayoutState.mCurrentPosition = this.getPosition(var11) + this.mLayoutState.mItemDirection;
         this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedStart(var11);
         var1 = -this.mOrientationHelper.getDecoratedStart(var11) + this.mOrientationHelper.getStartAfterPadding();
      }

      this.mLayoutState.mAvailable = var2;
      if(var3) {
         var10 = this.mLayoutState;
         var10.mAvailable -= var1;
      }

      this.mLayoutState.mScrollingOffset = var1;
   }

   private void updateLayoutStateToFillEnd(int var1, int var2) {
      this.mLayoutState.mAvailable = this.mOrientationHelper.getEndAfterPadding() - var2;
      LinearLayoutManager$LayoutState var4 = this.mLayoutState;
      byte var3;
      if(this.mShouldReverseLayout) {
         var3 = -1;
      } else {
         var3 = 1;
      }

      var4.mItemDirection = var3;
      this.mLayoutState.mCurrentPosition = var1;
      this.mLayoutState.mLayoutDirection = 1;
      this.mLayoutState.mOffset = var2;
      this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
   }

   private void updateLayoutStateToFillEnd(LinearLayoutManager$AnchorInfo var1) {
      this.updateLayoutStateToFillEnd(var1.mPosition, var1.mCoordinate);
   }

   private void updateLayoutStateToFillStart(int var1, int var2) {
      this.mLayoutState.mAvailable = var2 - this.mOrientationHelper.getStartAfterPadding();
      this.mLayoutState.mCurrentPosition = var1;
      LinearLayoutManager$LayoutState var3 = this.mLayoutState;
      byte var4;
      if(this.mShouldReverseLayout) {
         var4 = 1;
      } else {
         var4 = -1;
      }

      var3.mItemDirection = var4;
      this.mLayoutState.mLayoutDirection = -1;
      this.mLayoutState.mOffset = var2;
      this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
   }

   private void updateLayoutStateToFillStart(LinearLayoutManager$AnchorInfo var1) {
      this.updateLayoutStateToFillStart(var1.mPosition, var1.mCoordinate);
   }

   public void assertNotInLayoutOrScroll(String var1) {
      if(this.mPendingSavedState == null) {
         super.assertNotInLayoutOrScroll(var1);
      }

   }

   public boolean canScrollHorizontally() {
      return this.mOrientation == 0;
   }

   public boolean canScrollVertically() {
      return this.mOrientation == 1;
   }

   public int computeHorizontalScrollExtent(RecyclerView$State var1) {
      return this.computeScrollExtent(var1);
   }

   public int computeHorizontalScrollOffset(RecyclerView$State var1) {
      return this.computeScrollOffset(var1);
   }

   public int computeHorizontalScrollRange(RecyclerView$State var1) {
      return this.computeScrollRange(var1);
   }

   public PointF computeScrollVectorForPosition(int var1) {
      boolean var2 = false;
      if(this.getChildCount() == 0) {
         return null;
      } else {
         if(var1 < this.getPosition(this.getChildAt(0))) {
            var2 = true;
         }

         byte var3;
         if(var2 != this.mShouldReverseLayout) {
            var3 = -1;
         } else {
            var3 = 1;
         }

         return this.mOrientation == 0?new PointF((float)var3, 0.0F):new PointF(0.0F, (float)var3);
      }
   }

   public int computeVerticalScrollExtent(RecyclerView$State var1) {
      return this.computeScrollExtent(var1);
   }

   public int computeVerticalScrollOffset(RecyclerView$State var1) {
      return this.computeScrollOffset(var1);
   }

   public int computeVerticalScrollRange(RecyclerView$State var1) {
      return this.computeScrollRange(var1);
   }

   int convertFocusDirectionToLayoutDirection(int var1) {
      byte var3 = -1;
      byte var4 = 1;
      int var5 = Integer.MIN_VALUE;
      int var2 = var3;
      switch(var1) {
      case 1:
         break;
      case 2:
         return 1;
      case 17:
         var2 = var3;
         if(this.mOrientation != 0) {
            return Integer.MIN_VALUE;
         }
         break;
      case 33:
         var2 = var3;
         if(this.mOrientation != 1) {
            return Integer.MIN_VALUE;
         }
         break;
      case 66:
         if(this.mOrientation == 0) {
            var1 = var4;
         } else {
            var1 = Integer.MIN_VALUE;
         }

         return var1;
      case 130:
         var1 = var5;
         if(this.mOrientation == 1) {
            var1 = 1;
         }

         return var1;
      default:
         var2 = Integer.MIN_VALUE;
      }

      return var2;
   }

   LinearLayoutManager$LayoutState createLayoutState() {
      return new LinearLayoutManager$LayoutState();
   }

   void ensureLayoutState() {
      if(this.mLayoutState == null) {
         this.mLayoutState = this.createLayoutState();
      }

      if(this.mOrientationHelper == null) {
         this.mOrientationHelper = OrientationHelper.createOrientationHelper(this, this.mOrientation);
      }

   }

   int fill(RecyclerView$Recycler var1, LinearLayoutManager$LayoutState var2, RecyclerView$State var3, boolean var4) {
      int var7 = var2.mAvailable;
      if(var2.mScrollingOffset != Integer.MIN_VALUE) {
         if(var2.mAvailable < 0) {
            var2.mScrollingOffset += var2.mAvailable;
         }

         this.recycleByLayoutState(var1, var2);
      }

      int var5 = var2.mAvailable + var2.mExtra;
      LinearLayoutManager$LayoutChunkResult var8 = new LinearLayoutManager$LayoutChunkResult();

      while((var2.mInfinite || var5 > 0) && var2.hasMore(var3)) {
         var8.resetInternal();
         this.layoutChunk(var1, var3, var2, var8);
         if(var8.mFinished) {
            break;
         }

         int var6;
         label44: {
            var2.mOffset += var8.mConsumed * var2.mLayoutDirection;
            if(var8.mIgnoreConsumed && this.mLayoutState.mScrapList == null) {
               var6 = var5;
               if(var3.isPreLayout()) {
                  break label44;
               }
            }

            var2.mAvailable -= var8.mConsumed;
            var6 = var5 - var8.mConsumed;
         }

         if(var2.mScrollingOffset != Integer.MIN_VALUE) {
            var2.mScrollingOffset += var8.mConsumed;
            if(var2.mAvailable < 0) {
               var2.mScrollingOffset += var2.mAvailable;
            }

            this.recycleByLayoutState(var1, var2);
         }

         var5 = var6;
         if(var4) {
            var5 = var6;
            if(var8.mFocusable) {
               break;
            }
         }
      }

      return var7 - var2.mAvailable;
   }

   public int findFirstCompletelyVisibleItemPosition() {
      View var1 = this.findOneVisibleChild(0, this.getChildCount(), true, false);
      return var1 == null?-1:this.getPosition(var1);
   }

   public int findFirstVisibleItemPosition() {
      View var1 = this.findOneVisibleChild(0, this.getChildCount(), false, true);
      return var1 == null?-1:this.getPosition(var1);
   }

   public int findLastCompletelyVisibleItemPosition() {
      View var1 = this.findOneVisibleChild(this.getChildCount() - 1, -1, true, false);
      return var1 == null?-1:this.getPosition(var1);
   }

   public int findLastVisibleItemPosition() {
      View var1 = this.findOneVisibleChild(this.getChildCount() - 1, -1, false, true);
      return var1 == null?-1:this.getPosition(var1);
   }

   View findOneVisibleChild(int var1, int var2, boolean var3, boolean var4) {
      this.ensureLayoutState();
      int var6 = this.mOrientationHelper.getStartAfterPadding();
      int var7 = this.mOrientationHelper.getEndAfterPadding();
      byte var5;
      if(var2 > var1) {
         var5 = 1;
      } else {
         var5 = -1;
      }

      View var10;
      View var11;
      for(var10 = null; var1 != var2; var10 = var11) {
         View var12 = this.getChildAt(var1);
         int var8 = this.mOrientationHelper.getDecoratedStart(var12);
         int var9 = this.mOrientationHelper.getDecoratedEnd(var12);
         var11 = var10;
         if(var8 < var7) {
            var11 = var10;
            if(var9 > var6) {
               if(!var3 || var8 >= var6 && var9 <= var7) {
                  return var12;
               }

               var11 = var10;
               if(var4) {
                  var11 = var10;
                  if(var10 == null) {
                     var11 = var12;
                  }
               }
            }
         }

         var1 += var5;
      }

      return var10;
   }

   View findReferenceChild(RecyclerView$Recycler var1, RecyclerView$State var2, int var3, int var4, int var5) {
      this.ensureLayoutState();
      View var14 = null;
      View var13 = null;
      int var7 = this.mOrientationHelper.getStartAfterPadding();
      int var8 = this.mOrientationHelper.getEndAfterPadding();
      byte var6;
      if(var4 > var3) {
         var6 = 1;
      } else {
         var6 = -1;
      }

      View var11;
      while(true) {
         if(var3 == var4) {
            if(var13 == null) {
               var13 = var14;
            }

            var11 = var13;
            break;
         }

         View var10 = this.getChildAt(var3);
         int var9 = this.getPosition(var10);
         var11 = var14;
         View var12 = var13;
         if(var9 >= 0) {
            var11 = var14;
            var12 = var13;
            if(var9 < var5) {
               if(((RecyclerView$LayoutParams)var10.getLayoutParams()).isItemRemoved()) {
                  var11 = var14;
                  var12 = var13;
                  if(var14 == null) {
                     var12 = var13;
                     var11 = var10;
                  }
               } else {
                  if(this.mOrientationHelper.getDecoratedStart(var10) < var8) {
                     var11 = var10;
                     if(this.mOrientationHelper.getDecoratedEnd(var10) >= var7) {
                        break;
                     }
                  }

                  var11 = var14;
                  var12 = var13;
                  if(var13 == null) {
                     var11 = var14;
                     var12 = var10;
                  }
               }
            }
         }

         var3 += var6;
         var14 = var11;
         var13 = var12;
      }

      return var11;
   }

   public View findViewByPosition(int var1) {
      int var2 = this.getChildCount();
      View var4;
      if(var2 == 0) {
         var4 = null;
         return var4;
      } else {
         int var3 = var1 - this.getPosition(this.getChildAt(0));
         if(var3 >= 0 && var3 < var2) {
            View var5 = this.getChildAt(var3);
            var4 = var5;
            if(this.getPosition(var5) == var1) {
               return var4;
            }
         }

         return super.findViewByPosition(var1);
      }
   }

   public RecyclerView$LayoutParams generateDefaultLayoutParams() {
      return new RecyclerView$LayoutParams(-2, -2);
   }

   protected int getExtraLayoutSpace(RecyclerView$State var1) {
      return var1.hasTargetScrollPosition()?this.mOrientationHelper.getTotalSpace():0;
   }

   public int getOrientation() {
      return this.mOrientation;
   }

   public boolean getRecycleChildrenOnDetach() {
      return this.mRecycleChildrenOnDetach;
   }

   public boolean getReverseLayout() {
      return this.mReverseLayout;
   }

   public boolean getStackFromEnd() {
      return this.mStackFromEnd;
   }

   protected boolean isLayoutRTL() {
      return this.getLayoutDirection() == 1;
   }

   public boolean isSmoothScrollbarEnabled() {
      return this.mSmoothScrollbarEnabled;
   }

   void layoutChunk(RecyclerView$Recycler var1, RecyclerView$State var2, LinearLayoutManager$LayoutState var3, LinearLayoutManager$LayoutChunkResult var4) {
      View var11 = var3.next(var1);
      if(var11 == null) {
         var4.mFinished = true;
      } else {
         RecyclerView$LayoutParams var12 = (RecyclerView$LayoutParams)var11.getLayoutParams();
         boolean var9;
         boolean var10;
         if(var3.mScrapList == null) {
            var10 = this.mShouldReverseLayout;
            if(var3.mLayoutDirection == -1) {
               var9 = true;
            } else {
               var9 = false;
            }

            if(var10 == var9) {
               this.addView(var11);
            } else {
               this.addView(var11, 0);
            }
         } else {
            var10 = this.mShouldReverseLayout;
            if(var3.mLayoutDirection == -1) {
               var9 = true;
            } else {
               var9 = false;
            }

            if(var10 == var9) {
               this.addDisappearingView(var11);
            } else {
               this.addDisappearingView(var11, 0);
            }
         }

         this.measureChildWithMargins(var11, 0, 0);
         var4.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(var11);
         int var5;
         int var6;
         int var7;
         int var8;
         if(this.mOrientation == 1) {
            if(this.isLayoutRTL()) {
               var7 = this.getWidth() - this.getPaddingRight();
               var6 = var7 - this.mOrientationHelper.getDecoratedMeasurementInOther(var11);
            } else {
               var6 = this.getPaddingLeft();
               var7 = var6 + this.mOrientationHelper.getDecoratedMeasurementInOther(var11);
            }

            if(var3.mLayoutDirection == -1) {
               var5 = var3.mOffset;
               var8 = var3.mOffset - var4.mConsumed;
            } else {
               var8 = var3.mOffset;
               var5 = var3.mOffset + var4.mConsumed;
            }
         } else {
            var8 = this.getPaddingTop();
            var5 = var8 + this.mOrientationHelper.getDecoratedMeasurementInOther(var11);
            if(var3.mLayoutDirection == -1) {
               var7 = var3.mOffset;
               var6 = var3.mOffset - var4.mConsumed;
            } else {
               var6 = var3.mOffset;
               var7 = var3.mOffset + var4.mConsumed;
            }
         }

         this.layoutDecorated(var11, var6 + var12.leftMargin, var8 + var12.topMargin, var7 - var12.rightMargin, var5 - var12.bottomMargin);
         if(var12.isItemRemoved() || var12.isItemChanged()) {
            var4.mIgnoreConsumed = true;
         }

         var4.mFocusable = var11.isFocusable();
      }
   }

   void onAnchorReady(RecyclerView$Recycler var1, RecyclerView$State var2, LinearLayoutManager$AnchorInfo var3, int var4) {
   }

   public void onDetachedFromWindow(RecyclerView var1, RecyclerView$Recycler var2) {
      super.onDetachedFromWindow(var1, var2);
      if(this.mRecycleChildrenOnDetach) {
         this.removeAndRecycleAllViews(var2);
         var2.clear();
      }

   }

   public View onFocusSearchFailed(View var1, int var2, RecyclerView$Recycler var3, RecyclerView$State var4) {
      this.resolveShouldLayoutReverse();
      View var6;
      if(this.getChildCount() == 0) {
         var6 = null;
         return var6;
      } else {
         var2 = this.convertFocusDirectionToLayoutDirection(var2);
         if(var2 == Integer.MIN_VALUE) {
            return null;
         } else {
            this.ensureLayoutState();
            View var5;
            if(var2 == -1) {
               var5 = this.findReferenceChildClosestToStart(var3, var4);
            } else {
               var5 = this.findReferenceChildClosestToEnd(var3, var4);
            }

            if(var5 == null) {
               return null;
            } else {
               this.ensureLayoutState();
               this.updateLayoutState(var2, (int)(0.33333334F * (float)this.mOrientationHelper.getTotalSpace()), false, var4);
               this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
               this.mLayoutState.mRecycle = false;
               this.fill(var3, this.mLayoutState, var4, true);
               if(var2 == -1) {
                  var1 = this.getChildClosestToStart();
               } else {
                  var1 = this.getChildClosestToEnd();
               }

               if(var1 != var5) {
                  var6 = var1;
                  if(var1.isFocusable()) {
                     return var6;
                  }
               }

               return null;
            }
         }
      }
   }

   public void onInitializeAccessibilityEvent(AccessibilityEvent var1) {
      super.onInitializeAccessibilityEvent(var1);
      if(this.getChildCount() > 0) {
         AccessibilityRecordCompat var2 = AccessibilityEventCompat.asRecord(var1);
         var2.setFromIndex(this.findFirstVisibleItemPosition());
         var2.setToIndex(this.findLastVisibleItemPosition());
      }

   }

   public void onLayoutChildren(RecyclerView$Recycler var1, RecyclerView$State var2) {
      if((this.mPendingSavedState != null || this.mPendingScrollPosition != -1) && var2.getItemCount() == 0) {
         this.removeAndRecycleAllViews(var1);
      } else {
         if(this.mPendingSavedState != null && this.mPendingSavedState.hasValidAnchor()) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
         }

         this.ensureLayoutState();
         this.mLayoutState.mRecycle = false;
         this.resolveShouldLayoutReverse();
         this.mAnchorInfo.reset();
         this.mAnchorInfo.mLayoutFromEnd = this.mShouldReverseLayout ^ this.mStackFromEnd;
         this.updateAnchorInfoForLayout(var1, var2, this.mAnchorInfo);
         int var3 = this.getExtraLayoutSpace(var2);
         int var4;
         if(this.mLayoutState.mLastScrollDelta >= 0) {
            var4 = 0;
         } else {
            var4 = var3;
            var3 = 0;
         }

         int var5 = var4 + this.mOrientationHelper.getStartAfterPadding();
         int var6 = var3 + this.mOrientationHelper.getEndPadding();
         var3 = var6;
         var4 = var5;
         if(var2.isPreLayout()) {
            var3 = var6;
            var4 = var5;
            if(this.mPendingScrollPosition != -1) {
               var3 = var6;
               var4 = var5;
               if(this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                  View var9 = this.findViewByPosition(this.mPendingScrollPosition);
                  var3 = var6;
                  var4 = var5;
                  if(var9 != null) {
                     if(this.mShouldReverseLayout) {
                        var3 = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(var9) - this.mPendingScrollPositionOffset;
                     } else {
                        var3 = this.mOrientationHelper.getDecoratedStart(var9);
                        var4 = this.mOrientationHelper.getStartAfterPadding();
                        var3 = this.mPendingScrollPositionOffset - (var3 - var4);
                     }

                     if(var3 > 0) {
                        var4 = var5 + var3;
                        var3 = var6;
                     } else {
                        var3 = var6 - var3;
                        var4 = var5;
                     }
                  }
               }
            }
         }

         byte var10;
         if(this.mAnchorInfo.mLayoutFromEnd) {
            if(this.mShouldReverseLayout) {
               var10 = 1;
            } else {
               var10 = -1;
            }
         } else if(this.mShouldReverseLayout) {
            var10 = -1;
         } else {
            var10 = 1;
         }

         this.onAnchorReady(var1, var2, this.mAnchorInfo, var10);
         this.detachAndScrapAttachedViews(var1);
         LinearLayoutManager$LayoutState var11 = this.mLayoutState;
         boolean var8;
         if(this.mOrientationHelper.getMode() == 0) {
            var8 = true;
         } else {
            var8 = false;
         }

         var11.mInfinite = var8;
         this.mLayoutState.mIsPreLayout = var2.isPreLayout();
         int var7;
         if(this.mAnchorInfo.mLayoutFromEnd) {
            this.updateLayoutStateToFillStart(this.mAnchorInfo);
            this.mLayoutState.mExtra = var4;
            this.fill(var1, this.mLayoutState, var2, false);
            var5 = this.mLayoutState.mOffset;
            var7 = this.mLayoutState.mCurrentPosition;
            var4 = var3;
            if(this.mLayoutState.mAvailable > 0) {
               var4 = var3 + this.mLayoutState.mAvailable;
            }

            this.updateLayoutStateToFillEnd(this.mAnchorInfo);
            this.mLayoutState.mExtra = var4;
            var11 = this.mLayoutState;
            var11.mCurrentPosition += this.mLayoutState.mItemDirection;
            this.fill(var1, this.mLayoutState, var2, false);
            var6 = this.mLayoutState.mOffset;
            var3 = var6;
            var4 = var5;
            if(this.mLayoutState.mAvailable > 0) {
               var3 = this.mLayoutState.mAvailable;
               this.updateLayoutStateToFillStart(var7, var5);
               this.mLayoutState.mExtra = var3;
               this.fill(var1, this.mLayoutState, var2, false);
               var4 = this.mLayoutState.mOffset;
               var3 = var6;
            }
         } else {
            this.updateLayoutStateToFillEnd(this.mAnchorInfo);
            this.mLayoutState.mExtra = var3;
            this.fill(var1, this.mLayoutState, var2, false);
            var5 = this.mLayoutState.mOffset;
            var7 = this.mLayoutState.mCurrentPosition;
            var3 = var4;
            if(this.mLayoutState.mAvailable > 0) {
               var3 = var4 + this.mLayoutState.mAvailable;
            }

            this.updateLayoutStateToFillStart(this.mAnchorInfo);
            this.mLayoutState.mExtra = var3;
            var11 = this.mLayoutState;
            var11.mCurrentPosition += this.mLayoutState.mItemDirection;
            this.fill(var1, this.mLayoutState, var2, false);
            var6 = this.mLayoutState.mOffset;
            var3 = var5;
            var4 = var6;
            if(this.mLayoutState.mAvailable > 0) {
               var3 = this.mLayoutState.mAvailable;
               this.updateLayoutStateToFillEnd(var7, var5);
               this.mLayoutState.mExtra = var3;
               this.fill(var1, this.mLayoutState, var2, false);
               var3 = this.mLayoutState.mOffset;
               var4 = var6;
            }
         }

         var5 = var3;
         var6 = var4;
         if(this.getChildCount() > 0) {
            if(this.mShouldReverseLayout ^ this.mStackFromEnd) {
               var5 = this.fixLayoutEndGap(var3, var1, var2, true);
               var6 = var4 + var5;
               var4 = this.fixLayoutStartGap(var6, var1, var2, false);
               var6 += var4;
               var5 = var3 + var5 + var4;
            } else {
               var5 = this.fixLayoutStartGap(var4, var1, var2, true);
               var3 += var5;
               var7 = this.fixLayoutEndGap(var3, var1, var2, false);
               var6 = var4 + var5 + var7;
               var5 = var3 + var7;
            }
         }

         this.layoutForPredictiveAnimations(var1, var2, var6, var5);
         if(!var2.isPreLayout()) {
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            this.mOrientationHelper.onLayoutComplete();
         }

         this.mLastStackFromEnd = this.mStackFromEnd;
         this.mPendingSavedState = null;
      }
   }

   public void onRestoreInstanceState(Parcelable var1) {
      if(var1 instanceof LinearLayoutManager$SavedState) {
         this.mPendingSavedState = (LinearLayoutManager$SavedState)var1;
         this.requestLayout();
      }

   }

   public Parcelable onSaveInstanceState() {
      if(this.mPendingSavedState != null) {
         return new LinearLayoutManager$SavedState(this.mPendingSavedState);
      } else {
         LinearLayoutManager$SavedState var2 = new LinearLayoutManager$SavedState();
         if(this.getChildCount() > 0) {
            this.ensureLayoutState();
            boolean var1 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            var2.mAnchorLayoutFromEnd = var1;
            View var3;
            if(var1) {
               var3 = this.getChildClosestToEnd();
               var2.mAnchorOffset = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(var3);
               var2.mAnchorPosition = this.getPosition(var3);
               return var2;
            } else {
               var3 = this.getChildClosestToStart();
               var2.mAnchorPosition = this.getPosition(var3);
               var2.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(var3) - this.mOrientationHelper.getStartAfterPadding();
               return var2;
            }
         } else {
            var2.invalidateAnchor();
            return var2;
         }
      }
   }

   public void prepareForDrop(View var1, View var2, int var3, int var4) {
      this.assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
      this.ensureLayoutState();
      this.resolveShouldLayoutReverse();
      var3 = this.getPosition(var1);
      var4 = this.getPosition(var2);
      byte var5;
      if(var3 < var4) {
         var5 = 1;
      } else {
         var5 = -1;
      }

      if(this.mShouldReverseLayout) {
         if(var5 == 1) {
            this.scrollToPositionWithOffset(var4, this.mOrientationHelper.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedStart(var2) + this.mOrientationHelper.getDecoratedMeasurement(var1)));
         } else {
            this.scrollToPositionWithOffset(var4, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(var2));
         }
      } else if(var5 == -1) {
         this.scrollToPositionWithOffset(var4, this.mOrientationHelper.getDecoratedStart(var2));
      } else {
         this.scrollToPositionWithOffset(var4, this.mOrientationHelper.getDecoratedEnd(var2) - this.mOrientationHelper.getDecoratedMeasurement(var1));
      }
   }

   int scrollBy(int var1, RecyclerView$Recycler var2, RecyclerView$State var3) {
      if(this.getChildCount() != 0 && var1 != 0) {
         this.mLayoutState.mRecycle = true;
         this.ensureLayoutState();
         byte var4;
         if(var1 > 0) {
            var4 = 1;
         } else {
            var4 = -1;
         }

         int var5 = Math.abs(var1);
         this.updateLayoutState(var4, var5, true, var3);
         int var6 = this.mLayoutState.mScrollingOffset + this.fill(var2, this.mLayoutState, var3, false);
         if(var6 >= 0) {
            if(var5 > var6) {
               var1 = var4 * var6;
            }

            this.mOrientationHelper.offsetChildren(-var1);
            this.mLayoutState.mLastScrollDelta = var1;
            return var1;
         }
      }

      return 0;
   }

   public int scrollHorizontallyBy(int var1, RecyclerView$Recycler var2, RecyclerView$State var3) {
      return this.mOrientation == 1?0:this.scrollBy(var1, var2, var3);
   }

   public void scrollToPosition(int var1) {
      this.mPendingScrollPosition = var1;
      this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
      if(this.mPendingSavedState != null) {
         this.mPendingSavedState.invalidateAnchor();
      }

      this.requestLayout();
   }

   public void scrollToPositionWithOffset(int var1, int var2) {
      this.mPendingScrollPosition = var1;
      this.mPendingScrollPositionOffset = var2;
      if(this.mPendingSavedState != null) {
         this.mPendingSavedState.invalidateAnchor();
      }

      this.requestLayout();
   }

   public int scrollVerticallyBy(int var1, RecyclerView$Recycler var2, RecyclerView$State var3) {
      return this.mOrientation == 0?0:this.scrollBy(var1, var2, var3);
   }

   public void setOrientation(int var1) {
      if(var1 != 0 && var1 != 1) {
         throw new IllegalArgumentException("invalid orientation:" + var1);
      } else {
         this.assertNotInLayoutOrScroll((String)null);
         if(var1 != this.mOrientation) {
            this.mOrientation = var1;
            this.mOrientationHelper = null;
            this.requestLayout();
         }
      }
   }

   public void setRecycleChildrenOnDetach(boolean var1) {
      this.mRecycleChildrenOnDetach = var1;
   }

   public void setReverseLayout(boolean var1) {
      this.assertNotInLayoutOrScroll((String)null);
      if(var1 != this.mReverseLayout) {
         this.mReverseLayout = var1;
         this.requestLayout();
      }
   }

   public void setSmoothScrollbarEnabled(boolean var1) {
      this.mSmoothScrollbarEnabled = var1;
   }

   public void setStackFromEnd(boolean var1) {
      this.assertNotInLayoutOrScroll((String)null);
      if(this.mStackFromEnd != var1) {
         this.mStackFromEnd = var1;
         this.requestLayout();
      }
   }

   boolean shouldMeasureTwice() {
      return this.getHeightMode() != 1073741824 && this.getWidthMode() != 1073741824 && this.hasFlexibleChildInBothOrientations();
   }

   public void smoothScrollToPosition(RecyclerView var1, RecyclerView$State var2, int var3) {
      LinearLayoutManager$1 var4 = new LinearLayoutManager$1(this, var1.getContext());
      var4.setTargetPosition(var3);
      this.startSmoothScroll(var4);
   }

   public boolean supportsPredictiveItemAnimations() {
      return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
   }

   void validateChildOrder() {
      boolean var7 = true;
      boolean var6 = true;
      Log.d("LinearLayoutManager", "validating child count " + this.getChildCount());
      if(this.getChildCount() >= 1) {
         int var2 = this.getPosition(this.getChildAt(0));
         int var3 = this.mOrientationHelper.getDecoratedStart(this.getChildAt(0));
         int var1;
         int var4;
         int var5;
         View var8;
         StringBuilder var9;
         if(this.mShouldReverseLayout) {
            for(var1 = 1; var1 < this.getChildCount(); ++var1) {
               var8 = this.getChildAt(var1);
               var4 = this.getPosition(var8);
               var5 = this.mOrientationHelper.getDecoratedStart(var8);
               if(var4 < var2) {
                  this.logChildren();
                  var9 = (new StringBuilder()).append("detected invalid position. loc invalid? ");
                  if(var5 >= var3) {
                     var6 = false;
                  }

                  throw new RuntimeException(var9.append(var6).toString());
               }

               if(var5 > var3) {
                  this.logChildren();
                  throw new RuntimeException("detected invalid location");
               }
            }
         } else {
            for(var1 = 1; var1 < this.getChildCount(); ++var1) {
               var8 = this.getChildAt(var1);
               var4 = this.getPosition(var8);
               var5 = this.mOrientationHelper.getDecoratedStart(var8);
               if(var4 < var2) {
                  this.logChildren();
                  var9 = (new StringBuilder()).append("detected invalid position. loc invalid? ");
                  if(var5 < var3) {
                     var6 = var7;
                  } else {
                     var6 = false;
                  }

                  throw new RuntimeException(var9.append(var6).toString());
               }

               if(var5 < var3) {
                  this.logChildren();
                  throw new RuntimeException("detected invalid location");
               }
            }
         }
      }

   }
}
