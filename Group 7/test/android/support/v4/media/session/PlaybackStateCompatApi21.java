package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.media.session.PlaybackState.Builder;
import android.media.session.PlaybackState.CustomAction;
import java.util.Iterator;
import java.util.List;

class PlaybackStateCompatApi21 {
   public static long getActions(Object var0) {
      return ((PlaybackState)var0).getActions();
   }

   public static long getActiveQueueItemId(Object var0) {
      return ((PlaybackState)var0).getActiveQueueItemId();
   }

   public static long getBufferedPosition(Object var0) {
      return ((PlaybackState)var0).getBufferedPosition();
   }

   public static List<Object> getCustomActions(Object var0) {
      return ((PlaybackState)var0).getCustomActions();
   }

   public static CharSequence getErrorMessage(Object var0) {
      return ((PlaybackState)var0).getErrorMessage();
   }

   public static long getLastPositionUpdateTime(Object var0) {
      return ((PlaybackState)var0).getLastPositionUpdateTime();
   }

   public static float getPlaybackSpeed(Object var0) {
      return ((PlaybackState)var0).getPlaybackSpeed();
   }

   public static long getPosition(Object var0) {
      return ((PlaybackState)var0).getPosition();
   }

   public static int getState(Object var0) {
      return ((PlaybackState)var0).getState();
   }

   public static Object newInstance(int var0, long var1, long var3, float var5, long var6, CharSequence var8, long var9, List<Object> var11, long var12) {
      Builder var14 = new Builder();
      var14.setState(var0, var1, var5, var9);
      var14.setBufferedPosition(var3);
      var14.setActions(var6);
      var14.setErrorMessage(var8);
      Iterator var15 = var11.iterator();

      while(var15.hasNext()) {
         var14.addCustomAction((CustomAction)var15.next());
      }

      var14.setActiveQueueItemId(var12);
      return var14.build();
   }
}
