package android.support.v4.media.session;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.session.MediaSessionCompat$Callback;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.PlaybackStateCompat;
import java.util.List;

interface MediaSessionCompat$MediaSessionImpl {
   Object getMediaSession();

   Object getRemoteControlClient();

   MediaSessionCompat$Token getSessionToken();

   boolean isActive();

   void release();

   void sendSessionEvent(String var1, Bundle var2);

   void setActive(boolean var1);

   void setCallback(MediaSessionCompat$Callback var1, Handler var2);

   void setExtras(Bundle var1);

   void setFlags(int var1);

   void setMediaButtonReceiver(PendingIntent var1);

   void setMetadata(MediaMetadataCompat var1);

   void setPlaybackState(PlaybackStateCompat var1);

   void setPlaybackToLocal(int var1);

   void setPlaybackToRemote(VolumeProviderCompat var1);

   void setQueue(List<MediaSessionCompat$QueueItem> var1);

   void setQueueTitle(CharSequence var1);

   void setRatingType(int var1);

   void setSessionActivity(PendingIntent var1);
}
