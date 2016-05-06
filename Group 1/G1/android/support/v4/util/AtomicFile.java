package android.support.v4.util;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import android.util.Log;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.File;

public class AtomicFile
{
    private final File mBackupName;
    private final File mBaseName;
    
    public AtomicFile(final File mBaseName) {
        super();
        mBaseName = mBaseName;
        mBackupName = new File(mBaseName.getPath() + ".bak");
    }
    
    static boolean sync(final FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return true;
        }
        try {
            fileOutputStream.getFD().sync();
            return true;
        }
        catch (IOException ex) {
            return false;
        }
    }
    
    public void delete() {
        mBaseName.delete();
        mBackupName.delete();
    }
    
    public void failWrite(final FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return;
        }
        sync(fileOutputStream);
        try {
            fileOutputStream.close();
            mBaseName.delete();
            mBackupName.renameTo(mBaseName);
        }
        catch (IOException ex) {
            Log.w("AtomicFile", "failWrite: Got exception:", (Throwable)ex);
        }
    }
    
    public void finishWrite(final FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return;
        }
        sync(fileOutputStream);
        try {
            fileOutputStream.close();
            mBackupName.delete();
        }
        catch (IOException ex) {
            Log.w("AtomicFile", "finishWrite: Got exception:", (Throwable)ex);
        }
    }
    
    public File getBaseFile() {
        return mBaseName;
    }
    
    public FileInputStream openRead() throws FileNotFoundException {
        if (mBackupName.exists()) {
            mBaseName.delete();
            mBackupName.renameTo(mBaseName);
        }
        return new FileInputStream(mBaseName);
    }
    
    public byte[] readFully() throws IOException {
        final FileInputStream openRead = this.openRead();
        int n = 0;
        try {
            byte[] array = new byte[openRead.available()];
            while (true) {
                final int read = openRead.read(array, n, array.length - n);
                if (read <= 0) {
                    break;
                }
                n += read;
                final int available = openRead.available();
                if (available <= array.length - n) {
                    continue;
                }
                final byte[] array2 = new byte[n + available];
                System.arraycopy(array, 0, array2, 0, n);
                array = array2;
            }
            return array;
        }
        finally {
            openRead.close();
        }
    }
    
    public FileOutputStream startWrite() throws IOException {
        Label_0088: {
            if (mBaseName.exists()) {
                if (mBackupName.exists()) {
                    break Label_0088;
                }
                if (!mBaseName.renameTo(mBackupName)) {
                    Log.w("AtomicFile", "Couldn't rename file " + mBaseName + " to backup file " + mBackupName);
                }
            }
            try {
                return new FileOutputStream(mBaseName);
                mBaseName.delete();
                return new FileOutputStream(mBaseName);
            }
            catch (FileNotFoundException ex) {
                if (!mBaseName.getParentFile().mkdirs()) {
                    throw new IOException("Couldn't create directory " + mBaseName);
                }
                try {
                    return new FileOutputStream(mBaseName);
                }
                catch (FileNotFoundException ex2) {
                    throw new IOException("Couldn't create " + mBaseName);
                }
            }
        }
    }
}
