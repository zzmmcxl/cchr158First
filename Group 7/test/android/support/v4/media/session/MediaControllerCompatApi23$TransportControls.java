package android.support.v4.media.session;

import android.media.session.MediaController.TransportControls;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaControllerCompatApi21$TransportControls;

public class MediaControllerCompatApi23$TransportControls extends MediaControllerCompatApi21$TransportControls {
   public static void playFromUri(Object var0, Uri var1, Bundle var2) {
      ((TransportControls)var0).playFromUri(var1, var2);
   }
}
