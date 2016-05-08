package android.support.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Paint.Style;
import android.graphics.Region.Op;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.graphics.drawable.VectorDrawableCompat$VFullPath;
import android.support.graphics.drawable.VectorDrawableCompat$VGroup;
import android.support.graphics.drawable.VectorDrawableCompat$VPath;
import android.support.v4.util.ArrayMap;

class VectorDrawableCompat$VPathRenderer {
   private static final Matrix IDENTITY_MATRIX = new Matrix();
   float mBaseHeight = 0.0F;
   float mBaseWidth = 0.0F;
   private int mChangingConfigurations;
   private Paint mFillPaint;
   private final Matrix mFinalPathMatrix = new Matrix();
   private final Path mPath;
   private PathMeasure mPathMeasure;
   private final Path mRenderPath;
   int mRootAlpha = 255;
   private final VectorDrawableCompat$VGroup mRootGroup;
   String mRootName = null;
   private Paint mStrokePaint;
   final ArrayMap<String, Object> mVGTargetsMap = new ArrayMap();
   float mViewportHeight = 0.0F;
   float mViewportWidth = 0.0F;

   public VectorDrawableCompat$VPathRenderer() {
      this.mRootGroup = new VectorDrawableCompat$VGroup();
      this.mPath = new Path();
      this.mRenderPath = new Path();
   }

   public VectorDrawableCompat$VPathRenderer(VectorDrawableCompat$VPathRenderer var1) {
      this.mRootGroup = new VectorDrawableCompat$VGroup(var1.mRootGroup, this.mVGTargetsMap);
      this.mPath = new Path(var1.mPath);
      this.mRenderPath = new Path(var1.mRenderPath);
      this.mBaseWidth = var1.mBaseWidth;
      this.mBaseHeight = var1.mBaseHeight;
      this.mViewportWidth = var1.mViewportWidth;
      this.mViewportHeight = var1.mViewportHeight;
      this.mChangingConfigurations = var1.mChangingConfigurations;
      this.mRootAlpha = var1.mRootAlpha;
      this.mRootName = var1.mRootName;
      if(var1.mRootName != null) {
         this.mVGTargetsMap.put(var1.mRootName, this);
      }

   }

   private static float cross(float var0, float var1, float var2, float var3) {
      return var0 * var3 - var1 * var2;
   }

   private void drawGroupTree(VectorDrawableCompat$VGroup var1, Matrix var2, Canvas var3, int var4, int var5, ColorFilter var6) {
      VectorDrawableCompat$VGroup.access$700(var1).set(var2);
      VectorDrawableCompat$VGroup.access$700(var1).preConcat(VectorDrawableCompat$VGroup.access$800(var1));

      for(int var7 = 0; var7 < var1.mChildren.size(); ++var7) {
         Object var8 = var1.mChildren.get(var7);
         if(var8 instanceof VectorDrawableCompat$VGroup) {
            this.drawGroupTree((VectorDrawableCompat$VGroup)var8, VectorDrawableCompat$VGroup.access$700(var1), var3, var4, var5, var6);
         } else if(var8 instanceof VectorDrawableCompat$VPath) {
            this.drawPath(var1, (VectorDrawableCompat$VPath)var8, var3, var4, var5, var6);
         }
      }

   }

   private void drawPath(VectorDrawableCompat$VGroup var1, VectorDrawableCompat$VPath var2, Canvas var3, int var4, int var5, ColorFilter var6) {
      float var8 = (float)var4 / this.mViewportWidth;
      float var9 = (float)var5 / this.mViewportHeight;
      float var7 = Math.min(var8, var9);
      Matrix var15 = VectorDrawableCompat$VGroup.access$700(var1);
      this.mFinalPathMatrix.set(var15);
      this.mFinalPathMatrix.postScale(var8, var9);
      var8 = this.getMatrixScale(var15);
      if(var8 != 0.0F) {
         var2.toPath(this.mPath);
         Path var14 = this.mPath;
         this.mRenderPath.reset();
         if(var2.isClipPath()) {
            this.mRenderPath.addPath(var14, this.mFinalPathMatrix);
            var3.clipPath(this.mRenderPath, Op.REPLACE);
            return;
         }

         VectorDrawableCompat$VFullPath var16 = (VectorDrawableCompat$VFullPath)var2;
         if(var16.mTrimPathStart != 0.0F || var16.mTrimPathEnd != 1.0F) {
            float var12 = var16.mTrimPathStart;
            float var13 = var16.mTrimPathOffset;
            float var10 = var16.mTrimPathEnd;
            float var11 = var16.mTrimPathOffset;
            if(this.mPathMeasure == null) {
               this.mPathMeasure = new PathMeasure();
            }

            this.mPathMeasure.setPath(this.mPath, false);
            var9 = this.mPathMeasure.getLength();
            var12 = (var12 + var13) % 1.0F * var9;
            var10 = (var10 + var11) % 1.0F * var9;
            var14.reset();
            if(var12 > var10) {
               this.mPathMeasure.getSegment(var12, var9, var14, true);
               this.mPathMeasure.getSegment(0.0F, var10, var14, true);
            } else {
               this.mPathMeasure.getSegment(var12, var10, var14, true);
            }

            var14.rLineTo(0.0F, 0.0F);
         }

         this.mRenderPath.addPath(var14, this.mFinalPathMatrix);
         Paint var17;
         if(var16.mFillColor != 0) {
            if(this.mFillPaint == null) {
               this.mFillPaint = new Paint();
               this.mFillPaint.setStyle(Style.FILL);
               this.mFillPaint.setAntiAlias(true);
            }

            var17 = this.mFillPaint;
            var17.setColor(VectorDrawableCompat.access$900(var16.mFillColor, var16.mFillAlpha));
            var17.setColorFilter(var6);
            var3.drawPath(this.mRenderPath, var17);
         }

         if(var16.mStrokeColor != 0) {
            if(this.mStrokePaint == null) {
               this.mStrokePaint = new Paint();
               this.mStrokePaint.setStyle(Style.STROKE);
               this.mStrokePaint.setAntiAlias(true);
            }

            var17 = this.mStrokePaint;
            if(var16.mStrokeLineJoin != null) {
               var17.setStrokeJoin(var16.mStrokeLineJoin);
            }

            if(var16.mStrokeLineCap != null) {
               var17.setStrokeCap(var16.mStrokeLineCap);
            }

            var17.setStrokeMiter(var16.mStrokeMiterlimit);
            var17.setColor(VectorDrawableCompat.access$900(var16.mStrokeColor, var16.mStrokeAlpha));
            var17.setColorFilter(var6);
            var17.setStrokeWidth(var16.mStrokeWidth * var7 * var8);
            var3.drawPath(this.mRenderPath, var17);
            return;
         }
      }

   }

   private float getMatrixScale(Matrix var1) {
      float[] var5 = new float[]{0.0F, 1.0F, 1.0F, 0.0F};
      var1.mapVectors(var5);
      float var2 = (float)Math.hypot((double)var5[0], (double)var5[1]);
      float var4 = (float)Math.hypot((double)var5[2], (double)var5[3]);
      float var3 = cross(var5[0], var5[1], var5[2], var5[3]);
      var4 = Math.max(var2, var4);
      var2 = 0.0F;
      if(var4 > 0.0F) {
         var2 = Math.abs(var3) / var4;
      }

      return var2;
   }

   public void draw(Canvas var1, int var2, int var3, ColorFilter var4) {
      this.drawGroupTree(this.mRootGroup, IDENTITY_MATRIX, var1, var2, var3, var4);
   }

   public float getAlpha() {
      return (float)this.getRootAlpha() / 255.0F;
   }

   public int getRootAlpha() {
      return this.mRootAlpha;
   }

   public void setAlpha(float var1) {
      this.setRootAlpha((int)(255.0F * var1));
   }

   public void setRootAlpha(int var1) {
      this.mRootAlpha = var1;
   }
}
