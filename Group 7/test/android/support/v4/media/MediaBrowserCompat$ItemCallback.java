package android.support.v4.media;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.media.MediaBrowserCompat$1;
import android.support.v4.media.MediaBrowserCompat$ItemCallback$StubApi23;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaBrowserCompatApi23;

public abstract class MediaBrowserCompat$ItemCallback {
   final Object mItemCallbackObj;

   public MediaBrowserCompat$ItemCallback() {
      if(VERSION.SDK_INT >= 23) {
         this.mItemCallbackObj = MediaBrowserCompatApi23.createItemCallback(new MediaBrowserCompat$ItemCallback$StubApi23(this, (MediaBrowserCompat$1)null));
      } else {
         this.mItemCallbackObj = null;
      }
   }

   public void onError(@NonNull String var1) {
   }

   public void onItemLoaded(MediaBrowserCompat$MediaItem var1) {
   }
}
