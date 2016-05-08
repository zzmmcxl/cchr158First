package android.support.v4.widget;

import android.support.v4.widget.AutoScrollHelper;
import android.view.animation.AnimationUtils;

class AutoScrollHelper$ClampedScroller {
   private long mDeltaTime = 0L;
   private int mDeltaX = 0;
   private int mDeltaY = 0;
   private int mEffectiveRampDown;
   private int mRampDownDuration;
   private int mRampUpDuration;
   private long mStartTime = Long.MIN_VALUE;
   private long mStopTime = -1L;
   private float mStopValue;
   private float mTargetVelocityX;
   private float mTargetVelocityY;

   private float getValueAt(long var1) {
      if(var1 < this.mStartTime) {
         return 0.0F;
      } else if(this.mStopTime >= 0L && var1 >= this.mStopTime) {
         long var5 = this.mStopTime;
         float var3 = this.mStopValue;
         float var4 = this.mStopValue;
         return AutoScrollHelper.access$900((float)(var1 - var5) / (float)this.mEffectiveRampDown, 0.0F, 1.0F) * var4 + (1.0F - var3);
      } else {
         return AutoScrollHelper.access$900((float)(var1 - this.mStartTime) / (float)this.mRampUpDuration, 0.0F, 1.0F) * 0.5F;
      }
   }

   private float interpolateValue(float var1) {
      return -4.0F * var1 * var1 + 4.0F * var1;
   }

   public void computeScrollDelta() {
      if(this.mDeltaTime == 0L) {
         throw new RuntimeException("Cannot compute scroll delta before calling start()");
      } else {
         long var2 = AnimationUtils.currentAnimationTimeMillis();
         float var1 = this.interpolateValue(this.getValueAt(var2));
         long var4 = var2 - this.mDeltaTime;
         this.mDeltaTime = var2;
         this.mDeltaX = (int)((float)var4 * var1 * this.mTargetVelocityX);
         this.mDeltaY = (int)((float)var4 * var1 * this.mTargetVelocityY);
      }
   }

   public int getDeltaX() {
      return this.mDeltaX;
   }

   public int getDeltaY() {
      return this.mDeltaY;
   }

   public int getHorizontalDirection() {
      return (int)(this.mTargetVelocityX / Math.abs(this.mTargetVelocityX));
   }

   public int getVerticalDirection() {
      return (int)(this.mTargetVelocityY / Math.abs(this.mTargetVelocityY));
   }

   public boolean isFinished() {
      return this.mStopTime > 0L && AnimationUtils.currentAnimationTimeMillis() > this.mStopTime + (long)this.mEffectiveRampDown;
   }

   public void requestStop() {
      long var1 = AnimationUtils.currentAnimationTimeMillis();
      this.mEffectiveRampDown = AutoScrollHelper.access$800((int)(var1 - this.mStartTime), 0, this.mRampDownDuration);
      this.mStopValue = this.getValueAt(var1);
      this.mStopTime = var1;
   }

   public void setRampDownDuration(int var1) {
      this.mRampDownDuration = var1;
   }

   public void setRampUpDuration(int var1) {
      this.mRampUpDuration = var1;
   }

   public void setTargetVelocity(float var1, float var2) {
      this.mTargetVelocityX = var1;
      this.mTargetVelocityY = var2;
   }

   public void start() {
      this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
      this.mStopTime = -1L;
      this.mDeltaTime = this.mStartTime;
      this.mStopValue = 0.5F;
      this.mDeltaX = 0;
      this.mDeltaY = 0;
   }
}
