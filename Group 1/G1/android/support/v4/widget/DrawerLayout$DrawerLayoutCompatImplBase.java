package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup$MarginLayoutParams;

static class DrawerLayoutCompatImplBase implements DrawerLayoutCompatImpl
{
    DrawerLayoutCompatImplBase() {
        super();
    }
    
    @Override
    public void applyMarginInsets(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams, final Object o, final int n) {
    }
    
    @Override
    public void configureApplyInsets(final View view) {
    }
    
    @Override
    public void dispatchChildInsets(final View view, final Object o, final int n) {
    }
    
    @Override
    public Drawable getDefaultStatusBarBackground(final Context context) {
        return null;
    }
    
    @Override
    public int getTopInset(final Object o) {
        return 0;
    }
}
