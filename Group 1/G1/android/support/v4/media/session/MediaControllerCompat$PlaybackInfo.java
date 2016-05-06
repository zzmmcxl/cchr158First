package android.support.v4.media.session;

public static final class PlaybackInfo
{
    public static final int PLAYBACK_TYPE_LOCAL = 1;
    public static final int PLAYBACK_TYPE_REMOTE = 2;
    private final int mAudioStream;
    private final int mCurrentVolume;
    private final int mMaxVolume;
    private final int mPlaybackType;
    private final int mVolumeControl;
    
    PlaybackInfo(final int mPlaybackType, final int mAudioStream, final int mVolumeControl, final int mMaxVolume, final int mCurrentVolume) {
        super();
        this.mPlaybackType = mPlaybackType;
        this.mAudioStream = mAudioStream;
        this.mVolumeControl = mVolumeControl;
        this.mMaxVolume = mMaxVolume;
        this.mCurrentVolume = mCurrentVolume;
    }
    
    public int getAudioStream() {
        return mAudioStream;
    }
    
    public int getCurrentVolume() {
        return mCurrentVolume;
    }
    
    public int getMaxVolume() {
        return mMaxVolume;
    }
    
    public int getPlaybackType() {
        return mPlaybackType;
    }
    
    public int getVolumeControl() {
        return mVolumeControl;
    }
}
