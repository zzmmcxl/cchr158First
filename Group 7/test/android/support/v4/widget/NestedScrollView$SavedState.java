package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.widget.NestedScrollView$SavedState$1;
import android.view.View.BaseSavedState;

class NestedScrollView$SavedState extends BaseSavedState {
   public static final Creator<NestedScrollView$SavedState> CREATOR = new NestedScrollView$SavedState$1();
   public int scrollPosition;

   public NestedScrollView$SavedState(Parcel var1) {
      super(var1);
      this.scrollPosition = var1.readInt();
   }

   NestedScrollView$SavedState(Parcelable var1) {
      super(var1);
   }

   public String toString() {
      return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.scrollPosition + "}";
   }

   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeInt(this.scrollPosition);
   }
}
