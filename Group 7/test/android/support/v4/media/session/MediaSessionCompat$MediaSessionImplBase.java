package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.Build.VERSION;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.MediaMetadataCompat$Builder;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.VolumeProviderCompat$Callback;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.MediaSessionCompat$Callback;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$1;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$MediaSessionStub;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$MessageHandler;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.MediaSessionCompatApi14;
import android.support.v4.media.session.MediaSessionCompatApi18;
import android.support.v4.media.session.MediaSessionCompatApi8;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import java.util.List;

class MediaSessionCompat$MediaSessionImplBase implements MediaSessionCompat$MediaSessionImpl {
   private final AudioManager mAudioManager;
   private volatile MediaSessionCompat$Callback mCallback;
   private final ComponentName mComponentName;
   private final Context mContext;
   private final RemoteCallbackList<IMediaControllerCallback> mControllerCallbacks = new RemoteCallbackList();
   private boolean mDestroyed = false;
   private Bundle mExtras;
   private int mFlags;
   private MediaSessionCompat$MediaSessionImplBase$MessageHandler mHandler;
   private boolean mIsActive = false;
   private boolean mIsMbrRegistered = false;
   private boolean mIsRccRegistered = false;
   private int mLocalStream;
   private final Object mLock = new Object();
   private final PendingIntent mMediaButtonEventReceiver;
   private MediaMetadataCompat mMetadata;
   private final String mPackageName;
   private List<MediaSessionCompat$QueueItem> mQueue;
   private CharSequence mQueueTitle;
   private int mRatingType;
   private final Object mRccObj;
   private PendingIntent mSessionActivity;
   private PlaybackStateCompat mState;
   private final MediaSessionCompat$MediaSessionImplBase$MediaSessionStub mStub;
   private final String mTag;
   private final MediaSessionCompat$Token mToken;
   private VolumeProviderCompat$Callback mVolumeCallback = new MediaSessionCompat$MediaSessionImplBase$1(this);
   private VolumeProviderCompat mVolumeProvider;
   private int mVolumeType;

   public MediaSessionCompat$MediaSessionImplBase(Context var1, String var2, ComponentName var3, PendingIntent var4) {
      if(var3 == null) {
         throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
      } else {
         this.mContext = var1;
         this.mPackageName = var1.getPackageName();
         this.mAudioManager = (AudioManager)var1.getSystemService("audio");
         this.mTag = var2;
         this.mComponentName = var3;
         this.mMediaButtonEventReceiver = var4;
         this.mStub = new MediaSessionCompat$MediaSessionImplBase$MediaSessionStub(this);
         this.mToken = new MediaSessionCompat$Token(this.mStub);
         this.mRatingType = 0;
         this.mVolumeType = 1;
         this.mLocalStream = 3;
         if(VERSION.SDK_INT >= 14) {
            this.mRccObj = MediaSessionCompatApi14.createRemoteControlClient(var4);
         } else {
            this.mRccObj = null;
         }
      }
   }

   private void adjustVolume(int var1, int var2) {
      if(this.mVolumeType == 2) {
         if(this.mVolumeProvider != null) {
            this.mVolumeProvider.onAdjustVolume(var1);
         }

      } else {
         this.mAudioManager.adjustStreamVolume(this.mLocalStream, var1, var2);
      }
   }

   private MediaMetadataCompat cloneMetadataIfNeeded(MediaMetadataCompat var1) {
      label23: {
         MediaMetadataCompat var2;
         if(var1 == null) {
            var2 = null;
         } else {
            if(var1.containsKey("android.media.metadata.ART")) {
               break label23;
            }

            var2 = var1;
            if(var1.containsKey("android.media.metadata.ALBUM_ART")) {
               break label23;
            }
         }

         return var2;
      }

      MediaMetadataCompat$Builder var5 = new MediaMetadataCompat$Builder(var1);
      Bitmap var3 = var1.getBitmap("android.media.metadata.ART");
      if(var3 != null) {
         var5.putBitmap("android.media.metadata.ART", var3.copy(var3.getConfig(), false));
      }

      Bitmap var4 = var1.getBitmap("android.media.metadata.ALBUM_ART");
      if(var4 != null) {
         var5.putBitmap("android.media.metadata.ALBUM_ART", var4.copy(var4.getConfig(), false));
      }

      return var5.build();
   }

   private PlaybackStateCompat getStateWithUpdatedPosition() {
      // $FF: Couldn't be decompiled
   }

   private void postToHandler(int var1) {
      this.postToHandler(var1, (Object)null);
   }

   private void postToHandler(int var1, Object var2) {
      this.postToHandler(var1, var2, (Bundle)null);
   }

   private void postToHandler(int param1, Object param2, Bundle param3) {
      // $FF: Couldn't be decompiled
   }

   private void sendEvent(String var1, Bundle var2) {
      for(int var3 = this.mControllerCallbacks.beginBroadcast() - 1; var3 >= 0; --var3) {
         IMediaControllerCallback var4 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(var3);

         try {
            var4.onEvent(var1, var2);
         } catch (RemoteException var5) {
            ;
         }
      }

      this.mControllerCallbacks.finishBroadcast();
   }

   private void sendMetadata(MediaMetadataCompat var1) {
      for(int var2 = this.mControllerCallbacks.beginBroadcast() - 1; var2 >= 0; --var2) {
         IMediaControllerCallback var3 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(var2);

         try {
            var3.onMetadataChanged(var1);
         } catch (RemoteException var4) {
            ;
         }
      }

      this.mControllerCallbacks.finishBroadcast();
   }

   private void sendQueue(List<MediaSessionCompat$QueueItem> var1) {
      for(int var2 = this.mControllerCallbacks.beginBroadcast() - 1; var2 >= 0; --var2) {
         IMediaControllerCallback var3 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(var2);

         try {
            var3.onQueueChanged(var1);
         } catch (RemoteException var4) {
            ;
         }
      }

      this.mControllerCallbacks.finishBroadcast();
   }

   private void sendQueueTitle(CharSequence var1) {
      for(int var2 = this.mControllerCallbacks.beginBroadcast() - 1; var2 >= 0; --var2) {
         IMediaControllerCallback var3 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(var2);

         try {
            var3.onQueueTitleChanged(var1);
         } catch (RemoteException var4) {
            ;
         }
      }

      this.mControllerCallbacks.finishBroadcast();
   }

   private void sendSessionDestroyed() {
      for(int var1 = this.mControllerCallbacks.beginBroadcast() - 1; var1 >= 0; --var1) {
         IMediaControllerCallback var2 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(var1);

         try {
            var2.onSessionDestroyed();
         } catch (RemoteException var3) {
            ;
         }
      }

      this.mControllerCallbacks.finishBroadcast();
      this.mControllerCallbacks.kill();
   }

   private void sendState(PlaybackStateCompat var1) {
      for(int var2 = this.mControllerCallbacks.beginBroadcast() - 1; var2 >= 0; --var2) {
         IMediaControllerCallback var3 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(var2);

         try {
            var3.onPlaybackStateChanged(var1);
         } catch (RemoteException var4) {
            ;
         }
      }

      this.mControllerCallbacks.finishBroadcast();
   }

   private void sendVolumeInfoChanged(ParcelableVolumeInfo var1) {
      for(int var2 = this.mControllerCallbacks.beginBroadcast() - 1; var2 >= 0; --var2) {
         IMediaControllerCallback var3 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(var2);

         try {
            var3.onVolumeInfoChanged(var1);
         } catch (RemoteException var4) {
            ;
         }
      }

      this.mControllerCallbacks.finishBroadcast();
   }

   private void setVolumeTo(int var1, int var2) {
      if(this.mVolumeType == 2) {
         if(this.mVolumeProvider != null) {
            this.mVolumeProvider.onSetVolumeTo(var1);
         }

      } else {
         this.mAudioManager.setStreamVolume(this.mLocalStream, var1, var2);
      }
   }

   private boolean update() {
      boolean var2 = false;
      boolean var1;
      if(this.mIsActive) {
         if(VERSION.SDK_INT >= 8) {
            if(!this.mIsMbrRegistered && (this.mFlags & 1) != 0) {
               if(VERSION.SDK_INT >= 18) {
                  MediaSessionCompatApi18.registerMediaButtonEventReceiver(this.mContext, this.mMediaButtonEventReceiver, this.mComponentName);
               } else {
                  MediaSessionCompatApi8.registerMediaButtonEventReceiver(this.mContext, this.mComponentName);
               }

               this.mIsMbrRegistered = true;
            } else if(this.mIsMbrRegistered && (this.mFlags & 1) == 0) {
               if(VERSION.SDK_INT >= 18) {
                  MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(this.mContext, this.mMediaButtonEventReceiver, this.mComponentName);
               } else {
                  MediaSessionCompatApi8.unregisterMediaButtonEventReceiver(this.mContext, this.mComponentName);
               }

               this.mIsMbrRegistered = false;
            }
         }

         var1 = var2;
         if(VERSION.SDK_INT >= 14) {
            if(!this.mIsRccRegistered && (this.mFlags & 2) != 0) {
               MediaSessionCompatApi14.registerRemoteControlClient(this.mContext, this.mRccObj);
               this.mIsRccRegistered = true;
               var1 = true;
            } else {
               var1 = var2;
               if(this.mIsRccRegistered) {
                  var1 = var2;
                  if((this.mFlags & 2) == 0) {
                     MediaSessionCompatApi14.setState(this.mRccObj, 0);
                     MediaSessionCompatApi14.unregisterRemoteControlClient(this.mContext, this.mRccObj);
                     this.mIsRccRegistered = false;
                     return false;
                  }
               }
            }
         }
      } else {
         if(this.mIsMbrRegistered) {
            if(VERSION.SDK_INT >= 18) {
               MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(this.mContext, this.mMediaButtonEventReceiver, this.mComponentName);
            } else {
               MediaSessionCompatApi8.unregisterMediaButtonEventReceiver(this.mContext, this.mComponentName);
            }

            this.mIsMbrRegistered = false;
         }

         var1 = var2;
         if(this.mIsRccRegistered) {
            MediaSessionCompatApi14.setState(this.mRccObj, 0);
            MediaSessionCompatApi14.unregisterRemoteControlClient(this.mContext, this.mRccObj);
            this.mIsRccRegistered = false;
            return false;
         }
      }

      return var1;
   }

   public Object getMediaSession() {
      return null;
   }

   public Object getRemoteControlClient() {
      return this.mRccObj;
   }

   public MediaSessionCompat$Token getSessionToken() {
      return this.mToken;
   }

   public boolean isActive() {
      return this.mIsActive;
   }

   public void release() {
      this.mIsActive = false;
      this.mDestroyed = true;
      this.update();
      this.sendSessionDestroyed();
   }

   public void sendSessionEvent(String var1, Bundle var2) {
      this.sendEvent(var1, var2);
   }

   public void setActive(boolean var1) {
      if(var1 != this.mIsActive) {
         this.mIsActive = var1;
         if(this.update()) {
            this.setMetadata(this.mMetadata);
            this.setPlaybackState(this.mState);
            return;
         }
      }

   }

   public void setCallback(MediaSessionCompat$Callback param1, Handler param2) {
      // $FF: Couldn't be decompiled
   }

   public void setExtras(Bundle var1) {
      this.mExtras = var1;
   }

   public void setFlags(int param1) {
      // $FF: Couldn't be decompiled
   }

   public void setMediaButtonReceiver(PendingIntent var1) {
   }

   public void setMetadata(MediaMetadataCompat param1) {
      // $FF: Couldn't be decompiled
   }

   public void setPlaybackState(PlaybackStateCompat param1) {
      // $FF: Couldn't be decompiled
   }

   public void setPlaybackToLocal(int var1) {
      if(this.mVolumeProvider != null) {
         this.mVolumeProvider.setCallback((VolumeProviderCompat$Callback)null);
      }

      this.mVolumeType = 1;
      this.sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, 2, this.mAudioManager.getStreamMaxVolume(this.mLocalStream), this.mAudioManager.getStreamVolume(this.mLocalStream)));
   }

   public void setPlaybackToRemote(VolumeProviderCompat var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("volumeProvider may not be null");
      } else {
         if(this.mVolumeProvider != null) {
            this.mVolumeProvider.setCallback((VolumeProviderCompat$Callback)null);
         }

         this.mVolumeType = 2;
         this.mVolumeProvider = var1;
         this.sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.getVolumeControl(), this.mVolumeProvider.getMaxVolume(), this.mVolumeProvider.getCurrentVolume()));
         var1.setCallback(this.mVolumeCallback);
      }
   }

   public void setQueue(List<MediaSessionCompat$QueueItem> var1) {
      this.mQueue = var1;
      this.sendQueue(var1);
   }

   public void setQueueTitle(CharSequence var1) {
      this.mQueueTitle = var1;
      this.sendQueueTitle(var1);
   }

   public void setRatingType(int var1) {
      this.mRatingType = var1;
   }

   public void setSessionActivity(PendingIntent param1) {
      // $FF: Couldn't be decompiled
   }
}
