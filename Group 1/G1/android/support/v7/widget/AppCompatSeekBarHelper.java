package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.SeekBar;

class AppCompatSeekBarHelper extends AppCompatProgressBarHelper
{
    private static final int[] TINT_ATTRS;
    private final SeekBar mView;
    
    static {
        TINT_ATTRS = new int[] { 16843074 };
    }
    
    AppCompatSeekBarHelper(final SeekBar mView, final AppCompatDrawableManager appCompatDrawableManager) {
        super((ProgressBar)mView, appCompatDrawableManager);
        mView = mView;
    }
    
    @Override
    void loadFromAttributes(final AttributeSet set, final int n) {
        super.loadFromAttributes(set, n);
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(mView.getContext(), set, TINT_ATTRS, n, 0);
        final Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
        if (drawableIfKnown != null) {
            mView.setThumb(drawableIfKnown);
        }
        obtainStyledAttributes.recycle();
    }
}
