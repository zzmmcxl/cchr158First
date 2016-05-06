package android.support.v4.media.session;

import android.os.Message;
import android.os.Looper;
import android.os.Build$VERSION;
import android.os.ResultReceiver;
import android.os.IBinder$DeathRecipient;
import android.os.Handler;
import android.app.PendingIntent;
import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.os.Bundle;
import android.view.KeyEvent;
import android.os.RemoteException;
import android.util.Log;
import android.os.IBinder;

static class MediaControllerImplBase implements MediaControllerImpl
{
    private IMediaSession mBinder;
    private MediaSessionCompat.Token mToken;
    private TransportControls mTransportControls;
    
    public MediaControllerImplBase(final MediaSessionCompat.Token mToken) {
        super();
        this.mToken = mToken;
        this.mBinder = IMediaSession.Stub.asInterface((IBinder)mToken.getToken());
    }
    
    @Override
    public void adjustVolume(final int n, final int n2) {
        try {
            mBinder.adjustVolume(n, n2, null);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in adjustVolume. " + ex);
        }
    }
    
    @Override
    public boolean dispatchMediaButtonEvent(final KeyEvent keyEvent) {
        if (keyEvent == null) {
            throw new IllegalArgumentException("event may not be null.");
        }
        try {
            mBinder.sendMediaButton(keyEvent);
            return false;
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent. " + ex);
            return false;
        }
    }
    
    @Override
    public Bundle getExtras() {
        try {
            return mBinder.getExtras();
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in getExtras. " + ex);
            return null;
        }
    }
    
    @Override
    public long getFlags() {
        try {
            return mBinder.getFlags();
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in getFlags. " + ex);
            return 0L;
        }
    }
    
    @Override
    public Object getMediaController() {
        return null;
    }
    
    @Override
    public MediaMetadataCompat getMetadata() {
        try {
            return mBinder.getMetadata();
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in getMetadata. " + ex);
            return null;
        }
    }
    
    @Override
    public String getPackageName() {
        try {
            return mBinder.getPackageName();
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in getPackageName. " + ex);
            return null;
        }
    }
    
    @Override
    public PlaybackInfo getPlaybackInfo() {
        try {
            final ParcelableVolumeInfo volumeAttributes = mBinder.getVolumeAttributes();
            return new PlaybackInfo(volumeAttributes.volumeType, volumeAttributes.audioStream, volumeAttributes.controlType, volumeAttributes.maxVolume, volumeAttributes.currentVolume);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in getPlaybackInfo. " + ex);
            return null;
        }
    }
    
    @Override
    public PlaybackStateCompat getPlaybackState() {
        try {
            return mBinder.getPlaybackState();
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in getPlaybackState. " + ex);
            return null;
        }
    }
    
    @Override
    public List<MediaSessionCompat.QueueItem> getQueue() {
        try {
            return mBinder.getQueue();
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in getQueue. " + ex);
            return null;
        }
    }
    
    @Override
    public CharSequence getQueueTitle() {
        try {
            return mBinder.getQueueTitle();
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in getQueueTitle. " + ex);
            return null;
        }
    }
    
    @Override
    public int getRatingType() {
        try {
            return mBinder.getRatingType();
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in getRatingType. " + ex);
            return 0;
        }
    }
    
    @Override
    public PendingIntent getSessionActivity() {
        try {
            return mBinder.getLaunchPendingIntent();
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in getSessionActivity. " + ex);
            return null;
        }
    }
    
    @Override
    public TransportControls getTransportControls() {
        if (mTransportControls == null) {
            mTransportControls = new TransportControlsBase(mBinder);
        }
        return mTransportControls;
    }
    
    @Override
    public void registerCallback(final Callback callback, final Handler handler) {
        if (callback == null) {
            throw new IllegalArgumentException("callback may not be null.");
        }
        try {
            mBinder.asBinder().linkToDeath((IBinder$DeathRecipient)callback, 0);
            mBinder.registerCallbackListener((IMediaControllerCallback)callback.mCallbackObj);
            callback.setHandler(handler);
            callback.mRegistered = true;
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in registerCallback. " + ex);
            callback.onSessionDestroyed();
        }
    }
    
    @Override
    public void sendCommand(final String s, final Bundle bundle, final ResultReceiver resultReceiver) {
        try {
            mBinder.sendCommand(s, bundle, new MediaSessionCompat.ResultReceiverWrapper(resultReceiver));
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in sendCommand. " + ex);
        }
    }
    
    @Override
    public void setVolumeTo(final int n, final int n2) {
        try {
            mBinder.setVolumeTo(n, n2, null);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in setVolumeTo. " + ex);
        }
    }
    
    @Override
    public void unregisterCallback(final Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("callback may not be null.");
        }
        try {
            mBinder.unregisterCallbackListener((IMediaControllerCallback)callback.mCallbackObj);
            mBinder.asBinder().unlinkToDeath((IBinder$DeathRecipient)callback, 0);
            callback.mRegistered = false;
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in unregisterCallback. " + ex);
        }
    }
}
