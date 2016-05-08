package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.widget.MaterialProgressDrawable$1;
import android.support.v4.widget.MaterialProgressDrawable$2;
import android.support.v4.widget.MaterialProgressDrawable$3;
import android.support.v4.widget.MaterialProgressDrawable$ProgressDrawableSize;
import android.support.v4.widget.MaterialProgressDrawable$Ring;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;

class MaterialProgressDrawable extends Drawable implements Animatable {
   private static final int ANIMATION_DURATION = 1332;
   private static final int ARROW_HEIGHT = 5;
   private static final int ARROW_HEIGHT_LARGE = 6;
   private static final float ARROW_OFFSET_ANGLE = 5.0F;
   private static final int ARROW_WIDTH = 10;
   private static final int ARROW_WIDTH_LARGE = 12;
   private static final float CENTER_RADIUS = 8.75F;
   private static final float CENTER_RADIUS_LARGE = 12.5F;
   private static final int CIRCLE_DIAMETER = 40;
   private static final int CIRCLE_DIAMETER_LARGE = 56;
   private static final float COLOR_START_DELAY_OFFSET = 0.75F;
   static final int DEFAULT = 1;
   private static final float END_TRIM_START_DELAY_OFFSET = 0.5F;
   private static final float FULL_ROTATION = 1080.0F;
   static final int LARGE = 0;
   private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
   private static final Interpolator MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
   private static final float MAX_PROGRESS_ARC = 0.8F;
   private static final float NUM_POINTS = 5.0F;
   private static final float START_TRIM_DURATION_OFFSET = 0.5F;
   private static final float STROKE_WIDTH = 2.5F;
   private static final float STROKE_WIDTH_LARGE = 3.0F;
   private final int[] COLORS = new int[]{-16777216};
   private Animation mAnimation;
   private final ArrayList<Animation> mAnimators = new ArrayList();
   private final Callback mCallback = new MaterialProgressDrawable$3(this);
   boolean mFinishing;
   private double mHeight;
   private View mParent;
   private Resources mResources;
   private final MaterialProgressDrawable$Ring mRing;
   private float mRotation;
   private float mRotationCount;
   private double mWidth;

   public MaterialProgressDrawable(Context var1, View var2) {
      this.mParent = var2;
      this.mResources = var1.getResources();
      this.mRing = new MaterialProgressDrawable$Ring(this.mCallback);
      this.mRing.setColors(this.COLORS);
      this.updateSizes(1);
      this.setupAnimators();
   }

   private void applyFinishTranslation(float var1, MaterialProgressDrawable$Ring var2) {
      this.updateRingColor(var1, var2);
      float var3 = (float)(Math.floor((double)(var2.getStartingRotation() / 0.8F)) + 1.0D);
      float var4 = this.getMinProgressArc(var2);
      var2.setStartTrim(var2.getStartingStartTrim() + (var2.getStartingEndTrim() - var4 - var2.getStartingStartTrim()) * var1);
      var2.setEndTrim(var2.getStartingEndTrim());
      var2.setRotation(var2.getStartingRotation() + (var3 - var2.getStartingRotation()) * var1);
   }

   private int evaluateColorChange(float var1, int var2, int var3) {
      int var6 = Integer.valueOf(var2).intValue();
      var2 = var6 >> 24 & 255;
      int var4 = var6 >> 16 & 255;
      int var5 = var6 >> 8 & 255;
      var6 &= 255;
      var3 = Integer.valueOf(var3).intValue();
      return (int)((float)((var3 >> 24 & 255) - var2) * var1) + var2 << 24 | (int)((float)((var3 >> 16 & 255) - var4) * var1) + var4 << 16 | (int)((float)((var3 >> 8 & 255) - var5) * var1) + var5 << 8 | (int)((float)((var3 & 255) - var6) * var1) + var6;
   }

   private float getMinProgressArc(MaterialProgressDrawable$Ring var1) {
      return (float)Math.toRadians((double)var1.getStrokeWidth() / (6.283185307179586D * var1.getCenterRadius()));
   }

   private float getRotation() {
      return this.mRotation;
   }

   private void setSizeParameters(double var1, double var3, double var5, double var7, float var9, float var10) {
      MaterialProgressDrawable$Ring var12 = this.mRing;
      float var11 = this.mResources.getDisplayMetrics().density;
      this.mWidth = (double)var11 * var1;
      this.mHeight = (double)var11 * var3;
      var12.setStrokeWidth((float)var7 * var11);
      var12.setCenterRadius((double)var11 * var5);
      var12.setColorIndex(0);
      var12.setArrowDimensions(var9 * var11, var10 * var11);
      var12.setInsets((int)this.mWidth, (int)this.mHeight);
   }

   private void setupAnimators() {
      MaterialProgressDrawable$Ring var1 = this.mRing;
      MaterialProgressDrawable$1 var2 = new MaterialProgressDrawable$1(this, var1);
      var2.setRepeatCount(-1);
      var2.setRepeatMode(1);
      var2.setInterpolator(LINEAR_INTERPOLATOR);
      var2.setAnimationListener(new MaterialProgressDrawable$2(this, var1));
      this.mAnimation = var2;
   }

   private void updateRingColor(float var1, MaterialProgressDrawable$Ring var2) {
      if(var1 > 0.75F) {
         var2.setColor(this.evaluateColorChange((var1 - 0.75F) / 0.25F, var2.getStartingColor(), var2.getNextColor()));
      }

   }

   public void draw(Canvas var1) {
      Rect var3 = this.getBounds();
      int var2 = var1.save();
      var1.rotate(this.mRotation, var3.exactCenterX(), var3.exactCenterY());
      this.mRing.draw(var1, var3);
      var1.restoreToCount(var2);
   }

   public int getAlpha() {
      return this.mRing.getAlpha();
   }

   public int getIntrinsicHeight() {
      return (int)this.mHeight;
   }

   public int getIntrinsicWidth() {
      return (int)this.mWidth;
   }

   public int getOpacity() {
      return -3;
   }

   public boolean isRunning() {
      ArrayList var3 = this.mAnimators;
      int var2 = var3.size();

      for(int var1 = 0; var1 < var2; ++var1) {
         Animation var4 = (Animation)var3.get(var1);
         if(var4.hasStarted() && !var4.hasEnded()) {
            return true;
         }
      }

      return false;
   }

   public void setAlpha(int var1) {
      this.mRing.setAlpha(var1);
   }

   public void setArrowScale(float var1) {
      this.mRing.setArrowScale(var1);
   }

   public void setBackgroundColor(int var1) {
      this.mRing.setBackgroundColor(var1);
   }

   public void setColorFilter(ColorFilter var1) {
      this.mRing.setColorFilter(var1);
   }

   public void setColorSchemeColors(int... var1) {
      this.mRing.setColors(var1);
      this.mRing.setColorIndex(0);
   }

   public void setProgressRotation(float var1) {
      this.mRing.setRotation(var1);
   }

   void setRotation(float var1) {
      this.mRotation = var1;
      this.invalidateSelf();
   }

   public void setStartEndTrim(float var1, float var2) {
      this.mRing.setStartTrim(var1);
      this.mRing.setEndTrim(var2);
   }

   public void showArrow(boolean var1) {
      this.mRing.setShowArrow(var1);
   }

   public void start() {
      this.mAnimation.reset();
      this.mRing.storeOriginals();
      if(this.mRing.getEndTrim() != this.mRing.getStartTrim()) {
         this.mFinishing = true;
         this.mAnimation.setDuration(666L);
         this.mParent.startAnimation(this.mAnimation);
      } else {
         this.mRing.setColorIndex(0);
         this.mRing.resetOriginals();
         this.mAnimation.setDuration(1332L);
         this.mParent.startAnimation(this.mAnimation);
      }
   }

   public void stop() {
      this.mParent.clearAnimation();
      this.setRotation(0.0F);
      this.mRing.setShowArrow(false);
      this.mRing.setColorIndex(0);
      this.mRing.resetOriginals();
   }

   public void updateSizes(@MaterialProgressDrawable$ProgressDrawableSize int var1) {
      if(var1 == 0) {
         this.setSizeParameters(56.0D, 56.0D, 12.5D, 3.0D, 12.0F, 6.0F);
      } else {
         this.setSizeParameters(40.0D, 40.0D, 8.75D, 2.5D, 10.0F, 5.0F);
      }
   }
}
