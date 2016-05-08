package android.support.v7.app;

import android.os.Message;
import android.support.v7.app.AlertController;
import android.view.View;
import android.view.View.OnClickListener;

class AlertController$1 implements OnClickListener {
   AlertController$1(AlertController var1) {
      this.this$0 = var1;
   }

   public void onClick(View var1) {
      Message var2;
      if(var1 == AlertController.access$000(this.this$0) && AlertController.access$100(this.this$0) != null) {
         var2 = Message.obtain(AlertController.access$100(this.this$0));
      } else if(var1 == AlertController.access$200(this.this$0) && AlertController.access$300(this.this$0) != null) {
         var2 = Message.obtain(AlertController.access$300(this.this$0));
      } else if(var1 == AlertController.access$400(this.this$0) && AlertController.access$500(this.this$0) != null) {
         var2 = Message.obtain(AlertController.access$500(this.this$0));
      } else {
         var2 = null;
      }

      if(var2 != null) {
         var2.sendToTarget();
      }

      AlertController.access$700(this.this$0).obtainMessage(1, AlertController.access$600(this.this$0)).sendToTarget();
   }
}
