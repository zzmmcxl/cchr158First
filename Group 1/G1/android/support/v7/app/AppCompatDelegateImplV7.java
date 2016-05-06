package android.support.v7.app;

import android.view.View$MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.ActionMenuPresenter;
import android.view.View$OnClickListener;
import android.support.v7.widget.TintTypedArray;
import android.widget.LinearLayout;
import android.support.v7.widget.AbsActionBarView;
import android.support.v4.os.ParcelableCompat;
import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.ListMenuPresenter;
import android.support.v7.widget.AppCompatDrawableManager;
import android.view.MotionEvent;
import android.support.v7.view.StandaloneActionMode;
import android.support.v7.widget.ViewStubCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.content.res.Configuration;
import android.support.v4.view.LayoutInflaterCompat;
import android.app.Dialog;
import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater$Factory;
import android.util.AttributeSet;
import android.view.ViewGroup$MarginLayoutParams;
import android.util.AndroidRuntimeException;
import android.view.KeyCharacterMap;
import android.view.ViewParent;
import android.view.WindowManager$LayoutParams;
import android.view.ViewGroup$LayoutParams;
import android.util.Log;
import android.media.AudioManager;
import android.support.v4.view.ViewConfigurationCompat;
import android.view.ViewConfiguration;
import android.content.res.Resources$Theme;
import android.support.v7.view.menu.MenuPresenter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.os.Bundle;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.support.v7.widget.ViewUtils;
import android.support.v7.widget.FitWindowsViewGroup;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.os.Build$VERSION;
import android.support.v7.view.ContextThemeWrapper;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.Window$Callback;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R;
import android.support.v7.widget.ContentFrameLayout;
import android.view.Menu;
import android.view.Window;
import android.content.Context;
import android.widget.TextView;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.DecorContentParent;
import android.support.v7.widget.ActionBarContextView;
import android.widget.PopupWindow;
import android.support.v7.view.ActionMode;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.view.menu.MenuBuilder;

class AppCompatDelegateImplV7 extends AppCompatDelegateImplBase implements Callback, LayoutInflaterFactory
{
    private ActionMenuPresenterCallback mActionMenuPresenterCallback;
    ActionMode mActionMode;
    PopupWindow mActionModePopup;
    ActionBarContextView mActionModeView;
    private AppCompatViewInflater mAppCompatViewInflater;
    private boolean mClosingActionMenu;
    private DecorContentParent mDecorContentParent;
    private boolean mEnableDefaultActionBarUp;
    ViewPropertyAnimatorCompat mFadeAnim;
    private boolean mFeatureIndeterminateProgress;
    private boolean mFeatureProgress;
    private int mInvalidatePanelMenuFeatures;
    private boolean mInvalidatePanelMenuPosted;
    private final Runnable mInvalidatePanelMenuRunnable;
    private boolean mLongPressBackDown;
    private PanelMenuPresenterCallback mPanelMenuPresenterCallback;
    private PanelFeatureState[] mPanels;
    private PanelFeatureState mPreparedPanel;
    Runnable mShowActionModePopup;
    private View mStatusGuard;
    private ViewGroup mSubDecor;
    private boolean mSubDecorInstalled;
    private Rect mTempRect1;
    private Rect mTempRect2;
    private TextView mTitleView;
    
    AppCompatDelegateImplV7(final Context context, final Window window, final AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
        mFadeAnim = null;
        mInvalidatePanelMenuRunnable = new Runnable() {
            final /* synthetic */ AppCompatDelegateImplV7 this$0;
            
            AppCompatDelegateImplV7$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                if ((0x1 & mInvalidatePanelMenuFeatures) != 0x0) {
                    this$0.doInvalidatePanelMenu(0);
                }
                if ((0x1000 & mInvalidatePanelMenuFeatures) != 0x0) {
                    this$0.doInvalidatePanelMenu(108);
                }
                mInvalidatePanelMenuPosted = false;
                mInvalidatePanelMenuFeatures = 0;
            }
        };
    }
    
    static /* synthetic */ int access$000(final AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        return appCompatDelegateImplV7.mInvalidatePanelMenuFeatures;
    }
    
    static /* synthetic */ int access$002(final AppCompatDelegateImplV7 appCompatDelegateImplV7, final int mInvalidatePanelMenuFeatures) {
        return appCompatDelegateImplV7.mInvalidatePanelMenuFeatures = mInvalidatePanelMenuFeatures;
    }
    
    static /* synthetic */ void access$100(final AppCompatDelegateImplV7 appCompatDelegateImplV7, final int n) {
        appCompatDelegateImplV7.doInvalidatePanelMenu(n);
    }
    
    static /* synthetic */ void access$1000(final AppCompatDelegateImplV7 appCompatDelegateImplV7, final PanelFeatureState panelFeatureState, final boolean b) {
        appCompatDelegateImplV7.closePanel(panelFeatureState, b);
    }
    
    static /* synthetic */ void access$1100(final AppCompatDelegateImplV7 appCompatDelegateImplV7, final MenuBuilder menuBuilder) {
        appCompatDelegateImplV7.checkCloseActionMenu(menuBuilder);
    }
    
    static /* synthetic */ void access$1400(final AppCompatDelegateImplV7 appCompatDelegateImplV7, final int n) {
        appCompatDelegateImplV7.closePanel(n);
    }
    
    static /* synthetic */ boolean access$202(final AppCompatDelegateImplV7 appCompatDelegateImplV7, final boolean mInvalidatePanelMenuPosted) {
        return appCompatDelegateImplV7.mInvalidatePanelMenuPosted = mInvalidatePanelMenuPosted;
    }
    
    static /* synthetic */ int access$300(final AppCompatDelegateImplV7 appCompatDelegateImplV7, final int n) {
        return appCompatDelegateImplV7.updateStatusGuard(n);
    }
    
    static /* synthetic */ void access$400(final AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        appCompatDelegateImplV7.dismissPopups();
    }
    
    static /* synthetic */ void access$500(final AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        appCompatDelegateImplV7.endOnGoingFadeAnimation();
    }
    
    static /* synthetic */ PanelFeatureState access$800(final AppCompatDelegateImplV7 appCompatDelegateImplV7, final Menu menu) {
        return appCompatDelegateImplV7.findMenuPanel(menu);
    }
    
    static /* synthetic */ void access$900(final AppCompatDelegateImplV7 appCompatDelegateImplV7, final int n, final PanelFeatureState panelFeatureState, final Menu menu) {
        appCompatDelegateImplV7.callOnPanelClosed(n, panelFeatureState, menu);
    }
    
    private void applyFixedSizeWindow() {
        final ContentFrameLayout contentFrameLayout = (ContentFrameLayout)mSubDecor.findViewById(16908290);
        final View decorView = this.mWindow.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        final TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }
    
    private void callOnPanelClosed(final int n, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && n >= 0 && n < mPanels.length) {
                panelFeatureState = mPanels[n];
            }
            if (panelFeatureState != null) {
                menu = (Menu)panelFeatureState.menu;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.isOpen) && !this.isDestroyed()) {
            this.mOriginalWindowCallback.onPanelClosed(n, menu);
        }
    }
    
    private void checkCloseActionMenu(final MenuBuilder menuBuilder) {
        if (mClosingActionMenu) {
            return;
        }
        mClosingActionMenu = true;
        mDecorContentParent.dismissPopups();
        final Window$Callback windowCallback = this.getWindowCallback();
        if (windowCallback != null && !this.isDestroyed()) {
            windowCallback.onPanelClosed(108, (Menu)menuBuilder);
        }
        mClosingActionMenu = false;
    }
    
    private void closePanel(final int n) {
        this.closePanel(this.getPanelState(n, true), true);
    }
    
    private void closePanel(final PanelFeatureState panelFeatureState, final boolean b) {
        if (b && panelFeatureState.featureId == 0 && mDecorContentParent != null && mDecorContentParent.isOverflowMenuShowing()) {
            this.checkCloseActionMenu(panelFeatureState.menu);
        }
        else {
            final WindowManager windowManager = (WindowManager)this.mContext.getSystemService("window");
            if (windowManager != null && panelFeatureState.isOpen && panelFeatureState.decorView != null) {
                windowManager.removeView((View)panelFeatureState.decorView);
                if (b) {
                    this.callOnPanelClosed(panelFeatureState.featureId, panelFeatureState, null);
                }
            }
            panelFeatureState.isPrepared = false;
            panelFeatureState.isHandled = false;
            panelFeatureState.isOpen = false;
            panelFeatureState.shownPanelView = null;
            panelFeatureState.refreshDecorView = true;
            if (mPreparedPanel == panelFeatureState) {
                mPreparedPanel = null;
            }
        }
    }
    
    private ViewGroup createSubDecor() {
        final TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
        if (!obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowActionBar)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
            this.requestWindowFeature(1);
        }
        else if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBar, false)) {
            this.requestWindowFeature(108);
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            this.requestWindowFeature(109);
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            this.requestWindowFeature(10);
        }
        this.mIsFloating = obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
        obtainStyledAttributes.recycle();
        final LayoutInflater from = LayoutInflater.from(this.mContext);
        Object contentView;
        if (!this.mWindowNoTitle) {
            if (this.mIsFloating) {
                contentView = from.inflate(R.layout.abc_dialog_title_material, (ViewGroup)null);
                this.mOverlayActionBar = false;
                this.mHasActionBar = false;
            }
            else {
                final boolean mHasActionBar = this.mHasActionBar;
                contentView = null;
                if (mHasActionBar) {
                    final TypedValue typedValue = new TypedValue();
                    this.mContext.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                    Object mContext;
                    if (typedValue.resourceId != 0) {
                        mContext = new ContextThemeWrapper(this.mContext, typedValue.resourceId);
                    }
                    else {
                        mContext = this.mContext;
                    }
                    contentView = LayoutInflater.from((Context)mContext).inflate(R.layout.abc_screen_toolbar, (ViewGroup)null);
                    (mDecorContentParent = (DecorContentParent)((ViewGroup)contentView).findViewById(R.id.decor_content_parent)).setWindowCallback(this.getWindowCallback());
                    if (this.mOverlayActionBar) {
                        mDecorContentParent.initFeature(109);
                    }
                    if (mFeatureProgress) {
                        mDecorContentParent.initFeature(2);
                    }
                    if (mFeatureIndeterminateProgress) {
                        mDecorContentParent.initFeature(5);
                    }
                }
            }
        }
        else {
            if (this.mOverlayActionMode) {
                contentView = from.inflate(R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup)null);
            }
            else {
                contentView = from.inflate(R.layout.abc_screen_simple, (ViewGroup)null);
            }
            if (Build$VERSION.SDK_INT >= 21) {
                ViewCompat.setOnApplyWindowInsetsListener(contentView, (OnApplyWindowInsetsListener)new OnApplyWindowInsetsListener() {
                    final /* synthetic */ AppCompatDelegateImplV7 this$0;
                    
                    AppCompatDelegateImplV7$2() {
                        this$0 = this$0;
                        super();
                    }
                    
                    @Override
                    public WindowInsetsCompat onApplyWindowInsets(final View view, WindowInsetsCompat replaceSystemWindowInsets) {
                        final int systemWindowInsetTop = replaceSystemWindowInsets.getSystemWindowInsetTop();
                        final int access$300 = this$0.updateStatusGuard(systemWindowInsetTop);
                        if (systemWindowInsetTop != access$300) {
                            replaceSystemWindowInsets = replaceSystemWindowInsets.replaceSystemWindowInsets(replaceSystemWindowInsets.getSystemWindowInsetLeft(), access$300, replaceSystemWindowInsets.getSystemWindowInsetRight(), replaceSystemWindowInsets.getSystemWindowInsetBottom());
                        }
                        return ViewCompat.onApplyWindowInsets(view, replaceSystemWindowInsets);
                    }
                });
            }
            else {
                ((FitWindowsViewGroup)contentView).setOnFitSystemWindowsListener((FitWindowsViewGroup.OnFitSystemWindowsListener)new FitWindowsViewGroup.OnFitSystemWindowsListener() {
                    final /* synthetic */ AppCompatDelegateImplV7 this$0;
                    
                    AppCompatDelegateImplV7$3() {
                        this$0 = this$0;
                        super();
                    }
                    
                    @Override
                    public void onFitSystemWindows(final Rect rect) {
                        rect.top = this$0.updateStatusGuard(rect.top);
                    }
                });
            }
        }
        if (contentView == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.mHasActionBar + ", windowActionBarOverlay: " + this.mOverlayActionBar + ", android:windowIsFloating: " + this.mIsFloating + ", windowActionModeOverlay: " + this.mOverlayActionMode + ", windowNoTitle: " + this.mWindowNoTitle + " }");
        }
        if (mDecorContentParent == null) {
            mTitleView = (TextView)((ViewGroup)contentView).findViewById(R.id.title);
        }
        ViewUtils.makeOptionalFitsSystemWindows((View)contentView);
        final ViewGroup viewGroup = (ViewGroup)this.mWindow.findViewById(16908290);
        final ContentFrameLayout contentFrameLayout = (ContentFrameLayout)((ViewGroup)contentView).findViewById(R.id.action_bar_activity_content);
        while (viewGroup.getChildCount() > 0) {
            final View child = viewGroup.getChildAt(0);
            viewGroup.removeViewAt(0);
            contentFrameLayout.addView(child);
        }
        this.mWindow.setContentView((View)contentView);
        viewGroup.setId(-1);
        contentFrameLayout.setId(16908290);
        if (viewGroup instanceof FrameLayout) {
            ((FrameLayout)viewGroup).setForeground((Drawable)null);
        }
        contentFrameLayout.setAttachListener((ContentFrameLayout.OnAttachListener)new ContentFrameLayout.OnAttachListener() {
            final /* synthetic */ AppCompatDelegateImplV7 this$0;
            
            AppCompatDelegateImplV7$4() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onAttachedFromWindow() {
            }
            
            @Override
            public void onDetachedFromWindow() {
                this$0.dismissPopups();
            }
        });
        return (ViewGroup)contentView;
    }
    
    private void dismissPopups() {
        if (mDecorContentParent != null) {
            mDecorContentParent.dismissPopups();
        }
        Label_0060: {
            if (mActionModePopup == null) {
                break Label_0060;
            }
            this.mWindow.getDecorView().removeCallbacks(mShowActionModePopup);
            while (true) {
                if (!mActionModePopup.isShowing()) {
                    break Label_0055;
                }
                try {
                    mActionModePopup.dismiss();
                    mActionModePopup = null;
                    this.endOnGoingFadeAnimation();
                    final PanelFeatureState panelState = this.getPanelState(0, false);
                    if (panelState != null && panelState.menu != null) {
                        panelState.menu.close();
                    }
                }
                catch (IllegalArgumentException ex) {
                    continue;
                }
                break;
            }
        }
    }
    
    private void doInvalidatePanelMenu(final int n) {
        final PanelFeatureState panelState = this.getPanelState(n, true);
        if (panelState.menu != null) {
            final Bundle frozenActionViewState = new Bundle();
            panelState.menu.saveActionViewStates(frozenActionViewState);
            if (frozenActionViewState.size() > 0) {
                panelState.frozenActionViewState = frozenActionViewState;
            }
            panelState.menu.stopDispatchingItemsChanged();
            panelState.menu.clear();
        }
        panelState.refreshMenuContent = true;
        panelState.refreshDecorView = true;
        if ((n == 108 || n == 0) && mDecorContentParent != null) {
            final PanelFeatureState panelState2 = this.getPanelState(0, false);
            if (panelState2 != null) {
                panelState2.isPrepared = false;
                this.preparePanel(panelState2, null);
            }
        }
    }
    
    private void endOnGoingFadeAnimation() {
        if (mFadeAnim != null) {
            mFadeAnim.cancel();
        }
    }
    
    private void ensureSubDecor() {
        if (!mSubDecorInstalled) {
            mSubDecor = this.createSubDecor();
            final CharSequence title = this.getTitle();
            if (!TextUtils.isEmpty(title)) {
                this.onTitleChanged(title);
            }
            this.applyFixedSizeWindow();
            this.onSubDecorInstalled(mSubDecor);
            mSubDecorInstalled = true;
            final PanelFeatureState panelState = this.getPanelState(0, false);
            if (!this.isDestroyed() && (panelState == null || panelState.menu == null)) {
                this.invalidatePanelMenu(108);
            }
        }
    }
    
    private PanelFeatureState findMenuPanel(final Menu menu) {
        final PanelFeatureState[] mPanels = this.mPanels;
        if (mPanels != null) {
            final int length = mPanels.length;
        }
        else {
            final int length = 0;
        }
        for (final PanelFeatureState panelFeatureState : mPanels) {
            if (panelFeatureState != null && panelFeatureState.menu == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }
    
    private PanelFeatureState getPanelState(final int n, final boolean b) {
        PanelFeatureState[] mPanels = this.mPanels;
        if (mPanels == null || mPanels.length <= n) {
            final PanelFeatureState[] mPanels2 = new PanelFeatureState[n + 1];
            if (mPanels != null) {
                System.arraycopy(mPanels, 0, mPanels2, 0, mPanels.length);
            }
            mPanels = mPanels2;
            this.mPanels = mPanels2;
        }
        PanelFeatureState panelFeatureState = mPanels[n];
        if (panelFeatureState == null) {
            panelFeatureState = new PanelFeatureState(n);
            mPanels[n] = panelFeatureState;
        }
        return panelFeatureState;
    }
    
    private boolean initializePanelContent(final PanelFeatureState panelFeatureState) {
        if (panelFeatureState.createdPanelView != null) {
            panelFeatureState.shownPanelView = panelFeatureState.createdPanelView;
        }
        else {
            if (panelFeatureState.menu == null) {
                return false;
            }
            if (mPanelMenuPresenterCallback == null) {
                mPanelMenuPresenterCallback = new PanelMenuPresenterCallback(this);
            }
            panelFeatureState.shownPanelView = (View)panelFeatureState.getListMenuView(mPanelMenuPresenterCallback);
            if (panelFeatureState.shownPanelView == null) {
                return false;
            }
        }
        return true;
    }
    
    private boolean initializePanelDecor(final PanelFeatureState panelFeatureState) {
        panelFeatureState.setStyle(this.getActionBarThemedContext());
        panelFeatureState.decorView = (ViewGroup)new ListMenuDecorView(panelFeatureState.listPresenterContext);
        panelFeatureState.gravity = 81;
        return true;
    }
    
    private boolean initializePanelMenu(final PanelFeatureState panelFeatureState) {
        Context mContext = this.mContext;
        if ((panelFeatureState.featureId == 0 || panelFeatureState.featureId == 108) && mDecorContentParent != null) {
            final TypedValue typedValue = new TypedValue();
            final Resources$Theme theme = mContext.getTheme();
            theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
            Resources$Theme to;
            if (typedValue.resourceId != 0) {
                to = mContext.getResources().newTheme();
                to.setTo(theme);
                to.applyStyle(typedValue.resourceId, true);
                to.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            }
            else {
                theme.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
                to = null;
            }
            if (typedValue.resourceId != 0) {
                if (to == null) {
                    to = mContext.getResources().newTheme();
                    to.setTo(theme);
                }
                to.applyStyle(typedValue.resourceId, true);
            }
            if (to != null) {
                final ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(mContext, 0);
                ((Context)contextThemeWrapper).getTheme().setTo(to);
                mContext = (Context)contextThemeWrapper;
            }
        }
        final MenuBuilder menu = new MenuBuilder(mContext);
        menu.setCallback((MenuBuilder.Callback)this);
        panelFeatureState.setMenu(menu);
        return true;
    }
    
    private void invalidatePanelMenu(final int n) {
        mInvalidatePanelMenuFeatures |= 1 << n;
        if (!mInvalidatePanelMenuPosted) {
            ViewCompat.postOnAnimation(this.mWindow.getDecorView(), mInvalidatePanelMenuRunnable);
            mInvalidatePanelMenuPosted = true;
        }
    }
    
    private boolean onKeyDownPanel(final int n, final KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            final PanelFeatureState panelState = this.getPanelState(n, true);
            if (!panelState.isOpen) {
                return this.preparePanel(panelState, keyEvent);
            }
        }
        return false;
    }
    
    private boolean onKeyUpPanel(final int n, final KeyEvent keyEvent) {
        boolean b;
        if (mActionMode != null) {
            b = false;
        }
        else {
            final PanelFeatureState panelState = this.getPanelState(n, true);
            if (n == 0 && mDecorContentParent != null && mDecorContentParent.canShowOverflowMenu() && !ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext))) {
                if (!mDecorContentParent.isOverflowMenuShowing()) {
                    final boolean destroyed = this.isDestroyed();
                    b = false;
                    if (!destroyed) {
                        final boolean preparePanel = this.preparePanel(panelState, keyEvent);
                        b = false;
                        if (preparePanel) {
                            b = mDecorContentParent.showOverflowMenu();
                        }
                    }
                }
                else {
                    b = mDecorContentParent.hideOverflowMenu();
                }
            }
            else if (panelState.isOpen || panelState.isHandled) {
                b = panelState.isOpen;
                this.closePanel(panelState, true);
            }
            else {
                final boolean isPrepared = panelState.isPrepared;
                b = false;
                if (isPrepared) {
                    boolean preparePanel2 = true;
                    if (panelState.refreshMenuContent) {
                        panelState.isPrepared = false;
                        preparePanel2 = this.preparePanel(panelState, keyEvent);
                    }
                    b = false;
                    if (preparePanel2) {
                        this.openPanel(panelState, keyEvent);
                        b = true;
                    }
                }
            }
            if (b) {
                final AudioManager audioManager = (AudioManager)this.mContext.getSystemService("audio");
                if (audioManager != null) {
                    audioManager.playSoundEffect(0);
                    return b;
                }
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
                return b;
            }
        }
        return b;
    }
    
    private void openPanel(final PanelFeatureState panelFeatureState, final KeyEvent keyEvent) {
        if (!panelFeatureState.isOpen && !this.isDestroyed()) {
            if (panelFeatureState.featureId == 0) {
                final Context mContext = this.mContext;
                boolean b;
                if ((0xF & mContext.getResources().getConfiguration().screenLayout) == 0x4) {
                    b = true;
                }
                else {
                    b = false;
                }
                boolean b2;
                if (mContext.getApplicationInfo().targetSdkVersion >= 11) {
                    b2 = true;
                }
                else {
                    b2 = false;
                }
                if (b && b2) {
                    return;
                }
            }
            final Window$Callback windowCallback = this.getWindowCallback();
            if (windowCallback != null && !windowCallback.onMenuOpened(panelFeatureState.featureId, (Menu)panelFeatureState.menu)) {
                this.closePanel(panelFeatureState, true);
                return;
            }
            final WindowManager windowManager = (WindowManager)this.mContext.getSystemService("window");
            if (windowManager != null && this.preparePanel(panelFeatureState, keyEvent)) {
                int n = -2;
                if (panelFeatureState.decorView == null || panelFeatureState.refreshDecorView) {
                    if (panelFeatureState.decorView == null) {
                        if (!this.initializePanelDecor(panelFeatureState) || panelFeatureState.decorView == null) {
                            return;
                        }
                    }
                    else if (panelFeatureState.refreshDecorView && panelFeatureState.decorView.getChildCount() > 0) {
                        panelFeatureState.decorView.removeAllViews();
                    }
                    if (!this.initializePanelContent(panelFeatureState) || !panelFeatureState.hasPanelItems()) {
                        return;
                    }
                    ViewGroup$LayoutParams layoutParams = panelFeatureState.shownPanelView.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup$LayoutParams(-2, -2);
                    }
                    panelFeatureState.decorView.setBackgroundResource(panelFeatureState.background);
                    final ViewParent parent = panelFeatureState.shownPanelView.getParent();
                    if (parent != null && parent instanceof ViewGroup) {
                        ((ViewGroup)parent).removeView(panelFeatureState.shownPanelView);
                    }
                    panelFeatureState.decorView.addView(panelFeatureState.shownPanelView, layoutParams);
                    if (!panelFeatureState.shownPanelView.hasFocus()) {
                        panelFeatureState.shownPanelView.requestFocus();
                    }
                }
                else if (panelFeatureState.createdPanelView != null) {
                    final ViewGroup$LayoutParams layoutParams2 = panelFeatureState.createdPanelView.getLayoutParams();
                    if (layoutParams2 != null && layoutParams2.width == -1) {
                        n = -1;
                    }
                }
                panelFeatureState.isHandled = false;
                final WindowManager$LayoutParams windowManager$LayoutParams = new WindowManager$LayoutParams(n, -2, panelFeatureState.x, panelFeatureState.y, 1002, 8519680, -3);
                windowManager$LayoutParams.gravity = panelFeatureState.gravity;
                windowManager$LayoutParams.windowAnimations = panelFeatureState.windowAnimations;
                windowManager.addView((View)panelFeatureState.decorView, (ViewGroup$LayoutParams)windowManager$LayoutParams);
                panelFeatureState.isOpen = true;
            }
        }
    }
    
    private boolean performPanelShortcut(final PanelFeatureState panelFeatureState, final int n, final KeyEvent keyEvent, final int n2) {
        boolean performShortcut = false;
        if (keyEvent.isSystem()) {
            performShortcut = false;
        }
        else {
            Label_0063: {
                if (!panelFeatureState.isPrepared) {
                    final boolean preparePanel = this.preparePanel(panelFeatureState, keyEvent);
                    performShortcut = false;
                    if (!preparePanel) {
                        break Label_0063;
                    }
                }
                final MenuBuilder menu = panelFeatureState.menu;
                performShortcut = false;
                if (menu != null) {
                    performShortcut = panelFeatureState.menu.performShortcut(n, keyEvent, n2);
                }
            }
            if (performShortcut && (n2 & 0x1) == 0x0 && mDecorContentParent == null) {
                this.closePanel(panelFeatureState, true);
                return performShortcut;
            }
        }
        return performShortcut;
    }
    
    private boolean preparePanel(final PanelFeatureState mPreparedPanel, final KeyEvent keyEvent) {
        if (!this.isDestroyed()) {
            if (mPreparedPanel.isPrepared) {
                return true;
            }
            if (this.mPreparedPanel != null && this.mPreparedPanel != mPreparedPanel) {
                this.closePanel(this.mPreparedPanel, false);
            }
            final Window$Callback windowCallback = this.getWindowCallback();
            if (windowCallback != null) {
                mPreparedPanel.createdPanelView = windowCallback.onCreatePanelView(mPreparedPanel.featureId);
            }
            boolean b;
            if (mPreparedPanel.featureId == 0 || mPreparedPanel.featureId == 108) {
                b = true;
            }
            else {
                b = false;
            }
            if (b && mDecorContentParent != null) {
                mDecorContentParent.setMenuPrepared();
            }
            if (mPreparedPanel.createdPanelView == null && (!b || !(this.peekSupportActionBar() instanceof ToolbarActionBar))) {
                if (mPreparedPanel.menu == null || mPreparedPanel.refreshMenuContent) {
                    if (mPreparedPanel.menu == null && (!this.initializePanelMenu(mPreparedPanel) || mPreparedPanel.menu == null)) {
                        return false;
                    }
                    if (b && mDecorContentParent != null) {
                        if (mActionMenuPresenterCallback == null) {
                            mActionMenuPresenterCallback = new ActionMenuPresenterCallback(this);
                        }
                        mDecorContentParent.setMenu(mPreparedPanel.menu, (MenuPresenter.Callback)mActionMenuPresenterCallback);
                    }
                    mPreparedPanel.menu.stopDispatchingItemsChanged();
                    if (!windowCallback.onCreatePanelMenu(mPreparedPanel.featureId, (Menu)mPreparedPanel.menu)) {
                        mPreparedPanel.setMenu(null);
                        if (b && mDecorContentParent != null) {
                            mDecorContentParent.setMenu(null, mActionMenuPresenterCallback);
                            return false;
                        }
                        return false;
                    }
                    else {
                        mPreparedPanel.refreshMenuContent = false;
                    }
                }
                mPreparedPanel.menu.stopDispatchingItemsChanged();
                if (mPreparedPanel.frozenActionViewState != null) {
                    mPreparedPanel.menu.restoreActionViewStates(mPreparedPanel.frozenActionViewState);
                    mPreparedPanel.frozenActionViewState = null;
                }
                if (!windowCallback.onPreparePanel(0, mPreparedPanel.createdPanelView, (Menu)mPreparedPanel.menu)) {
                    if (b && mDecorContentParent != null) {
                        mDecorContentParent.setMenu(null, mActionMenuPresenterCallback);
                    }
                    mPreparedPanel.menu.startDispatchingItemsChanged();
                    return false;
                }
                int deviceId;
                if (keyEvent != null) {
                    deviceId = keyEvent.getDeviceId();
                }
                else {
                    deviceId = -1;
                }
                mPreparedPanel.qwertyMode = (KeyCharacterMap.load(deviceId).getKeyboardType() != 1);
                mPreparedPanel.menu.setQwertyMode(mPreparedPanel.qwertyMode);
                mPreparedPanel.menu.startDispatchingItemsChanged();
            }
            mPreparedPanel.isPrepared = true;
            mPreparedPanel.isHandled = false;
            this.mPreparedPanel = mPreparedPanel;
            return true;
        }
        return false;
    }
    
    private void reopenMenu(final MenuBuilder menuBuilder, final boolean b) {
        if (mDecorContentParent != null && mDecorContentParent.canShowOverflowMenu() && (!ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext)) || mDecorContentParent.isOverflowMenuShowPending())) {
            final Window$Callback windowCallback = this.getWindowCallback();
            if (!mDecorContentParent.isOverflowMenuShowing() || !b) {
                if (windowCallback != null && !this.isDestroyed()) {
                    if (mInvalidatePanelMenuPosted && (0x1 & mInvalidatePanelMenuFeatures) != 0x0) {
                        this.mWindow.getDecorView().removeCallbacks(mInvalidatePanelMenuRunnable);
                        mInvalidatePanelMenuRunnable.run();
                    }
                    final PanelFeatureState panelState = this.getPanelState(0, true);
                    if (panelState.menu != null && !panelState.refreshMenuContent && windowCallback.onPreparePanel(0, panelState.createdPanelView, (Menu)panelState.menu)) {
                        windowCallback.onMenuOpened(108, (Menu)panelState.menu);
                        mDecorContentParent.showOverflowMenu();
                    }
                }
            }
            else {
                mDecorContentParent.hideOverflowMenu();
                if (!this.isDestroyed()) {
                    windowCallback.onPanelClosed(108, (Menu)this.getPanelState(0, true).menu);
                }
            }
            return;
        }
        final PanelFeatureState panelState2 = this.getPanelState(0, true);
        panelState2.refreshDecorView = true;
        this.closePanel(panelState2, false);
        this.openPanel(panelState2, null);
    }
    
    private int sanitizeWindowFeatureId(int n) {
        if (n == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            n = 108;
        }
        else if (n == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
        return n;
    }
    
    private boolean shouldInheritContext(ViewParent parent) {
        if (parent == null) {
            return false;
        }
        final View decorView = this.mWindow.getDecorView();
        while (parent != null) {
            if (parent == decorView || !(parent instanceof View) || ViewCompat.isAttachedToWindow((View)parent)) {
                return false;
            }
            parent = parent.getParent();
        }
        return true;
    }
    
    private void throwFeatureRequestIfSubDecorInstalled() {
        if (mSubDecorInstalled) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }
    
    private int updateStatusGuard(int n) {
        final ActionBarContextView mActionModeView = this.mActionModeView;
        int n2 = 0;
        if (mActionModeView != null) {
            final boolean b = this.mActionModeView.getLayoutParams() instanceof ViewGroup$MarginLayoutParams;
            n2 = 0;
            if (b) {
                final ViewGroup$MarginLayoutParams layoutParams = (ViewGroup$MarginLayoutParams)this.mActionModeView.getLayoutParams();
                int n4;
                if (this.mActionModeView.isShown()) {
                    if (mTempRect1 == null) {
                        mTempRect1 = new Rect();
                        mTempRect2 = new Rect();
                    }
                    final Rect mTempRect1 = this.mTempRect1;
                    final Rect mTempRect2 = this.mTempRect2;
                    mTempRect1.set(0, n, 0, 0);
                    ViewUtils.computeFitSystemWindows((View)mSubDecor, mTempRect1, mTempRect2);
                    int n3;
                    if (mTempRect2.top == 0) {
                        n3 = n;
                    }
                    else {
                        n3 = 0;
                    }
                    final int topMargin = layoutParams.topMargin;
                    n4 = 0;
                    if (topMargin != n3) {
                        n4 = 1;
                        layoutParams.topMargin = n;
                        if (mStatusGuard == null) {
                            (mStatusGuard = new View(this.mContext)).setBackgroundColor(this.mContext.getResources().getColor(R.color.abc_input_method_navigation_guard));
                            mSubDecor.addView(mStatusGuard, -1, new ViewGroup$LayoutParams(-1, n));
                        }
                        else {
                            final ViewGroup$LayoutParams layoutParams2 = mStatusGuard.getLayoutParams();
                            if (layoutParams2.height != n) {
                                layoutParams2.height = n;
                                mStatusGuard.setLayoutParams(layoutParams2);
                            }
                        }
                    }
                    if (mStatusGuard != null) {
                        n2 = 1;
                    }
                    else {
                        n2 = 0;
                    }
                    if (!this.mOverlayActionMode && n2 != 0) {
                        n = 0;
                    }
                }
                else {
                    final int topMargin2 = layoutParams.topMargin;
                    n4 = 0;
                    n2 = 0;
                    if (topMargin2 != 0) {
                        n4 = 1;
                        layoutParams.topMargin = 0;
                        n2 = 0;
                    }
                }
                if (n4 != 0) {
                    this.mActionModeView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                }
            }
        }
        if (mStatusGuard != null) {
            final View mStatusGuard = this.mStatusGuard;
            int visibility = 0;
            if (n2 == 0) {
                visibility = 8;
            }
            mStatusGuard.setVisibility(visibility);
        }
        return n;
    }
    
    @Override
    public void addContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        this.ensureSubDecor();
        ((ViewGroup)mSubDecor.findViewById(16908290)).addView(view, viewGroup$LayoutParams);
        this.mOriginalWindowCallback.onContentChanged();
    }
    
    View callActivityOnCreateView(final View view, final String s, final Context context, final AttributeSet set) {
        if (this.mOriginalWindowCallback instanceof LayoutInflater$Factory) {
            final View onCreateView = ((LayoutInflater$Factory)this.mOriginalWindowCallback).onCreateView(s, context, set);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }
    
    @Override
    public View createView(final View view, final String s, @NonNull final Context context, @NonNull final AttributeSet set) {
        final boolean b = Build$VERSION.SDK_INT < 21;
        if (mAppCompatViewInflater == null) {
            mAppCompatViewInflater = new AppCompatViewInflater();
        }
        return mAppCompatViewInflater.createView(view, s, context, set, b && this.shouldInheritContext((ViewParent)view), b, true, b);
    }
    
    @Override
    boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && this.mOriginalWindowCallback.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        final int keyCode = keyEvent.getKeyCode();
        int n;
        if (keyEvent.getAction() == 0) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n != 0) {
            return this.onKeyDown(keyCode, keyEvent);
        }
        return this.onKeyUp(keyCode, keyEvent);
    }
    
    @Nullable
    @Override
    public View findViewById(@IdRes final int n) {
        this.ensureSubDecor();
        return this.mWindow.findViewById(n);
    }
    
    ViewGroup getSubDecor() {
        return mSubDecor;
    }
    
    @Override
    public boolean hasWindowFeature(final int n) {
        final int sanitizeWindowFeatureId = this.sanitizeWindowFeatureId(n);
        switch (sanitizeWindowFeatureId) {
            default:
                return this.mWindow.hasFeature(sanitizeWindowFeatureId);
            case 108:
                return this.mHasActionBar;
            case 109:
                return this.mOverlayActionBar;
            case 10:
                return this.mOverlayActionMode;
            case 2:
                return mFeatureProgress;
            case 5:
                return mFeatureIndeterminateProgress;
            case 1:
                return this.mWindowNoTitle;
        }
    }
    
    public void initWindowDecorActionBar() {
        this.ensureSubDecor();
        if (this.mHasActionBar && this.mActionBar == null) {
            if (this.mOriginalWindowCallback instanceof Activity) {
                this.mActionBar = new WindowDecorActionBar((Activity)this.mOriginalWindowCallback, this.mOverlayActionBar);
            }
            else if (this.mOriginalWindowCallback instanceof Dialog) {
                this.mActionBar = new WindowDecorActionBar((Dialog)this.mOriginalWindowCallback);
            }
            if (this.mActionBar != null) {
                this.mActionBar.setDefaultDisplayHomeAsUpEnabled(mEnableDefaultActionBarUp);
            }
        }
    }
    
    @Override
    public void installViewFactory() {
        final LayoutInflater from = LayoutInflater.from(this.mContext);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.setFactory(from, this);
        }
        else if (!(LayoutInflaterCompat.getFactory(from) instanceof AppCompatDelegateImplV7)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }
    
    @Override
    public void invalidateOptionsMenu() {
        final ActionBar supportActionBar = this.getSupportActionBar();
        if (supportActionBar != null && supportActionBar.invalidateOptionsMenu()) {
            return;
        }
        this.invalidatePanelMenu(0);
    }
    
    boolean onBackPressed() {
        if (mActionMode != null) {
            mActionMode.finish();
        }
        else {
            final ActionBar supportActionBar = this.getSupportActionBar();
            if (supportActionBar == null || !supportActionBar.collapseActionView()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void onConfigurationChanged(final Configuration configuration) {
        if (this.mHasActionBar && mSubDecorInstalled) {
            final ActionBar supportActionBar = this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.onConfigurationChanged(configuration);
            }
        }
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        if (this.mOriginalWindowCallback instanceof Activity && NavUtils.getParentActivityName((Activity)this.mOriginalWindowCallback) != null) {
            final ActionBar peekSupportActionBar = this.peekSupportActionBar();
            if (peekSupportActionBar != null) {
                peekSupportActionBar.setDefaultDisplayHomeAsUpEnabled(true);
                return;
            }
            mEnableDefaultActionBarUp = true;
        }
    }
    
    @Override
    public final View onCreateView(final View view, final String s, final Context context, final AttributeSet set) {
        final View callActivityOnCreateView = this.callActivityOnCreateView(view, s, context, set);
        if (callActivityOnCreateView != null) {
            return callActivityOnCreateView;
        }
        return this.createView(view, s, context, set);
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.mActionBar != null) {
            this.mActionBar.onDestroy();
            this.mActionBar = null;
        }
    }
    
    boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        boolean mLongPressBackDown = true;
        switch (n) {
            case 82:
                this.onKeyDownPanel(0, keyEvent);
                return mLongPressBackDown;
            case 4:
                if ((0x80 & keyEvent.getFlags()) == 0x0) {
                    mLongPressBackDown = false;
                }
                this.mLongPressBackDown = mLongPressBackDown;
                break;
        }
        if (Build$VERSION.SDK_INT < 11) {
            this.onKeyShortcut(n, keyEvent);
        }
        return false;
    }
    
    @Override
    boolean onKeyShortcut(final int n, final KeyEvent keyEvent) {
        final ActionBar supportActionBar = this.getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.onKeyShortcut(n, keyEvent)) {
            if (mPreparedPanel == null || !this.performPanelShortcut(mPreparedPanel, keyEvent.getKeyCode(), keyEvent, 1)) {
                if (mPreparedPanel == null) {
                    final PanelFeatureState panelState = this.getPanelState(0, true);
                    this.preparePanel(panelState, keyEvent);
                    final boolean performPanelShortcut = this.performPanelShortcut(panelState, keyEvent.getKeyCode(), keyEvent, 1);
                    panelState.isPrepared = false;
                    if (performPanelShortcut) {
                        return true;
                    }
                }
                return false;
            }
            if (mPreparedPanel != null) {
                return mPreparedPanel.isHandled = true;
            }
        }
        return true;
    }
    
    boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        boolean b = true;
        switch (n) {
            case 82:
                this.onKeyUpPanel(0, keyEvent);
                return b;
            case 4: {
                final boolean mLongPressBackDown = this.mLongPressBackDown;
                this.mLongPressBackDown = false;
                final PanelFeatureState panelState = this.getPanelState(0, false);
                if (panelState != null && panelState.isOpen) {
                    if (!mLongPressBackDown) {
                        this.closePanel(panelState, b);
                        return b;
                    }
                    return b;
                }
                else {
                    if (this.onBackPressed()) {
                        return b;
                    }
                    break;
                }
                break;
            }
        }
        b = false;
        return b;
    }
    
    @Override
    public boolean onMenuItemSelected(final MenuBuilder menuBuilder, final MenuItem menuItem) {
        final Window$Callback windowCallback = this.getWindowCallback();
        if (windowCallback != null && !this.isDestroyed()) {
            final PanelFeatureState menuPanel = this.findMenuPanel((Menu)menuBuilder.getRootMenu());
            if (menuPanel != null) {
                return windowCallback.onMenuItemSelected(menuPanel.featureId, menuItem);
            }
        }
        return false;
    }
    
    @Override
    public void onMenuModeChange(final MenuBuilder menuBuilder) {
        this.reopenMenu(menuBuilder, true);
    }
    
    @Override
    boolean onMenuOpened(final int n, final Menu menu) {
        if (n == 108) {
            final ActionBar supportActionBar = this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.dispatchMenuVisibilityChanged(true);
            }
            return true;
        }
        return false;
    }
    
    @Override
    void onPanelClosed(final int n, final Menu menu) {
        if (n == 108) {
            final ActionBar supportActionBar = this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.dispatchMenuVisibilityChanged(false);
            }
        }
        else if (n == 0) {
            final PanelFeatureState panelState = this.getPanelState(n, true);
            if (panelState.isOpen) {
                this.closePanel(panelState, false);
            }
        }
    }
    
    @Override
    public void onPostCreate(final Bundle bundle) {
        this.ensureSubDecor();
    }
    
    @Override
    public void onPostResume() {
        final ActionBar supportActionBar = this.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(true);
        }
    }
    
    @Override
    public void onStop() {
        final ActionBar supportActionBar = this.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
        }
    }
    
    void onSubDecorInstalled(final ViewGroup viewGroup) {
    }
    
    @Override
    void onTitleChanged(final CharSequence text) {
        if (mDecorContentParent != null) {
            mDecorContentParent.setWindowTitle(text);
        }
        else {
            if (this.peekSupportActionBar() != null) {
                this.peekSupportActionBar().setWindowTitle(text);
                return;
            }
            if (mTitleView != null) {
                mTitleView.setText(text);
            }
        }
    }
    
    @Override
    public boolean requestWindowFeature(final int n) {
        final int sanitizeWindowFeatureId = this.sanitizeWindowFeatureId(n);
        if (this.mWindowNoTitle && sanitizeWindowFeatureId == 108) {
            return false;
        }
        if (this.mHasActionBar && sanitizeWindowFeatureId == 1) {
            this.mHasActionBar = false;
        }
        switch (sanitizeWindowFeatureId) {
            default:
                return this.mWindow.requestFeature(sanitizeWindowFeatureId);
            case 108:
                this.throwFeatureRequestIfSubDecorInstalled();
                return this.mHasActionBar = true;
            case 109:
                this.throwFeatureRequestIfSubDecorInstalled();
                return this.mOverlayActionBar = true;
            case 10:
                this.throwFeatureRequestIfSubDecorInstalled();
                return this.mOverlayActionMode = true;
            case 2:
                this.throwFeatureRequestIfSubDecorInstalled();
                return mFeatureProgress = true;
            case 5:
                this.throwFeatureRequestIfSubDecorInstalled();
                return mFeatureIndeterminateProgress = true;
            case 1:
                this.throwFeatureRequestIfSubDecorInstalled();
                return this.mWindowNoTitle = true;
        }
    }
    
    @Override
    public void setContentView(final int n) {
        this.ensureSubDecor();
        final ViewGroup viewGroup = (ViewGroup)mSubDecor.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(n, viewGroup);
        this.mOriginalWindowCallback.onContentChanged();
    }
    
    @Override
    public void setContentView(final View view) {
        this.ensureSubDecor();
        final ViewGroup viewGroup = (ViewGroup)mSubDecor.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.mOriginalWindowCallback.onContentChanged();
    }
    
    @Override
    public void setContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        this.ensureSubDecor();
        final ViewGroup viewGroup = (ViewGroup)mSubDecor.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, viewGroup$LayoutParams);
        this.mOriginalWindowCallback.onContentChanged();
    }
    
    @Override
    public void setSupportActionBar(final Toolbar toolbar) {
        if (!(this.mOriginalWindowCallback instanceof Activity)) {
            return;
        }
        final ActionBar supportActionBar = this.getSupportActionBar();
        if (supportActionBar instanceof WindowDecorActionBar) {
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
        this.mMenuInflater = null;
        if (supportActionBar != null) {
            supportActionBar.onDestroy();
        }
        if (toolbar != null) {
            final ToolbarActionBar mActionBar = new ToolbarActionBar(toolbar, ((Activity)this.mContext).getTitle(), this.mAppCompatWindowCallback);
            this.mActionBar = mActionBar;
            this.mWindow.setCallback(mActionBar.getWrappedWindowCallback());
        }
        else {
            this.mActionBar = null;
            this.mWindow.setCallback(this.mAppCompatWindowCallback);
        }
        this.invalidateOptionsMenu();
    }
    
    @Override
    public ActionMode startSupportActionMode(final ActionMode.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (mActionMode != null) {
            mActionMode.finish();
        }
        final ActionModeCallbackWrapperV7 actionModeCallbackWrapperV7 = new ActionModeCallbackWrapperV7(callback);
        final ActionBar supportActionBar = this.getSupportActionBar();
        if (supportActionBar != null) {
            mActionMode = supportActionBar.startActionMode(actionModeCallbackWrapperV7);
            if (mActionMode != null && this.mAppCompatCallback != null) {
                this.mAppCompatCallback.onSupportActionModeStarted(mActionMode);
            }
        }
        if (mActionMode == null) {
            mActionMode = this.startSupportActionModeFromWindow(actionModeCallbackWrapperV7);
        }
        return mActionMode;
    }
    
    @Override
    ActionMode startSupportActionModeFromWindow(final ActionMode.Callback callback) {
        this.endOnGoingFadeAnimation();
        if (mActionMode != null) {
            mActionMode.finish();
        }
        final ActionModeCallbackWrapperV7 actionModeCallbackWrapperV7 = new ActionModeCallbackWrapperV7(callback);
        final AppCompatCallback mAppCompatCallback = this.mAppCompatCallback;
        ActionMode onWindowStartingSupportActionMode = null;
        while (true) {
            if (mAppCompatCallback == null) {
                break Label_0070;
            }
            final boolean destroyed = this.isDestroyed();
            onWindowStartingSupportActionMode = null;
            if (destroyed) {
                break Label_0070;
            }
            try {
                onWindowStartingSupportActionMode = this.mAppCompatCallback.onWindowStartingSupportActionMode(actionModeCallbackWrapperV7);
                if (onWindowStartingSupportActionMode != null) {
                    mActionMode = onWindowStartingSupportActionMode;
                }
                else {
                    if (mActionModeView == null) {
                        if (this.mIsFloating) {
                            final TypedValue typedValue = new TypedValue();
                            final Resources$Theme theme = this.mContext.getTheme();
                            theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                            Object mContext;
                            if (typedValue.resourceId != 0) {
                                final Resources$Theme theme2 = this.mContext.getResources().newTheme();
                                theme2.setTo(theme);
                                theme2.applyStyle(typedValue.resourceId, true);
                                mContext = new ContextThemeWrapper(this.mContext, 0);
                                ((Context)mContext).getTheme().setTo(theme2);
                            }
                            else {
                                mContext = this.mContext;
                            }
                            mActionModeView = new ActionBarContextView((Context)mContext);
                            PopupWindowCompat.setWindowLayoutType(mActionModePopup = new PopupWindow((Context)mContext, (AttributeSet)null, R.attr.actionModePopupWindowStyle), 2);
                            mActionModePopup.setContentView((View)mActionModeView);
                            mActionModePopup.setWidth(-1);
                            ((Context)mContext).getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
                            mActionModeView.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, ((Context)mContext).getResources().getDisplayMetrics()));
                            mActionModePopup.setHeight(-2);
                            mShowActionModePopup = new Runnable() {
                                final /* synthetic */ AppCompatDelegateImplV7 this$0;
                                
                                AppCompatDelegateImplV7$5() {
                                    this$0 = this$0;
                                    super();
                                }
                                
                                @Override
                                public void run() {
                                    mActionModePopup.showAtLocation((View)mActionModeView, 55, 0, 0);
                                    this$0.endOnGoingFadeAnimation();
                                    ViewCompat.setAlpha((View)mActionModeView, 0.0f);
                                    (mFadeAnim = ViewCompat.animate((View)mActionModeView).alpha(1.0f)).setListener(new ViewPropertyAnimatorListenerAdapter() {
                                        final /* synthetic */ AppCompatDelegateImplV7$5 this$1;
                                        
                                        AppCompatDelegateImplV7$5$1() {
                                            this$1 = this$1;
                                            super();
                                        }
                                        
                                        @Override
                                        public void onAnimationEnd(final View view) {
                                            ViewCompat.setAlpha((View)mActionModeView, 1.0f);
                                            mFadeAnim.setListener(null);
                                            mFadeAnim = null;
                                        }
                                        
                                        @Override
                                        public void onAnimationStart(final View view) {
                                            mActionModeView.setVisibility(0);
                                        }
                                    });
                                }
                            };
                        }
                        else {
                            final ViewStubCompat viewStubCompat = (ViewStubCompat)mSubDecor.findViewById(R.id.action_mode_bar_stub);
                            if (viewStubCompat != null) {
                                viewStubCompat.setLayoutInflater(LayoutInflater.from(this.getActionBarThemedContext()));
                                mActionModeView = (ActionBarContextView)viewStubCompat.inflate();
                            }
                        }
                    }
                    if (mActionModeView != null) {
                        this.endOnGoingFadeAnimation();
                        mActionModeView.killMode();
                        final StandaloneActionMode mActionMode = new StandaloneActionMode(mActionModeView.getContext(), mActionModeView, actionModeCallbackWrapperV7, mActionModePopup == null);
                        if (callback.onCreateActionMode(mActionMode, mActionMode.getMenu())) {
                            mActionMode.invalidate();
                            mActionModeView.initForMode(mActionMode);
                            this.mActionMode = mActionMode;
                            ViewCompat.setAlpha((View)mActionModeView, 0.0f);
                            (mFadeAnim = ViewCompat.animate((View)mActionModeView).alpha(1.0f)).setListener(new ViewPropertyAnimatorListenerAdapter() {
                                final /* synthetic */ AppCompatDelegateImplV7 this$0;
                                
                                AppCompatDelegateImplV7$6() {
                                    this$0 = this$0;
                                    super();
                                }
                                
                                @Override
                                public void onAnimationEnd(final View view) {
                                    ViewCompat.setAlpha((View)mActionModeView, 1.0f);
                                    mFadeAnim.setListener(null);
                                    mFadeAnim = null;
                                }
                                
                                @Override
                                public void onAnimationStart(final View view) {
                                    mActionModeView.setVisibility(0);
                                    mActionModeView.sendAccessibilityEvent(32);
                                    if (mActionModeView.getParent() != null) {
                                        ViewCompat.requestApplyInsets((View)mActionModeView.getParent());
                                    }
                                }
                            });
                            if (mActionModePopup != null) {
                                this.mWindow.getDecorView().post(mShowActionModePopup);
                            }
                        }
                        else {
                            this.mActionMode = null;
                        }
                    }
                }
                if (mActionMode != null && this.mAppCompatCallback != null) {
                    this.mAppCompatCallback.onSupportActionModeStarted(mActionMode);
                }
                return mActionMode;
            }
            catch (AbstractMethodError abstractMethodError) {
                onWindowStartingSupportActionMode = null;
                continue;
            }
            break;
        }
    }
}
