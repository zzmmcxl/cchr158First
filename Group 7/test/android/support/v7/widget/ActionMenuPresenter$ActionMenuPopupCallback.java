package android.support.v7.widget;

import android.support.v7.view.menu.ActionMenuItemView$PopupCallback;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ListPopupWindow;

class ActionMenuPresenter$ActionMenuPopupCallback extends ActionMenuItemView$PopupCallback {
   private ActionMenuPresenter$ActionMenuPopupCallback(ActionMenuPresenter var1) {
      this.this$0 = var1;
   }

   public ListPopupWindow getPopup() {
      return ActionMenuPresenter.access$800(this.this$0) != null?ActionMenuPresenter.access$800(this.this$0).getPopup():null;
   }
}
