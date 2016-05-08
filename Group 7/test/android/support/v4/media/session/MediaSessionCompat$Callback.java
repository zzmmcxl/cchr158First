package android.support.v4.media.session;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.os.Build.VERSION;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat$1;
import android.support.v4.media.session.MediaSessionCompat$Callback$StubApi21;
import android.support.v4.media.session.MediaSessionCompat$Callback$StubApi23;
import android.support.v4.media.session.MediaSessionCompatApi21;
import android.support.v4.media.session.MediaSessionCompatApi23;

public abstract class MediaSessionCompat$Callback {
   final Object mCallbackObj;

   public MediaSessionCompat$Callback() {
      if(VERSION.SDK_INT >= 23) {
         this.mCallbackObj = MediaSessionCompatApi23.createCallback(new MediaSessionCompat$Callback$StubApi23(this, (MediaSessionCompat$1)null));
      } else if(VERSION.SDK_INT >= 21) {
         this.mCallbackObj = MediaSessionCompatApi21.createCallback(new MediaSessionCompat$Callback$StubApi21(this, (MediaSessionCompat$1)null));
      } else {
         this.mCallbackObj = null;
      }
   }

   public void onCommand(String var1, Bundle var2, ResultReceiver var3) {
   }

   public void onCustomAction(String var1, Bundle var2) {
   }

   public void onFastForward() {
   }

   public boolean onMediaButtonEvent(Intent var1) {
      return false;
   }

   public void onPause() {
   }

   public void onPlay() {
   }

   public void onPlayFromMediaId(String var1, Bundle var2) {
   }

   public void onPlayFromSearch(String var1, Bundle var2) {
   }

   public void onPlayFromUri(Uri var1, Bundle var2) {
   }

   public void onRewind() {
   }

   public void onSeekTo(long var1) {
   }

   public void onSetRating(RatingCompat var1) {
   }

   public void onSkipToNext() {
   }

   public void onSkipToPrevious() {
   }

   public void onSkipToQueueItem(long var1) {
   }

   public void onStop() {
   }
}
