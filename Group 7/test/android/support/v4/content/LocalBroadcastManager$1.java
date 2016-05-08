package android.support.v4.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;

class LocalBroadcastManager$1 extends Handler {
   LocalBroadcastManager$1(LocalBroadcastManager var1, Looper var2) {
      super(var2);
      this.this$0 = var1;
   }

   public void handleMessage(Message var1) {
      switch(var1.what) {
      case 1:
         LocalBroadcastManager.access$000(this.this$0);
         return;
      default:
         super.handleMessage(var1);
      }
   }
}
