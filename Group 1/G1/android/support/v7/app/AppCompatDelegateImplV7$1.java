package android.support.v7.app;

class AppCompatDelegateImplV7$1 implements Runnable {
    final /* synthetic */ AppCompatDelegateImplV7 this$0;
    
    AppCompatDelegateImplV7$1(final AppCompatDelegateImplV7 this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        if ((0x1 & AppCompatDelegateImplV7.access$000(this$0)) != 0x0) {
            AppCompatDelegateImplV7.access$100(this$0, 0);
        }
        if ((0x1000 & AppCompatDelegateImplV7.access$000(this$0)) != 0x0) {
            AppCompatDelegateImplV7.access$100(this$0, 108);
        }
        AppCompatDelegateImplV7.access$202(this$0, false);
        AppCompatDelegateImplV7.access$002(this$0, 0);
    }
}