package android.support.graphics.drawable;

import android.graphics.Path;
import android.support.graphics.drawable.PathParser;
import android.util.Log;

public class PathParser$PathDataNode {
   float[] params;
   char type;

   private PathParser$PathDataNode(char var1, float[] var2) {
      this.type = var1;
      this.params = var2;
   }

   private PathParser$PathDataNode(PathParser$PathDataNode var1) {
      this.type = var1.type;
      this.params = PathParser.access$300(var1.params, 0, var1.params.length);
   }

   private static void addCommand(Path var0, float[] var1, char var2, char var3, float[] var4) {
      byte var14 = 2;
      float var5 = var1[0];
      float var6 = var1[1];
      float var8 = var1[2];
      float var10 = var1[3];
      float var7 = var1[4];
      float var9 = var1[5];
      switch(var3) {
      case 'A':
      case 'a':
         var14 = 7;
         break;
      case 'C':
      case 'c':
         var14 = 6;
         break;
      case 'H':
      case 'V':
      case 'h':
      case 'v':
         var14 = 1;
         break;
      case 'L':
      case 'M':
      case 'T':
      case 'l':
      case 'm':
      case 't':
         var14 = 2;
         break;
      case 'Q':
      case 'S':
      case 'q':
      case 's':
         var14 = 4;
         break;
      case 'Z':
      case 'z':
         var0.close();
         var5 = var7;
         var6 = var9;
         var8 = var7;
         var10 = var9;
         var0.moveTo(var7, var9);
      }

      byte var16 = 0;
      char var15 = var2;
      int var19 = var16;
      float var11 = var9;
      var9 = var7;
      float var12 = var10;

      float var13;
      for(var13 = var8; var19 < var4.length; var11 = var10) {
         boolean var17;
         boolean var18;
         switch(var3) {
         case 'A':
            var7 = var4[var19 + 5];
            var8 = var4[var19 + 6];
            var10 = var4[var19 + 0];
            var12 = var4[var19 + 1];
            var13 = var4[var19 + 2];
            if(var4[var19 + 3] != 0.0F) {
               var17 = true;
            } else {
               var17 = false;
            }

            if(var4[var19 + 4] != 0.0F) {
               var18 = true;
            } else {
               var18 = false;
            }

            drawArc(var0, var5, var6, var7, var8, var10, var12, var13, var17, var18);
            var5 = var4[var19 + 5];
            var6 = var4[var19 + 6];
            var7 = var5;
            var8 = var6;
            var10 = var11;
            break;
         case 'C':
            var0.cubicTo(var4[var19 + 0], var4[var19 + 1], var4[var19 + 2], var4[var19 + 3], var4[var19 + 4], var4[var19 + 5]);
            var5 = var4[var19 + 4];
            var6 = var4[var19 + 5];
            var7 = var4[var19 + 2];
            var8 = var4[var19 + 3];
            var10 = var11;
            break;
         case 'H':
            var0.lineTo(var4[var19 + 0], var6);
            var5 = var4[var19 + 0];
            var7 = var13;
            var8 = var12;
            var10 = var11;
            break;
         case 'L':
            var0.lineTo(var4[var19 + 0], var4[var19 + 1]);
            var5 = var4[var19 + 0];
            var6 = var4[var19 + 1];
            var7 = var13;
            var8 = var12;
            var10 = var11;
            break;
         case 'M':
            var5 = var4[var19 + 0];
            var6 = var4[var19 + 1];
            if(var19 > 0) {
               var0.lineTo(var4[var19 + 0], var4[var19 + 1]);
               var7 = var13;
               var8 = var12;
               var10 = var11;
            } else {
               var0.moveTo(var4[var19 + 0], var4[var19 + 1]);
               var9 = var5;
               var10 = var6;
               var7 = var13;
               var8 = var12;
            }
            break;
         case 'Q':
            var0.quadTo(var4[var19 + 0], var4[var19 + 1], var4[var19 + 2], var4[var19 + 3]);
            var7 = var4[var19 + 0];
            var8 = var4[var19 + 1];
            var5 = var4[var19 + 2];
            var6 = var4[var19 + 3];
            var10 = var11;
            break;
         case 'S':
            var8 = var5;
            var7 = var6;
            if(var15 == 99 || var15 == 115 || var15 == 67 || var15 == 83) {
               var8 = 2.0F * var5 - var13;
               var7 = 2.0F * var6 - var12;
            }

            var0.cubicTo(var8, var7, var4[var19 + 0], var4[var19 + 1], var4[var19 + 2], var4[var19 + 3]);
            var7 = var4[var19 + 0];
            var8 = var4[var19 + 1];
            var5 = var4[var19 + 2];
            var6 = var4[var19 + 3];
            var10 = var11;
            break;
         case 'T':
            var8 = var5;
            var7 = var6;
            if(var15 == 113 || var15 == 116 || var15 == 81 || var15 == 84) {
               var8 = 2.0F * var5 - var13;
               var7 = 2.0F * var6 - var12;
            }

            var0.quadTo(var8, var7, var4[var19 + 0], var4[var19 + 1]);
            var5 = var7;
            var12 = var4[var19 + 0];
            var6 = var4[var19 + 1];
            var7 = var8;
            var8 = var5;
            var10 = var11;
            var5 = var12;
            break;
         case 'V':
            var0.lineTo(var5, var4[var19 + 0]);
            var6 = var4[var19 + 0];
            var7 = var13;
            var8 = var12;
            var10 = var11;
            break;
         case 'a':
            var7 = var4[var19 + 5];
            var8 = var4[var19 + 6];
            var10 = var4[var19 + 0];
            var12 = var4[var19 + 1];
            var13 = var4[var19 + 2];
            if(var4[var19 + 3] != 0.0F) {
               var17 = true;
            } else {
               var17 = false;
            }

            if(var4[var19 + 4] != 0.0F) {
               var18 = true;
            } else {
               var18 = false;
            }

            drawArc(var0, var5, var6, var7 + var5, var8 + var6, var10, var12, var13, var17, var18);
            var5 += var4[var19 + 5];
            var6 += var4[var19 + 6];
            var7 = var5;
            var8 = var6;
            var10 = var11;
            break;
         case 'c':
            var0.rCubicTo(var4[var19 + 0], var4[var19 + 1], var4[var19 + 2], var4[var19 + 3], var4[var19 + 4], var4[var19 + 5]);
            var7 = var5 + var4[var19 + 2];
            var8 = var6 + var4[var19 + 3];
            var5 += var4[var19 + 4];
            var6 += var4[var19 + 5];
            var10 = var11;
            break;
         case 'h':
            var0.rLineTo(var4[var19 + 0], 0.0F);
            var5 += var4[var19 + 0];
            var7 = var13;
            var8 = var12;
            var10 = var11;
            break;
         case 'l':
            var0.rLineTo(var4[var19 + 0], var4[var19 + 1]);
            var5 += var4[var19 + 0];
            var6 += var4[var19 + 1];
            var7 = var13;
            var8 = var12;
            var10 = var11;
            break;
         case 'm':
            var5 += var4[var19 + 0];
            var6 += var4[var19 + 1];
            if(var19 > 0) {
               var0.rLineTo(var4[var19 + 0], var4[var19 + 1]);
               var7 = var13;
               var8 = var12;
               var10 = var11;
            } else {
               var0.rMoveTo(var4[var19 + 0], var4[var19 + 1]);
               var9 = var5;
               var10 = var6;
               var7 = var13;
               var8 = var12;
            }
            break;
         case 'q':
            var0.rQuadTo(var4[var19 + 0], var4[var19 + 1], var4[var19 + 2], var4[var19 + 3]);
            var7 = var5 + var4[var19 + 0];
            var8 = var6 + var4[var19 + 1];
            var5 += var4[var19 + 2];
            var6 += var4[var19 + 3];
            var10 = var11;
            break;
         case 's':
            var7 = 0.0F;
            var8 = 0.0F;
            if(var15 == 99 || var15 == 115 || var15 == 67 || var15 == 83) {
               var7 = var5 - var13;
               var8 = var6 - var12;
            }

            var0.rCubicTo(var7, var8, var4[var19 + 0], var4[var19 + 1], var4[var19 + 2], var4[var19 + 3]);
            var7 = var5 + var4[var19 + 0];
            var8 = var6 + var4[var19 + 1];
            var5 += var4[var19 + 2];
            var6 += var4[var19 + 3];
            var10 = var11;
            break;
         case 't':
            var8 = 0.0F;
            var7 = 0.0F;
            if(var15 == 113 || var15 == 116 || var15 == 81 || var15 == 84) {
               var8 = var5 - var13;
               var7 = var6 - var12;
            }

            var0.rQuadTo(var8, var7, var4[var19 + 0], var4[var19 + 1]);
            var8 += var5;
            var10 = var6 + var7;
            var5 += var4[var19 + 0];
            var6 += var4[var19 + 1];
            var7 = var8;
            var8 = var10;
            var10 = var11;
            break;
         case 'v':
            var0.rLineTo(0.0F, var4[var19 + 0]);
            var6 += var4[var19 + 0];
            var7 = var13;
            var8 = var12;
            var10 = var11;
            break;
         default:
            var10 = var11;
            var8 = var12;
            var7 = var13;
         }

         var15 = var3;
         var19 += var14;
         var13 = var7;
         var12 = var8;
      }

      var1[0] = var5;
      var1[1] = var6;
      var1[2] = var13;
      var1[3] = var12;
      var1[4] = var9;
      var1[5] = var11;
   }

   private static void arcToBezier(Path var0, double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15, double var17) {
      int var38 = (int)Math.ceil(Math.abs(4.0D * var17 / 3.141592653589793D));
      double var19 = var15;
      double var29 = Math.cos(var13);
      double var31 = Math.sin(var13);
      var13 = Math.cos(var15);
      var15 = Math.sin(var15);
      double var21 = -var5 * var29 * var15 - var7 * var31 * var13;
      double var23 = -var5 * var31 * var15 + var7 * var29 * var13;
      double var33 = var17 / (double)var38;
      int var37 = 0;
      var15 = var11;
      var13 = var9;
      var17 = var19;
      var11 = var23;

      for(var9 = var21; var37 < var38; ++var37) {
         double var27 = var17 + var33;
         var23 = Math.sin(var27);
         double var35 = Math.cos(var27);
         double var25 = var5 * var29 * var35 + var1 - var7 * var31 * var23;
         var21 = var5 * var31 * var35 + var3 + var7 * var29 * var23;
         var19 = -var5 * var29 * var23 - var7 * var31 * var35;
         var23 = -var5 * var31 * var23 + var7 * var29 * var35;
         var35 = Math.tan((var27 - var17) / 2.0D);
         var17 = Math.sin(var27 - var17) * (Math.sqrt(4.0D + 3.0D * var35 * var35) - 1.0D) / 3.0D;
         var0.cubicTo((float)(var13 + var17 * var9), (float)(var15 + var17 * var11), (float)(var25 - var17 * var19), (float)(var21 - var17 * var23), (float)var25, (float)var21);
         var17 = var27;
         var13 = var25;
         var15 = var21;
         var9 = var19;
         var11 = var23;
      }

   }

   private static void drawArc(Path var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, boolean var8, boolean var9) {
      double var18 = Math.toRadians((double)var7);
      double var20 = Math.cos(var18);
      double var22 = Math.sin(var18);
      double var24 = ((double)var1 * var20 + (double)var2 * var22) / (double)var5;
      double var26 = ((double)(-var1) * var22 + (double)var2 * var20) / (double)var6;
      double var10 = ((double)var3 * var20 + (double)var4 * var22) / (double)var5;
      double var16 = ((double)(-var3) * var22 + (double)var4 * var20) / (double)var6;
      double var30 = var24 - var10;
      double var28 = var26 - var16;
      double var14 = (var24 + var10) / 2.0D;
      double var12 = (var26 + var16) / 2.0D;
      double var32 = var30 * var30 + var28 * var28;
      if(var32 == 0.0D) {
         Log.w("PathParser", " Points are coincident");
      } else {
         double var34 = 1.0D / var32 - 0.25D;
         if(var34 < 0.0D) {
            Log.w("PathParser", "Points are too far apart " + var32);
            float var36 = (float)(Math.sqrt(var32) / 1.99999D);
            drawArc(var0, var1, var2, var3, var4, var5 * var36, var6 * var36, var7, var8, var9);
         } else {
            var32 = Math.sqrt(var34);
            var30 = var32 * var30;
            var28 = var32 * var28;
            if(var8 == var9) {
               var14 -= var28;
               var12 += var30;
            } else {
               var14 += var28;
               var12 -= var30;
            }

            var24 = Math.atan2(var26 - var12, var24 - var14);
            var16 = Math.atan2(var16 - var12, var10 - var14) - var24;
            if(var16 >= 0.0D) {
               var8 = true;
            } else {
               var8 = false;
            }

            var10 = var16;
            if(var9 != var8) {
               if(var16 > 0.0D) {
                  var10 = var16 - 6.283185307179586D;
               } else {
                  var10 = var16 + 6.283185307179586D;
               }
            }

            var14 *= (double)var5;
            var12 *= (double)var6;
            arcToBezier(var0, var14 * var20 - var12 * var22, var14 * var22 + var12 * var20, (double)var5, (double)var6, (double)var1, (double)var2, var18, var24, var10);
         }
      }
   }

   public static void nodesToPath(PathParser$PathDataNode[] var0, Path var1) {
      float[] var4 = new float[6];
      char var2 = 109;

      for(int var3 = 0; var3 < var0.length; ++var3) {
         addCommand(var1, var4, var2, var0[var3].type, var0[var3].params);
         var2 = var0[var3].type;
      }

   }

   public void interpolatePathDataNode(PathParser$PathDataNode var1, PathParser$PathDataNode var2, float var3) {
      for(int var4 = 0; var4 < var1.params.length; ++var4) {
         this.params[var4] = var1.params[var4] * (1.0F - var3) + var2.params[var4] * var3;
      }

   }
}
