package android.support.v7.widget;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter$Callback;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionMenuPresenter;

class ActionMenuPresenter$PopupPresenterCallback implements MenuPresenter$Callback {
   private ActionMenuPresenter$PopupPresenterCallback(ActionMenuPresenter var1) {
      this.this$0 = var1;
   }

   public void onCloseMenu(MenuBuilder var1, boolean var2) {
      if(var1 instanceof SubMenuBuilder) {
         ((SubMenuBuilder)var1).getRootMenu().close(false);
      }

      MenuPresenter$Callback var3 = this.this$0.getCallback();
      if(var3 != null) {
         var3.onCloseMenu(var1, var2);
      }

   }

   public boolean onOpenSubMenu(MenuBuilder var1) {
      if(var1 == null) {
         return false;
      } else {
         this.this$0.mOpenSubMenuId = ((SubMenuBuilder)var1).getItem().getItemId();
         MenuPresenter$Callback var3 = this.this$0.getCallback();
         boolean var2;
         if(var3 != null) {
            var2 = var3.onOpenSubMenu(var1);
         } else {
            var2 = false;
         }

         return var2;
      }
   }
}
