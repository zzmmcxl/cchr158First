package android.support.v4.print;

import android.os.CancellationSignal.OnCancelListener;
import android.support.v4.print.PrintHelperKitkat$2;
import android.support.v4.print.PrintHelperKitkat$2$1;

class PrintHelperKitkat$2$1$1 implements OnCancelListener {
   PrintHelperKitkat$2$1$1(PrintHelperKitkat$2$1 var1) {
      this.this$2 = var1;
   }

   public void onCancel() {
      PrintHelperKitkat$2.access$200(this.this$2.this$1);
      this.this$2.cancel(false);
   }
}
