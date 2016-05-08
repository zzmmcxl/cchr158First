package android.support.v4.media.session;

import android.content.Intent;
import android.media.Rating;
import android.media.session.MediaSession.Callback;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.media.session.MediaSessionCompatApi21$Callback;

class MediaSessionCompatApi21$CallbackProxy<T extends MediaSessionCompatApi21$Callback> extends Callback {
   protected final T mCallback;

   public MediaSessionCompatApi21$CallbackProxy(T var1) {
      this.mCallback = var1;
   }

   public void onCommand(String var1, Bundle var2, ResultReceiver var3) {
      this.mCallback.onCommand(var1, var2, var3);
   }

   public void onCustomAction(String var1, Bundle var2) {
      this.mCallback.onCustomAction(var1, var2);
   }

   public void onFastForward() {
      this.mCallback.onFastForward();
   }

   public boolean onMediaButtonEvent(Intent var1) {
      return this.mCallback.onMediaButtonEvent(var1) || super.onMediaButtonEvent(var1);
   }

   public void onPause() {
      this.mCallback.onPause();
   }

   public void onPlay() {
      this.mCallback.onPlay();
   }

   public void onPlayFromMediaId(String var1, Bundle var2) {
      this.mCallback.onPlayFromMediaId(var1, var2);
   }

   public void onPlayFromSearch(String var1, Bundle var2) {
      this.mCallback.onPlayFromSearch(var1, var2);
   }

   public void onRewind() {
      this.mCallback.onRewind();
   }

   public void onSeekTo(long var1) {
      this.mCallback.onSeekTo(var1);
   }

   public void onSetRating(Rating var1) {
      this.mCallback.onSetRating(var1);
   }

   public void onSkipToNext() {
      this.mCallback.onSkipToNext();
   }

   public void onSkipToPrevious() {
      this.mCallback.onSkipToPrevious();
   }

   public void onSkipToQueueItem(long var1) {
      this.mCallback.onSkipToQueueItem(var1);
   }

   public void onStop() {
      this.mCallback.onStop();
   }
}
