package android.support.v7.widget;

import android.support.v4.content.ContextCompat;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AppCompatImageHelper
{
    private final AppCompatDrawableManager mDrawableManager;
    private final ImageView mView;
    
    public AppCompatImageHelper(final ImageView mView, final AppCompatDrawableManager mDrawableManager) {
        super();
        mView = mView;
        mDrawableManager = mDrawableManager;
    }
    
    public void loadFromAttributes(final AttributeSet set, final int n) {
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(mView.getContext(), set, R.styleable.AppCompatImageView, n, 0);
        try {
            final Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(R.styleable.AppCompatImageView_android_src);
            if (drawableIfKnown != null) {
                mView.setImageDrawable(drawableIfKnown);
            }
            final int resourceId = obtainStyledAttributes.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1);
            if (resourceId != -1) {
                final Drawable drawable = mDrawableManager.getDrawable(mView.getContext(), resourceId);
                if (drawable != null) {
                    mView.setImageDrawable(drawable);
                }
            }
            final Drawable drawable2 = mView.getDrawable();
            if (drawable2 != null) {
                DrawableUtils.fixDrawable(drawable2);
            }
        }
        finally {
            obtainStyledAttributes.recycle();
        }
    }
    
    public void setImageResource(final int n) {
        if (n != 0) {
            Drawable imageDrawable;
            if (mDrawableManager != null) {
                imageDrawable = mDrawableManager.getDrawable(mView.getContext(), n);
            }
            else {
                imageDrawable = ContextCompat.getDrawable(mView.getContext(), n);
            }
            if (imageDrawable != null) {
                DrawableUtils.fixDrawable(imageDrawable);
            }
            mView.setImageDrawable(imageDrawable);
            return;
        }
        mView.setImageDrawable((Drawable)null);
    }
}
