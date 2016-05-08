package android.support.v4.text;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.text.TextUtilsCompat$1;
import android.support.v4.text.TextUtilsCompat$TextUtilsCompatImpl;
import android.support.v4.text.TextUtilsCompatJellybeanMr1;
import java.util.Locale;

class TextUtilsCompat$TextUtilsCompatJellybeanMr1Impl extends TextUtilsCompat$TextUtilsCompatImpl {
   private TextUtilsCompat$TextUtilsCompatJellybeanMr1Impl() {
      super((TextUtilsCompat$1)null);
   }

   public int getLayoutDirectionFromLocale(@Nullable Locale var1) {
      return TextUtilsCompatJellybeanMr1.getLayoutDirectionFromLocale(var1);
   }

   @NonNull
   public String htmlEncode(@NonNull String var1) {
      return TextUtilsCompatJellybeanMr1.htmlEncode(var1);
   }
}
