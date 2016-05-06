package android.support.v7.view.menu;

import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ActionProvider;
import java.util.Collection;
import android.view.KeyCharacterMap$KeyData;
import android.view.KeyEvent;
import android.view.SubMenu;
import java.util.List;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.Intent;
import android.content.ComponentName;
import android.view.MenuItem;
import android.support.v7.appcompat.R;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import java.util.Iterator;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu$ContextMenuInfo;
import android.content.Context;
import java.util.ArrayList;
import android.support.v4.internal.view.SupportMenu;

public class MenuBuilder implements SupportMenu
{
    private static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
    private static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
    private static final String PRESENTER_KEY = "android:menu:presenters";
    private static final String TAG = "MenuBuilder";
    private static final int[] sCategoryToOrder;
    private ArrayList<MenuItemImpl> mActionItems;
    private Callback mCallback;
    private final Context mContext;
    private ContextMenu$ContextMenuInfo mCurrentMenuInfo;
    private int mDefaultShowAsAction;
    private MenuItemImpl mExpandedItem;
    private SparseArray<Parcelable> mFrozenViewStates;
    Drawable mHeaderIcon;
    CharSequence mHeaderTitle;
    View mHeaderView;
    private boolean mIsActionItemsStale;
    private boolean mIsClosing;
    private boolean mIsVisibleItemsStale;
    private ArrayList<MenuItemImpl> mItems;
    private boolean mItemsChangedWhileDispatchPrevented;
    private ArrayList<MenuItemImpl> mNonActionItems;
    private boolean mOptionalIconsVisible;
    private boolean mOverrideVisibleItems;
    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> mPresenters;
    private boolean mPreventDispatchingItemsChanged;
    private boolean mQwertyMode;
    private final Resources mResources;
    private boolean mShortcutsVisible;
    private ArrayList<MenuItemImpl> mTempShortcutItemList;
    private ArrayList<MenuItemImpl> mVisibleItems;
    
    static {
        sCategoryToOrder = new int[] { 1, 4, 5, 3, 2, 0 };
    }
    
    public MenuBuilder(final Context mContext) {
        super();
        mDefaultShowAsAction = 0;
        mPreventDispatchingItemsChanged = false;
        mItemsChangedWhileDispatchPrevented = false;
        mOptionalIconsVisible = false;
        mIsClosing = false;
        mTempShortcutItemList = new ArrayList<MenuItemImpl>();
        mPresenters = new CopyOnWriteArrayList<WeakReference<MenuPresenter>>();
        mContext = mContext;
        mResources = mContext.getResources();
        mItems = new ArrayList<MenuItemImpl>();
        mVisibleItems = new ArrayList<MenuItemImpl>();
        mIsVisibleItemsStale = true;
        mActionItems = new ArrayList<MenuItemImpl>();
        mNonActionItems = new ArrayList<MenuItemImpl>();
        this.setShortcutsVisibleInner(mIsActionItemsStale = true);
    }
    
    private MenuItemImpl createNewMenuItem(final int n, final int n2, final int n3, final int n4, final CharSequence charSequence, final int n5) {
        return new MenuItemImpl(this, n, n2, n3, n4, charSequence, n5);
    }
    
    private void dispatchPresenterUpdate(final boolean b) {
        if (mPresenters.isEmpty()) {
            return;
        }
        this.stopDispatchingItemsChanged();
        for (final WeakReference<MenuPresenter> weakReference : mPresenters) {
            final MenuPresenter menuPresenter = (MenuPresenter)weakReference.get();
            if (menuPresenter == null) {
                mPresenters.remove(weakReference);
            }
            else {
                menuPresenter.updateMenuView(b);
            }
        }
        this.startDispatchingItemsChanged();
    }
    
    private void dispatchRestoreInstanceState(final Bundle bundle) {
        final SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !mPresenters.isEmpty()) {
            for (final WeakReference<MenuPresenter> weakReference : mPresenters) {
                final MenuPresenter menuPresenter = (MenuPresenter)weakReference.get();
                if (menuPresenter == null) {
                    mPresenters.remove(weakReference);
                }
                else {
                    final int id = menuPresenter.getId();
                    if (id <= 0) {
                        continue;
                    }
                    final Parcelable parcelable = (Parcelable)sparseParcelableArray.get(id);
                    if (parcelable == null) {
                        continue;
                    }
                    menuPresenter.onRestoreInstanceState(parcelable);
                }
            }
        }
    }
    
    private void dispatchSaveInstanceState(final Bundle bundle) {
        if (mPresenters.isEmpty()) {
            return;
        }
        final SparseArray sparseArray = new SparseArray();
        for (final WeakReference<MenuPresenter> weakReference : mPresenters) {
            final MenuPresenter menuPresenter = (MenuPresenter)weakReference.get();
            if (menuPresenter == null) {
                mPresenters.remove(weakReference);
            }
            else {
                final int id = menuPresenter.getId();
                if (id <= 0) {
                    continue;
                }
                final Parcelable onSaveInstanceState = menuPresenter.onSaveInstanceState();
                if (onSaveInstanceState == null) {
                    continue;
                }
                sparseArray.put(id, (Object)onSaveInstanceState);
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }
    
    private boolean dispatchSubMenuSelected(final SubMenuBuilder subMenuBuilder, final MenuPresenter menuPresenter) {
        boolean b;
        if (mPresenters.isEmpty()) {
            b = false;
        }
        else {
            b = false;
            if (menuPresenter != null) {
                b = menuPresenter.onSubMenuSelected(subMenuBuilder);
            }
            for (final WeakReference<MenuPresenter> weakReference : mPresenters) {
                final MenuPresenter menuPresenter2 = (MenuPresenter)weakReference.get();
                if (menuPresenter2 == null) {
                    mPresenters.remove(weakReference);
                }
                else {
                    if (b) {
                        continue;
                    }
                    b = menuPresenter2.onSubMenuSelected(subMenuBuilder);
                }
            }
        }
        return b;
    }
    
    private static int findInsertIndex(final ArrayList<MenuItemImpl> list, final int n) {
        for (int i = -1 + list.size(); i >= 0; --i) {
            if (((MenuItemImpl)list.get(i)).getOrdering() <= n) {
                return i + 1;
            }
        }
        return 0;
    }
    
    private static int getOrdering(final int n) {
        final int n2 = (0xFFFF0000 & n) >> 16;
        if (n2 < 0 || n2 >= sCategoryToOrder.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        return sCategoryToOrder[n2] << 16 | (0xFFFF & n);
    }
    
    private void removeItemAtInt(final int n, final boolean b) {
        if (n >= 0 && n < mItems.size()) {
            mItems.remove(n);
            if (b) {
                this.onItemsChanged(true);
            }
        }
    }
    
    private void setHeaderInternal(final int n, final CharSequence mHeaderTitle, final int n2, final Drawable mHeaderIcon, final View mHeaderView) {
        final Resources resources = this.getResources();
        if (mHeaderView != null) {
            this.mHeaderView = mHeaderView;
            this.mHeaderTitle = null;
            this.mHeaderIcon = null;
        }
        else {
            if (n > 0) {
                this.mHeaderTitle = resources.getText(n);
            }
            else if (mHeaderTitle != null) {
                this.mHeaderTitle = mHeaderTitle;
            }
            if (n2 > 0) {
                this.mHeaderIcon = ContextCompat.getDrawable(this.getContext(), n2);
            }
            else if (mHeaderIcon != null) {
                this.mHeaderIcon = mHeaderIcon;
            }
            this.mHeaderView = null;
        }
        this.onItemsChanged(false);
    }
    
    private void setShortcutsVisibleInner(final boolean b) {
        boolean mShortcutsVisible = true;
        if (!b || mResources.getConfiguration().keyboard == (mShortcutsVisible ? 1 : 0) || !mResources.getBoolean(R.bool.abc_config_showMenuShortcutsWhenKeyboardPresent)) {
            mShortcutsVisible = false;
        }
        this.mShortcutsVisible = mShortcutsVisible;
    }
    
    public MenuItem add(final int n) {
        return this.addInternal(0, 0, 0, mResources.getString(n));
    }
    
    public MenuItem add(final int n, final int n2, final int n3, final int n4) {
        return this.addInternal(n, n2, n3, mResources.getString(n4));
    }
    
    public MenuItem add(final int n, final int n2, final int n3, final CharSequence charSequence) {
        return this.addInternal(n, n2, n3, charSequence);
    }
    
    public MenuItem add(final CharSequence charSequence) {
        return this.addInternal(0, 0, 0, charSequence);
    }
    
    public int addIntentOptions(final int n, final int n2, final int n3, final ComponentName componentName, final Intent[] array, final Intent intent, final int n4, final MenuItem[] array2) {
        final PackageManager packageManager = mContext.getPackageManager();
        final List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, array, intent, 0);
        int size;
        if (queryIntentActivityOptions != null) {
            size = queryIntentActivityOptions.size();
        }
        else {
            size = 0;
        }
        if ((n4 & 0x1) == 0x0) {
            this.removeGroup(n);
        }
        for (int i = 0; i < size; ++i) {
            final ResolveInfo resolveInfo = (ResolveInfo)queryIntentActivityOptions.get(i);
            Intent intent2;
            if (resolveInfo.specificIndex < 0) {
                intent2 = intent;
            }
            else {
                intent2 = array[resolveInfo.specificIndex];
            }
            final Intent intent3 = new Intent(intent2);
            intent3.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            final MenuItem setIntent = this.add(n, n2, n3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (array2 != null && resolveInfo.specificIndex >= 0) {
                array2[resolveInfo.specificIndex] = setIntent;
            }
        }
        return size;
    }
    
    protected MenuItem addInternal(final int n, final int n2, final int n3, final CharSequence charSequence) {
        final int ordering = getOrdering(n3);
        final MenuItemImpl newMenuItem = this.createNewMenuItem(n, n2, n3, ordering, charSequence, mDefaultShowAsAction);
        if (mCurrentMenuInfo != null) {
            newMenuItem.setMenuInfo(mCurrentMenuInfo);
        }
        mItems.add(findInsertIndex(mItems, ordering), newMenuItem);
        this.onItemsChanged(true);
        return (MenuItem)newMenuItem;
    }
    
    public void addMenuPresenter(final MenuPresenter menuPresenter) {
        this.addMenuPresenter(menuPresenter, mContext);
    }
    
    public void addMenuPresenter(final MenuPresenter menuPresenter, final Context context) {
        mPresenters.add(new WeakReference<MenuPresenter>(menuPresenter));
        menuPresenter.initForMenu(context, this);
        mIsActionItemsStale = true;
    }
    
    public SubMenu addSubMenu(final int n) {
        return this.addSubMenu(0, 0, 0, mResources.getString(n));
    }
    
    public SubMenu addSubMenu(final int n, final int n2, final int n3, final int n4) {
        return this.addSubMenu(n, n2, n3, mResources.getString(n4));
    }
    
    public SubMenu addSubMenu(final int n, final int n2, final int n3, final CharSequence charSequence) {
        final MenuItemImpl menuItemImpl = (MenuItemImpl)this.addInternal(n, n2, n3, charSequence);
        final SubMenuBuilder subMenu = new SubMenuBuilder(mContext, this, menuItemImpl);
        menuItemImpl.setSubMenu(subMenu);
        return (SubMenu)subMenu;
    }
    
    public SubMenu addSubMenu(final CharSequence charSequence) {
        return this.addSubMenu(0, 0, 0, charSequence);
    }
    
    public void changeMenuMode() {
        if (mCallback != null) {
            mCallback.onMenuModeChange(this);
        }
    }
    
    public void clear() {
        if (mExpandedItem != null) {
            this.collapseItemActionView(mExpandedItem);
        }
        mItems.clear();
        this.onItemsChanged(true);
    }
    
    public void clearAll() {
        mPreventDispatchingItemsChanged = true;
        this.clear();
        this.clearHeader();
        mPreventDispatchingItemsChanged = false;
        mItemsChangedWhileDispatchPrevented = false;
        this.onItemsChanged(true);
    }
    
    public void clearHeader() {
        mHeaderIcon = null;
        mHeaderTitle = null;
        mHeaderView = null;
        this.onItemsChanged(false);
    }
    
    public void close() {
        this.close(true);
    }
    
    public final void close(final boolean b) {
        if (mIsClosing) {
            return;
        }
        mIsClosing = true;
        for (final WeakReference<MenuPresenter> weakReference : mPresenters) {
            final MenuPresenter menuPresenter = (MenuPresenter)weakReference.get();
            if (menuPresenter == null) {
                mPresenters.remove(weakReference);
            }
            else {
                menuPresenter.onCloseMenu(this, b);
            }
        }
        mIsClosing = false;
    }
    
    public boolean collapseItemActionView(final MenuItemImpl menuItemImpl) {
        boolean collapseItemActionView;
        if (mPresenters.isEmpty() || mExpandedItem != menuItemImpl) {
            collapseItemActionView = false;
        }
        else {
            collapseItemActionView = false;
            this.stopDispatchingItemsChanged();
            for (final WeakReference<MenuPresenter> weakReference : mPresenters) {
                final MenuPresenter menuPresenter = (MenuPresenter)weakReference.get();
                if (menuPresenter == null) {
                    mPresenters.remove(weakReference);
                }
                else {
                    collapseItemActionView = menuPresenter.collapseItemActionView(this, menuItemImpl);
                    if (collapseItemActionView) {
                        break;
                    }
                    continue;
                }
            }
            this.startDispatchingItemsChanged();
            if (collapseItemActionView) {
                mExpandedItem = null;
                return collapseItemActionView;
            }
        }
        return collapseItemActionView;
    }
    
    boolean dispatchMenuItemSelected(final MenuBuilder menuBuilder, final MenuItem menuItem) {
        return mCallback != null && mCallback.onMenuItemSelected(menuBuilder, menuItem);
    }
    
    public boolean expandItemActionView(final MenuItemImpl mExpandedItem) {
        boolean expandItemActionView;
        if (mPresenters.isEmpty()) {
            expandItemActionView = false;
        }
        else {
            expandItemActionView = false;
            this.stopDispatchingItemsChanged();
            for (final WeakReference<MenuPresenter> weakReference : mPresenters) {
                final MenuPresenter menuPresenter = (MenuPresenter)weakReference.get();
                if (menuPresenter == null) {
                    mPresenters.remove(weakReference);
                }
                else {
                    expandItemActionView = menuPresenter.expandItemActionView(this, mExpandedItem);
                    if (expandItemActionView) {
                        break;
                    }
                    continue;
                }
            }
            this.startDispatchingItemsChanged();
            if (expandItemActionView) {
                this.mExpandedItem = mExpandedItem;
                return expandItemActionView;
            }
        }
        return expandItemActionView;
    }
    
    public int findGroupIndex(final int n) {
        return this.findGroupIndex(n, 0);
    }
    
    public int findGroupIndex(final int n, int n2) {
        final int size = this.size();
        if (n2 < 0) {
            n2 = 0;
        }
        for (int i = n2; i < size; ++i) {
            if (((MenuItemImpl)mItems.get(i)).getGroupId() == n) {
                return i;
            }
        }
        return -1;
    }
    
    public MenuItem findItem(final int n) {
        for (int size = this.size(), i = 0; i < size; ++i) {
            final MenuItemImpl menuItemImpl = (MenuItemImpl)mItems.get(i);
            if (menuItemImpl.getItemId() == n) {
                return (MenuItem)menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu()) {
                final MenuItem item = menuItemImpl.getSubMenu().findItem(n);
                if (item != null) {
                    return item;
                }
            }
        }
        return null;
    }
    
    public int findItemIndex(final int n) {
        for (int size = this.size(), i = 0; i < size; ++i) {
            if (((MenuItemImpl)mItems.get(i)).getItemId() == n) {
                return i;
            }
        }
        return -1;
    }
    
    MenuItemImpl findItemWithShortcutForKey(final int n, final KeyEvent keyEvent) {
        final ArrayList<MenuItemImpl> mTempShortcutItemList = this.mTempShortcutItemList;
        mTempShortcutItemList.clear();
        this.findItemsWithShortcutForKey(mTempShortcutItemList, n, keyEvent);
        if (!mTempShortcutItemList.isEmpty()) {
            final int metaState = keyEvent.getMetaState();
            final KeyCharacterMap$KeyData keyCharacterMap$KeyData = new KeyCharacterMap$KeyData();
            keyEvent.getKeyData(keyCharacterMap$KeyData);
            final int size = mTempShortcutItemList.size();
            if (size == 1) {
                return mTempShortcutItemList.get(0);
            }
            final boolean qwertyMode = this.isQwertyMode();
            for (int i = 0; i < size; ++i) {
                final MenuItemImpl menuItemImpl = (MenuItemImpl)mTempShortcutItemList.get(i);
                char c;
                if (qwertyMode) {
                    c = menuItemImpl.getAlphabeticShortcut();
                }
                else {
                    c = menuItemImpl.getNumericShortcut();
                }
                if ((c == keyCharacterMap$KeyData.meta[0] && (metaState & 0x2) == 0x0) || (c == keyCharacterMap$KeyData.meta[2] && (metaState & 0x2) != 0x0) || (qwertyMode && c == '\b' && n == 67)) {
                    return menuItemImpl;
                }
            }
        }
        return null;
    }
    
    void findItemsWithShortcutForKey(final List<MenuItemImpl> list, final int n, final KeyEvent keyEvent) {
        final boolean qwertyMode = this.isQwertyMode();
        final int metaState = keyEvent.getMetaState();
        final KeyCharacterMap$KeyData keyCharacterMap$KeyData = new KeyCharacterMap$KeyData();
        if (keyEvent.getKeyData(keyCharacterMap$KeyData) || n == 67) {
            for (int size = mItems.size(), i = 0; i < size; ++i) {
                final MenuItemImpl menuItemImpl = (MenuItemImpl)mItems.get(i);
                if (menuItemImpl.hasSubMenu()) {
                    ((MenuBuilder)menuItemImpl.getSubMenu()).findItemsWithShortcutForKey(list, n, keyEvent);
                }
                char c;
                if (qwertyMode) {
                    c = menuItemImpl.getAlphabeticShortcut();
                }
                else {
                    c = menuItemImpl.getNumericShortcut();
                }
                if ((metaState & 0x5) == 0x0 && c != '\0' && (c == keyCharacterMap$KeyData.meta[0] || c == keyCharacterMap$KeyData.meta[2] || (qwertyMode && c == '\b' && n == 67)) && menuItemImpl.isEnabled()) {
                    list.add(menuItemImpl);
                }
            }
        }
    }
    
    public void flagActionItems() {
        final ArrayList<MenuItemImpl> visibleItems = this.getVisibleItems();
        if (!mIsActionItemsStale) {
            return;
        }
        boolean b = false;
        for (final WeakReference<MenuPresenter> weakReference : mPresenters) {
            final MenuPresenter menuPresenter = (MenuPresenter)weakReference.get();
            if (menuPresenter == null) {
                mPresenters.remove(weakReference);
            }
            else {
                b |= menuPresenter.flagActionItems();
            }
        }
        if (b) {
            mActionItems.clear();
            mNonActionItems.clear();
            for (int size = visibleItems.size(), i = 0; i < size; ++i) {
                final MenuItemImpl menuItemImpl = (MenuItemImpl)visibleItems.get(i);
                if (menuItemImpl.isActionButton()) {
                    mActionItems.add(menuItemImpl);
                }
                else {
                    mNonActionItems.add(menuItemImpl);
                }
            }
        }
        else {
            mActionItems.clear();
            mNonActionItems.clear();
            mNonActionItems.addAll(this.getVisibleItems());
        }
        mIsActionItemsStale = false;
    }
    
    public ArrayList<MenuItemImpl> getActionItems() {
        this.flagActionItems();
        return mActionItems;
    }
    
    protected String getActionViewStatesKey() {
        return "android:menu:actionviewstates";
    }
    
    public Context getContext() {
        return mContext;
    }
    
    public MenuItemImpl getExpandedItem() {
        return mExpandedItem;
    }
    
    public Drawable getHeaderIcon() {
        return mHeaderIcon;
    }
    
    public CharSequence getHeaderTitle() {
        return mHeaderTitle;
    }
    
    public View getHeaderView() {
        return mHeaderView;
    }
    
    public MenuItem getItem(final int n) {
        return (MenuItem)mItems.get(n);
    }
    
    public ArrayList<MenuItemImpl> getNonActionItems() {
        this.flagActionItems();
        return mNonActionItems;
    }
    
    boolean getOptionalIconsVisible() {
        return mOptionalIconsVisible;
    }
    
    Resources getResources() {
        return mResources;
    }
    
    public MenuBuilder getRootMenu() {
        return this;
    }
    
    public ArrayList<MenuItemImpl> getVisibleItems() {
        if (!mIsVisibleItemsStale) {
            return mVisibleItems;
        }
        mVisibleItems.clear();
        for (int size = mItems.size(), i = 0; i < size; ++i) {
            final MenuItemImpl menuItemImpl = (MenuItemImpl)mItems.get(i);
            if (menuItemImpl.isVisible()) {
                mVisibleItems.add(menuItemImpl);
            }
        }
        mIsVisibleItemsStale = false;
        mIsActionItemsStale = true;
        return mVisibleItems;
    }
    
    public boolean hasVisibleItems() {
        if (!mOverrideVisibleItems) {
            for (int size = this.size(), i = 0; i < size; ++i) {
                if (((MenuItemImpl)mItems.get(i)).isVisible()) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    boolean isQwertyMode() {
        return mQwertyMode;
    }
    
    public boolean isShortcutKey(final int n, final KeyEvent keyEvent) {
        return this.findItemWithShortcutForKey(n, keyEvent) != null;
    }
    
    public boolean isShortcutsVisible() {
        return mShortcutsVisible;
    }
    
    void onItemActionRequestChanged(final MenuItemImpl menuItemImpl) {
        this.onItemsChanged(mIsActionItemsStale = true);
    }
    
    void onItemVisibleChanged(final MenuItemImpl menuItemImpl) {
        this.onItemsChanged(mIsVisibleItemsStale = true);
    }
    
    public void onItemsChanged(final boolean b) {
        if (!mPreventDispatchingItemsChanged) {
            if (b) {
                mIsVisibleItemsStale = true;
                mIsActionItemsStale = true;
            }
            this.dispatchPresenterUpdate(b);
            return;
        }
        mItemsChangedWhileDispatchPrevented = true;
    }
    
    public boolean performIdentifierAction(final int n, final int n2) {
        return this.performItemAction(this.findItem(n), n2);
    }
    
    public boolean performItemAction(final MenuItem menuItem, final int n) {
        return this.performItemAction(menuItem, null, n);
    }
    
    public boolean performItemAction(final MenuItem menuItem, final MenuPresenter menuPresenter, final int n) {
        final MenuItemImpl menuItemImpl = (MenuItemImpl)menuItem;
        boolean invoke;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            invoke = false;
        }
        else {
            invoke = menuItemImpl.invoke();
            final ActionProvider supportActionProvider = menuItemImpl.getSupportActionProvider();
            final boolean b = supportActionProvider != null && supportActionProvider.hasSubMenu();
            if (menuItemImpl.hasCollapsibleActionView()) {
                invoke |= menuItemImpl.expandActionView();
                if (invoke) {
                    this.close(true);
                    return invoke;
                }
            }
            else if (menuItemImpl.hasSubMenu() || b) {
                this.close(false);
                if (!menuItemImpl.hasSubMenu()) {
                    menuItemImpl.setSubMenu(new SubMenuBuilder(this.getContext(), this, menuItemImpl));
                }
                final SubMenuBuilder subMenuBuilder = (SubMenuBuilder)menuItemImpl.getSubMenu();
                if (b) {
                    supportActionProvider.onPrepareSubMenu((SubMenu)subMenuBuilder);
                }
                invoke |= this.dispatchSubMenuSelected(subMenuBuilder, menuPresenter);
                if (!invoke) {
                    this.close(true);
                    return invoke;
                }
            }
            else if ((n & 0x1) == 0x0) {
                this.close(true);
                return invoke;
            }
        }
        return invoke;
    }
    
    public boolean performShortcut(final int n, final KeyEvent keyEvent, final int n2) {
        final MenuItemImpl itemWithShortcutForKey = this.findItemWithShortcutForKey(n, keyEvent);
        boolean performItemAction = false;
        if (itemWithShortcutForKey != null) {
            performItemAction = this.performItemAction((MenuItem)itemWithShortcutForKey, n2);
        }
        if ((n2 & 0x2) != 0x0) {
            this.close(true);
        }
        return performItemAction;
    }
    
    public void removeGroup(final int n) {
        final int groupIndex = this.findGroupIndex(n);
        if (groupIndex >= 0) {
            final int n2 = mItems.size() - groupIndex;
            int n3 = 0;
            while (true) {
                final int n4 = n3 + 1;
                if (n3 >= n2 || ((MenuItemImpl)mItems.get(groupIndex)).getGroupId() != n) {
                    break;
                }
                this.removeItemAtInt(groupIndex, false);
                n3 = n4;
            }
            this.onItemsChanged(true);
        }
    }
    
    public void removeItem(final int n) {
        this.removeItemAtInt(this.findItemIndex(n), true);
    }
    
    public void removeItemAt(final int n) {
        this.removeItemAtInt(n, true);
    }
    
    public void removeMenuPresenter(final MenuPresenter menuPresenter) {
        for (final WeakReference<MenuPresenter> weakReference : mPresenters) {
            final MenuPresenter menuPresenter2 = (MenuPresenter)weakReference.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                mPresenters.remove(weakReference);
            }
        }
    }
    
    public void restoreActionViewStates(final Bundle bundle) {
        if (bundle != null) {
            final SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(this.getActionViewStatesKey());
            for (int size = this.size(), i = 0; i < size; ++i) {
                final MenuItem item = this.getItem(i);
                final View actionView = MenuItemCompat.getActionView(item);
                if (actionView != null && actionView.getId() != -1) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((SubMenuBuilder)item.getSubMenu()).restoreActionViewStates(bundle);
                }
            }
            final int int1 = bundle.getInt("android:menu:expandedactionview");
            if (int1 > 0) {
                final MenuItem item2 = this.findItem(int1);
                if (item2 != null) {
                    MenuItemCompat.expandActionView(item2);
                }
            }
        }
    }
    
    public void restorePresenterStates(final Bundle bundle) {
        this.dispatchRestoreInstanceState(bundle);
    }
    
    public void saveActionViewStates(final Bundle bundle) {
        SparseArray sparseArray = null;
        for (int size = this.size(), i = 0; i < size; ++i) {
            final MenuItem item = this.getItem(i);
            final View actionView = MenuItemCompat.getActionView(item);
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (MenuItemCompat.isActionViewExpanded(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder)item.getSubMenu()).saveActionViewStates(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(this.getActionViewStatesKey(), sparseArray);
        }
    }
    
    public void savePresenterStates(final Bundle bundle) {
        this.dispatchSaveInstanceState(bundle);
    }
    
    public void setCallback(final Callback mCallback) {
        this.mCallback = mCallback;
    }
    
    public void setCurrentMenuInfo(final ContextMenu$ContextMenuInfo mCurrentMenuInfo) {
        this.mCurrentMenuInfo = mCurrentMenuInfo;
    }
    
    public MenuBuilder setDefaultShowAsAction(final int mDefaultShowAsAction) {
        this.mDefaultShowAsAction = mDefaultShowAsAction;
        return this;
    }
    
    void setExclusiveItemChecked(final MenuItem menuItem) {
        final int groupId = menuItem.getGroupId();
        for (int size = mItems.size(), i = 0; i < size; ++i) {
            final MenuItemImpl menuItemImpl = (MenuItemImpl)mItems.get(i);
            if (menuItemImpl.getGroupId() == groupId && menuItemImpl.isExclusiveCheckable() && menuItemImpl.isCheckable()) {
                menuItemImpl.setCheckedInt(menuItemImpl == menuItem);
            }
        }
    }
    
    public void setGroupCheckable(final int n, final boolean checkable, final boolean exclusiveCheckable) {
        for (int size = mItems.size(), i = 0; i < size; ++i) {
            final MenuItemImpl menuItemImpl = (MenuItemImpl)mItems.get(i);
            if (menuItemImpl.getGroupId() == n) {
                menuItemImpl.setExclusiveCheckable(exclusiveCheckable);
                menuItemImpl.setCheckable(checkable);
            }
        }
    }
    
    public void setGroupEnabled(final int n, final boolean enabled) {
        for (int size = mItems.size(), i = 0; i < size; ++i) {
            final MenuItemImpl menuItemImpl = (MenuItemImpl)mItems.get(i);
            if (menuItemImpl.getGroupId() == n) {
                menuItemImpl.setEnabled(enabled);
            }
        }
    }
    
    public void setGroupVisible(final int n, final boolean visibleInt) {
        final int size = mItems.size();
        boolean b = false;
        for (int i = 0; i < size; ++i) {
            final MenuItemImpl menuItemImpl = (MenuItemImpl)mItems.get(i);
            if (menuItemImpl.getGroupId() == n && menuItemImpl.setVisibleInt(visibleInt)) {
                b = true;
            }
        }
        if (b) {
            this.onItemsChanged(true);
        }
    }
    
    protected MenuBuilder setHeaderIconInt(final int n) {
        this.setHeaderInternal(0, null, n, null, null);
        return this;
    }
    
    protected MenuBuilder setHeaderIconInt(final Drawable drawable) {
        this.setHeaderInternal(0, null, 0, drawable, null);
        return this;
    }
    
    protected MenuBuilder setHeaderTitleInt(final int n) {
        this.setHeaderInternal(n, null, 0, null, null);
        return this;
    }
    
    protected MenuBuilder setHeaderTitleInt(final CharSequence charSequence) {
        this.setHeaderInternal(0, charSequence, 0, null, null);
        return this;
    }
    
    protected MenuBuilder setHeaderViewInt(final View view) {
        this.setHeaderInternal(0, null, 0, null, view);
        return this;
    }
    
    void setOptionalIconsVisible(final boolean mOptionalIconsVisible) {
        this.mOptionalIconsVisible = mOptionalIconsVisible;
    }
    
    public void setOverrideVisibleItems(final boolean mOverrideVisibleItems) {
        this.mOverrideVisibleItems = mOverrideVisibleItems;
    }
    
    public void setQwertyMode(final boolean mQwertyMode) {
        this.mQwertyMode = mQwertyMode;
        this.onItemsChanged(false);
    }
    
    public void setShortcutsVisible(final boolean shortcutsVisibleInner) {
        if (mShortcutsVisible == shortcutsVisibleInner) {
            return;
        }
        this.setShortcutsVisibleInner(shortcutsVisibleInner);
        this.onItemsChanged(false);
    }
    
    public int size() {
        return mItems.size();
    }
    
    public void startDispatchingItemsChanged() {
        mPreventDispatchingItemsChanged = false;
        if (mItemsChangedWhileDispatchPrevented) {
            mItemsChangedWhileDispatchPrevented = false;
            this.onItemsChanged(true);
        }
    }
    
    public void stopDispatchingItemsChanged() {
        if (!mPreventDispatchingItemsChanged) {
            mPreventDispatchingItemsChanged = true;
            mItemsChangedWhileDispatchPrevented = false;
        }
    }
}
