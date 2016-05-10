package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggleHoneycomb;
import android.support.v7.app.DrawerArrowDrawable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
   private final ActionBarDrawerToggle.Delegate mActivityImpl;
   private final int mCloseDrawerContentDescRes;
   private boolean mDrawerIndicatorEnabled;
   private final DrawerLayout mDrawerLayout;
   private boolean mHasCustomUpIndicator;
   private Drawable mHomeAsUpIndicator;
   private final int mOpenDrawerContentDescRes;
   private ActionBarDrawerToggle.DrawerToggle mSlider;
   private OnClickListener mToolbarNavigationClickListener;
   private boolean mWarnedForDisplayHomeAsUp;

   public ActionBarDrawerToggle(Activity var1, DrawerLayout var2, @StringRes int var3, @StringRes int var4) {
      this(var1, (Toolbar)null, var2, (Drawable)null, var3, var4);
   }

   public ActionBarDrawerToggle(Activity var1, DrawerLayout var2, Toolbar var3, @StringRes int var4, @StringRes int var5) {
      this(var1, var3, var2, (Drawable)null, var4, var5);
   }

   ActionBarDrawerToggle(Activity var1, Toolbar var2, DrawerLayout var3, Drawable var4, @StringRes int var5, @StringRes int var6) {
      this.mDrawerIndicatorEnabled = true;
      this.mWarnedForDisplayHomeAsUp = false;
      if(var2 != null) {
         this.mActivityImpl = new ActionBarDrawerToggle.ToolbarCompatDelegate(var2);
         var2.setNavigationOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
               if(ActionBarDrawerToggle.this.mDrawerIndicatorEnabled) {
                  ActionBarDrawerToggle.this.toggle();
               } else if(ActionBarDrawerToggle.this.mToolbarNavigationClickListener != null) {
                  ActionBarDrawerToggle.this.mToolbarNavigationClickListener.onClick(var1);
                  return;
               }

            }
         });
      } else if(var1 instanceof ActionBarDrawerToggle.DelegateProvider) {
         this.mActivityImpl = ((ActionBarDrawerToggle.DelegateProvider)var1).getDrawerToggleDelegate();
      } else if(VERSION.SDK_INT >= 18) {
         this.mActivityImpl = new ActionBarDrawerToggle.JellybeanMr2Delegate(var1, null);
      } else if(VERSION.SDK_INT >= 11) {
         this.mActivityImpl = new ActionBarDrawerToggle.HoneycombDelegate(var1, null);
      } else {
         this.mActivityImpl = new ActionBarDrawerToggle.DummyDelegate(var1);
      }

      this.mDrawerLayout = var3;
      this.mOpenDrawerContentDescRes = var5;
      this.mCloseDrawerContentDescRes = var6;
      if(var4 == null) {
         this.mSlider = new ActionBarDrawerToggle.DrawerArrowDrawableToggle(var1, this.mActivityImpl.getActionBarThemedContext());
      } else {
         this.mSlider = (ActionBarDrawerToggle.DrawerToggle)var4;
      }

      this.mHomeAsUpIndicator = this.getThemeUpIndicator();
   }

   private void toggle() {
      if(this.mDrawerLayout.isDrawerVisible(8388611)) {
         this.mDrawerLayout.closeDrawer(8388611);
      } else {
         this.mDrawerLayout.openDrawer(8388611);
      }
   }

   Drawable getThemeUpIndicator() {
      return this.mActivityImpl.getThemeUpIndicator();
   }

   public OnClickListener getToolbarNavigationClickListener() {
      return this.mToolbarNavigationClickListener;
   }

   public boolean isDrawerIndicatorEnabled() {
      return this.mDrawerIndicatorEnabled;
   }

   public void onConfigurationChanged(Configuration var1) {
      if(!this.mHasCustomUpIndicator) {
         this.mHomeAsUpIndicator = this.getThemeUpIndicator();
      }

      this.syncState();
   }

   public void onDrawerClosed(View var1) {
      this.mSlider.setPosition(0.0F);
      if(this.mDrawerIndicatorEnabled) {
         this.setActionBarDescription(this.mOpenDrawerContentDescRes);
      }

   }

   public void onDrawerOpened(View var1) {
      this.mSlider.setPosition(1.0F);
      if(this.mDrawerIndicatorEnabled) {
         this.setActionBarDescription(this.mCloseDrawerContentDescRes);
      }

   }

   public void onDrawerSlide(View var1, float var2) {
      this.mSlider.setPosition(Math.min(1.0F, Math.max(0.0F, var2)));
   }

   public void onDrawerStateChanged(int var1) {
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      if(var1 != null && var1.getItemId() == 16908332 && this.mDrawerIndicatorEnabled) {
         this.toggle();
         return true;
      } else {
         return false;
      }
   }

   void setActionBarDescription(int var1) {
      this.mActivityImpl.setActionBarDescription(var1);
   }

   void setActionBarUpIndicator(Drawable var1, int var2) {
      if(!this.mWarnedForDisplayHomeAsUp && !this.mActivityImpl.isNavigationVisible()) {
         Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
         this.mWarnedForDisplayHomeAsUp = true;
      }

      this.mActivityImpl.setActionBarUpIndicator(var1, var2);
   }

   public void setDrawerIndicatorEnabled(boolean var1) {
      if(var1 != this.mDrawerIndicatorEnabled) {
         if(var1) {
            Drawable var3 = (Drawable)this.mSlider;
            int var2;
            if(this.mDrawerLayout.isDrawerOpen(8388611)) {
               var2 = this.mCloseDrawerContentDescRes;
            } else {
               var2 = this.mOpenDrawerContentDescRes;
            }

            this.setActionBarUpIndicator(var3, var2);
         } else {
            this.setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
         }

         this.mDrawerIndicatorEnabled = var1;
      }

   }

   public void setHomeAsUpIndicator(int var1) {
      Drawable var2 = null;
      if(var1 != 0) {
         var2 = this.mDrawerLayout.getResources().getDrawable(var1);
      }

      this.setHomeAsUpIndicator(var2);
   }

   public void setHomeAsUpIndicator(Drawable var1) {
      if(var1 == null) {
         this.mHomeAsUpIndicator = this.getThemeUpIndicator();
         this.mHasCustomUpIndicator = false;
      } else {
         this.mHomeAsUpIndicator = var1;
         this.mHasCustomUpIndicator = true;
      }

      if(!this.mDrawerIndicatorEnabled) {
         this.setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
      }

   }

   public void setToolbarNavigationClickListener(OnClickListener var1) {
      this.mToolbarNavigationClickListener = var1;
   }

   public void syncState() {
      if(this.mDrawerLayout.isDrawerOpen(8388611)) {
         this.mSlider.setPosition(1.0F);
      } else {
         this.mSlider.setPosition(0.0F);
      }

      if(this.mDrawerIndicatorEnabled) {
         Drawable var2 = (Drawable)this.mSlider;
         int var1;
         if(this.mDrawerLayout.isDrawerOpen(8388611)) {
            var1 = this.mCloseDrawerContentDescRes;
         } else {
            var1 = this.mOpenDrawerContentDescRes;
         }

         this.setActionBarUpIndicator(var2, var1);
      }

   }

   public interface Delegate {
      Context getActionBarThemedContext();

      Drawable getThemeUpIndicator();

      boolean isNavigationVisible();

      void setActionBarDescription(@StringRes int var1);

      void setActionBarUpIndicator(Drawable var1, @StringRes int var2);
   }

   public interface DelegateProvider {
      @Nullable
      ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();
   }

   static class DrawerArrowDrawableToggle extends DrawerArrowDrawable implements ActionBarDrawerToggle.DrawerToggle {
      private final Activity mActivity;

      public DrawerArrowDrawableToggle(Activity var1, Context var2) {
         super(var2);
         this.mActivity = var1;
      }

      public float getPosition() {
         return super.getProgress();
      }

      boolean isLayoutRtl() {
         return ViewCompat.getLayoutDirection(this.mActivity.getWindow().getDecorView()) == 1;
      }

      public void setPosition(float var1) {
         if(var1 == 1.0F) {
            this.setVerticalMirror(true);
         } else if(var1 == 0.0F) {
            this.setVerticalMirror(false);
         }

         super.setProgress(var1);
      }
   }

   interface DrawerToggle {
      float getPosition();

      void setPosition(float var1);
   }

   static class DummyDelegate implements ActionBarDrawerToggle.Delegate {
      final Activity mActivity;

      DummyDelegate(Activity var1) {
         this.mActivity = var1;
      }

      public Context getActionBarThemedContext() {
         return this.mActivity;
      }

      public Drawable getThemeUpIndicator() {
         return null;
      }

      public boolean isNavigationVisible() {
         return true;
      }

      public void setActionBarDescription(@StringRes int var1) {
      }

      public void setActionBarUpIndicator(Drawable var1, @StringRes int var2) {
      }
   }

   private static class HoneycombDelegate implements ActionBarDrawerToggle.Delegate {
      final Activity mActivity;
      ActionBarDrawerToggleHoneycomb.SetIndicatorInfo mSetIndicatorInfo;

      private HoneycombDelegate(Activity var1) {
         this.mActivity = var1;
      }

      // $FF: synthetic method
      HoneycombDelegate(Activity var1, Object var2) {
         this(var1);
      }

      public Context getActionBarThemedContext() {
         android.app.ActionBar var1 = this.mActivity.getActionBar();
         return (Context)(var1 != null?var1.getThemedContext():this.mActivity);
      }

      public Drawable getThemeUpIndicator() {
         return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(this.mActivity);
      }

      public boolean isNavigationVisible() {
         android.app.ActionBar var1 = this.mActivity.getActionBar();
         return var1 != null && (var1.getDisplayOptions() & 4) != 0;
      }

      public void setActionBarDescription(int var1) {
         this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, var1);
      }

      public void setActionBarUpIndicator(Drawable var1, int var2) {
         this.mActivity.getActionBar().setDisplayShowHomeEnabled(true);
         this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(this.mSetIndicatorInfo, this.mActivity, var1, var2);
         this.mActivity.getActionBar().setDisplayShowHomeEnabled(false);
      }
   }

   private static class JellybeanMr2Delegate implements ActionBarDrawerToggle.Delegate {
      final Activity mActivity;

      private JellybeanMr2Delegate(Activity var1) {
         this.mActivity = var1;
      }

      // $FF: synthetic method
      JellybeanMr2Delegate(Activity var1, Object var2) {
         this(var1);
      }

      public Context getActionBarThemedContext() {
         android.app.ActionBar var1 = this.mActivity.getActionBar();
         return (Context)(var1 != null?var1.getThemedContext():this.mActivity);
      }

      public Drawable getThemeUpIndicator() {
         TypedArray var1 = this.getActionBarThemedContext().obtainStyledAttributes((AttributeSet)null, new int[]{16843531}, 16843470, 0);
         Drawable var2 = var1.getDrawable(0);
         var1.recycle();
         return var2;
      }

      public boolean isNavigationVisible() {
         android.app.ActionBar var1 = this.mActivity.getActionBar();
         return var1 != null && (var1.getDisplayOptions() & 4) != 0;
      }

      public void setActionBarDescription(int var1) {
         android.app.ActionBar var2 = this.mActivity.getActionBar();
         if(var2 != null) {
            var2.setHomeActionContentDescription(var1);
         }

      }

      public void setActionBarUpIndicator(Drawable var1, int var2) {
         android.app.ActionBar var3 = this.mActivity.getActionBar();
         if(var3 != null) {
            var3.setHomeAsUpIndicator(var1);
            var3.setHomeActionContentDescription(var2);
         }

      }
   }

   static class ToolbarCompatDelegate implements ActionBarDrawerToggle.Delegate {
      final CharSequence mDefaultContentDescription;
      final Drawable mDefaultUpIndicator;
      final Toolbar mToolbar;

      ToolbarCompatDelegate(Toolbar var1) {
         this.mToolbar = var1;
         this.mDefaultUpIndicator = var1.getNavigationIcon();
         this.mDefaultContentDescription = var1.getNavigationContentDescription();
      }

      public Context getActionBarThemedContext() {
         return this.mToolbar.getContext();
      }

      public Drawable getThemeUpIndicator() {
         return this.mDefaultUpIndicator;
      }

      public boolean isNavigationVisible() {
         return true;
      }

      public void setActionBarDescription(@StringRes int var1) {
         if(var1 == 0) {
            this.mToolbar.setNavigationContentDescription(this.mDefaultContentDescription);
         } else {
            this.mToolbar.setNavigationContentDescription(var1);
         }
      }

      public void setActionBarUpIndicator(Drawable var1, @StringRes int var2) {
         this.mToolbar.setNavigationIcon(var1);
         this.setActionBarDescription(var2);
      }
   }
}
