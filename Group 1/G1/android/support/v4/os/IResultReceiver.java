package android.support.v4.os;

import android.os.Parcel;
import android.os.IBinder;
import android.os.Binder;
import android.os.RemoteException;
import android.os.Bundle;
import android.os.IInterface;

public interface IResultReceiver extends IInterface
{
    void send(final int p0, final Bundle p1) throws RemoteException;
}
