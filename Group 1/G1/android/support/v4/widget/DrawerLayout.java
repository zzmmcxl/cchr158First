package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import android.content.res.TypedArray;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.os.Parcelable;
import android.view.View$MeasureSpec;
import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.support.v4.view.MotionEventCompat;
import android.view.ViewGroup$MarginLayoutParams;
import android.support.v4.view.GravityCompat;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.os.SystemClock;
import android.view.ViewGroup$LayoutParams;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Build$VERSION;
import android.graphics.drawable.Drawable;
import android.graphics.Paint;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

public class DrawerLayout extends ViewGroup implements DrawerLayoutImpl
{
    private static final boolean ALLOW_EDGE_LOCK = false;
    private static final boolean CAN_HIDE_DESCENDANTS = false;
    private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;
    private static final int DRAWER_ELEVATION = 10;
    static final DrawerLayoutCompatImpl IMPL;
    private static final int[] LAYOUT_ATTRS;
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_DRAWER_MARGIN = 64;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final int PEEK_DELAY = 160;
    private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION = false;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "DrawerLayout";
    private static final float TOUCH_SLOP_SENSITIVITY = 1.0f;
    private final ChildAccessibilityDelegate mChildAccessibilityDelegate;
    private boolean mChildrenCanceledTouch;
    private boolean mDisallowInterceptRequested;
    private boolean mDrawStatusBarBackground;
    private float mDrawerElevation;
    private int mDrawerState;
    private boolean mFirstLayout;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private Object mLastInsets;
    private final ViewDragCallback mLeftCallback;
    private final ViewDragHelper mLeftDragger;
    @Deprecated
    @Nullable
    private DrawerListener mListener;
    private List<DrawerListener> mListeners;
    private int mLockModeEnd;
    private int mLockModeLeft;
    private int mLockModeRight;
    private int mLockModeStart;
    private int mMinDrawerMargin;
    private final ArrayList<View> mNonDrawerViews;
    private final ViewDragCallback mRightCallback;
    private final ViewDragHelper mRightDragger;
    private int mScrimColor;
    private float mScrimOpacity;
    private Paint mScrimPaint;
    private Drawable mShadowEnd;
    private Drawable mShadowLeft;
    private Drawable mShadowLeftResolved;
    private Drawable mShadowRight;
    private Drawable mShadowRightResolved;
    private Drawable mShadowStart;
    private Drawable mStatusBarBackground;
    private CharSequence mTitleLeft;
    private CharSequence mTitleRight;
    
    static {
        int set_DRAWER_SHADOW_FROM_ELEVATION = 1;
        final int[] layout_ATTRS = new int[set_DRAWER_SHADOW_FROM_ELEVATION];
        layout_ATTRS[0] = 16842931;
        LAYOUT_ATTRS = layout_ATTRS;
        boolean can_HIDE_DESCENDANTS;
        if (Build$VERSION.SDK_INT >= 19) {
            can_HIDE_DESCENDANTS = (set_DRAWER_SHADOW_FROM_ELEVATION != 0);
        }
        else {
            can_HIDE_DESCENDANTS = false;
        }
        if (Build$VERSION.SDK_INT < 21) {
            set_DRAWER_SHADOW_FROM_ELEVATION = 0;
        }
        if (Build$VERSION.SDK_INT >= 21) {
            IMPL = (DrawerLayoutCompatImpl)new DrawerLayoutCompatImplApi21();
            return;
        }
        IMPL = (DrawerLayoutCompatImpl)new DrawerLayoutCompatImplBase();
    }
    
    public DrawerLayout(final Context context) {
        this(context, null);
    }
    
    public DrawerLayout(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public DrawerLayout(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        mChildAccessibilityDelegate = new ChildAccessibilityDelegate();
        mScrimColor = -1728053248;
        mScrimPaint = new Paint();
        mFirstLayout = true;
        mLockModeLeft = 3;
        mLockModeRight = 3;
        mLockModeStart = 3;
        mLockModeEnd = 3;
        mShadowStart = null;
        mShadowEnd = null;
        mShadowLeft = null;
        mShadowRight = null;
        this.setDescendantFocusability(262144);
        final float density = this.getResources().getDisplayMetrics().density;
        mMinDrawerMargin = (int)(0.5f + 64.0f * density);
        final float n2 = 400.0f * density;
        mLeftCallback = new ViewDragCallback(3);
        mRightCallback = new ViewDragCallback(5);
        (mLeftDragger = ViewDragHelper.create(this, 1.0f, (ViewDragHelper.Callback)mLeftCallback)).setEdgeTrackingEnabled(1);
        mLeftDragger.setMinVelocity(n2);
        mLeftCallback.setDragger(mLeftDragger);
        (mRightDragger = ViewDragHelper.create(this, 1.0f, (ViewDragHelper.Callback)mRightCallback)).setEdgeTrackingEnabled(2);
        mRightDragger.setMinVelocity(n2);
        mRightCallback.setDragger(mRightDragger);
        this.setFocusableInTouchMode(true);
        ViewCompat.setImportantForAccessibility((View)this, 1);
        ViewCompat.setAccessibilityDelegate(this, (AccessibilityDelegateCompat)new AccessibilityDelegate());
        ViewGroupCompat.setMotionEventSplittingEnabled(this, false);
        if (ViewCompat.getFitsSystemWindows((View)this)) {
            IMPL.configureApplyInsets((View)this);
            mStatusBarBackground = IMPL.getDefaultStatusBarBackground(context);
        }
        mDrawerElevation = 10.0f * density;
        mNonDrawerViews = new ArrayList<View>();
    }
    
    static /* synthetic */ int[] access$400() {
        return LAYOUT_ATTRS;
    }
    
    static /* synthetic */ boolean access$500() {
        return CAN_HIDE_DESCENDANTS;
    }
    
    static /* synthetic */ View access$600(final DrawerLayout drawerLayout) {
        return drawerLayout.findVisibleDrawer();
    }
    
    static /* synthetic */ boolean access$700(final View view) {
        return includeChildForAccessibility(view);
    }
    
    private View findVisibleDrawer() {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (this.isDrawerView(child) && this.isDrawerVisible(child)) {
                return child;
            }
        }
        return null;
    }
    
    static String gravityToString(final int n) {
        if ((n & 0x3) == 0x3) {
            return "LEFT";
        }
        if ((n & 0x5) == 0x5) {
            return "RIGHT";
        }
        return Integer.toHexString(n);
    }
    
    private static boolean hasOpaqueBackground(final View view) {
        final Drawable background = view.getBackground();
        boolean b = false;
        if (background != null) {
            final int opacity = background.getOpacity();
            b = false;
            if (opacity == -1) {
                b = true;
            }
        }
        return b;
    }
    
    private boolean hasPeekingDrawer() {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            if (((LayoutParams)this.getChildAt(i).getLayoutParams()).isPeeking) {
                return true;
            }
        }
        return false;
    }
    
    private boolean hasVisibleDrawer() {
        return this.findVisibleDrawer() != null;
    }
    
    private static boolean includeChildForAccessibility(final View view) {
        return ViewCompat.getImportantForAccessibility(view) != 4 && ViewCompat.getImportantForAccessibility(view) != 2;
    }
    
    private boolean mirror(final Drawable drawable, final int n) {
        if (drawable == null || !DrawableCompat.isAutoMirrored(drawable)) {
            return false;
        }
        DrawableCompat.setLayoutDirection(drawable, n);
        return true;
    }
    
    private Drawable resolveLeftShadow() {
        final int layoutDirection = ViewCompat.getLayoutDirection((View)this);
        if (layoutDirection == 0) {
            if (mShadowStart != null) {
                this.mirror(mShadowStart, layoutDirection);
                return mShadowStart;
            }
        }
        else if (mShadowEnd != null) {
            this.mirror(mShadowEnd, layoutDirection);
            return mShadowEnd;
        }
        return mShadowLeft;
    }
    
    private Drawable resolveRightShadow() {
        final int layoutDirection = ViewCompat.getLayoutDirection((View)this);
        if (layoutDirection == 0) {
            if (mShadowEnd != null) {
                this.mirror(mShadowEnd, layoutDirection);
                return mShadowEnd;
            }
        }
        else if (mShadowStart != null) {
            this.mirror(mShadowStart, layoutDirection);
            return mShadowStart;
        }
        return mShadowRight;
    }
    
    private void resolveShadowDrawables() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return;
        }
        mShadowLeftResolved = this.resolveLeftShadow();
        mShadowRightResolved = this.resolveRightShadow();
    }
    
    private void updateChildrenImportantForAccessibility(final View view, final boolean b) {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if ((!b && !this.isDrawerView(child)) || (b && child == view)) {
                ViewCompat.setImportantForAccessibility(child, 1);
            }
            else {
                ViewCompat.setImportantForAccessibility(child, 4);
            }
        }
    }
    
    public void addDrawerListener(@NonNull final DrawerListener drawerListener) {
        if (drawerListener == null) {
            return;
        }
        if (mListeners == null) {
            mListeners = new ArrayList<DrawerListener>();
        }
        mListeners.add(drawerListener);
    }
    
    public void addFocusables(final ArrayList<View> list, final int n, final int n2) {
        if (this.getDescendantFocusability() == 393216) {
            return;
        }
        final int childCount = this.getChildCount();
        boolean b = false;
        for (int i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (this.isDrawerView(child)) {
                if (this.isDrawerOpen(child)) {
                    b = true;
                    child.addFocusables((ArrayList)list, n, n2);
                }
            }
            else {
                mNonDrawerViews.add(child);
            }
        }
        if (!b) {
            for (int size = mNonDrawerViews.size(), j = 0; j < size; ++j) {
                final View view = (View)mNonDrawerViews.get(j);
                if (view.getVisibility() == 0) {
                    view.addFocusables((ArrayList)list, n, n2);
                }
            }
        }
        mNonDrawerViews.clear();
    }
    
    public void addView(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super.addView(view, n, viewGroup$LayoutParams);
        if (this.findOpenDrawer() != null || this.isDrawerView(view)) {
            ViewCompat.setImportantForAccessibility(view, 4);
        }
        else {
            ViewCompat.setImportantForAccessibility(view, 1);
        }
        if (!CAN_HIDE_DESCENDANTS) {
            ViewCompat.setAccessibilityDelegate(view, mChildAccessibilityDelegate);
        }
    }
    
    void cancelChildViewTouch() {
        if (!mChildrenCanceledTouch) {
            final long uptimeMillis = SystemClock.uptimeMillis();
            final MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                this.getChildAt(i).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            mChildrenCanceledTouch = true;
        }
    }
    
    boolean checkDrawerViewAbsoluteGravity(final View view, final int n) {
        return (n & this.getDrawerViewAbsoluteGravity(view)) == n;
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof LayoutParams && super.checkLayoutParams(viewGroup$LayoutParams);
    }
    
    public void closeDrawer(final int n) {
        final View drawerWithGravity = this.findDrawerWithGravity(n);
        if (drawerWithGravity == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(n));
        }
        this.closeDrawer(drawerWithGravity);
    }
    
    public void closeDrawer(final View view) {
        if (!this.isDrawerView(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (mFirstLayout) {
            layoutParams.onScreen = 0.0f;
            layoutParams.openState = 0;
        }
        else {
            layoutParams.openState |= 0x4;
            if (this.checkDrawerViewAbsoluteGravity(view, 3)) {
                mLeftDragger.smoothSlideViewTo(view, -view.getWidth(), view.getTop());
            }
            else {
                mRightDragger.smoothSlideViewTo(view, this.getWidth(), view.getTop());
            }
        }
        this.invalidate();
    }
    
    public void closeDrawers() {
        this.closeDrawers(false);
    }
    
    void closeDrawers(final boolean b) {
        boolean b2 = false;
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
            if (this.isDrawerView(child) && (!b || layoutParams.isPeeking)) {
                final int width = child.getWidth();
                if (this.checkDrawerViewAbsoluteGravity(child, 3)) {
                    b2 |= mLeftDragger.smoothSlideViewTo(child, -width, child.getTop());
                }
                else {
                    b2 |= mRightDragger.smoothSlideViewTo(child, this.getWidth(), child.getTop());
                }
                layoutParams.isPeeking = false;
            }
        }
        mLeftCallback.removeCallbacks();
        mRightCallback.removeCallbacks();
        if (b2) {
            this.invalidate();
        }
    }
    
    public void computeScroll() {
        final int childCount = this.getChildCount();
        float max = 0.0f;
        for (int i = 0; i < childCount; ++i) {
            max = Math.max(max, ((LayoutParams)this.getChildAt(i).getLayoutParams()).onScreen);
        }
        mScrimOpacity = max;
        if (mLeftDragger.continueSettling(true) | mRightDragger.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }
    
    void dispatchOnDrawerClosed(final View view) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if ((0x1 & layoutParams.openState) == 0x1) {
            layoutParams.openState = 0;
            if (mListeners != null) {
                for (int i = -1 + mListeners.size(); i >= 0; --i) {
                    ((DrawerListener)mListeners.get(i)).onDrawerClosed(view);
                }
            }
            this.updateChildrenImportantForAccessibility(view, false);
            if (this.hasWindowFocus()) {
                final View rootView = this.getRootView();
                if (rootView != null) {
                    rootView.sendAccessibilityEvent(32);
                }
            }
        }
    }
    
    void dispatchOnDrawerOpened(final View view) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if ((0x1 & layoutParams.openState) == 0x0) {
            layoutParams.openState = 1;
            if (mListeners != null) {
                for (int i = -1 + mListeners.size(); i >= 0; --i) {
                    ((DrawerListener)mListeners.get(i)).onDrawerOpened(view);
                }
            }
            this.updateChildrenImportantForAccessibility(view, true);
            if (this.hasWindowFocus()) {
                this.sendAccessibilityEvent(32);
            }
            view.requestFocus();
        }
    }
    
    void dispatchOnDrawerSlide(final View view, final float n) {
        if (mListeners != null) {
            for (int i = -1 + mListeners.size(); i >= 0; --i) {
                ((DrawerListener)mListeners.get(i)).onDrawerSlide(view, n);
            }
        }
    }
    
    protected boolean drawChild(final Canvas canvas, final View view, final long n) {
        final int height = this.getHeight();
        final boolean contentView = this.isContentView(view);
        int width = this.getWidth();
        final int save = canvas.save();
        int n2 = 0;
        if (contentView) {
            for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                final View child = this.getChildAt(i);
                if (child != view && child.getVisibility() == 0 && hasOpaqueBackground(child) && this.isDrawerView(child) && child.getHeight() >= height) {
                    if (this.checkDrawerViewAbsoluteGravity(child, 3)) {
                        final int right = child.getRight();
                        if (right > n2) {
                            n2 = right;
                        }
                    }
                    else {
                        final int left = child.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(n2, 0, width, this.getHeight());
        }
        final boolean drawChild = super.drawChild(canvas, view, n);
        canvas.restoreToCount(save);
        if (mScrimOpacity > 0.0f && contentView) {
            mScrimPaint.setColor((int)(((0xFF000000 & mScrimColor) >>> 24) * mScrimOpacity) << 24 | (0xFFFFFF & mScrimColor));
            canvas.drawRect((float)n2, 0.0f, (float)width, (float)this.getHeight(), mScrimPaint);
        }
        else {
            if (mShadowLeftResolved != null && this.checkDrawerViewAbsoluteGravity(view, 3)) {
                final int intrinsicWidth = mShadowLeftResolved.getIntrinsicWidth();
                final int right2 = view.getRight();
                final float max = Math.max(0.0f, Math.min((float)right2 / (float)mLeftDragger.getEdgeSize(), 1.0f));
                mShadowLeftResolved.setBounds(right2, view.getTop(), right2 + intrinsicWidth, view.getBottom());
                mShadowLeftResolved.setAlpha((int)(255.0f * max));
                mShadowLeftResolved.draw(canvas);
                return drawChild;
            }
            if (mShadowRightResolved != null && this.checkDrawerViewAbsoluteGravity(view, 5)) {
                final int intrinsicWidth2 = mShadowRightResolved.getIntrinsicWidth();
                final int left2 = view.getLeft();
                final float max2 = Math.max(0.0f, Math.min((float)(this.getWidth() - left2) / (float)mRightDragger.getEdgeSize(), 1.0f));
                mShadowRightResolved.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
                mShadowRightResolved.setAlpha((int)(255.0f * max2));
                mShadowRightResolved.draw(canvas);
                return drawChild;
            }
        }
        return drawChild;
    }
    
    View findDrawerWithGravity(final int n) {
        final int n2 = 0x7 & GravityCompat.getAbsoluteGravity(n, ViewCompat.getLayoutDirection((View)this));
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if ((0x7 & this.getDrawerViewAbsoluteGravity(child)) == n2) {
                return child;
            }
        }
        return null;
    }
    
    View findOpenDrawer() {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if ((0x1 & ((LayoutParams)child.getLayoutParams()).openState) == 0x1) {
                return child;
            }
        }
        return null;
    }
    
    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)new LayoutParams(-1, -1);
    }
    
    public ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)new LayoutParams(this.getContext(), set);
    }
    
    protected ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (viewGroup$LayoutParams instanceof LayoutParams) {
            return (ViewGroup$LayoutParams)new LayoutParams((LayoutParams)viewGroup$LayoutParams);
        }
        if (viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams) {
            return (ViewGroup$LayoutParams)new LayoutParams((ViewGroup$MarginLayoutParams)viewGroup$LayoutParams);
        }
        return (ViewGroup$LayoutParams)new LayoutParams(viewGroup$LayoutParams);
    }
    
    public float getDrawerElevation() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return mDrawerElevation;
        }
        return 0.0f;
    }
    
    public int getDrawerLockMode(final int n) {
        final int layoutDirection = ViewCompat.getLayoutDirection((View)this);
        switch (n) {
            case 3: {
                if (mLockModeLeft != 3) {
                    return mLockModeLeft;
                }
                int n2;
                if (layoutDirection == 0) {
                    n2 = mLockModeStart;
                }
                else {
                    n2 = mLockModeEnd;
                }
                if (n2 != 3) {
                    return n2;
                }
                break;
            }
            case 5: {
                if (mLockModeRight != 3) {
                    return mLockModeRight;
                }
                int n3;
                if (layoutDirection == 0) {
                    n3 = mLockModeEnd;
                }
                else {
                    n3 = mLockModeStart;
                }
                if (n3 != 3) {
                    return n3;
                }
                break;
            }
            case 8388611: {
                if (mLockModeStart != 3) {
                    return mLockModeStart;
                }
                int n4;
                if (layoutDirection == 0) {
                    n4 = mLockModeLeft;
                }
                else {
                    n4 = mLockModeRight;
                }
                if (n4 != 3) {
                    return n4;
                }
                break;
            }
            case 8388613: {
                if (mLockModeEnd != 3) {
                    return mLockModeEnd;
                }
                int n5;
                if (layoutDirection == 0) {
                    n5 = mLockModeRight;
                }
                else {
                    n5 = mLockModeLeft;
                }
                if (n5 != 3) {
                    return n5;
                }
                break;
            }
        }
        return 0;
    }
    
    public int getDrawerLockMode(final View view) {
        if (!this.isDrawerView(view)) {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
        return this.getDrawerLockMode(((LayoutParams)view.getLayoutParams()).gravity);
    }
    
    @Nullable
    public CharSequence getDrawerTitle(final int n) {
        final int absoluteGravity = GravityCompat.getAbsoluteGravity(n, ViewCompat.getLayoutDirection((View)this));
        if (absoluteGravity == 3) {
            return mTitleLeft;
        }
        if (absoluteGravity == 5) {
            return mTitleRight;
        }
        return null;
    }
    
    int getDrawerViewAbsoluteGravity(final View view) {
        return GravityCompat.getAbsoluteGravity(((LayoutParams)view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection((View)this));
    }
    
    float getDrawerViewOffset(final View view) {
        return ((LayoutParams)view.getLayoutParams()).onScreen;
    }
    
    public Drawable getStatusBarBackgroundDrawable() {
        return mStatusBarBackground;
    }
    
    boolean isContentView(final View view) {
        return ((LayoutParams)view.getLayoutParams()).gravity == 0;
    }
    
    public boolean isDrawerOpen(final int n) {
        final View drawerWithGravity = this.findDrawerWithGravity(n);
        return drawerWithGravity != null && this.isDrawerOpen(drawerWithGravity);
    }
    
    public boolean isDrawerOpen(final View view) {
        if (!this.isDrawerView(view)) {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
        return (0x1 & ((LayoutParams)view.getLayoutParams()).openState) == 0x1;
    }
    
    boolean isDrawerView(final View view) {
        final int absoluteGravity = GravityCompat.getAbsoluteGravity(((LayoutParams)view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(view));
        return (absoluteGravity & 0x3) != 0x0 || (absoluteGravity & 0x5) != 0x0;
    }
    
    public boolean isDrawerVisible(final int n) {
        final View drawerWithGravity = this.findDrawerWithGravity(n);
        return drawerWithGravity != null && this.isDrawerVisible(drawerWithGravity);
    }
    
    public boolean isDrawerVisible(final View view) {
        if (!this.isDrawerView(view)) {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
        return ((LayoutParams)view.getLayoutParams()).onScreen > 0.0f;
    }
    
    void moveDrawerToOffset(final View view, final float n) {
        final float drawerViewOffset = this.getDrawerViewOffset(view);
        final int width = view.getWidth();
        int n2 = (int)(n * width) - (int)(drawerViewOffset * width);
        if (!this.checkDrawerViewAbsoluteGravity(view, 3)) {
            n2 = -n2;
        }
        view.offsetLeftAndRight(n2);
        this.setDrawerViewOffset(view, n);
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mFirstLayout = true;
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mFirstLayout = true;
    }
    
    public void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        if (mDrawStatusBarBackground && mStatusBarBackground != null) {
            final int topInset = IMPL.getTopInset(mLastInsets);
            if (topInset > 0) {
                mStatusBarBackground.setBounds(0, 0, this.getWidth(), topInset);
                mStatusBarBackground.draw(canvas);
            }
        }
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        final boolean b = mLeftDragger.shouldInterceptTouchEvent(motionEvent) | mRightDragger.shouldInterceptTouchEvent(motionEvent);
        boolean b2 = false;
        switch (actionMasked) {
            case 0: {
                final float x = motionEvent.getX();
                final float y = motionEvent.getY();
                mInitialMotionX = x;
                mInitialMotionY = y;
                final float n = fcmpl(mScrimOpacity, 0.0f);
                b2 = false;
                if (n > 0) {
                    final View topChildUnder = mLeftDragger.findTopChildUnder((int)x, (int)y);
                    b2 = false;
                    if (topChildUnder != null) {
                        final boolean contentView = this.isContentView(topChildUnder);
                        b2 = false;
                        if (contentView) {
                            b2 = true;
                        }
                    }
                }
                mDisallowInterceptRequested = false;
                mChildrenCanceledTouch = false;
                break;
            }
            case 2: {
                final boolean checkTouchSlop = mLeftDragger.checkTouchSlop(3);
                b2 = false;
                if (checkTouchSlop) {
                    mLeftCallback.removeCallbacks();
                    mRightCallback.removeCallbacks();
                    b2 = false;
                    break;
                }
                break;
            }
            case 1:
            case 3:
                this.closeDrawers(true);
                mDisallowInterceptRequested = false;
                mChildrenCanceledTouch = false;
                b2 = false;
                break;
        }
        if (!b && !b2 && !this.hasPeekingDrawer()) {
            final boolean mChildrenCanceledTouch = this.mChildrenCanceledTouch;
            final boolean b3 = false;
            if (!mChildrenCanceledTouch) {
                return b3;
            }
        }
        return true;
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        if (n == 4 && this.hasVisibleDrawer()) {
            KeyEventCompat.startTracking(keyEvent);
            return true;
        }
        return super.onKeyDown(n, keyEvent);
    }
    
    public boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        if (n == 4) {
            final View visibleDrawer = this.findVisibleDrawer();
            if (visibleDrawer != null && this.getDrawerLockMode(visibleDrawer) == 0) {
                this.closeDrawers();
            }
            return visibleDrawer != null;
        }
        return super.onKeyUp(n, keyEvent);
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        mInLayout = true;
        final int n5 = n3 - n;
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
                if (this.isContentView(child)) {
                    child.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + child.getMeasuredWidth(), layoutParams.topMargin + child.getMeasuredHeight());
                }
                else {
                    final int measuredWidth = child.getMeasuredWidth();
                    final int measuredHeight = child.getMeasuredHeight();
                    int n6;
                    float n7;
                    if (this.checkDrawerViewAbsoluteGravity(child, 3)) {
                        n6 = -measuredWidth + (int)(measuredWidth * layoutParams.onScreen);
                        n7 = (measuredWidth + n6) / measuredWidth;
                    }
                    else {
                        n6 = n5 - (int)(measuredWidth * layoutParams.onScreen);
                        n7 = (n5 - n6) / measuredWidth;
                    }
                    int n8;
                    if (n7 != layoutParams.onScreen) {
                        n8 = 1;
                    }
                    else {
                        n8 = 0;
                    }
                    switch (0x70 & layoutParams.gravity) {
                        default:
                            child.layout(n6, layoutParams.topMargin, n6 + measuredWidth, measuredHeight + layoutParams.topMargin);
                            break;
                        case 80: {
                            final int n9 = n4 - n2;
                            child.layout(n6, n9 - layoutParams.bottomMargin - child.getMeasuredHeight(), n6 + measuredWidth, n9 - layoutParams.bottomMargin);
                            break;
                        }
                        case 16: {
                            final int n10 = n4 - n2;
                            int topMargin = (n10 - measuredHeight) / 2;
                            if (topMargin < layoutParams.topMargin) {
                                topMargin = layoutParams.topMargin;
                            }
                            else if (topMargin + measuredHeight > n10 - layoutParams.bottomMargin) {
                                topMargin = n10 - layoutParams.bottomMargin - measuredHeight;
                            }
                            child.layout(n6, topMargin, n6 + measuredWidth, topMargin + measuredHeight);
                            break;
                        }
                    }
                    if (n8 != 0) {
                        this.setDrawerViewOffset(child, n7);
                    }
                    int visibility;
                    if (layoutParams.onScreen > 0.0f) {
                        visibility = 0;
                    }
                    else {
                        visibility = 4;
                    }
                    if (child.getVisibility() != visibility) {
                        child.setVisibility(visibility);
                    }
                }
            }
        }
        mInLayout = false;
        mFirstLayout = false;
    }
    
    protected void onMeasure(final int n, final int n2) {
        final int mode = View$MeasureSpec.getMode(n);
        final int mode2 = View$MeasureSpec.getMode(n2);
        int size = View$MeasureSpec.getSize(n);
        int size2 = View$MeasureSpec.getSize(n2);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!this.isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
            if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                size2 = 300;
            }
        }
        this.setMeasuredDimension(size, size2);
        final boolean b = mLastInsets != null && ViewCompat.getFitsSystemWindows((View)this);
        final int layoutDirection = ViewCompat.getLayoutDirection((View)this);
        int n3 = 0;
        int n4 = 0;
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
                if (b) {
                    final int absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams.gravity, layoutDirection);
                    if (ViewCompat.getFitsSystemWindows(child)) {
                        IMPL.dispatchChildInsets(child, mLastInsets, absoluteGravity);
                    }
                    else {
                        IMPL.applyMarginInsets(layoutParams, mLastInsets, absoluteGravity);
                    }
                }
                if (this.isContentView(child)) {
                    child.measure(View$MeasureSpec.makeMeasureSpec(size - layoutParams.leftMargin - layoutParams.rightMargin, 1073741824), View$MeasureSpec.makeMeasureSpec(size2 - layoutParams.topMargin - layoutParams.bottomMargin, 1073741824));
                }
                else {
                    if (!this.isDrawerView(child)) {
                        throw new IllegalStateException("Child " + child + " at index " + i + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if (SET_DRAWER_SHADOW_FROM_ELEVATION && ViewCompat.getElevation(child) != mDrawerElevation) {
                        ViewCompat.setElevation(child, mDrawerElevation);
                    }
                    final int n5 = 0x7 & this.getDrawerViewAbsoluteGravity(child);
                    boolean b2;
                    if (n5 == 3) {
                        b2 = true;
                    }
                    else {
                        b2 = false;
                    }
                    if ((b2 && n3 != 0) || (!b2 && n4 != 0)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(n5) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
                    }
                    if (b2) {
                        n3 = 1;
                    }
                    else {
                        n4 = 1;
                    }
                    child.measure(getChildMeasureSpec(n, mMinDrawerMargin + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), getChildMeasureSpec(n2, layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height));
                }
            }
        }
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        final SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.openDrawerGravity != 0) {
            final View drawerWithGravity = this.findDrawerWithGravity(savedState.openDrawerGravity);
            if (drawerWithGravity != null) {
                this.openDrawer(drawerWithGravity);
            }
        }
        if (savedState.lockModeLeft != 3) {
            this.setDrawerLockMode(savedState.lockModeLeft, 3);
        }
        if (savedState.lockModeRight != 3) {
            this.setDrawerLockMode(savedState.lockModeRight, 5);
        }
        if (savedState.lockModeStart != 3) {
            this.setDrawerLockMode(savedState.lockModeStart, 8388611);
        }
        if (savedState.lockModeEnd != 3) {
            this.setDrawerLockMode(savedState.lockModeEnd, 8388613);
        }
    }
    
    public void onRtlPropertiesChanged(final int n) {
        this.resolveShadowDrawables();
    }
    
    protected Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState(super.onSaveInstanceState());
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final LayoutParams layoutParams = (LayoutParams)this.getChildAt(i).getLayoutParams();
            boolean b;
            if (layoutParams.openState == 1) {
                b = true;
            }
            else {
                b = false;
            }
            boolean b2;
            if (layoutParams.openState == 2) {
                b2 = true;
            }
            else {
                b2 = false;
            }
            if (b || b2) {
                savedState.openDrawerGravity = layoutParams.gravity;
                break;
            }
        }
        savedState.lockModeLeft = mLockModeLeft;
        savedState.lockModeRight = mLockModeRight;
        savedState.lockModeStart = mLockModeStart;
        savedState.lockModeEnd = mLockModeEnd;
        return (Parcelable)savedState;
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        mLeftDragger.processTouchEvent(motionEvent);
        mRightDragger.processTouchEvent(motionEvent);
        switch (0xFF & motionEvent.getAction()) {
            default:
                return true;
            case 0: {
                final float x = motionEvent.getX();
                final float y = motionEvent.getY();
                mInitialMotionX = x;
                mInitialMotionY = y;
                mDisallowInterceptRequested = false;
                mChildrenCanceledTouch = false;
                return true;
            }
            case 1: {
                final float x2 = motionEvent.getX();
                final float y2 = motionEvent.getY();
                boolean b = true;
                final View topChildUnder = mLeftDragger.findTopChildUnder((int)x2, (int)y2);
                if (topChildUnder != null && this.isContentView(topChildUnder)) {
                    final float n = x2 - mInitialMotionX;
                    final float n2 = y2 - mInitialMotionY;
                    final int touchSlop = mLeftDragger.getTouchSlop();
                    if (n * n + n2 * n2 < touchSlop * touchSlop) {
                        final View openDrawer = this.findOpenDrawer();
                        if (openDrawer != null) {
                            b = (this.getDrawerLockMode(openDrawer) == 2);
                        }
                    }
                }
                this.closeDrawers(b);
                mDisallowInterceptRequested = false;
                return true;
            }
            case 3:
                this.closeDrawers(true);
                mDisallowInterceptRequested = false;
                mChildrenCanceledTouch = false;
                return true;
        }
    }
    
    public void openDrawer(final int n) {
        final View drawerWithGravity = this.findDrawerWithGravity(n);
        if (drawerWithGravity == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(n));
        }
        this.openDrawer(drawerWithGravity);
    }
    
    public void openDrawer(final View view) {
        if (!this.isDrawerView(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (mFirstLayout) {
            layoutParams.onScreen = 1.0f;
            layoutParams.openState = 1;
            this.updateChildrenImportantForAccessibility(view, true);
        }
        else {
            layoutParams.openState |= 0x2;
            if (this.checkDrawerViewAbsoluteGravity(view, 3)) {
                mLeftDragger.smoothSlideViewTo(view, 0, view.getTop());
            }
            else {
                mRightDragger.smoothSlideViewTo(view, this.getWidth() - view.getWidth(), view.getTop());
            }
        }
        this.invalidate();
    }
    
    public void removeDrawerListener(@NonNull final DrawerListener drawerListener) {
        if (drawerListener != null && mListeners != null) {
            mListeners.remove(drawerListener);
        }
    }
    
    public void requestDisallowInterceptTouchEvent(final boolean mDisallowInterceptRequested) {
        super.requestDisallowInterceptTouchEvent(mDisallowInterceptRequested);
        this.mDisallowInterceptRequested = mDisallowInterceptRequested;
        if (mDisallowInterceptRequested) {
            this.closeDrawers(true);
        }
    }
    
    public void requestLayout() {
        if (!mInLayout) {
            super.requestLayout();
        }
    }
    
    public void setChildInsets(final Object mLastInsets, final boolean mDrawStatusBarBackground) {
        this.mLastInsets = mLastInsets;
        this.mDrawStatusBarBackground = mDrawStatusBarBackground;
        this.setWillNotDraw(!mDrawStatusBarBackground && this.getBackground() == null);
        this.requestLayout();
    }
    
    public void setDrawerElevation(final float mDrawerElevation) {
        this.mDrawerElevation = mDrawerElevation;
        for (int i = 0; i < this.getChildCount(); ++i) {
            final View child = this.getChildAt(i);
            if (this.isDrawerView(child)) {
                ViewCompat.setElevation(child, this.mDrawerElevation);
            }
        }
    }
    
    @Deprecated
    public void setDrawerListener(final DrawerListener mListener) {
        if (this.mListener != null) {
            this.removeDrawerListener(this.mListener);
        }
        if (mListener != null) {
            this.addDrawerListener(mListener);
        }
        this.mListener = mListener;
    }
    
    public void setDrawerLockMode(final int n) {
        this.setDrawerLockMode(n, 3);
        this.setDrawerLockMode(n, 5);
    }
    
    public void setDrawerLockMode(final int n, final int n2) {
        final int absoluteGravity = GravityCompat.getAbsoluteGravity(n2, ViewCompat.getLayoutDirection((View)this));
        switch (n2) {
            case 3:
                mLockModeLeft = n;
                break;
            case 5:
                mLockModeRight = n;
                break;
            case 8388611:
                mLockModeStart = n;
                break;
            case 8388613:
                mLockModeEnd = n;
                break;
        }
        if (n != 0) {
            ViewDragHelper viewDragHelper;
            if (absoluteGravity == 3) {
                viewDragHelper = mLeftDragger;
            }
            else {
                viewDragHelper = mRightDragger;
            }
            viewDragHelper.cancel();
        }
        switch (n) {
            case 2: {
                final View drawerWithGravity = this.findDrawerWithGravity(absoluteGravity);
                if (drawerWithGravity != null) {
                    this.openDrawer(drawerWithGravity);
                    return;
                }
                break;
            }
            case 1: {
                final View drawerWithGravity2 = this.findDrawerWithGravity(absoluteGravity);
                if (drawerWithGravity2 != null) {
                    this.closeDrawer(drawerWithGravity2);
                    return;
                }
                break;
            }
        }
    }
    
    public void setDrawerLockMode(final int n, final View view) {
        if (!this.isDrawerView(view)) {
            throw new IllegalArgumentException("View " + view + " is not a " + "drawer with appropriate layout_gravity");
        }
        this.setDrawerLockMode(n, ((LayoutParams)view.getLayoutParams()).gravity);
    }
    
    public void setDrawerShadow(@DrawableRes final int n, final int n2) {
        this.setDrawerShadow(this.getResources().getDrawable(n), n2);
    }
    
    public void setDrawerShadow(final Drawable drawable, final int n) {
        if (!SET_DRAWER_SHADOW_FROM_ELEVATION) {
            if ((n & 0x800003) == 0x800003) {
                mShadowStart = drawable;
            }
            else if ((n & 0x800005) == 0x800005) {
                mShadowEnd = drawable;
            }
            else if ((n & 0x3) == 0x3) {
                mShadowLeft = drawable;
            }
            else {
                if ((n & 0x5) != 0x5) {
                    return;
                }
                mShadowRight = drawable;
            }
            this.resolveShadowDrawables();
            this.invalidate();
        }
    }
    
    public void setDrawerTitle(final int n, final CharSequence charSequence) {
        final int absoluteGravity = GravityCompat.getAbsoluteGravity(n, ViewCompat.getLayoutDirection((View)this));
        if (absoluteGravity == 3) {
            mTitleLeft = charSequence;
        }
        else if (absoluteGravity == 5) {
            mTitleRight = charSequence;
        }
    }
    
    void setDrawerViewOffset(final View view, final float n) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (n == layoutParams.onScreen) {
            return;
        }
        layoutParams.onScreen = n;
        this.dispatchOnDrawerSlide(view, n);
    }
    
    public void setScrimColor(@ColorInt final int mScrimColor) {
        this.mScrimColor = mScrimColor;
        this.invalidate();
    }
    
    public void setStatusBarBackground(final int n) {
        Drawable drawable;
        if (n != 0) {
            drawable = ContextCompat.getDrawable(this.getContext(), n);
        }
        else {
            drawable = null;
        }
        mStatusBarBackground = drawable;
        this.invalidate();
    }
    
    public void setStatusBarBackground(final Drawable mStatusBarBackground) {
        this.mStatusBarBackground = mStatusBarBackground;
        this.invalidate();
    }
    
    public void setStatusBarBackgroundColor(@ColorInt final int n) {
        mStatusBarBackground = (Drawable)new ColorDrawable(n);
        this.invalidate();
    }
    
    void updateDrawerState(final int n, final int n2, final View view) {
        final int viewDragState = mLeftDragger.getViewDragState();
        final int viewDragState2 = mRightDragger.getViewDragState();
        int mDrawerState;
        if (viewDragState == 1 || viewDragState2 == 1) {
            mDrawerState = 1;
        }
        else if (viewDragState == 2 || viewDragState2 == 2) {
            mDrawerState = 2;
        }
        else {
            mDrawerState = 0;
        }
        if (view != null && n2 == 0) {
            final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            if (layoutParams.onScreen == 0.0f) {
                this.dispatchOnDrawerClosed(view);
            }
            else if (layoutParams.onScreen == 1.0f) {
                this.dispatchOnDrawerOpened(view);
            }
        }
        if (mDrawerState != this.mDrawerState) {
            this.mDrawerState = mDrawerState;
            if (mListeners != null) {
                for (int i = -1 + mListeners.size(); i >= 0; --i) {
                    ((DrawerListener)mListeners.get(i)).onDrawerStateChanged(mDrawerState);
                }
            }
        }
    }
}
