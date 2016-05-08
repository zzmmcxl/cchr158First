package android.support.v7.app;

import android.support.v7.app.AppCompatDelegateImplV14$AppCompatWindowCallbackV14;
import android.support.v7.app.AppCompatDelegateImplV23;
import android.view.ActionMode;
import android.view.Window.Callback;

class AppCompatDelegateImplV23$AppCompatWindowCallbackV23 extends AppCompatDelegateImplV14$AppCompatWindowCallbackV14 {
   AppCompatDelegateImplV23$AppCompatWindowCallbackV23(AppCompatDelegateImplV23 var1, Callback var2) {
      super(var1, var2);
      this.this$0 = var1;
   }

   public ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback var1) {
      return null;
   }

   public ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback var1, int var2) {
      if(this.this$0.isHandleNativeActionModesEnabled()) {
         switch(var2) {
         case 0:
            return this.startAsSupportActionMode(var1);
         }
      }

      return super.onWindowStartingActionMode(var1, var2);
   }
}
