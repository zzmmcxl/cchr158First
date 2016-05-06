package android.support.v4.app;

import android.app.Notification;
import android.os.RemoteException;
import android.os.Parcel;
import android.os.IBinder;

private static class Proxy implements INotificationSideChannel
{
    private IBinder mRemote;
    
    Proxy(final IBinder mRemote) {
        super();
        this.mRemote = mRemote;
    }
    
    public IBinder asBinder() {
        return mRemote;
    }
    
    @Override
    public void cancel(final String s, final int n, final String s2) throws RemoteException {
        final Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            obtain.writeString(s);
            obtain.writeInt(n);
            obtain.writeString(s2);
            mRemote.transact(2, obtain, (Parcel)null, 1);
        }
        finally {
            obtain.recycle();
        }
    }
    
    @Override
    public void cancelAll(final String s) throws RemoteException {
        final Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            obtain.writeString(s);
            mRemote.transact(3, obtain, (Parcel)null, 1);
        }
        finally {
            obtain.recycle();
        }
    }
    
    public String getInterfaceDescriptor() {
        return "android.support.v4.app.INotificationSideChannel";
    }
    
    @Override
    public void notify(final String s, final int n, final String s2, final Notification notification) throws RemoteException {
        final Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            obtain.writeString(s);
            obtain.writeInt(n);
            obtain.writeString(s2);
            if (notification != null) {
                obtain.writeInt(1);
                notification.writeToParcel(obtain, 0);
            }
            else {
                obtain.writeInt(0);
            }
            mRemote.transact(1, obtain, (Parcel)null, 1);
        }
        finally {
            obtain.recycle();
        }
    }
}
