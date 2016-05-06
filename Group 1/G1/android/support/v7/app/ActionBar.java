package android.support.v7.app;

import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup$LayoutParams;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.support.annotation.NonNull;
import android.view.ViewGroup$MarginLayoutParams;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import android.support.v7.view.ActionMode;
import android.widget.SpinnerAdapter;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.content.res.Configuration;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;

public abstract class ActionBar
{
    public static final int DISPLAY_HOME_AS_UP = 4;
    public static final int DISPLAY_SHOW_CUSTOM = 16;
    public static final int DISPLAY_SHOW_HOME = 2;
    public static final int DISPLAY_SHOW_TITLE = 8;
    public static final int DISPLAY_USE_LOGO = 1;
    public static final int NAVIGATION_MODE_LIST = 1;
    public static final int NAVIGATION_MODE_STANDARD = 0;
    public static final int NAVIGATION_MODE_TABS = 2;
    
    public ActionBar() {
        super();
    }
    
    public abstract void addOnMenuVisibilityListener(final OnMenuVisibilityListener p0);
    
    public abstract void addTab(final Tab p0);
    
    public abstract void addTab(final Tab p0, final int p1);
    
    public abstract void addTab(final Tab p0, final int p1, final boolean p2);
    
    public abstract void addTab(final Tab p0, final boolean p1);
    
    public boolean collapseActionView() {
        return false;
    }
    
    public void dispatchMenuVisibilityChanged(final boolean b) {
    }
    
    public abstract View getCustomView();
    
    public abstract int getDisplayOptions();
    
    public float getElevation() {
        return 0.0f;
    }
    
    public abstract int getHeight();
    
    public int getHideOffset() {
        return 0;
    }
    
    public abstract int getNavigationItemCount();
    
    public abstract int getNavigationMode();
    
    public abstract int getSelectedNavigationIndex();
    
    @Nullable
    public abstract Tab getSelectedTab();
    
    @Nullable
    public abstract CharSequence getSubtitle();
    
    public abstract Tab getTabAt(final int p0);
    
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
    
    public abstract Tab newTab();
    
    public void onConfigurationChanged(final Configuration configuration) {
    }
    
    void onDestroy() {
    }
    
    public boolean onKeyShortcut(final int n, final KeyEvent keyEvent) {
        return false;
    }
    
    public boolean onMenuKeyEvent(final KeyEvent keyEvent) {
        return false;
    }
    
    public boolean openOptionsMenu() {
        return false;
    }
    
    public abstract void removeAllTabs();
    
    public abstract void removeOnMenuVisibilityListener(final OnMenuVisibilityListener p0);
    
    public abstract void removeTab(final Tab p0);
    
    public abstract void removeTabAt(final int p0);
    
    boolean requestFocus() {
        return false;
    }
    
    public abstract void selectTab(final Tab p0);
    
    public abstract void setBackgroundDrawable(@Nullable final Drawable p0);
    
    public abstract void setCustomView(final int p0);
    
    public abstract void setCustomView(final View p0);
    
    public abstract void setCustomView(final View p0, final LayoutParams p1);
    
    public void setDefaultDisplayHomeAsUpEnabled(final boolean b) {
    }
    
    public abstract void setDisplayHomeAsUpEnabled(final boolean p0);
    
    public abstract void setDisplayOptions(final int p0);
    
    public abstract void setDisplayOptions(final int p0, final int p1);
    
    public abstract void setDisplayShowCustomEnabled(final boolean p0);
    
    public abstract void setDisplayShowHomeEnabled(final boolean p0);
    
    public abstract void setDisplayShowTitleEnabled(final boolean p0);
    
    public abstract void setDisplayUseLogoEnabled(final boolean p0);
    
    public void setElevation(final float n) {
        if (n != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }
    
    public void setHideOffset(final int n) {
        if (n != 0) {
            throw new UnsupportedOperationException("Setting an explicit action bar hide offset is not supported in this action bar configuration.");
        }
    }
    
    public void setHideOnContentScrollEnabled(final boolean b) {
        if (b) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }
    
    public void setHomeActionContentDescription(@StringRes final int n) {
    }
    
    public void setHomeActionContentDescription(@Nullable final CharSequence charSequence) {
    }
    
    public void setHomeAsUpIndicator(@DrawableRes final int n) {
    }
    
    public void setHomeAsUpIndicator(@Nullable final Drawable drawable) {
    }
    
    public void setHomeButtonEnabled(final boolean b) {
    }
    
    public abstract void setIcon(@DrawableRes final int p0);
    
    public abstract void setIcon(final Drawable p0);
    
    public abstract void setListNavigationCallbacks(final SpinnerAdapter p0, final OnNavigationListener p1);
    
    public abstract void setLogo(@DrawableRes final int p0);
    
    public abstract void setLogo(final Drawable p0);
    
    public abstract void setNavigationMode(final int p0);
    
    public abstract void setSelectedNavigationItem(final int p0);
    
    public void setShowHideAnimationEnabled(final boolean b) {
    }
    
    public void setSplitBackgroundDrawable(final Drawable drawable) {
    }
    
    public void setStackedBackgroundDrawable(final Drawable drawable) {
    }
    
    public abstract void setSubtitle(final int p0);
    
    public abstract void setSubtitle(final CharSequence p0);
    
    public abstract void setTitle(@StringRes final int p0);
    
    public abstract void setTitle(final CharSequence p0);
    
    public void setWindowTitle(final CharSequence charSequence) {
    }
    
    public abstract void show();
    
    public ActionMode startActionMode(final ActionMode.Callback callback) {
        return null;
    }
}
