package android.support.v4.media;

import android.os.Parcelable;
import android.os.Bundle;
import android.support.v4.os.ResultReceiver;

class MediaBrowserServiceCompat$4 extends Result<MediaBrowserCompat.MediaItem> {
    final /* synthetic */ MediaBrowserServiceCompat this$0;
    final /* synthetic */ ResultReceiver val$receiver;
    
    MediaBrowserServiceCompat$4(final MediaBrowserServiceCompat this$0, final Object o, final ResultReceiver val$receiver) {
        this$0 = this$0;
        val$receiver = val$receiver;
        super(o);
    }
    
    void onResultSent(final MediaBrowserCompat.MediaItem mediaItem, final int n) {
        final Bundle bundle = new Bundle();
        bundle.putParcelable("media_item", (Parcelable)mediaItem);
        val$receiver.send(0, bundle);
    }
    
    @Override
    /* bridge */ void onResultSent(final Object o, final int n) {
        this.onResultSent((MediaBrowserCompat.MediaItem)o, n);
    }
}