package android.support.v4.media.session;

import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat$Callback;
import android.support.v4.media.session.MediaControllerCompatApi21$Callback;
import android.support.v4.media.session.PlaybackStateCompat;

class MediaControllerCompat$Callback$StubApi21 implements MediaControllerCompatApi21$Callback {
   private MediaControllerCompat$Callback$StubApi21(MediaControllerCompat$Callback var1) {
      this.this$0 = var1;
   }

   public void onMetadataChanged(Object var1) {
      this.this$0.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(var1));
   }

   public void onPlaybackStateChanged(Object var1) {
      this.this$0.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(var1));
   }

   public void onSessionDestroyed() {
      this.this$0.onSessionDestroyed();
   }

   public void onSessionEvent(String var1, Bundle var2) {
      this.this$0.onSessionEvent(var1, var2);
   }
}
