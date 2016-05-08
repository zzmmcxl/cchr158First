package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v7.view.menu.BaseMenuWrapper;
import android.support.v7.view.menu.MenuItemWrapperICS$ActionProviderWrapper;
import android.support.v7.view.menu.MenuItemWrapperICS$CollapsibleActionViewWrapper;
import android.support.v7.view.menu.MenuItemWrapperICS$OnActionExpandListenerWrapper;
import android.support.v7.view.menu.MenuItemWrapperICS$OnMenuItemClickListenerWrapper;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import java.lang.reflect.Method;

@TargetApi(14)
public class MenuItemWrapperICS extends BaseMenuWrapper<SupportMenuItem> implements MenuItem {
   static final String LOG_TAG = "MenuItemWrapper";
   private Method mSetExclusiveCheckableMethod;

   MenuItemWrapperICS(Context var1, SupportMenuItem var2) {
      super(var1, var2);
   }

   public boolean collapseActionView() {
      return ((SupportMenuItem)this.mWrappedObject).collapseActionView();
   }

   MenuItemWrapperICS$ActionProviderWrapper createActionProviderWrapper(ActionProvider var1) {
      return new MenuItemWrapperICS$ActionProviderWrapper(this, this.mContext, var1);
   }

   public boolean expandActionView() {
      return ((SupportMenuItem)this.mWrappedObject).expandActionView();
   }

   public ActionProvider getActionProvider() {
      android.support.v4.view.ActionProvider var1 = ((SupportMenuItem)this.mWrappedObject).getSupportActionProvider();
      return var1 instanceof MenuItemWrapperICS$ActionProviderWrapper?((MenuItemWrapperICS$ActionProviderWrapper)var1).mInner:null;
   }

   public View getActionView() {
      View var2 = ((SupportMenuItem)this.mWrappedObject).getActionView();
      View var1 = var2;
      if(var2 instanceof MenuItemWrapperICS$CollapsibleActionViewWrapper) {
         var1 = ((MenuItemWrapperICS$CollapsibleActionViewWrapper)var2).getWrappedView();
      }

      return var1;
   }

   public char getAlphabeticShortcut() {
      return ((SupportMenuItem)this.mWrappedObject).getAlphabeticShortcut();
   }

   public int getGroupId() {
      return ((SupportMenuItem)this.mWrappedObject).getGroupId();
   }

   public Drawable getIcon() {
      return ((SupportMenuItem)this.mWrappedObject).getIcon();
   }

   public Intent getIntent() {
      return ((SupportMenuItem)this.mWrappedObject).getIntent();
   }

   public int getItemId() {
      return ((SupportMenuItem)this.mWrappedObject).getItemId();
   }

   public ContextMenuInfo getMenuInfo() {
      return ((SupportMenuItem)this.mWrappedObject).getMenuInfo();
   }

   public char getNumericShortcut() {
      return ((SupportMenuItem)this.mWrappedObject).getNumericShortcut();
   }

   public int getOrder() {
      return ((SupportMenuItem)this.mWrappedObject).getOrder();
   }

   public SubMenu getSubMenu() {
      return this.getSubMenuWrapper(((SupportMenuItem)this.mWrappedObject).getSubMenu());
   }

   public CharSequence getTitle() {
      return ((SupportMenuItem)this.mWrappedObject).getTitle();
   }

   public CharSequence getTitleCondensed() {
      return ((SupportMenuItem)this.mWrappedObject).getTitleCondensed();
   }

   public boolean hasSubMenu() {
      return ((SupportMenuItem)this.mWrappedObject).hasSubMenu();
   }

   public boolean isActionViewExpanded() {
      return ((SupportMenuItem)this.mWrappedObject).isActionViewExpanded();
   }

   public boolean isCheckable() {
      return ((SupportMenuItem)this.mWrappedObject).isCheckable();
   }

   public boolean isChecked() {
      return ((SupportMenuItem)this.mWrappedObject).isChecked();
   }

   public boolean isEnabled() {
      return ((SupportMenuItem)this.mWrappedObject).isEnabled();
   }

   public boolean isVisible() {
      return ((SupportMenuItem)this.mWrappedObject).isVisible();
   }

   public MenuItem setActionProvider(ActionProvider var1) {
      SupportMenuItem var2 = (SupportMenuItem)this.mWrappedObject;
      MenuItemWrapperICS$ActionProviderWrapper var3;
      if(var1 != null) {
         var3 = this.createActionProviderWrapper(var1);
      } else {
         var3 = null;
      }

      var2.setSupportActionProvider(var3);
      return this;
   }

   public MenuItem setActionView(int var1) {
      ((SupportMenuItem)this.mWrappedObject).setActionView(var1);
      View var2 = ((SupportMenuItem)this.mWrappedObject).getActionView();
      if(var2 instanceof CollapsibleActionView) {
         ((SupportMenuItem)this.mWrappedObject).setActionView(new MenuItemWrapperICS$CollapsibleActionViewWrapper(var2));
      }

      return this;
   }

   public MenuItem setActionView(View var1) {
      Object var2 = var1;
      if(var1 instanceof CollapsibleActionView) {
         var2 = new MenuItemWrapperICS$CollapsibleActionViewWrapper(var1);
      }

      ((SupportMenuItem)this.mWrappedObject).setActionView((View)var2);
      return this;
   }

   public MenuItem setAlphabeticShortcut(char var1) {
      ((SupportMenuItem)this.mWrappedObject).setAlphabeticShortcut(var1);
      return this;
   }

   public MenuItem setCheckable(boolean var1) {
      ((SupportMenuItem)this.mWrappedObject).setCheckable(var1);
      return this;
   }

   public MenuItem setChecked(boolean var1) {
      ((SupportMenuItem)this.mWrappedObject).setChecked(var1);
      return this;
   }

   public MenuItem setEnabled(boolean var1) {
      ((SupportMenuItem)this.mWrappedObject).setEnabled(var1);
      return this;
   }

   public void setExclusiveCheckable(boolean var1) {
      try {
         if(this.mSetExclusiveCheckableMethod == null) {
            this.mSetExclusiveCheckableMethod = ((SupportMenuItem)this.mWrappedObject).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
         }

         this.mSetExclusiveCheckableMethod.invoke(this.mWrappedObject, new Object[]{Boolean.valueOf(var1)});
      } catch (Exception var3) {
         Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", var3);
      }
   }

   public MenuItem setIcon(int var1) {
      ((SupportMenuItem)this.mWrappedObject).setIcon(var1);
      return this;
   }

   public MenuItem setIcon(Drawable var1) {
      ((SupportMenuItem)this.mWrappedObject).setIcon(var1);
      return this;
   }

   public MenuItem setIntent(Intent var1) {
      ((SupportMenuItem)this.mWrappedObject).setIntent(var1);
      return this;
   }

   public MenuItem setNumericShortcut(char var1) {
      ((SupportMenuItem)this.mWrappedObject).setNumericShortcut(var1);
      return this;
   }

   public MenuItem setOnActionExpandListener(OnActionExpandListener var1) {
      SupportMenuItem var2 = (SupportMenuItem)this.mWrappedObject;
      MenuItemWrapperICS$OnActionExpandListenerWrapper var3;
      if(var1 != null) {
         var3 = new MenuItemWrapperICS$OnActionExpandListenerWrapper(this, var1);
      } else {
         var3 = null;
      }

      var2.setSupportOnActionExpandListener(var3);
      return this;
   }

   public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener var1) {
      SupportMenuItem var2 = (SupportMenuItem)this.mWrappedObject;
      MenuItemWrapperICS$OnMenuItemClickListenerWrapper var3;
      if(var1 != null) {
         var3 = new MenuItemWrapperICS$OnMenuItemClickListenerWrapper(this, var1);
      } else {
         var3 = null;
      }

      var2.setOnMenuItemClickListener(var3);
      return this;
   }

   public MenuItem setShortcut(char var1, char var2) {
      ((SupportMenuItem)this.mWrappedObject).setShortcut(var1, var2);
      return this;
   }

   public void setShowAsAction(int var1) {
      ((SupportMenuItem)this.mWrappedObject).setShowAsAction(var1);
   }

   public MenuItem setShowAsActionFlags(int var1) {
      ((SupportMenuItem)this.mWrappedObject).setShowAsActionFlags(var1);
      return this;
   }

   public MenuItem setTitle(int var1) {
      ((SupportMenuItem)this.mWrappedObject).setTitle(var1);
      return this;
   }

   public MenuItem setTitle(CharSequence var1) {
      ((SupportMenuItem)this.mWrappedObject).setTitle(var1);
      return this;
   }

   public MenuItem setTitleCondensed(CharSequence var1) {
      ((SupportMenuItem)this.mWrappedObject).setTitleCondensed(var1);
      return this;
   }

   public MenuItem setVisible(boolean var1) {
      return ((SupportMenuItem)this.mWrappedObject).setVisible(var1);
   }
}
