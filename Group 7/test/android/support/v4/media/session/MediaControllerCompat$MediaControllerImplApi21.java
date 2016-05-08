package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat$Callback;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl;
import android.support.v4.media.session.MediaControllerCompat$PlaybackInfo;
import android.support.v4.media.session.MediaControllerCompat$TransportControls;
import android.support.v4.media.session.MediaControllerCompat$TransportControlsApi21;
import android.support.v4.media.session.MediaControllerCompatApi21;
import android.support.v4.media.session.MediaControllerCompatApi21$PlaybackInfo;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MediaControllerCompat$MediaControllerImplApi21 implements MediaControllerCompat$MediaControllerImpl {
   protected final Object mControllerObj;

   public MediaControllerCompat$MediaControllerImplApi21(Context var1, MediaSessionCompat$Token var2) throws RemoteException {
      this.mControllerObj = MediaControllerCompatApi21.fromToken(var1, var2.getToken());
      if(this.mControllerObj == null) {
         throw new RemoteException();
      }
   }

   public MediaControllerCompat$MediaControllerImplApi21(Context var1, MediaSessionCompat var2) {
      this.mControllerObj = MediaControllerCompatApi21.fromToken(var1, var2.getSessionToken().getToken());
   }

   public void adjustVolume(int var1, int var2) {
      MediaControllerCompatApi21.adjustVolume(this.mControllerObj, var1, var2);
   }

   public boolean dispatchMediaButtonEvent(KeyEvent var1) {
      return MediaControllerCompatApi21.dispatchMediaButtonEvent(this.mControllerObj, var1);
   }

   public Bundle getExtras() {
      return MediaControllerCompatApi21.getExtras(this.mControllerObj);
   }

   public long getFlags() {
      return MediaControllerCompatApi21.getFlags(this.mControllerObj);
   }

   public Object getMediaController() {
      return this.mControllerObj;
   }

   public MediaMetadataCompat getMetadata() {
      Object var1 = MediaControllerCompatApi21.getMetadata(this.mControllerObj);
      return var1 != null?MediaMetadataCompat.fromMediaMetadata(var1):null;
   }

   public String getPackageName() {
      return MediaControllerCompatApi21.getPackageName(this.mControllerObj);
   }

   public MediaControllerCompat$PlaybackInfo getPlaybackInfo() {
      Object var1 = MediaControllerCompatApi21.getPlaybackInfo(this.mControllerObj);
      return var1 != null?new MediaControllerCompat$PlaybackInfo(MediaControllerCompatApi21$PlaybackInfo.getPlaybackType(var1), MediaControllerCompatApi21$PlaybackInfo.getLegacyAudioStream(var1), MediaControllerCompatApi21$PlaybackInfo.getVolumeControl(var1), MediaControllerCompatApi21$PlaybackInfo.getMaxVolume(var1), MediaControllerCompatApi21$PlaybackInfo.getCurrentVolume(var1)):null;
   }

   public PlaybackStateCompat getPlaybackState() {
      Object var1 = MediaControllerCompatApi21.getPlaybackState(this.mControllerObj);
      return var1 != null?PlaybackStateCompat.fromPlaybackState(var1):null;
   }

   public List<MediaSessionCompat$QueueItem> getQueue() {
      List var1 = MediaControllerCompatApi21.getQueue(this.mControllerObj);
      ArrayList var4;
      if(var1 == null) {
         var4 = null;
      } else {
         ArrayList var2 = new ArrayList();
         Iterator var3 = var1.iterator();

         while(true) {
            var4 = var2;
            if(!var3.hasNext()) {
               break;
            }

            var2.add(MediaSessionCompat$QueueItem.obtain(var3.next()));
         }
      }

      return var4;
   }

   public CharSequence getQueueTitle() {
      return MediaControllerCompatApi21.getQueueTitle(this.mControllerObj);
   }

   public int getRatingType() {
      return MediaControllerCompatApi21.getRatingType(this.mControllerObj);
   }

   public PendingIntent getSessionActivity() {
      return MediaControllerCompatApi21.getSessionActivity(this.mControllerObj);
   }

   public MediaControllerCompat$TransportControls getTransportControls() {
      Object var1 = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
      return var1 != null?new MediaControllerCompat$TransportControlsApi21(var1):null;
   }

   public void registerCallback(MediaControllerCompat$Callback var1, Handler var2) {
      MediaControllerCompatApi21.registerCallback(this.mControllerObj, MediaControllerCompat$Callback.access$400(var1), var2);
   }

   public void sendCommand(String var1, Bundle var2, ResultReceiver var3) {
      MediaControllerCompatApi21.sendCommand(this.mControllerObj, var1, var2, var3);
   }

   public void setVolumeTo(int var1, int var2) {
      MediaControllerCompatApi21.setVolumeTo(this.mControllerObj, var1, var2);
   }

   public void unregisterCallback(MediaControllerCompat$Callback var1) {
      MediaControllerCompatApi21.unregisterCallback(this.mControllerObj, MediaControllerCompat$Callback.access$400(var1));
   }
}
