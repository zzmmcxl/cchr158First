package android.support.v4.os;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

public interface IResultReceiver extends IInterface {
   void send(int var1, Bundle var2) throws RemoteException;
}
