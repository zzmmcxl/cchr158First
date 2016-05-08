package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.media.MediaMetadata;
import android.media.VolumeProvider;
import android.media.AudioAttributes.Builder;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.media.session.MediaSession.Callback;
import android.media.session.MediaSession.QueueItem;
import android.media.session.MediaSession.Token;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompatApi21$Callback;
import android.support.v4.media.session.MediaSessionCompatApi21$CallbackProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MediaSessionCompatApi21 {
   public static Object createCallback(MediaSessionCompatApi21$Callback var0) {
      return new MediaSessionCompatApi21$CallbackProxy(var0);
   }

   public static Object createSession(Context var0, String var1) {
      return new MediaSession(var0, var1);
   }

   public static Parcelable getSessionToken(Object var0) {
      return ((MediaSession)var0).getSessionToken();
   }

   public static boolean isActive(Object var0) {
      return ((MediaSession)var0).isActive();
   }

   public static void release(Object var0) {
      ((MediaSession)var0).release();
   }

   public static void sendSessionEvent(Object var0, String var1, Bundle var2) {
      ((MediaSession)var0).sendSessionEvent(var1, var2);
   }

   public static void setActive(Object var0, boolean var1) {
      ((MediaSession)var0).setActive(var1);
   }

   public static void setCallback(Object var0, Object var1, Handler var2) {
      ((MediaSession)var0).setCallback((Callback)var1, var2);
   }

   public static void setExtras(Object var0, Bundle var1) {
      ((MediaSession)var0).setExtras(var1);
   }

   public static void setFlags(Object var0, int var1) {
      ((MediaSession)var0).setFlags(var1);
   }

   public static void setMediaButtonReceiver(Object var0, PendingIntent var1) {
      ((MediaSession)var0).setMediaButtonReceiver(var1);
   }

   public static void setMetadata(Object var0, Object var1) {
      ((MediaSession)var0).setMetadata((MediaMetadata)var1);
   }

   public static void setPlaybackState(Object var0, Object var1) {
      ((MediaSession)var0).setPlaybackState((PlaybackState)var1);
   }

   public static void setPlaybackToLocal(Object var0, int var1) {
      Builder var2 = new Builder();
      var2.setLegacyStreamType(var1);
      ((MediaSession)var0).setPlaybackToLocal(var2.build());
   }

   public static void setPlaybackToRemote(Object var0, Object var1) {
      ((MediaSession)var0).setPlaybackToRemote((VolumeProvider)var1);
   }

   public static void setQueue(Object var0, List<Object> var1) {
      if(var1 == null) {
         ((MediaSession)var0).setQueue((List)null);
      } else {
         ArrayList var2 = new ArrayList();
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            var2.add((QueueItem)var3.next());
         }

         ((MediaSession)var0).setQueue(var2);
      }
   }

   public static void setQueueTitle(Object var0, CharSequence var1) {
      ((MediaSession)var0).setQueueTitle(var1);
   }

   public static void setSessionActivity(Object var0, PendingIntent var1) {
      ((MediaSession)var0).setSessionActivity(var1);
   }

   public static Object verifySession(Object var0) {
      if(var0 instanceof MediaSession) {
         return var0;
      } else {
         throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
      }
   }

   public static Object verifyToken(Object var0) {
      if(var0 instanceof Token) {
         return var0;
      } else {
         throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
      }
   }
}
