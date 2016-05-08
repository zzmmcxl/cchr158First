package android.support.design.widget;

import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout$Behavior;
import android.support.design.widget.SwipeDismissBehavior$1;
import android.support.design.widget.SwipeDismissBehavior$OnDismissListener;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper$Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout$Behavior<V> {
   private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5F;
   private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0F;
   private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5F;
   public static final int STATE_DRAGGING = 1;
   public static final int STATE_IDLE = 0;
   public static final int STATE_SETTLING = 2;
   public static final int SWIPE_DIRECTION_ANY = 2;
   public static final int SWIPE_DIRECTION_END_TO_START = 1;
   public static final int SWIPE_DIRECTION_START_TO_END = 0;
   private float mAlphaEndSwipeDistance = 0.5F;
   private float mAlphaStartSwipeDistance = 0.0F;
   private final ViewDragHelper$Callback mDragCallback = new SwipeDismissBehavior$1(this);
   private float mDragDismissThreshold = 0.5F;
   private boolean mIgnoreEvents;
   private SwipeDismissBehavior$OnDismissListener mListener;
   private float mSensitivity = 0.0F;
   private boolean mSensitivitySet;
   private int mSwipeDirection = 2;
   private ViewDragHelper mViewDragHelper;

   private static float clamp(float var0, float var1, float var2) {
      return Math.min(Math.max(var0, var1), var2);
   }

   private static int clamp(int var0, int var1, int var2) {
      return Math.min(Math.max(var0, var1), var2);
   }

   private void ensureViewDragHelper(ViewGroup var1) {
      if(this.mViewDragHelper == null) {
         ViewDragHelper var2;
         if(this.mSensitivitySet) {
            var2 = ViewDragHelper.create(var1, this.mSensitivity, this.mDragCallback);
         } else {
            var2 = ViewDragHelper.create(var1, this.mDragCallback);
         }

         this.mViewDragHelper = var2;
      }

   }

   static float fraction(float var0, float var1, float var2) {
      return (var2 - var0) / (var1 - var0);
   }

   public boolean canSwipeDismissView(@NonNull View var1) {
      return true;
   }

   public int getDragState() {
      return this.mViewDragHelper != null?this.mViewDragHelper.getViewDragState():0;
   }

   public boolean onInterceptTouchEvent(CoordinatorLayout var1, V var2, MotionEvent var3) {
      switch(MotionEventCompat.getActionMasked(var3)) {
      case 1:
      case 3:
         if(this.mIgnoreEvents) {
            this.mIgnoreEvents = false;
            return false;
         }
         break;
      case 2:
      default:
         boolean var4;
         if(!var1.isPointInChildBounds(var2, (int)var3.getX(), (int)var3.getY())) {
            var4 = true;
         } else {
            var4 = false;
         }

         this.mIgnoreEvents = var4;
      }

      if(this.mIgnoreEvents) {
         return false;
      } else {
         this.ensureViewDragHelper(var1);
         return this.mViewDragHelper.shouldInterceptTouchEvent(var3);
      }
   }

   public boolean onTouchEvent(CoordinatorLayout var1, V var2, MotionEvent var3) {
      if(this.mViewDragHelper != null) {
         this.mViewDragHelper.processTouchEvent(var3);
         return true;
      } else {
         return false;
      }
   }

   public void setDragDismissDistance(float var1) {
      this.mDragDismissThreshold = clamp(0.0F, var1, 1.0F);
   }

   public void setEndAlphaSwipeDistance(float var1) {
      this.mAlphaEndSwipeDistance = clamp(0.0F, var1, 1.0F);
   }

   public void setListener(SwipeDismissBehavior$OnDismissListener var1) {
      this.mListener = var1;
   }

   public void setSensitivity(float var1) {
      this.mSensitivity = var1;
      this.mSensitivitySet = true;
   }

   public void setStartAlphaSwipeDistance(float var1) {
      this.mAlphaStartSwipeDistance = clamp(0.0F, var1, 1.0F);
   }

   public void setSwipeDirection(int var1) {
      this.mSwipeDirection = var1;
   }
}
