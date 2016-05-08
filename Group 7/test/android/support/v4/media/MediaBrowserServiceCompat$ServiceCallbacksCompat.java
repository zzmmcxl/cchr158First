package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceCallbacks;
import android.support.v4.media.session.MediaSessionCompat$Token;
import java.util.ArrayList;
import java.util.List;

class MediaBrowserServiceCompat$ServiceCallbacksCompat implements MediaBrowserServiceCompat$ServiceCallbacks {
   final Messenger mCallbacks;

   MediaBrowserServiceCompat$ServiceCallbacksCompat(MediaBrowserServiceCompat var1, Messenger var2) {
      this.this$0 = var1;
      this.mCallbacks = var2;
   }

   private void sendRequest(int var1, Bundle var2) throws RemoteException {
      Message var3 = Message.obtain();
      var3.what = var1;
      var3.arg1 = 1;
      var3.setData(var2);
      this.mCallbacks.send(var3);
   }

   public IBinder asBinder() {
      return this.mCallbacks.getBinder();
   }

   public void onConnect(String var1, MediaSessionCompat$Token var2, Bundle var3) throws RemoteException {
      Bundle var4 = var3;
      if(var3 == null) {
         var4 = new Bundle();
      }

      var4.putInt("extra_service_version", 1);
      var3 = new Bundle();
      var3.putString("data_media_item_id", var1);
      var3.putParcelable("data_media_session_token", var2);
      var3.putBundle("data_root_hints", var4);
      this.sendRequest(1, var3);
   }

   public void onConnectFailed() throws RemoteException {
      this.sendRequest(2, (Bundle)null);
   }

   public void onLoadChildren(String var1, List<MediaBrowserCompat$MediaItem> var2, Bundle var3) throws RemoteException {
      Bundle var4 = new Bundle();
      var4.putString("data_media_item_id", var1);
      var4.putBundle("data_options", var3);
      if(var2 != null) {
         ArrayList var5;
         if(var2 instanceof ArrayList) {
            var5 = (ArrayList)var2;
         } else {
            var5 = new ArrayList(var2);
         }

         var4.putParcelableArrayList("data_media_item_list", var5);
      }

      this.sendRequest(3, var4);
   }
}
