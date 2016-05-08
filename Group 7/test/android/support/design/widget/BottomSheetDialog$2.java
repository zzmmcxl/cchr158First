package android.support.design.widget;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior$BottomSheetCallback;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;

class BottomSheetDialog$2 extends BottomSheetBehavior$BottomSheetCallback {
   BottomSheetDialog$2(BottomSheetDialog var1) {
      this.this$0 = var1;
   }

   public void onSlide(@NonNull View var1, float var2) {
   }

   public void onStateChanged(@NonNull View var1, int var2) {
      if(var2 == 5) {
         this.this$0.dismiss();
      }

   }
}
