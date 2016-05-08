package android.support.v4.media.session;

import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase;
import android.support.v4.media.session.MediaSessionCompatApi19$Callback;

class MediaSessionCompat$MediaSessionImplBase$2 implements MediaSessionCompatApi19$Callback {
   MediaSessionCompat$MediaSessionImplBase$2(MediaSessionCompat$MediaSessionImplBase var1) {
      this.this$0 = var1;
   }

   public void onSeekTo(long var1) {
      MediaSessionCompat$MediaSessionImplBase.access$700(this.this$0, 11, Long.valueOf(var1));
   }

   public void onSetRating(Object var1) {
      MediaSessionCompat$MediaSessionImplBase.access$700(this.this$0, 12, RatingCompat.fromRating(var1));
   }
}
