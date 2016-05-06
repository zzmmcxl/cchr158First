package android.support.v4.media.session;

import android.os.Bundle;
import android.net.Uri;

static class CallbackProxy<T extends MediaSessionCompatApi23.Callback> extends MediaSessionCompatApi21.CallbackProxy<T>
{
    public CallbackProxy(final T t) {
        super(t);
    }
    
    public void onPlayFromUri(final Uri uri, final Bundle bundle) {
        ((MediaSessionCompatApi23.Callback)this.mCallback).onPlayFromUri(uri, bundle);
    }
}
