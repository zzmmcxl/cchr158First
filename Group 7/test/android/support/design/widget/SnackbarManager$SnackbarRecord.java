package android.support.design.widget;

import android.support.design.widget.SnackbarManager$Callback;
import java.lang.ref.WeakReference;

class SnackbarManager$SnackbarRecord {
   private final WeakReference<SnackbarManager$Callback> callback;
   private int duration;

   SnackbarManager$SnackbarRecord(int var1, SnackbarManager$Callback var2) {
      this.callback = new WeakReference(var2);
      this.duration = var1;
   }

   boolean isSnackbar(SnackbarManager$Callback var1) {
      return var1 != null && this.callback.get() == var1;
   }
}
