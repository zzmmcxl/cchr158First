package android.support.v7.app;

import android.view.View;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.WindowCallbackWrapper;
import android.util.AttributeSet;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.appcompat.R;
import android.graphics.drawable.Drawable;
import android.support.v7.view.ActionMode;
import android.os.Bundle;
import android.view.Menu;
import android.app.Activity;
import android.support.v7.view.SupportMenuInflater;
import android.view.KeyEvent;
import android.view.Window;
import android.view.MenuInflater;
import android.content.Context;
import android.view.Window$Callback;

abstract class AppCompatDelegateImplBase extends AppCompatDelegate
{
    ActionBar mActionBar;
    final AppCompatCallback mAppCompatCallback;
    final Window$Callback mAppCompatWindowCallback;
    final Context mContext;
    boolean mHasActionBar;
    private boolean mIsDestroyed;
    boolean mIsFloating;
    MenuInflater mMenuInflater;
    final Window$Callback mOriginalWindowCallback;
    boolean mOverlayActionBar;
    boolean mOverlayActionMode;
    boolean mThemeRead;
    private CharSequence mTitle;
    final Window mWindow;
    boolean mWindowNoTitle;
    
    AppCompatDelegateImplBase(final Context mContext, final Window mWindow, final AppCompatCallback mAppCompatCallback) {
        super();
        mContext = mContext;
        mWindow = mWindow;
        mAppCompatCallback = mAppCompatCallback;
        mOriginalWindowCallback = mWindow.getCallback();
        if (mOriginalWindowCallback instanceof AppCompatWindowCallbackBase) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        mAppCompatWindowCallback = this.wrapWindowCallback(mOriginalWindowCallback);
        mWindow.setCallback(mAppCompatWindowCallback);
    }
    
    @Override
    public boolean applyDayNight() {
        return false;
    }
    
    abstract boolean dispatchKeyEvent(final KeyEvent p0);
    
    final Context getActionBarThemedContext() {
        final ActionBar supportActionBar = this.getSupportActionBar();
        Context context = null;
        if (supportActionBar != null) {
            context = supportActionBar.getThemedContext();
        }
        if (context == null) {
            context = mContext;
        }
        return context;
    }
    
    @Override
    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return new ActionBarDrawableToggleImpl(this);
    }
    
    @Override
    public MenuInflater getMenuInflater() {
        if (mMenuInflater == null) {
            this.initWindowDecorActionBar();
            Context context;
            if (mActionBar != null) {
                context = mActionBar.getThemedContext();
            }
            else {
                context = mContext;
            }
            mMenuInflater = new SupportMenuInflater(context);
        }
        return mMenuInflater;
    }
    
    @Override
    public ActionBar getSupportActionBar() {
        this.initWindowDecorActionBar();
        return mActionBar;
    }
    
    final CharSequence getTitle() {
        if (mOriginalWindowCallback instanceof Activity) {
            return ((Activity)mOriginalWindowCallback).getTitle();
        }
        return mTitle;
    }
    
    final Window$Callback getWindowCallback() {
        return mWindow.getCallback();
    }
    
    abstract void initWindowDecorActionBar();
    
    final boolean isDestroyed() {
        return mIsDestroyed;
    }
    
    @Override
    public boolean isHandleNativeActionModesEnabled() {
        return false;
    }
    
    @Override
    public void onDestroy() {
        mIsDestroyed = true;
    }
    
    abstract boolean onKeyShortcut(final int p0, final KeyEvent p1);
    
    abstract boolean onMenuOpened(final int p0, final Menu p1);
    
    abstract void onPanelClosed(final int p0, final Menu p1);
    
    @Override
    public void onSaveInstanceState(final Bundle bundle) {
    }
    
    abstract void onTitleChanged(final CharSequence p0);
    
    final ActionBar peekSupportActionBar() {
        return mActionBar;
    }
    
    @Override
    public void setHandleNativeActionModesEnabled(final boolean b) {
    }
    
    @Override
    public void setLocalNightMode(final int n) {
    }
    
    @Override
    public final void setTitle(final CharSequence mTitle) {
        this.onTitleChanged(this.mTitle = mTitle);
    }
    
    abstract ActionMode startSupportActionModeFromWindow(final ActionMode.Callback p0);
    
    Window$Callback wrapWindowCallback(final Window$Callback window$Callback) {
        return (Window$Callback)new AppCompatWindowCallbackBase(window$Callback);
    }
}
