package android.support.v7.widget;

import android.support.annotation.DrawableRes;
import android.graphics.drawable.Drawable;
import android.graphics.PorterDuff$Mode;
import android.support.annotation.Nullable;
import android.content.res.ColorStateList;
import android.widget.TextView;
import android.view.View;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.content.Context;
import android.support.v4.view.TintableBackgroundView;
import android.widget.AutoCompleteTextView;

public class AppCompatAutoCompleteTextView extends AutoCompleteTextView implements TintableBackgroundView
{
    private static final int[] TINT_ATTRS;
    private AppCompatBackgroundHelper mBackgroundTintHelper;
    private AppCompatDrawableManager mDrawableManager;
    private AppCompatTextHelper mTextHelper;
    
    static {
        TINT_ATTRS = new int[] { 16843126 };
    }
    
    public AppCompatAutoCompleteTextView(final Context context) {
        this(context, null);
    }
    
    public AppCompatAutoCompleteTextView(final Context context, final AttributeSet set) {
        this(context, set, R.attr.autoCompleteTextViewStyle);
    }
    
    public AppCompatAutoCompleteTextView(final Context context, final AttributeSet set, final int n) {
        super(TintContextWrapper.wrap(context), set, n);
        mDrawableManager = AppCompatDrawableManager.get();
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.getContext(), set, TINT_ATTRS, n, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            this.setDropDownBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
        }
        obtainStyledAttributes.recycle();
        (mBackgroundTintHelper = new AppCompatBackgroundHelper((View)this, mDrawableManager)).loadFromAttributes(set, n);
        (mTextHelper = AppCompatTextHelper.create((TextView)this)).loadFromAttributes(set, n);
        mTextHelper.applyCompoundDrawablesTints();
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.applySupportBackgroundTint();
        }
        if (mTextHelper != null) {
            mTextHelper.applyCompoundDrawablesTints();
        }
    }
    
    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        if (mBackgroundTintHelper != null) {
            return mBackgroundTintHelper.getSupportBackgroundTintList();
        }
        return null;
    }
    
    @Nullable
    public PorterDuff$Mode getSupportBackgroundTintMode() {
        if (mBackgroundTintHelper != null) {
            return mBackgroundTintHelper.getSupportBackgroundTintMode();
        }
        return null;
    }
    
    public void setBackgroundDrawable(final Drawable backgroundDrawable) {
        super.setBackgroundDrawable(backgroundDrawable);
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.onSetBackgroundDrawable(backgroundDrawable);
        }
    }
    
    public void setBackgroundResource(@DrawableRes final int backgroundResource) {
        super.setBackgroundResource(backgroundResource);
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.onSetBackgroundResource(backgroundResource);
        }
    }
    
    public void setDropDownBackgroundResource(@DrawableRes final int dropDownBackgroundResource) {
        if (mDrawableManager != null) {
            this.setDropDownBackgroundDrawable(mDrawableManager.getDrawable(this.getContext(), dropDownBackgroundResource));
            return;
        }
        super.setDropDownBackgroundResource(dropDownBackgroundResource);
    }
    
    public void setSupportBackgroundTintList(@Nullable final ColorStateList supportBackgroundTintList) {
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.setSupportBackgroundTintList(supportBackgroundTintList);
        }
    }
    
    public void setSupportBackgroundTintMode(@Nullable final PorterDuff$Mode supportBackgroundTintMode) {
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.setSupportBackgroundTintMode(supportBackgroundTintMode);
        }
    }
    
    public void setTextAppearance(final Context context, final int n) {
        super.setTextAppearance(context, n);
        if (mTextHelper != null) {
            mTextHelper.onSetTextAppearance(context, n);
        }
    }
}
