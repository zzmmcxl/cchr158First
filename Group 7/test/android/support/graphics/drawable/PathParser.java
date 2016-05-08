package android.support.graphics.drawable;

import android.graphics.Path;
import android.support.graphics.drawable.PathParser$1;
import android.support.graphics.drawable.PathParser$ExtractFloatResult;
import android.support.graphics.drawable.PathParser$PathDataNode;
import java.util.ArrayList;

class PathParser {
   private static final String LOGTAG = "PathParser";

   private static void addNode(ArrayList<PathParser$PathDataNode> var0, char var1, float[] var2) {
      var0.add(new PathParser$PathDataNode(var1, var2, (PathParser$1)null));
   }

   public static boolean canMorph(PathParser$PathDataNode[] var0, PathParser$PathDataNode[] var1) {
      if(var0 != null && var1 != null && var0.length == var1.length) {
         int var2 = 0;

         while(true) {
            if(var2 >= var0.length) {
               return true;
            }

            if(var0[var2].type != var1[var2].type || var0[var2].params.length != var1[var2].params.length) {
               break;
            }

            ++var2;
         }
      }

      return false;
   }

   private static float[] copyOfRange(float[] var0, int var1, int var2) {
      if(var1 > var2) {
         throw new IllegalArgumentException();
      } else {
         int var3 = var0.length;
         if(var1 >= 0 && var1 <= var3) {
            var2 -= var1;
            var3 = Math.min(var2, var3 - var1);
            float[] var4 = new float[var2];
            System.arraycopy(var0, var1, var4, 0, var3);
            return var4;
         } else {
            throw new ArrayIndexOutOfBoundsException();
         }
      }
   }

   public static PathParser$PathDataNode[] createNodesFromPathData(String var0) {
      if(var0 == null) {
         return null;
      } else {
         int var1 = 0;
         int var2 = 1;

         ArrayList var3;
         for(var3 = new ArrayList(); var2 < var0.length(); var1 = var2++) {
            var2 = nextStart(var0, var2);
            String var4 = var0.substring(var1, var2).trim();
            if(var4.length() > 0) {
               float[] var5 = getFloats(var4);
               addNode(var3, var4.charAt(0), var5);
            }
         }

         if(var2 - var1 == 1 && var1 < var0.length()) {
            addNode(var3, var0.charAt(var1), new float[0]);
         }

         return (PathParser$PathDataNode[])var3.toArray(new PathParser$PathDataNode[var3.size()]);
      }
   }

   public static Path createPathFromPathData(String var0) {
      Path var1 = new Path();
      PathParser$PathDataNode[] var2 = createNodesFromPathData(var0);
      if(var2 != null) {
         try {
            PathParser$PathDataNode.nodesToPath(var2, var1);
            return var1;
         } catch (RuntimeException var3) {
            throw new RuntimeException("Error in parsing " + var0, var3);
         }
      } else {
         return null;
      }
   }

   public static PathParser$PathDataNode[] deepCopyNodes(PathParser$PathDataNode[] var0) {
      PathParser$PathDataNode[] var2;
      if(var0 == null) {
         var2 = null;
      } else {
         PathParser$PathDataNode[] var3 = new PathParser$PathDataNode[var0.length];
         int var1 = 0;

         while(true) {
            var2 = var3;
            if(var1 >= var0.length) {
               break;
            }

            var3[var1] = new PathParser$PathDataNode(var0[var1], (PathParser$1)null);
            ++var1;
         }
      }

      return var2;
   }

   private static void extract(String var0, int var1, PathParser$ExtractFloatResult var2) {
      int var6 = var1;
      boolean var7 = false;
      var2.mEndWithNegOrDot = false;
      boolean var5 = false;

      boolean var9;
      for(boolean var8 = false; var6 < var0.length(); var5 = var9) {
         boolean var10 = false;
         boolean var3;
         boolean var4;
         switch(var0.charAt(var6)) {
         case ' ':
         case ',':
            var3 = true;
            var4 = var10;
            var9 = var5;
            break;
         case '-':
            var3 = var7;
            var4 = var10;
            var9 = var5;
            if(var6 != var1) {
               var3 = var7;
               var4 = var10;
               var9 = var5;
               if(!var8) {
                  var3 = true;
                  var2.mEndWithNegOrDot = true;
                  var4 = var10;
                  var9 = var5;
               }
            }
            break;
         case '.':
            if(!var5) {
               var9 = true;
               var3 = var7;
               var4 = var10;
            } else {
               var3 = true;
               var2.mEndWithNegOrDot = true;
               var4 = var10;
               var9 = var5;
            }
            break;
         case 'E':
         case 'e':
            var4 = true;
            var3 = var7;
            var9 = var5;
            break;
         default:
            var9 = var5;
            var4 = var10;
            var3 = var7;
         }

         if(var3) {
            break;
         }

         ++var6;
         var7 = var3;
         var8 = var4;
      }

      var2.mEndPosition = var6;
   }

   private static float[] getFloats(String param0) {
      // $FF: Couldn't be decompiled
   }

   private static int nextStart(String var0, int var1) {
      while(var1 < var0.length()) {
         char var2 = var0.charAt(var1);
         if(((var2 - 65) * (var2 - 90) <= 0 || (var2 - 97) * (var2 - 122) <= 0) && var2 != 101 && var2 != 69) {
            break;
         }

         ++var1;
      }

      return var1;
   }

   public static void updateNodes(PathParser$PathDataNode[] var0, PathParser$PathDataNode[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         var0[var2].type = var1[var2].type;

         for(int var3 = 0; var3 < var1[var2].params.length; ++var3) {
            var0[var2].params[var3] = var1[var2].params[var3];
         }
      }

   }
}
