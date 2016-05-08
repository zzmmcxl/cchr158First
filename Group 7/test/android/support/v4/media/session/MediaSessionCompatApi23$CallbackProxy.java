package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompatApi21$CallbackProxy;
import android.support.v4.media.session.MediaSessionCompatApi23$Callback;

class MediaSessionCompatApi23$CallbackProxy<T extends MediaSessionCompatApi23$Callback> extends MediaSessionCompatApi21$CallbackProxy<T> {
   public MediaSessionCompatApi23$CallbackProxy(T var1) {
      super(var1);
   }

   public void onPlayFromUri(Uri var1, Bundle var2) {
      ((MediaSessionCompatApi23$Callback)this.mCallback).onPlayFromUri(var1, var2);
   }
}
