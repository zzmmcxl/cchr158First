package android.support.design.widget;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;

class CollapsingToolbarLayout$1 implements OnApplyWindowInsetsListener {
   CollapsingToolbarLayout$1(CollapsingToolbarLayout var1) {
      this.this$0 = var1;
   }

   public WindowInsetsCompat onApplyWindowInsets(View var1, WindowInsetsCompat var2) {
      return CollapsingToolbarLayout.access$000(this.this$0, var2);
   }
}
