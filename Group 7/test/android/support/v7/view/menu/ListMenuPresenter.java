package android.support.v7.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.v7.appcompat.R$layout;
import android.support.v7.view.menu.ExpandedMenuView;
import android.support.v7.view.menu.ListMenuPresenter$MenuAdapter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuDialogHelper;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuPresenter$Callback;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class ListMenuPresenter implements MenuPresenter, OnItemClickListener {
   private static final String TAG = "ListMenuPresenter";
   public static final String VIEWS_TAG = "android:menu:list";
   ListMenuPresenter$MenuAdapter mAdapter;
   private MenuPresenter$Callback mCallback;
   Context mContext;
   private int mId;
   LayoutInflater mInflater;
   private int mItemIndexOffset;
   int mItemLayoutRes;
   MenuBuilder mMenu;
   ExpandedMenuView mMenuView;
   int mThemeRes;

   public ListMenuPresenter(int var1, int var2) {
      this.mItemLayoutRes = var1;
      this.mThemeRes = var2;
   }

   public ListMenuPresenter(Context var1, int var2) {
      this(var2, 0);
      this.mContext = var1;
      this.mInflater = LayoutInflater.from(this.mContext);
   }

   public boolean collapseItemActionView(MenuBuilder var1, MenuItemImpl var2) {
      return false;
   }

   public boolean expandItemActionView(MenuBuilder var1, MenuItemImpl var2) {
      return false;
   }

   public boolean flagActionItems() {
      return false;
   }

   public ListAdapter getAdapter() {
      if(this.mAdapter == null) {
         this.mAdapter = new ListMenuPresenter$MenuAdapter(this);
      }

      return this.mAdapter;
   }

   public int getId() {
      return this.mId;
   }

   int getItemIndexOffset() {
      return this.mItemIndexOffset;
   }

   public MenuView getMenuView(ViewGroup var1) {
      if(this.mMenuView == null) {
         this.mMenuView = (ExpandedMenuView)this.mInflater.inflate(R$layout.abc_expanded_menu_layout, var1, false);
         if(this.mAdapter == null) {
            this.mAdapter = new ListMenuPresenter$MenuAdapter(this);
         }

         this.mMenuView.setAdapter(this.mAdapter);
         this.mMenuView.setOnItemClickListener(this);
      }

      return this.mMenuView;
   }

   public void initForMenu(Context var1, MenuBuilder var2) {
      if(this.mThemeRes != 0) {
         this.mContext = new ContextThemeWrapper(var1, this.mThemeRes);
         this.mInflater = LayoutInflater.from(this.mContext);
      } else if(this.mContext != null) {
         this.mContext = var1;
         if(this.mInflater == null) {
            this.mInflater = LayoutInflater.from(this.mContext);
         }
      }

      this.mMenu = var2;
      if(this.mAdapter != null) {
         this.mAdapter.notifyDataSetChanged();
      }

   }

   public void onCloseMenu(MenuBuilder var1, boolean var2) {
      if(this.mCallback != null) {
         this.mCallback.onCloseMenu(var1, var2);
      }

   }

   public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
      this.mMenu.performItemAction(this.mAdapter.getItem(var3), this, 0);
   }

   public void onRestoreInstanceState(Parcelable var1) {
      this.restoreHierarchyState((Bundle)var1);
   }

   public Parcelable onSaveInstanceState() {
      if(this.mMenuView == null) {
         return null;
      } else {
         Bundle var1 = new Bundle();
         this.saveHierarchyState(var1);
         return var1;
      }
   }

   public boolean onSubMenuSelected(SubMenuBuilder var1) {
      if(!var1.hasVisibleItems()) {
         return false;
      } else {
         (new MenuDialogHelper(var1)).show((IBinder)null);
         if(this.mCallback != null) {
            this.mCallback.onOpenSubMenu(var1);
         }

         return true;
      }
   }

   public void restoreHierarchyState(Bundle var1) {
      SparseArray var2 = var1.getSparseParcelableArray("android:menu:list");
      if(var2 != null) {
         this.mMenuView.restoreHierarchyState(var2);
      }

   }

   public void saveHierarchyState(Bundle var1) {
      SparseArray var2 = new SparseArray();
      if(this.mMenuView != null) {
         this.mMenuView.saveHierarchyState(var2);
      }

      var1.putSparseParcelableArray("android:menu:list", var2);
   }

   public void setCallback(MenuPresenter$Callback var1) {
      this.mCallback = var1;
   }

   public void setId(int var1) {
      this.mId = var1;
   }

   public void setItemIndexOffset(int var1) {
      this.mItemIndexOffset = var1;
      if(this.mMenuView != null) {
         this.updateMenuView(false);
      }

   }

   public void updateMenuView(boolean var1) {
      if(this.mAdapter != null) {
         this.mAdapter.notifyDataSetChanged();
      }

   }
}
