package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.CollapsibleActionView;
import android.support.annotation.ColorInt;
import android.text.TextUtils$TruncateAt;
import android.view.ContextThemeWrapper;
import android.support.annotation.StyleRes;
import android.support.annotation.StringRes;
import android.support.annotation.DrawableRes;
import android.os.Build$VERSION;
import android.support.v4.view.MenuItemCompat;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.text.Layout;
import android.support.annotation.MenuRes;
import android.view.Menu;
import android.support.v7.app.ActionBar;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.View$MeasureSpec;
import android.support.v7.view.SupportMenuInflater;
import android.view.MenuInflater;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.View$OnClickListener;
import android.view.ViewGroup$LayoutParams;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import java.util.List;
import android.text.TextUtils;
import android.view.MenuItem;
import android.support.v7.appcompat.R;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;
import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.widget.ImageView;
import java.util.ArrayList;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.widget.ImageButton;
import android.support.v7.view.menu.MenuPresenter;
import android.view.ViewGroup;

public class Toolbar extends ViewGroup
{
    private static final String TAG = "Toolbar";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private int mButtonGravity;
    private ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private final RtlSpacingHelper mContentInsets;
    private final AppCompatDrawableManager mDrawableManager;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList<View> mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    private MenuBuilder.Callback mMenuBuilderCallback;
    private ActionMenuView mMenuView;
    private final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    private OnMenuItemClickListener mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private int mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private int mTitleTextColor;
    private TextView mTitleTextView;
    private ToolbarWidgetWrapper mWrapper;
    
    public Toolbar(final Context context) {
        this(context, null);
    }
    
    public Toolbar(final Context context, @Nullable final AttributeSet set) {
        this(context, set, R.attr.toolbarStyle);
    }
    
    public Toolbar(final Context context, @Nullable final AttributeSet set, final int n) {
        super(context, set, n);
        mContentInsets = new RtlSpacingHelper();
        mGravity = 8388627;
        mTempViews = new ArrayList<View>();
        mHiddenViews = new ArrayList<View>();
        mTempMargins = new int[2];
        mMenuViewItemClickListener = new ActionMenuView.OnMenuItemClickListener() {
            final /* synthetic */ Toolbar this$0;
            
            Toolbar$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public boolean onMenuItemClick(final MenuItem menuItem) {
                return this$0.mOnMenuItemClickListener != null && this$0.mOnMenuItemClickListener.onMenuItemClick(menuItem);
            }
        };
        mShowOverflowMenuRunnable = new Runnable() {
            final /* synthetic */ Toolbar this$0;
            
            Toolbar$2() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                this$0.showOverflowMenu();
            }
        };
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.getContext(), set, R.styleable.Toolbar, n, 0);
        mTitleTextAppearance = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        mSubtitleTextAppearance = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
        mGravity = obtainStyledAttributes.getInteger(R.styleable.Toolbar_android_gravity, mGravity);
        mButtonGravity = 48;
        final int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMargins, 0);
        mTitleMarginBottom = dimensionPixelOffset;
        mTitleMarginTop = dimensionPixelOffset;
        mTitleMarginEnd = dimensionPixelOffset;
        mTitleMarginStart = dimensionPixelOffset;
        final int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
        if (dimensionPixelOffset2 >= 0) {
            mTitleMarginStart = dimensionPixelOffset2;
        }
        final int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1);
        if (dimensionPixelOffset3 >= 0) {
            mTitleMarginEnd = dimensionPixelOffset3;
        }
        final int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
        if (dimensionPixelOffset4 >= 0) {
            mTitleMarginTop = dimensionPixelOffset4;
        }
        final int dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
        if (dimensionPixelOffset5 >= 0) {
            mTitleMarginBottom = dimensionPixelOffset5;
        }
        mMaxButtonHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
        final int dimensionPixelOffset6 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        final int dimensionPixelOffset7 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        mContentInsets.setAbsolute(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0), obtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0));
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            mContentInsets.setRelative(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        mCollapseIcon = obtainStyledAttributes.getDrawable(R.styleable.Toolbar_collapseIcon);
        mCollapseDescription = obtainStyledAttributes.getText(R.styleable.Toolbar_collapseContentDescription);
        final CharSequence text = obtainStyledAttributes.getText(R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            this.setTitle(text);
        }
        final CharSequence text2 = obtainStyledAttributes.getText(R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text2)) {
            this.setSubtitle(text2);
        }
        mPopupContext = this.getContext();
        this.setPopupTheme(obtainStyledAttributes.getResourceId(R.styleable.Toolbar_popupTheme, 0));
        final Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.Toolbar_navigationIcon);
        if (drawable != null) {
            this.setNavigationIcon(drawable);
        }
        final CharSequence text3 = obtainStyledAttributes.getText(R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text3)) {
            this.setNavigationContentDescription(text3);
        }
        final Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.Toolbar_logo);
        if (drawable2 != null) {
            this.setLogo(drawable2);
        }
        final CharSequence text4 = obtainStyledAttributes.getText(R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text4)) {
            this.setLogoDescription(text4);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.Toolbar_titleTextColor)) {
            this.setTitleTextColor(obtainStyledAttributes.getColor(R.styleable.Toolbar_titleTextColor, -1));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.Toolbar_subtitleTextColor)) {
            this.setSubtitleTextColor(obtainStyledAttributes.getColor(R.styleable.Toolbar_subtitleTextColor, -1));
        }
        obtainStyledAttributes.recycle();
        mDrawableManager = AppCompatDrawableManager.get();
    }
    
    static /* synthetic */ OnMenuItemClickListener access$000(final Toolbar toolbar) {
        return toolbar.mOnMenuItemClickListener;
    }
    
    static /* synthetic */ void access$200(final Toolbar toolbar) {
        toolbar.ensureCollapseButtonView();
    }
    
    static /* synthetic */ ImageButton access$300(final Toolbar toolbar) {
        return toolbar.mCollapseButtonView;
    }
    
    static /* synthetic */ int access$400(final Toolbar toolbar) {
        return toolbar.mButtonGravity;
    }
    
    private void addCustomViewsWithGravity(final List<View> list, final int n) {
        int n2 = 1;
        if (ViewCompat.getLayoutDirection((View)this) != n2) {
            n2 = 0;
        }
        final int childCount = this.getChildCount();
        final int absoluteGravity = GravityCompat.getAbsoluteGravity(n, ViewCompat.getLayoutDirection((View)this));
        list.clear();
        if (n2 != 0) {
            for (int i = childCount - 1; i >= 0; --i) {
                final View child = this.getChildAt(i);
                final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
                if (layoutParams.mViewType == 0 && this.shouldLayout(child) && this.getChildHorizontalGravity(layoutParams.gravity) == absoluteGravity) {
                    list.add(child);
                }
            }
        }
        else {
            for (int j = 0; j < childCount; ++j) {
                final View child2 = this.getChildAt(j);
                final LayoutParams layoutParams2 = (LayoutParams)child2.getLayoutParams();
                if (layoutParams2.mViewType == 0 && this.shouldLayout(child2) && this.getChildHorizontalGravity(layoutParams2.gravity) == absoluteGravity) {
                    list.add(child2);
                }
            }
        }
    }
    
    private void addSystemView(final View view, final boolean b) {
        final ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        LayoutParams layoutParams2;
        if (layoutParams == null) {
            layoutParams2 = this.generateDefaultLayoutParams();
        }
        else if (!this.checkLayoutParams(layoutParams)) {
            layoutParams2 = this.generateLayoutParams(layoutParams);
        }
        else {
            layoutParams2 = (LayoutParams)layoutParams;
        }
        layoutParams2.mViewType = 1;
        if (b && mExpandedActionView != null) {
            view.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
            mHiddenViews.add(view);
            return;
        }
        this.addView(view, (ViewGroup$LayoutParams)layoutParams2);
    }
    
    private void ensureCollapseButtonView() {
        if (mCollapseButtonView == null) {
            (mCollapseButtonView = new ImageButton(this.getContext(), (AttributeSet)null, R.attr.toolbarNavigationButtonStyle)).setImageDrawable(mCollapseIcon);
            mCollapseButtonView.setContentDescription(mCollapseDescription);
            final LayoutParams generateDefaultLayoutParams = this.generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (0x800003 | (0x70 & mButtonGravity));
            generateDefaultLayoutParams.mViewType = 2;
            mCollapseButtonView.setLayoutParams((ViewGroup$LayoutParams)generateDefaultLayoutParams);
            mCollapseButtonView.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
                final /* synthetic */ Toolbar this$0;
                
                Toolbar$3() {
                    this$0 = this$0;
                    super();
                }
                
                public void onClick(final View view) {
                    this$0.collapseActionView();
                }
            });
        }
    }
    
    private void ensureLogoView() {
        if (mLogoView == null) {
            mLogoView = new ImageView(this.getContext());
        }
    }
    
    private void ensureMenu() {
        this.ensureMenuView();
        if (mMenuView.peekMenu() == null) {
            final MenuBuilder menuBuilder = (MenuBuilder)mMenuView.getMenu();
            if (mExpandedMenuPresenter == null) {
                mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(this);
            }
            mMenuView.setExpandedActionViewsExclusive(true);
            menuBuilder.addMenuPresenter(mExpandedMenuPresenter, mPopupContext);
        }
    }
    
    private void ensureMenuView() {
        if (mMenuView == null) {
            (mMenuView = new ActionMenuView(this.getContext())).setPopupTheme(mPopupTheme);
            mMenuView.setOnMenuItemClickListener(mMenuViewItemClickListener);
            mMenuView.setMenuCallbacks(mActionMenuPresenterCallback, mMenuBuilderCallback);
            final LayoutParams generateDefaultLayoutParams = this.generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (0x800005 | (0x70 & mButtonGravity));
            mMenuView.setLayoutParams((ViewGroup$LayoutParams)generateDefaultLayoutParams);
            this.addSystemView((View)mMenuView, false);
        }
    }
    
    private void ensureNavButtonView() {
        if (mNavButtonView == null) {
            mNavButtonView = new ImageButton(this.getContext(), (AttributeSet)null, R.attr.toolbarNavigationButtonStyle);
            final LayoutParams generateDefaultLayoutParams = this.generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (0x800003 | (0x70 & mButtonGravity));
            mNavButtonView.setLayoutParams((ViewGroup$LayoutParams)generateDefaultLayoutParams);
        }
    }
    
    private int getChildHorizontalGravity(final int n) {
        final int layoutDirection = ViewCompat.getLayoutDirection((View)this);
        int n2 = 0x7 & GravityCompat.getAbsoluteGravity(n, layoutDirection);
        switch (n2) {
            default: {
                int n3;
                if (layoutDirection == 1) {
                    n3 = 5;
                }
                else {
                    n3 = 3;
                }
                n2 = n3;
                return n2;
            }
            case 1:
            case 3:
            case 5:
                return n2;
        }
    }
    
    private int getChildTop(final View view, final int n) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        final int measuredHeight = view.getMeasuredHeight();
        int n2;
        if (n > 0) {
            n2 = (measuredHeight - n) / 2;
        }
        else {
            n2 = 0;
        }
        switch (this.getChildVerticalGravity(layoutParams.gravity)) {
            default: {
                final int paddingTop = this.getPaddingTop();
                final int paddingBottom = this.getPaddingBottom();
                final int height = this.getHeight();
                int n3 = (height - paddingTop - paddingBottom - measuredHeight) / 2;
                if (n3 < layoutParams.topMargin) {
                    n3 = layoutParams.topMargin;
                }
                else {
                    final int n4 = height - paddingBottom - measuredHeight - n3 - paddingTop;
                    if (n4 < layoutParams.bottomMargin) {
                        n3 = Math.max(0, n3 - (layoutParams.bottomMargin - n4));
                    }
                }
                return paddingTop + n3;
            }
            case 48:
                return this.getPaddingTop() - n2;
            case 80:
                return this.getHeight() - this.getPaddingBottom() - measuredHeight - layoutParams.bottomMargin - n2;
        }
    }
    
    private int getChildVerticalGravity(final int n) {
        int n2 = n & 0x70;
        switch (n2) {
            default:
                n2 = (0x70 & mGravity);
                return n2;
            case 16:
            case 48:
            case 80:
                return n2;
        }
    }
    
    private int getHorizontalMargins(final View view) {
        final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)view.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginStart(viewGroup$MarginLayoutParams) + MarginLayoutParamsCompat.getMarginEnd(viewGroup$MarginLayoutParams);
    }
    
    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.getContext());
    }
    
    private int getVerticalMargins(final View view) {
        final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)view.getLayoutParams();
        return viewGroup$MarginLayoutParams.topMargin + viewGroup$MarginLayoutParams.bottomMargin;
    }
    
    private int getViewListMeasuredWidth(final List<View> list, final int[] array) {
        int max = array[0];
        int max2 = array[1];
        int n = 0;
        for (int size = list.size(), i = 0; i < size; ++i) {
            final View view = (View)list.get(i);
            final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            final int n2 = layoutParams.leftMargin - max;
            final int n3 = layoutParams.rightMargin - max2;
            final int max3 = Math.max(0, n2);
            final int max4 = Math.max(0, n3);
            max = Math.max(0, -n2);
            max2 = Math.max(0, -n3);
            n += max4 + (max3 + view.getMeasuredWidth());
        }
        return n;
    }
    
    private boolean isChildOrHidden(final View view) {
        return view.getParent() == this || mHiddenViews.contains(view);
    }
    
    private static boolean isCustomView(final View view) {
        return ((LayoutParams)view.getLayoutParams()).mViewType == 0;
    }
    
    private int layoutChildLeft(final View view, final int n, final int[] array, final int n2) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        final int n3 = layoutParams.leftMargin - array[0];
        final int n4 = n + Math.max(0, n3);
        array[0] = Math.max(0, -n3);
        final int childTop = this.getChildTop(view, n2);
        final int measuredWidth = view.getMeasuredWidth();
        view.layout(n4, childTop, n4 + measuredWidth, childTop + view.getMeasuredHeight());
        return n4 + (measuredWidth + layoutParams.rightMargin);
    }
    
    private int layoutChildRight(final View view, final int n, final int[] array, final int n2) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        final int n3 = layoutParams.rightMargin - array[1];
        final int n4 = n - Math.max(0, n3);
        array[1] = Math.max(0, -n3);
        final int childTop = this.getChildTop(view, n2);
        final int measuredWidth = view.getMeasuredWidth();
        view.layout(n4 - measuredWidth, childTop, n4, childTop + view.getMeasuredHeight());
        return n4 - (measuredWidth + layoutParams.leftMargin);
    }
    
    private int measureChildCollapseMargins(final View view, final int n, final int n2, final int n3, final int n4, final int[] array) {
        final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)view.getLayoutParams();
        final int n5 = viewGroup$MarginLayoutParams.leftMargin - array[0];
        final int n6 = viewGroup$MarginLayoutParams.rightMargin - array[1];
        final int n7 = Math.max(0, n5) + Math.max(0, n6);
        array[0] = Math.max(0, -n5);
        array[1] = Math.max(0, -n6);
        view.measure(getChildMeasureSpec(n, n2 + (n7 + (this.getPaddingLeft() + this.getPaddingRight())), viewGroup$MarginLayoutParams.width), getChildMeasureSpec(n3, n4 + (this.getPaddingTop() + this.getPaddingBottom() + viewGroup$MarginLayoutParams.topMargin + viewGroup$MarginLayoutParams.bottomMargin), viewGroup$MarginLayoutParams.height));
        return n7 + view.getMeasuredWidth();
    }
    
    private void measureChildConstrained(final View view, final int n, final int n2, final int n3, final int n4, final int n5) {
        final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)view.getLayoutParams();
        final int childMeasureSpec = getChildMeasureSpec(n, n2 + (this.getPaddingLeft() + this.getPaddingRight() + viewGroup$MarginLayoutParams.leftMargin + viewGroup$MarginLayoutParams.rightMargin), viewGroup$MarginLayoutParams.width);
        int n6 = getChildMeasureSpec(n3, n4 + (this.getPaddingTop() + this.getPaddingBottom() + viewGroup$MarginLayoutParams.topMargin + viewGroup$MarginLayoutParams.bottomMargin), viewGroup$MarginLayoutParams.height);
        final int mode = View$MeasureSpec.getMode(n6);
        if (mode != 1073741824 && n5 >= 0) {
            int min;
            if (mode != 0) {
                min = Math.min(View$MeasureSpec.getSize(n6), n5);
            }
            else {
                min = n5;
            }
            n6 = View$MeasureSpec.makeMeasureSpec(min, 1073741824);
        }
        view.measure(childMeasureSpec, n6);
    }
    
    private void postShowOverflowMenu() {
        this.removeCallbacks(mShowOverflowMenuRunnable);
        this.post(mShowOverflowMenuRunnable);
    }
    
    private boolean shouldCollapse() {
        if (mCollapsible) {
            for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                final View child = this.getChildAt(i);
                if (this.shouldLayout(child) && child.getMeasuredWidth() > 0 && child.getMeasuredHeight() > 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    private boolean shouldLayout(final View view) {
        return view != null && view.getParent() == this && view.getVisibility() != 8;
    }
    
    void addChildrenForExpandedActionView() {
        for (int i = -1 + mHiddenViews.size(); i >= 0; --i) {
            this.addView((View)mHiddenViews.get(i));
        }
        mHiddenViews.clear();
    }
    
    public boolean canShowOverflowMenu() {
        return this.getVisibility() == 0 && mMenuView != null && mMenuView.isOverflowReserved();
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return super.checkLayoutParams(viewGroup$LayoutParams) && viewGroup$LayoutParams instanceof LayoutParams;
    }
    
    public void collapseActionView() {
        MenuItemImpl mCurrentExpandedItem;
        if (mExpandedMenuPresenter == null) {
            mCurrentExpandedItem = null;
        }
        else {
            mCurrentExpandedItem = mExpandedMenuPresenter.mCurrentExpandedItem;
        }
        if (mCurrentExpandedItem != null) {
            mCurrentExpandedItem.collapseActionView();
        }
    }
    
    public void dismissPopupMenus() {
        if (mMenuView != null) {
            mMenuView.dismissPopupMenus();
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
        if (viewGroup$LayoutParams instanceof ActionBar.LayoutParams) {
            return new LayoutParams((ActionBar.LayoutParams)viewGroup$LayoutParams);
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
    
    public int getContentInsetEnd() {
        return mContentInsets.getEnd();
    }
    
    public int getContentInsetLeft() {
        return mContentInsets.getLeft();
    }
    
    public int getContentInsetRight() {
        return mContentInsets.getRight();
    }
    
    public int getContentInsetStart() {
        return mContentInsets.getStart();
    }
    
    public Drawable getLogo() {
        if (mLogoView != null) {
            return mLogoView.getDrawable();
        }
        return null;
    }
    
    public CharSequence getLogoDescription() {
        if (mLogoView != null) {
            return mLogoView.getContentDescription();
        }
        return null;
    }
    
    public Menu getMenu() {
        this.ensureMenu();
        return mMenuView.getMenu();
    }
    
    @Nullable
    public CharSequence getNavigationContentDescription() {
        if (mNavButtonView != null) {
            return mNavButtonView.getContentDescription();
        }
        return null;
    }
    
    @Nullable
    public Drawable getNavigationIcon() {
        if (mNavButtonView != null) {
            return mNavButtonView.getDrawable();
        }
        return null;
    }
    
    @Nullable
    public Drawable getOverflowIcon() {
        this.ensureMenu();
        return mMenuView.getOverflowIcon();
    }
    
    public int getPopupTheme() {
        return mPopupTheme;
    }
    
    public CharSequence getSubtitle() {
        return mSubtitleText;
    }
    
    public CharSequence getTitle() {
        return mTitleText;
    }
    
    public DecorToolbar getWrapper() {
        if (mWrapper == null) {
            mWrapper = new ToolbarWidgetWrapper(this, true);
        }
        return mWrapper;
    }
    
    public boolean hasExpandedActionView() {
        return mExpandedMenuPresenter != null && mExpandedMenuPresenter.mCurrentExpandedItem != null;
    }
    
    public boolean hideOverflowMenu() {
        return mMenuView != null && mMenuView.hideOverflowMenu();
    }
    
    public void inflateMenu(@MenuRes final int n) {
        this.getMenuInflater().inflate(n, this.getMenu());
    }
    
    public boolean isOverflowMenuShowPending() {
        return mMenuView != null && mMenuView.isOverflowMenuShowPending();
    }
    
    public boolean isOverflowMenuShowing() {
        return mMenuView != null && mMenuView.isOverflowMenuShowing();
    }
    
    public boolean isTitleTruncated() {
        if (mTitleTextView != null) {
            final Layout layout = mTitleTextView.getLayout();
            if (layout != null) {
                for (int lineCount = layout.getLineCount(), i = 0; i < lineCount; ++i) {
                    if (layout.getEllipsisCount(i) > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeCallbacks(mShowOverflowMenuRunnable);
    }
    
    public boolean onHoverEvent(final MotionEvent motionEvent) {
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 9) {
            mEatingHover = false;
        }
        if (!mEatingHover) {
            final boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                mEatingHover = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            mEatingHover = false;
        }
        return true;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        boolean b2;
        if (ViewCompat.getLayoutDirection((View)this) == 1) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        final int width = this.getWidth();
        final int height = this.getHeight();
        final int paddingLeft = this.getPaddingLeft();
        final int paddingRight = this.getPaddingRight();
        final int paddingTop = this.getPaddingTop();
        final int paddingBottom = this.getPaddingBottom();
        int n5 = paddingLeft;
        int n6 = width - paddingRight;
        final int[] mTempMargins = this.mTempMargins;
        mTempMargins[mTempMargins[1] = 0] = 0;
        final int minimumHeight = ViewCompat.getMinimumHeight((View)this);
        if (this.shouldLayout((View)mNavButtonView)) {
            if (b2) {
                n6 = this.layoutChildRight((View)mNavButtonView, n6, mTempMargins, minimumHeight);
            }
            else {
                n5 = this.layoutChildLeft((View)mNavButtonView, n5, mTempMargins, minimumHeight);
            }
        }
        if (this.shouldLayout((View)mCollapseButtonView)) {
            if (b2) {
                n6 = this.layoutChildRight((View)mCollapseButtonView, n6, mTempMargins, minimumHeight);
            }
            else {
                n5 = this.layoutChildLeft((View)mCollapseButtonView, n5, mTempMargins, minimumHeight);
            }
        }
        if (this.shouldLayout((View)mMenuView)) {
            if (b2) {
                n5 = this.layoutChildLeft((View)mMenuView, n5, mTempMargins, minimumHeight);
            }
            else {
                n6 = this.layoutChildRight((View)mMenuView, n6, mTempMargins, minimumHeight);
            }
        }
        mTempMargins[0] = Math.max(0, this.getContentInsetLeft() - n5);
        mTempMargins[1] = Math.max(0, this.getContentInsetRight() - (width - paddingRight - n6));
        int n7 = Math.max(n5, this.getContentInsetLeft());
        int n8 = Math.min(n6, width - paddingRight - this.getContentInsetRight());
        if (this.shouldLayout(mExpandedActionView)) {
            if (b2) {
                n8 = this.layoutChildRight(mExpandedActionView, n8, mTempMargins, minimumHeight);
            }
            else {
                n7 = this.layoutChildLeft(mExpandedActionView, n7, mTempMargins, minimumHeight);
            }
        }
        if (this.shouldLayout((View)mLogoView)) {
            if (b2) {
                n8 = this.layoutChildRight((View)mLogoView, n8, mTempMargins, minimumHeight);
            }
            else {
                n7 = this.layoutChildLeft((View)mLogoView, n7, mTempMargins, minimumHeight);
            }
        }
        final boolean shouldLayout = this.shouldLayout((View)mTitleTextView);
        final boolean shouldLayout2 = this.shouldLayout((View)mSubtitleTextView);
        int n9 = 0;
        if (shouldLayout) {
            final LayoutParams layoutParams = (LayoutParams)mTitleTextView.getLayoutParams();
            n9 = 0 + (layoutParams.topMargin + mTitleTextView.getMeasuredHeight() + layoutParams.bottomMargin);
        }
        if (shouldLayout2) {
            final LayoutParams layoutParams2 = (LayoutParams)mSubtitleTextView.getLayoutParams();
            n9 += layoutParams2.topMargin + mSubtitleTextView.getMeasuredHeight() + layoutParams2.bottomMargin;
        }
        if (shouldLayout || shouldLayout2) {
            TextView textView;
            if (shouldLayout) {
                textView = mTitleTextView;
            }
            else {
                textView = mSubtitleTextView;
            }
            TextView textView2;
            if (shouldLayout2) {
                textView2 = mSubtitleTextView;
            }
            else {
                textView2 = mTitleTextView;
            }
            final LayoutParams layoutParams3 = (LayoutParams)((View)textView).getLayoutParams();
            final LayoutParams layoutParams4 = (LayoutParams)((View)textView2).getLayoutParams();
            boolean b3;
            if ((shouldLayout && mTitleTextView.getMeasuredWidth() > 0) || (shouldLayout2 && mSubtitleTextView.getMeasuredWidth() > 0)) {
                b3 = true;
            }
            else {
                b3 = false;
            }
            int n11 = 0;
            switch (0x70 & mGravity) {
                default: {
                    int max = (height - paddingTop - paddingBottom - n9) / 2;
                    if (max < layoutParams3.topMargin + mTitleMarginTop) {
                        max = layoutParams3.topMargin + mTitleMarginTop;
                    }
                    else {
                        final int n10 = height - paddingBottom - n9 - max - paddingTop;
                        if (n10 < layoutParams3.bottomMargin + mTitleMarginBottom) {
                            max = Math.max(0, max - (layoutParams4.bottomMargin + mTitleMarginBottom - n10));
                        }
                    }
                    n11 = paddingTop + max;
                    break;
                }
                case 48:
                    n11 = this.getPaddingTop() + layoutParams3.topMargin + mTitleMarginTop;
                    break;
                case 80:
                    n11 = height - paddingBottom - layoutParams4.bottomMargin - mTitleMarginBottom - n9;
                    break;
            }
            if (b2) {
                int mTitleMarginStart;
                if (b3) {
                    mTitleMarginStart = this.mTitleMarginStart;
                }
                else {
                    mTitleMarginStart = 0;
                }
                final int n12 = mTitleMarginStart - mTempMargins[1];
                n8 -= Math.max(0, n12);
                mTempMargins[1] = Math.max(0, -n12);
                int n13 = n8;
                int n14 = n8;
                if (shouldLayout) {
                    final LayoutParams layoutParams5 = (LayoutParams)mTitleTextView.getLayoutParams();
                    final int n15 = n13 - mTitleTextView.getMeasuredWidth();
                    final int n16 = n11 + mTitleTextView.getMeasuredHeight();
                    mTitleTextView.layout(n15, n11, n13, n16);
                    n13 = n15 - mTitleMarginEnd;
                    n11 = n16 + layoutParams5.bottomMargin;
                }
                if (shouldLayout2) {
                    final LayoutParams layoutParams6 = (LayoutParams)mSubtitleTextView.getLayoutParams();
                    final int n17 = n11 + layoutParams6.topMargin;
                    final int n18 = n14 - mSubtitleTextView.getMeasuredWidth();
                    final int n19 = n17 + mSubtitleTextView.getMeasuredHeight();
                    mSubtitleTextView.layout(n18, n17, n14, n19);
                    n14 -= mTitleMarginEnd;
                    final int n20 = n19 + layoutParams6.bottomMargin;
                }
                if (b3) {
                    n8 = Math.min(n13, n14);
                }
            }
            else {
                int mTitleMarginStart2;
                if (b3) {
                    mTitleMarginStart2 = mTitleMarginStart;
                }
                else {
                    mTitleMarginStart2 = 0;
                }
                final int n21 = mTitleMarginStart2 - mTempMargins[0];
                n7 += Math.max(0, n21);
                mTempMargins[0] = Math.max(0, -n21);
                int n22 = n7;
                int n23 = n7;
                if (shouldLayout) {
                    final LayoutParams layoutParams7 = (LayoutParams)mTitleTextView.getLayoutParams();
                    final int n24 = n22 + mTitleTextView.getMeasuredWidth();
                    final int n25 = n11 + mTitleTextView.getMeasuredHeight();
                    mTitleTextView.layout(n22, n11, n24, n25);
                    n22 = n24 + mTitleMarginEnd;
                    n11 = n25 + layoutParams7.bottomMargin;
                }
                if (shouldLayout2) {
                    final LayoutParams layoutParams8 = (LayoutParams)mSubtitleTextView.getLayoutParams();
                    final int n26 = n11 + layoutParams8.topMargin;
                    final int n27 = n23 + mSubtitleTextView.getMeasuredWidth();
                    final int n28 = n26 + mSubtitleTextView.getMeasuredHeight();
                    mSubtitleTextView.layout(n23, n26, n27, n28);
                    n23 = n27 + mTitleMarginEnd;
                    final int n29 = n28 + layoutParams8.bottomMargin;
                }
                if (b3) {
                    n7 = Math.max(n22, n23);
                }
            }
        }
        this.addCustomViewsWithGravity(mTempViews, 3);
        for (int size = mTempViews.size(), i = 0; i < size; ++i) {
            n7 = this.layoutChildLeft(mTempViews.get(i), n7, mTempMargins, minimumHeight);
        }
        this.addCustomViewsWithGravity(mTempViews, 5);
        for (int size2 = mTempViews.size(), j = 0; j < size2; ++j) {
            n8 = this.layoutChildRight(mTempViews.get(j), n8, mTempMargins, minimumHeight);
        }
        this.addCustomViewsWithGravity(mTempViews, 1);
        final int viewListMeasuredWidth = this.getViewListMeasuredWidth(mTempViews, mTempMargins);
        int layoutChildLeft = paddingLeft + (width - paddingLeft - paddingRight) / 2 - viewListMeasuredWidth / 2;
        final int n30 = layoutChildLeft + viewListMeasuredWidth;
        if (layoutChildLeft < n7) {
            layoutChildLeft = n7;
        }
        else if (n30 > n8) {
            layoutChildLeft -= n30 - n8;
        }
        for (int size3 = mTempViews.size(), k = 0; k < size3; ++k) {
            layoutChildLeft = this.layoutChildLeft(mTempViews.get(k), layoutChildLeft, mTempMargins, minimumHeight);
        }
        mTempViews.clear();
    }
    
    protected void onMeasure(final int n, final int n2) {
        final int[] mTempMargins = this.mTempMargins;
        int n3;
        int n4;
        if (ViewUtils.isLayoutRtl((View)this)) {
            n3 = 1;
            n4 = 0;
        }
        else {
            n4 = 1;
            n3 = 0;
        }
        final boolean shouldLayout = this.shouldLayout((View)mNavButtonView);
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        if (shouldLayout) {
            this.measureChildConstrained((View)mNavButtonView, n, 0, n2, 0, mMaxButtonHeight);
            n7 = mNavButtonView.getMeasuredWidth() + this.getHorizontalMargins((View)mNavButtonView);
            n6 = Math.max(0, mNavButtonView.getMeasuredHeight() + this.getVerticalMargins((View)mNavButtonView));
            n5 = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState((View)mNavButtonView));
        }
        if (this.shouldLayout((View)mCollapseButtonView)) {
            this.measureChildConstrained((View)mCollapseButtonView, n, 0, n2, 0, mMaxButtonHeight);
            n7 = mCollapseButtonView.getMeasuredWidth() + this.getHorizontalMargins((View)mCollapseButtonView);
            n6 = Math.max(n6, mCollapseButtonView.getMeasuredHeight() + this.getVerticalMargins((View)mCollapseButtonView));
            n5 = ViewUtils.combineMeasuredStates(n5, ViewCompat.getMeasuredState((View)mCollapseButtonView));
        }
        final int contentInsetStart = this.getContentInsetStart();
        final int n8 = 0 + Math.max(contentInsetStart, n7);
        mTempMargins[n3] = Math.max(0, contentInsetStart - n7);
        final boolean shouldLayout2 = this.shouldLayout((View)mMenuView);
        int n9 = 0;
        if (shouldLayout2) {
            this.measureChildConstrained((View)mMenuView, n, n8, n2, 0, mMaxButtonHeight);
            n9 = mMenuView.getMeasuredWidth() + this.getHorizontalMargins((View)mMenuView);
            n6 = Math.max(n6, mMenuView.getMeasuredHeight() + this.getVerticalMargins((View)mMenuView));
            n5 = ViewUtils.combineMeasuredStates(n5, ViewCompat.getMeasuredState((View)mMenuView));
        }
        final int contentInsetEnd = this.getContentInsetEnd();
        int n10 = n8 + Math.max(contentInsetEnd, n9);
        mTempMargins[n4] = Math.max(0, contentInsetEnd - n9);
        if (this.shouldLayout(mExpandedActionView)) {
            n10 += this.measureChildCollapseMargins(mExpandedActionView, n, n10, n2, 0, mTempMargins);
            n6 = Math.max(n6, mExpandedActionView.getMeasuredHeight() + this.getVerticalMargins(mExpandedActionView));
            n5 = ViewUtils.combineMeasuredStates(n5, ViewCompat.getMeasuredState(mExpandedActionView));
        }
        if (this.shouldLayout((View)mLogoView)) {
            n10 += this.measureChildCollapseMargins((View)mLogoView, n, n10, n2, 0, mTempMargins);
            n6 = Math.max(n6, mLogoView.getMeasuredHeight() + this.getVerticalMargins((View)mLogoView));
            n5 = ViewUtils.combineMeasuredStates(n5, ViewCompat.getMeasuredState((View)mLogoView));
        }
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (((LayoutParams)child.getLayoutParams()).mViewType == 0 && this.shouldLayout(child)) {
                n10 += this.measureChildCollapseMargins(child, n, n10, n2, 0, mTempMargins);
                n6 = Math.max(n6, child.getMeasuredHeight() + this.getVerticalMargins(child));
                n5 = ViewUtils.combineMeasuredStates(n5, ViewCompat.getMeasuredState(child));
            }
        }
        final int n11 = mTitleMarginTop + mTitleMarginBottom;
        final int n12 = mTitleMarginStart + mTitleMarginEnd;
        final boolean shouldLayout3 = this.shouldLayout((View)mTitleTextView);
        int n13 = 0;
        int max = 0;
        if (shouldLayout3) {
            this.measureChildCollapseMargins((View)mTitleTextView, n, n10 + n12, n2, n11, mTempMargins);
            max = mTitleTextView.getMeasuredWidth() + this.getHorizontalMargins((View)mTitleTextView);
            n13 = mTitleTextView.getMeasuredHeight() + this.getVerticalMargins((View)mTitleTextView);
            n5 = ViewUtils.combineMeasuredStates(n5, ViewCompat.getMeasuredState((View)mTitleTextView));
        }
        if (this.shouldLayout((View)mSubtitleTextView)) {
            max = Math.max(max, this.measureChildCollapseMargins((View)mSubtitleTextView, n, n10 + n12, n2, n13 + n11, mTempMargins));
            n13 += mSubtitleTextView.getMeasuredHeight() + this.getVerticalMargins((View)mSubtitleTextView);
            n5 = ViewUtils.combineMeasuredStates(n5, ViewCompat.getMeasuredState((View)mSubtitleTextView));
        }
        final int n14 = n10 + max;
        final int max2 = Math.max(n6, n13);
        final int n15 = n14 + (this.getPaddingLeft() + this.getPaddingRight());
        final int n16 = max2 + (this.getPaddingTop() + this.getPaddingBottom());
        final int resolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(n15, this.getSuggestedMinimumWidth()), n, 0xFF000000 & n5);
        int resolveSizeAndState2 = ViewCompat.resolveSizeAndState(Math.max(n16, this.getSuggestedMinimumHeight()), n2, n5 << 16);
        if (this.shouldCollapse()) {
            resolveSizeAndState2 = 0;
        }
        this.setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        final SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        Object peekMenu;
        if (mMenuView != null) {
            peekMenu = mMenuView.peekMenu();
        }
        else {
            peekMenu = null;
        }
        if (savedState.expandedMenuItemId != 0 && mExpandedMenuPresenter != null && peekMenu != null) {
            final MenuItem item = ((Menu)peekMenu).findItem(savedState.expandedMenuItemId);
            if (item != null) {
                MenuItemCompat.expandActionView(item);
            }
        }
        if (savedState.isOverflowOpen) {
            this.postShowOverflowMenu();
        }
    }
    
    public void onRtlPropertiesChanged(final int n) {
        boolean direction = true;
        if (Build$VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(n);
        }
        final RtlSpacingHelper mContentInsets = this.mContentInsets;
        if (n != (direction ? 1 : 0)) {
            direction = false;
        }
        mContentInsets.setDirection(direction);
    }
    
    protected Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (mExpandedMenuPresenter != null && mExpandedMenuPresenter.mCurrentExpandedItem != null) {
            savedState.expandedMenuItemId = mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        }
        savedState.isOverflowOpen = this.isOverflowMenuShowing();
        return (Parcelable)savedState;
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            mEatingTouch = false;
        }
        if (!mEatingTouch) {
            final boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                mEatingTouch = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            mEatingTouch = false;
        }
        return true;
    }
    
    void removeChildrenForExpandedActionView() {
        for (int i = -1 + this.getChildCount(); i >= 0; --i) {
            final View child = this.getChildAt(i);
            if (((LayoutParams)child.getLayoutParams()).mViewType != 2 && child != mMenuView) {
                this.removeViewAt(i);
                mHiddenViews.add(child);
            }
        }
    }
    
    public void setCollapsible(final boolean mCollapsible) {
        this.mCollapsible = mCollapsible;
        this.requestLayout();
    }
    
    public void setContentInsetsAbsolute(final int n, final int n2) {
        mContentInsets.setAbsolute(n, n2);
    }
    
    public void setContentInsetsRelative(final int n, final int n2) {
        mContentInsets.setRelative(n, n2);
    }
    
    public void setLogo(@DrawableRes final int n) {
        this.setLogo(mDrawableManager.getDrawable(this.getContext(), n));
    }
    
    public void setLogo(final Drawable imageDrawable) {
        if (imageDrawable != null) {
            this.ensureLogoView();
            if (!this.isChildOrHidden((View)mLogoView)) {
                this.addSystemView((View)mLogoView, true);
            }
        }
        else if (mLogoView != null && this.isChildOrHidden((View)mLogoView)) {
            this.removeView((View)mLogoView);
            mHiddenViews.remove(mLogoView);
        }
        if (mLogoView != null) {
            mLogoView.setImageDrawable(imageDrawable);
        }
    }
    
    public void setLogoDescription(@StringRes final int n) {
        this.setLogoDescription(this.getContext().getText(n));
    }
    
    public void setLogoDescription(final CharSequence contentDescription) {
        if (!TextUtils.isEmpty(contentDescription)) {
            this.ensureLogoView();
        }
        if (mLogoView != null) {
            mLogoView.setContentDescription(contentDescription);
        }
    }
    
    public void setMenu(final MenuBuilder menuBuilder, final ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder != null || mMenuView != null) {
            this.ensureMenuView();
            final MenuBuilder peekMenu = mMenuView.peekMenu();
            if (peekMenu != menuBuilder) {
                if (peekMenu != null) {
                    peekMenu.removeMenuPresenter(mOuterActionMenuPresenter);
                    peekMenu.removeMenuPresenter(mExpandedMenuPresenter);
                }
                if (mExpandedMenuPresenter == null) {
                    mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(this);
                }
                actionMenuPresenter.setExpandedActionViewsExclusive(true);
                if (menuBuilder != null) {
                    menuBuilder.addMenuPresenter(actionMenuPresenter, mPopupContext);
                    menuBuilder.addMenuPresenter(mExpandedMenuPresenter, mPopupContext);
                }
                else {
                    actionMenuPresenter.initForMenu(mPopupContext, null);
                    mExpandedMenuPresenter.initForMenu(mPopupContext, null);
                    actionMenuPresenter.updateMenuView(true);
                    mExpandedMenuPresenter.updateMenuView(true);
                }
                mMenuView.setPopupTheme(mPopupTheme);
                mMenuView.setPresenter(actionMenuPresenter);
                mOuterActionMenuPresenter = actionMenuPresenter;
            }
        }
    }
    
    public void setMenuCallbacks(final MenuPresenter.Callback mActionMenuPresenterCallback, final MenuBuilder.Callback mMenuBuilderCallback) {
        this.mActionMenuPresenterCallback = mActionMenuPresenterCallback;
        this.mMenuBuilderCallback = mMenuBuilderCallback;
        if (mMenuView != null) {
            mMenuView.setMenuCallbacks(mActionMenuPresenterCallback, mMenuBuilderCallback);
        }
    }
    
    public void setNavigationContentDescription(@StringRes final int n) {
        CharSequence text;
        if (n != 0) {
            text = this.getContext().getText(n);
        }
        else {
            text = null;
        }
        this.setNavigationContentDescription(text);
    }
    
    public void setNavigationContentDescription(@Nullable final CharSequence contentDescription) {
        if (!TextUtils.isEmpty(contentDescription)) {
            this.ensureNavButtonView();
        }
        if (mNavButtonView != null) {
            mNavButtonView.setContentDescription(contentDescription);
        }
    }
    
    public void setNavigationIcon(@DrawableRes final int n) {
        this.setNavigationIcon(mDrawableManager.getDrawable(this.getContext(), n));
    }
    
    public void setNavigationIcon(@Nullable final Drawable imageDrawable) {
        if (imageDrawable != null) {
            this.ensureNavButtonView();
            if (!this.isChildOrHidden((View)mNavButtonView)) {
                this.addSystemView((View)mNavButtonView, true);
            }
        }
        else if (mNavButtonView != null && this.isChildOrHidden((View)mNavButtonView)) {
            this.removeView((View)mNavButtonView);
            mHiddenViews.remove(mNavButtonView);
        }
        if (mNavButtonView != null) {
            mNavButtonView.setImageDrawable(imageDrawable);
        }
    }
    
    public void setNavigationOnClickListener(final View$OnClickListener onClickListener) {
        this.ensureNavButtonView();
        mNavButtonView.setOnClickListener(onClickListener);
    }
    
    public void setOnMenuItemClickListener(final OnMenuItemClickListener mOnMenuItemClickListener) {
        this.mOnMenuItemClickListener = mOnMenuItemClickListener;
    }
    
    public void setOverflowIcon(@Nullable final Drawable overflowIcon) {
        this.ensureMenu();
        mMenuView.setOverflowIcon(overflowIcon);
    }
    
    public void setPopupTheme(@StyleRes final int mPopupTheme) {
        if (this.mPopupTheme != mPopupTheme) {
            if ((this.mPopupTheme = mPopupTheme) != 0) {
                mPopupContext = (Context)new ContextThemeWrapper(this.getContext(), mPopupTheme);
                return;
            }
            mPopupContext = this.getContext();
        }
    }
    
    public void setSubtitle(@StringRes final int n) {
        this.setSubtitle(this.getContext().getText(n));
    }
    
    public void setSubtitle(final CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (mSubtitleTextView == null) {
                final Context context = this.getContext();
                (mSubtitleTextView = new TextView(context)).setSingleLine();
                mSubtitleTextView.setEllipsize(TextUtils$TruncateAt.END);
                if (mSubtitleTextAppearance != 0) {
                    mSubtitleTextView.setTextAppearance(context, mSubtitleTextAppearance);
                }
                if (mSubtitleTextColor != 0) {
                    mSubtitleTextView.setTextColor(mSubtitleTextColor);
                }
            }
            if (!this.isChildOrHidden((View)mSubtitleTextView)) {
                this.addSystemView((View)mSubtitleTextView, true);
            }
        }
        else if (mSubtitleTextView != null && this.isChildOrHidden((View)mSubtitleTextView)) {
            this.removeView((View)mSubtitleTextView);
            mHiddenViews.remove(mSubtitleTextView);
        }
        if (mSubtitleTextView != null) {
            mSubtitleTextView.setText(charSequence);
        }
        mSubtitleText = charSequence;
    }
    
    public void setSubtitleTextAppearance(final Context context, @StyleRes final int mSubtitleTextAppearance) {
        this.mSubtitleTextAppearance = mSubtitleTextAppearance;
        if (mSubtitleTextView != null) {
            mSubtitleTextView.setTextAppearance(context, mSubtitleTextAppearance);
        }
    }
    
    public void setSubtitleTextColor(@ColorInt final int n) {
        mSubtitleTextColor = n;
        if (mSubtitleTextView != null) {
            mSubtitleTextView.setTextColor(n);
        }
    }
    
    public void setTitle(@StringRes final int n) {
        this.setTitle(this.getContext().getText(n));
    }
    
    public void setTitle(final CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (mTitleTextView == null) {
                final Context context = this.getContext();
                (mTitleTextView = new TextView(context)).setSingleLine();
                mTitleTextView.setEllipsize(TextUtils$TruncateAt.END);
                if (mTitleTextAppearance != 0) {
                    mTitleTextView.setTextAppearance(context, mTitleTextAppearance);
                }
                if (mTitleTextColor != 0) {
                    mTitleTextView.setTextColor(mTitleTextColor);
                }
            }
            if (!this.isChildOrHidden((View)mTitleTextView)) {
                this.addSystemView((View)mTitleTextView, true);
            }
        }
        else if (mTitleTextView != null && this.isChildOrHidden((View)mTitleTextView)) {
            this.removeView((View)mTitleTextView);
            mHiddenViews.remove(mTitleTextView);
        }
        if (mTitleTextView != null) {
            mTitleTextView.setText(charSequence);
        }
        mTitleText = charSequence;
    }
    
    public void setTitleTextAppearance(final Context context, @StyleRes final int mTitleTextAppearance) {
        this.mTitleTextAppearance = mTitleTextAppearance;
        if (mTitleTextView != null) {
            mTitleTextView.setTextAppearance(context, mTitleTextAppearance);
        }
    }
    
    public void setTitleTextColor(@ColorInt final int n) {
        mTitleTextColor = n;
        if (mTitleTextView != null) {
            mTitleTextView.setTextColor(n);
        }
    }
    
    public boolean showOverflowMenu() {
        return mMenuView != null && mMenuView.showOverflowMenu();
    }
}
