package com.example.reforceapk;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import com.example.reforceapk.RefInvoke;
import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ProxyApplication extends Application {
   private static final String appkey = "APPLICATION_CLASS_NAME";
   private String dynamicllyLoadedAPKName;
   private String UUybjNNbf;
   private String jUHJJGTDSpLKD;
   protected AssetManager mAssetManager;
   protected Resources mResources;
   protected Theme mTheme;

   private byte[] jgsyagjwnbas(byte[] var1) {
      for(int i = 0; i < var1.length; ++i) {
         byte var2 = var1[i];
         var1[i] = var1[var1.length - i - 1];
         var1[var1.length - i - 1] = var2;
         var1[i] = (byte)(var1[i] ^ 255);
      }

      return var1;
   }

   private byte[] readDexFileFromApk() throws IOException {
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();
      ZipInputStream var3 = new ZipInputStream(new BufferedInputStream(new FileInputStream(this.getApplicationInfo().sourceDir)));

      while(true) {
         ZipEntry var4 = var3.getNextEntry();
         if(var4 == null) {
            var3.close();
            var3.close();
            return var2.toByteArray();
         }

         if(var4.getName().equals("classes.dex")) {
            byte[] var5 = new byte[1024];

            while(true) {
               int var1 = var3.read(var5);
               if(var1 == -1) {
                  break;
               }

               var2.write(var5, 0, var1);
            }
         }

         var3.closeEntry();
      }
   }

   private byte[] sdkjfh(byte[] var1, String var2) {
      char[] var7 = var2.toCharArray();
      int var5 = var7.length;

      for(int var3 = 0; var3 < var5; ++var3) {
         char var6 = var7[var3];

         for(int var4 = 0; var4 < var1.length; ++var4) {
            var1[var4] = (byte)(var1[var4] ^ var6);
         }
      }

      return var1;
   }

   private void splitPayLoadFromDex(byte[] var1) throws IOException {
      int var2 = var1.length;
      byte[] var4 = new byte[4];
      System.arraycopy(var1, var2 - 4, var4, 0, 4);
      int var3 = (new DataInputStream(new ByteArrayInputStream(var4))).readInt();
      System.out.println(Integer.toHexString(var3));
      var4 = new byte[var3];
      System.arraycopy(var1, var2 - 4 - var3, var4, 0, var3);
      var1 = this.sdkjfh(var4, "Ivy");
      File var8 = new File(this.dynamicllyLoadedAPKName);

      try {
         FileOutputStream var5 = new FileOutputStream(var8);
         var5.write(var1);
         var5.close();
      } catch (IOException var6) {
         throw new RuntimeException(var6);
      }

      ZipInputStream var7 = new ZipInputStream(new BufferedInputStream(new FileInputStream(var8)));

      while(true) {
         ZipEntry var9 = var7.getNextEntry();
         if(var9 == null) {
            var7.close();
            var7.close();
            return;
         }

         String var10 = var9.getName();
         if(var10.startsWith("lib/") && var10.endsWith(".so")) {
            var8 = new File(this.jUHJJGTDSpLKD + "/" + var10.substring(var10.lastIndexOf(47)));
            var8.createNewFile();
            FileOutputStream var12 = new FileOutputStream(var8);
            byte[] var11 = new byte[1024];

            while(true) {
               var2 = var7.read(var11);
               if(var2 == -1) {
                  var12.flush();
                  var12.close();
                  break;
               }

               var12.write(var11, 0, var2);
            }
         }

         var7.closeEntry();
      }
   }

   protected void attachBaseContext(Context var1) {
      super.attachBaseContext(var1);

      DexClassLoader var9;
      try {
         File var5 = this.getDir("payload_odex", 0);
         File var2 = this.getDir("payload_lib", 0);
         this.UUybjNNbf = var5.getAbsolutePath();
         this.jUHJJGTDSpLKD = var2.getAbsolutePath();
         this.dynamicllyLoadedAPKName = var5.getAbsolutePath() + "/payload.apk";
         var5 = new File(this.dynamicllyLoadedAPKName);
         if(!var5.exists()) {
            var5.createNewFile();
            this.splitPayLoadFromDex(this.readDexFileFromApk());
         }

         Object var6 = RefInvoke.invokeStaticMethod("android.app.ActivityThread", "currentActivityThread", new Class[0], new Object[0]);
         String var7 = this.getPackageName();
         WeakReference var8 = (WeakReference)((HashMap)RefInvoke.getFieldOjbect("android.app.ActivityThread", var6, "mPackages")).get(var7);
         var9 = new DexClassLoader(this.dynamicllyLoadedAPKName, this.UUybjNNbf, this.jUHJJGTDSpLKD, (ClassLoader)RefInvoke.getFieldOjbect("android.app.LoadedApk", var8.get(), "mClassLoader"));
         RefInvoke.setFieldOjbect("android.app.LoadedApk", "mClassLoader", var8.get(), var9);
      } catch (Exception var4) {
         var4.printStackTrace();
         return;
      }

      try {
         var9.loadClass("com.bojunjin.whotouchedmyphone.MainActivity");
      } catch (Exception var3) {
         ;
      }
   }

   public AssetManager getAssets() {
      return this.mAssetManager == null?super.getAssets():this.mAssetManager;
   }

   public Resources getResources() {
      return this.mResources == null?super.getResources():this.mResources;
   }

   public Theme getTheme() {
      return this.mTheme == null?super.getTheme():this.mTheme;
   }

   protected void loadResources(String var1) {
      try {
         AssetManager var2 = (AssetManager)AssetManager.class.newInstance();
         var2.getClass().getMethod("addAssetPath", new Class[]{String.class}).invoke(var2, new Object[]{var1});
         this.mAssetManager = var2;
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      Resources var4 = super.getResources();
      var4.getDisplayMetrics();
      var4.getConfiguration();
      this.mResources = new Resources(this.mAssetManager, var4.getDisplayMetrics(), var4.getConfiguration());
      this.mTheme = this.mResources.newTheme();
      this.mTheme.setTo(super.getTheme());
   }

   public void onCreate() {
      // $FF: Couldn't be decompiled
	   super.onCreate();
       Object string = null;
       while (true) {
           try {
               final Bundle metaData = this.getPackageManager().getApplicationInfo(this.getPackageName(), 128).metaData;
               if (metaData == null || !metaData.containsKey("APPLICATION_CLASS_NAME")) {
                   return;
               }
               string = metaData.getString("APPLICATION_CLASS_NAME");
               final ActivityThread invokeStaticMethod = RefInvoke.invokeStaticMethod("android.app.ActivityThread", "currentActivityThread", new Class[0], new Object[0]);
               final AppBindData fieldOjbect = RefInvoke.getFieldOjbect("android.app.ActivityThread", invokeStaticMethod, "mBoundApplication");
               final PackageInfo fieldOjbect2 = RefInvoke.getFieldOjbect("android.app.ActivityThread$AppBindData", fieldOjbect, "info");
               RefInvoke.setFieldOjbect("android.app.LoadedApk", "mApplication", fieldOjbect2, (Object)null);
               ((ArrayList)RefInvoke.getFieldOjbect("android.app.ActivityThread", invokeStaticMethod, "mAllApplications")).remove(RefInvoke.getFieldOjbect("android.app.ActivityThread", invokeStaticMethod, "mInitialApplication"));
               final ApplicationInfo applicationInfo = (ApplicationInfo)RefInvoke.getFieldOjbect("android.app.LoadedApk", fieldOjbect2, "mApplicationInfo");
               final ApplicationInfo applicationInfo2 = (ApplicationInfo)RefInvoke.getFieldOjbect("android.app.ActivityThread$AppBindData", fieldOjbect, "appInfo");
               applicationInfo.className = (String)string;
               applicationInfo2.className = (String)string;
               string = RefInvoke.invokeMethod("android.app.LoadedApk", "makeApplication", fieldOjbect2, new Class[] { Boolean.TYPE, Instrumentation.class }, new Object[] { false, null });
               RefInvoke.setFieldOjbect("android.app.ActivityThread", "mInitialApplication", invokeStaticMethod, string);
               final Iterator<Object> iterator = ((HashMap)RefInvoke.getFieldOjbect("android.app.ActivityThread", invokeStaticMethod, "mProviderMap")).values().iterator();
               while (iterator.hasNext()) {
                   RefInvoke.setFieldOjbect("android.content.ContentProvider", "mContext", RefInvoke.getFieldOjbect("android.app.ActivityThread$ProviderClientRecord", iterator.next(), "mLocalProvider"), string);
               }
           }
           catch (PackageManager$NameNotFoundException ex) {
               ex.printStackTrace();
               continue;
           }
           break;
       }
       ((Application)string).onCreate();
   }
}
