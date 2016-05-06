package android.support.design.widget;

import android.view.animation.Transformation;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.graphics.PorterDuff$Mode;
import android.view.animation.Animation$AnimationListener;
import android.support.design.R;
import android.support.annotation.Nullable;
import android.graphics.Rect;
import android.content.res.ColorStateList;
import android.view.animation.Animation;
import android.view.View;

class FloatingActionButtonEclairMr1 extends FloatingActionButtonImpl
{
    private int mAnimationDuration;
    private boolean mIsHiding;
    ShadowDrawableWrapper mShadowDrawable;
    private StateListAnimator mStateListAnimator;
    
    FloatingActionButtonEclairMr1(final VisibilityAwareImageButton target, final ShadowViewDelegate shadowViewDelegate) {
        super(target, shadowViewDelegate);
        mAnimationDuration = target.getResources().getInteger(17694720);
        (mStateListAnimator = new StateListAnimator()).setTarget((View)target);
        mStateListAnimator.addState(FloatingActionButtonEclairMr1.PRESSED_ENABLED_STATE_SET, this.setupAnimation((Animation)new ElevateToTranslationZAnimation(this)));
        mStateListAnimator.addState(FloatingActionButtonEclairMr1.FOCUSED_ENABLED_STATE_SET, this.setupAnimation((Animation)new ElevateToTranslationZAnimation(this)));
        mStateListAnimator.addState(FloatingActionButtonEclairMr1.EMPTY_STATE_SET, this.setupAnimation((Animation)new ResetElevationAnimation(this)));
    }
    
    static /* synthetic */ boolean access$202(final FloatingActionButtonEclairMr1 floatingActionButtonEclairMr1, final boolean mIsHiding) {
        return floatingActionButtonEclairMr1.mIsHiding = mIsHiding;
    }
    
    private static ColorStateList createColorStateList(final int n) {
        final int[][] array = new int[3][];
        final int[] array2 = new int[3];
        array[0] = FloatingActionButtonEclairMr1.FOCUSED_ENABLED_STATE_SET;
        array2[0] = n;
        final int n2 = 0 + 1;
        array[n2] = FloatingActionButtonEclairMr1.PRESSED_ENABLED_STATE_SET;
        array2[n2] = n;
        final int n3 = n2 + 1;
        array[n3] = new int[0];
        array2[n3] = 0;
        return new ColorStateList(array, array2);
    }
    
    private Animation setupAnimation(final Animation animation) {
        animation.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        animation.setDuration((long)mAnimationDuration);
        return animation;
    }
    
    @Override
    float getElevation() {
        return this.mElevation;
    }
    
    @Override
    void getPadding(final Rect rect) {
        mShadowDrawable.getPadding(rect);
    }
    
    @Override
    void hide(@Nullable final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean b) {
        if (mIsHiding || this.mView.getVisibility() != 0) {
            if (internalVisibilityChangedListener != null) {
                internalVisibilityChangedListener.onHidden();
            }
            return;
        }
        final Animation loadAnimation = android.view.animation.AnimationUtils.loadAnimation(this.mView.getContext(), R.anim.design_fab_out);
        loadAnimation.setInterpolator(AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        loadAnimation.setDuration(200L);
        loadAnimation.setAnimationListener((Animation$AnimationListener)new AnimationUtils.AnimationListenerAdapter() {
            final /* synthetic */ FloatingActionButtonEclairMr1 this$0;
            final /* synthetic */ boolean val$fromUser;
            final /* synthetic */ InternalVisibilityChangedListener val$listener;
            
            FloatingActionButtonEclairMr1$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onAnimationEnd(final Animation animation) {
                mIsHiding = false;
                this$0.mView.internalSetVisibility(8, b);
                if (internalVisibilityChangedListener != null) {
                    internalVisibilityChangedListener.onHidden();
                }
            }
            
            @Override
            public void onAnimationStart(final Animation animation) {
                mIsHiding = true;
            }
        });
        this.mView.startAnimation(loadAnimation);
    }
    
    @Override
    void jumpDrawableToCurrentState() {
        mStateListAnimator.jumpToCurrentState();
    }
    
    @Override
    void onCompatShadowChanged() {
    }
    
    @Override
    void onDrawableStateChanged(final int[] state) {
        mStateListAnimator.setState(state);
    }
    
    @Override
    void onElevationChanged(final float n) {
        if (mShadowDrawable != null) {
            mShadowDrawable.setShadowSize(n, n + this.mPressedTranslationZ);
            this.updatePadding();
        }
    }
    
    @Override
    void onTranslationZChanged(final float n) {
        if (mShadowDrawable != null) {
            mShadowDrawable.setMaxShadowSize(n + this.mElevation);
            this.updatePadding();
        }
    }
    
    @Override
    void setBackgroundDrawable(final ColorStateList list, final PorterDuff$Mode porterDuff$Mode, final int n, final int n2) {
        DrawableCompat.setTintList(this.mShapeDrawable = DrawableCompat.wrap((Drawable)this.createShapeDrawable()), list);
        if (porterDuff$Mode != null) {
            DrawableCompat.setTintMode(this.mShapeDrawable, porterDuff$Mode);
        }
        DrawableCompat.setTintList(this.mRippleDrawable = DrawableCompat.wrap((Drawable)this.createShapeDrawable()), createColorStateList(n));
        Drawable[] array;
        if (n2 > 0) {
            this.mBorderDrawable = this.createBorderDrawable(n2, list);
            array = new Drawable[] { this.mBorderDrawable, this.mShapeDrawable, this.mRippleDrawable };
        }
        else {
            this.mBorderDrawable = null;
            array = new Drawable[] { this.mShapeDrawable, this.mRippleDrawable };
        }
        this.mContentBackground = (Drawable)new LayerDrawable(array);
        (mShadowDrawable = new ShadowDrawableWrapper(this.mView.getResources(), this.mContentBackground, this.mShadowViewDelegate.getRadius(), this.mElevation, this.mElevation + this.mPressedTranslationZ)).setAddPaddingForCorners(false);
        this.mShadowViewDelegate.setBackgroundDrawable(mShadowDrawable);
    }
    
    @Override
    void setBackgroundTintList(final ColorStateList borderTint) {
        if (this.mShapeDrawable != null) {
            DrawableCompat.setTintList(this.mShapeDrawable, borderTint);
        }
        if (this.mBorderDrawable != null) {
            this.mBorderDrawable.setBorderTint(borderTint);
        }
    }
    
    @Override
    void setBackgroundTintMode(final PorterDuff$Mode porterDuff$Mode) {
        if (this.mShapeDrawable != null) {
            DrawableCompat.setTintMode(this.mShapeDrawable, porterDuff$Mode);
        }
    }
    
    @Override
    void setRippleColor(final int n) {
        if (this.mRippleDrawable != null) {
            DrawableCompat.setTintList(this.mRippleDrawable, createColorStateList(n));
        }
    }
    
    @Override
    void show(@Nullable final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean b) {
        if (this.mView.getVisibility() != 0 || mIsHiding) {
            this.mView.clearAnimation();
            this.mView.internalSetVisibility(0, b);
            final Animation loadAnimation = android.view.animation.AnimationUtils.loadAnimation(this.mView.getContext(), R.anim.design_fab_in);
            loadAnimation.setDuration(200L);
            loadAnimation.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
            loadAnimation.setAnimationListener((Animation$AnimationListener)new AnimationUtils.AnimationListenerAdapter() {
                final /* synthetic */ FloatingActionButtonEclairMr1 this$0;
                final /* synthetic */ InternalVisibilityChangedListener val$listener;
                
                FloatingActionButtonEclairMr1$2() {
                    this$0 = this$0;
                    super();
                }
                
                @Override
                public void onAnimationEnd(final Animation animation) {
                    if (internalVisibilityChangedListener != null) {
                        internalVisibilityChangedListener.onShown();
                    }
                }
            });
            this.mView.startAnimation(loadAnimation);
        }
        else if (internalVisibilityChangedListener != null) {
            internalVisibilityChangedListener.onShown();
        }
    }
}
