package android.support.v7.widget;

import android.content.res.TypedArray;
import android.content.Context;
import android.util.AttributeSet;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

class AppCompatTextHelperV17 extends AppCompatTextHelper
{
    private static final int[] VIEW_ATTRS_v17;
    private TintInfo mDrawableEndTint;
    private TintInfo mDrawableStartTint;
    
    static {
        VIEW_ATTRS_v17 = new int[] { 16843666, 16843667 };
    }
    
    AppCompatTextHelperV17(final TextView textView) {
        super(textView);
    }
    
    @Override
    void applyCompoundDrawablesTints() {
        super.applyCompoundDrawablesTints();
        if (mDrawableStartTint != null || mDrawableEndTint != null) {
            final Drawable[] compoundDrawablesRelative = this.mView.getCompoundDrawablesRelative();
            this.applyCompoundDrawableTint(compoundDrawablesRelative[0], mDrawableStartTint);
            this.applyCompoundDrawableTint(compoundDrawablesRelative[2], mDrawableEndTint);
        }
    }
    
    @Override
    void loadFromAttributes(final AttributeSet set, final int n) {
        super.loadFromAttributes(set, n);
        final Context context = this.mView.getContext();
        final AppCompatDrawableManager value = AppCompatDrawableManager.get();
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, VIEW_ATTRS_v17, n, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            mDrawableStartTint = AppCompatTextHelper.createTintInfo(context, value, obtainStyledAttributes.getResourceId(0, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            mDrawableEndTint = AppCompatTextHelper.createTintInfo(context, value, obtainStyledAttributes.getResourceId(1, 0));
        }
        obtainStyledAttributes.recycle();
    }
}
