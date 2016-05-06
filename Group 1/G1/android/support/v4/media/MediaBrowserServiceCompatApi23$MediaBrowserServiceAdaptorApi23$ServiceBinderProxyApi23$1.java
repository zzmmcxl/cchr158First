package android.support.v4.media;

import android.os.Parcelable;
import android.media.browse.MediaBrowser$MediaItem;
import android.os.Parcel;
import android.os.Bundle;
import android.os.ResultReceiver;

class MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptorApi23$ServiceBinderProxyApi23$1 implements ItemCallback {
    final /* synthetic */ ServiceBinderProxyApi23 this$0;
    final /* synthetic */ String val$KEY_MEDIA_ITEM;
    final /* synthetic */ ResultReceiver val$receiver;
    
    MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptorApi23$ServiceBinderProxyApi23$1(final ServiceBinderProxyApi23 this$0, final String val$KEY_MEDIA_ITEM, final ResultReceiver val$receiver) {
        this$0 = this$0;
        val$KEY_MEDIA_ITEM = val$KEY_MEDIA_ITEM;
        val$receiver = val$receiver;
        super();
    }
    
    @Override
    public void onItemLoaded(final int n, final Bundle bundle, final Parcel parcel) {
        if (parcel != null) {
            parcel.setDataPosition(0);
            bundle.putParcelable(val$KEY_MEDIA_ITEM, (Parcelable)(MediaBrowser$MediaItem)MediaBrowser$MediaItem.CREATOR.createFromParcel(parcel));
            parcel.recycle();
        }
        val$receiver.send(n, bundle);
    }
}