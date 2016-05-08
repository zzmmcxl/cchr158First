package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.media.MediaBrowserCompat$ConnectionCallback;
import android.support.v4.media.MediaBrowserCompat$ItemCallback;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21;
import android.support.v4.media.MediaBrowserCompatApi23;

class MediaBrowserCompat$MediaBrowserImplApi23 extends MediaBrowserCompat$MediaBrowserImplApi21 {
   public MediaBrowserCompat$MediaBrowserImplApi23(Context var1, ComponentName var2, MediaBrowserCompat$ConnectionCallback var3, Bundle var4) {
      super(var1, var2, var3, var4);
   }

   public void getItem(@NonNull String var1, @NonNull MediaBrowserCompat$ItemCallback var2) {
      MediaBrowserCompatApi23.getItem(this.mBrowserObj, var1, var2.mItemCallbackObj);
   }
}
