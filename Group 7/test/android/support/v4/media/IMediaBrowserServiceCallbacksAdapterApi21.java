package android.support.v4.media;

import android.media.session.MediaSession.Token;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class IMediaBrowserServiceCallbacksAdapterApi21 {
   private Method mAsBinderMethod;
   Object mCallbackObject;
   private Method mOnConnectFailedMethod;
   private Method mOnConnectMethod;
   private Method mOnLoadChildrenMethod;

   IMediaBrowserServiceCallbacksAdapterApi21(Object var1) {
      this.mCallbackObject = var1;

      try {
         Class var5 = Class.forName("android.service.media.IMediaBrowserServiceCallbacks");
         Class var2 = Class.forName("android.content.pm.ParceledListSlice");
         this.mAsBinderMethod = var5.getMethod("asBinder", new Class[0]);
         this.mOnConnectMethod = var5.getMethod("onConnect", new Class[]{String.class, Token.class, Bundle.class});
         this.mOnConnectFailedMethod = var5.getMethod("onConnectFailed", new Class[0]);
         this.mOnLoadChildrenMethod = var5.getMethod("onLoadChildren", new Class[]{String.class, var2});
         return;
      } catch (ClassNotFoundException var3) {
         var1 = var3;
      } catch (NoSuchMethodException var4) {
         var1 = var4;
      }

      ((ReflectiveOperationException)var1).printStackTrace();
   }

   IBinder asBinder() {
      Object var1;
      try {
         IBinder var4 = (IBinder)this.mAsBinderMethod.invoke(this.mCallbackObject, new Object[0]);
         return var4;
      } catch (IllegalAccessException var2) {
         var1 = var2;
      } catch (InvocationTargetException var3) {
         var1 = var3;
      }

      ((ReflectiveOperationException)var1).printStackTrace();
      return null;
   }

   void onConnect(String var1, Object var2, Bundle var3) throws RemoteException {
      Object var6;
      try {
         this.mOnConnectMethod.invoke(this.mCallbackObject, new Object[]{var1, var2, var3});
         return;
      } catch (IllegalAccessException var4) {
         var6 = var4;
      } catch (InvocationTargetException var5) {
         var6 = var5;
      }

      ((ReflectiveOperationException)var6).printStackTrace();
   }

   void onConnectFailed() throws RemoteException {
      Object var1;
      try {
         this.mOnConnectFailedMethod.invoke(this.mCallbackObject, new Object[0]);
         return;
      } catch (IllegalAccessException var2) {
         var1 = var2;
      } catch (InvocationTargetException var3) {
         var1 = var3;
      }

      ((ReflectiveOperationException)var1).printStackTrace();
   }

   void onLoadChildren(String var1, Object var2) throws RemoteException {
      Object var5;
      try {
         this.mOnLoadChildrenMethod.invoke(this.mCallbackObject, new Object[]{var1, var2});
         return;
      } catch (IllegalAccessException var3) {
         var5 = var3;
      } catch (InvocationTargetException var4) {
         var5 = var4;
      }

      ((ReflectiveOperationException)var5).printStackTrace();
   }
}
