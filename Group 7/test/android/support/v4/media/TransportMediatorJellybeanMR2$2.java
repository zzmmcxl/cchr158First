package android.support.v4.media;

import android.support.v4.media.TransportMediatorJellybeanMR2;
import android.view.ViewTreeObserver.OnWindowFocusChangeListener;

class TransportMediatorJellybeanMR2$2 implements OnWindowFocusChangeListener {
   TransportMediatorJellybeanMR2$2(TransportMediatorJellybeanMR2 var1) {
      this.this$0 = var1;
   }

   public void onWindowFocusChanged(boolean var1) {
      if(var1) {
         this.this$0.gainFocus();
      } else {
         this.this$0.loseFocus();
      }
   }
}
