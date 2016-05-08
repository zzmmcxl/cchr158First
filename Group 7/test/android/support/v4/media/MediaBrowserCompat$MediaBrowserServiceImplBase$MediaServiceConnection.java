package android.support.v4.media;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceImplBase;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection$1;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection$2;
import android.util.Log;

class MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection implements ServiceConnection {
   private MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection(MediaBrowserCompat$MediaBrowserServiceImplBase var1) {
      this.this$0 = var1;
   }

   private boolean isCurrent(String var1) {
      if(MediaBrowserCompat$MediaBrowserServiceImplBase.access$700(this.this$0) != this) {
         if(MediaBrowserCompat$MediaBrowserServiceImplBase.access$1400(this.this$0) != 0) {
            Log.i("MediaBrowserCompat", var1 + " for " + MediaBrowserCompat$MediaBrowserServiceImplBase.access$1700(this.this$0) + " with mServiceConnection=" + MediaBrowserCompat$MediaBrowserServiceImplBase.access$700(this.this$0) + " this=" + this);
         }

         return false;
      } else {
         return true;
      }
   }

   private void postOrRun(Runnable var1) {
      if(Thread.currentThread() == MediaBrowserCompat$MediaBrowserServiceImplBase.access$1300(this.this$0).getLooper().getThread()) {
         var1.run();
      } else {
         MediaBrowserCompat$MediaBrowserServiceImplBase.access$1300(this.this$0).post(var1);
      }
   }

   public void onServiceConnected(ComponentName var1, IBinder var2) {
      this.postOrRun(new MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection$1(this, var1, var2));
   }

   public void onServiceDisconnected(ComponentName var1) {
      this.postOrRun(new MediaBrowserCompat$MediaBrowserServiceImplBase$MediaServiceConnection$2(this, var1));
   }
}
