package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat$ConnectionRecord;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceCallbacks;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceImpl;
import android.util.Log;

class MediaBrowserServiceCompat$ServiceImpl$3 implements Runnable {
   MediaBrowserServiceCompat$ServiceImpl$3(MediaBrowserServiceCompat$ServiceImpl var1, MediaBrowserServiceCompat$ServiceCallbacks var2, String var3, Bundle var4) {
      this.this$1 = var1;
      this.val$callbacks = var2;
      this.val$id = var3;
      this.val$options = var4;
   }

   public void run() {
      IBinder var1 = this.val$callbacks.asBinder();
      MediaBrowserServiceCompat$ConnectionRecord var2 = (MediaBrowserServiceCompat$ConnectionRecord)MediaBrowserServiceCompat.access$500(this.this$1.this$0).get(var1);
      if(var2 == null) {
         Log.w("MediaBrowserServiceCompat", "addSubscription for callback that isn\'t registered id=" + this.val$id);
      } else {
         MediaBrowserServiceCompat.access$700(this.this$1.this$0, this.val$id, var2, this.val$options);
      }
   }
}
