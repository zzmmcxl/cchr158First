package android.support.v4.media.session;

import android.media.AudioAttributes;
import android.media.session.MediaController.PlaybackInfo;

public class MediaControllerCompatApi21$PlaybackInfo {
   private static final int FLAG_SCO = 4;
   private static final int STREAM_BLUETOOTH_SCO = 6;
   private static final int STREAM_SYSTEM_ENFORCED = 7;

   public static AudioAttributes getAudioAttributes(Object var0) {
      return ((PlaybackInfo)var0).getAudioAttributes();
   }

   public static int getCurrentVolume(Object var0) {
      return ((PlaybackInfo)var0).getCurrentVolume();
   }

   public static int getLegacyAudioStream(Object var0) {
      return toLegacyStreamType(getAudioAttributes(var0));
   }

   public static int getMaxVolume(Object var0) {
      return ((PlaybackInfo)var0).getMaxVolume();
   }

   public static int getPlaybackType(Object var0) {
      return ((PlaybackInfo)var0).getPlaybackType();
   }

   public static int getVolumeControl(Object var0) {
      return ((PlaybackInfo)var0).getVolumeControl();
   }

   private static int toLegacyStreamType(AudioAttributes var0) {
      byte var1 = 3;
      if((var0.getFlags() & 1) == 1) {
         var1 = 7;
      } else {
         if((var0.getFlags() & 4) == 4) {
            return 6;
         }

         switch(var0.getUsage()) {
         case 1:
         case 11:
         case 12:
         case 14:
            break;
         case 2:
            return 0;
         case 3:
            return 8;
         case 4:
            return 4;
         case 5:
         case 7:
         case 8:
         case 9:
         case 10:
            return 5;
         case 6:
            return 2;
         case 13:
            return 1;
         default:
            return 3;
         }
      }

      return var1;
   }
}
