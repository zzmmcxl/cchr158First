package android.support.design.widget;

import android.support.v4.view.WindowInsetsCompat;
import android.view.View;
import android.support.v4.view.OnApplyWindowInsetsListener;

class CollapsingToolbarLayout$1 implements OnApplyWindowInsetsListener {
    final /* synthetic */ CollapsingToolbarLayout this$0;
    
    CollapsingToolbarLayout$1(final CollapsingToolbarLayout this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public WindowInsetsCompat onApplyWindowInsets(final View view, final WindowInsetsCompat windowInsetsCompat) {
        return CollapsingToolbarLayout.access$000(this$0, windowInsetsCompat);
    }
}