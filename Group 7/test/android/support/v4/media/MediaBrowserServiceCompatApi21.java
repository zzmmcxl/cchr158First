package android.support.v4.media;

import android.content.Intent;
import android.os.IBinder;
import android.support.v4.media.MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptorApi21;
import android.support.v4.media.MediaBrowserServiceCompatApi21$ServiceImplApi21;

class MediaBrowserServiceCompatApi21 {
   public static Object createService() {
      return new MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptorApi21();
   }

   public static IBinder onBind(Object var0, Intent var1) {
      return ((MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptorApi21)var0).onBind(var1);
   }

   public static void onCreate(Object var0, MediaBrowserServiceCompatApi21$ServiceImplApi21 var1) {
      ((MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptorApi21)var0).onCreate(var1);
   }
}
