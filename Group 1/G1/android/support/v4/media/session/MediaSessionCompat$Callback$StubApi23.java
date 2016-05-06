package android.support.v4.media.session;

import android.os.Bundle;
import android.net.Uri;

private class StubApi23 extends StubApi21 implements MediaSessionCompatApi23.Callback
{
    final /* synthetic */ MediaSessionCompat.Callback this$0;
    
    private StubApi23(final MediaSessionCompat.Callback this$0) {
        this$0 = this$0;
        this$0.super();
    }
    
    StubApi23(final MediaSessionCompat.Callback callback, final MediaSessionCompat$1 object) {
        this(callback);
    }
    
    @Override
    public void onPlayFromUri(final Uri uri, final Bundle bundle) {
        this$0.onPlayFromUri(uri, bundle);
    }
}
