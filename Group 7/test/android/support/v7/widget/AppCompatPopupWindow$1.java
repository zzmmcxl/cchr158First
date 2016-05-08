package android.support.v7.widget;

import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

final class AppCompatPopupWindow$1 implements OnScrollChangedListener {
   AppCompatPopupWindow$1(Field var1, PopupWindow var2, OnScrollChangedListener var3) {
      this.val$fieldAnchor = var1;
      this.val$popup = var2;
      this.val$originalListener = var3;
   }

   public void onScrollChanged() {
      // $FF: Couldn't be decompiled
   }
}
