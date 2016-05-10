package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.view.TintableBackgroundView;
import android.support.v7.appcompat.R;
import android.support.v7.internal.text.AllCapsTransformationMethod;
import android.support.v7.internal.widget.ThemeUtils;
import android.support.v7.internal.widget.TintInfo;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

public class AppCompatButton extends Button implements TintableBackgroundView {
   private static final int[] TINT_ATTRS = new int[]{16842964};
   private TintInfo mBackgroundTint;
   private TintInfo mInternalBackgroundTint;
   private TintManager mTintManager;

   public AppCompatButton(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public AppCompatButton(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.buttonStyle);
   }

   public AppCompatButton(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      if(TintManager.SHOULD_BE_USED) {
         TintTypedArray var5 = TintTypedArray.obtainStyledAttributes(this.getContext(), var2, TINT_ATTRS, var3, 0);
         if(var5.hasValue(0)) {
            ColorStateList var6 = var5.getTintManager().getTintList(var5.getResourceId(0, -1));
            if(var6 != null) {
               this.setInternalBackgroundTint(var6);
            }
         }

         this.mTintManager = var5.getTintManager();
         var5.recycle();
      }

      TypedArray var9 = var1.obtainStyledAttributes(var2, R.styleable.AppCompatTextView, var3, 0);
      int var4 = var9.getResourceId(R.styleable.AppCompatTextView_android_textAppearance, -1);
      var9.recycle();
      if(var4 != -1) {
         var9 = var1.obtainStyledAttributes(var4, R.styleable.TextAppearance);
         if(var9.hasValue(R.styleable.TextAppearance_textAllCaps)) {
            this.setAllCaps(var9.getBoolean(R.styleable.TextAppearance_textAllCaps, false));
         }

         var9.recycle();
      }

      TypedArray var7 = var1.obtainStyledAttributes(var2, R.styleable.AppCompatTextView, var3, 0);
      if(var7.hasValue(R.styleable.AppCompatTextView_textAllCaps)) {
         this.setAllCaps(var7.getBoolean(R.styleable.AppCompatTextView_textAllCaps, false));
      }

      var7.recycle();
      ColorStateList var8 = this.getTextColors();
      if(var8 != null && !var8.isStateful()) {
         if(VERSION.SDK_INT < 21) {
            var3 = ThemeUtils.getDisabledThemeAttrColor(var1, 16842808);
         } else {
            var3 = ThemeUtils.getThemeAttrColor(var1, 16842808);
         }

         this.setTextColor(ThemeUtils.createDisabledStateList(var8.getDefaultColor(), var3));
      }

   }

   private void applySupportBackgroundTint() {
      if(this.getBackground() != null) {
         if(this.mBackgroundTint != null) {
            TintManager.tintViewBackground(this, this.mBackgroundTint);
         } else if(this.mInternalBackgroundTint != null) {
            TintManager.tintViewBackground(this, this.mInternalBackgroundTint);
            return;
         }
      }

   }

   private void setInternalBackgroundTint(ColorStateList var1) {
      if(var1 != null) {
         if(this.mInternalBackgroundTint == null) {
            this.mInternalBackgroundTint = new TintInfo();
         }

         this.mInternalBackgroundTint.mTintList = var1;
         this.mInternalBackgroundTint.mHasTintList = true;
      } else {
         this.mInternalBackgroundTint = null;
      }

      this.applySupportBackgroundTint();
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      this.applySupportBackgroundTint();
   }

   @Nullable
   public ColorStateList getSupportBackgroundTintList() {
      return this.mBackgroundTint != null?this.mBackgroundTint.mTintList:null;
   }

   @Nullable
   public Mode getSupportBackgroundTintMode() {
      return this.mBackgroundTint != null?this.mBackgroundTint.mTintMode:null;
   }

   public void onInitializeAccessibilityEvent(AccessibilityEvent var1) {
      super.onInitializeAccessibilityEvent(var1);
      var1.setClassName(Button.class.getName());
   }

   public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo var1) {
      super.onInitializeAccessibilityNodeInfo(var1);
      var1.setClassName(Button.class.getName());
   }

   public void setAllCaps(boolean var1) {
      AllCapsTransformationMethod var2;
      if(var1) {
         var2 = new AllCapsTransformationMethod(this.getContext());
      } else {
         var2 = null;
      }

      this.setTransformationMethod(var2);
   }

   public void setBackgroundDrawable(Drawable var1) {
      super.setBackgroundDrawable(var1);
      this.setInternalBackgroundTint((ColorStateList)null);
   }

   public void setBackgroundResource(int var1) {
      super.setBackgroundResource(var1);
      ColorStateList var2;
      if(this.mTintManager != null) {
         var2 = this.mTintManager.getTintList(var1);
      } else {
         var2 = null;
      }

      this.setInternalBackgroundTint(var2);
   }

   public void setSupportBackgroundTintList(@Nullable ColorStateList var1) {
      if(this.mBackgroundTint == null) {
         this.mBackgroundTint = new TintInfo();
      }

      this.mBackgroundTint.mTintList = var1;
      this.mBackgroundTint.mHasTintList = true;
      this.applySupportBackgroundTint();
   }

   public void setSupportBackgroundTintMode(@Nullable Mode var1) {
      if(this.mBackgroundTint == null) {
         this.mBackgroundTint = new TintInfo();
      }

      this.mBackgroundTint.mTintMode = var1;
      this.mBackgroundTint.mHasTintMode = true;
      this.applySupportBackgroundTint();
   }

   public void setTextAppearance(Context var1, int var2) {
      super.setTextAppearance(var1, var2);
      TypedArray var3 = var1.obtainStyledAttributes(var2, R.styleable.TextAppearance);
      if(var3.hasValue(R.styleable.TextAppearance_textAllCaps)) {
         this.setAllCaps(var3.getBoolean(R.styleable.TextAppearance_textAllCaps, false));
      }

      var3.recycle();
   }
}
