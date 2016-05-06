package android.support.v4.media;

import android.os.Parcel;
import java.util.List;
import android.os.RemoteException;
import android.os.Bundle;
import android.os.IBinder;

public interface ServiceCallbacks
{
    IBinder asBinder();
    
    void onConnect(final String p0, final Object p1, final Bundle p2) throws RemoteException;
    
    void onConnectFailed() throws RemoteException;
    
    void onLoadChildren(final String p0, final List<Parcel> p1) throws RemoteException;
}
