package android.support.v4.media;

import java.lang.reflect.InvocationTargetException;
import android.media.browse.MediaBrowser$MediaItem;
import java.util.List;
import java.lang.reflect.Constructor;

class ParceledListSliceAdapterApi21
{
    private static Constructor sConstructor;
    
    static {
        try {
            sConstructor = Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class);
        }
        catch (ClassNotFoundException ex) {}
        catch (NoSuchMethodException ex2) {
            goto Label_0022;
        }
    }
    
    ParceledListSliceAdapterApi21() {
        super();
    }
    
    static Object newInstance(final List<MediaBrowser$MediaItem> list) {
        try {
            return sConstructor.newInstance(list);
        }
        catch (InstantiationException ex) {}
        catch (IllegalAccessException ex2) {
            goto Label_0018;
        }
        catch (InvocationTargetException ex2) {
            goto Label_0018;
        }
    }
}
