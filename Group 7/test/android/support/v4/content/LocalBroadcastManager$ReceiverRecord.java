package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

class LocalBroadcastManager$ReceiverRecord {
   boolean broadcasting;
   final IntentFilter filter;
   final BroadcastReceiver receiver;

   LocalBroadcastManager$ReceiverRecord(IntentFilter var1, BroadcastReceiver var2) {
      this.filter = var1;
      this.receiver = var2;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder(128);
      var1.append("Receiver{");
      var1.append(this.receiver);
      var1.append(" filter=");
      var1.append(this.filter);
      var1.append("}");
      return var1.toString();
   }
}
