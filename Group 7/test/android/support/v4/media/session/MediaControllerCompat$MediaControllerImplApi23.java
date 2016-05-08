package android.support.v4.media.session;

import android.content.Context;
import android.os.RemoteException;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21;
import android.support.v4.media.session.MediaControllerCompat$TransportControls;
import android.support.v4.media.session.MediaControllerCompat$TransportControlsApi23;
import android.support.v4.media.session.MediaControllerCompatApi21;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat$Token;

class MediaControllerCompat$MediaControllerImplApi23 extends MediaControllerCompat$MediaControllerImplApi21 {
   public MediaControllerCompat$MediaControllerImplApi23(Context var1, MediaSessionCompat$Token var2) throws RemoteException {
      super(var1, var2);
   }

   public MediaControllerCompat$MediaControllerImplApi23(Context var1, MediaSessionCompat var2) {
      super(var1, var2);
   }

   public MediaControllerCompat$TransportControls getTransportControls() {
      Object var1 = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
      return var1 != null?new MediaControllerCompat$TransportControlsApi23(var1):null;
   }
}
