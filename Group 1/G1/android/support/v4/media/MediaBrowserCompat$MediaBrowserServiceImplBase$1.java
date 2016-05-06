package android.support.v4.media;

import android.content.ServiceConnection;

class MediaBrowserCompat$MediaBrowserServiceImplBase$1 implements Runnable {
    final /* synthetic */ MediaBrowserServiceImplBase this$0;
    final /* synthetic */ ServiceConnection val$thisConnection;
    
    MediaBrowserCompat$MediaBrowserServiceImplBase$1(final MediaBrowserServiceImplBase this$0, final ServiceConnection val$thisConnection) {
        this$0 = this$0;
        val$thisConnection = val$thisConnection;
        super();
    }
    
    @Override
    public void run() {
        if (val$thisConnection == MediaBrowserServiceImplBase.access$700(this$0)) {
            MediaBrowserServiceImplBase.access$800(this$0);
            MediaBrowserServiceImplBase.access$900(this$0).onConnectionFailed();
        }
    }
}