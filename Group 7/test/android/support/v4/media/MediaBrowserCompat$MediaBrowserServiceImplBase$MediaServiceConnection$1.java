package android.support.v4.media;

import android.content.ComponentName;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceImplBase;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection;
import android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper;
import android.util.Log;

class MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection$1 implements Runnable {
   MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection$1(MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection var1, ComponentName var2, IBinder var3) {
      this.this$1 = var1;
      this.val$name = var2;
      this.val$binder = var3;
   }

   public void run() {
      if(MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection.access$1000(this.this$1, "onServiceConnected")) {
         MediaBrowserCompat$MediaBrowserServiceImplBase.access$1102(this.this$1.this$0, new MediaBrowserCompat$ServiceBinderWrapper(this.val$binder));
         MediaBrowserCompat$MediaBrowserServiceImplBase.access$1202(this.this$1.this$0, new Messenger(MediaBrowserCompat$MediaBrowserServiceImplBase.access$1300(this.this$1.this$0)));
         MediaBrowserCompat$MediaBrowserServiceImplBase.access$1300(this.this$1.this$0).setCallbacksMessenger(MediaBrowserCompat$MediaBrowserServiceImplBase.access$1200(this.this$1.this$0));
         MediaBrowserCompat$MediaBrowserServiceImplBase.access$1402(this.this$1.this$0, 1);

         try {
            MediaBrowserCompat$MediaBrowserServiceImplBase.access$1100(this.this$1.this$0).connect(MediaBrowserCompat$MediaBrowserServiceImplBase.access$1500(this.this$1.this$0), MediaBrowserCompat$MediaBrowserServiceImplBase.access$1600(this.this$1.this$0), MediaBrowserCompat$MediaBrowserServiceImplBase.access$1200(this.this$1.this$0));
         } catch (RemoteException var2) {
            Log.w("MediaBrowserCompat", "RemoteException during connect for " + MediaBrowserCompat$MediaBrowserServiceImplBase.access$1700(this.this$1.this$0));
         }
      }
   }
}
