package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;

class ParcelableCompat$CompatCreator<T> implements Creator<T> {
   final ParcelableCompatCreatorCallbacks<T> mCallbacks;

   public ParcelableCompat$CompatCreator(ParcelableCompatCreatorCallbacks<T> var1) {
      this.mCallbacks = var1;
   }

   public T createFromParcel(Parcel var1) {
      return this.mCallbacks.createFromParcel(var1, (ClassLoader)null);
   }

   public T[] newArray(int var1) {
      return this.mCallbacks.newArray(var1);
   }
}
