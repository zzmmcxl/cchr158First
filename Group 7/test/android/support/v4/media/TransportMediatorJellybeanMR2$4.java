package android.support.v4.media;

import android.media.AudioManager.OnAudioFocusChangeListener;
import android.support.v4.media.TransportMediatorJellybeanMR2;

class TransportMediatorJellybeanMR2$4 implements OnAudioFocusChangeListener {
   TransportMediatorJellybeanMR2$4(TransportMediatorJellybeanMR2 var1) {
      this.this$0 = var1;
   }

   public void onAudioFocusChange(int var1) {
      this.this$0.mTransportCallback.handleAudioFocusChange(var1);
   }
}
