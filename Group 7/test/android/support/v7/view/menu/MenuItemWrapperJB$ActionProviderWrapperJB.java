package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.ActionProvider$VisibilityListener;
import android.support.v7.view.menu.MenuItemWrapperICS$ActionProviderWrapper;
import android.support.v7.view.menu.MenuItemWrapperJB;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import android.view.ActionProvider.VisibilityListener;

class MenuItemWrapperJB$ActionProviderWrapperJB extends MenuItemWrapperICS$ActionProviderWrapper implements VisibilityListener {
   ActionProvider$VisibilityListener mListener;

   public MenuItemWrapperJB$ActionProviderWrapperJB(MenuItemWrapperJB var1, Context var2, ActionProvider var3) {
      super(var1, var2, var3);
      this.this$0 = var1;
   }

   public boolean isVisible() {
      return this.mInner.isVisible();
   }

   public void onActionProviderVisibilityChanged(boolean var1) {
      if(this.mListener != null) {
         this.mListener.onActionProviderVisibilityChanged(var1);
      }

   }

   public View onCreateActionView(MenuItem var1) {
      return this.mInner.onCreateActionView(var1);
   }

   public boolean overridesItemVisibility() {
      return this.mInner.overridesItemVisibility();
   }

   public void refreshVisibility() {
      this.mInner.refreshVisibility();
   }

   public void setVisibilityListener(ActionProvider$VisibilityListener var1) {
      this.mListener = var1;
      ActionProvider var2 = this.mInner;
      MenuItemWrapperJB$ActionProviderWrapperJB var3;
      if(var1 != null) {
         var3 = this;
      } else {
         var3 = null;
      }

      var2.setVisibilityListener(var3);
   }
}
