package android.support.v4.graphics.drawable;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import android.content.res.Resources$Theme;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class DrawableCompatBase
{
    DrawableCompatBase() {
        super();
    }
    
    public static void inflate(final Drawable drawable, final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set, final Resources$Theme resources$Theme) throws IOException, XmlPullParserException {
        drawable.inflate(resources, xmlPullParser, set);
    }
    
    public static void setTint(final Drawable drawable, final int compatTint) {
        if (drawable instanceof DrawableWrapper) {
            ((DrawableWrapper)drawable).setCompatTint(compatTint);
        }
    }
    
    public static void setTintList(final Drawable drawable, final ColorStateList compatTintList) {
        if (drawable instanceof DrawableWrapper) {
            ((DrawableWrapper)drawable).setCompatTintList(compatTintList);
        }
    }
    
    public static void setTintMode(final Drawable drawable, final PorterDuff$Mode compatTintMode) {
        if (drawable instanceof DrawableWrapper) {
            ((DrawableWrapper)drawable).setCompatTintMode(compatTintMode);
        }
    }
    
    public static Drawable wrapForTinting(Drawable drawable) {
        if (!(drawable instanceof DrawableWrapperDonut)) {
            drawable = new DrawableWrapperDonut(drawable);
        }
        return drawable;
    }
}
