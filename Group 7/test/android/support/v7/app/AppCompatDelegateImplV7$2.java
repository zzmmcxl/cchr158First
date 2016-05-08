package android.support.v7.app;

import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.app.AppCompatDelegateImplV7;
import android.view.View;

class AppCompatDelegateImplV7$2 implements OnApplyWindowInsetsListener {
   AppCompatDelegateImplV7$2(AppCompatDelegateImplV7 var1) {
      this.this$0 = var1;
   }

   public WindowInsetsCompat onApplyWindowInsets(View var1, WindowInsetsCompat var2) {
      int var3 = var2.getSystemWindowInsetTop();
      int var4 = AppCompatDelegateImplV7.access$300(this.this$0, var3);
      WindowInsetsCompat var5 = var2;
      if(var3 != var4) {
         var5 = var2.replaceSystemWindowInsets(var2.getSystemWindowInsetLeft(), var4, var2.getSystemWindowInsetRight(), var2.getSystemWindowInsetBottom());
      }

      return ViewCompat.onApplyWindowInsets(var1, var5);
   }
}
