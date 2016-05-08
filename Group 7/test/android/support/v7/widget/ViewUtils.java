package android.support.v7.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ViewUtils {
   private static final String TAG = "ViewUtils";
   private static Method sComputeFitSystemWindowsMethod;

   static {
      if(VERSION.SDK_INT >= 18) {
         try {
            sComputeFitSystemWindowsMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});
            if(!sComputeFitSystemWindowsMethod.isAccessible()) {
               sComputeFitSystemWindowsMethod.setAccessible(true);
            }
         } catch (NoSuchMethodException var1) {
            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
            return;
         }
      }

   }

   public static int combineMeasuredStates(int var0, int var1) {
      return var0 | var1;
   }

   public static void computeFitSystemWindows(View var0, Rect var1, Rect var2) {
      if(sComputeFitSystemWindowsMethod != null) {
         try {
            sComputeFitSystemWindowsMethod.invoke(var0, new Object[]{var1, var2});
         } catch (Exception var3) {
            Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", var3);
            return;
         }
      }

   }

   public static boolean isLayoutRtl(View var0) {
      return ViewCompat.getLayoutDirection(var0) == 1;
   }

   public static void makeOptionalFitsSystemWindows(View var0) {
      if(VERSION.SDK_INT >= 16) {
         try {
            Method var1 = var0.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
            if(!var1.isAccessible()) {
               var1.setAccessible(true);
            }

            var1.invoke(var0, new Object[0]);
         } catch (NoSuchMethodException var2) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
            return;
         } catch (InvocationTargetException var3) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", var3);
            return;
         } catch (IllegalAccessException var4) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", var4);
            return;
         }
      }

   }
}
