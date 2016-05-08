package android.support.v4.media.session;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat$Callback;
import android.support.v4.media.session.MediaControllerCompat$PlaybackInfo;
import android.support.v4.media.session.MediaControllerCompat$TransportControls;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.KeyEvent;
import java.util.List;

interface MediaControllerCompat$MediaControllerImpl {
   void adjustVolume(int var1, int var2);

   boolean dispatchMediaButtonEvent(KeyEvent var1);

   Bundle getExtras();

   long getFlags();

   Object getMediaController();

   MediaMetadataCompat getMetadata();

   String getPackageName();

   MediaControllerCompat$PlaybackInfo getPlaybackInfo();

   PlaybackStateCompat getPlaybackState();

   List<MediaSessionCompat$QueueItem> getQueue();

   CharSequence getQueueTitle();

   int getRatingType();

   PendingIntent getSessionActivity();

   MediaControllerCompat$TransportControls getTransportControls();

   void registerCallback(MediaControllerCompat$Callback var1, Handler var2);

   void sendCommand(String var1, Bundle var2, ResultReceiver var3);

   void setVolumeTo(int var1, int var2);

   void unregisterCallback(MediaControllerCompat$Callback var1);
}
