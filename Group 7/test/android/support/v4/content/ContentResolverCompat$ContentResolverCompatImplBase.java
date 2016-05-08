package android.support.v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.ContentResolverCompat$ContentResolverCompatImpl;
import android.support.v4.os.CancellationSignal;

class ContentResolverCompat$ContentResolverCompatImplBase implements ContentResolverCompat$ContentResolverCompatImpl {
   public Cursor query(ContentResolver var1, Uri var2, String[] var3, String var4, String[] var5, String var6, CancellationSignal var7) {
      if(var7 != null) {
         var7.throwIfCanceled();
      }

      return var1.query(var2, var3, var4, var5, var6);
   }
}
