package android.support.v7.widget;

import android.support.v7.widget.StaggeredGridLayoutManager;

class StaggeredGridLayoutManager$AnchorInfo {
   boolean mInvalidateOffsets;
   boolean mLayoutFromEnd;
   int mOffset;
   int mPosition;

   private StaggeredGridLayoutManager$AnchorInfo(StaggeredGridLayoutManager var1) {
      this.this$0 = var1;
   }

   void assignCoordinateFromPadding() {
      int var1;
      if(this.mLayoutFromEnd) {
         var1 = this.this$0.mPrimaryOrientation.getEndAfterPadding();
      } else {
         var1 = this.this$0.mPrimaryOrientation.getStartAfterPadding();
      }

      this.mOffset = var1;
   }

   void assignCoordinateFromPadding(int var1) {
      if(this.mLayoutFromEnd) {
         this.mOffset = this.this$0.mPrimaryOrientation.getEndAfterPadding() - var1;
      } else {
         this.mOffset = this.this$0.mPrimaryOrientation.getStartAfterPadding() + var1;
      }
   }

   void reset() {
      this.mPosition = -1;
      this.mOffset = Integer.MIN_VALUE;
      this.mLayoutFromEnd = false;
      this.mInvalidateOffsets = false;
   }
}
