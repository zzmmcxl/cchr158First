package android.support.v4.app;

import android.graphics.Paint;
import android.support.v4.app.FragmentManagerImpl$AnimateOnHWLayerIfNeededListener;
import android.support.v4.view.ViewCompat;

class FragmentManagerImpl$AnimateOnHWLayerIfNeededListener$1 implements Runnable {
   FragmentManagerImpl$AnimateOnHWLayerIfNeededListener$1(FragmentManagerImpl$AnimateOnHWLayerIfNeededListener var1) {
      this.this$0 = var1;
   }

   public void run() {
      ViewCompat.setLayerType(FragmentManagerImpl$AnimateOnHWLayerIfNeededListener.access$000(this.this$0), 2, (Paint)null);
   }
}
