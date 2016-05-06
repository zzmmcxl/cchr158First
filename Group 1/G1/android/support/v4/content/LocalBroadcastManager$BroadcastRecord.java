package android.support.v4.content;

import java.util.ArrayList;
import android.content.Intent;

private static class BroadcastRecord
{
    final Intent intent;
    final ArrayList<ReceiverRecord> receivers;
    
    BroadcastRecord(final Intent intent, final ArrayList<ReceiverRecord> receivers) {
        super();
        this.intent = intent;
        this.receivers = receivers;
    }
}
