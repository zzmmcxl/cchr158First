package android.support.v7.app;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.app.ActionBar;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.support.annotation.Nullable;
import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.content.res.Configuration;
import android.os.Build$VERSION;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.support.annotation.StringRes;
import android.app.Activity;
import android.view.View$OnClickListener;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.DrawerLayout;

public class ActionBarDrawerToggle implements DrawerListener
{
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private DrawerToggle mSlider;
    private View$OnClickListener mToolbarNavigationClickListener;
    private boolean mWarnedForDisplayHomeAsUp;
    
    public ActionBarDrawerToggle(final Activity activity, final DrawerLayout drawerLayout, @StringRes final int n, @StringRes final int n2) {
        this(activity, null, drawerLayout, (Drawable)null, n, n2);
    }
    
    public ActionBarDrawerToggle(final Activity activity, final DrawerLayout drawerLayout, final Toolbar toolbar, @StringRes final int n, @StringRes final int n2) {
        this(activity, toolbar, drawerLayout, (Drawable)null, n, n2);
    }
    
    ActionBarDrawerToggle(final Activity activity, final Toolbar toolbar, final DrawerLayout mDrawerLayout, final T t, @StringRes final int mOpenDrawerContentDescRes, @StringRes final int mCloseDrawerContentDescRes) {
        super();
        mDrawerIndicatorEnabled = true;
        mWarnedForDisplayHomeAsUp = false;
        if (toolbar != null) {
            mActivityImpl = (Delegate)new ToolbarCompatDelegate(toolbar);
            toolbar.setNavigationOnClickListener((View$OnClickListener)new View$OnClickListener() {
                final /* synthetic */ ActionBarDrawerToggle this$0;
                
                ActionBarDrawerToggle$1() {
                    this$0 = this$0;
                    super();
                }
                
                public void onClick(final View view) {
                    if (mDrawerIndicatorEnabled) {
                        this$0.toggle();
                    }
                    else if (mToolbarNavigationClickListener != null) {
                        mToolbarNavigationClickListener.onClick(view);
                    }
                }
            });
        }
        else if (activity instanceof DelegateProvider) {
            mActivityImpl = ((DelegateProvider)activity).getDrawerToggleDelegate();
        }
        else if (Build$VERSION.SDK_INT >= 18) {
            mActivityImpl = (Delegate)new JellybeanMr2Delegate(activity);
        }
        else if (Build$VERSION.SDK_INT >= 11) {
            mActivityImpl = (Delegate)new HoneycombDelegate(activity);
        }
        else {
            mActivityImpl = (Delegate)new DummyDelegate(activity);
        }
        mDrawerLayout = mDrawerLayout;
        mOpenDrawerContentDescRes = mOpenDrawerContentDescRes;
        mCloseDrawerContentDescRes = mCloseDrawerContentDescRes;
        if (t == null) {
            mSlider = (DrawerToggle)new DrawerArrowDrawableToggle(activity, mActivityImpl.getActionBarThemedContext());
        }
        else {
            mSlider = (DrawerToggle)t;
        }
        mHomeAsUpIndicator = this.getThemeUpIndicator();
    }
    
    static /* synthetic */ boolean access$000(final ActionBarDrawerToggle actionBarDrawerToggle) {
        return actionBarDrawerToggle.mDrawerIndicatorEnabled;
    }
    
    static /* synthetic */ void access$100(final ActionBarDrawerToggle actionBarDrawerToggle) {
        actionBarDrawerToggle.toggle();
    }
    
    static /* synthetic */ View$OnClickListener access$200(final ActionBarDrawerToggle actionBarDrawerToggle) {
        return actionBarDrawerToggle.mToolbarNavigationClickListener;
    }
    
    private void toggle() {
        final int drawerLockMode = mDrawerLayout.getDrawerLockMode(8388611);
        if (mDrawerLayout.isDrawerVisible(8388611) && drawerLockMode != 2) {
            mDrawerLayout.closeDrawer(8388611);
        }
        else if (drawerLockMode != 1) {
            mDrawerLayout.openDrawer(8388611);
        }
    }
    
    Drawable getThemeUpIndicator() {
        return mActivityImpl.getThemeUpIndicator();
    }
    
    public View$OnClickListener getToolbarNavigationClickListener() {
        return mToolbarNavigationClickListener;
    }
    
    public boolean isDrawerIndicatorEnabled() {
        return mDrawerIndicatorEnabled;
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        if (!mHasCustomUpIndicator) {
            mHomeAsUpIndicator = this.getThemeUpIndicator();
        }
        this.syncState();
    }
    
    @Override
    public void onDrawerClosed(final View view) {
        mSlider.setPosition(0.0f);
        if (mDrawerIndicatorEnabled) {
            this.setActionBarDescription(mOpenDrawerContentDescRes);
        }
    }
    
    @Override
    public void onDrawerOpened(final View view) {
        mSlider.setPosition(1.0f);
        if (mDrawerIndicatorEnabled) {
            this.setActionBarDescription(mCloseDrawerContentDescRes);
        }
    }
    
    @Override
    public void onDrawerSlide(final View view, final float n) {
        mSlider.setPosition(Math.min(1.0f, Math.max(0.0f, n)));
    }
    
    @Override
    public void onDrawerStateChanged(final int n) {
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        if (menuItem != null && menuItem.getItemId() == 16908332 && mDrawerIndicatorEnabled) {
            this.toggle();
            return true;
        }
        return false;
    }
    
    void setActionBarDescription(final int actionBarDescription) {
        mActivityImpl.setActionBarDescription(actionBarDescription);
    }
    
    void setActionBarUpIndicator(final Drawable drawable, final int n) {
        if (!mWarnedForDisplayHomeAsUp && !mActivityImpl.isNavigationVisible()) {
            Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            mWarnedForDisplayHomeAsUp = true;
        }
        mActivityImpl.setActionBarUpIndicator(drawable, n);
    }
    
    public void setDrawerIndicatorEnabled(final boolean mDrawerIndicatorEnabled) {
        if (mDrawerIndicatorEnabled != this.mDrawerIndicatorEnabled) {
            if (mDrawerIndicatorEnabled) {
                final Drawable drawable = (Drawable)mSlider;
                int n;
                if (mDrawerLayout.isDrawerOpen(8388611)) {
                    n = mCloseDrawerContentDescRes;
                }
                else {
                    n = mOpenDrawerContentDescRes;
                }
                this.setActionBarUpIndicator(drawable, n);
            }
            else {
                this.setActionBarUpIndicator(mHomeAsUpIndicator, 0);
            }
            this.mDrawerIndicatorEnabled = mDrawerIndicatorEnabled;
        }
    }
    
    public void setHomeAsUpIndicator(final int n) {
        Drawable drawable = null;
        if (n != 0) {
            drawable = mDrawerLayout.getResources().getDrawable(n);
        }
        this.setHomeAsUpIndicator(drawable);
    }
    
    public void setHomeAsUpIndicator(final Drawable mHomeAsUpIndicator) {
        if (mHomeAsUpIndicator == null) {
            this.mHomeAsUpIndicator = this.getThemeUpIndicator();
            mHasCustomUpIndicator = false;
        }
        else {
            this.mHomeAsUpIndicator = mHomeAsUpIndicator;
            mHasCustomUpIndicator = true;
        }
        if (!mDrawerIndicatorEnabled) {
            this.setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        }
    }
    
    public void setToolbarNavigationClickListener(final View$OnClickListener mToolbarNavigationClickListener) {
        this.mToolbarNavigationClickListener = mToolbarNavigationClickListener;
    }
    
    public void syncState() {
        if (mDrawerLayout.isDrawerOpen(8388611)) {
            mSlider.setPosition(1.0f);
        }
        else {
            mSlider.setPosition(0.0f);
        }
        if (mDrawerIndicatorEnabled) {
            final Drawable drawable = (Drawable)mSlider;
            int n;
            if (mDrawerLayout.isDrawerOpen(8388611)) {
                n = mCloseDrawerContentDescRes;
            }
            else {
                n = mOpenDrawerContentDescRes;
            }
            this.setActionBarUpIndicator(drawable, n);
        }
    }
}
