package android.support.v4.view;

import android.support.v4.view.KeyEventCompat$EclairKeyEventVersionImpl;
import android.support.v4.view.KeyEventCompatHoneycomb;

class KeyEventCompat$HoneycombKeyEventVersionImpl extends KeyEventCompat$EclairKeyEventVersionImpl {
   public boolean metaStateHasModifiers(int var1, int var2) {
      return KeyEventCompatHoneycomb.metaStateHasModifiers(var1, var2);
   }

   public boolean metaStateHasNoModifiers(int var1) {
      return KeyEventCompatHoneycomb.metaStateHasNoModifiers(var1);
   }

   public int normalizeMetaState(int var1) {
      return KeyEventCompatHoneycomb.normalizeMetaState(var1);
   }
}
