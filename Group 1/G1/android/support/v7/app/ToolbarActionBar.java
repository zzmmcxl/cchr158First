package android.support.v7.app;

import android.support.v7.view.WindowCallbackWrapper;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.SpinnerAdapter;
import android.view.ViewGroup$LayoutParams;
import android.view.LayoutInflater;
import android.support.annotation.Nullable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.content.res.Configuration;
import android.support.v4.view.ViewCompat;
import android.content.res.Resources$Theme;
import android.support.v7.view.menu.MenuPresenter;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.support.v7.appcompat.R;
import android.util.TypedValue;
import android.support.v7.view.menu.MenuBuilder;
import android.view.View;
import android.view.Menu;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.view.MenuItem;
import android.view.Window$Callback;
import java.util.ArrayList;
import android.support.v7.widget.Toolbar;
import android.support.v7.view.menu.ListMenuPresenter;
import android.support.v7.widget.DecorToolbar;

class ToolbarActionBar extends ActionBar
{
    private DecorToolbar mDecorToolbar;
    private boolean mLastMenuVisibility;
    private ListMenuPresenter mListMenuPresenter;
    private boolean mMenuCallbackSet;
    private final Toolbar.OnMenuItemClickListener mMenuClicker;
    private final Runnable mMenuInvalidator;
    private ArrayList<OnMenuVisibilityListener> mMenuVisibilityListeners;
    private boolean mToolbarMenuPrepared;
    private Window$Callback mWindowCallback;
    
    public ToolbarActionBar(final Toolbar toolbar, final CharSequence windowTitle, final Window$Callback window$Callback) {
        super();
        mMenuVisibilityListeners = new ArrayList<OnMenuVisibilityListener>();
        mMenuInvalidator = new Runnable() {
            final /* synthetic */ ToolbarActionBar this$0;
            
            ToolbarActionBar$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                this$0.populateOptionsMenu();
            }
        };
        mMenuClicker = new Toolbar.OnMenuItemClickListener() {
            final /* synthetic */ ToolbarActionBar this$0;
            
            ToolbarActionBar$2() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public boolean onMenuItemClick(final MenuItem menuItem) {
                return mWindowCallback.onMenuItemSelected(0, menuItem);
            }
        };
        mDecorToolbar = new ToolbarWidgetWrapper(toolbar, false);
        mWindowCallback = (Window$Callback)new ToolbarCallbackWrapper(window$Callback);
        mDecorToolbar.setWindowCallback(mWindowCallback);
        toolbar.setOnMenuItemClickListener(mMenuClicker);
        mDecorToolbar.setWindowTitle(windowTitle);
    }
    
    static /* synthetic */ Window$Callback access$000(final ToolbarActionBar toolbarActionBar) {
        return toolbarActionBar.mWindowCallback;
    }
    
    static /* synthetic */ boolean access$200(final ToolbarActionBar toolbarActionBar) {
        return toolbarActionBar.mToolbarMenuPrepared;
    }
    
    static /* synthetic */ boolean access$202(final ToolbarActionBar toolbarActionBar, final boolean mToolbarMenuPrepared) {
        return toolbarActionBar.mToolbarMenuPrepared = mToolbarMenuPrepared;
    }
    
    static /* synthetic */ DecorToolbar access$300(final ToolbarActionBar toolbarActionBar) {
        return toolbarActionBar.mDecorToolbar;
    }
    
    static /* synthetic */ View access$400(final ToolbarActionBar toolbarActionBar, final Menu menu) {
        return toolbarActionBar.getListMenuView(menu);
    }
    
    private void ensureListMenuPresenter(final Menu menu) {
        if (mListMenuPresenter == null && menu instanceof MenuBuilder) {
            final MenuBuilder menuBuilder = (MenuBuilder)menu;
            final Context context = mDecorToolbar.getContext();
            final TypedValue typedValue = new TypedValue();
            final Resources$Theme theme = context.getResources().newTheme();
            theme.setTo(context.getTheme());
            theme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                theme.applyStyle(typedValue.resourceId, true);
            }
            theme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                theme.applyStyle(typedValue.resourceId, true);
            }
            else {
                theme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
            }
            final ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
            ((Context)contextThemeWrapper).getTheme().setTo(theme);
            (mListMenuPresenter = new ListMenuPresenter((Context)contextThemeWrapper, R.layout.abc_list_menu_item_layout)).setCallback(new PanelMenuPresenterCallback(this));
            menuBuilder.addMenuPresenter(mListMenuPresenter);
        }
    }
    
    private View getListMenuView(final Menu menu) {
        this.ensureListMenuPresenter(menu);
        if (menu != null && mListMenuPresenter != null && mListMenuPresenter.getAdapter().getCount() > 0) {
            return (View)mListMenuPresenter.getMenuView(mDecorToolbar.getViewGroup());
        }
        return null;
    }
    
    private Menu getMenu() {
        if (!mMenuCallbackSet) {
            mDecorToolbar.setMenuCallbacks(new ActionMenuPresenterCallback(this), new MenuBuilderCallback(this));
            mMenuCallbackSet = true;
        }
        return mDecorToolbar.getMenu();
    }
    
    @Override
    public void addOnMenuVisibilityListener(final OnMenuVisibilityListener onMenuVisibilityListener) {
        mMenuVisibilityListeners.add(onMenuVisibilityListener);
    }
    
    @Override
    public void addTab(final Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }
    
    @Override
    public void addTab(final Tab tab, final int n) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }
    
    @Override
    public void addTab(final Tab tab, final int n, final boolean b) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }
    
    @Override
    public void addTab(final Tab tab, final boolean b) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }
    
    @Override
    public boolean collapseActionView() {
        if (mDecorToolbar.hasExpandedActionView()) {
            mDecorToolbar.collapseActionView();
            return true;
        }
        return false;
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
        return ViewCompat.getElevation((View)mDecorToolbar.getViewGroup());
    }
    
    @Override
    public int getHeight() {
        return mDecorToolbar.getHeight();
    }
    
    @Override
    public int getNavigationItemCount() {
        return 0;
    }
    
    @Override
    public int getNavigationMode() {
        return 0;
    }
    
    @Override
    public int getSelectedNavigationIndex() {
        return -1;
    }
    
    @Override
    public Tab getSelectedTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }
    
    @Override
    public CharSequence getSubtitle() {
        return mDecorToolbar.getSubtitle();
    }
    
    @Override
    public Tab getTabAt(final int n) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }
    
    @Override
    public int getTabCount() {
        return 0;
    }
    
    @Override
    public Context getThemedContext() {
        return mDecorToolbar.getContext();
    }
    
    @Override
    public CharSequence getTitle() {
        return mDecorToolbar.getTitle();
    }
    
    public Window$Callback getWrappedWindowCallback() {
        return mWindowCallback;
    }
    
    @Override
    public void hide() {
        mDecorToolbar.setVisibility(8);
    }
    
    @Override
    public boolean invalidateOptionsMenu() {
        mDecorToolbar.getViewGroup().removeCallbacks(mMenuInvalidator);
        ViewCompat.postOnAnimation((View)mDecorToolbar.getViewGroup(), mMenuInvalidator);
        return true;
    }
    
    @Override
    public boolean isShowing() {
        return mDecorToolbar.getVisibility() == 0;
    }
    
    @Override
    public boolean isTitleTruncated() {
        return super.isTitleTruncated();
    }
    
    @Override
    public Tab newTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }
    
    @Override
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
    
    @Override
    void onDestroy() {
        mDecorToolbar.getViewGroup().removeCallbacks(mMenuInvalidator);
    }
    
    @Override
    public boolean onKeyShortcut(final int n, final KeyEvent keyEvent) {
        final Menu menu = this.getMenu();
        if (menu != null) {
            int deviceId;
            if (keyEvent != null) {
                deviceId = keyEvent.getDeviceId();
            }
            else {
                deviceId = -1;
            }
            menu.setQwertyMode(KeyCharacterMap.load(deviceId).getKeyboardType() != 1);
            menu.performShortcut(n, keyEvent, 0);
        }
        return true;
    }
    
    @Override
    public boolean onMenuKeyEvent(final KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            this.openOptionsMenu();
        }
        return true;
    }
    
    @Override
    public boolean openOptionsMenu() {
        return mDecorToolbar.showOverflowMenu();
    }
    
    void populateOptionsMenu() {
        final Menu menu = this.getMenu();
        final boolean b = menu instanceof MenuBuilder;
        MenuBuilder menuBuilder = null;
        if (b) {
            menuBuilder = (MenuBuilder)menu;
        }
        if (menuBuilder != null) {
            menuBuilder.stopDispatchingItemsChanged();
        }
        try {
            menu.clear();
            if (!mWindowCallback.onCreatePanelMenu(0, menu) || !mWindowCallback.onPreparePanel(0, (View)null, menu)) {
                menu.clear();
            }
        }
        finally {
            if (menuBuilder != null) {
                menuBuilder.startDispatchingItemsChanged();
            }
        }
    }
    
    @Override
    public void removeAllTabs() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }
    
    @Override
    public void removeOnMenuVisibilityListener(final OnMenuVisibilityListener onMenuVisibilityListener) {
        mMenuVisibilityListeners.remove(onMenuVisibilityListener);
    }
    
    @Override
    public void removeTab(final Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }
    
    @Override
    public void removeTabAt(final int n) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
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
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }
    
    @Override
    public void setBackgroundDrawable(@Nullable final Drawable backgroundDrawable) {
        mDecorToolbar.setBackgroundDrawable(backgroundDrawable);
    }
    
    @Override
    public void setCustomView(final int n) {
        this.setCustomView(LayoutInflater.from(mDecorToolbar.getContext()).inflate(n, mDecorToolbar.getViewGroup(), false));
    }
    
    @Override
    public void setCustomView(final View view) {
        this.setCustomView(view, new LayoutParams(-2, -2));
    }
    
    @Override
    public void setCustomView(final View customView, final LayoutParams layoutParams) {
        if (customView != null) {
            customView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        }
        mDecorToolbar.setCustomView(customView);
    }
    
    @Override
    public void setDefaultDisplayHomeAsUpEnabled(final boolean b) {
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
    public void setDisplayOptions(final int n) {
        this.setDisplayOptions(n, -1);
    }
    
    @Override
    public void setDisplayOptions(final int n, final int n2) {
        mDecorToolbar.setDisplayOptions((n & n2) | (mDecorToolbar.getDisplayOptions() & ~n2));
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
        ViewCompat.setElevation((View)mDecorToolbar.getViewGroup(), n);
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
    public void setHomeButtonEnabled(final boolean b) {
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
        if (navigationMode == 2) {
            throw new IllegalArgumentException("Tabs not supported in this configuration");
        }
        mDecorToolbar.setNavigationMode(navigationMode);
    }
    
    @Override
    public void setSelectedNavigationItem(final int dropdownSelectedPosition) {
        switch (mDecorToolbar.getNavigationMode()) {
            default:
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
            case 1:
                mDecorToolbar.setDropdownSelectedPosition(dropdownSelectedPosition);
        }
    }
    
    @Override
    public void setShowHideAnimationEnabled(final boolean b) {
    }
    
    @Override
    public void setSplitBackgroundDrawable(final Drawable drawable) {
    }
    
    @Override
    public void setStackedBackgroundDrawable(final Drawable drawable) {
    }
    
    @Override
    public void setSubtitle(final int n) {
        final DecorToolbar mDecorToolbar = this.mDecorToolbar;
        CharSequence text;
        if (n != 0) {
            text = this.mDecorToolbar.getContext().getText(n);
        }
        else {
            text = null;
        }
        mDecorToolbar.setSubtitle(text);
    }
    
    @Override
    public void setSubtitle(final CharSequence subtitle) {
        mDecorToolbar.setSubtitle(subtitle);
    }
    
    @Override
    public void setTitle(final int n) {
        final DecorToolbar mDecorToolbar = this.mDecorToolbar;
        CharSequence text;
        if (n != 0) {
            text = this.mDecorToolbar.getContext().getText(n);
        }
        else {
            text = null;
        }
        mDecorToolbar.setTitle(text);
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
        mDecorToolbar.setVisibility(0);
    }
}
