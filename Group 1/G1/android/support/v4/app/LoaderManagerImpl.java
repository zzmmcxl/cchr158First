package android.support.v4.app;

import java.lang.reflect.Modifier;
import android.support.v4.util.DebugUtils;
import android.support.v4.content.Loader;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.util.Log;
import android.os.Bundle;
import android.support.v4.util.SparseArrayCompat;

class LoaderManagerImpl extends LoaderManager
{
    static boolean DEBUG = false;
    static final String TAG = "LoaderManager";
    boolean mCreatingLoader;
    private FragmentHostCallback mHost;
    final SparseArrayCompat<LoaderInfo> mInactiveLoaders;
    final SparseArrayCompat<LoaderInfo> mLoaders;
    boolean mRetaining;
    boolean mRetainingStarted;
    boolean mStarted;
    final String mWho;
    
    static {
        DEBUG = false;
    }
    
    LoaderManagerImpl(final String mWho, final FragmentHostCallback mHost, final boolean mStarted) {
        super();
        mLoaders = new SparseArrayCompat<LoaderInfo>();
        mInactiveLoaders = new SparseArrayCompat<LoaderInfo>();
        mWho = mWho;
        mHost = mHost;
        mStarted = mStarted;
    }
    
    static /* synthetic */ FragmentHostCallback access$000(final LoaderManagerImpl loaderManagerImpl) {
        return loaderManagerImpl.mHost;
    }
    
    private LoaderInfo createAndInstallLoader(final int n, final Bundle bundle, final LoaderCallbacks<Object> loaderCallbacks) {
        try {
            mCreatingLoader = true;
            final LoaderInfo loader = this.createLoader(n, bundle, loaderCallbacks);
            this.installLoader(loader);
            return loader;
        }
        finally {
            mCreatingLoader = false;
        }
    }
    
    private LoaderInfo createLoader(final int n, final Bundle bundle, final LoaderCallbacks<Object> loaderCallbacks) {
        final LoaderInfo loaderInfo = new LoaderInfo(n, bundle, loaderCallbacks);
        loaderInfo.mLoader = loaderCallbacks.onCreateLoader(n, bundle);
        return loaderInfo;
    }
    
    @Override
    public void destroyLoader(final int n) {
        if (mCreatingLoader) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (DEBUG) {
            Log.v("LoaderManager", "destroyLoader in " + this + " of " + n);
        }
        final int indexOfKey = mLoaders.indexOfKey(n);
        if (indexOfKey >= 0) {
            final LoaderInfo loaderInfo = (LoaderInfo)mLoaders.valueAt(indexOfKey);
            mLoaders.removeAt(indexOfKey);
            loaderInfo.destroy();
        }
        final int indexOfKey2 = mInactiveLoaders.indexOfKey(n);
        if (indexOfKey2 >= 0) {
            final LoaderInfo loaderInfo2 = (LoaderInfo)mInactiveLoaders.valueAt(indexOfKey2);
            mInactiveLoaders.removeAt(indexOfKey2);
            loaderInfo2.destroy();
        }
        if (mHost != null && !this.hasRunningLoaders()) {
            mHost.mFragmentManager.startPendingDeferredFragments();
        }
    }
    
    void doDestroy() {
        if (!mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int i = -1 + mLoaders.size(); i >= 0; --i) {
                ((LoaderInfo)mLoaders.valueAt(i)).destroy();
            }
            mLoaders.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int j = -1 + mInactiveLoaders.size(); j >= 0; --j) {
            ((LoaderInfo)mInactiveLoaders.valueAt(j)).destroy();
        }
        mInactiveLoaders.clear();
    }
    
    void doReportNextStart() {
        for (int i = -1 + mLoaders.size(); i >= 0; --i) {
            ((LoaderInfo)mLoaders.valueAt(i)).mReportNextStart = true;
        }
    }
    
    void doReportStart() {
        for (int i = -1 + mLoaders.size(); i >= 0; --i) {
            ((LoaderInfo)mLoaders.valueAt(i)).reportStart();
        }
    }
    
    void doRetain() {
        if (DEBUG) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (!mStarted) {
            final RuntimeException ex = new RuntimeException("here");
            ex.fillInStackTrace();
            Log.w("LoaderManager", "Called doRetain when not started: " + this, (Throwable)ex);
        }
        else {
            mRetaining = true;
            mStarted = false;
            for (int i = -1 + mLoaders.size(); i >= 0; --i) {
                ((LoaderInfo)mLoaders.valueAt(i)).retain();
            }
        }
    }
    
    void doStart() {
        if (DEBUG) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (mStarted) {
            final RuntimeException ex = new RuntimeException("here");
            ex.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, (Throwable)ex);
        }
        else {
            mStarted = true;
            for (int i = -1 + mLoaders.size(); i >= 0; --i) {
                ((LoaderInfo)mLoaders.valueAt(i)).start();
            }
        }
    }
    
    void doStop() {
        if (DEBUG) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (!mStarted) {
            final RuntimeException ex = new RuntimeException("here");
            ex.fillInStackTrace();
            Log.w("LoaderManager", "Called doStop when not started: " + this, (Throwable)ex);
            return;
        }
        for (int i = -1 + mLoaders.size(); i >= 0; --i) {
            ((LoaderInfo)mLoaders.valueAt(i)).stop();
        }
        mStarted = false;
    }
    
    @Override
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        if (mLoaders.size() > 0) {
            printWriter.print(s);
            printWriter.println("Active Loaders:");
            final String string = s + "    ";
            for (int i = 0; i < mLoaders.size(); ++i) {
                final LoaderInfo loaderInfo = (LoaderInfo)mLoaders.valueAt(i);
                printWriter.print(s);
                printWriter.print("  #");
                printWriter.print(mLoaders.keyAt(i));
                printWriter.print(": ");
                printWriter.println(loaderInfo.toString());
                loaderInfo.dump(string, fileDescriptor, printWriter, array);
            }
        }
        if (mInactiveLoaders.size() > 0) {
            printWriter.print(s);
            printWriter.println("Inactive Loaders:");
            final String string2 = s + "    ";
            for (int j = 0; j < mInactiveLoaders.size(); ++j) {
                final LoaderInfo loaderInfo2 = (LoaderInfo)mInactiveLoaders.valueAt(j);
                printWriter.print(s);
                printWriter.print("  #");
                printWriter.print(mInactiveLoaders.keyAt(j));
                printWriter.print(": ");
                printWriter.println(loaderInfo2.toString());
                loaderInfo2.dump(string2, fileDescriptor, printWriter, array);
            }
        }
    }
    
    void finishRetain() {
        if (mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            mRetaining = false;
            for (int i = -1 + mLoaders.size(); i >= 0; --i) {
                ((LoaderInfo)mLoaders.valueAt(i)).finishRetain();
            }
        }
    }
    
    @Override
    public <D> Loader<D> getLoader(final int n) {
        if (mCreatingLoader) {
            throw new IllegalStateException("Called while creating a loader");
        }
        final LoaderInfo loaderInfo = (LoaderInfo)mLoaders.get(n);
        if (loaderInfo == null) {
            return null;
        }
        if (loaderInfo.mPendingLoader != null) {
            return (Loader<D>)loaderInfo.mPendingLoader.mLoader;
        }
        return (Loader<D>)loaderInfo.mLoader;
    }
    
    @Override
    public boolean hasRunningLoaders() {
        boolean b = false;
        for (int size = mLoaders.size(), i = 0; i < size; ++i) {
            final LoaderInfo loaderInfo = (LoaderInfo)mLoaders.valueAt(i);
            b |= (loaderInfo.mStarted && !loaderInfo.mDeliveredData);
        }
        return b;
    }
    
    @Override
    public <D> Loader<D> initLoader(final int n, final Bundle bundle, final LoaderCallbacks<D> mCallbacks) {
        if (mCreatingLoader) {
            throw new IllegalStateException("Called while creating a loader");
        }
        LoaderInfo andInstallLoader = (LoaderInfo)mLoaders.get(n);
        if (DEBUG) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (andInstallLoader == null) {
            andInstallLoader = this.createAndInstallLoader(n, bundle, (LoaderCallbacks<Object>)mCallbacks);
            if (DEBUG) {
                Log.v("LoaderManager", "  Created new loader " + andInstallLoader);
            }
        }
        else {
            if (DEBUG) {
                Log.v("LoaderManager", "  Re-using existing loader " + andInstallLoader);
            }
            andInstallLoader.mCallbacks = (LoaderCallbacks<Object>)mCallbacks;
        }
        if (andInstallLoader.mHaveData && mStarted) {
            andInstallLoader.callOnLoadFinished(andInstallLoader.mLoader, andInstallLoader.mData);
        }
        return (Loader<D>)andInstallLoader.mLoader;
    }
    
    void installLoader(final LoaderInfo loaderInfo) {
        mLoaders.put(loaderInfo.mId, loaderInfo);
        if (mStarted) {
            loaderInfo.start();
        }
    }
    
    @Override
    public <D> Loader<D> restartLoader(final int n, final Bundle bundle, final LoaderCallbacks<D> loaderCallbacks) {
        if (mCreatingLoader) {
            throw new IllegalStateException("Called while creating a loader");
        }
        final LoaderInfo loaderInfo = (LoaderInfo)mLoaders.get(n);
        if (DEBUG) {
            Log.v("LoaderManager", "restartLoader in " + this + ": args=" + bundle);
        }
        if (loaderInfo != null) {
            final LoaderInfo loaderInfo2 = (LoaderInfo)mInactiveLoaders.get(n);
            if (loaderInfo2 != null) {
                if (loaderInfo.mHaveData) {
                    if (DEBUG) {
                        Log.v("LoaderManager", "  Removing last inactive loader: " + loaderInfo);
                    }
                    loaderInfo2.mDeliveredData = false;
                    loaderInfo2.destroy();
                    loaderInfo.mLoader.abandon();
                    mInactiveLoaders.put(n, loaderInfo);
                }
                else {
                    if (loaderInfo.mStarted) {
                        if (DEBUG) {
                            Log.v("LoaderManager", "  Current loader is running; attempting to cancel");
                        }
                        loaderInfo.cancel();
                        if (loaderInfo.mPendingLoader != null) {
                            if (DEBUG) {
                                Log.v("LoaderManager", "  Removing pending loader: " + loaderInfo.mPendingLoader);
                            }
                            loaderInfo.mPendingLoader.destroy();
                            loaderInfo.mPendingLoader = null;
                        }
                        if (DEBUG) {
                            Log.v("LoaderManager", "  Enqueuing as new pending loader");
                        }
                        loaderInfo.mPendingLoader = this.createLoader(n, bundle, (LoaderCallbacks<Object>)loaderCallbacks);
                        return (Loader<D>)loaderInfo.mPendingLoader.mLoader;
                    }
                    if (DEBUG) {
                        Log.v("LoaderManager", "  Current loader is stopped; replacing");
                    }
                    mLoaders.put(n, null);
                    loaderInfo.destroy();
                }
            }
            else {
                if (DEBUG) {
                    Log.v("LoaderManager", "  Making last loader inactive: " + loaderInfo);
                }
                loaderInfo.mLoader.abandon();
                mInactiveLoaders.put(n, loaderInfo);
            }
        }
        return (Loader<D>)this.createAndInstallLoader(n, bundle, (LoaderCallbacks<Object>)loaderCallbacks).mLoader;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode((Object)this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(mHost, sb);
        sb.append("}}");
        return sb.toString();
    }
    
    void updateHostController(final FragmentHostCallback mHost) {
        this.mHost = mHost;
    }
}
