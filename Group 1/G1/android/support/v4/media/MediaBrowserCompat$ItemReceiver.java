package android.support.v4.media;

import android.os.Parcelable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.os.ResultReceiver;

private static class ItemReceiver extends ResultReceiver
{
    private final ItemCallback mCallback;
    private final String mMediaId;
    
    ItemReceiver(final String mMediaId, final ItemCallback mCallback, final Handler handler) {
        super(handler);
        this.mMediaId = mMediaId;
        this.mCallback = mCallback;
    }
    
    @Override
    protected void onReceiveResult(final int n, final Bundle bundle) {
        bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
        if (n != 0 || bundle == null || !bundle.containsKey("media_item")) {
            mCallback.onError(mMediaId);
            return;
        }
        final Parcelable parcelable = bundle.getParcelable("media_item");
        if (parcelable instanceof MediaItem) {
            mCallback.onItemLoaded((MediaItem)parcelable);
            return;
        }
        mCallback.onError(mMediaId);
    }
}
