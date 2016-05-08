package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Build.VERSION;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat$Callback;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase;
import android.support.v4.media.session.MediaSessionCompat$OnActiveChangeListener;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MediaSessionCompat {
   public static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
   public static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
   public static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
   public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
   public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
   private static final String TAG = "MediaSessionCompat";
   private final ArrayList<MediaSessionCompat$OnActiveChangeListener> mActiveListeners;
   private final MediaControllerCompat mController;
   private final MediaSessionCompat$MediaSessionImpl mImpl;

   private MediaSessionCompat(Context var1, MediaSessionCompat$MediaSessionImpl var2) {
      this.mActiveListeners = new ArrayList();
      this.mImpl = var2;
      this.mController = new MediaControllerCompat(var1, this);
   }

   public MediaSessionCompat(Context var1, String var2) {
      this(var1, var2, (ComponentName)null, (PendingIntent)null);
   }

   public MediaSessionCompat(Context var1, String var2, ComponentName var3, PendingIntent var4) {
      this.mActiveListeners = new ArrayList();
      if(var1 == null) {
         throw new IllegalArgumentException("context must not be null");
      } else if(TextUtils.isEmpty(var2)) {
         throw new IllegalArgumentException("tag must not be null or empty");
      } else {
         ComponentName var5 = var3;
         if(var3 == null) {
            Intent var10 = new Intent("android.intent.action.MEDIA_BUTTON");
            var10.setPackage(var1.getPackageName());
            List var6 = var1.getPackageManager().queryBroadcastReceivers(var10, 0);
            if(var6.size() == 1) {
               ResolveInfo var7 = (ResolveInfo)var6.get(0);
               var5 = new ComponentName(var7.activityInfo.packageName, var7.activityInfo.name);
            } else {
               var5 = var3;
               if(var6.size() > 1) {
                  Log.w("MediaSessionCompat", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, using null. Provide a specific ComponentName to use as this session\'s media button receiver");
                  var5 = var3;
               }
            }
         }

         PendingIntent var8 = var4;
         if(var5 != null) {
            var8 = var4;
            if(var4 == null) {
               Intent var9 = new Intent("android.intent.action.MEDIA_BUTTON");
               var9.setComponent(var5);
               var8 = PendingIntent.getBroadcast(var1, 0, var9, 0);
            }
         }

         if(VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaSessionCompat$MediaSessionImplApi21(var1, var2);
            this.mImpl.setMediaButtonReceiver(var8);
         } else {
            this.mImpl = new MediaSessionCompat$MediaSessionImplBase(var1, var2, var5, var8);
         }

         this.mController = new MediaControllerCompat(var1, this);
      }
   }

   public static MediaSessionCompat obtain(Context var0, Object var1) {
      return new MediaSessionCompat(var0, new MediaSessionCompat$MediaSessionImplApi21(var1));
   }

   public void addOnActiveChangeListener(MediaSessionCompat$OnActiveChangeListener var1) {
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

   public MediaSessionCompat$Token getSessionToken() {
      return this.mImpl.getSessionToken();
   }

   public boolean isActive() {
      return this.mImpl.isActive();
   }

   public void release() {
      this.mImpl.release();
   }

   public void removeOnActiveChangeListener(MediaSessionCompat$OnActiveChangeListener var1) {
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
         ((MediaSessionCompat$OnActiveChangeListener)var2.next()).onActiveChanged();
      }

   }

   public void setCallback(MediaSessionCompat$Callback var1) {
      this.setCallback(var1, (Handler)null);
   }

   public void setCallback(MediaSessionCompat$Callback var1, Handler var2) {
      MediaSessionCompat$MediaSessionImpl var3 = this.mImpl;
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

   public void setQueue(List<MediaSessionCompat$QueueItem> var1) {
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
}
