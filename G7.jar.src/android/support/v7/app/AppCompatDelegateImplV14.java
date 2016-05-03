package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.view.SupportActionModeWrapper.CallbackWrapper;
import android.util.Log;
import android.view.ActionMode.Callback;
import android.view.Window;
import android.view.Window.Callback;

class AppCompatDelegateImplV14
  extends AppCompatDelegateImplV11
{
  private static final String KEY_LOCAL_NIGHT_MODE = "appcompat:local_night_mode";
  private static TwilightManager sTwilightManager;
  private boolean mApplyDayNightCalled;
  private boolean mHandleNativeActionModes = true;
  private int mLocalNightMode = -100;
  
  AppCompatDelegateImplV14(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback)
  {
    super(paramContext, paramWindow, paramAppCompatCallback);
  }
  
  private int getNightModeToApply()
  {
    if (this.mLocalNightMode == -100) {}
    for (int i = getDefaultNightMode();; i = this.mLocalNightMode) {
      return mapNightModeToYesNo(i);
    }
  }
  
  private TwilightManager getTwilightManager()
  {
    if (sTwilightManager == null) {
      sTwilightManager = new TwilightManager(this.mContext.getApplicationContext());
    }
    return sTwilightManager;
  }
  
  private int mapNightModeToYesNo(int paramInt)
  {
    int j = 2;
    int i = j;
    switch (paramInt)
    {
    case 1: 
    default: 
      i = 1;
    case 2: 
    case 0: 
      do
      {
        return i;
        i = j;
      } while (getTwilightManager().isNight());
      return 1;
    }
    i = j;
    switch (((UiModeManager)this.mContext.getSystemService("uimode")).getNightMode())
    {
    case 2: 
    case 1: 
    default: 
      return 1;
    }
    return 0;
  }
  
  private boolean updateConfigurationForNightMode(int paramInt)
  {
    Resources localResources = this.mContext.getResources();
    Configuration localConfiguration = localResources.getConfiguration();
    int j = localConfiguration.uiMode;
    int i = 0;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    while ((j & 0x30) != paramInt)
    {
      localConfiguration.uiMode = (localConfiguration.uiMode & 0xFFFFFFCF | paramInt);
      localResources.updateConfiguration(localConfiguration, null);
      return true;
      paramInt = 16;
      continue;
      paramInt = 32;
    }
    return false;
  }
  
  public boolean applyDayNight()
  {
    this.mApplyDayNightCalled = true;
    return updateConfigurationForNightMode(getNightModeToApply());
  }
  
  public boolean isHandleNativeActionModesEnabled()
  {
    return this.mHandleNativeActionModes;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((paramBundle != null) && (this.mLocalNightMode == -100)) {
      this.mLocalNightMode = paramBundle.getInt("appcompat:local_night_mode", -100);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.mLocalNightMode != -100) {
      paramBundle.putInt("appcompat:local_night_mode", this.mLocalNightMode);
    }
  }
  
  public void setHandleNativeActionModesEnabled(boolean paramBoolean)
  {
    this.mHandleNativeActionModes = paramBoolean;
  }
  
  public void setLocalNightMode(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      Log.d("AppCompatDelegate", "setLocalNightMode() called with an unknown mode");
      do
      {
        return;
      } while (this.mLocalNightMode == paramInt);
      this.mLocalNightMode = paramInt;
    } while (!this.mApplyDayNightCalled);
    applyDayNight();
  }
  
  Window.Callback wrapWindowCallback(Window.Callback paramCallback)
  {
    return new AppCompatWindowCallbackV14(paramCallback);
  }
  
  class AppCompatWindowCallbackV14
    extends AppCompatDelegateImplBase.AppCompatWindowCallbackBase
  {
    AppCompatWindowCallbackV14(Window.Callback paramCallback)
    {
      super(paramCallback);
    }
    
    public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      if (AppCompatDelegateImplV14.this.isHandleNativeActionModesEnabled()) {
        return startAsSupportActionMode(paramCallback);
      }
      return super.onWindowStartingActionMode(paramCallback);
    }
    
    final android.view.ActionMode startAsSupportActionMode(ActionMode.Callback paramCallback)
    {
      paramCallback = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImplV14.this.mContext, paramCallback);
      android.support.v7.view.ActionMode localActionMode = AppCompatDelegateImplV14.this.startSupportActionMode(paramCallback);
      if (localActionMode != null) {
        return paramCallback.getActionModeWrapper(localActionMode);
      }
      return null;
    }
  }
}


/* Location:              C:\Users\colin\Documents\GitHub\cchr158First\G7.jar!\android\support\v7\app\AppCompatDelegateImplV14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */