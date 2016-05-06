package android.support.v4.media;

import android.support.v4.media.session.MediaSessionCompat;
import android.os.Bundle;
import java.util.List;
import android.os.Messenger;

interface MediaBrowserServiceCallbackImpl
{
    void onConnectionFailed(final Messenger p0);
    
    void onLoadChildren(final Messenger p0, final String p1, final List p2, final Bundle p3);
    
    void onServiceConnected(final Messenger p0, final String p1, final MediaSessionCompat.Token p2, final Bundle p3);
}
