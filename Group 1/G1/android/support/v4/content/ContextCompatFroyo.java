package android.support.v4.content;

import java.io.File;
import android.content.Context;

class ContextCompatFroyo
{
    ContextCompatFroyo() {
        super();
    }
    
    public static File getExternalCacheDir(final Context context) {
        return context.getExternalCacheDir();
    }
    
    public static File getExternalFilesDir(final Context context, final String s) {
        return context.getExternalFilesDir(s);
    }
}
