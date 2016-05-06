package android.support.v4.media.session;

import android.media.Rating;
import android.media.RemoteControlClient$OnMetadataUpdateListener;

static class OnMetadataUpdateListener<T extends Callback> implements RemoteControlClient$OnMetadataUpdateListener
{
    protected final T mCallback;
    
    public OnMetadataUpdateListener(final T mCallback) {
        super();
        this.mCallback = mCallback;
    }
    
    public void onMetadataUpdate(final int n, final Object o) {
        if (n == 268435457 && o instanceof Rating) {
            ((Callback)mCallback).onSetRating(o);
        }
    }
}
