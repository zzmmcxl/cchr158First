package android.support.design.internal;

import android.support.design.internal.NavigationMenuPresenter$NavigationMenuItem;
import android.support.v7.view.menu.MenuItemImpl;

class NavigationMenuPresenter$NavigationMenuTextItem implements NavigationMenuPresenter$NavigationMenuItem {
   private final MenuItemImpl mMenuItem;

   private NavigationMenuPresenter$NavigationMenuTextItem(MenuItemImpl var1) {
      this.mMenuItem = var1;
   }

   public MenuItemImpl getMenuItem() {
      return this.mMenuItem;
   }
}
