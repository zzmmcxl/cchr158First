package android.support.v4.text;

import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v4.text.TextDirectionHeuristicsCompat$1;
import android.support.v4.text.TextDirectionHeuristicsCompat$AnyStrong;
import android.support.v4.text.TextDirectionHeuristicsCompat$FirstStrong;
import android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm;
import android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal;
import android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale;

public final class TextDirectionHeuristicsCompat {
   public static final TextDirectionHeuristicCompat ANYRTL_LTR;
   public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR;
   public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL;
   public static final TextDirectionHeuristicCompat LOCALE;
   public static final TextDirectionHeuristicCompat LTR = new TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal((TextDirectionHeuristicsCompat$TextDirectionAlgorithm)null, false, (TextDirectionHeuristicsCompat$1)null);
   public static final TextDirectionHeuristicCompat RTL = new TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal((TextDirectionHeuristicsCompat$TextDirectionAlgorithm)null, true, (TextDirectionHeuristicsCompat$1)null);
   private static final int STATE_FALSE = 1;
   private static final int STATE_TRUE = 0;
   private static final int STATE_UNKNOWN = 2;

   static {
      FIRSTSTRONG_LTR = new TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat$FirstStrong.INSTANCE, false, (TextDirectionHeuristicsCompat$1)null);
      FIRSTSTRONG_RTL = new TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat$FirstStrong.INSTANCE, true, (TextDirectionHeuristicsCompat$1)null);
      ANYRTL_LTR = new TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat$AnyStrong.INSTANCE_RTL, false, (TextDirectionHeuristicsCompat$1)null);
      LOCALE = TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale.INSTANCE;
   }

   private static int isRtlText(int var0) {
      switch(var0) {
      case 0:
         return 1;
      case 1:
      case 2:
         return 0;
      default:
         return 2;
      }
   }

   private static int isRtlTextOrFormat(int var0) {
      switch(var0) {
      case 0:
      case 14:
      case 15:
         return 1;
      case 1:
      case 2:
      case 16:
      case 17:
         return 0;
      default:
         return 2;
      }
   }
}
