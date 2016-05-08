package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.v4.widget.PopupMenuCompat$BasePopupMenuImpl;
import android.support.v4.widget.PopupMenuCompat$KitKatPopupMenuImpl;
import android.support.v4.widget.PopupMenuCompat$PopupMenuImpl;
import android.view.View.OnTouchListener;

public final class PopupMenuCompat {
   static final PopupMenuCompat$PopupMenuImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 19) {
         IMPL = new PopupMenuCompat$KitKatPopupMenuImpl();
      } else {
         IMPL = new PopupMenuCompat$BasePopupMenuImpl();
      }
   }

   public static OnTouchListener getDragToOpenListener(Object var0) {
      return IMPL.getDragToOpenListener(var0);
   }
}
