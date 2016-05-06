package android.support.v4.app;

import android.os.RemoteException;

private interface Task
{
    void send(final INotificationSideChannel p0) throws RemoteException;
}
