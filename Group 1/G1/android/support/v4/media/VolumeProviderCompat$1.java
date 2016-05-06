package android.support.v4.media;

class VolumeProviderCompat$1 implements Delegate {
    final /* synthetic */ VolumeProviderCompat this$0;
    
    VolumeProviderCompat$1(final VolumeProviderCompat this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void onAdjustVolume(final int n) {
        this$0.onAdjustVolume(n);
    }
    
    @Override
    public void onSetVolumeTo(final int n) {
        this$0.onSetVolumeTo(n);
    }
}