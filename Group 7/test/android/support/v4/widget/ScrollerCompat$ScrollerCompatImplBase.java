package android.support.v4.widget;

import android.content.Context;
import android.support.v4.widget.ScrollerCompat$ScrollerCompatImpl;
import android.view.animation.Interpolator;
import android.widget.Scroller;

class ScrollerCompat$ScrollerCompatImplBase implements ScrollerCompat$ScrollerCompatImpl {
   public void abortAnimation(Object var1) {
      ((Scroller)var1).abortAnimation();
   }

   public boolean computeScrollOffset(Object var1) {
      return ((Scroller)var1).computeScrollOffset();
   }

   public Object createScroller(Context var1, Interpolator var2) {
      return var2 != null?new Scroller(var1, var2):new Scroller(var1);
   }

   public void fling(Object var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      ((Scroller)var1).fling(var2, var3, var4, var5, var6, var7, var8, var9);
   }

   public void fling(Object var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      ((Scroller)var1).fling(var2, var3, var4, var5, var6, var7, var8, var9);
   }

   public float getCurrVelocity(Object var1) {
      return 0.0F;
   }

   public int getCurrX(Object var1) {
      return ((Scroller)var1).getCurrX();
   }

   public int getCurrY(Object var1) {
      return ((Scroller)var1).getCurrY();
   }

   public int getFinalX(Object var1) {
      return ((Scroller)var1).getFinalX();
   }

   public int getFinalY(Object var1) {
      return ((Scroller)var1).getFinalY();
   }

   public boolean isFinished(Object var1) {
      return ((Scroller)var1).isFinished();
   }

   public boolean isOverScrolled(Object var1) {
      return false;
   }

   public void notifyHorizontalEdgeReached(Object var1, int var2, int var3, int var4) {
   }

   public void notifyVerticalEdgeReached(Object var1, int var2, int var3, int var4) {
   }

   public boolean springBack(Object var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      return false;
   }

   public void startScroll(Object var1, int var2, int var3, int var4, int var5) {
      ((Scroller)var1).startScroll(var2, var3, var4, var5);
   }

   public void startScroll(Object var1, int var2, int var3, int var4, int var5, int var6) {
      ((Scroller)var1).startScroll(var2, var3, var4, var5, var6);
   }
}
