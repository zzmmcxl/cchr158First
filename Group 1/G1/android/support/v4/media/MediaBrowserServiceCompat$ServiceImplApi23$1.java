package android.support.v4.media;

import android.os.Parcel;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.os.ResultReceiver;

class MediaBrowserServiceCompat$ServiceImplApi23$1 extends ResultReceiver {
    final /* synthetic */ ServiceImplApi23 this$1;
    final /* synthetic */ ItemCallback val$cb;
    
    MediaBrowserServiceCompat$ServiceImplApi23$1(final ServiceImplApi23 this$1, final Handler handler, final ItemCallback val$cb) {
        this$1 = this$1;
        val$cb = val$cb;
        super(handler);
    }
    
    @Override
    protected void onReceiveResult(final int n, final Bundle bundle) {
        final MediaBrowserCompat.MediaItem mediaItem = (MediaBrowserCompat.MediaItem)bundle.getParcelable("media_item");
        Parcel obtain = null;
        if (mediaItem != null) {
            obtain = Parcel.obtain();
            mediaItem.writeToParcel(obtain, 0);
        }
        val$cb.onItemLoaded(n, bundle, obtain);
    }
}