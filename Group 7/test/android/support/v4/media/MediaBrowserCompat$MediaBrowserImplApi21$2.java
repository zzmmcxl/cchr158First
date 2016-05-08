package android.support.v4.media;

import android.support.v4.media.MediaBrowserCompat$ItemCallback;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21;
import android.support.v4.media.MediaBrowserCompat$MediaItem;

class MediaBrowserCompat$MediaBrowserImplApi21$2 implements Runnable {
   MediaBrowserCompat$MediaBrowserImplApi21$2(MediaBrowserCompat$MediaBrowserImplApi21 var1, MediaBrowserCompat$ItemCallback var2) {
      this.this$0 = var1;
      this.val$cb = var2;
   }

   public void run() {
      this.val$cb.onItemLoaded((MediaBrowserCompat$MediaItem)null);
   }
}
