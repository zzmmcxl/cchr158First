package android.support.design.widget;

import android.support.design.widget.FloatingActionButtonEclairMr1;
import android.support.design.widget.FloatingActionButtonEclairMr1$1;
import android.support.design.widget.FloatingActionButtonEclairMr1$BaseShadowAnimation;

class FloatingActionButtonEclairMr1$ResetElevationAnimation extends FloatingActionButtonEclairMr1$BaseShadowAnimation {
   private FloatingActionButtonEclairMr1$ResetElevationAnimation(FloatingActionButtonEclairMr1 var1) {
      super(var1, (FloatingActionButtonEclairMr1$1)null);
      this.this$0 = var1;
   }

   protected float getTargetShadowSize() {
      return this.this$0.mElevation;
   }
}
