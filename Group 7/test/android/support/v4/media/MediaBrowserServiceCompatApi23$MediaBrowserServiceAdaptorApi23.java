package android.support.v4.media;

import android.support.v4.media.MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptorApi21;
import android.support.v4.media.MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptorApi23$ServiceBinderProxyApi23;
import android.support.v4.media.MediaBrowserServiceCompatApi23$ServiceImplApi23;

class MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptorApi23 extends MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptorApi21 {
   public void onCreate(MediaBrowserServiceCompatApi23$ServiceImplApi23 var1) {
      this.mBinder = new MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptorApi23$ServiceBinderProxyApi23(var1);
   }
}
