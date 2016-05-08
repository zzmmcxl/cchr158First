package android.support.design.widget;

import android.os.Build.VERSION;
import android.support.design.widget.ValueAnimatorCompat;
import android.support.design.widget.ValueAnimatorCompat$Creator;
import android.support.design.widget.ValueAnimatorCompat$Impl;
import android.support.design.widget.ValueAnimatorCompatImplEclairMr1;
import android.support.design.widget.ValueAnimatorCompatImplHoneycombMr1;

final class ViewUtils$1 implements ValueAnimatorCompat$Creator {
   public ValueAnimatorCompat createAnimator() {
      Object var1;
      if(VERSION.SDK_INT >= 12) {
         var1 = new ValueAnimatorCompatImplHoneycombMr1();
      } else {
         var1 = new ValueAnimatorCompatImplEclairMr1();
      }

      return new ValueAnimatorCompat((ValueAnimatorCompat$Impl)var1);
   }
}
