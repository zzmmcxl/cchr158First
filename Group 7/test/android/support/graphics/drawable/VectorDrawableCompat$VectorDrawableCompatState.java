package android.support.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.graphics.drawable.VectorDrawableCompat$1;
import android.support.graphics.drawable.VectorDrawableCompat$VPathRenderer;

class VectorDrawableCompat$VectorDrawableCompatState extends ConstantState {
   boolean mAutoMirrored;
   boolean mCacheDirty;
   boolean mCachedAutoMirrored;
   Bitmap mCachedBitmap;
   int mCachedRootAlpha;
   int[] mCachedThemeAttrs;
   ColorStateList mCachedTint;
   Mode mCachedTintMode;
   int mChangingConfigurations;
   Paint mTempPaint;
   ColorStateList mTint = null;
   Mode mTintMode;
   VectorDrawableCompat$VPathRenderer mVPathRenderer;

   public VectorDrawableCompat$VectorDrawableCompatState() {
      this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
      this.mVPathRenderer = new VectorDrawableCompat$VPathRenderer();
   }

   public VectorDrawableCompat$VectorDrawableCompatState(VectorDrawableCompat$VectorDrawableCompatState var1) {
      this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
      if(var1 != null) {
         this.mChangingConfigurations = var1.mChangingConfigurations;
         this.mVPathRenderer = new VectorDrawableCompat$VPathRenderer(var1.mVPathRenderer);
         if(VectorDrawableCompat$VPathRenderer.access$400(var1.mVPathRenderer) != null) {
            VectorDrawableCompat$VPathRenderer.access$402(this.mVPathRenderer, new Paint(VectorDrawableCompat$VPathRenderer.access$400(var1.mVPathRenderer)));
         }

         if(VectorDrawableCompat$VPathRenderer.access$500(var1.mVPathRenderer) != null) {
            VectorDrawableCompat$VPathRenderer.access$502(this.mVPathRenderer, new Paint(VectorDrawableCompat$VPathRenderer.access$500(var1.mVPathRenderer)));
         }

         this.mTint = var1.mTint;
         this.mTintMode = var1.mTintMode;
         this.mAutoMirrored = var1.mAutoMirrored;
      }

   }

   public boolean canReuseBitmap(int var1, int var2) {
      return var1 == this.mCachedBitmap.getWidth() && var2 == this.mCachedBitmap.getHeight();
   }

   public boolean canReuseCache() {
      return !this.mCacheDirty && this.mCachedTint == this.mTint && this.mCachedTintMode == this.mTintMode && this.mCachedAutoMirrored == this.mAutoMirrored && this.mCachedRootAlpha == this.mVPathRenderer.getRootAlpha();
   }

   public void createCachedBitmapIfNeeded(int var1, int var2) {
      if(this.mCachedBitmap == null || !this.canReuseBitmap(var1, var2)) {
         this.mCachedBitmap = Bitmap.createBitmap(var1, var2, Config.ARGB_8888);
         this.mCacheDirty = true;
      }

   }

   public void drawCachedBitmapWithRootAlpha(Canvas var1, ColorFilter var2, Rect var3) {
      Paint var4 = this.getPaint(var2);
      var1.drawBitmap(this.mCachedBitmap, (Rect)null, var3, var4);
   }

   public int getChangingConfigurations() {
      return this.mChangingConfigurations;
   }

   public Paint getPaint(ColorFilter var1) {
      if(!this.hasTranslucentRoot() && var1 == null) {
         return null;
      } else {
         if(this.mTempPaint == null) {
            this.mTempPaint = new Paint();
            this.mTempPaint.setFilterBitmap(true);
         }

         this.mTempPaint.setAlpha(this.mVPathRenderer.getRootAlpha());
         this.mTempPaint.setColorFilter(var1);
         return this.mTempPaint;
      }
   }

   public boolean hasTranslucentRoot() {
      return this.mVPathRenderer.getRootAlpha() < 255;
   }

   public Drawable newDrawable() {
      return new VectorDrawableCompat(this, (VectorDrawableCompat$1)null);
   }

   public Drawable newDrawable(Resources var1) {
      return new VectorDrawableCompat(this, (VectorDrawableCompat$1)null);
   }

   public void updateCacheStates() {
      this.mCachedTint = this.mTint;
      this.mCachedTintMode = this.mTintMode;
      this.mCachedRootAlpha = this.mVPathRenderer.getRootAlpha();
      this.mCachedAutoMirrored = this.mAutoMirrored;
      this.mCacheDirty = false;
   }

   public void updateCachedBitmap(int var1, int var2) {
      this.mCachedBitmap.eraseColor(0);
      Canvas var3 = new Canvas(this.mCachedBitmap);
      this.mVPathRenderer.draw(var3, var1, var2, (ColorFilter)null);
   }
}
