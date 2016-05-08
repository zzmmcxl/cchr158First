package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Build.VERSION;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.session.MediaSessionCompat$Callback;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.MediaSessionCompatApi21;
import android.support.v4.media.session.MediaSessionCompatApi22;
import android.support.v4.media.session.PlaybackStateCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MediaSessionCompat$MediaSessionImplApi21 implements MediaSessionCompat$MediaSessionImpl {
   private PendingIntent mMediaButtonIntent;
   private final Object mSessionObj;
   private final MediaSessionCompat$Token mToken;

   public MediaSessionCompat$MediaSessionImplApi21(Context var1, String var2) {
      this.mSessionObj = MediaSessionCompatApi21.createSession(var1, var2);
      this.mToken = new MediaSessionCompat$Token(MediaSessionCompatApi21.getSessionToken(this.mSessionObj));
   }

   public MediaSessionCompat$MediaSessionImplApi21(Object var1) {
      this.mSessionObj = MediaSessionCompatApi21.verifySession(var1);
      this.mToken = new MediaSessionCompat$Token(MediaSessionCompatApi21.getSessionToken(this.mSessionObj));
   }

   public Object getMediaSession() {
      return this.mSessionObj;
   }

   public Object getRemoteControlClient() {
      return null;
   }

   public MediaSessionCompat$Token getSessionToken() {
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

   public void setCallback(MediaSessionCompat$Callback var1, Handler var2) {
      Object var3 = this.mSessionObj;
      Object var4;
      if(var1 == null) {
         var4 = null;
      } else {
         var4 = var1.mCallbackObj;
      }

      MediaSessionCompatApi21.setCallback(var3, var4, var2);
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
      Object var2 = this.mSessionObj;
      Object var3;
      if(var1 == null) {
         var3 = null;
      } else {
         var3 = var1.getMediaMetadata();
      }

      MediaSessionCompatApi21.setMetadata(var2, var3);
   }

   public void setPlaybackState(PlaybackStateCompat var1) {
      Object var2 = this.mSessionObj;
      Object var3;
      if(var1 == null) {
         var3 = null;
      } else {
         var3 = var1.getPlaybackState();
      }

      MediaSessionCompatApi21.setPlaybackState(var2, var3);
   }

   public void setPlaybackToLocal(int var1) {
      MediaSessionCompatApi21.setPlaybackToLocal(this.mSessionObj, var1);
   }

   public void setPlaybackToRemote(VolumeProviderCompat var1) {
      MediaSessionCompatApi21.setPlaybackToRemote(this.mSessionObj, var1.getVolumeProvider());
   }

   public void setQueue(List<MediaSessionCompat$QueueItem> var1) {
      ArrayList var2 = null;
      if(var1 != null) {
         ArrayList var3 = new ArrayList();
         Iterator var4 = var1.iterator();

         while(true) {
            var2 = var3;
            if(!var4.hasNext()) {
               break;
            }

            var3.add(((MediaSessionCompat$QueueItem)var4.next()).getQueueItem());
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
