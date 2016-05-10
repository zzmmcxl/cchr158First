package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.view.TintableBackgroundView;
import android.support.v7.appcompat.R;
import android.support.v7.internal.widget.TintInfo;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.util.AttributeSet;
import android.widget.Spinner;
import java.lang.reflect.Field;

public class AppCompatSpinner extends Spinner implements TintableBackgroundView {
   private static final int[] TINT_ATTRS = new int[]{16842964, 16843126};
   private TintInfo mBackgroundTint;
   private TintInfo mInternalBackgroundTint;
   private TintManager mTintManager;

   public AppCompatSpinner(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public AppCompatSpinner(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.spinnerStyle);
   }

   public AppCompatSpinner(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      if(TintManager.SHOULD_BE_USED) {
         TintTypedArray var4 = TintTypedArray.obtainStyledAttributes(this.getContext(), var2, TINT_ATTRS, var3, 0);
         if(var4.hasValue(0)) {
            ColorStateList var5 = var4.getTintManager().getTintList(var4.getResourceId(0, -1));
            if(var5 != null) {
               this.setInternalBackgroundTint(var5);
            }
         }

         if(var4.hasValue(1)) {
            Drawable var6 = var4.getDrawable(1);
            if(VERSION.SDK_INT >= 16) {
               this.setPopupBackgroundDrawable(var6);
            } else if(VERSION.SDK_INT >= 11) {
               setPopupBackgroundDrawableV11(this, var6);
            }
         }

         this.mTintManager = var4.getTintManager();
         var4.recycle();
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

   @TargetApi(11)
   private static void setPopupBackgroundDrawableV11(Spinner var0, Drawable var1) {
      try {
         Field var2 = Spinner.class.getDeclaredField("mPopup");
         var2.setAccessible(true);
         Object var5 = var2.get(var0);
         if(var5 instanceof android.widget.ListPopupWindow) {
            ((android.widget.ListPopupWindow)var5).setBackgroundDrawable(var1);
         }

      } catch (NoSuchFieldException var3) {
         var3.printStackTrace();
      } catch (IllegalAccessException var4) {
         var4.printStackTrace();
      }
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
}
