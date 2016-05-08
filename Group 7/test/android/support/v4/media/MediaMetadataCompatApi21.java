package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.os.Parcel;
import java.util.Set;

class MediaMetadataCompatApi21 {
   public static Object createFromParcel(Parcel var0) {
      return MediaMetadata.CREATOR.createFromParcel(var0);
   }

   public static Bitmap getBitmap(Object var0, String var1) {
      return ((MediaMetadata)var0).getBitmap(var1);
   }

   public static long getLong(Object var0, String var1) {
      return ((MediaMetadata)var0).getLong(var1);
   }

   public static Object getRating(Object var0, String var1) {
      return ((MediaMetadata)var0).getRating(var1);
   }

   public static CharSequence getText(Object var0, String var1) {
      return ((MediaMetadata)var0).getText(var1);
   }

   public static Set<String> keySet(Object var0) {
      return ((MediaMetadata)var0).keySet();
   }

   public static void writeToParcel(Object var0, Parcel var1, int var2) {
      ((MediaMetadata)var0).writeToParcel(var1, var2);
   }
}
