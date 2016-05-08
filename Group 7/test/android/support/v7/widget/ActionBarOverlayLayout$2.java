package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.ActionBarOverlayLayout;

class ActionBarOverlayLayout$2 implements Runnable {
   ActionBarOverlayLayout$2(ActionBarOverlayLayout var1) {
      this.this$0 = var1;
   }

   public void run() {
      ActionBarOverlayLayout.access$200(this.this$0);
      ActionBarOverlayLayout.access$002(this.this$0, ViewCompat.animate(ActionBarOverlayLayout.access$400(this.this$0)).translationY(0.0F).setListener(ActionBarOverlayLayout.access$300(this.this$0)));
   }
}
