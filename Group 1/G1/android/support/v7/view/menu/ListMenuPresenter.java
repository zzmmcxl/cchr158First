package android.support.v7.view.menu;

import java.util.ArrayList;
import android.widget.BaseAdapter;
import android.util.SparseArray;
import android.os.IBinder;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.view.ContextThemeWrapper;
import android.support.v7.appcompat.R;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.view.LayoutInflater;
import android.content.Context;
import android.widget.AdapterView$OnItemClickListener;

public class ListMenuPresenter implements MenuPresenter, AdapterView$OnItemClickListener
{
    private static final String TAG = "ListMenuPresenter";
    public static final String VIEWS_TAG = "android:menu:list";
    MenuAdapter mAdapter;
    private Callback mCallback;
    Context mContext;
    private int mId;
    LayoutInflater mInflater;
    private int mItemIndexOffset;
    int mItemLayoutRes;
    MenuBuilder mMenu;
    ExpandedMenuView mMenuView;
    int mThemeRes;
    
    public ListMenuPresenter(final int mItemLayoutRes, final int mThemeRes) {
        super();
        mItemLayoutRes = mItemLayoutRes;
        mThemeRes = mThemeRes;
    }
    
    public ListMenuPresenter(final Context mContext, final int n) {
        this(n, 0);
        mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }
    
    static /* synthetic */ int access$000(final ListMenuPresenter listMenuPresenter) {
        return listMenuPresenter.mItemIndexOffset;
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
    
    public ListAdapter getAdapter() {
        if (mAdapter == null) {
            mAdapter = new MenuAdapter();
        }
        return (ListAdapter)mAdapter;
    }
    
    @Override
    public int getId() {
        return mId;
    }
    
    int getItemIndexOffset() {
        return mItemIndexOffset;
    }
    
    @Override
    public MenuView getMenuView(final ViewGroup viewGroup) {
        if (mMenuView == null) {
            mMenuView = (ExpandedMenuView)mInflater.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (mAdapter == null) {
                mAdapter = new MenuAdapter();
            }
            mMenuView.setAdapter((ListAdapter)mAdapter);
            mMenuView.setOnItemClickListener((AdapterView$OnItemClickListener)this);
        }
        return mMenuView;
    }
    
    @Override
    public void initForMenu(final Context mContext, final MenuBuilder mMenu) {
        if (mThemeRes != 0) {
            this.mContext = (Context)new ContextThemeWrapper(mContext, mThemeRes);
            mInflater = LayoutInflater.from(this.mContext);
        }
        else if (this.mContext != null) {
            this.mContext = mContext;
            if (mInflater == null) {
                mInflater = LayoutInflater.from(this.mContext);
            }
        }
        this.mMenu = mMenu;
        if (mAdapter != null) {
            mAdapter.notifyDataSetChanged();
        }
    }
    
    @Override
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
        if (mCallback != null) {
            mCallback.onCloseMenu(menuBuilder, b);
        }
    }
    
    public void onItemClick(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
        mMenu.performItemAction(mAdapter.getItem(n), (MenuPresenter)this, 0);
    }
    
    @Override
    public void onRestoreInstanceState(final Parcelable parcelable) {
        this.restoreHierarchyState((Bundle)parcelable);
    }
    
    @Override
    public Parcelable onSaveInstanceState() {
        if (mMenuView == null) {
            return null;
        }
        final Bundle bundle = new Bundle();
        this.saveHierarchyState(bundle);
        return (Parcelable)bundle;
    }
    
    @Override
    public boolean onSubMenuSelected(final SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        new MenuDialogHelper(subMenuBuilder).show(null);
        if (mCallback != null) {
            mCallback.onOpenSubMenu(subMenuBuilder);
        }
        return true;
    }
    
    public void restoreHierarchyState(final Bundle bundle) {
        final SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            ((View)mMenuView).restoreHierarchyState(sparseParcelableArray);
        }
    }
    
    public void saveHierarchyState(final Bundle bundle) {
        final SparseArray sparseArray = new SparseArray();
        if (mMenuView != null) {
            ((View)mMenuView).saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }
    
    @Override
    public void setCallback(final Callback mCallback) {
        this.mCallback = mCallback;
    }
    
    public void setId(final int mId) {
        this.mId = mId;
    }
    
    public void setItemIndexOffset(final int mItemIndexOffset) {
        this.mItemIndexOffset = mItemIndexOffset;
        if (mMenuView != null) {
            this.updateMenuView(false);
        }
    }
    
    @Override
    public void updateMenuView(final boolean b) {
        if (mAdapter != null) {
            mAdapter.notifyDataSetChanged();
        }
    }
}
