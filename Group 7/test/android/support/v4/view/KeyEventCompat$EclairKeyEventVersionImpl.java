package android.support.v4.view;

import android.support.v4.view.KeyEventCompat$BaseKeyEventVersionImpl;
import android.support.v4.view.KeyEventCompatEclair;
import android.view.KeyEvent;
import android.view.View;
import android.view.KeyEvent.Callback;

class KeyEventCompat$EclairKeyEventVersionImpl extends KeyEventCompat$BaseKeyEventVersionImpl {
   public boolean dispatch(KeyEvent var1, Callback var2, Object var3, Object var4) {
      return KeyEventCompatEclair.dispatch(var1, var2, var3, var4);
   }

   public Object getKeyDispatcherState(View var1) {
      return KeyEventCompatEclair.getKeyDispatcherState(var1);
   }

   public boolean isTracking(KeyEvent var1) {
      return KeyEventCompatEclair.isTracking(var1);
   }

   public void startTracking(KeyEvent var1) {
      KeyEventCompatEclair.startTracking(var1);
   }
}
