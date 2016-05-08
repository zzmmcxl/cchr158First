package android.support.v4.view;

import android.support.v4.view.KeyEventCompat$KeyEventVersionImpl;
import android.view.KeyEvent;
import android.view.View;
import android.view.KeyEvent.Callback;

class KeyEventCompat$BaseKeyEventVersionImpl implements KeyEventCompat$KeyEventVersionImpl {
   private static final int META_ALL_MASK = 247;
   private static final int META_MODIFIER_MASK = 247;

   private static int metaStateFilterDirectionalModifiers(int var0, int var1, int var2, int var3, int var4) {
      boolean var6 = true;
      boolean var5;
      if((var1 & var2) != 0) {
         var5 = true;
      } else {
         var5 = false;
      }

      var3 |= var4;
      boolean var7;
      if((var1 & var3) != 0) {
         var7 = var6;
      } else {
         var7 = false;
      }

      if(var5) {
         if(var7) {
            throw new IllegalArgumentException("bad arguments");
         }

         var3 = var0 & ~var3;
      } else {
         var3 = var0;
         if(var7) {
            return var0 & ~var2;
         }
      }

      return var3;
   }

   public boolean dispatch(KeyEvent var1, Callback var2, Object var3, Object var4) {
      return var1.dispatch(var2);
   }

   public Object getKeyDispatcherState(View var1) {
      return null;
   }

   public boolean isTracking(KeyEvent var1) {
      return false;
   }

   public boolean metaStateHasModifiers(int var1, int var2) {
      return metaStateFilterDirectionalModifiers(metaStateFilterDirectionalModifiers(this.normalizeMetaState(var1) & 247, var2, 1, 64, 128), var2, 2, 16, 32) == var2;
   }

   public boolean metaStateHasNoModifiers(int var1) {
      return (this.normalizeMetaState(var1) & 247) == 0;
   }

   public int normalizeMetaState(int var1) {
      int var2 = var1;
      if((var1 & 192) != 0) {
         var2 = var1 | 1;
      }

      var1 = var2;
      if((var2 & 48) != 0) {
         var1 = var2 | 2;
      }

      return var1 & 247;
   }

   public void startTracking(KeyEvent var1) {
   }
}
