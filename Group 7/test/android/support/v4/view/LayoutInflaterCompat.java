package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.view.LayoutInflaterCompat$LayoutInflaterCompatImpl;
import android.support.v4.view.LayoutInflaterCompat$LayoutInflaterCompatImplBase;
import android.support.v4.view.LayoutInflaterCompat$LayoutInflaterCompatImplV11;
import android.support.v4.view.LayoutInflaterCompat$LayoutInflaterCompatImplV21;
import android.support.v4.view.LayoutInflaterFactory;
import android.view.LayoutInflater;

public final class LayoutInflaterCompat {
   static final LayoutInflaterCompat$LayoutInflaterCompatImpl IMPL;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 21) {
         IMPL = new LayoutInflaterCompat$LayoutInflaterCompatImplV21();
      } else if(var0 >= 11) {
         IMPL = new LayoutInflaterCompat$LayoutInflaterCompatImplV11();
      } else {
         IMPL = new LayoutInflaterCompat$LayoutInflaterCompatImplBase();
      }
   }

   public static LayoutInflaterFactory getFactory(LayoutInflater var0) {
      return IMPL.getFactory(var0);
   }

   public static void setFactory(LayoutInflater var0, LayoutInflaterFactory var1) {
      IMPL.setFactory(var0, var1);
   }
}
