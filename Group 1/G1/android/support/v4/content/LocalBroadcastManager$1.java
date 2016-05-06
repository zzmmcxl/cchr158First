package android.support.v4.content;

import android.os.Message;
import android.os.Looper;
import android.os.Handler;

class LocalBroadcastManager$1 extends Handler {
    final /* synthetic */ LocalBroadcastManager this$0;
    
    LocalBroadcastManager$1(final LocalBroadcastManager this$0, final Looper looper) {
        this$0 = this$0;
        super(looper);
    }
    
    public void handleMessage(final Message message) {
        switch (message.what) {
            default:
                super.handleMessage(message);
            case 1:
                LocalBroadcastManager.access$000(this$0);
        }
    }
}