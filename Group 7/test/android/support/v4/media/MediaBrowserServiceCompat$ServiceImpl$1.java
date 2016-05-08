package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat$1;
import android.support.v4.media.MediaBrowserServiceCompat$ConnectionRecord;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceCallbacks;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceImpl;
import android.util.Log;

class MediaBrowserServiceCompat$ServiceImpl$1 implements Runnable {
   MediaBrowserServiceCompat$ServiceImpl$1(MediaBrowserServiceCompat$ServiceImpl var1, MediaBrowserServiceCompat$ServiceCallbacks var2, String var3, Bundle var4, int var5) {
      this.this$1 = var1;
      this.val$callbacks = var2;
      this.val$pkg = var3;
      this.val$rootHints = var4;
      this.val$uid = var5;
   }

   public void run() {
      IBinder var1 = this.val$callbacks.asBinder();
      MediaBrowserServiceCompat.access$500(this.this$1.this$0).remove(var1);
      MediaBrowserServiceCompat$ConnectionRecord var2 = new MediaBrowserServiceCompat$ConnectionRecord(this.this$1.this$0, (MediaBrowserServiceCompat$1)null);
      var2.pkg = this.val$pkg;
      var2.rootHints = this.val$rootHints;
      var2.callbacks = this.val$callbacks;
      var2.root = this.this$1.this$0.onGetRoot(this.val$pkg, this.val$uid, this.val$rootHints);
      if(var2.root == null) {
         Log.i("MediaBrowserServiceCompat", "No root for client " + this.val$pkg + " from service " + this.getClass().getName());

         try {
            this.val$callbacks.onConnectFailed();
         } catch (RemoteException var4) {
            Log.w("MediaBrowserServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + this.val$pkg);
            return;
         }
      } else {
         try {
            MediaBrowserServiceCompat.access$500(this.this$1.this$0).put(var1, var2);
            if(this.this$1.this$0.mSession != null) {
               this.val$callbacks.onConnect(var2.root.getRootId(), this.this$1.this$0.mSession, var2.root.getExtras());
               return;
            }
         } catch (RemoteException var3) {
            Log.w("MediaBrowserServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + this.val$pkg);
            MediaBrowserServiceCompat.access$500(this.this$1.this$0).remove(var1);
            return;
         }
      }

   }
}
