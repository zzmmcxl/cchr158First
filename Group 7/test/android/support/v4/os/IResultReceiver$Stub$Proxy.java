package android.support.v4.os;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.os.IResultReceiver;

class IResultReceiver$Stub$Proxy implements IResultReceiver {
   private IBinder mRemote;

   IResultReceiver$Stub$Proxy(IBinder var1) {
      this.mRemote = var1;
   }

   public IBinder asBinder() {
      return this.mRemote;
   }

   public String getInterfaceDescriptor() {
      return "android.support.v4.os.IResultReceiver";
   }

   public void send(int param1, Bundle param2) throws RemoteException {
      // $FF: Couldn't be decompiled
   }
}
