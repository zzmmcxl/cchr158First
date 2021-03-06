package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.Nullable;
import android.support.design.R$anim;
import android.support.design.widget.AnimationUtils;
import android.support.design.widget.FloatingActionButtonEclairMr1$1;
import android.support.design.widget.FloatingActionButtonEclairMr1$2;
import android.support.design.widget.FloatingActionButtonEclairMr1$ElevateToTranslationZAnimation;
import android.support.design.widget.FloatingActionButtonEclairMr1$ResetElevationAnimation;
import android.support.design.widget.FloatingActionButtonImpl;
import android.support.design.widget.FloatingActionButtonImpl$InternalVisibilityChangedListener;
import android.support.design.widget.ShadowDrawableWrapper;
import android.support.design.widget.ShadowViewDelegate;
import android.support.design.widget.StateListAnimator;
import android.support.design.widget.VisibilityAwareImageButton;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.animation.Animation;

class FloatingActionButtonEclairMr1 extends FloatingActionButtonImpl {
   private int mAnimationDuration;
   private boolean mIsHiding;
   ShadowDrawableWrapper mShadowDrawable;
   private StateListAnimator mStateListAnimator;

   FloatingActionButtonEclairMr1(VisibilityAwareImageButton var1, ShadowViewDelegate var2) {
      super(var1, var2);
      this.mAnimationDuration = var1.getResources().getInteger(17694720);
      this.mStateListAnimator = new StateListAnimator();
      this.mStateListAnimator.setTarget(var1);
      this.mStateListAnimator.addState(PRESSED_ENABLED_STATE_SET, this.setupAnimation(new FloatingActionButtonEclairMr1$ElevateToTranslationZAnimation(this, (FloatingActionButtonEclairMr1$1)null)));
      this.mStateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, this.setupAnimation(new FloatingActionButtonEclairMr1$ElevateToTranslationZAnimation(this, (FloatingActionButtonEclairMr1$1)null)));
      this.mStateListAnimator.addState(EMPTY_STATE_SET, this.setupAnimation(new FloatingActionButtonEclairMr1$ResetElevationAnimation(this, (FloatingActionButtonEclairMr1$1)null)));
   }

   private static ColorStateList createColorStateList(int var0) {
      int[][] var2 = new int[3][];
      int[] var3 = new int[3];
      var2[0] = FOCUSED_ENABLED_STATE_SET;
      var3[0] = var0;
      int var1 = 0 + 1;
      var2[var1] = PRESSED_ENABLED_STATE_SET;
      var3[var1] = var0;
      var0 = var1 + 1;
      var2[var0] = new int[0];
      var3[var0] = 0;
      return new ColorStateList(var2, var3);
   }

   private Animation setupAnimation(Animation var1) {
      var1.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
      var1.setDuration((long)this.mAnimationDuration);
      return var1;
   }

   float getElevation() {
      return this.mElevation;
   }

   void getPadding(Rect var1) {
      this.mShadowDrawable.getPadding(var1);
   }

   void hide(@Nullable FloatingActionButtonImpl$InternalVisibilityChangedListener var1, boolean var2) {
      if(!this.mIsHiding && this.mView.getVisibility() == 0) {
         Animation var3 = android.view.animation.AnimationUtils.loadAnimation(this.mView.getContext(), R$anim.design_fab_out);
         var3.setInterpolator(AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
         var3.setDuration(200L);
         var3.setAnimationListener(new FloatingActionButtonEclairMr1$1(this, var2, var1));
         this.mView.startAnimation(var3);
      } else {
         if(var1 != null) {
            var1.onHidden();
         }

      }
   }

   void jumpDrawableToCurrentState() {
      this.mStateListAnimator.jumpToCurrentState();
   }

   void onCompatShadowChanged() {
   }

   void onDrawableStateChanged(int[] var1) {
      this.mStateListAnimator.setState(var1);
   }

   void onElevationChanged(float var1) {
      if(this.mShadowDrawable != null) {
         this.mShadowDrawable.setShadowSize(var1, this.mPressedTranslationZ + var1);
         this.updatePadding();
      }

   }

   void onTranslationZChanged(float var1) {
      if(this.mShadowDrawable != null) {
         this.mShadowDrawable.setMaxShadowSize(this.mElevation + var1);
         this.updatePadding();
      }

   }

   void setBackgroundDrawable(ColorStateList var1, Mode var2, int var3, int var4) {
      this.mShapeDrawable = DrawableCompat.wrap(this.createShapeDrawable());
      DrawableCompat.setTintList(this.mShapeDrawable, var1);
      if(var2 != null) {
         DrawableCompat.setTintMode(this.mShapeDrawable, var2);
      }

      this.mRippleDrawable = DrawableCompat.wrap(this.createShapeDrawable());
      DrawableCompat.setTintList(this.mRippleDrawable, createColorStateList(var3));
      Drawable[] var5;
      if(var4 > 0) {
         this.mBorderDrawable = this.createBorderDrawable(var4, var1);
         var5 = new Drawable[]{this.mBorderDrawable, this.mShapeDrawable, this.mRippleDrawable};
      } else {
         this.mBorderDrawable = null;
         var5 = new Drawable[]{this.mShapeDrawable, this.mRippleDrawable};
      }

      this.mContentBackground = new LayerDrawable(var5);
      this.mShadowDrawable = new ShadowDrawableWrapper(this.mView.getResources(), this.mContentBackground, this.mShadowViewDelegate.getRadius(), this.mElevation, this.mElevation + this.mPressedTranslationZ);
      this.mShadowDrawable.setAddPaddingForCorners(false);
      this.mShadowViewDelegate.setBackgroundDrawable(this.mShadowDrawable);
   }

   void setBackgroundTintList(ColorStateList var1) {
      if(this.mShapeDrawable != null) {
         DrawableCompat.setTintList(this.mShapeDrawable, var1);
      }

      if(this.mBorderDrawable != null) {
         this.mBorderDrawable.setBorderTint(var1);
      }

   }

   void setBackgroundTintMode(Mode var1) {
      if(this.mShapeDrawable != null) {
         DrawableCompat.setTintMode(this.mShapeDrawable, var1);
      }

   }

   void setRippleColor(int var1) {
      if(this.mRippleDrawable != null) {
         DrawableCompat.setTintList(this.mRippleDrawable, createColorStateList(var1));
      }

   }

   void show(@Nullable FloatingActionButtonImpl$InternalVisibilityChangedListener var1, boolean var2) {
      if(this.mView.getVisibility() == 0 && !this.mIsHiding) {
         if(var1 != null) {
            var1.onShown();
            return;
         }
      } else {
         this.mView.clearAnimation();
         this.mView.internalSetVisibility(0, var2);
         Animation var3 = android.view.animation.AnimationUtils.loadAnimation(this.mView.getContext(), R$anim.design_fab_in);
         var3.setDuration(200L);
         var3.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
         var3.setAnimationListener(new FloatingActionButtonEclairMr1$2(this, var1));
         this.mView.startAnimation(var3);
      }

   }
}
