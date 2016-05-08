package android.support.v4.view;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.view.View;
import android.view.animation.Interpolator;

interface ViewPropertyAnimatorCompat$ViewPropertyAnimatorCompatImpl {
   void alpha(ViewPropertyAnimatorCompat var1, View var2, float var3);

   void alphaBy(ViewPropertyAnimatorCompat var1, View var2, float var3);

   void cancel(ViewPropertyAnimatorCompat var1, View var2);

   long getDuration(ViewPropertyAnimatorCompat var1, View var2);

   Interpolator getInterpolator(ViewPropertyAnimatorCompat var1, View var2);

   long getStartDelay(ViewPropertyAnimatorCompat var1, View var2);

   void rotation(ViewPropertyAnimatorCompat var1, View var2, float var3);

   void rotationBy(ViewPropertyAnimatorCompat var1, View var2, float var3);

   void rotationX(ViewPropertyAnimatorCompat var1, View var2, float var3);

   void rotationXBy(ViewPropertyAnimatorCompat var1, View var2, float var3);

   void rotationY(ViewPropertyAnimatorCompat var1, View var2, float var3);

   void rotationYBy(ViewPropertyAnimatorCompat var1, View var2, float var3);

   void scaleX(ViewPropertyAnimatorCompat var1, View var2, float var3);

   void scaleXBy(ViewPropertyAnimatorCompat var1, View var2, float var3);

   void scaleY(ViewPropertyAnimatorCompat var1, View var2, float var3);

   void scaleYBy(ViewPropertyAnimatorCompat var1, View var2, float var3);

   void setDuration(ViewPropertyAnimatorCompat var1, View var2, long var3);

   void setInterpolator(ViewPropertyAnimatorCompat var1, View var2, Interpolator var3);

   void setListener(ViewPropertyAnimatorCompat var1, View var2, ViewPropertyAnimatorListener var3);

   void setStartDelay(ViewPropertyAnimatorCompat var1, View var2, long var3);

   void setUpdateListener(ViewPropertyAnimatorCompat var1, View var2, ViewPropertyAnimatorUpdateListener var3);

   void start(ViewPropertyAnimatorCompat var1, View var2);

   void translationX(ViewPropertyAnimatorCompat var1, View var2, float var3);

   void translationXBy(ViewPropertyAnimatorCompat var1, View var2, float var3);

   void translationY(ViewPropertyAnimatorCompat var1, View var2, float var3);

   void translationYBy(ViewPropertyAnimatorCompat var1, View var2, float var3);

   void translationZ(ViewPropertyAnimatorCompat var1, View var2, float var3);

   void translationZBy(ViewPropertyAnimatorCompat var1, View var2, float var3);

   void withEndAction(ViewPropertyAnimatorCompat var1, View var2, Runnable var3);

   void withLayer(ViewPropertyAnimatorCompat var1, View var2);

   void withStartAction(ViewPropertyAnimatorCompat var1, View var2, Runnable var3);

   void x(ViewPropertyAnimatorCompat var1, View var2, float var3);

   void xBy(ViewPropertyAnimatorCompat var1, View var2, float var3);

   void y(ViewPropertyAnimatorCompat var1, View var2, float var3);

   void yBy(ViewPropertyAnimatorCompat var1, View var2, float var3);

   void z(ViewPropertyAnimatorCompat var1, View var2, float var3);

   void zBy(ViewPropertyAnimatorCompat var1, View var2, float var3);
}
