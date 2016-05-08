package android.support.v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

class PopupWindowCompatGingerbread {
   private static Method sGetWindowLayoutTypeMethod;
   private static boolean sGetWindowLayoutTypeMethodAttempted;
   private static Method sSetWindowLayoutTypeMethod;
   private static boolean sSetWindowLayoutTypeMethodAttempted;

   static int getWindowLayoutType(PopupWindow var0) {
      if(!sGetWindowLayoutTypeMethodAttempted) {
         try {
            sGetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new Class[0]);
            sGetWindowLayoutTypeMethod.setAccessible(true);
         } catch (Exception var3) {
            ;
         }

         sGetWindowLayoutTypeMethodAttempted = true;
      }

      if(sGetWindowLayoutTypeMethod != null) {
         try {
            int var1 = ((Integer)sGetWindowLayoutTypeMethod.invoke(var0, new Object[0])).intValue();
            return var1;
         } catch (Exception var4) {
            ;
         }
      }

      return 0;
   }

   static void setWindowLayoutType(PopupWindow var0, int var1) {
      if(!sSetWindowLayoutTypeMethodAttempted) {
         try {
            sSetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
            sSetWindowLayoutTypeMethod.setAccessible(true);
         } catch (Exception var4) {
            ;
         }

         sSetWindowLayoutTypeMethodAttempted = true;
      }

      if(sSetWindowLayoutTypeMethod != null) {
         try {
            sSetWindowLayoutTypeMethod.invoke(var0, new Object[]{Integer.valueOf(var1)});
         } catch (Exception var3) {
            return;
         }
      }

   }
}
