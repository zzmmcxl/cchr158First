package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem$1;
import java.util.Arrays;

class StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem implements Parcelable {
   public static final Creator<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> CREATOR = new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem$1();
   int mGapDir;
   int[] mGapPerSpan;
   boolean mHasUnwantedGapAfter;
   int mPosition;

   public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem() {
   }

   public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem(Parcel var1) {
      boolean var3 = true;
      super();
      this.mPosition = var1.readInt();
      this.mGapDir = var1.readInt();
      if(var1.readInt() != 1) {
         var3 = false;
      }

      this.mHasUnwantedGapAfter = var3;
      int var2 = var1.readInt();
      if(var2 > 0) {
         this.mGapPerSpan = new int[var2];
         var1.readIntArray(this.mGapPerSpan);
      }

   }

   public int describeContents() {
      return 0;
   }

   int getGapForSpan(int var1) {
      return this.mGapPerSpan == null?0:this.mGapPerSpan[var1];
   }

   public String toString() {
      return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeInt(this.mPosition);
      var1.writeInt(this.mGapDir);
      byte var3;
      if(this.mHasUnwantedGapAfter) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      var1.writeInt(var3);
      if(this.mGapPerSpan != null && this.mGapPerSpan.length > 0) {
         var1.writeInt(this.mGapPerSpan.length);
         var1.writeIntArray(this.mGapPerSpan);
      } else {
         var1.writeInt(0);
      }
   }
}
