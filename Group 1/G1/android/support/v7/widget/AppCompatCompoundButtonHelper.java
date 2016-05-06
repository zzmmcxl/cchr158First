package android.support.v7.widget;

import android.support.annotation.Nullable;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.os.Build$VERSION;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.CompoundButtonCompat;
import android.widget.CompoundButton;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;

class AppCompatCompoundButtonHelper
{
    private ColorStateList mButtonTintList;
    private PorterDuff$Mode mButtonTintMode;
    private final AppCompatDrawableManager mDrawableManager;
    private boolean mHasButtonTint;
    private boolean mHasButtonTintMode;
    private boolean mSkipNextApply;
    private final CompoundButton mView;
    
    AppCompatCompoundButtonHelper(final CompoundButton mView, final AppCompatDrawableManager mDrawableManager) {
        super();
        mButtonTintList = null;
        mButtonTintMode = null;
        mHasButtonTint = false;
        mHasButtonTintMode = false;
        mView = mView;
        mDrawableManager = mDrawableManager;
    }
    
    void applyButtonTint() {
        final Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(mView);
        if (buttonDrawable != null && (mHasButtonTint || mHasButtonTintMode)) {
            final Drawable mutate = DrawableCompat.wrap(buttonDrawable).mutate();
            if (mHasButtonTint) {
                DrawableCompat.setTintList(mutate, mButtonTintList);
            }
            if (mHasButtonTintMode) {
                DrawableCompat.setTintMode(mutate, mButtonTintMode);
            }
            if (mutate.isStateful()) {
                mutate.setState(mView.getDrawableState());
            }
            mView.setButtonDrawable(mutate);
        }
    }
    
    int getCompoundPaddingLeft(int n) {
        if (Build$VERSION.SDK_INT < 17) {
            final Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(mView);
            if (buttonDrawable != null) {
                n += buttonDrawable.getIntrinsicWidth();
            }
        }
        return n;
    }
    
    ColorStateList getSupportButtonTintList() {
        return mButtonTintList;
    }
    
    PorterDuff$Mode getSupportButtonTintMode() {
        return mButtonTintMode;
    }
    
    void loadFromAttributes(final AttributeSet set, final int n) {
        final TypedArray obtainStyledAttributes = mView.getContext().obtainStyledAttributes(set, R.styleable.CompoundButton, n, 0);
        try {
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_android_button)) {
                final int resourceId = obtainStyledAttributes.getResourceId(R.styleable.CompoundButton_android_button, 0);
                if (resourceId != 0) {
                    mView.setButtonDrawable(mDrawableManager.getDrawable(mView.getContext(), resourceId));
                }
            }
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTint)) {
                CompoundButtonCompat.setButtonTintList(mView, obtainStyledAttributes.getColorStateList(R.styleable.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTintMode)) {
                CompoundButtonCompat.setButtonTintMode(mView, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.CompoundButton_buttonTintMode, -1), (PorterDuff$Mode)null));
            }
        }
        finally {
            obtainStyledAttributes.recycle();
        }
    }
    
    void onSetButtonDrawable() {
        if (mSkipNextApply) {
            mSkipNextApply = false;
            return;
        }
        mSkipNextApply = true;
        this.applyButtonTint();
    }
    
    void setSupportButtonTintList(final ColorStateList mButtonTintList) {
        this.mButtonTintList = mButtonTintList;
        mHasButtonTint = true;
        this.applyButtonTint();
    }
    
    void setSupportButtonTintMode(@Nullable final PorterDuff$Mode mButtonTintMode) {
        this.mButtonTintMode = mButtonTintMode;
        mHasButtonTintMode = true;
        this.applyButtonTint();
    }
}
