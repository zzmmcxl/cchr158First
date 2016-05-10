package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.appcompat.R;
import android.support.v7.internal.app.WindowDecorActionBar;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.WindowCallbackWrapper;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.widget.TintTypedArray;
import android.support.v7.view.ActionMode;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

abstract class AppCompatDelegateImplBase extends AppCompatDelegate {
   private ActionBar mActionBar;
   final AppCompatCallback mAppCompatCallback;
   final Callback mAppCompatWindowCallback;
   final Context mContext;
   boolean mHasActionBar;
   private boolean mIsDestroyed;
   boolean mIsFloating;
   private MenuInflater mMenuInflater;
   final Callback mOriginalWindowCallback;
   boolean mOverlayActionBar;
   boolean mOverlayActionMode;
   private CharSequence mTitle;
   final Window mWindow;
   boolean mWindowNoTitle;

   AppCompatDelegateImplBase(Context var1, Window var2, AppCompatCallback var3) {
      this.mContext = var1;
      this.mWindow = var2;
      this.mAppCompatCallback = var3;
      this.mOriginalWindowCallback = this.mWindow.getCallback();
      if(this.mOriginalWindowCallback instanceof AppCompatDelegateImplBase.AppCompatWindowCallbackBase) {
         throw new IllegalStateException("AppCompat has already installed itself into the Window");
      } else {
         this.mAppCompatWindowCallback = this.wrapWindowCallback(this.mOriginalWindowCallback);
         this.mWindow.setCallback(this.mAppCompatWindowCallback);
      }
   }

   abstract ActionBar createSupportActionBar();

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

   public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
      return new AppCompatDelegateImplBase.ActionBarDrawableToggleImpl();
   }

   public MenuInflater getMenuInflater() {
      if(this.mMenuInflater == null) {
         this.mMenuInflater = new SupportMenuInflater(this.getActionBarThemedContext());
      }

      return this.mMenuInflater;
   }

   public ActionBar getSupportActionBar() {
      if(this.mHasActionBar) {
         if(this.mActionBar == null) {
            this.mActionBar = this.createSupportActionBar();
         }
      } else if(this.mActionBar instanceof WindowDecorActionBar) {
         this.mActionBar = null;
      }

      return this.mActionBar;
   }

   final CharSequence getTitle() {
      return this.mOriginalWindowCallback instanceof Activity?((Activity)this.mOriginalWindowCallback).getTitle():this.mTitle;
   }

   final Callback getWindowCallback() {
      return this.mWindow.getCallback();
   }

   final boolean isDestroyed() {
      return this.mIsDestroyed;
   }

   public boolean isHandleNativeActionModesEnabled() {
      return false;
   }

   public void onCreate(Bundle var1) {
      TypedArray var2 = this.mContext.obtainStyledAttributes(R.styleable.Theme);
      if(!var2.hasValue(R.styleable.Theme_windowActionBar)) {
         var2.recycle();
         throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
      } else {
         if(var2.getBoolean(R.styleable.Theme_windowActionBar, false)) {
            this.mHasActionBar = true;
         }

         if(var2.getBoolean(R.styleable.Theme_windowActionBarOverlay, false)) {
            this.mOverlayActionBar = true;
         }

         if(var2.getBoolean(R.styleable.Theme_windowActionModeOverlay, false)) {
            this.mOverlayActionMode = true;
         }

         this.mIsFloating = var2.getBoolean(R.styleable.Theme_android_windowIsFloating, false);
         this.mWindowNoTitle = var2.getBoolean(R.styleable.Theme_windowNoTitle, false);
         var2.recycle();
      }
   }

   public final void onDestroy() {
      this.mIsDestroyed = true;
   }

   abstract boolean onKeyShortcut(int var1, KeyEvent var2);

   abstract boolean onMenuOpened(int var1, Menu var2);

   abstract boolean onPanelClosed(int var1, Menu var2);

   abstract void onTitleChanged(CharSequence var1);

   final ActionBar peekSupportActionBar() {
      return this.mActionBar;
   }

   public void setHandleNativeActionModesEnabled(boolean var1) {
   }

   final void setSupportActionBar(ActionBar var1) {
      this.mActionBar = var1;
   }

   public final void setTitle(CharSequence var1) {
      this.mTitle = var1;
      this.onTitleChanged(var1);
   }

   abstract ActionMode startSupportActionModeFromWindow(ActionMode.Callback var1);

   Callback wrapWindowCallback(Callback var1) {
      return new AppCompatDelegateImplBase.AppCompatWindowCallbackBase(var1);
   }

   private class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
      private ActionBarDrawableToggleImpl() {
      }

      // $FF: synthetic method
      ActionBarDrawableToggleImpl(Object var2) {
         this();
      }

      public Context getActionBarThemedContext() {
         return AppCompatDelegateImplBase.this.getActionBarThemedContext();
      }

      public Drawable getThemeUpIndicator() {
         TintTypedArray var1 = TintTypedArray.obtainStyledAttributes(this.getActionBarThemedContext(), (AttributeSet)null, new int[]{R.attr.homeAsUpIndicator});
         Drawable var2 = var1.getDrawable(0);
         var1.recycle();
         return var2;
      }

      public boolean isNavigationVisible() {
         ActionBar var1 = AppCompatDelegateImplBase.this.getSupportActionBar();
         return var1 != null && (var1.getDisplayOptions() & 4) != 0;
      }

      public void setActionBarDescription(int var1) {
         ActionBar var2 = AppCompatDelegateImplBase.this.getSupportActionBar();
         if(var2 != null) {
            var2.setHomeActionContentDescription(var1);
         }

      }

      public void setActionBarUpIndicator(Drawable var1, int var2) {
         ActionBar var3 = AppCompatDelegateImplBase.this.getSupportActionBar();
         if(var3 != null) {
            var3.setHomeAsUpIndicator(var1);
            var3.setHomeActionContentDescription(var2);
         }

      }
   }

   class AppCompatWindowCallbackBase extends WindowCallbackWrapper {
      AppCompatWindowCallbackBase(Callback var2) {
         super(var2);
      }

      public boolean dispatchKeyEvent(KeyEvent var1) {
         return AppCompatDelegateImplBase.this.dispatchKeyEvent(var1)?true:super.dispatchKeyEvent(var1);
      }

      public boolean dispatchKeyShortcutEvent(KeyEvent var1) {
         return AppCompatDelegateImplBase.this.onKeyShortcut(var1.getKeyCode(), var1)?true:super.dispatchKeyShortcutEvent(var1);
      }

      public void onContentChanged() {
      }

      public boolean onCreatePanelMenu(int var1, Menu var2) {
         return var1 == 0 && !(var2 instanceof MenuBuilder)?false:super.onCreatePanelMenu(var1, var2);
      }

      public boolean onMenuOpened(int var1, Menu var2) {
         return AppCompatDelegateImplBase.this.onMenuOpened(var1, var2)?true:super.onMenuOpened(var1, var2);
      }

      public void onPanelClosed(int var1, Menu var2) {
         if(!AppCompatDelegateImplBase.this.onPanelClosed(var1, var2)) {
            super.onPanelClosed(var1, var2);
         }
      }

      public boolean onPreparePanel(int var1, View var2, Menu var3) {
         MenuBuilder var6;
         if(var3 instanceof MenuBuilder) {
            var6 = (MenuBuilder)var3;
         } else {
            var6 = null;
         }

         boolean var4;
         if(var1 == 0 && var6 == null) {
            var4 = false;
         } else {
            if(var6 != null) {
               var6.setOverrideVisibleItems(true);
            }

            boolean var5 = super.onPreparePanel(var1, var2, var3);
            var4 = var5;
            if(var6 != null) {
               var6.setOverrideVisibleItems(false);
               return var5;
            }
         }

         return var4;
      }
   }
}
