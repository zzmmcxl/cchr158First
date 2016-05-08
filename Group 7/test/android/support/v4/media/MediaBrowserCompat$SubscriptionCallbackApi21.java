package android.support.v4.media;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.media.MediaBrowserCompat$1;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaBrowserCompat$SubscriptionCallback;
import android.support.v4.media.MediaBrowserCompat$SubscriptionCallbackApi21$StubApi21;
import android.support.v4.media.MediaBrowserCompatApi21;
import java.util.List;

class MediaBrowserCompat$SubscriptionCallbackApi21 extends MediaBrowserCompat$SubscriptionCallback {
   private Bundle mOptions;
   MediaBrowserCompat$SubscriptionCallback mSubscriptionCallback;
   private final Object mSubscriptionCallbackObj;

   public MediaBrowserCompat$SubscriptionCallbackApi21(MediaBrowserCompat$SubscriptionCallback var1, Bundle var2) {
      this.mSubscriptionCallback = var1;
      this.mOptions = var2;
      this.mSubscriptionCallbackObj = MediaBrowserCompatApi21.createSubscriptionCallback(new MediaBrowserCompat$SubscriptionCallbackApi21$StubApi21(this, (MediaBrowserCompat$1)null));
   }

   public void onChildrenLoaded(@NonNull String var1, List<MediaBrowserCompat$MediaItem> var2) {
      this.mSubscriptionCallback.onChildrenLoaded(var1, var2);
   }

   public void onChildrenLoaded(@NonNull String var1, List<MediaBrowserCompat$MediaItem> var2, @NonNull Bundle var3) {
      this.mSubscriptionCallback.onChildrenLoaded(var1, var2, var3);
   }

   public void onError(@NonNull String var1) {
      this.mSubscriptionCallback.onError(var1);
   }

   public void onError(@NonNull String var1, @NonNull Bundle var2) {
      this.mSubscriptionCallback.onError(var1, var2);
   }
}
