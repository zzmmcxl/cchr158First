package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.session.MediaSessionCompat$Token;
import java.util.List;

interface MediaBrowserServiceCompat$ServiceCallbacks {
   IBinder asBinder();

   void onConnect(String var1, MediaSessionCompat$Token var2, Bundle var3) throws RemoteException;

   void onConnectFailed() throws RemoteException;

   void onLoadChildren(String var1, List<MediaBrowserCompat$MediaItem> var2, Bundle var3) throws RemoteException;
}
