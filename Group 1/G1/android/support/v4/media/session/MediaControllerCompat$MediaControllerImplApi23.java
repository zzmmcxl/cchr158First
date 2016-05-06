package android.support.v4.media.session;

import android.os.RemoteException;
import android.content.Context;

static class MediaControllerImplApi23 extends MediaControllerImplApi21
{
    public MediaControllerImplApi23(final Context context, final MediaSessionCompat.Token token) throws RemoteException {
        super(context, token);
    }
    
    public MediaControllerImplApi23(final Context context, final MediaSessionCompat mediaSessionCompat) {
        super(context, mediaSessionCompat);
    }
    
    @Override
    public TransportControls getTransportControls() {
        final Object transportControls = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
        if (transportControls != null) {
            return new TransportControlsApi23(transportControls);
        }
        return null;
    }
}
