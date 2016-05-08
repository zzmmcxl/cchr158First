package android.support.design.widget;

import android.os.Build.VERSION;
import android.support.design.widget.ValueAnimatorCompat;
import android.support.design.widget.ValueAnimatorCompat$Creator;
import android.support.design.widget.ViewUtils$1;
import android.support.design.widget.ViewUtils$ViewUtilsImpl;
import android.support.design.widget.ViewUtils$ViewUtilsImplBase;
import android.support.design.widget.ViewUtils$ViewUtilsImplLollipop;
import android.view.View;

class ViewUtils {
   static final ValueAnimatorCompat$Creator DEFAULT_ANIMATOR_CREATOR = new ViewUtils$1();
   private static final ViewUtils$ViewUtilsImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 21) {
         IMPL = new ViewUtils$ViewUtilsImplLollipop((ViewUtils$1)null);
      } else {
         IMPL = new ViewUtils$ViewUtilsImplBase((ViewUtils$1)null);
      }
   }

   static ValueAnimatorCompat createAnimator() {
      return DEFAULT_ANIMATOR_CREATOR.createAnimator();
   }

   static void setBoundsViewOutlineProvider(View var0) {
      IMPL.setBoundsViewOutlineProvider(var0);
   }
}
