package android.support.v4.media;

import android.os.Parcelable;
import android.media.browse.MediaBrowser$MediaItem;
import android.service.media.MediaBrowserService;
import android.os.ResultReceiver;
import android.os.Parcel;
import android.os.Bundle;

class MediaBrowserServiceCompatApi23 extends MediaBrowserServiceCompatApi21
{
    private static final String TAG = "MediaBrowserServiceCompatApi21";
    
    MediaBrowserServiceCompatApi23() {
        super();
    }
    
    public static Object createService() {
        return new MediaBrowserServiceAdaptorApi23();
    }
    
    public static void onCreate(final Object o, final ServiceImplApi23 serviceImplApi23) {
        ((MediaBrowserServiceAdaptorApi23)o).onCreate(serviceImplApi23);
    }
}
