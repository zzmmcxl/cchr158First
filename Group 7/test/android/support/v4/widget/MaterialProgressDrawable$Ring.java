package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path.FillType;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;

class MaterialProgressDrawable$Ring {
   private int mAlpha;
   private Path mArrow;
   private int mArrowHeight;
   private final Paint mArrowPaint = new Paint();
   private float mArrowScale;
   private int mArrowWidth;
   private int mBackgroundColor;
   private final Callback mCallback;
   private final Paint mCirclePaint = new Paint(1);
   private int mColorIndex;
   private int[] mColors;
   private int mCurrentColor;
   private float mEndTrim = 0.0F;
   private final Paint mPaint = new Paint();
   private double mRingCenterRadius;
   private float mRotation = 0.0F;
   private boolean mShowArrow;
   private float mStartTrim = 0.0F;
   private float mStartingEndTrim;
   private float mStartingRotation;
   private float mStartingStartTrim;
   private float mStrokeInset = 2.5F;
   private float mStrokeWidth = 5.0F;
   private final RectF mTempBounds = new RectF();

   public MaterialProgressDrawable$Ring(Callback var1) {
      this.mCallback = var1;
      this.mPaint.setStrokeCap(Cap.SQUARE);
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStyle(Style.STROKE);
      this.mArrowPaint.setStyle(Style.FILL);
      this.mArrowPaint.setAntiAlias(true);
   }

   private void drawTriangle(Canvas var1, float var2, float var3, Rect var4) {
      if(this.mShowArrow) {
         if(this.mArrow == null) {
            this.mArrow = new Path();
            this.mArrow.setFillType(FillType.EVEN_ODD);
         } else {
            this.mArrow.reset();
         }

         float var5 = (float)((int)this.mStrokeInset / 2);
         float var6 = this.mArrowScale;
         float var7 = (float)(this.mRingCenterRadius * Math.cos(0.0D) + (double)var4.exactCenterX());
         float var8 = (float)(this.mRingCenterRadius * Math.sin(0.0D) + (double)var4.exactCenterY());
         this.mArrow.moveTo(0.0F, 0.0F);
         this.mArrow.lineTo((float)this.mArrowWidth * this.mArrowScale, 0.0F);
         this.mArrow.lineTo((float)this.mArrowWidth * this.mArrowScale / 2.0F, (float)this.mArrowHeight * this.mArrowScale);
         this.mArrow.offset(var7 - var5 * var6, var8);
         this.mArrow.close();
         this.mArrowPaint.setColor(this.mCurrentColor);
         var1.rotate(var2 + var3 - 5.0F, var4.exactCenterX(), var4.exactCenterY());
         var1.drawPath(this.mArrow, this.mArrowPaint);
      }

   }

   private int getNextColorIndex() {
      return (this.mColorIndex + 1) % this.mColors.length;
   }

   private void invalidateSelf() {
      this.mCallback.invalidateDrawable((Drawable)null);
   }

   public void draw(Canvas var1, Rect var2) {
      RectF var5 = this.mTempBounds;
      var5.set(var2);
      var5.inset(this.mStrokeInset, this.mStrokeInset);
      float var3 = (this.mStartTrim + this.mRotation) * 360.0F;
      float var4 = (this.mEndTrim + this.mRotation) * 360.0F - var3;
      this.mPaint.setColor(this.mCurrentColor);
      var1.drawArc(var5, var3, var4, false, this.mPaint);
      this.drawTriangle(var1, var3, var4, var2);
      if(this.mAlpha < 255) {
         this.mCirclePaint.setColor(this.mBackgroundColor);
         this.mCirclePaint.setAlpha(255 - this.mAlpha);
         var1.drawCircle(var2.exactCenterX(), var2.exactCenterY(), (float)(var2.width() / 2), this.mCirclePaint);
      }

   }

   public int getAlpha() {
      return this.mAlpha;
   }

   public double getCenterRadius() {
      return this.mRingCenterRadius;
   }

   public float getEndTrim() {
      return this.mEndTrim;
   }

   public float getInsets() {
      return this.mStrokeInset;
   }

   public int getNextColor() {
      return this.mColors[this.getNextColorIndex()];
   }

   public float getRotation() {
      return this.mRotation;
   }

   public float getStartTrim() {
      return this.mStartTrim;
   }

   public int getStartingColor() {
      return this.mColors[this.mColorIndex];
   }

   public float getStartingEndTrim() {
      return this.mStartingEndTrim;
   }

   public float getStartingRotation() {
      return this.mStartingRotation;
   }

   public float getStartingStartTrim() {
      return this.mStartingStartTrim;
   }

   public float getStrokeWidth() {
      return this.mStrokeWidth;
   }

   public void goToNextColor() {
      this.setColorIndex(this.getNextColorIndex());
   }

   public void resetOriginals() {
      this.mStartingStartTrim = 0.0F;
      this.mStartingEndTrim = 0.0F;
      this.mStartingRotation = 0.0F;
      this.setStartTrim(0.0F);
      this.setEndTrim(0.0F);
      this.setRotation(0.0F);
   }

   public void setAlpha(int var1) {
      this.mAlpha = var1;
   }

   public void setArrowDimensions(float var1, float var2) {
      this.mArrowWidth = (int)var1;
      this.mArrowHeight = (int)var2;
   }

   public void setArrowScale(float var1) {
      if(var1 != this.mArrowScale) {
         this.mArrowScale = var1;
         this.invalidateSelf();
      }

   }

   public void setBackgroundColor(int var1) {
      this.mBackgroundColor = var1;
   }

   public void setCenterRadius(double var1) {
      this.mRingCenterRadius = var1;
   }

   public void setColor(int var1) {
      this.mCurrentColor = var1;
   }

   public void setColorFilter(ColorFilter var1) {
      this.mPaint.setColorFilter(var1);
      this.invalidateSelf();
   }

   public void setColorIndex(int var1) {
      this.mColorIndex = var1;
      this.mCurrentColor = this.mColors[this.mColorIndex];
   }

   public void setColors(@NonNull int[] var1) {
      this.mColors = var1;
      this.setColorIndex(0);
   }

   public void setEndTrim(float var1) {
      this.mEndTrim = var1;
      this.invalidateSelf();
   }

   public void setInsets(int var1, int var2) {
      float var3 = (float)Math.min(var1, var2);
      if(this.mRingCenterRadius > 0.0D && var3 >= 0.0F) {
         var3 = (float)((double)(var3 / 2.0F) - this.mRingCenterRadius);
      } else {
         var3 = (float)Math.ceil((double)(this.mStrokeWidth / 2.0F));
      }

      this.mStrokeInset = var3;
   }

   public void setRotation(float var1) {
      this.mRotation = var1;
      this.invalidateSelf();
   }

   public void setShowArrow(boolean var1) {
      if(this.mShowArrow != var1) {
         this.mShowArrow = var1;
         this.invalidateSelf();
      }

   }

   public void setStartTrim(float var1) {
      this.mStartTrim = var1;
      this.invalidateSelf();
   }

   public void setStrokeWidth(float var1) {
      this.mStrokeWidth = var1;
      this.mPaint.setStrokeWidth(var1);
      this.invalidateSelf();
   }

   public void storeOriginals() {
      this.mStartingStartTrim = this.mStartTrim;
      this.mStartingEndTrim = this.mEndTrim;
      this.mStartingRotation = this.mRotation;
   }
}
