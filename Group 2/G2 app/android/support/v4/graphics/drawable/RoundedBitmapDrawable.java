package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

public abstract class RoundedBitmapDrawable extends Drawable {
   private static final int DEFAULT_PAINT_FLAGS = 6;
   private boolean mApplyGravity = true;
   Bitmap mBitmap;
   private int mBitmapHeight;
   private BitmapShader mBitmapShader;
   private int mBitmapWidth;
   private float mCornerRadius;
   final Rect mDstRect = new Rect();
   final RectF mDstRectF = new RectF();
   private int mGravity = 119;
   private Paint mPaint = new Paint(6);
   private int mTargetDensity = 160;

   RoundedBitmapDrawable(Resources var1, Bitmap var2) {
      if(var1 != null) {
         this.mTargetDensity = var1.getDisplayMetrics().densityDpi;
      }

      this.mBitmap = var2;
      if(this.mBitmap != null) {
         this.computeBitmapSize();
         this.mBitmapShader = new BitmapShader(this.mBitmap, TileMode.CLAMP, TileMode.CLAMP);
      } else {
         this.mBitmapHeight = -1;
         this.mBitmapWidth = -1;
      }
   }

   private void computeBitmapSize() {
      this.mBitmapWidth = this.mBitmap.getScaledWidth(this.mTargetDensity);
      this.mBitmapHeight = this.mBitmap.getScaledHeight(this.mTargetDensity);
   }

   private static boolean isGreaterThanZero(float var0) {
      return Float.compare(var0, 0.0F) > 0;
   }

   public void draw(Canvas var1) {
      Bitmap var2 = this.mBitmap;
      if(var2 != null) {
         this.updateDstRect();
         Paint var3 = this.mPaint;
         if(var3.getShader() == null) {
            var1.drawBitmap(var2, (Rect)null, this.mDstRect, var3);
         } else {
            var1.drawRoundRect(this.mDstRectF, this.mCornerRadius, this.mCornerRadius, var3);
         }
      }
   }

   public int getAlpha() {
      return this.mPaint.getAlpha();
   }

   public final Bitmap getBitmap() {
      return this.mBitmap;
   }

   public ColorFilter getColorFilter() {
      return this.mPaint.getColorFilter();
   }

   public float getCornerRadius() {
      return this.mCornerRadius;
   }

   public int getGravity() {
      return this.mGravity;
   }

   public int getIntrinsicHeight() {
      return this.mBitmapHeight;
   }

   public int getIntrinsicWidth() {
      return this.mBitmapWidth;
   }

   public int getOpacity() {
      if(this.mGravity == 119) {
         Bitmap var1 = this.mBitmap;
         if(var1 != null && !var1.hasAlpha() && this.mPaint.getAlpha() >= 255 && !isGreaterThanZero(this.mCornerRadius)) {
            return -1;
         }
      }

      return -3;
   }

   public final Paint getPaint() {
      return this.mPaint;
   }

   void gravityCompatApply(int var1, int var2, int var3, Rect var4, Rect var5) {
      throw new UnsupportedOperationException();
   }

   public boolean hasAntiAlias() {
      return this.mPaint.isAntiAlias();
   }

   public boolean hasMipMap() {
      throw new UnsupportedOperationException();
   }

   public void setAlpha(int var1) {
      if(var1 != this.mPaint.getAlpha()) {
         this.mPaint.setAlpha(var1);
         this.invalidateSelf();
      }

   }

   public void setAntiAlias(boolean var1) {
      this.mPaint.setAntiAlias(var1);
      this.invalidateSelf();
   }

   public void setColorFilter(ColorFilter var1) {
      this.mPaint.setColorFilter(var1);
      this.invalidateSelf();
   }

   public void setCornerRadius(float var1) {
      if(isGreaterThanZero(var1)) {
         this.mPaint.setShader(this.mBitmapShader);
      } else {
         this.mPaint.setShader((Shader)null);
      }

      this.mCornerRadius = var1;
   }

   public void setDither(boolean var1) {
      this.mPaint.setDither(var1);
      this.invalidateSelf();
   }

   public void setFilterBitmap(boolean var1) {
      this.mPaint.setFilterBitmap(var1);
      this.invalidateSelf();
   }

   public void setGravity(int var1) {
      if(this.mGravity != var1) {
         this.mGravity = var1;
         this.mApplyGravity = true;
         this.invalidateSelf();
      }

   }

   public void setMipMap(boolean var1) {
      throw new UnsupportedOperationException();
   }

   public void setTargetDensity(int var1) {
      if(this.mTargetDensity != var1) {
         int var2 = var1;
         if(var1 == 0) {
            var2 = 160;
         }

         this.mTargetDensity = var2;
         if(this.mBitmap != null) {
            this.computeBitmapSize();
         }

         this.invalidateSelf();
      }

   }

   public void setTargetDensity(Canvas var1) {
      this.setTargetDensity(var1.getDensity());
   }

   public void setTargetDensity(DisplayMetrics var1) {
      this.setTargetDensity(var1.densityDpi);
   }

   void updateDstRect() {
      if(this.mApplyGravity) {
         this.gravityCompatApply(this.mGravity, this.mBitmapWidth, this.mBitmapHeight, this.getBounds(), this.mDstRect);
         this.mDstRectF.set(this.mDstRect);
         this.mApplyGravity = false;
      }

   }
}
