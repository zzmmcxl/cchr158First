package android.support.v4.media;

import android.media.MediaDescription.Builder;
import android.media.browse.MediaBrowser.MediaItem;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.Build.VERSION;
import android.support.v4.media.IMediaBrowserServiceCallbacksAdapterApi21;
import android.support.v4.media.MediaBrowserServiceCompatApi21$ServiceCallbacks;
import android.support.v4.media.ParceledListSliceAdapterApi21;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MediaBrowserServiceCompatApi21$ServiceCallbacksApi21 implements MediaBrowserServiceCompatApi21$ServiceCallbacks {
   private static Object sNullParceledListSliceObj;
   private final IMediaBrowserServiceCallbacksAdapterApi21 mCallbacks;

   static {
      MediaItem var0 = new MediaItem((new Builder()).setMediaId("android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM").build(), 0);
      ArrayList var1 = new ArrayList();
      var1.add(var0);
      sNullParceledListSliceObj = ParceledListSliceAdapterApi21.newInstance(var1);
   }

   MediaBrowserServiceCompatApi21$ServiceCallbacksApi21(Object var1) {
      this.mCallbacks = new IMediaBrowserServiceCallbacksAdapterApi21(var1);
   }

   public IBinder asBinder() {
      return this.mCallbacks.asBinder();
   }

   public void onConnect(String var1, Object var2, Bundle var3) throws RemoteException {
      this.mCallbacks.onConnect(var1, var2, var3);
   }

   public void onConnectFailed() throws RemoteException {
      this.mCallbacks.onConnectFailed();
   }

   public void onLoadChildren(String var1, List<Parcel> var2) throws RemoteException {
      ArrayList var3 = null;
      if(var2 != null) {
         ArrayList var4 = new ArrayList();
         Iterator var5 = var2.iterator();

         while(true) {
            var3 = var4;
            if(!var5.hasNext()) {
               break;
            }

            Parcel var7 = (Parcel)var5.next();
            var7.setDataPosition(0);
            var4.add(MediaItem.CREATOR.createFromParcel(var7));
            var7.recycle();
         }
      }

      Object var6;
      if(VERSION.SDK_INT > 23) {
         if(var3 == null) {
            var6 = null;
         } else {
            var6 = ParceledListSliceAdapterApi21.newInstance(var3);
         }
      } else if(var3 == null) {
         var6 = sNullParceledListSliceObj;
      } else {
         var6 = ParceledListSliceAdapterApi21.newInstance(var3);
      }

      this.mCallbacks.onLoadChildren(var1, var6);
   }
}
