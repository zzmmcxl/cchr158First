package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.PlaybackStateCompat;

final class PlaybackStateCompat$1 implements Creator<PlaybackStateCompat> {
   public PlaybackStateCompat createFromParcel(Parcel var1) {
      return new PlaybackStateCompat(var1, (PlaybackStateCompat$1)null);
   }

   public PlaybackStateCompat[] newArray(int var1) {
      return new PlaybackStateCompat[var1];
   }
}
