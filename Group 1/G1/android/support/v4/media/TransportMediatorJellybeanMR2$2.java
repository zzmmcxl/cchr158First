package android.support.v4.media;

import android.view.ViewTreeObserver$OnWindowFocusChangeListener;

class TransportMediatorJellybeanMR2$2 implements ViewTreeObserver$OnWindowFocusChangeListener {
    final /* synthetic */ TransportMediatorJellybeanMR2 this$0;
    
    TransportMediatorJellybeanMR2$2(final TransportMediatorJellybeanMR2 this$0) {
        this$0 = this$0;
        super();
    }
    
    public void onWindowFocusChanged(final boolean b) {
        if (b) {
            this$0.gainFocus();
            return;
        }
        this$0.loseFocus();
    }
}