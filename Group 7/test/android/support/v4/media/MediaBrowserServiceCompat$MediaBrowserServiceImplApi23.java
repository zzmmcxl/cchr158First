package android.support.v4.media;

import android.content.Intent;
import android.os.IBinder;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat$1;
import android.support.v4.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceImplApi23;
import android.support.v4.media.MediaBrowserServiceCompatApi23;

class MediaBrowserServiceCompat$MediaBrowserServiceImplApi23 implements MediaBrowserServiceCompat$MediaBrowserServiceImpl {
   private Object mServiceObj;

   MediaBrowserServiceCompat$MediaBrowserServiceImplApi23(MediaBrowserServiceCompat var1) {
      this.this$0 = var1;
   }

   public IBinder onBind(Intent var1) {
      return MediaBrowserServiceCompatApi23.onBind(this.mServiceObj, var1);
   }

   public void onCreate() {
      this.mServiceObj = MediaBrowserServiceCompatApi23.createService();
      MediaBrowserServiceCompatApi23.onCreate(this.mServiceObj, new MediaBrowserServiceCompat$ServiceImplApi23(this.this$0, (MediaBrowserServiceCompat$1)null));
   }
}
