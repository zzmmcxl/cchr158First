package android.support.v4.media;

import android.media.RemoteControlClient$OnPlaybackPositionUpdateListener;

class TransportMediatorJellybeanMR2$6 implements RemoteControlClient$OnPlaybackPositionUpdateListener {
    final /* synthetic */ TransportMediatorJellybeanMR2 this$0;
    
    TransportMediatorJellybeanMR2$6(final TransportMediatorJellybeanMR2 this$0) {
        this$0 = this$0;
        super();
    }
    
    public void onPlaybackPositionUpdate(final long n) {
        mTransportCallback.playbackPositionUpdate(n);
    }
}