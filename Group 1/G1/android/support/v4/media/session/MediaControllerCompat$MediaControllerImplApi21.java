package android.support.v4.media.session;

import android.os.Message;
import android.os.Looper;
import android.os.Build$VERSION;
import android.os.IBinder$DeathRecipient;
import android.os.ResultReceiver;
import android.os.Handler;
import android.app.PendingIntent;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.os.Bundle;
import android.view.KeyEvent;
import android.os.RemoteException;
import android.content.Context;

static class MediaControllerImplApi21 implements MediaControllerImpl
{
    protected final Object mControllerObj;
    
    public MediaControllerImplApi21(final Context context, final MediaSessionCompat.Token token) throws RemoteException {
        super();
        this.mControllerObj = MediaControllerCompatApi21.fromToken(context, token.getToken());
        if (this.mControllerObj == null) {
            throw new RemoteException();
        }
    }
    
    public MediaControllerImplApi21(final Context context, final MediaSessionCompat mediaSessionCompat) {
        super();
        this.mControllerObj = MediaControllerCompatApi21.fromToken(context, mediaSessionCompat.getSessionToken().getToken());
    }
    
    @Override
    public void adjustVolume(final int n, final int n2) {
        MediaControllerCompatApi21.adjustVolume(mControllerObj, n, n2);
    }
    
    @Override
    public boolean dispatchMediaButtonEvent(final KeyEvent keyEvent) {
        return MediaControllerCompatApi21.dispatchMediaButtonEvent(mControllerObj, keyEvent);
    }
    
    @Override
    public Bundle getExtras() {
        return MediaControllerCompatApi21.getExtras(mControllerObj);
    }
    
    @Override
    public long getFlags() {
        return MediaControllerCompatApi21.getFlags(mControllerObj);
    }
    
    @Override
    public Object getMediaController() {
        return mControllerObj;
    }
    
    @Override
    public MediaMetadataCompat getMetadata() {
        final Object metadata = MediaControllerCompatApi21.getMetadata(mControllerObj);
        if (metadata != null) {
            return MediaMetadataCompat.fromMediaMetadata(metadata);
        }
        return null;
    }
    
    @Override
    public String getPackageName() {
        return MediaControllerCompatApi21.getPackageName(mControllerObj);
    }
    
    @Override
    public PlaybackInfo getPlaybackInfo() {
        final Object playbackInfo = MediaControllerCompatApi21.getPlaybackInfo(mControllerObj);
        if (playbackInfo != null) {
            return new PlaybackInfo(MediaControllerCompatApi21.PlaybackInfo.getPlaybackType(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getVolumeControl(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getMaxVolume(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getCurrentVolume(playbackInfo));
        }
        return null;
    }
    
    @Override
    public PlaybackStateCompat getPlaybackState() {
        final Object playbackState = MediaControllerCompatApi21.getPlaybackState(mControllerObj);
        if (playbackState != null) {
            return PlaybackStateCompat.fromPlaybackState(playbackState);
        }
        return null;
    }
    
    @Override
    public List<MediaSessionCompat.QueueItem> getQueue() {
        final List<Object> queue = MediaControllerCompatApi21.getQueue(mControllerObj);
        List<MediaSessionCompat.QueueItem> list;
        if (queue == null) {
            list = null;
        }
        else {
            list = new ArrayList<MediaSessionCompat.QueueItem>();
            final Iterator<Object> iterator = queue.iterator();
            while (iterator.hasNext()) {
                list.add(MediaSessionCompat.QueueItem.obtain(iterator.next()));
            }
        }
        return list;
    }
    
    @Override
    public CharSequence getQueueTitle() {
        return MediaControllerCompatApi21.getQueueTitle(mControllerObj);
    }
    
    @Override
    public int getRatingType() {
        return MediaControllerCompatApi21.getRatingType(mControllerObj);
    }
    
    @Override
    public PendingIntent getSessionActivity() {
        return MediaControllerCompatApi21.getSessionActivity(mControllerObj);
    }
    
    @Override
    public TransportControls getTransportControls() {
        final Object transportControls = MediaControllerCompatApi21.getTransportControls(mControllerObj);
        if (transportControls != null) {
            return new TransportControlsApi21(transportControls);
        }
        return null;
    }
    
    @Override
    public void registerCallback(final Callback callback, final Handler handler) {
        MediaControllerCompatApi21.registerCallback(mControllerObj, callback.mCallbackObj, handler);
    }
    
    @Override
    public void sendCommand(final String s, final Bundle bundle, final ResultReceiver resultReceiver) {
        MediaControllerCompatApi21.sendCommand(mControllerObj, s, bundle, resultReceiver);
    }
    
    @Override
    public void setVolumeTo(final int n, final int n2) {
        MediaControllerCompatApi21.setVolumeTo(mControllerObj, n, n2);
    }
    
    @Override
    public void unregisterCallback(final Callback callback) {
        MediaControllerCompatApi21.unregisterCallback(mControllerObj, callback.mCallbackObj);
    }
}
