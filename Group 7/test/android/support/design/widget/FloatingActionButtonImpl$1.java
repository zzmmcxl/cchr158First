package android.support.design.widget;

import android.support.design.widget.FloatingActionButtonImpl;
import android.view.ViewTreeObserver.OnPreDrawListener;

class FloatingActionButtonImpl$1 implements OnPreDrawListener {
   FloatingActionButtonImpl$1(FloatingActionButtonImpl var1) {
      this.this$0 = var1;
   }

   public boolean onPreDraw() {
      this.this$0.onPreDraw();
      return true;
   }
}
