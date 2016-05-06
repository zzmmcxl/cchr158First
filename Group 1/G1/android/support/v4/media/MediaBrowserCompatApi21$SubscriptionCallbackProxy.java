package android.support.v4.media;

import java.util.Iterator;
import android.os.Parcel;
import java.util.ArrayList;
import android.media.browse.MediaBrowser$MediaItem;
import java.util.List;
import android.support.annotation.NonNull;
import android.media.browse.MediaBrowser$SubscriptionCallback;

static class SubscriptionCallbackProxy<T extends SubscriptionCallback> extends MediaBrowser$SubscriptionCallback
{
    protected final T mSubscriptionCallback;
    
    public SubscriptionCallbackProxy(final T mSubscriptionCallback) {
        super();
        this.mSubscriptionCallback = mSubscriptionCallback;
    }
    
    public void onChildrenLoaded(@NonNull final String s, List<MediaBrowser$MediaItem> list) {
        if (list != null && list.size() == 1 && ((MediaBrowser$MediaItem)list.get(0)).getMediaId().equals("android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM")) {
            list = null;
        }
        List<Parcel> list2 = null;
        if (list != null) {
            list2 = new ArrayList<Parcel>();
            for (final MediaBrowser$MediaItem mediaBrowser$MediaItem : list) {
                final Parcel obtain = Parcel.obtain();
                mediaBrowser$MediaItem.writeToParcel(obtain, 0);
                list2.add(obtain);
            }
        }
        ((SubscriptionCallback)mSubscriptionCallback).onChildrenLoaded(s, list2);
    }
    
    public void onError(@NonNull final String s) {
        ((SubscriptionCallback)mSubscriptionCallback).onError(s);
    }
}
