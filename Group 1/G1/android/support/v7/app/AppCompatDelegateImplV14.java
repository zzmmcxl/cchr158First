package android.support.v7.app;

import android.support.v7.view.SupportActionModeWrapper;
import android.view.ActionMode;
import android.view.ActionMode$Callback;
import android.view.Window$Callback;
import android.util.Log;
import android.os.Bundle;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.app.UiModeManager;
import android.view.Window;
import android.content.Context;

class AppCompatDelegateImplV14 extends AppCompatDelegateImplV11
{
    private static final String KEY_LOCAL_NIGHT_MODE = "appcompat:local_night_mode";
    private static TwilightManager sTwilightManager;
    private boolean mApplyDayNightCalled;
    private boolean mHandleNativeActionModes;
    private int mLocalNightMode;
    
    AppCompatDelegateImplV14(final Context context, final Window window, final AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
        mLocalNightMode = -100;
        mHandleNativeActionModes = true;
    }
    
    private int getNightModeToApply() {
        int n;
        if (mLocalNightMode == -100) {
            n = AppCompatDelegate.getDefaultNightMode();
        }
        else {
            n = mLocalNightMode;
        }
        return this.mapNightModeToYesNo(n);
    }
    
    private TwilightManager getTwilightManager() {
        if (sTwilightManager == null) {
            sTwilightManager = new TwilightManager(this.mContext.getApplicationContext());
        }
        return sTwilightManager;
    }
    
    private int mapNightModeToYesNo(final int n) {
        int n2 = 2;
        switch (n) {
            default:
                n2 = 1;
                return n2;
            case 2:
                return n2;
            case 0:
                if (!this.getTwilightManager().isNight()) {
                    return 1;
                }
                return n2;
            case -1:
                switch (((UiModeManager)this.mContext.getSystemService("uimode")).getNightMode()) {
                    case 2:
                        return n2;
                    default:
                        return 1;
                    case 0:
                        return 0;
                }
                break;
        }
    }
    
    private boolean updateConfigurationForNightMode(final int n) {
        final Resources resources = this.mContext.getResources();
        final Configuration configuration = resources.getConfiguration();
        final int n2 = 0x30 & configuration.uiMode;
        int n3 = 0;
        switch (n) {
            case 1:
                n3 = 16;
                break;
            case 2:
                n3 = 32;
                break;
        }
        if (n2 != n3) {
            configuration.uiMode = (n3 | (0xFFFFFFCF & configuration.uiMode));
            resources.updateConfiguration(configuration, (DisplayMetrics)null);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean applyDayNight() {
        mApplyDayNightCalled = true;
        return this.updateConfigurationForNightMode(this.getNightModeToApply());
    }
    
    @Override
    public boolean isHandleNativeActionModesEnabled() {
        return mHandleNativeActionModes;
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && mLocalNightMode == -100) {
            mLocalNightMode = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }
    
    @Override
    public void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (mLocalNightMode != -100) {
            bundle.putInt("appcompat:local_night_mode", mLocalNightMode);
        }
    }
    
    @Override
    public void setHandleNativeActionModesEnabled(final boolean mHandleNativeActionModes) {
        this.mHandleNativeActionModes = mHandleNativeActionModes;
    }
    
    @Override
    public void setLocalNightMode(final int mLocalNightMode) {
        switch (mLocalNightMode) {
            default:
                Log.d("AppCompatDelegate", "setLocalNightMode() called with an unknown mode");
                break;
            case -1:
            case 0:
            case 1:
            case 2:
                if (this.mLocalNightMode == mLocalNightMode) {
                    break;
                }
                this.mLocalNightMode = mLocalNightMode;
                if (mApplyDayNightCalled) {
                    this.applyDayNight();
                    return;
                }
                break;
        }
    }
    
    @Override
    Window$Callback wrapWindowCallback(final Window$Callback window$Callback) {
        return (Window$Callback)new AppCompatWindowCallbackV14(window$Callback);
    }
}
