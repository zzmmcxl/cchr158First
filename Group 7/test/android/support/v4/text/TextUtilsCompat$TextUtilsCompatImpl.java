package android.support.v4.text;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.text.ICUCompat;
import android.support.v4.text.TextUtilsCompat;
import java.util.Locale;

class TextUtilsCompat$TextUtilsCompatImpl {
   private TextUtilsCompat$TextUtilsCompatImpl() {
   }

   private static int getLayoutDirectionFromFirstChar(@NonNull Locale var0) {
      switch(Character.getDirectionality(var0.getDisplayName(var0).charAt(0))) {
      case 1:
      case 2:
         return 1;
      default:
         return 0;
      }
   }

   public int getLayoutDirectionFromLocale(@Nullable Locale var1) {
      if(var1 != null && !var1.equals(TextUtilsCompat.ROOT)) {
         String var2 = ICUCompat.maximizeAndGetScript(var1);
         if(var2 == null) {
            return getLayoutDirectionFromFirstChar(var1);
         }

         if(var2.equalsIgnoreCase(TextUtilsCompat.access$000()) || var2.equalsIgnoreCase(TextUtilsCompat.access$100())) {
            return 1;
         }
      }

      return 0;
   }

   @NonNull
   public String htmlEncode(@NonNull String var1) {
      StringBuilder var4 = new StringBuilder();

      for(int var3 = 0; var3 < var1.length(); ++var3) {
         char var2 = var1.charAt(var3);
         switch(var2) {
         case '\"':
            var4.append("&quot;");
            break;
         case '&':
            var4.append("&amp;");
            break;
         case '\'':
            var4.append("&#39;");
            break;
         case '<':
            var4.append("&lt;");
            break;
         case '>':
            var4.append("&gt;");
            break;
         default:
            var4.append(var2);
         }
      }

      return var4.toString();
   }
}
