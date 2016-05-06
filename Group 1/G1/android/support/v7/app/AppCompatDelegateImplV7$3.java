package android.support.v7.app;

import android.graphics.Rect;
import android.support.v7.widget.FitWindowsViewGroup;

class AppCompatDelegateImplV7$3 implements OnFitSystemWindowsListener {
    final /* synthetic */ AppCompatDelegateImplV7 this$0;
    
    AppCompatDelegateImplV7$3(final AppCompatDelegateImplV7 this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void onFitSystemWindows(final Rect rect) {
        rect.top = AppCompatDelegateImplV7.access$300(this$0, rect.top);
    }
}