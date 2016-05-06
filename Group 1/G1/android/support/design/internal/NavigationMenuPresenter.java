package android.support.design.internal;

import android.widget.TextView;
import java.util.Iterator;
import android.view.SubMenu;
import android.graphics.drawable.ColorDrawable;
import java.util.ArrayList;
import android.support.annotation.StyleRes;
import android.support.v7.view.menu.SubMenuBuilder;
import android.util.SparseArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.support.design.R;
import android.support.v7.view.menu.MenuView;
import android.view.ViewGroup;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.MenuItem;
import android.view.View;
import android.view.View$OnClickListener;
import android.support.v7.view.menu.MenuBuilder;
import android.view.LayoutInflater;
import android.graphics.drawable.Drawable;
import android.content.res.ColorStateList;
import android.widget.LinearLayout;
import android.support.v7.view.menu.MenuPresenter;

public class NavigationMenuPresenter implements MenuPresenter
{
    private static final String STATE_ADAPTER = "android:menu:adapter";
    private static final String STATE_HIERARCHY = "android:menu:list";
    private NavigationMenuAdapter mAdapter;
    private Callback mCallback;
    private LinearLayout mHeaderLayout;
    private ColorStateList mIconTintList;
    private int mId;
    private Drawable mItemBackground;
    private LayoutInflater mLayoutInflater;
    private MenuBuilder mMenu;
    private NavigationMenuView mMenuView;
    private final View$OnClickListener mOnClickListener;
    private int mPaddingSeparator;
    private int mPaddingTopDefault;
    private int mTextAppearance;
    private boolean mTextAppearanceSet;
    private ColorStateList mTextColor;
    
    public NavigationMenuPresenter() {
        super();
        mOnClickListener = (View$OnClickListener)new View$OnClickListener() {
            final /* synthetic */ NavigationMenuPresenter this$0;
            
            NavigationMenuPresenter$1() {
                this$0 = this$0;
                super();
            }
            
            public void onClick(final View view) {
                final NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView)view;
                this$0.setUpdateSuspended(true);
                final MenuItemImpl itemData = navigationMenuItemView.getItemData();
                final boolean performItemAction = mMenu.performItemAction(itemData, (MenuPresenter)this$0, 0);
                if (itemData != null && itemData.isCheckable() && performItemAction) {
                    mAdapter.setCheckedItem(itemData);
                }
                this$0.setUpdateSuspended(false);
                this$0.updateMenuView(false);
            }
        };
    }
    
    static /* synthetic */ MenuBuilder access$000(final NavigationMenuPresenter navigationMenuPresenter) {
        return navigationMenuPresenter.mMenu;
    }
    
    static /* synthetic */ NavigationMenuAdapter access$100(final NavigationMenuPresenter navigationMenuPresenter) {
        return navigationMenuPresenter.mAdapter;
    }
    
    static /* synthetic */ int access$1100(final NavigationMenuPresenter navigationMenuPresenter) {
        return navigationMenuPresenter.mPaddingSeparator;
    }
    
    static /* synthetic */ LayoutInflater access$200(final NavigationMenuPresenter navigationMenuPresenter) {
        return navigationMenuPresenter.mLayoutInflater;
    }
    
    static /* synthetic */ View$OnClickListener access$300(final NavigationMenuPresenter navigationMenuPresenter) {
        return navigationMenuPresenter.mOnClickListener;
    }
    
    static /* synthetic */ LinearLayout access$400(final NavigationMenuPresenter navigationMenuPresenter) {
        return navigationMenuPresenter.mHeaderLayout;
    }
    
    static /* synthetic */ ColorStateList access$500(final NavigationMenuPresenter navigationMenuPresenter) {
        return navigationMenuPresenter.mIconTintList;
    }
    
    static /* synthetic */ boolean access$600(final NavigationMenuPresenter navigationMenuPresenter) {
        return navigationMenuPresenter.mTextAppearanceSet;
    }
    
    static /* synthetic */ int access$700(final NavigationMenuPresenter navigationMenuPresenter) {
        return navigationMenuPresenter.mTextAppearance;
    }
    
    static /* synthetic */ ColorStateList access$800(final NavigationMenuPresenter navigationMenuPresenter) {
        return navigationMenuPresenter.mTextColor;
    }
    
    static /* synthetic */ Drawable access$900(final NavigationMenuPresenter navigationMenuPresenter) {
        return navigationMenuPresenter.mItemBackground;
    }
    
    public void addHeaderView(@NonNull final View view) {
        mHeaderLayout.addView(view);
        mMenuView.setPadding(0, 0, 0, mMenuView.getPaddingBottom());
    }
    
    @Override
    public boolean collapseItemActionView(final MenuBuilder menuBuilder, final MenuItemImpl menuItemImpl) {
        return false;
    }
    
    @Override
    public boolean expandItemActionView(final MenuBuilder menuBuilder, final MenuItemImpl menuItemImpl) {
        return false;
    }
    
    @Override
    public boolean flagActionItems() {
        return false;
    }
    
    public int getHeaderCount() {
        return mHeaderLayout.getChildCount();
    }
    
    public View getHeaderView(final int n) {
        return mHeaderLayout.getChildAt(n);
    }
    
    @Override
    public int getId() {
        return mId;
    }
    
    @Nullable
    public Drawable getItemBackground() {
        return mItemBackground;
    }
    
    @Nullable
    public ColorStateList getItemTextColor() {
        return mTextColor;
    }
    
    @Nullable
    public ColorStateList getItemTintList() {
        return mIconTintList;
    }
    
    @Override
    public MenuView getMenuView(final ViewGroup viewGroup) {
        if (mMenuView == null) {
            mMenuView = (NavigationMenuView)mLayoutInflater.inflate(R.layout.design_navigation_menu, viewGroup, false);
            if (mAdapter == null) {
                mAdapter = new NavigationMenuAdapter();
            }
            mHeaderLayout = (LinearLayout)mLayoutInflater.inflate(R.layout.design_navigation_item_header, (ViewGroup)mMenuView, false);
            mMenuView.setAdapter((RecyclerView.Adapter)mAdapter);
        }
        return mMenuView;
    }
    
    public View inflateHeaderView(@LayoutRes final int n) {
        final View inflate = mLayoutInflater.inflate(n, (ViewGroup)mHeaderLayout, false);
        this.addHeaderView(inflate);
        return inflate;
    }
    
    @Override
    public void initForMenu(final Context context, final MenuBuilder mMenu) {
        mLayoutInflater = LayoutInflater.from(context);
        this.mMenu = mMenu;
        mPaddingSeparator = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }
    
    @Override
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
        if (mCallback != null) {
            mCallback.onCloseMenu(menuBuilder, b);
        }
    }
    
    @Override
    public void onRestoreInstanceState(final Parcelable parcelable) {
        final Bundle bundle = (Bundle)parcelable;
        final SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            mMenuView.restoreHierarchyState(sparseParcelableArray);
        }
        final Bundle bundle2 = bundle.getBundle("android:menu:adapter");
        if (bundle2 != null) {
            mAdapter.restoreInstanceState(bundle2);
        }
    }
    
    @Override
    public Parcelable onSaveInstanceState() {
        final Bundle bundle = new Bundle();
        if (mMenuView != null) {
            final SparseArray sparseArray = new SparseArray();
            mMenuView.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        if (mAdapter != null) {
            bundle.putBundle("android:menu:adapter", mAdapter.createInstanceState());
        }
        return (Parcelable)bundle;
    }
    
    @Override
    public boolean onSubMenuSelected(final SubMenuBuilder subMenuBuilder) {
        return false;
    }
    
    public void removeHeaderView(@NonNull final View view) {
        mHeaderLayout.removeView(view);
        if (mHeaderLayout.getChildCount() == 0) {
            mMenuView.setPadding(0, mPaddingTopDefault, 0, mMenuView.getPaddingBottom());
        }
    }
    
    @Override
    public void setCallback(final Callback mCallback) {
        this.mCallback = mCallback;
    }
    
    public void setCheckedItem(final MenuItemImpl checkedItem) {
        mAdapter.setCheckedItem(checkedItem);
    }
    
    public void setId(final int mId) {
        this.mId = mId;
    }
    
    public void setItemBackground(@Nullable final Drawable mItemBackground) {
        this.mItemBackground = mItemBackground;
        this.updateMenuView(false);
    }
    
    public void setItemIconTintList(@Nullable final ColorStateList mIconTintList) {
        this.mIconTintList = mIconTintList;
        this.updateMenuView(false);
    }
    
    public void setItemTextAppearance(@StyleRes final int mTextAppearance) {
        this.mTextAppearance = mTextAppearance;
        mTextAppearanceSet = true;
        this.updateMenuView(false);
    }
    
    public void setItemTextColor(@Nullable final ColorStateList mTextColor) {
        this.mTextColor = mTextColor;
        this.updateMenuView(false);
    }
    
    public void setPaddingTopDefault(final int mPaddingTopDefault) {
        if (this.mPaddingTopDefault != mPaddingTopDefault) {
            this.mPaddingTopDefault = mPaddingTopDefault;
            if (mHeaderLayout.getChildCount() == 0) {
                mMenuView.setPadding(0, this.mPaddingTopDefault, 0, mMenuView.getPaddingBottom());
            }
        }
    }
    
    public void setUpdateSuspended(final boolean updateSuspended) {
        if (mAdapter != null) {
            mAdapter.setUpdateSuspended(updateSuspended);
        }
    }
    
    @Override
    public void updateMenuView(final boolean b) {
        if (mAdapter != null) {
            mAdapter.update();
        }
    }
}
