package android.support.v4.media.session;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.IMediaSession$Stub;
import android.support.v4.media.session.MediaControllerCompat$Callback;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl;
import android.support.v4.media.session.MediaControllerCompat$PlaybackInfo;
import android.support.v4.media.session.MediaControllerCompat$TransportControls;
import android.support.v4.media.session.MediaControllerCompat$TransportControlsBase;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import java.util.List;

class MediaControllerCompat$MediaControllerImplBase implements MediaControllerCompat$MediaControllerImpl {
   private IMediaSession mBinder;
   private MediaSessionCompat$Token mToken;
   private MediaControllerCompat$TransportControls mTransportControls;

   public MediaControllerCompat$MediaControllerImplBase(MediaSessionCompat$Token var1) {
      this.mToken = var1;
      this.mBinder = IMediaSession$Stub.asInterface((IBinder)var1.getToken());
   }

   public void adjustVolume(int var1, int var2) {
      try {
         this.mBinder.adjustVolume(var1, var2, (String)null);
      } catch (RemoteException var4) {
         Log.e("MediaControllerCompat", "Dead object in adjustVolume. " + var4);
      }
   }

   public boolean dispatchMediaButtonEvent(KeyEvent var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("event may not be null.");
      } else {
         try {
            this.mBinder.sendMediaButton(var1);
         } catch (RemoteException var2) {
            Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent. " + var2);
         }

         return false;
      }
   }

   public Bundle getExtras() {
      try {
         Bundle var1 = this.mBinder.getExtras();
         return var1;
      } catch (RemoteException var2) {
         Log.e("MediaControllerCompat", "Dead object in getExtras. " + var2);
         return null;
      }
   }

   public long getFlags() {
      try {
         long var1 = this.mBinder.getFlags();
         return var1;
      } catch (RemoteException var4) {
         Log.e("MediaControllerCompat", "Dead object in getFlags. " + var4);
         return 0L;
      }
   }

   public Object getMediaController() {
      return null;
   }

   public MediaMetadataCompat getMetadata() {
      try {
         MediaMetadataCompat var1 = this.mBinder.getMetadata();
         return var1;
      } catch (RemoteException var2) {
         Log.e("MediaControllerCompat", "Dead object in getMetadata. " + var2);
         return null;
      }
   }

   public String getPackageName() {
      try {
         String var1 = this.mBinder.getPackageName();
         return var1;
      } catch (RemoteException var2) {
         Log.e("MediaControllerCompat", "Dead object in getPackageName. " + var2);
         return null;
      }
   }

   public MediaControllerCompat$PlaybackInfo getPlaybackInfo() {
      try {
         ParcelableVolumeInfo var1 = this.mBinder.getVolumeAttributes();
         MediaControllerCompat$PlaybackInfo var3 = new MediaControllerCompat$PlaybackInfo(var1.volumeType, var1.audioStream, var1.controlType, var1.maxVolume, var1.currentVolume);
         return var3;
      } catch (RemoteException var2) {
         Log.e("MediaControllerCompat", "Dead object in getPlaybackInfo. " + var2);
         return null;
      }
   }

   public PlaybackStateCompat getPlaybackState() {
      try {
         PlaybackStateCompat var1 = this.mBinder.getPlaybackState();
         return var1;
      } catch (RemoteException var2) {
         Log.e("MediaControllerCompat", "Dead object in getPlaybackState. " + var2);
         return null;
      }
   }

   public List<MediaSessionCompat$QueueItem> getQueue() {
      try {
         List var1 = this.mBinder.getQueue();
         return var1;
      } catch (RemoteException var2) {
         Log.e("MediaControllerCompat", "Dead object in getQueue. " + var2);
         return null;
      }
   }

   public CharSequence getQueueTitle() {
      try {
         CharSequence var1 = this.mBinder.getQueueTitle();
         return var1;
      } catch (RemoteException var2) {
         Log.e("MediaControllerCompat", "Dead object in getQueueTitle. " + var2);
         return null;
      }
   }

   public int getRatingType() {
      try {
         int var1 = this.mBinder.getRatingType();
         return var1;
      } catch (RemoteException var3) {
         Log.e("MediaControllerCompat", "Dead object in getRatingType. " + var3);
         return 0;
      }
   }

   public PendingIntent getSessionActivity() {
      try {
         PendingIntent var1 = this.mBinder.getLaunchPendingIntent();
         return var1;
      } catch (RemoteException var2) {
         Log.e("MediaControllerCompat", "Dead object in getSessionActivity. " + var2);
         return null;
      }
   }

   public MediaControllerCompat$TransportControls getTransportControls() {
      if(this.mTransportControls == null) {
         this.mTransportControls = new MediaControllerCompat$TransportControlsBase(this.mBinder);
      }

      return this.mTransportControls;
   }

   public void registerCallback(MediaControllerCompat$Callback var1, Handler var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("callback may not be null.");
      } else {
         try {
            this.mBinder.asBinder().linkToDeath(var1, 0);
            this.mBinder.registerCallbackListener((IMediaControllerCallback)MediaControllerCompat$Callback.access$400(var1));
            MediaControllerCompat$Callback.access$500(var1, var2);
            MediaControllerCompat$Callback.access$302(var1, true);
         } catch (RemoteException var3) {
            Log.e("MediaControllerCompat", "Dead object in registerCallback. " + var3);
            var1.onSessionDestroyed();
         }
      }
   }

   public void sendCommand(String var1, Bundle var2, ResultReceiver var3) {
      try {
         this.mBinder.sendCommand(var1, var2, new MediaSessionCompat$ResultReceiverWrapper(var3));
      } catch (RemoteException var4) {
         Log.e("MediaControllerCompat", "Dead object in sendCommand. " + var4);
      }
   }

   public void setVolumeTo(int var1, int var2) {
      try {
         this.mBinder.setVolumeTo(var1, var2, (String)null);
      } catch (RemoteException var4) {
         Log.e("MediaControllerCompat", "Dead object in setVolumeTo. " + var4);
      }
   }

   public void unregisterCallback(MediaControllerCompat$Callback var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("callback may not be null.");
      } else {
         try {
            this.mBinder.unregisterCallbackListener((IMediaControllerCallback)MediaControllerCompat$Callback.access$400(var1));
            this.mBinder.asBinder().unlinkToDeath(var1, 0);
            MediaControllerCompat$Callback.access$302(var1, false);
         } catch (RemoteException var2) {
            Log.e("MediaControllerCompat", "Dead object in unregisterCallback. " + var2);
         }
      }
   }
}
