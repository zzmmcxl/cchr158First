package android.support.v4.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v4.widget.SlidingPaneLayout$LayoutParams;
import android.support.v4.widget.SlidingPaneLayout$SlidingPanelLayoutImplBase;
import android.view.View;

class SlidingPaneLayout$SlidingPanelLayoutImplJBMR1 extends SlidingPaneLayout$SlidingPanelLayoutImplBase {
   public void invalidateChildRegion(SlidingPaneLayout var1, View var2) {
      ViewCompat.setLayerPaint(var2, ((SlidingPaneLayout$LayoutParams)var2.getLayoutParams()).dimPaint);
   }
}
