package android.support.v4.media.session;

import android.text.TextUtils;
import android.os.Parcelable$Creator;
import android.os.Parcel;
import android.os.IBinder;
import android.os.Binder;
import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.os.RemoteException;
import android.os.Bundle;
import android.os.IInterface;

public interface IMediaControllerCallback extends IInterface
{
    void onEvent(final String p0, final Bundle p1) throws RemoteException;
    
    void onExtrasChanged(final Bundle p0) throws RemoteException;
    
    void onMetadataChanged(final MediaMetadataCompat p0) throws RemoteException;
    
    void onPlaybackStateChanged(final PlaybackStateCompat p0) throws RemoteException;
    
    void onQueueChanged(final List<MediaSessionCompat.QueueItem> p0) throws RemoteException;
    
    void onQueueTitleChanged(final CharSequence p0) throws RemoteException;
    
    void onSessionDestroyed() throws RemoteException;
    
    void onVolumeInfoChanged(final ParcelableVolumeInfo p0) throws RemoteException;
}
