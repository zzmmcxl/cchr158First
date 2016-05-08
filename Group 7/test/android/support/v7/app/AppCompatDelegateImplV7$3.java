package android.support.v7.app;

import android.graphics.Rect;
import android.support.v7.app.AppCompatDelegateImplV7;
import android.support.v7.widget.FitWindowsViewGroup$OnFitSystemWindowsListener;

class AppCompatDelegateImplV7$3 implements FitWindowsViewGroup$OnFitSystemWindowsListener {
   AppCompatDelegateImplV7$3(AppCompatDelegateImplV7 var1) {
      this.this$0 = var1;
   }

   public void onFitSystemWindows(Rect var1) {
      var1.top = AppCompatDelegateImplV7.access$300(this.this$0, var1.top);
   }
}
