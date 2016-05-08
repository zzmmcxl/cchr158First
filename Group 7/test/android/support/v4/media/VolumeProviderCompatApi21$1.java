package android.support.v4.media;

import android.media.VolumeProvider;
import android.support.v4.media.VolumeProviderCompatApi21$Delegate;

final class VolumeProviderCompatApi21$1 extends VolumeProvider {
   VolumeProviderCompatApi21$1(int var1, int var2, int var3, VolumeProviderCompatApi21$Delegate var4) {
      super(var1, var2, var3);
      this.val$delegate = var4;
   }

   public void onAdjustVolume(int var1) {
      this.val$delegate.onAdjustVolume(var1);
   }

   public void onSetVolumeTo(int var1) {
      this.val$delegate.onSetVolumeTo(var1);
   }
}
