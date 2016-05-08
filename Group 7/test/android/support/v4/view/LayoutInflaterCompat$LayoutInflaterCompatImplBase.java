package android.support.v4.view;

import android.support.v4.view.LayoutInflaterCompat$LayoutInflaterCompatImpl;
import android.support.v4.view.LayoutInflaterCompatBase;
import android.support.v4.view.LayoutInflaterFactory;
import android.view.LayoutInflater;

class LayoutInflaterCompat$LayoutInflaterCompatImplBase implements LayoutInflaterCompat$LayoutInflaterCompatImpl {
   public LayoutInflaterFactory getFactory(LayoutInflater var1) {
      return LayoutInflaterCompatBase.getFactory(var1);
   }

   public void setFactory(LayoutInflater var1, LayoutInflaterFactory var2) {
      LayoutInflaterCompatBase.setFactory(var1, var2);
   }
}
