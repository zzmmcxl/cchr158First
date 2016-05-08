package android.support.v4.media.session;

import android.os.Bundle;
import android.support.v4.media.session.PlaybackStateCompat$1;
import android.support.v4.media.session.PlaybackStateCompat$CustomAction;
import android.text.TextUtils;

public final class PlaybackStateCompat$CustomAction$Builder {
   private final String mAction;
   private Bundle mExtras;
   private final int mIcon;
   private final CharSequence mName;

   public PlaybackStateCompat$CustomAction$Builder(String var1, CharSequence var2, int var3) {
      if(TextUtils.isEmpty(var1)) {
         throw new IllegalArgumentException("You must specify an action to build a CustomAction.");
      } else if(TextUtils.isEmpty(var2)) {
         throw new IllegalArgumentException("You must specify a name to build a CustomAction.");
      } else if(var3 == 0) {
         throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction.");
      } else {
         this.mAction = var1;
         this.mName = var2;
         this.mIcon = var3;
      }
   }

   public PlaybackStateCompat$CustomAction build() {
      return new PlaybackStateCompat$CustomAction(this.mAction, this.mName, this.mIcon, this.mExtras, (PlaybackStateCompat$1)null);
   }

   public PlaybackStateCompat$CustomAction$Builder setExtras(Bundle var1) {
      this.mExtras = var1;
      return this;
   }
}
