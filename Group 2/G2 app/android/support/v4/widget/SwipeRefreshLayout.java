package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.CircleImageView;
import android.support.v4.widget.MaterialProgressDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.view.animation.Animation.AnimationListener;
import android.widget.AbsListView;

public class SwipeRefreshLayout extends ViewGroup {
   private static final int ALPHA_ANIMATION_DURATION = 300;
   private static final int ANIMATE_TO_START_DURATION = 200;
   private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
   private static final int CIRCLE_BG_LIGHT = -328966;
   private static final int CIRCLE_DIAMETER = 40;
   private static final int CIRCLE_DIAMETER_LARGE = 56;
   private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0F;
   public static final int DEFAULT = 1;
   private static final int DEFAULT_CIRCLE_TARGET = 64;
   private static final float DRAG_RATE = 0.5F;
   private static final int INVALID_POINTER = -1;
   public static final int LARGE = 0;
   private static final int[] LAYOUT_ATTRS = new int[]{16842766};
   private static final String LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
   private static final int MAX_ALPHA = 255;
   private static final float MAX_PROGRESS_ANGLE = 0.8F;
   private static final int SCALE_DOWN_DURATION = 150;
   private static final int STARTING_PROGRESS_ALPHA = 76;
   private int mActivePointerId;
   private Animation mAlphaMaxAnimation;
   private Animation mAlphaStartAnimation;
   private final Animation mAnimateToCorrectPosition;
   private final Animation mAnimateToStartPosition;
   private int mCircleHeight;
   private CircleImageView mCircleView;
   private int mCircleViewIndex;
   private int mCircleWidth;
   private int mCurrentTargetOffsetTop;
   private final DecelerateInterpolator mDecelerateInterpolator;
   protected int mFrom;
   private float mInitialDownY;
   private float mInitialMotionY;
   private boolean mIsBeingDragged;
   private SwipeRefreshLayout.OnRefreshListener mListener;
   private int mMediumAnimationDuration;
   private boolean mNotify;
   private boolean mOriginalOffsetCalculated;
   protected int mOriginalOffsetTop;
   private MaterialProgressDrawable mProgress;
   private AnimationListener mRefreshListener;
   private boolean mRefreshing;
   private boolean mReturningToStart;
   private boolean mScale;
   private Animation mScaleAnimation;
   private Animation mScaleDownAnimation;
   private Animation mScaleDownToStartAnimation;
   private float mSpinnerFinalOffset;
   private float mStartingScale;
   private View mTarget;
   private float mTotalDragDistance;
   private int mTouchSlop;
   private boolean mUsingCustomStart;

   public SwipeRefreshLayout(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public SwipeRefreshLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.mRefreshing = false;
      this.mTotalDragDistance = -1.0F;
      this.mOriginalOffsetCalculated = false;
      this.mActivePointerId = -1;
      this.mCircleViewIndex = -1;
      this.mRefreshListener = new AnimationListener() {
         public void onAnimationEnd(Animation var1) {
            if(SwipeRefreshLayout.this.mRefreshing) {
               SwipeRefreshLayout.this.mProgress.setAlpha(255);
               SwipeRefreshLayout.this.mProgress.start();
               if(SwipeRefreshLayout.this.mNotify && SwipeRefreshLayout.this.mListener != null) {
                  SwipeRefreshLayout.this.mListener.onRefresh();
               }
            } else {
               SwipeRefreshLayout.this.mProgress.stop();
               SwipeRefreshLayout.this.mCircleView.setVisibility(8);
               SwipeRefreshLayout.this.setColorViewAlpha(255);
               if(SwipeRefreshLayout.this.mScale) {
                  SwipeRefreshLayout.this.setAnimationProgress(0.0F);
               } else {
                  SwipeRefreshLayout.this.setTargetOffsetTopAndBottom(SwipeRefreshLayout.this.mOriginalOffsetTop - SwipeRefreshLayout.this.mCurrentTargetOffsetTop, true);
               }
            }

            SwipeRefreshLayout.this.mCurrentTargetOffsetTop = SwipeRefreshLayout.this.mCircleView.getTop();
         }

         public void onAnimationRepeat(Animation var1) {
         }

         public void onAnimationStart(Animation var1) {
         }
      };
      this.mAnimateToCorrectPosition = new Animation() {
         public void applyTransformation(float var1, Transformation var2) {
            int var3;
            if(!SwipeRefreshLayout.this.mUsingCustomStart) {
               var3 = (int)(SwipeRefreshLayout.this.mSpinnerFinalOffset - (float)Math.abs(SwipeRefreshLayout.this.mOriginalOffsetTop));
            } else {
               var3 = (int)SwipeRefreshLayout.this.mSpinnerFinalOffset;
            }

            int var4 = SwipeRefreshLayout.this.mFrom;
            var3 = (int)((float)(var3 - SwipeRefreshLayout.this.mFrom) * var1);
            int var5 = SwipeRefreshLayout.this.mCircleView.getTop();
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom(var4 + var3 - var5, false);
            SwipeRefreshLayout.this.mProgress.setArrowScale(1.0F - var1);
         }
      };
      this.mAnimateToStartPosition = new Animation() {
         public void applyTransformation(float var1, Transformation var2) {
            SwipeRefreshLayout.this.moveToStart(var1);
         }
      };
      this.mTouchSlop = ViewConfiguration.get(var1).getScaledTouchSlop();
      this.mMediumAnimationDuration = this.getResources().getInteger(17694721);
      this.setWillNotDraw(false);
      this.mDecelerateInterpolator = new DecelerateInterpolator(2.0F);
      TypedArray var3 = var1.obtainStyledAttributes(var2, LAYOUT_ATTRS);
      this.setEnabled(var3.getBoolean(0, true));
      var3.recycle();
      DisplayMetrics var4 = this.getResources().getDisplayMetrics();
      this.mCircleWidth = (int)(var4.density * 40.0F);
      this.mCircleHeight = (int)(var4.density * 40.0F);
      this.createProgressView();
      ViewCompat.setChildrenDrawingOrderEnabled(this, true);
      this.mSpinnerFinalOffset = 64.0F * var4.density;
      this.mTotalDragDistance = this.mSpinnerFinalOffset;
   }

   private void animateOffsetToCorrectPosition(int var1, AnimationListener var2) {
      this.mFrom = var1;
      this.mAnimateToCorrectPosition.reset();
      this.mAnimateToCorrectPosition.setDuration(200L);
      this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
      if(var2 != null) {
         this.mCircleView.setAnimationListener(var2);
      }

      this.mCircleView.clearAnimation();
      this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
   }

   private void animateOffsetToStartPosition(int var1, AnimationListener var2) {
      if(this.mScale) {
         this.startScaleDownReturnToStartAnimation(var1, var2);
      } else {
         this.mFrom = var1;
         this.mAnimateToStartPosition.reset();
         this.mAnimateToStartPosition.setDuration(200L);
         this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
         if(var2 != null) {
            this.mCircleView.setAnimationListener(var2);
         }

         this.mCircleView.clearAnimation();
         this.mCircleView.startAnimation(this.mAnimateToStartPosition);
      }
   }

   private void createProgressView() {
      this.mCircleView = new CircleImageView(this.getContext(), -328966, 20.0F);
      this.mProgress = new MaterialProgressDrawable(this.getContext(), this);
      this.mProgress.setBackgroundColor(-328966);
      this.mCircleView.setImageDrawable(this.mProgress);
      this.mCircleView.setVisibility(8);
      this.addView(this.mCircleView);
   }

   private void ensureTarget() {
      if(this.mTarget == null) {
         for(int var1 = 0; var1 < this.getChildCount(); ++var1) {
            View var2 = this.getChildAt(var1);
            if(!var2.equals(this.mCircleView)) {
               this.mTarget = var2;
               break;
            }
         }
      }

   }

   private float getMotionEventY(MotionEvent var1, int var2) {
      var2 = MotionEventCompat.findPointerIndex(var1, var2);
      return var2 < 0?-1.0F:MotionEventCompat.getY(var1, var2);
   }

   private boolean isAlphaUsedForScale() {
      return VERSION.SDK_INT < 11;
   }

   private boolean isAnimationRunning(Animation var1) {
      return var1 != null && var1.hasStarted() && !var1.hasEnded();
   }

   private void moveToStart(float var1) {
      this.setTargetOffsetTopAndBottom(this.mFrom + (int)((float)(this.mOriginalOffsetTop - this.mFrom) * var1) - this.mCircleView.getTop(), false);
   }

   private void onSecondaryPointerUp(MotionEvent var1) {
      int var2 = MotionEventCompat.getActionIndex(var1);
      if(MotionEventCompat.getPointerId(var1, var2) == this.mActivePointerId) {
         byte var3;
         if(var2 == 0) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         this.mActivePointerId = MotionEventCompat.getPointerId(var1, var3);
      }

   }

   private void setAnimationProgress(float var1) {
      if(this.isAlphaUsedForScale()) {
         this.setColorViewAlpha((int)(255.0F * var1));
      } else {
         ViewCompat.setScaleX(this.mCircleView, var1);
         ViewCompat.setScaleY(this.mCircleView, var1);
      }
   }

   private void setColorViewAlpha(int var1) {
      this.mCircleView.getBackground().setAlpha(var1);
      this.mProgress.setAlpha(var1);
   }

   private void setRefreshing(boolean var1, boolean var2) {
      if(this.mRefreshing != var1) {
         this.mNotify = var2;
         this.ensureTarget();
         this.mRefreshing = var1;
         if(!this.mRefreshing) {
            this.startScaleDownAnimation(this.mRefreshListener);
            return;
         }

         this.animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
      }

   }

   private void setTargetOffsetTopAndBottom(int var1, boolean var2) {
      this.mCircleView.bringToFront();
      this.mCircleView.offsetTopAndBottom(var1);
      this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
      if(var2 && VERSION.SDK_INT < 11) {
         this.invalidate();
      }

   }

   private Animation startAlphaAnimation(final int var1, final int var2) {
      if(this.mScale && this.isAlphaUsedForScale()) {
         return null;
      } else {
         Animation var3 = new Animation() {
            public void applyTransformation(float var1x, Transformation var2x) {
               SwipeRefreshLayout.this.mProgress.setAlpha((int)((float)var1 + (float)(var2 - var1) * var1x));
            }
         };
         var3.setDuration(300L);
         this.mCircleView.setAnimationListener((AnimationListener)null);
         this.mCircleView.clearAnimation();
         this.mCircleView.startAnimation(var3);
         return var3;
      }
   }

   private void startProgressAlphaMaxAnimation() {
      this.mAlphaMaxAnimation = this.startAlphaAnimation(this.mProgress.getAlpha(), 255);
   }

   private void startProgressAlphaStartAnimation() {
      this.mAlphaStartAnimation = this.startAlphaAnimation(this.mProgress.getAlpha(), 76);
   }

   private void startScaleDownAnimation(AnimationListener var1) {
      this.mScaleDownAnimation = new Animation() {
         public void applyTransformation(float var1, Transformation var2) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0F - var1);
         }
      };
      this.mScaleDownAnimation.setDuration(150L);
      this.mCircleView.setAnimationListener(var1);
      this.mCircleView.clearAnimation();
      this.mCircleView.startAnimation(this.mScaleDownAnimation);
   }

   private void startScaleDownReturnToStartAnimation(int var1, AnimationListener var2) {
      this.mFrom = var1;
      if(this.isAlphaUsedForScale()) {
         this.mStartingScale = (float)this.mProgress.getAlpha();
      } else {
         this.mStartingScale = ViewCompat.getScaleX(this.mCircleView);
      }

      this.mScaleDownToStartAnimation = new Animation() {
         public void applyTransformation(float var1, Transformation var2) {
            float var3 = SwipeRefreshLayout.this.mStartingScale;
            float var4 = -SwipeRefreshLayout.this.mStartingScale;
            SwipeRefreshLayout.this.setAnimationProgress(var3 + var4 * var1);
            SwipeRefreshLayout.this.moveToStart(var1);
         }
      };
      this.mScaleDownToStartAnimation.setDuration(150L);
      if(var2 != null) {
         this.mCircleView.setAnimationListener(var2);
      }

      this.mCircleView.clearAnimation();
      this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
   }

   private void startScaleUpAnimation(AnimationListener var1) {
      this.mCircleView.setVisibility(0);
      if(VERSION.SDK_INT >= 11) {
         this.mProgress.setAlpha(255);
      }

      this.mScaleAnimation = new Animation() {
         public void applyTransformation(float var1, Transformation var2) {
            SwipeRefreshLayout.this.setAnimationProgress(var1);
         }
      };
      this.mScaleAnimation.setDuration((long)this.mMediumAnimationDuration);
      if(var1 != null) {
         this.mCircleView.setAnimationListener(var1);
      }

      this.mCircleView.clearAnimation();
      this.mCircleView.startAnimation(this.mScaleAnimation);
   }

   public boolean canChildScrollUp() {
      boolean var1 = false;
      if(VERSION.SDK_INT >= 14) {
         return ViewCompat.canScrollVertically(this.mTarget, -1);
      } else if(this.mTarget instanceof AbsListView) {
         AbsListView var2 = (AbsListView)this.mTarget;
         return var2.getChildCount() > 0 && (var2.getFirstVisiblePosition() > 0 || var2.getChildAt(0).getTop() < var2.getPaddingTop());
      } else {
         if(ViewCompat.canScrollVertically(this.mTarget, -1) || this.mTarget.getScrollY() > 0) {
            var1 = true;
         }

         return var1;
      }
   }

   protected int getChildDrawingOrder(int var1, int var2) {
      if(this.mCircleViewIndex >= 0) {
         if(var2 == var1 - 1) {
            return this.mCircleViewIndex;
         }

         if(var2 >= this.mCircleViewIndex) {
            return var2 + 1;
         }
      }

      return var2;
   }

   public int getProgressCircleDiameter() {
      return this.mCircleView != null?this.mCircleView.getMeasuredHeight():0;
   }

   public boolean isRefreshing() {
      return this.mRefreshing;
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      this.ensureTarget();
      int var3 = MotionEventCompat.getActionMasked(var1);
      if(this.mReturningToStart && var3 == 0) {
         this.mReturningToStart = false;
      }

      if(this.isEnabled() && !this.mReturningToStart && !this.canChildScrollUp() && !this.mRefreshing) {
         float var2;
         switch(var3) {
         case 0:
            this.setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop(), true);
            this.mActivePointerId = MotionEventCompat.getPointerId(var1, 0);
            this.mIsBeingDragged = false;
            var2 = this.getMotionEventY(var1, this.mActivePointerId);
            if(var2 == -1.0F) {
               return false;
            }

            this.mInitialDownY = var2;
            break;
         case 1:
         case 3:
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            break;
         case 2:
            if(this.mActivePointerId == -1) {
               Log.e(LOG_TAG, "Got ACTION_MOVE event but don\'t have an active pointer id.");
               return false;
            }

            var2 = this.getMotionEventY(var1, this.mActivePointerId);
            if(var2 == -1.0F) {
               return false;
            }

            if(var2 - this.mInitialDownY > (float)this.mTouchSlop && !this.mIsBeingDragged) {
               this.mInitialMotionY = this.mInitialDownY + (float)this.mTouchSlop;
               this.mIsBeingDragged = true;
               this.mProgress.setAlpha(76);
            }
         case 4:
         case 5:
         default:
            break;
         case 6:
            this.onSecondaryPointerUp(var1);
         }

         return this.mIsBeingDragged;
      } else {
         return false;
      }
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      var2 = this.getMeasuredWidth();
      var3 = this.getMeasuredHeight();
      if(this.getChildCount() != 0) {
         if(this.mTarget == null) {
            this.ensureTarget();
         }

         if(this.mTarget != null) {
            View var6 = this.mTarget;
            var4 = this.getPaddingLeft();
            var5 = this.getPaddingTop();
            var6.layout(var4, var5, var4 + (var2 - this.getPaddingLeft() - this.getPaddingRight()), var5 + (var3 - this.getPaddingTop() - this.getPaddingBottom()));
            var3 = this.mCircleView.getMeasuredWidth();
            var4 = this.mCircleView.getMeasuredHeight();
            this.mCircleView.layout(var2 / 2 - var3 / 2, this.mCurrentTargetOffsetTop, var2 / 2 + var3 / 2, this.mCurrentTargetOffsetTop + var4);
            return;
         }
      }

   }

   public void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      if(this.mTarget == null) {
         this.ensureTarget();
      }

      if(this.mTarget != null) {
         this.mTarget.measure(MeasureSpec.makeMeasureSpec(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), 1073741824));
         this.mCircleView.measure(MeasureSpec.makeMeasureSpec(this.mCircleWidth, 1073741824), MeasureSpec.makeMeasureSpec(this.mCircleHeight, 1073741824));
         if(!this.mUsingCustomStart && !this.mOriginalOffsetCalculated) {
            this.mOriginalOffsetCalculated = true;
            var1 = -this.mCircleView.getMeasuredHeight();
            this.mOriginalOffsetTop = var1;
            this.mCurrentTargetOffsetTop = var1;
         }

         this.mCircleViewIndex = -1;

         for(var1 = 0; var1 < this.getChildCount(); ++var1) {
            if(this.getChildAt(var1) == this.mCircleView) {
               this.mCircleViewIndex = var1;
               return;
            }
         }
      }

   }

   public boolean onTouchEvent(MotionEvent var1) {
      int var8 = MotionEventCompat.getActionMasked(var1);
      if(this.mReturningToStart && var8 == 0) {
         this.mReturningToStart = false;
      }

      if(this.isEnabled() && !this.mReturningToStart && !this.canChildScrollUp()) {
         float var2;
         float var3;
         switch(var8) {
         case 0:
            this.mActivePointerId = MotionEventCompat.getPointerId(var1, 0);
            this.mIsBeingDragged = false;
            break;
         case 1:
         case 3:
            if(this.mActivePointerId == -1) {
               if(var8 == 1) {
                  Log.e(LOG_TAG, "Got ACTION_UP event but don\'t have an active pointer id.");
               }

               return false;
            }

            var2 = MotionEventCompat.getY(var1, MotionEventCompat.findPointerIndex(var1, this.mActivePointerId));
            var3 = this.mInitialMotionY;
            this.mIsBeingDragged = false;
            if((var2 - var3) * 0.5F > this.mTotalDragDistance) {
               this.setRefreshing(true, true);
            } else {
               this.mRefreshing = false;
               this.mProgress.setStartEndTrim(0.0F, 0.0F);
               AnimationListener var10 = null;
               if(!this.mScale) {
                  var10 = new AnimationListener() {
                     public void onAnimationEnd(Animation var1) {
                        if(!SwipeRefreshLayout.this.mScale) {
                           SwipeRefreshLayout.this.startScaleDownAnimation((AnimationListener)null);
                        }

                     }

                     public void onAnimationRepeat(Animation var1) {
                     }

                     public void onAnimationStart(Animation var1) {
                     }
                  };
               }

               this.animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, var10);
               this.mProgress.showArrow(false);
            }

            this.mActivePointerId = -1;
            return false;
         case 2:
            var8 = MotionEventCompat.findPointerIndex(var1, this.mActivePointerId);
            if(var8 < 0) {
               Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
               return false;
            }

            var3 = (MotionEventCompat.getY(var1, var8) - this.mInitialMotionY) * 0.5F;
            if(this.mIsBeingDragged) {
               this.mProgress.showArrow(true);
               var2 = var3 / this.mTotalDragDistance;
               if(var2 < 0.0F) {
                  return false;
               }

               float var4 = Math.min(1.0F, Math.abs(var2));
               float var5 = (float)Math.max((double)var4 - 0.4D, 0.0D) * 5.0F / 3.0F;
               float var6 = Math.abs(var3);
               float var7 = this.mTotalDragDistance;
               if(this.mUsingCustomStart) {
                  var2 = this.mSpinnerFinalOffset - (float)this.mOriginalOffsetTop;
               } else {
                  var2 = this.mSpinnerFinalOffset;
               }

               var6 = Math.max(0.0F, Math.min(var6 - var7, 2.0F * var2) / var2);
               var6 = (float)((double)(var6 / 4.0F) - Math.pow((double)(var6 / 4.0F), 2.0D)) * 2.0F;
               var8 = this.mOriginalOffsetTop;
               int var9 = (int)(var2 * var4 + var2 * var6 * 2.0F);
               if(this.mCircleView.getVisibility() != 0) {
                  this.mCircleView.setVisibility(0);
               }

               if(!this.mScale) {
                  ViewCompat.setScaleX(this.mCircleView, 1.0F);
                  ViewCompat.setScaleY(this.mCircleView, 1.0F);
               }

               if(var3 < this.mTotalDragDistance) {
                  if(this.mScale) {
                     this.setAnimationProgress(var3 / this.mTotalDragDistance);
                  }

                  if(this.mProgress.getAlpha() > 76 && !this.isAnimationRunning(this.mAlphaStartAnimation)) {
                     this.startProgressAlphaStartAnimation();
                  }

                  this.mProgress.setStartEndTrim(0.0F, Math.min(0.8F, var5 * 0.8F));
                  this.mProgress.setArrowScale(Math.min(1.0F, var5));
               } else if(this.mProgress.getAlpha() < 255 && !this.isAnimationRunning(this.mAlphaMaxAnimation)) {
                  this.startProgressAlphaMaxAnimation();
               }

               this.mProgress.setProgressRotation((-0.25F + 0.4F * var5 + 2.0F * var6) * 0.5F);
               this.setTargetOffsetTopAndBottom(var8 + var9 - this.mCurrentTargetOffsetTop, true);
            }
         case 4:
         default:
            break;
         case 5:
            this.mActivePointerId = MotionEventCompat.getPointerId(var1, MotionEventCompat.getActionIndex(var1));
            break;
         case 6:
            this.onSecondaryPointerUp(var1);
         }

         return true;
      } else {
         return false;
      }
   }

   public void requestDisallowInterceptTouchEvent(boolean var1) {
   }

   @Deprecated
   public void setColorScheme(int... var1) {
      this.setColorSchemeResources(var1);
   }

   public void setColorSchemeColors(int... var1) {
      this.ensureTarget();
      this.mProgress.setColorSchemeColors(var1);
   }

   public void setColorSchemeResources(int... var1) {
      Resources var3 = this.getResources();
      int[] var4 = new int[var1.length];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         var4[var2] = var3.getColor(var1[var2]);
      }

      this.setColorSchemeColors(var4);
   }

   public void setDistanceToTriggerSync(int var1) {
      this.mTotalDragDistance = (float)var1;
   }

   public void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener var1) {
      this.mListener = var1;
   }

   @Deprecated
   public void setProgressBackgroundColor(int var1) {
      this.setProgressBackgroundColorSchemeResource(var1);
   }

   public void setProgressBackgroundColorSchemeColor(int var1) {
      this.mCircleView.setBackgroundColor(var1);
      this.mProgress.setBackgroundColor(var1);
   }

   public void setProgressBackgroundColorSchemeResource(int var1) {
      this.setProgressBackgroundColorSchemeColor(this.getResources().getColor(var1));
   }

   public void setProgressViewEndTarget(boolean var1, int var2) {
      this.mSpinnerFinalOffset = (float)var2;
      this.mScale = var1;
      this.mCircleView.invalidate();
   }

   public void setProgressViewOffset(boolean var1, int var2, int var3) {
      this.mScale = var1;
      this.mCircleView.setVisibility(8);
      this.mCurrentTargetOffsetTop = var2;
      this.mOriginalOffsetTop = var2;
      this.mSpinnerFinalOffset = (float)var3;
      this.mUsingCustomStart = true;
      this.mCircleView.invalidate();
   }

   public void setRefreshing(boolean var1) {
      if(var1 && this.mRefreshing != var1) {
         this.mRefreshing = var1;
         int var2;
         if(!this.mUsingCustomStart) {
            var2 = (int)(this.mSpinnerFinalOffset + (float)this.mOriginalOffsetTop);
         } else {
            var2 = (int)this.mSpinnerFinalOffset;
         }

         this.setTargetOffsetTopAndBottom(var2 - this.mCurrentTargetOffsetTop, true);
         this.mNotify = false;
         this.startScaleUpAnimation(this.mRefreshListener);
      } else {
         this.setRefreshing(var1, false);
      }
   }

   public void setSize(int var1) {
      if(var1 == 0 || var1 == 1) {
         DisplayMetrics var3 = this.getResources().getDisplayMetrics();
         int var2;
         if(var1 == 0) {
            var2 = (int)(56.0F * var3.density);
            this.mCircleWidth = var2;
            this.mCircleHeight = var2;
         } else {
            var2 = (int)(40.0F * var3.density);
            this.mCircleWidth = var2;
            this.mCircleHeight = var2;
         }

         this.mCircleView.setImageDrawable((Drawable)null);
         this.mProgress.updateSizes(var1);
         this.mCircleView.setImageDrawable(this.mProgress);
      }
   }

   public interface OnRefreshListener {
      void onRefresh();
   }
}
