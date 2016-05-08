package android.support.v4.media.session;

import android.media.RemoteControlClient;
import android.media.RemoteControlClient.MetadataEditor;
import android.media.RemoteControlClient.OnMetadataUpdateListener;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompatApi14;
import android.support.v4.media.session.MediaSessionCompatApi18;
import android.support.v4.media.session.MediaSessionCompatApi19$Callback;
import android.support.v4.media.session.MediaSessionCompatApi19$OnMetadataUpdateListener;

class MediaSessionCompatApi19 {
   private static final long ACTION_SET_RATING = 128L;
   private static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
   private static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
   private static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";

   static void addNewMetadata(Bundle var0, MetadataEditor var1) {
      if(var0 != null) {
         if(var0.containsKey("android.media.metadata.YEAR")) {
            var1.putLong(8, var0.getLong("android.media.metadata.YEAR"));
         }

         if(var0.containsKey("android.media.metadata.RATING")) {
            var1.putObject(101, var0.getParcelable("android.media.metadata.RATING"));
         }

         if(var0.containsKey("android.media.metadata.USER_RATING")) {
            var1.putObject(268435457, var0.getParcelable("android.media.metadata.USER_RATING"));
            return;
         }
      }

   }

   public static Object createMetadataUpdateListener(MediaSessionCompatApi19$Callback var0) {
      return new MediaSessionCompatApi19$OnMetadataUpdateListener(var0);
   }

   static int getRccTransportControlFlagsFromActions(long var0) {
      int var3 = MediaSessionCompatApi18.getRccTransportControlFlagsFromActions(var0);
      int var2 = var3;
      if((128L & var0) != 0L) {
         var2 = var3 | 512;
      }

      return var2;
   }

   public static void setMetadata(Object var0, Bundle var1, long var2) {
      MetadataEditor var4 = ((RemoteControlClient)var0).editMetadata(true);
      MediaSessionCompatApi14.buildOldMetadata(var1, var4);
      addNewMetadata(var1, var4);
      if((128L & var2) != 0L) {
         var4.addEditableKey(268435457);
      }

      var4.apply();
   }

   public static void setOnMetadataUpdateListener(Object var0, Object var1) {
      ((RemoteControlClient)var0).setMetadataUpdateListener((OnMetadataUpdateListener)var1);
   }

   public static void setTransportControlFlags(Object var0, long var1) {
      ((RemoteControlClient)var0).setTransportControlFlags(getRccTransportControlFlagsFromActions(var1));
   }
}
