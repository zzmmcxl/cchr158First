package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.RecyclerView$LayoutManager;
import android.support.v7.widget.RecyclerView$SavedState$1;
import android.view.View.BaseSavedState;

public class RecyclerView$SavedState extends BaseSavedState {
   public static final Creator<RecyclerView$SavedState> CREATOR = new RecyclerView$SavedState$1();
   Parcelable mLayoutState;

   RecyclerView$SavedState(Parcel var1) {
      super(var1);
      this.mLayoutState = var1.readParcelable(RecyclerView$LayoutManager.class.getClassLoader());
   }

   RecyclerView$SavedState(Parcelable var1) {
      super(var1);
   }

   private void copyFrom(RecyclerView$SavedState var1) {
      this.mLayoutState = var1.mLayoutState;
   }

   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeParcelable(this.mLayoutState, 0);
   }
}
