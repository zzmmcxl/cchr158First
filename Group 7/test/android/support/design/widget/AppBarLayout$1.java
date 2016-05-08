package android.support.design.widget;

import android.support.design.widget.AppBarLayout;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;

class AppBarLayout$1 implements OnApplyWindowInsetsListener {
   AppBarLayout$1(AppBarLayout var1) {
      this.this$0 = var1;
   }

   public WindowInsetsCompat onApplyWindowInsets(View var1, WindowInsetsCompat var2) {
      return AppBarLayout.access$000(this.this$0, var2);
   }
}
