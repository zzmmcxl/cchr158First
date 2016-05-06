package android.support.v7.app;

import android.view.View$MeasureSpec;
import android.support.v7.widget.ViewUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.MotionEvent;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.ActionMenuPresenter;
import android.view.View$OnClickListener;
import android.view.ViewGroup$MarginLayoutParams;
import android.text.TextUtils;
import android.support.v7.widget.TintTypedArray;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v7.widget.AbsActionBarView;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.view.menu.MenuPopupHelper;
import android.view.MenuItem;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.view.SupportMenuInflater;
import android.view.MenuInflater;
import android.view.Menu;
import java.lang.ref.WeakReference;
import android.support.v7.view.menu.MenuBuilder;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.SpinnerAdapter;
import android.view.ViewGroup$LayoutParams;
import android.view.LayoutInflater;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.content.res.Configuration;
import android.view.ContextThemeWrapper;
import android.util.TypedValue;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.appcompat.R;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.os.Build$VERSION;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v7.widget.ScrollingTabContainerView;
import java.util.ArrayList;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.app.Dialog;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.widget.ActionBarContextView;
import android.content.Context;
import android.view.View;
import android.support.v7.widget.ActionBarContainer;
import android.app.Activity;
import android.view.animation.Interpolator;
import android.support.v7.widget.ActionBarOverlayLayout;

public class WindowDecorActionBar extends ActionBar implements ActionBarVisibilityCallback
{
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean ALLOW_SHOW_HIDE_ANIMATIONS = false;
    private static final long FADE_IN_DURATION_MS = 200L;
    private static final long FADE_OUT_DURATION_MS = 100L;
    private static final int INVALID_POSITION = -1;
    private static final String TAG = "WindowDecorActionBar";
    private static final Interpolator sHideInterpolator;
    private static final Interpolator sShowInterpolator;
    ActionModeImpl mActionMode;
    private Activity mActivity;
    private ActionBarContainer mContainerView;
    private boolean mContentAnimations;
    private View mContentView;
    private Context mContext;
    private ActionBarContextView mContextView;
    private int mCurWindowVisibility;
    private ViewPropertyAnimatorCompatSet mCurrentShowAnim;
    private DecorToolbar mDecorToolbar;
    ActionMode mDeferredDestroyActionMode;
    ActionMode.Callback mDeferredModeDestroyCallback;
    private Dialog mDialog;
    private boolean mDisplayHomeAsUpSet;
    private boolean mHasEmbeddedTabs;
    private boolean mHiddenByApp;
    private boolean mHiddenBySystem;
    final ViewPropertyAnimatorListener mHideListener;
    boolean mHideOnContentScroll;
    private boolean mLastMenuVisibility;
    private ArrayList<OnMenuVisibilityListener> mMenuVisibilityListeners;
    private boolean mNowShowing;
    private ActionBarOverlayLayout mOverlayLayout;
    private int mSavedTabPosition;
    private TabImpl mSelectedTab;
    private boolean mShowHideAnimationEnabled;
    final ViewPropertyAnimatorListener mShowListener;
    private boolean mShowingForMode;
    private ScrollingTabContainerView mTabScrollView;
    private ArrayList<TabImpl> mTabs;
    private Context mThemedContext;
    final ViewPropertyAnimatorUpdateListener mUpdateListener;
    
    static {
        boolean allow_SHOW_HIDE_ANIMATIONS = true;
        sHideInterpolator = (Interpolator)new AccelerateInterpolator();
        sShowInterpolator = (Interpolator)new DecelerateInterpolator();
        if (Build$VERSION.SDK_INT < 14) {
            allow_SHOW_HIDE_ANIMATIONS = false;
        }
    }
    
    public WindowDecorActionBar(final Activity mActivity, final boolean b) {
        super();
        mTabs = new ArrayList<TabImpl>();
        mSavedTabPosition = -1;
        mMenuVisibilityListeners = new ArrayList<OnMenuVisibilityListener>();
        mCurWindowVisibility = 0;
        mContentAnimations = true;
        mNowShowing = true;
        mHideListener = new ViewPropertyAnimatorListenerAdapter() {
            final /* synthetic */ WindowDecorActionBar this$0;
            
            WindowDecorActionBar$1(final WindowDecorActionBar this$0) {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onAnimationEnd(final View view) {
                if (mContentAnimations && mContentView != null) {
                    ViewCompat.setTranslationY(mContentView, 0.0f);
                    ViewCompat.setTranslationY((View)mContainerView, 0.0f);
                }
                mContainerView.setVisibility(8);
                mContainerView.setTransitioning(false);
                mCurrentShowAnim = null;
                this$0.completeDeferredDestroyActionMode();
                if (mOverlayLayout != null) {
                    ViewCompat.requestApplyInsets((View)mOverlayLayout);
                }
            }
        };
        mShowListener = new ViewPropertyAnimatorListenerAdapter() {
            final /* synthetic */ WindowDecorActionBar this$0;
            
            WindowDecorActionBar$2(final WindowDecorActionBar this$0) {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onAnimationEnd(final View view) {
                mCurrentShowAnim = null;
                mContainerView.requestLayout();
            }
        };
        mUpdateListener = new ViewPropertyAnimatorUpdateListener() {
            final /* synthetic */ WindowDecorActionBar this$0;
            
            WindowDecorActionBar$3(final WindowDecorActionBar this$0) {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onAnimationUpdate(final View view) {
                ((View)mContainerView.getParent()).invalidate();
            }
        };
        mActivity = mActivity;
        final View decorView = mActivity.getWindow().getDecorView();
        this.init(decorView);
        if (!b) {
            mContentView = decorView.findViewById(16908290);
        }
    }
    
    public WindowDecorActionBar(final Dialog mDialog) {
        super();
        mTabs = new ArrayList<TabImpl>();
        mSavedTabPosition = -1;
        mMenuVisibilityListeners = new ArrayList<OnMenuVisibilityListener>();
        mCurWindowVisibility = 0;
        mContentAnimations = true;
        mNowShowing = true;
        mHideListener = new ViewPropertyAnimatorListenerAdapter() {
            final /* synthetic */ WindowDecorActionBar this$0;
            
            WindowDecorActionBar$1(final WindowDecorActionBar this$0) {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onAnimationEnd(final View view) {
                if (mContentAnimations && mContentView != null) {
                    ViewCompat.setTranslationY(mContentView, 0.0f);
                    ViewCompat.setTranslationY((View)mContainerView, 0.0f);
                }
                mContainerView.setVisibility(8);
                mContainerView.setTransitioning(false);
                mCurrentShowAnim = null;
                this$0.completeDeferredDestroyActionMode();
                if (mOverlayLayout != null) {
                    ViewCompat.requestApplyInsets((View)mOverlayLayout);
                }
            }
        };
        mShowListener = new ViewPropertyAnimatorListenerAdapter() {
            final /* synthetic */ WindowDecorActionBar this$0;
            
            WindowDecorActionBar$2(final WindowDecorActionBar this$0) {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onAnimationEnd(final View view) {
                mCurrentShowAnim = null;
                mContainerView.requestLayout();
            }
        };
        mUpdateListener = new ViewPropertyAnimatorUpdateListener() {
            final /* synthetic */ WindowDecorActionBar this$0;
            
            WindowDecorActionBar$3(final WindowDecorActionBar this$0) {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onAnimationUpdate(final View view) {
                ((View)mContainerView.getParent()).invalidate();
            }
        };
        mDialog = mDialog;
        this.init(mDialog.getWindow().getDecorView());
    }
    
    public WindowDecorActionBar(final View view) {
        super();
        mTabs = new ArrayList<TabImpl>();
        mSavedTabPosition = -1;
        mMenuVisibilityListeners = new ArrayList<OnMenuVisibilityListener>();
        mCurWindowVisibility = 0;
        mContentAnimations = true;
        mNowShowing = true;
        mHideListener = new ViewPropertyAnimatorListenerAdapter() {
            final /* synthetic */ WindowDecorActionBar this$0;
            
            WindowDecorActionBar$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onAnimationEnd(final View view) {
                if (mContentAnimations && mContentView != null) {
                    ViewCompat.setTranslationY(mContentView, 0.0f);
                    ViewCompat.setTranslationY((View)mContainerView, 0.0f);
                }
                mContainerView.setVisibility(8);
                mContainerView.setTransitioning(false);
                mCurrentShowAnim = null;
                this$0.completeDeferredDestroyActionMode();
                if (mOverlayLayout != null) {
                    ViewCompat.requestApplyInsets((View)mOverlayLayout);
                }
            }
        };
        mShowListener = new ViewPropertyAnimatorListenerAdapter() {
            final /* synthetic */ WindowDecorActionBar this$0;
            
            WindowDecorActionBar$2() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onAnimationEnd(final View view) {
                mCurrentShowAnim = null;
                mContainerView.requestLayout();
            }
        };
        mUpdateListener = new ViewPropertyAnimatorUpdateListener() {
            final /* synthetic */ WindowDecorActionBar this$0;
            
            WindowDecorActionBar$3() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onAnimationUpdate(final View view) {
                ((View)mContainerView.getParent()).invalidate();
            }
        };
        assert view.isInEditMode();
        this.init(view);
    }
    
    static /* synthetic */ boolean access$000(final WindowDecorActionBar windowDecorActionBar) {
        return windowDecorActionBar.mContentAnimations;
    }
    
    static /* synthetic */ View access$100(final WindowDecorActionBar windowDecorActionBar) {
        return windowDecorActionBar.mContentView;
    }
    
    static /* synthetic */ Context access$1000(final WindowDecorActionBar windowDecorActionBar) {
        return windowDecorActionBar.mContext;
    }
    
    static /* synthetic */ ScrollingTabContainerView access$1100(final WindowDecorActionBar windowDecorActionBar) {
        return windowDecorActionBar.mTabScrollView;
    }
    
    static /* synthetic */ ActionBarContainer access$200(final WindowDecorActionBar windowDecorActionBar) {
        return windowDecorActionBar.mContainerView;
    }
    
    static /* synthetic */ ViewPropertyAnimatorCompatSet access$302(final WindowDecorActionBar windowDecorActionBar, final ViewPropertyAnimatorCompatSet mCurrentShowAnim) {
        return windowDecorActionBar.mCurrentShowAnim = mCurrentShowAnim;
    }
    
    static /* synthetic */ ActionBarOverlayLayout access$400(final WindowDecorActionBar windowDecorActionBar) {
        return windowDecorActionBar.mOverlayLayout;
    }
    
    static /* synthetic */ boolean access$500(final WindowDecorActionBar windowDecorActionBar) {
        return windowDecorActionBar.mHiddenByApp;
    }
    
    static /* synthetic */ boolean access$600(final WindowDecorActionBar windowDecorActionBar) {
        return windowDecorActionBar.mHiddenBySystem;
    }
    
    static /* synthetic */ boolean access$700(final boolean b, final boolean b2, final boolean b3) {
        return checkShowingFlags(b, b2, b3);
    }
    
    static /* synthetic */ ActionBarContextView access$800(final WindowDecorActionBar windowDecorActionBar) {
        return windowDecorActionBar.mContextView;
    }
    
    static /* synthetic */ DecorToolbar access$900(final WindowDecorActionBar windowDecorActionBar) {
        return windowDecorActionBar.mDecorToolbar;
    }
    
    private static boolean checkShowingFlags(final boolean b, final boolean b2, final boolean b3) {
        return b3 || (!b && !b2);
    }
    
    private void cleanupTabs() {
        if (mSelectedTab != null) {
            this.selectTab(null);
        }
        mTabs.clear();
        if (mTabScrollView != null) {
            mTabScrollView.removeAllTabs();
        }
        mSavedTabPosition = -1;
    }
    
    private void configureTab(final Tab tab, final int position) {
        final TabImpl tabImpl = (TabImpl)tab;
        if (tabImpl.getCallback() == null) {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
        tabImpl.setPosition(position);
        mTabs.add(position, tabImpl);
        for (int size = mTabs.size(), i = position + 1; i < size; ++i) {
            ((TabImpl)mTabs.get(i)).setPosition(i);
        }
    }
    
    private void ensureTabsExist() {
        if (mTabScrollView != null) {
            return;
        }
        final ScrollingTabContainerView mTabScrollView = new ScrollingTabContainerView(mContext);
        if (mHasEmbeddedTabs) {
            mTabScrollView.setVisibility(0);
            mDecorToolbar.setEmbeddedTabView(mTabScrollView);
        }
        else {
            if (this.getNavigationMode() == 2) {
                mTabScrollView.setVisibility(0);
                if (mOverlayLayout != null) {
                    ViewCompat.requestApplyInsets((View)mOverlayLayout);
                }
            }
            else {
                mTabScrollView.setVisibility(8);
            }
            mContainerView.setTabContainer(mTabScrollView);
        }
        this.mTabScrollView = mTabScrollView;
    }
    
    private DecorToolbar getDecorToolbar(final View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar)view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar)view).getWrapper();
        }
        String simpleName;
        if ("Can't make a decor toolbar out of " + view != null) {
            simpleName = view.getClass().getSimpleName();
        }
        else {
            simpleName = "null";
        }
        throw new IllegalStateException(simpleName);
    }
    
    private void hideForActionMode() {
        if (mShowingForMode) {
            mShowingForMode = false;
            if (mOverlayLayout != null) {
                mOverlayLayout.setShowingForActionMode(false);
            }
            this.updateVisibility(false);
        }
    }
    
    private void init(final View view) {
        mOverlayLayout = (ActionBarOverlayLayout)view.findViewById(R.id.decor_content_parent);
        if (mOverlayLayout != null) {
            mOverlayLayout.setActionBarVisibilityCallback((ActionBarOverlayLayout.ActionBarVisibilityCallback)this);
        }
        mDecorToolbar = this.getDecorToolbar(view.findViewById(R.id.action_bar));
        mContextView = (ActionBarContextView)view.findViewById(R.id.action_context_bar);
        mContainerView = (ActionBarContainer)view.findViewById(R.id.action_bar_container);
        if (mDecorToolbar == null || mContextView == null || mContainerView == null) {
            throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        mContext = mDecorToolbar.getContext();
        boolean b;
        if ((0x4 & mDecorToolbar.getDisplayOptions()) != 0x0) {
            b = true;
        }
        else {
            b = false;
        }
        if (b) {
            mDisplayHomeAsUpSet = true;
        }
        final ActionBarPolicy value = ActionBarPolicy.get(mContext);
        this.setHomeButtonEnabled(value.enableHomeButtonByDefault() || b);
        this.setHasEmbeddedTabs(value.hasEmbeddedTabs());
        final TypedArray obtainStyledAttributes = mContext.obtainStyledAttributes((AttributeSet)null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
            this.setHideOnContentScrollEnabled(true);
        }
        final int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            this.setElevation(dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }
    
    private void setHasEmbeddedTabs(final boolean mHasEmbeddedTabs) {
        boolean hasNonEmbeddedTabs = true;
        if (!(this.mHasEmbeddedTabs = mHasEmbeddedTabs)) {
            mDecorToolbar.setEmbeddedTabView(null);
            mContainerView.setTabContainer(mTabScrollView);
        }
        else {
            mContainerView.setTabContainer(null);
            mDecorToolbar.setEmbeddedTabView(mTabScrollView);
        }
        final boolean b = this.getNavigationMode() == 2 && hasNonEmbeddedTabs;
        if (mTabScrollView != null) {
            if (b) {
                mTabScrollView.setVisibility(0);
                if (mOverlayLayout != null) {
                    ViewCompat.requestApplyInsets((View)mOverlayLayout);
                }
            }
            else {
                mTabScrollView.setVisibility(8);
            }
        }
        mDecorToolbar.setCollapsible(!this.mHasEmbeddedTabs && b && hasNonEmbeddedTabs);
        final ActionBarOverlayLayout mOverlayLayout = this.mOverlayLayout;
        if (this.mHasEmbeddedTabs || !b) {
            hasNonEmbeddedTabs = false;
        }
        mOverlayLayout.setHasNonEmbeddedTabs(hasNonEmbeddedTabs);
    }
    
    private void showForActionMode() {
        if (!mShowingForMode) {
            mShowingForMode = true;
            if (mOverlayLayout != null) {
                mOverlayLayout.setShowingForActionMode(true);
            }
            this.updateVisibility(false);
        }
    }
    
    private void updateVisibility(final boolean b) {
        if (checkShowingFlags(mHiddenByApp, mHiddenBySystem, mShowingForMode)) {
            if (!mNowShowing) {
                mNowShowing = true;
                this.doShow(b);
            }
        }
        else if (mNowShowing) {
            mNowShowing = false;
            this.doHide(b);
        }
    }
    
    @Override
    public void addOnMenuVisibilityListener(final OnMenuVisibilityListener onMenuVisibilityListener) {
        mMenuVisibilityListeners.add(onMenuVisibilityListener);
    }
    
    @Override
    public void addTab(final Tab tab) {
        this.addTab(tab, mTabs.isEmpty());
    }
    
    @Override
    public void addTab(final Tab tab, final int n) {
        this.addTab(tab, n, mTabs.isEmpty());
    }
    
    @Override
    public void addTab(final Tab tab, final int n, final boolean b) {
        this.ensureTabsExist();
        mTabScrollView.addTab(tab, n, b);
        this.configureTab(tab, n);
        if (b) {
            this.selectTab(tab);
        }
    }
    
    @Override
    public void addTab(final Tab tab, final boolean b) {
        this.ensureTabsExist();
        mTabScrollView.addTab(tab, b);
        this.configureTab(tab, mTabs.size());
        if (b) {
            this.selectTab(tab);
        }
    }
    
    public void animateToMode(final boolean b) {
        if (b) {
            this.showForActionMode();
        }
        else {
            this.hideForActionMode();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
        if (b) {
            viewPropertyAnimatorCompat = mDecorToolbar.setupAnimatorToVisibility(4, 100L);
            viewPropertyAnimatorCompat2 = mContextView.setupAnimatorToVisibility(0, 200L);
        }
        else {
            viewPropertyAnimatorCompat2 = mDecorToolbar.setupAnimatorToVisibility(0, 200L);
            viewPropertyAnimatorCompat = mContextView.setupAnimatorToVisibility(8, 100L);
        }
        final ViewPropertyAnimatorCompatSet set = new ViewPropertyAnimatorCompatSet();
        set.playSequentially(viewPropertyAnimatorCompat, viewPropertyAnimatorCompat2);
        set.start();
    }
    
    @Override
    public boolean collapseActionView() {
        if (mDecorToolbar != null && mDecorToolbar.hasExpandedActionView()) {
            mDecorToolbar.collapseActionView();
            return true;
        }
        return false;
    }
    
    void completeDeferredDestroyActionMode() {
        if (mDeferredModeDestroyCallback != null) {
            mDeferredModeDestroyCallback.onDestroyActionMode(mDeferredDestroyActionMode);
            mDeferredDestroyActionMode = null;
            mDeferredModeDestroyCallback = null;
        }
    }
    
    @Override
    public void dispatchMenuVisibilityChanged(final boolean mLastMenuVisibility) {
        if (mLastMenuVisibility != this.mLastMenuVisibility) {
            this.mLastMenuVisibility = mLastMenuVisibility;
            for (int size = mMenuVisibilityListeners.size(), i = 0; i < size; ++i) {
                ((OnMenuVisibilityListener)mMenuVisibilityListeners.get(i)).onMenuVisibilityChanged(mLastMenuVisibility);
            }
        }
    }
    
    public void doHide(final boolean b) {
        if (mCurrentShowAnim != null) {
            mCurrentShowAnim.cancel();
        }
        if (mCurWindowVisibility == 0 && ALLOW_SHOW_HIDE_ANIMATIONS && (mShowHideAnimationEnabled || b)) {
            ViewCompat.setAlpha((View)mContainerView, 1.0f);
            mContainerView.setTransitioning(true);
            final ViewPropertyAnimatorCompatSet mCurrentShowAnim = new ViewPropertyAnimatorCompatSet();
            float n = (float)(-mContainerView.getHeight());
            if (b) {
                final int[] array = { 0, 0 };
                mContainerView.getLocationInWindow(array);
                n -= array[1];
            }
            final ViewPropertyAnimatorCompat translationY = ViewCompat.animate((View)mContainerView).translationY(n);
            translationY.setUpdateListener(mUpdateListener);
            mCurrentShowAnim.play(translationY);
            if (mContentAnimations && mContentView != null) {
                mCurrentShowAnim.play(ViewCompat.animate(mContentView).translationY(n));
            }
            mCurrentShowAnim.setInterpolator(sHideInterpolator);
            mCurrentShowAnim.setDuration(250L);
            mCurrentShowAnim.setListener(mHideListener);
            (this.mCurrentShowAnim = mCurrentShowAnim).start();
            return;
        }
        mHideListener.onAnimationEnd(null);
    }
    
    public void doShow(final boolean b) {
        if (mCurrentShowAnim != null) {
            mCurrentShowAnim.cancel();
        }
        mContainerView.setVisibility(0);
        if (mCurWindowVisibility == 0 && ALLOW_SHOW_HIDE_ANIMATIONS && (mShowHideAnimationEnabled || b)) {
            ViewCompat.setTranslationY((View)mContainerView, 0.0f);
            float n = (float)(-mContainerView.getHeight());
            if (b) {
                final int[] array = { 0, 0 };
                mContainerView.getLocationInWindow(array);
                n -= array[1];
            }
            ViewCompat.setTranslationY((View)mContainerView, n);
            final ViewPropertyAnimatorCompatSet mCurrentShowAnim = new ViewPropertyAnimatorCompatSet();
            final ViewPropertyAnimatorCompat translationY = ViewCompat.animate((View)mContainerView).translationY(0.0f);
            translationY.setUpdateListener(mUpdateListener);
            mCurrentShowAnim.play(translationY);
            if (mContentAnimations && mContentView != null) {
                ViewCompat.setTranslationY(mContentView, n);
                mCurrentShowAnim.play(ViewCompat.animate(mContentView).translationY(0.0f));
            }
            mCurrentShowAnim.setInterpolator(sShowInterpolator);
            mCurrentShowAnim.setDuration(250L);
            mCurrentShowAnim.setListener(mShowListener);
            (this.mCurrentShowAnim = mCurrentShowAnim).start();
        }
        else {
            ViewCompat.setAlpha((View)mContainerView, 1.0f);
            ViewCompat.setTranslationY((View)mContainerView, 0.0f);
            if (mContentAnimations && mContentView != null) {
                ViewCompat.setTranslationY(mContentView, 0.0f);
            }
            mShowListener.onAnimationEnd(null);
        }
        if (mOverlayLayout != null) {
            ViewCompat.requestApplyInsets((View)mOverlayLayout);
        }
    }
    
    @Override
    public void enableContentAnimations(final boolean mContentAnimations) {
        this.mContentAnimations = mContentAnimations;
    }
    
    @Override
    public View getCustomView() {
        return mDecorToolbar.getCustomView();
    }
    
    @Override
    public int getDisplayOptions() {
        return mDecorToolbar.getDisplayOptions();
    }
    
    @Override
    public float getElevation() {
        return ViewCompat.getElevation((View)mContainerView);
    }
    
    @Override
    public int getHeight() {
        return mContainerView.getHeight();
    }
    
    @Override
    public int getHideOffset() {
        return mOverlayLayout.getActionBarHideOffset();
    }
    
    @Override
    public int getNavigationItemCount() {
        switch (mDecorToolbar.getNavigationMode()) {
            default:
                return 0;
            case 2:
                return mTabs.size();
            case 1:
                return mDecorToolbar.getDropdownItemCount();
        }
    }
    
    @Override
    public int getNavigationMode() {
        return mDecorToolbar.getNavigationMode();
    }
    
    @Override
    public int getSelectedNavigationIndex() {
        switch (mDecorToolbar.getNavigationMode()) {
            case 2:
                if (mSelectedTab != null) {
                    return mSelectedTab.getPosition();
                }
                break;
            case 1:
                return mDecorToolbar.getDropdownSelectedPosition();
        }
        return -1;
    }
    
    @Override
    public Tab getSelectedTab() {
        return mSelectedTab;
    }
    
    @Override
    public CharSequence getSubtitle() {
        return mDecorToolbar.getSubtitle();
    }
    
    @Override
    public Tab getTabAt(final int n) {
        return mTabs.get(n);
    }
    
    @Override
    public int getTabCount() {
        return mTabs.size();
    }
    
    @Override
    public Context getThemedContext() {
        if (mThemedContext == null) {
            final TypedValue typedValue = new TypedValue();
            mContext.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            final int resourceId = typedValue.resourceId;
            if (resourceId != 0) {
                mThemedContext = (Context)new ContextThemeWrapper(mContext, resourceId);
            }
            else {
                mThemedContext = mContext;
            }
        }
        return mThemedContext;
    }
    
    @Override
    public CharSequence getTitle() {
        return mDecorToolbar.getTitle();
    }
    
    public boolean hasIcon() {
        return mDecorToolbar.hasIcon();
    }
    
    public boolean hasLogo() {
        return mDecorToolbar.hasLogo();
    }
    
    @Override
    public void hide() {
        if (!mHiddenByApp) {
            mHiddenByApp = true;
            this.updateVisibility(false);
        }
    }
    
    @Override
    public void hideForSystem() {
        if (!mHiddenBySystem) {
            this.updateVisibility(mHiddenBySystem = true);
        }
    }
    
    @Override
    public boolean isHideOnContentScrollEnabled() {
        return mOverlayLayout.isHideOnContentScrollEnabled();
    }
    
    @Override
    public boolean isShowing() {
        final int height = this.getHeight();
        return mNowShowing && (height == 0 || this.getHideOffset() < height);
    }
    
    @Override
    public boolean isTitleTruncated() {
        return mDecorToolbar != null && mDecorToolbar.isTitleTruncated();
    }
    
    @Override
    public Tab newTab() {
        return new TabImpl();
    }
    
    @Override
    public void onConfigurationChanged(final Configuration configuration) {
        this.setHasEmbeddedTabs(ActionBarPolicy.get(mContext).hasEmbeddedTabs());
    }
    
    @Override
    public void onContentScrollStarted() {
        if (mCurrentShowAnim != null) {
            mCurrentShowAnim.cancel();
            mCurrentShowAnim = null;
        }
    }
    
    @Override
    public void onContentScrollStopped() {
    }
    
    @Override
    public void onWindowVisibilityChanged(final int mCurWindowVisibility) {
        this.mCurWindowVisibility = mCurWindowVisibility;
    }
    
    @Override
    public void removeAllTabs() {
        this.cleanupTabs();
    }
    
    @Override
    public void removeOnMenuVisibilityListener(final OnMenuVisibilityListener onMenuVisibilityListener) {
        mMenuVisibilityListeners.remove(onMenuVisibilityListener);
    }
    
    @Override
    public void removeTab(final Tab tab) {
        this.removeTabAt(tab.getPosition());
    }
    
    @Override
    public void removeTabAt(final int n) {
        if (mTabScrollView != null) {
            int n2;
            if (mSelectedTab != null) {
                n2 = mSelectedTab.getPosition();
            }
            else {
                n2 = mSavedTabPosition;
            }
            mTabScrollView.removeTabAt(n);
            final TabImpl tabImpl = (TabImpl)mTabs.remove(n);
            if (tabImpl != null) {
                tabImpl.setPosition(-1);
            }
            for (int size = mTabs.size(), i = n; i < size; ++i) {
                ((TabImpl)mTabs.get(i)).setPosition(i);
            }
            if (n2 == n) {
                Tab tab;
                if (mTabs.isEmpty()) {
                    tab = null;
                }
                else {
                    tab = mTabs.get(Math.max(0, n - 1));
                }
                this.selectTab(tab);
            }
        }
    }
    
    public boolean requestFocus() {
        final ViewGroup viewGroup = mDecorToolbar.getViewGroup();
        if (viewGroup != null && !viewGroup.hasFocus()) {
            viewGroup.requestFocus();
            return true;
        }
        return false;
    }
    
    @Override
    public void selectTab(final Tab tab) {
        int position = -1;
        if (this.getNavigationMode() != 2) {
            int position2;
            if (tab != null) {
                position2 = tab.getPosition();
            }
            else {
                position2 = position;
            }
            mSavedTabPosition = position2;
        }
        else {
            FragmentTransaction disallowAddToBackStack;
            if (mActivity instanceof FragmentActivity && !mDecorToolbar.getViewGroup().isInEditMode()) {
                disallowAddToBackStack = ((FragmentActivity)mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
            }
            else {
                disallowAddToBackStack = null;
            }
            if (mSelectedTab == tab) {
                if (mSelectedTab != null) {
                    mSelectedTab.getCallback().onTabReselected(mSelectedTab, disallowAddToBackStack);
                    mTabScrollView.animateToTab(tab.getPosition());
                }
            }
            else {
                final ScrollingTabContainerView mTabScrollView = this.mTabScrollView;
                if (tab != null) {
                    position = tab.getPosition();
                }
                mTabScrollView.setTabSelected(position);
                if (mSelectedTab != null) {
                    mSelectedTab.getCallback().onTabUnselected(mSelectedTab, disallowAddToBackStack);
                }
                mSelectedTab = (TabImpl)tab;
                if (mSelectedTab != null) {
                    mSelectedTab.getCallback().onTabSelected(mSelectedTab, disallowAddToBackStack);
                }
            }
            if (disallowAddToBackStack != null && !disallowAddToBackStack.isEmpty()) {
                disallowAddToBackStack.commit();
            }
        }
    }
    
    @Override
    public void setBackgroundDrawable(final Drawable primaryBackground) {
        mContainerView.setPrimaryBackground(primaryBackground);
    }
    
    @Override
    public void setCustomView(final int n) {
        this.setCustomView(LayoutInflater.from(this.getThemedContext()).inflate(n, mDecorToolbar.getViewGroup(), false));
    }
    
    @Override
    public void setCustomView(final View customView) {
        mDecorToolbar.setCustomView(customView);
    }
    
    @Override
    public void setCustomView(final View customView, final ActionBar.LayoutParams layoutParams) {
        customView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        mDecorToolbar.setCustomView(customView);
    }
    
    @Override
    public void setDefaultDisplayHomeAsUpEnabled(final boolean displayHomeAsUpEnabled) {
        if (!mDisplayHomeAsUpSet) {
            this.setDisplayHomeAsUpEnabled(displayHomeAsUpEnabled);
        }
    }
    
    @Override
    public void setDisplayHomeAsUpEnabled(final boolean b) {
        int n;
        if (b) {
            n = 4;
        }
        else {
            n = 0;
        }
        this.setDisplayOptions(n, 4);
    }
    
    @Override
    public void setDisplayOptions(final int displayOptions) {
        if ((displayOptions & 0x4) != 0x0) {
            mDisplayHomeAsUpSet = true;
        }
        mDecorToolbar.setDisplayOptions(displayOptions);
    }
    
    @Override
    public void setDisplayOptions(final int n, final int n2) {
        final int displayOptions = mDecorToolbar.getDisplayOptions();
        if ((n2 & 0x4) != 0x0) {
            mDisplayHomeAsUpSet = true;
        }
        mDecorToolbar.setDisplayOptions((n & n2) | (displayOptions & ~n2));
    }
    
    @Override
    public void setDisplayShowCustomEnabled(final boolean b) {
        int n;
        if (b) {
            n = 16;
        }
        else {
            n = 0;
        }
        this.setDisplayOptions(n, 16);
    }
    
    @Override
    public void setDisplayShowHomeEnabled(final boolean b) {
        int n;
        if (b) {
            n = 2;
        }
        else {
            n = 0;
        }
        this.setDisplayOptions(n, 2);
    }
    
    @Override
    public void setDisplayShowTitleEnabled(final boolean b) {
        int n;
        if (b) {
            n = 8;
        }
        else {
            n = 0;
        }
        this.setDisplayOptions(n, 8);
    }
    
    @Override
    public void setDisplayUseLogoEnabled(final boolean b) {
        int n;
        if (b) {
            n = 1;
        }
        else {
            n = 0;
        }
        this.setDisplayOptions(n, 1);
    }
    
    @Override
    public void setElevation(final float n) {
        ViewCompat.setElevation((View)mContainerView, n);
    }
    
    @Override
    public void setHideOffset(final int actionBarHideOffset) {
        if (actionBarHideOffset != 0 && !mOverlayLayout.isInOverlayMode()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
        }
        mOverlayLayout.setActionBarHideOffset(actionBarHideOffset);
    }
    
    @Override
    public void setHideOnContentScrollEnabled(final boolean b) {
        if (b && !mOverlayLayout.isInOverlayMode()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        mHideOnContentScroll = b;
        mOverlayLayout.setHideOnContentScrollEnabled(b);
    }
    
    @Override
    public void setHomeActionContentDescription(final int navigationContentDescription) {
        mDecorToolbar.setNavigationContentDescription(navigationContentDescription);
    }
    
    @Override
    public void setHomeActionContentDescription(final CharSequence navigationContentDescription) {
        mDecorToolbar.setNavigationContentDescription(navigationContentDescription);
    }
    
    @Override
    public void setHomeAsUpIndicator(final int navigationIcon) {
        mDecorToolbar.setNavigationIcon(navigationIcon);
    }
    
    @Override
    public void setHomeAsUpIndicator(final Drawable navigationIcon) {
        mDecorToolbar.setNavigationIcon(navigationIcon);
    }
    
    @Override
    public void setHomeButtonEnabled(final boolean homeButtonEnabled) {
        mDecorToolbar.setHomeButtonEnabled(homeButtonEnabled);
    }
    
    @Override
    public void setIcon(final int icon) {
        mDecorToolbar.setIcon(icon);
    }
    
    @Override
    public void setIcon(final Drawable icon) {
        mDecorToolbar.setIcon(icon);
    }
    
    @Override
    public void setListNavigationCallbacks(final SpinnerAdapter spinnerAdapter, final OnNavigationListener onNavigationListener) {
        mDecorToolbar.setDropdownParams(spinnerAdapter, (AdapterView$OnItemSelectedListener)new NavItemSelectedListener(onNavigationListener));
    }
    
    @Override
    public void setLogo(final int logo) {
        mDecorToolbar.setLogo(logo);
    }
    
    @Override
    public void setLogo(final Drawable logo) {
        mDecorToolbar.setLogo(logo);
    }
    
    @Override
    public void setNavigationMode(final int navigationMode) {
        boolean hasNonEmbeddedTabs = true;
        final int navigationMode2 = mDecorToolbar.getNavigationMode();
        switch (navigationMode2) {
            case 2:
                mSavedTabPosition = this.getSelectedNavigationIndex();
                this.selectTab(null);
                mTabScrollView.setVisibility(8);
                break;
        }
        if (navigationMode2 != navigationMode && !mHasEmbeddedTabs && mOverlayLayout != null) {
            ViewCompat.requestApplyInsets((View)mOverlayLayout);
        }
        mDecorToolbar.setNavigationMode(navigationMode);
        switch (navigationMode) {
            case 2:
                this.ensureTabsExist();
                mTabScrollView.setVisibility(0);
                if (mSavedTabPosition != -1) {
                    this.setSelectedNavigationItem(mSavedTabPosition);
                    mSavedTabPosition = -1;
                    break;
                }
                break;
        }
        mDecorToolbar.setCollapsible(navigationMode == 2 && !mHasEmbeddedTabs && hasNonEmbeddedTabs);
        final ActionBarOverlayLayout mOverlayLayout = this.mOverlayLayout;
        if (navigationMode != 2 || mHasEmbeddedTabs) {
            hasNonEmbeddedTabs = false;
        }
        mOverlayLayout.setHasNonEmbeddedTabs(hasNonEmbeddedTabs);
    }
    
    @Override
    public void setSelectedNavigationItem(final int dropdownSelectedPosition) {
        switch (mDecorToolbar.getNavigationMode()) {
            default:
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
            case 2:
                this.selectTab(mTabs.get(dropdownSelectedPosition));
            case 1:
                mDecorToolbar.setDropdownSelectedPosition(dropdownSelectedPosition);
        }
    }
    
    @Override
    public void setShowHideAnimationEnabled(final boolean mShowHideAnimationEnabled) {
        this.mShowHideAnimationEnabled = mShowHideAnimationEnabled;
        if (!mShowHideAnimationEnabled && mCurrentShowAnim != null) {
            mCurrentShowAnim.cancel();
        }
    }
    
    @Override
    public void setSplitBackgroundDrawable(final Drawable drawable) {
    }
    
    @Override
    public void setStackedBackgroundDrawable(final Drawable stackedBackground) {
        mContainerView.setStackedBackground(stackedBackground);
    }
    
    @Override
    public void setSubtitle(final int n) {
        this.setSubtitle(mContext.getString(n));
    }
    
    @Override
    public void setSubtitle(final CharSequence subtitle) {
        mDecorToolbar.setSubtitle(subtitle);
    }
    
    @Override
    public void setTitle(final int n) {
        this.setTitle(mContext.getString(n));
    }
    
    @Override
    public void setTitle(final CharSequence title) {
        mDecorToolbar.setTitle(title);
    }
    
    @Override
    public void setWindowTitle(final CharSequence windowTitle) {
        mDecorToolbar.setWindowTitle(windowTitle);
    }
    
    @Override
    public void show() {
        if (mHiddenByApp) {
            this.updateVisibility(mHiddenByApp = false);
        }
    }
    
    @Override
    public void showForSystem() {
        if (mHiddenBySystem) {
            mHiddenBySystem = false;
            this.updateVisibility(true);
        }
    }
    
    @Override
    public ActionMode startActionMode(final ActionMode.Callback callback) {
        if (mActionMode != null) {
            mActionMode.finish();
        }
        mOverlayLayout.setHideOnContentScrollEnabled(false);
        mContextView.killMode();
        final ActionModeImpl mActionMode = new ActionModeImpl(mContextView.getContext(), callback);
        if (mActionMode.dispatchOnCreate()) {
            mActionMode.invalidate();
            mContextView.initForMode(mActionMode);
            this.animateToMode(true);
            mContextView.sendAccessibilityEvent(32);
            return this.mActionMode = mActionMode;
        }
        return null;
    }
}
