package android.support.design.widget;

import android.graphics.PorterDuff$Mode;
import android.support.annotation.Nullable;
import android.graphics.drawable.GradientDrawable;
import android.content.res.Resources;
import android.support.design.R;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.view.ViewTreeObserver$OnPreDrawListener;
import android.graphics.drawable.Drawable;

abstract class FloatingActionButtonImpl
{
    static final int[] EMPTY_STATE_SET;
    static final int[] FOCUSED_ENABLED_STATE_SET;
    static final int[] PRESSED_ENABLED_STATE_SET;
    static final int SHOW_HIDE_ANIM_DURATION = 200;
    CircularBorderDrawable mBorderDrawable;
    Drawable mContentBackground;
    float mElevation;
    private ViewTreeObserver$OnPreDrawListener mPreDrawListener;
    float mPressedTranslationZ;
    Drawable mRippleDrawable;
    final ShadowViewDelegate mShadowViewDelegate;
    Drawable mShapeDrawable;
    private final Rect mTmpRect;
    final VisibilityAwareImageButton mView;
    
    static {
        PRESSED_ENABLED_STATE_SET = new int[] { 16842919, 16842910 };
        FOCUSED_ENABLED_STATE_SET = new int[] { 16842908, 16842910 };
        EMPTY_STATE_SET = new int[0];
    }
    
    FloatingActionButtonImpl(final VisibilityAwareImageButton mView, final ShadowViewDelegate mShadowViewDelegate) {
        super();
        mTmpRect = new Rect();
        mView = mView;
        mShadowViewDelegate = mShadowViewDelegate;
    }
    
    private void ensurePreDrawListener() {
        if (mPreDrawListener == null) {
            mPreDrawListener = (ViewTreeObserver$OnPreDrawListener)new ViewTreeObserver$OnPreDrawListener() {
                final /* synthetic */ FloatingActionButtonImpl this$0;
                
                FloatingActionButtonImpl$1() {
                    this$0 = this$0;
                    super();
                }
                
                public boolean onPreDraw() {
                    this$0.onPreDraw();
                    return true;
                }
            };
        }
    }
    
    CircularBorderDrawable createBorderDrawable(final int n, final ColorStateList borderTint) {
        final Resources resources = mView.getResources();
        final CircularBorderDrawable circularDrawable = this.newCircularDrawable();
        circularDrawable.setGradientColors(resources.getColor(R.color.design_fab_stroke_top_outer_color), resources.getColor(R.color.design_fab_stroke_top_inner_color), resources.getColor(R.color.design_fab_stroke_end_inner_color), resources.getColor(R.color.design_fab_stroke_end_outer_color));
        circularDrawable.setBorderWidth(n);
        circularDrawable.setBorderTint(borderTint);
        return circularDrawable;
    }
    
    GradientDrawable createShapeDrawable() {
        final GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }
    
    final Drawable getContentBackground() {
        return mContentBackground;
    }
    
    abstract float getElevation();
    
    abstract void getPadding(final Rect p0);
    
    abstract void hide(@Nullable final InternalVisibilityChangedListener p0, final boolean p1);
    
    abstract void jumpDrawableToCurrentState();
    
    CircularBorderDrawable newCircularDrawable() {
        return new CircularBorderDrawable();
    }
    
    void onAttachedToWindow() {
        if (this.requirePreDrawListener()) {
            this.ensurePreDrawListener();
            mView.getViewTreeObserver().addOnPreDrawListener(mPreDrawListener);
        }
    }
    
    abstract void onCompatShadowChanged();
    
    void onDetachedFromWindow() {
        if (mPreDrawListener != null) {
            mView.getViewTreeObserver().removeOnPreDrawListener(mPreDrawListener);
            mPreDrawListener = null;
        }
    }
    
    abstract void onDrawableStateChanged(final int[] p0);
    
    abstract void onElevationChanged(final float p0);
    
    void onPaddingUpdated(final Rect rect) {
    }
    
    void onPreDraw() {
    }
    
    abstract void onTranslationZChanged(final float p0);
    
    boolean requirePreDrawListener() {
        return false;
    }
    
    abstract void setBackgroundDrawable(final ColorStateList p0, final PorterDuff$Mode p1, final int p2, final int p3);
    
    abstract void setBackgroundTintList(final ColorStateList p0);
    
    abstract void setBackgroundTintMode(final PorterDuff$Mode p0);
    
    final void setElevation(final float mElevation) {
        if (this.mElevation != mElevation) {
            this.onElevationChanged(this.mElevation = mElevation);
        }
    }
    
    final void setPressedTranslationZ(final float mPressedTranslationZ) {
        if (this.mPressedTranslationZ != mPressedTranslationZ) {
            this.onTranslationZChanged(this.mPressedTranslationZ = mPressedTranslationZ);
        }
    }
    
    abstract void setRippleColor(final int p0);
    
    abstract void show(@Nullable final InternalVisibilityChangedListener p0, final boolean p1);
    
    final void updatePadding() {
        final Rect mTmpRect = this.mTmpRect;
        this.getPadding(mTmpRect);
        this.onPaddingUpdated(mTmpRect);
        mShadowViewDelegate.setShadowPadding(mTmpRect.left, mTmpRect.top, mTmpRect.right, mTmpRect.bottom);
    }
}
