package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.HeaderBehavior$FlingRunnable;
import android.support.design.widget.MathUtils;
import android.support.design.widget.ViewOffsetBehavior;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ScrollerCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
   private static final int INVALID_POINTER = -1;
   private int mActivePointerId = -1;
   private Runnable mFlingRunnable;
   private boolean mIsBeingDragged;
   private int mLastMotionY;
   private ScrollerCompat mScroller;
   private int mTouchSlop = -1;
   private VelocityTracker mVelocityTracker;

   public HeaderBehavior() {
   }

   public HeaderBehavior(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   private void ensureVelocityTracker() {
      if(this.mVelocityTracker == null) {
         this.mVelocityTracker = VelocityTracker.obtain();
      }

   }

   boolean canDragView(V var1) {
      return false;
   }

   final boolean fling(CoordinatorLayout var1, V var2, int var3, int var4, float var5) {
      if(this.mFlingRunnable != null) {
         var2.removeCallbacks(this.mFlingRunnable);
         this.mFlingRunnable = null;
      }

      if(this.mScroller == null) {
         this.mScroller = ScrollerCompat.create(var2.getContext());
      }

      this.mScroller.fling(0, this.getTopAndBottomOffset(), 0, Math.round(var5), 0, 0, var3, var4);
      if(this.mScroller.computeScrollOffset()) {
         this.mFlingRunnable = new HeaderBehavior$FlingRunnable(this, var1, var2);
         ViewCompat.postOnAnimation(var2, this.mFlingRunnable);
         return true;
      } else {
         this.onFlingFinished(var1, var2);
         return false;
      }
   }

   int getMaxDragOffset(V var1) {
      return -var1.getHeight();
   }

   int getScrollRangeForDragFling(V var1) {
      return var1.getHeight();
   }

   int getTopBottomOffsetForScrollingSibling() {
      return this.getTopAndBottomOffset();
   }

   void onFlingFinished(CoordinatorLayout var1, V var2) {
   }

   public boolean onInterceptTouchEvent(CoordinatorLayout var1, V var2, MotionEvent var3) {
      if(this.mTouchSlop < 0) {
         this.mTouchSlop = ViewConfiguration.get(var1.getContext()).getScaledTouchSlop();
      }

      if(var3.getAction() == 2 && this.mIsBeingDragged) {
         return true;
      } else {
         int var4;
         switch(MotionEventCompat.getActionMasked(var3)) {
         case 0:
            this.mIsBeingDragged = false;
            var4 = (int)var3.getX();
            int var5 = (int)var3.getY();
            if(this.canDragView(var2) && var1.isPointInChildBounds(var2, var4, var5)) {
               this.mLastMotionY = var5;
               this.mActivePointerId = MotionEventCompat.getPointerId(var3, 0);
               this.ensureVelocityTracker();
            }
            break;
         case 1:
         case 3:
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            if(this.mVelocityTracker != null) {
               this.mVelocityTracker.recycle();
               this.mVelocityTracker = null;
            }
            break;
         case 2:
            var4 = this.mActivePointerId;
            if(var4 != -1) {
               var4 = MotionEventCompat.findPointerIndex(var3, var4);
               if(var4 != -1) {
                  var4 = (int)MotionEventCompat.getY(var3, var4);
                  if(Math.abs(var4 - this.mLastMotionY) > this.mTouchSlop) {
                     this.mIsBeingDragged = true;
                     this.mLastMotionY = var4;
                  }
               }
            }
         }

         if(this.mVelocityTracker != null) {
            this.mVelocityTracker.addMovement(var3);
         }

         return this.mIsBeingDragged;
      }
   }

   public boolean onTouchEvent(CoordinatorLayout var1, V var2, MotionEvent var3) {
      if(this.mTouchSlop < 0) {
         this.mTouchSlop = ViewConfiguration.get(var1.getContext()).getScaledTouchSlop();
      }

      int var5;
      int var6;
      switch(MotionEventCompat.getActionMasked(var3)) {
      case 0:
         var5 = (int)var3.getX();
         var6 = (int)var3.getY();
         if(!var1.isPointInChildBounds(var2, var5, var6) || !this.canDragView(var2)) {
            return false;
         }

         this.mLastMotionY = var6;
         this.mActivePointerId = MotionEventCompat.getPointerId(var3, 0);
         this.ensureVelocityTracker();
         break;
      case 1:
         if(this.mVelocityTracker != null) {
            this.mVelocityTracker.addMovement(var3);
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float var4 = VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId);
            this.fling(var1, var2, -this.getScrollRangeForDragFling(var2), 0, var4);
         }
      case 3:
         this.mIsBeingDragged = false;
         this.mActivePointerId = -1;
         if(this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
         }
         break;
      case 2:
         var5 = MotionEventCompat.findPointerIndex(var3, this.mActivePointerId);
         if(var5 == -1) {
            return false;
         }

         int var7 = (int)MotionEventCompat.getY(var3, var5);
         var6 = this.mLastMotionY - var7;
         var5 = var6;
         if(!this.mIsBeingDragged) {
            var5 = var6;
            if(Math.abs(var6) > this.mTouchSlop) {
               this.mIsBeingDragged = true;
               if(var6 > 0) {
                  var5 = var6 - this.mTouchSlop;
               } else {
                  var5 = var6 + this.mTouchSlop;
               }
            }
         }

         if(this.mIsBeingDragged) {
            this.mLastMotionY = var7;
            this.scroll(var1, var2, var5, this.getMaxDragOffset(var2), 0);
         }
      }

      if(this.mVelocityTracker != null) {
         this.mVelocityTracker.addMovement(var3);
      }

      return true;
   }

   final int scroll(CoordinatorLayout var1, V var2, int var3, int var4, int var5) {
      return this.setHeaderTopBottomOffset(var1, var2, this.getTopBottomOffsetForScrollingSibling() - var3, var4, var5);
   }

   int setHeaderTopBottomOffset(CoordinatorLayout var1, V var2, int var3) {
      return this.setHeaderTopBottomOffset(var1, var2, var3, Integer.MIN_VALUE, Integer.MAX_VALUE);
   }

   int setHeaderTopBottomOffset(CoordinatorLayout var1, V var2, int var3, int var4, int var5) {
      int var8 = this.getTopAndBottomOffset();
      byte var7 = 0;
      int var6 = var7;
      if(var4 != 0) {
         var6 = var7;
         if(var8 >= var4) {
            var6 = var7;
            if(var8 <= var5) {
               var3 = MathUtils.constrain(var3, var4, var5);
               var6 = var7;
               if(var8 != var3) {
                  this.setTopAndBottomOffset(var3);
                  var6 = var8 - var3;
               }
            }
         }
      }

      return var6;
   }
}
