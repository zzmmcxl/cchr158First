package android.support.v4.media;

import android.media.browse.MediaBrowser$ConnectionCallback;

static class ConnectionCallbackProxy<T extends ConnectionCallback> extends MediaBrowser$ConnectionCallback
{
    protected final T mConnectionCallback;
    
    public ConnectionCallbackProxy(final T mConnectionCallback) {
        super();
        this.mConnectionCallback = mConnectionCallback;
    }
    
    public void onConnected() {
        ((ConnectionCallback)mConnectionCallback).onConnected();
    }
    
    public void onConnectionFailed() {
        ((ConnectionCallback)mConnectionCallback).onConnectionFailed();
    }
    
    public void onConnectionSuspended() {
        ((ConnectionCallback)mConnectionCallback).onConnectionSuspended();
    }
}
