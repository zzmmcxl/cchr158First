package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.MediaMetadataCompat;

final class MediaMetadataCompat$1 implements Creator<MediaMetadataCompat> {
   public MediaMetadataCompat createFromParcel(Parcel var1) {
      return new MediaMetadataCompat(var1, (MediaMetadataCompat$1)null);
   }

   public MediaMetadataCompat[] newArray(int var1) {
      return new MediaMetadataCompat[var1];
   }
}
