package android.support.design.widget;

import android.support.v4.os.ParcelableCompat;
import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.os.Parcelable$Creator;
import android.view.ViewParent;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import android.view.View$BaseSavedState;
import android.support.v4.content.ContextCompat;
import android.support.annotation.DrawableRes;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.ColorInt;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.graphics.drawable.Drawable$Callback;
import android.util.SparseArray;
import android.os.Parcelable;
import android.view.View$MeasureSpec;
import android.support.annotation.Nullable;
import java.io.Serializable;
import android.view.ViewGroup$MarginLayoutParams;
import android.graphics.Canvas;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewTreeObserver$OnPreDrawListener;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import java.util.HashMap;
import android.text.TextUtils;
import android.support.v4.view.GravityCompat;
import java.util.Collections;
import android.util.Log;
import android.support.v4.view.ViewCompat;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.design.R;
import java.util.ArrayList;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Build$VERSION;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.Paint;
import android.view.ViewGroup$OnHierarchyChangeListener;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.WindowInsetsCompat;
import java.util.List;
import java.lang.reflect.Constructor;
import java.util.Map;
import android.view.View;
import java.util.Comparator;
import android.support.v4.view.NestedScrollingParent;
import android.view.ViewGroup;

public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent
{
    static final Class<?>[] CONSTRUCTOR_PARAMS;
    static final CoordinatorLayoutInsetsHelper INSETS_HELPER;
    static final String TAG = "CoordinatorLayout";
    static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR;
    private static final int TYPE_ON_INTERCEPT = 0;
    private static final int TYPE_ON_TOUCH = 1;
    static final String WIDGET_PACKAGE_NAME;
    static final ThreadLocal<Map<String, Constructor<Behavior>>> sConstructors;
    private View mBehaviorTouchView;
    private final List<View> mDependencySortedChildren;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private WindowInsetsCompat mLastInsets;
    final Comparator<View> mLayoutDependencyComparator;
    private boolean mNeedsPreDrawListener;
    private View mNestedScrollingDirectChild;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    private ViewGroup$OnHierarchyChangeListener mOnHierarchyChangeListener;
    private OnPreDrawListener mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List<View> mTempDependenciesList;
    private final int[] mTempIntPair;
    private final List<View> mTempList1;
    private final Rect mTempRect1;
    private final Rect mTempRect2;
    private final Rect mTempRect3;
    
    static {
        final Package package1 = CoordinatorLayout.class.getPackage();
        String name;
        if (package1 != null) {
            name = package1.getName();
        }
        else {
            name = null;
        }
        WIDGET_PACKAGE_NAME = name;
        if (Build$VERSION.SDK_INT >= 21) {
            TOP_SORTED_CHILDREN_COMPARATOR = new ViewElevationComparator();
            INSETS_HELPER = new CoordinatorLayoutInsetsHelperLollipop();
        }
        else {
            TOP_SORTED_CHILDREN_COMPARATOR = null;
            INSETS_HELPER = null;
        }
        CONSTRUCTOR_PARAMS = new Class[] { Context.class, AttributeSet.class };
        sConstructors = new ThreadLocal<Map<String, Constructor<Behavior>>>();
    }
    
    public CoordinatorLayout(final Context context) {
        this(context, null);
    }
    
    public CoordinatorLayout(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public CoordinatorLayout(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        mLayoutDependencyComparator = new Comparator<View>() {
            final /* synthetic */ CoordinatorLayout this$0;
            
            CoordinatorLayout$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public int compare(final View view, final View view2) {
                if (view == view2) {
                    return 0;
                }
                if (((LayoutParams)view.getLayoutParams()).dependsOn(this$0, view, view2)) {
                    return 1;
                }
                if (((LayoutParams)view2.getLayoutParams()).dependsOn(this$0, view2, view)) {
                    return -1;
                }
                return 0;
            }
            
            @Override
            public /* bridge */ int compare(final Object o, final Object o2) {
                return this.compare((View)o, (View)o2);
            }
        };
        mDependencySortedChildren = new ArrayList<View>();
        mTempList1 = new ArrayList<View>();
        mTempDependenciesList = new ArrayList<View>();
        mTempRect1 = new Rect();
        mTempRect2 = new Rect();
        mTempRect3 = new Rect();
        mTempIntPair = new int[2];
        mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        ThemeUtils.checkAppCompatTheme(context);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.CoordinatorLayout, n, R.style.Widget_Design_CoordinatorLayout);
        final int resourceId = obtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            final Resources resources = context.getResources();
            mKeylines = resources.getIntArray(resourceId);
            final float density = resources.getDisplayMetrics().density;
            for (int length = mKeylines.length, i = 0; i < length; ++i) {
                final int[] mKeylines = this.mKeylines;
                mKeylines[i] *= density;
            }
        }
        mStatusBarBackground = obtainStyledAttributes.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        if (INSETS_HELPER != null) {
            INSETS_HELPER.setupForWindowInsets(this, (OnApplyWindowInsetsListener)new ApplyInsetsListener(this));
        }
        super.setOnHierarchyChangeListener((ViewGroup$OnHierarchyChangeListener)new HierarchyChangeListener(this));
    }
    
    static /* synthetic */ WindowInsetsCompat access$200(final CoordinatorLayout coordinatorLayout, final WindowInsetsCompat windowInsets) {
        return coordinatorLayout.setWindowInsets(windowInsets);
    }
    
    static /* synthetic */ ViewGroup$OnHierarchyChangeListener access$300(final CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.mOnHierarchyChangeListener;
    }
    
    private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat onApplyWindowInsets) {
        if (onApplyWindowInsets.isConsumed()) {
            return onApplyWindowInsets;
        }
        for (int i = 0; i < this.getChildCount(); ++i) {
            final View child = this.getChildAt(i);
            if (ViewCompat.getFitsSystemWindows(child)) {
                final Behavior behavior = ((LayoutParams)child.getLayoutParams()).getBehavior();
                if (behavior != null) {
                    onApplyWindowInsets = behavior.onApplyWindowInsets(this, child, onApplyWindowInsets);
                    if (onApplyWindowInsets.isConsumed()) {
                        break;
                    }
                }
            }
        }
        return onApplyWindowInsets;
    }
    
    private int getKeyline(final int n) {
        if (mKeylines == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + n);
            return 0;
        }
        if (n < 0 || n >= mKeylines.length) {
            Log.e("CoordinatorLayout", "Keyline index " + n + " out of range for " + this);
            return 0;
        }
        return mKeylines[n];
    }
    
    private void getTopSortedChildren(final List<View> list) {
        list.clear();
        final boolean childrenDrawingOrderEnabled = this.isChildrenDrawingOrderEnabled();
        final int childCount = this.getChildCount();
        for (int i = childCount - 1; i >= 0; --i) {
            int childDrawingOrder;
            if (childrenDrawingOrderEnabled) {
                childDrawingOrder = this.getChildDrawingOrder(childCount, i);
            }
            else {
                childDrawingOrder = i;
            }
            list.add(this.getChildAt(childDrawingOrder));
        }
        if (TOP_SORTED_CHILDREN_COMPARATOR != null) {
            Collections.<Object>sort((List<Object>)list, (Comparator<? super Object>)TOP_SORTED_CHILDREN_COMPARATOR);
        }
    }
    
    private void layoutChild(final View view, final int n) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        final Rect mTempRect1 = this.mTempRect1;
        mTempRect1.set(this.getPaddingLeft() + layoutParams.leftMargin, this.getPaddingTop() + layoutParams.topMargin, this.getWidth() - this.getPaddingRight() - layoutParams.rightMargin, this.getHeight() - this.getPaddingBottom() - layoutParams.bottomMargin);
        if (mLastInsets != null && ViewCompat.getFitsSystemWindows((View)this) && !ViewCompat.getFitsSystemWindows(view)) {
            mTempRect1.left += mLastInsets.getSystemWindowInsetLeft();
            mTempRect1.top += mLastInsets.getSystemWindowInsetTop();
            mTempRect1.right -= mLastInsets.getSystemWindowInsetRight();
            mTempRect1.bottom -= mLastInsets.getSystemWindowInsetBottom();
        }
        final Rect mTempRect2 = this.mTempRect2;
        GravityCompat.apply(resolveGravity(layoutParams.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), mTempRect1, mTempRect2, n);
        view.layout(mTempRect2.left, mTempRect2.top, mTempRect2.right, mTempRect2.bottom);
    }
    
    private void layoutChildWithAnchor(final View view, final View view2, final int n) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        final Rect mTempRect1 = this.mTempRect1;
        final Rect mTempRect2 = this.mTempRect2;
        this.getDescendantRect(view2, mTempRect1);
        this.getDesiredAnchoredChildRect(view, n, mTempRect1, mTempRect2);
        view.layout(mTempRect2.left, mTempRect2.top, mTempRect2.right, mTempRect2.bottom);
    }
    
    private void layoutChildWithKeyline(final View view, int n, final int n2) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        final int absoluteGravity = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(layoutParams.gravity), n2);
        final int n3 = absoluteGravity & 0x7;
        final int n4 = absoluteGravity & 0x70;
        final int width = this.getWidth();
        final int height = this.getHeight();
        final int measuredWidth = view.getMeasuredWidth();
        final int measuredHeight = view.getMeasuredHeight();
        if (n2 == 1) {
            n = width - n;
        }
        int n5 = this.getKeyline(n) - measuredWidth;
        switch (n3) {
            case 5:
                n5 += measuredWidth;
                break;
            case 1:
                n5 += measuredWidth / 2;
                break;
        }
        int n6 = 0;
        switch (n4) {
            case 80:
                n6 = 0 + measuredHeight;
                break;
            case 16:
                n6 = 0 + measuredHeight / 2;
                break;
        }
        final int max = Math.max(this.getPaddingLeft() + layoutParams.leftMargin, Math.min(n5, width - this.getPaddingRight() - measuredWidth - layoutParams.rightMargin));
        final int max2 = Math.max(this.getPaddingTop() + layoutParams.topMargin, Math.min(n6, height - this.getPaddingBottom() - measuredHeight - layoutParams.bottomMargin));
        view.layout(max, max2, max + measuredWidth, max2 + measuredHeight);
    }
    
    static Behavior parseBehavior(final Context context, final AttributeSet set, final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return null;
        }
        Label_0151: {
            if (!s.startsWith(".")) {
                break Label_0151;
            }
            String s2 = context.getPackageName() + s;
            try {
                // iftrue(Label_0165:, s.indexOf(46) < 0)
            Label_0200:
                while (true) {
                    while (true) {
                        Map<String, Constructor<Behavior>> map = (Map<String, Constructor<Behavior>>)sConstructors.get();
                        if (map == null) {
                            map = new HashMap<String, Constructor<Behavior>>();
                            sConstructors.set(map);
                        }
                        Constructor<?> constructor = (Constructor<Behavior>)map.get(s2);
                        if (constructor == null) {
                            constructor = Class.forName(s2, true, context.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);
                            constructor.setAccessible(true);
                            map.put(s2, (Constructor<Behavior>)constructor);
                        }
                        return constructor.newInstance(context, set);
                        Label_0203: {
                            s2 = s;
                        }
                        break Label_0200;
                        s2 = s;
                        continue;
                    }
                    Label_0165: {
                        s2 = WIDGET_PACKAGE_NAME + '.' + s;
                    }
                    continue Label_0200;
                }
            }
            // iftrue(Label_0203:, TextUtils.isEmpty((CharSequence)CoordinatorLayout.WIDGET_PACKAGE_NAME))
            catch (Exception ex) {
                throw new RuntimeException("Could not inflate Behavior subclass " + s2, ex);
            }
        }
    }
    
    private boolean performIntercept(final MotionEvent motionEvent, final int n) {
        boolean b = false;
        int n2 = 0;
        MotionEvent obtain = null;
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        final List<View> mTempList1 = this.mTempList1;
        this.getTopSortedChildren(mTempList1);
        for (int size = mTempList1.size(), i = 0; i < size; ++i) {
            final View mBehaviorTouchView = (View)mTempList1.get(i);
            final LayoutParams layoutParams = (LayoutParams)mBehaviorTouchView.getLayoutParams();
            final Behavior behavior = layoutParams.getBehavior();
            if ((b || n2 != 0) && actionMasked != 0) {
                if (behavior != null) {
                    if (obtain == null) {
                        final long uptimeMillis = SystemClock.uptimeMillis();
                        obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    switch (n) {
                        case 0:
                            behavior.onInterceptTouchEvent(this, mBehaviorTouchView, obtain);
                            break;
                        case 1:
                            behavior.onTouchEvent(this, mBehaviorTouchView, obtain);
                            break;
                    }
                }
            }
            else {
                if (!b && behavior != null) {
                    switch (n) {
                        case 0:
                            b = behavior.onInterceptTouchEvent(this, mBehaviorTouchView, motionEvent);
                            break;
                        case 1:
                            b = behavior.onTouchEvent(this, mBehaviorTouchView, motionEvent);
                            break;
                    }
                    if (b) {
                        this.mBehaviorTouchView = mBehaviorTouchView;
                    }
                }
                final boolean didBlockInteraction = layoutParams.didBlockInteraction();
                final boolean blockingInteractionBelow = layoutParams.isBlockingInteractionBelow(this, mBehaviorTouchView);
                if (blockingInteractionBelow && !didBlockInteraction) {
                    n2 = 1;
                }
                else {
                    n2 = 0;
                }
                if (blockingInteractionBelow && n2 == 0) {
                    break;
                }
            }
        }
        mTempList1.clear();
        return b;
    }
    
    private void prepareChildren() {
        mDependencySortedChildren.clear();
        for (int i = 0; i < this.getChildCount(); ++i) {
            final View child = this.getChildAt(i);
            this.getResolvedLayoutParams(child).findAnchorView(this, child);
            mDependencySortedChildren.add(child);
        }
        selectionSort(mDependencySortedChildren, mLayoutDependencyComparator);
    }
    
    private void resetTouchBehaviors() {
        if (mBehaviorTouchView != null) {
            final Behavior behavior = ((LayoutParams)mBehaviorTouchView.getLayoutParams()).getBehavior();
            if (behavior != null) {
                final long uptimeMillis = SystemClock.uptimeMillis();
                final MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                behavior.onTouchEvent(this, mBehaviorTouchView, obtain);
                obtain.recycle();
            }
            mBehaviorTouchView = null;
        }
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            ((LayoutParams)this.getChildAt(i).getLayoutParams()).resetTouchBehaviorTracking();
        }
    }
    
    private static int resolveAnchoredChildGravity(int n) {
        if (n == 0) {
            n = 17;
        }
        return n;
    }
    
    private static int resolveGravity(int n) {
        if (n == 0) {
            n = 8388659;
        }
        return n;
    }
    
    private static int resolveKeylineGravity(int n) {
        if (n == 0) {
            n = 8388661;
        }
        return n;
    }
    
    private static void selectionSort(final List<View> list, final Comparator<View> comparator) {
        if (list != null && list.size() >= 2) {
            final View[] array = new View[list.size()];
            list.<View>toArray(array);
            final int length = array.length;
            for (int i = 0; i < length; ++i) {
                int n = i;
                for (int j = i + 1; j < length; ++j) {
                    if (comparator.compare(array[j], array[n]) < 0) {
                        n = j;
                    }
                }
                if (i != n) {
                    final View view = array[n];
                    array[n] = array[i];
                    array[i] = view;
                }
            }
            list.clear();
            for (int k = 0; k < length; ++k) {
                list.add(array[k]);
            }
        }
    }
    
    private WindowInsetsCompat setWindowInsets(WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors) {
        boolean willNotDraw = true;
        if (mLastInsets != dispatchApplyWindowInsetsToBehaviors) {
            mLastInsets = dispatchApplyWindowInsetsToBehaviors;
            mDrawStatusBarBackground = (dispatchApplyWindowInsetsToBehaviors != null && dispatchApplyWindowInsetsToBehaviors.getSystemWindowInsetTop() > 0 && willNotDraw);
            if (mDrawStatusBarBackground || this.getBackground() != null) {
                willNotDraw = false;
            }
            this.setWillNotDraw(willNotDraw);
            dispatchApplyWindowInsetsToBehaviors = this.dispatchApplyWindowInsetsToBehaviors(dispatchApplyWindowInsetsToBehaviors);
            this.requestLayout();
        }
        return dispatchApplyWindowInsetsToBehaviors;
    }
    
    void addPreDrawListener() {
        if (mIsAttachedToWindow) {
            if (mOnPreDrawListener == null) {
                mOnPreDrawListener = new OnPreDrawListener();
            }
            this.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)mOnPreDrawListener);
        }
        mNeedsPreDrawListener = true;
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof LayoutParams && super.checkLayoutParams(viewGroup$LayoutParams);
    }
    
    void dispatchDependentViewRemoved(final View view) {
        final int size = mDependencySortedChildren.size();
        boolean b = false;
        for (int i = 0; i < size; ++i) {
            final View view2 = (View)mDependencySortedChildren.get(i);
            if (view2 == view) {
                b = true;
            }
            else if (b) {
                final LayoutParams layoutParams = (LayoutParams)view2.getLayoutParams();
                final Behavior behavior = layoutParams.getBehavior();
                if (behavior != null && layoutParams.dependsOn(this, view2, view)) {
                    behavior.onDependentViewRemoved(this, view2, view);
                }
            }
        }
    }
    
    public void dispatchDependentViewsChanged(final View view) {
        final int size = mDependencySortedChildren.size();
        boolean b = false;
        for (int i = 0; i < size; ++i) {
            final View view2 = (View)mDependencySortedChildren.get(i);
            if (view2 == view) {
                b = true;
            }
            else if (b) {
                final LayoutParams layoutParams = (LayoutParams)view2.getLayoutParams();
                final Behavior behavior = layoutParams.getBehavior();
                if (behavior != null && layoutParams.dependsOn(this, view2, view)) {
                    behavior.onDependentViewChanged(this, view2, view);
                }
            }
        }
    }
    
    void dispatchOnDependentViewChanged(final boolean b) {
        final int layoutDirection = ViewCompat.getLayoutDirection((View)this);
        for (int size = mDependencySortedChildren.size(), i = 0; i < size; ++i) {
            final View view = (View)mDependencySortedChildren.get(i);
            final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            for (int j = 0; j < i; ++j) {
                if (layoutParams.mAnchorDirectChild == mDependencySortedChildren.get(j)) {
                    this.offsetChildToAnchor(view, layoutDirection);
                }
            }
            final Rect mTempRect1 = this.mTempRect1;
            final Rect mTempRect2 = this.mTempRect2;
            this.getLastChildRect(view, mTempRect1);
            this.getChildRect(view, true, mTempRect2);
            if (!mTempRect1.equals((Object)mTempRect2)) {
                this.recordLastChildRect(view, mTempRect2);
                for (int k = i + 1; k < size; ++k) {
                    final View view2 = (View)mDependencySortedChildren.get(k);
                    final LayoutParams layoutParams2 = (LayoutParams)view2.getLayoutParams();
                    final Behavior behavior = layoutParams2.getBehavior();
                    if (behavior != null && behavior.layoutDependsOn(this, view2, view)) {
                        if (!b && layoutParams2.getChangedAfterNestedScroll()) {
                            layoutParams2.resetChangedAfterNestedScroll();
                        }
                        else {
                            final boolean onDependentViewChanged = behavior.onDependentViewChanged(this, view2, view);
                            if (b) {
                                layoutParams2.setChangedAfterNestedScroll(onDependentViewChanged);
                            }
                        }
                    }
                }
            }
        }
    }
    
    public boolean doViewsOverlap(final View view, final View view2) {
        if (view.getVisibility() == 0 && view2.getVisibility() == 0) {
            final Rect mTempRect1 = this.mTempRect1;
            this.getChildRect(view, view.getParent() != this, mTempRect1);
            final Rect mTempRect2 = this.mTempRect2;
            this.getChildRect(view2, view2.getParent() != this, mTempRect2);
            return mTempRect1.left <= mTempRect2.right && mTempRect1.top <= mTempRect2.bottom && mTempRect1.right >= mTempRect2.left && mTempRect1.bottom >= mTempRect2.top;
        }
        return false;
    }
    
    protected boolean drawChild(final Canvas canvas, final View view, final long n) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.mBehavior != null && layoutParams.mBehavior.getScrimOpacity(this, view) > 0.0f) {
            if (mScrimPaint == null) {
                mScrimPaint = new Paint();
            }
            mScrimPaint.setColor(layoutParams.mBehavior.getScrimColor(this, view));
            canvas.drawRect((float)this.getPaddingLeft(), (float)this.getPaddingTop(), (float)(this.getWidth() - this.getPaddingRight()), (float)(this.getHeight() - this.getPaddingBottom()), mScrimPaint);
        }
        return super.drawChild(canvas, view, n);
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final int[] drawableState = this.getDrawableState();
        final Drawable mStatusBarBackground = this.mStatusBarBackground;
        boolean b = false;
        if (mStatusBarBackground != null) {
            final boolean stateful = mStatusBarBackground.isStateful();
            b = false;
            if (stateful) {
                b = (false | mStatusBarBackground.setState(drawableState));
            }
        }
        if (b) {
            this.invalidate();
        }
    }
    
    void ensurePreDrawListener() {
        final int childCount = this.getChildCount();
        int n = 0;
        boolean b;
        while (true) {
            b = false;
            if (n >= childCount) {
                break;
            }
            if (this.hasDependencies(this.getChildAt(n))) {
                b = true;
                break;
            }
            ++n;
        }
        if (b != mNeedsPreDrawListener) {
            if (!b) {
                this.removePreDrawListener();
                return;
            }
            this.addPreDrawListener();
        }
    }
    
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }
    
    protected /* bridge */ ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)this.generateDefaultLayoutParams();
    }
    
    public LayoutParams generateLayoutParams(final AttributeSet set) {
        return new LayoutParams(this.getContext(), set);
    }
    
    protected LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (viewGroup$LayoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams)viewGroup$LayoutParams);
        }
        if (viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams) {
            return new LayoutParams((ViewGroup$MarginLayoutParams)viewGroup$LayoutParams);
        }
        return new LayoutParams(viewGroup$LayoutParams);
    }
    
    public /* bridge */ ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)this.generateLayoutParams(set);
    }
    
    protected /* bridge */ ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return (ViewGroup$LayoutParams)this.generateLayoutParams(viewGroup$LayoutParams);
    }
    
    void getChildRect(final View view, final boolean b, final Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.set(0, 0, 0, 0);
            return;
        }
        if (b) {
            this.getDescendantRect(view, rect);
            return;
        }
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }
    
    public List<View> getDependencies(final View view) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        final List<View> mTempDependenciesList = this.mTempDependenciesList;
        mTempDependenciesList.clear();
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child != view && layoutParams.dependsOn(this, view, child)) {
                mTempDependenciesList.add(child);
            }
        }
        return mTempDependenciesList;
    }
    
    void getDescendantRect(final View view, final Rect rect) {
        ViewGroupUtils.getDescendantRect(this, view, rect);
    }
    
    void getDesiredAnchoredChildRect(final View view, final int n, final Rect rect, final Rect rect2) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        final int absoluteGravity = GravityCompat.getAbsoluteGravity(resolveAnchoredChildGravity(layoutParams.gravity), n);
        final int absoluteGravity2 = GravityCompat.getAbsoluteGravity(resolveGravity(layoutParams.anchorGravity), n);
        final int n2 = absoluteGravity & 0x7;
        final int n3 = absoluteGravity & 0x70;
        final int n4 = absoluteGravity2 & 0x7;
        final int n5 = absoluteGravity2 & 0x70;
        final int measuredWidth = view.getMeasuredWidth();
        final int measuredHeight = view.getMeasuredHeight();
        int n6 = 0;
        switch (n4) {
            default:
                n6 = rect.left;
                break;
            case 5:
                n6 = rect.right;
                break;
            case 1:
                n6 = rect.left + rect.width() / 2;
                break;
        }
        int n7 = 0;
        switch (n5) {
            default:
                n7 = rect.top;
                break;
            case 80:
                n7 = rect.bottom;
                break;
            case 16:
                n7 = rect.top + rect.height() / 2;
                break;
        }
        switch (n2) {
            case 1:
                n6 -= measuredWidth / 2;
            default:
                n6 -= measuredWidth;
            case 5:
                switch (n3) {
                    case 16:
                        n7 -= measuredHeight / 2;
                    default:
                        n7 -= measuredHeight;
                    case 80: {
                        final int width = this.getWidth();
                        final int height = this.getHeight();
                        final int max = Math.max(this.getPaddingLeft() + layoutParams.leftMargin, Math.min(n6, width - this.getPaddingRight() - measuredWidth - layoutParams.rightMargin));
                        final int max2 = Math.max(this.getPaddingTop() + layoutParams.topMargin, Math.min(n7, height - this.getPaddingBottom() - measuredHeight - layoutParams.bottomMargin));
                        rect2.set(max, max2, max + measuredWidth, max2 + measuredHeight);
                        return;
                    }
                }
                break;
        }
    }
    
    void getLastChildRect(final View view, final Rect rect) {
        rect.set(((LayoutParams)view.getLayoutParams()).getLastChildRect());
    }
    
    public int getNestedScrollAxes() {
        return mNestedScrollingParentHelper.getNestedScrollAxes();
    }
    
    LayoutParams getResolvedLayoutParams(final View view) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.mBehaviorResolved) {
            return layoutParams;
        }
        Serializable s = view.getClass();
        DefaultBehavior defaultBehavior = null;
        while (s != null) {
            defaultBehavior = ((Class<? extends View>)s).<DefaultBehavior>getAnnotation(DefaultBehavior.class);
            if (defaultBehavior != null) {
                break;
            }
            s = ((Class<? extends View>)s).getSuperclass();
        }
        while (true) {
            if (defaultBehavior == null) {
                break Label_0073;
            }
            try {
                layoutParams.setBehavior((Behavior)defaultBehavior.value().newInstance());
                layoutParams.mBehaviorResolved = true;
                return layoutParams;
            }
            catch (Exception ex) {
                Log.e("CoordinatorLayout", "Default behavior class " + defaultBehavior.value().getName() + " could not be instantiated. Did you forget a default constructor?", (Throwable)ex);
                continue;
            }
            break;
        }
    }
    
    @Nullable
    public Drawable getStatusBarBackground() {
        return mStatusBarBackground;
    }
    
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), this.getPaddingTop() + this.getPaddingBottom());
    }
    
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), this.getPaddingLeft() + this.getPaddingRight());
    }
    
    boolean hasDependencies(final View view) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.mAnchorView != null) {
            return true;
        }
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child != view && layoutParams.dependsOn(this, view, child)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isPointInChildBounds(final View view, final int n, final int n2) {
        final Rect mTempRect1 = this.mTempRect1;
        this.getDescendantRect(view, mTempRect1);
        return mTempRect1.contains(n, n2);
    }
    
    void offsetChildToAnchor(final View view, final int n) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.mAnchorView != null) {
            final Rect mTempRect1 = this.mTempRect1;
            final Rect mTempRect2 = this.mTempRect2;
            final Rect mTempRect3 = this.mTempRect3;
            this.getDescendantRect(layoutParams.mAnchorView, mTempRect1);
            this.getChildRect(view, false, mTempRect2);
            this.getDesiredAnchoredChildRect(view, n, mTempRect1, mTempRect3);
            final int n2 = mTempRect3.left - mTempRect2.left;
            final int n3 = mTempRect3.top - mTempRect2.top;
            if (n2 != 0) {
                view.offsetLeftAndRight(n2);
            }
            if (n3 != 0) {
                view.offsetTopAndBottom(n3);
            }
            if (n2 != 0 || n3 != 0) {
                final Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    behavior.onDependentViewChanged(this, view, layoutParams.mAnchorView);
                }
            }
        }
    }
    
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.resetTouchBehaviors();
        if (mNeedsPreDrawListener) {
            if (mOnPreDrawListener == null) {
                mOnPreDrawListener = new OnPreDrawListener();
            }
            this.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)mOnPreDrawListener);
        }
        if (mLastInsets == null && ViewCompat.getFitsSystemWindows((View)this)) {
            ViewCompat.requestApplyInsets((View)this);
        }
        mIsAttachedToWindow = true;
    }
    
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.resetTouchBehaviors();
        if (mNeedsPreDrawListener && mOnPreDrawListener != null) {
            this.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)mOnPreDrawListener);
        }
        if (mNestedScrollingTarget != null) {
            this.onStopNestedScroll(mNestedScrollingTarget);
        }
        mIsAttachedToWindow = false;
    }
    
    public void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        if (mDrawStatusBarBackground && mStatusBarBackground != null) {
            int systemWindowInsetTop;
            if (mLastInsets != null) {
                systemWindowInsetTop = mLastInsets.getSystemWindowInsetTop();
            }
            else {
                systemWindowInsetTop = 0;
            }
            if (systemWindowInsetTop > 0) {
                mStatusBarBackground.setBounds(0, 0, this.getWidth(), systemWindowInsetTop);
                mStatusBarBackground.draw(canvas);
            }
        }
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.resetTouchBehaviors();
        }
        final boolean performIntercept = this.performIntercept(motionEvent, 0);
        if (false) {
            ((MotionEvent)null).recycle();
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.resetTouchBehaviors();
        }
        return performIntercept;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        final int layoutDirection = ViewCompat.getLayoutDirection((View)this);
        for (int size = mDependencySortedChildren.size(), i = 0; i < size; ++i) {
            final View view = (View)mDependencySortedChildren.get(i);
            final Behavior behavior = ((LayoutParams)view.getLayoutParams()).getBehavior();
            if (behavior == null || !behavior.onLayoutChild(this, view, layoutDirection)) {
                this.onLayoutChild(view, layoutDirection);
            }
        }
    }
    
    public void onLayoutChild(final View view, final int n) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.checkAnchorChanged()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        if (layoutParams.mAnchorView != null) {
            this.layoutChildWithAnchor(view, layoutParams.mAnchorView, n);
            return;
        }
        if (layoutParams.keyline >= 0) {
            this.layoutChildWithKeyline(view, layoutParams.keyline, n);
            return;
        }
        this.layoutChild(view, n);
    }
    
    protected void onMeasure(final int n, final int n2) {
        this.prepareChildren();
        this.ensurePreDrawListener();
        final int paddingLeft = this.getPaddingLeft();
        final int paddingTop = this.getPaddingTop();
        final int paddingRight = this.getPaddingRight();
        final int paddingBottom = this.getPaddingBottom();
        final int layoutDirection = ViewCompat.getLayoutDirection((View)this);
        boolean b;
        if (layoutDirection == 1) {
            b = true;
        }
        else {
            b = false;
        }
        final int mode = View$MeasureSpec.getMode(n);
        final int size = View$MeasureSpec.getSize(n);
        final int mode2 = View$MeasureSpec.getMode(n2);
        final int size2 = View$MeasureSpec.getSize(n2);
        final int n3 = paddingLeft + paddingRight;
        final int n4 = paddingTop + paddingBottom;
        int n5 = this.getSuggestedMinimumWidth();
        int n6 = this.getSuggestedMinimumHeight();
        int combineMeasuredStates = 0;
        boolean b2;
        if (mLastInsets != null && ViewCompat.getFitsSystemWindows((View)this)) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        for (int size3 = mDependencySortedChildren.size(), i = 0; i < size3; ++i) {
            final View view = (View)mDependencySortedChildren.get(i);
            final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            final int keyline = layoutParams.keyline;
            int n7 = 0;
            Label_0250: {
                if (keyline >= 0) {
                    n7 = 0;
                    if (mode != 0) {
                        final int keyline2 = this.getKeyline(layoutParams.keyline);
                        final int n8 = 0x7 & GravityCompat.getAbsoluteGravity(resolveKeylineGravity(layoutParams.gravity), layoutDirection);
                        if ((n8 == 3 && !b) || (n8 == 5 && b)) {
                            n7 = Math.max(0, size - paddingRight - keyline2);
                        }
                        else {
                            if (n8 != 5 || b) {
                                n7 = 0;
                                if (n8 != 3) {
                                    break Label_0250;
                                }
                                n7 = 0;
                                if (!b) {
                                    break Label_0250;
                                }
                            }
                            n7 = Math.max(0, keyline2 - paddingLeft);
                        }
                    }
                }
            }
            int measureSpec = n;
            int measureSpec2 = n2;
            if (b2 && !ViewCompat.getFitsSystemWindows(view)) {
                final int n9 = mLastInsets.getSystemWindowInsetLeft() + mLastInsets.getSystemWindowInsetRight();
                final int n10 = mLastInsets.getSystemWindowInsetTop() + mLastInsets.getSystemWindowInsetBottom();
                measureSpec = View$MeasureSpec.makeMeasureSpec(size - n9, mode);
                measureSpec2 = View$MeasureSpec.makeMeasureSpec(size2 - n10, mode2);
            }
            final Behavior behavior = layoutParams.getBehavior();
            if (behavior == null || !behavior.onMeasureChild(this, view, measureSpec, n7, measureSpec2, 0)) {
                this.onMeasureChild(view, measureSpec, n7, measureSpec2, 0);
            }
            n5 = Math.max(n5, n3 + view.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            n6 = Math.max(n6, n4 + view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            combineMeasuredStates = ViewCompat.combineMeasuredStates(combineMeasuredStates, ViewCompat.getMeasuredState(view));
        }
        this.setMeasuredDimension(ViewCompat.resolveSizeAndState(n5, n, 0xFF000000 & combineMeasuredStates), ViewCompat.resolveSizeAndState(n6, n2, combineMeasuredStates << 16));
    }
    
    public void onMeasureChild(final View view, final int n, final int n2, final int n3, final int n4) {
        this.measureChildWithMargins(view, n, n2, n3, n4);
    }
    
    public boolean onNestedFling(final View view, final float n, final float n2, final boolean b) {
        boolean b2 = false;
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
            if (layoutParams.isNestedScrollAccepted()) {
                final Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    b2 |= behavior.onNestedFling(this, child, view, n, n2, b);
                }
            }
        }
        if (b2) {
            this.dispatchOnDependentViewChanged(true);
        }
        return b2;
    }
    
    public boolean onNestedPreFling(final View view, final float n, final float n2) {
        boolean b = false;
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
            if (layoutParams.isNestedScrollAccepted()) {
                final Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    b |= behavior.onNestedPreFling(this, child, view, n, n2);
                }
            }
        }
        return b;
    }
    
    public void onNestedPreScroll(final View view, final int n, final int n2, final int[] array) {
        int n3 = 0;
        int n4 = 0;
        boolean b = false;
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
            if (layoutParams.isNestedScrollAccepted()) {
                final Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    mTempIntPair[mTempIntPair[1] = 0] = 0;
                    behavior.onNestedPreScroll(this, child, view, n, n2, mTempIntPair);
                    if (n > 0) {
                        n3 = Math.max(n3, mTempIntPair[0]);
                    }
                    else {
                        n3 = Math.min(n3, mTempIntPair[0]);
                    }
                    if (n2 > 0) {
                        n4 = Math.max(n4, mTempIntPair[1]);
                    }
                    else {
                        n4 = Math.min(n4, mTempIntPair[1]);
                    }
                    b = true;
                }
            }
        }
        array[0] = n3;
        array[1] = n4;
        if (b) {
            this.dispatchOnDependentViewChanged(true);
        }
    }
    
    public void onNestedScroll(final View view, final int n, final int n2, final int n3, final int n4) {
        final int childCount = this.getChildCount();
        boolean b = false;
        for (int i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
            if (layoutParams.isNestedScrollAccepted()) {
                final Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    behavior.onNestedScroll(this, child, view, n, n2, n3, n4);
                    b = true;
                }
            }
        }
        if (b) {
            this.dispatchOnDependentViewChanged(true);
        }
    }
    
    public void onNestedScrollAccepted(final View mNestedScrollingDirectChild, final View mNestedScrollingTarget, final int n) {
        mNestedScrollingParentHelper.onNestedScrollAccepted(mNestedScrollingDirectChild, mNestedScrollingTarget, n);
        this.mNestedScrollingDirectChild = mNestedScrollingDirectChild;
        this.mNestedScrollingTarget = mNestedScrollingTarget;
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
            if (layoutParams.isNestedScrollAccepted()) {
                final Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    behavior.onNestedScrollAccepted(this, child, mNestedScrollingDirectChild, mNestedScrollingTarget, n);
                }
            }
        }
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
        }
        else {
            final SavedState savedState = (SavedState)parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            final SparseArray<Parcelable> behaviorStates = savedState.behaviorStates;
            for (int i = 0; i < this.getChildCount(); ++i) {
                final View child = this.getChildAt(i);
                final int id = child.getId();
                final Behavior behavior = this.getResolvedLayoutParams(child).getBehavior();
                if (id != -1 && behavior != null) {
                    final Parcelable parcelable2 = (Parcelable)behaviorStates.get(id);
                    if (parcelable2 != null) {
                        behavior.onRestoreInstanceState(this, child, parcelable2);
                    }
                }
            }
        }
    }
    
    protected Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState(super.onSaveInstanceState());
        final SparseArray behaviorStates = new SparseArray();
        for (int i = 0; i < this.getChildCount(); ++i) {
            final View child = this.getChildAt(i);
            final int id = child.getId();
            final Behavior behavior = ((LayoutParams)child.getLayoutParams()).getBehavior();
            if (id != -1 && behavior != null) {
                final Parcelable onSaveInstanceState = behavior.onSaveInstanceState(this, child);
                if (onSaveInstanceState != null) {
                    behaviorStates.append(id, (Object)onSaveInstanceState);
                }
            }
        }
        savedState.behaviorStates = (SparseArray<Parcelable>)behaviorStates;
        return (Parcelable)savedState;
    }
    
    public boolean onStartNestedScroll(final View view, final View view2, final int n) {
        boolean b = false;
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
            final Behavior behavior = layoutParams.getBehavior();
            if (behavior != null) {
                final boolean onStartNestedScroll = behavior.onStartNestedScroll(this, child, view, view2, n);
                b |= onStartNestedScroll;
                layoutParams.acceptNestedScroll(onStartNestedScroll);
            }
            else {
                layoutParams.acceptNestedScroll(false);
            }
        }
        return b;
    }
    
    public void onStopNestedScroll(final View view) {
        mNestedScrollingParentHelper.onStopNestedScroll(view);
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
            if (layoutParams.isNestedScrollAccepted()) {
                final Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    behavior.onStopNestedScroll(this, child, view);
                }
                layoutParams.resetNestedScroll();
                layoutParams.resetChangedAfterNestedScroll();
            }
        }
        mNestedScrollingDirectChild = null;
        mNestedScrollingTarget = null;
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        MotionEvent obtain = null;
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        final View mBehaviorTouchView = this.mBehaviorTouchView;
        boolean performIntercept = false;
        boolean onTouchEvent = false;
        Label_0073: {
            if (mBehaviorTouchView == null) {
                performIntercept = this.performIntercept(motionEvent, 1);
                onTouchEvent = false;
                if (!performIntercept) {
                    break Label_0073;
                }
            }
            final Behavior behavior = ((LayoutParams)this.mBehaviorTouchView.getLayoutParams()).getBehavior();
            onTouchEvent = false;
            if (behavior != null) {
                onTouchEvent = behavior.onTouchEvent(this, this.mBehaviorTouchView, motionEvent);
            }
        }
        if (this.mBehaviorTouchView == null) {
            onTouchEvent |= super.onTouchEvent(motionEvent);
        }
        else {
            obtain = null;
            if (performIntercept) {
                obtain = null;
                if (!false) {
                    final long uptimeMillis = SystemClock.uptimeMillis();
                    obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                super.onTouchEvent(obtain);
            }
        }
        if (onTouchEvent || actionMasked == 0) {}
        if (obtain != null) {
            obtain.recycle();
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.resetTouchBehaviors();
        }
        return onTouchEvent;
    }
    
    void recordLastChildRect(final View view, final Rect lastChildRect) {
        ((LayoutParams)view.getLayoutParams()).setLastChildRect(lastChildRect);
    }
    
    void removePreDrawListener() {
        if (mIsAttachedToWindow && mOnPreDrawListener != null) {
            this.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)mOnPreDrawListener);
        }
        mNeedsPreDrawListener = false;
    }
    
    public void requestDisallowInterceptTouchEvent(final boolean b) {
        super.requestDisallowInterceptTouchEvent(b);
        if (b) {
            this.resetTouchBehaviors();
        }
    }
    
    public void setOnHierarchyChangeListener(final ViewGroup$OnHierarchyChangeListener mOnHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = mOnHierarchyChangeListener;
    }
    
    public void setStatusBarBackground(@Nullable final Drawable drawable) {
        if (mStatusBarBackground != drawable) {
            if (mStatusBarBackground != null) {
                mStatusBarBackground.setCallback((Drawable$Callback)null);
            }
            Drawable mutate = null;
            if (drawable != null) {
                mutate = drawable.mutate();
            }
            mStatusBarBackground = mutate;
            if (mStatusBarBackground != null) {
                if (mStatusBarBackground.isStateful()) {
                    mStatusBarBackground.setState(this.getDrawableState());
                }
                DrawableCompat.setLayoutDirection(mStatusBarBackground, ViewCompat.getLayoutDirection((View)this));
                mStatusBarBackground.setVisible(this.getVisibility() == 0, false);
                mStatusBarBackground.setCallback((Drawable$Callback)this);
            }
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }
    
    public void setStatusBarBackgroundColor(@ColorInt final int n) {
        this.setStatusBarBackground((Drawable)new ColorDrawable(n));
    }
    
    public void setStatusBarBackgroundResource(@DrawableRes final int n) {
        Drawable drawable;
        if (n != 0) {
            drawable = ContextCompat.getDrawable(this.getContext(), n);
        }
        else {
            drawable = null;
        }
        this.setStatusBarBackground(drawable);
    }
    
    public void setVisibility(final int visibility) {
        super.setVisibility(visibility);
        final boolean b = visibility == 0;
        if (mStatusBarBackground != null && mStatusBarBackground.isVisible() != b) {
            mStatusBarBackground.setVisible(b, false);
        }
    }
    
    protected boolean verifyDrawable(final Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == mStatusBarBackground;
    }
}
