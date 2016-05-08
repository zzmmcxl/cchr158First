package android.support.v4.media;

import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.VolumeProviderCompatApi21$Delegate;

class VolumeProviderCompat$1 implements VolumeProviderCompatApi21$Delegate {
   VolumeProviderCompat$1(VolumeProviderCompat var1) {
      this.this$0 = var1;
   }

   public void onAdjustVolume(int var1) {
      this.this$0.onAdjustVolume(var1);
   }

   public void onSetVolumeTo(int var1) {
      this.this$0.onSetVolumeTo(var1);
   }
}
