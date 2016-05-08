package android.support.v4.app;

import android.app.Notification;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel$Stub;
import android.support.v4.app.NotificationCompatSideChannelService;

class NotificationCompatSideChannelService$NotificationSideChannelStub extends INotificationSideChannel$Stub {
   private NotificationCompatSideChannelService$NotificationSideChannelStub(NotificationCompatSideChannelService var1) {
      this.this$0 = var1;
   }

   public void cancel(String var1, int var2, String var3) throws RemoteException {
      NotificationCompatSideChannelService.access$100(this.this$0, getCallingUid(), var1);
      long var4 = clearCallingIdentity();
      boolean var7 = false;

      try {
         var7 = true;
         this.this$0.cancel(var1, var2, var3);
         var7 = false;
      } finally {
         if(var7) {
            restoreCallingIdentity(var4);
         }
      }

      restoreCallingIdentity(var4);
   }

   public void cancelAll(String var1) {
      NotificationCompatSideChannelService.access$100(this.this$0, getCallingUid(), var1);
      long var2 = clearCallingIdentity();
      boolean var5 = false;

      try {
         var5 = true;
         this.this$0.cancelAll(var1);
         var5 = false;
      } finally {
         if(var5) {
            restoreCallingIdentity(var2);
         }
      }

      restoreCallingIdentity(var2);
   }

   public void notify(String var1, int var2, String var3, Notification var4) throws RemoteException {
      NotificationCompatSideChannelService.access$100(this.this$0, getCallingUid(), var1);
      long var5 = clearCallingIdentity();
      boolean var8 = false;

      try {
         var8 = true;
         this.this$0.notify(var1, var2, var3, var4);
         var8 = false;
      } finally {
         if(var8) {
            restoreCallingIdentity(var5);
         }
      }

      restoreCallingIdentity(var5);
   }
}
