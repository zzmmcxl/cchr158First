package android.support.v4.media;

import android.os.Parcelable;
import android.media.browse.MediaBrowser$MediaItem;
import android.os.Parcel;
import android.os.Bundle;
import android.service.media.MediaBrowserService;
import android.os.ResultReceiver;

static class MediaBrowserServiceAdaptorApi23 extends MediaBrowserServiceAdaptorApi21
{
    MediaBrowserServiceAdaptorApi23() {
        super();
    }
    
    public void onCreate(final ServiceImplApi23 serviceImplApi23) {
        this.mBinder = (ServiceBinderProxyApi21)new ServiceBinderProxyApi23(serviceImplApi23);
    }
}
