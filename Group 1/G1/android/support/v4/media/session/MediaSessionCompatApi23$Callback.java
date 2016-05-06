package android.support.v4.media.session;

import android.os.Bundle;
import android.net.Uri;

public interface Callback extends MediaSessionCompatApi21.Callback
{
    void onPlayFromUri(final Uri p0, final Bundle p1);
}
