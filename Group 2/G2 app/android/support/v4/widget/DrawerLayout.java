package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.DrawerLayoutCompatApi21;
import android.support.v4.widget.DrawerLayoutImpl;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class DrawerLayout extends ViewGroup implements DrawerLayoutImpl {
   private static final boolean ALLOW_EDGE_LOCK = false;
   private static final boolean CAN_HIDE_DESCENDANTS;
   private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
   private static final int DEFAULT_SCRIM_COLOR = -1728053248;
   static final DrawerLayout.DrawerLayoutCompatImpl IMPL;
   private static final int[] LAYOUT_ATTRS;
   public static final int LOCK_MODE_LOCKED_CLOSED = 1;
   public static final int LOCK_MODE_LOCKED_OPEN = 2;
   public static final int LOCK_MODE_UNLOCKED = 0;
   private static final int MIN_DRAWER_MARGIN = 64;
   private static final int MIN_FLING_VELOCITY = 400;
   private static final int PEEK_DELAY = 160;
   public static final int STATE_DRAGGING = 1;
   public static final int STATE_IDLE = 0;
   public static final int STATE_SETTLING = 2;
   private static final String TAG = "DrawerLayout";
   private static final float TOUCH_SLOP_SENSITIVITY = 1.0F;
   private final DrawerLayout.ChildAccessibilityDelegate mChildAccessibilityDelegate;
   private boolean mChildrenCanceledTouch;
   private boolean mDisallowInterceptRequested;
   private boolean mDrawStatusBarBackground;
   private int mDrawerState;
   private boolean mFirstLayout;
   private boolean mInLayout;
   private float mInitialMotionX;
   private float mInitialMotionY;
   private Object mLastInsets;
   private final DrawerLayout.ViewDragCallback mLeftCallback;
   private final ViewDragHelper mLeftDragger;
   private DrawerLayout.DrawerListener mListener;
   private int mLockModeLeft;
   private int mLockModeRight;
   private int mMinDrawerMargin;
   private final DrawerLayout.ViewDragCallback mRightCallback;
   private final ViewDragHelper mRightDragger;
   private int mScrimColor;
   private float mScrimOpacity;
   private Paint mScrimPaint;
   private Drawable mShadowLeft;
   private Drawable mShadowRight;
   private Drawable mStatusBarBackground;
   private CharSequence mTitleLeft;
   private CharSequence mTitleRight;

   static {
      boolean var0 = true;
      LAYOUT_ATTRS = new int[]{16842931};
      if(VERSION.SDK_INT < 19) {
         var0 = false;
      }

      CAN_HIDE_DESCENDANTS = var0;
      if(VERSION.SDK_INT >= 21) {
         IMPL = new DrawerLayout.DrawerLayoutCompatImplApi21();
      } else {
         IMPL = new DrawerLayout.DrawerLayoutCompatImplBase();
      }
   }

   public DrawerLayout(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public DrawerLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public DrawerLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mChildAccessibilityDelegate = new DrawerLayout.ChildAccessibilityDelegate();
      this.mScrimColor = -1728053248;
      this.mScrimPaint = new Paint();
      this.mFirstLayout = true;
      this.setDescendantFocusability(262144);
      float var4 = this.getResources().getDisplayMetrics().density;
      this.mMinDrawerMargin = (int)(64.0F * var4 + 0.5F);
      var4 = 400.0F * var4;
      this.mLeftCallback = new DrawerLayout.ViewDragCallback(3);
      this.mRightCallback = new DrawerLayout.ViewDragCallback(5);
      this.mLeftDragger = ViewDragHelper.create(this, 1.0F, this.mLeftCallback);
      this.mLeftDragger.setEdgeTrackingEnabled(1);
      this.mLeftDragger.setMinVelocity(var4);
      this.mLeftCallback.setDragger(this.mLeftDragger);
      this.mRightDragger = ViewDragHelper.create(this, 1.0F, this.mRightCallback);
      this.mRightDragger.setEdgeTrackingEnabled(2);
      this.mRightDragger.setMinVelocity(var4);
      this.mRightCallback.setDragger(this.mRightDragger);
      this.setFocusableInTouchMode(true);
      ViewCompat.setImportantForAccessibility(this, 1);
      ViewCompat.setAccessibilityDelegate(this, new DrawerLayout.AccessibilityDelegate());
      ViewGroupCompat.setMotionEventSplittingEnabled(this, false);
      if(ViewCompat.getFitsSystemWindows(this)) {
         IMPL.configureApplyInsets(this);
         this.mStatusBarBackground = IMPL.getDefaultStatusBarBackground(var1);
      }

   }

   private View findVisibleDrawer() {
      int var2 = this.getChildCount();

      for(int var1 = 0; var1 < var2; ++var1) {
         View var3 = this.getChildAt(var1);
         if(this.isDrawerView(var3) && this.isDrawerVisible(var3)) {
            return var3;
         }
      }

      return null;
   }

   static String gravityToString(int var0) {
      return (var0 & 3) == 3?"LEFT":((var0 & 5) == 5?"RIGHT":Integer.toHexString(var0));
   }

   private static boolean hasOpaqueBackground(View var0) {
      boolean var2 = false;
      Drawable var3 = var0.getBackground();
      boolean var1 = var2;
      if(var3 != null) {
         var1 = var2;
         if(var3.getOpacity() == -1) {
            var1 = true;
         }
      }

      return var1;
   }

   private boolean hasPeekingDrawer() {
      int var2 = this.getChildCount();

      for(int var1 = 0; var1 < var2; ++var1) {
         if(((DrawerLayout.LayoutParams)this.getChildAt(var1).getLayoutParams()).isPeeking) {
            return true;
         }
      }

      return false;
   }

   private boolean hasVisibleDrawer() {
      return this.findVisibleDrawer() != null;
   }

   private static boolean includeChildForAccessibility(View var0) {
      return ViewCompat.getImportantForAccessibility(var0) != 4 && ViewCompat.getImportantForAccessibility(var0) != 2;
   }

   private void updateChildrenImportantForAccessibility(View var1, boolean var2) {
      int var4 = this.getChildCount();

      for(int var3 = 0; var3 < var4; ++var3) {
         View var5 = this.getChildAt(var3);
         if((var2 || this.isDrawerView(var5)) && (!var2 || var5 != var1)) {
            ViewCompat.setImportantForAccessibility(var5, 4);
         } else {
            ViewCompat.setImportantForAccessibility(var5, 1);
         }
      }

   }

   public void addView(View var1, int var2, android.view.ViewGroup.LayoutParams var3) {
      super.addView(var1, var2, var3);
      if(this.findOpenDrawer() == null && !this.isDrawerView(var1)) {
         ViewCompat.setImportantForAccessibility(var1, 1);
      } else {
         ViewCompat.setImportantForAccessibility(var1, 4);
      }

      if(!CAN_HIDE_DESCENDANTS) {
         ViewCompat.setAccessibilityDelegate(var1, this.mChildAccessibilityDelegate);
      }

   }

   void cancelChildViewTouch() {
      if(!this.mChildrenCanceledTouch) {
         long var3 = SystemClock.uptimeMillis();
         MotionEvent var5 = MotionEvent.obtain(var3, var3, 3, 0.0F, 0.0F, 0);
         int var2 = this.getChildCount();

         for(int var1 = 0; var1 < var2; ++var1) {
            this.getChildAt(var1).dispatchTouchEvent(var5);
         }

         var5.recycle();
         this.mChildrenCanceledTouch = true;
      }

   }

   boolean checkDrawerViewAbsoluteGravity(View var1, int var2) {
      return (this.getDrawerViewAbsoluteGravity(var1) & var2) == var2;
   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 instanceof DrawerLayout.LayoutParams && super.checkLayoutParams(var1);
   }

   public void closeDrawer(int var1) {
      View var2 = this.findDrawerWithGravity(var1);
      if(var2 == null) {
         throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(var1));
      } else {
         this.closeDrawer(var2);
      }
   }

   public void closeDrawer(View var1) {
      if(!this.isDrawerView(var1)) {
         throw new IllegalArgumentException("View " + var1 + " is not a sliding drawer");
      } else {
         if(this.mFirstLayout) {
            DrawerLayout.LayoutParams var2 = (DrawerLayout.LayoutParams)var1.getLayoutParams();
            var2.onScreen = 0.0F;
            var2.knownOpen = false;
         } else if(this.checkDrawerViewAbsoluteGravity(var1, 3)) {
            this.mLeftDragger.smoothSlideViewTo(var1, -var1.getWidth(), var1.getTop());
         } else {
            this.mRightDragger.smoothSlideViewTo(var1, this.getWidth(), var1.getTop());
         }

         this.invalidate();
      }
   }

   public void closeDrawers() {
      this.closeDrawers(false);
   }

   void closeDrawers(boolean var1) {
      boolean var2 = false;
      int var5 = this.getChildCount();

      boolean var4;
      for(int var3 = 0; var3 < var5; var2 = var4) {
         View var6 = this.getChildAt(var3);
         DrawerLayout.LayoutParams var7 = (DrawerLayout.LayoutParams)var6.getLayoutParams();
         var4 = var2;
         if(this.isDrawerView(var6)) {
            if(var1 && !var7.isPeeking) {
               var4 = var2;
            } else {
               int var8 = var6.getWidth();
               if(this.checkDrawerViewAbsoluteGravity(var6, 3)) {
                  var2 |= this.mLeftDragger.smoothSlideViewTo(var6, -var8, var6.getTop());
               } else {
                  var2 |= this.mRightDragger.smoothSlideViewTo(var6, this.getWidth(), var6.getTop());
               }

               var7.isPeeking = false;
               var4 = var2;
            }
         }

         ++var3;
      }

      this.mLeftCallback.removeCallbacks();
      this.mRightCallback.removeCallbacks();
      if(var2) {
         this.invalidate();
      }

   }

   public void computeScroll() {
      int var3 = this.getChildCount();
      float var1 = 0.0F;

      for(int var2 = 0; var2 < var3; ++var2) {
         var1 = Math.max(var1, ((DrawerLayout.LayoutParams)this.getChildAt(var2).getLayoutParams()).onScreen);
      }

      this.mScrimOpacity = var1;
      if(this.mLeftDragger.continueSettling(true) | this.mRightDragger.continueSettling(true)) {
         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   void dispatchOnDrawerClosed(View var1) {
      DrawerLayout.LayoutParams var2 = (DrawerLayout.LayoutParams)var1.getLayoutParams();
      if(var2.knownOpen) {
         var2.knownOpen = false;
         if(this.mListener != null) {
            this.mListener.onDrawerClosed(var1);
         }

         this.updateChildrenImportantForAccessibility(var1, false);
         if(this.hasWindowFocus()) {
            var1 = this.getRootView();
            if(var1 != null) {
               var1.sendAccessibilityEvent(32);
            }
         }
      }

   }

   void dispatchOnDrawerOpened(View var1) {
      DrawerLayout.LayoutParams var2 = (DrawerLayout.LayoutParams)var1.getLayoutParams();
      if(!var2.knownOpen) {
         var2.knownOpen = true;
         if(this.mListener != null) {
            this.mListener.onDrawerOpened(var1);
         }

         this.updateChildrenImportantForAccessibility(var1, true);
         if(this.hasWindowFocus()) {
            this.sendAccessibilityEvent(32);
         }

         var1.requestFocus();
      }

   }

   void dispatchOnDrawerSlide(View var1, float var2) {
      if(this.mListener != null) {
         this.mListener.onDrawerSlide(var1, var2);
      }

   }

   protected boolean drawChild(Canvas var1, View var2, long var3) {
      int var12 = this.getHeight();
      boolean var15 = this.isContentView(var2);
      int var6 = 0;
      byte var9 = 0;
      int var7 = this.getWidth();
      int var13 = var1.save();
      int var8 = var7;
      int var18;
      if(var15) {
         int var14 = this.getChildCount();
         var8 = 0;

         int var10;
         for(var6 = var9; var8 < var14; var7 = var10) {
            View var17 = this.getChildAt(var8);
            var18 = var6;
            var10 = var7;
            if(var17 != var2) {
               var18 = var6;
               var10 = var7;
               if(var17.getVisibility() == 0) {
                  var18 = var6;
                  var10 = var7;
                  if(hasOpaqueBackground(var17)) {
                     var18 = var6;
                     var10 = var7;
                     if(this.isDrawerView(var17)) {
                        if(var17.getHeight() < var12) {
                           var10 = var7;
                           var18 = var6;
                        } else {
                           int var11;
                           if(this.checkDrawerViewAbsoluteGravity(var17, 3)) {
                              var11 = var17.getRight();
                              var18 = var6;
                              var10 = var7;
                              if(var11 > var6) {
                                 var18 = var11;
                                 var10 = var7;
                              }
                           } else {
                              var11 = var17.getLeft();
                              var18 = var6;
                              var10 = var7;
                              if(var11 < var7) {
                                 var10 = var11;
                                 var18 = var6;
                              }
                           }
                        }
                     }
                  }
               }
            }

            ++var8;
            var6 = var18;
         }

         var1.clipRect(var6, 0, var7, this.getHeight());
         var8 = var7;
      }

      boolean var16 = super.drawChild(var1, var2, var3);
      var1.restoreToCount(var13);
      if(this.mScrimOpacity > 0.0F && var15) {
         var7 = (int)((float)((this.mScrimColor & -16777216) >>> 24) * this.mScrimOpacity);
         var18 = this.mScrimColor;
         this.mScrimPaint.setColor(var7 << 24 | var18 & 16777215);
         var1.drawRect((float)var6, 0.0F, (float)var8, (float)this.getHeight(), this.mScrimPaint);
      } else {
         float var5;
         if(this.mShadowLeft != null && this.checkDrawerViewAbsoluteGravity(var2, 3)) {
            var6 = this.mShadowLeft.getIntrinsicWidth();
            var7 = var2.getRight();
            var8 = this.mLeftDragger.getEdgeSize();
            var5 = Math.max(0.0F, Math.min((float)var7 / (float)var8, 1.0F));
            this.mShadowLeft.setBounds(var7, var2.getTop(), var7 + var6, var2.getBottom());
            this.mShadowLeft.setAlpha((int)(255.0F * var5));
            this.mShadowLeft.draw(var1);
            return var16;
         }

         if(this.mShadowRight != null && this.checkDrawerViewAbsoluteGravity(var2, 5)) {
            var6 = this.mShadowRight.getIntrinsicWidth();
            var7 = var2.getLeft();
            var8 = this.getWidth();
            var18 = this.mRightDragger.getEdgeSize();
            var5 = Math.max(0.0F, Math.min((float)(var8 - var7) / (float)var18, 1.0F));
            this.mShadowRight.setBounds(var7 - var6, var2.getTop(), var7, var2.getBottom());
            this.mShadowRight.setAlpha((int)(255.0F * var5));
            this.mShadowRight.draw(var1);
            return var16;
         }
      }

      return var16;
   }

   View findDrawerWithGravity(int var1) {
      int var2 = GravityCompat.getAbsoluteGravity(var1, ViewCompat.getLayoutDirection(this));
      int var3 = this.getChildCount();

      for(var1 = 0; var1 < var3; ++var1) {
         View var4 = this.getChildAt(var1);
         if((this.getDrawerViewAbsoluteGravity(var4) & 7) == (var2 & 7)) {
            return var4;
         }
      }

      return null;
   }

   View findOpenDrawer() {
      int var2 = this.getChildCount();

      for(int var1 = 0; var1 < var2; ++var1) {
         View var3 = this.getChildAt(var1);
         if(((DrawerLayout.LayoutParams)var3.getLayoutParams()).knownOpen) {
            return var3;
         }
      }

      return null;
   }

   protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
      return new DrawerLayout.LayoutParams(-1, -1);
   }

   public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet var1) {
      return new DrawerLayout.LayoutParams(this.getContext(), var1);
   }

   protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 instanceof DrawerLayout.LayoutParams?new DrawerLayout.LayoutParams((DrawerLayout.LayoutParams)var1):(var1 instanceof MarginLayoutParams?new DrawerLayout.LayoutParams((MarginLayoutParams)var1):new DrawerLayout.LayoutParams(var1));
   }

   public int getDrawerLockMode(int var1) {
      var1 = GravityCompat.getAbsoluteGravity(var1, ViewCompat.getLayoutDirection(this));
      return var1 == 3?this.mLockModeLeft:(var1 == 5?this.mLockModeRight:0);
   }

   public int getDrawerLockMode(View var1) {
      int var2 = this.getDrawerViewAbsoluteGravity(var1);
      return var2 == 3?this.mLockModeLeft:(var2 == 5?this.mLockModeRight:0);
   }

   @Nullable
   public CharSequence getDrawerTitle(int var1) {
      var1 = GravityCompat.getAbsoluteGravity(var1, ViewCompat.getLayoutDirection(this));
      return var1 == 3?this.mTitleLeft:(var1 == 5?this.mTitleRight:null);
   }

   int getDrawerViewAbsoluteGravity(View var1) {
      return GravityCompat.getAbsoluteGravity(((DrawerLayout.LayoutParams)var1.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
   }

   float getDrawerViewOffset(View var1) {
      return ((DrawerLayout.LayoutParams)var1.getLayoutParams()).onScreen;
   }

   public Drawable getStatusBarBackgroundDrawable() {
      return this.mStatusBarBackground;
   }

   boolean isContentView(View var1) {
      return ((DrawerLayout.LayoutParams)var1.getLayoutParams()).gravity == 0;
   }

   public boolean isDrawerOpen(int var1) {
      View var2 = this.findDrawerWithGravity(var1);
      return var2 != null?this.isDrawerOpen(var2):false;
   }

   public boolean isDrawerOpen(View var1) {
      if(!this.isDrawerView(var1)) {
         throw new IllegalArgumentException("View " + var1 + " is not a drawer");
      } else {
         return ((DrawerLayout.LayoutParams)var1.getLayoutParams()).knownOpen;
      }
   }

   boolean isDrawerView(View var1) {
      return (GravityCompat.getAbsoluteGravity(((DrawerLayout.LayoutParams)var1.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(var1)) & 7) != 0;
   }

   public boolean isDrawerVisible(int var1) {
      View var2 = this.findDrawerWithGravity(var1);
      return var2 != null?this.isDrawerVisible(var2):false;
   }

   public boolean isDrawerVisible(View var1) {
      if(!this.isDrawerView(var1)) {
         throw new IllegalArgumentException("View " + var1 + " is not a drawer");
      } else {
         return ((DrawerLayout.LayoutParams)var1.getLayoutParams()).onScreen > 0.0F;
      }
   }

   void moveDrawerToOffset(View var1, float var2) {
      float var3 = this.getDrawerViewOffset(var1);
      int var4 = var1.getWidth();
      int var5 = (int)((float)var4 * var3);
      var4 = (int)((float)var4 * var2) - var5;
      if(!this.checkDrawerViewAbsoluteGravity(var1, 3)) {
         var4 = -var4;
      }

      var1.offsetLeftAndRight(var4);
      this.setDrawerViewOffset(var1, var2);
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.mFirstLayout = true;
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.mFirstLayout = true;
   }

   public void onDraw(Canvas var1) {
      super.onDraw(var1);
      if(this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
         int var2 = IMPL.getTopInset(this.mLastInsets);
         if(var2 > 0) {
            this.mStatusBarBackground.setBounds(0, 0, this.getWidth(), var2);
            this.mStatusBarBackground.draw(var1);
         }
      }

   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      boolean var7 = false;
      int var4 = MotionEventCompat.getActionMasked(var1);
      boolean var8 = this.mLeftDragger.shouldInterceptTouchEvent(var1);
      boolean var9 = this.mRightDragger.shouldInterceptTouchEvent(var1);
      boolean var6 = false;
      boolean var5 = false;
      boolean var11;
      switch(var4) {
      case 0:
         float var2 = var1.getX();
         float var3 = var1.getY();
         this.mInitialMotionX = var2;
         this.mInitialMotionY = var3;
         var11 = var6;
         if(this.mScrimOpacity > 0.0F) {
            View var10 = this.mLeftDragger.findTopChildUnder((int)var2, (int)var3);
            var11 = var6;
            if(var10 != null) {
               var11 = var6;
               if(this.isContentView(var10)) {
                  var11 = true;
               }
            }
         }

         this.mDisallowInterceptRequested = false;
         this.mChildrenCanceledTouch = false;
         break;
      case 1:
      case 3:
         this.closeDrawers(true);
         this.mDisallowInterceptRequested = false;
         this.mChildrenCanceledTouch = false;
         var11 = var5;
         break;
      case 2:
         var11 = var5;
         if(this.mLeftDragger.checkTouchSlop(3)) {
            this.mLeftCallback.removeCallbacks();
            this.mRightCallback.removeCallbacks();
            var11 = var5;
         }
         break;
      default:
         var11 = var5;
      }

      if(var8 | var9 || var11 || this.hasPeekingDrawer() || this.mChildrenCanceledTouch) {
         var7 = true;
      }

      return var7;
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      if(var1 == 4 && this.hasVisibleDrawer()) {
         KeyEventCompat.startTracking(var2);
         return true;
      } else {
         return super.onKeyDown(var1, var2);
      }
   }

   public boolean onKeyUp(int var1, KeyEvent var2) {
      if(var1 == 4) {
         View var3 = this.findVisibleDrawer();
         if(var3 != null && this.getDrawerLockMode(var3) == 0) {
            this.closeDrawers();
         }

         return var3 != null;
      } else {
         return super.onKeyUp(var1, var2);
      }
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      this.mInLayout = true;
      int var10 = var4 - var2;
      int var11 = this.getChildCount();

      for(var4 = 0; var4 < var11; ++var4) {
         View var15 = this.getChildAt(var4);
         if(var15.getVisibility() != 8) {
            DrawerLayout.LayoutParams var16 = (DrawerLayout.LayoutParams)var15.getLayoutParams();
            if(this.isContentView(var15)) {
               var15.layout(var16.leftMargin, var16.topMargin, var16.leftMargin + var15.getMeasuredWidth(), var16.topMargin + var15.getMeasuredHeight());
            } else {
               int var12 = var15.getMeasuredWidth();
               int var13 = var15.getMeasuredHeight();
               float var6;
               int var7;
               if(this.checkDrawerViewAbsoluteGravity(var15, 3)) {
                  var7 = -var12 + (int)((float)var12 * var16.onScreen);
                  var6 = (float)(var12 + var7) / (float)var12;
               } else {
                  var7 = var10 - (int)((float)var12 * var16.onScreen);
                  var6 = (float)(var10 - var7) / (float)var12;
               }

               boolean var8;
               if(var6 != var16.onScreen) {
                  var8 = true;
               } else {
                  var8 = false;
               }

               switch(var16.gravity & 112) {
               case 16:
                  int var14 = var5 - var3;
                  int var9 = (var14 - var13) / 2;
                  if(var9 < var16.topMargin) {
                     var2 = var16.topMargin;
                  } else {
                     var2 = var9;
                     if(var9 + var13 > var14 - var16.bottomMargin) {
                        var2 = var14 - var16.bottomMargin - var13;
                     }
                  }

                  var15.layout(var7, var2, var7 + var12, var2 + var13);
                  break;
               case 80:
                  var2 = var5 - var3;
                  var15.layout(var7, var2 - var16.bottomMargin - var15.getMeasuredHeight(), var7 + var12, var2 - var16.bottomMargin);
                  break;
               default:
                  var15.layout(var7, var16.topMargin, var7 + var12, var16.topMargin + var13);
               }

               if(var8) {
                  this.setDrawerViewOffset(var15, var6);
               }

               byte var17;
               if(var16.onScreen > 0.0F) {
                  var17 = 0;
               } else {
                  var17 = 4;
               }

               if(var15.getVisibility() != var17) {
                  var15.setVisibility(var17);
               }
            }
         }
      }

      this.mInLayout = false;
      this.mFirstLayout = false;
   }

   protected void onMeasure(int var1, int var2) {
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      label67: {
         var8 = MeasureSpec.getMode(var1);
         var7 = MeasureSpec.getMode(var2);
         int var3 = MeasureSpec.getSize(var1);
         var6 = MeasureSpec.getSize(var2);
         if(var8 == 1073741824) {
            var4 = var6;
            var5 = var3;
            if(var7 == 1073741824) {
               break label67;
            }
         }

         if(!this.isInEditMode()) {
            throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
         }

         if(var8 != Integer.MIN_VALUE && var8 == 0) {
            var3 = 300;
         }

         if(var7 == Integer.MIN_VALUE) {
            var5 = var3;
            var4 = var6;
         } else {
            var4 = var6;
            var5 = var3;
            if(var7 == 0) {
               var4 = 300;
               var5 = var3;
            }
         }
      }

      this.setMeasuredDimension(var5, var4);
      boolean var12;
      if(this.mLastInsets != null && ViewCompat.getFitsSystemWindows(this)) {
         var12 = true;
      } else {
         var12 = false;
      }

      var7 = ViewCompat.getLayoutDirection(this);
      var8 = this.getChildCount();

      for(var6 = 0; var6 < var8; ++var6) {
         View var10 = this.getChildAt(var6);
         if(var10.getVisibility() != 8) {
            DrawerLayout.LayoutParams var11 = (DrawerLayout.LayoutParams)var10.getLayoutParams();
            int var9;
            if(var12) {
               var9 = GravityCompat.getAbsoluteGravity(var11.gravity, var7);
               if(ViewCompat.getFitsSystemWindows(var10)) {
                  IMPL.dispatchChildInsets(var10, this.mLastInsets, var9);
               } else {
                  IMPL.applyMarginInsets(var11, this.mLastInsets, var9);
               }
            }

            if(this.isContentView(var10)) {
               var10.measure(MeasureSpec.makeMeasureSpec(var5 - var11.leftMargin - var11.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec(var4 - var11.topMargin - var11.bottomMargin, 1073741824));
            } else {
               if(!this.isDrawerView(var10)) {
                  throw new IllegalStateException("Child " + var10 + " at index " + var6 + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
               }

               var9 = this.getDrawerViewAbsoluteGravity(var10) & 7;
               if((0 & var9) != 0) {
                  throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(var9) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
               }

               var10.measure(getChildMeasureSpec(var1, this.mMinDrawerMargin + var11.leftMargin + var11.rightMargin, var11.width), getChildMeasureSpec(var2, var11.topMargin + var11.bottomMargin, var11.height));
            }
         }
      }

   }

   protected void onRestoreInstanceState(Parcelable var1) {
      DrawerLayout.SavedState var3 = (DrawerLayout.SavedState)var1;
      super.onRestoreInstanceState(var3.getSuperState());
      if(var3.openDrawerGravity != 0) {
         View var2 = this.findDrawerWithGravity(var3.openDrawerGravity);
         if(var2 != null) {
            this.openDrawer(var2);
         }
      }

      this.setDrawerLockMode(var3.lockModeLeft, 3);
      this.setDrawerLockMode(var3.lockModeRight, 5);
   }

   protected Parcelable onSaveInstanceState() {
      DrawerLayout.SavedState var1 = new DrawerLayout.SavedState(super.onSaveInstanceState());
      View var2 = this.findOpenDrawer();
      if(var2 != null) {
         var1.openDrawerGravity = ((DrawerLayout.LayoutParams)var2.getLayoutParams()).gravity;
      }

      var1.lockModeLeft = this.mLockModeLeft;
      var1.lockModeRight = this.mLockModeRight;
      return var1;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      this.mLeftDragger.processTouchEvent(var1);
      this.mRightDragger.processTouchEvent(var1);
      float var2;
      float var3;
      switch(var1.getAction() & 255) {
      case 0:
         var2 = var1.getX();
         var3 = var1.getY();
         this.mInitialMotionX = var2;
         this.mInitialMotionY = var3;
         this.mDisallowInterceptRequested = false;
         this.mChildrenCanceledTouch = false;
         return true;
      case 1:
         var3 = var1.getX();
         var2 = var1.getY();
         boolean var6 = true;
         View var7 = this.mLeftDragger.findTopChildUnder((int)var3, (int)var2);
         boolean var5 = var6;
         if(var7 != null) {
            var5 = var6;
            if(this.isContentView(var7)) {
               var3 -= this.mInitialMotionX;
               var2 -= this.mInitialMotionY;
               int var4 = this.mLeftDragger.getTouchSlop();
               var5 = var6;
               if(var3 * var3 + var2 * var2 < (float)(var4 * var4)) {
                  var7 = this.findOpenDrawer();
                  var5 = var6;
                  if(var7 != null) {
                     if(this.getDrawerLockMode(var7) == 2) {
                        var5 = true;
                     } else {
                        var5 = false;
                     }
                  }
               }
            }
         }

         this.closeDrawers(var5);
         this.mDisallowInterceptRequested = false;
         return true;
      case 2:
      default:
         return true;
      case 3:
         this.closeDrawers(true);
         this.mDisallowInterceptRequested = false;
         this.mChildrenCanceledTouch = false;
         return true;
      }
   }

   public void openDrawer(int var1) {
      View var2 = this.findDrawerWithGravity(var1);
      if(var2 == null) {
         throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(var1));
      } else {
         this.openDrawer(var2);
      }
   }

   public void openDrawer(View var1) {
      if(!this.isDrawerView(var1)) {
         throw new IllegalArgumentException("View " + var1 + " is not a sliding drawer");
      } else {
         if(this.mFirstLayout) {
            DrawerLayout.LayoutParams var2 = (DrawerLayout.LayoutParams)var1.getLayoutParams();
            var2.onScreen = 1.0F;
            var2.knownOpen = true;
            this.updateChildrenImportantForAccessibility(var1, true);
         } else if(this.checkDrawerViewAbsoluteGravity(var1, 3)) {
            this.mLeftDragger.smoothSlideViewTo(var1, 0, var1.getTop());
         } else {
            this.mRightDragger.smoothSlideViewTo(var1, this.getWidth() - var1.getWidth(), var1.getTop());
         }

         this.invalidate();
      }
   }

   public void requestDisallowInterceptTouchEvent(boolean var1) {
      super.requestDisallowInterceptTouchEvent(var1);
      this.mDisallowInterceptRequested = var1;
      if(var1) {
         this.closeDrawers(true);
      }

   }

   public void requestLayout() {
      if(!this.mInLayout) {
         super.requestLayout();
      }

   }

   public void setChildInsets(Object var1, boolean var2) {
      this.mLastInsets = var1;
      this.mDrawStatusBarBackground = var2;
      if(!var2 && this.getBackground() == null) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.setWillNotDraw(var2);
      this.requestLayout();
   }

   public void setDrawerListener(DrawerLayout.DrawerListener var1) {
      this.mListener = var1;
   }

   public void setDrawerLockMode(int var1) {
      this.setDrawerLockMode(var1, 3);
      this.setDrawerLockMode(var1, 5);
   }

   public void setDrawerLockMode(int var1, int var2) {
      var2 = GravityCompat.getAbsoluteGravity(var2, ViewCompat.getLayoutDirection(this));
      if(var2 == 3) {
         this.mLockModeLeft = var1;
      } else if(var2 == 5) {
         this.mLockModeRight = var1;
      }

      if(var1 != 0) {
         ViewDragHelper var3;
         if(var2 == 3) {
            var3 = this.mLeftDragger;
         } else {
            var3 = this.mRightDragger;
         }

         var3.cancel();
      }

      View var4;
      switch(var1) {
      case 1:
         var4 = this.findDrawerWithGravity(var2);
         if(var4 != null) {
            this.closeDrawer(var4);
            return;
         }
         break;
      case 2:
         var4 = this.findDrawerWithGravity(var2);
         if(var4 != null) {
            this.openDrawer(var4);
            return;
         }
      }

   }

   public void setDrawerLockMode(int var1, View var2) {
      if(!this.isDrawerView(var2)) {
         throw new IllegalArgumentException("View " + var2 + " is not a " + "drawer with appropriate layout_gravity");
      } else {
         this.setDrawerLockMode(var1, ((DrawerLayout.LayoutParams)var2.getLayoutParams()).gravity);
      }
   }

   public void setDrawerShadow(@DrawableRes int var1, int var2) {
      this.setDrawerShadow(this.getResources().getDrawable(var1), var2);
   }

   public void setDrawerShadow(Drawable var1, int var2) {
      var2 = GravityCompat.getAbsoluteGravity(var2, ViewCompat.getLayoutDirection(this));
      if((var2 & 3) == 3) {
         this.mShadowLeft = var1;
         this.invalidate();
      }

      if((var2 & 5) == 5) {
         this.mShadowRight = var1;
         this.invalidate();
      }

   }

   public void setDrawerTitle(int var1, CharSequence var2) {
      var1 = GravityCompat.getAbsoluteGravity(var1, ViewCompat.getLayoutDirection(this));
      if(var1 == 3) {
         this.mTitleLeft = var2;
      } else if(var1 == 5) {
         this.mTitleRight = var2;
         return;
      }

   }

   void setDrawerViewOffset(View var1, float var2) {
      DrawerLayout.LayoutParams var3 = (DrawerLayout.LayoutParams)var1.getLayoutParams();
      if(var2 != var3.onScreen) {
         var3.onScreen = var2;
         this.dispatchOnDrawerSlide(var1, var2);
      }
   }

   public void setScrimColor(int var1) {
      this.mScrimColor = var1;
      this.invalidate();
   }

   public void setStatusBarBackground(int var1) {
      Drawable var2;
      if(var1 != 0) {
         var2 = ContextCompat.getDrawable(this.getContext(), var1);
      } else {
         var2 = null;
      }

      this.mStatusBarBackground = var2;
      this.invalidate();
   }

   public void setStatusBarBackground(Drawable var1) {
      this.mStatusBarBackground = var1;
      this.invalidate();
   }

   public void setStatusBarBackgroundColor(int var1) {
      this.mStatusBarBackground = new ColorDrawable(var1);
      this.invalidate();
   }

   void updateDrawerState(int var1, int var2, View var3) {
      var1 = this.mLeftDragger.getViewDragState();
      int var4 = this.mRightDragger.getViewDragState();
      byte var6;
      if(var1 != 1 && var4 != 1) {
         if(var1 != 2 && var4 != 2) {
            var6 = 0;
         } else {
            var6 = 2;
         }
      } else {
         var6 = 1;
      }

      if(var3 != null && var2 == 0) {
         DrawerLayout.LayoutParams var5 = (DrawerLayout.LayoutParams)var3.getLayoutParams();
         if(var5.onScreen == 0.0F) {
            this.dispatchOnDrawerClosed(var3);
         } else if(var5.onScreen == 1.0F) {
            this.dispatchOnDrawerOpened(var3);
         }
      }

      if(var6 != this.mDrawerState) {
         this.mDrawerState = var6;
         if(this.mListener != null) {
            this.mListener.onDrawerStateChanged(var6);
         }
      }

   }

   class AccessibilityDelegate extends AccessibilityDelegateCompat {
      private final Rect mTmpRect = new Rect();

      private void addChildrenForAccessibility(AccessibilityNodeInfoCompat var1, ViewGroup var2) {
         int var4 = var2.getChildCount();

         for(int var3 = 0; var3 < var4; ++var3) {
            View var5 = var2.getChildAt(var3);
            if(DrawerLayout.includeChildForAccessibility(var5)) {
               var1.addChild(var5);
            }
         }

      }

      private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat var1, AccessibilityNodeInfoCompat var2) {
         Rect var3 = this.mTmpRect;
         var2.getBoundsInParent(var3);
         var1.setBoundsInParent(var3);
         var2.getBoundsInScreen(var3);
         var1.setBoundsInScreen(var3);
         var1.setVisibleToUser(var2.isVisibleToUser());
         var1.setPackageName(var2.getPackageName());
         var1.setClassName(var2.getClassName());
         var1.setContentDescription(var2.getContentDescription());
         var1.setEnabled(var2.isEnabled());
         var1.setClickable(var2.isClickable());
         var1.setFocusable(var2.isFocusable());
         var1.setFocused(var2.isFocused());
         var1.setAccessibilityFocused(var2.isAccessibilityFocused());
         var1.setSelected(var2.isSelected());
         var1.setLongClickable(var2.isLongClickable());
         var1.addAction(var2.getActions());
      }

      public boolean dispatchPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
         if(var2.getEventType() == 32) {
            List var4 = var2.getText();
            View var5 = DrawerLayout.this.findVisibleDrawer();
            if(var5 != null) {
               int var3 = DrawerLayout.this.getDrawerViewAbsoluteGravity(var5);
               CharSequence var6 = DrawerLayout.this.getDrawerTitle(var3);
               if(var6 != null) {
                  var4.add(var6);
               }
            }

            return true;
         } else {
            return super.dispatchPopulateAccessibilityEvent(var1, var2);
         }
      }

      public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
         super.onInitializeAccessibilityEvent(var1, var2);
         var2.setClassName(DrawerLayout.class.getName());
      }

      public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
         if(DrawerLayout.CAN_HIDE_DESCENDANTS) {
            super.onInitializeAccessibilityNodeInfo(var1, var2);
         } else {
            AccessibilityNodeInfoCompat var3 = AccessibilityNodeInfoCompat.obtain(var2);
            super.onInitializeAccessibilityNodeInfo(var1, var3);
            var2.setSource(var1);
            ViewParent var4 = ViewCompat.getParentForAccessibility(var1);
            if(var4 instanceof View) {
               var2.setParent((View)var4);
            }

            this.copyNodeInfoNoChildren(var2, var3);
            var3.recycle();
            this.addChildrenForAccessibility(var2, (ViewGroup)var1);
         }

         var2.setClassName(DrawerLayout.class.getName());
         var2.setFocusable(false);
         var2.setFocused(false);
      }

      public boolean onRequestSendAccessibilityEvent(ViewGroup var1, View var2, AccessibilityEvent var3) {
         return !DrawerLayout.CAN_HIDE_DESCENDANTS && !DrawerLayout.includeChildForAccessibility(var2)?false:super.onRequestSendAccessibilityEvent(var1, var2, var3);
      }
   }

   final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
      public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
         super.onInitializeAccessibilityNodeInfo(var1, var2);
         if(!DrawerLayout.includeChildForAccessibility(var1)) {
            var2.setParent((View)null);
         }

      }
   }

   interface DrawerLayoutCompatImpl {
      void applyMarginInsets(MarginLayoutParams var1, Object var2, int var3);

      void configureApplyInsets(View var1);

      void dispatchChildInsets(View var1, Object var2, int var3);

      Drawable getDefaultStatusBarBackground(Context var1);

      int getTopInset(Object var1);
   }

   static class DrawerLayoutCompatImplApi21 implements DrawerLayout.DrawerLayoutCompatImpl {
      public void applyMarginInsets(MarginLayoutParams var1, Object var2, int var3) {
         DrawerLayoutCompatApi21.applyMarginInsets(var1, var2, var3);
      }

      public void configureApplyInsets(View var1) {
         DrawerLayoutCompatApi21.configureApplyInsets(var1);
      }

      public void dispatchChildInsets(View var1, Object var2, int var3) {
         DrawerLayoutCompatApi21.dispatchChildInsets(var1, var2, var3);
      }

      public Drawable getDefaultStatusBarBackground(Context var1) {
         return DrawerLayoutCompatApi21.getDefaultStatusBarBackground(var1);
      }

      public int getTopInset(Object var1) {
         return DrawerLayoutCompatApi21.getTopInset(var1);
      }
   }

   static class DrawerLayoutCompatImplBase implements DrawerLayout.DrawerLayoutCompatImpl {
      public void applyMarginInsets(MarginLayoutParams var1, Object var2, int var3) {
      }

      public void configureApplyInsets(View var1) {
      }

      public void dispatchChildInsets(View var1, Object var2, int var3) {
      }

      public Drawable getDefaultStatusBarBackground(Context var1) {
         return null;
      }

      public int getTopInset(Object var1) {
         return 0;
      }
   }

   public interface DrawerListener {
      void onDrawerClosed(View var1);

      void onDrawerOpened(View var1);

      void onDrawerSlide(View var1, float var2);

      void onDrawerStateChanged(int var1);
   }

   public static class LayoutParams extends MarginLayoutParams {
      public int gravity;
      boolean isPeeking;
      boolean knownOpen;
      float onScreen;

      public LayoutParams(int var1, int var2) {
         super(var1, var2);
         this.gravity = 0;
      }

      public LayoutParams(int var1, int var2, int var3) {
         this(var1, var2);
         this.gravity = var3;
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
         this.gravity = 0;
         TypedArray var3 = var1.obtainStyledAttributes(var2, DrawerLayout.LAYOUT_ATTRS);
         this.gravity = var3.getInt(0, 0);
         var3.recycle();
      }

      public LayoutParams(DrawerLayout.LayoutParams var1) {
         super(var1);
         this.gravity = 0;
         this.gravity = var1.gravity;
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
         this.gravity = 0;
      }

      public LayoutParams(MarginLayoutParams var1) {
         super(var1);
         this.gravity = 0;
      }
   }

   protected static class SavedState extends BaseSavedState {
      public static final Creator CREATOR = new Creator() {
         public DrawerLayout.SavedState createFromParcel(Parcel var1) {
            return new DrawerLayout.SavedState(var1);
         }

         public DrawerLayout.SavedState[] newArray(int var1) {
            return new DrawerLayout.SavedState[var1];
         }
      };
      int lockModeLeft = 0;
      int lockModeRight = 0;
      int openDrawerGravity = 0;

      public SavedState(Parcel var1) {
         super(var1);
         this.openDrawerGravity = var1.readInt();
      }

      public SavedState(Parcelable var1) {
         super(var1);
      }

      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeInt(this.openDrawerGravity);
      }
   }

   public abstract static class SimpleDrawerListener implements DrawerLayout.DrawerListener {
      public void onDrawerClosed(View var1) {
      }

      public void onDrawerOpened(View var1) {
      }

      public void onDrawerSlide(View var1, float var2) {
      }

      public void onDrawerStateChanged(int var1) {
      }
   }

   private class ViewDragCallback extends ViewDragHelper.Callback {
      private final int mAbsGravity;
      private ViewDragHelper mDragger;
      private final Runnable mPeekRunnable = new Runnable() {
         public void run() {
            ViewDragCallback.this.peekDrawer();
         }
      };

      public ViewDragCallback(int var2) {
         this.mAbsGravity = var2;
      }

      private void closeOtherDrawer() {
         byte var1 = 3;
         if(this.mAbsGravity == 3) {
            var1 = 5;
         }

         View var2 = DrawerLayout.this.findDrawerWithGravity(var1);
         if(var2 != null) {
            DrawerLayout.this.closeDrawer(var2);
         }

      }

      private void peekDrawer() {
         int var2 = 0;
         int var3 = this.mDragger.getEdgeSize();
         boolean var1;
         if(this.mAbsGravity == 3) {
            var1 = true;
         } else {
            var1 = false;
         }

         View var4;
         if(var1) {
            var4 = DrawerLayout.this.findDrawerWithGravity(3);
            if(var4 != null) {
               var2 = -var4.getWidth();
            }

            var2 += var3;
         } else {
            var4 = DrawerLayout.this.findDrawerWithGravity(5);
            var2 = DrawerLayout.this.getWidth() - var3;
         }

         if(var4 != null && (var1 && var4.getLeft() < var2 || !var1 && var4.getLeft() > var2) && DrawerLayout.this.getDrawerLockMode(var4) == 0) {
            DrawerLayout.LayoutParams var5 = (DrawerLayout.LayoutParams)var4.getLayoutParams();
            this.mDragger.smoothSlideViewTo(var4, var2, var4.getTop());
            var5.isPeeking = true;
            DrawerLayout.this.invalidate();
            this.closeOtherDrawer();
            DrawerLayout.this.cancelChildViewTouch();
         }

      }

      public int clampViewPositionHorizontal(View var1, int var2, int var3) {
         if(DrawerLayout.this.checkDrawerViewAbsoluteGravity(var1, 3)) {
            return Math.max(-var1.getWidth(), Math.min(var2, 0));
         } else {
            var3 = DrawerLayout.this.getWidth();
            return Math.max(var3 - var1.getWidth(), Math.min(var2, var3));
         }
      }

      public int clampViewPositionVertical(View var1, int var2, int var3) {
         return var1.getTop();
      }

      public int getViewHorizontalDragRange(View var1) {
         return DrawerLayout.this.isDrawerView(var1)?var1.getWidth():0;
      }

      public void onEdgeDragStarted(int var1, int var2) {
         View var3;
         if((var1 & 1) == 1) {
            var3 = DrawerLayout.this.findDrawerWithGravity(3);
         } else {
            var3 = DrawerLayout.this.findDrawerWithGravity(5);
         }

         if(var3 != null && DrawerLayout.this.getDrawerLockMode(var3) == 0) {
            this.mDragger.captureChildView(var3, var2);
         }

      }

      public boolean onEdgeLock(int var1) {
         return false;
      }

      public void onEdgeTouched(int var1, int var2) {
         DrawerLayout.this.postDelayed(this.mPeekRunnable, 160L);
      }

      public void onViewCaptured(View var1, int var2) {
         ((DrawerLayout.LayoutParams)var1.getLayoutParams()).isPeeking = false;
         this.closeOtherDrawer();
      }

      public void onViewDragStateChanged(int var1) {
         DrawerLayout.this.updateDrawerState(this.mAbsGravity, var1, this.mDragger.getCapturedView());
      }

      public void onViewPositionChanged(View var1, int var2, int var3, int var4, int var5) {
         var3 = var1.getWidth();
         float var6;
         if(DrawerLayout.this.checkDrawerViewAbsoluteGravity(var1, 3)) {
            var6 = (float)(var3 + var2) / (float)var3;
         } else {
            var6 = (float)(DrawerLayout.this.getWidth() - var2) / (float)var3;
         }

         DrawerLayout.this.setDrawerViewOffset(var1, var6);
         byte var7;
         if(var6 == 0.0F) {
            var7 = 4;
         } else {
            var7 = 0;
         }

         var1.setVisibility(var7);
         DrawerLayout.this.invalidate();
      }

      public void onViewReleased(View var1, float var2, float var3) {
         var3 = DrawerLayout.this.getDrawerViewOffset(var1);
         int var5 = var1.getWidth();
         int var4;
         if(DrawerLayout.this.checkDrawerViewAbsoluteGravity(var1, 3)) {
            if(var2 <= 0.0F && (var2 != 0.0F || var3 <= 0.5F)) {
               var4 = -var5;
            } else {
               var4 = 0;
            }
         } else {
            var4 = DrawerLayout.this.getWidth();
            if(var2 < 0.0F || var2 == 0.0F && var3 > 0.5F) {
               var4 -= var5;
            }
         }

         this.mDragger.settleCapturedViewAt(var4, var1.getTop());
         DrawerLayout.this.invalidate();
      }

      public void removeCallbacks() {
         DrawerLayout.this.removeCallbacks(this.mPeekRunnable);
      }

      public void setDragger(ViewDragHelper var1) {
         this.mDragger = var1;
      }

      public boolean tryCaptureView(View var1, int var2) {
         return DrawerLayout.this.isDrawerView(var1) && DrawerLayout.this.checkDrawerViewAbsoluteGravity(var1, this.mAbsGravity) && DrawerLayout.this.getDrawerLockMode(var1) == 0;
      }
   }
}
