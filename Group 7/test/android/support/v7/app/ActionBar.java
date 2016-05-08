package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar$LayoutParams;
import android.support.v7.app.ActionBar$OnMenuVisibilityListener;
import android.support.v7.app.ActionBar$OnNavigationListener;
import android.support.v7.app.ActionBar$Tab;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode$Callback;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SpinnerAdapter;

public abstract class ActionBar {
   public static final int DISPLAY_HOME_AS_UP = 4;
   public static final int DISPLAY_SHOW_CUSTOM = 16;
   public static final int DISPLAY_SHOW_HOME = 2;
   public static final int DISPLAY_SHOW_TITLE = 8;
   public static final int DISPLAY_USE_LOGO = 1;
   public static final int NAVIGATION_MODE_LIST = 1;
   public static final int NAVIGATION_MODE_STANDARD = 0;
   public static final int NAVIGATION_MODE_TABS = 2;

   public abstract void addOnMenuVisibilityListener(ActionBar$OnMenuVisibilityListener var1);

   public abstract void addTab(ActionBar$Tab var1);

   public abstract void addTab(ActionBar$Tab var1, int var2);

   public abstract void addTab(ActionBar$Tab var1, int var2, boolean var3);

   public abstract void addTab(ActionBar$Tab var1, boolean var2);

   public boolean collapseActionView() {
      return false;
   }

   public void dispatchMenuVisibilityChanged(boolean var1) {
   }

   public abstract View getCustomView();

   public abstract int getDisplayOptions();

   public float getElevation() {
      return 0.0F;
   }

   public abstract int getHeight();

   public int getHideOffset() {
      return 0;
   }

   public abstract int getNavigationItemCount();

   public abstract int getNavigationMode();

   public abstract int getSelectedNavigationIndex();

   @Nullable
   public abstract ActionBar$Tab getSelectedTab();

   @Nullable
   public abstract CharSequence getSubtitle();

   public abstract ActionBar$Tab getTabAt(int var1);

   public abstract int getTabCount();

   public Context getThemedContext() {
      return null;
   }

   @Nullable
   public abstract CharSequence getTitle();

   public abstract void hide();

   public boolean invalidateOptionsMenu() {
      return false;
   }

   public boolean isHideOnContentScrollEnabled() {
      return false;
   }

   public abstract boolean isShowing();

   public boolean isTitleTruncated() {
      return false;
   }

   public abstract ActionBar$Tab newTab();

   public void onConfigurationChanged(Configuration var1) {
   }

   void onDestroy() {
   }

   public boolean onKeyShortcut(int var1, KeyEvent var2) {
      return false;
   }

   public boolean onMenuKeyEvent(KeyEvent var1) {
      return false;
   }

   public boolean openOptionsMenu() {
      return false;
   }

   public abstract void removeAllTabs();

   public abstract void removeOnMenuVisibilityListener(ActionBar$OnMenuVisibilityListener var1);

   public abstract void removeTab(ActionBar$Tab var1);

   public abstract void removeTabAt(int var1);

   boolean requestFocus() {
      return false;
   }

   public abstract void selectTab(ActionBar$Tab var1);

   public abstract void setBackgroundDrawable(@Nullable Drawable var1);

   public abstract void setCustomView(int var1);

   public abstract void setCustomView(View var1);

   public abstract void setCustomView(View var1, ActionBar$LayoutParams var2);

   public void setDefaultDisplayHomeAsUpEnabled(boolean var1) {
   }

   public abstract void setDisplayHomeAsUpEnabled(boolean var1);

   public abstract void setDisplayOptions(int var1);

   public abstract void setDisplayOptions(int var1, int var2);

   public abstract void setDisplayShowCustomEnabled(boolean var1);

   public abstract void setDisplayShowHomeEnabled(boolean var1);

   public abstract void setDisplayShowTitleEnabled(boolean var1);

   public abstract void setDisplayUseLogoEnabled(boolean var1);

   public void setElevation(float var1) {
      if(var1 != 0.0F) {
         throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
      }
   }

   public void setHideOffset(int var1) {
      if(var1 != 0) {
         throw new UnsupportedOperationException("Setting an explicit action bar hide offset is not supported in this action bar configuration.");
      }
   }

   public void setHideOnContentScrollEnabled(boolean var1) {
      if(var1) {
         throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
      }
   }

   public void setHomeActionContentDescription(@StringRes int var1) {
   }

   public void setHomeActionContentDescription(@Nullable CharSequence var1) {
   }

   public void setHomeAsUpIndicator(@DrawableRes int var1) {
   }

   public void setHomeAsUpIndicator(@Nullable Drawable var1) {
   }

   public void setHomeButtonEnabled(boolean var1) {
   }

   public abstract void setIcon(@DrawableRes int var1);

   public abstract void setIcon(Drawable var1);

   public abstract void setListNavigationCallbacks(SpinnerAdapter var1, ActionBar$OnNavigationListener var2);

   public abstract void setLogo(@DrawableRes int var1);

   public abstract void setLogo(Drawable var1);

   public abstract void setNavigationMode(int var1);

   public abstract void setSelectedNavigationItem(int var1);

   public void setShowHideAnimationEnabled(boolean var1) {
   }

   public void setSplitBackgroundDrawable(Drawable var1) {
   }

   public void setStackedBackgroundDrawable(Drawable var1) {
   }

   public abstract void setSubtitle(int var1);

   public abstract void setSubtitle(CharSequence var1);

   public abstract void setTitle(@StringRes int var1);

   public abstract void setTitle(CharSequence var1);

   public void setWindowTitle(CharSequence var1) {
   }

   public abstract void show();

   public ActionMode startActionMode(ActionMode$Callback var1) {
      return null;
   }
}
