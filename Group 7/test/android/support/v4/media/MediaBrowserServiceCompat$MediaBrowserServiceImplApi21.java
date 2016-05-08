package android.support.v4.media;

import android.content.Intent;
import android.os.IBinder;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceImplApi21;
import android.support.v4.media.MediaBrowserServiceCompatApi21;

class MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompat$MediaBrowserServiceImpl {
   private Object mServiceObj;

   MediaBrowserServiceCompat$MediaBrowserServiceImplApi21(MediaBrowserServiceCompat var1) {
      this.this$0 = var1;
   }

   public IBinder onBind(Intent var1) {
      return MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, var1);
   }

   public void onCreate() {
      this.mServiceObj = MediaBrowserServiceCompatApi21.createService();
      MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj, new MediaBrowserServiceCompat$ServiceImplApi21(this.this$0));
   }
}
