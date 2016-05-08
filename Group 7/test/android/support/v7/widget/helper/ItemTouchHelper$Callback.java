package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.recyclerview.R$dimen;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$ItemAnimator;
import android.support.v7.widget.RecyclerView$LayoutManager;
import android.support.v7.widget.RecyclerView$ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper$Callback$1;
import android.support.v7.widget.helper.ItemTouchHelper$Callback$2;
import android.support.v7.widget.helper.ItemTouchHelper$RecoverAnimation;
import android.support.v7.widget.helper.ItemTouchHelper$ViewDropHandler;
import android.support.v7.widget.helper.ItemTouchUIUtil;
import android.support.v7.widget.helper.ItemTouchUIUtilImpl$Gingerbread;
import android.support.v7.widget.helper.ItemTouchUIUtilImpl$Honeycomb;
import android.support.v7.widget.helper.ItemTouchUIUtilImpl$Lollipop;
import android.view.animation.Interpolator;
import java.util.List;

public abstract class ItemTouchHelper$Callback {
   private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
   public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
   public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
   private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000L;
   static final int RELATIVE_DIR_FLAGS = 3158064;
   private static final Interpolator sDragScrollInterpolator = new ItemTouchHelper$Callback$1();
   private static final Interpolator sDragViewScrollCapInterpolator = new ItemTouchHelper$Callback$2();
   private static final ItemTouchUIUtil sUICallback;
   private int mCachedMaxScrollSpeed = -1;

   static {
      if(VERSION.SDK_INT >= 21) {
         sUICallback = new ItemTouchUIUtilImpl$Lollipop();
      } else if(VERSION.SDK_INT >= 11) {
         sUICallback = new ItemTouchUIUtilImpl$Honeycomb();
      } else {
         sUICallback = new ItemTouchUIUtilImpl$Gingerbread();
      }
   }

   public static int convertToRelativeDirection(int var0, int var1) {
      int var2 = var0 & 789516;
      if(var2 == 0) {
         return var0;
      } else {
         var0 &= ~var2;
         return var1 == 0?var0 | var2 << 2:var0 | var2 << 1 & -789517 | (var2 << 1 & 789516) << 2;
      }
   }

   public static ItemTouchUIUtil getDefaultUIUtil() {
      return sUICallback;
   }

   private int getMaxDragScroll(RecyclerView var1) {
      if(this.mCachedMaxScrollSpeed == -1) {
         this.mCachedMaxScrollSpeed = var1.getResources().getDimensionPixelSize(R$dimen.item_touch_helper_max_drag_scroll_per_frame);
      }

      return this.mCachedMaxScrollSpeed;
   }

   private boolean hasDragFlag(RecyclerView var1, RecyclerView$ViewHolder var2) {
      return (16711680 & this.getAbsoluteMovementFlags(var1, var2)) != 0;
   }

   private boolean hasSwipeFlag(RecyclerView var1, RecyclerView$ViewHolder var2) {
      return ('\uff00' & this.getAbsoluteMovementFlags(var1, var2)) != 0;
   }

   public static int makeFlag(int var0, int var1) {
      return var1 << var0 * 8;
   }

   public static int makeMovementFlags(int var0, int var1) {
      return makeFlag(0, var1 | var0) | makeFlag(1, var1) | makeFlag(2, var0);
   }

   private void onDraw(Canvas var1, RecyclerView var2, RecyclerView$ViewHolder var3, List<ItemTouchHelper$RecoverAnimation> var4, int var5, float var6, float var7) {
      int var9 = var4.size();

      int var8;
      for(var8 = 0; var8 < var9; ++var8) {
         ItemTouchHelper$RecoverAnimation var11 = (ItemTouchHelper$RecoverAnimation)var4.get(var8);
         var11.update();
         int var10 = var1.save();
         this.onChildDraw(var1, var2, var11.mViewHolder, var11.mX, var11.mY, var11.mActionState, false);
         var1.restoreToCount(var10);
      }

      if(var3 != null) {
         var8 = var1.save();
         this.onChildDraw(var1, var2, var3, var6, var7, var5, true);
         var1.restoreToCount(var8);
      }

   }

   private void onDrawOver(Canvas var1, RecyclerView var2, RecyclerView$ViewHolder var3, List<ItemTouchHelper$RecoverAnimation> var4, int var5, float var6, float var7) {
      int var9 = var4.size();

      int var8;
      for(var8 = 0; var8 < var9; ++var8) {
         ItemTouchHelper$RecoverAnimation var11 = (ItemTouchHelper$RecoverAnimation)var4.get(var8);
         int var10 = var1.save();
         this.onChildDrawOver(var1, var2, var11.mViewHolder, var11.mX, var11.mY, var11.mActionState, false);
         var1.restoreToCount(var10);
      }

      if(var3 != null) {
         var8 = var1.save();
         this.onChildDrawOver(var1, var2, var3, var6, var7, var5, true);
         var1.restoreToCount(var8);
      }

      boolean var13 = false;

      for(var5 = var9 - 1; var5 >= 0; --var5) {
         ItemTouchHelper$RecoverAnimation var12 = (ItemTouchHelper$RecoverAnimation)var4.get(var5);
         if(ItemTouchHelper$RecoverAnimation.access$1900(var12) && !var12.mIsPendingCleanup) {
            var4.remove(var5);
         } else if(!ItemTouchHelper$RecoverAnimation.access$1900(var12)) {
            var13 = true;
         }
      }

      if(var13) {
         var2.invalidate();
      }

   }

   public boolean canDropOver(RecyclerView var1, RecyclerView$ViewHolder var2, RecyclerView$ViewHolder var3) {
      return true;
   }

   public RecyclerView$ViewHolder chooseDropTarget(RecyclerView$ViewHolder var1, List<RecyclerView$ViewHolder> var2, int var3, int var4) {
      int var9 = var1.itemView.getWidth();
      int var10 = var1.itemView.getHeight();
      RecyclerView$ViewHolder var16 = null;
      int var6 = -1;
      int var11 = var3 - var1.itemView.getLeft();
      int var12 = var4 - var1.itemView.getTop();
      int var13 = var2.size();

      for(int var7 = 0; var7 < var13; ++var7) {
         RecyclerView$ViewHolder var14 = (RecyclerView$ViewHolder)var2.get(var7);
         RecyclerView$ViewHolder var15 = var16;
         int var5 = var6;
         int var8;
         if(var11 > 0) {
            var8 = var14.itemView.getRight() - (var3 + var9);
            var15 = var16;
            var5 = var6;
            if(var8 < 0) {
               var15 = var16;
               var5 = var6;
               if(var14.itemView.getRight() > var1.itemView.getRight()) {
                  var8 = Math.abs(var8);
                  var15 = var16;
                  var5 = var6;
                  if(var8 > var6) {
                     var5 = var8;
                     var15 = var14;
                  }
               }
            }
         }

         var16 = var15;
         var6 = var5;
         if(var11 < 0) {
            var8 = var14.itemView.getLeft() - var3;
            var16 = var15;
            var6 = var5;
            if(var8 > 0) {
               var16 = var15;
               var6 = var5;
               if(var14.itemView.getLeft() < var1.itemView.getLeft()) {
                  var8 = Math.abs(var8);
                  var16 = var15;
                  var6 = var5;
                  if(var8 > var5) {
                     var6 = var8;
                     var16 = var14;
                  }
               }
            }
         }

         var15 = var16;
         var5 = var6;
         if(var12 < 0) {
            var8 = var14.itemView.getTop() - var4;
            var15 = var16;
            var5 = var6;
            if(var8 > 0) {
               var15 = var16;
               var5 = var6;
               if(var14.itemView.getTop() < var1.itemView.getTop()) {
                  var8 = Math.abs(var8);
                  var15 = var16;
                  var5 = var6;
                  if(var8 > var6) {
                     var5 = var8;
                     var15 = var14;
                  }
               }
            }
         }

         var16 = var15;
         var6 = var5;
         if(var12 > 0) {
            var8 = var14.itemView.getBottom() - (var4 + var10);
            var16 = var15;
            var6 = var5;
            if(var8 < 0) {
               var16 = var15;
               var6 = var5;
               if(var14.itemView.getBottom() > var1.itemView.getBottom()) {
                  var8 = Math.abs(var8);
                  var16 = var15;
                  var6 = var5;
                  if(var8 > var5) {
                     var6 = var8;
                     var16 = var14;
                  }
               }
            }
         }
      }

      return var16;
   }

   public void clearView(RecyclerView var1, RecyclerView$ViewHolder var2) {
      sUICallback.clearView(var2.itemView);
   }

   public int convertToAbsoluteDirection(int var1, int var2) {
      int var3 = var1 & 3158064;
      if(var3 == 0) {
         return var1;
      } else {
         var1 &= ~var3;
         return var2 == 0?var1 | var3 >> 2:var1 | var3 >> 1 & -3158065 | (var3 >> 1 & 3158064) >> 2;
      }
   }

   final int getAbsoluteMovementFlags(RecyclerView var1, RecyclerView$ViewHolder var2) {
      return this.convertToAbsoluteDirection(this.getMovementFlags(var1, var2), ViewCompat.getLayoutDirection(var1));
   }

   public long getAnimationDuration(RecyclerView var1, int var2, float var3, float var4) {
      RecyclerView$ItemAnimator var5 = var1.getItemAnimator();
      return var5 == null?(var2 == 8?200L:250L):(var2 == 8?var5.getMoveDuration():var5.getRemoveDuration());
   }

   public int getBoundingBoxMargin() {
      return 0;
   }

   public float getMoveThreshold(RecyclerView$ViewHolder var1) {
      return 0.5F;
   }

   public abstract int getMovementFlags(RecyclerView var1, RecyclerView$ViewHolder var2);

   public float getSwipeEscapeVelocity(float var1) {
      return var1;
   }

   public float getSwipeThreshold(RecyclerView$ViewHolder var1) {
      return 0.5F;
   }

   public float getSwipeVelocityThreshold(float var1) {
      return var1;
   }

   public int interpolateOutOfBoundsScroll(RecyclerView var1, int var2, int var3, int var4, long var5) {
      var4 = this.getMaxDragScroll(var1);
      int var8 = Math.abs(var3);
      int var9 = (int)Math.signum((float)var3);
      float var7 = Math.min(1.0F, 1.0F * (float)var8 / (float)var2);
      var2 = (int)((float)(var9 * var4) * sDragViewScrollCapInterpolator.getInterpolation(var7));
      if(var5 > 2000L) {
         var7 = 1.0F;
      } else {
         var7 = (float)var5 / 2000.0F;
      }

      var2 = (int)((float)var2 * sDragScrollInterpolator.getInterpolation(var7));
      return var2 == 0?(var3 > 0?1:-1):var2;
   }

   public boolean isItemViewSwipeEnabled() {
      return true;
   }

   public boolean isLongPressDragEnabled() {
      return true;
   }

   public void onChildDraw(Canvas var1, RecyclerView var2, RecyclerView$ViewHolder var3, float var4, float var5, int var6, boolean var7) {
      sUICallback.onDraw(var1, var2, var3.itemView, var4, var5, var6, var7);
   }

   public void onChildDrawOver(Canvas var1, RecyclerView var2, RecyclerView$ViewHolder var3, float var4, float var5, int var6, boolean var7) {
      sUICallback.onDrawOver(var1, var2, var3.itemView, var4, var5, var6, var7);
   }

   public abstract boolean onMove(RecyclerView var1, RecyclerView$ViewHolder var2, RecyclerView$ViewHolder var3);

   public void onMoved(RecyclerView var1, RecyclerView$ViewHolder var2, int var3, RecyclerView$ViewHolder var4, int var5, int var6, int var7) {
      RecyclerView$LayoutManager var8 = var1.getLayoutManager();
      if(var8 instanceof ItemTouchHelper$ViewDropHandler) {
         ((ItemTouchHelper$ViewDropHandler)var8).prepareForDrop(var2.itemView, var4.itemView, var6, var7);
      } else {
         if(var8.canScrollHorizontally()) {
            if(var8.getDecoratedLeft(var4.itemView) <= var1.getPaddingLeft()) {
               var1.scrollToPosition(var5);
            }

            if(var8.getDecoratedRight(var4.itemView) >= var1.getWidth() - var1.getPaddingRight()) {
               var1.scrollToPosition(var5);
            }
         }

         if(var8.canScrollVertically()) {
            if(var8.getDecoratedTop(var4.itemView) <= var1.getPaddingTop()) {
               var1.scrollToPosition(var5);
            }

            if(var8.getDecoratedBottom(var4.itemView) >= var1.getHeight() - var1.getPaddingBottom()) {
               var1.scrollToPosition(var5);
               return;
            }
         }
      }

   }

   public void onSelectedChanged(RecyclerView$ViewHolder var1, int var2) {
      if(var1 != null) {
         sUICallback.onSelected(var1.itemView);
      }

   }

   public abstract void onSwiped(RecyclerView$ViewHolder var1, int var2);
}
