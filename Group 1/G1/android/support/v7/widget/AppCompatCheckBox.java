package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.annotation.DrawableRes;
import android.graphics.PorterDuff$Mode;
import android.support.annotation.Nullable;
import android.content.res.ColorStateList;
import android.widget.CompoundButton;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.content.Context;
import android.support.v4.widget.TintableCompoundButton;
import android.widget.CheckBox;

public class AppCompatCheckBox extends CheckBox implements TintableCompoundButton
{
    private AppCompatCompoundButtonHelper mCompoundButtonHelper;
    private AppCompatDrawableManager mDrawableManager;
    
    public AppCompatCheckBox(final Context context) {
        this(context, null);
    }
    
    public AppCompatCheckBox(final Context context, final AttributeSet set) {
        this(context, set, R.attr.checkboxStyle);
    }
    
    public AppCompatCheckBox(final Context context, final AttributeSet set, final int n) {
        super(TintContextWrapper.wrap(context), set, n);
        mDrawableManager = AppCompatDrawableManager.get();
        (mCompoundButtonHelper = new AppCompatCompoundButtonHelper((CompoundButton)this, mDrawableManager)).loadFromAttributes(set, n);
    }
    
    public int getCompoundPaddingLeft() {
        int n = super.getCompoundPaddingLeft();
        if (mCompoundButtonHelper != null) {
            n = mCompoundButtonHelper.getCompoundPaddingLeft(n);
        }
        return n;
    }
    
    @Nullable
    public ColorStateList getSupportButtonTintList() {
        if (mCompoundButtonHelper != null) {
            return mCompoundButtonHelper.getSupportButtonTintList();
        }
        return null;
    }
    
    @Nullable
    public PorterDuff$Mode getSupportButtonTintMode() {
        if (mCompoundButtonHelper != null) {
            return mCompoundButtonHelper.getSupportButtonTintMode();
        }
        return null;
    }
    
    public void setButtonDrawable(@DrawableRes final int n) {
        Drawable buttonDrawable;
        if (mDrawableManager != null) {
            buttonDrawable = mDrawableManager.getDrawable(this.getContext(), n);
        }
        else {
            buttonDrawable = ContextCompat.getDrawable(this.getContext(), n);
        }
        this.setButtonDrawable(buttonDrawable);
    }
    
    public void setButtonDrawable(final Drawable buttonDrawable) {
        super.setButtonDrawable(buttonDrawable);
        if (mCompoundButtonHelper != null) {
            mCompoundButtonHelper.onSetButtonDrawable();
        }
    }
    
    public void setSupportButtonTintList(@Nullable final ColorStateList supportButtonTintList) {
        if (mCompoundButtonHelper != null) {
            mCompoundButtonHelper.setSupportButtonTintList(supportButtonTintList);
        }
    }
    
    public void setSupportButtonTintMode(@Nullable final PorterDuff$Mode supportButtonTintMode) {
        if (mCompoundButtonHelper != null) {
            mCompoundButtonHelper.setSupportButtonTintMode(supportButtonTintMode);
        }
    }
}
