package android.support.v4.media;

import android.support.v4.os.ResultReceiver;

class MediaBrowserServiceCompat$ServiceImpl$5 implements Runnable {
    final /* synthetic */ ServiceImpl this$1;
    final /* synthetic */ String val$mediaId;
    final /* synthetic */ ResultReceiver val$receiver;
    
    MediaBrowserServiceCompat$ServiceImpl$5(final ServiceImpl this$1, final String val$mediaId, final ResultReceiver val$receiver) {
        this$1 = this$1;
        val$mediaId = val$mediaId;
        val$receiver = val$receiver;
        super();
    }
    
    @Override
    public void run() {
        MediaBrowserServiceCompat.access$900(this$0, val$mediaId, val$receiver);
    }
}