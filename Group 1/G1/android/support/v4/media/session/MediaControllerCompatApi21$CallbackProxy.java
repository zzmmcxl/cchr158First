package android.support.v4.media.session;

import android.os.Bundle;
import android.media.session.PlaybackState;
import android.media.MediaMetadata;
import android.media.session.MediaController$Callback;

static class CallbackProxy<T extends Callback> extends MediaController$Callback
{
    protected final T mCallback;
    
    public CallbackProxy(final T mCallback) {
        super();
        this.mCallback = mCallback;
    }
    
    public void onMetadataChanged(final MediaMetadata mediaMetadata) {
        ((Callback)mCallback).onMetadataChanged(mediaMetadata);
    }
    
    public void onPlaybackStateChanged(final PlaybackState playbackState) {
        ((Callback)mCallback).onPlaybackStateChanged(playbackState);
    }
    
    public void onSessionDestroyed() {
        ((Callback)mCallback).onSessionDestroyed();
    }
    
    public void onSessionEvent(final String s, final Bundle bundle) {
        ((Callback)mCallback).onSessionEvent(s, bundle);
    }
}
