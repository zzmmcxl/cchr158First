package android.support.v7.app;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.graphics.drawable.Drawable;
import android.app.ActionBar;
import android.content.Context;
import android.app.Activity;

private static class JellybeanMr2Delegate implements Delegate
{
    final Activity mActivity;
    
    private JellybeanMr2Delegate(final Activity mActivity) {
        super();
        this.mActivity = mActivity;
    }
    
    JellybeanMr2Delegate(final Activity activity, final ActionBarDrawerToggle$1 view$OnClickListener) {
        this(activity);
    }
    
    @Override
    public Context getActionBarThemedContext() {
        final ActionBar actionBar = mActivity.getActionBar();
        if (actionBar != null) {
            return actionBar.getThemedContext();
        }
        return (Context)mActivity;
    }
    
    @Override
    public Drawable getThemeUpIndicator() {
        final TypedArray obtainStyledAttributes = this.getActionBarThemedContext().obtainStyledAttributes((AttributeSet)null, new int[] { 16843531 }, 16843470, 0);
        final Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }
    
    @Override
    public boolean isNavigationVisible() {
        final ActionBar actionBar = mActivity.getActionBar();
        return actionBar != null && (0x4 & actionBar.getDisplayOptions()) != 0x0;
    }
    
    @Override
    public void setActionBarDescription(final int homeActionContentDescription) {
        final ActionBar actionBar = mActivity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(homeActionContentDescription);
        }
    }
    
    @Override
    public void setActionBarUpIndicator(final Drawable homeAsUpIndicator, final int homeActionContentDescription) {
        final ActionBar actionBar = mActivity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(homeAsUpIndicator);
            actionBar.setHomeActionContentDescription(homeActionContentDescription);
        }
    }
}
