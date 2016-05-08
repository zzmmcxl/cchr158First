package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.R$attr;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.ActionMenuPresenter;
import android.view.View;

class ActionMenuPresenter$OverflowPopup extends MenuPopupHelper {
   public ActionMenuPresenter$OverflowPopup(ActionMenuPresenter var1, Context var2, MenuBuilder var3, View var4, boolean var5) {
      super(var2, var3, var4, var5, R$attr.actionOverflowMenuStyle);
      this.this$0 = var1;
      this.setGravity(8388613);
      this.setCallback(var1.mPopupPresenterCallback);
   }

   public void onDismiss() {
      super.onDismiss();
      if(ActionMenuPresenter.access$400(this.this$0) != null) {
         ActionMenuPresenter.access$500(this.this$0).close();
      }

      ActionMenuPresenter.access$202(this.this$0, (ActionMenuPresenter$OverflowPopup)null);
   }
}
