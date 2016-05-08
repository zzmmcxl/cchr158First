package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle$Delegate;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.app.AppCompatDelegateImplBase$1;
import android.support.v7.app.AppCompatDelegateImplBase$ActionBarDrawableToggleImpl;
import android.support.v7.app.AppCompatDelegateImplBase$AppCompatWindowCallbackBase;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode$Callback;
import android.support.v7.view.SupportMenuInflater;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;
import android.view.Window.Callback;

abstract class AppCompatDelegateImplBase extends AppCompatDelegate {
   ActionBar mActionBar;
   final AppCompatCallback mAppCompatCallback;
   final Callback mAppCompatWindowCallback;
   final Context mContext;
   boolean mHasActionBar;
   private boolean mIsDestroyed;
   boolean mIsFloating;
   MenuInflater mMenuInflater;
   final Callback mOriginalWindowCallback;
   boolean mOverlayActionBar;
   boolean mOverlayActionMode;
   boolean mThemeRead;
   private CharSequence mTitle;
   final Window mWindow;
   boolean mWindowNoTitle;

   AppCompatDelegateImplBase(Context var1, Window var2, AppCompatCallback var3) {
      this.mContext = var1;
      this.mWindow = var2;
      this.mAppCompatCallback = var3;
      this.mOriginalWindowCallback = this.mWindow.getCallback();
      if(this.mOriginalWindowCallback instanceof AppCompatDelegateImplBase$AppCompatWindowCallbackBase) {
         throw new IllegalStateException("AppCompat has already installed itself into the Window");
      } else {
         this.mAppCompatWindowCallback = this.wrapWindowCallback(this.mOriginalWindowCallback);
         this.mWindow.setCallback(this.mAppCompatWindowCallback);
      }
   }

   public boolean applyDayNight() {
      return false;
   }

   abstract boolean dispatchKeyEvent(KeyEvent var1);

   final Context getActionBarThemedContext() {
      Context var1 = null;
      ActionBar var2 = this.getSupportActionBar();
      if(var2 != null) {
         var1 = var2.getThemedContext();
      }

      Context var3 = var1;
      if(var1 == null) {
         var3 = this.mContext;
      }

      return var3;
   }

   public final ActionBarDrawerToggle$Delegate getDrawerToggleDelegate() {
      return new AppCompatDelegateImplBase$ActionBarDrawableToggleImpl(this, (AppCompatDelegateImplBase$1)null);
   }

   public MenuInflater getMenuInflater() {
      if(this.mMenuInflater == null) {
         this.initWindowDecorActionBar();
         Context var1;
         if(this.mActionBar != null) {
            var1 = this.mActionBar.getThemedContext();
         } else {
            var1 = this.mContext;
         }

         this.mMenuInflater = new SupportMenuInflater(var1);
      }

      return this.mMenuInflater;
   }

   public ActionBar getSupportActionBar() {
      this.initWindowDecorActionBar();
      return this.mActionBar;
   }

   final CharSequence getTitle() {
      return this.mOriginalWindowCallback instanceof Activity?((Activity)this.mOriginalWindowCallback).getTitle():this.mTitle;
   }

   final Callback getWindowCallback() {
      return this.mWindow.getCallback();
   }

   abstract void initWindowDecorActionBar();

   final boolean isDestroyed() {
      return this.mIsDestroyed;
   }

   public boolean isHandleNativeActionModesEnabled() {
      return false;
   }

   public void onDestroy() {
      this.mIsDestroyed = true;
   }

   abstract boolean onKeyShortcut(int var1, KeyEvent var2);

   abstract boolean onMenuOpened(int var1, Menu var2);

   abstract void onPanelClosed(int var1, Menu var2);

   public void onSaveInstanceState(Bundle var1) {
   }

   abstract void onTitleChanged(CharSequence var1);

   final ActionBar peekSupportActionBar() {
      return this.mActionBar;
   }

   public void setHandleNativeActionModesEnabled(boolean var1) {
   }

   public void setLocalNightMode(int var1) {
   }

   public final void setTitle(CharSequence var1) {
      this.mTitle = var1;
      this.onTitleChanged(var1);
   }

   abstract ActionMode startSupportActionModeFromWindow(ActionMode$Callback var1);

   Callback wrapWindowCallback(Callback var1) {
      return new AppCompatDelegateImplBase$AppCompatWindowCallbackBase(this, var1);
   }
}
