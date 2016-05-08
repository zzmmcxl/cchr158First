package android.support.v4.media.session;

import android.support.v4.media.session.MediaSessionCompatApi23$Callback;
import android.support.v4.media.session.MediaSessionCompatApi23$CallbackProxy;

class MediaSessionCompatApi23 {
   public static Object createCallback(MediaSessionCompatApi23$Callback var0) {
      return new MediaSessionCompatApi23$CallbackProxy(var0);
   }
}
