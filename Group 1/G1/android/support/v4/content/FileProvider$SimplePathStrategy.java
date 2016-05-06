package android.support.v4.content;

import java.util.Iterator;
import android.net.Uri$Builder;
import java.util.Map;
import android.net.Uri;
import java.io.IOException;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;

static class SimplePathStrategy implements PathStrategy
{
    private final String mAuthority;
    private final HashMap<String, File> mRoots;
    
    public SimplePathStrategy(final String mAuthority) {
        super();
        this.mRoots = new HashMap<String, File>();
        this.mAuthority = mAuthority;
    }
    
    public void addRoot(final String s, final File file) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        try {
            mRoots.put(s, file.getCanonicalFile());
        }
        catch (IOException ex) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file, ex);
        }
    }
    
    @Override
    public File getFileForUri(final Uri uri) {
        final String encodedPath = uri.getEncodedPath();
        final int index = encodedPath.indexOf(47, 1);
        final String decode = Uri.decode(encodedPath.substring(1, index));
        final String decode2 = Uri.decode(encodedPath.substring(index + 1));
        final File file = (File)mRoots.get(decode);
        if (file == null) {
            throw new IllegalArgumentException("Unable to find configured root for " + uri);
        }
        final File file2 = new File(file, decode2);
        File canonicalFile;
        try {
            canonicalFile = file2.getCanonicalFile();
            if (!canonicalFile.getPath().startsWith(file.getPath())) {
                throw new SecurityException("Resolved path jumped beyond configured root");
            }
        }
        catch (IOException ex) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
        }
        return canonicalFile;
    }
    
    @Override
    public Uri getUriForFile(final File file) {
        String canonicalPath;
        Object o;
        try {
            canonicalPath = file.getCanonicalPath();
            o = null;
            for (final Map.Entry<String, File> entry : mRoots.entrySet()) {
                final String path = ((File)entry.getValue()).getPath();
                if (canonicalPath.startsWith(path) && (o == null || path.length() > ((File)((Map.Entry<K, File>)o).getValue()).getPath().length())) {
                    o = entry;
                }
            }
        }
        catch (IOException ex) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
        }
        if (o == null) {
            throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
        }
        final String path2 = ((File)((Map.Entry<K, File>)o).getValue()).getPath();
        String s;
        if (path2.endsWith("/")) {
            s = canonicalPath.substring(path2.length());
        }
        else {
            s = canonicalPath.substring(1 + path2.length());
        }
        return new Uri$Builder().scheme("content").authority(mAuthority).encodedPath(Uri.encode((String)((Map.Entry)o).getKey()) + '/' + Uri.encode(s, "/")).build();
    }
}
