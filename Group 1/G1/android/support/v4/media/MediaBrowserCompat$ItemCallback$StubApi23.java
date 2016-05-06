package android.support.v4.media;

import android.os.Parcel;
import android.support.annotation.NonNull;

private class StubApi23 implements MediaBrowserCompatApi23.ItemCallback
{
    final /* synthetic */ MediaBrowserCompat.ItemCallback this$0;
    
    private StubApi23(final MediaBrowserCompat.ItemCallback this$0) {
        this$0 = this$0;
        super();
    }
    
    StubApi23(final MediaBrowserCompat.ItemCallback itemCallback, final MediaBrowserCompat$1 object) {
        this(itemCallback);
    }
    
    @Override
    public void onError(@NonNull final String s) {
        this$0.onError(s);
    }
    
    @Override
    public void onItemLoaded(final Parcel parcel) {
        parcel.setDataPosition(0);
        final MediaItem mediaItem = (MediaItem)MediaItem.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        this$0.onItemLoaded(mediaItem);
    }
}
