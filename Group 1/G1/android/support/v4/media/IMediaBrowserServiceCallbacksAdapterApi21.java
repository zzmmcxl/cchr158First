package android.support.v4.media;

import android.os.RemoteException;
import java.lang.reflect.InvocationTargetException;
import android.os.IBinder;
import android.os.Bundle;
import android.media.session.MediaSession$Token;
import java.lang.reflect.Method;

class IMediaBrowserServiceCallbacksAdapterApi21
{
    private Method mAsBinderMethod;
    Object mCallbackObject;
    private Method mOnConnectFailedMethod;
    private Method mOnConnectMethod;
    private Method mOnLoadChildrenMethod;
    
    IMediaBrowserServiceCallbacksAdapterApi21(final Object mCallbackObject) {
        super();
        mCallbackObject = mCallbackObject;
        try {
            final Class<?> forName = Class.forName("android.service.media.IMediaBrowserServiceCallbacks");
            final Class<?> forName2 = Class.forName("android.content.pm.ParceledListSlice");
            mAsBinderMethod = forName.getMethod("asBinder", (Class<?>[])new Class[0]);
            mOnConnectMethod = forName.getMethod("onConnect", String.class, MediaSession$Token.class, Bundle.class);
            mOnConnectFailedMethod = forName.getMethod("onConnectFailed", (Class<?>[])new Class[0]);
            mOnLoadChildrenMethod = forName.getMethod("onLoadChildren", String.class, forName2);
        }
        catch (ClassNotFoundException ex) {}
        catch (NoSuchMethodException ex2) {
            goto Label_0105;
        }
    }
    
    IBinder asBinder() {
        try {
            return (IBinder)mAsBinderMethod.invoke(mCallbackObject, new Object[0]);
        }
        catch (IllegalAccessException ex) {}
        catch (InvocationTargetException ex2) {
            goto Label_0022;
        }
    }
    
    void onConnect(final String s, final Object o, final Bundle bundle) throws RemoteException {
        try {
            mOnConnectMethod.invoke(mCallbackObject, s, o, bundle);
        }
        catch (IllegalAccessException ex) {}
        catch (InvocationTargetException ex2) {
            goto Label_0031;
        }
    }
    
    void onConnectFailed() throws RemoteException {
        try {
            mOnConnectFailedMethod.invoke(mCallbackObject, new Object[0]);
        }
        catch (IllegalAccessException ex) {}
        catch (InvocationTargetException ex2) {
            goto Label_0018;
        }
    }
    
    void onLoadChildren(final String s, final Object o) throws RemoteException {
        try {
            mOnLoadChildrenMethod.invoke(mCallbackObject, s, o);
        }
        catch (IllegalAccessException ex) {}
        catch (InvocationTargetException ex2) {
            goto Label_0026;
        }
    }
}
