package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.ScrollerCompat$ScrollerCompatImpl;
import android.support.v4.widget.ScrollerCompat$ScrollerCompatImplBase;
import android.support.v4.widget.ScrollerCompat$ScrollerCompatImplGingerbread;
import android.support.v4.widget.ScrollerCompat$ScrollerCompatImplIcs;
import android.view.animation.Interpolator;

public final class ScrollerCompat {
   static final int CHASE_FRAME_TIME = 16;
   private static final String TAG = "ScrollerCompat";
   ScrollerCompat$ScrollerCompatImpl mImpl;
   Object mScroller;

   private ScrollerCompat(int var1, Context var2, Interpolator var3) {
      if(var1 >= 14) {
         this.mImpl = new ScrollerCompat$ScrollerCompatImplIcs();
      } else if(var1 >= 9) {
         this.mImpl = new ScrollerCompat$ScrollerCompatImplGingerbread();
      } else {
         this.mImpl = new ScrollerCompat$ScrollerCompatImplBase();
      }

      this.mScroller = this.mImpl.createScroller(var2, var3);
   }

   public static ScrollerCompat create(Context var0) {
      return create(var0, (Interpolator)null);
   }

   public static ScrollerCompat create(Context var0, Interpolator var1) {
      return new ScrollerCompat(VERSION.SDK_INT, var0, var1);
   }

   public void abortAnimation() {
      this.mImpl.abortAnimation(this.mScroller);
   }

   public boolean computeScrollOffset() {
      return this.mImpl.computeScrollOffset(this.mScroller);
   }

   public void fling(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      this.mImpl.fling(this.mScroller, var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public void fling(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      this.mImpl.fling(this.mScroller, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
   }

   public float getCurrVelocity() {
      return this.mImpl.getCurrVelocity(this.mScroller);
   }

   public int getCurrX() {
      return this.mImpl.getCurrX(this.mScroller);
   }

   public int getCurrY() {
      return this.mImpl.getCurrY(this.mScroller);
   }

   public int getFinalX() {
      return this.mImpl.getFinalX(this.mScroller);
   }

   public int getFinalY() {
      return this.mImpl.getFinalY(this.mScroller);
   }

   public boolean isFinished() {
      return this.mImpl.isFinished(this.mScroller);
   }

   public boolean isOverScrolled() {
      return this.mImpl.isOverScrolled(this.mScroller);
   }

   public void notifyHorizontalEdgeReached(int var1, int var2, int var3) {
      this.mImpl.notifyHorizontalEdgeReached(this.mScroller, var1, var2, var3);
   }

   public void notifyVerticalEdgeReached(int var1, int var2, int var3) {
      this.mImpl.notifyVerticalEdgeReached(this.mScroller, var1, var2, var3);
   }

   public boolean springBack(int var1, int var2, int var3, int var4, int var5, int var6) {
      return this.mImpl.springBack(this.mScroller, var1, var2, var3, var4, var5, var6);
   }

   public void startScroll(int var1, int var2, int var3, int var4) {
      this.mImpl.startScroll(this.mScroller, var1, var2, var3, var4);
   }

   public void startScroll(int var1, int var2, int var3, int var4, int var5) {
      this.mImpl.startScroll(this.mScroller, var1, var2, var3, var4, var5);
   }
}
