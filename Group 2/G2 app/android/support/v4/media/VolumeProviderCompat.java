package android.support.v4.media;

import android.os.Build.VERSION;
import android.support.v4.media.VolumeProviderCompatApi21;

public abstract class VolumeProviderCompat {
   public static final int VOLUME_CONTROL_ABSOLUTE = 2;
   public static final int VOLUME_CONTROL_FIXED = 0;
   public static final int VOLUME_CONTROL_RELATIVE = 1;
   private VolumeProviderCompat.Callback mCallback;
   private final int mControlType;
   private int mCurrentVolume;
   private final int mMaxVolume;
   private Object mVolumeProviderObj;

   public VolumeProviderCompat(int var1, int var2, int var3) {
      this.mControlType = var1;
      this.mMaxVolume = var2;
      this.mCurrentVolume = var3;
   }

   public final int getCurrentVolume() {
      return this.mCurrentVolume;
   }

   public final int getMaxVolume() {
      return this.mMaxVolume;
   }

   public final int getVolumeControl() {
      return this.mControlType;
   }

   public Object getVolumeProvider() {
      if(this.mVolumeProviderObj == null && VERSION.SDK_INT >= 21) {
         this.mVolumeProviderObj = VolumeProviderCompatApi21.createVolumeProvider(this.mControlType, this.mMaxVolume, this.mCurrentVolume, new VolumeProviderCompatApi21.Delegate() {
            public void onAdjustVolume(int var1) {
               VolumeProviderCompat.this.onAdjustVolume(var1);
            }

            public void onSetVolumeTo(int var1) {
               VolumeProviderCompat.this.onSetVolumeTo(var1);
            }
         });
         return this.mVolumeProviderObj;
      } else {
         return this.mVolumeProviderObj;
      }
   }

   public void onAdjustVolume(int var1) {
   }

   public void onSetVolumeTo(int var1) {
   }

   public void setCallback(VolumeProviderCompat.Callback var1) {
      this.mCallback = var1;
   }

   public final void setCurrentVolume(int var1) {
      if(this.mCallback != null) {
         this.mCallback.onVolumeChanged(this);
      }

   }

   public abstract static class Callback {
      public abstract void onVolumeChanged(VolumeProviderCompat var1);
   }
}
