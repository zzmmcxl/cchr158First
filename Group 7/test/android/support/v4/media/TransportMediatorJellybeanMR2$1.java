package android.support.v4.media;

import android.support.v4.media.TransportMediatorJellybeanMR2;
import android.view.ViewTreeObserver.OnWindowAttachListener;

class TransportMediatorJellybeanMR2$1 implements OnWindowAttachListener {
   TransportMediatorJellybeanMR2$1(TransportMediatorJellybeanMR2 var1) {
      this.this$0 = var1;
   }

   public void onWindowAttached() {
      this.this$0.windowAttached();
   }

   public void onWindowDetached() {
      this.this$0.windowDetached();
   }
}
