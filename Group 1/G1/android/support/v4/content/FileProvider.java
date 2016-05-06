package android.support.v4.content;

import java.util.Iterator;
import android.net.Uri$Builder;
import java.util.Map;
import android.text.TextUtils;
import android.database.MatrixCursor;
import android.database.Cursor;
import java.io.FileNotFoundException;
import android.os.ParcelFileDescriptor;
import android.content.ContentValues;
import android.webkit.MimeTypeMap;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.os.Environment;
import android.net.Uri;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import android.content.Context;
import java.util.HashMap;
import java.io.File;
import android.content.ContentProvider;

public class FileProvider extends ContentProvider
{
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String[] COLUMNS;
    private static final File DEVICE_ROOT;
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private static HashMap<String, PathStrategy> sCache;
    private PathStrategy mStrategy;
    
    static {
        COLUMNS = new String[] { "_display_name", "_size" };
        DEVICE_ROOT = new File("/");
        sCache = new HashMap<String, PathStrategy>();
    }
    
    public FileProvider() {
        super();
    }
    
    private static File buildPath(final File file, final String... array) {
        final int length = array.length;
        int i = 0;
        File file2 = file;
        while (i < length) {
            final String s = array[i];
            File file3;
            if (s != null) {
                file3 = new File(file2, s);
            }
            else {
                file3 = file2;
            }
            ++i;
            file2 = file3;
        }
        return file2;
    }
    
    private static Object[] copyOf(final Object[] array, final int n) {
        final Object[] array2 = new Object[n];
        System.arraycopy(array, 0, array2, 0, n);
        return array2;
    }
    
    private static String[] copyOf(final String[] array, final int n) {
        final String[] array2 = new String[n];
        System.arraycopy(array, 0, array2, 0, n);
        return array2;
    }
    
    private static PathStrategy getPathStrategy(final Context context, final String s) {
        // monitorenter(FileProvider.sCache)
        try {
            PathStrategy pathStrategy = (PathStrategy)sCache.get(s);
            if (pathStrategy != null) {
                return pathStrategy;
            }
            try {
                pathStrategy = parsePathStrategy(context, s);
                sCache.put(s, pathStrategy);
                return pathStrategy;
            }
            catch (IOException ex) {
                throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", ex);
            }
            catch (XmlPullParserException ex2) {
                throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", (Throwable)ex2);
            }
        }
        finally {}
    }
    
    public static Uri getUriForFile(final Context context, final String s, final File file) {
        return getPathStrategy(context, s).getUriForFile(file);
    }
    
    private static int modeToMode(final String s) {
        if ("r".equals(s)) {
            return 268435456;
        }
        if ("w".equals(s) || "wt".equals(s)) {
            return 738197504;
        }
        if ("wa".equals(s)) {
            return 704643072;
        }
        if ("rw".equals(s)) {
            return 939524096;
        }
        if ("rwt".equals(s)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + s);
    }
    
    private static PathStrategy parsePathStrategy(final Context context, final String s) throws IOException, XmlPullParserException {
        final SimplePathStrategy simplePathStrategy = new SimplePathStrategy(s);
        final XmlResourceParser loadXmlMetaData = context.getPackageManager().resolveContentProvider(s, 128).loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (loadXmlMetaData == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while (true) {
            final int next = loadXmlMetaData.next();
            if (next == 1) {
                break;
            }
            if (next != 2) {
                continue;
            }
            final String name = loadXmlMetaData.getName();
            final String attributeValue = loadXmlMetaData.getAttributeValue((String)null, "name");
            final String attributeValue2 = loadXmlMetaData.getAttributeValue((String)null, "path");
            File file;
            if ("root-path".equals(name)) {
                file = buildPath(DEVICE_ROOT, attributeValue2);
            }
            else if ("files-path".equals(name)) {
                file = buildPath(context.getFilesDir(), attributeValue2);
            }
            else if ("cache-path".equals(name)) {
                file = buildPath(context.getCacheDir(), attributeValue2);
            }
            else {
                final boolean equals = "external-path".equals(name);
                file = null;
                if (equals) {
                    file = buildPath(Environment.getExternalStorageDirectory(), attributeValue2);
                }
            }
            if (file == null) {
                continue;
            }
            simplePathStrategy.addRoot(attributeValue, file);
        }
        return (PathStrategy)simplePathStrategy;
    }
    
    public void attachInfo(final Context context, final ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        mStrategy = getPathStrategy(context, providerInfo.authority);
    }
    
    public int delete(final Uri uri, final String s, final String[] array) {
        if (mStrategy.getFileForUri(uri).delete()) {
            return 1;
        }
        return 0;
    }
    
    public String getType(final Uri uri) {
        final File fileForUri = mStrategy.getFileForUri(uri);
        final int lastIndex = fileForUri.getName().lastIndexOf(46);
        if (lastIndex >= 0) {
            final String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileForUri.getName().substring(lastIndex + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return "application/octet-stream";
    }
    
    public Uri insert(final Uri uri, final ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }
    
    public boolean onCreate() {
        return true;
    }
    
    public ParcelFileDescriptor openFile(final Uri uri, final String s) throws FileNotFoundException {
        return ParcelFileDescriptor.open(mStrategy.getFileForUri(uri), modeToMode(s));
    }
    
    public Cursor query(final Uri uri, String[] columns, final String s, final String[] array, final String s2) {
        final File fileForUri = mStrategy.getFileForUri(uri);
        if (columns == null) {
            columns = COLUMNS;
        }
        final String[] array2 = new String[columns.length];
        final Object[] array3 = new Object[columns.length];
        final String[] array4 = columns;
        final int length = array4.length;
        int i = 0;
        int n = 0;
        while (i < length) {
            final String s3 = array4[i];
            int n2;
            if ("_display_name".equals(s3)) {
                array2[n] = "_display_name";
                n2 = n + 1;
                array3[n] = fileForUri.getName();
            }
            else if ("_size".equals(s3)) {
                array2[n] = "_size";
                n2 = n + 1;
                array3[n] = fileForUri.length();
            }
            else {
                n2 = n;
            }
            ++i;
            n = n2;
        }
        final String[] copy = copyOf(array2, n);
        final Object[] copy2 = copyOf(array3, n);
        final MatrixCursor matrixCursor = new MatrixCursor(copy, 1);
        matrixCursor.addRow(copy2);
        return (Cursor)matrixCursor;
    }
    
    public int update(final Uri uri, final ContentValues contentValues, final String s, final String[] array) {
        throw new UnsupportedOperationException("No external updates");
    }
}
