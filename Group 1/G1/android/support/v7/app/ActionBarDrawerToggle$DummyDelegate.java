package android.support.v7.app;

import android.support.annotation.StringRes;
import android.graphics.drawable.Drawable;
import android.content.Context;
import android.app.Activity;

static class DummyDelegate implements Delegate
{
    final Activity mActivity;
    
    DummyDelegate(final Activity mActivity) {
        super();
        this.mActivity = mActivity;
    }
    
    @Override
    public Context getActionBarThemedContext() {
        return (Context)mActivity;
    }
    
    @Override
    public Drawable getThemeUpIndicator() {
        return null;
    }
    
    @Override
    public boolean isNavigationVisible() {
        return true;
    }
    
    @Override
    public void setActionBarDescription(@StringRes final int n) {
    }
    
    @Override
    public void setActionBarUpIndicator(final Drawable drawable, @StringRes final int n) {
    }
}
