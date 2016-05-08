package android.support.v4.app;

import android.app.Notification;
import android.os.IInterface;
import android.os.RemoteException;

public interface INotificationSideChannel extends IInterface {
   void cancel(String var1, int var2, String var3) throws RemoteException;

   void cancelAll(String var1) throws RemoteException;

   void notify(String var1, int var2, String var3, Notification var4) throws RemoteException;
}
