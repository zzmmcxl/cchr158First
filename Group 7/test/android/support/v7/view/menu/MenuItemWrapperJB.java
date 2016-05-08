package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.support.v7.view.menu.MenuItemWrapperICS$ActionProviderWrapper;
import android.support.v7.view.menu.MenuItemWrapperJB$ActionProviderWrapperJB;
import android.view.ActionProvider;

@TargetApi(16)
class MenuItemWrapperJB extends MenuItemWrapperICS {
   MenuItemWrapperJB(Context var1, SupportMenuItem var2) {
      super(var1, var2);
   }

   MenuItemWrapperICS$ActionProviderWrapper createActionProviderWrapper(ActionProvider var1) {
      return new MenuItemWrapperJB$ActionProviderWrapperJB(this, this.mContext, var1);
   }
}
