package android.support.v4.view;

import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.ViewPager$SavedState;

final class ViewPager$SavedState$1 implements ParcelableCompatCreatorCallbacks<ViewPager$SavedState> {
   public ViewPager$SavedState createFromParcel(Parcel var1, ClassLoader var2) {
      return new ViewPager$SavedState(var1, var2);
   }

   public ViewPager$SavedState[] newArray(int var1) {
      return new ViewPager$SavedState[var1];
   }
}
