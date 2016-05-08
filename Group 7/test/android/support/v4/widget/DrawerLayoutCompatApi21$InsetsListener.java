package android.support.v4.widget;

import android.support.v4.widget.DrawerLayoutImpl;
import android.view.View;
import android.view.WindowInsets;
import android.view.View.OnApplyWindowInsetsListener;

class DrawerLayoutCompatApi21$InsetsListener implements OnApplyWindowInsetsListener {
   public WindowInsets onApplyWindowInsets(View var1, WindowInsets var2) {
      DrawerLayoutImpl var4 = (DrawerLayoutImpl)var1;
      boolean var3;
      if(var2.getSystemWindowInsetTop() > 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      var4.setChildInsets(var2, var3);
      return var2.consumeSystemWindowInsets();
   }
}
