package android.support.v7.widget;

import android.support.v7.widget.AppCompatSpinner$DropdownPopup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow.OnDismissListener;

class AppCompatSpinner$DropdownPopup$3 implements OnDismissListener {
   AppCompatSpinner$DropdownPopup$3(AppCompatSpinner$DropdownPopup var1, OnGlobalLayoutListener var2) {
      this.this$1 = var1;
      this.val$layoutListener = var2;
   }

   public void onDismiss() {
      ViewTreeObserver var1 = this.this$1.this$0.getViewTreeObserver();
      if(var1 != null) {
         var1.removeGlobalOnLayoutListener(this.val$layoutListener);
      }

   }
}
