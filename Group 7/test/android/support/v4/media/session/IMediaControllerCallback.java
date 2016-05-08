package android.support.v4.media.session;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import java.util.List;

public interface IMediaControllerCallback extends IInterface {
   void onEvent(String var1, Bundle var2) throws RemoteException;

   void onExtrasChanged(Bundle var1) throws RemoteException;

   void onMetadataChanged(MediaMetadataCompat var1) throws RemoteException;

   void onPlaybackStateChanged(PlaybackStateCompat var1) throws RemoteException;

   void onQueueChanged(List<MediaSessionCompat$QueueItem> var1) throws RemoteException;

   void onQueueTitleChanged(CharSequence var1) throws RemoteException;

   void onSessionDestroyed() throws RemoteException;

   void onVolumeInfoChanged(ParcelableVolumeInfo var1) throws RemoteException;
}
