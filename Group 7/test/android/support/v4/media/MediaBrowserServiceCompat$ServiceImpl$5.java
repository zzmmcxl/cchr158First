package android.support.v4.media;

import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceImpl;
import android.support.v4.os.ResultReceiver;

class MediaBrowserServiceCompat$ServiceImpl$5 implements Runnable {
   MediaBrowserServiceCompat$ServiceImpl$5(MediaBrowserServiceCompat$ServiceImpl var1, String var2, ResultReceiver var3) {
      this.this$1 = var1;
      this.val$mediaId = var2;
      this.val$receiver = var3;
   }

   public void run() {
      MediaBrowserServiceCompat.access$900(this.this$1.this$0, this.val$mediaId, this.val$receiver);
   }
}
