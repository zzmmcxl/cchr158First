package android.support.v4.widget;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import android.content.res.TypedArray;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.annotation.DrawableRes;
import android.os.Parcelable;
import android.view.View$MeasureSpec;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.support.annotation.ColorInt;
import android.view.ViewGroup$MarginLayoutParams;
import android.graphics.Bitmap;
import android.util.Log;
import android.graphics.Canvas;
import android.view.ViewGroup$LayoutParams;
import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.Paint;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.view.ViewConfiguration;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Build$VERSION;
import android.graphics.Rect;
import android.view.View;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import android.view.ViewGroup;

public class SlidingPaneLayout extends ViewGroup
{
    private static final int DEFAULT_FADE_COLOR = -858993460;
    private static final int DEFAULT_OVERHANG_SIZE = 32;
    static final SlidingPanelLayoutImpl IMPL;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final String TAG = "SlidingPaneLayout";
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    private final ViewDragHelper mDragHelper;
    private boolean mFirstLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsUnableToDrag;
    private final int mOverhangSize;
    private PanelSlideListener mPanelSlideListener;
    private int mParallaxBy;
    private float mParallaxOffset;
    private final ArrayList<DisableLayerRunnable> mPostedRunnables;
    private boolean mPreservedOpenState;
    private Drawable mShadowDrawableLeft;
    private Drawable mShadowDrawableRight;
    private float mSlideOffset;
    private int mSlideRange;
    private View mSlideableView;
    private int mSliderFadeColor;
    private final Rect mTmpRect;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 17) {
            IMPL = (SlidingPanelLayoutImpl)new SlidingPanelLayoutImplJBMR1();
            return;
        }
        if (sdk_INT >= 16) {
            IMPL = (SlidingPanelLayoutImpl)new SlidingPanelLayoutImplJB();
            return;
        }
        IMPL = (SlidingPanelLayoutImpl)new SlidingPanelLayoutImplBase();
    }
    
    public SlidingPaneLayout(final Context context) {
        this(context, null);
    }
    
    public SlidingPaneLayout(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public SlidingPaneLayout(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        mSliderFadeColor = -858993460;
        mFirstLayout = true;
        mTmpRect = new Rect();
        mPostedRunnables = new ArrayList<DisableLayerRunnable>();
        final float density = context.getResources().getDisplayMetrics().density;
        mOverhangSize = (int)(0.5f + 32.0f * density);
        ViewConfiguration.get(context);
        this.setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, (AccessibilityDelegateCompat)new AccessibilityDelegate());
        ViewCompat.setImportantForAccessibility((View)this, 1);
        (mDragHelper = ViewDragHelper.create(this, 0.5f, (ViewDragHelper.Callback)new DragHelperCallback(this))).setMinVelocity(400.0f * density);
    }
    
    static /* synthetic */ boolean access$100(final SlidingPaneLayout slidingPaneLayout) {
        return slidingPaneLayout.mIsUnableToDrag;
    }
    
    static /* synthetic */ void access$1000(final SlidingPaneLayout slidingPaneLayout, final View view) {
        slidingPaneLayout.invalidateChildRegion(view);
    }
    
    static /* synthetic */ ArrayList access$1100(final SlidingPaneLayout slidingPaneLayout) {
        return slidingPaneLayout.mPostedRunnables;
    }
    
    static /* synthetic */ ViewDragHelper access$200(final SlidingPaneLayout slidingPaneLayout) {
        return slidingPaneLayout.mDragHelper;
    }
    
    static /* synthetic */ float access$300(final SlidingPaneLayout slidingPaneLayout) {
        return slidingPaneLayout.mSlideOffset;
    }
    
    static /* synthetic */ View access$400(final SlidingPaneLayout slidingPaneLayout) {
        return slidingPaneLayout.mSlideableView;
    }
    
    static /* synthetic */ boolean access$502(final SlidingPaneLayout slidingPaneLayout, final boolean mPreservedOpenState) {
        return slidingPaneLayout.mPreservedOpenState = mPreservedOpenState;
    }
    
    static /* synthetic */ void access$600(final SlidingPaneLayout slidingPaneLayout, final int n) {
        slidingPaneLayout.onPanelDragged(n);
    }
    
    static /* synthetic */ boolean access$700(final SlidingPaneLayout slidingPaneLayout) {
        return slidingPaneLayout.isLayoutRtlSupport();
    }
    
    static /* synthetic */ int access$800(final SlidingPaneLayout slidingPaneLayout) {
        return slidingPaneLayout.mSlideRange;
    }
    
    private boolean closePane(final View view, final int n) {
        if (!mFirstLayout) {
            final boolean smoothSlideTo = this.smoothSlideTo(0.0f, n);
            final boolean b = false;
            if (!smoothSlideTo) {
                return b;
            }
        }
        mPreservedOpenState = false;
        return true;
    }
    
    private void dimChildView(final View view, final float n, final int n2) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (n > 0.0f && n2 != 0) {
            final int n3 = (int)(n * ((0xFF000000 & n2) >>> 24)) << 24 | (0xFFFFFF & n2);
            if (layoutParams.dimPaint == null) {
                layoutParams.dimPaint = new Paint();
            }
            layoutParams.dimPaint.setColorFilter((ColorFilter)new PorterDuffColorFilter(n3, PorterDuff$Mode.SRC_OVER));
            if (ViewCompat.getLayerType(view) != 2) {
                ViewCompat.setLayerType(view, 2, layoutParams.dimPaint);
            }
            this.invalidateChildRegion(view);
        }
        else if (ViewCompat.getLayerType(view) != 0) {
            if (layoutParams.dimPaint != null) {
                layoutParams.dimPaint.setColorFilter((ColorFilter)null);
            }
            final DisableLayerRunnable disableLayerRunnable = new DisableLayerRunnable(view);
            mPostedRunnables.add(disableLayerRunnable);
            ViewCompat.postOnAnimation(this, (Runnable)disableLayerRunnable);
        }
    }
    
    private void invalidateChildRegion(final View view) {
        IMPL.invalidateChildRegion(this, view);
    }
    
    private boolean isLayoutRtlSupport() {
        return ViewCompat.getLayoutDirection((View)this) == 1;
    }
    
    private void onPanelDragged(final int n) {
        if (mSlideableView == null) {
            mSlideOffset = 0.0f;
            return;
        }
        final boolean layoutRtlSupport = this.isLayoutRtlSupport();
        final LayoutParams layoutParams = (LayoutParams)mSlideableView.getLayoutParams();
        final int width = mSlideableView.getWidth();
        int n2;
        if (layoutRtlSupport) {
            n2 = this.getWidth() - n - width;
        }
        else {
            n2 = n;
        }
        int n3;
        if (layoutRtlSupport) {
            n3 = this.getPaddingRight();
        }
        else {
            n3 = this.getPaddingLeft();
        }
        int n4;
        if (layoutRtlSupport) {
            n4 = layoutParams.rightMargin;
        }
        else {
            n4 = layoutParams.leftMargin;
        }
        mSlideOffset = (n2 - (n3 + n4)) / mSlideRange;
        if (mParallaxBy != 0) {
            this.parallaxOtherViews(mSlideOffset);
        }
        if (layoutParams.dimWhenOffset) {
            this.dimChildView(mSlideableView, mSlideOffset, mSliderFadeColor);
        }
        this.dispatchOnPanelSlide(mSlideableView);
    }
    
    private boolean openPane(final View view, final int n) {
        return (mFirstLayout || this.smoothSlideTo(1.0f, n)) && (mPreservedOpenState = true);
    }
    
    private void parallaxOtherViews(final float mParallaxOffset) {
        final boolean layoutRtlSupport = this.isLayoutRtlSupport();
        final LayoutParams layoutParams = (LayoutParams)mSlideableView.getLayoutParams();
        while (true) {
            Label_0089: {
                if (!layoutParams.dimWhenOffset) {
                    break Label_0089;
                }
                int n;
                if (layoutRtlSupport) {
                    n = layoutParams.rightMargin;
                }
                else {
                    n = layoutParams.leftMargin;
                }
                if (n > 0) {
                    break Label_0089;
                }
                final boolean b = true;
                for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                    final View child = this.getChildAt(i);
                    if (child != mSlideableView) {
                        final int n2 = (int)((1.0f - this.mParallaxOffset) * mParallaxBy);
                        this.mParallaxOffset = mParallaxOffset;
                        int n3 = n2 - (int)((1.0f - mParallaxOffset) * mParallaxBy);
                        if (layoutRtlSupport) {
                            n3 = -n3;
                        }
                        child.offsetLeftAndRight(n3);
                        if (b) {
                            float n4;
                            if (layoutRtlSupport) {
                                n4 = this.mParallaxOffset - 1.0f;
                            }
                            else {
                                n4 = 1.0f - this.mParallaxOffset;
                            }
                            this.dimChildView(child, n4, mCoveredFadeColor);
                        }
                    }
                }
                return;
            }
            final boolean b = false;
            continue;
        }
    }
    
    private static boolean viewIsOpaque(final View view) {
        if (!ViewCompat.isOpaque(view)) {
            if (Build$VERSION.SDK_INT >= 18) {
                return false;
            }
            final Drawable background = view.getBackground();
            if (background == null) {
                return false;
            }
            if (background.getOpacity() != -1) {
                return false;
            }
        }
        return true;
    }
    
    protected boolean canScroll(final View view, final boolean b, int n, final int n2, final int n3) {
        if (view instanceof ViewGroup) {
            final ViewGroup viewGroup = (ViewGroup)view;
            final int scrollX = view.getScrollX();
            final int scrollY = view.getScrollY();
            for (int i = -1 + viewGroup.getChildCount(); i >= 0; --i) {
                final View child = viewGroup.getChildAt(i);
                if (n2 + scrollX >= child.getLeft() && n2 + scrollX < child.getRight() && n3 + scrollY >= child.getTop() && n3 + scrollY < child.getBottom() && this.canScroll(child, true, n, n2 + scrollX - child.getLeft(), n3 + scrollY - child.getTop())) {
                    return true;
                }
            }
        }
        if (b) {
            if (!this.isLayoutRtlSupport()) {
                n = -n;
            }
            if (ViewCompat.canScrollHorizontally(view, n)) {
                return true;
            }
        }
        return false;
    }
    
    @Deprecated
    public boolean canSlide() {
        return mCanSlide;
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof LayoutParams && super.checkLayoutParams(viewGroup$LayoutParams);
    }
    
    public boolean closePane() {
        return this.closePane(mSlideableView, 0);
    }
    
    public void computeScroll() {
        if (mDragHelper.continueSettling(true)) {
            if (mCanSlide) {
                ViewCompat.postInvalidateOnAnimation((View)this);
                return;
            }
            mDragHelper.abort();
        }
    }
    
    void dispatchOnPanelClosed(final View view) {
        if (mPanelSlideListener != null) {
            mPanelSlideListener.onPanelClosed(view);
        }
        this.sendAccessibilityEvent(32);
    }
    
    void dispatchOnPanelOpened(final View view) {
        if (mPanelSlideListener != null) {
            mPanelSlideListener.onPanelOpened(view);
        }
        this.sendAccessibilityEvent(32);
    }
    
    void dispatchOnPanelSlide(final View view) {
        if (mPanelSlideListener != null) {
            mPanelSlideListener.onPanelSlide(view, mSlideOffset);
        }
    }
    
    public void draw(final Canvas canvas) {
        super.draw(canvas);
        Drawable drawable;
        if (this.isLayoutRtlSupport()) {
            drawable = mShadowDrawableRight;
        }
        else {
            drawable = mShadowDrawableLeft;
        }
        View child;
        if (this.getChildCount() > 1) {
            child = this.getChildAt(1);
        }
        else {
            child = null;
        }
        if (child == null || drawable == null) {
            return;
        }
        final int top = child.getTop();
        final int bottom = child.getBottom();
        final int intrinsicWidth = drawable.getIntrinsicWidth();
        int right;
        int left;
        if (this.isLayoutRtlSupport()) {
            right = child.getRight();
            left = right + intrinsicWidth;
        }
        else {
            left = child.getLeft();
            right = left - intrinsicWidth;
        }
        drawable.setBounds(right, top, left, bottom);
        drawable.draw(canvas);
    }
    
    protected boolean drawChild(final Canvas canvas, final View view, final long n) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        final int save = canvas.save(2);
        if (mCanSlide && !layoutParams.slideable && mSlideableView != null) {
            canvas.getClipBounds(mTmpRect);
            if (this.isLayoutRtlSupport()) {
                mTmpRect.left = Math.max(mTmpRect.left, mSlideableView.getRight());
            }
            else {
                mTmpRect.right = Math.min(mTmpRect.right, mSlideableView.getLeft());
            }
            canvas.clipRect(mTmpRect);
        }
        boolean b;
        if (Build$VERSION.SDK_INT >= 11) {
            b = super.drawChild(canvas, view, n);
        }
        else if (layoutParams.dimWhenOffset && mSlideOffset > 0.0f) {
            if (!view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(true);
            }
            final Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                canvas.drawBitmap(drawingCache, (float)view.getLeft(), (float)view.getTop(), layoutParams.dimPaint);
                b = false;
            }
            else {
                Log.e("SlidingPaneLayout", "drawChild: child view " + view + " returned null drawing cache");
                b = super.drawChild(canvas, view, n);
            }
        }
        else {
            if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
            b = super.drawChild(canvas, view, n);
        }
        canvas.restoreToCount(save);
        return b;
    }
    
    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)new LayoutParams();
    }
    
    public ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)new LayoutParams(this.getContext(), set);
    }
    
    protected ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams) {
            return (ViewGroup$LayoutParams)new LayoutParams((ViewGroup$MarginLayoutParams)viewGroup$LayoutParams);
        }
        return (ViewGroup$LayoutParams)new LayoutParams(viewGroup$LayoutParams);
    }
    
    @ColorInt
    public int getCoveredFadeColor() {
        return mCoveredFadeColor;
    }
    
    public int getParallaxDistance() {
        return mParallaxBy;
    }
    
    @ColorInt
    public int getSliderFadeColor() {
        return mSliderFadeColor;
    }
    
    boolean isDimmed(final View view) {
        if (view != null) {
            final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            if (mCanSlide && layoutParams.dimWhenOffset && mSlideOffset > 0.0f) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isOpen() {
        return !mCanSlide || mSlideOffset == 1.0f;
    }
    
    public boolean isSlideable() {
        return mCanSlide;
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mFirstLayout = true;
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mFirstLayout = true;
        for (int i = 0; i < mPostedRunnables.size(); ++i) {
            ((DisableLayerRunnable)mPostedRunnables.get(i)).run();
        }
        mPostedRunnables.clear();
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (!mCanSlide && actionMasked == 0 && this.getChildCount() > 1) {
            final View child = this.getChildAt(1);
            if (child != null) {
                mPreservedOpenState = !mDragHelper.isViewUnder(child, (int)motionEvent.getX(), (int)motionEvent.getY());
            }
        }
        if (!mCanSlide || (mIsUnableToDrag && actionMasked != 0)) {
            mDragHelper.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked == 3 || actionMasked == 1) {
            mDragHelper.cancel();
            return false;
        }
        boolean b = false;
        switch (actionMasked) {
            case 0: {
                mIsUnableToDrag = false;
                final float x = motionEvent.getX();
                final float y = motionEvent.getY();
                mInitialMotionX = x;
                mInitialMotionY = y;
                final boolean viewUnder = mDragHelper.isViewUnder(mSlideableView, (int)x, (int)y);
                b = false;
                if (!viewUnder) {
                    break;
                }
                final boolean dimmed = this.isDimmed(mSlideableView);
                b = false;
                if (dimmed) {
                    b = true;
                    break;
                }
                break;
            }
            case 2: {
                final float x2 = motionEvent.getX();
                final float y2 = motionEvent.getY();
                final float abs = Math.abs(x2 - mInitialMotionX);
                final float abs2 = Math.abs(y2 - mInitialMotionY);
                final float n = fcmpl(abs, (float)mDragHelper.getTouchSlop());
                b = false;
                if (n <= 0) {
                    break;
                }
                final float n2 = fcmpl(abs2, abs);
                b = false;
                if (n2 > 0) {
                    mDragHelper.cancel();
                    mIsUnableToDrag = true;
                    return false;
                }
                break;
            }
        }
        return mDragHelper.shouldInterceptTouchEvent(motionEvent) || b;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        final boolean layoutRtlSupport = this.isLayoutRtlSupport();
        if (layoutRtlSupport) {
            mDragHelper.setEdgeTrackingEnabled(2);
        }
        else {
            mDragHelper.setEdgeTrackingEnabled(1);
        }
        final int n5 = n3 - n;
        int n6;
        if (layoutRtlSupport) {
            n6 = this.getPaddingRight();
        }
        else {
            n6 = this.getPaddingLeft();
        }
        int n7;
        if (layoutRtlSupport) {
            n7 = this.getPaddingLeft();
        }
        else {
            n7 = this.getPaddingRight();
        }
        final int paddingTop = this.getPaddingTop();
        final int childCount = this.getChildCount();
        int n9;
        int n8 = n9 = n6;
        if (mFirstLayout) {
            float mSlideOffset;
            if (mCanSlide && mPreservedOpenState) {
                mSlideOffset = 1.0f;
            }
            else {
                mSlideOffset = 0.0f;
            }
            this.mSlideOffset = mSlideOffset;
        }
        for (int i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
                final int measuredWidth = child.getMeasuredWidth();
                int n10 = 0;
                if (layoutParams.slideable) {
                    final int mSlideRange = Math.min(n9, n5 - n7 - mOverhangSize) - n8 - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.mSlideRange = mSlideRange;
                    int n11;
                    if (layoutRtlSupport) {
                        n11 = layoutParams.rightMargin;
                    }
                    else {
                        n11 = layoutParams.leftMargin;
                    }
                    layoutParams.dimWhenOffset = (mSlideRange + (n8 + n11) + measuredWidth / 2 > n5 - n7);
                    final int n12 = (int)(mSlideRange * mSlideOffset);
                    n8 += n12 + n11;
                    mSlideOffset = n12 / this.mSlideRange;
                }
                else if (mCanSlide && mParallaxBy != 0) {
                    n10 = (int)((1.0f - mSlideOffset) * mParallaxBy);
                    n8 = n9;
                }
                else {
                    n8 = n9;
                    n10 = 0;
                }
                int n13;
                int n14;
                if (layoutRtlSupport) {
                    n13 = n10 + (n5 - n8);
                    n14 = n13 - measuredWidth;
                }
                else {
                    n14 = n8 - n10;
                    n13 = n14 + measuredWidth;
                }
                child.layout(n14, paddingTop, n13, paddingTop + child.getMeasuredHeight());
                n9 += child.getWidth();
            }
        }
        if (mFirstLayout) {
            if (mCanSlide) {
                if (mParallaxBy != 0) {
                    this.parallaxOtherViews(mSlideOffset);
                }
                if (((LayoutParams)mSlideableView.getLayoutParams()).dimWhenOffset) {
                    this.dimChildView(mSlideableView, mSlideOffset, mSliderFadeColor);
                }
            }
            else {
                for (int j = 0; j < childCount; ++j) {
                    this.dimChildView(this.getChildAt(j), 0.0f, mSliderFadeColor);
                }
            }
            this.updateObscuredViewsVisibility(mSlideableView);
        }
        mFirstLayout = false;
    }
    
    protected void onMeasure(final int n, final int n2) {
        final int mode = View$MeasureSpec.getMode(n);
        int size = View$MeasureSpec.getSize(n);
        int mode2 = View$MeasureSpec.getMode(n2);
        int size2 = View$MeasureSpec.getSize(n2);
        if (mode != 1073741824) {
            if (!this.isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
        }
        else if (mode2 == 0) {
            if (!this.isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            }
            if (mode2 == 0) {
                mode2 = Integer.MIN_VALUE;
                size2 = 300;
            }
        }
        int n3 = -1;
        int min = 0;
        switch (mode2) {
            case 1073741824:
                n3 = (min = size2 - this.getPaddingTop() - this.getPaddingBottom());
                break;
            case Integer.MIN_VALUE:
                n3 = size2 - this.getPaddingTop() - this.getPaddingBottom();
                min = 0;
                break;
        }
        float n4 = 0.0f;
        boolean mCanSlide = false;
        int n6;
        final int n5 = n6 = size - this.getPaddingLeft() - this.getPaddingRight();
        final int childCount = this.getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        mSlideableView = null;
        for (int i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
            if (child.getVisibility() == 8) {
                layoutParams.dimWhenOffset = false;
            }
            else {
                if (layoutParams.weight > 0.0f) {
                    n4 += layoutParams.weight;
                    if (layoutParams.width == 0) {
                        continue;
                    }
                }
                final int n7 = layoutParams.leftMargin + layoutParams.rightMargin;
                int n8;
                if (layoutParams.width == -2) {
                    n8 = View$MeasureSpec.makeMeasureSpec(n5 - n7, Integer.MIN_VALUE);
                }
                else if (layoutParams.width == -1) {
                    n8 = View$MeasureSpec.makeMeasureSpec(n5 - n7, 1073741824);
                }
                else {
                    n8 = View$MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                }
                int n9;
                if (layoutParams.height == -2) {
                    n9 = View$MeasureSpec.makeMeasureSpec(n3, Integer.MIN_VALUE);
                }
                else if (layoutParams.height == -1) {
                    n9 = View$MeasureSpec.makeMeasureSpec(n3, 1073741824);
                }
                else {
                    n9 = View$MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                }
                child.measure(n8, n9);
                final int measuredWidth = child.getMeasuredWidth();
                final int measuredHeight = child.getMeasuredHeight();
                if (mode2 == Integer.MIN_VALUE && measuredHeight > min) {
                    min = Math.min(measuredHeight, n3);
                }
                n6 -= measuredWidth;
                final boolean slideable = n6 < 0;
                layoutParams.slideable = slideable;
                mCanSlide |= slideable;
                if (layoutParams.slideable) {
                    mSlideableView = child;
                }
            }
        }
        if (mCanSlide || n4 > 0.0f) {
            final int n10 = n5 - mOverhangSize;
            for (int j = 0; j < childCount; ++j) {
                final View child2 = this.getChildAt(j);
                if (child2.getVisibility() != 8) {
                    final LayoutParams layoutParams2 = (LayoutParams)child2.getLayoutParams();
                    if (child2.getVisibility() != 8) {
                        boolean b;
                        if (layoutParams2.width == 0 && layoutParams2.weight > 0.0f) {
                            b = true;
                        }
                        else {
                            b = false;
                        }
                        int measuredWidth2;
                        if (b) {
                            measuredWidth2 = 0;
                        }
                        else {
                            measuredWidth2 = child2.getMeasuredWidth();
                        }
                        if (mCanSlide && child2 != mSlideableView) {
                            if (layoutParams2.width < 0 && (measuredWidth2 > n10 || layoutParams2.weight > 0.0f)) {
                                int n11;
                                if (b) {
                                    if (layoutParams2.height == -2) {
                                        n11 = View$MeasureSpec.makeMeasureSpec(n3, Integer.MIN_VALUE);
                                    }
                                    else if (layoutParams2.height == -1) {
                                        n11 = View$MeasureSpec.makeMeasureSpec(n3, 1073741824);
                                    }
                                    else {
                                        n11 = View$MeasureSpec.makeMeasureSpec(layoutParams2.height, 1073741824);
                                    }
                                }
                                else {
                                    n11 = View$MeasureSpec.makeMeasureSpec(child2.getMeasuredHeight(), 1073741824);
                                }
                                child2.measure(View$MeasureSpec.makeMeasureSpec(n10, 1073741824), n11);
                            }
                        }
                        else if (layoutParams2.weight > 0.0f) {
                            int n12;
                            if (layoutParams2.width == 0) {
                                if (layoutParams2.height == -2) {
                                    n12 = View$MeasureSpec.makeMeasureSpec(n3, Integer.MIN_VALUE);
                                }
                                else if (layoutParams2.height == -1) {
                                    n12 = View$MeasureSpec.makeMeasureSpec(n3, 1073741824);
                                }
                                else {
                                    n12 = View$MeasureSpec.makeMeasureSpec(layoutParams2.height, 1073741824);
                                }
                            }
                            else {
                                n12 = View$MeasureSpec.makeMeasureSpec(child2.getMeasuredHeight(), 1073741824);
                            }
                            if (mCanSlide) {
                                final int n13 = n5 - (layoutParams2.leftMargin + layoutParams2.rightMargin);
                                final int measureSpec = View$MeasureSpec.makeMeasureSpec(n13, 1073741824);
                                if (measuredWidth2 != n13) {
                                    child2.measure(measureSpec, n12);
                                }
                            }
                            else {
                                child2.measure(View$MeasureSpec.makeMeasureSpec(measuredWidth2 + (int)(layoutParams2.weight * Math.max(0, n6) / n4), 1073741824), n12);
                            }
                        }
                    }
                }
            }
        }
        this.setMeasuredDimension(size, min + this.getPaddingTop() + this.getPaddingBottom());
        this.mCanSlide = mCanSlide;
        if (mDragHelper.getViewDragState() != 0 && !mCanSlide) {
            mDragHelper.abort();
        }
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        final SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isOpen) {
            this.openPane();
        }
        else {
            this.closePane();
        }
        mPreservedOpenState = savedState.isOpen;
    }
    
    protected Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState(super.onSaveInstanceState());
        boolean isOpen;
        if (this.isSlideable()) {
            isOpen = this.isOpen();
        }
        else {
            isOpen = mPreservedOpenState;
        }
        savedState.isOpen = isOpen;
        return (Parcelable)savedState;
    }
    
    protected void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        if (n != n3) {
            mFirstLayout = true;
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        boolean onTouchEvent;
        if (!mCanSlide) {
            onTouchEvent = super.onTouchEvent(motionEvent);
        }
        else {
            mDragHelper.processTouchEvent(motionEvent);
            final int action = motionEvent.getAction();
            onTouchEvent = true;
            switch (action & 0xFF) {
                default:
                    return onTouchEvent;
                case 0: {
                    final float x = motionEvent.getX();
                    final float y = motionEvent.getY();
                    mInitialMotionX = x;
                    mInitialMotionY = y;
                    return onTouchEvent;
                }
                case 1: {
                    if (!this.isDimmed(mSlideableView)) {
                        break;
                    }
                    final float x2 = motionEvent.getX();
                    final float y2 = motionEvent.getY();
                    final float n = x2 - mInitialMotionX;
                    final float n2 = y2 - mInitialMotionY;
                    final int touchSlop = mDragHelper.getTouchSlop();
                    if (n * n + n2 * n2 < touchSlop * touchSlop && mDragHelper.isViewUnder(mSlideableView, (int)x2, (int)y2)) {
                        this.closePane(mSlideableView, 0);
                        return onTouchEvent;
                    }
                    break;
                }
            }
        }
        return onTouchEvent;
    }
    
    public boolean openPane() {
        return this.openPane(mSlideableView, 0);
    }
    
    public void requestChildFocus(final View view, final View view2) {
        super.requestChildFocus(view, view2);
        if (!this.isInTouchMode() && !mCanSlide) {
            mPreservedOpenState = (view == mSlideableView);
        }
    }
    
    void setAllChildrenVisible() {
        for (int i = 0; i < this.getChildCount(); ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() == 4) {
                child.setVisibility(0);
            }
        }
    }
    
    public void setCoveredFadeColor(@ColorInt final int mCoveredFadeColor) {
        this.mCoveredFadeColor = mCoveredFadeColor;
    }
    
    public void setPanelSlideListener(final PanelSlideListener mPanelSlideListener) {
        this.mPanelSlideListener = mPanelSlideListener;
    }
    
    public void setParallaxDistance(final int mParallaxBy) {
        this.mParallaxBy = mParallaxBy;
        this.requestLayout();
    }
    
    @Deprecated
    public void setShadowDrawable(final Drawable shadowDrawableLeft) {
        this.setShadowDrawableLeft(shadowDrawableLeft);
    }
    
    public void setShadowDrawableLeft(final Drawable mShadowDrawableLeft) {
        this.mShadowDrawableLeft = mShadowDrawableLeft;
    }
    
    public void setShadowDrawableRight(final Drawable mShadowDrawableRight) {
        this.mShadowDrawableRight = mShadowDrawableRight;
    }
    
    @Deprecated
    public void setShadowResource(@DrawableRes final int n) {
        this.setShadowDrawable(this.getResources().getDrawable(n));
    }
    
    public void setShadowResourceLeft(final int n) {
        this.setShadowDrawableLeft(this.getResources().getDrawable(n));
    }
    
    public void setShadowResourceRight(final int n) {
        this.setShadowDrawableRight(this.getResources().getDrawable(n));
    }
    
    public void setSliderFadeColor(@ColorInt final int mSliderFadeColor) {
        this.mSliderFadeColor = mSliderFadeColor;
    }
    
    @Deprecated
    public void smoothSlideClosed() {
        this.closePane();
    }
    
    @Deprecated
    public void smoothSlideOpen() {
        this.openPane();
    }
    
    boolean smoothSlideTo(final float n, final int n2) {
        if (mCanSlide) {
            final boolean layoutRtlSupport = this.isLayoutRtlSupport();
            final LayoutParams layoutParams = (LayoutParams)mSlideableView.getLayoutParams();
            int n3;
            if (layoutRtlSupport) {
                n3 = (int)(this.getWidth() - (this.getPaddingRight() + layoutParams.rightMargin + n * mSlideRange + mSlideableView.getWidth()));
            }
            else {
                n3 = (int)(this.getPaddingLeft() + layoutParams.leftMargin + n * mSlideRange);
            }
            if (mDragHelper.smoothSlideViewTo(mSlideableView, n3, mSlideableView.getTop())) {
                this.setAllChildrenVisible();
                ViewCompat.postInvalidateOnAnimation((View)this);
                return true;
            }
        }
        return false;
    }
    
    void updateObscuredViewsVisibility(final View view) {
        final boolean layoutRtlSupport = this.isLayoutRtlSupport();
        int paddingLeft;
        if (layoutRtlSupport) {
            paddingLeft = this.getWidth() - this.getPaddingRight();
        }
        else {
            paddingLeft = this.getPaddingLeft();
        }
        int paddingLeft2;
        if (layoutRtlSupport) {
            paddingLeft2 = this.getPaddingLeft();
        }
        else {
            paddingLeft2 = this.getWidth() - this.getPaddingRight();
        }
        final int paddingTop = this.getPaddingTop();
        final int n = this.getHeight() - this.getPaddingBottom();
        int left;
        int right;
        int top;
        int bottom;
        if (view != null && viewIsOpaque(view)) {
            left = view.getLeft();
            right = view.getRight();
            top = view.getTop();
            bottom = view.getBottom();
        }
        else {
            bottom = 0;
            left = 0;
            right = 0;
            top = 0;
        }
        for (int i = 0; i < this.getChildCount(); ++i) {
            final View child = this.getChildAt(i);
            if (child == view) {
                break;
            }
            int n2;
            if (layoutRtlSupport) {
                n2 = paddingLeft2;
            }
            else {
                n2 = paddingLeft;
            }
            final int max = Math.max(n2, child.getLeft());
            final int max2 = Math.max(paddingTop, child.getTop());
            int n3;
            if (layoutRtlSupport) {
                n3 = paddingLeft;
            }
            else {
                n3 = paddingLeft2;
            }
            final int min = Math.min(n3, child.getRight());
            final int min2 = Math.min(n, child.getBottom());
            int visibility;
            if (max >= left && max2 >= top && min <= right && min2 <= bottom) {
                visibility = 4;
            }
            else {
                visibility = 0;
            }
            child.setVisibility(visibility);
        }
    }
}
