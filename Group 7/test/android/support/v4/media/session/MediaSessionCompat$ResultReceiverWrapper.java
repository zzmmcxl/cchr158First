package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper$1;

final class MediaSessionCompat$ResultReceiverWrapper implements Parcelable {
   public static final Creator<MediaSessionCompat$ResultReceiverWrapper> CREATOR = new MediaSessionCompat$ResultReceiverWrapper$1();
   private ResultReceiver mResultReceiver;

   MediaSessionCompat$ResultReceiverWrapper(Parcel var1) {
      this.mResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(var1);
   }

   public MediaSessionCompat$ResultReceiverWrapper(ResultReceiver var1) {
      this.mResultReceiver = var1;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      this.mResultReceiver.writeToParcel(var1, var2);
   }
}
