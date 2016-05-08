package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.Rating;
import android.media.MediaMetadata.Builder;

public class MediaMetadataCompatApi21$Builder {
   public static Object build(Object var0) {
      return ((Builder)var0).build();
   }

   public static Object newInstance() {
      return new Builder();
   }

   public static void putBitmap(Object var0, String var1, Bitmap var2) {
      ((Builder)var0).putBitmap(var1, var2);
   }

   public static void putLong(Object var0, String var1, long var2) {
      ((Builder)var0).putLong(var1, var2);
   }

   public static void putRating(Object var0, String var1, Object var2) {
      ((Builder)var0).putRating(var1, (Rating)var2);
   }

   public static void putString(Object var0, String var1, String var2) {
      ((Builder)var0).putString(var1, var2);
   }

   public static void putText(Object var0, String var1, CharSequence var2) {
      ((Builder)var0).putText(var1, var2);
   }
}
