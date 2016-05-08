package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaControllerCompat$TransportControlsApi21;
import android.support.v4.media.session.MediaControllerCompatApi23$TransportControls;

class MediaControllerCompat$TransportControlsApi23 extends MediaControllerCompat$TransportControlsApi21 {
   public MediaControllerCompat$TransportControlsApi23(Object var1) {
      super(var1);
   }

   public void playFromUri(Uri var1, Bundle var2) {
      MediaControllerCompatApi23$TransportControls.playFromUri(this.mControlsObj, var1, var2);
   }
}
