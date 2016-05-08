package android.support.v7.widget;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView$LayoutParams;
import android.support.v7.widget.RecyclerView$State;
import android.view.View;

class LinearLayoutManager$AnchorInfo {
   int mCoordinate;
   boolean mLayoutFromEnd;
   int mPosition;

   LinearLayoutManager$AnchorInfo(LinearLayoutManager var1) {
      this.this$0 = var1;
   }

   private boolean isViewValidAsAnchor(View var1, RecyclerView$State var2) {
      RecyclerView$LayoutParams var3 = (RecyclerView$LayoutParams)var1.getLayoutParams();
      return !var3.isItemRemoved() && var3.getViewLayoutPosition() >= 0 && var3.getViewLayoutPosition() < var2.getItemCount();
   }

   void assignCoordinateFromPadding() {
      int var1;
      if(this.mLayoutFromEnd) {
         var1 = this.this$0.mOrientationHelper.getEndAfterPadding();
      } else {
         var1 = this.this$0.mOrientationHelper.getStartAfterPadding();
      }

      this.mCoordinate = var1;
   }

   public void assignFromView(View var1) {
      if(this.mLayoutFromEnd) {
         this.mCoordinate = this.this$0.mOrientationHelper.getDecoratedEnd(var1) + this.this$0.mOrientationHelper.getTotalSpaceChange();
      } else {
         this.mCoordinate = this.this$0.mOrientationHelper.getDecoratedStart(var1);
      }

      this.mPosition = this.this$0.getPosition(var1);
   }

   public void assignFromViewAndKeepVisibleRect(View var1) {
      int var3 = this.this$0.mOrientationHelper.getTotalSpaceChange();
      if(var3 >= 0) {
         this.assignFromView(var1);
      } else {
         this.mPosition = this.this$0.getPosition(var1);
         int var2;
         int var4;
         int var5;
         if(this.mLayoutFromEnd) {
            var2 = this.this$0.mOrientationHelper.getEndAfterPadding() - var3 - this.this$0.mOrientationHelper.getDecoratedEnd(var1);
            this.mCoordinate = this.this$0.mOrientationHelper.getEndAfterPadding() - var2;
            if(var2 > 0) {
               var3 = this.this$0.mOrientationHelper.getDecoratedMeasurement(var1);
               var4 = this.mCoordinate;
               var5 = this.this$0.mOrientationHelper.getStartAfterPadding();
               var3 = var4 - var3 - (var5 + Math.min(this.this$0.mOrientationHelper.getDecoratedStart(var1) - var5, 0));
               if(var3 < 0) {
                  this.mCoordinate += Math.min(var2, -var3);
                  return;
               }
            }
         } else {
            var4 = this.this$0.mOrientationHelper.getDecoratedStart(var1);
            var2 = var4 - this.this$0.mOrientationHelper.getStartAfterPadding();
            this.mCoordinate = var4;
            if(var2 > 0) {
               var5 = this.this$0.mOrientationHelper.getDecoratedMeasurement(var1);
               int var6 = this.this$0.mOrientationHelper.getEndAfterPadding();
               int var7 = this.this$0.mOrientationHelper.getDecoratedEnd(var1);
               var3 = this.this$0.mOrientationHelper.getEndAfterPadding() - Math.min(0, var6 - var3 - var7) - (var4 + var5);
               if(var3 < 0) {
                  this.mCoordinate -= Math.min(var2, -var3);
                  return;
               }
            }
         }
      }

   }

   void reset() {
      this.mPosition = -1;
      this.mCoordinate = Integer.MIN_VALUE;
      this.mLayoutFromEnd = false;
   }

   public String toString() {
      return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.mCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + '}';
   }
}
