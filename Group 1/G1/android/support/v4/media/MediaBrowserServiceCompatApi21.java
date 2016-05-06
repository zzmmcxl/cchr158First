package android.support.v4.media;

import java.util.Iterator;
import android.os.Build$VERSION;
import java.util.ArrayList;
import android.media.browse.MediaBrowser$MediaItem;
import android.media.MediaDescription$Builder;
import android.os.Parcel;
import java.util.List;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.Bundle;
import android.os.IBinder;
import android.content.Intent;

class MediaBrowserServiceCompatApi21
{
    MediaBrowserServiceCompatApi21() {
        super();
    }
    
    public static Object createService() {
        return new MediaBrowserServiceAdaptorApi21();
    }
    
    public static IBinder onBind(final Object o, final Intent intent) {
        return ((MediaBrowserServiceAdaptorApi21)o).onBind(intent);
    }
    
    public static void onCreate(final Object o, final ServiceImplApi21 serviceImplApi21) {
        ((MediaBrowserServiceAdaptorApi21)o).onCreate(serviceImplApi21);
    }
}
