package android.support.v4.media.session;

import android.os.Parcelable$Creator;
import android.text.TextUtils;
import android.os.Parcel;
import android.os.IBinder;
import android.os.Binder;
import android.view.KeyEvent;
import android.support.v4.media.RatingCompat;
import android.net.Uri;
import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.IInterface;

public interface IMediaSession extends IInterface
{
    void adjustVolume(final int p0, final int p1, final String p2) throws RemoteException;
    
    void fastForward() throws RemoteException;
    
    Bundle getExtras() throws RemoteException;
    
    long getFlags() throws RemoteException;
    
    PendingIntent getLaunchPendingIntent() throws RemoteException;
    
    MediaMetadataCompat getMetadata() throws RemoteException;
    
    String getPackageName() throws RemoteException;
    
    PlaybackStateCompat getPlaybackState() throws RemoteException;
    
    List<MediaSessionCompat.QueueItem> getQueue() throws RemoteException;
    
    CharSequence getQueueTitle() throws RemoteException;
    
    int getRatingType() throws RemoteException;
    
    String getTag() throws RemoteException;
    
    ParcelableVolumeInfo getVolumeAttributes() throws RemoteException;
    
    boolean isTransportControlEnabled() throws RemoteException;
    
    void next() throws RemoteException;
    
    void pause() throws RemoteException;
    
    void play() throws RemoteException;
    
    void playFromMediaId(final String p0, final Bundle p1) throws RemoteException;
    
    void playFromSearch(final String p0, final Bundle p1) throws RemoteException;
    
    void playFromUri(final Uri p0, final Bundle p1) throws RemoteException;
    
    void previous() throws RemoteException;
    
    void rate(final RatingCompat p0) throws RemoteException;
    
    void registerCallbackListener(final IMediaControllerCallback p0) throws RemoteException;
    
    void rewind() throws RemoteException;
    
    void seekTo(final long p0) throws RemoteException;
    
    void sendCommand(final String p0, final Bundle p1, final MediaSessionCompat.ResultReceiverWrapper p2) throws RemoteException;
    
    void sendCustomAction(final String p0, final Bundle p1) throws RemoteException;
    
    boolean sendMediaButton(final KeyEvent p0) throws RemoteException;
    
    void setVolumeTo(final int p0, final int p1, final String p2) throws RemoteException;
    
    void skipToQueueItem(final long p0) throws RemoteException;
    
    void stop() throws RemoteException;
    
    void unregisterCallbackListener(final IMediaControllerCallback p0) throws RemoteException;
}
