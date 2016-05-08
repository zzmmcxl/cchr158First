package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.design.widget.ViewGroupUtils$1;
import android.support.design.widget.ViewGroupUtils$ViewGroupUtilsImpl;
import android.support.design.widget.ViewGroupUtils$ViewGroupUtilsImplBase;
import android.support.design.widget.ViewGroupUtils$ViewGroupUtilsImplHoneycomb;
import android.view.View;
import android.view.ViewGroup;

class ViewGroupUtils {
   private static final ViewGroupUtils$ViewGroupUtilsImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 11) {
         IMPL = new ViewGroupUtils$ViewGroupUtilsImplHoneycomb((ViewGroupUtils$1)null);
      } else {
         IMPL = new ViewGroupUtils$ViewGroupUtilsImplBase((ViewGroupUtils$1)null);
      }
   }

   static void getDescendantRect(ViewGroup var0, View var1, Rect var2) {
      var2.set(0, 0, var1.getWidth(), var1.getHeight());
      offsetDescendantRect(var0, var1, var2);
   }

   static void offsetDescendantRect(ViewGroup var0, View var1, Rect var2) {
      IMPL.offsetDescendantRect(var0, var1, var2);
   }
}
