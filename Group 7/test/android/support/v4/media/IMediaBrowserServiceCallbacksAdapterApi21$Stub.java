package android.support.v4.media;

import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class IMediaBrowserServiceCallbacksAdapterApi21$Stub {
   static Method sAsInterfaceMethod;

   static {
      Object var0;
      try {
         sAsInterfaceMethod = Class.forName("android.service.media.IMediaBrowserServiceCallbacks$Stub").getMethod("asInterface", new Class[]{IBinder.class});
         return;
      } catch (ClassNotFoundException var1) {
         var0 = var1;
      } catch (NoSuchMethodException var2) {
         var0 = var2;
      }

      ((ReflectiveOperationException)var0).printStackTrace();
   }

   static Object asInterface(IBinder var0) {
      Object var3;
      try {
         var3 = sAsInterfaceMethod.invoke((Object)null, new Object[]{var0});
         return var3;
      } catch (IllegalAccessException var1) {
         var3 = var1;
      } catch (InvocationTargetException var2) {
         var3 = var2;
      }

      ((ReflectiveOperationException)var3).printStackTrace();
      return null;
   }
}
