package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutManager$SavedState$1;

public class LinearLayoutManager$SavedState implements Parcelable {
   public static final Creator<LinearLayoutManager$SavedState> CREATOR = new LinearLayoutManager$SavedState$1();
   boolean mAnchorLayoutFromEnd;
   int mAnchorOffset;
   int mAnchorPosition;

   public LinearLayoutManager$SavedState() {
   }

   LinearLayoutManager$SavedState(Parcel var1) {
      boolean var2 = true;
      super();
      this.mAnchorPosition = var1.readInt();
      this.mAnchorOffset = var1.readInt();
      if(var1.readInt() != 1) {
         var2 = false;
      }

      this.mAnchorLayoutFromEnd = var2;
   }

   public LinearLayoutManager$SavedState(LinearLayoutManager$SavedState var1) {
      this.mAnchorPosition = var1.mAnchorPosition;
      this.mAnchorOffset = var1.mAnchorOffset;
      this.mAnchorLayoutFromEnd = var1.mAnchorLayoutFromEnd;
   }

   public int describeContents() {
      return 0;
   }

   boolean hasValidAnchor() {
      return this.mAnchorPosition >= 0;
   }

   void invalidateAnchor() {
      this.mAnchorPosition = -1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeInt(this.mAnchorPosition);
      var1.writeInt(this.mAnchorOffset);
      byte var3;
      if(this.mAnchorLayoutFromEnd) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      var1.writeInt(var3);
   }
}
