package android.support.v4.content;

import java.io.File;
import android.content.Context;

class ContextCompatKitKat
{
    ContextCompatKitKat() {
        super();
    }
    
    public static File[] getExternalCacheDirs(final Context context) {
        return context.getExternalCacheDirs();
    }
    
    public static File[] getExternalFilesDirs(final Context context, final String s) {
        return context.getExternalFilesDirs(s);
    }
    
    public static File[] getObbDirs(final Context context) {
        return context.getObbDirs();
    }
}
