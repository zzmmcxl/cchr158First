package android.support.v4.print;

import android.os.CancellationSignal$OnCancelListener;

class PrintHelperKitkat$2$1$1 implements CancellationSignal$OnCancelListener {
    final /* synthetic */ PrintHelperKitkat$2$1 this$2;
    
    PrintHelperKitkat$2$1$1(final PrintHelperKitkat$2$1 this$2) {
        this$2 = this$2;
        super();
    }
    
    public void onCancel() {
        PrintHelperKitkat$2.access$200(this$1);
        this$2.cancel(false);
    }
}