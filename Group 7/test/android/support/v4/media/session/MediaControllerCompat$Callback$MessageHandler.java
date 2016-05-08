package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat$Callback;
import android.support.v4.media.session.MediaControllerCompat$PlaybackInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import java.util.List;

class MediaControllerCompat$Callback$MessageHandler extends Handler {
   private static final int MSG_DESTROYED = 8;
   private static final int MSG_EVENT = 1;
   private static final int MSG_UPDATE_EXTRAS = 7;
   private static final int MSG_UPDATE_METADATA = 3;
   private static final int MSG_UPDATE_PLAYBACK_STATE = 2;
   private static final int MSG_UPDATE_QUEUE = 5;
   private static final int MSG_UPDATE_QUEUE_TITLE = 6;
   private static final int MSG_UPDATE_VOLUME = 4;

   public MediaControllerCompat$Callback$MessageHandler(MediaControllerCompat$Callback var1, Looper var2) {
      super(var2);
      this.this$0 = var1;
   }

   public void handleMessage(Message var1) {
      if(MediaControllerCompat$Callback.access$300(this.this$0)) {
         switch(var1.what) {
         case 1:
            this.this$0.onSessionEvent((String)var1.obj, var1.getData());
            return;
         case 2:
            this.this$0.onPlaybackStateChanged((PlaybackStateCompat)var1.obj);
            return;
         case 3:
            this.this$0.onMetadataChanged((MediaMetadataCompat)var1.obj);
            return;
         case 4:
            this.this$0.onAudioInfoChanged((MediaControllerCompat$PlaybackInfo)var1.obj);
            return;
         case 5:
            this.this$0.onQueueChanged((List)var1.obj);
            return;
         case 6:
            this.this$0.onQueueTitleChanged((CharSequence)var1.obj);
            return;
         case 7:
            this.this$0.onExtrasChanged((Bundle)var1.obj);
            return;
         case 8:
            this.this$0.onSessionDestroyed();
            return;
         default:
         }
      }
   }

   public void post(int var1, Object var2, Bundle var3) {
      Message var4 = this.obtainMessage(var1, var2);
      var4.setData(var3);
      var4.sendToTarget();
   }
}
