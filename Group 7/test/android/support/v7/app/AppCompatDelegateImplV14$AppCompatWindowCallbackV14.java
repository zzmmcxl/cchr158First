package android.support.v7.app;

import android.support.v7.app.AppCompatDelegateImplBase$AppCompatWindowCallbackBase;
import android.support.v7.app.AppCompatDelegateImplV14;
import android.support.v7.view.SupportActionModeWrapper$CallbackWrapper;
import android.view.ActionMode;
import android.view.Window.Callback;

class AppCompatDelegateImplV14$AppCompatWindowCallbackV14 extends AppCompatDelegateImplBase$AppCompatWindowCallbackBase {
   AppCompatDelegateImplV14$AppCompatWindowCallbackV14(AppCompatDelegateImplV14 var1, Callback var2) {
      super(var1, var2);
      this.this$0 = var1;
   }

   public ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback var1) {
      return this.this$0.isHandleNativeActionModesEnabled()?this.startAsSupportActionMode(var1):super.onWindowStartingActionMode(var1);
   }

   final ActionMode startAsSupportActionMode(android.view.ActionMode.Callback var1) {
      SupportActionModeWrapper$CallbackWrapper var3 = new SupportActionModeWrapper$CallbackWrapper(this.this$0.mContext, var1);
      android.support.v7.view.ActionMode var2 = this.this$0.startSupportActionMode(var3);
      return var2 != null?var3.getActionModeWrapper(var2):null;
   }
}
