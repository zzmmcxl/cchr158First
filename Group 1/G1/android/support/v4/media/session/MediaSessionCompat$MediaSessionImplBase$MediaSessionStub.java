package android.support.v4.media.session;

import android.os.Parcel;
import android.os.ResultReceiver;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.os.IInterface;
import android.support.v4.media.RatingCompat;
import android.net.Uri;
import android.support.v4.media.VolumeProviderCompat;
import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.RemoteException;

class MediaSessionStub extends Stub
{
    final /* synthetic */ MediaSessionImplBase this$0;
    
    MediaSessionStub(final MediaSessionImplBase this$0) {
        this$0 = this$0;
        super();
    }
    
    public void adjustVolume(final int n, final int n2, final String s) {
        MediaSessionImplBase.access$1700(this$0, n, n2);
    }
    
    public void fastForward() throws RemoteException {
        MediaSessionImplBase.access$1900(this$0, 9);
    }
    
    public Bundle getExtras() {
        synchronized (MediaSessionImplBase.access$1400(this$0)) {
            return MediaSessionImplBase.access$2500(this$0);
        }
    }
    
    public long getFlags() {
        synchronized (MediaSessionImplBase.access$1400(this$0)) {
            return MediaSessionImplBase.access$900(this$0);
        }
    }
    
    public PendingIntent getLaunchPendingIntent() {
        synchronized (MediaSessionImplBase.access$1400(this$0)) {
            return MediaSessionImplBase.access$1500(this$0);
        }
    }
    
    public MediaMetadataCompat getMetadata() {
        return MediaSessionImplBase.access$2100(this$0);
    }
    
    public String getPackageName() {
        return MediaSessionImplBase.access$1200(this$0);
    }
    
    public PlaybackStateCompat getPlaybackState() {
        return MediaSessionImplBase.access$2200(this$0);
    }
    
    public List<QueueItem> getQueue() {
        synchronized (MediaSessionImplBase.access$1400(this$0)) {
            return (List<QueueItem>)MediaSessionImplBase.access$2300(this$0);
        }
    }
    
    public CharSequence getQueueTitle() {
        return MediaSessionImplBase.access$2400(this$0);
    }
    
    public int getRatingType() {
        return MediaSessionImplBase.access$2600(this$0);
    }
    
    public String getTag() {
        return MediaSessionImplBase.access$1300(this$0);
    }
    
    public ParcelableVolumeInfo getVolumeAttributes() {
        synchronized (MediaSessionImplBase.access$1400(this$0)) {
            final int access$400 = MediaSessionImplBase.access$400(this$0);
            final int access$401 = MediaSessionImplBase.access$500(this$0);
            final VolumeProviderCompat access$402 = MediaSessionImplBase.access$300(this$0);
            int volumeControl;
            int n;
            int n2;
            if (access$400 == 2) {
                volumeControl = access$402.getVolumeControl();
                n = access$402.getMaxVolume();
                n2 = access$402.getCurrentVolume();
            }
            else {
                volumeControl = 2;
                n = MediaSessionImplBase.access$1600(this$0).getStreamMaxVolume(access$401);
                n2 = MediaSessionImplBase.access$1600(this$0).getStreamVolume(access$401);
            }
            // monitorexit(MediaSessionImplBase.access$1400(this.this$0))
            return new ParcelableVolumeInfo(access$400, access$401, volumeControl, n, n2);
        }
    }
    
    public boolean isTransportControlEnabled() {
        return (0x2 & MediaSessionImplBase.access$900(this$0)) != 0x0;
    }
    
    public void next() throws RemoteException {
        MediaSessionImplBase.access$1900(this$0, 7);
    }
    
    public void pause() throws RemoteException {
        MediaSessionImplBase.access$1900(this$0, 5);
    }
    
    public void play() throws RemoteException {
        MediaSessionImplBase.access$1900(this$0, 1);
    }
    
    public void playFromMediaId(final String s, final Bundle bundle) throws RemoteException {
        MediaSessionImplBase.access$2000(this$0, 2, s, bundle);
    }
    
    public void playFromSearch(final String s, final Bundle bundle) throws RemoteException {
        MediaSessionImplBase.access$2000(this$0, 3, s, bundle);
    }
    
    public void playFromUri(final Uri uri, final Bundle bundle) throws RemoteException {
        MediaSessionImplBase.access$2000(this$0, 18, uri, bundle);
    }
    
    public void previous() throws RemoteException {
        MediaSessionImplBase.access$1900(this$0, 8);
    }
    
    public void rate(final RatingCompat ratingCompat) throws RemoteException {
        MediaSessionImplBase.access$700(this$0, 12, ratingCompat);
    }
    
    public void registerCallbackListener(final IMediaControllerCallback mediaControllerCallback) {
        Label_0017: {
            if (!MediaSessionImplBase.access$1000(this$0)) {
                break Label_0017;
            }
            try {
                mediaControllerCallback.onSessionDestroyed();
                return;
                MediaSessionImplBase.access$1100(this$0).register((IInterface)mediaControllerCallback);
            }
            catch (Exception ex) {}
        }
    }
    
    public void rewind() throws RemoteException {
        MediaSessionImplBase.access$1900(this$0, 10);
    }
    
    public void seekTo(final long n) throws RemoteException {
        MediaSessionImplBase.access$700(this$0, 11, n);
    }
    
    public void sendCommand(final String s, final Bundle bundle, final ResultReceiverWrapper resultReceiverWrapper) {
        MediaSessionImplBase.access$700(this$0, 15, new Command(s, bundle, resultReceiverWrapper.mResultReceiver));
    }
    
    public void sendCustomAction(final String s, final Bundle bundle) throws RemoteException {
        MediaSessionImplBase.access$2000(this$0, 13, s, bundle);
    }
    
    public boolean sendMediaButton(final KeyEvent keyEvent) {
        final boolean b = (0x1 & MediaSessionImplBase.access$900(this$0)) != 0x0;
        if (b) {
            MediaSessionImplBase.access$700(this$0, 14, keyEvent);
        }
        return b;
    }
    
    public void setVolumeTo(final int n, final int n2, final String s) {
        MediaSessionImplBase.access$1800(this$0, n, n2);
    }
    
    public void skipToQueueItem(final long n) {
        MediaSessionImplBase.access$700(this$0, 4, n);
    }
    
    public void stop() throws RemoteException {
        MediaSessionImplBase.access$1900(this$0, 6);
    }
    
    public void unregisterCallbackListener(final IMediaControllerCallback mediaControllerCallback) {
        MediaSessionImplBase.access$1100(this$0).unregister((IInterface)mediaControllerCallback);
    }
}
