package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;

final class MediaSessionCompat$ResultReceiverWrapper$1 implements Creator<MediaSessionCompat$ResultReceiverWrapper> {
   public MediaSessionCompat$ResultReceiverWrapper createFromParcel(Parcel var1) {
      return new MediaSessionCompat$ResultReceiverWrapper(var1);
   }

   public MediaSessionCompat$ResultReceiverWrapper[] newArray(int var1) {
      return new MediaSessionCompat$ResultReceiverWrapper[var1];
   }
}
