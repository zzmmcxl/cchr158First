package android.support.v4.media;

import android.os.Handler;
import android.os.IBinder;
import android.content.Intent;
import android.os.Messenger;

class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl
{
    private Messenger mMessenger;
    final /* synthetic */ MediaBrowserServiceCompat this$0;
    
    MediaBrowserServiceImplBase(final MediaBrowserServiceCompat this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public IBinder onBind(final Intent intent) {
        if ("android.media.browse.MediaBrowserService".equals(intent.getAction())) {
            return mMessenger.getBinder();
        }
        return null;
    }
    
    @Override
    public void onCreate() {
        mMessenger = new Messenger((Handler)MediaBrowserServiceCompat.access$100(this$0));
    }
}
