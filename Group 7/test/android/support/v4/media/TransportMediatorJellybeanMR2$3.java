package android.support.v4.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.media.TransportMediatorJellybeanMR2;
import android.util.Log;
import android.view.KeyEvent;

class TransportMediatorJellybeanMR2$3 extends BroadcastReceiver {
   TransportMediatorJellybeanMR2$3(TransportMediatorJellybeanMR2 var1) {
      this.this$0 = var1;
   }

   public void onReceive(Context var1, Intent var2) {
      try {
         KeyEvent var4 = (KeyEvent)var2.getParcelableExtra("android.intent.extra.KEY_EVENT");
         this.this$0.mTransportCallback.handleKey(var4);
      } catch (ClassCastException var3) {
         Log.w("TransportController", var3);
      }
   }
}
