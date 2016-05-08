package android.support.design.widget;

import android.support.design.widget.ValueAnimatorCompat$1;
import android.support.design.widget.ValueAnimatorCompat$2;
import android.support.design.widget.ValueAnimatorCompat$AnimatorListener;
import android.support.design.widget.ValueAnimatorCompat$AnimatorUpdateListener;
import android.support.design.widget.ValueAnimatorCompat$Impl;
import android.support.design.widget.ValueAnimatorCompat$Impl$AnimatorListenerProxy;
import android.support.design.widget.ValueAnimatorCompat$Impl$AnimatorUpdateListenerProxy;
import android.view.animation.Interpolator;

class ValueAnimatorCompat {
   private final ValueAnimatorCompat$Impl mImpl;

   ValueAnimatorCompat(ValueAnimatorCompat$Impl var1) {
      this.mImpl = var1;
   }

   public void cancel() {
      this.mImpl.cancel();
   }

   public void end() {
      this.mImpl.end();
   }

   public float getAnimatedFloatValue() {
      return this.mImpl.getAnimatedFloatValue();
   }

   public float getAnimatedFraction() {
      return this.mImpl.getAnimatedFraction();
   }

   public int getAnimatedIntValue() {
      return this.mImpl.getAnimatedIntValue();
   }

   public long getDuration() {
      return this.mImpl.getDuration();
   }

   public boolean isRunning() {
      return this.mImpl.isRunning();
   }

   public void setDuration(int var1) {
      this.mImpl.setDuration(var1);
   }

   public void setFloatValues(float var1, float var2) {
      this.mImpl.setFloatValues(var1, var2);
   }

   public void setIntValues(int var1, int var2) {
      this.mImpl.setIntValues(var1, var2);
   }

   public void setInterpolator(Interpolator var1) {
      this.mImpl.setInterpolator(var1);
   }

   public void setListener(ValueAnimatorCompat$AnimatorListener var1) {
      if(var1 != null) {
         this.mImpl.setListener(new ValueAnimatorCompat$2(this, var1));
      } else {
         this.mImpl.setListener((ValueAnimatorCompat$Impl$AnimatorListenerProxy)null);
      }
   }

   public void setUpdateListener(ValueAnimatorCompat$AnimatorUpdateListener var1) {
      if(var1 != null) {
         this.mImpl.setUpdateListener(new ValueAnimatorCompat$1(this, var1));
      } else {
         this.mImpl.setUpdateListener((ValueAnimatorCompat$Impl$AnimatorUpdateListenerProxy)null);
      }
   }

   public void start() {
      this.mImpl.start();
   }
}
