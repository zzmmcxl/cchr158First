package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.support.annotation.NonNull;
import android.support.v7.widget.TintResources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class TintContextWrapper extends ContextWrapper {
   private static final ArrayList<WeakReference<TintContextWrapper>> sCache = new ArrayList();
   private Resources mResources;
   private final Theme mTheme = this.getResources().newTheme();

   private TintContextWrapper(@NonNull Context var1) {
      super(var1);
      this.mTheme.setTo(var1.getTheme());
   }

   private static boolean shouldWrap(@NonNull Context var0) {
      return !(var0 instanceof TintContextWrapper) && !(var0.getResources() instanceof TintResources);
   }

   public static Context wrap(@NonNull Context var0) {
      if(shouldWrap(var0)) {
         int var1 = 0;

         for(int var2 = sCache.size(); var1 < var2; ++var1) {
            WeakReference var3 = (WeakReference)sCache.get(var1);
            TintContextWrapper var5;
            if(var3 != null) {
               var5 = (TintContextWrapper)var3.get();
            } else {
               var5 = null;
            }

            if(var5 != null && var5.getBaseContext() == var0) {
               return var5;
            }
         }

         TintContextWrapper var4 = new TintContextWrapper(var0);
         sCache.add(new WeakReference(var4));
         return var4;
      } else {
         return var0;
      }
   }

   public Resources getResources() {
      if(this.mResources == null) {
         this.mResources = new TintResources(this, super.getResources());
      }

      return this.mResources;
   }

   public Theme getTheme() {
      return this.mTheme;
   }

   public void setTheme(int var1) {
      this.mTheme.applyStyle(var1, true);
   }
}
