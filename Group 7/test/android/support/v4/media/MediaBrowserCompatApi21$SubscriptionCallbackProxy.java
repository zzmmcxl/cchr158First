package android.support.v4.media;

import android.media.browse.MediaBrowser.MediaItem;
import android.media.browse.MediaBrowser.SubscriptionCallback;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.v4.media.MediaBrowserCompatApi21$SubscriptionCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MediaBrowserCompatApi21$SubscriptionCallbackProxy<T extends MediaBrowserCompatApi21$SubscriptionCallback> extends SubscriptionCallback {
   protected final T mSubscriptionCallback;

   public MediaBrowserCompatApi21$SubscriptionCallbackProxy(T var1) {
      this.mSubscriptionCallback = var1;
   }

   public void onChildrenLoaded(@NonNull String var1, List<MediaItem> var2) {
      ArrayList var4 = null;
      List var3 = var2;
      if(var2 != null) {
         var3 = var2;
         if(var2.size() == 1) {
            var3 = var2;
            if(((MediaItem)var2.get(0)).getMediaId().equals("android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM")) {
               var3 = null;
            }
         }
      }

      ArrayList var6 = var4;
      if(var3 != null) {
         var4 = new ArrayList();
         Iterator var8 = var3.iterator();

         while(true) {
            var6 = var4;
            if(!var8.hasNext()) {
               break;
            }

            MediaItem var7 = (MediaItem)var8.next();
            Parcel var5 = Parcel.obtain();
            var7.writeToParcel(var5, 0);
            var4.add(var5);
         }
      }

      this.mSubscriptionCallback.onChildrenLoaded(var1, var6);
   }

   public void onError(@NonNull String var1) {
      this.mSubscriptionCallback.onError(var1);
   }
}
