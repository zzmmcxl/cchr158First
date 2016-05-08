package android.support.v4.media;

import android.support.v4.media.MediaBrowserCompat$ConnectionCallback;
import android.support.v4.media.MediaBrowserCompatApi21$ConnectionCallback;

class MediaBrowserCompat$ConnectionCallback$StubApi21 implements MediaBrowserCompatApi21$ConnectionCallback {
   private MediaBrowserCompat$ConnectionCallback$StubApi21(MediaBrowserCompat$ConnectionCallback var1) {
      this.this$0 = var1;
   }

   public void onConnected() {
      if(MediaBrowserCompat$ConnectionCallback.access$200(this.this$0) != null) {
         MediaBrowserCompat$ConnectionCallback.access$200(this.this$0).onConnected();
      }

      this.this$0.onConnected();
   }

   public void onConnectionFailed() {
      if(MediaBrowserCompat$ConnectionCallback.access$200(this.this$0) != null) {
         MediaBrowserCompat$ConnectionCallback.access$200(this.this$0).onConnectionFailed();
      }

      this.this$0.onConnectionFailed();
   }

   public void onConnectionSuspended() {
      if(MediaBrowserCompat$ConnectionCallback.access$200(this.this$0) != null) {
         MediaBrowserCompat$ConnectionCallback.access$200(this.this$0).onConnectionSuspended();
      }

      this.this$0.onConnectionSuspended();
   }
}
