package android.support.v4.media;

class MediaBrowserCompat$MediaBrowserServiceImplBase$3 implements Runnable {
    final /* synthetic */ MediaBrowserServiceImplBase this$0;
    final /* synthetic */ ItemCallback val$cb;
    final /* synthetic */ String val$mediaId;
    
    MediaBrowserCompat$MediaBrowserServiceImplBase$3(final MediaBrowserServiceImplBase this$0, final ItemCallback val$cb, final String val$mediaId) {
        this$0 = this$0;
        val$cb = val$cb;
        val$mediaId = val$mediaId;
        super();
    }
    
    @Override
    public void run() {
        val$cb.onError(val$mediaId);
    }
}