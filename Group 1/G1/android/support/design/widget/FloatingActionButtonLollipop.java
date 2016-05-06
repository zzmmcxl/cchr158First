package android.support.design.widget;

import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.Rect;
import android.animation.TimeInterpolator;
import android.animation.Animator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.graphics.drawable.InsetDrawable;
import android.annotation.TargetApi;

@TargetApi(21)
class FloatingActionButtonLollipop extends FloatingActionButtonIcs
{
    private InsetDrawable mInsetDrawable;
    private final Interpolator mInterpolator;
    
    FloatingActionButtonLollipop(final VisibilityAwareImageButton visibilityAwareImageButton, final ShadowViewDelegate shadowViewDelegate) {
        super(visibilityAwareImageButton, shadowViewDelegate);
        Interpolator loadInterpolator;
        if (visibilityAwareImageButton.isInEditMode()) {
            loadInterpolator = null;
        }
        else {
            loadInterpolator = AnimationUtils.loadInterpolator(this.mView.getContext(), 17563661);
        }
        mInterpolator = loadInterpolator;
    }
    
    private Animator setupAnimator(final Animator animator) {
        animator.setInterpolator((TimeInterpolator)mInterpolator);
        return animator;
    }
    
    public float getElevation() {
        return this.mView.getElevation();
    }
    
    @Override
    void getPadding(final Rect rect) {
        if (this.mShadowViewDelegate.isCompatPaddingEnabled()) {
            final float radius = this.mShadowViewDelegate.getRadius();
            final float n = this.getElevation() + this.mPressedTranslationZ;
            final int n2 = (int)Math.ceil(ShadowDrawableWrapper.calculateHorizontalPadding(n, radius, false));
            final int n3 = (int)Math.ceil(ShadowDrawableWrapper.calculateVerticalPadding(n, radius, false));
            rect.set(n2, n3, n2, n3);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
    
    @Override
    void jumpDrawableToCurrentState() {
    }
    
    @Override
    CircularBorderDrawable newCircularDrawable() {
        return new CircularBorderDrawableLollipop();
    }
    
    @Override
    void onCompatShadowChanged() {
        this.updatePadding();
    }
    
    @Override
    void onDrawableStateChanged(final int[] array) {
    }
    
    public void onElevationChanged(final float elevation) {
        this.mView.setElevation(elevation);
        if (this.mShadowViewDelegate.isCompatPaddingEnabled()) {
            this.updatePadding();
        }
    }
    
    @Override
    void onPaddingUpdated(final Rect rect) {
        if (this.mShadowViewDelegate.isCompatPaddingEnabled()) {
            mInsetDrawable = new InsetDrawable(this.mRippleDrawable, rect.left, rect.top, rect.right, rect.bottom);
            this.mShadowViewDelegate.setBackgroundDrawable((Drawable)mInsetDrawable);
            return;
        }
        this.mShadowViewDelegate.setBackgroundDrawable(this.mRippleDrawable);
    }
    
    @Override
    void onTranslationZChanged(final float n) {
        final StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(FloatingActionButtonLollipop.PRESSED_ENABLED_STATE_SET, this.setupAnimator((Animator)ObjectAnimator.ofFloat((Object)this.mView, "translationZ", new float[] { n })));
        stateListAnimator.addState(FloatingActionButtonLollipop.FOCUSED_ENABLED_STATE_SET, this.setupAnimator((Animator)ObjectAnimator.ofFloat((Object)this.mView, "translationZ", new float[] { n })));
        stateListAnimator.addState(FloatingActionButtonLollipop.EMPTY_STATE_SET, this.setupAnimator((Animator)ObjectAnimator.ofFloat((Object)this.mView, "translationZ", new float[] { 0.0f })));
        this.mView.setStateListAnimator(stateListAnimator);
        if (this.mShadowViewDelegate.isCompatPaddingEnabled()) {
            this.updatePadding();
        }
    }
    
    @Override
    boolean requirePreDrawListener() {
        return false;
    }
    
    @Override
    void setBackgroundDrawable(final ColorStateList list, final PorterDuff$Mode porterDuff$Mode, final int n, final int n2) {
        DrawableCompat.setTintList(this.mShapeDrawable = DrawableCompat.wrap((Drawable)this.createShapeDrawable()), list);
        if (porterDuff$Mode != null) {
            DrawableCompat.setTintMode(this.mShapeDrawable, porterDuff$Mode);
        }
        Object mShapeDrawable;
        if (n2 > 0) {
            this.mBorderDrawable = this.createBorderDrawable(n2, list);
            mShapeDrawable = new LayerDrawable(new Drawable[] { this.mBorderDrawable, this.mShapeDrawable });
        }
        else {
            this.mBorderDrawable = null;
            mShapeDrawable = this.mShapeDrawable;
        }
        this.mRippleDrawable = (Drawable)new RippleDrawable(ColorStateList.valueOf(n), (Drawable)mShapeDrawable, (Drawable)null);
        this.mContentBackground = this.mRippleDrawable;
        this.mShadowViewDelegate.setBackgroundDrawable(this.mRippleDrawable);
    }
    
    @Override
    void setRippleColor(final int rippleColor) {
        if (this.mRippleDrawable instanceof RippleDrawable) {
            ((RippleDrawable)this.mRippleDrawable).setColor(ColorStateList.valueOf(rippleColor));
            return;
        }
        super.setRippleColor(rippleColor);
    }
}
