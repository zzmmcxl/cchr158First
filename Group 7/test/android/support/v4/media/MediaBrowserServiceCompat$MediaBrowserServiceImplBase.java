package android.support.v4.media;

import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl;

class MediaBrowserServiceCompat$MediaBrowserServiceImplBase implements MediaBrowserServiceCompat$MediaBrowserServiceImpl {
   private Messenger mMessenger;

   MediaBrowserServiceCompat$MediaBrowserServiceImplBase(MediaBrowserServiceCompat var1) {
      this.this$0 = var1;
   }

   public IBinder onBind(Intent var1) {
      return "android.media.browse.MediaBrowserService".equals(var1.getAction())?this.mMessenger.getBinder():null;
   }

   public void onCreate() {
      this.mMessenger = new Messenger(MediaBrowserServiceCompat.access$100(this.this$0));
   }
}
