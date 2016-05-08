package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatDrawableManager;
import java.lang.ref.WeakReference;

public class TintResources extends Resources {
   private final WeakReference<Context> mContextRef;

   public TintResources(@NonNull Context var1, @NonNull Resources var2) {
      super(var2.getAssets(), var2.getDisplayMetrics(), var2.getConfiguration());
      this.mContextRef = new WeakReference(var1);
   }

   public Drawable getDrawable(int var1) throws NotFoundException {
      Context var2 = (Context)this.mContextRef.get();
      return var2 != null?AppCompatDrawableManager.get().onDrawableLoadedFromResources(var2, this, var1):super.getDrawable(var1);
   }

   final Drawable superGetDrawable(int var1) {
      return super.getDrawable(var1);
   }
}
