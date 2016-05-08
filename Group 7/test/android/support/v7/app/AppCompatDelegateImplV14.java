package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegateImplV11;
import android.support.v7.app.AppCompatDelegateImplV14$AppCompatWindowCallbackV14;
import android.support.v7.app.TwilightManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Window;
import android.view.Window.Callback;

class AppCompatDelegateImplV14 extends AppCompatDelegateImplV11 {
   private static final String KEY_LOCAL_NIGHT_MODE = "appcompat:local_night_mode";
   private static TwilightManager sTwilightManager;
   private boolean mApplyDayNightCalled;
   private boolean mHandleNativeActionModes = true;
   private int mLocalNightMode = -100;

   AppCompatDelegateImplV14(Context var1, Window var2, AppCompatCallback var3) {
      super(var1, var2, var3);
   }

   private int getNightModeToApply() {
      int var1;
      if(this.mLocalNightMode == -100) {
         var1 = getDefaultNightMode();
      } else {
         var1 = this.mLocalNightMode;
      }

      return this.mapNightModeToYesNo(var1);
   }

   private TwilightManager getTwilightManager() {
      if(sTwilightManager == null) {
         sTwilightManager = new TwilightManager(this.mContext.getApplicationContext());
      }

      return sTwilightManager;
   }

   private int mapNightModeToYesNo(int var1) {
      byte var3 = 2;
      byte var2 = var3;
      switch(var1) {
      case -1:
         var2 = var3;
         switch(((UiModeManager)this.mContext.getSystemService("uimode")).getNightMode()) {
         case 0:
            return 0;
         case 1:
         default:
            return 1;
         case 2:
            return var2;
         }
      case 0:
         var2 = var3;
         if(!this.getTwilightManager().isNight()) {
            return 1;
         }
         break;
      case 1:
      default:
         var2 = 1;
      case 2:
      }

      return var2;
   }

   private boolean updateConfigurationForNightMode(int var1) {
      Resources var4 = this.mContext.getResources();
      Configuration var5 = var4.getConfiguration();
      int var3 = var5.uiMode;
      byte var2 = 0;
      byte var6;
      switch(var1) {
      case 1:
         var6 = 16;
         break;
      case 2:
         var6 = 32;
         break;
      default:
         var6 = var2;
      }

      if((var3 & 48) != var6) {
         var5.uiMode = var5.uiMode & -49 | var6;
         var4.updateConfiguration(var5, (DisplayMetrics)null);
         return true;
      } else {
         return false;
      }
   }

   public boolean applyDayNight() {
      this.mApplyDayNightCalled = true;
      return this.updateConfigurationForNightMode(this.getNightModeToApply());
   }

   public boolean isHandleNativeActionModesEnabled() {
      return this.mHandleNativeActionModes;
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if(var1 != null && this.mLocalNightMode == -100) {
         this.mLocalNightMode = var1.getInt("appcompat:local_night_mode", -100);
      }

   }

   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      if(this.mLocalNightMode != -100) {
         var1.putInt("appcompat:local_night_mode", this.mLocalNightMode);
      }

   }

   public void setHandleNativeActionModesEnabled(boolean var1) {
      this.mHandleNativeActionModes = var1;
   }

   public void setLocalNightMode(int var1) {
      switch(var1) {
      case -1:
      case 0:
      case 1:
      case 2:
         if(this.mLocalNightMode != var1) {
            this.mLocalNightMode = var1;
            if(this.mApplyDayNightCalled) {
               this.applyDayNight();
               return;
            }
         }
         break;
      default:
         Log.d("AppCompatDelegate", "setLocalNightMode() called with an unknown mode");
      }

   }

   Callback wrapWindowCallback(Callback var1) {
      return new AppCompatDelegateImplV14$AppCompatWindowCallbackV14(this, var1);
   }
}
