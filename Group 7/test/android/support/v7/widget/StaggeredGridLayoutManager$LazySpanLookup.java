package android.support.v7.widget;

import android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
import android.support.v7.widget.StaggeredGridLayoutManager$Span;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StaggeredGridLayoutManager$LazySpanLookup {
   private static final int MIN_SIZE = 10;
   int[] mData;
   List<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> mFullSpanItems;

   private int invalidateFullSpansAfter(int var1) {
      if(this.mFullSpanItems != null) {
         StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem var6 = this.getFullSpanItem(var1);
         if(var6 != null) {
            this.mFullSpanItems.remove(var6);
         }

         byte var4 = -1;
         int var5 = this.mFullSpanItems.size();
         int var2 = 0;

         int var3;
         while(true) {
            var3 = var4;
            if(var2 >= var5) {
               break;
            }

            if(((StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.mFullSpanItems.get(var2)).mPosition >= var1) {
               var3 = var2;
               break;
            }

            ++var2;
         }

         if(var3 != -1) {
            var6 = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.mFullSpanItems.get(var3);
            this.mFullSpanItems.remove(var3);
            return var6.mPosition;
         }
      }

      return -1;
   }

   private void offsetFullSpansForAddition(int var1, int var2) {
      if(this.mFullSpanItems != null) {
         for(int var3 = this.mFullSpanItems.size() - 1; var3 >= 0; --var3) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem var4 = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.mFullSpanItems.get(var3);
            if(var4.mPosition >= var1) {
               var4.mPosition += var2;
            }
         }
      }

   }

   private void offsetFullSpansForRemoval(int var1, int var2) {
      if(this.mFullSpanItems != null) {
         for(int var3 = this.mFullSpanItems.size() - 1; var3 >= 0; --var3) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem var4 = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.mFullSpanItems.get(var3);
            if(var4.mPosition >= var1) {
               if(var4.mPosition < var1 + var2) {
                  this.mFullSpanItems.remove(var3);
               } else {
                  var4.mPosition -= var2;
               }
            }
         }
      }

   }

   public void addFullSpanItem(StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem var1) {
      if(this.mFullSpanItems == null) {
         this.mFullSpanItems = new ArrayList();
      }

      int var3 = this.mFullSpanItems.size();

      for(int var2 = 0; var2 < var3; ++var2) {
         StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem var4 = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.mFullSpanItems.get(var2);
         if(var4.mPosition == var1.mPosition) {
            this.mFullSpanItems.remove(var2);
         }

         if(var4.mPosition >= var1.mPosition) {
            this.mFullSpanItems.add(var2, var1);
            return;
         }
      }

      this.mFullSpanItems.add(var1);
   }

   void clear() {
      if(this.mData != null) {
         Arrays.fill(this.mData, -1);
      }

      this.mFullSpanItems = null;
   }

   void ensureSize(int var1) {
      if(this.mData == null) {
         this.mData = new int[Math.max(var1, 10) + 1];
         Arrays.fill(this.mData, -1);
      } else if(var1 >= this.mData.length) {
         int[] var2 = this.mData;
         this.mData = new int[this.sizeForPosition(var1)];
         System.arraycopy(var2, 0, this.mData, 0, var2.length);
         Arrays.fill(this.mData, var2.length, this.mData.length, -1);
         return;
      }

   }

   int forceInvalidateAfter(int var1) {
      if(this.mFullSpanItems != null) {
         for(int var2 = this.mFullSpanItems.size() - 1; var2 >= 0; --var2) {
            if(((StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.mFullSpanItems.get(var2)).mPosition >= var1) {
               this.mFullSpanItems.remove(var2);
            }
         }
      }

      return this.invalidateAfter(var1);
   }

   public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem getFirstFullSpanItemInRange(int var1, int var2, int var3, boolean var4) {
      StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem var7;
      if(this.mFullSpanItems == null) {
         var7 = null;
      } else {
         int var6 = this.mFullSpanItems.size();
         int var5 = 0;

         while(true) {
            if(var5 >= var6) {
               return null;
            }

            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem var8 = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.mFullSpanItems.get(var5);
            if(var8.mPosition >= var2) {
               return null;
            }

            if(var8.mPosition >= var1) {
               var7 = var8;
               if(var3 == 0) {
                  break;
               }

               var7 = var8;
               if(var8.mGapDir == var3) {
                  break;
               }

               if(var4) {
                  var7 = var8;
                  if(var8.mHasUnwantedGapAfter) {
                     break;
                  }
               }
            }

            ++var5;
         }
      }

      return var7;
   }

   public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem getFullSpanItem(int var1) {
      StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem var3;
      if(this.mFullSpanItems == null) {
         var3 = null;
      } else {
         int var2 = this.mFullSpanItems.size() - 1;

         while(true) {
            if(var2 < 0) {
               return null;
            }

            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem var4 = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)this.mFullSpanItems.get(var2);
            var3 = var4;
            if(var4.mPosition == var1) {
               break;
            }

            --var2;
         }
      }

      return var3;
   }

   int getSpan(int var1) {
      return this.mData != null && var1 < this.mData.length?this.mData[var1]:-1;
   }

   int invalidateAfter(int var1) {
      if(this.mData != null && var1 < this.mData.length) {
         int var2 = this.invalidateFullSpansAfter(var1);
         if(var2 == -1) {
            Arrays.fill(this.mData, var1, this.mData.length, -1);
            return this.mData.length;
         } else {
            Arrays.fill(this.mData, var1, var2 + 1, -1);
            return var2 + 1;
         }
      } else {
         return -1;
      }
   }

   void offsetForAddition(int var1, int var2) {
      if(this.mData != null && var1 < this.mData.length) {
         this.ensureSize(var1 + var2);
         System.arraycopy(this.mData, var1, this.mData, var1 + var2, this.mData.length - var1 - var2);
         Arrays.fill(this.mData, var1, var1 + var2, -1);
         this.offsetFullSpansForAddition(var1, var2);
      }
   }

   void offsetForRemoval(int var1, int var2) {
      if(this.mData != null && var1 < this.mData.length) {
         this.ensureSize(var1 + var2);
         System.arraycopy(this.mData, var1 + var2, this.mData, var1, this.mData.length - var1 - var2);
         Arrays.fill(this.mData, this.mData.length - var2, this.mData.length, -1);
         this.offsetFullSpansForRemoval(var1, var2);
      }
   }

   void setSpan(int var1, StaggeredGridLayoutManager$Span var2) {
      this.ensureSize(var1);
      this.mData[var1] = var2.mIndex;
   }

   int sizeForPosition(int var1) {
      int var2;
      for(var2 = this.mData.length; var2 <= var1; var2 *= 2) {
         ;
      }

      return var2;
   }
}
