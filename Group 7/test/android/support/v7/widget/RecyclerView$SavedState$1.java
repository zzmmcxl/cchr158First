package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.RecyclerView$SavedState;

final class RecyclerView$SavedState$1 implements Creator<RecyclerView$SavedState> {
   public RecyclerView$SavedState createFromParcel(Parcel var1) {
      return new RecyclerView$SavedState(var1);
   }

   public RecyclerView$SavedState[] newArray(int var1) {
      return new RecyclerView$SavedState[var1];
   }
}
