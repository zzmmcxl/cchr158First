package android.support.v4.media;

import java.util.List;
import android.os.RemoteException;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.os.IBinder;

private interface ServiceCallbacks
{
    IBinder asBinder();
    
    void onConnect(final String p0, final MediaSessionCompat.Token p1, final Bundle p2) throws RemoteException;
    
    void onConnectFailed() throws RemoteException;
    
    void onLoadChildren(final String p0, final List<MediaBrowserCompat.MediaItem> p1, final Bundle p2) throws RemoteException;
}
