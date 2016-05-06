package android.support.v4.app;

import android.os.Bundle;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.support.annotation.Nullable;
import android.view.View;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.os.Handler;
import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import android.app.Activity;

public abstract class FragmentHostCallback<E> extends FragmentContainer
{
    private final Activity mActivity;
    private SimpleArrayMap<String, LoaderManager> mAllLoaderManagers;
    private boolean mCheckedForLoaderManager;
    final Context mContext;
    final FragmentManagerImpl mFragmentManager;
    private final Handler mHandler;
    private LoaderManagerImpl mLoaderManager;
    private boolean mLoadersStarted;
    private boolean mRetainLoaders;
    final int mWindowAnimations;
    
    FragmentHostCallback(final Activity mActivity, final Context mContext, final Handler mHandler, final int mWindowAnimations) {
        super();
        mFragmentManager = new FragmentManagerImpl();
        mActivity = mActivity;
        mContext = mContext;
        mHandler = mHandler;
        mWindowAnimations = mWindowAnimations;
    }
    
    public FragmentHostCallback(final Context context, final Handler handler, final int n) {
        this(null, context, handler, n);
    }
    
    FragmentHostCallback(final FragmentActivity fragmentActivity) {
        this(fragmentActivity, (Context)fragmentActivity, fragmentActivity.mHandler, 0);
    }
    
    void doLoaderDestroy() {
        if (mLoaderManager == null) {
            return;
        }
        mLoaderManager.doDestroy();
    }
    
    void doLoaderRetain() {
        if (mLoaderManager == null) {
            return;
        }
        mLoaderManager.doRetain();
    }
    
    void doLoaderStart() {
        if (mLoadersStarted) {
            return;
        }
        mLoadersStarted = true;
        if (mLoaderManager != null) {
            mLoaderManager.doStart();
        }
        else if (!mCheckedForLoaderManager) {
            mLoaderManager = this.getLoaderManager("(root)", mLoadersStarted, false);
            if (mLoaderManager != null && !mLoaderManager.mStarted) {
                mLoaderManager.doStart();
            }
        }
        mCheckedForLoaderManager = true;
    }
    
    void doLoaderStop(final boolean mRetainLoaders) {
        this.mRetainLoaders = mRetainLoaders;
        if (mLoaderManager == null || !mLoadersStarted) {
            return;
        }
        mLoadersStarted = false;
        if (mRetainLoaders) {
            mLoaderManager.doRetain();
            return;
        }
        mLoaderManager.doStop();
    }
    
    void dumpLoaders(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        printWriter.print(s);
        printWriter.print("mLoadersStarted=");
        printWriter.println(mLoadersStarted);
        if (mLoaderManager != null) {
            printWriter.print(s);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode((Object)mLoaderManager)));
            printWriter.println(":");
            mLoaderManager.dump(s + "  ", fileDescriptor, printWriter, array);
        }
    }
    
    Activity getActivity() {
        return mActivity;
    }
    
    Context getContext() {
        return mContext;
    }
    
    FragmentManagerImpl getFragmentManagerImpl() {
        return mFragmentManager;
    }
    
    Handler getHandler() {
        return mHandler;
    }
    
    LoaderManagerImpl getLoaderManager(final String s, final boolean b, final boolean b2) {
        if (mAllLoaderManagers == null) {
            mAllLoaderManagers = new SimpleArrayMap<String, LoaderManager>();
        }
        LoaderManagerImpl loaderManagerImpl = (LoaderManagerImpl)mAllLoaderManagers.get(s);
        if (loaderManagerImpl == null) {
            if (b2) {
                loaderManagerImpl = new LoaderManagerImpl(s, this, b);
                mAllLoaderManagers.put(s, loaderManagerImpl);
            }
            return loaderManagerImpl;
        }
        loaderManagerImpl.updateHostController(this);
        return loaderManagerImpl;
    }
    
    LoaderManagerImpl getLoaderManagerImpl() {
        if (mLoaderManager != null) {
            return mLoaderManager;
        }
        mCheckedForLoaderManager = true;
        return mLoaderManager = this.getLoaderManager("(root)", mLoadersStarted, true);
    }
    
    boolean getRetainLoaders() {
        return mRetainLoaders;
    }
    
    void inactivateFragment(final String s) {
        if (mAllLoaderManagers != null) {
            final LoaderManagerImpl loaderManagerImpl = (LoaderManagerImpl)mAllLoaderManagers.get(s);
            if (loaderManagerImpl != null && !loaderManagerImpl.mRetaining) {
                loaderManagerImpl.doDestroy();
                mAllLoaderManagers.remove(s);
            }
        }
    }
    
    void onAttachFragment(final Fragment fragment) {
    }
    
    public void onDump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
    }
    
    @Nullable
    @Override
    public View onFindViewById(final int n) {
        return null;
    }
    
    @Nullable
    public abstract E onGetHost();
    
    public LayoutInflater onGetLayoutInflater() {
        return (LayoutInflater)mContext.getSystemService("layout_inflater");
    }
    
    public int onGetWindowAnimations() {
        return mWindowAnimations;
    }
    
    @Override
    public boolean onHasView() {
        return true;
    }
    
    public boolean onHasWindowAnimations() {
        return true;
    }
    
    public void onRequestPermissionsFromFragment(@NonNull final Fragment fragment, @NonNull final String[] array, final int n) {
    }
    
    public boolean onShouldSaveFragmentState(final Fragment fragment) {
        return true;
    }
    
    public boolean onShouldShowRequestPermissionRationale(@NonNull final String s) {
        return false;
    }
    
    public void onStartActivityFromFragment(final Fragment fragment, final Intent intent, final int n) {
        this.onStartActivityFromFragment(fragment, intent, n, null);
    }
    
    public void onStartActivityFromFragment(final Fragment fragment, final Intent intent, final int n, @Nullable final Bundle bundle) {
        if (n != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        mContext.startActivity(intent);
    }
    
    public void onSupportInvalidateOptionsMenu() {
    }
    
    void reportLoaderStart() {
        if (mAllLoaderManagers != null) {
            final int size = mAllLoaderManagers.size();
            final LoaderManagerImpl[] array = new LoaderManagerImpl[size];
            for (int i = size - 1; i >= 0; --i) {
                array[i] = (LoaderManagerImpl)mAllLoaderManagers.valueAt(i);
            }
            for (final LoaderManagerImpl loaderManagerImpl : array) {
                loaderManagerImpl.finishRetain();
                loaderManagerImpl.doReportStart();
            }
        }
    }
    
    void restoreLoaderNonConfig(final SimpleArrayMap<String, LoaderManager> mAllLoaderManagers) {
        this.mAllLoaderManagers = mAllLoaderManagers;
    }
    
    SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
        final SimpleArrayMap<String, LoaderManager> mAllLoaderManagers = this.mAllLoaderManagers;
        boolean b = false;
        if (mAllLoaderManagers != null) {
            final int size = this.mAllLoaderManagers.size();
            final LoaderManagerImpl[] array = new LoaderManagerImpl[size];
            for (int i = size - 1; i >= 0; --i) {
                array[i] = (LoaderManagerImpl)this.mAllLoaderManagers.valueAt(i);
            }
            for (final LoaderManagerImpl loaderManagerImpl : array) {
                if (loaderManagerImpl.mRetaining) {
                    b = true;
                }
                else {
                    loaderManagerImpl.doDestroy();
                    this.mAllLoaderManagers.remove(loaderManagerImpl.mWho);
                }
            }
        }
        if (b) {
            return this.mAllLoaderManagers;
        }
        return null;
    }
}
