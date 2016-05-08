package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceCallbacks;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceImpl$1;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceImpl$2;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceImpl$3;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceImpl$4;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceImpl$5;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceImpl$6;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;

class MediaBrowserServiceCompat$ServiceImpl {
   private MediaBrowserServiceCompat$ServiceImpl(MediaBrowserServiceCompat var1) {
      this.this$0 = var1;
   }

   public void addSubscription(String var1, Bundle var2, MediaBrowserServiceCompat$ServiceCallbacks var3) {
      MediaBrowserServiceCompat.access$100(this.this$0).postOrRun(new MediaBrowserServiceCompat$ServiceImpl$3(this, var3, var1, var2));
   }

   public void connect(String var1, int var2, Bundle var3, MediaBrowserServiceCompat$ServiceCallbacks var4) {
      if(!MediaBrowserServiceCompat.access$400(this.this$0, var1, var2)) {
         throw new IllegalArgumentException("Package/uid mismatch: uid=" + var2 + " package=" + var1);
      } else {
         MediaBrowserServiceCompat.access$100(this.this$0).postOrRun(new MediaBrowserServiceCompat$ServiceImpl$1(this, var4, var1, var3, var2));
      }
   }

   public void disconnect(MediaBrowserServiceCompat$ServiceCallbacks var1) {
      MediaBrowserServiceCompat.access$100(this.this$0).postOrRun(new MediaBrowserServiceCompat$ServiceImpl$2(this, var1));
   }

   public void getMediaItem(String var1, ResultReceiver var2) {
      if(!TextUtils.isEmpty(var1) && var2 != null) {
         MediaBrowserServiceCompat.access$100(this.this$0).postOrRun(new MediaBrowserServiceCompat$ServiceImpl$5(this, var1, var2));
      }
   }

   public void registerCallbacks(MediaBrowserServiceCompat$ServiceCallbacks var1) {
      MediaBrowserServiceCompat.access$100(this.this$0).postOrRun(new MediaBrowserServiceCompat$ServiceImpl$6(this, var1));
   }

   public void removeSubscription(String var1, Bundle var2, MediaBrowserServiceCompat$ServiceCallbacks var3) {
      MediaBrowserServiceCompat.access$100(this.this$0).postOrRun(new MediaBrowserServiceCompat$ServiceImpl$4(this, var3, var1, var2));
   }
}
