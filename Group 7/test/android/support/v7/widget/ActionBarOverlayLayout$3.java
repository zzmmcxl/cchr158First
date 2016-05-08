package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.ActionBarOverlayLayout;

class ActionBarOverlayLayout$3 implements Runnable {
   ActionBarOverlayLayout$3(ActionBarOverlayLayout var1) {
      this.this$0 = var1;
   }

   public void run() {
      ActionBarOverlayLayout.access$200(this.this$0);
      ActionBarOverlayLayout.access$002(this.this$0, ViewCompat.animate(ActionBarOverlayLayout.access$400(this.this$0)).translationY((float)(-ActionBarOverlayLayout.access$400(this.this$0).getHeight())).setListener(ActionBarOverlayLayout.access$300(this.this$0)));
   }
}
