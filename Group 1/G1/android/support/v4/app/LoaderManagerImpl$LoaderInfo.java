package android.support.v4.app;

import android.support.v4.util.DebugUtils;
import java.lang.reflect.Modifier;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.util.Log;
import android.os.Bundle;
import android.support.v4.content.Loader;

final class LoaderInfo implements OnLoadCompleteListener<Object>, OnLoadCanceledListener<Object>
{
    final Bundle mArgs;
    LoaderCallbacks<Object> mCallbacks;
    Object mData;
    boolean mDeliveredData;
    boolean mDestroyed;
    boolean mHaveData;
    final int mId;
    boolean mListenerRegistered;
    Loader<Object> mLoader;
    LoaderInfo mPendingLoader;
    boolean mReportNextStart;
    boolean mRetaining;
    boolean mRetainingStarted;
    boolean mStarted;
    final /* synthetic */ LoaderManagerImpl this$0;
    
    public LoaderInfo(final LoaderManagerImpl this$0, final int mId, final Bundle mArgs, final LoaderCallbacks<Object> mCallbacks) {
        this$0 = this$0;
        super();
        mId = mId;
        mArgs = mArgs;
        mCallbacks = mCallbacks;
    }
    
    void callOnLoadFinished(final Loader<Object> loader, final Object o) {
        if (mCallbacks == null) {
            return;
        }
        final FragmentHostCallback access$000 = LoaderManagerImpl.access$000(this$0);
        String mNoTransactionsBecause = null;
        if (access$000 != null) {
            mNoTransactionsBecause = LoaderManagerImpl.access$000(this$0).mFragmentManager.mNoTransactionsBecause;
            LoaderManagerImpl.access$000(this$0).mFragmentManager.mNoTransactionsBecause = "onLoadFinished";
        }
        try {
            if (DEBUG) {
                Log.v("LoaderManager", "  onLoadFinished in " + loader + ": " + loader.dataToString(o));
            }
            mCallbacks.onLoadFinished(loader, o);
            if (LoaderManagerImpl.access$000(this$0) != null) {
                LoaderManagerImpl.access$000(this$0).mFragmentManager.mNoTransactionsBecause = mNoTransactionsBecause;
            }
            mDeliveredData = true;
        }
        finally {
            if (LoaderManagerImpl.access$000(this$0) != null) {
                LoaderManagerImpl.access$000(this$0).mFragmentManager.mNoTransactionsBecause = mNoTransactionsBecause;
            }
        }
    }
    
    void cancel() {
        if (DEBUG) {
            Log.v("LoaderManager", "  Canceling: " + this);
        }
        if (mStarted && mLoader != null && mListenerRegistered && !mLoader.cancelLoad()) {
            this.onLoadCanceled(mLoader);
        }
    }
    
    void destroy() {
        if (DEBUG) {
            Log.v("LoaderManager", "  Destroying: " + this);
        }
        mDestroyed = true;
        final boolean mDeliveredData = this.mDeliveredData;
        this.mDeliveredData = false;
        Label_0182: {
            if (mCallbacks == null || mLoader == null || !mHaveData || !mDeliveredData) {
                break Label_0182;
            }
            if (DEBUG) {
                Log.v("LoaderManager", "  Reseting: " + this);
            }
            final FragmentHostCallback access$000 = LoaderManagerImpl.access$000(this$0);
            String mNoTransactionsBecause = null;
            if (access$000 != null) {
                mNoTransactionsBecause = LoaderManagerImpl.access$000(this$0).mFragmentManager.mNoTransactionsBecause;
                LoaderManagerImpl.access$000(this$0).mFragmentManager.mNoTransactionsBecause = "onLoaderReset";
            }
            try {
                mCallbacks.onLoaderReset(mLoader);
                if (LoaderManagerImpl.access$000(this$0) != null) {
                    LoaderManagerImpl.access$000(this$0).mFragmentManager.mNoTransactionsBecause = mNoTransactionsBecause;
                }
                mCallbacks = null;
                mData = null;
                mHaveData = false;
                if (mLoader != null) {
                    if (mListenerRegistered) {
                        mListenerRegistered = false;
                        mLoader.unregisterListener((Loader.OnLoadCompleteListener<Object>)this);
                        mLoader.unregisterOnLoadCanceledListener((Loader.OnLoadCanceledListener<Object>)this);
                    }
                    mLoader.reset();
                }
                if (mPendingLoader != null) {
                    mPendingLoader.destroy();
                }
            }
            finally {
                if (LoaderManagerImpl.access$000(this$0) != null) {
                    LoaderManagerImpl.access$000(this$0).mFragmentManager.mNoTransactionsBecause = mNoTransactionsBecause;
                }
            }
        }
    }
    
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        printWriter.print(s);
        printWriter.print("mId=");
        printWriter.print(mId);
        printWriter.print(" mArgs=");
        printWriter.println(mArgs);
        printWriter.print(s);
        printWriter.print("mCallbacks=");
        printWriter.println(mCallbacks);
        printWriter.print(s);
        printWriter.print("mLoader=");
        printWriter.println(mLoader);
        if (mLoader != null) {
            mLoader.dump(s + "  ", fileDescriptor, printWriter, array);
        }
        if (mHaveData || mDeliveredData) {
            printWriter.print(s);
            printWriter.print("mHaveData=");
            printWriter.print(mHaveData);
            printWriter.print("  mDeliveredData=");
            printWriter.println(mDeliveredData);
            printWriter.print(s);
            printWriter.print("mData=");
            printWriter.println(mData);
        }
        printWriter.print(s);
        printWriter.print("mStarted=");
        printWriter.print(mStarted);
        printWriter.print(" mReportNextStart=");
        printWriter.print(mReportNextStart);
        printWriter.print(" mDestroyed=");
        printWriter.println(mDestroyed);
        printWriter.print(s);
        printWriter.print("mRetaining=");
        printWriter.print(mRetaining);
        printWriter.print(" mRetainingStarted=");
        printWriter.print(mRetainingStarted);
        printWriter.print(" mListenerRegistered=");
        printWriter.println(mListenerRegistered);
        if (mPendingLoader != null) {
            printWriter.print(s);
            printWriter.println("Pending Loader ");
            printWriter.print(mPendingLoader);
            printWriter.println(":");
            mPendingLoader.dump(s + "  ", fileDescriptor, printWriter, array);
        }
    }
    
    void finishRetain() {
        if (mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "  Finished Retaining: " + this);
            }
            mRetaining = false;
            if (mStarted != mRetainingStarted && !mStarted) {
                this.stop();
            }
        }
        if (mStarted && mHaveData && !mReportNextStart) {
            this.callOnLoadFinished(mLoader, mData);
        }
    }
    
    @Override
    public void onLoadCanceled(final Loader<Object> loader) {
        if (DEBUG) {
            Log.v("LoaderManager", "onLoadCanceled: " + this);
        }
        if (mDestroyed) {
            if (DEBUG) {
                Log.v("LoaderManager", "  Ignoring load canceled -- destroyed");
            }
        }
        else if (mLoaders.get(mId) != this) {
            if (DEBUG) {
                Log.v("LoaderManager", "  Ignoring load canceled -- not active");
            }
        }
        else {
            final LoaderInfo mPendingLoader = this.mPendingLoader;
            if (mPendingLoader != null) {
                if (DEBUG) {
                    Log.v("LoaderManager", "  Switching to pending loader: " + mPendingLoader);
                }
                this.mPendingLoader = null;
                mLoaders.put(mId, null);
                this.destroy();
                this$0.installLoader(mPendingLoader);
            }
        }
    }
    
    @Override
    public void onLoadComplete(final Loader<Object> loader, final Object mData) {
        if (DEBUG) {
            Log.v("LoaderManager", "onLoadComplete: " + this);
        }
        if (mDestroyed) {
            if (DEBUG) {
                Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
            }
        }
        else if (mLoaders.get(mId) != this) {
            if (DEBUG) {
                Log.v("LoaderManager", "  Ignoring load complete -- not active");
            }
        }
        else {
            final LoaderInfo mPendingLoader = this.mPendingLoader;
            if (mPendingLoader != null) {
                if (DEBUG) {
                    Log.v("LoaderManager", "  Switching to pending loader: " + mPendingLoader);
                }
                this.mPendingLoader = null;
                mLoaders.put(mId, null);
                this.destroy();
                this$0.installLoader(mPendingLoader);
                return;
            }
            if (this.mData != mData || !mHaveData) {
                this.mData = mData;
                mHaveData = true;
                if (mStarted) {
                    this.callOnLoadFinished(loader, mData);
                }
            }
            final LoaderInfo loaderInfo = (LoaderInfo)mInactiveLoaders.get(mId);
            if (loaderInfo != null && loaderInfo != this) {
                mDeliveredData = false;
                loaderInfo.destroy();
                mInactiveLoaders.remove(mId);
            }
            if (LoaderManagerImpl.access$000(this$0) != null && !this$0.hasRunningLoaders()) {
                LoaderManagerImpl.access$000(this$0).mFragmentManager.startPendingDeferredFragments();
            }
        }
    }
    
    void reportStart() {
        if (mStarted && mReportNextStart) {
            mReportNextStart = false;
            if (mHaveData) {
                this.callOnLoadFinished(mLoader, mData);
            }
        }
    }
    
    void retain() {
        if (DEBUG) {
            Log.v("LoaderManager", "  Retaining: " + this);
        }
        mRetaining = true;
        mRetainingStarted = mStarted;
        mStarted = false;
        mCallbacks = null;
    }
    
    void start() {
        if (mRetaining && mRetainingStarted) {
            mStarted = true;
        }
        else if (!mStarted) {
            mStarted = true;
            if (DEBUG) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            if (mLoader == null && mCallbacks != null) {
                mLoader = mCallbacks.onCreateLoader(mId, mArgs);
            }
            if (mLoader != null) {
                if (mLoader.getClass().isMemberClass() && !Modifier.isStatic(mLoader.getClass().getModifiers())) {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + mLoader);
                }
                if (!mListenerRegistered) {
                    mLoader.registerListener(mId, (Loader.OnLoadCompleteListener<Object>)this);
                    mLoader.registerOnLoadCanceledListener((Loader.OnLoadCanceledListener<Object>)this);
                    mListenerRegistered = true;
                }
                mLoader.startLoading();
            }
        }
    }
    
    void stop() {
        if (DEBUG) {
            Log.v("LoaderManager", "  Stopping: " + this);
        }
        mStarted = false;
        if (!mRetaining && mLoader != null && mListenerRegistered) {
            mListenerRegistered = false;
            mLoader.unregisterListener((Loader.OnLoadCompleteListener<Object>)this);
            mLoader.unregisterOnLoadCanceledListener((Loader.OnLoadCanceledListener<Object>)this);
            mLoader.stopLoading();
        }
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(64);
        sb.append("LoaderInfo{");
        sb.append(Integer.toHexString(System.identityHashCode((Object)this)));
        sb.append(" #");
        sb.append(mId);
        sb.append(" : ");
        DebugUtils.buildShortClassTag(mLoader, sb);
        sb.append("}}");
        return sb.toString();
    }
}
