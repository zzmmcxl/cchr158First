package com.example.reforceapk;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class RefInvoke {
   public static Object getFieldOjbect(String var0, Object var1, String var2) {
      try {
         Field var8 = Class.forName(var0).getDeclaredField(var2);
         var8.setAccessible(true);
         Object var9 = var8.get(var1);
         return var9;
      } catch (SecurityException var3) {
         var3.printStackTrace();
      } catch (NoSuchFieldException var4) {
         var4.printStackTrace();
      } catch (IllegalArgumentException var5) {
         var5.printStackTrace();
      } catch (IllegalAccessException var6) {
         var6.printStackTrace();
      } catch (ClassNotFoundException var7) {
         var7.printStackTrace();
      }

      return null;
   }

   public static Object getStaticFieldOjbect(String var0, String var1) {
      try {
         Field var7 = Class.forName(var0).getDeclaredField(var1);
         var7.setAccessible(true);
         Object var8 = var7.get((Object)null);
         return var8;
      } catch (SecurityException var2) {
         var2.printStackTrace();
         return null;
      } catch (NoSuchFieldException var3) {
         var3.printStackTrace();
         return null;
      } catch (IllegalArgumentException var4) {
         var4.printStackTrace();
         return null;
      } catch (IllegalAccessException var5) {
         var5.printStackTrace();
         return null;
      } catch (ClassNotFoundException var6) {
         var6.printStackTrace();
         return null;
      }
   }

   public static Object invokeMethod(String var0, String var1, Object var2, Class[] var3, Object[] var4) {
      try {
         Object var11 = Class.forName(var0).getMethod(var1, var3).invoke(var2, var4);
         return var11;
      } catch (SecurityException var5) {
         var5.printStackTrace();
      } catch (IllegalArgumentException var6) {
         var6.printStackTrace();
      } catch (IllegalAccessException var7) {
         var7.printStackTrace();
      } catch (NoSuchMethodException var8) {
         var8.printStackTrace();
      } catch (InvocationTargetException var9) {
         var9.printStackTrace();
      } catch (ClassNotFoundException var10) {
         var10.printStackTrace();
      }

      return null;
   }

   public static Object invokeStaticMethod(String var0, String var1, Class[] var2, Object[] var3) {
      try {
         Object var10 = Class.forName(var0).getMethod(var1, var2).invoke((Object)null, var3);
         return var10;
      } catch (SecurityException var4) {
         var4.printStackTrace();
         return null;
      } catch (IllegalArgumentException var5) {
         var5.printStackTrace();
         return null;
      } catch (IllegalAccessException var6) {
         var6.printStackTrace();
         return null;
      } catch (NoSuchMethodException var7) {
         var7.printStackTrace();
         return null;
      } catch (InvocationTargetException var8) {
         var8.printStackTrace();
         return null;
      } catch (ClassNotFoundException var9) {
         var9.printStackTrace();
         return null;
      }
   }

   public static void setFieldOjbect(String var0, String var1, Object var2, Object var3) {
      try {
         Field var9 = Class.forName(var0).getDeclaredField(var1);
         var9.setAccessible(true);
         var9.set(var2, var3);
      } catch (SecurityException var4) {
         var4.printStackTrace();
      } catch (NoSuchFieldException var5) {
         var5.printStackTrace();
      } catch (IllegalArgumentException var6) {
         var6.printStackTrace();
      } catch (IllegalAccessException var7) {
         var7.printStackTrace();
      } catch (ClassNotFoundException var8) {
         var8.printStackTrace();
      }
   }

   public static void setStaticOjbect(String var0, String var1, Object var2) {
      try {
         Field var8 = Class.forName(var0).getDeclaredField(var1);
         var8.setAccessible(true);
         var8.set((Object)null, var2);
      } catch (SecurityException var3) {
         var3.printStackTrace();
      } catch (NoSuchFieldException var4) {
         var4.printStackTrace();
      } catch (IllegalArgumentException var5) {
         var5.printStackTrace();
      } catch (IllegalAccessException var6) {
         var6.printStackTrace();
      } catch (ClassNotFoundException var7) {
         var7.printStackTrace();
      }
   }
}
