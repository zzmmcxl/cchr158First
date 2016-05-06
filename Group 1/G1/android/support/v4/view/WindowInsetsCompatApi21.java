package android.support.v4.view;

import android.graphics.Rect;
import android.view.WindowInsets;

class WindowInsetsCompatApi21 extends WindowInsetsCompat
{
    private final WindowInsets mSource;
    
    WindowInsetsCompatApi21(final WindowInsets mSource) {
        super();
        mSource = mSource;
    }
    
    @Override
    public WindowInsetsCompat consumeStableInsets() {
        return new WindowInsetsCompatApi21(mSource.consumeStableInsets());
    }
    
    @Override
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return new WindowInsetsCompatApi21(mSource.consumeSystemWindowInsets());
    }
    
    @Override
    public int getStableInsetBottom() {
        return mSource.getStableInsetBottom();
    }
    
    @Override
    public int getStableInsetLeft() {
        return mSource.getStableInsetLeft();
    }
    
    @Override
    public int getStableInsetRight() {
        return mSource.getStableInsetRight();
    }
    
    @Override
    public int getStableInsetTop() {
        return mSource.getStableInsetTop();
    }
    
    @Override
    public int getSystemWindowInsetBottom() {
        return mSource.getSystemWindowInsetBottom();
    }
    
    @Override
    public int getSystemWindowInsetLeft() {
        return mSource.getSystemWindowInsetLeft();
    }
    
    @Override
    public int getSystemWindowInsetRight() {
        return mSource.getSystemWindowInsetRight();
    }
    
    @Override
    public int getSystemWindowInsetTop() {
        return mSource.getSystemWindowInsetTop();
    }
    
    @Override
    public boolean hasInsets() {
        return mSource.hasInsets();
    }
    
    @Override
    public boolean hasStableInsets() {
        return mSource.hasStableInsets();
    }
    
    @Override
    public boolean hasSystemWindowInsets() {
        return mSource.hasSystemWindowInsets();
    }
    
    @Override
    public boolean isConsumed() {
        return mSource.isConsumed();
    }
    
    @Override
    public boolean isRound() {
        return mSource.isRound();
    }
    
    @Override
    public WindowInsetsCompat replaceSystemWindowInsets(final int n, final int n2, final int n3, final int n4) {
        return new WindowInsetsCompatApi21(mSource.replaceSystemWindowInsets(n, n2, n3, n4));
    }
    
    @Override
    public WindowInsetsCompat replaceSystemWindowInsets(final Rect rect) {
        return new WindowInsetsCompatApi21(mSource.replaceSystemWindowInsets(rect));
    }
    
    WindowInsets unwrap() {
        return mSource;
    }
}
