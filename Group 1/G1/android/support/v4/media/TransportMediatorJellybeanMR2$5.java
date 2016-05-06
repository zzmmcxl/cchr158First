package android.support.v4.media;

import android.media.RemoteControlClient$OnGetPlaybackPositionListener;

class TransportMediatorJellybeanMR2$5 implements RemoteControlClient$OnGetPlaybackPositionListener {
    final /* synthetic */ TransportMediatorJellybeanMR2 this$0;
    
    TransportMediatorJellybeanMR2$5(final TransportMediatorJellybeanMR2 this$0) {
        this$0 = this$0;
        super();
    }
    
    public long onGetPlaybackPosition() {
        return mTransportCallback.getPlaybackPosition();
    }
}