package android.support.v7.internal.app;

import android.support.v7.app.ActionBar;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.View;

class NavItemSelectedListener implements AdapterViewCompat.OnItemSelectedListener {
   private final ActionBar.OnNavigationListener mListener;

   public NavItemSelectedListener(ActionBar.OnNavigationListener var1) {
      this.mListener = var1;
   }

   public void onItemSelected(AdapterViewCompat var1, View var2, int var3, long var4) {
      if(this.mListener != null) {
         this.mListener.onNavigationItemSelected(var3, var4);
      }

   }

   public void onNothingSelected(AdapterViewCompat var1) {
   }
}
