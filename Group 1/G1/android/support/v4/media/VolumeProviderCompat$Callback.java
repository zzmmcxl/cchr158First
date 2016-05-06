package android.support.v4.media;

public abstract static class Callback
{
    public Callback() {
        super();
    }
    
    public abstract void onVolumeChanged(final VolumeProviderCompat p0);
}
