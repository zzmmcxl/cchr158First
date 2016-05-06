package android.support.v7.view.menu;

import android.view.MenuItem$OnActionExpandListener;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.view.LayoutInflater;
import android.content.ActivityNotFoundException;
import android.util.Log;
import android.os.Build$VERSION;
import android.view.SubMenu;
import android.view.ViewDebug$CapturedViewProperty;
import android.support.v7.widget.AppCompatDrawableManager;
import android.view.MenuItem;
import android.support.v4.view.MenuItemCompat;
import android.view.ContextMenu$ContextMenuInfo;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.MenuItem$OnMenuItemClickListener;
import android.view.View;
import android.support.v4.view.ActionProvider;
import android.support.v4.internal.view.SupportMenuItem;

public final class MenuItemImpl implements SupportMenuItem
{
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private static final int IS_ACTION = 32;
    static final int NO_ICON = 0;
    private static final int SHOW_AS_ACTION_MASK = 3;
    private static final String TAG = "MenuItemImpl";
    private static String sDeleteShortcutLabel;
    private static String sEnterShortcutLabel;
    private static String sPrependShortcutLabel;
    private static String sSpaceShortcutLabel;
    private ActionProvider mActionProvider;
    private View mActionView;
    private final int mCategoryOrder;
    private MenuItem$OnMenuItemClickListener mClickListener;
    private int mFlags;
    private final int mGroup;
    private Drawable mIconDrawable;
    private int mIconResId;
    private final int mId;
    private Intent mIntent;
    private boolean mIsActionViewExpanded;
    private Runnable mItemCallback;
    private MenuBuilder mMenu;
    private ContextMenu$ContextMenuInfo mMenuInfo;
    private MenuItemCompat.OnActionExpandListener mOnActionExpandListener;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private char mShortcutNumericChar;
    private int mShowAsAction;
    private SubMenuBuilder mSubMenu;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    
    MenuItemImpl(final MenuBuilder mMenu, final int mGroup, final int mId, final int mCategoryOrder, final int mOrdering, final CharSequence mTitle, final int mShowAsAction) {
        super();
        mIconResId = 0;
        mFlags = 16;
        mShowAsAction = 0;
        mIsActionViewExpanded = false;
        mMenu = mMenu;
        mId = mId;
        mGroup = mGroup;
        mCategoryOrder = mCategoryOrder;
        mOrdering = mOrdering;
        mTitle = mTitle;
        mShowAsAction = mShowAsAction;
    }
    
    static /* synthetic */ MenuBuilder access$000(final MenuItemImpl menuItemImpl) {
        return menuItemImpl.mMenu;
    }
    
    public void actionFormatChanged() {
        mMenu.onItemActionRequestChanged(this);
    }
    
    @Override
    public boolean collapseActionView() {
        if ((0x8 & mShowAsAction) != 0x0) {
            if (mActionView == null) {
                return true;
            }
            if (mOnActionExpandListener == null || mOnActionExpandListener.onMenuItemActionCollapse((MenuItem)this)) {
                return mMenu.collapseItemActionView(this);
            }
        }
        return false;
    }
    
    @Override
    public boolean expandActionView() {
        return this.hasCollapsibleActionView() && (mOnActionExpandListener == null || mOnActionExpandListener.onMenuItemActionExpand((MenuItem)this)) && mMenu.expandItemActionView(this);
    }
    
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }
    
    @Override
    public View getActionView() {
        if (mActionView != null) {
            return mActionView;
        }
        if (mActionProvider != null) {
            return mActionView = mActionProvider.onCreateActionView((MenuItem)this);
        }
        return null;
    }
    
    public char getAlphabeticShortcut() {
        return mShortcutAlphabeticChar;
    }
    
    Runnable getCallback() {
        return mItemCallback;
    }
    
    public int getGroupId() {
        return mGroup;
    }
    
    public Drawable getIcon() {
        if (mIconDrawable != null) {
            return mIconDrawable;
        }
        if (mIconResId != 0) {
            final Drawable drawable = AppCompatDrawableManager.get().getDrawable(mMenu.getContext(), mIconResId);
            mIconResId = 0;
            return mIconDrawable = drawable;
        }
        return null;
    }
    
    public Intent getIntent() {
        return mIntent;
    }
    
    @ViewDebug$CapturedViewProperty
    public int getItemId() {
        return mId;
    }
    
    public ContextMenu$ContextMenuInfo getMenuInfo() {
        return mMenuInfo;
    }
    
    public char getNumericShortcut() {
        return mShortcutNumericChar;
    }
    
    public int getOrder() {
        return mCategoryOrder;
    }
    
    public int getOrdering() {
        return mOrdering;
    }
    
    char getShortcut() {
        if (mMenu.isQwertyMode()) {
            return mShortcutAlphabeticChar;
        }
        return mShortcutNumericChar;
    }
    
    String getShortcutLabel() {
        final char shortcut = this.getShortcut();
        if (shortcut == '\0') {
            return "";
        }
        final StringBuilder sb = new StringBuilder(sPrependShortcutLabel);
        switch (shortcut) {
            default:
                sb.append(shortcut);
                break;
            case 10:
                sb.append(sEnterShortcutLabel);
                break;
            case 8:
                sb.append(sDeleteShortcutLabel);
                break;
            case 32:
                sb.append(sSpaceShortcutLabel);
                break;
        }
        return sb.toString();
    }
    
    public SubMenu getSubMenu() {
        return (SubMenu)mSubMenu;
    }
    
    @Override
    public ActionProvider getSupportActionProvider() {
        return mActionProvider;
    }
    
    @ViewDebug$CapturedViewProperty
    public CharSequence getTitle() {
        return mTitle;
    }
    
    public CharSequence getTitleCondensed() {
        CharSequence charSequence;
        if (mTitleCondensed != null) {
            charSequence = mTitleCondensed;
        }
        else {
            charSequence = mTitle;
        }
        if (Build$VERSION.SDK_INT < 18 && charSequence != null && !(charSequence instanceof String)) {
            charSequence = charSequence.toString();
        }
        return charSequence;
    }
    
    CharSequence getTitleForItemView(final MenuView.ItemView itemView) {
        if (itemView != null && itemView.prefersCondensedTitle()) {
            return this.getTitleCondensed();
        }
        return this.getTitle();
    }
    
    public boolean hasCollapsibleActionView() {
        final int n = 0x8 & mShowAsAction;
        boolean b = false;
        if (n != 0) {
            if (mActionView == null && mActionProvider != null) {
                mActionView = mActionProvider.onCreateActionView((MenuItem)this);
            }
            final View mActionView = this.mActionView;
            b = false;
            if (mActionView != null) {
                b = true;
            }
        }
        return b;
    }
    
    public boolean hasSubMenu() {
        return mSubMenu != null;
    }
    
    public boolean invoke() {
        if ((mClickListener == null || !mClickListener.onMenuItemClick((MenuItem)this)) && !mMenu.dispatchMenuItemSelected(mMenu.getRootMenu(), (MenuItem)this)) {
            if (mItemCallback != null) {
                mItemCallback.run();
                return true;
            }
            if (mIntent != null) {
                try {
                    mMenu.getContext().startActivity(mIntent);
                    return true;
                }
                catch (ActivityNotFoundException ex) {
                    Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", (Throwable)ex);
                }
            }
            if (mActionProvider == null || !mActionProvider.onPerformDefaultAction()) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isActionButton() {
        return (0x20 & mFlags) == 0x20;
    }
    
    @Override
    public boolean isActionViewExpanded() {
        return mIsActionViewExpanded;
    }
    
    public boolean isCheckable() {
        return (0x1 & mFlags) == 0x1;
    }
    
    public boolean isChecked() {
        return (0x2 & mFlags) == 0x2;
    }
    
    public boolean isEnabled() {
        return (0x10 & mFlags) != 0x0;
    }
    
    public boolean isExclusiveCheckable() {
        return (0x4 & mFlags) != 0x0;
    }
    
    public boolean isVisible() {
        if (mActionProvider != null && mActionProvider.overridesItemVisibility()) {
            if ((0x8 & mFlags) != 0x0 || !mActionProvider.isVisible()) {
                return false;
            }
        }
        else if ((0x8 & mFlags) != 0x0) {
            return false;
        }
        return true;
    }
    
    public boolean requestsActionButton() {
        return (0x1 & mShowAsAction) == 0x1;
    }
    
    public boolean requiresActionButton() {
        return (0x2 & mShowAsAction) == 0x2;
    }
    
    public MenuItem setActionProvider(final android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }
    
    public SupportMenuItem setActionView(final int n) {
        final Context context = mMenu.getContext();
        this.setActionView(LayoutInflater.from(context).inflate(n, (ViewGroup)new LinearLayout(context), false));
        return this;
    }
    
    public SupportMenuItem setActionView(final View mActionView) {
        this.mActionView = mActionView;
        mActionProvider = null;
        if (mActionView != null && mActionView.getId() == -1 && mId > 0) {
            mActionView.setId(mId);
        }
        mMenu.onItemActionRequestChanged(this);
        return this;
    }
    
    @Override
    public /* bridge */ MenuItem setActionView(final int actionView) {
        return (MenuItem)this.setActionView(actionView);
    }
    
    @Override
    public /* bridge */ MenuItem setActionView(final View actionView) {
        return (MenuItem)this.setActionView(actionView);
    }
    
    public void setActionViewExpanded(final boolean mIsActionViewExpanded) {
        this.mIsActionViewExpanded = mIsActionViewExpanded;
        mMenu.onItemsChanged(false);
    }
    
    public MenuItem setAlphabeticShortcut(final char c) {
        if (mShortcutAlphabeticChar == c) {
            return (MenuItem)this;
        }
        mShortcutAlphabeticChar = Character.toLowerCase(c);
        mMenu.onItemsChanged(false);
        return (MenuItem)this;
    }
    
    public MenuItem setCallback(final Runnable mItemCallback) {
        this.mItemCallback = mItemCallback;
        return (MenuItem)this;
    }
    
    public MenuItem setCheckable(final boolean b) {
        final int mFlags = this.mFlags;
        final int n = 0xFFFFFFFE & this.mFlags;
        boolean b2;
        if (b) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        this.mFlags = ((b2 ? 1 : 0) | n);
        if (mFlags != this.mFlags) {
            mMenu.onItemsChanged(false);
        }
        return (MenuItem)this;
    }
    
    public MenuItem setChecked(final boolean checkedInt) {
        if ((0x4 & mFlags) != 0x0) {
            mMenu.setExclusiveItemChecked((MenuItem)this);
            return (MenuItem)this;
        }
        this.setCheckedInt(checkedInt);
        return (MenuItem)this;
    }
    
    void setCheckedInt(final boolean b) {
        final int mFlags = this.mFlags;
        final int n = 0xFFFFFFFD & this.mFlags;
        int n2;
        if (b) {
            n2 = 2;
        }
        else {
            n2 = 0;
        }
        this.mFlags = (n2 | n);
        if (mFlags != this.mFlags) {
            mMenu.onItemsChanged(false);
        }
    }
    
    public MenuItem setEnabled(final boolean b) {
        if (b) {
            mFlags |= 0x10;
        }
        else {
            mFlags &= 0xFFFFFFEF;
        }
        mMenu.onItemsChanged(false);
        return (MenuItem)this;
    }
    
    public void setExclusiveCheckable(final boolean b) {
        final int n = 0xFFFFFFFB & mFlags;
        int n2;
        if (b) {
            n2 = 4;
        }
        else {
            n2 = 0;
        }
        mFlags = (n2 | n);
    }
    
    public MenuItem setIcon(final int mIconResId) {
        mIconDrawable = null;
        this.mIconResId = mIconResId;
        mMenu.onItemsChanged(false);
        return (MenuItem)this;
    }
    
    public MenuItem setIcon(final Drawable mIconDrawable) {
        mIconResId = 0;
        this.mIconDrawable = mIconDrawable;
        mMenu.onItemsChanged(false);
        return (MenuItem)this;
    }
    
    public MenuItem setIntent(final Intent mIntent) {
        this.mIntent = mIntent;
        return (MenuItem)this;
    }
    
    public void setIsActionButton(final boolean b) {
        if (b) {
            mFlags |= 0x20;
            return;
        }
        mFlags &= 0xFFFFFFDF;
    }
    
    void setMenuInfo(final ContextMenu$ContextMenuInfo mMenuInfo) {
        this.mMenuInfo = mMenuInfo;
    }
    
    public MenuItem setNumericShortcut(final char mShortcutNumericChar) {
        if (this.mShortcutNumericChar == mShortcutNumericChar) {
            return (MenuItem)this;
        }
        this.mShortcutNumericChar = mShortcutNumericChar;
        mMenu.onItemsChanged(false);
        return (MenuItem)this;
    }
    
    public MenuItem setOnActionExpandListener(final MenuItem$OnActionExpandListener menuItem$OnActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }
    
    public MenuItem setOnMenuItemClickListener(final MenuItem$OnMenuItemClickListener mClickListener) {
        this.mClickListener = mClickListener;
        return (MenuItem)this;
    }
    
    public MenuItem setShortcut(final char mShortcutNumericChar, final char c) {
        this.mShortcutNumericChar = mShortcutNumericChar;
        mShortcutAlphabeticChar = Character.toLowerCase(c);
        mMenu.onItemsChanged(false);
        return (MenuItem)this;
    }
    
    @Override
    public void setShowAsAction(final int mShowAsAction) {
        switch (mShowAsAction & 0x3) {
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
            case 0:
            case 1:
            case 2:
                this.mShowAsAction = mShowAsAction;
                mMenu.onItemActionRequestChanged(this);
        }
    }
    
    public SupportMenuItem setShowAsActionFlags(final int showAsAction) {
        this.setShowAsAction(showAsAction);
        return this;
    }
    
    @Override
    public /* bridge */ MenuItem setShowAsActionFlags(final int showAsActionFlags) {
        return (MenuItem)this.setShowAsActionFlags(showAsActionFlags);
    }
    
    public void setSubMenu(final SubMenuBuilder mSubMenu) {
        (this.mSubMenu = mSubMenu).setHeaderTitle(this.getTitle());
    }
    
    @Override
    public SupportMenuItem setSupportActionProvider(final ActionProvider mActionProvider) {
        if (this.mActionProvider != null) {
            this.mActionProvider.reset();
        }
        mActionView = null;
        this.mActionProvider = mActionProvider;
        mMenu.onItemsChanged(true);
        if (this.mActionProvider != null) {
            this.mActionProvider.setVisibilityListener((ActionProvider.VisibilityListener)new ActionProvider.VisibilityListener() {
                final /* synthetic */ MenuItemImpl this$0;
                
                MenuItemImpl$1() {
                    this$0 = this$0;
                    super();
                }
                
                @Override
                public void onActionProviderVisibilityChanged(final boolean b) {
                    mMenu.onItemVisibleChanged(this$0);
                }
            });
        }
        return this;
    }
    
    @Override
    public SupportMenuItem setSupportOnActionExpandListener(final MenuItemCompat.OnActionExpandListener mOnActionExpandListener) {
        this.mOnActionExpandListener = mOnActionExpandListener;
        return this;
    }
    
    public MenuItem setTitle(final int n) {
        return this.setTitle(mMenu.getContext().getString(n));
    }
    
    public MenuItem setTitle(final CharSequence charSequence) {
        mTitle = charSequence;
        mMenu.onItemsChanged(false);
        if (mSubMenu != null) {
            mSubMenu.setHeaderTitle(charSequence);
        }
        return (MenuItem)this;
    }
    
    public MenuItem setTitleCondensed(final CharSequence mTitleCondensed) {
        this.mTitleCondensed = mTitleCondensed;
        if (mTitleCondensed == null) {
            final CharSequence mTitle = this.mTitle;
        }
        mMenu.onItemsChanged(false);
        return (MenuItem)this;
    }
    
    public MenuItem setVisible(final boolean visibleInt) {
        if (this.setVisibleInt(visibleInt)) {
            mMenu.onItemVisibleChanged(this);
        }
        return (MenuItem)this;
    }
    
    boolean setVisibleInt(final boolean b) {
        final int mFlags = this.mFlags;
        final int n = 0xFFFFFFF7 & this.mFlags;
        int n2;
        if (b) {
            n2 = 0;
        }
        else {
            n2 = 8;
        }
        this.mFlags = (n2 | n);
        final int mFlags2 = this.mFlags;
        boolean b2 = false;
        if (mFlags != mFlags2) {
            b2 = true;
        }
        return b2;
    }
    
    public boolean shouldShowIcon() {
        return mMenu.getOptionalIconsVisible();
    }
    
    boolean shouldShowShortcut() {
        return mMenu.isShortcutsVisible() && this.getShortcut() != '\0';
    }
    
    public boolean showsTextAsAction() {
        return (0x4 & mShowAsAction) == 0x4;
    }
    
    @Override
    public String toString() {
        if (mTitle != null) {
            return mTitle.toString();
        }
        return null;
    }
}
