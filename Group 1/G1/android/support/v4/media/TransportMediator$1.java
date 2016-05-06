package android.support.v4.media;

import android.view.KeyEvent;

class TransportMediator$1 implements TransportMediatorCallback {
    final /* synthetic */ TransportMediator this$0;
    
    TransportMediator$1(final TransportMediator this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public long getPlaybackPosition() {
        return mCallbacks.onGetCurrentPosition();
    }
    
    @Override
    public void handleAudioFocusChange(final int n) {
        mCallbacks.onAudioFocusChange(n);
    }
    
    @Override
    public void handleKey(final KeyEvent keyEvent) {
        keyEvent.dispatch(mKeyEventCallback);
    }
    
    @Override
    public void playbackPositionUpdate(final long n) {
        mCallbacks.onSeekTo(n);
    }
}