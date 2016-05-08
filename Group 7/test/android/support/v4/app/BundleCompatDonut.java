package android.support.v4.app;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class BundleCompatDonut {
   private static final String TAG = "BundleCompatDonut";
   private static Method sGetIBinderMethod;
   private static boolean sGetIBinderMethodFetched;
   private static Method sPutIBinderMethod;
   private static boolean sPutIBinderMethodFetched;

   public static IBinder getBinder(Bundle var0, String var1) {
      if(!sGetIBinderMethodFetched) {
         try {
            sGetIBinderMethod = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
            sGetIBinderMethod.setAccessible(true);
         } catch (NoSuchMethodException var6) {
            Log.i("BundleCompatDonut", "Failed to retrieve getIBinder method", var6);
         }

         sGetIBinderMethodFetched = true;
      }

      if(sGetIBinderMethod != null) {
         Object var7;
         try {
            IBinder var8 = (IBinder)sGetIBinderMethod.invoke(var0, new Object[]{var1});
            return var8;
         } catch (InvocationTargetException var3) {
            var7 = var3;
         } catch (IllegalAccessException var4) {
            var7 = var4;
         } catch (IllegalArgumentException var5) {
            var7 = var5;
         }

         Log.i("BundleCompatDonut", "Failed to invoke getIBinder via reflection", (Throwable)var7);
         sGetIBinderMethod = null;
      }

      return null;
   }

   public static void putBinder(Bundle var0, String var1, IBinder var2) {
      if(!sPutIBinderMethodFetched) {
         try {
            sPutIBinderMethod = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
            sPutIBinderMethod.setAccessible(true);
         } catch (NoSuchMethodException var4) {
            Log.i("BundleCompatDonut", "Failed to retrieve putIBinder method", var4);
         }

         sPutIBinderMethodFetched = true;
      }

      if(sPutIBinderMethod != null) {
         Object var8;
         try {
            sPutIBinderMethod.invoke(var0, new Object[]{var1, var2});
            return;
         } catch (InvocationTargetException var5) {
            var8 = var5;
         } catch (IllegalAccessException var6) {
            var8 = var6;
         } catch (IllegalArgumentException var7) {
            var8 = var7;
         }

         Log.i("BundleCompatDonut", "Failed to invoke putIBinder via reflection", (Throwable)var8);
         sPutIBinderMethod = null;
      }
   }
}
