package android.support.v4.media;

import android.os.ResultReceiver;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptorApi21$ServiceBinderProxyApi21;
import android.support.v4.media.MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptorApi23$ServiceBinderProxyApi23$1;
import android.support.v4.media.MediaBrowserServiceCompatApi23$ServiceImplApi23;
import android.util.Log;

class MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptorApi23$ServiceBinderProxyApi23 extends MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptorApi21$ServiceBinderProxyApi21 {
   MediaBrowserServiceCompatApi23$ServiceImplApi23 mServiceImpl;

   MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptorApi23$ServiceBinderProxyApi23(MediaBrowserServiceCompatApi23$ServiceImplApi23 var1) {
      super(var1);
      this.mServiceImpl = var1;
   }

   public void getMediaItem(String var1, ResultReceiver var2) {
      String var3;
      label14: {
         Object var6;
         try {
            var3 = (String)MediaBrowserService.class.getDeclaredField("KEY_MEDIA_ITEM").get((Object)null);
            break label14;
         } catch (IllegalAccessException var4) {
            var6 = var4;
         } catch (NoSuchFieldException var5) {
            var6 = var5;
         }

         Log.i("MediaBrowserServiceCompatApi21", "Failed to get KEY_MEDIA_ITEM via reflection", (Throwable)var6);
         return;
      }

      this.mServiceImpl.getMediaItem(var1, new MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptorApi23$ServiceBinderProxyApi23$1(this, var3, var2));
   }
}
