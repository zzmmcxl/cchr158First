package android.support.design.widget;

import android.support.design.widget.FloatingActionButtonEclairMr1;
import android.view.animation.Animation;
import android.view.animation.Transformation;

abstract class FloatingActionButtonEclairMr1$BaseShadowAnimation extends Animation {
   private float mShadowSizeDiff;
   private float mShadowSizeStart;

   private FloatingActionButtonEclairMr1$BaseShadowAnimation(FloatingActionButtonEclairMr1 var1) {
      this.this$0 = var1;
   }

   protected void applyTransformation(float var1, Transformation var2) {
      this.this$0.mShadowDrawable.setShadowSize(this.mShadowSizeStart + this.mShadowSizeDiff * var1);
   }

   protected abstract float getTargetShadowSize();

   public void reset() {
      super.reset();
      this.mShadowSizeStart = this.this$0.mShadowDrawable.getShadowSize();
      this.mShadowSizeDiff = this.getTargetShadowSize() - this.mShadowSizeStart;
   }
}
