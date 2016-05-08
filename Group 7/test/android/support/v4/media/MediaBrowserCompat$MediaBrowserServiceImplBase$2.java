package android.support.v4.media;

import android.support.v4.media.MediaBrowserCompat$ItemCallback;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceImplBase;

class MediaBrowserCompat$MediaBrowserServiceImplBase$2 implements Runnable {
   MediaBrowserCompat$MediaBrowserServiceImplBase$2(MediaBrowserCompat$MediaBrowserServiceImplBase var1, MediaBrowserCompat$ItemCallback var2, String var3) {
      this.this$0 = var1;
      this.val$cb = var2;
      this.val$mediaId = var3;
   }

   public void run() {
      this.val$cb.onError(this.val$mediaId);
   }
}
