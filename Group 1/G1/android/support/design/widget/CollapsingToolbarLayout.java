package android.support.design.widget;

import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.annotation.DrawableRes;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable$Callback;
import android.support.annotation.ColorInt;
import android.support.annotation.StyleRes;
import android.text.TextUtils;
import android.support.annotation.Nullable;
import android.graphics.Typeface;
import android.widget.FrameLayout$LayoutParams;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.support.annotation.NonNull;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.design.R;
import android.util.AttributeSet;
import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.graphics.Rect;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

public class CollapsingToolbarLayout extends FrameLayout
{
    private static final int SCRIM_ANIMATION_DURATION = 600;
    private final CollapsingTextHelper mCollapsingTextHelper;
    private boolean mCollapsingTitleEnabled;
    private Drawable mContentScrim;
    private int mCurrentOffset;
    private boolean mDrawCollapsingTitle;
    private View mDummyView;
    private int mExpandedMarginBottom;
    private int mExpandedMarginEnd;
    private int mExpandedMarginStart;
    private int mExpandedMarginTop;
    private WindowInsetsCompat mLastInsets;
    private AppBarLayout.OnOffsetChangedListener mOnOffsetChangedListener;
    private boolean mRefreshToolbar;
    private int mScrimAlpha;
    private ValueAnimatorCompat mScrimAnimator;
    private boolean mScrimsAreShown;
    private Drawable mStatusBarScrim;
    private final Rect mTmpRect;
    private Toolbar mToolbar;
    private View mToolbarDirectChild;
    private int mToolbarId;
    
    public CollapsingToolbarLayout(final Context context) {
        this(context, null);
    }
    
    public CollapsingToolbarLayout(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public CollapsingToolbarLayout(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        mRefreshToolbar = true;
        mTmpRect = new Rect();
        ThemeUtils.checkAppCompatTheme(context);
        (mCollapsingTextHelper = new CollapsingTextHelper((View)this)).setTextSizeInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.CollapsingToolbarLayout, n, R.style.Widget_Design_CollapsingToolbar);
        mCollapsingTextHelper.setExpandedTextGravity(obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        mCollapsingTextHelper.setCollapsedTextGravity(obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        final int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        mExpandedMarginBottom = dimensionPixelSize;
        mExpandedMarginEnd = dimensionPixelSize;
        mExpandedMarginTop = dimensionPixelSize;
        mExpandedMarginStart = dimensionPixelSize;
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            mExpandedMarginStart = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            mExpandedMarginEnd = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            mExpandedMarginTop = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            mExpandedMarginBottom = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        mCollapsingTitleEnabled = obtainStyledAttributes.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
        this.setTitle(obtainStyledAttributes.getText(R.styleable.CollapsingToolbarLayout_title));
        mCollapsingTextHelper.setExpandedTextAppearance(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        mCollapsingTextHelper.setCollapsedTextAppearance(R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            mCollapsingTextHelper.setExpandedTextAppearance(obtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            mCollapsingTextHelper.setCollapsedTextAppearance(obtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.setContentScrim(obtainStyledAttributes.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
        this.setStatusBarScrim(obtainStyledAttributes.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
        mToolbarId = obtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
        obtainStyledAttributes.recycle();
        this.setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, (OnApplyWindowInsetsListener)new OnApplyWindowInsetsListener() {
            final /* synthetic */ CollapsingToolbarLayout this$0;
            
            CollapsingToolbarLayout$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public WindowInsetsCompat onApplyWindowInsets(final View view, final WindowInsetsCompat windowInsetsCompat) {
                return this$0.setWindowInsets(windowInsetsCompat);
            }
        });
    }
    
    static /* synthetic */ WindowInsetsCompat access$000(final CollapsingToolbarLayout collapsingToolbarLayout, final WindowInsetsCompat windowInsets) {
        return collapsingToolbarLayout.setWindowInsets(windowInsets);
    }
    
    static /* synthetic */ void access$200(final CollapsingToolbarLayout collapsingToolbarLayout, final int scrimAlpha) {
        collapsingToolbarLayout.setScrimAlpha(scrimAlpha);
    }
    
    static /* synthetic */ int access$302(final CollapsingToolbarLayout collapsingToolbarLayout, final int mCurrentOffset) {
        return collapsingToolbarLayout.mCurrentOffset = mCurrentOffset;
    }
    
    static /* synthetic */ WindowInsetsCompat access$400(final CollapsingToolbarLayout collapsingToolbarLayout) {
        return collapsingToolbarLayout.mLastInsets;
    }
    
    static /* synthetic */ ViewOffsetHelper access$500(final View view) {
        return getViewOffsetHelper(view);
    }
    
    static /* synthetic */ Drawable access$600(final CollapsingToolbarLayout collapsingToolbarLayout) {
        return collapsingToolbarLayout.mContentScrim;
    }
    
    static /* synthetic */ Drawable access$700(final CollapsingToolbarLayout collapsingToolbarLayout) {
        return collapsingToolbarLayout.mStatusBarScrim;
    }
    
    static /* synthetic */ CollapsingTextHelper access$800(final CollapsingToolbarLayout collapsingToolbarLayout) {
        return collapsingToolbarLayout.mCollapsingTextHelper;
    }
    
    private void animateScrim(final int n) {
        this.ensureToolbar();
        if (mScrimAnimator == null) {
            (mScrimAnimator = ViewUtils.createAnimator()).setDuration(600);
            final ValueAnimatorCompat mScrimAnimator = this.mScrimAnimator;
            Interpolator interpolator;
            if (n > mScrimAlpha) {
                interpolator = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
            }
            else {
                interpolator = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
            }
            mScrimAnimator.setInterpolator(interpolator);
            this.mScrimAnimator.setUpdateListener((ValueAnimatorCompat.AnimatorUpdateListener)new ValueAnimatorCompat.AnimatorUpdateListener() {
                final /* synthetic */ CollapsingToolbarLayout this$0;
                
                CollapsingToolbarLayout$2() {
                    this$0 = this$0;
                    super();
                }
                
                @Override
                public void onAnimationUpdate(final ValueAnimatorCompat valueAnimatorCompat) {
                    this$0.setScrimAlpha(valueAnimatorCompat.getAnimatedIntValue());
                }
            });
        }
        else if (mScrimAnimator.isRunning()) {
            mScrimAnimator.cancel();
        }
        mScrimAnimator.setIntValues(mScrimAlpha, n);
        mScrimAnimator.start();
    }
    
    private void ensureToolbar() {
        if (!mRefreshToolbar) {
            return;
        }
        mToolbar = null;
        mToolbarDirectChild = null;
        if (mToolbarId != -1) {
            mToolbar = (Toolbar)this.findViewById(mToolbarId);
            if (mToolbar != null) {
                mToolbarDirectChild = this.findDirectChild((View)mToolbar);
            }
        }
        if (mToolbar == null) {
            int n = 0;
            final int childCount = this.getChildCount();
            Toolbar mToolbar;
            while (true) {
                mToolbar = null;
                if (n >= childCount) {
                    break;
                }
                final View child = this.getChildAt(n);
                if (child instanceof Toolbar) {
                    mToolbar = (Toolbar)child;
                    break;
                }
                ++n;
            }
            this.mToolbar = mToolbar;
        }
        this.updateDummyView();
        mRefreshToolbar = false;
    }
    
    private View findDirectChild(final View view) {
        View view2 = view;
        for (ViewParent viewParent = view.getParent(); viewParent != this && viewParent != null; viewParent = viewParent.getParent()) {
            if (viewParent instanceof View) {
                view2 = (View)viewParent;
            }
        }
        return view2;
    }
    
    private static int getHeightWithMargins(@NonNull final View view) {
        final ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup$MarginLayoutParams) {
            final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)layoutParams;
            return view.getHeight() + viewGroup$MarginLayoutParams.topMargin + viewGroup$MarginLayoutParams.bottomMargin;
        }
        return view.getHeight();
    }
    
    private static ViewOffsetHelper getViewOffsetHelper(final View view) {
        ViewOffsetHelper viewOffsetHelper = (ViewOffsetHelper)view.getTag(R.id.view_offset_helper);
        if (viewOffsetHelper == null) {
            viewOffsetHelper = new ViewOffsetHelper(view);
            view.setTag(R.id.view_offset_helper, (Object)viewOffsetHelper);
        }
        return viewOffsetHelper;
    }
    
    private void setScrimAlpha(final int mScrimAlpha) {
        if (mScrimAlpha != this.mScrimAlpha) {
            if (mContentScrim != null && mToolbar != null) {
                ViewCompat.postInvalidateOnAnimation((View)mToolbar);
            }
            this.mScrimAlpha = mScrimAlpha;
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }
    
    private WindowInsetsCompat setWindowInsets(final WindowInsetsCompat mLastInsets) {
        if (this.mLastInsets != mLastInsets) {
            this.mLastInsets = mLastInsets;
            this.requestLayout();
        }
        return mLastInsets.consumeSystemWindowInsets();
    }
    
    private void updateDummyView() {
        if (!mCollapsingTitleEnabled && mDummyView != null) {
            final ViewParent parent = mDummyView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup)parent).removeView(mDummyView);
            }
        }
        if (mCollapsingTitleEnabled && mToolbar != null) {
            if (mDummyView == null) {
                mDummyView = new View(this.getContext());
            }
            if (mDummyView.getParent() == null) {
                mToolbar.addView(mDummyView, -1, -1);
            }
        }
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof LayoutParams;
    }
    
    public void draw(final Canvas canvas) {
        super.draw(canvas);
        this.ensureToolbar();
        if (mToolbar == null && mContentScrim != null && mScrimAlpha > 0) {
            mContentScrim.mutate().setAlpha(mScrimAlpha);
            mContentScrim.draw(canvas);
        }
        if (mCollapsingTitleEnabled && mDrawCollapsingTitle) {
            mCollapsingTextHelper.draw(canvas);
        }
        if (mStatusBarScrim != null && mScrimAlpha > 0) {
            int systemWindowInsetTop;
            if (mLastInsets != null) {
                systemWindowInsetTop = mLastInsets.getSystemWindowInsetTop();
            }
            else {
                systemWindowInsetTop = 0;
            }
            if (systemWindowInsetTop > 0) {
                mStatusBarScrim.setBounds(0, -mCurrentOffset, this.getWidth(), systemWindowInsetTop - mCurrentOffset);
                mStatusBarScrim.mutate().setAlpha(mScrimAlpha);
                mStatusBarScrim.draw(canvas);
            }
        }
    }
    
    protected boolean drawChild(final Canvas canvas, final View view, final long n) {
        this.ensureToolbar();
        if (view == mToolbar && mContentScrim != null && mScrimAlpha > 0) {
            mContentScrim.mutate().setAlpha(mScrimAlpha);
            mContentScrim.draw(canvas);
        }
        return super.drawChild(canvas, view, n);
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final int[] drawableState = this.getDrawableState();
        final Drawable mStatusBarScrim = this.mStatusBarScrim;
        boolean b = false;
        if (mStatusBarScrim != null) {
            final boolean stateful = mStatusBarScrim.isStateful();
            b = false;
            if (stateful) {
                b = (false | mStatusBarScrim.setState(drawableState));
            }
        }
        final Drawable mContentScrim = this.mContentScrim;
        if (mContentScrim != null && mContentScrim.isStateful()) {
            b |= mContentScrim.setState(drawableState);
        }
        if (b) {
            this.invalidate();
        }
    }
    
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(super.generateDefaultLayoutParams());
    }
    
    protected /* bridge */ ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)this.generateDefaultLayoutParams();
    }
    
    protected /* bridge */ FrameLayout$LayoutParams generateDefaultLayoutParams() {
        return this.generateDefaultLayoutParams();
    }
    
    public /* bridge */ ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)this.generateLayoutParams(set);
    }
    
    protected /* bridge */ ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return (ViewGroup$LayoutParams)this.generateLayoutParams(viewGroup$LayoutParams);
    }
    
    public FrameLayout$LayoutParams generateLayoutParams(final AttributeSet set) {
        return new LayoutParams(this.getContext(), set);
    }
    
    protected FrameLayout$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return new LayoutParams(viewGroup$LayoutParams);
    }
    
    public int getCollapsedTitleGravity() {
        return mCollapsingTextHelper.getCollapsedTextGravity();
    }
    
    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return mCollapsingTextHelper.getCollapsedTypeface();
    }
    
    @Nullable
    public Drawable getContentScrim() {
        return mContentScrim;
    }
    
    public int getExpandedTitleGravity() {
        return mCollapsingTextHelper.getExpandedTextGravity();
    }
    
    public int getExpandedTitleMarginBottom() {
        return mExpandedMarginBottom;
    }
    
    public int getExpandedTitleMarginEnd() {
        return mExpandedMarginEnd;
    }
    
    public int getExpandedTitleMarginStart() {
        return mExpandedMarginStart;
    }
    
    public int getExpandedTitleMarginTop() {
        return mExpandedMarginTop;
    }
    
    @NonNull
    public Typeface getExpandedTitleTypeface() {
        return mCollapsingTextHelper.getExpandedTypeface();
    }
    
    final int getScrimTriggerOffset() {
        return 2 * ViewCompat.getMinimumHeight((View)this);
    }
    
    @Nullable
    public Drawable getStatusBarScrim() {
        return mStatusBarScrim;
    }
    
    @Nullable
    public CharSequence getTitle() {
        if (mCollapsingTitleEnabled) {
            return mCollapsingTextHelper.getText();
        }
        return null;
    }
    
    public boolean isTitleEnabled() {
        return mCollapsingTitleEnabled;
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        final ViewParent parent = this.getParent();
        if (parent instanceof AppBarLayout) {
            if (mOnOffsetChangedListener == null) {
                mOnOffsetChangedListener = new OffsetUpdateListener(this);
            }
            ((AppBarLayout)parent).addOnOffsetChangedListener(mOnOffsetChangedListener);
        }
        ViewCompat.requestApplyInsets((View)this);
    }
    
    protected void onDetachedFromWindow() {
        final ViewParent parent = this.getParent();
        if (mOnOffsetChangedListener != null && parent instanceof AppBarLayout) {
            ((AppBarLayout)parent).removeOnOffsetChangedListener(mOnOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        if (mCollapsingTitleEnabled && mDummyView != null) {
            mDrawCollapsingTitle = (ViewCompat.isAttachedToWindow(mDummyView) && mDummyView.getVisibility() == 0);
            if (mDrawCollapsingTitle) {
                final View mToolbarDirectChild = this.mToolbarDirectChild;
                int bottomMargin = 0;
                if (mToolbarDirectChild != null) {
                    final View mToolbarDirectChild2 = this.mToolbarDirectChild;
                    bottomMargin = 0;
                    if (mToolbarDirectChild2 != this) {
                        bottomMargin = ((LayoutParams)this.mToolbarDirectChild.getLayoutParams()).bottomMargin;
                    }
                }
                ViewGroupUtils.getDescendantRect((ViewGroup)this, mDummyView, mTmpRect);
                mCollapsingTextHelper.setCollapsedBounds(mTmpRect.left, n4 - mTmpRect.height() - bottomMargin, mTmpRect.right, n4 - bottomMargin);
                boolean b2;
                if (ViewCompat.getLayoutDirection((View)this) == 1) {
                    b2 = true;
                }
                else {
                    b2 = false;
                }
                final CollapsingTextHelper mCollapsingTextHelper = this.mCollapsingTextHelper;
                int n5;
                if (b2) {
                    n5 = mExpandedMarginEnd;
                }
                else {
                    n5 = mExpandedMarginStart;
                }
                final int n6 = mTmpRect.bottom + mExpandedMarginTop;
                final int n7 = n3 - n;
                int n8;
                if (b2) {
                    n8 = mExpandedMarginStart;
                }
                else {
                    n8 = mExpandedMarginEnd;
                }
                mCollapsingTextHelper.setExpandedBounds(n5, n6, n7 - n8, n4 - n2 - mExpandedMarginBottom);
                this.mCollapsingTextHelper.recalculate();
            }
        }
        for (int i = 0; i < this.getChildCount(); ++i) {
            final View child = this.getChildAt(i);
            if (mLastInsets != null && !ViewCompat.getFitsSystemWindows(child)) {
                final int systemWindowInsetTop = mLastInsets.getSystemWindowInsetTop();
                if (child.getTop() < systemWindowInsetTop) {
                    ViewCompat.offsetTopAndBottom(child, systemWindowInsetTop);
                }
            }
            getViewOffsetHelper(child).onViewLayout();
        }
        if (mToolbar != null) {
            if (mCollapsingTitleEnabled && TextUtils.isEmpty(mCollapsingTextHelper.getText())) {
                mCollapsingTextHelper.setText(mToolbar.getTitle());
            }
            if (mToolbarDirectChild != null && mToolbarDirectChild != this) {
                this.setMinimumHeight(getHeightWithMargins(mToolbarDirectChild));
                return;
            }
            this.setMinimumHeight(getHeightWithMargins((View)mToolbar));
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        this.ensureToolbar();
        super.onMeasure(n, n2);
    }
    
    protected void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        if (mContentScrim != null) {
            mContentScrim.setBounds(0, 0, n, n2);
        }
    }
    
    public void setCollapsedTitleGravity(final int collapsedTextGravity) {
        mCollapsingTextHelper.setCollapsedTextGravity(collapsedTextGravity);
    }
    
    public void setCollapsedTitleTextAppearance(@StyleRes final int collapsedTextAppearance) {
        mCollapsingTextHelper.setCollapsedTextAppearance(collapsedTextAppearance);
    }
    
    public void setCollapsedTitleTextColor(@ColorInt final int collapsedTextColor) {
        mCollapsingTextHelper.setCollapsedTextColor(collapsedTextColor);
    }
    
    public void setCollapsedTitleTypeface(@Nullable final Typeface collapsedTypeface) {
        mCollapsingTextHelper.setCollapsedTypeface(collapsedTypeface);
    }
    
    public void setContentScrim(@Nullable final Drawable drawable) {
        if (mContentScrim != drawable) {
            if (mContentScrim != null) {
                mContentScrim.setCallback((Drawable$Callback)null);
            }
            Drawable mutate = null;
            if (drawable != null) {
                mutate = drawable.mutate();
            }
            mContentScrim = mutate;
            if (mContentScrim != null) {
                mContentScrim.setBounds(0, 0, this.getWidth(), this.getHeight());
                mContentScrim.setCallback((Drawable$Callback)this);
                mContentScrim.setAlpha(mScrimAlpha);
            }
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }
    
    public void setContentScrimColor(@ColorInt final int n) {
        this.setContentScrim((Drawable)new ColorDrawable(n));
    }
    
    public void setContentScrimResource(@DrawableRes final int n) {
        this.setContentScrim(ContextCompat.getDrawable(this.getContext(), n));
    }
    
    public void setExpandedTitleColor(@ColorInt final int expandedTextColor) {
        mCollapsingTextHelper.setExpandedTextColor(expandedTextColor);
    }
    
    public void setExpandedTitleGravity(final int expandedTextGravity) {
        mCollapsingTextHelper.setExpandedTextGravity(expandedTextGravity);
    }
    
    public void setExpandedTitleMargin(final int mExpandedMarginStart, final int mExpandedMarginTop, final int mExpandedMarginEnd, final int mExpandedMarginBottom) {
        this.mExpandedMarginStart = mExpandedMarginStart;
        this.mExpandedMarginTop = mExpandedMarginTop;
        this.mExpandedMarginEnd = mExpandedMarginEnd;
        this.mExpandedMarginBottom = mExpandedMarginBottom;
        this.requestLayout();
    }
    
    public void setExpandedTitleMarginBottom(final int mExpandedMarginBottom) {
        this.mExpandedMarginBottom = mExpandedMarginBottom;
        this.requestLayout();
    }
    
    public void setExpandedTitleMarginEnd(final int mExpandedMarginEnd) {
        this.mExpandedMarginEnd = mExpandedMarginEnd;
        this.requestLayout();
    }
    
    public void setExpandedTitleMarginStart(final int mExpandedMarginStart) {
        this.mExpandedMarginStart = mExpandedMarginStart;
        this.requestLayout();
    }
    
    public void setExpandedTitleMarginTop(final int mExpandedMarginTop) {
        this.mExpandedMarginTop = mExpandedMarginTop;
        this.requestLayout();
    }
    
    public void setExpandedTitleTextAppearance(@StyleRes final int expandedTextAppearance) {
        mCollapsingTextHelper.setExpandedTextAppearance(expandedTextAppearance);
    }
    
    public void setExpandedTitleTypeface(@Nullable final Typeface expandedTypeface) {
        mCollapsingTextHelper.setExpandedTypeface(expandedTypeface);
    }
    
    public void setScrimsShown(final boolean b) {
        this.setScrimsShown(b, ViewCompat.isLaidOut((View)this) && !this.isInEditMode());
    }
    
    public void setScrimsShown(final boolean mScrimsAreShown, final boolean b) {
        int scrimAlpha = 255;
        if (this.mScrimsAreShown != mScrimsAreShown) {
            if (b) {
                if (!mScrimsAreShown) {
                    scrimAlpha = 0;
                }
                this.animateScrim(scrimAlpha);
            }
            else {
                if (!mScrimsAreShown) {
                    scrimAlpha = 0;
                }
                this.setScrimAlpha(scrimAlpha);
            }
            this.mScrimsAreShown = mScrimsAreShown;
        }
    }
    
    public void setStatusBarScrim(@Nullable final Drawable drawable) {
        if (mStatusBarScrim != drawable) {
            if (mStatusBarScrim != null) {
                mStatusBarScrim.setCallback((Drawable$Callback)null);
            }
            Drawable mutate = null;
            if (drawable != null) {
                mutate = drawable.mutate();
            }
            mStatusBarScrim = mutate;
            if (mStatusBarScrim != null) {
                if (mStatusBarScrim.isStateful()) {
                    mStatusBarScrim.setState(this.getDrawableState());
                }
                DrawableCompat.setLayoutDirection(mStatusBarScrim, ViewCompat.getLayoutDirection((View)this));
                mStatusBarScrim.setVisible(this.getVisibility() == 0, false);
                mStatusBarScrim.setCallback((Drawable$Callback)this);
                mStatusBarScrim.setAlpha(mScrimAlpha);
            }
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }
    
    public void setStatusBarScrimColor(@ColorInt final int n) {
        this.setStatusBarScrim((Drawable)new ColorDrawable(n));
    }
    
    public void setStatusBarScrimResource(@DrawableRes final int n) {
        this.setStatusBarScrim(ContextCompat.getDrawable(this.getContext(), n));
    }
    
    public void setTitle(@Nullable final CharSequence text) {
        mCollapsingTextHelper.setText(text);
    }
    
    public void setTitleEnabled(final boolean mCollapsingTitleEnabled) {
        if (mCollapsingTitleEnabled != this.mCollapsingTitleEnabled) {
            this.mCollapsingTitleEnabled = mCollapsingTitleEnabled;
            this.updateDummyView();
            this.requestLayout();
        }
    }
    
    public void setVisibility(final int visibility) {
        super.setVisibility(visibility);
        final boolean b = visibility == 0;
        if (mStatusBarScrim != null && mStatusBarScrim.isVisible() != b) {
            mStatusBarScrim.setVisible(b, false);
        }
        if (mContentScrim != null && mContentScrim.isVisible() != b) {
            mContentScrim.setVisible(b, false);
        }
    }
    
    protected boolean verifyDrawable(final Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == mContentScrim || drawable == mStatusBarScrim;
    }
}
