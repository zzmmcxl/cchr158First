package android.support.v4.media;

import android.os.IBinder;

class MediaBrowserServiceCompat$ServiceImpl$6 implements Runnable {
    final /* synthetic */ ServiceImpl this$1;
    final /* synthetic */ ServiceCallbacks val$callbacks;
    
    MediaBrowserServiceCompat$ServiceImpl$6(final ServiceImpl this$1, final ServiceCallbacks val$callbacks) {
        this$1 = this$1;
        val$callbacks = val$callbacks;
        super();
    }
    
    @Override
    public void run() {
        final IBinder binder = val$callbacks.asBinder();
        MediaBrowserServiceCompat.access$500(this$0).remove(binder);
        final ConnectionRecord connectionRecord = this$0.new ConnectionRecord();
        connectionRecord.callbacks = val$callbacks;
        MediaBrowserServiceCompat.access$500(this$0).put(binder, connectionRecord);
    }
}