package android.support.graphics.drawable;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.util.ArrayMap;
import java.util.ArrayList;

class AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState extends ConstantState {
   ArrayList<Animator> mAnimators;
   int mChangingConfigurations;
   ArrayMap<Animator, String> mTargetNameMap;
   VectorDrawableCompat mVectorDrawable;

   public AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState(Context var1, AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState var2, Callback var3, Resources var4) {
      if(var2 != null) {
         this.mChangingConfigurations = var2.mChangingConfigurations;
         if(var2.mVectorDrawable != null) {
            ConstantState var7 = var2.mVectorDrawable.getConstantState();
            if(var4 != null) {
               this.mVectorDrawable = (VectorDrawableCompat)var7.newDrawable(var4);
            } else {
               this.mVectorDrawable = (VectorDrawableCompat)var7.newDrawable();
            }

            this.mVectorDrawable = (VectorDrawableCompat)this.mVectorDrawable.mutate();
            this.mVectorDrawable.setCallback(var3);
            this.mVectorDrawable.setBounds(var2.mVectorDrawable.getBounds());
            this.mVectorDrawable.setAllowCaching(false);
         }

         if(var2.mAnimators != null) {
            int var6 = var2.mAnimators.size();
            this.mAnimators = new ArrayList(var6);
            this.mTargetNameMap = new ArrayMap(var6);

            for(int var5 = 0; var5 < var6; ++var5) {
               Animator var9 = (Animator)var2.mAnimators.get(var5);
               Animator var8 = var9.clone();
               String var10 = (String)var2.mTargetNameMap.get(var9);
               var8.setTarget(this.mVectorDrawable.getTargetByName(var10));
               this.mAnimators.add(var8);
               this.mTargetNameMap.put(var8, var10);
            }
         }
      }

   }

   public int getChangingConfigurations() {
      return this.mChangingConfigurations;
   }

   public Drawable newDrawable() {
      throw new IllegalStateException("No constant state support for SDK < 21.");
   }

   public Drawable newDrawable(Resources var1) {
      throw new IllegalStateException("No constant state support for SDK < 21.");
   }
}
