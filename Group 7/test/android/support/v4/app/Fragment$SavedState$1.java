package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment$SavedState;

final class Fragment$SavedState$1 implements Creator<Fragment$SavedState> {
   public Fragment$SavedState createFromParcel(Parcel var1) {
      return new Fragment$SavedState(var1, (ClassLoader)null);
   }

   public Fragment$SavedState[] newArray(int var1) {
      return new Fragment$SavedState[var1];
   }
}
