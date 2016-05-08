package android.support.v4.view;

import android.view.KeyEvent;
import android.view.View;
import android.view.KeyEvent.Callback;

interface KeyEventCompat$KeyEventVersionImpl {
   boolean dispatch(KeyEvent var1, Callback var2, Object var3, Object var4);

   Object getKeyDispatcherState(View var1);

   boolean isTracking(KeyEvent var1);

   boolean metaStateHasModifiers(int var1, int var2);

   boolean metaStateHasNoModifiers(int var1);

   int normalizeMetaState(int var1);

   void startTracking(KeyEvent var1);
}
