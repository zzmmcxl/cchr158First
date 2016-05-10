package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompatApi14;
import android.support.v4.media.session.MediaSessionCompatApi18;
import android.support.v4.media.session.MediaSessionCompatApi19;
import android.support.v4.media.session.MediaSessionCompatApi21;
import android.support.v4.media.session.MediaSessionCompatApi22;
import android.support.v4.media.session.MediaSessionCompatApi8;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MediaSessionCompat {
   public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
   public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
   private final ArrayList mActiveListeners = new ArrayList();
   private final MediaControllerCompat mController;
   private final MediaSessionCompat.MediaSessionImpl mImpl;

   private MediaSessionCompat(Context var1, MediaSessionCompat.MediaSessionImpl var2) {
      this.mImpl = var2;
      this.mController = new MediaControllerCompat(var1, this);
   }

   public MediaSessionCompat(Context var1, String var2, ComponentName var3, PendingIntent var4) {
      if(var1 == null) {
         throw new IllegalArgumentException("context must not be null");
      } else if(TextUtils.isEmpty(var2)) {
         throw new IllegalArgumentException("tag must not be null or empty");
      } else {
         PendingIntent var5 = var4;
         if(var3 != null) {
            var5 = var4;
            if(var4 == null) {
               Intent var6 = new Intent("android.intent.action.MEDIA_BUTTON");
               var6.setComponent(var3);
               var5 = PendingIntent.getBroadcast(var1, 0, var6, 0);
            }
         }

         if(VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaSessionCompat.MediaSessionImplApi21(var1, var2);
            this.mImpl.setMediaButtonReceiver(var5);
         } else {
            this.mImpl = new MediaSessionCompat.MediaSessionImplBase(var1, var2, var3, var5);
         }

         this.mController = new MediaControllerCompat(var1, this);
      }
   }

   public static MediaSessionCompat obtain(Context var0, Object var1) {
      return new MediaSessionCompat(var0, new MediaSessionCompat.MediaSessionImplApi21(var1));
   }

   public void addOnActiveChangeListener(MediaSessionCompat.OnActiveChangeListener var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Listener may not be null");
      } else {
         this.mActiveListeners.add(var1);
      }
   }

   public MediaControllerCompat getController() {
      return this.mController;
   }

   public Object getMediaSession() {
      return this.mImpl.getMediaSession();
   }

   public Object getRemoteControlClient() {
      return this.mImpl.getRemoteControlClient();
   }

   public MediaSessionCompat.Token getSessionToken() {
      return this.mImpl.getSessionToken();
   }

   public boolean isActive() {
      return this.mImpl.isActive();
   }

   public void release() {
      this.mImpl.release();
   }

   public void removeOnActiveChangeListener(MediaSessionCompat.OnActiveChangeListener var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Listener may not be null");
      } else {
         this.mActiveListeners.remove(var1);
      }
   }

   public void sendSessionEvent(String var1, Bundle var2) {
      if(TextUtils.isEmpty(var1)) {
         throw new IllegalArgumentException("event cannot be null or empty");
      } else {
         this.mImpl.sendSessionEvent(var1, var2);
      }
   }

   public void setActive(boolean var1) {
      this.mImpl.setActive(var1);
      Iterator var2 = this.mActiveListeners.iterator();

      while(var2.hasNext()) {
         ((MediaSessionCompat.OnActiveChangeListener)var2.next()).onActiveChanged();
      }

   }

   public void setCallback(MediaSessionCompat.Callback var1) {
      this.setCallback(var1, (Handler)null);
   }

   public void setCallback(MediaSessionCompat.Callback var1, Handler var2) {
      MediaSessionCompat.MediaSessionImpl var3 = this.mImpl;
      if(var2 == null) {
         var2 = new Handler();
      }

      var3.setCallback(var1, var2);
   }

   public void setExtras(Bundle var1) {
      this.mImpl.setExtras(var1);
   }

   public void setFlags(int var1) {
      this.mImpl.setFlags(var1);
   }

   public void setMediaButtonReceiver(PendingIntent var1) {
      this.mImpl.setMediaButtonReceiver(var1);
   }

   public void setMetadata(MediaMetadataCompat var1) {
      this.mImpl.setMetadata(var1);
   }

   public void setPlaybackState(PlaybackStateCompat var1) {
      this.mImpl.setPlaybackState(var1);
   }

   public void setPlaybackToLocal(int var1) {
      this.mImpl.setPlaybackToLocal(var1);
   }

   public void setPlaybackToRemote(VolumeProviderCompat var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("volumeProvider may not be null!");
      } else {
         this.mImpl.setPlaybackToRemote(var1);
      }
   }

   public void setQueue(List var1) {
      this.mImpl.setQueue(var1);
   }

   public void setQueueTitle(CharSequence var1) {
      this.mImpl.setQueueTitle(var1);
   }

   public void setRatingType(int var1) {
      this.mImpl.setRatingType(var1);
   }

   public void setSessionActivity(PendingIntent var1) {
      this.mImpl.setSessionActivity(var1);
   }

   public abstract static class Callback {
      final Object mCallbackObj;

      public Callback() {
         if(VERSION.SDK_INT >= 21) {
            this.mCallbackObj = MediaSessionCompatApi21.createCallback(new MediaSessionCompat.StubApi21());
         } else {
            this.mCallbackObj = null;
         }
      }

      public void onCommand(String var1, Bundle var2, ResultReceiver var3) {
      }

      public void onCustomAction(String var1, Bundle var2) {
      }

      public void onFastForward() {
      }

      public boolean onMediaButtonEvent(Intent var1) {
         return false;
      }

      public void onPause() {
      }

      public void onPlay() {
      }

      public void onPlayFromMediaId(String var1, Bundle var2) {
      }

      public void onPlayFromSearch(String var1, Bundle var2) {
      }

      public void onRewind() {
      }

      public void onSeekTo(long var1) {
      }

      public void onSetRating(RatingCompat var1) {
      }

      public void onSkipToNext() {
      }

      public void onSkipToPrevious() {
      }

      public void onSkipToQueueItem(long var1) {
      }

      public void onStop() {
      }
   }

   private class StubApi21 implements MediaSessionCompatApi21.Callback {
      private StubApi21() {
      }

      // $FF: synthetic method
      StubApi21(Object var2) {
         this();
      }

      public void onCommand(String var1, Bundle var2, ResultReceiver var3) {
         MediaSessionCompat.this.onCommand(var1, var2, var3);
      }

      public void onCustomAction(String var1, Bundle var2) {
         MediaSessionCompat.this.onCustomAction(var1, var2);
      }

      public void onFastForward() {
         MediaSessionCompat.this.onFastForward();
      }

      public boolean onMediaButtonEvent(Intent var1) {
         return MediaSessionCompat.this.onMediaButtonEvent(var1);
      }

      public void onPause() {
         MediaSessionCompat.this.onPause();
      }

      public void onPlay() {
         MediaSessionCompat.this.onPlay();
      }

      public void onPlayFromMediaId(String var1, Bundle var2) {
         MediaSessionCompat.this.onPlayFromMediaId(var1, var2);
      }

      public void onPlayFromSearch(String var1, Bundle var2) {
         MediaSessionCompat.this.onPlayFromSearch(var1, var2);
      }

      public void onRewind() {
         MediaSessionCompat.this.onRewind();
      }

      public void onSeekTo(long var1) {
         MediaSessionCompat.this.onSeekTo(var1);
      }

      public void onSetRating(Object var1) {
         MediaSessionCompat.this.onSetRating(RatingCompat.fromRating(var1));
      }

      public void onSkipToNext() {
         MediaSessionCompat.this.onSkipToNext();
      }

      public void onSkipToPrevious() {
         MediaSessionCompat.this.onSkipToPrevious();
      }

      public void onSkipToQueueItem(long var1) {
         MediaSessionCompat.this.onSkipToQueueItem(var1);
      }

      public void onStop() {
         MediaSessionCompat.this.onStop();
      }
   }

   interface MediaSessionImpl {
      Object getMediaSession();

      Object getRemoteControlClient();

      MediaSessionCompat.Token getSessionToken();

      boolean isActive();

      void release();

      void sendSessionEvent(String var1, Bundle var2);

      void setActive(boolean var1);

      void setCallback(MediaSessionCompat.Callback var1, Handler var2);

      void setExtras(Bundle var1);

      void setFlags(int var1);

      void setMediaButtonReceiver(PendingIntent var1);

      void setMetadata(MediaMetadataCompat var1);

      void setPlaybackState(PlaybackStateCompat var1);

      void setPlaybackToLocal(int var1);

      void setPlaybackToRemote(VolumeProviderCompat var1);

      void setQueue(List var1);

      void setQueueTitle(CharSequence var1);

      void setRatingType(int var1);

      void setSessionActivity(PendingIntent var1);
   }

   static class MediaSessionImplApi21 implements MediaSessionCompat.MediaSessionImpl {
      private PendingIntent mMediaButtonIntent;
      private final Object mSessionObj;
      private final MediaSessionCompat.Token mToken;

      public MediaSessionImplApi21(Context var1, String var2) {
         this.mSessionObj = MediaSessionCompatApi21.createSession(var1, var2);
         this.mToken = new MediaSessionCompat.Token(MediaSessionCompatApi21.getSessionToken(this.mSessionObj));
      }

      public MediaSessionImplApi21(Object var1) {
         this.mSessionObj = MediaSessionCompatApi21.verifySession(var1);
         this.mToken = new MediaSessionCompat.Token(MediaSessionCompatApi21.getSessionToken(this.mSessionObj));
      }

      public Object getMediaSession() {
         return this.mSessionObj;
      }

      public Object getRemoteControlClient() {
         return null;
      }

      public MediaSessionCompat.Token getSessionToken() {
         return this.mToken;
      }

      public boolean isActive() {
         return MediaSessionCompatApi21.isActive(this.mSessionObj);
      }

      public void release() {
         MediaSessionCompatApi21.release(this.mSessionObj);
      }

      public void sendSessionEvent(String var1, Bundle var2) {
         MediaSessionCompatApi21.sendSessionEvent(this.mSessionObj, var1, var2);
      }

      public void setActive(boolean var1) {
         MediaSessionCompatApi21.setActive(this.mSessionObj, var1);
      }

      public void setCallback(MediaSessionCompat.Callback var1, Handler var2) {
         MediaSessionCompatApi21.setCallback(this.mSessionObj, var1.mCallbackObj, var2);
      }

      public void setExtras(Bundle var1) {
         MediaSessionCompatApi21.setExtras(this.mSessionObj, var1);
      }

      public void setFlags(int var1) {
         MediaSessionCompatApi21.setFlags(this.mSessionObj, var1);
      }

      public void setMediaButtonReceiver(PendingIntent var1) {
         this.mMediaButtonIntent = var1;
         MediaSessionCompatApi21.setMediaButtonReceiver(this.mSessionObj, var1);
      }

      public void setMetadata(MediaMetadataCompat var1) {
         MediaSessionCompatApi21.setMetadata(this.mSessionObj, var1.getMediaMetadata());
      }

      public void setPlaybackState(PlaybackStateCompat var1) {
         MediaSessionCompatApi21.setPlaybackState(this.mSessionObj, var1.getPlaybackState());
      }

      public void setPlaybackToLocal(int var1) {
         MediaSessionCompatApi21.setPlaybackToLocal(this.mSessionObj, var1);
      }

      public void setPlaybackToRemote(VolumeProviderCompat var1) {
         MediaSessionCompatApi21.setPlaybackToRemote(this.mSessionObj, var1.getVolumeProvider());
      }

      public void setQueue(List var1) {
         ArrayList var2 = null;
         if(var1 != null) {
            ArrayList var3 = new ArrayList();
            Iterator var4 = var1.iterator();

            while(true) {
               var2 = var3;
               if(!var4.hasNext()) {
                  break;
               }

               var3.add(((MediaSessionCompat.QueueItem)var4.next()).getQueueItem());
            }
         }

         MediaSessionCompatApi21.setQueue(this.mSessionObj, var2);
      }

      public void setQueueTitle(CharSequence var1) {
         MediaSessionCompatApi21.setQueueTitle(this.mSessionObj, var1);
      }

      public void setRatingType(int var1) {
         if(VERSION.SDK_INT >= 22) {
            MediaSessionCompatApi22.setRatingType(this.mSessionObj, var1);
         }
      }

      public void setSessionActivity(PendingIntent var1) {
         MediaSessionCompatApi21.setSessionActivity(this.mSessionObj, var1);
      }
   }

   static class MediaSessionImplBase implements MediaSessionCompat.MediaSessionImpl {
      private final AudioManager mAudioManager;
      private MediaSessionCompat.Callback mCallback;
      private final ComponentName mComponentName;
      private final Context mContext;
      private final RemoteCallbackList mControllerCallbacks = new RemoteCallbackList();
      private boolean mDestroyed = false;
      private Bundle mExtras;
      private int mFlags;
      private final MediaSessionCompat.MessageHandler mHandler;
      private boolean mIsActive = false;
      private boolean mIsMbrRegistered = false;
      private boolean mIsRccRegistered = false;
      private int mLocalStream;
      private final Object mLock = new Object();
      private final PendingIntent mMediaButtonEventReceiver;
      private MediaMetadataCompat mMetadata;
      private final String mPackageName;
      private List mQueue;
      private CharSequence mQueueTitle;
      private int mRatingType;
      private final Object mRccObj;
      private PendingIntent mSessionActivity;
      private PlaybackStateCompat mState;
      private final MediaSessionCompat.MediaSessionStub mStub;
      private final String mTag;
      private final MediaSessionCompat.Token mToken;
      private VolumeProviderCompat.Callback mVolumeCallback = new VolumeProviderCompat.Callback() {
         public void onVolumeChanged(VolumeProviderCompat var1) {
            if(MediaSessionImplBase.this.mVolumeProvider == var1) {
               ParcelableVolumeInfo var2 = new ParcelableVolumeInfo(MediaSessionImplBase.this.mVolumeType, MediaSessionImplBase.this.mLocalStream, var1.getVolumeControl(), var1.getMaxVolume(), var1.getCurrentVolume());
               MediaSessionImplBase.this.sendVolumeInfoChanged(var2);
            }
         }
      };
      private VolumeProviderCompat mVolumeProvider;
      private int mVolumeType;

      public MediaSessionImplBase(Context var1, String var2, ComponentName var3, PendingIntent var4) {
         if(var3 == null) {
            throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
         } else {
            this.mContext = var1;
            this.mPackageName = var1.getPackageName();
            this.mAudioManager = (AudioManager)var1.getSystemService("audio");
            this.mTag = var2;
            this.mComponentName = var3;
            this.mMediaButtonEventReceiver = var4;
            this.mStub = new MediaSessionCompat.MediaSessionStub();
            this.mToken = new MediaSessionCompat.Token(this.mStub);
            this.mHandler = new MediaSessionCompat.MessageHandler(Looper.myLooper());
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

      // $FF: synthetic method
      static Object access$1300(MediaSessionCompat.MediaSessionImplBase var0) {
         return var0.mLock;
      }

      // $FF: synthetic method
      static PendingIntent access$1400(MediaSessionCompat.MediaSessionImplBase var0) {
         return var0.mSessionActivity;
      }

      // $FF: synthetic method
      static AudioManager access$1500(MediaSessionCompat.MediaSessionImplBase var0) {
         return var0.mAudioManager;
      }

      // $FF: synthetic method
      static List access$2000(MediaSessionCompat.MediaSessionImplBase var0) {
         return var0.mQueue;
      }

      // $FF: synthetic method
      static Bundle access$2200(MediaSessionCompat.MediaSessionImplBase var0) {
         return var0.mExtras;
      }

      private void adjustVolume(int var1, int var2) {
         if(this.mVolumeType == 2) {
            if(this.mVolumeProvider != null) {
               this.mVolumeProvider.onAdjustVolume(var1);
            }

         } else {
            this.mAudioManager.adjustStreamVolume(var1, this.mLocalStream, var2);
         }
      }

      private PlaybackStateCompat getStateWithUpdatedPosition() {
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

      private void sendQueue(List var1) {
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
                     MediaSessionCompatApi18.registerMediaButtonEventReceiver(this.mContext, this.mMediaButtonEventReceiver);
                  } else {
                     MediaSessionCompatApi8.registerMediaButtonEventReceiver(this.mContext, this.mComponentName);
                  }

                  this.mIsMbrRegistered = true;
               } else if(this.mIsMbrRegistered && (this.mFlags & 1) == 0) {
                  if(VERSION.SDK_INT >= 18) {
                     MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(this.mContext, this.mMediaButtonEventReceiver);
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
                  MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(this.mContext, this.mMediaButtonEventReceiver);
               } else {
                  MediaSessionCompatApi8.unregisterMediaButtonEventReceiver(this.mContext, this.mComponentName);
               }

               this.mIsMbrRegistered = false;
            }

            var1 = var2;
            if(this.mIsRccRegistered) {
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

      public MediaSessionCompat.Token getSessionToken() {
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

      public void setCallback(final MediaSessionCompat.Callback var1, Handler var2) {
         if(var1 != this.mCallback) {
            if(var1 != null && VERSION.SDK_INT >= 18) {
               if(var2 == null) {
                  new Handler();
               }

               MediaSessionCompatApi14.Callback var4 = new MediaSessionCompatApi14.Callback() {
                  public void onCommand(String var1x, Bundle var2, ResultReceiver var3) {
                     var1.onCommand(var1x, var2, var3);
                  }

                  public void onFastForward() {
                     var1.onFastForward();
                  }

                  public boolean onMediaButtonEvent(Intent var1x) {
                     return var1.onMediaButtonEvent(var1x);
                  }

                  public void onPause() {
                     var1.onPause();
                  }

                  public void onPlay() {
                     var1.onPlay();
                  }

                  public void onRewind() {
                     var1.onRewind();
                  }

                  public void onSeekTo(long var1x) {
                     var1.onSeekTo(var1x);
                  }

                  public void onSetRating(Object var1x) {
                     var1.onSetRating(RatingCompat.fromRating(var1x));
                  }

                  public void onSkipToNext() {
                     var1.onSkipToNext();
                  }

                  public void onSkipToPrevious() {
                     var1.onSkipToPrevious();
                  }

                  public void onStop() {
                     var1.onStop();
                  }
               };
               if(VERSION.SDK_INT >= 18) {
                  Object var3 = MediaSessionCompatApi18.createPlaybackPositionUpdateListener(var4);
                  MediaSessionCompatApi18.setOnPlaybackPositionUpdateListener(this.mRccObj, var3);
               }

               if(VERSION.SDK_INT >= 19) {
                  Object var5 = MediaSessionCompatApi19.createMetadataUpdateListener(var4);
                  MediaSessionCompatApi19.setOnMetadataUpdateListener(this.mRccObj, var5);
               }
            } else {
               if(VERSION.SDK_INT >= 18) {
                  MediaSessionCompatApi18.setOnPlaybackPositionUpdateListener(this.mRccObj, (Object)null);
               }

               if(VERSION.SDK_INT >= 19) {
                  MediaSessionCompatApi19.setOnMetadataUpdateListener(this.mRccObj, (Object)null);
               }
            }

            this.mCallback = var1;
         }
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
            this.mVolumeProvider.setCallback((VolumeProviderCompat.Callback)null);
         }

         this.mVolumeType = 1;
         this.sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, 2, this.mAudioManager.getStreamMaxVolume(this.mLocalStream), this.mAudioManager.getStreamVolume(this.mLocalStream)));
      }

      public void setPlaybackToRemote(VolumeProviderCompat var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("volumeProvider may not be null");
         } else {
            if(this.mVolumeProvider != null) {
               this.mVolumeProvider.setCallback((VolumeProviderCompat.Callback)null);
            }

            this.mVolumeType = 2;
            this.mVolumeProvider = var1;
            this.sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.getVolumeControl(), this.mVolumeProvider.getMaxVolume(), this.mVolumeProvider.getCurrentVolume()));
            var1.setCallback(this.mVolumeCallback);
         }
      }

      public void setQueue(List var1) {
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

   private static final class Command {
      public final String command;
      public final Bundle extras;
      public final ResultReceiver stub;

      public Command(String var1, Bundle var2, ResultReceiver var3) {
         this.command = var1;
         this.extras = var2;
         this.stub = var3;
      }
   }

   class MediaSessionStub extends IMediaSession.Stub {
      public void adjustVolume(int var1, int var2, String var3) {
         MediaSessionCompat.super.adjustVolume(var1, var2);
      }

      public void fastForward() throws RemoteException {
         MediaSessionCompat.super.mHandler.post(9);
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
         return MediaSessionCompat.super.mMetadata;
      }

      public String getPackageName() {
         return MediaSessionCompat.super.mPackageName;
      }

      public PlaybackStateCompat getPlaybackState() {
         return MediaSessionCompat.super.getStateWithUpdatedPosition();
      }

      public List getQueue() {
         // $FF: Couldn't be decompiled
      }

      public CharSequence getQueueTitle() {
         return MediaSessionCompat.super.mQueueTitle;
      }

      public int getRatingType() {
         return MediaSessionCompat.super.mRatingType;
      }

      public String getTag() {
         return MediaSessionCompat.super.mTag;
      }

      public ParcelableVolumeInfo getVolumeAttributes() {
         // $FF: Couldn't be decompiled
      }

      public boolean isTransportControlEnabled() {
         return (MediaSessionCompat.super.mFlags & 2) != 0;
      }

      public void next() throws RemoteException {
         MediaSessionCompat.super.mHandler.post(7);
      }

      public void pause() throws RemoteException {
         MediaSessionCompat.super.mHandler.post(5);
      }

      public void play() throws RemoteException {
         MediaSessionCompat.super.mHandler.post(1);
      }

      public void playFromMediaId(String var1, Bundle var2) throws RemoteException {
         MediaSessionCompat.super.mHandler.post(2, var1, var2);
      }

      public void playFromSearch(String var1, Bundle var2) throws RemoteException {
         MediaSessionCompat.super.mHandler.post(3, var1, var2);
      }

      public void previous() throws RemoteException {
         MediaSessionCompat.super.mHandler.post(8);
      }

      public void rate(RatingCompat var1) throws RemoteException {
         MediaSessionCompat.super.mHandler.post(12, var1);
      }

      public void registerCallbackListener(IMediaControllerCallback var1) {
         if(MediaSessionCompat.super.mDestroyed) {
            try {
               var1.onSessionDestroyed();
            } catch (Exception var2) {
               ;
            }
         } else {
            MediaSessionCompat.super.mControllerCallbacks.register(var1);
         }
      }

      public void rewind() throws RemoteException {
         MediaSessionCompat.super.mHandler.post(10);
      }

      public void seekTo(long var1) throws RemoteException {
         MediaSessionCompat.super.mHandler.post(11, Long.valueOf(var1));
      }

      public void sendCommand(String var1, Bundle var2, MediaSessionCompat.ResultReceiverWrapper var3) {
         MediaSessionCompat.super.mHandler.post(15, new MediaSessionCompat.Command(var1, var2, var3.mResultReceiver));
      }

      public void sendCustomAction(String var1, Bundle var2) throws RemoteException {
         MediaSessionCompat.super.mHandler.post(13, var1, var2);
      }

      public boolean sendMediaButton(KeyEvent var1) {
         boolean var2;
         if((MediaSessionCompat.super.mFlags & 1) != 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         if(var2) {
            MediaSessionCompat.super.mHandler.post(14, var1);
         }

         return var2;
      }

      public void setVolumeTo(int var1, int var2, String var3) {
         MediaSessionCompat.super.setVolumeTo(var1, var2);
      }

      public void skipToQueueItem(long var1) {
         MediaSessionCompat.super.mHandler.post(4, Long.valueOf(var1));
      }

      public void stop() throws RemoteException {
         MediaSessionCompat.super.mHandler.post(6);
      }

      public void unregisterCallbackListener(IMediaControllerCallback var1) {
         MediaSessionCompat.super.mControllerCallbacks.unregister(var1);
      }
   }

   private class MessageHandler extends Handler {
      private static final int MSG_ADJUST_VOLUME = 16;
      private static final int MSG_COMMAND = 15;
      private static final int MSG_CUSTOM_ACTION = 13;
      private static final int MSG_FAST_FORWARD = 9;
      private static final int MSG_MEDIA_BUTTON = 14;
      private static final int MSG_NEXT = 7;
      private static final int MSG_PAUSE = 5;
      private static final int MSG_PLAY = 1;
      private static final int MSG_PLAY_MEDIA_ID = 2;
      private static final int MSG_PLAY_SEARCH = 3;
      private static final int MSG_PREVIOUS = 8;
      private static final int MSG_RATE = 12;
      private static final int MSG_REWIND = 10;
      private static final int MSG_SEEK_TO = 11;
      private static final int MSG_SET_VOLUME = 17;
      private static final int MSG_SKIP_TO_ITEM = 4;
      private static final int MSG_STOP = 6;

      public MessageHandler(Looper var2) {
         super(var2);
      }

      public void handleMessage(Message var1) {
         if(MediaSessionCompat.super.mCallback != null) {
            switch(var1.what) {
            case 1:
               MediaSessionCompat.super.mCallback.onPlay();
               return;
            case 2:
               MediaSessionCompat.super.mCallback.onPlayFromMediaId((String)var1.obj, var1.getData());
               return;
            case 3:
               MediaSessionCompat.super.mCallback.onPlayFromSearch((String)var1.obj, var1.getData());
               return;
            case 4:
               MediaSessionCompat.super.mCallback.onSkipToQueueItem(((Long)var1.obj).longValue());
               return;
            case 5:
               MediaSessionCompat.super.mCallback.onPause();
               return;
            case 6:
               MediaSessionCompat.super.mCallback.onStop();
               return;
            case 7:
               MediaSessionCompat.super.mCallback.onSkipToNext();
               return;
            case 8:
               MediaSessionCompat.super.mCallback.onSkipToPrevious();
               return;
            case 9:
               MediaSessionCompat.super.mCallback.onFastForward();
               return;
            case 10:
               MediaSessionCompat.super.mCallback.onRewind();
               return;
            case 11:
               MediaSessionCompat.super.mCallback.onSeekTo(((Long)var1.obj).longValue());
               return;
            case 12:
               MediaSessionCompat.super.mCallback.onSetRating((RatingCompat)var1.obj);
               return;
            case 13:
               MediaSessionCompat.super.mCallback.onCustomAction((String)var1.obj, var1.getData());
               return;
            case 14:
               KeyEvent var4 = (KeyEvent)var1.obj;
               Intent var2 = new Intent("android.intent.action.MEDIA_BUTTON");
               var2.putExtra("android.intent.extra.KEY_EVENT", var4);
               MediaSessionCompat.super.mCallback.onMediaButtonEvent(var2);
               return;
            case 15:
               MediaSessionCompat.Command var3 = (MediaSessionCompat.Command)var1.obj;
               MediaSessionCompat.super.mCallback.onCommand(var3.command, var3.extras, var3.stub);
               return;
            case 16:
               MediaSessionCompat.super.adjustVolume(((Integer)var1.obj).intValue(), 0);
               return;
            case 17:
               MediaSessionCompat.super.setVolumeTo(((Integer)var1.obj).intValue(), 0);
               return;
            default:
            }
         }
      }

      public void post(int var1) {
         this.post(var1, (Object)null);
      }

      public void post(int var1, Object var2) {
         this.obtainMessage(var1, var2).sendToTarget();
      }

      public void post(int var1, Object var2, int var3) {
         this.obtainMessage(var1, var3, 0, var2).sendToTarget();
      }

      public void post(int var1, Object var2, Bundle var3) {
         Message var4 = this.obtainMessage(var1, var2);
         var4.setData(var3);
         var4.sendToTarget();
      }
   }

   public interface OnActiveChangeListener {
      void onActiveChanged();
   }

   public static final class QueueItem implements Parcelable {
      public static final Creator CREATOR = new Creator() {
         public MediaSessionCompat.QueueItem createFromParcel(Parcel var1) {
            return new MediaSessionCompat.QueueItem(var1);
         }

         public MediaSessionCompat.QueueItem[] newArray(int var1) {
            return new MediaSessionCompat.QueueItem[var1];
         }
      };
      public static final int UNKNOWN_ID = -1;
      private final MediaDescriptionCompat mDescription;
      private final long mId;
      private Object mItem;

      private QueueItem(Parcel var1) {
         this.mDescription = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(var1);
         this.mId = var1.readLong();
      }

      // $FF: synthetic method
      QueueItem(Parcel var1, Object var2) {
         this(var1);
      }

      public QueueItem(MediaDescriptionCompat var1, long var2) {
         this((Object)null, var1, var2);
      }

      private QueueItem(Object var1, MediaDescriptionCompat var2, long var3) {
         if(var2 == null) {
            throw new IllegalArgumentException("Description cannot be null.");
         } else if(var3 == -1L) {
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
         } else {
            this.mDescription = var2;
            this.mId = var3;
            this.mItem = var1;
         }
      }

      public static MediaSessionCompat.QueueItem obtain(Object var0) {
         return new MediaSessionCompat.QueueItem(var0, MediaDescriptionCompat.fromMediaDescription(MediaSessionCompatApi21.QueueItem.getDescription(var0)), MediaSessionCompatApi21.QueueItem.getQueueId(var0));
      }

      public int describeContents() {
         return 0;
      }

      public MediaDescriptionCompat getDescription() {
         return this.mDescription;
      }

      public long getQueueId() {
         return this.mId;
      }

      public Object getQueueItem() {
         if(this.mItem == null && VERSION.SDK_INT >= 21) {
            this.mItem = MediaSessionCompatApi21.QueueItem.createItem(this.mDescription.getMediaDescription(), this.mId);
            return this.mItem;
         } else {
            return this.mItem;
         }
      }

      public String toString() {
         return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
      }

      public void writeToParcel(Parcel var1, int var2) {
         this.mDescription.writeToParcel(var1, var2);
         var1.writeLong(this.mId);
      }
   }

   static final class ResultReceiverWrapper implements Parcelable {
      public static final Creator CREATOR = new Creator() {
         public MediaSessionCompat.ResultReceiverWrapper createFromParcel(Parcel var1) {
            return new MediaSessionCompat.ResultReceiverWrapper(var1);
         }

         public MediaSessionCompat.ResultReceiverWrapper[] newArray(int var1) {
            return new MediaSessionCompat.ResultReceiverWrapper[var1];
         }
      };
      private ResultReceiver mResultReceiver;

      ResultReceiverWrapper(Parcel var1) {
         this.mResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(var1);
      }

      public ResultReceiverWrapper(ResultReceiver var1) {
         this.mResultReceiver = var1;
      }

      public int describeContents() {
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         this.mResultReceiver.writeToParcel(var1, var2);
      }
   }

   public static final class Token implements Parcelable {
      public static final Creator CREATOR = new Creator() {
         public MediaSessionCompat.Token createFromParcel(Parcel var1) {
            Object var2;
            if(VERSION.SDK_INT >= 21) {
               var2 = var1.readParcelable((ClassLoader)null);
            } else {
               var2 = var1.readStrongBinder();
            }

            return new MediaSessionCompat.Token(var2);
         }

         public MediaSessionCompat.Token[] newArray(int var1) {
            return new MediaSessionCompat.Token[var1];
         }
      };
      private final Object mInner;

      Token(Object var1) {
         this.mInner = var1;
      }

      public static MediaSessionCompat.Token fromToken(Object var0) {
         return var0 != null && VERSION.SDK_INT >= 21?new MediaSessionCompat.Token(MediaSessionCompatApi21.verifyToken(var0)):null;
      }

      public int describeContents() {
         return 0;
      }

      public Object getToken() {
         return this.mInner;
      }

      public void writeToParcel(Parcel var1, int var2) {
         if(VERSION.SDK_INT >= 21) {
            var1.writeParcelable((Parcelable)this.mInner, var2);
         } else {
            var1.writeStrongBinder((IBinder)this.mInner);
         }
      }
   }
}
