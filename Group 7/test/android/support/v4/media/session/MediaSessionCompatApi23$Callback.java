package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompatApi21$Callback;

public interface MediaSessionCompatApi23$Callback extends MediaSessionCompatApi21$Callback {
   void onPlayFromUri(Uri var1, Bundle var2);
}
