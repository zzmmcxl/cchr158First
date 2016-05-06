package android.support.design.internal;

import android.support.v4.view.ViewCompat;
import android.graphics.Rect;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;
import android.support.v4.view.OnApplyWindowInsetsListener;

class ScrimInsetsFrameLayout$1 implements OnApplyWindowInsetsListener {
    final /* synthetic */ ScrimInsetsFrameLayout this$0;
    
    ScrimInsetsFrameLayout$1(final ScrimInsetsFrameLayout this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public WindowInsetsCompat onApplyWindowInsets(final View view, final WindowInsetsCompat windowInsetsCompat) {
        if (ScrimInsetsFrameLayout.access$000(this$0) == null) {
            ScrimInsetsFrameLayout.access$002(this$0, new Rect());
        }
        ScrimInsetsFrameLayout.access$000(this$0).set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
        this$0.onInsetsChanged(ScrimInsetsFrameLayout.access$000(this$0));
        this$0.setWillNotDraw(ScrimInsetsFrameLayout.access$000(this$0).isEmpty() || ScrimInsetsFrameLayout.access$100(this$0) == null);
        ViewCompat.postInvalidateOnAnimation((View)this$0);
        return windowInsetsCompat.consumeSystemWindowInsets();
    }
}