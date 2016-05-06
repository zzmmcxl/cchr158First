package android.support.v4.media;

import android.os.ResultReceiver;
import android.os.Bundle;
import android.os.IBinder;
import android.content.Intent;

static class MediaBrowserServiceAdaptorApi21
{
    ServiceBinderProxyApi21 mBinder;
    
    MediaBrowserServiceAdaptorApi21() {
        super();
    }
    
    public IBinder onBind(final Intent intent) {
        if ("android.media.browse.MediaBrowserService".equals(intent.getAction())) {
            return (IBinder)mBinder;
        }
        return null;
    }
    
    public void onCreate(final ServiceImplApi21 serviceImplApi21) {
        mBinder = new ServiceBinderProxyApi21(serviceImplApi21);
    }
}
