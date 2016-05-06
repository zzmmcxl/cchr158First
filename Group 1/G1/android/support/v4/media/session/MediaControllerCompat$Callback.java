package android.support.v4.media.session;

import android.os.RemoteException;
import android.os.Message;
import android.os.Looper;
import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Build$VERSION;
import android.os.IBinder$DeathRecipient;

public abstract static class Callback implements IBinder$DeathRecipient
{
    private final Object mCallbackObj;
    private MessageHandler mHandler;
    private boolean mRegistered;
    
    public Callback() {
        super();
        this.mRegistered = false;
        if (Build$VERSION.SDK_INT >= 21) {
            this.mCallbackObj = MediaControllerCompatApi21.createCallback((MediaControllerCompatApi21.Callback)new StubApi21(this));
            return;
        }
        this.mCallbackObj = new StubCompat(this);
    }
    
    static /* synthetic */ MessageHandler access$200(final Callback callback) {
        return callback.mHandler;
    }
    
    static /* synthetic */ boolean access$300(final Callback callback) {
        return callback.mRegistered;
    }
    
    static /* synthetic */ boolean access$302(final Callback callback, final boolean mRegistered) {
        return callback.mRegistered = mRegistered;
    }
    
    static /* synthetic */ Object access$400(final Callback callback) {
        return callback.mCallbackObj;
    }
    
    static /* synthetic */ void access$500(final Callback callback, final Handler handler) {
        callback.setHandler(handler);
    }
    
    private void setHandler(final Handler handler) {
        mHandler = new MessageHandler(handler.getLooper());
    }
    
    public void binderDied() {
        this.onSessionDestroyed();
    }
    
    public void onAudioInfoChanged(final PlaybackInfo playbackInfo) {
    }
    
    public void onExtrasChanged(final Bundle bundle) {
    }
    
    public void onMetadataChanged(final MediaMetadataCompat mediaMetadataCompat) {
    }
    
    public void onPlaybackStateChanged(final PlaybackStateCompat playbackStateCompat) {
    }
    
    public void onQueueChanged(final List<MediaSessionCompat.QueueItem> list) {
    }
    
    public void onQueueTitleChanged(final CharSequence charSequence) {
    }
    
    public void onSessionDestroyed() {
    }
    
    public void onSessionEvent(final String s, final Bundle bundle) {
    }
}
