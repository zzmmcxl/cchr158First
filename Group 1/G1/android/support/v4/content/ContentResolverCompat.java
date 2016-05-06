package android.support.v4.content;

import android.support.v4.os.OperationCanceledException;
import android.database.Cursor;
import android.support.v4.os.CancellationSignal;
import android.net.Uri;
import android.content.ContentResolver;
import android.os.Build$VERSION;

public final class ContentResolverCompat
{
    private static final ContentResolverCompatImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 16) {
            IMPL = (ContentResolverCompatImpl)new ContentResolverCompatImplJB();
            return;
        }
        IMPL = (ContentResolverCompatImpl)new ContentResolverCompatImplBase();
    }
    
    private ContentResolverCompat() {
        super();
    }
    
    public static Cursor query(final ContentResolver contentResolver, final Uri uri, final String[] array, final String s, final String[] array2, final String s2, final CancellationSignal cancellationSignal) {
        return IMPL.query(contentResolver, uri, array, s, array2, s2, cancellationSignal);
    }
}
