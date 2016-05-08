package android.support.v4.media;

import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.v4.media.MediaBrowserCompat$ItemCallback;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaBrowserCompatApi23$ItemCallback;

class MediaBrowserCompat$ItemCallback$StubApi23 implements MediaBrowserCompatApi23$ItemCallback {
   private MediaBrowserCompat$ItemCallback$StubApi23(MediaBrowserCompat$ItemCallback var1) {
      this.this$0 = var1;
   }

   public void onError(@NonNull String var1) {
      this.this$0.onError(var1);
   }

   public void onItemLoaded(Parcel var1) {
      var1.setDataPosition(0);
      MediaBrowserCompat$MediaItem var2 = (MediaBrowserCompat$MediaItem)MediaBrowserCompat$MediaItem.CREATOR.createFromParcel(var1);
      var1.recycle();
      this.this$0.onItemLoaded(var2);
   }
}
