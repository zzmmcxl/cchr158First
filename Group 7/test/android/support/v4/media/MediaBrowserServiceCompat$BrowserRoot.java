package android.support.v4.media;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class MediaBrowserServiceCompat$BrowserRoot {
   public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
   public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
   public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
   private final Bundle mExtras;
   private final String mRootId;

   public MediaBrowserServiceCompat$BrowserRoot(@NonNull String var1, @Nullable Bundle var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
      } else {
         this.mRootId = var1;
         this.mExtras = var2;
      }
   }

   public Bundle getExtras() {
      return this.mExtras;
   }

   public String getRootId() {
      return this.mRootId;
   }
}
