package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.design.R$dimen;
import android.support.design.R$layout;
import android.support.design.internal.NavigationMenuPresenter$1;
import android.support.design.internal.NavigationMenuPresenter$NavigationMenuAdapter;
import android.support.design.internal.NavigationMenuView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuPresenter$Callback;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class NavigationMenuPresenter implements MenuPresenter {
   private static final String STATE_ADAPTER = "android:menu:adapter";
   private static final String STATE_HIERARCHY = "android:menu:list";
   private NavigationMenuPresenter$NavigationMenuAdapter mAdapter;
   private MenuPresenter$Callback mCallback;
   private LinearLayout mHeaderLayout;
   private ColorStateList mIconTintList;
   private int mId;
   private Drawable mItemBackground;
   private LayoutInflater mLayoutInflater;
   private MenuBuilder mMenu;
   private NavigationMenuView mMenuView;
   private final OnClickListener mOnClickListener = new NavigationMenuPresenter$1(this);
   private int mPaddingSeparator;
   private int mPaddingTopDefault;
   private int mTextAppearance;
   private boolean mTextAppearanceSet;
   private ColorStateList mTextColor;

   public void addHeaderView(@NonNull View var1) {
      this.mHeaderLayout.addView(var1);
      this.mMenuView.setPadding(0, 0, 0, this.mMenuView.getPaddingBottom());
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

   public int getHeaderCount() {
      return this.mHeaderLayout.getChildCount();
   }

   public View getHeaderView(int var1) {
      return this.mHeaderLayout.getChildAt(var1);
   }

   public int getId() {
      return this.mId;
   }

   @Nullable
   public Drawable getItemBackground() {
      return this.mItemBackground;
   }

   @Nullable
   public ColorStateList getItemTextColor() {
      return this.mTextColor;
   }

   @Nullable
   public ColorStateList getItemTintList() {
      return this.mIconTintList;
   }

   public MenuView getMenuView(ViewGroup var1) {
      if(this.mMenuView == null) {
         this.mMenuView = (NavigationMenuView)this.mLayoutInflater.inflate(R$layout.design_navigation_menu, var1, false);
         if(this.mAdapter == null) {
            this.mAdapter = new NavigationMenuPresenter$NavigationMenuAdapter(this);
         }

         this.mHeaderLayout = (LinearLayout)this.mLayoutInflater.inflate(R$layout.design_navigation_item_header, this.mMenuView, false);
         this.mMenuView.setAdapter(this.mAdapter);
      }

      return this.mMenuView;
   }

   public View inflateHeaderView(@LayoutRes int var1) {
      View var2 = this.mLayoutInflater.inflate(var1, this.mHeaderLayout, false);
      this.addHeaderView(var2);
      return var2;
   }

   public void initForMenu(Context var1, MenuBuilder var2) {
      this.mLayoutInflater = LayoutInflater.from(var1);
      this.mMenu = var2;
      this.mPaddingSeparator = var1.getResources().getDimensionPixelOffset(R$dimen.design_navigation_separator_vertical_padding);
   }

   public void onCloseMenu(MenuBuilder var1, boolean var2) {
      if(this.mCallback != null) {
         this.mCallback.onCloseMenu(var1, var2);
      }

   }

   public void onRestoreInstanceState(Parcelable var1) {
      Bundle var3 = (Bundle)var1;
      SparseArray var2 = var3.getSparseParcelableArray("android:menu:list");
      if(var2 != null) {
         this.mMenuView.restoreHierarchyState(var2);
      }

      var3 = var3.getBundle("android:menu:adapter");
      if(var3 != null) {
         this.mAdapter.restoreInstanceState(var3);
      }

   }

   public Parcelable onSaveInstanceState() {
      Bundle var1 = new Bundle();
      if(this.mMenuView != null) {
         SparseArray var2 = new SparseArray();
         this.mMenuView.saveHierarchyState(var2);
         var1.putSparseParcelableArray("android:menu:list", var2);
      }

      if(this.mAdapter != null) {
         var1.putBundle("android:menu:adapter", this.mAdapter.createInstanceState());
      }

      return var1;
   }

   public boolean onSubMenuSelected(SubMenuBuilder var1) {
      return false;
   }

   public void removeHeaderView(@NonNull View var1) {
      this.mHeaderLayout.removeView(var1);
      if(this.mHeaderLayout.getChildCount() == 0) {
         this.mMenuView.setPadding(0, this.mPaddingTopDefault, 0, this.mMenuView.getPaddingBottom());
      }

   }

   public void setCallback(MenuPresenter$Callback var1) {
      this.mCallback = var1;
   }

   public void setCheckedItem(MenuItemImpl var1) {
      this.mAdapter.setCheckedItem(var1);
   }

   public void setId(int var1) {
      this.mId = var1;
   }

   public void setItemBackground(@Nullable Drawable var1) {
      this.mItemBackground = var1;
      this.updateMenuView(false);
   }

   public void setItemIconTintList(@Nullable ColorStateList var1) {
      this.mIconTintList = var1;
      this.updateMenuView(false);
   }

   public void setItemTextAppearance(@StyleRes int var1) {
      this.mTextAppearance = var1;
      this.mTextAppearanceSet = true;
      this.updateMenuView(false);
   }

   public void setItemTextColor(@Nullable ColorStateList var1) {
      this.mTextColor = var1;
      this.updateMenuView(false);
   }

   public void setPaddingTopDefault(int var1) {
      if(this.mPaddingTopDefault != var1) {
         this.mPaddingTopDefault = var1;
         if(this.mHeaderLayout.getChildCount() == 0) {
            this.mMenuView.setPadding(0, this.mPaddingTopDefault, 0, this.mMenuView.getPaddingBottom());
         }
      }

   }

   public void setUpdateSuspended(boolean var1) {
      if(this.mAdapter != null) {
         this.mAdapter.setUpdateSuspended(var1);
      }

   }

   public void updateMenuView(boolean var1) {
      if(this.mAdapter != null) {
         this.mAdapter.update();
      }

   }
}
