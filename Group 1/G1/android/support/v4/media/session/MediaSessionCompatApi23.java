package android.support.v4.media.session;

import android.os.Bundle;
import android.net.Uri;

class MediaSessionCompatApi23
{
    MediaSessionCompatApi23() {
        super();
    }
    
    public static Object createCallback(final Callback callback) {
        return new CallbackProxy(callback);
    }
}
