package android.support.v4.media;

import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaBrowserCompat$SubscriptionCallbackApi21;
import android.support.v4.media.MediaBrowserCompatApi21$SubscriptionCallback;
import android.support.v4.media.MediaBrowserCompatUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MediaBrowserCompat$SubscriptionCallbackApi21$StubApi21 implements MediaBrowserCompatApi21$SubscriptionCallback {
   private MediaBrowserCompat$SubscriptionCallbackApi21$StubApi21(MediaBrowserCompat$SubscriptionCallbackApi21 var1) {
      this.this$0 = var1;
   }

   public void onChildrenLoaded(@NonNull String var1, List<Parcel> var2) {
      ArrayList var3 = null;
      if(var2 != null) {
         ArrayList var4 = new ArrayList();
         Iterator var5 = var2.iterator();

         while(true) {
            var3 = var4;
            if(!var5.hasNext()) {
               break;
            }

            Parcel var6 = (Parcel)var5.next();
            var6.setDataPosition(0);
            var4.add(MediaBrowserCompat$MediaItem.CREATOR.createFromParcel(var6));
            var6.recycle();
         }
      }

      if(MediaBrowserCompat$SubscriptionCallbackApi21.access$400(this.this$0) != null) {
         this.this$0.onChildrenLoaded(var1, MediaBrowserCompatUtils.applyOptions(var3, MediaBrowserCompat$SubscriptionCallbackApi21.access$400(this.this$0)), MediaBrowserCompat$SubscriptionCallbackApi21.access$400(this.this$0));
      } else {
         this.this$0.onChildrenLoaded(var1, var3);
      }
   }

   public void onError(@NonNull String var1) {
      if(MediaBrowserCompat$SubscriptionCallbackApi21.access$400(this.this$0) != null) {
         this.this$0.onError(var1, MediaBrowserCompat$SubscriptionCallbackApi21.access$400(this.this$0));
      } else {
         this.this$0.onError(var1);
      }
   }
}
