package android.support.design.internal;

import android.support.design.internal.NavigationMenuItemView;
import android.support.design.internal.NavigationMenuPresenter;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.View;
import android.view.View.OnClickListener;

class NavigationMenuPresenter$1 implements OnClickListener {
   NavigationMenuPresenter$1(NavigationMenuPresenter var1) {
      this.this$0 = var1;
   }

   public void onClick(View var1) {
      NavigationMenuItemView var3 = (NavigationMenuItemView)var1;
      this.this$0.setUpdateSuspended(true);
      MenuItemImpl var4 = var3.getItemData();
      boolean var2 = NavigationMenuPresenter.access$000(this.this$0).performItemAction(var4, this.this$0, 0);
      if(var4 != null && var4.isCheckable() && var2) {
         NavigationMenuPresenter.access$100(this.this$0).setCheckedItem(var4);
      }

      this.this$0.setUpdateSuspended(false);
      this.this$0.updateMenuView(false);
   }
}
