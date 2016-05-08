package android.support.v4.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v4.widget.SlidingPaneLayout$SlidingPanelLayoutImpl;
import android.view.View;

class SlidingPaneLayout$SlidingPanelLayoutImplBase implements SlidingPaneLayout$SlidingPanelLayoutImpl {
   public void invalidateChildRegion(SlidingPaneLayout var1, View var2) {
      ViewCompat.postInvalidateOnAnimation(var1, var2.getLeft(), var2.getTop(), var2.getRight(), var2.getBottom());
   }
}
