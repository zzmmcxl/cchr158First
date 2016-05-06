package android.support.v4.media;

class MediaBrowserCompat$MediaBrowserImplApi21$2 implements Runnable {
    final /* synthetic */ MediaBrowserImplApi21 this$0;
    final /* synthetic */ ItemCallback val$cb;
    
    MediaBrowserCompat$MediaBrowserImplApi21$2(final MediaBrowserImplApi21 this$0, final ItemCallback val$cb) {
        this$0 = this$0;
        val$cb = val$cb;
        super();
    }
    
    @Override
    public void run() {
        val$cb.onItemLoaded(null);
    }
}