package android.support.v7.view;

import android.content.res.TypedArray;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.SubMenu;
import android.view.View;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.MenuItem$OnMenuItemClickListener;
import android.support.v4.view.MenuItemCompat;
import android.view.MenuItem;
import java.lang.reflect.Constructor;
import android.util.Log;
import android.view.Menu;
import android.support.v4.view.ActionProvider;

private class MenuState
{
    private static final int defaultGroupId = 0;
    private static final int defaultItemCategory = 0;
    private static final int defaultItemCheckable = 0;
    private static final boolean defaultItemChecked = false;
    private static final boolean defaultItemEnabled = true;
    private static final int defaultItemId = 0;
    private static final int defaultItemOrder = 0;
    private static final boolean defaultItemVisible = true;
    private int groupCategory;
    private int groupCheckable;
    private boolean groupEnabled;
    private int groupId;
    private int groupOrder;
    private boolean groupVisible;
    private ActionProvider itemActionProvider;
    private String itemActionProviderClassName;
    private String itemActionViewClassName;
    private int itemActionViewLayout;
    private boolean itemAdded;
    private char itemAlphabeticShortcut;
    private int itemCategoryOrder;
    private int itemCheckable;
    private boolean itemChecked;
    private boolean itemEnabled;
    private int itemIconResId;
    private int itemId;
    private String itemListenerMethodName;
    private char itemNumericShortcut;
    private int itemShowAsAction;
    private CharSequence itemTitle;
    private CharSequence itemTitleCondensed;
    private boolean itemVisible;
    private Menu menu;
    final /* synthetic */ SupportMenuInflater this$0;
    
    public MenuState(final SupportMenuInflater this$0, final Menu menu) {
        this$0 = this$0;
        super();
        menu = menu;
        this.resetGroup();
    }
    
    static /* synthetic */ ActionProvider access$000(final MenuState menuState) {
        return menuState.itemActionProvider;
    }
    
    private char getShortcut(final String s) {
        if (s == null) {
            return '\0';
        }
        return s.charAt(0);
    }
    
    private <T> T newInstance(final String s, final Class<?>[] array, final Object[] array2) {
        try {
            final Constructor<?> constructor = SupportMenuInflater.access$100(this$0).getClassLoader().loadClass(s).getConstructor(array);
            constructor.setAccessible(true);
            return (T)constructor.newInstance(array2);
        }
        catch (Exception ex) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + s, (Throwable)ex);
            return null;
        }
    }
    
    private void setItem(final MenuItem menuItem) {
        menuItem.setChecked(itemChecked).setVisible(itemVisible).setEnabled(itemEnabled).setCheckable(itemCheckable >= 1).setTitleCondensed(itemTitleCondensed).setIcon(itemIconResId).setAlphabeticShortcut(itemAlphabeticShortcut).setNumericShortcut(itemNumericShortcut);
        if (itemShowAsAction >= 0) {
            MenuItemCompat.setShowAsAction(menuItem, itemShowAsAction);
        }
        if (itemListenerMethodName != null) {
            if (SupportMenuInflater.access$100(this$0).isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            menuItem.setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)new InflatedOnMenuItemClickListener(SupportMenuInflater.access$400(this$0), itemListenerMethodName));
        }
        if (menuItem instanceof MenuItemImpl) {
            final MenuItemImpl menuItemImpl = (MenuItemImpl)menuItem;
        }
        if (itemCheckable >= 2) {
            if (menuItem instanceof MenuItemImpl) {
                ((MenuItemImpl)menuItem).setExclusiveCheckable(true);
            }
            else if (menuItem instanceof MenuItemWrapperICS) {
                ((MenuItemWrapperICS)menuItem).setExclusiveCheckable(true);
            }
        }
        final String itemActionViewClassName = this.itemActionViewClassName;
        boolean b = false;
        if (itemActionViewClassName != null) {
            MenuItemCompat.setActionView(menuItem, this.<View>newInstance(this.itemActionViewClassName, SupportMenuInflater.access$500(), SupportMenuInflater.access$600(this$0)));
            b = true;
        }
        if (itemActionViewLayout > 0) {
            if (!b) {
                MenuItemCompat.setActionView(menuItem, itemActionViewLayout);
            }
            else {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            }
        }
        if (itemActionProvider != null) {
            MenuItemCompat.setActionProvider(menuItem, itemActionProvider);
        }
    }
    
    public void addItem() {
        itemAdded = true;
        this.setItem(menu.add(groupId, itemId, itemCategoryOrder, itemTitle));
    }
    
    public SubMenu addSubMenuItem() {
        itemAdded = true;
        final SubMenu addSubMenu = menu.addSubMenu(groupId, itemId, itemCategoryOrder, itemTitle);
        this.setItem(addSubMenu.getItem());
        return addSubMenu;
    }
    
    public boolean hasAddedItem() {
        return itemAdded;
    }
    
    public void readGroup(final AttributeSet set) {
        final TypedArray obtainStyledAttributes = SupportMenuInflater.access$100(this$0).obtainStyledAttributes(set, R.styleable.MenuGroup);
        groupId = obtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
        groupCategory = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
        groupOrder = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
        groupCheckable = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
        groupVisible = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
        groupEnabled = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
        obtainStyledAttributes.recycle();
    }
    
    public void readItem(final AttributeSet set) {
        final TypedArray obtainStyledAttributes = SupportMenuInflater.access$100(this$0).obtainStyledAttributes(set, R.styleable.MenuItem);
        itemId = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_android_id, 0);
        itemCategoryOrder = ((0xFFFF0000 & obtainStyledAttributes.getInt(R.styleable.MenuItem_android_menuCategory, groupCategory)) | (0xFFFF & obtainStyledAttributes.getInt(R.styleable.MenuItem_android_orderInCategory, groupOrder)));
        itemTitle = obtainStyledAttributes.getText(R.styleable.MenuItem_android_title);
        itemTitleCondensed = obtainStyledAttributes.getText(R.styleable.MenuItem_android_titleCondensed);
        itemIconResId = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_android_icon, 0);
        itemAlphabeticShortcut = this.getShortcut(obtainStyledAttributes.getString(R.styleable.MenuItem_android_alphabeticShortcut));
        itemNumericShortcut = this.getShortcut(obtainStyledAttributes.getString(R.styleable.MenuItem_android_numericShortcut));
        if (obtainStyledAttributes.hasValue(R.styleable.MenuItem_android_checkable)) {
            int itemCheckable;
            if (obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_checkable, false)) {
                itemCheckable = 1;
            }
            else {
                itemCheckable = 0;
            }
            this.itemCheckable = itemCheckable;
        }
        else {
            itemCheckable = groupCheckable;
        }
        itemChecked = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_checked, false);
        itemVisible = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_visible, groupVisible);
        itemEnabled = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_enabled, groupEnabled);
        itemShowAsAction = obtainStyledAttributes.getInt(R.styleable.MenuItem_showAsAction, -1);
        itemListenerMethodName = obtainStyledAttributes.getString(R.styleable.MenuItem_android_onClick);
        itemActionViewLayout = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_actionLayout, 0);
        itemActionViewClassName = obtainStyledAttributes.getString(R.styleable.MenuItem_actionViewClass);
        itemActionProviderClassName = obtainStyledAttributes.getString(R.styleable.MenuItem_actionProviderClass);
        boolean b;
        if (itemActionProviderClassName != null) {
            b = true;
        }
        else {
            b = false;
        }
        if (b && itemActionViewLayout == 0 && itemActionViewClassName == null) {
            itemActionProvider = this.<ActionProvider>newInstance(itemActionProviderClassName, SupportMenuInflater.access$200(), SupportMenuInflater.access$300(this$0));
        }
        else {
            if (b) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }
            itemActionProvider = null;
        }
        obtainStyledAttributes.recycle();
        itemAdded = false;
    }
    
    public void resetGroup() {
        groupId = 0;
        groupCategory = 0;
        groupOrder = 0;
        groupCheckable = 0;
        groupVisible = true;
        groupEnabled = true;
    }
}
