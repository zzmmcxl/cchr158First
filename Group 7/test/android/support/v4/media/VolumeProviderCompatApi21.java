package android.support.v4.media;

import android.media.VolumeProvider;
import android.support.v4.media.VolumeProviderCompatApi21$1;
import android.support.v4.media.VolumeProviderCompatApi21$Delegate;

class VolumeProviderCompatApi21 {
   public static Object createVolumeProvider(int var0, int var1, int var2, VolumeProviderCompatApi21$Delegate var3) {
      return new VolumeProviderCompatApi21$1(var0, var1, var2, var3);
   }

   public static void setCurrentVolume(Object var0, int var1) {
      ((VolumeProvider)var0).setCurrentVolume(var1);
   }
}
