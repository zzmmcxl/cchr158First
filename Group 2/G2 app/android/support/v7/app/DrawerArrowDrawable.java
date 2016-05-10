package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;

abstract class DrawerArrowDrawable extends Drawable {
   private static final float ARROW_HEAD_ANGLE = (float)Math.toRadians(45.0D);
   private final float mBarGap;
   private final float mBarSize;
   private final float mBarThickness;
   private float mCenterOffset;
   private float mMaxCutForBarSize;
   private final float mMiddleArrowSize;
   private final Paint mPaint = new Paint();
   private final Path mPath = new Path();
   private float mProgress;
   private final int mSize;
   private final boolean mSpin;
   private final float mTopBottomArrowSize;
   private boolean mVerticalMirror = false;

   DrawerArrowDrawable(Context var1) {
      TypedArray var2 = var1.getTheme().obtainStyledAttributes((AttributeSet)null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
      this.mPaint.setAntiAlias(true);
      this.mPaint.setColor(var2.getColor(R.styleable.DrawerArrowToggle_color, 0));
      this.mSize = var2.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
      this.mBarSize = (float)Math.round(var2.getDimension(R.styleable.DrawerArrowToggle_barSize, 0.0F));
      this.mTopBottomArrowSize = (float)Math.round(var2.getDimension(R.styleable.DrawerArrowToggle_topBottomBarArrowSize, 0.0F));
      this.mBarThickness = var2.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0F);
      this.mBarGap = (float)Math.round(var2.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0F));
      this.mSpin = var2.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true);
      this.mMiddleArrowSize = var2.getDimension(R.styleable.DrawerArrowToggle_middleBarArrowSize, 0.0F);
      this.mCenterOffset = (float)((int)((float)this.mSize - this.mBarThickness * 3.0F - this.mBarGap * 2.0F) / 4 * 2);
      this.mCenterOffset = (float)((double)this.mCenterOffset + (double)this.mBarThickness * 1.5D + (double)this.mBarGap);
      var2.recycle();
      this.mPaint.setStyle(Style.STROKE);
      this.mPaint.setStrokeJoin(Join.MITER);
      this.mPaint.setStrokeCap(Cap.BUTT);
      this.mPaint.setStrokeWidth(this.mBarThickness);
      this.mMaxCutForBarSize = (float)((double)(this.mBarThickness / 2.0F) * Math.cos((double)ARROW_HEAD_ANGLE));
   }

   private static float lerp(float var0, float var1, float var2) {
      return (var1 - var0) * var2 + var0;
   }

   public void draw(Canvas var1) {
      Rect var11 = this.getBounds();
      boolean var10 = this.isLayoutRtl();
      float var6 = lerp(this.mBarSize, this.mTopBottomArrowSize, this.mProgress);
      float var4 = lerp(this.mBarSize, this.mMiddleArrowSize, this.mProgress);
      float var5 = (float)Math.round(lerp(0.0F, this.mMaxCutForBarSize, this.mProgress));
      float var7 = lerp(0.0F, ARROW_HEAD_ANGLE, this.mProgress);
      float var2;
      if(var10) {
         var2 = 0.0F;
      } else {
         var2 = -180.0F;
      }

      float var3;
      if(var10) {
         var3 = 180.0F;
      } else {
         var3 = 0.0F;
      }

      var2 = lerp(var2, var3, this.mProgress);
      var3 = (float)Math.round((double)var6 * Math.cos((double)var7));
      var6 = (float)Math.round((double)var6 * Math.sin((double)var7));
      this.mPath.rewind();
      var7 = lerp(this.mBarGap + this.mBarThickness, -this.mMaxCutForBarSize, this.mProgress);
      float var8 = -var4 / 2.0F;
      this.mPath.moveTo(var8 + var5, 0.0F);
      this.mPath.rLineTo(var4 - 2.0F * var5, 0.0F);
      this.mPath.moveTo(var8, var7);
      this.mPath.rLineTo(var3, var6);
      this.mPath.moveTo(var8, -var7);
      this.mPath.rLineTo(var3, -var6);
      this.mPath.close();
      var1.save();
      var1.translate((float)var11.centerX(), this.mCenterOffset);
      if(this.mSpin) {
         byte var9;
         if(this.mVerticalMirror ^ var10) {
            var9 = -1;
         } else {
            var9 = 1;
         }

         var1.rotate((float)var9 * var2);
      } else if(var10) {
         var1.rotate(180.0F);
      }

      var1.drawPath(this.mPath, this.mPaint);
      var1.restore();
   }

   public int getIntrinsicHeight() {
      return this.mSize;
   }

   public int getIntrinsicWidth() {
      return this.mSize;
   }

   public int getOpacity() {
      return -3;
   }

   public float getProgress() {
      return this.mProgress;
   }

   public boolean isAutoMirrored() {
      return true;
   }

   abstract boolean isLayoutRtl();

   public void setAlpha(int var1) {
      this.mPaint.setAlpha(var1);
   }

   public void setColorFilter(ColorFilter var1) {
      this.mPaint.setColorFilter(var1);
   }

   public void setProgress(float var1) {
      this.mProgress = var1;
      this.invalidateSelf();
   }

   protected void setVerticalMirror(boolean var1) {
      this.mVerticalMirror = var1;
   }
}
