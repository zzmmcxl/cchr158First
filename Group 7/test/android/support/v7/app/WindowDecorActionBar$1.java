package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.app.WindowDecorActionBar;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.view.View;

class WindowDecorActionBar$1 extends ViewPropertyAnimatorListenerAdapter {
   WindowDecorActionBar$1(WindowDecorActionBar var1) {
      this.this$0 = var1;
   }

   public void onAnimationEnd(View var1) {
      if(WindowDecorActionBar.access$000(this.this$0) && WindowDecorActionBar.access$100(this.this$0) != null) {
         ViewCompat.setTranslationY(WindowDecorActionBar.access$100(this.this$0), 0.0F);
         ViewCompat.setTranslationY(WindowDecorActionBar.access$200(this.this$0), 0.0F);
      }

      WindowDecorActionBar.access$200(this.this$0).setVisibility(8);
      WindowDecorActionBar.access$200(this.this$0).setTransitioning(false);
      WindowDecorActionBar.access$302(this.this$0, (ViewPropertyAnimatorCompatSet)null);
      this.this$0.completeDeferredDestroyActionMode();
      if(WindowDecorActionBar.access$400(this.this$0) != null) {
         ViewCompat.requestApplyInsets(WindowDecorActionBar.access$400(this.this$0));
      }

   }
}
