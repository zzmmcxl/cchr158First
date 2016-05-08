package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.design.widget.AnimationUtils;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout$SlidingTabStrip$1;
import android.support.design.widget.TabLayout$SlidingTabStrip$2;
import android.support.design.widget.ValueAnimatorCompat;
import android.support.design.widget.ViewUtils;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

class TabLayout$SlidingTabStrip extends LinearLayout {
   private ValueAnimatorCompat mIndicatorAnimator;
   private int mIndicatorLeft;
   private int mIndicatorRight;
   private int mSelectedIndicatorHeight;
   private final Paint mSelectedIndicatorPaint;
   private int mSelectedPosition;
   private float mSelectionOffset;

   TabLayout$SlidingTabStrip(TabLayout var1, Context var2) {
      super(var2);
      this.this$0 = var1;
      this.mSelectedPosition = -1;
      this.mIndicatorLeft = -1;
      this.mIndicatorRight = -1;
      this.setWillNotDraw(false);
      this.mSelectedIndicatorPaint = new Paint();
   }

   private void setIndicatorPosition(int var1, int var2) {
      if(var1 != this.mIndicatorLeft || var2 != this.mIndicatorRight) {
         this.mIndicatorLeft = var1;
         this.mIndicatorRight = var2;
         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   private void updateIndicatorPosition() {
      View var5 = this.getChildAt(this.mSelectedPosition);
      int var1;
      int var2;
      if(var5 != null && var5.getWidth() > 0) {
         int var4 = var5.getLeft();
         int var3 = var5.getRight();
         var1 = var4;
         var2 = var3;
         if(this.mSelectionOffset > 0.0F) {
            var1 = var4;
            var2 = var3;
            if(this.mSelectedPosition < this.getChildCount() - 1) {
               var5 = this.getChildAt(this.mSelectedPosition + 1);
               var1 = (int)(this.mSelectionOffset * (float)var5.getLeft() + (1.0F - this.mSelectionOffset) * (float)var4);
               var2 = (int)(this.mSelectionOffset * (float)var5.getRight() + (1.0F - this.mSelectionOffset) * (float)var3);
            }
         }
      } else {
         var2 = -1;
         var1 = -1;
      }

      this.setIndicatorPosition(var1, var2);
   }

   void animateIndicatorToPosition(int var1, int var2) {
      if(this.mIndicatorAnimator != null && this.mIndicatorAnimator.isRunning()) {
         this.mIndicatorAnimator.cancel();
      }

      boolean var3;
      if(ViewCompat.getLayoutDirection(this) == 1) {
         var3 = true;
      } else {
         var3 = false;
      }

      View var7 = this.getChildAt(var1);
      if(var7 == null) {
         this.updateIndicatorPosition();
      } else {
         int var5 = var7.getLeft();
         int var6 = var7.getRight();
         int var4;
         int var8;
         if(Math.abs(var1 - this.mSelectedPosition) <= 1) {
            var8 = this.mIndicatorLeft;
            var4 = this.mIndicatorRight;
         } else {
            var4 = TabLayout.access$2100(this.this$0, 24);
            if(var1 < this.mSelectedPosition) {
               if(var3) {
                  var4 = var5 - var4;
                  var8 = var4;
               } else {
                  var4 += var6;
                  var8 = var4;
               }
            } else if(var3) {
               var4 += var6;
               var8 = var4;
            } else {
               var4 = var5 - var4;
               var8 = var4;
            }
         }

         if(var8 != var5 || var4 != var6) {
            ValueAnimatorCompat var9 = ViewUtils.createAnimator();
            this.mIndicatorAnimator = var9;
            var9.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            var9.setDuration(var2);
            var9.setFloatValues(0.0F, 1.0F);
            var9.setUpdateListener(new TabLayout$SlidingTabStrip$1(this, var8, var5, var4, var6));
            var9.setListener(new TabLayout$SlidingTabStrip$2(this, var1));
            var9.start();
            return;
         }
      }

   }

   boolean childrenNeedLayout() {
      int var1 = 0;

      for(int var2 = this.getChildCount(); var1 < var2; ++var1) {
         if(this.getChildAt(var1).getWidth() <= 0) {
            return true;
         }
      }

      return false;
   }

   public void draw(Canvas var1) {
      super.draw(var1);
      if(this.mIndicatorLeft >= 0 && this.mIndicatorRight > this.mIndicatorLeft) {
         var1.drawRect((float)this.mIndicatorLeft, (float)(this.getHeight() - this.mSelectedIndicatorHeight), (float)this.mIndicatorRight, (float)this.getHeight(), this.mSelectedIndicatorPaint);
      }

   }

   float getIndicatorPosition() {
      return (float)this.mSelectedPosition + this.mSelectionOffset;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      if(this.mIndicatorAnimator != null && this.mIndicatorAnimator.isRunning()) {
         this.mIndicatorAnimator.cancel();
         long var6 = this.mIndicatorAnimator.getDuration();
         this.animateIndicatorToPosition(this.mSelectedPosition, Math.round((1.0F - this.mIndicatorAnimator.getAnimatedFraction()) * (float)var6));
      } else {
         this.updateIndicatorPosition();
      }
   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      if(MeasureSpec.getMode(var1) == 1073741824 && TabLayout.access$1800(this.this$0) == 1 && TabLayout.access$2200(this.this$0) == 1) {
         int var7 = this.getChildCount();
         int var4 = 0;

         int var5;
         for(int var3 = 0; var3 < var7; var4 = var5) {
            View var8 = this.getChildAt(var3);
            var5 = var4;
            if(var8.getVisibility() == 0) {
               var5 = Math.max(var4, var8.getMeasuredWidth());
            }

            ++var3;
         }

         if(var4 > 0) {
            var5 = TabLayout.access$2100(this.this$0, 16);
            boolean var9 = false;
            boolean var6;
            if(var4 * var7 > this.getMeasuredWidth() - var5 * 2) {
               TabLayout.access$2202(this.this$0, 0);
               TabLayout.access$2300(this.this$0, false);
               var6 = true;
            } else {
               var5 = 0;

               while(true) {
                  var6 = var9;
                  if(var5 >= var7) {
                     break;
                  }

                  LayoutParams var10 = (LayoutParams)this.getChildAt(var5).getLayoutParams();
                  if(var10.width != var4 || var10.weight != 0.0F) {
                     var10.width = var4;
                     var10.weight = 0.0F;
                     var9 = true;
                  }

                  ++var5;
               }
            }

            if(var6) {
               super.onMeasure(var1, var2);
               return;
            }
         }
      }

   }

   void setIndicatorPositionFromTabPosition(int var1, float var2) {
      if(this.mIndicatorAnimator != null && this.mIndicatorAnimator.isRunning()) {
         this.mIndicatorAnimator.cancel();
      }

      this.mSelectedPosition = var1;
      this.mSelectionOffset = var2;
      this.updateIndicatorPosition();
   }

   void setSelectedIndicatorColor(int var1) {
      if(this.mSelectedIndicatorPaint.getColor() != var1) {
         this.mSelectedIndicatorPaint.setColor(var1);
         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   void setSelectedIndicatorHeight(int var1) {
      if(this.mSelectedIndicatorHeight != var1) {
         this.mSelectedIndicatorHeight = var1;
         ViewCompat.postInvalidateOnAnimation(this);
      }

   }
}
