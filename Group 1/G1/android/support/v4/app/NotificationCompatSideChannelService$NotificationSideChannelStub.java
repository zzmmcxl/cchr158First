package android.support.v4.app;

import android.app.Notification;
import android.os.RemoteException;

private class NotificationSideChannelStub extends Stub
{
    final /* synthetic */ NotificationCompatSideChannelService this$0;
    
    private NotificationSideChannelStub(final NotificationCompatSideChannelService this$0) {
        this$0 = this$0;
        super();
    }
    
    NotificationSideChannelStub(final NotificationCompatSideChannelService notificationCompatSideChannelService, final NotificationCompatSideChannelService$1 object) {
        this(notificationCompatSideChannelService);
    }
    
    public void cancel(final String s, final int n, final String s2) throws RemoteException {
        NotificationCompatSideChannelService.access$100(this$0, getCallingUid(), s);
        final long clearCallingIdentity = clearCallingIdentity();
        try {
            this$0.cancel(s, n, s2);
        }
        finally {
            restoreCallingIdentity(clearCallingIdentity);
        }
    }
    
    public void cancelAll(final String s) {
        NotificationCompatSideChannelService.access$100(this$0, getCallingUid(), s);
        final long clearCallingIdentity = clearCallingIdentity();
        try {
            this$0.cancelAll(s);
        }
        finally {
            restoreCallingIdentity(clearCallingIdentity);
        }
    }
    
    public void notify(final String s, final int n, final String s2, final Notification notification) throws RemoteException {
        NotificationCompatSideChannelService.access$100(this$0, getCallingUid(), s);
        final long clearCallingIdentity = clearCallingIdentity();
        try {
            this$0.notify(s, n, s2, notification);
        }
        finally {
            restoreCallingIdentity(clearCallingIdentity);
        }
    }
}
