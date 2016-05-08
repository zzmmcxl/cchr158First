package android.support.v4.view;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat$JBMr2ViewPropertyAnimatorCompatImpl;
import android.support.v4.view.ViewPropertyAnimatorCompatKK;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.view.View;

class ViewPropertyAnimatorCompat$KitKatViewPropertyAnimatorCompatImpl extends ViewPropertyAnimatorCompat$JBMr2ViewPropertyAnimatorCompatImpl {
   public void setUpdateListener(ViewPropertyAnimatorCompat var1, View var2, ViewPropertyAnimatorUpdateListener var3) {
      ViewPropertyAnimatorCompatKK.setUpdateListener(var2, var3);
   }
}
