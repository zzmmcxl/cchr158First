package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.SearchView$SavedState$1;
import android.view.View.BaseSavedState;

class SearchView$SavedState extends BaseSavedState {
   public static final Creator<SearchView$SavedState> CREATOR = new SearchView$SavedState$1();
   boolean isIconified;

   public SearchView$SavedState(Parcel var1) {
      super(var1);
      this.isIconified = ((Boolean)var1.readValue((ClassLoader)null)).booleanValue();
   }

   SearchView$SavedState(Parcelable var1) {
      super(var1);
   }

   public String toString() {
      return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.isIconified + "}";
   }

   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeValue(Boolean.valueOf(this.isIconified));
   }
}
