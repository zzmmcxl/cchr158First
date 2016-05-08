package android.support.design.internal;

import android.os.Parcel;
import android.support.design.internal.ParcelableSparseArray;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;

final class ParcelableSparseArray$1 implements ParcelableCompatCreatorCallbacks<ParcelableSparseArray> {
   public ParcelableSparseArray createFromParcel(Parcel var1, ClassLoader var2) {
      return new ParcelableSparseArray(var1, var2);
   }

   public ParcelableSparseArray[] newArray(int var1) {
      return new ParcelableSparseArray[var1];
   }
}
