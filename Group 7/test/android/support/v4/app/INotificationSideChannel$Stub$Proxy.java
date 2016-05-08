package android.support.v4.app;

import android.app.Notification;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;

class INotificationSideChannel$Stub$Proxy implements INotificationSideChannel {
   private IBinder mRemote;

   INotificationSideChannel$Stub$Proxy(IBinder var1) {
      this.mRemote = var1;
   }

   public IBinder asBinder() {
      return this.mRemote;
   }

   public void cancel(String var1, int var2, String var3) throws RemoteException {
      Parcel var4 = Parcel.obtain();
      boolean var6 = false;

      try {
         var6 = true;
         var4.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
         var4.writeString(var1);
         var4.writeInt(var2);
         var4.writeString(var3);
         this.mRemote.transact(2, var4, (Parcel)null, 1);
         var6 = false;
      } finally {
         if(var6) {
            var4.recycle();
         }
      }

      var4.recycle();
   }

   public void cancelAll(String var1) throws RemoteException {
      Parcel var2 = Parcel.obtain();
      boolean var4 = false;

      try {
         var4 = true;
         var2.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
         var2.writeString(var1);
         this.mRemote.transact(3, var2, (Parcel)null, 1);
         var4 = false;
      } finally {
         if(var4) {
            var2.recycle();
         }
      }

      var2.recycle();
   }

   public String getInterfaceDescriptor() {
      return "android.support.v4.app.INotificationSideChannel";
   }

   public void notify(String param1, int param2, String param3, Notification param4) throws RemoteException {
      // $FF: Couldn't be decompiled
   }
}
