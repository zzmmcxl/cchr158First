package android.support.v4.media;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.os.ResultReceiver;

class MediaBrowserCompat$ServiceBinderWrapper {
   private Messenger mMessenger;

   public MediaBrowserCompat$ServiceBinderWrapper(IBinder var1) {
      this.mMessenger = new Messenger(var1);
   }

   private void sendRequest(int var1, Bundle var2, Messenger var3) throws RemoteException {
      Message var4 = Message.obtain();
      var4.what = var1;
      var4.arg1 = 1;
      var4.setData(var2);
      var4.replyTo = var3;
      this.mMessenger.send(var4);
   }

   void addSubscription(String var1, Bundle var2, Messenger var3) throws RemoteException {
      Bundle var4 = new Bundle();
      var4.putString("data_media_item_id", var1);
      var4.putBundle("data_options", var2);
      this.sendRequest(3, var4, var3);
   }

   void connect(Context var1, Bundle var2, Messenger var3) throws RemoteException {
      Bundle var4 = new Bundle();
      var4.putString("data_package_name", var1.getPackageName());
      var4.putBundle("data_root_hints", var2);
      this.sendRequest(1, var4, var3);
   }

   void disconnect(Messenger var1) throws RemoteException {
      this.sendRequest(2, (Bundle)null, var1);
   }

   void getMediaItem(String var1, ResultReceiver var2) throws RemoteException {
      Bundle var3 = new Bundle();
      var3.putString("data_media_item_id", var1);
      var3.putParcelable("data_result_receiver", var2);
      this.sendRequest(5, var3, (Messenger)null);
   }

   void registerCallbackMessenger(Messenger var1) throws RemoteException {
      this.sendRequest(6, (Bundle)null, var1);
   }

   void removeSubscription(String var1, Bundle var2, Messenger var3) throws RemoteException {
      Bundle var4 = new Bundle();
      var4.putString("data_media_item_id", var1);
      var4.putBundle("data_options", var2);
      this.sendRequest(4, var4, var3);
   }
}
