package android.support.v4.text;

import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm;

class TextDirectionHeuristicsCompat$FirstStrong implements TextDirectionHeuristicsCompat$TextDirectionAlgorithm {
   public static final TextDirectionHeuristicsCompat$FirstStrong INSTANCE = new TextDirectionHeuristicsCompat$FirstStrong();

   public int checkRtl(CharSequence var1, int var2, int var3) {
      int var5 = 2;

      for(int var4 = var2; var4 < var2 + var3 && var5 == 2; ++var4) {
         var5 = TextDirectionHeuristicsCompat.access$100(Character.getDirectionality(var1.charAt(var4)));
      }

      return var5;
   }
}
