package android.support.v7.widget;

import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

class AppCompatSpinner$DropDownAdapter implements ListAdapter, SpinnerAdapter {
   private SpinnerAdapter mAdapter;
   private ListAdapter mListAdapter;

   public AppCompatSpinner$DropDownAdapter(@Nullable SpinnerAdapter var1, @Nullable Theme var2) {
      this.mAdapter = var1;
      if(var1 instanceof ListAdapter) {
         this.mListAdapter = (ListAdapter)var1;
      }

      if(var2 != null) {
         if(AppCompatSpinner.access$100() && var1 instanceof android.widget.ThemedSpinnerAdapter) {
            android.widget.ThemedSpinnerAdapter var4 = (android.widget.ThemedSpinnerAdapter)var1;
            if(var4.getDropDownViewTheme() != var2) {
               var4.setDropDownViewTheme(var2);
            }
         } else if(var1 instanceof ThemedSpinnerAdapter) {
            ThemedSpinnerAdapter var3 = (ThemedSpinnerAdapter)var1;
            if(var3.getDropDownViewTheme() == null) {
               var3.setDropDownViewTheme(var2);
               return;
            }
         }
      }

   }

   public boolean areAllItemsEnabled() {
      ListAdapter var1 = this.mListAdapter;
      return var1 != null?var1.areAllItemsEnabled():true;
   }

   public int getCount() {
      return this.mAdapter == null?0:this.mAdapter.getCount();
   }

   public View getDropDownView(int var1, View var2, ViewGroup var3) {
      return this.mAdapter == null?null:this.mAdapter.getDropDownView(var1, var2, var3);
   }

   public Object getItem(int var1) {
      return this.mAdapter == null?null:this.mAdapter.getItem(var1);
   }

   public long getItemId(int var1) {
      return this.mAdapter == null?-1L:this.mAdapter.getItemId(var1);
   }

   public int getItemViewType(int var1) {
      return 0;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      return this.getDropDownView(var1, var2, var3);
   }

   public int getViewTypeCount() {
      return 1;
   }

   public boolean hasStableIds() {
      return this.mAdapter != null && this.mAdapter.hasStableIds();
   }

   public boolean isEmpty() {
      return this.getCount() == 0;
   }

   public boolean isEnabled(int var1) {
      ListAdapter var2 = this.mListAdapter;
      return var2 != null?var2.isEnabled(var1):true;
   }

   public void registerDataSetObserver(DataSetObserver var1) {
      if(this.mAdapter != null) {
         this.mAdapter.registerDataSetObserver(var1);
      }

   }

   public void unregisterDataSetObserver(DataSetObserver var1) {
      if(this.mAdapter != null) {
         this.mAdapter.unregisterDataSetObserver(var1);
      }

   }
}
