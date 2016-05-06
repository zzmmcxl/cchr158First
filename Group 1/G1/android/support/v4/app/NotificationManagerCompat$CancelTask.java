package android.support.v4.app;

import android.os.RemoteException;

private static class CancelTask implements Task
{
    final boolean all;
    final int id;
    final String packageName;
    final String tag;
    
    public CancelTask(final String packageName) {
        super();
        this.packageName = packageName;
        this.id = 0;
        this.tag = null;
        this.all = true;
    }
    
    public CancelTask(final String packageName, final int id, final String tag) {
        super();
        this.packageName = packageName;
        this.id = id;
        this.tag = tag;
        this.all = false;
    }
    
    @Override
    public void send(final INotificationSideChannel notificationSideChannel) throws RemoteException {
        if (all) {
            notificationSideChannel.cancelAll(packageName);
            return;
        }
        notificationSideChannel.cancel(packageName, id, tag);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CancelTask[");
        sb.append("packageName:").append(packageName);
        sb.append(", id:").append(id);
        sb.append(", tag:").append(tag);
        sb.append(", all:").append(all);
        sb.append("]");
        return sb.toString();
    }
}
