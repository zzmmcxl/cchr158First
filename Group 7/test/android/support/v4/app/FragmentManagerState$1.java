package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentManagerState;

final class FragmentManagerState$1 implements Creator<FragmentManagerState> {
   public FragmentManagerState createFromParcel(Parcel var1) {
      return new FragmentManagerState(var1);
   }

   public FragmentManagerState[] newArray(int var1) {
      return new FragmentManagerState[var1];
   }
}
