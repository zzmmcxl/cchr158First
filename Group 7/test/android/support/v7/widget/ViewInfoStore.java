package android.support.v7.widget;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v7.widget.RecyclerView$ItemAnimator$ItemHolderInfo;
import android.support.v7.widget.RecyclerView$ViewHolder;
import android.support.v7.widget.ViewInfoStore$InfoRecord;
import android.support.v7.widget.ViewInfoStore$ProcessCallback;

class ViewInfoStore {
   private static final boolean DEBUG = false;
   @VisibleForTesting
   final ArrayMap<RecyclerView$ViewHolder, ViewInfoStore$InfoRecord> mLayoutHolderMap = new ArrayMap();
   @VisibleForTesting
   final LongSparseArray<RecyclerView$ViewHolder> mOldChangedHolders = new LongSparseArray();

   private RecyclerView$ItemAnimator$ItemHolderInfo popFromLayoutStep(RecyclerView$ViewHolder var1, int var2) {
      Object var5 = null;
      int var3 = this.mLayoutHolderMap.indexOfKey(var1);
      RecyclerView$ItemAnimator$ItemHolderInfo var4;
      if(var3 < 0) {
         var4 = (RecyclerView$ItemAnimator$ItemHolderInfo)var5;
      } else {
         ViewInfoStore$InfoRecord var6 = (ViewInfoStore$InfoRecord)this.mLayoutHolderMap.valueAt(var3);
         var4 = (RecyclerView$ItemAnimator$ItemHolderInfo)var5;
         if(var6 != null) {
            var4 = (RecyclerView$ItemAnimator$ItemHolderInfo)var5;
            if((var6.flags & var2) != 0) {
               var6.flags &= ~var2;
               RecyclerView$ItemAnimator$ItemHolderInfo var7;
               if(var2 == 4) {
                  var7 = var6.preInfo;
               } else {
                  if(var2 != 8) {
                     throw new IllegalArgumentException("Must provide flag PRE or POST");
                  }

                  var7 = var6.postInfo;
               }

               var4 = var7;
               if((var6.flags & 12) == 0) {
                  this.mLayoutHolderMap.removeAt(var3);
                  ViewInfoStore$InfoRecord.recycle(var6);
                  return var7;
               }
            }
         }
      }

      return var4;
   }

   void addToAppearedInPreLayoutHolders(RecyclerView$ViewHolder var1, RecyclerView$ItemAnimator$ItemHolderInfo var2) {
      ViewInfoStore$InfoRecord var4 = (ViewInfoStore$InfoRecord)this.mLayoutHolderMap.get(var1);
      ViewInfoStore$InfoRecord var3 = var4;
      if(var4 == null) {
         var3 = ViewInfoStore$InfoRecord.obtain();
         this.mLayoutHolderMap.put(var1, var3);
      }

      var3.flags |= 2;
      var3.preInfo = var2;
   }

   void addToDisappearedInLayout(RecyclerView$ViewHolder var1) {
      ViewInfoStore$InfoRecord var3 = (ViewInfoStore$InfoRecord)this.mLayoutHolderMap.get(var1);
      ViewInfoStore$InfoRecord var2 = var3;
      if(var3 == null) {
         var2 = ViewInfoStore$InfoRecord.obtain();
         this.mLayoutHolderMap.put(var1, var2);
      }

      var2.flags |= 1;
   }

   void addToOldChangeHolders(long var1, RecyclerView$ViewHolder var3) {
      this.mOldChangedHolders.put(var1, var3);
   }

   void addToPostLayout(RecyclerView$ViewHolder var1, RecyclerView$ItemAnimator$ItemHolderInfo var2) {
      ViewInfoStore$InfoRecord var4 = (ViewInfoStore$InfoRecord)this.mLayoutHolderMap.get(var1);
      ViewInfoStore$InfoRecord var3 = var4;
      if(var4 == null) {
         var3 = ViewInfoStore$InfoRecord.obtain();
         this.mLayoutHolderMap.put(var1, var3);
      }

      var3.postInfo = var2;
      var3.flags |= 8;
   }

   void addToPreLayout(RecyclerView$ViewHolder var1, RecyclerView$ItemAnimator$ItemHolderInfo var2) {
      ViewInfoStore$InfoRecord var4 = (ViewInfoStore$InfoRecord)this.mLayoutHolderMap.get(var1);
      ViewInfoStore$InfoRecord var3 = var4;
      if(var4 == null) {
         var3 = ViewInfoStore$InfoRecord.obtain();
         this.mLayoutHolderMap.put(var1, var3);
      }

      var3.preInfo = var2;
      var3.flags |= 4;
   }

   void clear() {
      this.mLayoutHolderMap.clear();
      this.mOldChangedHolders.clear();
   }

   RecyclerView$ViewHolder getFromOldChangeHolders(long var1) {
      return (RecyclerView$ViewHolder)this.mOldChangedHolders.get(var1);
   }

   boolean isDisappearing(RecyclerView$ViewHolder var1) {
      ViewInfoStore$InfoRecord var2 = (ViewInfoStore$InfoRecord)this.mLayoutHolderMap.get(var1);
      return var2 != null && (var2.flags & 1) != 0;
   }

   boolean isInPreLayout(RecyclerView$ViewHolder var1) {
      ViewInfoStore$InfoRecord var2 = (ViewInfoStore$InfoRecord)this.mLayoutHolderMap.get(var1);
      return var2 != null && (var2.flags & 4) != 0;
   }

   void onDetach() {
      ViewInfoStore$InfoRecord.drainCache();
   }

   public void onViewDetached(RecyclerView$ViewHolder var1) {
      this.removeFromDisappearedInLayout(var1);
   }

   @Nullable
   RecyclerView$ItemAnimator$ItemHolderInfo popFromPostLayout(RecyclerView$ViewHolder var1) {
      return this.popFromLayoutStep(var1, 8);
   }

   @Nullable
   RecyclerView$ItemAnimator$ItemHolderInfo popFromPreLayout(RecyclerView$ViewHolder var1) {
      return this.popFromLayoutStep(var1, 4);
   }

   void process(ViewInfoStore$ProcessCallback var1) {
      for(int var2 = this.mLayoutHolderMap.size() - 1; var2 >= 0; --var2) {
         RecyclerView$ViewHolder var3 = (RecyclerView$ViewHolder)this.mLayoutHolderMap.keyAt(var2);
         ViewInfoStore$InfoRecord var4 = (ViewInfoStore$InfoRecord)this.mLayoutHolderMap.removeAt(var2);
         if((var4.flags & 3) == 3) {
            var1.unused(var3);
         } else if((var4.flags & 1) != 0) {
            if(var4.preInfo == null) {
               var1.unused(var3);
            } else {
               var1.processDisappeared(var3, var4.preInfo, var4.postInfo);
            }
         } else if((var4.flags & 14) == 14) {
            var1.processAppeared(var3, var4.preInfo, var4.postInfo);
         } else if((var4.flags & 12) == 12) {
            var1.processPersistent(var3, var4.preInfo, var4.postInfo);
         } else if((var4.flags & 4) != 0) {
            var1.processDisappeared(var3, var4.preInfo, (RecyclerView$ItemAnimator$ItemHolderInfo)null);
         } else if((var4.flags & 8) != 0) {
            var1.processAppeared(var3, var4.preInfo, var4.postInfo);
         } else if((var4.flags & 2) != 0) {
            ;
         }

         ViewInfoStore$InfoRecord.recycle(var4);
      }

   }

   void removeFromDisappearedInLayout(RecyclerView$ViewHolder var1) {
      ViewInfoStore$InfoRecord var2 = (ViewInfoStore$InfoRecord)this.mLayoutHolderMap.get(var1);
      if(var2 != null) {
         var2.flags &= -2;
      }
   }

   void removeViewHolder(RecyclerView$ViewHolder var1) {
      for(int var2 = this.mOldChangedHolders.size() - 1; var2 >= 0; --var2) {
         if(var1 == this.mOldChangedHolders.valueAt(var2)) {
            this.mOldChangedHolders.removeAt(var2);
            break;
         }
      }

      ViewInfoStore$InfoRecord var3 = (ViewInfoStore$InfoRecord)this.mLayoutHolderMap.remove(var1);
      if(var3 != null) {
         ViewInfoStore$InfoRecord.recycle(var3);
      }

   }
}
