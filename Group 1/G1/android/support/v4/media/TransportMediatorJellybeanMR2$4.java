package android.support.v4.media;

import android.media.AudioManager$OnAudioFocusChangeListener;

class TransportMediatorJellybeanMR2$4 implements AudioManager$OnAudioFocusChangeListener {
    final /* synthetic */ TransportMediatorJellybeanMR2 this$0;
    
    TransportMediatorJellybeanMR2$4(final TransportMediatorJellybeanMR2 this$0) {
        this$0 = this$0;
        super();
    }
    
    public void onAudioFocusChange(final int n) {
        mTransportCallback.handleAudioFocusChange(n);
    }
}