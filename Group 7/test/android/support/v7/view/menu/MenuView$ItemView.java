package android.support.v7.view.menu;

import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.MenuItemImpl;

public interface MenuView$ItemView {
   MenuItemImpl getItemData();

   void initialize(MenuItemImpl var1, int var2);

   boolean prefersCondensedTitle();

   void setCheckable(boolean var1);

   void setChecked(boolean var1);

   void setEnabled(boolean var1);

   void setIcon(Drawable var1);

   void setShortcut(boolean var1, char var2);

   void setTitle(CharSequence var1);

   boolean showsIcon();
}