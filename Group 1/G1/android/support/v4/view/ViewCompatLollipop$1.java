package android.support.v4.view;

import android.view.WindowInsets;
import android.view.View;
import android.view.View$OnApplyWindowInsetsListener;

static final class ViewCompatLollipop$1 implements View$OnApplyWindowInsetsListener {
    final /* synthetic */ OnApplyWindowInsetsListener val$listener;
    
    ViewCompatLollipop$1(final OnApplyWindowInsetsListener val$listener) {
        this.val$listener = val$listener;
        super();
    }
    
    public WindowInsets onApplyWindowInsets(final View view, final WindowInsets windowInsets) {
        return ((WindowInsetsCompatApi21)val$listener.onApplyWindowInsets(view, new WindowInsetsCompatApi21(windowInsets))).unwrap();
    }
}