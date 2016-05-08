package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.ParcelableVolumeInfo;

final class ParcelableVolumeInfo$1 implements Creator<ParcelableVolumeInfo> {
   public ParcelableVolumeInfo createFromParcel(Parcel var1) {
      return new ParcelableVolumeInfo(var1);
   }

   public ParcelableVolumeInfo[] newArray(int var1) {
      return new ParcelableVolumeInfo[var1];
   }
}
