package android.support.design.widget;

import android.os.Parcel;
import android.support.design.widget.NavigationView$SavedState;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;

final class NavigationView$SavedState$1 implements ParcelableCompatCreatorCallbacks<NavigationView$SavedState> {
   public NavigationView$SavedState createFromParcel(Parcel var1, ClassLoader var2) {
      return new NavigationView$SavedState(var1, var2);
   }

   public NavigationView$SavedState[] newArray(int var1) {
      return new NavigationView$SavedState[var1];
   }
}
