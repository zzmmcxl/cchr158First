package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.content.Context;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import android.content.ContextWrapper;

public class TintContextWrapper extends ContextWrapper
{
    private static final ArrayList<WeakReference<TintContextWrapper>> sCache;
    private Resources mResources;
    private final Resources$Theme mTheme;
    
    static {
        sCache = new ArrayList<WeakReference<TintContextWrapper>>();
    }
    
    private TintContextWrapper(@NonNull final Context context) {
        super(context);
        (mTheme = this.getResources().newTheme()).setTo(context.getTheme());
    }
    
    private static boolean shouldWrap(@NonNull final Context context) {
        return !(context instanceof TintContextWrapper) && !(context.getResources() instanceof TintResources);
    }
    
    public static Context wrap(@NonNull final Context context) {
        if (shouldWrap(context)) {
            for (int i = 0; i < sCache.size(); ++i) {
                final WeakReference<TintContextWrapper> weakReference = (WeakReference<TintContextWrapper>)sCache.get(i);
                TintContextWrapper tintContextWrapper;
                if (weakReference != null) {
                    tintContextWrapper = weakReference.get();
                }
                else {
                    tintContextWrapper = null;
                }
                if (tintContextWrapper != null && tintContextWrapper.getBaseContext() == context) {
                    return (Context)tintContextWrapper;
                }
            }
            final TintContextWrapper tintContextWrapper2 = new TintContextWrapper(context);
            sCache.add(new WeakReference<TintContextWrapper>(tintContextWrapper2));
            return (Context)tintContextWrapper2;
        }
        return context;
    }
    
    public Resources getResources() {
        if (mResources == null) {
            mResources = new TintResources((Context)this, super.getResources());
        }
        return mResources;
    }
    
    public Resources$Theme getTheme() {
        return mTheme;
    }
    
    public void setTheme(final int n) {
        mTheme.applyStyle(n, true);
    }
}
