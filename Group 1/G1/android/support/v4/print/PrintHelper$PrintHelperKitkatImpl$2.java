package android.support.v4.print;

class PrintHelper$PrintHelperKitkatImpl$2 implements PrintHelperKitkat.OnPrintFinishCallback {
    final /* synthetic */ PrintHelperKitkatImpl this$0;
    final /* synthetic */ PrintHelper.OnPrintFinishCallback val$callback;
    
    PrintHelper$PrintHelperKitkatImpl$2(final PrintHelperKitkatImpl this$0, final PrintHelper.OnPrintFinishCallback val$callback) {
        this$0 = this$0;
        val$callback = val$callback;
        super();
    }
    
    @Override
    public void onFinish() {
        val$callback.onFinish();
    }
}