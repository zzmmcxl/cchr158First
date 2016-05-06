package android.support.v4.media;

import android.media.browse.MediaBrowser$MediaItem;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.media.browse.MediaBrowser$ItemCallback;
import android.media.browse.MediaBrowser;

class MediaBrowserCompatApi23
{
    MediaBrowserCompatApi23() {
        super();
    }
    
    public static Object createItemCallback(final ItemCallback itemCallback) {
        return new ItemCallbackProxy(itemCallback);
    }
    
    public static void getItem(final Object o, final String s, final Object o2) {
        ((MediaBrowser)o).getItem(s, (MediaBrowser$ItemCallback)o2);
    }
}
