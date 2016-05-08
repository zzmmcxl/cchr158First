package android.support.v7.widget;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.view.View;

class ActionBarOverlayLayout$1 extends ViewPropertyAnimatorListenerAdapter {
   ActionBarOverlayLayout$1(ActionBarOverlayLayout var1) {
      this.this$0 = var1;
   }

   public void onAnimationCancel(View var1) {
      ActionBarOverlayLayout.access$002(this.this$0, (ViewPropertyAnimatorCompat)null);
      ActionBarOverlayLayout.access$102(this.this$0, false);
   }

   public void onAnimationEnd(View var1) {
      ActionBarOverlayLayout.access$002(this.this$0, (ViewPropertyAnimatorCompat)null);
      ActionBarOverlayLayout.access$102(this.this$0, false);
   }
}
