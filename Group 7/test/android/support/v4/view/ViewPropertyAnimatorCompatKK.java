package android.support.v4.view;

import android.support.v4.view.ViewPropertyAnimatorCompatKK$1;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.view.View;

class ViewPropertyAnimatorCompatKK {
   public static void setUpdateListener(View var0, ViewPropertyAnimatorUpdateListener var1) {
      ViewPropertyAnimatorCompatKK$1 var2 = null;
      if(var1 != null) {
         var2 = new ViewPropertyAnimatorCompatKK$1(var1, var0);
      }

      var0.animate().setUpdateListener(var2);
   }
}
