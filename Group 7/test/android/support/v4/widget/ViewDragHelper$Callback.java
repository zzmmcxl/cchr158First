package android.support.v4.widget;

import android.view.View;

public abstract class ViewDragHelper$Callback {
   public int clampViewPositionHorizontal(View var1, int var2, int var3) {
      return 0;
   }

   public int clampViewPositionVertical(View var1, int var2, int var3) {
      return 0;
   }

   public int getOrderedChildIndex(int var1) {
      return var1;
   }

   public int getViewHorizontalDragRange(View var1) {
      return 0;
   }

   public int getViewVerticalDragRange(View var1) {
      return 0;
   }

   public void onEdgeDragStarted(int var1, int var2) {
   }

   public boolean onEdgeLock(int var1) {
      return false;
   }

   public void onEdgeTouched(int var1, int var2) {
   }

   public void onViewCaptured(View var1, int var2) {
   }

   public void onViewDragStateChanged(int var1) {
   }

   public void onViewPositionChanged(View var1, int var2, int var3, int var4, int var5) {
   }

   public void onViewReleased(View var1, float var2, float var3) {
   }

   public abstract boolean tryCaptureView(View var1, int var2);
}
