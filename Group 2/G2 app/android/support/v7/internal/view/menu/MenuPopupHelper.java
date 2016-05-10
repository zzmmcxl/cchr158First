package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.appcompat.R;
import android.support.v7.internal.view.menu.ListMenuItemView;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;

public class MenuPopupHelper implements OnItemClickListener, OnKeyListener, OnGlobalLayoutListener, OnDismissListener, MenuPresenter {
   static final int ITEM_LAYOUT;
   private static final String TAG = "MenuPopupHelper";
   private final MenuPopupHelper.MenuAdapter mAdapter;
   private View mAnchorView;
   private int mContentWidth;
   private final Context mContext;
   private int mDropDownGravity;
   boolean mForceShowIcon;
   private boolean mHasContentWidth;
   private final LayoutInflater mInflater;
   private ViewGroup mMeasureParent;
   private final MenuBuilder mMenu;
   private final boolean mOverflowOnly;
   private ListPopupWindow mPopup;
   private final int mPopupMaxWidth;
   private final int mPopupStyleAttr;
   private final int mPopupStyleRes;
   private MenuPresenter.Callback mPresenterCallback;
   private ViewTreeObserver mTreeObserver;

   static {
      ITEM_LAYOUT = R.layout.abc_popup_menu_item_layout;
   }

   public MenuPopupHelper(Context var1, MenuBuilder var2) {
      this(var1, var2, (View)null, false, R.attr.popupMenuStyle);
   }

   public MenuPopupHelper(Context var1, MenuBuilder var2, View var3) {
      this(var1, var2, var3, false, R.attr.popupMenuStyle);
   }

   public MenuPopupHelper(Context var1, MenuBuilder var2, View var3, boolean var4, int var5) {
      this(var1, var2, var3, var4, var5, 0);
   }

   public MenuPopupHelper(Context var1, MenuBuilder var2, View var3, boolean var4, int var5, int var6) {
      this.mDropDownGravity = 0;
      this.mContext = var1;
      this.mInflater = LayoutInflater.from(var1);
      this.mMenu = var2;
      this.mAdapter = new MenuPopupHelper.MenuAdapter(this.mMenu);
      this.mOverflowOnly = var4;
      this.mPopupStyleAttr = var5;
      this.mPopupStyleRes = var6;
      Resources var7 = var1.getResources();
      this.mPopupMaxWidth = Math.max(var7.getDisplayMetrics().widthPixels / 2, var7.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
      this.mAnchorView = var3;
      var2.addMenuPresenter(this, var1);
   }

   private int measureContentWidth() {
      int var1 = 0;
      View var9 = null;
      int var4 = 0;
      MenuPopupHelper.MenuAdapter var10 = this.mAdapter;
      int var6 = MeasureSpec.makeMeasureSpec(0, 0);
      int var7 = MeasureSpec.makeMeasureSpec(0, 0);
      int var8 = var10.getCount();
      int var2 = 0;

      int var3;
      while(true) {
         var3 = var1;
         if(var2 >= var8) {
            break;
         }

         int var5 = var10.getItemViewType(var2);
         var3 = var4;
         if(var5 != var4) {
            var3 = var5;
            var9 = null;
         }

         if(this.mMeasureParent == null) {
            this.mMeasureParent = new FrameLayout(this.mContext);
         }

         var9 = var10.getView(var2, var9, this.mMeasureParent);
         var9.measure(var6, var7);
         var4 = var9.getMeasuredWidth();
         if(var4 >= this.mPopupMaxWidth) {
            var3 = this.mPopupMaxWidth;
            break;
         }

         var5 = var1;
         if(var4 > var1) {
            var5 = var4;
         }

         ++var2;
         var4 = var3;
         var1 = var5;
      }

      return var3;
   }

   public boolean collapseItemActionView(MenuBuilder var1, MenuItemImpl var2) {
      return false;
   }

   public void dismiss() {
      if(this.isShowing()) {
         this.mPopup.dismiss();
      }

   }

   public boolean expandItemActionView(MenuBuilder var1, MenuItemImpl var2) {
      return false;
   }

   public boolean flagActionItems() {
      return false;
   }

   public int getId() {
      return 0;
   }

   public MenuView getMenuView(ViewGroup var1) {
      throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
   }

   public ListPopupWindow getPopup() {
      return this.mPopup;
   }

   public void initForMenu(Context var1, MenuBuilder var2) {
   }

   public boolean isShowing() {
      return this.mPopup != null && this.mPopup.isShowing();
   }

   public void onCloseMenu(MenuBuilder var1, boolean var2) {
      if(var1 == this.mMenu) {
         this.dismiss();
         if(this.mPresenterCallback != null) {
            this.mPresenterCallback.onCloseMenu(var1, var2);
            return;
         }
      }

   }

   public void onDismiss() {
      this.mPopup = null;
      this.mMenu.close();
      if(this.mTreeObserver != null) {
         if(!this.mTreeObserver.isAlive()) {
            this.mTreeObserver = this.mAnchorView.getViewTreeObserver();
         }

         this.mTreeObserver.removeGlobalOnLayoutListener(this);
         this.mTreeObserver = null;
      }

   }

   public void onGlobalLayout() {
      if(this.isShowing()) {
         View var1 = this.mAnchorView;
         if(var1 != null && var1.isShown()) {
            if(this.isShowing()) {
               this.mPopup.show();
               return;
            }
         } else {
            this.dismiss();
         }
      }

   }

   public void onItemClick(AdapterView var1, View var2, int var3, long var4) {
      MenuPopupHelper.MenuAdapter var6 = this.mAdapter;
      var6.mAdapterMenu.performItemAction(var6.getItem(var3), 0);
   }

   public boolean onKey(View var1, int var2, KeyEvent var3) {
      if(var3.getAction() == 1 && var2 == 82) {
         this.dismiss();
         return true;
      } else {
         return false;
      }
   }

   public void onRestoreInstanceState(Parcelable var1) {
   }

   public Parcelable onSaveInstanceState() {
      return null;
   }

   public boolean onSubMenuSelected(SubMenuBuilder var1) {
      if(var1.hasVisibleItems()) {
         MenuPopupHelper var6 = new MenuPopupHelper(this.mContext, var1, this.mAnchorView);
         var6.setCallback(this.mPresenterCallback);
         boolean var5 = false;
         int var3 = var1.size();
         int var2 = 0;

         boolean var4;
         while(true) {
            var4 = var5;
            if(var2 >= var3) {
               break;
            }

            MenuItem var7 = var1.getItem(var2);
            if(var7.isVisible() && var7.getIcon() != null) {
               var4 = true;
               break;
            }

            ++var2;
         }

         var6.setForceShowIcon(var4);
         if(var6.tryShow()) {
            if(this.mPresenterCallback != null) {
               this.mPresenterCallback.onOpenSubMenu(var1);
            }

            return true;
         }
      }

      return false;
   }

   public void setAnchorView(View var1) {
      this.mAnchorView = var1;
   }

   public void setCallback(MenuPresenter.Callback var1) {
      this.mPresenterCallback = var1;
   }

   public void setForceShowIcon(boolean var1) {
      this.mForceShowIcon = var1;
   }

   public void setGravity(int var1) {
      this.mDropDownGravity = var1;
   }

   public void show() {
      if(!this.tryShow()) {
         throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
      }
   }

   public boolean tryShow() {
      boolean var1 = false;
      this.mPopup = new ListPopupWindow(this.mContext, (AttributeSet)null, this.mPopupStyleAttr, this.mPopupStyleRes);
      this.mPopup.setOnDismissListener(this);
      this.mPopup.setOnItemClickListener(this);
      this.mPopup.setAdapter(this.mAdapter);
      this.mPopup.setModal(true);
      View var2 = this.mAnchorView;
      if(var2 != null) {
         if(this.mTreeObserver == null) {
            var1 = true;
         }

         this.mTreeObserver = var2.getViewTreeObserver();
         if(var1) {
            this.mTreeObserver.addOnGlobalLayoutListener(this);
         }

         this.mPopup.setAnchorView(var2);
         this.mPopup.setDropDownGravity(this.mDropDownGravity);
         if(!this.mHasContentWidth) {
            this.mContentWidth = this.measureContentWidth();
            this.mHasContentWidth = true;
         }

         this.mPopup.setContentWidth(this.mContentWidth);
         this.mPopup.setInputMethodMode(2);
         this.mPopup.show();
         this.mPopup.getListView().setOnKeyListener(this);
         return true;
      } else {
         return false;
      }
   }

   public void updateMenuView(boolean var1) {
      this.mHasContentWidth = false;
      if(this.mAdapter != null) {
         this.mAdapter.notifyDataSetChanged();
      }

   }

   private class MenuAdapter extends BaseAdapter {
      private MenuBuilder mAdapterMenu;
      private int mExpandedIndex = -1;

      public MenuAdapter(MenuBuilder var2) {
         this.mAdapterMenu = var2;
         this.findExpandedIndex();
      }

      void findExpandedIndex() {
         MenuItemImpl var3 = MenuPopupHelper.this.mMenu.getExpandedItem();
         if(var3 != null) {
            ArrayList var4 = MenuPopupHelper.this.mMenu.getNonActionItems();
            int var2 = var4.size();

            for(int var1 = 0; var1 < var2; ++var1) {
               if((MenuItemImpl)var4.get(var1) == var3) {
                  this.mExpandedIndex = var1;
                  return;
               }
            }
         }

         this.mExpandedIndex = -1;
      }

      public int getCount() {
         ArrayList var1;
         if(MenuPopupHelper.this.mOverflowOnly) {
            var1 = this.mAdapterMenu.getNonActionItems();
         } else {
            var1 = this.mAdapterMenu.getVisibleItems();
         }

         return this.mExpandedIndex < 0?var1.size():var1.size() - 1;
      }

      public MenuItemImpl getItem(int var1) {
         ArrayList var3;
         if(MenuPopupHelper.this.mOverflowOnly) {
            var3 = this.mAdapterMenu.getNonActionItems();
         } else {
            var3 = this.mAdapterMenu.getVisibleItems();
         }

         int var2 = var1;
         if(this.mExpandedIndex >= 0) {
            var2 = var1;
            if(var1 >= this.mExpandedIndex) {
               var2 = var1 + 1;
            }
         }

         return (MenuItemImpl)var3.get(var2);
      }

      public long getItemId(int var1) {
         return (long)var1;
      }

      public View getView(int var1, View var2, ViewGroup var3) {
         View var4 = var2;
         if(var2 == null) {
            var4 = MenuPopupHelper.this.mInflater.inflate(MenuPopupHelper.ITEM_LAYOUT, var3, false);
         }

         MenuView.ItemView var5 = (MenuView.ItemView)var4;
         if(MenuPopupHelper.this.mForceShowIcon) {
            ((ListMenuItemView)var4).setForceShowIcon(true);
         }

         var5.initialize(this.getItem(var1), 0);
         return var4;
      }

      public void notifyDataSetChanged() {
         this.findExpandedIndex();
         super.notifyDataSetChanged();
      }
   }
}
