package android.support.v4.media;

import android.os.Parcel;
import android.support.annotation.NonNull;
import android.os.Build$VERSION;

public abstract static class ItemCallback
{
    final Object mItemCallbackObj;
    
    public ItemCallback() {
        super();
        if (Build$VERSION.SDK_INT >= 23) {
            this.mItemCallbackObj = MediaBrowserCompatApi23.createItemCallback((MediaBrowserCompatApi23.ItemCallback)new StubApi23(this));
            return;
        }
        this.mItemCallbackObj = null;
    }
    
    public void onError(@NonNull final String s) {
    }
    
    public void onItemLoaded(final MediaItem mediaItem) {
    }
}
