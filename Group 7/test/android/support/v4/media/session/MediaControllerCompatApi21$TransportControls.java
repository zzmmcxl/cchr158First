package android.support.v4.media.session;

import android.media.Rating;
import android.media.session.MediaController.TransportControls;
import android.os.Bundle;

public class MediaControllerCompatApi21$TransportControls {
   public static void fastForward(Object var0) {
      ((TransportControls)var0).fastForward();
   }

   public static void pause(Object var0) {
      ((TransportControls)var0).pause();
   }

   public static void play(Object var0) {
      ((TransportControls)var0).play();
   }

   public static void playFromMediaId(Object var0, String var1, Bundle var2) {
      ((TransportControls)var0).playFromMediaId(var1, var2);
   }

   public static void playFromSearch(Object var0, String var1, Bundle var2) {
      ((TransportControls)var0).playFromSearch(var1, var2);
   }

   public static void rewind(Object var0) {
      ((TransportControls)var0).rewind();
   }

   public static void seekTo(Object var0, long var1) {
      ((TransportControls)var0).seekTo(var1);
   }

   public static void sendCustomAction(Object var0, String var1, Bundle var2) {
      ((TransportControls)var0).sendCustomAction(var1, var2);
   }

   public static void setRating(Object var0, Object var1) {
      ((TransportControls)var0).setRating((Rating)var1);
   }

   public static void skipToNext(Object var0) {
      ((TransportControls)var0).skipToNext();
   }

   public static void skipToPrevious(Object var0) {
      ((TransportControls)var0).skipToPrevious();
   }

   public static void skipToQueueItem(Object var0, long var1) {
      ((TransportControls)var0).skipToQueueItem(var1);
   }

   public static void stop(Object var0) {
      ((TransportControls)var0).stop();
   }
}
