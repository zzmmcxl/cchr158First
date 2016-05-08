package android.support.v4.text;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.text.TextUtilsCompat$1;
import android.support.v4.text.TextUtilsCompat$TextUtilsCompatImpl;
import android.support.v4.text.TextUtilsCompat$TextUtilsCompatJellybeanMr1Impl;
import java.util.Locale;

public final class TextUtilsCompat {
   private static String ARAB_SCRIPT_SUBTAG;
   private static String HEBR_SCRIPT_SUBTAG;
   private static final TextUtilsCompat$TextUtilsCompatImpl IMPL;
   public static final Locale ROOT;

   static {
      if(VERSION.SDK_INT >= 17) {
         IMPL = new TextUtilsCompat$TextUtilsCompatJellybeanMr1Impl((TextUtilsCompat$1)null);
      } else {
         IMPL = new TextUtilsCompat$TextUtilsCompatImpl((TextUtilsCompat$1)null);
      }

      ROOT = new Locale("", "");
      ARAB_SCRIPT_SUBTAG = "Arab";
      HEBR_SCRIPT_SUBTAG = "Hebr";
   }

   public static int getLayoutDirectionFromLocale(@Nullable Locale var0) {
      return IMPL.getLayoutDirectionFromLocale(var0);
   }

   @NonNull
   public static String htmlEncode(@NonNull String var0) {
      return IMPL.htmlEncode(var0);
   }
}
