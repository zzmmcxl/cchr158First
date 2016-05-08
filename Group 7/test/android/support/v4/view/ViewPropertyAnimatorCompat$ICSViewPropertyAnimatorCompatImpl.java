package android.support.v4.view;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl;
import android.support.v4.view.ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$MyVpaListener;
import android.support.v4.view.ViewPropertyAnimatorCompatICS;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

class ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl extends ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl {
   WeakHashMap<View, Integer> mLayerMap = null;

   public void alpha(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatICS.alpha(var2, var3);
   }

   public void alphaBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatICS.alphaBy(var2, var3);
   }

   public void cancel(ViewPropertyAnimatorCompat var1, View var2) {
      ViewPropertyAnimatorCompatICS.cancel(var2);
   }

   public long getDuration(ViewPropertyAnimatorCompat var1, View var2) {
      return ViewPropertyAnimatorCompatICS.getDuration(var2);
   }

   public long getStartDelay(ViewPropertyAnimatorCompat var1, View var2) {
      return ViewPropertyAnimatorCompatICS.getStartDelay(var2);
   }

   public void rotation(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatICS.rotation(var2, var3);
   }

   public void rotationBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatICS.rotationBy(var2, var3);
   }

   public void rotationX(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatICS.rotationX(var2, var3);
   }

   public void rotationXBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatICS.rotationXBy(var2, var3);
   }

   public void rotationY(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatICS.rotationY(var2, var3);
   }

   public void rotationYBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatICS.rotationYBy(var2, var3);
   }

   public void scaleX(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatICS.scaleX(var2, var3);
   }

   public void scaleXBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatICS.scaleXBy(var2, var3);
   }

   public void scaleY(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatICS.scaleY(var2, var3);
   }

   public void scaleYBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatICS.scaleYBy(var2, var3);
   }

   public void setDuration(ViewPropertyAnimatorCompat var1, View var2, long var3) {
      ViewPropertyAnimatorCompatICS.setDuration(var2, var3);
   }

   public void setInterpolator(ViewPropertyAnimatorCompat var1, View var2, Interpolator var3) {
      ViewPropertyAnimatorCompatICS.setInterpolator(var2, var3);
   }

   public void setListener(ViewPropertyAnimatorCompat var1, View var2, ViewPropertyAnimatorListener var3) {
      var2.setTag(2113929216, var3);
      ViewPropertyAnimatorCompatICS.setListener(var2, new ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$MyVpaListener(var1));
   }

   public void setStartDelay(ViewPropertyAnimatorCompat var1, View var2, long var3) {
      ViewPropertyAnimatorCompatICS.setStartDelay(var2, var3);
   }

   public void start(ViewPropertyAnimatorCompat var1, View var2) {
      ViewPropertyAnimatorCompatICS.start(var2);
   }

   public void translationX(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatICS.translationX(var2, var3);
   }

   public void translationXBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatICS.translationXBy(var2, var3);
   }

   public void translationY(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatICS.translationY(var2, var3);
   }

   public void translationYBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatICS.translationYBy(var2, var3);
   }

   public void withEndAction(ViewPropertyAnimatorCompat var1, View var2, Runnable var3) {
      ViewPropertyAnimatorCompatICS.setListener(var2, new ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$MyVpaListener(var1));
      ViewPropertyAnimatorCompat.access$002(var1, var3);
   }

   public void withLayer(ViewPropertyAnimatorCompat var1, View var2) {
      ViewPropertyAnimatorCompat.access$402(var1, ViewCompat.getLayerType(var2));
      ViewPropertyAnimatorCompatICS.setListener(var2, new ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$MyVpaListener(var1));
   }

   public void withStartAction(ViewPropertyAnimatorCompat var1, View var2, Runnable var3) {
      ViewPropertyAnimatorCompatICS.setListener(var2, new ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$MyVpaListener(var1));
      ViewPropertyAnimatorCompat.access$102(var1, var3);
   }

   public void x(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatICS.x(var2, var3);
   }

   public void xBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatICS.xBy(var2, var3);
   }

   public void y(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatICS.y(var2, var3);
   }

   public void yBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatICS.yBy(var2, var3);
   }
}
