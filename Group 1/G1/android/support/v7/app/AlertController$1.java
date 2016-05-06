package android.support.v7.app;

import android.os.Message;
import android.view.View;
import android.view.View$OnClickListener;

class AlertController$1 implements View$OnClickListener {
    final /* synthetic */ AlertController this$0;
    
    AlertController$1(final AlertController this$0) {
        this$0 = this$0;
        super();
    }
    
    public void onClick(final View view) {
        Message message;
        if (view == AlertController.access$000(this$0) && AlertController.access$100(this$0) != null) {
            message = Message.obtain(AlertController.access$100(this$0));
        }
        else if (view == AlertController.access$200(this$0) && AlertController.access$300(this$0) != null) {
            message = Message.obtain(AlertController.access$300(this$0));
        }
        else if (view == AlertController.access$400(this$0) && AlertController.access$500(this$0) != null) {
            message = Message.obtain(AlertController.access$500(this$0));
        }
        else {
            message = null;
        }
        if (message != null) {
            message.sendToTarget();
        }
        AlertController.access$700(this$0).obtainMessage(1, (Object)AlertController.access$600(this$0)).sendToTarget();
    }
}