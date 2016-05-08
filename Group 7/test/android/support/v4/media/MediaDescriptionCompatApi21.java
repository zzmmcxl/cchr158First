package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

class MediaDescriptionCompatApi21 {
   public static Object fromParcel(Parcel var0) {
      return MediaDescription.CREATOR.createFromParcel(var0);
   }

   public static CharSequence getDescription(Object var0) {
      return ((MediaDescription)var0).getDescription();
   }

   public static Bundle getExtras(Object var0) {
      return ((MediaDescription)var0).getExtras();
   }

   public static Bitmap getIconBitmap(Object var0) {
      return ((MediaDescription)var0).getIconBitmap();
   }

   public static Uri getIconUri(Object var0) {
      return ((MediaDescription)var0).getIconUri();
   }

   public static String getMediaId(Object var0) {
      return ((MediaDescription)var0).getMediaId();
   }

   public static CharSequence getSubtitle(Object var0) {
      return ((MediaDescription)var0).getSubtitle();
   }

   public static CharSequence getTitle(Object var0) {
      return ((MediaDescription)var0).getTitle();
   }

   public static void writeToParcel(Object var0, Parcel var1, int var2) {
      ((MediaDescription)var0).writeToParcel(var1, var2);
   }
}
