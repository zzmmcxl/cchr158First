package android.support.v4.media;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat$1;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceCallbacksCompat;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceImpl;
import android.support.v4.os.ResultReceiver;
import android.util.Log;

final class MediaBrowserServiceCompat$ServiceHandler extends Handler {
   private final MediaBrowserServiceCompat$ServiceImpl mServiceImpl;

   private MediaBrowserServiceCompat$ServiceHandler(MediaBrowserServiceCompat var1) {
      this.this$0 = var1;
      this.mServiceImpl = new MediaBrowserServiceCompat$ServiceImpl(this.this$0, (MediaBrowserServiceCompat$1)null);
   }

   public MediaBrowserServiceCompat$ServiceImpl getServiceImpl() {
      return this.mServiceImpl;
   }

   public void handleMessage(Message var1) {
      Bundle var2 = var1.getData();
      switch(var1.what) {
      case 1:
         this.mServiceImpl.connect(var2.getString("data_package_name"), var2.getInt("data_calling_uid"), var2.getBundle("data_root_hints"), new MediaBrowserServiceCompat$ServiceCallbacksCompat(this.this$0, var1.replyTo));
         return;
      case 2:
         this.mServiceImpl.disconnect(new MediaBrowserServiceCompat$ServiceCallbacksCompat(this.this$0, var1.replyTo));
         return;
      case 3:
         this.mServiceImpl.addSubscription(var2.getString("data_media_item_id"), var2.getBundle("data_options"), new MediaBrowserServiceCompat$ServiceCallbacksCompat(this.this$0, var1.replyTo));
         return;
      case 4:
         this.mServiceImpl.removeSubscription(var2.getString("data_media_item_id"), var2.getBundle("data_options"), new MediaBrowserServiceCompat$ServiceCallbacksCompat(this.this$0, var1.replyTo));
         return;
      case 5:
         this.mServiceImpl.getMediaItem(var2.getString("data_media_item_id"), (ResultReceiver)var2.getParcelable("data_result_receiver"));
         return;
      case 6:
         this.mServiceImpl.registerCallbacks(new MediaBrowserServiceCompat$ServiceCallbacksCompat(this.this$0, var1.replyTo));
         return;
      default:
         Log.w("MediaBrowserServiceCompat", "Unhandled message: " + var1 + "\n  Service version: " + 1 + "\n  Client version: " + var1.arg1);
      }
   }

   public void postOrRun(Runnable var1) {
      if(Thread.currentThread() == this.getLooper().getThread()) {
         var1.run();
      } else {
         this.post(var1);
      }
   }

   public boolean sendMessageAtTime(Message var1, long var2) {
      Bundle var4 = var1.getData();
      var4.setClassLoader(MediaBrowserCompat.class.getClassLoader());
      var4.putInt("data_calling_uid", Binder.getCallingUid());
      return super.sendMessageAtTime(var1, var2);
   }
}
