package android.support.v7.app;

import android.content.Context;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegateImplBase;
import android.support.v7.app.AppCompatDelegateImplV11;
import android.support.v7.internal.view.SupportActionModeWrapper;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;

class AppCompatDelegateImplV14 extends AppCompatDelegateImplV11 {
   private boolean mHandleNativeActionModes = true;

   AppCompatDelegateImplV14(Context var1, Window var2, AppCompatCallback var3) {
      super(var1, var2, var3);
   }

   public boolean isHandleNativeActionModesEnabled() {
      return this.mHandleNativeActionModes;
   }

   public void setHandleNativeActionModesEnabled(boolean var1) {
      this.mHandleNativeActionModes = var1;
   }

   Callback wrapWindowCallback(Callback var1) {
      return new AppCompatDelegateImplV14.AppCompatWindowCallbackV14(var1);
   }

   class AppCompatWindowCallbackV14 extends AppCompatDelegateImplBase.AppCompatWindowCallbackBase {
      AppCompatWindowCallbackV14(Callback var2) {
         super();
      }

      public ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback var1) {
         return AppCompatDelegateImplV14.this.mHandleNativeActionModes?this.startAsSupportActionMode(var1):super.onWindowStartingActionMode(var1);
      }

      final ActionMode startAsSupportActionMode(android.view.ActionMode.Callback var1) {
         SupportActionModeWrapper.CallbackWrapper var3 = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImplV14.this.mContext, var1);
         android.support.v7.view.ActionMode var2 = AppCompatDelegateImplV14.this.startSupportActionMode(var3);
         return var2 != null?var3.getActionModeWrapper(var2):null;
      }
   }
}
