package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.Interpolator;

public class RecyclerView$SmoothScroller$Action {
   public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
   private boolean changed;
   private int consecutiveUpdates;
   private int mDuration;
   private int mDx;
   private int mDy;
   private Interpolator mInterpolator;
   private int mJumpToPosition;

   public RecyclerView$SmoothScroller$Action(int var1, int var2) {
      this(var1, var2, Integer.MIN_VALUE, (Interpolator)null);
   }

   public RecyclerView$SmoothScroller$Action(int var1, int var2, int var3) {
      this(var1, var2, var3, (Interpolator)null);
   }

   public RecyclerView$SmoothScroller$Action(int var1, int var2, int var3, Interpolator var4) {
      this.mJumpToPosition = -1;
      this.changed = false;
      this.consecutiveUpdates = 0;
      this.mDx = var1;
      this.mDy = var2;
      this.mDuration = var3;
      this.mInterpolator = var4;
   }

   private void runIfNecessary(RecyclerView var1) {
      if(this.mJumpToPosition >= 0) {
         int var2 = this.mJumpToPosition;
         this.mJumpToPosition = -1;
         RecyclerView.access$6200(var1, var2);
         this.changed = false;
      } else if(this.changed) {
         this.validate();
         if(this.mInterpolator == null) {
            if(this.mDuration == Integer.MIN_VALUE) {
               RecyclerView.access$5900(var1).smoothScrollBy(this.mDx, this.mDy);
            } else {
               RecyclerView.access$5900(var1).smoothScrollBy(this.mDx, this.mDy, this.mDuration);
            }
         } else {
            RecyclerView.access$5900(var1).smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
         }

         ++this.consecutiveUpdates;
         if(this.consecutiveUpdates > 10) {
            Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
         }

         this.changed = false;
      } else {
         this.consecutiveUpdates = 0;
      }
   }

   private void validate() {
      if(this.mInterpolator != null && this.mDuration < 1) {
         throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
      } else if(this.mDuration < 1) {
         throw new IllegalStateException("Scroll duration must be a positive number");
      }
   }

   public int getDuration() {
      return this.mDuration;
   }

   public int getDx() {
      return this.mDx;
   }

   public int getDy() {
      return this.mDy;
   }

   public Interpolator getInterpolator() {
      return this.mInterpolator;
   }

   boolean hasJumpTarget() {
      return this.mJumpToPosition >= 0;
   }

   public void jumpTo(int var1) {
      this.mJumpToPosition = var1;
   }

   public void setDuration(int var1) {
      this.changed = true;
      this.mDuration = var1;
   }

   public void setDx(int var1) {
      this.changed = true;
      this.mDx = var1;
   }

   public void setDy(int var1) {
      this.changed = true;
      this.mDy = var1;
   }

   public void setInterpolator(Interpolator var1) {
      this.changed = true;
      this.mInterpolator = var1;
   }

   public void update(int var1, int var2, int var3, Interpolator var4) {
      this.mDx = var1;
      this.mDy = var2;
      this.mDuration = var3;
      this.mInterpolator = var4;
      this.changed = true;
   }
}
