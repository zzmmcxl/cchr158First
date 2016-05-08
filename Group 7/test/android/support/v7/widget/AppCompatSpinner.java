package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.TintableBackgroundView;
import android.support.v7.appcompat.R$attr;
import android.support.v7.widget.AppCompatBackgroundHelper;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.AppCompatSpinner$DropDownAdapter;
import android.support.v7.widget.AppCompatSpinner$DropdownPopup;
import android.support.v7.widget.ListPopupWindow$ForwardingListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class AppCompatSpinner extends Spinner implements TintableBackgroundView {
   private static final int[] ATTRS_ANDROID_SPINNERMODE;
   private static final boolean IS_AT_LEAST_JB;
   private static final boolean IS_AT_LEAST_M;
   private static final int MAX_ITEMS_MEASURED = 15;
   private static final int MODE_DIALOG = 0;
   private static final int MODE_DROPDOWN = 1;
   private static final int MODE_THEME = -1;
   private static final String TAG = "AppCompatSpinner";
   private AppCompatBackgroundHelper mBackgroundTintHelper;
   private AppCompatDrawableManager mDrawableManager;
   private int mDropDownWidth;
   private ListPopupWindow$ForwardingListener mForwardingListener;
   private AppCompatSpinner$DropdownPopup mPopup;
   private Context mPopupContext;
   private boolean mPopupSet;
   private SpinnerAdapter mTempAdapter;
   private final Rect mTempRect;

   static {
      boolean var0;
      if(VERSION.SDK_INT >= 23) {
         var0 = true;
      } else {
         var0 = false;
      }

      IS_AT_LEAST_M = var0;
      if(VERSION.SDK_INT >= 16) {
         var0 = true;
      } else {
         var0 = false;
      }

      IS_AT_LEAST_JB = var0;
      ATTRS_ANDROID_SPINNERMODE = new int[]{16843505};
   }

   public AppCompatSpinner(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public AppCompatSpinner(Context var1, int var2) {
      this(var1, (AttributeSet)null, R$attr.spinnerStyle, var2);
   }

   public AppCompatSpinner(Context var1, AttributeSet var2) {
      this(var1, var2, R$attr.spinnerStyle);
   }

   public AppCompatSpinner(Context var1, AttributeSet var2, int var3) {
      this(var1, var2, var3, -1);
   }

   public AppCompatSpinner(Context var1, AttributeSet var2, int var3, int var4) {
      this(var1, var2, var3, var4, (Theme)null);
   }

   public AppCompatSpinner(Context param1, AttributeSet param2, int param3, int param4, Theme param5) {
      // $FF: Couldn't be decompiled
   }

   private int compatMeasureContentWidth(SpinnerAdapter var1, Drawable var2) {
      int var4;
      if(var1 == null) {
         var4 = 0;
      } else {
         int var3 = 0;
         View var11 = null;
         int var5 = 0;
         int var8 = MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 0);
         int var9 = MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 0);
         var4 = Math.max(0, this.getSelectedItemPosition());
         int var10 = Math.min(var1.getCount(), var4 + 15);

         int var6;
         for(var4 = Math.max(0, var4 - (15 - (var10 - var4))); var4 < var10; var5 = var6) {
            int var7 = var1.getItemViewType(var4);
            var6 = var5;
            if(var7 != var5) {
               var6 = var7;
               var11 = null;
            }

            var11 = var1.getView(var4, var11, this);
            if(var11.getLayoutParams() == null) {
               var11.setLayoutParams(new LayoutParams(-2, -2));
            }

            var11.measure(var8, var9);
            var3 = Math.max(var3, var11.getMeasuredWidth());
            ++var4;
         }

         var4 = var3;
         if(var2 != null) {
            var2.getPadding(this.mTempRect);
            return var3 + this.mTempRect.left + this.mTempRect.right;
         }
      }

      return var4;
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      if(this.mBackgroundTintHelper != null) {
         this.mBackgroundTintHelper.applySupportBackgroundTint();
      }

   }

   public int getDropDownHorizontalOffset() {
      return this.mPopup != null?this.mPopup.getHorizontalOffset():(IS_AT_LEAST_JB?super.getDropDownHorizontalOffset():0);
   }

   public int getDropDownVerticalOffset() {
      return this.mPopup != null?this.mPopup.getVerticalOffset():(IS_AT_LEAST_JB?super.getDropDownVerticalOffset():0);
   }

   public int getDropDownWidth() {
      return this.mPopup != null?this.mDropDownWidth:(IS_AT_LEAST_JB?super.getDropDownWidth():0);
   }

   public Drawable getPopupBackground() {
      return this.mPopup != null?this.mPopup.getBackground():(IS_AT_LEAST_JB?super.getPopupBackground():null);
   }

   public Context getPopupContext() {
      return this.mPopup != null?this.mPopupContext:(IS_AT_LEAST_M?super.getPopupContext():null);
   }

   public CharSequence getPrompt() {
      return this.mPopup != null?this.mPopup.getHintText():super.getPrompt();
   }

   @Nullable
   public ColorStateList getSupportBackgroundTintList() {
      return this.mBackgroundTintHelper != null?this.mBackgroundTintHelper.getSupportBackgroundTintList():null;
   }

   @Nullable
   public Mode getSupportBackgroundTintMode() {
      return this.mBackgroundTintHelper != null?this.mBackgroundTintHelper.getSupportBackgroundTintMode():null;
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if(this.mPopup != null && this.mPopup.isShowing()) {
         this.mPopup.dismiss();
      }

   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      if(this.mPopup != null && MeasureSpec.getMode(var1) == Integer.MIN_VALUE) {
         this.setMeasuredDimension(Math.min(Math.max(this.getMeasuredWidth(), this.compatMeasureContentWidth(this.getAdapter(), this.getBackground())), MeasureSpec.getSize(var1)), this.getMeasuredHeight());
      }

   }

   public boolean onTouchEvent(MotionEvent var1) {
      return this.mForwardingListener != null && this.mForwardingListener.onTouch(this, var1)?true:super.onTouchEvent(var1);
   }

   public boolean performClick() {
      if(this.mPopup != null && !this.mPopup.isShowing()) {
         this.mPopup.show();
         return true;
      } else {
         return super.performClick();
      }
   }

   public void setAdapter(SpinnerAdapter var1) {
      if(!this.mPopupSet) {
         this.mTempAdapter = var1;
      } else {
         super.setAdapter(var1);
         if(this.mPopup != null) {
            Context var2;
            if(this.mPopupContext == null) {
               var2 = this.getContext();
            } else {
               var2 = this.mPopupContext;
            }

            this.mPopup.setAdapter(new AppCompatSpinner$DropDownAdapter(var1, var2.getTheme()));
            return;
         }
      }

   }

   public void setBackgroundDrawable(Drawable var1) {
      super.setBackgroundDrawable(var1);
      if(this.mBackgroundTintHelper != null) {
         this.mBackgroundTintHelper.onSetBackgroundDrawable(var1);
      }

   }

   public void setBackgroundResource(@DrawableRes int var1) {
      super.setBackgroundResource(var1);
      if(this.mBackgroundTintHelper != null) {
         this.mBackgroundTintHelper.onSetBackgroundResource(var1);
      }

   }

   public void setDropDownHorizontalOffset(int var1) {
      if(this.mPopup != null) {
         this.mPopup.setHorizontalOffset(var1);
      } else if(IS_AT_LEAST_JB) {
         super.setDropDownHorizontalOffset(var1);
         return;
      }

   }

   public void setDropDownVerticalOffset(int var1) {
      if(this.mPopup != null) {
         this.mPopup.setVerticalOffset(var1);
      } else if(IS_AT_LEAST_JB) {
         super.setDropDownVerticalOffset(var1);
         return;
      }

   }

   public void setDropDownWidth(int var1) {
      if(this.mPopup != null) {
         this.mDropDownWidth = var1;
      } else if(IS_AT_LEAST_JB) {
         super.setDropDownWidth(var1);
         return;
      }

   }

   public void setPopupBackgroundDrawable(Drawable var1) {
      if(this.mPopup != null) {
         this.mPopup.setBackgroundDrawable(var1);
      } else if(IS_AT_LEAST_JB) {
         super.setPopupBackgroundDrawable(var1);
         return;
      }

   }

   public void setPopupBackgroundResource(@DrawableRes int var1) {
      this.setPopupBackgroundDrawable(ContextCompat.getDrawable(this.getPopupContext(), var1));
   }

   public void setPrompt(CharSequence var1) {
      if(this.mPopup != null) {
         this.mPopup.setPromptText(var1);
      } else {
         super.setPrompt(var1);
      }
   }

   public void setSupportBackgroundTintList(@Nullable ColorStateList var1) {
      if(this.mBackgroundTintHelper != null) {
         this.mBackgroundTintHelper.setSupportBackgroundTintList(var1);
      }

   }

   public void setSupportBackgroundTintMode(@Nullable Mode var1) {
      if(this.mBackgroundTintHelper != null) {
         this.mBackgroundTintHelper.setSupportBackgroundTintMode(var1);
      }

   }
}
