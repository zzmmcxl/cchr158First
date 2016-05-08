package android.support.v4.media;

import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceImplApi21;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceImplApi23$1;
import android.support.v4.media.MediaBrowserServiceCompatApi23$ItemCallback;
import android.support.v4.media.MediaBrowserServiceCompatApi23$ServiceImplApi23;

class MediaBrowserServiceCompat$ServiceImplApi23 extends MediaBrowserServiceCompat$ServiceImplApi21 implements MediaBrowserServiceCompatApi23$ServiceImplApi23 {
   private MediaBrowserServiceCompat$ServiceImplApi23(MediaBrowserServiceCompat var1) {
      super(var1);
      this.this$0 = var1;
   }

   public void getMediaItem(String var1, MediaBrowserServiceCompatApi23$ItemCallback var2) {
      MediaBrowserServiceCompat$ServiceImplApi23$1 var3 = new MediaBrowserServiceCompat$ServiceImplApi23$1(this, MediaBrowserServiceCompat.access$100(this.this$0), var2);
      this.mServiceImpl.getMediaItem(var1, var3);
   }
}
