package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.RatingCompat;

final class RatingCompat$1 implements Creator<RatingCompat> {
   public RatingCompat createFromParcel(Parcel var1) {
      return new RatingCompat(var1.readInt(), var1.readFloat(), (RatingCompat$1)null);
   }

   public RatingCompat[] newArray(int var1) {
      return new RatingCompat[var1];
   }
}
