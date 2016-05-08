package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.widget.SlidingPaneLayout$1;
import android.support.v4.widget.SlidingPaneLayout$SavedState;

final class SlidingPaneLayout$SavedState$1 implements Creator<SlidingPaneLayout$SavedState> {
   public SlidingPaneLayout$SavedState createFromParcel(Parcel var1) {
      return new SlidingPaneLayout$SavedState(var1, (SlidingPaneLayout$1)null);
   }

   public SlidingPaneLayout$SavedState[] newArray(int var1) {
      return new SlidingPaneLayout$SavedState[var1];
   }
}
