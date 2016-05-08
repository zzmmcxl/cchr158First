package android.support.v4.view;

import android.support.v4.view.LayoutInflaterCompat$LayoutInflaterCompatImplV11;
import android.support.v4.view.LayoutInflaterCompatLollipop;
import android.support.v4.view.LayoutInflaterFactory;
import android.view.LayoutInflater;

class LayoutInflaterCompat$LayoutInflaterCompatImplV21 extends LayoutInflaterCompat$LayoutInflaterCompatImplV11 {
   public void setFactory(LayoutInflater var1, LayoutInflaterFactory var2) {
      LayoutInflaterCompatLollipop.setFactory(var1, var2);
   }
}
