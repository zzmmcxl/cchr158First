package android.support.v7.app;

import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v7.app.WindowDecorActionBar;
import android.view.View;

class WindowDecorActionBar$3 implements ViewPropertyAnimatorUpdateListener {
   WindowDecorActionBar$3(WindowDecorActionBar var1) {
      this.this$0 = var1;
   }

   public void onAnimationUpdate(View var1) {
      ((View)WindowDecorActionBar.access$200(this.this$0).getParent()).invalidate();
   }
}
