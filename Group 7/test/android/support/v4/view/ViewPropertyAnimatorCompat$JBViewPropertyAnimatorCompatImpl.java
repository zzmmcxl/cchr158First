package android.support.v4.view;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl;
import android.support.v4.view.ViewPropertyAnimatorCompatJB;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;

class ViewPropertyAnimatorCompat$JBViewPropertyAnimatorCompatImpl extends ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl {
   public void setListener(ViewPropertyAnimatorCompat var1, View var2, ViewPropertyAnimatorListener var3) {
      ViewPropertyAnimatorCompatJB.setListener(var2, var3);
   }

   public void withEndAction(ViewPropertyAnimatorCompat var1, View var2, Runnable var3) {
      ViewPropertyAnimatorCompatJB.withEndAction(var2, var3);
   }

   public void withLayer(ViewPropertyAnimatorCompat var1, View var2) {
      ViewPropertyAnimatorCompatJB.withLayer(var2);
   }

   public void withStartAction(ViewPropertyAnimatorCompat var1, View var2, Runnable var3) {
      ViewPropertyAnimatorCompatJB.withStartAction(var2, var3);
   }
}
