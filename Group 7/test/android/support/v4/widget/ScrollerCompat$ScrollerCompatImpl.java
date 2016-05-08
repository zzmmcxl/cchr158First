package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;

interface ScrollerCompat$ScrollerCompatImpl {
   void abortAnimation(Object var1);

   boolean computeScrollOffset(Object var1);

   Object createScroller(Context var1, Interpolator var2);

   void fling(Object var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9);

   void fling(Object var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11);

   float getCurrVelocity(Object var1);

   int getCurrX(Object var1);

   int getCurrY(Object var1);

   int getFinalX(Object var1);

   int getFinalY(Object var1);

   boolean isFinished(Object var1);

   boolean isOverScrolled(Object var1);

   void notifyHorizontalEdgeReached(Object var1, int var2, int var3, int var4);

   void notifyVerticalEdgeReached(Object var1, int var2, int var3, int var4);

   boolean springBack(Object var1, int var2, int var3, int var4, int var5, int var6, int var7);

   void startScroll(Object var1, int var2, int var3, int var4, int var5);

   void startScroll(Object var1, int var2, int var3, int var4, int var5, int var6);
}
