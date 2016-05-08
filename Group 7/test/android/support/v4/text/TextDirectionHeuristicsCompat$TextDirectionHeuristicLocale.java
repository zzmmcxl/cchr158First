package android.support.v4.text;

import android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm;
import android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl;
import android.support.v4.text.TextUtilsCompat;
import java.util.Locale;

class TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale extends TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl {
   public static final TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale INSTANCE = new TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale();

   public TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale() {
      super((TextDirectionHeuristicsCompat$TextDirectionAlgorithm)null);
   }

   protected boolean defaultIsRtl() {
      return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
   }
}
