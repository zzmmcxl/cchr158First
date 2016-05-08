package android.support.v7.app;

import android.content.Context;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegateImplV14;
import android.support.v7.app.AppCompatDelegateImplV23$AppCompatWindowCallbackV23;
import android.view.Window;
import android.view.Window.Callback;

class AppCompatDelegateImplV23 extends AppCompatDelegateImplV14 {
   AppCompatDelegateImplV23(Context var1, Window var2, AppCompatCallback var3) {
      super(var1, var2, var3);
   }

   Callback wrapWindowCallback(Callback var1) {
      return new AppCompatDelegateImplV23$AppCompatWindowCallbackV23(this, var1);
   }
}
