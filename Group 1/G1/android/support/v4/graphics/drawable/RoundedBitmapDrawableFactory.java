package android.support.v4.graphics.drawable;

import android.support.v4.graphics.BitmapCompat;
import android.support.v4.view.GravityCompat;
import android.graphics.Rect;
import android.util.Log;
import android.graphics.BitmapFactory;
import java.io.InputStream;
import android.os.Build$VERSION;
import android.graphics.Bitmap;
import android.content.res.Resources;

public final class RoundedBitmapDrawableFactory
{
    private static final String TAG = "RoundedBitmapDrawableFactory";
    
    private RoundedBitmapDrawableFactory() {
        super();
    }
    
    public static RoundedBitmapDrawable create(final Resources resources, final Bitmap bitmap) {
        if (Build$VERSION.SDK_INT >= 21) {
            return new RoundedBitmapDrawable21(resources, bitmap);
        }
        return new DefaultRoundedBitmapDrawable(resources, bitmap);
    }
    
    public static RoundedBitmapDrawable create(final Resources resources, final InputStream inputStream) {
        final RoundedBitmapDrawable create = create(resources, BitmapFactory.decodeStream(inputStream));
        if (create.getBitmap() == null) {
            Log.w("RoundedBitmapDrawableFactory", "RoundedBitmapDrawable cannot decode " + inputStream);
        }
        return create;
    }
    
    public static RoundedBitmapDrawable create(final Resources resources, final String s) {
        final RoundedBitmapDrawable create = create(resources, BitmapFactory.decodeFile(s));
        if (create.getBitmap() == null) {
            Log.w("RoundedBitmapDrawableFactory", "RoundedBitmapDrawable cannot decode " + s);
        }
        return create;
    }
}
