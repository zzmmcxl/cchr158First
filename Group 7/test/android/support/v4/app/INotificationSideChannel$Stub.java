package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;
import android.support.v4.app.INotificationSideChannel$Stub$Proxy;

public abstract class INotificationSideChannel$Stub extends Binder implements INotificationSideChannel {
   private static final String DESCRIPTOR = "android.support.v4.app.INotificationSideChannel";
   static final int TRANSACTION_cancel = 2;
   static final int TRANSACTION_cancelAll = 3;
   static final int TRANSACTION_notify = 1;

   public INotificationSideChannel$Stub() {
      this.attachInterface(this, "android.support.v4.app.INotificationSideChannel");
   }

   public static INotificationSideChannel asInterface(IBinder var0) {
      if(var0 == null) {
         return null;
      } else {
         IInterface var1 = var0.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
         return (INotificationSideChannel)(var1 != null && var1 instanceof INotificationSideChannel?(INotificationSideChannel)var1:new INotificationSideChannel$Stub$Proxy(var0));
      }
   }

   public IBinder asBinder() {
      return this;
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
      switch(var1) {
      case 1:
         var2.enforceInterface("android.support.v4.app.INotificationSideChannel");
         String var7 = var2.readString();
         var1 = var2.readInt();
         String var5 = var2.readString();
         Notification var6;
         if(var2.readInt() != 0) {
            var6 = (Notification)Notification.CREATOR.createFromParcel(var2);
         } else {
            var6 = null;
         }

         this.notify(var7, var1, var5, var6);
         return true;
      case 2:
         var2.enforceInterface("android.support.v4.app.INotificationSideChannel");
         this.cancel(var2.readString(), var2.readInt(), var2.readString());
         return true;
      case 3:
         var2.enforceInterface("android.support.v4.app.INotificationSideChannel");
         this.cancelAll(var2.readString());
         return true;
      case 1598968902:
         var3.writeString("android.support.v4.app.INotificationSideChannel");
         return true;
      default:
         return super.onTransact(var1, var2, var3, var4);
      }
   }
}
