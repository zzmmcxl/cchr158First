package android.support.design.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.internal.ParcelableSparseArray$1;
import android.support.v4.os.ParcelableCompat;
import android.util.SparseArray;

public class ParcelableSparseArray extends SparseArray<Parcelable> implements Parcelable {
   public static final Creator<ParcelableSparseArray> CREATOR = ParcelableCompat.newCreator(new ParcelableSparseArray$1());

   public ParcelableSparseArray() {
   }

   public ParcelableSparseArray(Parcel var1, ClassLoader var2) {
      int var4 = var1.readInt();
      int[] var5 = new int[var4];
      var1.readIntArray(var5);
      Parcelable[] var6 = var1.readParcelableArray(var2);

      for(int var3 = 0; var3 < var4; ++var3) {
         this.put(var5[var3], var6[var3]);
      }

   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      int var4 = this.size();
      int[] var5 = new int[var4];
      Parcelable[] var6 = new Parcelable[var4];

      for(int var3 = 0; var3 < var4; ++var3) {
         var5[var3] = this.keyAt(var3);
         var6[var3] = (Parcelable)this.valueAt(var3);
      }

      var1.writeInt(var4);
      var1.writeIntArray(var5);
      var1.writeParcelableArray(var6, var2);
   }
}
