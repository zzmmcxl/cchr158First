package android.support.v7.app;

import android.support.annotation.StringRes;
import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.graphics.drawable.Drawable;

static class ToolbarCompatDelegate implements Delegate
{
    final CharSequence mDefaultContentDescription;
    final Drawable mDefaultUpIndicator;
    final Toolbar mToolbar;
    
    ToolbarCompatDelegate(final Toolbar mToolbar) {
        super();
        this.mToolbar = mToolbar;
        this.mDefaultUpIndicator = mToolbar.getNavigationIcon();
        this.mDefaultContentDescription = mToolbar.getNavigationContentDescription();
    }
    
    @Override
    public Context getActionBarThemedContext() {
        return mToolbar.getContext();
    }
    
    @Override
    public Drawable getThemeUpIndicator() {
        return mDefaultUpIndicator;
    }
    
    @Override
    public boolean isNavigationVisible() {
        return true;
    }
    
    @Override
    public void setActionBarDescription(@StringRes final int navigationContentDescription) {
        if (navigationContentDescription == 0) {
            mToolbar.setNavigationContentDescription(mDefaultContentDescription);
            return;
        }
        mToolbar.setNavigationContentDescription(navigationContentDescription);
    }
    
    @Override
    public void setActionBarUpIndicator(final Drawable navigationIcon, @StringRes final int actionBarDescription) {
        mToolbar.setNavigationIcon(navigationIcon);
        this.setActionBarDescription(actionBarDescription);
    }
}
