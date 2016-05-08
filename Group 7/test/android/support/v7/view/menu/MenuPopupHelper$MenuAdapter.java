package android.support.v7.view.menu;

import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.MenuView$ItemView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

class MenuPopupHelper$MenuAdapter extends BaseAdapter {
   private MenuBuilder mAdapterMenu;
   private int mExpandedIndex;

   public MenuPopupHelper$MenuAdapter(MenuPopupHelper var1, MenuBuilder var2) {
      this.this$0 = var1;
      this.mExpandedIndex = -1;
      this.mAdapterMenu = var2;
      this.findExpandedIndex();
   }

   void findExpandedIndex() {
      MenuItemImpl var3 = MenuPopupHelper.access$300(this.this$0).getExpandedItem();
      if(var3 != null) {
         ArrayList var4 = MenuPopupHelper.access$300(this.this$0).getNonActionItems();
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
      if(MenuPopupHelper.access$100(this.this$0)) {
         var1 = this.mAdapterMenu.getNonActionItems();
      } else {
         var1 = this.mAdapterMenu.getVisibleItems();
      }

      return this.mExpandedIndex < 0?var1.size():var1.size() - 1;
   }

   public MenuItemImpl getItem(int var1) {
      ArrayList var3;
      if(MenuPopupHelper.access$100(this.this$0)) {
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
         var4 = MenuPopupHelper.access$200(this.this$0).inflate(MenuPopupHelper.ITEM_LAYOUT, var3, false);
      }

      MenuView$ItemView var5 = (MenuView$ItemView)var4;
      if(this.this$0.mForceShowIcon) {
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
