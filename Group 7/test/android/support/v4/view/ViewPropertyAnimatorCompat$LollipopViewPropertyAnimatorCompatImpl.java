package android.support.v4.view;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat$KitKatViewPropertyAnimatorCompatImpl;
import android.support.v4.view.ViewPropertyAnimatorCompatLollipop;
import android.view.View;

class ViewPropertyAnimatorCompat$LollipopViewPropertyAnimatorCompatImpl extends ViewPropertyAnimatorCompat$KitKatViewPropertyAnimatorCompatImpl {
   public void translationZ(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatLollipop.translationZ(var2, var3);
   }

   public void translationZBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatLollipop.translationZBy(var2, var3);
   }

   public void z(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatLollipop.z(var2, var3);
   }

   public void zBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      ViewPropertyAnimatorCompatLollipop.zBy(var2, var3);
   }
}
