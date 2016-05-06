package android.support.v4.media;

import android.view.ViewTreeObserver$OnWindowAttachListener;

class TransportMediatorJellybeanMR2$1 implements ViewTreeObserver$OnWindowAttachListener {
    final /* synthetic */ TransportMediatorJellybeanMR2 this$0;
    
    TransportMediatorJellybeanMR2$1(final TransportMediatorJellybeanMR2 this$0) {
        this$0 = this$0;
        super();
    }
    
    public void onWindowAttached() {
        this$0.windowAttached();
    }
    
    public void onWindowDetached() {
        this$0.windowDetached();
    }
}