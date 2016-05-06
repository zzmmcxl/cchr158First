package android.support.design.widget;

import android.view.View$MeasureSpec;
import android.content.res.TypedArray;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.view.ViewCompat;
import android.support.design.R;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.TextView;
import android.widget.Button;
import android.widget.LinearLayout;

public static class SnackbarLayout extends LinearLayout
{
    private Button mActionView;
    private int mMaxInlineActionWidth;
    private int mMaxWidth;
    private TextView mMessageView;
    private OnAttachStateChangeListener mOnAttachStateChangeListener;
    private OnLayoutChangeListener mOnLayoutChangeListener;
    
    public SnackbarLayout(final Context context) {
        this(context, null);
    }
    
    public SnackbarLayout(final Context context, final AttributeSet set) {
        super(context, set);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.SnackbarLayout);
        this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
        this.mMaxInlineActionWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
        if (obtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_elevation)) {
            ViewCompat.setElevation(this, (float)obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0));
        }
        obtainStyledAttributes.recycle();
        this.setClickable(true);
        LayoutInflater.from(context).inflate(R.layout.design_layout_snackbar_include, (ViewGroup)this);
        ViewCompat.setAccessibilityLiveRegion((View)this, 1);
        ViewCompat.setImportantForAccessibility((View)this, 1);
    }
    
    private static void updateTopBottomPadding(final View view, final int n, final int n2) {
        if (ViewCompat.isPaddingRelative(view)) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), n, ViewCompat.getPaddingEnd(view), n2);
            return;
        }
        view.setPadding(view.getPaddingLeft(), n, view.getPaddingRight(), n2);
    }
    
    private boolean updateViewsWithinLayout(final int orientation, final int n, final int n2) {
        final int orientation2 = this.getOrientation();
        boolean b = false;
        if (orientation != orientation2) {
            this.setOrientation(orientation);
            b = true;
        }
        if (mMessageView.getPaddingTop() != n || mMessageView.getPaddingBottom() != n2) {
            updateTopBottomPadding((View)mMessageView, n, n2);
            b = true;
        }
        return b;
    }
    
    void animateChildrenIn(final int n, final int n2) {
        ViewCompat.setAlpha((View)mMessageView, 0.0f);
        ViewCompat.animate((View)mMessageView).alpha(1.0f).setDuration(n2).setStartDelay(n).start();
        if (mActionView.getVisibility() == 0) {
            ViewCompat.setAlpha((View)mActionView, 0.0f);
            ViewCompat.animate((View)mActionView).alpha(1.0f).setDuration(n2).setStartDelay(n).start();
        }
    }
    
    void animateChildrenOut(final int n, final int n2) {
        ViewCompat.setAlpha((View)mMessageView, 1.0f);
        ViewCompat.animate((View)mMessageView).alpha(0.0f).setDuration(n2).setStartDelay(n).start();
        if (mActionView.getVisibility() == 0) {
            ViewCompat.setAlpha((View)mActionView, 1.0f);
            ViewCompat.animate((View)mActionView).alpha(0.0f).setDuration(n2).setStartDelay(n).start();
        }
    }
    
    Button getActionView() {
        return mActionView;
    }
    
    TextView getMessageView() {
        return mMessageView;
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mOnAttachStateChangeListener != null) {
            mOnAttachStateChangeListener.onViewAttachedToWindow((View)this);
        }
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mOnAttachStateChangeListener != null) {
            mOnAttachStateChangeListener.onViewDetachedFromWindow((View)this);
        }
    }
    
    protected void onFinishInflate() {
        super.onFinishInflate();
        mMessageView = (TextView)this.findViewById(R.id.snackbar_text);
        mActionView = (Button)this.findViewById(R.id.snackbar_action);
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        if (mOnLayoutChangeListener != null) {
            mOnLayoutChangeListener.onLayoutChange((View)this, n, n2, n3, n4);
        }
    }
    
    protected void onMeasure(int measureSpec, final int n) {
        super.onMeasure(measureSpec, n);
        if (mMaxWidth > 0 && this.getMeasuredWidth() > mMaxWidth) {
            measureSpec = View$MeasureSpec.makeMeasureSpec(mMaxWidth, 1073741824);
            super.onMeasure(measureSpec, n);
        }
        final int dimensionPixelSize = this.getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
        final int dimensionPixelSize2 = this.getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
        boolean b;
        if (mMessageView.getLayout().getLineCount() > 1) {
            b = true;
        }
        else {
            b = false;
        }
        int n2;
        if (b && mMaxInlineActionWidth > 0 && mActionView.getMeasuredWidth() > mMaxInlineActionWidth) {
            final boolean updateViewsWithinLayout = this.updateViewsWithinLayout(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2);
            n2 = 0;
            if (updateViewsWithinLayout) {
                n2 = 1;
            }
        }
        else {
            int n3;
            if (b) {
                n3 = dimensionPixelSize;
            }
            else {
                n3 = dimensionPixelSize2;
            }
            final boolean updateViewsWithinLayout2 = this.updateViewsWithinLayout(0, n3, n3);
            n2 = 0;
            if (updateViewsWithinLayout2) {
                n2 = 1;
            }
        }
        if (n2 != 0) {
            super.onMeasure(measureSpec, n);
        }
    }
    
    void setOnAttachStateChangeListener(final OnAttachStateChangeListener mOnAttachStateChangeListener) {
        this.mOnAttachStateChangeListener = mOnAttachStateChangeListener;
    }
    
    void setOnLayoutChangeListener(final OnLayoutChangeListener mOnLayoutChangeListener) {
        this.mOnLayoutChangeListener = mOnLayoutChangeListener;
    }
}
