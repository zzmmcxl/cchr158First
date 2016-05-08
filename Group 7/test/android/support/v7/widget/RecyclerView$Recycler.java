package android.support.v7.widget;

import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$Adapter;
import android.support.v7.widget.RecyclerView$ItemAnimator;
import android.support.v7.widget.RecyclerView$ItemAnimator$ItemHolderInfo;
import android.support.v7.widget.RecyclerView$LayoutParams;
import android.support.v7.widget.RecyclerView$RecycledViewPool;
import android.support.v7.widget.RecyclerView$State;
import android.support.v7.widget.RecyclerView$ViewCacheExtension;
import android.support.v7.widget.RecyclerView$ViewHolder;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RecyclerView$Recycler {
   private static final int DEFAULT_CACHE_SIZE = 2;
   final ArrayList<RecyclerView$ViewHolder> mAttachedScrap;
   final ArrayList<RecyclerView$ViewHolder> mCachedViews;
   private ArrayList<RecyclerView$ViewHolder> mChangedScrap;
   private RecyclerView$RecycledViewPool mRecyclerPool;
   private final List<RecyclerView$ViewHolder> mUnmodifiableAttachedScrap;
   private RecyclerView$ViewCacheExtension mViewCacheExtension;
   private int mViewCacheMax;

   public RecyclerView$Recycler(RecyclerView var1) {
      this.this$0 = var1;
      this.mAttachedScrap = new ArrayList();
      this.mChangedScrap = null;
      this.mCachedViews = new ArrayList();
      this.mUnmodifiableAttachedScrap = Collections.unmodifiableList(this.mAttachedScrap);
      this.mViewCacheMax = 2;
   }

   private void attachAccessibilityDelegate(View var1) {
      if(this.this$0.isAccessibilityEnabled()) {
         if(ViewCompat.getImportantForAccessibility(var1) == 0) {
            ViewCompat.setImportantForAccessibility(var1, 1);
         }

         if(!ViewCompat.hasAccessibilityDelegate(var1)) {
            ViewCompat.setAccessibilityDelegate(var1, RecyclerView.access$4800(this.this$0).getItemDelegate());
         }
      }

   }

   private void invalidateDisplayListInt(RecyclerView$ViewHolder var1) {
      if(var1.itemView instanceof ViewGroup) {
         this.invalidateDisplayListInt((ViewGroup)var1.itemView, false);
      }

   }

   private void invalidateDisplayListInt(ViewGroup var1, boolean var2) {
      int var3;
      for(var3 = var1.getChildCount() - 1; var3 >= 0; --var3) {
         View var4 = var1.getChildAt(var3);
         if(var4 instanceof ViewGroup) {
            this.invalidateDisplayListInt((ViewGroup)var4, true);
         }
      }

      if(var2) {
         if(var1.getVisibility() == 4) {
            var1.setVisibility(0);
            var1.setVisibility(4);
         } else {
            var3 = var1.getVisibility();
            var1.setVisibility(4);
            var1.setVisibility(var3);
         }
      }
   }

   void addViewHolderToRecycledViewPool(RecyclerView$ViewHolder var1) {
      ViewCompat.setAccessibilityDelegate(var1.itemView, (AccessibilityDelegateCompat)null);
      this.dispatchViewRecycled(var1);
      var1.mOwnerRecyclerView = null;
      this.getRecycledViewPool().putRecycledView(var1);
   }

   public void bindViewToPosition(View var1, int var2) {
      boolean var4 = true;
      RecyclerView$ViewHolder var5 = RecyclerView.getChildViewHolderInt(var1);
      if(var5 == null) {
         throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
      } else {
         int var3 = this.this$0.mAdapterHelper.findPositionOffset(var2);
         if(var3 >= 0 && var3 < RecyclerView.access$3100(this.this$0).getItemCount()) {
            var5.mOwnerRecyclerView = this.this$0;
            RecyclerView.access$3100(this.this$0).bindViewHolder(var5, var3);
            this.attachAccessibilityDelegate(var1);
            if(this.this$0.mState.isPreLayout()) {
               var5.mPreLayoutPosition = var2;
            }

            LayoutParams var6 = var5.itemView.getLayoutParams();
            RecyclerView$LayoutParams var7;
            if(var6 == null) {
               var7 = (RecyclerView$LayoutParams)this.this$0.generateDefaultLayoutParams();
               var5.itemView.setLayoutParams(var7);
            } else if(!this.this$0.checkLayoutParams(var6)) {
               var7 = (RecyclerView$LayoutParams)this.this$0.generateLayoutParams(var6);
               var5.itemView.setLayoutParams(var7);
            } else {
               var7 = (RecyclerView$LayoutParams)var6;
            }

            var7.mInsetsDirty = true;
            var7.mViewHolder = var5;
            if(var5.itemView.getParent() != null) {
               var4 = false;
            }

            var7.mPendingInvalidate = var4;
         } else {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + var2 + "(offset:" + var3 + ")." + "state:" + this.this$0.mState.getItemCount());
         }
      }
   }

   public void clear() {
      this.mAttachedScrap.clear();
      this.recycleAndClearCachedViews();
   }

   void clearOldPositions() {
      int var2 = this.mCachedViews.size();

      int var1;
      for(var1 = 0; var1 < var2; ++var1) {
         ((RecyclerView$ViewHolder)this.mCachedViews.get(var1)).clearOldPosition();
      }

      var2 = this.mAttachedScrap.size();

      for(var1 = 0; var1 < var2; ++var1) {
         ((RecyclerView$ViewHolder)this.mAttachedScrap.get(var1)).clearOldPosition();
      }

      if(this.mChangedScrap != null) {
         var2 = this.mChangedScrap.size();

         for(var1 = 0; var1 < var2; ++var1) {
            ((RecyclerView$ViewHolder)this.mChangedScrap.get(var1)).clearOldPosition();
         }
      }

   }

   void clearScrap() {
      this.mAttachedScrap.clear();
      if(this.mChangedScrap != null) {
         this.mChangedScrap.clear();
      }

   }

   public int convertPreLayoutPositionToPostLayout(int var1) {
      if(var1 >= 0 && var1 < this.this$0.mState.getItemCount()) {
         return !this.this$0.mState.isPreLayout()?var1:this.this$0.mAdapterHelper.findPositionOffset(var1);
      } else {
         throw new IndexOutOfBoundsException("invalid position " + var1 + ". State " + "item count is " + this.this$0.mState.getItemCount());
      }
   }

   void dispatchViewRecycled(RecyclerView$ViewHolder var1) {
      if(RecyclerView.access$5300(this.this$0) != null) {
         RecyclerView.access$5300(this.this$0).onViewRecycled(var1);
      }

      if(RecyclerView.access$3100(this.this$0) != null) {
         RecyclerView.access$3100(this.this$0).onViewRecycled(var1);
      }

      if(this.this$0.mState != null) {
         this.this$0.mViewInfoStore.removeViewHolder(var1);
      }

   }

   RecyclerView$ViewHolder getChangedScrapViewForPosition(int var1) {
      if(this.mChangedScrap != null) {
         int var3 = this.mChangedScrap.size();
         if(var3 != 0) {
            RecyclerView$ViewHolder var6;
            for(int var2 = 0; var2 < var3; ++var2) {
               var6 = (RecyclerView$ViewHolder)this.mChangedScrap.get(var2);
               if(!var6.wasReturnedFromScrap() && var6.getLayoutPosition() == var1) {
                  var6.addFlags(32);
                  return var6;
               }
            }

            if(RecyclerView.access$3100(this.this$0).hasStableIds()) {
               var1 = this.this$0.mAdapterHelper.findPositionOffset(var1);
               if(var1 > 0 && var1 < RecyclerView.access$3100(this.this$0).getItemCount()) {
                  long var4 = RecyclerView.access$3100(this.this$0).getItemId(var1);

                  for(var1 = 0; var1 < var3; ++var1) {
                     var6 = (RecyclerView$ViewHolder)this.mChangedScrap.get(var1);
                     if(!var6.wasReturnedFromScrap() && var6.getItemId() == var4) {
                        var6.addFlags(32);
                        return var6;
                     }
                  }
               }
            }

            return null;
         }
      }

      return null;
   }

   RecyclerView$RecycledViewPool getRecycledViewPool() {
      if(this.mRecyclerPool == null) {
         this.mRecyclerPool = new RecyclerView$RecycledViewPool();
      }

      return this.mRecyclerPool;
   }

   int getScrapCount() {
      return this.mAttachedScrap.size();
   }

   public List<RecyclerView$ViewHolder> getScrapList() {
      return this.mUnmodifiableAttachedScrap;
   }

   View getScrapViewAt(int var1) {
      return ((RecyclerView$ViewHolder)this.mAttachedScrap.get(var1)).itemView;
   }

   RecyclerView$ViewHolder getScrapViewForId(long var1, int var3, boolean var4) {
      int var5 = this.mAttachedScrap.size() - 1;

      RecyclerView$ViewHolder var6;
      while(true) {
         RecyclerView$ViewHolder var7;
         if(var5 < 0) {
            for(var5 = this.mCachedViews.size() - 1; var5 >= 0; --var5) {
               var7 = (RecyclerView$ViewHolder)this.mCachedViews.get(var5);
               if(var7.getItemId() == var1) {
                  if(var3 == var7.getItemViewType()) {
                     var6 = var7;
                     if(!var4) {
                        this.mCachedViews.remove(var5);
                        return var7;
                     }

                     return var6;
                  }

                  if(!var4) {
                     this.recycleCachedViewAt(var5);
                  }
               }
            }

            return null;
         }

         var7 = (RecyclerView$ViewHolder)this.mAttachedScrap.get(var5);
         if(var7.getItemId() == var1 && !var7.wasReturnedFromScrap()) {
            if(var3 == var7.getItemViewType()) {
               var7.addFlags(32);
               var6 = var7;
               if(var7.isRemoved()) {
                  var6 = var7;
                  if(!this.this$0.mState.isPreLayout()) {
                     var7.setFlags(2, 14);
                     var6 = var7;
                  }
               }
               break;
            }

            if(!var4) {
               this.mAttachedScrap.remove(var5);
               this.this$0.removeDetachedView(var7.itemView, false);
               this.quickRecycleScrapView(var7.itemView);
            }
         }

         --var5;
      }

      return var6;
   }

   RecyclerView$ViewHolder getScrapViewForPosition(int var1, int var2, boolean var3) {
      int var5 = this.mAttachedScrap.size();
      int var4 = 0;

      while(true) {
         RecyclerView$ViewHolder var6;
         if(var4 < var5) {
            var6 = (RecyclerView$ViewHolder)this.mAttachedScrap.get(var4);
            if(var6.wasReturnedFromScrap() || var6.getLayoutPosition() != var1 || var6.isInvalid() || !RecyclerView$State.access$2400(this.this$0.mState) && var6.isRemoved()) {
               ++var4;
               continue;
            }

            if(var2 == -1 || var6.getItemViewType() == var2) {
               var6.addFlags(32);
               return var6;
            }

            Log.e("RecyclerView", "Scrap view for position " + var1 + " isn\'t dirty but has" + " wrong view type! (found " + var6.getItemViewType() + " but expected " + var2 + ")");
         }

         RecyclerView$ViewHolder var7;
         if(!var3) {
            View var8 = this.this$0.mChildHelper.findHiddenNonRemovedView(var1, var2);
            if(var8 != null) {
               var7 = RecyclerView.getChildViewHolderInt(var8);
               this.this$0.mChildHelper.unhide(var8);
               var1 = this.this$0.mChildHelper.indexOfChild(var8);
               if(var1 == -1) {
                  throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + var7);
               }

               this.this$0.mChildHelper.detachViewFromParent(var1);
               this.scrapView(var8);
               var7.addFlags(8224);
               return var7;
            }
         }

         var4 = this.mCachedViews.size();

         for(var2 = 0; var2 < var4; ++var2) {
            var7 = (RecyclerView$ViewHolder)this.mCachedViews.get(var2);
            if(!var7.isInvalid() && var7.getLayoutPosition() == var1) {
               var6 = var7;
               if(!var3) {
                  this.mCachedViews.remove(var2);
                  return var7;
               }

               return var6;
            }
         }

         return null;
      }
   }

   public View getViewForPosition(int var1) {
      return this.getViewForPosition(var1, false);
   }

   View getViewForPosition(int var1, boolean var2) {
      if(var1 >= 0 && var1 < this.this$0.mState.getItemCount()) {
         boolean var4 = false;
         RecyclerView$ViewHolder var8 = null;
         if(this.this$0.mState.isPreLayout()) {
            var8 = this.getChangedScrapViewForPosition(var1);
            if(var8 != null) {
               var4 = true;
            } else {
               var4 = false;
            }
         }

         boolean var3 = var4;
         RecyclerView$ViewHolder var7 = var8;
         if(var8 == null) {
            var8 = this.getScrapViewForPosition(var1, -1, var2);
            var3 = var4;
            var7 = var8;
            if(var8 != null) {
               if(!this.validateViewHolderForOffsetPosition(var8)) {
                  if(!var2) {
                     var8.addFlags(4);
                     if(var8.isScrap()) {
                        this.this$0.removeDetachedView(var8.itemView, false);
                        var8.unScrap();
                     } else if(var8.wasReturnedFromScrap()) {
                        var8.clearReturnedFromScrapFlag();
                     }

                     this.recycleViewHolderInternal(var8);
                  }

                  var7 = null;
                  var3 = var4;
               } else {
                  var3 = true;
                  var7 = var8;
               }
            }
         }

         boolean var5 = var3;
         var8 = var7;
         if(var7 == null) {
            int var11 = this.this$0.mAdapterHelper.findPositionOffset(var1);
            if(var11 < 0 || var11 >= RecyclerView.access$3100(this.this$0).getItemCount()) {
               throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + var1 + "(offset:" + var11 + ")." + "state:" + this.this$0.mState.getItemCount());
            }

            int var6 = RecyclerView.access$3100(this.this$0).getItemViewType(var11);
            var4 = var3;
            var8 = var7;
            if(RecyclerView.access$3100(this.this$0).hasStableIds()) {
               var7 = this.getScrapViewForId(RecyclerView.access$3100(this.this$0).getItemId(var11), var6, var2);
               var4 = var3;
               var8 = var7;
               if(var7 != null) {
                  var7.mPosition = var11;
                  var4 = true;
                  var8 = var7;
               }
            }

            var7 = var8;
            if(var8 == null) {
               var7 = var8;
               if(this.mViewCacheExtension != null) {
                  View var9 = this.mViewCacheExtension.getViewForPositionAndType(this, var1, var6);
                  var7 = var8;
                  if(var9 != null) {
                     var8 = this.this$0.getChildViewHolder(var9);
                     if(var8 == null) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                     }

                     var7 = var8;
                     if(var8.shouldIgnore()) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                     }
                  }
               }
            }

            RecyclerView$ViewHolder var12 = var7;
            if(var7 == null) {
               var7 = this.getRecycledViewPool().getRecycledView(var6);
               var12 = var7;
               if(var7 != null) {
                  var7.resetInternal();
                  var12 = var7;
                  if(RecyclerView.access$4600()) {
                     this.invalidateDisplayListInt(var7);
                     var12 = var7;
                  }
               }
            }

            var5 = var4;
            var8 = var12;
            if(var12 == null) {
               var8 = RecyclerView.access$3100(this.this$0).createViewHolder(this.this$0, var6);
               var5 = var4;
            }
         }

         int var10;
         if(var5 && !this.this$0.mState.isPreLayout() && var8.hasAnyOfTheFlags(8192)) {
            var8.setFlags(0, 8192);
            if(RecyclerView$State.access$2500(this.this$0.mState)) {
               var10 = RecyclerView$ItemAnimator.buildAdapterChangeFlagsForAnimations(var8);
               RecyclerView$ItemAnimator$ItemHolderInfo var13 = this.this$0.mItemAnimator.recordPreLayoutInformation(this.this$0.mState, var8, var10 | 4096, var8.getUnmodifiedPayloads());
               RecyclerView.access$4700(this.this$0, var8, var13);
            }
         }

         var3 = false;
         if(this.this$0.mState.isPreLayout() && var8.isBound()) {
            var8.mPreLayoutPosition = var1;
         } else if(!var8.isBound() || var8.needsUpdate() || var8.isInvalid()) {
            var10 = this.this$0.mAdapterHelper.findPositionOffset(var1);
            var8.mOwnerRecyclerView = this.this$0;
            RecyclerView.access$3100(this.this$0).bindViewHolder(var8, var10);
            this.attachAccessibilityDelegate(var8.itemView);
            var4 = true;
            var3 = var4;
            if(this.this$0.mState.isPreLayout()) {
               var8.mPreLayoutPosition = var1;
               var3 = var4;
            }
         }

         LayoutParams var14 = var8.itemView.getLayoutParams();
         RecyclerView$LayoutParams var15;
         if(var14 == null) {
            var15 = (RecyclerView$LayoutParams)this.this$0.generateDefaultLayoutParams();
            var8.itemView.setLayoutParams(var15);
         } else if(!this.this$0.checkLayoutParams(var14)) {
            var15 = (RecyclerView$LayoutParams)this.this$0.generateLayoutParams(var14);
            var8.itemView.setLayoutParams(var15);
         } else {
            var15 = (RecyclerView$LayoutParams)var14;
         }

         var15.mViewHolder = var8;
         if(var5 && var3) {
            var2 = true;
         } else {
            var2 = false;
         }

         var15.mPendingInvalidate = var2;
         return var8.itemView;
      } else {
         throw new IndexOutOfBoundsException("Invalid item position " + var1 + "(" + var1 + "). Item count:" + this.this$0.mState.getItemCount());
      }
   }

   void markItemDecorInsetsDirty() {
      int var2 = this.mCachedViews.size();

      for(int var1 = 0; var1 < var2; ++var1) {
         RecyclerView$LayoutParams var3 = (RecyclerView$LayoutParams)((RecyclerView$ViewHolder)this.mCachedViews.get(var1)).itemView.getLayoutParams();
         if(var3 != null) {
            var3.mInsetsDirty = true;
         }
      }

   }

   void markKnownViewsInvalid() {
      if(RecyclerView.access$3100(this.this$0) != null && RecyclerView.access$3100(this.this$0).hasStableIds()) {
         int var2 = this.mCachedViews.size();

         for(int var1 = 0; var1 < var2; ++var1) {
            RecyclerView$ViewHolder var3 = (RecyclerView$ViewHolder)this.mCachedViews.get(var1);
            if(var3 != null) {
               var3.addFlags(6);
               var3.addChangePayload((Object)null);
            }
         }
      } else {
         this.recycleAndClearCachedViews();
      }

   }

   void offsetPositionRecordsForInsert(int var1, int var2) {
      int var4 = this.mCachedViews.size();

      for(int var3 = 0; var3 < var4; ++var3) {
         RecyclerView$ViewHolder var5 = (RecyclerView$ViewHolder)this.mCachedViews.get(var3);
         if(var5 != null && var5.mPosition >= var1) {
            var5.offsetPosition(var2, true);
         }
      }

   }

   void offsetPositionRecordsForMove(int var1, int var2) {
      int var3;
      byte var4;
      int var5;
      if(var1 < var2) {
         var5 = var1;
         var3 = var2;
         var4 = -1;
      } else {
         var5 = var2;
         var3 = var1;
         var4 = 1;
      }

      int var7 = this.mCachedViews.size();

      for(int var6 = 0; var6 < var7; ++var6) {
         RecyclerView$ViewHolder var8 = (RecyclerView$ViewHolder)this.mCachedViews.get(var6);
         if(var8 != null && var8.mPosition >= var5 && var8.mPosition <= var3) {
            if(var8.mPosition == var1) {
               var8.offsetPosition(var2 - var1, false);
            } else {
               var8.offsetPosition(var4, false);
            }
         }
      }

   }

   void offsetPositionRecordsForRemove(int var1, int var2, boolean var3) {
      for(int var4 = this.mCachedViews.size() - 1; var4 >= 0; --var4) {
         RecyclerView$ViewHolder var5 = (RecyclerView$ViewHolder)this.mCachedViews.get(var4);
         if(var5 != null) {
            if(var5.mPosition >= var1 + var2) {
               var5.offsetPosition(-var2, var3);
            } else if(var5.mPosition >= var1) {
               var5.addFlags(8);
               this.recycleCachedViewAt(var4);
            }
         }
      }

   }

   void onAdapterChanged(RecyclerView$Adapter var1, RecyclerView$Adapter var2, boolean var3) {
      this.clear();
      this.getRecycledViewPool().onAdapterChanged(var1, var2, var3);
   }

   void quickRecycleScrapView(View var1) {
      RecyclerView$ViewHolder var2 = RecyclerView.getChildViewHolderInt(var1);
      RecyclerView$ViewHolder.access$5002(var2, (RecyclerView$Recycler)null);
      RecyclerView$ViewHolder.access$5102(var2, false);
      var2.clearReturnedFromScrapFlag();
      this.recycleViewHolderInternal(var2);
   }

   void recycleAndClearCachedViews() {
      for(int var1 = this.mCachedViews.size() - 1; var1 >= 0; --var1) {
         this.recycleCachedViewAt(var1);
      }

      this.mCachedViews.clear();
   }

   void recycleCachedViewAt(int var1) {
      this.addViewHolderToRecycledViewPool((RecyclerView$ViewHolder)this.mCachedViews.get(var1));
      this.mCachedViews.remove(var1);
   }

   public void recycleView(View var1) {
      RecyclerView$ViewHolder var2 = RecyclerView.getChildViewHolderInt(var1);
      if(var2.isTmpDetached()) {
         this.this$0.removeDetachedView(var1, false);
      }

      if(var2.isScrap()) {
         var2.unScrap();
      } else if(var2.wasReturnedFromScrap()) {
         var2.clearReturnedFromScrapFlag();
      }

      this.recycleViewHolderInternal(var2);
   }

   void recycleViewHolderInternal(RecyclerView$ViewHolder var1) {
      boolean var7 = true;
      if(!var1.isScrap() && var1.itemView.getParent() == null) {
         if(var1.isTmpDetached()) {
            throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + var1);
         } else if(var1.shouldIgnore()) {
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
         } else {
            var7 = RecyclerView$ViewHolder.access$4900(var1);
            boolean var2;
            if(RecyclerView.access$3100(this.this$0) != null && var7 && RecyclerView.access$3100(this.this$0).onFailedToRecycleView(var1)) {
               var2 = true;
            } else {
               var2 = false;
            }

            boolean var3;
            boolean var4;
            label66: {
               var3 = false;
               boolean var6 = false;
               boolean var5 = false;
               if(!var2) {
                  var4 = var5;
                  if(!var1.isRecyclable()) {
                     break label66;
                  }
               }

               var2 = var6;
               if(!var1.hasAnyOfTheFlags(14)) {
                  int var9 = this.mCachedViews.size();
                  if(var9 == this.mViewCacheMax && var9 > 0) {
                     this.recycleCachedViewAt(0);
                  }

                  var2 = var6;
                  if(var9 < this.mViewCacheMax) {
                     this.mCachedViews.add(var1);
                     var2 = true;
                  }
               }

               var3 = var2;
               var4 = var5;
               if(!var2) {
                  this.addViewHolderToRecycledViewPool(var1);
                  var4 = true;
                  var3 = var2;
               }
            }

            this.this$0.mViewInfoStore.removeViewHolder(var1);
            if(!var3 && !var4 && var7) {
               var1.mOwnerRecyclerView = null;
            }

         }
      } else {
         StringBuilder var8 = (new StringBuilder()).append("Scrapped or attached views may not be recycled. isScrap:").append(var1.isScrap()).append(" isAttached:");
         if(var1.itemView.getParent() == null) {
            var7 = false;
         }

         throw new IllegalArgumentException(var8.append(var7).toString());
      }
   }

   void recycleViewInternal(View var1) {
      this.recycleViewHolderInternal(RecyclerView.getChildViewHolderInt(var1));
   }

   void scrapView(View var1) {
      RecyclerView$ViewHolder var2 = RecyclerView.getChildViewHolderInt(var1);
      if(!var2.hasAnyOfTheFlags(12) && var2.isUpdated() && !RecyclerView.access$5200(this.this$0, var2)) {
         if(this.mChangedScrap == null) {
            this.mChangedScrap = new ArrayList();
         }

         var2.setScrapContainer(this, true);
         this.mChangedScrap.add(var2);
      } else if(var2.isInvalid() && !var2.isRemoved() && !RecyclerView.access$3100(this.this$0).hasStableIds()) {
         throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
      } else {
         var2.setScrapContainer(this, false);
         this.mAttachedScrap.add(var2);
      }
   }

   void setAdapterPositionsAsUnknown() {
      int var2 = this.mCachedViews.size();

      for(int var1 = 0; var1 < var2; ++var1) {
         RecyclerView$ViewHolder var3 = (RecyclerView$ViewHolder)this.mCachedViews.get(var1);
         if(var3 != null) {
            var3.addFlags(512);
         }
      }

   }

   void setRecycledViewPool(RecyclerView$RecycledViewPool var1) {
      if(this.mRecyclerPool != null) {
         this.mRecyclerPool.detach();
      }

      this.mRecyclerPool = var1;
      if(var1 != null) {
         this.mRecyclerPool.attach(this.this$0.getAdapter());
      }

   }

   void setViewCacheExtension(RecyclerView$ViewCacheExtension var1) {
      this.mViewCacheExtension = var1;
   }

   public void setViewCacheSize(int var1) {
      this.mViewCacheMax = var1;

      for(int var2 = this.mCachedViews.size() - 1; var2 >= 0 && this.mCachedViews.size() > var1; --var2) {
         this.recycleCachedViewAt(var2);
      }

   }

   void unscrapView(RecyclerView$ViewHolder var1) {
      if(RecyclerView$ViewHolder.access$5100(var1)) {
         this.mChangedScrap.remove(var1);
      } else {
         this.mAttachedScrap.remove(var1);
      }

      RecyclerView$ViewHolder.access$5002(var1, (RecyclerView$Recycler)null);
      RecyclerView$ViewHolder.access$5102(var1, false);
      var1.clearReturnedFromScrapFlag();
   }

   boolean validateViewHolderForOffsetPosition(RecyclerView$ViewHolder var1) {
      boolean var3 = true;
      boolean var2;
      if(var1.isRemoved()) {
         var2 = this.this$0.mState.isPreLayout();
      } else {
         if(var1.mPosition < 0 || var1.mPosition >= RecyclerView.access$3100(this.this$0).getItemCount()) {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + var1);
         }

         if(!this.this$0.mState.isPreLayout() && RecyclerView.access$3100(this.this$0).getItemViewType(var1.mPosition) != var1.getItemViewType()) {
            return false;
         }

         var2 = var3;
         if(RecyclerView.access$3100(this.this$0).hasStableIds()) {
            var2 = var3;
            if(var1.getItemId() != RecyclerView.access$3100(this.this$0).getItemId(var1.mPosition)) {
               return false;
            }
         }
      }

      return var2;
   }

   void viewRangeUpdate(int var1, int var2) {
      for(int var3 = this.mCachedViews.size() - 1; var3 >= 0; --var3) {
         RecyclerView$ViewHolder var5 = (RecyclerView$ViewHolder)this.mCachedViews.get(var3);
         if(var5 != null) {
            int var4 = var5.getLayoutPosition();
            if(var4 >= var1 && var4 < var1 + var2) {
               var5.addFlags(2);
               this.recycleCachedViewAt(var3);
            }
         }
      }

   }
}
