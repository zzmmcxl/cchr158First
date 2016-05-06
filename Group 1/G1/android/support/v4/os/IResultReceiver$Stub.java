package android.support.v4.os;

import android.os.RemoteException;
import android.os.Bundle;
import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;

public abstract static class Stub extends Binder implements IResultReceiver
{
    private static final String DESCRIPTOR = "android.support.v4.os.IResultReceiver";
    static final int TRANSACTION_send = 1;
    
    public Stub() {
        super();
        this.attachInterface((IInterface)this, "android.support.v4.os.IResultReceiver");
    }
    
    public static IResultReceiver asInterface(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("android.support.v4.os.IResultReceiver");
        if (queryLocalInterface != null && queryLocalInterface instanceof IResultReceiver) {
            return (IResultReceiver)queryLocalInterface;
        }
        return new Proxy(binder);
    }
    
    public IBinder asBinder() {
        return (IBinder)this;
    }
    
    public boolean onTransact(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        switch (n) {
            default:
                return super.onTransact(n, parcel, parcel2, n2);
            case 1598968902:
                parcel2.writeString("android.support.v4.os.IResultReceiver");
                return true;
            case 1: {
                parcel.enforceInterface("android.support.v4.os.IResultReceiver");
                final int int1 = parcel.readInt();
                Bundle bundle;
                if (parcel.readInt() != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                else {
                    bundle = null;
                }
                this.send(int1, bundle);
                return true;
            }
        }
    }
}
