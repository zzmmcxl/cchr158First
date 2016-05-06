package android.support.v4.provider;

import java.util.ArrayList;
import android.net.Uri;
import java.io.IOException;
import android.webkit.MimeTypeMap;
import android.util.Log;
import java.io.File;

class RawDocumentFile extends DocumentFile
{
    private File mFile;
    
    RawDocumentFile(final DocumentFile documentFile, final File mFile) {
        super(documentFile);
        mFile = mFile;
    }
    
    private static boolean deleteContents(final File file) {
        final File[] listFiles = file.listFiles();
        boolean b = true;
        if (listFiles != null) {
            for (final File file2 : listFiles) {
                if (file2.isDirectory()) {
                    b &= deleteContents(file2);
                }
                if (!file2.delete()) {
                    Log.w("DocumentFile", "Failed to delete " + file2);
                    b = false;
                }
            }
        }
        return b;
    }
    
    private static String getTypeForName(final String s) {
        final int lastIndex = s.lastIndexOf(46);
        if (lastIndex >= 0) {
            final String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(s.substring(lastIndex + 1).toLowerCase());
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return "application/octet-stream";
    }
    
    @Override
    public boolean canRead() {
        return mFile.canRead();
    }
    
    @Override
    public boolean canWrite() {
        return mFile.canWrite();
    }
    
    @Override
    public DocumentFile createDirectory(final String s) {
        final File file = new File(mFile, s);
        if (file.isDirectory() || file.mkdir()) {
            return new RawDocumentFile(this, file);
        }
        return null;
    }
    
    @Override
    public DocumentFile createFile(final String s, String string) {
        final String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(s);
        if (extensionFromMimeType != null) {
            string = string + "." + extensionFromMimeType;
        }
        final File file = new File(mFile, string);
        try {
            file.createNewFile();
            return new RawDocumentFile(this, file);
        }
        catch (IOException ex) {
            Log.w("DocumentFile", "Failed to createFile: " + ex);
            return null;
        }
    }
    
    @Override
    public boolean delete() {
        deleteContents(mFile);
        return mFile.delete();
    }
    
    @Override
    public boolean exists() {
        return mFile.exists();
    }
    
    @Override
    public String getName() {
        return mFile.getName();
    }
    
    @Override
    public String getType() {
        if (mFile.isDirectory()) {
            return null;
        }
        return getTypeForName(mFile.getName());
    }
    
    @Override
    public Uri getUri() {
        return Uri.fromFile(mFile);
    }
    
    @Override
    public boolean isDirectory() {
        return mFile.isDirectory();
    }
    
    @Override
    public boolean isFile() {
        return mFile.isFile();
    }
    
    @Override
    public long lastModified() {
        return mFile.lastModified();
    }
    
    @Override
    public long length() {
        return mFile.length();
    }
    
    @Override
    public DocumentFile[] listFiles() {
        final ArrayList<RawDocumentFile> list = new ArrayList<RawDocumentFile>();
        final File[] listFiles = mFile.listFiles();
        if (listFiles != null) {
            for (int length = listFiles.length, i = 0; i < length; ++i) {
                list.add(new RawDocumentFile((DocumentFile)this, listFiles[i]));
            }
        }
        return list.<DocumentFile>toArray(new DocumentFile[list.size()]);
    }
    
    @Override
    public boolean renameTo(final String s) {
        final File mFile = new File(this.mFile.getParentFile(), s);
        if (this.mFile.renameTo(mFile)) {
            this.mFile = mFile;
            return true;
        }
        return false;
    }
}
