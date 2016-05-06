package android.support.v4.media;

import android.media.VolumeProvider;

static final class VolumeProviderCompatApi21$1 extends VolumeProvider {
    final /* synthetic */ Delegate val$delegate;
    
    VolumeProviderCompatApi21$1(final int n, final int n2, final int n3, final Delegate val$delegate) {
        this.val$delegate = val$delegate;
        super(n, n2, n3);
    }
    
    public void onAdjustVolume(final int n) {
        val$delegate.onAdjustVolume(n);
    }
    
    public void onSetVolumeTo(final int n) {
        val$delegate.onSetVolumeTo(n);
    }
}