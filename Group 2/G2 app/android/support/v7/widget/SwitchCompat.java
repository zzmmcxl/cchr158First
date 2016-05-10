package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.internal.text.AllCapsTransformationMethod;
import android.support.v7.internal.widget.DrawableUtils;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.support.v7.internal.widget.ViewUtils;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.Layout.Alignment;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.CompoundButton;

public class SwitchCompat extends CompoundButton {
   private static final String ACCESSIBILITY_EVENT_CLASS_NAME = "android.widget.Switch";
   private static final int[] CHECKED_STATE_SET = new int[]{16842912};
   private static final int MONOSPACE = 3;
   private static final int SANS = 1;
   private static final int SERIF = 2;
   private static final int THUMB_ANIMATION_DURATION = 250;
   private static final int TOUCH_MODE_DOWN = 1;
   private static final int TOUCH_MODE_DRAGGING = 2;
   private static final int TOUCH_MODE_IDLE = 0;
   private int mMinFlingVelocity;
   private Layout mOffLayout;
   private Layout mOnLayout;
   private Animation mPositionAnimator;
   private boolean mShowText;
   private boolean mSplitTrack;
   private int mSwitchBottom;
   private int mSwitchHeight;
   private int mSwitchLeft;
   private int mSwitchMinWidth;
   private int mSwitchPadding;
   private int mSwitchRight;
   private int mSwitchTop;
   private TransformationMethod mSwitchTransformationMethod;
   private int mSwitchWidth;
   private final Rect mTempRect;
   private ColorStateList mTextColors;
   private CharSequence mTextOff;
   private CharSequence mTextOn;
   private TextPaint mTextPaint;
   private Drawable mThumbDrawable;
   private float mThumbPosition;
   private int mThumbTextPadding;
   private int mThumbWidth;
   private final TintManager mTintManager;
   private int mTouchMode;
   private int mTouchSlop;
   private float mTouchX;
   private float mTouchY;
   private Drawable mTrackDrawable;
   private VelocityTracker mVelocityTracker;

   public SwitchCompat(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public SwitchCompat(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.switchStyle);
   }

   public SwitchCompat(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mVelocityTracker = VelocityTracker.obtain();
      this.mTempRect = new Rect();
      this.mTextPaint = new TextPaint(1);
      Resources var4 = this.getResources();
      this.mTextPaint.density = var4.getDisplayMetrics().density;
      TintTypedArray var6 = TintTypedArray.obtainStyledAttributes(var1, var2, R.styleable.SwitchCompat, var3, 0);
      this.mThumbDrawable = var6.getDrawable(R.styleable.SwitchCompat_android_thumb);
      if(this.mThumbDrawable != null) {
         this.mThumbDrawable.setCallback(this);
      }

      this.mTrackDrawable = var6.getDrawable(R.styleable.SwitchCompat_track);
      if(this.mTrackDrawable != null) {
         this.mTrackDrawable.setCallback(this);
      }

      this.mTextOn = var6.getText(R.styleable.SwitchCompat_android_textOn);
      this.mTextOff = var6.getText(R.styleable.SwitchCompat_android_textOff);
      this.mShowText = var6.getBoolean(R.styleable.SwitchCompat_showText, true);
      this.mThumbTextPadding = var6.getDimensionPixelSize(R.styleable.SwitchCompat_thumbTextPadding, 0);
      this.mSwitchMinWidth = var6.getDimensionPixelSize(R.styleable.SwitchCompat_switchMinWidth, 0);
      this.mSwitchPadding = var6.getDimensionPixelSize(R.styleable.SwitchCompat_switchPadding, 0);
      this.mSplitTrack = var6.getBoolean(R.styleable.SwitchCompat_splitTrack, false);
      var3 = var6.getResourceId(R.styleable.SwitchCompat_switchTextAppearance, 0);
      if(var3 != 0) {
         this.setSwitchTextAppearance(var1, var3);
      }

      this.mTintManager = var6.getTintManager();
      var6.recycle();
      ViewConfiguration var5 = ViewConfiguration.get(var1);
      this.mTouchSlop = var5.getScaledTouchSlop();
      this.mMinFlingVelocity = var5.getScaledMinimumFlingVelocity();
      this.refreshDrawableState();
      this.setChecked(this.isChecked());
   }

   private void animateThumbToCheckedState(boolean var1) {
      final float var3 = this.mThumbPosition;
      float var2;
      if(var1) {
         var2 = 1.0F;
      } else {
         var2 = 0.0F;
      }

      this.mPositionAnimator = new Animation() {
         // $FF: synthetic field
         final float val$diff;

         {
            this.val$diff = var3x;
         }

         protected void applyTransformation(float var1, Transformation var2) {
            SwitchCompat.this.setThumbPosition(var3 + this.val$diff * var1);
         }
      };
      this.mPositionAnimator.setDuration(250L);
      this.startAnimation(this.mPositionAnimator);
   }

   private void cancelPositionAnimator() {
      if(this.mPositionAnimator != null) {
         this.clearAnimation();
         this.mPositionAnimator = null;
      }

   }

   private void cancelSuperTouch(MotionEvent var1) {
      var1 = MotionEvent.obtain(var1);
      var1.setAction(3);
      super.onTouchEvent(var1);
      var1.recycle();
   }

   private static float constrain(float var0, float var1, float var2) {
      return var0 < var1?var1:(var0 > var2?var2:var0);
   }

   private boolean getTargetCheckedState() {
      return this.mThumbPosition > 0.5F;
   }

   private int getThumbOffset() {
      float var1;
      if(ViewUtils.isLayoutRtl(this)) {
         var1 = 1.0F - this.mThumbPosition;
      } else {
         var1 = this.mThumbPosition;
      }

      return (int)((float)this.getThumbScrollRange() * var1 + 0.5F);
   }

   private int getThumbScrollRange() {
      if(this.mTrackDrawable != null) {
         Rect var2 = this.mTempRect;
         this.mTrackDrawable.getPadding(var2);
         Rect var1;
         if(this.mThumbDrawable != null) {
            var1 = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
         } else {
            var1 = DrawableUtils.INSETS_NONE;
         }

         return this.mSwitchWidth - this.mThumbWidth - var2.left - var2.right - var1.left - var1.right;
      } else {
         return 0;
      }
   }

   private boolean hitThumb(float var1, float var2) {
      if(this.mThumbDrawable != null) {
         int var5 = this.getThumbOffset();
         this.mThumbDrawable.getPadding(this.mTempRect);
         int var3 = this.mSwitchTop;
         int var4 = this.mTouchSlop;
         var5 = this.mSwitchLeft + var5 - this.mTouchSlop;
         int var6 = this.mThumbWidth;
         int var7 = this.mTempRect.left;
         int var8 = this.mTempRect.right;
         int var9 = this.mTouchSlop;
         int var10 = this.mSwitchBottom;
         int var11 = this.mTouchSlop;
         if(var1 > (float)var5 && var1 < (float)(var6 + var5 + var7 + var8 + var9) && var2 > (float)(var3 - var4) && var2 < (float)(var10 + var11)) {
            return true;
         }
      }

      return false;
   }

   private Layout makeLayout(CharSequence var1) {
      if(this.mSwitchTransformationMethod != null) {
         var1 = this.mSwitchTransformationMethod.getTransformation(var1, this);
      }

      TextPaint var3 = this.mTextPaint;
      int var2;
      if(var1 != null) {
         var2 = (int)Math.ceil((double)Layout.getDesiredWidth(var1, this.mTextPaint));
      } else {
         var2 = 0;
      }

      return new StaticLayout(var1, var3, var2, Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
   }

   private void setSwitchTypefaceByIndex(int var1, int var2) {
      Typeface var3 = null;
      switch(var1) {
      case 1:
         var3 = Typeface.SANS_SERIF;
         break;
      case 2:
         var3 = Typeface.SERIF;
         break;
      case 3:
         var3 = Typeface.MONOSPACE;
      }

      this.setSwitchTypeface(var3, var2);
   }

   private void setThumbPosition(float var1) {
      this.mThumbPosition = var1;
      this.invalidate();
   }

   private void stopDrag(MotionEvent var1) {
      this.mTouchMode = 0;
      boolean var3;
      if(var1.getAction() == 1 && this.isEnabled()) {
         var3 = true;
      } else {
         var3 = false;
      }

      boolean var5 = this.isChecked();
      boolean var4;
      if(var3) {
         this.mVelocityTracker.computeCurrentVelocity(1000);
         float var2 = this.mVelocityTracker.getXVelocity();
         if(Math.abs(var2) > (float)this.mMinFlingVelocity) {
            if(ViewUtils.isLayoutRtl(this)) {
               if(var2 < 0.0F) {
                  var4 = true;
               } else {
                  var4 = false;
               }
            } else if(var2 > 0.0F) {
               var4 = true;
            } else {
               var4 = false;
            }
         } else {
            var4 = this.getTargetCheckedState();
         }
      } else {
         var4 = var5;
      }

      if(var4 != var5) {
         this.playSoundEffect(0);
         this.setChecked(var4);
      }

      this.cancelSuperTouch(var1);
   }

   public void draw(Canvas var1) {
      Rect var15 = this.mTempRect;
      int var5 = this.mSwitchLeft;
      int var11 = this.mSwitchTop;
      int var3 = this.mSwitchRight;
      int var12 = this.mSwitchBottom;
      int var4 = var5 + this.getThumbOffset();
      Rect var14;
      if(this.mThumbDrawable != null) {
         var14 = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
      } else {
         var14 = DrawableUtils.INSETS_NONE;
      }

      int var2 = var4;
      if(this.mTrackDrawable != null) {
         this.mTrackDrawable.getPadding(var15);
         int var13 = var4 + var15.left;
         int var10 = var12;
         int var7 = var5;
         int var8 = var3;
         int var9 = var11;
         if(var14 != null) {
            var10 = var12;
            var7 = var5;
            var8 = var3;
            var9 = var11;
            if(!var14.isEmpty()) {
               var2 = var5;
               if(var14.left > var15.left) {
                  var2 = var5 + (var14.left - var15.left);
               }

               var5 = var11;
               if(var14.top > var15.top) {
                  var5 = var11 + (var14.top - var15.top);
               }

               var4 = var3;
               if(var14.right > var15.right) {
                  var4 = var3 - (var14.right - var15.right);
               }

               var10 = var12;
               var7 = var2;
               var8 = var4;
               var9 = var5;
               if(var14.bottom > var15.bottom) {
                  var10 = var12 - (var14.bottom - var15.bottom);
                  var9 = var5;
                  var8 = var4;
                  var7 = var2;
               }
            }
         }

         this.mTrackDrawable.setBounds(var7, var9, var8, var10);
         var2 = var13;
      }

      if(this.mThumbDrawable != null) {
         this.mThumbDrawable.getPadding(var15);
         var3 = var2 - var15.left;
         var2 = this.mThumbWidth + var2 + var15.right;
         this.mThumbDrawable.setBounds(var3, var11, var2, var12);
         Drawable var16 = this.getBackground();
         if(var16 != null) {
            DrawableCompat.setHotspotBounds(var16, var3, var11, var2, var12);
         }
      }

      super.draw(var1);
   }

   public void drawableHotspotChanged(float var1, float var2) {
      if(VERSION.SDK_INT >= 21) {
         super.drawableHotspotChanged(var1, var2);
      }

      if(this.mThumbDrawable != null) {
         DrawableCompat.setHotspot(this.mThumbDrawable, var1, var2);
      }

      if(this.mTrackDrawable != null) {
         DrawableCompat.setHotspot(this.mTrackDrawable, var1, var2);
      }

   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      int[] var1 = this.getDrawableState();
      if(this.mThumbDrawable != null) {
         this.mThumbDrawable.setState(var1);
      }

      if(this.mTrackDrawable != null) {
         this.mTrackDrawable.setState(var1);
      }

      this.invalidate();
   }

   public int getCompoundPaddingLeft() {
      int var1;
      if(!ViewUtils.isLayoutRtl(this)) {
         var1 = super.getCompoundPaddingLeft();
      } else {
         int var2 = super.getCompoundPaddingLeft() + this.mSwitchWidth;
         var1 = var2;
         if(!TextUtils.isEmpty(this.getText())) {
            return var2 + this.mSwitchPadding;
         }
      }

      return var1;
   }

   public int getCompoundPaddingRight() {
      int var1;
      if(ViewUtils.isLayoutRtl(this)) {
         var1 = super.getCompoundPaddingRight();
      } else {
         int var2 = super.getCompoundPaddingRight() + this.mSwitchWidth;
         var1 = var2;
         if(!TextUtils.isEmpty(this.getText())) {
            return var2 + this.mSwitchPadding;
         }
      }

      return var1;
   }

   public boolean getShowText() {
      return this.mShowText;
   }

   public boolean getSplitTrack() {
      return this.mSplitTrack;
   }

   public int getSwitchMinWidth() {
      return this.mSwitchMinWidth;
   }

   public int getSwitchPadding() {
      return this.mSwitchPadding;
   }

   public CharSequence getTextOff() {
      return this.mTextOff;
   }

   public CharSequence getTextOn() {
      return this.mTextOn;
   }

   public Drawable getThumbDrawable() {
      return this.mThumbDrawable;
   }

   public int getThumbTextPadding() {
      return this.mThumbTextPadding;
   }

   public Drawable getTrackDrawable() {
      return this.mTrackDrawable;
   }

   public void jumpDrawablesToCurrentState() {
      if(VERSION.SDK_INT >= 11) {
         super.jumpDrawablesToCurrentState();
         if(this.mThumbDrawable != null) {
            this.mThumbDrawable.jumpToCurrentState();
         }

         if(this.mTrackDrawable != null) {
            this.mTrackDrawable.jumpToCurrentState();
         }

         if(this.mPositionAnimator != null && !this.mPositionAnimator.hasEnded()) {
            this.clearAnimation();
            this.mPositionAnimator = null;
         }
      }

   }

   protected int[] onCreateDrawableState(int var1) {
      int[] var2 = super.onCreateDrawableState(var1 + 1);
      if(this.isChecked()) {
         mergeDrawableStates(var2, CHECKED_STATE_SET);
      }

      return var2;
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      Rect var9 = this.mTempRect;
      Drawable var11 = this.mTrackDrawable;
      if(var11 != null) {
         var11.getPadding(var9);
      } else {
         var9.setEmpty();
      }

      int var4 = this.mSwitchTop;
      int var5 = this.mSwitchBottom;
      int var6 = var9.top;
      int var7 = var9.bottom;
      Drawable var10 = this.mThumbDrawable;
      int var2;
      if(var11 != null) {
         if(this.mSplitTrack && var10 != null) {
            Rect var12 = DrawableUtils.getOpticalBounds(var10);
            var10.copyBounds(var9);
            var9.left += var12.left;
            var9.right -= var12.right;
            var2 = var1.save();
            var1.clipRect(var9, Op.DIFFERENCE);
            var11.draw(var1);
            var1.restoreToCount(var2);
         } else {
            var11.draw(var1);
         }
      }

      int var3 = var1.save();
      if(var10 != null) {
         var10.draw(var1);
      }

      Layout var15;
      if(this.getTargetCheckedState()) {
         var15 = this.mOnLayout;
      } else {
         var15 = this.mOffLayout;
      }

      if(var15 != null) {
         int[] var14 = this.getDrawableState();
         if(this.mTextColors != null) {
            this.mTextPaint.setColor(this.mTextColors.getColorForState(var14, 0));
         }

         this.mTextPaint.drawableState = var14;
         if(var10 != null) {
            Rect var13 = var10.getBounds();
            var2 = var13.left + var13.right;
         } else {
            var2 = this.getWidth();
         }

         var2 /= 2;
         int var8 = var15.getWidth() / 2;
         var4 = (var4 + var6 + (var5 - var7)) / 2;
         var5 = var15.getHeight() / 2;
         var1.translate((float)(var2 - var8), (float)(var4 - var5));
         var15.draw(var1);
      }

      var1.restoreToCount(var3);
   }

   @TargetApi(14)
   public void onInitializeAccessibilityEvent(AccessibilityEvent var1) {
      super.onInitializeAccessibilityEvent(var1);
      var1.setClassName("android.widget.Switch");
   }

   public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo var1) {
      if(VERSION.SDK_INT >= 14) {
         super.onInitializeAccessibilityNodeInfo(var1);
         var1.setClassName("android.widget.Switch");
         CharSequence var2;
         if(this.isChecked()) {
            var2 = this.mTextOn;
         } else {
            var2 = this.mTextOff;
         }

         if(!TextUtils.isEmpty(var2)) {
            CharSequence var3 = var1.getText();
            if(!TextUtils.isEmpty(var3)) {
               StringBuilder var4 = new StringBuilder();
               var4.append(var3).append(' ').append(var2);
               var1.setText(var4);
               return;
            }

            var1.setText(var2);
         }
      }

   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      var2 = 0;
      var3 = 0;
      if(this.mThumbDrawable != null) {
         Rect var6 = this.mTempRect;
         if(this.mTrackDrawable != null) {
            this.mTrackDrawable.getPadding(var6);
         } else {
            var6.setEmpty();
         }

         Rect var7 = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
         var2 = Math.max(0, var7.left - var6.left);
         var3 = Math.max(0, var7.right - var6.right);
      }

      if(ViewUtils.isLayoutRtl(this)) {
         var4 = this.getPaddingLeft() + var2;
         var5 = this.mSwitchWidth + var4 - var2 - var3;
      } else {
         var5 = this.getWidth() - this.getPaddingRight() - var3;
         var4 = var5 - this.mSwitchWidth + var2 + var3;
      }

      switch(this.getGravity() & 112) {
      case 16:
         var3 = (this.getPaddingTop() + this.getHeight() - this.getPaddingBottom()) / 2 - this.mSwitchHeight / 2;
         var2 = var3 + this.mSwitchHeight;
         break;
      case 80:
         var2 = this.getHeight() - this.getPaddingBottom();
         var3 = var2 - this.mSwitchHeight;
         break;
      default:
         var3 = this.getPaddingTop();
         var2 = var3 + this.mSwitchHeight;
      }

      this.mSwitchLeft = var4;
      this.mSwitchTop = var3;
      this.mSwitchBottom = var2;
      this.mSwitchRight = var5;
   }

   public void onMeasure(int var1, int var2) {
      if(this.mShowText) {
         if(this.mOnLayout == null) {
            this.mOnLayout = this.makeLayout(this.mTextOn);
         }

         if(this.mOffLayout == null) {
            this.mOffLayout = this.makeLayout(this.mTextOff);
         }
      }

      Rect var9 = this.mTempRect;
      int var3;
      int var4;
      if(this.mThumbDrawable != null) {
         this.mThumbDrawable.getPadding(var9);
         var4 = this.mThumbDrawable.getIntrinsicWidth() - var9.left - var9.right;
         var3 = this.mThumbDrawable.getIntrinsicHeight();
      } else {
         var4 = 0;
         var3 = 0;
      }

      int var5;
      if(this.mShowText) {
         var5 = Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth()) + this.mThumbTextPadding * 2;
      } else {
         var5 = 0;
      }

      this.mThumbWidth = Math.max(var5, var4);
      if(this.mTrackDrawable != null) {
         this.mTrackDrawable.getPadding(var9);
         var4 = this.mTrackDrawable.getIntrinsicHeight();
      } else {
         var9.setEmpty();
         var4 = 0;
      }

      int var8 = var9.left;
      int var7 = var9.right;
      int var6 = var8;
      var5 = var7;
      if(this.mThumbDrawable != null) {
         var9 = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
         var6 = Math.max(var8, var9.left);
         var5 = Math.max(var7, var9.right);
      }

      var5 = Math.max(this.mSwitchMinWidth, this.mThumbWidth * 2 + var6 + var5);
      var3 = Math.max(var4, var3);
      this.mSwitchWidth = var5;
      this.mSwitchHeight = var3;
      super.onMeasure(var1, var2);
      if(this.getMeasuredHeight() < var3) {
         this.setMeasuredDimension(ViewCompat.getMeasuredWidthAndState(this), var3);
      }

   }

   @TargetApi(14)
   public void onPopulateAccessibilityEvent(AccessibilityEvent var1) {
      super.onPopulateAccessibilityEvent(var1);
      CharSequence var2;
      if(this.isChecked()) {
         var2 = this.mTextOn;
      } else {
         var2 = this.mTextOff;
      }

      if(var2 != null) {
         var1.getText().add(var2);
      }

   }

   public boolean onTouchEvent(MotionEvent var1) {
      this.mVelocityTracker.addMovement(var1);
      float var2;
      float var3;
      switch(MotionEventCompat.getActionMasked(var1)) {
      case 0:
         var2 = var1.getX();
         var3 = var1.getY();
         if(this.isEnabled() && this.hitThumb(var2, var3)) {
            this.mTouchMode = 1;
            this.mTouchX = var2;
            this.mTouchY = var3;
         }
         break;
      case 1:
      case 3:
         if(this.mTouchMode == 2) {
            this.stopDrag(var1);
            super.onTouchEvent(var1);
            return true;
         }

         this.mTouchMode = 0;
         this.mVelocityTracker.clear();
         break;
      case 2:
         switch(this.mTouchMode) {
         case 0:
         default:
            break;
         case 1:
            var2 = var1.getX();
            var3 = var1.getY();
            if(Math.abs(var2 - this.mTouchX) <= (float)this.mTouchSlop && Math.abs(var3 - this.mTouchY) <= (float)this.mTouchSlop) {
               break;
            }

            this.mTouchMode = 2;
            this.getParent().requestDisallowInterceptTouchEvent(true);
            this.mTouchX = var2;
            this.mTouchY = var3;
            return true;
         case 2:
            float var4 = var1.getX();
            int var5 = this.getThumbScrollRange();
            var2 = var4 - this.mTouchX;
            if(var5 != 0) {
               var2 /= (float)var5;
            } else if(var2 > 0.0F) {
               var2 = 1.0F;
            } else {
               var2 = -1.0F;
            }

            var3 = var2;
            if(ViewUtils.isLayoutRtl(this)) {
               var3 = -var2;
            }

            var2 = constrain(this.mThumbPosition + var3, 0.0F, 1.0F);
            if(var2 != this.mThumbPosition) {
               this.mTouchX = var4;
               this.setThumbPosition(var2);
            }

            return true;
         }
      }

      return super.onTouchEvent(var1);
   }

   public void setChecked(boolean var1) {
      super.setChecked(var1);
      var1 = this.isChecked();
      if(this.getWindowToken() != null && ViewCompat.isLaidOut(this)) {
         this.animateThumbToCheckedState(var1);
      } else {
         this.cancelPositionAnimator();
         float var2;
         if(var1) {
            var2 = 1.0F;
         } else {
            var2 = 0.0F;
         }

         this.setThumbPosition(var2);
      }
   }

   public void setShowText(boolean var1) {
      if(this.mShowText != var1) {
         this.mShowText = var1;
         this.requestLayout();
      }

   }

   public void setSplitTrack(boolean var1) {
      this.mSplitTrack = var1;
      this.invalidate();
   }

   public void setSwitchMinWidth(int var1) {
      this.mSwitchMinWidth = var1;
      this.requestLayout();
   }

   public void setSwitchPadding(int var1) {
      this.mSwitchPadding = var1;
      this.requestLayout();
   }

   public void setSwitchTextAppearance(Context var1, int var2) {
      TypedArray var4 = var1.obtainStyledAttributes(var2, R.styleable.TextAppearance);
      ColorStateList var3 = var4.getColorStateList(R.styleable.TextAppearance_android_textColor);
      if(var3 != null) {
         this.mTextColors = var3;
      } else {
         this.mTextColors = this.getTextColors();
      }

      var2 = var4.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
      if(var2 != 0 && (float)var2 != this.mTextPaint.getTextSize()) {
         this.mTextPaint.setTextSize((float)var2);
         this.requestLayout();
      }

      this.setSwitchTypefaceByIndex(var4.getInt(R.styleable.TextAppearance_android_typeface, -1), var4.getInt(R.styleable.TextAppearance_android_textStyle, -1));
      if(var4.getBoolean(R.styleable.TextAppearance_textAllCaps, false)) {
         this.mSwitchTransformationMethod = new AllCapsTransformationMethod(this.getContext());
      } else {
         this.mSwitchTransformationMethod = null;
      }

      var4.recycle();
   }

   public void setSwitchTypeface(Typeface var1) {
      if(this.mTextPaint.getTypeface() != var1) {
         this.mTextPaint.setTypeface(var1);
         this.requestLayout();
         this.invalidate();
      }

   }

   public void setSwitchTypeface(Typeface var1, int var2) {
      boolean var5 = false;
      if(var2 > 0) {
         if(var1 == null) {
            var1 = Typeface.defaultFromStyle(var2);
         } else {
            var1 = Typeface.create(var1, var2);
         }

         this.setSwitchTypeface(var1);
         int var4;
         if(var1 != null) {
            var4 = var1.getStyle();
         } else {
            var4 = 0;
         }

         var2 &= ~var4;
         TextPaint var6 = this.mTextPaint;
         if((var2 & 1) != 0) {
            var5 = true;
         }

         var6.setFakeBoldText(var5);
         var6 = this.mTextPaint;
         float var3;
         if((var2 & 2) != 0) {
            var3 = -0.25F;
         } else {
            var3 = 0.0F;
         }

         var6.setTextSkewX(var3);
      } else {
         this.mTextPaint.setFakeBoldText(false);
         this.mTextPaint.setTextSkewX(0.0F);
         this.setSwitchTypeface(var1);
      }
   }

   public void setTextOff(CharSequence var1) {
      this.mTextOff = var1;
      this.requestLayout();
   }

   public void setTextOn(CharSequence var1) {
      this.mTextOn = var1;
      this.requestLayout();
   }

   public void setThumbDrawable(Drawable var1) {
      this.mThumbDrawable = var1;
      this.requestLayout();
   }

   public void setThumbResource(int var1) {
      this.setThumbDrawable(this.mTintManager.getDrawable(var1));
   }

   public void setThumbTextPadding(int var1) {
      this.mThumbTextPadding = var1;
      this.requestLayout();
   }

   public void setTrackDrawable(Drawable var1) {
      this.mTrackDrawable = var1;
      this.requestLayout();
   }

   public void setTrackResource(int var1) {
      this.setTrackDrawable(this.mTintManager.getDrawable(var1));
   }

   public void toggle() {
      boolean var1;
      if(!this.isChecked()) {
         var1 = true;
      } else {
         var1 = false;
      }

      this.setChecked(var1);
   }

   protected boolean verifyDrawable(Drawable var1) {
      return super.verifyDrawable(var1) || var1 == this.mThumbDrawable || var1 == this.mTrackDrawable;
   }
}
