package android.support.v4.media;

import android.os.Messenger;
import android.content.ComponentName;

class MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection$2 implements Runnable {
    final /* synthetic */ MediaServiceConnection this$1;
    final /* synthetic */ ComponentName val$name;
    
    MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection$2(final MediaServiceConnection this$1, final ComponentName val$name) {
        this$1 = this$1;
        val$name = val$name;
        super();
    }
    
    @Override
    public void run() {
        if (!MediaServiceConnection.access$1000(this$1, "onServiceDisconnected")) {
            return;
        }
        MediaBrowserServiceImplBase.access$1102(this$0, null);
        MediaBrowserServiceImplBase.access$1202(this$0, null);
        MediaBrowserServiceImplBase.access$1300(this$0).setCallbacksMessenger(null);
        MediaBrowserServiceImplBase.access$1402(this$0, 3);
        MediaBrowserServiceImplBase.access$900(this$0).onConnectionSuspended();
    }
}