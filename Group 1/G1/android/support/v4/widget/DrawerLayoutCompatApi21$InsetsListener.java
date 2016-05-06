package android.support.v4.widget;

import android.view.WindowInsets;
import android.view.View;
import android.view.View$OnApplyWindowInsetsListener;

static class InsetsListener implements View$OnApplyWindowInsetsListener
{
    InsetsListener() {
        super();
    }
    
    public WindowInsets onApplyWindowInsets(final View view, final WindowInsets windowInsets) {
        ((DrawerLayoutImpl)view).setChildInsets(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
        return windowInsets.consumeSystemWindowInsets();
    }
}
