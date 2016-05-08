package android.support.v7.widget;

import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatSpinner$DropdownPopup;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow$ForwardingListener;
import android.view.View;

class AppCompatSpinner$1 extends ListPopupWindow$ForwardingListener {
   AppCompatSpinner$1(AppCompatSpinner var1, View var2, AppCompatSpinner$DropdownPopup var3) {
      super(var2);
      this.this$0 = var1;
      this.val$popup = var3;
   }

   public ListPopupWindow getPopup() {
      return this.val$popup;
   }

   public boolean onForwardingStarted() {
      if(!AppCompatSpinner.access$000(this.this$0).isShowing()) {
         AppCompatSpinner.access$000(this.this$0).show();
      }

      return true;
   }
}
