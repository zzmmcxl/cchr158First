package android.support.v4.os;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.Bundle;
import android.os.IBinder;

private static class Proxy implements IResultReceiver
{
    private IBinder mRemote;
    
    Proxy(final IBinder mRemote) {
        super();
        this.mRemote = mRemote;
    }
    
    public IBinder asBinder() {
        return mRemote;
    }
    
    public String getInterfaceDescriptor() {
        return "android.support.v4.os.IResultReceiver";
    }
    
    @Override
    public void send(final int n, final Bundle bundle) throws RemoteException {
        final Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.os.IResultReceiver");
            obtain.writeInt(n);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
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
