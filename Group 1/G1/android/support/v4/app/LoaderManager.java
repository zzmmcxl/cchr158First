package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import java.io.PrintWriter;
import java.io.FileDescriptor;

public abstract class LoaderManager
{
    public LoaderManager() {
        super();
    }
    
    public static void enableDebugLogging(final boolean debug) {
        LoaderManagerImpl.DEBUG = debug;
    }
    
    public abstract void destroyLoader(final int p0);
    
    public abstract void dump(final String p0, final FileDescriptor p1, final PrintWriter p2, final String[] p3);
    
    public abstract <D> Loader<D> getLoader(final int p0);
    
    public boolean hasRunningLoaders() {
        return false;
    }
    
    public abstract <D> Loader<D> initLoader(final int p0, final Bundle p1, final LoaderCallbacks<D> p2);
    
    public abstract <D> Loader<D> restartLoader(final int p0, final Bundle p1, final LoaderCallbacks<D> p2);
}
