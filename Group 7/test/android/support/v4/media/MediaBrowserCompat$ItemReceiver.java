package android.support.v4.media;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompat$ItemCallback;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.os.ResultReceiver;

class MediaBrowserCompat$ItemReceiver extends ResultReceiver {
   private final MediaBrowserCompat$ItemCallback mCallback;
   private final String mMediaId;

   MediaBrowserCompat$ItemReceiver(String var1, MediaBrowserCompat$ItemCallback var2, Handler var3) {
      super(var3);
      this.mMediaId = var1;
      this.mCallback = var2;
   }

   protected void onReceiveResult(int var1, Bundle var2) {
      var2.setClassLoader(MediaBrowserCompat.class.getClassLoader());
      if(var1 == 0 && var2 != null && var2.containsKey("media_item")) {
         Parcelable var3 = var2.getParcelable("media_item");
         if(var3 instanceof MediaBrowserCompat$MediaItem) {
            this.mCallback.onItemLoaded((MediaBrowserCompat$MediaItem)var3);
         } else {
            this.mCallback.onError(this.mMediaId);
         }
      } else {
         this.mCallback.onError(this.mMediaId);
      }
   }
}
