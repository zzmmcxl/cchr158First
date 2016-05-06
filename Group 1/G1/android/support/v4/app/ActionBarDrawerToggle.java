package android.support.v4.app;

import android.support.v4.view.ViewCompat;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.InsetDrawable;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.view.View;
import android.content.res.Configuration;
import android.support.v4.content.ContextCompat;
import android.content.Context;
import android.support.annotation.StringRes;
import android.support.annotation.DrawableRes;
import android.os.Build$VERSION;
import android.graphics.drawable.Drawable;
import android.app.Activity;
import android.support.v4.widget.DrawerLayout;

@Deprecated
public class ActionBarDrawerToggle implements DrawerListener
{
    private static final int ID_HOME = 16908332;
    private static final ActionBarDrawerToggleImpl IMPL;
    private static final float TOGGLE_DRAWABLE_OFFSET = 0.33333334f;
    private final Activity mActivity;
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private Drawable mDrawerImage;
    private final int mDrawerImageResource;
    private boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private Object mSetIndicatorInfo;
    private SlideDrawable mSlider;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 18) {
            IMPL = (ActionBarDrawerToggleImpl)new ActionBarDrawerToggleImplJellybeanMR2();
            return;
        }
        if (sdk_INT >= 11) {
            IMPL = (ActionBarDrawerToggleImpl)new ActionBarDrawerToggleImplHC();
            return;
        }
        IMPL = (ActionBarDrawerToggleImpl)new ActionBarDrawerToggleImplBase();
    }
    
    public ActionBarDrawerToggle(final Activity activity, final DrawerLayout drawerLayout, @DrawableRes final int n, @StringRes final int n2, @StringRes final int n3) {
        this(activity, drawerLayout, !assumeMaterial((Context)activity), n, n2, n3);
    }
    
    public ActionBarDrawerToggle(final Activity mActivity, final DrawerLayout mDrawerLayout, final boolean b, @DrawableRes final int mDrawerImageResource, @StringRes final int mOpenDrawerContentDescRes, @StringRes final int mCloseDrawerContentDescRes) {
        super();
        mDrawerIndicatorEnabled = true;
        mActivity = mActivity;
        if (mActivity instanceof DelegateProvider) {
            mActivityImpl = ((DelegateProvider)mActivity).getDrawerToggleDelegate();
        }
        else {
            mActivityImpl = null;
        }
        mDrawerLayout = mDrawerLayout;
        mDrawerImageResource = mDrawerImageResource;
        mOpenDrawerContentDescRes = mOpenDrawerContentDescRes;
        mCloseDrawerContentDescRes = mCloseDrawerContentDescRes;
        mHomeAsUpIndicator = this.getThemeUpIndicator();
        mDrawerImage = ContextCompat.getDrawable((Context)mActivity, mDrawerImageResource);
        mSlider = new SlideDrawable(this, mDrawerImage);
        final SlideDrawable mSlider = this.mSlider;
        float offset;
        if (b) {
            offset = 0.33333334f;
        }
        else {
            offset = 0.0f;
        }
        mSlider.setOffset(offset);
    }
    
    static /* synthetic */ Activity access$400(final ActionBarDrawerToggle actionBarDrawerToggle) {
        return actionBarDrawerToggle.mActivity;
    }
    
    private static boolean assumeMaterial(final Context context) {
        return context.getApplicationInfo().targetSdkVersion >= 21 && Build$VERSION.SDK_INT >= 21;
    }
    
    Drawable getThemeUpIndicator() {
        if (mActivityImpl != null) {
            return mActivityImpl.getThemeUpIndicator();
        }
        return IMPL.getThemeUpIndicator(mActivity);
    }
    
    public boolean isDrawerIndicatorEnabled() {
        return mDrawerIndicatorEnabled;
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        if (!mHasCustomUpIndicator) {
            mHomeAsUpIndicator = this.getThemeUpIndicator();
        }
        mDrawerImage = ContextCompat.getDrawable((Context)mActivity, mDrawerImageResource);
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
        final float position = mSlider.getPosition();
        float position2;
        if (n > 0.5f) {
            position2 = Math.max(position, 2.0f * Math.max(0.0f, n - 0.5f));
        }
        else {
            position2 = Math.min(position, n * 2.0f);
        }
        mSlider.setPosition(position2);
    }
    
    @Override
    public void onDrawerStateChanged(final int n) {
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        if (menuItem != null && menuItem.getItemId() == 16908332 && mDrawerIndicatorEnabled) {
            if (mDrawerLayout.isDrawerVisible(8388611)) {
                mDrawerLayout.closeDrawer(8388611);
            }
            else {
                mDrawerLayout.openDrawer(8388611);
            }
            return true;
        }
        return false;
    }
    
    void setActionBarDescription(final int actionBarDescription) {
        if (mActivityImpl != null) {
            mActivityImpl.setActionBarDescription(actionBarDescription);
            return;
        }
        mSetIndicatorInfo = IMPL.setActionBarDescription(mSetIndicatorInfo, mActivity, actionBarDescription);
    }
    
    void setActionBarUpIndicator(final Drawable drawable, final int n) {
        if (mActivityImpl != null) {
            mActivityImpl.setActionBarUpIndicator(drawable, n);
            return;
        }
        mSetIndicatorInfo = IMPL.setActionBarUpIndicator(mSetIndicatorInfo, mActivity, drawable, n);
    }
    
    public void setDrawerIndicatorEnabled(final boolean mDrawerIndicatorEnabled) {
        if (mDrawerIndicatorEnabled != this.mDrawerIndicatorEnabled) {
            if (mDrawerIndicatorEnabled) {
                final SlideDrawable mSlider = this.mSlider;
                int n;
                if (mDrawerLayout.isDrawerOpen(8388611)) {
                    n = mCloseDrawerContentDescRes;
                }
                else {
                    n = mOpenDrawerContentDescRes;
                }
                this.setActionBarUpIndicator((Drawable)mSlider, n);
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
            drawable = ContextCompat.getDrawable((Context)mActivity, n);
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
    
    public void syncState() {
        if (mDrawerLayout.isDrawerOpen(8388611)) {
            mSlider.setPosition(1.0f);
        }
        else {
            mSlider.setPosition(0.0f);
        }
        if (mDrawerIndicatorEnabled) {
            final SlideDrawable mSlider = this.mSlider;
            int n;
            if (mDrawerLayout.isDrawerOpen(8388611)) {
                n = mCloseDrawerContentDescRes;
            }
            else {
                n = mOpenDrawerContentDescRes;
            }
            this.setActionBarUpIndicator((Drawable)mSlider, n);
        }
    }
}
