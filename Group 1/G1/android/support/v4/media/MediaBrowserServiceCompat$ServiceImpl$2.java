package android.support.v4.media;

class MediaBrowserServiceCompat$ServiceImpl$2 implements Runnable {
    final /* synthetic */ ServiceImpl this$1;
    final /* synthetic */ ServiceCallbacks val$callbacks;
    
    MediaBrowserServiceCompat$ServiceImpl$2(final ServiceImpl this$1, final ServiceCallbacks val$callbacks) {
        this$1 = this$1;
        val$callbacks = val$callbacks;
        super();
    }
    
    @Override
    public void run() {
        if (MediaBrowserServiceCompat.access$500(this$0).remove(val$callbacks.asBinder()) != null) {}
    }
}