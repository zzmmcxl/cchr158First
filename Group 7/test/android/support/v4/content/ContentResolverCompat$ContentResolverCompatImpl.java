package android.support.v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.os.CancellationSignal;

interface ContentResolverCompat$ContentResolverCompatImpl {
   Cursor query(ContentResolver var1, Uri var2, String[] var3, String var4, String[] var5, String var6, CancellationSignal var7);
}
