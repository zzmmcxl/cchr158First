package android.support.v4.media;

import android.content.ServiceConnection;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceImplBase;

class MediaBrowserCompat$MediaBrowserServiceImplBase$1 implements Runnable {
   MediaBrowserCompat$MediaBrowserServiceImplBase$1(MediaBrowserCompat$MediaBrowserServiceImplBase var1, ServiceConnection var2) {
      this.this$0 = var1;
      this.val$thisConnection = var2;
   }

   public void run() {
      if(this.val$thisConnection == MediaBrowserCompat$MediaBrowserServiceImplBase.access$700(this.this$0)) {
         MediaBrowserCompat$MediaBrowserServiceImplBase.access$800(this.this$0);
         MediaBrowserCompat$MediaBrowserServiceImplBase.access$900(this.this$0).onConnectionFailed();
      }

   }
}
