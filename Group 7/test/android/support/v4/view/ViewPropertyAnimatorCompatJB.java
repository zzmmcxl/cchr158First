package android.support.v4.view;

import android.animation.Animator.AnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorCompatJB$1;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;

class ViewPropertyAnimatorCompatJB {
   public static void setListener(View var0, ViewPropertyAnimatorListener var1) {
      if(var1 != null) {
         var0.animate().setListener(new ViewPropertyAnimatorCompatJB$1(var1, var0));
      } else {
         var0.animate().setListener((AnimatorListener)null);
      }
   }

   public static void withEndAction(View var0, Runnable var1) {
      var0.animate().withEndAction(var1);
   }

   public static void withLayer(View var0) {
      var0.animate().withLayer();
   }

   public static void withStartAction(View var0, Runnable var1) {
      var0.animate().withStartAction(var1);
   }
}
