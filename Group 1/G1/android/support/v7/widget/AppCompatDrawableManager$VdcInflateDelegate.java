package android.support.v7.widget;

import android.util.Log;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.content.res.Resources$Theme;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import android.support.annotation.NonNull;
import android.content.Context;

private static class VdcInflateDelegate implements InflateDelegate
{
    private VdcInflateDelegate() {
        super();
    }
    
    VdcInflateDelegate(final AppCompatDrawableManager$1 object) {
        this();
    }
    
    @Override
    public Drawable createFromXmlInner(@NonNull final Context context, @NonNull final XmlPullParser xmlPullParser, @NonNull final AttributeSet set, @Nullable final Resources$Theme resources$Theme) {
        try {
            return VectorDrawableCompat.createFromXmlInner(context.getResources(), xmlPullParser, set, resources$Theme);
        }
        catch (Exception ex) {
            Log.e("VdcInflateDelegate", "Exception while inflating <vector>", (Throwable)ex);
            return null;
        }
    }
}
