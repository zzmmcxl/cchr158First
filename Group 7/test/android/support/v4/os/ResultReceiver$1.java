package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.os.ResultReceiver;

final class ResultReceiver$1 implements Creator<ResultReceiver> {
   public ResultReceiver createFromParcel(Parcel var1) {
      return new ResultReceiver(var1);
   }

   public ResultReceiver[] newArray(int var1) {
      return new ResultReceiver[var1];
   }
}
