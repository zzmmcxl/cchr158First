package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.KeyEvent;
import java.util.List;

public interface IMediaSession extends IInterface {
   void adjustVolume(int var1, int var2, String var3) throws RemoteException;

   void fastForward() throws RemoteException;

   Bundle getExtras() throws RemoteException;

   long getFlags() throws RemoteException;

   PendingIntent getLaunchPendingIntent() throws RemoteException;

   MediaMetadataCompat getMetadata() throws RemoteException;

   String getPackageName() throws RemoteException;

   PlaybackStateCompat getPlaybackState() throws RemoteException;

   List<MediaSessionCompat$QueueItem> getQueue() throws RemoteException;

   CharSequence getQueueTitle() throws RemoteException;

   int getRatingType() throws RemoteException;

   String getTag() throws RemoteException;

   ParcelableVolumeInfo getVolumeAttributes() throws RemoteException;

   boolean isTransportControlEnabled() throws RemoteException;

   void next() throws RemoteException;

   void pause() throws RemoteException;

   void play() throws RemoteException;

   void playFromMediaId(String var1, Bundle var2) throws RemoteException;

   void playFromSearch(String var1, Bundle var2) throws RemoteException;

   void playFromUri(Uri var1, Bundle var2) throws RemoteException;

   void previous() throws RemoteException;

   void rate(RatingCompat var1) throws RemoteException;

   void registerCallbackListener(IMediaControllerCallback var1) throws RemoteException;

   void rewind() throws RemoteException;

   void seekTo(long var1) throws RemoteException;

   void sendCommand(String var1, Bundle var2, MediaSessionCompat$ResultReceiverWrapper var3) throws RemoteException;

   void sendCustomAction(String var1, Bundle var2) throws RemoteException;

   boolean sendMediaButton(KeyEvent var1) throws RemoteException;

   void setVolumeTo(int var1, int var2, String var3) throws RemoteException;

   void skipToQueueItem(long var1) throws RemoteException;

   void stop() throws RemoteException;

   void unregisterCallbackListener(IMediaControllerCallback var1) throws RemoteException;
}
