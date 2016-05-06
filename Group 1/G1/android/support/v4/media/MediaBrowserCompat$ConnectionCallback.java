package android.support.v4.media;

import android.os.Build$VERSION;

public static class ConnectionCallback
{
    private ConnectionCallbackInternal mConnectionCallbackInternal;
    final Object mConnectionCallbackObj;
    
    public ConnectionCallback() {
        super();
        if (Build$VERSION.SDK_INT >= 21) {
            this.mConnectionCallbackObj = MediaBrowserCompatApi21.createConnectionCallback((MediaBrowserCompatApi21.ConnectionCallback)new StubApi21(this));
            return;
        }
        this.mConnectionCallbackObj = null;
    }
    
    static /* synthetic */ ConnectionCallbackInternal access$200(final ConnectionCallback connectionCallback) {
        return connectionCallback.mConnectionCallbackInternal;
    }
    
    public void onConnected() {
    }
    
    public void onConnectionFailed() {
    }
    
    public void onConnectionSuspended() {
    }
    
    void setInternalConnectionCallback(final ConnectionCallbackInternal mConnectionCallbackInternal) {
        this.mConnectionCallbackInternal = mConnectionCallbackInternal;
    }
}
