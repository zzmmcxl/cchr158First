package android.support.v4.media;

import android.os.IBinder;
import android.content.Intent;

class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl
{
    private Object mServiceObj;
    final /* synthetic */ MediaBrowserServiceCompat this$0;
    
    MediaBrowserServiceImplApi21(final MediaBrowserServiceCompat this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public IBinder onBind(final Intent intent) {
        return MediaBrowserServiceCompatApi21.onBind(mServiceObj, intent);
    }
    
    @Override
    public void onCreate() {
        MediaBrowserServiceCompatApi21.onCreate(mServiceObj = MediaBrowserServiceCompatApi21.createService(), (MediaBrowserServiceCompatApi21.ServiceImplApi21)this$0.new ServiceImplApi21());
    }
}
