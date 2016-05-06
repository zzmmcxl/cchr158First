package android.support.v7.widget;

import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.SpinnerAdapter;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.Log;
import android.view.Menu;
import android.content.Context;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.ViewGroup$LayoutParams;
import android.view.MenuItem;
import android.support.v7.view.menu.ActionMenuItem;
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.support.v7.appcompat.R;
import android.view.Window$Callback;
import android.widget.Spinner;
import android.graphics.drawable.Drawable;
import android.view.View;

public class ToolbarWidgetWrapper implements DecorToolbar
{
    private static final int AFFECTS_LOGO_MASK = 3;
    private static final long DEFAULT_FADE_DURATION_MS = 200L;
    private static final String TAG = "ToolbarWidgetWrapper";
    private ActionMenuPresenter mActionMenuPresenter;
    private View mCustomView;
    private int mDefaultNavigationContentDescription;
    private Drawable mDefaultNavigationIcon;
    private int mDisplayOpts;
    private final AppCompatDrawableManager mDrawableManager;
    private CharSequence mHomeDescription;
    private Drawable mIcon;
    private Drawable mLogo;
    private boolean mMenuPrepared;
    private Drawable mNavIcon;
    private int mNavigationMode;
    private Spinner mSpinner;
    private CharSequence mSubtitle;
    private View mTabView;
    private CharSequence mTitle;
    private boolean mTitleSet;
    private Toolbar mToolbar;
    private Window$Callback mWindowCallback;
    
    public ToolbarWidgetWrapper(final Toolbar toolbar, final boolean b) {
        this(toolbar, b, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_mtrl_am_alpha);
    }
    
    public ToolbarWidgetWrapper(final Toolbar mToolbar, final boolean b, final int defaultNavigationContentDescription, final int n) {
        super();
        mNavigationMode = 0;
        mDefaultNavigationContentDescription = 0;
        mToolbar = mToolbar;
        mTitle = mToolbar.getTitle();
        mSubtitle = mToolbar.getSubtitle();
        mTitleSet = (mTitle != null);
        mNavIcon = mToolbar.getNavigationIcon();
        if (b) {
            final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(mToolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
            final CharSequence text = obtainStyledAttributes.getText(R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                this.setTitle(text);
            }
            final CharSequence text2 = obtainStyledAttributes.getText(R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                this.setSubtitle(text2);
            }
            final Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_logo);
            if (drawable != null) {
                this.setLogo(drawable);
            }
            final Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_icon);
            if (mNavIcon == null && drawable2 != null) {
                this.setIcon(drawable2);
            }
            final Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_homeAsUpIndicator);
            if (drawable3 != null) {
                this.setNavigationIcon(drawable3);
            }
            this.setDisplayOptions(obtainStyledAttributes.getInt(R.styleable.ActionBar_displayOptions, 0));
            final int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                this.setCustomView(LayoutInflater.from(mToolbar.getContext()).inflate(resourceId, (ViewGroup)mToolbar, false));
                this.setDisplayOptions(0x10 | mDisplayOpts);
            }
            final int layoutDimension = obtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0);
            if (layoutDimension > 0) {
                final ViewGroup$LayoutParams layoutParams = mToolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                mToolbar.setLayoutParams(layoutParams);
            }
            final int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetStart, -1);
            final int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetEnd, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                mToolbar.setContentInsetsRelative(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            final int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_titleTextStyle, 0);
            if (resourceId2 != 0) {
                mToolbar.setTitleTextAppearance(mToolbar.getContext(), resourceId2);
            }
            final int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0);
            if (resourceId3 != 0) {
                mToolbar.setSubtitleTextAppearance(mToolbar.getContext(), resourceId3);
            }
            final int resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.ActionBar_popupTheme, 0);
            if (resourceId4 != 0) {
                mToolbar.setPopupTheme(resourceId4);
            }
            obtainStyledAttributes.recycle();
        }
        else {
            mDisplayOpts = this.detectDisplayOptions();
        }
        mDrawableManager = AppCompatDrawableManager.get();
        this.setDefaultNavigationContentDescription(defaultNavigationContentDescription);
        mHomeDescription = mToolbar.getNavigationContentDescription();
        this.setDefaultNavigationIcon(mDrawableManager.getDrawable(this.getContext(), n));
        mToolbar.setNavigationOnClickListener((View$OnClickListener)new View$OnClickListener() {
            final ActionMenuItem mNavItem = new ActionMenuItem(mToolbar.getContext(), 0, 16908332, 0, 0, mTitle);
            final /* synthetic */ ToolbarWidgetWrapper this$0;
            
            ToolbarWidgetWrapper$1() {
                this$0 = this$0;
                super();
            }
            
            public void onClick(final View view) {
                if (mWindowCallback != null && mMenuPrepared) {
                    mWindowCallback.onMenuItemSelected(0, (MenuItem)mNavItem);
                }
            }
        });
    }
    
    static /* synthetic */ Toolbar access$000(final ToolbarWidgetWrapper toolbarWidgetWrapper) {
        return toolbarWidgetWrapper.mToolbar;
    }
    
    static /* synthetic */ CharSequence access$100(final ToolbarWidgetWrapper toolbarWidgetWrapper) {
        return toolbarWidgetWrapper.mTitle;
    }
    
    static /* synthetic */ Window$Callback access$200(final ToolbarWidgetWrapper toolbarWidgetWrapper) {
        return toolbarWidgetWrapper.mWindowCallback;
    }
    
    static /* synthetic */ boolean access$300(final ToolbarWidgetWrapper toolbarWidgetWrapper) {
        return toolbarWidgetWrapper.mMenuPrepared;
    }
    
    private int detectDisplayOptions() {
        int n = 11;
        if (mToolbar.getNavigationIcon() != null) {
            n |= 0x4;
        }
        return n;
    }
    
    private void ensureSpinner() {
        if (mSpinner == null) {
            (mSpinner = new AppCompatSpinner(this.getContext(), null, R.attr.actionDropDownStyle)).setLayoutParams((ViewGroup$LayoutParams)new Toolbar.LayoutParams(-2, -2, 8388627));
        }
    }
    
    private void setTitleInt(final CharSequence charSequence) {
        mTitle = charSequence;
        if ((0x8 & mDisplayOpts) != 0x0) {
            mToolbar.setTitle(charSequence);
        }
    }
    
    private void updateHomeAccessibility() {
        if ((0x4 & mDisplayOpts) != 0x0) {
            if (!TextUtils.isEmpty(mHomeDescription)) {
                mToolbar.setNavigationContentDescription(mHomeDescription);
                return;
            }
            mToolbar.setNavigationContentDescription(mDefaultNavigationContentDescription);
        }
    }
    
    private void updateNavigationIcon() {
        if ((0x4 & mDisplayOpts) != 0x0) {
            final Toolbar mToolbar = this.mToolbar;
            Drawable navigationIcon;
            if (mNavIcon != null) {
                navigationIcon = mNavIcon;
            }
            else {
                navigationIcon = mDefaultNavigationIcon;
            }
            mToolbar.setNavigationIcon(navigationIcon);
        }
    }
    
    private void updateToolbarLogo() {
        final int n = 0x2 & mDisplayOpts;
        Drawable logo = null;
        if (n != 0) {
            if ((0x1 & mDisplayOpts) != 0x0) {
                if (mLogo != null) {
                    logo = mLogo;
                }
                else {
                    logo = mIcon;
                }
            }
            else {
                logo = mIcon;
            }
        }
        mToolbar.setLogo(logo);
    }
    
    @Override
    public void animateToVisibility(final int n) {
        final ViewPropertyAnimatorCompat setupAnimatorToVisibility = this.setupAnimatorToVisibility(n, 200L);
        if (setupAnimatorToVisibility != null) {
            setupAnimatorToVisibility.start();
        }
    }
    
    @Override
    public boolean canShowOverflowMenu() {
        return mToolbar.canShowOverflowMenu();
    }
    
    @Override
    public void collapseActionView() {
        mToolbar.collapseActionView();
    }
    
    @Override
    public void dismissPopupMenus() {
        mToolbar.dismissPopupMenus();
    }
    
    @Override
    public Context getContext() {
        return mToolbar.getContext();
    }
    
    @Override
    public View getCustomView() {
        return mCustomView;
    }
    
    @Override
    public int getDisplayOptions() {
        return mDisplayOpts;
    }
    
    @Override
    public int getDropdownItemCount() {
        if (mSpinner != null) {
            return mSpinner.getCount();
        }
        return 0;
    }
    
    @Override
    public int getDropdownSelectedPosition() {
        if (mSpinner != null) {
            return mSpinner.getSelectedItemPosition();
        }
        return 0;
    }
    
    @Override
    public int getHeight() {
        return mToolbar.getHeight();
    }
    
    @Override
    public Menu getMenu() {
        return mToolbar.getMenu();
    }
    
    @Override
    public int getNavigationMode() {
        return mNavigationMode;
    }
    
    @Override
    public CharSequence getSubtitle() {
        return mToolbar.getSubtitle();
    }
    
    @Override
    public CharSequence getTitle() {
        return mToolbar.getTitle();
    }
    
    @Override
    public ViewGroup getViewGroup() {
        return mToolbar;
    }
    
    @Override
    public int getVisibility() {
        return mToolbar.getVisibility();
    }
    
    @Override
    public boolean hasEmbeddedTabs() {
        return mTabView != null;
    }
    
    @Override
    public boolean hasExpandedActionView() {
        return mToolbar.hasExpandedActionView();
    }
    
    @Override
    public boolean hasIcon() {
        return mIcon != null;
    }
    
    @Override
    public boolean hasLogo() {
        return mLogo != null;
    }
    
    @Override
    public boolean hideOverflowMenu() {
        return mToolbar.hideOverflowMenu();
    }
    
    @Override
    public void initIndeterminateProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }
    
    @Override
    public void initProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }
    
    @Override
    public boolean isOverflowMenuShowPending() {
        return mToolbar.isOverflowMenuShowPending();
    }
    
    @Override
    public boolean isOverflowMenuShowing() {
        return mToolbar.isOverflowMenuShowing();
    }
    
    @Override
    public boolean isTitleTruncated() {
        return mToolbar.isTitleTruncated();
    }
    
    @Override
    public void restoreHierarchyState(final SparseArray<Parcelable> sparseArray) {
        mToolbar.restoreHierarchyState((SparseArray)sparseArray);
    }
    
    @Override
    public void saveHierarchyState(final SparseArray<Parcelable> sparseArray) {
        mToolbar.saveHierarchyState((SparseArray)sparseArray);
    }
    
    @Override
    public void setBackgroundDrawable(final Drawable backgroundDrawable) {
        mToolbar.setBackgroundDrawable(backgroundDrawable);
    }
    
    @Override
    public void setCollapsible(final boolean collapsible) {
        mToolbar.setCollapsible(collapsible);
    }
    
    @Override
    public void setCustomView(final View mCustomView) {
        if (this.mCustomView != null && (0x10 & mDisplayOpts) != 0x0) {
            mToolbar.removeView(this.mCustomView);
        }
        if ((this.mCustomView = mCustomView) != null && (0x10 & mDisplayOpts) != 0x0) {
            mToolbar.addView(this.mCustomView);
        }
    }
    
    @Override
    public void setDefaultNavigationContentDescription(final int mDefaultNavigationContentDescription) {
        if (mDefaultNavigationContentDescription != this.mDefaultNavigationContentDescription) {
            this.mDefaultNavigationContentDescription = mDefaultNavigationContentDescription;
            if (TextUtils.isEmpty(mToolbar.getNavigationContentDescription())) {
                this.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
            }
        }
    }
    
    @Override
    public void setDefaultNavigationIcon(final Drawable mDefaultNavigationIcon) {
        if (this.mDefaultNavigationIcon != mDefaultNavigationIcon) {
            this.mDefaultNavigationIcon = mDefaultNavigationIcon;
            this.updateNavigationIcon();
        }
    }
    
    @Override
    public void setDisplayOptions(final int mDisplayOpts) {
        final int n = mDisplayOpts ^ this.mDisplayOpts;
        this.mDisplayOpts = mDisplayOpts;
        if (n != 0) {
            if ((n & 0x4) != 0x0) {
                if ((mDisplayOpts & 0x4) != 0x0) {
                    this.updateNavigationIcon();
                    this.updateHomeAccessibility();
                }
                else {
                    mToolbar.setNavigationIcon(null);
                }
            }
            if ((n & 0x3) != 0x0) {
                this.updateToolbarLogo();
            }
            if ((n & 0x8) != 0x0) {
                if ((mDisplayOpts & 0x8) != 0x0) {
                    mToolbar.setTitle(mTitle);
                    mToolbar.setSubtitle(mSubtitle);
                }
                else {
                    mToolbar.setTitle(null);
                    mToolbar.setSubtitle(null);
                }
            }
            if ((n & 0x10) != 0x0 && mCustomView != null) {
                if ((mDisplayOpts & 0x10) == 0x0) {
                    mToolbar.removeView(mCustomView);
                    return;
                }
                mToolbar.addView(mCustomView);
            }
        }
    }
    
    @Override
    public void setDropdownParams(final SpinnerAdapter adapter, final AdapterView$OnItemSelectedListener onItemSelectedListener) {
        this.ensureSpinner();
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(onItemSelectedListener);
    }
    
    @Override
    public void setDropdownSelectedPosition(final int selection) {
        if (mSpinner == null) {
            throw new IllegalStateException("Can't set dropdown selected position without an adapter");
        }
        mSpinner.setSelection(selection);
    }
    
    @Override
    public void setEmbeddedTabView(final ScrollingTabContainerView mTabView) {
        if (this.mTabView != null && this.mTabView.getParent() == mToolbar) {
            mToolbar.removeView(this.mTabView);
        }
        if ((this.mTabView = (View)mTabView) != null && mNavigationMode == 2) {
            mToolbar.addView(this.mTabView, 0);
            final Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams)this.mTabView.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = 8388691;
            mTabView.setAllowCollapse(true);
        }
    }
    
    @Override
    public void setHomeButtonEnabled(final boolean b) {
    }
    
    @Override
    public void setIcon(final int n) {
        Drawable drawable;
        if (n != 0) {
            drawable = mDrawableManager.getDrawable(this.getContext(), n);
        }
        else {
            drawable = null;
        }
        this.setIcon(drawable);
    }
    
    @Override
    public void setIcon(final Drawable mIcon) {
        this.mIcon = mIcon;
        this.updateToolbarLogo();
    }
    
    @Override
    public void setLogo(final int n) {
        Drawable drawable;
        if (n != 0) {
            drawable = mDrawableManager.getDrawable(this.getContext(), n);
        }
        else {
            drawable = null;
        }
        this.setLogo(drawable);
    }
    
    @Override
    public void setLogo(final Drawable mLogo) {
        this.mLogo = mLogo;
        this.updateToolbarLogo();
    }
    
    @Override
    public void setMenu(final Menu menu, final MenuPresenter.Callback callback) {
        if (mActionMenuPresenter == null) {
            (mActionMenuPresenter = new ActionMenuPresenter(mToolbar.getContext())).setId(R.id.action_menu_presenter);
        }
        mActionMenuPresenter.setCallback(callback);
        mToolbar.setMenu((MenuBuilder)menu, mActionMenuPresenter);
    }
    
    @Override
    public void setMenuCallbacks(final MenuPresenter.Callback callback, final MenuBuilder.Callback callback2) {
        mToolbar.setMenuCallbacks(callback, callback2);
    }
    
    @Override
    public void setMenuPrepared() {
        mMenuPrepared = true;
    }
    
    @Override
    public void setNavigationContentDescription(final int n) {
        CharSequence string;
        if (n == 0) {
            string = null;
        }
        else {
            string = this.getContext().getString(n);
        }
        this.setNavigationContentDescription(string);
    }
    
    @Override
    public void setNavigationContentDescription(final CharSequence mHomeDescription) {
        this.mHomeDescription = mHomeDescription;
        this.updateHomeAccessibility();
    }
    
    @Override
    public void setNavigationIcon(final int n) {
        Drawable drawable;
        if (n != 0) {
            drawable = AppCompatDrawableManager.get().getDrawable(this.getContext(), n);
        }
        else {
            drawable = null;
        }
        this.setNavigationIcon(drawable);
    }
    
    @Override
    public void setNavigationIcon(final Drawable mNavIcon) {
        this.mNavIcon = mNavIcon;
        this.updateNavigationIcon();
    }
    
    @Override
    public void setNavigationMode(final int mNavigationMode) {
        final int mNavigationMode2 = this.mNavigationMode;
        if (mNavigationMode != mNavigationMode2) {
            switch (mNavigationMode2) {
                case 1:
                    if (mSpinner != null && mSpinner.getParent() == mToolbar) {
                        mToolbar.removeView((View)mSpinner);
                        break;
                    }
                    break;
                case 2:
                    if (mTabView != null && mTabView.getParent() == mToolbar) {
                        mToolbar.removeView(mTabView);
                        break;
                    }
                    break;
            }
            switch (this.mNavigationMode = mNavigationMode) {
                default:
                    throw new IllegalArgumentException("Invalid navigation mode " + mNavigationMode);
                case 1:
                    this.ensureSpinner();
                    mToolbar.addView((View)mSpinner, 0);
                case 0:
                    break;
                case 2:
                    if (mTabView != null) {
                        mToolbar.addView(mTabView, 0);
                        final Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams)mTabView.getLayoutParams();
                        layoutParams.width = -2;
                        layoutParams.height = -2;
                        layoutParams.gravity = 8388691;
                        return;
                    }
                    break;
            }
        }
    }
    
    @Override
    public void setSubtitle(final CharSequence charSequence) {
        mSubtitle = charSequence;
        if ((0x8 & mDisplayOpts) != 0x0) {
            mToolbar.setSubtitle(charSequence);
        }
    }
    
    @Override
    public void setTitle(final CharSequence titleInt) {
        mTitleSet = true;
        this.setTitleInt(titleInt);
    }
    
    @Override
    public void setVisibility(final int visibility) {
        mToolbar.setVisibility(visibility);
    }
    
    @Override
    public void setWindowCallback(final Window$Callback mWindowCallback) {
        this.mWindowCallback = mWindowCallback;
    }
    
    @Override
    public void setWindowTitle(final CharSequence titleInt) {
        if (!mTitleSet) {
            this.setTitleInt(titleInt);
        }
    }
    
    @Override
    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int n, final long duration) {
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate((View)mToolbar);
        float n2;
        if (n == 0) {
            n2 = 1.0f;
        }
        else {
            n2 = 0.0f;
        }
        return animate.alpha(n2).setDuration(duration).setListener(new ViewPropertyAnimatorListenerAdapter() {
            private boolean mCanceled = false;
            final /* synthetic */ ToolbarWidgetWrapper this$0;
            final /* synthetic */ int val$visibility;
            
            ToolbarWidgetWrapper$2() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onAnimationCancel(final View view) {
                mCanceled = true;
            }
            
            @Override
            public void onAnimationEnd(final View view) {
                if (!mCanceled) {
                    mToolbar.setVisibility(n);
                }
            }
            
            @Override
            public void onAnimationStart(final View view) {
                mToolbar.setVisibility(0);
            }
        });
    }
    
    @Override
    public boolean showOverflowMenu() {
        return mToolbar.showOverflowMenu();
    }
}
