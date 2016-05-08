package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R$attr;
import android.support.v7.appcompat.R$styleable;
import android.support.v7.text.AllCapsTransformationMethod;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.AppCompatTextHelperV17;
import android.support.v7.widget.TintInfo;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

class AppCompatTextHelper {
   private static final int[] TEXT_APPEARANCE_ATTRS;
   private static final int[] VIEW_ATTRS = new int[]{16842804, 16843119, 16843117, 16843120, 16843118};
   private TintInfo mDrawableBottomTint;
   private TintInfo mDrawableLeftTint;
   private TintInfo mDrawableRightTint;
   private TintInfo mDrawableTopTint;
   final TextView mView;

   static {
      TEXT_APPEARANCE_ATTRS = new int[]{R$attr.textAllCaps};
   }

   AppCompatTextHelper(TextView var1) {
      this.mView = var1;
   }

   static AppCompatTextHelper create(TextView var0) {
      return (AppCompatTextHelper)(VERSION.SDK_INT >= 17?new AppCompatTextHelperV17(var0):new AppCompatTextHelper(var0));
   }

   protected static TintInfo createTintInfo(Context var0, AppCompatDrawableManager var1, int var2) {
      ColorStateList var3 = var1.getTintList(var0, var2);
      if(var3 != null) {
         TintInfo var4 = new TintInfo();
         var4.mHasTintList = true;
         var4.mTintList = var3;
         return var4;
      } else {
         return null;
      }
   }

   final void applyCompoundDrawableTint(Drawable var1, TintInfo var2) {
      if(var1 != null && var2 != null) {
         AppCompatDrawableManager.tintDrawable(var1, var2, this.mView.getDrawableState());
      }

   }

   void applyCompoundDrawablesTints() {
      if(this.mDrawableLeftTint != null || this.mDrawableTopTint != null || this.mDrawableRightTint != null || this.mDrawableBottomTint != null) {
         Drawable[] var1 = this.mView.getCompoundDrawables();
         this.applyCompoundDrawableTint(var1[0], this.mDrawableLeftTint);
         this.applyCompoundDrawableTint(var1[1], this.mDrawableTopTint);
         this.applyCompoundDrawableTint(var1[2], this.mDrawableRightTint);
         this.applyCompoundDrawableTint(var1[3], this.mDrawableBottomTint);
      }

   }

   void loadFromAttributes(AttributeSet var1, int var2) {
      Context var8 = this.mView.getContext();
      AppCompatDrawableManager var9 = AppCompatDrawableManager.get();
      TypedArray var10 = var8.obtainStyledAttributes(var1, VIEW_ATTRS, var2, 0);
      int var5 = var10.getResourceId(0, -1);
      if(var10.hasValue(1)) {
         this.mDrawableLeftTint = createTintInfo(var8, var9, var10.getResourceId(1, 0));
      }

      if(var10.hasValue(2)) {
         this.mDrawableTopTint = createTintInfo(var8, var9, var10.getResourceId(2, 0));
      }

      if(var10.hasValue(3)) {
         this.mDrawableRightTint = createTintInfo(var8, var9, var10.getResourceId(3, 0));
      }

      if(var10.hasValue(4)) {
         this.mDrawableBottomTint = createTintInfo(var8, var9, var10.getResourceId(4, 0));
      }

      var10.recycle();
      if(!(this.mView.getTransformationMethod() instanceof PasswordTransformationMethod)) {
         boolean var6 = false;
         boolean var7 = false;
         boolean var3 = false;
         boolean var4 = false;
         if(var5 != -1) {
            TypedArray var12 = var8.obtainStyledAttributes(var5, R$styleable.TextAppearance);
            var6 = var7;
            var3 = var4;
            if(var12.hasValue(R$styleable.TextAppearance_textAllCaps)) {
               var3 = true;
               var6 = var12.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
            }

            var12.recycle();
         }

         TypedArray var11 = var8.obtainStyledAttributes(var1, TEXT_APPEARANCE_ATTRS, var2, 0);
         if(var11.hasValue(0)) {
            var3 = true;
            var6 = var11.getBoolean(0, false);
         }

         var11.recycle();
         if(var3) {
            this.setAllCaps(var6);
         }
      }

   }

   void onSetTextAppearance(Context var1, int var2) {
      TypedArray var3 = var1.obtainStyledAttributes(var2, TEXT_APPEARANCE_ATTRS);
      if(var3.getBoolean(0, false)) {
         this.setAllCaps(true);
      }

      var3.recycle();
   }

   void setAllCaps(boolean var1) {
      TextView var3 = this.mView;
      AllCapsTransformationMethod var2;
      if(var1) {
         var2 = new AllCapsTransformationMethod(this.mView.getContext());
      } else {
         var2 = null;
      }

      var3.setTransformationMethod(var2);
   }
}
