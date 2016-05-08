package android.support.design.widget;

import android.support.design.widget.ValueAnimatorCompat$Impl$AnimatorListenerProxy;
import android.support.design.widget.ValueAnimatorCompat$Impl$AnimatorUpdateListenerProxy;
import android.view.animation.Interpolator;

abstract class ValueAnimatorCompat$Impl {
   abstract void cancel();

   abstract void end();

   abstract float getAnimatedFloatValue();

   abstract float getAnimatedFraction();

   abstract int getAnimatedIntValue();

   abstract long getDuration();

   abstract boolean isRunning();

   abstract void setDuration(int var1);

   abstract void setFloatValues(float var1, float var2);

   abstract void setIntValues(int var1, int var2);

   abstract void setInterpolator(Interpolator var1);

   abstract void setListener(ValueAnimatorCompat$Impl$AnimatorListenerProxy var1);

   abstract void setUpdateListener(ValueAnimatorCompat$Impl$AnimatorUpdateListenerProxy var1);

   abstract void start();
}
