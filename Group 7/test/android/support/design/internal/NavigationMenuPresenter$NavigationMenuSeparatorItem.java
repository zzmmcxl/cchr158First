package android.support.design.internal;

import android.support.design.internal.NavigationMenuPresenter$NavigationMenuItem;

class NavigationMenuPresenter$NavigationMenuSeparatorItem implements NavigationMenuPresenter$NavigationMenuItem {
   private final int mPaddingBottom;
   private final int mPaddingTop;

   public NavigationMenuPresenter$NavigationMenuSeparatorItem(int var1, int var2) {
      this.mPaddingTop = var1;
      this.mPaddingBottom = var2;
   }

   public int getPaddingBottom() {
      return this.mPaddingBottom;
   }

   public int getPaddingTop() {
      return this.mPaddingTop;
   }
}
