package android.support.v4.media;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import java.util.List;

public abstract class MediaBrowserCompat$SubscriptionCallback {
   public void onChildrenLoaded(@NonNull String var1, List<MediaBrowserCompat$MediaItem> var2) {
   }

   public void onChildrenLoaded(@NonNull String var1, List<MediaBrowserCompat$MediaItem> var2, @NonNull Bundle var3) {
   }

   public void onError(@NonNull String var1) {
   }

   public void onError(@NonNull String var1, @NonNull Bundle var2) {
   }
}
