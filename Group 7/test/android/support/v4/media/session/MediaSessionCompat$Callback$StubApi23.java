package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat$1;
import android.support.v4.media.session.MediaSessionCompat$Callback;
import android.support.v4.media.session.MediaSessionCompat$Callback$StubApi21;
import android.support.v4.media.session.MediaSessionCompatApi23$Callback;

class MediaSessionCompat$Callback$StubApi23 extends MediaSessionCompat$Callback$StubApi21 implements MediaSessionCompatApi23$Callback {
   private MediaSessionCompat$Callback$StubApi23(MediaSessionCompat$Callback var1) {
      super(var1, (MediaSessionCompat$1)null);
      this.this$0 = var1;
   }

   public void onPlayFromUri(Uri var1, Bundle var2) {
      this.this$0.onPlayFromUri(var1, var2);
   }
}
