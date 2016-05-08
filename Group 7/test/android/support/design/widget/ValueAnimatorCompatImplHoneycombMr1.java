package android.support.design.widget;

import android.animation.ValueAnimator;
import android.support.design.widget.ValueAnimatorCompat$Impl;
import android.support.design.widget.ValueAnimatorCompat$Impl$AnimatorListenerProxy;
import android.support.design.widget.ValueAnimatorCompat$Impl$AnimatorUpdateListenerProxy;
import android.support.design.widget.ValueAnimatorCompatImplHoneycombMr1$1;
import android.support.design.widget.ValueAnimatorCompatImplHoneycombMr1$2;
import android.view.animation.Interpolator;

class ValueAnimatorCompatImplHoneycombMr1 extends ValueAnimatorCompat$Impl {
   final ValueAnimator mValueAnimator = new ValueAnimator();

   public void cancel() {
      this.mValueAnimator.cancel();
   }

   public void end() {
      this.mValueAnimator.end();
   }

   public float getAnimatedFloatValue() {
      return ((Float)this.mValueAnimator.getAnimatedValue()).floatValue();
   }

   public float getAnimatedFraction() {
      return this.mValueAnimator.getAnimatedFraction();
   }

   public int getAnimatedIntValue() {
      return ((Integer)this.mValueAnimator.getAnimatedValue()).intValue();
   }

   public long getDuration() {
      return this.mValueAnimator.getDuration();
   }

   public boolean isRunning() {
      return this.mValueAnimator.isRunning();
   }

   public void setDuration(int var1) {
      this.mValueAnimator.setDuration((long)var1);
   }

   public void setFloatValues(float var1, float var2) {
      this.mValueAnimator.setFloatValues(new float[]{var1, var2});
   }

   public void setIntValues(int var1, int var2) {
      this.mValueAnimator.setIntValues(new int[]{var1, var2});
   }

   public void setInterpolator(Interpolator var1) {
      this.mValueAnimator.setInterpolator(var1);
   }

   public void setListener(ValueAnimatorCompat$Impl$AnimatorListenerProxy var1) {
      this.mValueAnimator.addListener(new ValueAnimatorCompatImplHoneycombMr1$2(this, var1));
   }

   public void setUpdateListener(ValueAnimatorCompat$Impl$AnimatorUpdateListenerProxy var1) {
      this.mValueAnimator.addUpdateListener(new ValueAnimatorCompatImplHoneycombMr1$1(this, var1));
   }

   public void start() {
      this.mValueAnimator.start();
   }
}
