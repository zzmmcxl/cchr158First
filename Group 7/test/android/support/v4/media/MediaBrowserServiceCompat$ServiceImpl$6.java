package android.support.v4.media;

import android.os.IBinder;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat$1;
import android.support.v4.media.MediaBrowserServiceCompat$ConnectionRecord;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceCallbacks;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceImpl;

class MediaBrowserServiceCompat$ServiceImpl$6 implements Runnable {
   MediaBrowserServiceCompat$ServiceImpl$6(MediaBrowserServiceCompat$ServiceImpl var1, MediaBrowserServiceCompat$ServiceCallbacks var2) {
      this.this$1 = var1;
      this.val$callbacks = var2;
   }

   public void run() {
      IBinder var1 = this.val$callbacks.asBinder();
      MediaBrowserServiceCompat.access$500(this.this$1.this$0).remove(var1);
      MediaBrowserServiceCompat$ConnectionRecord var2 = new MediaBrowserServiceCompat$ConnectionRecord(this.this$1.this$0, (MediaBrowserServiceCompat$1)null);
      var2.callbacks = this.val$callbacks;
      MediaBrowserServiceCompat.access$500(this.this$1.this$0).put(var1, var2);
   }
}
