package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.widget.CoordinatorLayout$SavedState$1;
import android.support.v4.os.ParcelableCompat;
import android.util.SparseArray;
import android.view.View.BaseSavedState;

public class CoordinatorLayout$SavedState extends BaseSavedState {
   public static final Creator<CoordinatorLayout$SavedState> CREATOR = ParcelableCompat.newCreator(new CoordinatorLayout$SavedState$1());
   SparseArray<Parcelable> behaviorStates;

   public CoordinatorLayout$SavedState(Parcel var1, ClassLoader var2) {
      super(var1);
      int var4 = var1.readInt();
      int[] var5 = new int[var4];
      var1.readIntArray(var5);
      Parcelable[] var6 = var1.readParcelableArray(var2);
      this.behaviorStates = new SparseArray(var4);

      for(int var3 = 0; var3 < var4; ++var3) {
         this.behaviorStates.append(var5[var3], var6[var3]);
      }

   }

   public CoordinatorLayout$SavedState(Parcelable var1) {
      super(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      int var3;
      if(this.behaviorStates != null) {
         var3 = this.behaviorStates.size();
      } else {
         var3 = 0;
      }

      var1.writeInt(var3);
      int[] var5 = new int[var3];
      Parcelable[] var6 = new Parcelable[var3];

      for(int var4 = 0; var4 < var3; ++var4) {
         var5[var4] = this.behaviorStates.keyAt(var4);
         var6[var4] = (Parcelable)this.behaviorStates.valueAt(var4);
      }

      var1.writeIntArray(var5);
      var1.writeParcelableArray(var6, var2);
   }
}
