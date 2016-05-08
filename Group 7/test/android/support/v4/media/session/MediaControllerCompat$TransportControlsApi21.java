package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaControllerCompat$TransportControls;
import android.support.v4.media.session.MediaControllerCompatApi21$TransportControls;
import android.support.v4.media.session.PlaybackStateCompat$CustomAction;

class MediaControllerCompat$TransportControlsApi21 extends MediaControllerCompat$TransportControls {
   protected final Object mControlsObj;

   public MediaControllerCompat$TransportControlsApi21(Object var1) {
      this.mControlsObj = var1;
   }

   public void fastForward() {
      MediaControllerCompatApi21$TransportControls.fastForward(this.mControlsObj);
   }

   public void pause() {
      MediaControllerCompatApi21$TransportControls.pause(this.mControlsObj);
   }

   public void play() {
      MediaControllerCompatApi21$TransportControls.play(this.mControlsObj);
   }

   public void playFromMediaId(String var1, Bundle var2) {
      MediaControllerCompatApi21$TransportControls.playFromMediaId(this.mControlsObj, var1, var2);
   }

   public void playFromSearch(String var1, Bundle var2) {
      MediaControllerCompatApi21$TransportControls.playFromSearch(this.mControlsObj, var1, var2);
   }

   public void playFromUri(Uri var1, Bundle var2) {
      if(var1 != null && !Uri.EMPTY.equals(var1)) {
         Bundle var3 = new Bundle();
         var3.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", var1);
         var3.putParcelable("android.support.v4.media.session.action.ARGUMENT_EXTRAS", var2);
         this.sendCustomAction("android.support.v4.media.session.action.PLAY_FROM_URI", var3);
      } else {
         throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
      }
   }

   public void rewind() {
      MediaControllerCompatApi21$TransportControls.rewind(this.mControlsObj);
   }

   public void seekTo(long var1) {
      MediaControllerCompatApi21$TransportControls.seekTo(this.mControlsObj, var1);
   }

   public void sendCustomAction(PlaybackStateCompat$CustomAction var1, Bundle var2) {
      MediaControllerCompatApi21$TransportControls.sendCustomAction(this.mControlsObj, var1.getAction(), var2);
   }

   public void sendCustomAction(String var1, Bundle var2) {
      MediaControllerCompatApi21$TransportControls.sendCustomAction(this.mControlsObj, var1, var2);
   }

   public void setRating(RatingCompat var1) {
      Object var2 = this.mControlsObj;
      Object var3;
      if(var1 != null) {
         var3 = var1.getRating();
      } else {
         var3 = null;
      }

      MediaControllerCompatApi21$TransportControls.setRating(var2, var3);
   }

   public void skipToNext() {
      MediaControllerCompatApi21$TransportControls.skipToNext(this.mControlsObj);
   }

   public void skipToPrevious() {
      MediaControllerCompatApi21$TransportControls.skipToPrevious(this.mControlsObj);
   }

   public void skipToQueueItem(long var1) {
      MediaControllerCompatApi21$TransportControls.skipToQueueItem(this.mControlsObj, var1);
   }

   public void stop() {
      MediaControllerCompatApi21$TransportControls.stop(this.mControlsObj);
   }
}
