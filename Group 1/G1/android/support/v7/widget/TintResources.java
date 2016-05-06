package android.support.v7.widget;

import android.content.res.Resources$NotFoundException;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.content.Context;
import java.lang.ref.WeakReference;
import android.content.res.Resources;

public class TintResources extends Resources
{
    private final WeakReference<Context> mContextRef;
    
    public TintResources(@NonNull final Context context, @NonNull final Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        mContextRef = new WeakReference<Context>(context);
    }
    
    public Drawable getDrawable(final int n) throws Resources$NotFoundException {
        final Context context = (Context)mContextRef.get();
        if (context != null) {
            return AppCompatDrawableManager.get().onDrawableLoadedFromResources(context, this, n);
        }
        return super.getDrawable(n);
    }
    
    final Drawable superGetDrawable(final int n) {
        return super.getDrawable(n);
    }
}
