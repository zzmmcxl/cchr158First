package android.support.v4.media;

import android.content.Intent;
import android.os.IBinder;
import android.support.v4.media.MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptorApi21$ServiceBinderProxyApi21;
import android.support.v4.media.MediaBrowserServiceCompatApi21$ServiceImplApi21;

class MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptorApi21 {
   MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptorApi21$ServiceBinderProxyApi21 mBinder;

   public IBinder onBind(Intent var1) {
      return "android.media.browse.MediaBrowserService".equals(var1.getAction())?this.mBinder:null;
   }

   public void onCreate(MediaBrowserServiceCompatApi21$ServiceImplApi21 var1) {
      this.mBinder = new MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptorApi21$ServiceBinderProxyApi21(var1);
   }
}
