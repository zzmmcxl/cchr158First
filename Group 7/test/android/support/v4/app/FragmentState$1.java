package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentState;

final class FragmentState$1 implements Creator<FragmentState> {
   public FragmentState createFromParcel(Parcel var1) {
      return new FragmentState(var1);
   }

   public FragmentState[] newArray(int var1) {
      return new FragmentState[var1];
   }
}
