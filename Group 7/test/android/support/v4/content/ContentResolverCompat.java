package android.support.v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.content.ContentResolverCompat$ContentResolverCompatImpl;
import android.support.v4.content.ContentResolverCompat$ContentResolverCompatImplBase;
import android.support.v4.content.ContentResolverCompat$ContentResolverCompatImplJB;
import android.support.v4.os.CancellationSignal;

public final class ContentResolverCompat {
   private static final ContentResolverCompat$ContentResolverCompatImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 16) {
         IMPL = new ContentResolverCompat$ContentResolverCompatImplJB();
      } else {
         IMPL = new ContentResolverCompat$ContentResolverCompatImplBase();
      }
   }

   public static Cursor query(ContentResolver var0, Uri var1, String[] var2, String var3, String[] var4, String var5, CancellationSignal var6) {
      return IMPL.query(var0, var1, var2, var3, var4, var5, var6);
   }
}
