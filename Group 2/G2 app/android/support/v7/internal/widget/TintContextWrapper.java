package android.support.v7.internal.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.ResourcesWrapper;
import android.support.v7.internal.widget.TintManager;

public class TintContextWrapper extends ContextWrapper {
   private Resources mResources;

   private TintContextWrapper(Context var1) {
      super(var1);
   }

   public static Context wrap(Context var0) {
      Object var1 = var0;
      if(!(var0 instanceof TintContextWrapper)) {
         var1 = new TintContextWrapper(var0);
      }

      return (Context)var1;
   }

   public Resources getResources() {
      if(this.mResources == null) {
         this.mResources = new TintContextWrapper.TintResources(super.getResources(), TintManager.get(this));
      }

      return this.mResources;
   }

   static class TintResources extends ResourcesWrapper {
      private final TintManager mTintManager;

      public TintResources(Resources var1, TintManager var2) {
         super(var1);
         this.mTintManager = var2;
      }

      public Drawable getDrawable(int var1) throws NotFoundException {
         Drawable var2 = super.getDrawable(var1);
         if(var2 != null) {
            this.mTintManager.tintDrawableUsingColorFilter(var1, var2);
         }

         return var2;
      }
   }
}
