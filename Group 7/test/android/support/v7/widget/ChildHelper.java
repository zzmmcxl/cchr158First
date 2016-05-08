package android.support.v7.widget;

import android.support.v7.widget.ChildHelper$Bucket;
import android.support.v7.widget.ChildHelper$Callback;
import android.support.v7.widget.RecyclerView$ViewHolder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

class ChildHelper {
   private static final boolean DEBUG = false;
   private static final String TAG = "ChildrenHelper";
   final ChildHelper$Bucket mBucket;
   final ChildHelper$Callback mCallback;
   final List<View> mHiddenViews;

   ChildHelper(ChildHelper$Callback var1) {
      this.mCallback = var1;
      this.mBucket = new ChildHelper$Bucket();
      this.mHiddenViews = new ArrayList();
   }

   private int getOffset(int var1) {
      if(var1 < 0) {
         var1 = -1;
         return var1;
      } else {
         int var3 = this.mCallback.getChildCount();

         int var4;
         for(int var2 = var1; var2 < var3; var2 += var4) {
            var4 = var1 - (var2 - this.mBucket.countOnesBefore(var2));
            if(var4 == 0) {
               while(true) {
                  var1 = var2;
                  if(!this.mBucket.get(var2)) {
                     return var1;
                  }

                  ++var2;
               }
            }
         }

         return -1;
      }
   }

   private void hideViewInternal(View var1) {
      this.mHiddenViews.add(var1);
      this.mCallback.onEnteredHiddenState(var1);
   }

   private boolean unhideViewInternal(View var1) {
      if(this.mHiddenViews.remove(var1)) {
         this.mCallback.onLeftHiddenState(var1);
         return true;
      } else {
         return false;
      }
   }

   void addView(View var1, int var2, boolean var3) {
      if(var2 < 0) {
         var2 = this.mCallback.getChildCount();
      } else {
         var2 = this.getOffset(var2);
      }

      this.mBucket.insert(var2, var3);
      if(var3) {
         this.hideViewInternal(var1);
      }

      this.mCallback.addView(var1, var2);
   }

   void addView(View var1, boolean var2) {
      this.addView(var1, -1, var2);
   }

   void attachViewToParent(View var1, int var2, LayoutParams var3, boolean var4) {
      if(var2 < 0) {
         var2 = this.mCallback.getChildCount();
      } else {
         var2 = this.getOffset(var2);
      }

      this.mBucket.insert(var2, var4);
      if(var4) {
         this.hideViewInternal(var1);
      }

      this.mCallback.attachViewToParent(var1, var2, var3);
   }

   void detachViewFromParent(int var1) {
      var1 = this.getOffset(var1);
      this.mBucket.remove(var1);
      this.mCallback.detachViewFromParent(var1);
   }

   View findHiddenNonRemovedView(int var1, int var2) {
      int var4 = this.mHiddenViews.size();

      for(int var3 = 0; var3 < var4; ++var3) {
         View var5 = (View)this.mHiddenViews.get(var3);
         RecyclerView$ViewHolder var6 = this.mCallback.getChildViewHolder(var5);
         if(var6.getLayoutPosition() == var1 && !var6.isInvalid() && !var6.isRemoved() && (var2 == -1 || var6.getItemViewType() == var2)) {
            return var5;
         }
      }

      return null;
   }

   View getChildAt(int var1) {
      var1 = this.getOffset(var1);
      return this.mCallback.getChildAt(var1);
   }

   int getChildCount() {
      return this.mCallback.getChildCount() - this.mHiddenViews.size();
   }

   View getUnfilteredChildAt(int var1) {
      return this.mCallback.getChildAt(var1);
   }

   int getUnfilteredChildCount() {
      return this.mCallback.getChildCount();
   }

   void hide(View var1) {
      int var2 = this.mCallback.indexOfChild(var1);
      if(var2 < 0) {
         throw new IllegalArgumentException("view is not a child, cannot hide " + var1);
      } else {
         this.mBucket.set(var2);
         this.hideViewInternal(var1);
      }
   }

   int indexOfChild(View var1) {
      int var2 = this.mCallback.indexOfChild(var1);
      return var2 != -1 && !this.mBucket.get(var2)?var2 - this.mBucket.countOnesBefore(var2):-1;
   }

   boolean isHidden(View var1) {
      return this.mHiddenViews.contains(var1);
   }

   void removeAllViewsUnfiltered() {
      this.mBucket.reset();

      for(int var1 = this.mHiddenViews.size() - 1; var1 >= 0; --var1) {
         this.mCallback.onLeftHiddenState((View)this.mHiddenViews.get(var1));
         this.mHiddenViews.remove(var1);
      }

      this.mCallback.removeAllViews();
   }

   void removeView(View var1) {
      int var2 = this.mCallback.indexOfChild(var1);
      if(var2 >= 0) {
         if(this.mBucket.remove(var2)) {
            this.unhideViewInternal(var1);
         }

         this.mCallback.removeViewAt(var2);
      }
   }

   void removeViewAt(int var1) {
      var1 = this.getOffset(var1);
      View var2 = this.mCallback.getChildAt(var1);
      if(var2 != null) {
         if(this.mBucket.remove(var1)) {
            this.unhideViewInternal(var2);
         }

         this.mCallback.removeViewAt(var1);
      }
   }

   boolean removeViewIfHidden(View var1) {
      int var2 = this.mCallback.indexOfChild(var1);
      if(var2 == -1) {
         if(this.unhideViewInternal(var1)) {
            ;
         }

         return true;
      } else if(this.mBucket.get(var2)) {
         this.mBucket.remove(var2);
         if(!this.unhideViewInternal(var1)) {
            ;
         }

         this.mCallback.removeViewAt(var2);
         return true;
      } else {
         return false;
      }
   }

   public String toString() {
      return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
   }

   void unhide(View var1) {
      int var2 = this.mCallback.indexOfChild(var1);
      if(var2 < 0) {
         throw new IllegalArgumentException("view is not a child, cannot hide " + var1);
      } else if(!this.mBucket.get(var2)) {
         throw new RuntimeException("trying to unhide a view that was not hidden" + var1);
      } else {
         this.mBucket.clear(var2);
         this.unhideViewInternal(var1);
      }
   }
}
