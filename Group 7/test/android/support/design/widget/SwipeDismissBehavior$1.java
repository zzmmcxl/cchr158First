package android.support.design.widget;

import android.support.design.widget.SwipeDismissBehavior;
import android.support.design.widget.SwipeDismissBehavior$SettleRunnable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper$Callback;
import android.view.View;
import android.view.ViewParent;

class SwipeDismissBehavior$1 extends ViewDragHelper$Callback {
   private int mOriginalCapturedViewLeft;

   SwipeDismissBehavior$1(SwipeDismissBehavior var1) {
      this.this$0 = var1;
   }

   private boolean shouldDismiss(View var1, float var2) {
      if(var2 != 0.0F) {
         boolean var3;
         if(ViewCompat.getLayoutDirection(var1) == 1) {
            var3 = true;
         } else {
            var3 = false;
         }

         if(SwipeDismissBehavior.access$200(this.this$0) != 2) {
            if(SwipeDismissBehavior.access$200(this.this$0) == 0) {
               if(var3) {
                  if(var2 >= 0.0F) {
                     return false;
                  }
               } else if(var2 <= 0.0F) {
                  return false;
               }
            } else {
               if(SwipeDismissBehavior.access$200(this.this$0) != 1) {
                  return false;
               }

               if(var3) {
                  if(var2 <= 0.0F) {
                     return false;
                  }
               } else if(var2 >= 0.0F) {
                  return false;
               }
            }
         }
      } else {
         int var6 = var1.getLeft();
         int var4 = this.mOriginalCapturedViewLeft;
         int var5 = Math.round((float)var1.getWidth() * SwipeDismissBehavior.access$300(this.this$0));
         if(Math.abs(var6 - var4) < var5) {
            return false;
         }
      }

      return true;
   }

   public int clampViewPositionHorizontal(View var1, int var2, int var3) {
      boolean var5;
      if(ViewCompat.getLayoutDirection(var1) == 1) {
         var5 = true;
      } else {
         var5 = false;
      }

      int var4;
      if(SwipeDismissBehavior.access$200(this.this$0) == 0) {
         if(var5) {
            var4 = this.mOriginalCapturedViewLeft - var1.getWidth();
            var3 = this.mOriginalCapturedViewLeft;
         } else {
            var4 = this.mOriginalCapturedViewLeft;
            var3 = this.mOriginalCapturedViewLeft + var1.getWidth();
         }
      } else if(SwipeDismissBehavior.access$200(this.this$0) == 1) {
         if(var5) {
            var4 = this.mOriginalCapturedViewLeft;
            var3 = this.mOriginalCapturedViewLeft + var1.getWidth();
         } else {
            var4 = this.mOriginalCapturedViewLeft - var1.getWidth();
            var3 = this.mOriginalCapturedViewLeft;
         }
      } else {
         var4 = this.mOriginalCapturedViewLeft - var1.getWidth();
         var3 = this.mOriginalCapturedViewLeft + var1.getWidth();
      }

      return SwipeDismissBehavior.access$400(var4, var2, var3);
   }

   public int clampViewPositionVertical(View var1, int var2, int var3) {
      return var1.getTop();
   }

   public int getViewHorizontalDragRange(View var1) {
      return var1.getWidth();
   }

   public void onViewCaptured(View var1, int var2) {
      this.mOriginalCapturedViewLeft = var1.getLeft();
      ViewParent var3 = var1.getParent();
      if(var3 != null) {
         var3.requestDisallowInterceptTouchEvent(true);
      }

   }

   public void onViewDragStateChanged(int var1) {
      if(SwipeDismissBehavior.access$000(this.this$0) != null) {
         SwipeDismissBehavior.access$000(this.this$0).onDragStateChanged(var1);
      }

   }

   public void onViewPositionChanged(View var1, int var2, int var3, int var4, int var5) {
      float var6 = (float)this.mOriginalCapturedViewLeft + (float)var1.getWidth() * SwipeDismissBehavior.access$500(this.this$0);
      float var7 = (float)this.mOriginalCapturedViewLeft + (float)var1.getWidth() * SwipeDismissBehavior.access$600(this.this$0);
      if((float)var2 <= var6) {
         ViewCompat.setAlpha(var1, 1.0F);
      } else if((float)var2 >= var7) {
         ViewCompat.setAlpha(var1, 0.0F);
      } else {
         ViewCompat.setAlpha(var1, SwipeDismissBehavior.access$700(0.0F, 1.0F - SwipeDismissBehavior.fraction(var6, var7, (float)var2), 1.0F));
      }
   }

   public void onViewReleased(View var1, float var2, float var3) {
      ViewParent var6 = var1.getParent();
      if(var6 != null) {
         var6.requestDisallowInterceptTouchEvent(false);
      }

      int var4 = var1.getWidth();
      boolean var5 = false;
      if(this.shouldDismiss(var1, var2)) {
         if(var1.getLeft() < this.mOriginalCapturedViewLeft) {
            var4 = this.mOriginalCapturedViewLeft - var4;
         } else {
            var4 += this.mOriginalCapturedViewLeft;
         }

         var5 = true;
      } else {
         var4 = this.mOriginalCapturedViewLeft;
      }

      if(SwipeDismissBehavior.access$100(this.this$0).settleCapturedViewAt(var4, var1.getTop())) {
         ViewCompat.postOnAnimation(var1, new SwipeDismissBehavior$SettleRunnable(this.this$0, var1, var5));
      } else if(var5 && SwipeDismissBehavior.access$000(this.this$0) != null) {
         SwipeDismissBehavior.access$000(this.this$0).onDismiss(var1);
         return;
      }

   }

   public boolean tryCaptureView(View var1, int var2) {
      return this.this$0.canSwipeDismissView(var1);
   }
}
