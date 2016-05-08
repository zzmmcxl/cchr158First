package android.support.v4.text;

import android.support.v4.text.BidiFormatter$Builder;
import android.support.v4.text.BidiFormatter$DirectionalityEstimator;
import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.text.TextUtilsCompat;
import java.util.Locale;

public final class BidiFormatter {
   private static final int DEFAULT_FLAGS = 2;
   private static final BidiFormatter DEFAULT_LTR_INSTANCE;
   private static final BidiFormatter DEFAULT_RTL_INSTANCE;
   private static TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC;
   private static final int DIR_LTR = -1;
   private static final int DIR_RTL = 1;
   private static final int DIR_UNKNOWN = 0;
   private static final String EMPTY_STRING = "";
   private static final int FLAG_STEREO_RESET = 2;
   private static final char LRE = '\u202a';
   private static final char LRM = '\u200e';
   private static final String LRM_STRING;
   private static final char PDF = '\u202c';
   private static final char RLE = '\u202b';
   private static final char RLM = '\u200f';
   private static final String RLM_STRING;
   private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
   private final int mFlags;
   private final boolean mIsRtlContext;

   static {
      DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
      LRM_STRING = Character.toString('\u200e');
      RLM_STRING = Character.toString('\u200f');
      DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
      DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
   }

   private BidiFormatter(boolean var1, int var2, TextDirectionHeuristicCompat var3) {
      this.mIsRtlContext = var1;
      this.mFlags = var2;
      this.mDefaultTextDirectionHeuristicCompat = var3;
   }

   private static int getEntryDir(String var0) {
      return (new BidiFormatter$DirectionalityEstimator(var0, false)).getEntryDir();
   }

   private static int getExitDir(String var0) {
      return (new BidiFormatter$DirectionalityEstimator(var0, false)).getExitDir();
   }

   public static BidiFormatter getInstance() {
      return (new BidiFormatter$Builder()).build();
   }

   public static BidiFormatter getInstance(Locale var0) {
      return (new BidiFormatter$Builder(var0)).build();
   }

   public static BidiFormatter getInstance(boolean var0) {
      return (new BidiFormatter$Builder(var0)).build();
   }

   private static boolean isRtlLocale(Locale var0) {
      return TextUtilsCompat.getLayoutDirectionFromLocale(var0) == 1;
   }

   private String markAfter(String var1, TextDirectionHeuristicCompat var2) {
      boolean var3 = var2.isRtl((CharSequence)var1, 0, var1.length());
      return this.mIsRtlContext || !var3 && getExitDir(var1) != 1?(!this.mIsRtlContext || var3 && getExitDir(var1) != -1?"":RLM_STRING):LRM_STRING;
   }

   private String markBefore(String var1, TextDirectionHeuristicCompat var2) {
      boolean var3 = var2.isRtl((CharSequence)var1, 0, var1.length());
      return this.mIsRtlContext || !var3 && getEntryDir(var1) != 1?(!this.mIsRtlContext || var3 && getEntryDir(var1) != -1?"":RLM_STRING):LRM_STRING;
   }

   public boolean getStereoReset() {
      return (this.mFlags & 2) != 0;
   }

   public boolean isRtl(String var1) {
      return this.mDefaultTextDirectionHeuristicCompat.isRtl((CharSequence)var1, 0, var1.length());
   }

   public boolean isRtlContext() {
      return this.mIsRtlContext;
   }

   public String unicodeWrap(String var1) {
      return this.unicodeWrap(var1, this.mDefaultTextDirectionHeuristicCompat, true);
   }

   public String unicodeWrap(String var1, TextDirectionHeuristicCompat var2) {
      return this.unicodeWrap(var1, var2, true);
   }

   public String unicodeWrap(String var1, TextDirectionHeuristicCompat var2, boolean var3) {
      if(var1 == null) {
         return null;
      } else {
         boolean var5 = var2.isRtl((CharSequence)var1, 0, var1.length());
         StringBuilder var6 = new StringBuilder();
         if(this.getStereoReset() && var3) {
            if(var5) {
               var2 = TextDirectionHeuristicsCompat.RTL;
            } else {
               var2 = TextDirectionHeuristicsCompat.LTR;
            }

            var6.append(this.markBefore(var1, var2));
         }

         if(var5 != this.mIsRtlContext) {
            char var4;
            if(var5) {
               var4 = 8235;
            } else {
               var4 = 8234;
            }

            var6.append(var4);
            var6.append(var1);
            var6.append('\u202c');
         } else {
            var6.append(var1);
         }

         if(var3) {
            if(var5) {
               var2 = TextDirectionHeuristicsCompat.RTL;
            } else {
               var2 = TextDirectionHeuristicsCompat.LTR;
            }

            var6.append(this.markAfter(var1, var2));
         }

         return var6.toString();
      }
   }

   public String unicodeWrap(String var1, boolean var2) {
      return this.unicodeWrap(var1, this.mDefaultTextDirectionHeuristicCompat, var2);
   }
}
