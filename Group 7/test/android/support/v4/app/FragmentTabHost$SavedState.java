package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentTabHost$SavedState$1;
import android.view.View.BaseSavedState;

class FragmentTabHost$SavedState extends BaseSavedState {
   public static final Creator<FragmentTabHost$SavedState> CREATOR = new FragmentTabHost$SavedState$1();
   String curTab;

   private FragmentTabHost$SavedState(Parcel var1) {
      super(var1);
      this.curTab = var1.readString();
   }

   FragmentTabHost$SavedState(Parcelable var1) {
      super(var1);
   }

   public String toString() {
      return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.curTab + "}";
   }

   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeString(this.curTab);
   }
}
