package android.support.v4.content;

import android.graphics.drawable.Drawable;
import java.io.File;
import android.content.Context;

class ContextCompatApi21
{
    ContextCompatApi21() {
        super();
    }
    
    public static File getCodeCacheDir(final Context context) {
        return context.getCodeCacheDir();
    }
    
    public static Drawable getDrawable(final Context context, final int n) {
        return context.getDrawable(n);
    }
    
    public static File getNoBackupFilesDir(final Context context) {
        return context.getNoBackupFilesDir();
    }
}
