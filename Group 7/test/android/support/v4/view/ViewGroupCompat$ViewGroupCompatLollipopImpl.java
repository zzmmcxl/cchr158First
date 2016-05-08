package android.support.v4.view;

import android.support.v4.view.ViewGroupCompat$ViewGroupCompatJellybeanMR2Impl;
import android.support.v4.view.ViewGroupCompatLollipop;
import android.view.ViewGroup;

class ViewGroupCompat$ViewGroupCompatLollipopImpl extends ViewGroupCompat$ViewGroupCompatJellybeanMR2Impl {
   public int getNestedScrollAxes(ViewGroup var1) {
      return ViewGroupCompatLollipop.getNestedScrollAxes(var1);
   }

   public boolean isTransitionGroup(ViewGroup var1) {
      return ViewGroupCompatLollipop.isTransitionGroup(var1);
   }

   public void setTransitionGroup(ViewGroup var1, boolean var2) {
      ViewGroupCompatLollipop.setTransitionGroup(var1, var2);
   }
}
