package android.support.design.widget;

import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.view.ViewCompat;
import android.view.View;

class BottomSheetBehavior$SettleRunnable implements Runnable {
   private final int mTargetState;
   private final View mView;

   BottomSheetBehavior$SettleRunnable(BottomSheetBehavior var1, View var2, int var3) {
      this.this$0 = var1;
      this.mView = var2;
      this.mTargetState = var3;
   }

   public void run() {
      if(BottomSheetBehavior.access$1200(this.this$0) != null && BottomSheetBehavior.access$1200(this.this$0).continueSettling(true)) {
         ViewCompat.postOnAnimation(this.mView, this);
      } else {
         BottomSheetBehavior.access$600(this.this$0, this.mTargetState);
      }
   }
}
