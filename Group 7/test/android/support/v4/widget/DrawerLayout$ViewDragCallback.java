package android.support.v4.widget;

import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout$LayoutParams;
import android.support.v4.widget.DrawerLayout$ViewDragCallback$1;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper$Callback;
import android.view.View;

class DrawerLayout$ViewDragCallback extends ViewDragHelper$Callback {
   private final int mAbsGravity;
   private ViewDragHelper mDragger;
   private final Runnable mPeekRunnable;

   public DrawerLayout$ViewDragCallback(DrawerLayout var1, int var2) {
      this.this$0 = var1;
      this.mPeekRunnable = new DrawerLayout$ViewDragCallback$1(this);
      this.mAbsGravity = var2;
   }

   private void closeOtherDrawer() {
      byte var1 = 3;
      if(this.mAbsGravity == 3) {
         var1 = 5;
      }

      View var2 = this.this$0.findDrawerWithGravity(var1);
      if(var2 != null) {
         this.this$0.closeDrawer(var2);
      }

   }

   private void peekDrawer() {
      int var2 = 0;
      int var3 = this.mDragger.getEdgeSize();
      boolean var1;
      if(this.mAbsGravity == 3) {
         var1 = true;
      } else {
         var1 = false;
      }

      View var4;
      if(var1) {
         var4 = this.this$0.findDrawerWithGravity(3);
         if(var4 != null) {
            var2 = -var4.getWidth();
         }

         var2 += var3;
      } else {
         var4 = this.this$0.findDrawerWithGravity(5);
         var2 = this.this$0.getWidth() - var3;
      }

      if(var4 != null && (var1 && var4.getLeft() < var2 || !var1 && var4.getLeft() > var2) && this.this$0.getDrawerLockMode(var4) == 0) {
         DrawerLayout$LayoutParams var5 = (DrawerLayout$LayoutParams)var4.getLayoutParams();
         this.mDragger.smoothSlideViewTo(var4, var2, var4.getTop());
         DrawerLayout$LayoutParams.access$202(var5, true);
         this.this$0.invalidate();
         this.closeOtherDrawer();
         this.this$0.cancelChildViewTouch();
      }

   }

   public int clampViewPositionHorizontal(View var1, int var2, int var3) {
      if(this.this$0.checkDrawerViewAbsoluteGravity(var1, 3)) {
         return Math.max(-var1.getWidth(), Math.min(var2, 0));
      } else {
         var3 = this.this$0.getWidth();
         return Math.max(var3 - var1.getWidth(), Math.min(var2, var3));
      }
   }

   public int clampViewPositionVertical(View var1, int var2, int var3) {
      return var1.getTop();
   }

   public int getViewHorizontalDragRange(View var1) {
      return this.this$0.isDrawerView(var1)?var1.getWidth():0;
   }

   public void onEdgeDragStarted(int var1, int var2) {
      View var3;
      if((var1 & 1) == 1) {
         var3 = this.this$0.findDrawerWithGravity(3);
      } else {
         var3 = this.this$0.findDrawerWithGravity(5);
      }

      if(var3 != null && this.this$0.getDrawerLockMode(var3) == 0) {
         this.mDragger.captureChildView(var3, var2);
      }

   }

   public boolean onEdgeLock(int var1) {
      return false;
   }

   public void onEdgeTouched(int var1, int var2) {
      this.this$0.postDelayed(this.mPeekRunnable, 160L);
   }

   public void onViewCaptured(View var1, int var2) {
      DrawerLayout$LayoutParams.access$202((DrawerLayout$LayoutParams)var1.getLayoutParams(), false);
      this.closeOtherDrawer();
   }

   public void onViewDragStateChanged(int var1) {
      this.this$0.updateDrawerState(this.mAbsGravity, var1, this.mDragger.getCapturedView());
   }

   public void onViewPositionChanged(View var1, int var2, int var3, int var4, int var5) {
      var3 = var1.getWidth();
      float var6;
      if(this.this$0.checkDrawerViewAbsoluteGravity(var1, 3)) {
         var6 = (float)(var3 + var2) / (float)var3;
      } else {
         var6 = (float)(this.this$0.getWidth() - var2) / (float)var3;
      }

      this.this$0.setDrawerViewOffset(var1, var6);
      byte var7;
      if(var6 == 0.0F) {
         var7 = 4;
      } else {
         var7 = 0;
      }

      var1.setVisibility(var7);
      this.this$0.invalidate();
   }

   public void onViewReleased(View var1, float var2, float var3) {
      var3 = this.this$0.getDrawerViewOffset(var1);
      int var5 = var1.getWidth();
      int var4;
      if(this.this$0.checkDrawerViewAbsoluteGravity(var1, 3)) {
         if(var2 <= 0.0F && (var2 != 0.0F || var3 <= 0.5F)) {
            var4 = -var5;
         } else {
            var4 = 0;
         }
      } else {
         var4 = this.this$0.getWidth();
         if(var2 < 0.0F || var2 == 0.0F && var3 > 0.5F) {
            var4 -= var5;
         }
      }

      this.mDragger.settleCapturedViewAt(var4, var1.getTop());
      this.this$0.invalidate();
   }

   public void removeCallbacks() {
      this.this$0.removeCallbacks(this.mPeekRunnable);
   }

   public void setDragger(ViewDragHelper var1) {
      this.mDragger = var1;
   }

   public boolean tryCaptureView(View var1, int var2) {
      return this.this$0.isDrawerView(var1) && this.this$0.checkDrawerViewAbsoluteGravity(var1, this.mAbsGravity) && this.this$0.getDrawerLockMode(var1) == 0;
   }
}
