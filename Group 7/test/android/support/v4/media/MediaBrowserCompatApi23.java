package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.ItemCallback;
import android.support.v4.media.MediaBrowserCompatApi23$ItemCallback;
import android.support.v4.media.MediaBrowserCompatApi23$ItemCallbackProxy;

class MediaBrowserCompatApi23 {
   public static Object createItemCallback(MediaBrowserCompatApi23$ItemCallback var0) {
      return new MediaBrowserCompatApi23$ItemCallbackProxy(var0);
   }

   public static void getItem(Object var0, String var1, Object var2) {
      ((MediaBrowser)var0).getItem(var1, (ItemCallback)var2);
   }
}
