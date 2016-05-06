package android.support.v7.widget;

import android.graphics.ColorFilter;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

class ActionBarBackgroundDrawable extends Drawable
{
    final ActionBarContainer mContainer;
    
    public ActionBarBackgroundDrawable(final ActionBarContainer mContainer) {
        super();
        mContainer = mContainer;
    }
    
    public void draw(final Canvas canvas) {
        if (mContainer.mIsSplit) {
            if (mContainer.mSplitBackground != null) {
                mContainer.mSplitBackground.draw(canvas);
            }
        }
        else {
            if (mContainer.mBackground != null) {
                mContainer.mBackground.draw(canvas);
            }
            if (mContainer.mStackedBackground != null && mContainer.mIsStacked) {
                mContainer.mStackedBackground.draw(canvas);
            }
        }
    }
    
    public int getOpacity() {
        return 0;
    }
    
    public void setAlpha(final int n) {
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
    }
}
