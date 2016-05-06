package android.support.design.internal;

import android.graphics.drawable.Drawable$Callback;
import android.view.Gravity;
import android.support.annotation.NonNull;
import android.graphics.Canvas;
import android.content.res.TypedArray;
import android.support.design.R;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutCompat;

public class ForegroundLinearLayout extends LinearLayoutCompat
{
    private Drawable mForeground;
    boolean mForegroundBoundsChanged;
    private int mForegroundGravity;
    protected boolean mForegroundInPadding;
    private final Rect mOverlayBounds;
    private final Rect mSelfBounds;
    
    public ForegroundLinearLayout(final Context context) {
        this(context, null);
    }
    
    public ForegroundLinearLayout(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public ForegroundLinearLayout(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        mSelfBounds = new Rect();
        mOverlayBounds = new Rect();
        mForegroundGravity = 119;
        mForegroundInPadding = true;
        mForegroundBoundsChanged = false;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.ForegroundLinearLayout, n, 0);
        mForegroundGravity = obtainStyledAttributes.getInt(R.styleable.ForegroundLinearLayout_android_foregroundGravity, mForegroundGravity);
        final Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            this.setForeground(drawable);
        }
        mForegroundInPadding = obtainStyledAttributes.getBoolean(R.styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
        obtainStyledAttributes.recycle();
    }
    
    public void draw(@NonNull final Canvas canvas) {
        super.draw(canvas);
        if (mForeground != null) {
            final Drawable mForeground = this.mForeground;
            if (mForegroundBoundsChanged) {
                mForegroundBoundsChanged = false;
                final Rect mSelfBounds = this.mSelfBounds;
                final Rect mOverlayBounds = this.mOverlayBounds;
                final int n = this.getRight() - this.getLeft();
                final int n2 = this.getBottom() - this.getTop();
                if (mForegroundInPadding) {
                    mSelfBounds.set(0, 0, n, n2);
                }
                else {
                    mSelfBounds.set(this.getPaddingLeft(), this.getPaddingTop(), n - this.getPaddingRight(), n2 - this.getPaddingBottom());
                }
                Gravity.apply(mForegroundGravity, mForeground.getIntrinsicWidth(), mForeground.getIntrinsicHeight(), mSelfBounds, mOverlayBounds);
                mForeground.setBounds(mOverlayBounds);
            }
            mForeground.draw(canvas);
        }
    }
    
    public void drawableHotspotChanged(final float n, final float n2) {
        super.drawableHotspotChanged(n, n2);
        if (mForeground != null) {
            mForeground.setHotspot(n, n2);
        }
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (mForeground != null && mForeground.isStateful()) {
            mForeground.setState(this.getDrawableState());
        }
    }
    
    public Drawable getForeground() {
        return mForeground;
    }
    
    public int getForegroundGravity() {
        return mForegroundGravity;
    }
    
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (mForeground != null) {
            mForeground.jumpToCurrentState();
        }
    }
    
    @Override
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        mForegroundBoundsChanged |= b;
    }
    
    protected void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        mForegroundBoundsChanged = true;
    }
    
    public void setForeground(final Drawable mForeground) {
        if (this.mForeground != mForeground) {
            if (this.mForeground != null) {
                this.mForeground.setCallback((Drawable$Callback)null);
                this.unscheduleDrawable(this.mForeground);
            }
            if ((this.mForeground = mForeground) != null) {
                this.setWillNotDraw(false);
                mForeground.setCallback((Drawable$Callback)this);
                if (mForeground.isStateful()) {
                    mForeground.setState(this.getDrawableState());
                }
                if (mForegroundGravity == 119) {
                    mForeground.getPadding(new Rect());
                }
            }
            else {
                this.setWillNotDraw(true);
            }
            this.requestLayout();
            this.invalidate();
        }
    }
    
    public void setForegroundGravity(int mForegroundGravity) {
        if (this.mForegroundGravity != mForegroundGravity) {
            if ((0x800007 & mForegroundGravity) == 0x0) {
                mForegroundGravity |= 0x800003;
            }
            if ((mForegroundGravity & 0x70) == 0x0) {
                mForegroundGravity |= 0x30;
            }
            this.mForegroundGravity = mForegroundGravity;
            if (this.mForegroundGravity == 119 && mForeground != null) {
                mForeground.getPadding(new Rect());
            }
            this.requestLayout();
        }
    }
    
    protected boolean verifyDrawable(final Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == mForeground;
    }
}
