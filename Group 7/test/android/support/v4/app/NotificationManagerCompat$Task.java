package android.support.v4.app;

import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;

interface NotificationManagerCompat$Task {
   void send(INotificationSideChannel var1) throws RemoteException;
}
