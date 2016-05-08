package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaController.Callback;
import android.media.session.MediaSession.Token;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v4.media.session.MediaControllerCompatApi21$Callback;
import android.support.v4.media.session.MediaControllerCompatApi21$CallbackProxy;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;

class MediaControllerCompatApi21 {
   public static void adjustVolume(Object var0, int var1, int var2) {
      ((MediaController)var0).adjustVolume(var1, var2);
   }

   public static Object createCallback(MediaControllerCompatApi21$Callback var0) {
      return new MediaControllerCompatApi21$CallbackProxy(var0);
   }

   public static boolean dispatchMediaButtonEvent(Object var0, KeyEvent var1) {
      return ((MediaController)var0).dispatchMediaButtonEvent(var1);
   }

   public static Object fromToken(Context var0, Object var1) {
      return new MediaController(var0, (Token)var1);
   }

   public static Bundle getExtras(Object var0) {
      return ((MediaController)var0).getExtras();
   }

   public static long getFlags(Object var0) {
      return ((MediaController)var0).getFlags();
   }

   public static Object getMetadata(Object var0) {
      return ((MediaController)var0).getMetadata();
   }

   public static String getPackageName(Object var0) {
      return ((MediaController)var0).getPackageName();
   }

   public static Object getPlaybackInfo(Object var0) {
      return ((MediaController)var0).getPlaybackInfo();
   }

   public static Object getPlaybackState(Object var0) {
      return ((MediaController)var0).getPlaybackState();
   }

   public static List<Object> getQueue(Object var0) {
      List var1 = ((MediaController)var0).getQueue();
      return var1 == null?null:new ArrayList(var1);
   }

   public static CharSequence getQueueTitle(Object var0) {
      return ((MediaController)var0).getQueueTitle();
   }

   public static int getRatingType(Object var0) {
      return ((MediaController)var0).getRatingType();
   }

   public static PendingIntent getSessionActivity(Object var0) {
      return ((MediaController)var0).getSessionActivity();
   }

   public static Object getTransportControls(Object var0) {
      return ((MediaController)var0).getTransportControls();
   }

   public static void registerCallback(Object var0, Object var1, Handler var2) {
      ((MediaController)var0).registerCallback((Callback)var1, var2);
   }

   public static void sendCommand(Object var0, String var1, Bundle var2, ResultReceiver var3) {
      ((MediaController)var0).sendCommand(var1, var2, var3);
   }

   public static void setVolumeTo(Object var0, int var1, int var2) {
      ((MediaController)var0).setVolumeTo(var1, var2);
   }

   public static void unregisterCallback(Object var0, Object var1) {
      ((MediaController)var0).unregisterCallback((Callback)var1);
   }
}
