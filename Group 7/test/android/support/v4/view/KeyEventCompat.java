package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.view.KeyEventCompat$BaseKeyEventVersionImpl;
import android.support.v4.view.KeyEventCompat$HoneycombKeyEventVersionImpl;
import android.support.v4.view.KeyEventCompat$KeyEventVersionImpl;
import android.view.KeyEvent;
import android.view.View;
import android.view.KeyEvent.Callback;

public final class KeyEventCompat {
   static final KeyEventCompat$KeyEventVersionImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 11) {
         IMPL = new KeyEventCompat$HoneycombKeyEventVersionImpl();
      } else {
         IMPL = new KeyEventCompat$BaseKeyEventVersionImpl();
      }
   }

   public static boolean dispatch(KeyEvent var0, Callback var1, Object var2, Object var3) {
      return IMPL.dispatch(var0, var1, var2, var3);
   }

   public static Object getKeyDispatcherState(View var0) {
      return IMPL.getKeyDispatcherState(var0);
   }

   public static boolean hasModifiers(KeyEvent var0, int var1) {
      return IMPL.metaStateHasModifiers(var0.getMetaState(), var1);
   }

   public static boolean hasNoModifiers(KeyEvent var0) {
      return IMPL.metaStateHasNoModifiers(var0.getMetaState());
   }

   public static boolean isTracking(KeyEvent var0) {
      return IMPL.isTracking(var0);
   }

   public static boolean metaStateHasModifiers(int var0, int var1) {
      return IMPL.metaStateHasModifiers(var0, var1);
   }

   public static boolean metaStateHasNoModifiers(int var0) {
      return IMPL.metaStateHasNoModifiers(var0);
   }

   public static int normalizeMetaState(int var0) {
      return IMPL.normalizeMetaState(var0);
   }

   public static void startTracking(KeyEvent var0) {
      IMPL.startTracking(var0);
   }
}
