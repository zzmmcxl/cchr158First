package android.support.v4.media;

import android.view.KeyEvent;
import android.view.KeyEvent$Callback;

class TransportMediator$2 implements KeyEvent$Callback {
    final /* synthetic */ TransportMediator this$0;
    
    TransportMediator$2(final TransportMediator this$0) {
        this$0 = this$0;
        super();
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        return TransportMediator.isMediaKey(n) && mCallbacks.onMediaButtonDown(n, keyEvent);
    }
    
    public boolean onKeyLongPress(final int n, final KeyEvent keyEvent) {
        return false;
    }
    
    public boolean onKeyMultiple(final int n, final int n2, final KeyEvent keyEvent) {
        return false;
    }
    
    public boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        return TransportMediator.isMediaKey(n) && mCallbacks.onMediaButtonUp(n, keyEvent);
    }
}