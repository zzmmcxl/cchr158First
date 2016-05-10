package android.support.v4.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

class PathInterpolatorDonut implements Interpolator {
   private static final float PRECISION = 0.002F;
   private final float[] mX;
   private final float[] mY;

   public PathInterpolatorDonut(float var1, float var2) {
      this(createQuad(var1, var2));
   }

   public PathInterpolatorDonut(float var1, float var2, float var3, float var4) {
      this(createCubic(var1, var2, var3, var4));
   }

   public PathInterpolatorDonut(Path var1) {
      PathMeasure var6 = new PathMeasure(var1, false);
      float var2 = var6.getLength();
      int var4 = (int)(var2 / 0.002F) + 1;
      this.mX = new float[var4];
      this.mY = new float[var4];
      float[] var5 = new float[2];

      for(int var3 = 0; var3 < var4; ++var3) {
         var6.getPosTan((float)var3 * var2 / (float)(var4 - 1), var5, (float[])null);
         this.mX[var3] = var5[0];
         this.mY[var3] = var5[1];
      }

   }

   private static Path createCubic(float var0, float var1, float var2, float var3) {
      Path var4 = new Path();
      var4.moveTo(0.0F, 0.0F);
      var4.cubicTo(var0, var1, var2, var3, 1.0F, 1.0F);
      return var4;
   }

   private static Path createQuad(float var0, float var1) {
      Path var2 = new Path();
      var2.moveTo(0.0F, 0.0F);
      var2.quadTo(var0, var1, 1.0F, 1.0F);
      return var2;
   }

   public float getInterpolation(float var1) {
      if(var1 <= 0.0F) {
         return 0.0F;
      } else if(var1 >= 1.0F) {
         return 1.0F;
      } else {
         int var3 = 0;
         int var4 = this.mX.length - 1;

         while(var4 - var3 > 1) {
            int var5 = (var3 + var4) / 2;
            if(var1 < this.mX[var5]) {
               var4 = var5;
            } else {
               var3 = var5;
            }
         }

         float var2 = this.mX[var4] - this.mX[var3];
         if(var2 == 0.0F) {
            return this.mY[var3];
         } else {
            var1 = (var1 - this.mX[var3]) / var2;
            var2 = this.mY[var3];
            return (this.mY[var4] - var2) * var1 + var2;
         }
      }
   }
}
