package android.support.v7.widget;

import android.content.res.TypedArray;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.graphics.drawable.GradientDrawable;
import android.os.Build$VERSION;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.support.v4.view.ViewCompat;
import android.support.annotation.NonNull;
import android.graphics.drawable.Drawable;
import android.view.View;

class AppCompatBackgroundHelper
{
    private TintInfo mBackgroundTint;
    private final AppCompatDrawableManager mDrawableManager;
    private TintInfo mInternalBackgroundTint;
    private TintInfo mTmpInfo;
    private final View mView;
    
    AppCompatBackgroundHelper(final View mView, final AppCompatDrawableManager mDrawableManager) {
        super();
        mView = mView;
        mDrawableManager = mDrawableManager;
    }
    
    private void compatTintDrawableUsingFrameworkTint(@NonNull final Drawable drawable) {
        if (mTmpInfo == null) {
            mTmpInfo = new TintInfo();
        }
        final TintInfo mTmpInfo = this.mTmpInfo;
        mTmpInfo.clear();
        final ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(mView);
        if (backgroundTintList != null) {
            mTmpInfo.mHasTintList = true;
            mTmpInfo.mTintList = backgroundTintList;
        }
        final PorterDuff$Mode backgroundTintMode = ViewCompat.getBackgroundTintMode(mView);
        if (backgroundTintMode != null) {
            mTmpInfo.mHasTintMode = true;
            mTmpInfo.mTintMode = backgroundTintMode;
        }
        if (mTmpInfo.mHasTintList || mTmpInfo.mHasTintMode) {
            AppCompatDrawableManager.tintDrawable(drawable, mTmpInfo, mView.getDrawableState());
        }
    }
    
    private boolean shouldCompatTintUsingFrameworkTint(@NonNull final Drawable drawable) {
        return Build$VERSION.SDK_INT == 21 && drawable instanceof GradientDrawable;
    }
    
    void applySupportBackgroundTint() {
        final Drawable background = mView.getBackground();
        if (background != null) {
            if (mBackgroundTint != null) {
                AppCompatDrawableManager.tintDrawable(background, mBackgroundTint, mView.getDrawableState());
            }
            else {
                if (mInternalBackgroundTint != null) {
                    AppCompatDrawableManager.tintDrawable(background, mInternalBackgroundTint, mView.getDrawableState());
                    return;
                }
                if (this.shouldCompatTintUsingFrameworkTint(background)) {
                    this.compatTintDrawableUsingFrameworkTint(background);
                }
            }
        }
    }
    
    ColorStateList getSupportBackgroundTintList() {
        if (mBackgroundTint != null) {
            return mBackgroundTint.mTintList;
        }
        return null;
    }
    
    PorterDuff$Mode getSupportBackgroundTintMode() {
        if (mBackgroundTint != null) {
            return mBackgroundTint.mTintMode;
        }
        return null;
    }
    
    void loadFromAttributes(final AttributeSet set, final int n) {
        final TypedArray obtainStyledAttributes = mView.getContext().obtainStyledAttributes(set, R.styleable.ViewBackgroundHelper, n, 0);
        try {
            if (obtainStyledAttributes.hasValue(R.styleable.ViewBackgroundHelper_android_background)) {
                final ColorStateList tintList = mDrawableManager.getTintList(mView.getContext(), obtainStyledAttributes.getResourceId(R.styleable.ViewBackgroundHelper_android_background, -1));
                if (tintList != null) {
                    this.setInternalBackgroundTint(tintList);
                }
            }
            if (obtainStyledAttributes.hasValue(R.styleable.ViewBackgroundHelper_backgroundTint)) {
                ViewCompat.setBackgroundTintList(mView, obtainStyledAttributes.getColorStateList(R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                ViewCompat.setBackgroundTintMode(mView, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), (PorterDuff$Mode)null));
            }
        }
        finally {
            obtainStyledAttributes.recycle();
        }
    }
    
    void onSetBackgroundDrawable(final Drawable drawable) {
        this.setInternalBackgroundTint(null);
    }
    
    void onSetBackgroundResource(final int n) {
        ColorStateList tintList;
        if (mDrawableManager != null) {
            tintList = mDrawableManager.getTintList(mView.getContext(), n);
        }
        else {
            tintList = null;
        }
        this.setInternalBackgroundTint(tintList);
    }
    
    void setInternalBackgroundTint(final ColorStateList mTintList) {
        if (mTintList != null) {
            if (mInternalBackgroundTint == null) {
                mInternalBackgroundTint = new TintInfo();
            }
            mInternalBackgroundTint.mTintList = mTintList;
            mInternalBackgroundTint.mHasTintList = true;
        }
        else {
            mInternalBackgroundTint = null;
        }
        this.applySupportBackgroundTint();
    }
    
    void setSupportBackgroundTintList(final ColorStateList mTintList) {
        if (mBackgroundTint == null) {
            mBackgroundTint = new TintInfo();
        }
        mBackgroundTint.mTintList = mTintList;
        mBackgroundTint.mHasTintList = true;
        this.applySupportBackgroundTint();
    }
    
    void setSupportBackgroundTintMode(final PorterDuff$Mode mTintMode) {
        if (mBackgroundTint == null) {
            mBackgroundTint = new TintInfo();
        }
        mBackgroundTint.mTintMode = mTintMode;
        mBackgroundTint.mHasTintMode = true;
        this.applySupportBackgroundTint();
    }
}
