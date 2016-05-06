package android.support.v7.widget;

import android.support.annotation.DrawableRes;
import android.widget.TextView;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.CheckedTextView;

public class AppCompatCheckedTextView extends CheckedTextView
{
    private static final int[] TINT_ATTRS;
    private AppCompatDrawableManager mDrawableManager;
    private AppCompatTextHelper mTextHelper;
    
    static {
        TINT_ATTRS = new int[] { 16843016 };
    }
    
    public AppCompatCheckedTextView(final Context context) {
        this(context, null);
    }
    
    public AppCompatCheckedTextView(final Context context, final AttributeSet set) {
        this(context, set, 16843720);
    }
    
    public AppCompatCheckedTextView(final Context context, final AttributeSet set, final int n) {
        super(TintContextWrapper.wrap(context), set, n);
        (mTextHelper = AppCompatTextHelper.create((TextView)this)).loadFromAttributes(set, n);
        mTextHelper.applyCompoundDrawablesTints();
        mDrawableManager = AppCompatDrawableManager.get();
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.getContext(), set, TINT_ATTRS, n, 0);
        this.setCheckMarkDrawable(obtainStyledAttributes.getDrawable(0));
        obtainStyledAttributes.recycle();
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (mTextHelper != null) {
            mTextHelper.applyCompoundDrawablesTints();
        }
    }
    
    public void setCheckMarkDrawable(@DrawableRes final int checkMarkDrawable) {
        if (mDrawableManager != null) {
            this.setCheckMarkDrawable(mDrawableManager.getDrawable(this.getContext(), checkMarkDrawable));
            return;
        }
        super.setCheckMarkDrawable(checkMarkDrawable);
    }
    
    public void setTextAppearance(final Context context, final int n) {
        super.setTextAppearance(context, n);
        if (mTextHelper != null) {
            mTextHelper.onSetTextAppearance(context, n);
        }
    }
}
