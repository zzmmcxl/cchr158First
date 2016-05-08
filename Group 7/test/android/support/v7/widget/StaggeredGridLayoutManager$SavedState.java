package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
import android.support.v7.widget.StaggeredGridLayoutManager$SavedState$1;
import java.util.List;

public class StaggeredGridLayoutManager$SavedState implements Parcelable {
   public static final Creator<StaggeredGridLayoutManager$SavedState> CREATOR = new StaggeredGridLayoutManager$SavedState$1();
   boolean mAnchorLayoutFromEnd;
   int mAnchorPosition;
   List<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> mFullSpanItems;
   boolean mLastLayoutRTL;
   boolean mReverseLayout;
   int[] mSpanLookup;
   int mSpanLookupSize;
   int[] mSpanOffsets;
   int mSpanOffsetsSize;
   int mVisibleAnchorPosition;

   public StaggeredGridLayoutManager$SavedState() {
   }

   StaggeredGridLayoutManager$SavedState(Parcel var1) {
      boolean var3 = true;
      super();
      this.mAnchorPosition = var1.readInt();
      this.mVisibleAnchorPosition = var1.readInt();
      this.mSpanOffsetsSize = var1.readInt();
      if(this.mSpanOffsetsSize > 0) {
         this.mSpanOffsets = new int[this.mSpanOffsetsSize];
         var1.readIntArray(this.mSpanOffsets);
      }

      this.mSpanLookupSize = var1.readInt();
      if(this.mSpanLookupSize > 0) {
         this.mSpanLookup = new int[this.mSpanLookupSize];
         var1.readIntArray(this.mSpanLookup);
      }

      boolean var2;
      if(var1.readInt() == 1) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.mReverseLayout = var2;
      if(var1.readInt() == 1) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.mAnchorLayoutFromEnd = var2;
      if(var1.readInt() == 1) {
         var2 = var3;
      } else {
         var2 = false;
      }

      this.mLastLayoutRTL = var2;
      this.mFullSpanItems = var1.readArrayList(StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem.class.getClassLoader());
   }

   public StaggeredGridLayoutManager$SavedState(StaggeredGridLayoutManager$SavedState var1) {
      this.mSpanOffsetsSize = var1.mSpanOffsetsSize;
      this.mAnchorPosition = var1.mAnchorPosition;
      this.mVisibleAnchorPosition = var1.mVisibleAnchorPosition;
      this.mSpanOffsets = var1.mSpanOffsets;
      this.mSpanLookupSize = var1.mSpanLookupSize;
      this.mSpanLookup = var1.mSpanLookup;
      this.mReverseLayout = var1.mReverseLayout;
      this.mAnchorLayoutFromEnd = var1.mAnchorLayoutFromEnd;
      this.mLastLayoutRTL = var1.mLastLayoutRTL;
      this.mFullSpanItems = var1.mFullSpanItems;
   }

   public int describeContents() {
      return 0;
   }

   void invalidateAnchorPositionInfo() {
      this.mSpanOffsets = null;
      this.mSpanOffsetsSize = 0;
      this.mAnchorPosition = -1;
      this.mVisibleAnchorPosition = -1;
   }

   void invalidateSpanInfo() {
      this.mSpanOffsets = null;
      this.mSpanOffsetsSize = 0;
      this.mSpanLookupSize = 0;
      this.mSpanLookup = null;
      this.mFullSpanItems = null;
   }

   public void writeToParcel(Parcel var1, int var2) {
      byte var3 = 1;
      var1.writeInt(this.mAnchorPosition);
      var1.writeInt(this.mVisibleAnchorPosition);
      var1.writeInt(this.mSpanOffsetsSize);
      if(this.mSpanOffsetsSize > 0) {
         var1.writeIntArray(this.mSpanOffsets);
      }

      var1.writeInt(this.mSpanLookupSize);
      if(this.mSpanLookupSize > 0) {
         var1.writeIntArray(this.mSpanLookup);
      }

      byte var4;
      if(this.mReverseLayout) {
         var4 = 1;
      } else {
         var4 = 0;
      }

      var1.writeInt(var4);
      if(this.mAnchorLayoutFromEnd) {
         var4 = 1;
      } else {
         var4 = 0;
      }

      var1.writeInt(var4);
      if(this.mLastLayoutRTL) {
         var4 = var3;
      } else {
         var4 = 0;
      }

      var1.writeInt(var4);
      var1.writeList(this.mFullSpanItems);
   }
}
