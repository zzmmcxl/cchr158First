package android.support.v4.provider;

import android.net.Uri;
import android.content.Context;

class SingleDocumentFile extends DocumentFile
{
    private Context mContext;
    private Uri mUri;
    
    SingleDocumentFile(final DocumentFile documentFile, final Context mContext, final Uri mUri) {
        super(documentFile);
        mContext = mContext;
        mUri = mUri;
    }
    
    @Override
    public boolean canRead() {
        return DocumentsContractApi19.canRead(mContext, mUri);
    }
    
    @Override
    public boolean canWrite() {
        return DocumentsContractApi19.canWrite(mContext, mUri);
    }
    
    @Override
    public DocumentFile createDirectory(final String s) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public DocumentFile createFile(final String s, final String s2) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean delete() {
        return DocumentsContractApi19.delete(mContext, mUri);
    }
    
    @Override
    public boolean exists() {
        return DocumentsContractApi19.exists(mContext, mUri);
    }
    
    @Override
    public String getName() {
        return DocumentsContractApi19.getName(mContext, mUri);
    }
    
    @Override
    public String getType() {
        return DocumentsContractApi19.getType(mContext, mUri);
    }
    
    @Override
    public Uri getUri() {
        return mUri;
    }
    
    @Override
    public boolean isDirectory() {
        return DocumentsContractApi19.isDirectory(mContext, mUri);
    }
    
    @Override
    public boolean isFile() {
        return DocumentsContractApi19.isFile(mContext, mUri);
    }
    
    @Override
    public long lastModified() {
        return DocumentsContractApi19.lastModified(mContext, mUri);
    }
    
    @Override
    public long length() {
        return DocumentsContractApi19.length(mContext, mUri);
    }
    
    @Override
    public DocumentFile[] listFiles() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean renameTo(final String s) {
        throw new UnsupportedOperationException();
    }
}
