package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.view.ViewPager$SavedState$1;
import android.view.View.BaseSavedState;

public class ViewPager$SavedState extends BaseSavedState {
   public static final Creator<ViewPager$SavedState> CREATOR = ParcelableCompat.newCreator(new ViewPager$SavedState$1());
   Parcelable adapterState;
   ClassLoader loader;
   int position;

   ViewPager$SavedState(Parcel var1, ClassLoader var2) {
      super(var1);
      ClassLoader var3 = var2;
      if(var2 == null) {
         var3 = this.getClass().getClassLoader();
      }

      this.position = var1.readInt();
      this.adapterState = var1.readParcelable(var3);
      this.loader = var3;
   }

   public ViewPager$SavedState(Parcelable var1) {
      super(var1);
   }

   public String toString() {
      return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
   }

   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeInt(this.position);
      var1.writeParcelable(this.adapterState, var2);
   }
}
