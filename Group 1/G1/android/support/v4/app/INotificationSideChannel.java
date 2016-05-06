package android.support.v4.app;

import android.os.Parcel;
import android.os.IBinder;
import android.os.Binder;
import android.app.Notification;
import android.os.RemoteException;
import android.os.IInterface;

public interface INotificationSideChannel extends IInterface
{
    void cancel(final String p0, final int p1, final String p2) throws RemoteException;
    
    void cancelAll(final String p0) throws RemoteException;
    
    void notify(final String p0, final int p1, final String p2, final Notification p3) throws RemoteException;
}
