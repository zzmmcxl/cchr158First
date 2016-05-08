package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Bundle;

class MediaDescriptionCompatApi21$Builder {
   public static Object build(Object var0) {
      return ((Builder)var0).build();
   }

   public static Object newInstance() {
      return new Builder();
   }

   public static void setDescription(Object var0, CharSequence var1) {
      ((Builder)var0).setDescription(var1);
   }

   public static void setExtras(Object var0, Bundle var1) {
      ((Builder)var0).setExtras(var1);
   }

   public static void setIconBitmap(Object var0, Bitmap var1) {
      ((Builder)var0).setIconBitmap(var1);
   }

   public static void setIconUri(Object var0, Uri var1) {
      ((Builder)var0).setIconUri(var1);
   }

   public static void setMediaId(Object var0, String var1) {
      ((Builder)var0).setMediaId(var1);
   }

   public static void setSubtitle(Object var0, CharSequence var1) {
      ((Builder)var0).setSubtitle(var1);
   }

   public static void setTitle(Object var0, CharSequence var1) {
      ((Builder)var0).setTitle(var1);
   }
}
