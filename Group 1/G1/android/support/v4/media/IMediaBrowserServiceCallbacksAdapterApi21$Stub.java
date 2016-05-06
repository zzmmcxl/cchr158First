package android.support.v4.media;

import java.lang.reflect.InvocationTargetException;
import android.os.IBinder;
import java.lang.reflect.Method;

static class Stub
{
    static Method sAsInterfaceMethod;
    
    static {
        try {
            sAsInterfaceMethod = Class.forName("android.service.media.IMediaBrowserServiceCallbacks$Stub").getMethod("asInterface", IBinder.class);
        }
        catch (ClassNotFoundException ex) {}
        catch (NoSuchMethodException ex2) {
            goto Label_0024;
        }
    }
    
    Stub() {
        super();
    }
    
    static Object asInterface(final IBinder binder) {
        try {
            return sAsInterfaceMethod.invoke(null, binder);
        }
        catch (IllegalAccessException ex) {}
        catch (InvocationTargetException ex2) {
            goto Label_0019;
        }
    }
}
