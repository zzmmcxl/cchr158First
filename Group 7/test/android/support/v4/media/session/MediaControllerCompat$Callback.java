package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.Build.VERSION;
import android.os.IBinder.DeathRecipient;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat$1;
import android.support.v4.media.session.MediaControllerCompat$Callback$MessageHandler;
import android.support.v4.media.session.MediaControllerCompat$Callback$StubApi21;
import android.support.v4.media.session.MediaControllerCompat$Callback$StubCompat;
import android.support.v4.media.session.MediaControllerCompat$PlaybackInfo;
import android.support.v4.media.session.MediaControllerCompatApi21;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.PlaybackStateCompat;
import java.util.List;

public abstract class MediaControllerCompat$Callback implements DeathRecipient {
   private final Object mCallbackObj;
   private MediaControllerCompat$Callback$MessageHandler mHandler;
   private boolean mRegistered = false;

   public MediaControllerCompat$Callback() {
      if(VERSION.SDK_INT >= 21) {
         this.mCallbackObj = MediaControllerCompatApi21.createCallback(new MediaControllerCompat$Callback$StubApi21(this, (MediaControllerCompat$1)null));
      } else {
         this.mCallbackObj = new MediaControllerCompat$Callback$StubCompat(this, (MediaControllerCompat$1)null);
      }
   }

   private void setHandler(Handler var1) {
      this.mHandler = new MediaControllerCompat$Callback$MessageHandler(this, var1.getLooper());
   }

   public void binderDied() {
      this.onSessionDestroyed();
   }

   public void onAudioInfoChanged(MediaControllerCompat$PlaybackInfo var1) {
   }

   public void onExtrasChanged(Bundle var1) {
   }

   public void onMetadataChanged(MediaMetadataCompat var1) {
   }

   public void onPlaybackStateChanged(PlaybackStateCompat var1) {
   }

   public void onQueueChanged(List<MediaSessionCompat$QueueItem> var1) {
   }

   public void onQueueTitleChanged(CharSequence var1) {
   }

   public void onSessionDestroyed() {
   }

   public void onSessionEvent(String var1, Bundle var2) {
   }
}
