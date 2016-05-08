package android.support.v7.widget;

import android.support.v7.widget.AppCompatSpinner$DropdownPopup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class AppCompatSpinner$DropdownPopup$2 implements OnGlobalLayoutListener {
   AppCompatSpinner$DropdownPopup$2(AppCompatSpinner$DropdownPopup var1) {
      this.this$1 = var1;
   }

   public void onGlobalLayout() {
      if(!AppCompatSpinner$DropdownPopup.access$600(this.this$1, this.this$1.this$0)) {
         this.this$1.dismiss();
      } else {
         this.this$1.computeContentWidth();
         AppCompatSpinner$DropdownPopup.access$701(this.this$1);
      }
   }
}
