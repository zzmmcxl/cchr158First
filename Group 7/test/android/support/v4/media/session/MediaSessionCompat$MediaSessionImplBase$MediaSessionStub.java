package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession$Stub;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$Command;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.KeyEvent;
import java.util.List;

class MediaSessionCompat$MediaSessionImplBase$MediaSessionStub extends IMediaSession$Stub {
   MediaSessionCompat$MediaSessionImplBase$MediaSessionStub(MediaSessionCompat$MediaSessionImplBase var1) {
      this.this$0 = var1;
   }

   public void adjustVolume(int var1, int var2, String var3) {
      MediaSessionCompat$MediaSessionImplBase.access$1700(this.this$0, var1, var2);
   }

   public void fastForward() throws RemoteException {
      MediaSessionCompat$MediaSessionImplBase.access$1900(this.this$0, 9);
   }

   public Bundle getExtras() {
      // $FF: Couldn't be decompiled
   }

   public long getFlags() {
      // $FF: Couldn't be decompiled
   }

   public PendingIntent getLaunchPendingIntent() {
      // $FF: Couldn't be decompiled
   }

   public MediaMetadataCompat getMetadata() {
      return MediaSessionCompat$MediaSessionImplBase.access$2100(this.this$0);
   }

   public String getPackageName() {
      return MediaSessionCompat$MediaSessionImplBase.access$1200(this.this$0);
   }

   public PlaybackStateCompat getPlaybackState() {
      return MediaSessionCompat$MediaSessionImplBase.access$2200(this.this$0);
   }

   public List<MediaSessionCompat$QueueItem> getQueue() {
      // $FF: Couldn't be decompiled
   }

   public CharSequence getQueueTitle() {
      return MediaSessionCompat$MediaSessionImplBase.access$2400(this.this$0);
   }

   public int getRatingType() {
      return MediaSessionCompat$MediaSessionImplBase.access$2600(this.this$0);
   }

   public String getTag() {
      return MediaSessionCompat$MediaSessionImplBase.access$1300(this.this$0);
   }

   public ParcelableVolumeInfo getVolumeAttributes() {
      // $FF: Couldn't be decompiled
   }

   public boolean isTransportControlEnabled() {
      return (MediaSessionCompat$MediaSessionImplBase.access$900(this.this$0) & 2) != 0;
   }

   public void next() throws RemoteException {
      MediaSessionCompat$MediaSessionImplBase.access$1900(this.this$0, 7);
   }

   public void pause() throws RemoteException {
      MediaSessionCompat$MediaSessionImplBase.access$1900(this.this$0, 5);
   }

   public void play() throws RemoteException {
      MediaSessionCompat$MediaSessionImplBase.access$1900(this.this$0, 1);
   }

   public void playFromMediaId(String var1, Bundle var2) throws RemoteException {
      MediaSessionCompat$MediaSessionImplBase.access$2000(this.this$0, 2, var1, var2);
   }

   public void playFromSearch(String var1, Bundle var2) throws RemoteException {
      MediaSessionCompat$MediaSessionImplBase.access$2000(this.this$0, 3, var1, var2);
   }

   public void playFromUri(Uri var1, Bundle var2) throws RemoteException {
      MediaSessionCompat$MediaSessionImplBase.access$2000(this.this$0, 18, var1, var2);
   }

   public void previous() throws RemoteException {
      MediaSessionCompat$MediaSessionImplBase.access$1900(this.this$0, 8);
   }

   public void rate(RatingCompat var1) throws RemoteException {
      MediaSessionCompat$MediaSessionImplBase.access$700(this.this$0, 12, var1);
   }

   public void registerCallbackListener(IMediaControllerCallback var1) {
      if(MediaSessionCompat$MediaSessionImplBase.access$1000(this.this$0)) {
         try {
            var1.onSessionDestroyed();
         } catch (Exception var2) {
            ;
         }
      } else {
         MediaSessionCompat$MediaSessionImplBase.access$1100(this.this$0).register(var1);
      }
   }

   public void rewind() throws RemoteException {
      MediaSessionCompat$MediaSessionImplBase.access$1900(this.this$0, 10);
   }

   public void seekTo(long var1) throws RemoteException {
      MediaSessionCompat$MediaSessionImplBase.access$700(this.this$0, 11, Long.valueOf(var1));
   }

   public void sendCommand(String var1, Bundle var2, MediaSessionCompat$ResultReceiverWrapper var3) {
      MediaSessionCompat$MediaSessionImplBase.access$700(this.this$0, 15, new MediaSessionCompat$MediaSessionImplBase$Command(var1, var2, MediaSessionCompat$ResultReceiverWrapper.access$800(var3)));
   }

   public void sendCustomAction(String var1, Bundle var2) throws RemoteException {
      MediaSessionCompat$MediaSessionImplBase.access$2000(this.this$0, 13, var1, var2);
   }

   public boolean sendMediaButton(KeyEvent var1) {
      boolean var2;
      if((MediaSessionCompat$MediaSessionImplBase.access$900(this.this$0) & 1) != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      if(var2) {
         MediaSessionCompat$MediaSessionImplBase.access$700(this.this$0, 14, var1);
      }

      return var2;
   }

   public void setVolumeTo(int var1, int var2, String var3) {
      MediaSessionCompat$MediaSessionImplBase.access$1800(this.this$0, var1, var2);
   }

   public void skipToQueueItem(long var1) {
      MediaSessionCompat$MediaSessionImplBase.access$700(this.this$0, 4, Long.valueOf(var1));
   }

   public void stop() throws RemoteException {
      MediaSessionCompat$MediaSessionImplBase.access$1900(this.this$0, 6);
   }

   public void unregisterCallbackListener(IMediaControllerCallback var1) {
      MediaSessionCompat$MediaSessionImplBase.access$1100(this.this$0).unregister(var1);
   }
}
