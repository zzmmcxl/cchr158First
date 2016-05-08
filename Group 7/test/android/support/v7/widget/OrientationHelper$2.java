package android.support.v7.widget;

import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.OrientationHelper$1;
import android.support.v7.widget.RecyclerView$LayoutManager;
import android.support.v7.widget.RecyclerView$LayoutParams;
import android.view.View;

final class OrientationHelper$2 extends OrientationHelper {
   OrientationHelper$2(RecyclerView$LayoutManager var1) {
      super(var1, (OrientationHelper$1)null);
   }

   public int getDecoratedEnd(View var1) {
      RecyclerView$LayoutParams var2 = (RecyclerView$LayoutParams)var1.getLayoutParams();
      return this.mLayoutManager.getDecoratedBottom(var1) + var2.bottomMargin;
   }

   public int getDecoratedMeasurement(View var1) {
      RecyclerView$LayoutParams var2 = (RecyclerView$LayoutParams)var1.getLayoutParams();
      return this.mLayoutManager.getDecoratedMeasuredHeight(var1) + var2.topMargin + var2.bottomMargin;
   }

   public int getDecoratedMeasurementInOther(View var1) {
      RecyclerView$LayoutParams var2 = (RecyclerView$LayoutParams)var1.getLayoutParams();
      return this.mLayoutManager.getDecoratedMeasuredWidth(var1) + var2.leftMargin + var2.rightMargin;
   }

   public int getDecoratedStart(View var1) {
      RecyclerView$LayoutParams var2 = (RecyclerView$LayoutParams)var1.getLayoutParams();
      return this.mLayoutManager.getDecoratedTop(var1) - var2.topMargin;
   }

   public int getEnd() {
      return this.mLayoutManager.getHeight();
   }

   public int getEndAfterPadding() {
      return this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingBottom();
   }

   public int getEndPadding() {
      return this.mLayoutManager.getPaddingBottom();
   }

   public int getMode() {
      return this.mLayoutManager.getHeightMode();
   }

   public int getModeInOther() {
      return this.mLayoutManager.getWidthMode();
   }

   public int getStartAfterPadding() {
      return this.mLayoutManager.getPaddingTop();
   }

   public int getTotalSpace() {
      return this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingTop() - this.mLayoutManager.getPaddingBottom();
   }

   public void offsetChild(View var1, int var2) {
      var1.offsetTopAndBottom(var2);
   }

   public void offsetChildren(int var1) {
      this.mLayoutManager.offsetChildrenVertical(var1);
   }
}
