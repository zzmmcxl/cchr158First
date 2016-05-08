package android.support.v4.media;

import android.support.v4.media.MediaBrowserCompat$ItemCallback;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21;

class MediaBrowserCompat$MediaBrowserImplApi21$1 implements Runnable {
   MediaBrowserCompat$MediaBrowserImplApi21$1(MediaBrowserCompat$MediaBrowserImplApi21 var1, MediaBrowserCompat$ItemCallback var2, String var3) {
      this.this$0 = var1;
      this.val$cb = var2;
      this.val$mediaId = var3;
   }

   public void run() {
      this.val$cb.onError(this.val$mediaId);
   }
}
