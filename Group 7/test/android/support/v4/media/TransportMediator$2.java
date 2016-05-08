package android.support.v4.media;

import android.support.v4.media.TransportMediator;
import android.view.KeyEvent;
import android.view.KeyEvent.Callback;

class TransportMediator$2 implements Callback {
   TransportMediator$2(TransportMediator var1) {
      this.this$0 = var1;
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      return TransportMediator.isMediaKey(var1)?this.this$0.mCallbacks.onMediaButtonDown(var1, var2):false;
   }

   public boolean onKeyLongPress(int var1, KeyEvent var2) {
      return false;
   }

   public boolean onKeyMultiple(int var1, int var2, KeyEvent var3) {
      return false;
   }

   public boolean onKeyUp(int var1, KeyEvent var2) {
      return TransportMediator.isMediaKey(var1)?this.this$0.mCallbacks.onMediaButtonUp(var1, var2):false;
   }
}
