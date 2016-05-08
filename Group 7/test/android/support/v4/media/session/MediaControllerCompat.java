package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.Build.VERSION;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat$Callback;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi23;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplBase;
import android.support.v4.media.session.MediaControllerCompat$PlaybackInfo;
import android.support.v4.media.session.MediaControllerCompat$TransportControls;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.List;

public final class MediaControllerCompat {
   private static final String TAG = "MediaControllerCompat";
   private final MediaControllerCompat$MediaControllerImpl mImpl;
   private final MediaSessionCompat$Token mToken;

   public MediaControllerCompat(Context var1, MediaSessionCompat$Token var2) throws RemoteException {
      if(var2 == null) {
         throw new IllegalArgumentException("sessionToken must not be null");
      } else {
         this.mToken = var2;
         if(VERSION.SDK_INT >= 23) {
            this.mImpl = new MediaControllerCompat$MediaControllerImplApi23(var1, var2);
         } else if(VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaControllerCompat$MediaControllerImplApi21(var1, var2);
         } else {
            this.mImpl = new MediaControllerCompat$MediaControllerImplBase(this.mToken);
         }
      }
   }

   public MediaControllerCompat(Context var1, MediaSessionCompat var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("session must not be null");
      } else {
         this.mToken = var2.getSessionToken();
         if(VERSION.SDK_INT >= 23) {
            this.mImpl = new MediaControllerCompat$MediaControllerImplApi23(var1, var2);
         } else if(VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaControllerCompat$MediaControllerImplApi21(var1, var2);
         } else {
            this.mImpl = new MediaControllerCompat$MediaControllerImplBase(this.mToken);
         }
      }
   }

   public void adjustVolume(int var1, int var2) {
      this.mImpl.adjustVolume(var1, var2);
   }

   public boolean dispatchMediaButtonEvent(KeyEvent var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("KeyEvent may not be null");
      } else {
         return this.mImpl.dispatchMediaButtonEvent(var1);
      }
   }

   public Bundle getExtras() {
      return this.mImpl.getExtras();
   }

   public long getFlags() {
      return this.mImpl.getFlags();
   }

   public Object getMediaController() {
      return this.mImpl.getMediaController();
   }

   public MediaMetadataCompat getMetadata() {
      return this.mImpl.getMetadata();
   }

   public String getPackageName() {
      return this.mImpl.getPackageName();
   }

   public MediaControllerCompat$PlaybackInfo getPlaybackInfo() {
      return this.mImpl.getPlaybackInfo();
   }

   public PlaybackStateCompat getPlaybackState() {
      return this.mImpl.getPlaybackState();
   }

   public List<MediaSessionCompat$QueueItem> getQueue() {
      return this.mImpl.getQueue();
   }

   public CharSequence getQueueTitle() {
      return this.mImpl.getQueueTitle();
   }

   public int getRatingType() {
      return this.mImpl.getRatingType();
   }

   public PendingIntent getSessionActivity() {
      return this.mImpl.getSessionActivity();
   }

   public MediaSessionCompat$Token getSessionToken() {
      return this.mToken;
   }

   public MediaControllerCompat$TransportControls getTransportControls() {
      return this.mImpl.getTransportControls();
   }

   public void registerCallback(MediaControllerCompat$Callback var1) {
      this.registerCallback(var1, (Handler)null);
   }

   public void registerCallback(MediaControllerCompat$Callback var1, Handler var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("callback cannot be null");
      } else {
         Handler var3 = var2;
         if(var2 == null) {
            var3 = new Handler();
         }

         this.mImpl.registerCallback(var1, var3);
      }
   }

   public void sendCommand(String var1, Bundle var2, ResultReceiver var3) {
      if(TextUtils.isEmpty(var1)) {
         throw new IllegalArgumentException("command cannot be null or empty");
      } else {
         this.mImpl.sendCommand(var1, var2, var3);
      }
   }

   public void setVolumeTo(int var1, int var2) {
      this.mImpl.setVolumeTo(var1, var2);
   }

   public void unregisterCallback(MediaControllerCompat$Callback var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("callback cannot be null");
      } else {
         this.mImpl.unregisterCallback(var1);
      }
   }
}
