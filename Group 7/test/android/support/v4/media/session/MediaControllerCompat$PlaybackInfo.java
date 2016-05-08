package android.support.v4.media.session;

public final class MediaControllerCompat$PlaybackInfo {
   public static final int PLAYBACK_TYPE_LOCAL = 1;
   public static final int PLAYBACK_TYPE_REMOTE = 2;
   private final int mAudioStream;
   private final int mCurrentVolume;
   private final int mMaxVolume;
   private final int mPlaybackType;
   private final int mVolumeControl;

   MediaControllerCompat$PlaybackInfo(int var1, int var2, int var3, int var4, int var5) {
      this.mPlaybackType = var1;
      this.mAudioStream = var2;
      this.mVolumeControl = var3;
      this.mMaxVolume = var4;
      this.mCurrentVolume = var5;
   }

   public int getAudioStream() {
      return this.mAudioStream;
   }

   public int getCurrentVolume() {
      return this.mCurrentVolume;
   }

   public int getMaxVolume() {
      return this.mMaxVolume;
   }

   public int getPlaybackType() {
      return this.mPlaybackType;
   }

   public int getVolumeControl() {
      return this.mVolumeControl;
   }
}
