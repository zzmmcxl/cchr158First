package android.support.v4.view;

import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.WindowInsetsCompatApi21;
import android.view.View;
import android.view.WindowInsets;

final class ViewCompatLollipop$1 implements android.view.View.OnApplyWindowInsetsListener {
   ViewCompatLollipop$1(OnApplyWindowInsetsListener var1) {
      this.val$listener = var1;
   }

   public WindowInsets onApplyWindowInsets(View var1, WindowInsets var2) {
      WindowInsetsCompatApi21 var3 = new WindowInsetsCompatApi21(var2);
      return ((WindowInsetsCompatApi21)this.val$listener.onApplyWindowInsets(var1, var3)).unwrap();
   }
}
