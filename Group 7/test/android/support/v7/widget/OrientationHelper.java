package android.support.v7.widget;

import android.support.v7.widget.OrientationHelper$1;
import android.support.v7.widget.OrientationHelper$2;
import android.support.v7.widget.RecyclerView$LayoutManager;
import android.view.View;

public abstract class OrientationHelper {
   public static final int HORIZONTAL = 0;
   private static final int INVALID_SIZE = Integer.MIN_VALUE;
   public static final int VERTICAL = 1;
   private int mLastTotalSpace;
   protected final RecyclerView$LayoutManager mLayoutManager;

   private OrientationHelper(RecyclerView$LayoutManager var1) {
      this.mLastTotalSpace = Integer.MIN_VALUE;
      this.mLayoutManager = var1;
   }

   public static OrientationHelper createHorizontalHelper(RecyclerView$LayoutManager var0) {
      return new OrientationHelper$1(var0);
   }

   public static OrientationHelper createOrientationHelper(RecyclerView$LayoutManager var0, int var1) {
      switch(var1) {
      case 0:
         return createHorizontalHelper(var0);
      case 1:
         return createVerticalHelper(var0);
      default:
         throw new IllegalArgumentException("invalid orientation");
      }
   }

   public static OrientationHelper createVerticalHelper(RecyclerView$LayoutManager var0) {
      return new OrientationHelper$2(var0);
   }

   public abstract int getDecoratedEnd(View var1);

   public abstract int getDecoratedMeasurement(View var1);

   public abstract int getDecoratedMeasurementInOther(View var1);

   public abstract int getDecoratedStart(View var1);

   public abstract int getEnd();

   public abstract int getEndAfterPadding();

   public abstract int getEndPadding();

   public abstract int getMode();

   public abstract int getModeInOther();

   public abstract int getStartAfterPadding();

   public abstract int getTotalSpace();

   public int getTotalSpaceChange() {
      return Integer.MIN_VALUE == this.mLastTotalSpace?0:this.getTotalSpace() - this.mLastTotalSpace;
   }

   public abstract void offsetChild(View var1, int var2);

   public abstract void offsetChildren(int var1);

   public void onLayoutComplete() {
      this.mLastTotalSpace = this.getTotalSpace();
   }
}
