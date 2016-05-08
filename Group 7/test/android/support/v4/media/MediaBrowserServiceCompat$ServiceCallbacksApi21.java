package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceCallbacks;
import android.support.v4.media.MediaBrowserServiceCompatApi21$ServiceCallbacks;
import android.support.v4.media.session.MediaSessionCompat$Token;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MediaBrowserServiceCompat$ServiceCallbacksApi21 implements MediaBrowserServiceCompat$ServiceCallbacks {
   final MediaBrowserServiceCompatApi21$ServiceCallbacks mCallbacks;
   Messenger mMessenger;

   MediaBrowserServiceCompat$ServiceCallbacksApi21(MediaBrowserServiceCompat var1, MediaBrowserServiceCompatApi21$ServiceCallbacks var2) {
      this.this$0 = var1;
      this.mCallbacks = var2;
   }

   public IBinder asBinder() {
      return this.mCallbacks.asBinder();
   }

   public void onConnect(String var1, MediaSessionCompat$Token var2, Bundle var3) throws RemoteException {
      Bundle var4 = var3;
      if(var3 == null) {
         var4 = new Bundle();
      }

      this.mMessenger = new Messenger(MediaBrowserServiceCompat.access$100(this.this$0));
      BundleCompat.putBinder(var4, "extra_messenger", this.mMessenger.getBinder());
      var4.putInt("extra_service_version", 1);
      this.mCallbacks.onConnect(var1, var2.getToken(), var4);
   }

   public void onConnectFailed() throws RemoteException {
      this.mCallbacks.onConnectFailed();
   }

   public void onLoadChildren(String var1, List<MediaBrowserCompat$MediaItem> var2, Bundle var3) throws RemoteException {
      ArrayList var7 = null;
      if(var2 != null) {
         ArrayList var4 = new ArrayList();
         Iterator var6 = var2.iterator();

         while(true) {
            var7 = var4;
            if(!var6.hasNext()) {
               break;
            }

            MediaBrowserCompat$MediaItem var8 = (MediaBrowserCompat$MediaItem)var6.next();
            Parcel var5 = Parcel.obtain();
            var8.writeToParcel(var5, 0);
            var4.add(var5);
         }
      }

      this.mCallbacks.onLoadChildren(var1, var7);
   }
}
