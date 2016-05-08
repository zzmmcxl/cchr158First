package android.support.v4.text;

import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm;
import java.nio.CharBuffer;

abstract class TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
   private final TextDirectionHeuristicsCompat$TextDirectionAlgorithm mAlgorithm;

   public TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl(TextDirectionHeuristicsCompat$TextDirectionAlgorithm var1) {
      this.mAlgorithm = var1;
   }

   private boolean doCheck(CharSequence var1, int var2, int var3) {
      switch(this.mAlgorithm.checkRtl(var1, var2, var3)) {
      case 0:
         return true;
      case 1:
         return false;
      default:
         return this.defaultIsRtl();
      }
   }

   protected abstract boolean defaultIsRtl();

   public boolean isRtl(CharSequence var1, int var2, int var3) {
      if(var1 != null && var2 >= 0 && var3 >= 0 && var1.length() - var3 >= var2) {
         return this.mAlgorithm == null?this.defaultIsRtl():this.doCheck(var1, var2, var3);
      } else {
         throw new IllegalArgumentException();
      }
   }

   public boolean isRtl(char[] var1, int var2, int var3) {
      return this.isRtl((CharSequence)CharBuffer.wrap(var1), var2, var3);
   }
}
