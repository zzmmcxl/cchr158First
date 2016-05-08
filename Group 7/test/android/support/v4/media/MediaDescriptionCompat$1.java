package android.support.v4.media;

import android.os.Parcel;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaDescriptionCompatApi21;

final class MediaDescriptionCompat$1 implements Creator<MediaDescriptionCompat> {
   public MediaDescriptionCompat createFromParcel(Parcel var1) {
      return VERSION.SDK_INT < 21?new MediaDescriptionCompat(var1, (MediaDescriptionCompat$1)null):MediaDescriptionCompat.fromMediaDescription(MediaDescriptionCompatApi21.fromParcel(var1));
   }

   public MediaDescriptionCompat[] newArray(int var1) {
      return new MediaDescriptionCompat[var1];
   }
}
