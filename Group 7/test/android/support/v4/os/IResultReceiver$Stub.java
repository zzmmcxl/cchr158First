package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.os.IResultReceiver;
import android.support.v4.os.IResultReceiver$Stub$Proxy;

public abstract class IResultReceiver$Stub extends Binder implements IResultReceiver {
   private static final String DESCRIPTOR = "android.support.v4.os.IResultReceiver";
   static final int TRANSACTION_send = 1;

   public IResultReceiver$Stub() {
      this.attachInterface(this, "android.support.v4.os.IResultReceiver");
   }

   public static IResultReceiver asInterface(IBinder var0) {
      if(var0 == null) {
         return null;
      } else {
         IInterface var1 = var0.queryLocalInterface("android.support.v4.os.IResultReceiver");
         return (IResultReceiver)(var1 != null && var1 instanceof IResultReceiver?(IResultReceiver)var1:new IResultReceiver$Stub$Proxy(var0));
      }
   }

   public IBinder asBinder() {
      return this;
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
      switch(var1) {
      case 1:
         var2.enforceInterface("android.support.v4.os.IResultReceiver");
         var1 = var2.readInt();
         Bundle var5;
         if(var2.readInt() != 0) {
            var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         } else {
            var5 = null;
         }

         this.send(var1, var5);
         return true;
      case 1598968902:
         var3.writeString("android.support.v4.os.IResultReceiver");
         return true;
      default:
         return super.onTransact(var1, var2, var3, var4);
      }
   }
}
