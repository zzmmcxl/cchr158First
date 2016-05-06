package android.support.v4.media;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import android.os.Build$VERSION;

public abstract class VolumeProviderCompat
{
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;
    private Callback mCallback;
    private final int mControlType;
    private int mCurrentVolume;
    private final int mMaxVolume;
    private Object mVolumeProviderObj;
    
    public VolumeProviderCompat(final int mControlType, final int mMaxVolume, final int mCurrentVolume) {
        super();
        mControlType = mControlType;
        mMaxVolume = mMaxVolume;
        mCurrentVolume = mCurrentVolume;
    }
    
    public final int getCurrentVolume() {
        return mCurrentVolume;
    }
    
    public final int getMaxVolume() {
        return mMaxVolume;
    }
    
    public final int getVolumeControl() {
        return mControlType;
    }
    
    public Object getVolumeProvider() {
        if (mVolumeProviderObj != null || Build$VERSION.SDK_INT < 21) {
            return mVolumeProviderObj;
        }
        return mVolumeProviderObj = VolumeProviderCompatApi21.createVolumeProvider(mControlType, mMaxVolume, mCurrentVolume, (VolumeProviderCompatApi21.Delegate)new VolumeProviderCompatApi21.Delegate() {
            final /* synthetic */ VolumeProviderCompat this$0;
            
            VolumeProviderCompat$1() {
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
        });
    }
    
    public void onAdjustVolume(final int n) {
    }
    
    public void onSetVolumeTo(final int n) {
    }
    
    public void setCallback(final Callback mCallback) {
        this.mCallback = mCallback;
    }
    
    public final void setCurrentVolume(final int mCurrentVolume) {
        this.mCurrentVolume = mCurrentVolume;
        final Object volumeProvider = this.getVolumeProvider();
        if (volumeProvider != null) {
            VolumeProviderCompatApi21.setCurrentVolume(volumeProvider, mCurrentVolume);
        }
        if (mCallback != null) {
            mCallback.onVolumeChanged(this);
        }
    }
}
