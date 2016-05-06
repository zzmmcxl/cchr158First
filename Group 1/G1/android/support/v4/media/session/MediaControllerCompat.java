package android.support.v4.media.session;

import android.os.Parcelable;
import android.support.v4.media.RatingCompat;
import android.net.Uri;
import android.util.Log;
import android.os.IBinder;
import java.util.Iterator;
import java.util.ArrayList;
import android.os.Message;
import android.os.Looper;
import android.os.IBinder$DeathRecipient;
import android.text.TextUtils;
import android.os.ResultReceiver;
import android.os.Handler;
import android.app.PendingIntent;
import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.os.Bundle;
import android.view.KeyEvent;
import android.os.RemoteException;
import android.os.Build$VERSION;
import android.content.Context;

public final class MediaControllerCompat
{
    private static final String TAG = "MediaControllerCompat";
    private final MediaControllerImpl mImpl;
    private final MediaSessionCompat.Token mToken;
    
    public MediaControllerCompat(final Context context, final MediaSessionCompat.Token mToken) throws RemoteException {
        super();
        if (mToken == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        mToken = mToken;
        if (Build$VERSION.SDK_INT >= 23) {
            mImpl = (MediaControllerImpl)new MediaControllerImplApi23(context, mToken);
            return;
        }
        if (Build$VERSION.SDK_INT >= 21) {
            mImpl = (MediaControllerImpl)new MediaControllerImplApi21(context, mToken);
            return;
        }
        mImpl = (MediaControllerImpl)new MediaControllerImplBase(mToken);
    }
    
    public MediaControllerCompat(final Context context, final MediaSessionCompat mediaSessionCompat) {
        super();
        if (mediaSessionCompat == null) {
            throw new IllegalArgumentException("session must not be null");
        }
        mToken = mediaSessionCompat.getSessionToken();
        if (Build$VERSION.SDK_INT >= 23) {
            mImpl = (MediaControllerImpl)new MediaControllerImplApi23(context, mediaSessionCompat);
            return;
        }
        if (Build$VERSION.SDK_INT >= 21) {
            mImpl = (MediaControllerImpl)new MediaControllerImplApi21(context, mediaSessionCompat);
            return;
        }
        mImpl = (MediaControllerImpl)new MediaControllerImplBase(mToken);
    }
    
    public void adjustVolume(final int n, final int n2) {
        mImpl.adjustVolume(n, n2);
    }
    
    public boolean dispatchMediaButtonEvent(final KeyEvent keyEvent) {
        if (keyEvent == null) {
            throw new IllegalArgumentException("KeyEvent may not be null");
        }
        return mImpl.dispatchMediaButtonEvent(keyEvent);
    }
    
    public Bundle getExtras() {
        return mImpl.getExtras();
    }
    
    public long getFlags() {
        return mImpl.getFlags();
    }
    
    public Object getMediaController() {
        return mImpl.getMediaController();
    }
    
    public MediaMetadataCompat getMetadata() {
        return mImpl.getMetadata();
    }
    
    public String getPackageName() {
        return mImpl.getPackageName();
    }
    
    public PlaybackInfo getPlaybackInfo() {
        return mImpl.getPlaybackInfo();
    }
    
    public PlaybackStateCompat getPlaybackState() {
        return mImpl.getPlaybackState();
    }
    
    public List<MediaSessionCompat.QueueItem> getQueue() {
        return mImpl.getQueue();
    }
    
    public CharSequence getQueueTitle() {
        return mImpl.getQueueTitle();
    }
    
    public int getRatingType() {
        return mImpl.getRatingType();
    }
    
    public PendingIntent getSessionActivity() {
        return mImpl.getSessionActivity();
    }
    
    public MediaSessionCompat.Token getSessionToken() {
        return mToken;
    }
    
    public TransportControls getTransportControls() {
        return mImpl.getTransportControls();
    }
    
    public void registerCallback(final Callback callback) {
        this.registerCallback(callback, null);
    }
    
    public void registerCallback(final Callback callback, Handler handler) {
        if (callback == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        if (handler == null) {
            handler = new Handler();
        }
        mImpl.registerCallback(callback, handler);
    }
    
    public void sendCommand(final String s, final Bundle bundle, final ResultReceiver resultReceiver) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("command cannot be null or empty");
        }
        mImpl.sendCommand(s, bundle, resultReceiver);
    }
    
    public void setVolumeTo(final int n, final int n2) {
        mImpl.setVolumeTo(n, n2);
    }
    
    public void unregisterCallback(final Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        mImpl.unregisterCallback(callback);
    }
}
