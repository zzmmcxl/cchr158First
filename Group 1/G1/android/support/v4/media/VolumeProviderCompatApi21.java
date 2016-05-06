package android.support.v4.media;

import android.media.VolumeProvider;

class VolumeProviderCompatApi21
{
    VolumeProviderCompatApi21() {
        super();
    }
    
    public static Object createVolumeProvider(final int n, final int n2, final int n3, final Delegate delegate) {
        return new VolumeProvider(n, n2, n3) {
            final /* synthetic */ Delegate val$delegate;
            
            VolumeProviderCompatApi21$1(final int n, final int n2, final int n3) {
                super(n, n2, n3);
            }
            
            public void onAdjustVolume(final int n) {
                delegate.onAdjustVolume(n);
            }
            
            public void onSetVolumeTo(final int n) {
                delegate.onSetVolumeTo(n);
            }
        };
    }
    
    public static void setCurrentVolume(final Object o, final int currentVolume) {
        ((VolumeProvider)o).setCurrentVolume(currentVolume);
    }
}
