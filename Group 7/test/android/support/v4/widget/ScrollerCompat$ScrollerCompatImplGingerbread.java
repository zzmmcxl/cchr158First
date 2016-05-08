package android.support.v4.widget;

import android.content.Context;
import android.support.v4.widget.ScrollerCompat$ScrollerCompatImpl;
import android.support.v4.widget.ScrollerCompatGingerbread;
import android.view.animation.Interpolator;

class ScrollerCompat$ScrollerCompatImplGingerbread implements ScrollerCompat$ScrollerCompatImpl {
   public void abortAnimation(Object var1) {
      ScrollerCompatGingerbread.abortAnimation(var1);
   }

   public boolean computeScrollOffset(Object var1) {
      return ScrollerCompatGingerbread.computeScrollOffset(var1);
   }

   public Object createScroller(Context var1, Interpolator var2) {
      return ScrollerCompatGingerbread.createScroller(var1, var2);
   }

   public void fling(Object var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      ScrollerCompatGingerbread.fling(var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   public void fling(Object var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      ScrollerCompatGingerbread.fling(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   public float getCurrVelocity(Object var1) {
      return 0.0F;
   }

   public int getCurrX(Object var1) {
      return ScrollerCompatGingerbread.getCurrX(var1);
   }

   public int getCurrY(Object var1) {
      return ScrollerCompatGingerbread.getCurrY(var1);
   }

   public int getFinalX(Object var1) {
      return ScrollerCompatGingerbread.getFinalX(var1);
   }

   public int getFinalY(Object var1) {
      return ScrollerCompatGingerbread.getFinalY(var1);
   }

   public boolean isFinished(Object var1) {
      return ScrollerCompatGingerbread.isFinished(var1);
   }

   public boolean isOverScrolled(Object var1) {
      return ScrollerCompatGingerbread.isOverScrolled(var1);
   }

   public void notifyHorizontalEdgeReached(Object var1, int var2, int var3, int var4) {
      ScrollerCompatGingerbread.notifyHorizontalEdgeReached(var1, var2, var3, var4);
   }

   public void notifyVerticalEdgeReached(Object var1, int var2, int var3, int var4) {
      ScrollerCompatGingerbread.notifyVerticalEdgeReached(var1, var2, var3, var4);
   }

   public boolean springBack(Object var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      return ScrollerCompatGingerbread.springBack(var1, var2, var3, var4, var5, var6, var7);
   }

   public void startScroll(Object var1, int var2, int var3, int var4, int var5) {
      ScrollerCompatGingerbread.startScroll(var1, var2, var3, var4, var5);
   }

   public void startScroll(Object var1, int var2, int var3, int var4, int var5, int var6) {
      ScrollerCompatGingerbread.startScroll(var1, var2, var3, var4, var5, var6);
   }
}
