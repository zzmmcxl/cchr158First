package android.support.v4.text;

import android.os.Build.VERSION;
import android.support.v4.text.ICUCompat$ICUCompatImpl;
import android.support.v4.text.ICUCompat$ICUCompatImplBase;
import android.support.v4.text.ICUCompat$ICUCompatImplIcs;
import android.support.v4.text.ICUCompat$ICUCompatImplLollipop;
import java.util.Locale;

public final class ICUCompat {
   private static final ICUCompat$ICUCompatImpl IMPL;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 21) {
         IMPL = new ICUCompat$ICUCompatImplLollipop();
      } else if(var0 >= 14) {
         IMPL = new ICUCompat$ICUCompatImplIcs();
      } else {
         IMPL = new ICUCompat$ICUCompatImplBase();
      }
   }

   public static String maximizeAndGetScript(Locale var0) {
      return IMPL.maximizeAndGetScript(var0);
   }
}
