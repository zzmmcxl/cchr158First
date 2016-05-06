package android.support.v4.media;

private class StubApi21 implements MediaBrowserCompatApi21.ConnectionCallback
{
    final /* synthetic */ MediaBrowserCompat.ConnectionCallback this$0;
    
    private StubApi21(final MediaBrowserCompat.ConnectionCallback this$0) {
        this$0 = this$0;
        super();
    }
    
    StubApi21(final MediaBrowserCompat.ConnectionCallback connectionCallback, final MediaBrowserCompat$1 object) {
        this(connectionCallback);
    }
    
    @Override
    public void onConnected() {
        if (MediaBrowserCompat.ConnectionCallback.access$200(this$0) != null) {
            MediaBrowserCompat.ConnectionCallback.access$200(this$0).onConnected();
        }
        this$0.onConnected();
    }
    
    @Override
    public void onConnectionFailed() {
        if (MediaBrowserCompat.ConnectionCallback.access$200(this$0) != null) {
            MediaBrowserCompat.ConnectionCallback.access$200(this$0).onConnectionFailed();
        }
        this$0.onConnectionFailed();
    }
    
    @Override
    public void onConnectionSuspended() {
        if (MediaBrowserCompat.ConnectionCallback.access$200(this$0) != null) {
            MediaBrowserCompat.ConnectionCallback.access$200(this$0).onConnectionSuspended();
        }
        this$0.onConnectionSuspended();
    }
}
