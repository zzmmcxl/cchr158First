package android.support.v7.widget;

import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuPresenter$OverflowMenuButton;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow$ForwardingListener;
import android.view.View;

class ActionMenuPresenter$OverflowMenuButton$1 extends ListPopupWindow$ForwardingListener {
   ActionMenuPresenter$OverflowMenuButton$1(ActionMenuPresenter$OverflowMenuButton var1, View var2, ActionMenuPresenter var3) {
      super(var2);
      this.this$1 = var1;
      this.val$this$0 = var3;
   }

   public ListPopupWindow getPopup() {
      return ActionMenuPresenter.access$200(this.this$1.this$0) == null?null:ActionMenuPresenter.access$200(this.this$1.this$0).getPopup();
   }

   public boolean onForwardingStarted() {
      this.this$1.this$0.showOverflowMenu();
      return true;
   }

   public boolean onForwardingStopped() {
      if(ActionMenuPresenter.access$300(this.this$1.this$0) != null) {
         return false;
      } else {
         this.this$1.this$0.hideOverflowMenu();
         return true;
      }
   }
}
