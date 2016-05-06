package android.support.v4.media.session;

import android.support.v4.media.VolumeProviderCompat;

class MediaSessionCompat$MediaSessionImplBase$1 extends VolumeProviderCompat.Callback {
    final /* synthetic */ MediaSessionImplBase this$0;
    
    MediaSessionCompat$MediaSessionImplBase$1(final MediaSessionImplBase this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void onVolumeChanged(final VolumeProviderCompat volumeProviderCompat) {
        if (MediaSessionImplBase.access$300(this$0) != volumeProviderCompat) {
            return;
        }
        MediaSessionImplBase.access$600(this$0, new ParcelableVolumeInfo(MediaSessionImplBase.access$400(this$0), MediaSessionImplBase.access$500(this$0), volumeProviderCompat.getVolumeControl(), volumeProviderCompat.getMaxVolume(), volumeProviderCompat.getCurrentVolume()));
    }
}