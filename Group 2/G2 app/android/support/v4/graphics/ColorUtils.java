package android.support.v4.graphics;

import android.graphics.Color;

public class ColorUtils {
   private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
   private static final int MIN_ALPHA_SEARCH_PRECISION = 10;

   public static int HSLToColor(float[] var0) {
      float var1 = var0[0];
      float var2 = var0[1];
      float var3 = var0[2];
      var2 = (1.0F - Math.abs(2.0F * var3 - 1.0F)) * var2;
      var3 -= 0.5F * var2;
      float var4 = var2 * (1.0F - Math.abs(var1 / 60.0F % 2.0F - 1.0F));
      int var8 = (int)var1 / 60;
      int var7 = 0;
      int var6 = 0;
      int var5 = 0;
      switch(var8) {
      case 0:
         var7 = Math.round(255.0F * (var2 + var3));
         var6 = Math.round(255.0F * (var4 + var3));
         var5 = Math.round(255.0F * var3);
         break;
      case 1:
         var7 = Math.round(255.0F * (var4 + var3));
         var6 = Math.round(255.0F * (var2 + var3));
         var5 = Math.round(255.0F * var3);
         break;
      case 2:
         var7 = Math.round(255.0F * var3);
         var6 = Math.round(255.0F * (var2 + var3));
         var5 = Math.round(255.0F * (var4 + var3));
         break;
      case 3:
         var7 = Math.round(255.0F * var3);
         var6 = Math.round(255.0F * (var4 + var3));
         var5 = Math.round(255.0F * (var2 + var3));
         break;
      case 4:
         var7 = Math.round(255.0F * (var4 + var3));
         var6 = Math.round(255.0F * var3);
         var5 = Math.round(255.0F * (var2 + var3));
         break;
      case 5:
      case 6:
         var7 = Math.round(255.0F * (var2 + var3));
         var6 = Math.round(255.0F * var3);
         var5 = Math.round(255.0F * (var4 + var3));
      }

      return Color.rgb(constrain(var7, 0, 255), constrain(var6, 0, 255), constrain(var5, 0, 255));
   }

   public static void RGBToHSL(int var0, int var1, int var2, float[] var3) {
      float var4 = (float)var0 / 255.0F;
      float var6 = (float)var1 / 255.0F;
      float var8 = (float)var2 / 255.0F;
      float var9 = Math.max(var4, Math.max(var6, var8));
      float var10 = Math.min(var4, Math.min(var6, var8));
      float var5 = var9 - var10;
      float var7 = (var9 + var10) / 2.0F;
      if(var9 == var10) {
         var4 = 0.0F;
         var5 = 0.0F;
      } else {
         if(var9 == var4) {
            var4 = (var6 - var8) / var5 % 6.0F;
         } else if(var9 == var6) {
            var4 = (var8 - var4) / var5 + 2.0F;
         } else {
            var4 = (var4 - var6) / var5 + 4.0F;
         }

         var6 = var5 / (1.0F - Math.abs(2.0F * var7 - 1.0F));
         var5 = var4;
         var4 = var6;
      }

      var6 = 60.0F * var5 % 360.0F;
      var5 = var6;
      if(var6 < 0.0F) {
         var5 = var6 + 360.0F;
      }

      var3[0] = constrain(var5, 0.0F, 360.0F);
      var3[1] = constrain(var4, 0.0F, 1.0F);
      var3[2] = constrain(var7, 0.0F, 1.0F);
   }

   public static double calculateContrast(int var0, int var1) {
      if(Color.alpha(var1) != 255) {
         throw new IllegalArgumentException("background can not be translucent");
      } else {
         int var6 = var0;
         if(Color.alpha(var0) < 255) {
            var6 = compositeColors(var0, var1);
         }

         double var2 = calculateLuminance(var6) + 0.05D;
         double var4 = calculateLuminance(var1) + 0.05D;
         return Math.max(var2, var4) / Math.min(var2, var4);
      }
   }

   public static double calculateLuminance(int var0) {
      double var1 = (double)Color.red(var0) / 255.0D;
      if(var1 < 0.03928D) {
         var1 /= 12.92D;
      } else {
         var1 = Math.pow((0.055D + var1) / 1.055D, 2.4D);
      }

      double var3 = (double)Color.green(var0) / 255.0D;
      if(var3 < 0.03928D) {
         var3 /= 12.92D;
      } else {
         var3 = Math.pow((0.055D + var3) / 1.055D, 2.4D);
      }

      double var5 = (double)Color.blue(var0) / 255.0D;
      if(var5 < 0.03928D) {
         var5 /= 12.92D;
      } else {
         var5 = Math.pow((0.055D + var5) / 1.055D, 2.4D);
      }

      return 0.2126D * var1 + 0.7152D * var3 + 0.0722D * var5;
   }

   public static int calculateMinimumAlpha(int var0, int var1, float var2) {
      if(Color.alpha(var1) != 255) {
         throw new IllegalArgumentException("background can not be translucent");
      } else {
         int var6;
         if(calculateContrast(setAlphaComponent(var0, 255), var1) < (double)var2) {
            var6 = -1;
         } else {
            int var4 = 0;
            int var5 = 0;
            int var3 = 255;

            while(true) {
               var6 = var3;
               if(var4 > 10) {
                  break;
               }

               var6 = var3;
               if(var3 - var5 <= 10) {
                  break;
               }

               var6 = (var5 + var3) / 2;
               if(calculateContrast(setAlphaComponent(var0, var6), var1) < (double)var2) {
                  var5 = var6;
               } else {
                  var3 = var6;
               }

               ++var4;
            }
         }

         return var6;
      }
   }

   public static void colorToHSL(int var0, float[] var1) {
      RGBToHSL(Color.red(var0), Color.green(var0), Color.blue(var0), var1);
   }

   private static int compositeAlpha(int var0, int var1) {
      return 255 - (255 - var1) * (255 - var0) / 255;
   }

   public static int compositeColors(int var0, int var1) {
      int var2 = Color.alpha(var1);
      int var3 = Color.alpha(var0);
      int var4 = compositeAlpha(var3, var2);
      return Color.argb(var4, compositeComponent(Color.red(var0), var3, Color.red(var1), var2, var4), compositeComponent(Color.green(var0), var3, Color.green(var1), var2, var4), compositeComponent(Color.blue(var0), var3, Color.blue(var1), var2, var4));
   }

   private static int compositeComponent(int var0, int var1, int var2, int var3, int var4) {
      return var4 == 0?0:(var0 * 255 * var1 + var2 * var3 * (255 - var1)) / (var4 * 255);
   }

   private static float constrain(float var0, float var1, float var2) {
      return var0 < var1?var1:(var0 > var2?var2:var0);
   }

   private static int constrain(int var0, int var1, int var2) {
      return var0 < var1?var1:(var0 > var2?var2:var0);
   }

   public static int setAlphaComponent(int var0, int var1) {
      if(var1 >= 0 && var1 <= 255) {
         return 16777215 & var0 | var1 << 24;
      } else {
         throw new IllegalArgumentException("alpha must be between 0 and 255.");
      }
   }
}
