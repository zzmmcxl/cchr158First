package android.support.design.widget;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.AnimationUtils;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout$Behavior$1;
import android.support.design.widget.AppBarLayout$Behavior$DragCallback;
import android.support.design.widget.AppBarLayout$Behavior$SavedState;
import android.support.design.widget.AppBarLayout$LayoutParams;
import android.support.design.widget.AppBarLayout$OnOffsetChangedListener;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.HeaderBehavior;
import android.support.design.widget.MathUtils;
import android.support.design.widget.ValueAnimatorCompat;
import android.support.design.widget.ViewUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.List;

public class AppBarLayout$Behavior extends HeaderBehavior<AppBarLayout> {
   private static final int ANIMATE_OFFSET_DIPS_PER_SECOND = 300;
   private static final int INVALID_POSITION = -1;
   private ValueAnimatorCompat mAnimator;
   private WeakReference<View> mLastNestedScrollingChildRef;
   private int mOffsetDelta;
   private int mOffsetToChildIndexOnLayout = -1;
   private boolean mOffsetToChildIndexOnLayoutIsMinHeight;
   private float mOffsetToChildIndexOnLayoutPerc;
   private AppBarLayout$Behavior$DragCallback mOnDragCallback;
   private boolean mSkipNestedPreScroll;
   private boolean mWasNestedFlung;

   public AppBarLayout$Behavior() {
   }

   public AppBarLayout$Behavior(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   private void animateOffsetTo(CoordinatorLayout var1, AppBarLayout var2, int var3) {
      int var5 = this.getTopBottomOffsetForScrollingSibling();
      if(var5 == var3) {
         if(this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
         }

      } else {
         if(this.mAnimator == null) {
            this.mAnimator = ViewUtils.createAnimator();
            this.mAnimator.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
            this.mAnimator.setUpdateListener(new AppBarLayout$Behavior$1(this, var1, var2));
         } else {
            this.mAnimator.cancel();
         }

         float var4 = (float)Math.abs(var5 - var3) / var1.getResources().getDisplayMetrics().density;
         this.mAnimator.setDuration(Math.round(1000.0F * var4 / 300.0F));
         this.mAnimator.setIntValues(var5, var3);
         this.mAnimator.start();
      }
   }

   private void dispatchOffsetUpdates(AppBarLayout var1) {
      List var4 = AppBarLayout.access$800(var1);
      int var2 = 0;

      for(int var3 = var4.size(); var2 < var3; ++var2) {
         AppBarLayout$OnOffsetChangedListener var5 = (AppBarLayout$OnOffsetChangedListener)var4.get(var2);
         if(var5 != null) {
            var5.onOffsetChanged(var1, this.getTopAndBottomOffset());
         }
      }

   }

   private View getChildOnOffset(AppBarLayout var1, int var2) {
      int var3 = 0;

      for(int var4 = var1.getChildCount(); var3 < var4; ++var3) {
         View var5 = var1.getChildAt(var3);
         if(var5.getTop() <= -var2 && var5.getBottom() >= -var2) {
            return var5;
         }
      }

      return null;
   }

   private int interpolateOffset(AppBarLayout var1, int var2) {
      int var5 = Math.abs(var2);
      int var4 = 0;
      int var6 = var1.getChildCount();

      int var3;
      while(true) {
         var3 = var2;
         if(var4 >= var6) {
            break;
         }

         View var7 = var1.getChildAt(var4);
         AppBarLayout$LayoutParams var8 = (AppBarLayout$LayoutParams)var7.getLayoutParams();
         Interpolator var9 = var8.getScrollInterpolator();
         if(var5 >= var7.getTop() && var5 <= var7.getBottom()) {
            var3 = var2;
            if(var9 != null) {
               var3 = 0;
               var6 = var8.getScrollFlags();
               if((var6 & 1) != 0) {
                  var4 = 0 + var7.getHeight() + var8.topMargin + var8.bottomMargin;
                  var3 = var4;
                  if((var6 & 2) != 0) {
                     var3 = var4 - ViewCompat.getMinimumHeight(var7);
                  }
               }

               var4 = var3;
               if(ViewCompat.getFitsSystemWindows(var7)) {
                  var4 = var3 - AppBarLayout.access$900(var1);
               }

               var3 = var2;
               if(var4 > 0) {
                  var3 = var7.getTop();
                  var3 = Math.round((float)var4 * var9.getInterpolation((float)(var5 - var3) / (float)var4));
                  var3 = Integer.signum(var2) * (var7.getTop() + var3);
               }
            }
            break;
         }

         ++var4;
      }

      return var3;
   }

   private void snapToChildIfNeeded(CoordinatorLayout var1, AppBarLayout var2) {
      int var6 = this.getTopBottomOffsetForScrollingSibling();
      View var7 = this.getChildOnOffset(var2, var6);
      if(var7 != null) {
         AppBarLayout$LayoutParams var8 = (AppBarLayout$LayoutParams)var7.getLayoutParams();
         if((var8.getScrollFlags() & 17) == 17) {
            int var4 = -var7.getTop();
            int var5 = -var7.getBottom();
            int var3 = var5;
            if((var8.getScrollFlags() & 2) == 2) {
               var3 = var5 + ViewCompat.getMinimumHeight(var7);
            }

            if(var6 >= (var3 + var4) / 2) {
               var3 = var4;
            }

            this.animateOffsetTo(var1, var2, MathUtils.constrain(var3, -var2.getTotalScrollRange(), 0));
         }
      }

   }

   boolean canDragView(AppBarLayout var1) {
      boolean var3 = true;
      boolean var2;
      if(this.mOnDragCallback != null) {
         var2 = this.mOnDragCallback.canDrag(var1);
      } else {
         var2 = var3;
         if(this.mLastNestedScrollingChildRef != null) {
            View var4 = (View)this.mLastNestedScrollingChildRef.get();
            if(var4 != null && var4.isShown()) {
               var2 = var3;
               if(!ViewCompat.canScrollVertically(var4, -1)) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   int getMaxDragOffset(AppBarLayout var1) {
      return -AppBarLayout.access$400(var1);
   }

   int getScrollRangeForDragFling(AppBarLayout var1) {
      return var1.getTotalScrollRange();
   }

   int getTopBottomOffsetForScrollingSibling() {
      return this.getTopAndBottomOffset() + this.mOffsetDelta;
   }

   void onFlingFinished(CoordinatorLayout var1, AppBarLayout var2) {
      this.snapToChildIfNeeded(var1, var2);
   }

   public boolean onLayoutChild(CoordinatorLayout var1, AppBarLayout var2, int var3) {
      boolean var5 = super.onLayoutChild(var1, var2, var3);
      int var4 = AppBarLayout.access$500(var2);
      if(var4 != 0) {
         boolean var7;
         if((var4 & 4) != 0) {
            var7 = true;
         } else {
            var7 = false;
         }

         if((var4 & 2) != 0) {
            var4 = -AppBarLayout.access$300(var2);
            if(var7) {
               this.animateOffsetTo(var1, var2, var4);
            } else {
               this.setHeaderTopBottomOffset(var1, var2, var4);
            }
         } else if((var4 & 1) != 0) {
            if(var7) {
               this.animateOffsetTo(var1, var2, 0);
            } else {
               this.setHeaderTopBottomOffset(var1, var2, 0);
            }
         }
      } else if(this.mOffsetToChildIndexOnLayout >= 0) {
         View var6 = var2.getChildAt(this.mOffsetToChildIndexOnLayout);
         var3 = -var6.getBottom();
         if(this.mOffsetToChildIndexOnLayoutIsMinHeight) {
            var3 += ViewCompat.getMinimumHeight(var6);
         } else {
            var3 += Math.round((float)var6.getHeight() * this.mOffsetToChildIndexOnLayoutPerc);
         }

         this.setTopAndBottomOffset(var3);
      }

      AppBarLayout.access$600(var2);
      this.mOffsetToChildIndexOnLayout = -1;
      this.setTopAndBottomOffset(MathUtils.constrain(this.getTopAndBottomOffset(), -var2.getTotalScrollRange(), 0));
      this.dispatchOffsetUpdates(var2);
      return var5;
   }

   public boolean onNestedFling(CoordinatorLayout var1, AppBarLayout var2, View var3, float var4, float var5, boolean var6) {
      boolean var8 = false;
      if(!var6) {
         var6 = this.fling(var1, var2, -var2.getTotalScrollRange(), 0, -var5);
      } else {
         int var7;
         if(var5 < 0.0F) {
            var7 = -var2.getTotalScrollRange() + AppBarLayout.access$200(var2);
            var6 = var8;
            if(this.getTopBottomOffsetForScrollingSibling() < var7) {
               this.animateOffsetTo(var1, var2, var7);
               var6 = true;
            }
         } else {
            var7 = -AppBarLayout.access$300(var2);
            var6 = var8;
            if(this.getTopBottomOffsetForScrollingSibling() > var7) {
               this.animateOffsetTo(var1, var2, var7);
               var6 = true;
            }
         }
      }

      this.mWasNestedFlung = var6;
      return var6;
   }

   public void onNestedPreScroll(CoordinatorLayout var1, AppBarLayout var2, View var3, int var4, int var5, int[] var6) {
      if(var5 != 0 && !this.mSkipNestedPreScroll) {
         int var7;
         if(var5 < 0) {
            var4 = -var2.getTotalScrollRange();
            var7 = var4 + AppBarLayout.access$200(var2);
         } else {
            var4 = -AppBarLayout.access$300(var2);
            var7 = 0;
         }

         var6[1] = this.scroll(var1, var2, var5, var4, var7);
      }

   }

   public void onNestedScroll(CoordinatorLayout var1, AppBarLayout var2, View var3, int var4, int var5, int var6, int var7) {
      if(var7 < 0) {
         this.scroll(var1, var2, var7, -AppBarLayout.access$400(var2), 0);
         this.mSkipNestedPreScroll = true;
      } else {
         this.mSkipNestedPreScroll = false;
      }
   }

   public void onRestoreInstanceState(CoordinatorLayout var1, AppBarLayout var2, Parcelable var3) {
      if(var3 instanceof AppBarLayout$Behavior$SavedState) {
         AppBarLayout$Behavior$SavedState var4 = (AppBarLayout$Behavior$SavedState)var3;
         super.onRestoreInstanceState(var1, var2, var4.getSuperState());
         this.mOffsetToChildIndexOnLayout = var4.firstVisibleChildIndex;
         this.mOffsetToChildIndexOnLayoutPerc = var4.firstVisibileChildPercentageShown;
         this.mOffsetToChildIndexOnLayoutIsMinHeight = var4.firstVisibileChildAtMinimumHeight;
      } else {
         super.onRestoreInstanceState(var1, var2, var3);
         this.mOffsetToChildIndexOnLayout = -1;
      }
   }

   public Parcelable onSaveInstanceState(CoordinatorLayout var1, AppBarLayout var2) {
      Parcelable var8 = super.onSaveInstanceState(var1, var2);
      int var4 = this.getTopAndBottomOffset();
      int var3 = 0;

      for(int var5 = var2.getChildCount(); var3 < var5; ++var3) {
         View var9 = var2.getChildAt(var3);
         int var6 = var9.getBottom() + var4;
         if(var9.getTop() + var4 <= 0 && var6 >= 0) {
            AppBarLayout$Behavior$SavedState var10 = new AppBarLayout$Behavior$SavedState(var8);
            var10.firstVisibleChildIndex = var3;
            boolean var7;
            if(var6 == ViewCompat.getMinimumHeight(var9)) {
               var7 = true;
            } else {
               var7 = false;
            }

            var10.firstVisibileChildAtMinimumHeight = var7;
            var10.firstVisibileChildPercentageShown = (float)var6 / (float)var9.getHeight();
            return var10;
         }
      }

      return var8;
   }

   public boolean onStartNestedScroll(CoordinatorLayout var1, AppBarLayout var2, View var3, View var4, int var5) {
      boolean var6;
      if((var5 & 2) != 0 && AppBarLayout.access$100(var2) && var1.getHeight() - var3.getHeight() <= var2.getHeight()) {
         var6 = true;
      } else {
         var6 = false;
      }

      if(var6 && this.mAnimator != null) {
         this.mAnimator.cancel();
      }

      this.mLastNestedScrollingChildRef = null;
      return var6;
   }

   public void onStopNestedScroll(CoordinatorLayout var1, AppBarLayout var2, View var3) {
      if(!this.mWasNestedFlung) {
         this.snapToChildIfNeeded(var1, var2);
      }

      this.mSkipNestedPreScroll = false;
      this.mWasNestedFlung = false;
      this.mLastNestedScrollingChildRef = new WeakReference(var3);
   }

   public void setDragCallback(@Nullable AppBarLayout$Behavior$DragCallback var1) {
      this.mOnDragCallback = var1;
   }

   int setHeaderTopBottomOffset(CoordinatorLayout var1, AppBarLayout var2, int var3, int var4, int var5) {
      int var7 = this.getTopBottomOffsetForScrollingSibling();
      byte var6 = 0;
      if(var4 != 0 && var7 >= var4 && var7 <= var5) {
         var4 = MathUtils.constrain(var3, var4, var5);
         var3 = var6;
         if(var7 != var4) {
            if(AppBarLayout.access$700(var2)) {
               var3 = this.interpolateOffset(var2, var4);
            } else {
               var3 = var4;
            }

            boolean var8 = this.setTopAndBottomOffset(var3);
            var5 = var7 - var4;
            this.mOffsetDelta = var4 - var3;
            if(!var8 && AppBarLayout.access$700(var2)) {
               var1.dispatchDependentViewsChanged(var2);
            }

            this.dispatchOffsetUpdates(var2);
            var3 = var5;
         }

         return var3;
      } else {
         this.mOffsetDelta = 0;
         return 0;
      }
   }
}
