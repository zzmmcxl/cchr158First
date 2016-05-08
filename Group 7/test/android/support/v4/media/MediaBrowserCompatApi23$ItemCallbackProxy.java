package android.support.v4.media;

import android.media.browse.MediaBrowser.ItemCallback;
import android.media.browse.MediaBrowser.MediaItem;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.v4.media.MediaBrowserCompatApi23$ItemCallback;

class MediaBrowserCompatApi23$ItemCallbackProxy<T extends MediaBrowserCompatApi23$ItemCallback> extends ItemCallback {
   protected final T mItemCallback;

   public MediaBrowserCompatApi23$ItemCallbackProxy(T var1) {
      this.mItemCallback = var1;
   }

   public void onError(@NonNull String var1) {
      this.mItemCallback.onError(var1);
   }

   public void onItemLoaded(MediaItem var1) {
      Parcel var2 = Parcel.obtain();
      var1.writeToParcel(var2, 0);
      this.mItemCallback.onItemLoaded(var2);
   }
}
