package android.support.v7.widget;

import android.support.v7.widget.RecyclerView$Adapter;
import android.support.v7.widget.RecyclerView$ViewHolder;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;

public class RecyclerView$RecycledViewPool {
   private static final int DEFAULT_MAX_SCRAP = 5;
   private int mAttachCount = 0;
   private SparseIntArray mMaxScrap = new SparseIntArray();
   private SparseArray<ArrayList<RecyclerView$ViewHolder>> mScrap = new SparseArray();

   private ArrayList<RecyclerView$ViewHolder> getScrapHeapForType(int var1) {
      ArrayList var3 = (ArrayList)this.mScrap.get(var1);
      ArrayList var2 = var3;
      if(var3 == null) {
         var3 = new ArrayList();
         this.mScrap.put(var1, var3);
         var2 = var3;
         if(this.mMaxScrap.indexOfKey(var1) < 0) {
            this.mMaxScrap.put(var1, 5);
            var2 = var3;
         }
      }

      return var2;
   }

   void attach(RecyclerView$Adapter var1) {
      ++this.mAttachCount;
   }

   public void clear() {
      this.mScrap.clear();
   }

   void detach() {
      --this.mAttachCount;
   }

   public RecyclerView$ViewHolder getRecycledView(int var1) {
      ArrayList var2 = (ArrayList)this.mScrap.get(var1);
      if(var2 != null && !var2.isEmpty()) {
         var1 = var2.size() - 1;
         RecyclerView$ViewHolder var3 = (RecyclerView$ViewHolder)var2.get(var1);
         var2.remove(var1);
         return var3;
      } else {
         return null;
      }
   }

   void onAdapterChanged(RecyclerView$Adapter var1, RecyclerView$Adapter var2, boolean var3) {
      if(var1 != null) {
         this.detach();
      }

      if(!var3 && this.mAttachCount == 0) {
         this.clear();
      }

      if(var2 != null) {
         this.attach(var2);
      }

   }

   public void putRecycledView(RecyclerView$ViewHolder var1) {
      int var2 = var1.getItemViewType();
      ArrayList var3 = this.getScrapHeapForType(var2);
      if(this.mMaxScrap.get(var2) > var3.size()) {
         var1.resetInternal();
         var3.add(var1);
      }
   }

   public void setMaxRecycledViews(int var1, int var2) {
      this.mMaxScrap.put(var1, var2);
      ArrayList var3 = (ArrayList)this.mScrap.get(var1);
      if(var3 != null) {
         while(var3.size() > var2) {
            var3.remove(var3.size() - 1);
         }
      }

   }

   int size() {
      int var2 = 0;

      int var3;
      for(int var1 = 0; var1 < this.mScrap.size(); var2 = var3) {
         ArrayList var4 = (ArrayList)this.mScrap.valueAt(var1);
         var3 = var2;
         if(var4 != null) {
            var3 = var2 + var4.size();
         }

         ++var1;
      }

      return var2;
   }
}
