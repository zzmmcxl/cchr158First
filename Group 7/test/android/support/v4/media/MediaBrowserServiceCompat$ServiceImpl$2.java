package android.support.v4.media;

import android.os.IBinder;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat$ConnectionRecord;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceCallbacks;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceImpl;

class MediaBrowserServiceCompat$ServiceImpl$2 implements Runnable {
   MediaBrowserServiceCompat$ServiceImpl$2(MediaBrowserServiceCompat$ServiceImpl var1, MediaBrowserServiceCompat$ServiceCallbacks var2) {
      this.this$1 = var1;
      this.val$callbacks = var2;
   }

   public void run() {
      IBinder var1 = this.val$callbacks.asBinder();
      if((MediaBrowserServiceCompat$ConnectionRecord)MediaBrowserServiceCompat.access$500(this.this$1.this$0).remove(var1) != null) {
         ;
      }

   }
}
