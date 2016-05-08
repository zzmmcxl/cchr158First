package android.support.v4.media;

import android.media.browse.MediaBrowser.ConnectionCallback;
import android.support.v4.media.MediaBrowserCompatApi21$ConnectionCallback;

class MediaBrowserCompatApi21$ConnectionCallbackProxy<T extends MediaBrowserCompatApi21$ConnectionCallback> extends ConnectionCallback {
   protected final T mConnectionCallback;

   public MediaBrowserCompatApi21$ConnectionCallbackProxy(T var1) {
      this.mConnectionCallback = var1;
   }

   public void onConnected() {
      this.mConnectionCallback.onConnected();
   }

   public void onConnectionFailed() {
      this.mConnectionCallback.onConnectionFailed();
   }

   public void onConnectionSuspended() {
      this.mConnectionCallback.onConnectionSuspended();
   }
}
