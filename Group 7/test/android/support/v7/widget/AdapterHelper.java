package android.support.v7.widget;

import android.support.v4.util.Pools$Pool;
import android.support.v4.util.Pools$SimplePool;
import android.support.v7.widget.AdapterHelper$Callback;
import android.support.v7.widget.AdapterHelper$UpdateOp;
import android.support.v7.widget.OpReorderer;
import android.support.v7.widget.OpReorderer$Callback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class AdapterHelper implements OpReorderer$Callback {
   private static final boolean DEBUG = false;
   static final int POSITION_TYPE_INVISIBLE = 0;
   static final int POSITION_TYPE_NEW_OR_LAID_OUT = 1;
   private static final String TAG = "AHT";
   final AdapterHelper$Callback mCallback;
   final boolean mDisableRecycler;
   private int mExistingUpdateTypes;
   Runnable mOnItemProcessedCallback;
   final OpReorderer mOpReorderer;
   final ArrayList<AdapterHelper$UpdateOp> mPendingUpdates;
   final ArrayList<AdapterHelper$UpdateOp> mPostponedList;
   private Pools$Pool<AdapterHelper$UpdateOp> mUpdateOpPool;

   AdapterHelper(AdapterHelper$Callback var1) {
      this(var1, false);
   }

   AdapterHelper(AdapterHelper$Callback var1, boolean var2) {
      this.mUpdateOpPool = new Pools$SimplePool(30);
      this.mPendingUpdates = new ArrayList();
      this.mPostponedList = new ArrayList();
      this.mExistingUpdateTypes = 0;
      this.mCallback = var1;
      this.mDisableRecycler = var2;
      this.mOpReorderer = new OpReorderer(this);
   }

   private void applyAdd(AdapterHelper$UpdateOp var1) {
      this.postponeAndUpdateViewHolders(var1);
   }

   private void applyMove(AdapterHelper$UpdateOp var1) {
      this.postponeAndUpdateViewHolders(var1);
   }

   private void applyRemove(AdapterHelper$UpdateOp var1) {
      int var8 = var1.positionStart;
      int var6 = 0;
      int var5 = var1.positionStart + var1.itemCount;
      byte var7 = -1;

      byte var10;
      for(int var2 = var1.positionStart; var2 < var5; var7 = var10) {
         boolean var4 = false;
         boolean var3 = false;
         if(this.mCallback.findViewHolder(var2) == null && !this.canFindInPreLayout(var2)) {
            if(var7 == 1) {
               this.postponeAndUpdateViewHolders(this.obtainUpdateOp(2, var8, var6, (Object)null));
               var4 = true;
            }

            var10 = 0;
         } else {
            if(var7 == 0) {
               this.dispatchAndUpdateViewHolders(this.obtainUpdateOp(2, var8, var6, (Object)null));
               var3 = true;
            }

            byte var12 = 1;
            var4 = var3;
            var10 = var12;
         }

         int var11;
         if(var4) {
            var2 -= var6;
            var5 -= var6;
            var11 = 1;
         } else {
            var11 = var6 + 1;
         }

         ++var2;
         var6 = var11;
      }

      AdapterHelper$UpdateOp var9 = var1;
      if(var6 != var1.itemCount) {
         this.recycleUpdateOp(var1);
         var9 = this.obtainUpdateOp(2, var8, var6, (Object)null);
      }

      if(var7 == 0) {
         this.dispatchAndUpdateViewHolders(var9);
      } else {
         this.postponeAndUpdateViewHolders(var9);
      }
   }

   private void applyUpdate(AdapterHelper$UpdateOp var1) {
      int var4 = var1.positionStart;
      int var3 = 0;
      int var9 = var1.positionStart;
      int var10 = var1.itemCount;
      byte var8 = -1;

      byte var5;
      for(int var2 = var1.positionStart; var2 < var9 + var10; var8 = var5) {
         int var6;
         if(this.mCallback.findViewHolder(var2) == null && !this.canFindInPreLayout(var2)) {
            var6 = var3;
            int var13 = var4;
            if(var8 == 1) {
               this.postponeAndUpdateViewHolders(this.obtainUpdateOp(4, var4, var3, var1.payload));
               var6 = 0;
               var13 = var2;
            }

            byte var12 = 0;
            var4 = var13;
            var5 = var12;
         } else {
            var6 = var3;
            int var7 = var4;
            if(var8 == 0) {
               this.dispatchAndUpdateViewHolders(this.obtainUpdateOp(4, var4, var3, var1.payload));
               var6 = 0;
               var7 = var2;
            }

            var5 = 1;
            var4 = var7;
         }

         var3 = var6 + 1;
         ++var2;
      }

      AdapterHelper$UpdateOp var11 = var1;
      if(var3 != var1.itemCount) {
         Object var14 = var1.payload;
         this.recycleUpdateOp(var1);
         var11 = this.obtainUpdateOp(4, var4, var3, var14);
      }

      if(var8 == 0) {
         this.dispatchAndUpdateViewHolders(var11);
      } else {
         this.postponeAndUpdateViewHolders(var11);
      }
   }

   private boolean canFindInPreLayout(int var1) {
      int var4 = this.mPostponedList.size();

      for(int var2 = 0; var2 < var4; ++var2) {
         AdapterHelper$UpdateOp var7 = (AdapterHelper$UpdateOp)this.mPostponedList.get(var2);
         if(var7.cmd == 8) {
            if(this.findPositionOffset(var7.itemCount, var2 + 1) == var1) {
               return true;
            }
         } else if(var7.cmd == 1) {
            int var5 = var7.positionStart;
            int var6 = var7.itemCount;

            for(int var3 = var7.positionStart; var3 < var5 + var6; ++var3) {
               if(this.findPositionOffset(var3, var2 + 1) == var1) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   private void dispatchAndUpdateViewHolders(AdapterHelper$UpdateOp var1) {
      if(var1.cmd != 1 && var1.cmd != 8) {
         int var7 = this.updatePositionWithPostponed(var1.positionStart, var1.cmd);
         int var6 = 1;
         int var2 = var1.positionStart;
         byte var4;
         switch(var1.cmd) {
         case 2:
            var4 = 0;
            break;
         case 3:
         default:
            throw new IllegalArgumentException("op should be remove or update." + var1);
         case 4:
            var4 = 1;
         }

         int var11;
         for(int var5 = 1; var5 < var1.itemCount; var6 = var11) {
            int var8 = this.updatePositionWithPostponed(var1.positionStart + var4 * var5, var1.cmd);
            boolean var9 = false;
            boolean var3 = var9;
            switch(var1.cmd) {
            case 2:
               if(var8 == var7) {
                  var3 = true;
               } else {
                  var3 = false;
               }
            case 3:
               break;
            case 4:
               if(var8 == var7 + 1) {
                  var3 = true;
               } else {
                  var3 = false;
               }
               break;
            default:
               var3 = var9;
            }

            if(var3) {
               var11 = var6 + 1;
            } else {
               AdapterHelper$UpdateOp var10 = this.obtainUpdateOp(var1.cmd, var7, var6, var1.payload);
               this.dispatchFirstPassAndUpdateViewHolders(var10, var2);
               this.recycleUpdateOp(var10);
               var11 = var2;
               if(var1.cmd == 4) {
                  var11 = var2 + var6;
               }

               var7 = var8;
               byte var12 = 1;
               var2 = var11;
               var11 = var12;
            }

            ++var5;
         }

         Object var13 = var1.payload;
         this.recycleUpdateOp(var1);
         if(var6 > 0) {
            var1 = this.obtainUpdateOp(var1.cmd, var7, var6, var13);
            this.dispatchFirstPassAndUpdateViewHolders(var1, var2);
            this.recycleUpdateOp(var1);
         }

      } else {
         throw new IllegalArgumentException("should not dispatch add or move for pre layout");
      }
   }

   private void postponeAndUpdateViewHolders(AdapterHelper$UpdateOp var1) {
      this.mPostponedList.add(var1);
      switch(var1.cmd) {
      case 1:
         this.mCallback.offsetPositionsForAdd(var1.positionStart, var1.itemCount);
         return;
      case 2:
         this.mCallback.offsetPositionsForRemovingLaidOutOrNewView(var1.positionStart, var1.itemCount);
         return;
      case 3:
      case 5:
      case 6:
      case 7:
      default:
         throw new IllegalArgumentException("Unknown update op type for " + var1);
      case 4:
         this.mCallback.markViewHoldersUpdated(var1.positionStart, var1.itemCount, var1.payload);
         return;
      case 8:
         this.mCallback.offsetPositionsForMove(var1.positionStart, var1.itemCount);
      }
   }

   private int updatePositionWithPostponed(int var1, int var2) {
      int var3 = this.mPostponedList.size() - 1;

      int var4;
      AdapterHelper$UpdateOp var6;
      for(var4 = var1; var3 >= 0; var4 = var1) {
         var6 = (AdapterHelper$UpdateOp)this.mPostponedList.get(var3);
         if(var6.cmd == 8) {
            int var5;
            if(var6.positionStart < var6.itemCount) {
               var5 = var6.positionStart;
               var1 = var6.itemCount;
            } else {
               var5 = var6.itemCount;
               var1 = var6.positionStart;
            }

            if(var4 >= var5 && var4 <= var1) {
               if(var5 == var6.positionStart) {
                  if(var2 == 1) {
                     ++var6.itemCount;
                  } else if(var2 == 2) {
                     --var6.itemCount;
                  }

                  var1 = var4 + 1;
               } else {
                  if(var2 == 1) {
                     ++var6.positionStart;
                  } else if(var2 == 2) {
                     --var6.positionStart;
                  }

                  var1 = var4 - 1;
               }
            } else {
               var1 = var4;
               if(var4 < var6.positionStart) {
                  if(var2 == 1) {
                     ++var6.positionStart;
                     ++var6.itemCount;
                     var1 = var4;
                  } else {
                     var1 = var4;
                     if(var2 == 2) {
                        --var6.positionStart;
                        --var6.itemCount;
                        var1 = var4;
                     }
                  }
               }
            }
         } else if(var6.positionStart <= var4) {
            if(var6.cmd == 1) {
               var1 = var4 - var6.itemCount;
            } else {
               var1 = var4;
               if(var6.cmd == 2) {
                  var1 = var4 + var6.itemCount;
               }
            }
         } else if(var2 == 1) {
            ++var6.positionStart;
            var1 = var4;
         } else {
            var1 = var4;
            if(var2 == 2) {
               --var6.positionStart;
               var1 = var4;
            }
         }

         --var3;
      }

      for(var1 = this.mPostponedList.size() - 1; var1 >= 0; --var1) {
         var6 = (AdapterHelper$UpdateOp)this.mPostponedList.get(var1);
         if(var6.cmd == 8) {
            if(var6.itemCount == var6.positionStart || var6.itemCount < 0) {
               this.mPostponedList.remove(var1);
               this.recycleUpdateOp(var6);
            }
         } else if(var6.itemCount <= 0) {
            this.mPostponedList.remove(var1);
            this.recycleUpdateOp(var6);
         }
      }

      return var4;
   }

   AdapterHelper addUpdateOp(AdapterHelper$UpdateOp... var1) {
      Collections.addAll(this.mPendingUpdates, var1);
      return this;
   }

   public int applyPendingUpdatesToPosition(int var1) {
      int var5 = this.mPendingUpdates.size();
      int var4 = 0;
      int var2 = var1;

      while(true) {
         var1 = var2;
         if(var4 >= var5) {
            return var1;
         }

         AdapterHelper$UpdateOp var6 = (AdapterHelper$UpdateOp)this.mPendingUpdates.get(var4);
         switch(var6.cmd) {
         case 1:
            var1 = var2;
            if(var6.positionStart <= var2) {
               var1 = var2 + var6.itemCount;
            }
            break;
         case 2:
            var1 = var2;
            if(var6.positionStart <= var2) {
               if(var6.positionStart + var6.itemCount > var2) {
                  var1 = -1;
                  return var1;
               }

               var1 = var2 - var6.itemCount;
            }
            break;
         case 8:
            if(var6.positionStart == var2) {
               var1 = var6.itemCount;
            } else {
               int var3 = var2;
               if(var6.positionStart < var2) {
                  var3 = var2 - 1;
               }

               var1 = var3;
               if(var6.itemCount <= var3) {
                  var1 = var3 + 1;
               }
            }
            break;
         default:
            var1 = var2;
         }

         ++var4;
         var2 = var1;
      }
   }

   void consumePostponedUpdates() {
      int var2 = this.mPostponedList.size();

      for(int var1 = 0; var1 < var2; ++var1) {
         this.mCallback.onDispatchSecondPass((AdapterHelper$UpdateOp)this.mPostponedList.get(var1));
      }

      this.recycleUpdateOpsAndClearList(this.mPostponedList);
      this.mExistingUpdateTypes = 0;
   }

   void consumeUpdatesInOnePass() {
      this.consumePostponedUpdates();
      int var2 = this.mPendingUpdates.size();

      for(int var1 = 0; var1 < var2; ++var1) {
         AdapterHelper$UpdateOp var3 = (AdapterHelper$UpdateOp)this.mPendingUpdates.get(var1);
         switch(var3.cmd) {
         case 1:
            this.mCallback.onDispatchSecondPass(var3);
            this.mCallback.offsetPositionsForAdd(var3.positionStart, var3.itemCount);
            break;
         case 2:
            this.mCallback.onDispatchSecondPass(var3);
            this.mCallback.offsetPositionsForRemovingInvisible(var3.positionStart, var3.itemCount);
         case 3:
         case 5:
         case 6:
         case 7:
         default:
            break;
         case 4:
            this.mCallback.onDispatchSecondPass(var3);
            this.mCallback.markViewHoldersUpdated(var3.positionStart, var3.itemCount, var3.payload);
            break;
         case 8:
            this.mCallback.onDispatchSecondPass(var3);
            this.mCallback.offsetPositionsForMove(var3.positionStart, var3.itemCount);
         }

         if(this.mOnItemProcessedCallback != null) {
            this.mOnItemProcessedCallback.run();
         }
      }

      this.recycleUpdateOpsAndClearList(this.mPendingUpdates);
      this.mExistingUpdateTypes = 0;
   }

   void dispatchFirstPassAndUpdateViewHolders(AdapterHelper$UpdateOp var1, int var2) {
      this.mCallback.onDispatchFirstPass(var1);
      switch(var1.cmd) {
      case 2:
         this.mCallback.offsetPositionsForRemovingInvisible(var2, var1.itemCount);
         return;
      case 3:
      default:
         throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
      case 4:
         this.mCallback.markViewHoldersUpdated(var2, var1.itemCount, var1.payload);
      }
   }

   int findPositionOffset(int var1) {
      return this.findPositionOffset(var1, 0);
   }

   int findPositionOffset(int var1, int var2) {
      int var5 = this.mPostponedList.size();
      int var4 = var2;
      var2 = var1;

      while(true) {
         var1 = var2;
         if(var4 >= var5) {
            break;
         }

         AdapterHelper$UpdateOp var6 = (AdapterHelper$UpdateOp)this.mPostponedList.get(var4);
         if(var6.cmd == 8) {
            if(var6.positionStart == var2) {
               var1 = var6.itemCount;
            } else {
               int var3 = var2;
               if(var6.positionStart < var2) {
                  var3 = var2 - 1;
               }

               var1 = var3;
               if(var6.itemCount <= var3) {
                  var1 = var3 + 1;
               }
            }
         } else {
            var1 = var2;
            if(var6.positionStart <= var2) {
               if(var6.cmd == 2) {
                  if(var2 < var6.positionStart + var6.itemCount) {
                     var1 = -1;
                     break;
                  }

                  var1 = var2 - var6.itemCount;
               } else {
                  var1 = var2;
                  if(var6.cmd == 1) {
                     var1 = var2 + var6.itemCount;
                  }
               }
            }
         }

         ++var4;
         var2 = var1;
      }

      return var1;
   }

   boolean hasAnyUpdateTypes(int var1) {
      return (this.mExistingUpdateTypes & var1) != 0;
   }

   boolean hasPendingUpdates() {
      return this.mPendingUpdates.size() > 0;
   }

   boolean hasUpdates() {
      return !this.mPostponedList.isEmpty() && !this.mPendingUpdates.isEmpty();
   }

   public AdapterHelper$UpdateOp obtainUpdateOp(int var1, int var2, int var3, Object var4) {
      AdapterHelper$UpdateOp var5 = (AdapterHelper$UpdateOp)this.mUpdateOpPool.acquire();
      if(var5 == null) {
         return new AdapterHelper$UpdateOp(var1, var2, var3, var4);
      } else {
         var5.cmd = var1;
         var5.positionStart = var2;
         var5.itemCount = var3;
         var5.payload = var4;
         return var5;
      }
   }

   boolean onItemRangeChanged(int var1, int var2, Object var3) {
      this.mPendingUpdates.add(this.obtainUpdateOp(4, var1, var2, var3));
      this.mExistingUpdateTypes |= 4;
      return this.mPendingUpdates.size() == 1;
   }

   boolean onItemRangeInserted(int var1, int var2) {
      this.mPendingUpdates.add(this.obtainUpdateOp(1, var1, var2, (Object)null));
      this.mExistingUpdateTypes |= 1;
      return this.mPendingUpdates.size() == 1;
   }

   boolean onItemRangeMoved(int var1, int var2, int var3) {
      boolean var4 = true;
      if(var1 == var2) {
         return false;
      } else if(var3 != 1) {
         throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
      } else {
         this.mPendingUpdates.add(this.obtainUpdateOp(8, var1, var2, (Object)null));
         this.mExistingUpdateTypes |= 8;
         if(this.mPendingUpdates.size() != 1) {
            var4 = false;
         }

         return var4;
      }
   }

   boolean onItemRangeRemoved(int var1, int var2) {
      this.mPendingUpdates.add(this.obtainUpdateOp(2, var1, var2, (Object)null));
      this.mExistingUpdateTypes |= 2;
      return this.mPendingUpdates.size() == 1;
   }

   void preProcess() {
      this.mOpReorderer.reorderOps(this.mPendingUpdates);
      int var2 = this.mPendingUpdates.size();

      for(int var1 = 0; var1 < var2; ++var1) {
         AdapterHelper$UpdateOp var3 = (AdapterHelper$UpdateOp)this.mPendingUpdates.get(var1);
         switch(var3.cmd) {
         case 1:
            this.applyAdd(var3);
            break;
         case 2:
            this.applyRemove(var3);
         case 3:
         case 5:
         case 6:
         case 7:
         default:
            break;
         case 4:
            this.applyUpdate(var3);
            break;
         case 8:
            this.applyMove(var3);
         }

         if(this.mOnItemProcessedCallback != null) {
            this.mOnItemProcessedCallback.run();
         }
      }

      this.mPendingUpdates.clear();
   }

   public void recycleUpdateOp(AdapterHelper$UpdateOp var1) {
      if(!this.mDisableRecycler) {
         var1.payload = null;
         this.mUpdateOpPool.release(var1);
      }

   }

   void recycleUpdateOpsAndClearList(List<AdapterHelper$UpdateOp> var1) {
      int var3 = var1.size();

      for(int var2 = 0; var2 < var3; ++var2) {
         this.recycleUpdateOp((AdapterHelper$UpdateOp)var1.get(var2));
      }

      var1.clear();
   }

   void reset() {
      this.recycleUpdateOpsAndClearList(this.mPendingUpdates);
      this.recycleUpdateOpsAndClearList(this.mPostponedList);
      this.mExistingUpdateTypes = 0;
   }
}
