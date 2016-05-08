package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.design.widget.AnimationUtils;
import android.support.design.widget.ValueAnimatorCompat$Impl;
import android.support.design.widget.ValueAnimatorCompat$Impl$AnimatorListenerProxy;
import android.support.design.widget.ValueAnimatorCompat$Impl$AnimatorUpdateListenerProxy;
import android.support.design.widget.ValueAnimatorCompatImplEclairMr1$1;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

class ValueAnimatorCompatImplEclairMr1 extends ValueAnimatorCompat$Impl {
   private static final int DEFAULT_DURATION = 200;
   private static final int HANDLER_DELAY = 10;
   private static final Handler sHandler = new Handler(Looper.getMainLooper());
   private float mAnimatedFraction;
   private int mDuration = 200;
   private final float[] mFloatValues = new float[2];
   private final int[] mIntValues = new int[2];
   private Interpolator mInterpolator;
   private boolean mIsRunning;
   private ValueAnimatorCompat$Impl$AnimatorListenerProxy mListener;
   private final Runnable mRunnable = new ValueAnimatorCompatImplEclairMr1$1(this);
   private long mStartTime;
   private ValueAnimatorCompat$Impl$AnimatorUpdateListenerProxy mUpdateListener;

   private void update() {
      if(this.mIsRunning) {
         float var2 = (float)(SystemClock.uptimeMillis() - this.mStartTime) / (float)this.mDuration;
         float var1 = var2;
         if(this.mInterpolator != null) {
            var1 = this.mInterpolator.getInterpolation(var2);
         }

         this.mAnimatedFraction = var1;
         if(this.mUpdateListener != null) {
            this.mUpdateListener.onAnimationUpdate();
         }

         if(SystemClock.uptimeMillis() >= this.mStartTime + (long)this.mDuration) {
            this.mIsRunning = false;
            if(this.mListener != null) {
               this.mListener.onAnimationEnd();
            }
         }
      }

      if(this.mIsRunning) {
         sHandler.postDelayed(this.mRunnable, 10L);
      }

   }

   public void cancel() {
      this.mIsRunning = false;
      sHandler.removeCallbacks(this.mRunnable);
      if(this.mListener != null) {
         this.mListener.onAnimationCancel();
      }

   }

   public void end() {
      if(this.mIsRunning) {
         this.mIsRunning = false;
         sHandler.removeCallbacks(this.mRunnable);
         this.mAnimatedFraction = 1.0F;
         if(this.mUpdateListener != null) {
            this.mUpdateListener.onAnimationUpdate();
         }

         if(this.mListener != null) {
            this.mListener.onAnimationEnd();
         }
      }

   }

   public float getAnimatedFloatValue() {
      return AnimationUtils.lerp(this.mFloatValues[0], this.mFloatValues[1], this.getAnimatedFraction());
   }

   public float getAnimatedFraction() {
      return this.mAnimatedFraction;
   }

   public int getAnimatedIntValue() {
      return AnimationUtils.lerp(this.mIntValues[0], this.mIntValues[1], this.getAnimatedFraction());
   }

   public long getDuration() {
      return (long)this.mDuration;
   }

   public boolean isRunning() {
      return this.mIsRunning;
   }

   public void setDuration(int var1) {
      this.mDuration = var1;
   }

   public void setFloatValues(float var1, float var2) {
      this.mFloatValues[0] = var1;
      this.mFloatValues[1] = var2;
   }

   public void setIntValues(int var1, int var2) {
      this.mIntValues[0] = var1;
      this.mIntValues[1] = var2;
   }

   public void setInterpolator(Interpolator var1) {
      this.mInterpolator = var1;
   }

   public void setListener(ValueAnimatorCompat$Impl$AnimatorListenerProxy var1) {
      this.mListener = var1;
   }

   public void setUpdateListener(ValueAnimatorCompat$Impl$AnimatorUpdateListenerProxy var1) {
      this.mUpdateListener = var1;
   }

   public void start() {
      if(!this.mIsRunning) {
         if(this.mInterpolator == null) {
            this.mInterpolator = new AccelerateDecelerateInterpolator();
         }

         this.mStartTime = SystemClock.uptimeMillis();
         this.mIsRunning = true;
         if(this.mListener != null) {
            this.mListener.onAnimationStart();
         }

         sHandler.postDelayed(this.mRunnable, 10L);
      }
   }
}
