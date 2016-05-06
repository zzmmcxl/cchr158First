package android.support.v7.app;

import android.graphics.drawable.Drawable;
import android.app.ActionBar;
import android.content.Context;
import android.app.Activity;

private static class HoneycombDelegate implements Delegate
{
    final Activity mActivity;
    ActionBarDrawerToggleHoneycomb.SetIndicatorInfo mSetIndicatorInfo;
    
    private HoneycombDelegate(final Activity mActivity) {
        super();
        this.mActivity = mActivity;
    }
    
    HoneycombDelegate(final Activity activity, final ActionBarDrawerToggle$1 view$OnClickListener) {
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
        return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(mActivity);
    }
    
    @Override
    public boolean isNavigationVisible() {
        final ActionBar actionBar = mActivity.getActionBar();
        return actionBar != null && (0x4 & actionBar.getDisplayOptions()) != 0x0;
    }
    
    @Override
    public void setActionBarDescription(final int n) {
        mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarDescription(mSetIndicatorInfo, mActivity, n);
    }
    
    @Override
    public void setActionBarUpIndicator(final Drawable drawable, final int n) {
        mActivity.getActionBar().setDisplayShowHomeEnabled(true);
        mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(mSetIndicatorInfo, mActivity, drawable, n);
        mActivity.getActionBar().setDisplayShowHomeEnabled(false);
    }
}
