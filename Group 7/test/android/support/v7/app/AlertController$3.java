package android.support.v7.app;

import android.support.v7.app.AlertController;
import android.view.View;

class AlertController$3 implements Runnable {
   AlertController$3(AlertController var1, View var2, View var3) {
      this.this$0 = var1;
      this.val$top = var2;
      this.val$bottom = var3;
   }

   public void run() {
      AlertController.access$800(AlertController.access$900(this.this$0), this.val$top, this.val$bottom);
   }
}
