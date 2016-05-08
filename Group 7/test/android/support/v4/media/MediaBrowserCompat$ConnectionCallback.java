package android.support.v4.media;

import android.os.Build.VERSION;
import android.support.v4.media.MediaBrowserCompat$1;
import android.support.v4.media.MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal;
import android.support.v4.media.MediaBrowserCompat$ConnectionCallback$StubApi21;
import android.support.v4.media.MediaBrowserCompatApi21;

public class MediaBrowserCompat$ConnectionCallback {
   private MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal mConnectionCallbackInternal;
   final Object mConnectionCallbackObj;

   public MediaBrowserCompat$ConnectionCallback() {
      if(VERSION.SDK_INT >= 21) {
         this.mConnectionCallbackObj = MediaBrowserCompatApi21.createConnectionCallback(new MediaBrowserCompat$ConnectionCallback$StubApi21(this, (MediaBrowserCompat$1)null));
      } else {
         this.mConnectionCallbackObj = null;
      }
   }

   public void onConnected() {
   }

   public void onConnectionFailed() {
   }

   public void onConnectionSuspended() {
   }

   void setInternalConnectionCallback(MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal var1) {
      this.mConnectionCallbackInternal = var1;
   }
}
