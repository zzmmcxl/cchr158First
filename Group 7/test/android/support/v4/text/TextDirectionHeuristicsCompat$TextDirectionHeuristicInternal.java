package android.support.v4.text;

import android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm;
import android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl;

class TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal extends TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl {
   private final boolean mDefaultIsRtl;

   private TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat$TextDirectionAlgorithm var1, boolean var2) {
      super(var1);
      this.mDefaultIsRtl = var2;
   }

   protected boolean defaultIsRtl() {
      return this.mDefaultIsRtl;
   }
}
