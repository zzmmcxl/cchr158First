package android.support.v4.media.session;

import android.media.MediaMetadata;
import android.media.session.PlaybackState;
import android.media.session.MediaController.Callback;
import android.os.Bundle;
import android.support.v4.media.session.MediaControllerCompatApi21$Callback;

class MediaControllerCompatApi21$CallbackProxy<T extends MediaControllerCompatApi21$Callback> extends Callback {
   protected final T mCallback;

   public MediaControllerCompatApi21$CallbackProxy(T var1) {
      this.mCallback = var1;
   }

   public void onMetadataChanged(MediaMetadata var1) {
      this.mCallback.onMetadataChanged(var1);
   }

   public void onPlaybackStateChanged(PlaybackState var1) {
      this.mCallback.onPlaybackStateChanged(var1);
   }

   public void onSessionDestroyed() {
      this.mCallback.onSessionDestroyed();
   }

   public void onSessionEvent(String var1, Bundle var2) {
      this.mCallback.onSessionEvent(var1, var2);
   }
}
