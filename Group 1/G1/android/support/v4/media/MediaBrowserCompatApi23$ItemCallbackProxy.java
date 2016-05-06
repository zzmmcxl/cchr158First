package android.support.v4.media;

import android.os.Parcel;
import android.media.browse.MediaBrowser$MediaItem;
import android.support.annotation.NonNull;
import android.media.browse.MediaBrowser$ItemCallback;

static class ItemCallbackProxy<T extends ItemCallback> extends MediaBrowser$ItemCallback
{
    protected final T mItemCallback;
    
    public ItemCallbackProxy(final T mItemCallback) {
        super();
        this.mItemCallback = mItemCallback;
    }
    
    public void onError(@NonNull final String s) {
        ((ItemCallback)mItemCallback).onError(s);
    }
    
    public void onItemLoaded(final MediaBrowser$MediaItem mediaBrowser$MediaItem) {
        final Parcel obtain = Parcel.obtain();
        mediaBrowser$MediaItem.writeToParcel(obtain, 0);
        ((ItemCallback)mItemCallback).onItemLoaded(obtain);
    }
}
