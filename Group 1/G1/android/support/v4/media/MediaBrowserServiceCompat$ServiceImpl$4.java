package android.support.v4.media;

import android.util.Log;
import android.os.Bundle;

class MediaBrowserServiceCompat$ServiceImpl$4 implements Runnable {
    final /* synthetic */ ServiceImpl this$1;
    final /* synthetic */ ServiceCallbacks val$callbacks;
    final /* synthetic */ String val$id;
    final /* synthetic */ Bundle val$options;
    
    MediaBrowserServiceCompat$ServiceImpl$4(final ServiceImpl this$1, final ServiceCallbacks val$callbacks, final String val$id, final Bundle val$options) {
        this$1 = this$1;
        val$callbacks = val$callbacks;
        val$id = val$id;
        val$options = val$options;
        super();
    }
    
    @Override
    public void run() {
        final ConnectionRecord connectionRecord = (ConnectionRecord)MediaBrowserServiceCompat.access$500(this$0).get(val$callbacks.asBinder());
        if (connectionRecord == null) {
            Log.w("MediaBrowserServiceCompat", "removeSubscription for callback that isn't registered id=" + val$id);
        }
        else if (!MediaBrowserServiceCompat.access$800(this$0, val$id, connectionRecord, val$options)) {
            Log.w("MediaBrowserServiceCompat", "removeSubscription called for " + val$id + " which is not subscribed");
        }
    }
}