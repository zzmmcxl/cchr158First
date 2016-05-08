package android.support.v7.widget;

import android.support.v4.os.TraceCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ScrollerCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$SmoothScroller;
import android.view.animation.Interpolator;

class RecyclerView$ViewFlinger implements Runnable {
   private boolean mEatRunOnAnimationRequest;
   private Interpolator mInterpolator;
   private int mLastFlingX;
   private int mLastFlingY;
   private boolean mReSchedulePostAnimationCallback;
   private ScrollerCompat mScroller;

   public RecyclerView$ViewFlinger(RecyclerView var1) {
      this.this$0 = var1;
      this.mInterpolator = RecyclerView.access$3000();
      this.mEatRunOnAnimationRequest = false;
      this.mReSchedulePostAnimationCallback = false;
      this.mScroller = ScrollerCompat.create(var1.getContext(), RecyclerView.access$3000());
   }

   private int computeScrollDuration(int var1, int var2, int var3, int var4) {
      int var9 = Math.abs(var1);
      int var10 = Math.abs(var2);
      boolean var8;
      if(var9 > var10) {
         var8 = true;
      } else {
         var8 = false;
      }

      var3 = (int)Math.sqrt((double)(var3 * var3 + var4 * var4));
      var2 = (int)Math.sqrt((double)(var1 * var1 + var2 * var2));
      if(var8) {
         var1 = this.this$0.getWidth();
      } else {
         var1 = this.this$0.getHeight();
      }

      var4 = var1 / 2;
      float var7 = Math.min(1.0F, 1.0F * (float)var2 / (float)var1);
      float var5 = (float)var4;
      float var6 = (float)var4;
      var7 = this.distanceInfluenceForSnapDuration(var7);
      if(var3 > 0) {
         var1 = Math.round(1000.0F * Math.abs((var5 + var6 * var7) / (float)var3)) * 4;
      } else {
         if(var8) {
            var2 = var9;
         } else {
            var2 = var10;
         }

         var1 = (int)(((float)var2 / (float)var1 + 1.0F) * 300.0F);
      }

      return Math.min(var1, 2000);
   }

   private void disableRunOnAnimationRequests() {
      this.mReSchedulePostAnimationCallback = false;
      this.mEatRunOnAnimationRequest = true;
   }

   private float distanceInfluenceForSnapDuration(float var1) {
      return (float)Math.sin((double)((float)((double)(var1 - 0.5F) * 0.4712389167638204D)));
   }

   private void enableRunOnAnimationRequests() {
      this.mEatRunOnAnimationRequest = false;
      if(this.mReSchedulePostAnimationCallback) {
         this.postOnAnimation();
      }

   }

   public void fling(int var1, int var2) {
      RecyclerView.access$3900(this.this$0, 2);
      this.mLastFlingY = 0;
      this.mLastFlingX = 0;
      this.mScroller.fling(0, 0, var1, var2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
      this.postOnAnimation();
   }

   void postOnAnimation() {
      if(this.mEatRunOnAnimationRequest) {
         this.mReSchedulePostAnimationCallback = true;
      } else {
         this.this$0.removeCallbacks(this);
         ViewCompat.postOnAnimation(this.this$0, this);
      }
   }

   public void run() {
      if(this.this$0.mLayout == null) {
         this.stop();
      } else {
         this.disableRunOnAnimationRequests();
         RecyclerView.access$400(this.this$0);
         ScrollerCompat var13 = this.mScroller;
         RecyclerView$SmoothScroller var14 = this.this$0.mLayout.mSmoothScroller;
         if(var13.computeScrollOffset()) {
            int var11 = var13.getCurrX();
            int var12 = var13.getCurrY();
            int var9 = var11 - this.mLastFlingX;
            int var10 = var12 - this.mLastFlingY;
            int var5 = 0;
            int var1 = 0;
            int var8 = 0;
            int var4 = 0;
            this.mLastFlingX = var11;
            this.mLastFlingY = var12;
            int var6 = 0;
            int var2 = 0;
            int var7 = 0;
            int var3 = 0;
            if(RecyclerView.access$3100(this.this$0) != null) {
               this.this$0.eatRequestLayout();
               RecyclerView.access$3200(this.this$0);
               TraceCompat.beginSection("RV Scroll");
               if(var9 != 0) {
                  var1 = this.this$0.mLayout.scrollHorizontallyBy(var9, this.this$0.mRecycler, this.this$0.mState);
                  var2 = var9 - var1;
               }

               if(var10 != 0) {
                  var4 = this.this$0.mLayout.scrollVerticallyBy(var10, this.this$0.mRecycler, this.this$0.mState);
                  var3 = var10 - var4;
               }

               TraceCompat.endSection();
               RecyclerView.access$3300(this.this$0);
               RecyclerView.access$3400(this.this$0);
               this.this$0.resumeRequestLayout(false);
               var5 = var1;
               var6 = var2;
               var7 = var3;
               var8 = var4;
               if(var14 != null) {
                  var5 = var1;
                  var6 = var2;
                  var7 = var3;
                  var8 = var4;
                  if(!var14.isPendingInitialRun()) {
                     var5 = var1;
                     var6 = var2;
                     var7 = var3;
                     var8 = var4;
                     if(var14.isRunning()) {
                        var5 = this.this$0.mState.getItemCount();
                        if(var5 == 0) {
                           var14.stop();
                           var8 = var4;
                           var7 = var3;
                           var6 = var2;
                           var5 = var1;
                        } else if(var14.getTargetPosition() >= var5) {
                           var14.setTargetPosition(var5 - 1);
                           RecyclerView$SmoothScroller.access$3500(var14, var9 - var2, var10 - var3);
                           var5 = var1;
                           var6 = var2;
                           var7 = var3;
                           var8 = var4;
                        } else {
                           RecyclerView$SmoothScroller.access$3500(var14, var9 - var2, var10 - var3);
                           var5 = var1;
                           var6 = var2;
                           var7 = var3;
                           var8 = var4;
                        }
                     }
                  }
               }
            }

            if(!RecyclerView.access$3600(this.this$0).isEmpty()) {
               this.this$0.invalidate();
            }

            if(ViewCompat.getOverScrollMode(this.this$0) != 2) {
               RecyclerView.access$3700(this.this$0, var9, var10);
            }

            if(var6 != 0 || var7 != 0) {
               var3 = (int)var13.getCurrVelocity();
               var1 = 0;
               if(var6 != var11) {
                  if(var6 < 0) {
                     var1 = -var3;
                  } else if(var6 > 0) {
                     var1 = var3;
                  } else {
                     var1 = 0;
                  }
               }

               var2 = 0;
               if(var7 != var12) {
                  if(var7 < 0) {
                     var2 = -var3;
                  } else if(var7 > 0) {
                     var2 = var3;
                  } else {
                     var2 = 0;
                  }
               }

               if(ViewCompat.getOverScrollMode(this.this$0) != 2) {
                  this.this$0.absorbGlows(var1, var2);
               }

               if((var1 != 0 || var6 == var11 || var13.getFinalX() == 0) && (var2 != 0 || var7 == var12 || var13.getFinalY() == 0)) {
                  var13.abortAnimation();
               }
            }

            if(var5 != 0 || var8 != 0) {
               this.this$0.dispatchOnScrolled(var5, var8);
            }

            if(!RecyclerView.access$3800(this.this$0)) {
               this.this$0.invalidate();
            }

            boolean var15;
            if(var10 != 0 && this.this$0.mLayout.canScrollVertically() && var8 == var10) {
               var15 = true;
            } else {
               var15 = false;
            }

            boolean var16;
            if(var9 != 0 && this.this$0.mLayout.canScrollHorizontally() && var5 == var9) {
               var16 = true;
            } else {
               var16 = false;
            }

            if((var9 != 0 || var10 != 0) && !var16 && !var15) {
               var15 = false;
            } else {
               var15 = true;
            }

            if(!var13.isFinished() && var15) {
               this.postOnAnimation();
            } else {
               RecyclerView.access$3900(this.this$0, 0);
            }
         }

         if(var14 != null) {
            if(var14.isPendingInitialRun()) {
               RecyclerView$SmoothScroller.access$3500(var14, 0, 0);
            }

            if(!this.mReSchedulePostAnimationCallback) {
               var14.stop();
            }
         }

         this.enableRunOnAnimationRequests();
      }
   }

   public void smoothScrollBy(int var1, int var2) {
      this.smoothScrollBy(var1, var2, 0, 0);
   }

   public void smoothScrollBy(int var1, int var2, int var3) {
      this.smoothScrollBy(var1, var2, var3, RecyclerView.access$3000());
   }

   public void smoothScrollBy(int var1, int var2, int var3, int var4) {
      this.smoothScrollBy(var1, var2, this.computeScrollDuration(var1, var2, var3, var4));
   }

   public void smoothScrollBy(int var1, int var2, int var3, Interpolator var4) {
      if(this.mInterpolator != var4) {
         this.mInterpolator = var4;
         this.mScroller = ScrollerCompat.create(this.this$0.getContext(), var4);
      }

      RecyclerView.access$3900(this.this$0, 2);
      this.mLastFlingY = 0;
      this.mLastFlingX = 0;
      this.mScroller.startScroll(0, 0, var1, var2, var3);
      this.postOnAnimation();
   }

   public void stop() {
      this.this$0.removeCallbacks(this);
      this.mScroller.abortAnimation();
   }
}
