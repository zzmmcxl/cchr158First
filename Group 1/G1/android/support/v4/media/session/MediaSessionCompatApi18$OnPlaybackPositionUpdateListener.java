package android.support.v4.media.session;

import android.media.RemoteControlClient$OnPlaybackPositionUpdateListener;

static class OnPlaybackPositionUpdateListener<T extends Callback> implements RemoteControlClient$OnPlaybackPositionUpdateListener
{
    protected final T mCallback;
    
    public OnPlaybackPositionUpdateListener(final T mCallback) {
        super();
        this.mCallback = mCallback;
    }
    
    public void onPlaybackPositionUpdate(final long n) {
        ((Callback)mCallback).onSeekTo(n);
    }
}
