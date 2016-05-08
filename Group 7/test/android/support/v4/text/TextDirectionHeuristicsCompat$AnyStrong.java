package android.support.v4.text;

import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm;

class TextDirectionHeuristicsCompat$AnyStrong implements TextDirectionHeuristicsCompat$TextDirectionAlgorithm {
   public static final TextDirectionHeuristicsCompat$AnyStrong INSTANCE_LTR = new TextDirectionHeuristicsCompat$AnyStrong(false);
   public static final TextDirectionHeuristicsCompat$AnyStrong INSTANCE_RTL = new TextDirectionHeuristicsCompat$AnyStrong(true);
   private final boolean mLookForRtl;

   private TextDirectionHeuristicsCompat$AnyStrong(boolean var1) {
      this.mLookForRtl = var1;
   }

   public int checkRtl(CharSequence var1, int var2, int var3) {
      byte var6 = 1;
      boolean var4 = false;

      byte var7;
      for(int var5 = var2; var5 < var2 + var3; ++var5) {
         switch(TextDirectionHeuristicsCompat.access$200(Character.getDirectionality(var1.charAt(var5)))) {
         case 0:
            if(this.mLookForRtl) {
               var7 = 0;
               return var7;
            }

            var4 = true;
            break;
         case 1:
            var7 = var6;
            if(!this.mLookForRtl) {
               return var7;
            }

            var4 = true;
         }
      }

      if(!var4) {
         return 2;
      } else {
         var7 = var6;
         if(!this.mLookForRtl) {
            return 0;
         } else {
            return var7;
         }
      }
   }
}
