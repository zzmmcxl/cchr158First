package android.support.v4.content;

import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v4.content.FileProvider$PathStrategy;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

class FileProvider$SimplePathStrategy implements FileProvider$PathStrategy {
   private final String mAuthority;
   private final HashMap<String, File> mRoots = new HashMap();

   public FileProvider$SimplePathStrategy(String var1) {
      this.mAuthority = var1;
   }

   public void addRoot(String var1, File var2) {
      if(TextUtils.isEmpty(var1)) {
         throw new IllegalArgumentException("Name must not be empty");
      } else {
         File var3;
         try {
            var3 = var2.getCanonicalFile();
         } catch (IOException var4) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + var2, var4);
         }

         this.mRoots.put(var1, var3);
      }
   }

   public File getFileForUri(Uri var1) {
      String var4 = var1.getEncodedPath();
      int var2 = var4.indexOf(47, 1);
      String var3 = Uri.decode(var4.substring(1, var2));
      var4 = Uri.decode(var4.substring(var2 + 1));
      File var7 = (File)this.mRoots.get(var3);
      if(var7 == null) {
         throw new IllegalArgumentException("Unable to find configured root for " + var1);
      } else {
         File var6 = new File(var7, var4);

         File var8;
         try {
            var8 = var6.getCanonicalFile();
         } catch (IOException var5) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + var6);
         }

         if(!var8.getPath().startsWith(var7.getPath())) {
            throw new SecurityException("Resolved path jumped beyond configured root");
         } else {
            return var8;
         }
      }
   }

   public Uri getUriForFile(File var1) {
      String var3;
      try {
         var3 = var1.getCanonicalPath();
      } catch (IOException var6) {
         throw new IllegalArgumentException("Failed to resolve canonical path for " + var1);
      }

      Entry var7 = null;
      Iterator var4 = this.mRoots.entrySet().iterator();

      while(true) {
         Entry var2;
         String var5;
         do {
            do {
               if(!var4.hasNext()) {
                  if(var7 == null) {
                     throw new IllegalArgumentException("Failed to find configured root that contains " + var3);
                  }

                  String var9 = ((File)var7.getValue()).getPath();
                  if(var9.endsWith("/")) {
                     var9 = var3.substring(var9.length());
                  } else {
                     var9 = var3.substring(var9.length() + 1);
                  }

                  String var8 = Uri.encode((String)var7.getKey()) + '/' + Uri.encode(var9, "/");
                  return (new Builder()).scheme("content").authority(this.mAuthority).encodedPath(var8).build();
               }

               var2 = (Entry)var4.next();
               var5 = ((File)var2.getValue()).getPath();
            } while(!var3.startsWith(var5));
         } while(var7 != null && var5.length() <= ((File)var7.getValue()).getPath().length());

         var7 = var2;
      }
   }
}
