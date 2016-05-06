package android.support.v4.app;

import android.os.RemoteException;
import android.app.Notification;

private static class NotifyTask implements Task
{
    final int id;
    final Notification notif;
    final String packageName;
    final String tag;
    
    public NotifyTask(final String packageName, final int id, final String tag, final Notification notif) {
        super();
        this.packageName = packageName;
        this.id = id;
        this.tag = tag;
        this.notif = notif;
    }
    
    @Override
    public void send(final INotificationSideChannel notificationSideChannel) throws RemoteException {
        notificationSideChannel.notify(packageName, id, tag, notif);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NotifyTask[");
        sb.append("packageName:").append(packageName);
        sb.append(", id:").append(id);
        sb.append(", tag:").append(tag);
        sb.append("]");
        return sb.toString();
    }
}
