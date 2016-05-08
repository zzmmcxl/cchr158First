package android.support.design.widget;

import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior$SettleRunnable;
import android.support.design.widget.MathUtils;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper$Callback;
import android.view.View;

class BottomSheetBehavior$1 extends ViewDragHelper$Callback {
   BottomSheetBehavior$1(BottomSheetBehavior var1) {
      this.this$0 = var1;
   }

   public int clampViewPositionHorizontal(View var1, int var2, int var3) {
      return var1.getLeft();
   }

   public int clampViewPositionVertical(View var1, int var2, int var3) {
      int var4 = BottomSheetBehavior.access$700(this.this$0);
      if(BottomSheetBehavior.access$800(this.this$0)) {
         var3 = BottomSheetBehavior.access$1000(this.this$0);
      } else {
         var3 = BottomSheetBehavior.access$1100(this.this$0);
      }

      return MathUtils.constrain(var2, var4, var3);
   }

   public int getViewVerticalDragRange(View var1) {
      return BottomSheetBehavior.access$800(this.this$0)?BottomSheetBehavior.access$1000(this.this$0) - BottomSheetBehavior.access$700(this.this$0):BottomSheetBehavior.access$1100(this.this$0) - BottomSheetBehavior.access$700(this.this$0);
   }

   public void onViewDragStateChanged(int var1) {
      if(var1 == 1) {
         BottomSheetBehavior.access$600(this.this$0, 1);
      }

   }

   public void onViewPositionChanged(View var1, int var2, int var3, int var4, int var5) {
      BottomSheetBehavior.access$500(this.this$0, var3);
   }

   public void onViewReleased(View var1, float var2, float var3) {
      byte var4;
      int var5;
      if(var3 < 0.0F) {
         var5 = BottomSheetBehavior.access$700(this.this$0);
         var4 = 3;
      } else if(BottomSheetBehavior.access$800(this.this$0) && BottomSheetBehavior.access$900(this.this$0, var1, var3)) {
         var5 = BottomSheetBehavior.access$1000(this.this$0);
         var4 = 5;
      } else if(var3 == 0.0F) {
         int var6 = var1.getTop();
         if(Math.abs(var6 - BottomSheetBehavior.access$700(this.this$0)) < Math.abs(var6 - BottomSheetBehavior.access$1100(this.this$0))) {
            var5 = BottomSheetBehavior.access$700(this.this$0);
            var4 = 3;
         } else {
            var5 = BottomSheetBehavior.access$1100(this.this$0);
            var4 = 4;
         }
      } else {
         var5 = BottomSheetBehavior.access$1100(this.this$0);
         var4 = 4;
      }

      if(BottomSheetBehavior.access$1200(this.this$0).settleCapturedViewAt(var1.getLeft(), var5)) {
         BottomSheetBehavior.access$600(this.this$0, 2);
         ViewCompat.postOnAnimation(var1, new BottomSheetBehavior$SettleRunnable(this.this$0, var1, var4));
      } else {
         BottomSheetBehavior.access$600(this.this$0, var4);
      }
   }

   public boolean tryCaptureView(View var1, int var2) {
      boolean var3 = true;
      if(BottomSheetBehavior.access$000(this.this$0) != 1 && !BottomSheetBehavior.access$100(this.this$0)) {
         if(BottomSheetBehavior.access$000(this.this$0) == 3 && BottomSheetBehavior.access$200(this.this$0) == var2) {
            View var4 = (View)BottomSheetBehavior.access$300(this.this$0).get();
            if(var4 != null && ViewCompat.canScrollVertically(var4, -1)) {
               return false;
            }
         }

         if(BottomSheetBehavior.access$400(this.this$0) == null || BottomSheetBehavior.access$400(this.this$0).get() != var1) {
            var3 = false;
         }

         return var3;
      } else {
         return false;
      }
   }
}
