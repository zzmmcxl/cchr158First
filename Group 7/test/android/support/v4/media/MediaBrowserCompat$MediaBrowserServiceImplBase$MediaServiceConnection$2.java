package android.support.v4.media;

import android.content.ComponentName;
import android.os.Messenger;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceImplBase;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection;
import android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper;

class MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection$2 implements Runnable {
   MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection$2(MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection var1, ComponentName var2) {
      this.this$1 = var1;
      this.val$name = var2;
   }

   public void run() {
      if(MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection.access$1000(this.this$1, "onServiceDisconnected")) {
         MediaBrowserCompat$MediaBrowserServiceImplBase.access$1102(this.this$1.this$0, (MediaBrowserCompat$ServiceBinderWrapper)null);
         MediaBrowserCompat$MediaBrowserServiceImplBase.access$1202(this.this$1.this$0, (Messenger)null);
         MediaBrowserCompat$MediaBrowserServiceImplBase.access$1300(this.this$1.this$0).setCallbacksMessenger((Messenger)null);
         MediaBrowserCompat$MediaBrowserServiceImplBase.access$1402(this.this$1.this$0, 3);
         MediaBrowserCompat$MediaBrowserServiceImplBase.access$900(this.this$1.this$0).onConnectionSuspended();
      }
   }
}
