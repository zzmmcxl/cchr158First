package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.R$attr;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionMenuPresenter;
import android.view.MenuItem;
import android.view.View;

class ActionMenuPresenter$ActionButtonSubmenu extends MenuPopupHelper {
   private SubMenuBuilder mSubMenu;

   public ActionMenuPresenter$ActionButtonSubmenu(ActionMenuPresenter var1, Context var2, SubMenuBuilder var3) {
      super(var2, var3, (View)null, false, R$attr.actionOverflowMenuStyle);
      this.this$0 = var1;
      this.mSubMenu = var3;
      if(!((MenuItemImpl)var3.getItem()).isActionButton()) {
         Object var9;
         if(ActionMenuPresenter.access$600(var1) == null) {
            var9 = (View)ActionMenuPresenter.access$700(var1);
         } else {
            var9 = ActionMenuPresenter.access$600(var1);
         }

         this.setAnchorView((View)var9);
      }

      this.setCallback(var1.mPopupPresenterCallback);
      boolean var7 = false;
      int var5 = var3.size();
      int var4 = 0;

      boolean var6;
      while(true) {
         var6 = var7;
         if(var4 >= var5) {
            break;
         }

         MenuItem var8 = var3.getItem(var4);
         if(var8.isVisible() && var8.getIcon() != null) {
            var6 = true;
            break;
         }

         ++var4;
      }

      this.setForceShowIcon(var6);
   }

   public void onDismiss() {
      super.onDismiss();
      ActionMenuPresenter.access$802(this.this$0, (ActionMenuPresenter$ActionButtonSubmenu)null);
      this.this$0.mOpenSubMenuId = 0;
   }
}
