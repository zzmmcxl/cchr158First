package android.support.v4.media.session;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback$Stub;
import android.support.v4.media.session.MediaControllerCompat$Callback;
import android.support.v4.media.session.MediaControllerCompat$PlaybackInfo;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import java.util.List;

class MediaControllerCompat$Callback$StubCompat extends IMediaControllerCallback$Stub {
   private MediaControllerCompat$Callback$StubCompat(MediaControllerCompat$Callback var1) {
      this.this$0 = var1;
   }

   public void onEvent(String var1, Bundle var2) throws RemoteException {
      MediaControllerCompat$Callback.access$200(this.this$0).post(1, var1, var2);
   }

   public void onExtrasChanged(Bundle var1) throws RemoteException {
      MediaControllerCompat$Callback.access$200(this.this$0).post(7, var1, (Bundle)null);
   }

   public void onMetadataChanged(MediaMetadataCompat var1) throws RemoteException {
      MediaControllerCompat$Callback.access$200(this.this$0).post(3, var1, (Bundle)null);
   }

   public void onPlaybackStateChanged(PlaybackStateCompat var1) throws RemoteException {
      MediaControllerCompat$Callback.access$200(this.this$0).post(2, var1, (Bundle)null);
   }

   public void onQueueChanged(List<MediaSessionCompat$QueueItem> var1) throws RemoteException {
      MediaControllerCompat$Callback.access$200(this.this$0).post(5, var1, (Bundle)null);
   }

   public void onQueueTitleChanged(CharSequence var1) throws RemoteException {
      MediaControllerCompat$Callback.access$200(this.this$0).post(6, var1, (Bundle)null);
   }

   public void onSessionDestroyed() throws RemoteException {
      MediaControllerCompat$Callback.access$200(this.this$0).post(8, (Object)null, (Bundle)null);
   }

   public void onVolumeInfoChanged(ParcelableVolumeInfo var1) throws RemoteException {
      MediaControllerCompat$PlaybackInfo var2 = null;
      if(var1 != null) {
         var2 = new MediaControllerCompat$PlaybackInfo(var1.volumeType, var1.audioStream, var1.controlType, var1.maxVolume, var1.currentVolume);
      }

      MediaControllerCompat$Callback.access$200(this.this$0).post(4, var2, (Bundle)null);
   }
}
