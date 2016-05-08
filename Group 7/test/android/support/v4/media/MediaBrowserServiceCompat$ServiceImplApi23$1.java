package android.support.v4.media;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceImplApi23;
import android.support.v4.media.MediaBrowserServiceCompatApi23$ItemCallback;
import android.support.v4.os.ResultReceiver;

class MediaBrowserServiceCompat$ServiceImplApi23$1 extends ResultReceiver {
   MediaBrowserServiceCompat$ServiceImplApi23$1(MediaBrowserServiceCompat$ServiceImplApi23 var1, Handler var2, MediaBrowserServiceCompatApi23$ItemCallback var3) {
      super(var2);
      this.this$1 = var1;
      this.val$cb = var3;
   }

   protected void onReceiveResult(int var1, Bundle var2) {
      MediaBrowserCompat$MediaItem var4 = (MediaBrowserCompat$MediaItem)var2.getParcelable("media_item");
      Parcel var3 = null;
      if(var4 != null) {
         var3 = Parcel.obtain();
         var4.writeToParcel(var3, 0);
      }

      this.val$cb.onItemLoaded(var1, var2, var3);
   }
}
