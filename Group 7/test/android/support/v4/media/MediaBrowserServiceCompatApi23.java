package android.support.v4.media;

import android.support.v4.media.MediaBrowserServiceCompatApi21;
import android.support.v4.media.MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptorApi23;
import android.support.v4.media.MediaBrowserServiceCompatApi23$ServiceImplApi23;

class MediaBrowserServiceCompatApi23 extends MediaBrowserServiceCompatApi21 {
   private static final String TAG = "MediaBrowserServiceCompatApi21";

   public static Object createService() {
      return new MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptorApi23();
   }

   public static void onCreate(Object var0, MediaBrowserServiceCompatApi23$ServiceImplApi23 var1) {
      ((MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptorApi23)var0).onCreate(var1);
   }
}
