package android.support.design.widget;

import android.os.Parcel;
import android.support.design.widget.CoordinatorLayout$SavedState;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;

final class CoordinatorLayout$SavedState$1 implements ParcelableCompatCreatorCallbacks<CoordinatorLayout$SavedState> {
   public CoordinatorLayout$SavedState createFromParcel(Parcel var1, ClassLoader var2) {
      return new CoordinatorLayout$SavedState(var1, var2);
   }

   public CoordinatorLayout$SavedState[] newArray(int var1) {
      return new CoordinatorLayout$SavedState[var1];
   }
}
