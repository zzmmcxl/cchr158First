package android.support.v4.app;

import android.os.RemoteException;
import android.app.Notification;
import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;

public abstract static class Stub extends Binder implements INotificationSideChannel
{
    private static final String DESCRIPTOR = "android.support.v4.app.INotificationSideChannel";
    static final int TRANSACTION_cancel = 2;
    static final int TRANSACTION_cancelAll = 3;
    static final int TRANSACTION_notify = 1;
    
    public Stub() {
        super();
        this.attachInterface((IInterface)this, "android.support.v4.app.INotificationSideChannel");
    }
    
    public static INotificationSideChannel asInterface(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
        if (queryLocalInterface != null && queryLocalInterface instanceof INotificationSideChannel) {
            return (INotificationSideChannel)queryLocalInterface;
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
                parcel2.writeString("android.support.v4.app.INotificationSideChannel");
                return true;
            case 1: {
                parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                final String string = parcel.readString();
                final int int1 = parcel.readInt();
                final String string2 = parcel.readString();
                Notification notification;
                if (parcel.readInt() != 0) {
                    notification = (Notification)Notification.CREATOR.createFromParcel(parcel);
                }
                else {
                    notification = null;
                }
                this.notify(string, int1, string2, notification);
                return true;
            }
            case 2:
                parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                this.cancel(parcel.readString(), parcel.readInt(), parcel.readString());
                return true;
            case 3:
                parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                this.cancelAll(parcel.readString());
                return true;
        }
    }
}
