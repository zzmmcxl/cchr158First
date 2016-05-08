package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow$1;
import android.support.v7.widget.ListPopupWindow$DropDownListView;
import android.support.v7.widget.ListPopupWindow$ForwardingListener$DisallowIntercept;
import android.support.v7.widget.ListPopupWindow$ForwardingListener$TriggerLongPress;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.View.OnTouchListener;

public abstract class ListPopupWindow$ForwardingListener implements OnTouchListener {
   private int mActivePointerId;
   private Runnable mDisallowIntercept;
   private boolean mForwarding;
   private final int mLongPressTimeout;
   private final float mScaledTouchSlop;
   private final View mSrc;
   private final int mTapTimeout;
   private final int[] mTmpLocation = new int[2];
   private Runnable mTriggerLongPress;
   private boolean mWasLongPress;

   public ListPopupWindow$ForwardingListener(View var1) {
      this.mSrc = var1;
      this.mScaledTouchSlop = (float)ViewConfiguration.get(var1.getContext()).getScaledTouchSlop();
      this.mTapTimeout = ViewConfiguration.getTapTimeout();
      this.mLongPressTimeout = (this.mTapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
   }

   private void clearCallbacks() {
      if(this.mTriggerLongPress != null) {
         this.mSrc.removeCallbacks(this.mTriggerLongPress);
      }

      if(this.mDisallowIntercept != null) {
         this.mSrc.removeCallbacks(this.mDisallowIntercept);
      }

   }

   private void onLongPress() {
      this.clearCallbacks();
      View var3 = this.mSrc;
      if(var3.isEnabled() && !var3.isLongClickable() && this.onForwardingStarted()) {
         var3.getParent().requestDisallowInterceptTouchEvent(true);
         long var1 = SystemClock.uptimeMillis();
         MotionEvent var4 = MotionEvent.obtain(var1, var1, 3, 0.0F, 0.0F, 0);
         var3.onTouchEvent(var4);
         var4.recycle();
         this.mForwarding = true;
         this.mWasLongPress = true;
      }
   }

   private boolean onTouchForwarded(MotionEvent var1) {
      boolean var3 = true;
      View var5 = this.mSrc;
      ListPopupWindow var6 = this.getPopup();
      if(var6 != null && var6.isShowing()) {
         ListPopupWindow$DropDownListView var9 = ListPopupWindow.access$600(var6);
         if(var9 != null && var9.isShown()) {
            MotionEvent var7 = MotionEvent.obtainNoHistory(var1);
            this.toGlobalMotionEvent(var5, var7);
            this.toLocalMotionEvent(var9, var7);
            boolean var4 = var9.onForwardedEvent(var7, this.mActivePointerId);
            var7.recycle();
            int var2 = MotionEventCompat.getActionMasked(var1);
            boolean var8;
            if(var2 != 1 && var2 != 3) {
               var8 = true;
            } else {
               var8 = false;
            }

            if(!var4 || !var8) {
               var3 = false;
            }

            return var3;
         }
      }

      return false;
   }

   private boolean onTouchObserved(MotionEvent var1) {
      View var3 = this.mSrc;
      if(var3.isEnabled()) {
         switch(MotionEventCompat.getActionMasked(var1)) {
         case 0:
            this.mActivePointerId = var1.getPointerId(0);
            this.mWasLongPress = false;
            if(this.mDisallowIntercept == null) {
               this.mDisallowIntercept = new ListPopupWindow$ForwardingListener$DisallowIntercept(this, (ListPopupWindow$1)null);
            }

            var3.postDelayed(this.mDisallowIntercept, (long)this.mTapTimeout);
            if(this.mTriggerLongPress == null) {
               this.mTriggerLongPress = new ListPopupWindow$ForwardingListener$TriggerLongPress(this, (ListPopupWindow$1)null);
            }

            var3.postDelayed(this.mTriggerLongPress, (long)this.mLongPressTimeout);
            return false;
         case 1:
         case 3:
            this.clearCallbacks();
            return false;
         case 2:
            int var2 = var1.findPointerIndex(this.mActivePointerId);
            if(var2 >= 0 && !pointInView(var3, var1.getX(var2), var1.getY(var2), this.mScaledTouchSlop)) {
               this.clearCallbacks();
               var3.getParent().requestDisallowInterceptTouchEvent(true);
               return true;
            }
            break;
         default:
            return false;
         }
      }

      return false;
   }

   private static boolean pointInView(View var0, float var1, float var2, float var3) {
      return var1 >= -var3 && var2 >= -var3 && var1 < (float)(var0.getRight() - var0.getLeft()) + var3 && var2 < (float)(var0.getBottom() - var0.getTop()) + var3;
   }

   private boolean toGlobalMotionEvent(View var1, MotionEvent var2) {
      int[] var3 = this.mTmpLocation;
      var1.getLocationOnScreen(var3);
      var2.offsetLocation((float)var3[0], (float)var3[1]);
      return true;
   }

   private boolean toLocalMotionEvent(View var1, MotionEvent var2) {
      int[] var3 = this.mTmpLocation;
      var1.getLocationOnScreen(var3);
      var2.offsetLocation((float)(-var3[0]), (float)(-var3[1]));
      return true;
   }

   public abstract ListPopupWindow getPopup();

   protected boolean onForwardingStarted() {
      ListPopupWindow var1 = this.getPopup();
      if(var1 != null && !var1.isShowing()) {
         var1.show();
      }

      return true;
   }

   protected boolean onForwardingStopped() {
      ListPopupWindow var1 = this.getPopup();
      if(var1 != null && var1.isShowing()) {
         var1.dismiss();
      }

      return true;
   }

   public boolean onTouch(View var1, MotionEvent var2) {
      boolean var5 = false;
      boolean var6 = this.mForwarding;
      boolean var3;
      if(var6) {
         if(this.mWasLongPress) {
            var3 = this.onTouchForwarded(var2);
         } else if(!this.onTouchForwarded(var2) && this.onForwardingStopped()) {
            var3 = false;
         } else {
            var3 = true;
         }
      } else {
         boolean var4;
         if(this.onTouchObserved(var2) && this.onForwardingStarted()) {
            var4 = true;
         } else {
            var4 = false;
         }

         var3 = var4;
         if(var4) {
            long var7 = SystemClock.uptimeMillis();
            MotionEvent var9 = MotionEvent.obtain(var7, var7, 3, 0.0F, 0.0F, 0);
            this.mSrc.onTouchEvent(var9);
            var9.recycle();
            var3 = var4;
         }
      }

      this.mForwarding = var3;
      if(!var3) {
         var3 = var5;
         if(!var6) {
            return var3;
         }
      }

      var3 = true;
      return var3;
   }
}
