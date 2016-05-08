package android.support.v4.content;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager$ReceiverRecord;
import java.util.ArrayList;

class LocalBroadcastManager$BroadcastRecord {
   final Intent intent;
   final ArrayList<LocalBroadcastManager$ReceiverRecord> receivers;

   LocalBroadcastManager$BroadcastRecord(Intent var1, ArrayList<LocalBroadcastManager$ReceiverRecord> var2) {
      this.intent = var1;
      this.receivers = var2;
   }
}
