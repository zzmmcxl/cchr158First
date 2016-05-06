package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

private static class ReceiverRecord
{
    boolean broadcasting;
    final IntentFilter filter;
    final BroadcastReceiver receiver;
    
    ReceiverRecord(final IntentFilter filter, final BroadcastReceiver receiver) {
        super();
        this.filter = filter;
        this.receiver = receiver;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append("Receiver{");
        sb.append(receiver);
        sb.append(" filter=");
        sb.append(filter);
        sb.append("}");
        return sb.toString();
    }
}
