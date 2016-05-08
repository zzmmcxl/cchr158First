package android.support.design.widget;

import android.graphics.Rect;
import android.support.design.widget.ViewGroupUtils$ViewGroupUtilsImpl;
import android.view.View;
import android.view.ViewGroup;

class ViewGroupUtils$ViewGroupUtilsImplBase implements ViewGroupUtils$ViewGroupUtilsImpl {
   private ViewGroupUtils$ViewGroupUtilsImplBase() {
   }

   public void offsetDescendantRect(ViewGroup var1, View var2, Rect var3) {
      var1.offsetDescendantRectToMyCoords(var2, var3);
      var3.offset(var2.getScrollX(), var2.getScrollY());
   }
}
