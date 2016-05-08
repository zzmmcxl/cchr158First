package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.BackStackState;

final class BackStackState$1 implements Creator<BackStackState> {
   public BackStackState createFromParcel(Parcel var1) {
      return new BackStackState(var1);
   }

   public BackStackState[] newArray(int var1) {
      return new BackStackState[var1];
   }
}
