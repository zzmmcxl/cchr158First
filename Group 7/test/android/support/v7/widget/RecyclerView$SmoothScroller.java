package android.support.v7.widget;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$LayoutManager;
import android.support.v7.widget.RecyclerView$SmoothScroller$Action;
import android.support.v7.widget.RecyclerView$State;
import android.util.Log;
import android.view.View;

public abstract class RecyclerView$SmoothScroller {
   private RecyclerView$LayoutManager mLayoutManager;
   private boolean mPendingInitialRun;
   private RecyclerView mRecyclerView;
   private final RecyclerView$SmoothScroller$Action mRecyclingAction = new RecyclerView$SmoothScroller$Action(0, 0);
   private boolean mRunning;
   private int mTargetPosition = -1;
   private View mTargetView;

   private void onAnimation(int var1, int var2) {
      RecyclerView var4 = this.mRecyclerView;
      if(!this.mRunning || this.mTargetPosition == -1 || var4 == null) {
         this.stop();
      }

      this.mPendingInitialRun = false;
      if(this.mTargetView != null) {
         if(this.getChildPosition(this.mTargetView) == this.mTargetPosition) {
            this.onTargetFound(this.mTargetView, var4.mState, this.mRecyclingAction);
            RecyclerView$SmoothScroller$Action.access$6100(this.mRecyclingAction, var4);
            this.stop();
         } else {
            Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
            this.mTargetView = null;
         }
      }

      if(this.mRunning) {
         this.onSeekTargetStep(var1, var2, var4.mState, this.mRecyclingAction);
         boolean var3 = this.mRecyclingAction.hasJumpTarget();
         RecyclerView$SmoothScroller$Action.access$6100(this.mRecyclingAction, var4);
         if(var3) {
            if(!this.mRunning) {
               this.stop();
               return;
            }

            this.mPendingInitialRun = true;
            RecyclerView.access$5900(var4).postOnAnimation();
         }
      }

   }

   public View findViewByPosition(int var1) {
      return this.mRecyclerView.mLayout.findViewByPosition(var1);
   }

   public int getChildCount() {
      return this.mRecyclerView.mLayout.getChildCount();
   }

   public int getChildPosition(View var1) {
      return this.mRecyclerView.getChildLayoutPosition(var1);
   }

   @Nullable
   public RecyclerView$LayoutManager getLayoutManager() {
      return this.mLayoutManager;
   }

   public int getTargetPosition() {
      return this.mTargetPosition;
   }

   @Deprecated
   public void instantScrollToPosition(int var1) {
      this.mRecyclerView.scrollToPosition(var1);
   }

   public boolean isPendingInitialRun() {
      return this.mPendingInitialRun;
   }

   public boolean isRunning() {
      return this.mRunning;
   }

   protected void normalize(PointF var1) {
      double var2 = Math.sqrt((double)(var1.x * var1.x + var1.y * var1.y));
      var1.x = (float)((double)var1.x / var2);
      var1.y = (float)((double)var1.y / var2);
   }

   protected void onChildAttachedToWindow(View var1) {
      if(this.getChildPosition(var1) == this.getTargetPosition()) {
         this.mTargetView = var1;
      }

   }

   protected abstract void onSeekTargetStep(int var1, int var2, RecyclerView$State var3, RecyclerView$SmoothScroller$Action var4);

   protected abstract void onStart();

   protected abstract void onStop();

   protected abstract void onTargetFound(View var1, RecyclerView$State var2, RecyclerView$SmoothScroller$Action var3);

   public void setTargetPosition(int var1) {
      this.mTargetPosition = var1;
   }

   void start(RecyclerView var1, RecyclerView$LayoutManager var2) {
      this.mRecyclerView = var1;
      this.mLayoutManager = var2;
      if(this.mTargetPosition == -1) {
         throw new IllegalArgumentException("Invalid target position");
      } else {
         RecyclerView$State.access$5802(this.mRecyclerView.mState, this.mTargetPosition);
         this.mRunning = true;
         this.mPendingInitialRun = true;
         this.mTargetView = this.findViewByPosition(this.getTargetPosition());
         this.onStart();
         RecyclerView.access$5900(this.mRecyclerView).postOnAnimation();
      }
   }

   protected final void stop() {
      if(this.mRunning) {
         this.onStop();
         RecyclerView$State.access$5802(this.mRecyclerView.mState, -1);
         this.mTargetView = null;
         this.mTargetPosition = -1;
         this.mPendingInitialRun = false;
         this.mRunning = false;
         RecyclerView$LayoutManager.access$6000(this.mLayoutManager, this);
         this.mLayoutManager = null;
         this.mRecyclerView = null;
      }
   }
}
