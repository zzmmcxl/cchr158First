package android.support.v7.widget;

import android.util.Log;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.content.res.Resources$Theme;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import android.support.annotation.NonNull;
import android.content.Context;

private static class AvdcInflateDelegate implements InflateDelegate
{
    private AvdcInflateDelegate() {
        super();
    }
    
    AvdcInflateDelegate(final AppCompatDrawableManager$1 object) {
        this();
    }
    
    @Override
    public Drawable createFromXmlInner(@NonNull final Context context, @NonNull final XmlPullParser xmlPullParser, @NonNull final AttributeSet set, @Nullable final Resources$Theme resources$Theme) {
        try {
            return AnimatedVectorDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, set, resources$Theme);
        }
        catch (Exception ex) {
            Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", (Throwable)ex);
            return null;
        }
    }
}
