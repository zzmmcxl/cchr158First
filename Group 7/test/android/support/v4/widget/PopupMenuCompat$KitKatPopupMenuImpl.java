package android.support.v4.widget;

import android.support.v4.widget.PopupMenuCompat$BasePopupMenuImpl;
import android.support.v4.widget.PopupMenuCompatKitKat;
import android.view.View.OnTouchListener;

class PopupMenuCompat$KitKatPopupMenuImpl extends PopupMenuCompat$BasePopupMenuImpl {
   public OnTouchListener getDragToOpenListener(Object var1) {
      return PopupMenuCompatKitKat.getDragToOpenListener(var1);
   }
}
