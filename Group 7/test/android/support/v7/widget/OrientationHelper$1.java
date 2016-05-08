package android.support.v7.widget;

import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView$LayoutManager;
import android.support.v7.widget.RecyclerView$LayoutParams;
import android.view.View;

final class OrientationHelper$1 extends OrientationHelper {
   OrientationHelper$1(RecyclerView$LayoutManager var1) {
      super(var1, (OrientationHelper$1)null);
   }

   public int getDecoratedEnd(View var1) {
      RecyclerView$LayoutParams var2 = (RecyclerView$LayoutParams)var1.getLayoutParams();
      return this.mLayoutManager.getDecoratedRight(var1) + var2.rightMargin;
   }

   public int getDecoratedMeasurement(View var1) {
      RecyclerView$LayoutParams var2 = (RecyclerView$LayoutParams)var1.getLayoutParams();
      return this.mLayoutManager.getDecoratedMeasuredWidth(var1) + var2.leftMargin + var2.rightMargin;
   }

   public int getDecoratedMeasurementInOther(View var1) {
      RecyclerView$LayoutParams var2 = (RecyclerView$LayoutParams)var1.getLayoutParams();
      return this.mLayoutManager.getDecoratedMeasuredHeight(var1) + var2.topMargin + var2.bottomMargin;
   }

   public int getDecoratedStart(View var1) {
      RecyclerView$LayoutParams var2 = (RecyclerView$LayoutParams)var1.getLayoutParams();
      return this.mLayoutManager.getDecoratedLeft(var1) - var2.leftMargin;
   }

   public int getEnd() {
      return this.mLayoutManager.getWidth();
   }

   public int getEndAfterPadding() {
      return this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingRight();
   }

   public int getEndPadding() {
      return this.mLayoutManager.getPaddingRight();
   }

   public int getMode() {
      return this.mLayoutManager.getWidthMode();
   }

   public int getModeInOther() {
      return this.mLayoutManager.getHeightMode();
   }

   public int getStartAfterPadding() {
      return this.mLayoutManager.getPaddingLeft();
   }

   public int getTotalSpace() {
      return this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingLeft() - this.mLayoutManager.getPaddingRight();
   }

   public void offsetChild(View var1, int var2) {
      var1.offsetLeftAndRight(var2);
   }

   public void offsetChildren(int var1) {
      this.mLayoutManager.offsetChildrenHorizontal(var1);
   }
}
