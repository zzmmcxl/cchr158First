package android.support.v4.view;

import android.support.v4.view.ViewParentCompat$ViewParentCompatICSImpl;
import android.support.v4.view.ViewParentCompatKitKat;
import android.view.View;
import android.view.ViewParent;

class ViewParentCompat$ViewParentCompatKitKatImpl extends ViewParentCompat$ViewParentCompatICSImpl {
   public void notifySubtreeAccessibilityStateChanged(ViewParent var1, View var2, View var3, int var4) {
      ViewParentCompatKitKat.notifySubtreeAccessibilityStateChanged(var1, var2, var3, var4);
   }
}
