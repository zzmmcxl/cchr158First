package android.support.v4.media;

import android.os.IBinder;
import android.content.Intent;

class MediaBrowserServiceImplApi23 implements MediaBrowserServiceImpl
{
    private Object mServiceObj;
    final /* synthetic */ MediaBrowserServiceCompat this$0;
    
    MediaBrowserServiceImplApi23(final MediaBrowserServiceCompat this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public IBinder onBind(final Intent intent) {
        return MediaBrowserServiceCompatApi21.onBind(mServiceObj, intent);
    }
    
    @Override
    public void onCreate() {
        MediaBrowserServiceCompatApi23.onCreate(mServiceObj = MediaBrowserServiceCompatApi23.createService(), (MediaBrowserServiceCompatApi23.ServiceImplApi23)this$0.new ServiceImplApi23());
    }
}
