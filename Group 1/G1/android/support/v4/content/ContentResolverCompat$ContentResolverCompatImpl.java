package android.support.v4.content;

import android.database.Cursor;
import android.support.v4.os.CancellationSignal;
import android.net.Uri;
import android.content.ContentResolver;

interface ContentResolverCompatImpl
{
    Cursor query(final ContentResolver p0, final Uri p1, final String[] p2, final String p3, final String[] p4, final String p5, final CancellationSignal p6);
}
