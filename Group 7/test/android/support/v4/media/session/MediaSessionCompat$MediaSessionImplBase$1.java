package android.support.v4.media.session;

import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.VolumeProviderCompat$Callback;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase;
import android.support.v4.media.session.ParcelableVolumeInfo;

class MediaSessionCompat$MediaSessionImplBase$1 extends VolumeProviderCompat$Callback {
   MediaSessionCompat$MediaSessionImplBase$1(MediaSessionCompat$MediaSessionImplBase var1) {
      this.this$0 = var1;
   }

   public void onVolumeChanged(VolumeProviderCompat var1) {
      if(MediaSessionCompat$MediaSessionImplBase.access$300(this.this$0) == var1) {
         ParcelableVolumeInfo var2 = new ParcelableVolumeInfo(MediaSessionCompat$MediaSessionImplBase.access$400(this.this$0), MediaSessionCompat$MediaSessionImplBase.access$500(this.this$0), var1.getVolumeControl(), var1.getMaxVolume(), var1.getCurrentVolume());
         MediaSessionCompat$MediaSessionImplBase.access$600(this.this$0, var2);
      }
   }
}
