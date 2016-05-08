package android.support.v4.media.session;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat$Callback;
import android.support.v4.media.session.MediaSessionCompatApi21$Callback;

class MediaSessionCompat$Callback$StubApi21 implements MediaSessionCompatApi21$Callback {
   private MediaSessionCompat$Callback$StubApi21(MediaSessionCompat$Callback var1) {
      this.this$0 = var1;
   }

   public void onCommand(String var1, Bundle var2, ResultReceiver var3) {
      this.this$0.onCommand(var1, var2, var3);
   }

   public void onCustomAction(String var1, Bundle var2) {
      if(var1.equals("android.support.v4.media.session.action.PLAY_FROM_URI")) {
         Uri var3 = (Uri)var2.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
         var2 = (Bundle)var2.getParcelable("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
         this.this$0.onPlayFromUri(var3, var2);
      } else {
         this.this$0.onCustomAction(var1, var2);
      }
   }

   public void onFastForward() {
      this.this$0.onFastForward();
   }

   public boolean onMediaButtonEvent(Intent var1) {
      return this.this$0.onMediaButtonEvent(var1);
   }

   public void onPause() {
      this.this$0.onPause();
   }

   public void onPlay() {
      this.this$0.onPlay();
   }

   public void onPlayFromMediaId(String var1, Bundle var2) {
      this.this$0.onPlayFromMediaId(var1, var2);
   }

   public void onPlayFromSearch(String var1, Bundle var2) {
      this.this$0.onPlayFromSearch(var1, var2);
   }

   public void onRewind() {
      this.this$0.onRewind();
   }

   public void onSeekTo(long var1) {
      this.this$0.onSeekTo(var1);
   }

   public void onSetRating(Object var1) {
      this.this$0.onSetRating(RatingCompat.fromRating(var1));
   }

   public void onSkipToNext() {
      this.this$0.onSkipToNext();
   }

   public void onSkipToPrevious() {
      this.this$0.onSkipToPrevious();
   }

   public void onSkipToQueueItem(long var1) {
      this.this$0.onSkipToQueueItem(var1);
   }

   public void onStop() {
      this.this$0.onStop();
   }
}
