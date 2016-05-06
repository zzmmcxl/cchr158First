package android.support.v4.graphics.drawable;

import android.graphics.PorterDuff$Mode;
import android.support.annotation.Nullable;
import android.content.res.ColorStateList;
import android.support.annotation.ColorInt;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.support.annotation.NonNull;
import android.content.res.Resources$Theme;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;

public final class DrawableCompat
{
    static final DrawableImpl IMPL;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 23) {
            IMPL = (DrawableImpl)new MDrawableImpl();
            return;
        }
        if (sdk_INT >= 21) {
            IMPL = (DrawableImpl)new LollipopDrawableImpl();
            return;
        }
        if (sdk_INT >= 19) {
            IMPL = (DrawableImpl)new KitKatDrawableImpl();
            return;
        }
        if (sdk_INT >= 17) {
            IMPL = (DrawableImpl)new JellybeanMr1DrawableImpl();
            return;
        }
        if (sdk_INT >= 11) {
            IMPL = (DrawableImpl)new HoneycombDrawableImpl();
            return;
        }
        if (sdk_INT >= 5) {
            IMPL = (DrawableImpl)new EclairDrawableImpl();
            return;
        }
        IMPL = (DrawableImpl)new BaseDrawableImpl();
    }
    
    private DrawableCompat() {
        super();
    }
    
    public static void applyTheme(final Drawable drawable, final Resources$Theme resources$Theme) {
        IMPL.applyTheme(drawable, resources$Theme);
    }
    
    public static boolean canApplyTheme(final Drawable drawable) {
        return IMPL.canApplyTheme(drawable);
    }
    
    public static int getAlpha(@NonNull final Drawable drawable) {
        return IMPL.getAlpha(drawable);
    }
    
    public static ColorFilter getColorFilter(final Drawable drawable) {
        return IMPL.getColorFilter(drawable);
    }
    
    public static int getLayoutDirection(@NonNull final Drawable drawable) {
        return IMPL.getLayoutDirection(drawable);
    }
    
    public static void inflate(final Drawable drawable, final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set, final Resources$Theme resources$Theme) throws XmlPullParserException, IOException {
        IMPL.inflate(drawable, resources, xmlPullParser, set, resources$Theme);
    }
    
    public static boolean isAutoMirrored(@NonNull final Drawable drawable) {
        return IMPL.isAutoMirrored(drawable);
    }
    
    public static void jumpToCurrentState(@NonNull final Drawable drawable) {
        IMPL.jumpToCurrentState(drawable);
    }
    
    public static void setAutoMirrored(@NonNull final Drawable drawable, final boolean b) {
        IMPL.setAutoMirrored(drawable, b);
    }
    
    public static void setHotspot(@NonNull final Drawable drawable, final float n, final float n2) {
        IMPL.setHotspot(drawable, n, n2);
    }
    
    public static void setHotspotBounds(@NonNull final Drawable drawable, final int n, final int n2, final int n3, final int n4) {
        IMPL.setHotspotBounds(drawable, n, n2, n3, n4);
    }
    
    public static void setLayoutDirection(@NonNull final Drawable drawable, final int n) {
        IMPL.setLayoutDirection(drawable, n);
    }
    
    public static void setTint(@NonNull final Drawable drawable, @ColorInt final int n) {
        IMPL.setTint(drawable, n);
    }
    
    public static void setTintList(@NonNull final Drawable drawable, @Nullable final ColorStateList list) {
        IMPL.setTintList(drawable, list);
    }
    
    public static void setTintMode(@NonNull final Drawable drawable, @Nullable final PorterDuff$Mode porterDuff$Mode) {
        IMPL.setTintMode(drawable, porterDuff$Mode);
    }
    
    public static <T extends Drawable> T unwrap(@NonNull Drawable wrappedDrawable) {
        if (wrappedDrawable instanceof DrawableWrapper) {
            wrappedDrawable = ((DrawableWrapper)wrappedDrawable).getWrappedDrawable();
        }
        return (T)wrappedDrawable;
    }
    
    public static Drawable wrap(@NonNull final Drawable drawable) {
        return IMPL.wrap(drawable);
    }
}
