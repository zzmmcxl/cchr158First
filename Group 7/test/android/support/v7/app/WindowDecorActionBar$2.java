package android.support.v7.app;

import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.app.WindowDecorActionBar;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.view.View;

class WindowDecorActionBar$2 extends ViewPropertyAnimatorListenerAdapter {
   WindowDecorActionBar$2(WindowDecorActionBar var1) {
      this.this$0 = var1;
   }

   public void onAnimationEnd(View var1) {
      WindowDecorActionBar.access$302(this.this$0, (ViewPropertyAnimatorCompatSet)null);
      WindowDecorActionBar.access$200(this.this$0).requestLayout();
   }
}
