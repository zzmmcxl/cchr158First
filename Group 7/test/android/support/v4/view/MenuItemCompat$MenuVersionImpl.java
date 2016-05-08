package android.support.v4.view;

import android.support.v4.view.MenuItemCompat$OnActionExpandListener;
import android.view.MenuItem;
import android.view.View;

interface MenuItemCompat$MenuVersionImpl {
   boolean collapseActionView(MenuItem var1);

   boolean expandActionView(MenuItem var1);

   View getActionView(MenuItem var1);

   boolean isActionViewExpanded(MenuItem var1);

   MenuItem setActionView(MenuItem var1, int var2);

   MenuItem setActionView(MenuItem var1, View var2);

   MenuItem setOnActionExpandListener(MenuItem var1, MenuItemCompat$OnActionExpandListener var2);

   void setShowAsAction(MenuItem var1, int var2);
}
