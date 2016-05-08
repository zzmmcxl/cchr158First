package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface MediaBrowserServiceCompatApi21$ServiceCallbacks {
   IBinder asBinder();

   void onConnect(String var1, Object var2, Bundle var3) throws RemoteException;

   void onConnectFailed() throws RemoteException;

   void onLoadChildren(String var1, List<Parcel> var2) throws RemoteException;
}
