package android.support.v4.view;

import android.support.v4.view.LayoutInflaterCompat$LayoutInflaterCompatImplBase;
import android.support.v4.view.LayoutInflaterCompatHC;
import android.support.v4.view.LayoutInflaterFactory;
import android.view.LayoutInflater;

class LayoutInflaterCompat$LayoutInflaterCompatImplV11 extends LayoutInflaterCompat$LayoutInflaterCompatImplBase {
   public void setFactory(LayoutInflater var1, LayoutInflaterFactory var2) {
      LayoutInflaterCompatHC.setFactory(var1, var2);
   }
}
