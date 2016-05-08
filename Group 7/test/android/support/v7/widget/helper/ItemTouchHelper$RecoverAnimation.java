package android.support.v7.widget.helper;

import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.animation.AnimatorListenerCompat;
import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView$ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper$RecoverAnimation$1;

class ItemTouchHelper$RecoverAnimation implements AnimatorListenerCompat {
   final int mActionState;
   private final int mAnimationType;
   private boolean mEnded;
   private float mFraction;
   public boolean mIsPendingCleanup;
   boolean mOverridden;
   final float mStartDx;
   final float mStartDy;
   final float mTargetX;
   final float mTargetY;
   private final ValueAnimatorCompat mValueAnimator;
   final RecyclerView$ViewHolder mViewHolder;
   float mX;
   float mY;

   public ItemTouchHelper$RecoverAnimation(ItemTouchHelper var1, RecyclerView$ViewHolder var2, int var3, int var4, float var5, float var6, float var7, float var8) {
      this.this$0 = var1;
      this.mOverridden = false;
      this.mEnded = false;
      this.mActionState = var4;
      this.mAnimationType = var3;
      this.mViewHolder = var2;
      this.mStartDx = var5;
      this.mStartDy = var6;
      this.mTargetX = var7;
      this.mTargetY = var8;
      this.mValueAnimator = AnimatorCompatHelper.emptyValueAnimator();
      this.mValueAnimator.addUpdateListener(new ItemTouchHelper$RecoverAnimation$1(this, var1));
      this.mValueAnimator.setTarget(var2.itemView);
      this.mValueAnimator.addListener(this);
      this.setFraction(0.0F);
   }

   public void cancel() {
      this.mValueAnimator.cancel();
   }

   public void onAnimationCancel(ValueAnimatorCompat var1) {
      this.setFraction(1.0F);
   }

   public void onAnimationEnd(ValueAnimatorCompat var1) {
      if(!this.mEnded) {
         this.mViewHolder.setIsRecyclable(true);
      }

      this.mEnded = true;
   }

   public void onAnimationRepeat(ValueAnimatorCompat var1) {
   }

   public void onAnimationStart(ValueAnimatorCompat var1) {
   }

   public void setDuration(long var1) {
      this.mValueAnimator.setDuration(var1);
   }

   public void setFraction(float var1) {
      this.mFraction = var1;
   }

   public void start() {
      this.mViewHolder.setIsRecyclable(false);
      this.mValueAnimator.start();
   }

   public void update() {
      if(this.mStartDx == this.mTargetX) {
         this.mX = ViewCompat.getTranslationX(this.mViewHolder.itemView);
      } else {
         this.mX = this.mStartDx + this.mFraction * (this.mTargetX - this.mStartDx);
      }

      if(this.mStartDy == this.mTargetY) {
         this.mY = ViewCompat.getTranslationY(this.mViewHolder.itemView);
      } else {
         this.mY = this.mStartDy + this.mFraction * (this.mTargetY - this.mStartDy);
      }
   }
}
