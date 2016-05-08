package android.support.design.widget;

import android.graphics.Rect;
import android.support.design.widget.ViewGroupUtils$ViewGroupUtilsImpl;
import android.support.design.widget.ViewGroupUtilsHoneycomb;
import android.view.View;
import android.view.ViewGroup;

class ViewGroupUtils$ViewGroupUtilsImplHoneycomb implements ViewGroupUtils$ViewGroupUtilsImpl {
   private ViewGroupUtils$ViewGroupUtilsImplHoneycomb() {
   }

   public void offsetDescendantRect(ViewGroup var1, View var2, Rect var3) {
      ViewGroupUtilsHoneycomb.offsetDescendantRect(var1, var2, var3);
   }
}
