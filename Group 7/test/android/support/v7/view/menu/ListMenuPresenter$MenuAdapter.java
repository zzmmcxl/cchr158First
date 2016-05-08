package android.support.v7.view.menu;

import android.support.v7.view.menu.ListMenuPresenter;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView$ItemView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

class ListMenuPresenter$MenuAdapter extends BaseAdapter {
   private int mExpandedIndex;

   public ListMenuPresenter$MenuAdapter(ListMenuPresenter var1) {
      this.this$0 = var1;
      this.mExpandedIndex = -1;
      this.findExpandedIndex();
   }

   void findExpandedIndex() {
      MenuItemImpl var3 = this.this$0.mMenu.getExpandedItem();
      if(var3 != null) {
         ArrayList var4 = this.this$0.mMenu.getNonActionItems();
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
      int var1 = this.this$0.mMenu.getNonActionItems().size() - ListMenuPresenter.access$000(this.this$0);
      return this.mExpandedIndex < 0?var1:var1 - 1;
   }

   public MenuItemImpl getItem(int var1) {
      ArrayList var3 = this.this$0.mMenu.getNonActionItems();
      int var2 = var1 + ListMenuPresenter.access$000(this.this$0);
      var1 = var2;
      if(this.mExpandedIndex >= 0) {
         var1 = var2;
         if(var2 >= this.mExpandedIndex) {
            var1 = var2 + 1;
         }
      }

      return (MenuItemImpl)var3.get(var1);
   }

   public long getItemId(int var1) {
      return (long)var1;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      View var4 = var2;
      if(var2 == null) {
         var4 = this.this$0.mInflater.inflate(this.this$0.mItemLayoutRes, var3, false);
      }

      ((MenuView$ItemView)var4).initialize(this.getItem(var1), 0);
      return var4;
   }

   public void notifyDataSetChanged() {
      this.findExpandedIndex();
      super.notifyDataSetChanged();
   }
}
