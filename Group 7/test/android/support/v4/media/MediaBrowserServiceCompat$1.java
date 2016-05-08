package android.support.v4.media;

import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat$ConnectionRecord;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.util.Log;
import java.util.Iterator;

class MediaBrowserServiceCompat$1 implements Runnable {
   MediaBrowserServiceCompat$1(MediaBrowserServiceCompat var1, MediaSessionCompat$Token var2) {
      this.this$0 = var1;
      this.val$token = var2;
   }

   public void run() {
      Iterator var1 = MediaBrowserServiceCompat.access$500(this.this$0).keySet().iterator();

      while(var1.hasNext()) {
         IBinder var2 = (IBinder)var1.next();
         MediaBrowserServiceCompat$ConnectionRecord var3 = (MediaBrowserServiceCompat$ConnectionRecord)MediaBrowserServiceCompat.access$500(this.this$0).get(var2);

         try {
            var3.callbacks.onConnect(var3.root.getRootId(), this.val$token, var3.root.getExtras());
         } catch (RemoteException var5) {
            Log.w("MediaBrowserServiceCompat", "Connection for " + var3.pkg + " is no longer valid.");
            MediaBrowserServiceCompat.access$500(this.this$0).remove(var2);
         }
      }

   }
}
