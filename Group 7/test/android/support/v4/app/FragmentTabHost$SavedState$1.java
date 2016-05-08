package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentTabHost$1;
import android.support.v4.app.FragmentTabHost$SavedState;

final class FragmentTabHost$SavedState$1 implements Creator<FragmentTabHost$SavedState> {
   public FragmentTabHost$SavedState createFromParcel(Parcel var1) {
      return new FragmentTabHost$SavedState(var1, (FragmentTabHost$1)null);
   }

   public FragmentTabHost$SavedState[] newArray(int var1) {
      return new FragmentTabHost$SavedState[var1];
   }
}
