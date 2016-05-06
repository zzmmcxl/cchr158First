package android.support.v4.media;

import android.os.Parcel;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.os.ResultReceiver;

private class ServiceImplApi23 extends MediaBrowserServiceCompat.ServiceImplApi21 implements MediaBrowserServiceCompatApi23.ServiceImplApi23
{
    final /* synthetic */ MediaBrowserServiceCompat this$0;
    
    private ServiceImplApi23(final MediaBrowserServiceCompat this$0) {
        this$0 = this$0;
        this$0.super();
    }
    
    ServiceImplApi23(final MediaBrowserServiceCompat mediaBrowserServiceCompat, final MediaBrowserServiceCompat$1 runnable) {
        this(mediaBrowserServiceCompat);
    }
    
    @Override
    public void getMediaItem(final String s, final ItemCallback itemCallback) {
        this.mServiceImpl.getMediaItem(s, new ResultReceiver(MediaBrowserServiceCompat.access$100(this$0)) {
            final /* synthetic */ ServiceImplApi23 this$1;
            final /* synthetic */ ItemCallback val$cb;
            
            MediaBrowserServiceCompat$ServiceImplApi23$1(final Handler handler) {
                this$1 = this$1;
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
                itemCallback.onItemLoaded(n, bundle, obtain);
            }
        });
    }
}
