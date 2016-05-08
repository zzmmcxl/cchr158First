package android.support.design.internal;

import android.graphics.Rect;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;

class ScrimInsetsFrameLayout$1 implements OnApplyWindowInsetsListener {
   ScrimInsetsFrameLayout$1(ScrimInsetsFrameLayout var1) {
      this.this$0 = var1;
   }

   public WindowInsetsCompat onApplyWindowInsets(View var1, WindowInsetsCompat var2) {
      if(ScrimInsetsFrameLayout.access$000(this.this$0) == null) {
         ScrimInsetsFrameLayout.access$002(this.this$0, new Rect());
      }

      ScrimInsetsFrameLayout.access$000(this.this$0).set(var2.getSystemWindowInsetLeft(), var2.getSystemWindowInsetTop(), var2.getSystemWindowInsetRight(), var2.getSystemWindowInsetBottom());
      this.this$0.onInsetsChanged(ScrimInsetsFrameLayout.access$000(this.this$0));
      ScrimInsetsFrameLayout var4 = this.this$0;
      boolean var3;
      if(!ScrimInsetsFrameLayout.access$000(this.this$0).isEmpty() && ScrimInsetsFrameLayout.access$100(this.this$0) != null) {
         var3 = false;
      } else {
         var3 = true;
      }

      var4.setWillNotDraw(var3);
      ViewCompat.postInvalidateOnAnimation(this.this$0);
      return var2.consumeSystemWindowInsets();
   }
}
