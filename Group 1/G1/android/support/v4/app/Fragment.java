package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.support.v4.util.DebugUtils;
import java.util.List;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.ContextMenu;
import android.view.animation.Animation;
import android.view.MenuItem;
import android.content.res.Configuration;
import android.app.Activity;
import android.content.Intent;
import android.support.annotation.StringRes;
import android.content.res.Resources;
import android.support.v4.view.LayoutInflaterCompat;
import android.view.LayoutInflater;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.support.annotation.Nullable;
import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.View;
import android.support.v4.util.SimpleArrayMap;
import android.view.View$OnCreateContextMenuListener;
import android.content.ComponentCallbacks;

public class Fragment implements ComponentCallbacks, View$OnCreateContextMenuListener
{
    static final int ACTIVITY_CREATED = 2;
    static final int CREATED = 1;
    static final int INITIALIZING = 0;
    static final int RESUMED = 5;
    static final int STARTED = 4;
    static final int STOPPED = 3;
    static final Object USE_DEFAULT_TRANSITION;
    private static final SimpleArrayMap<String, Class<?>> sClassMap;
    boolean mAdded;
    Boolean mAllowEnterTransitionOverlap;
    Boolean mAllowReturnTransitionOverlap;
    View mAnimatingAway;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mCalled;
    boolean mCheckedForLoaderManager;
    FragmentManagerImpl mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    boolean mDeferStart;
    boolean mDetached;
    Object mEnterTransition;
    SharedElementCallback mEnterTransitionCallback;
    Object mExitTransition;
    SharedElementCallback mExitTransitionCallback;
    int mFragmentId;
    FragmentManagerImpl mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    FragmentHostCallback mHost;
    boolean mInLayout;
    int mIndex;
    View mInnerView;
    LoaderManagerImpl mLoaderManager;
    boolean mLoadersStarted;
    boolean mMenuVisible;
    int mNextAnim;
    Fragment mParentFragment;
    Object mReenterTransition;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetaining;
    Object mReturnTransition;
    Bundle mSavedFragmentState;
    SparseArray<Parcelable> mSavedViewState;
    Object mSharedElementEnterTransition;
    Object mSharedElementReturnTransition;
    int mState;
    int mStateAfterAnimating;
    String mTag;
    Fragment mTarget;
    int mTargetIndex;
    int mTargetRequestCode;
    boolean mUserVisibleHint;
    View mView;
    String mWho;
    
    static {
        sClassMap = new SimpleArrayMap<String, Class<?>>();
        USE_DEFAULT_TRANSITION = new Object();
    }
    
    public Fragment() {
        super();
        mState = 0;
        mIndex = -1;
        mTargetIndex = -1;
        mMenuVisible = true;
        mUserVisibleHint = true;
        mEnterTransition = null;
        mReturnTransition = USE_DEFAULT_TRANSITION;
        mExitTransition = null;
        mReenterTransition = USE_DEFAULT_TRANSITION;
        mSharedElementEnterTransition = null;
        mSharedElementReturnTransition = USE_DEFAULT_TRANSITION;
        mEnterTransitionCallback = null;
        mExitTransitionCallback = null;
    }
    
    public static Fragment instantiate(final Context context, final String s) {
        return instantiate(context, s, null);
    }
    
    public static Fragment instantiate(final Context context, final String s, @Nullable final Bundle mArguments) {
        try {
            Class<?> loadClass = (Class<?>)sClassMap.get(s);
            if (loadClass == null) {
                loadClass = context.getClassLoader().loadClass(s);
                sClassMap.put(s, loadClass);
            }
            final Fragment fragment = (Fragment)loadClass.newInstance();
            if (mArguments != null) {
                mArguments.setClassLoader(fragment.getClass().getClassLoader());
                fragment.mArguments = mArguments;
            }
            return fragment;
        }
        catch (ClassNotFoundException ex) {
            throw new InstantiationException("Unable to instantiate fragment " + s + ": make sure class name exists, is public, and has an" + " empty constructor that is public", ex);
        }
        catch (java.lang.InstantiationException ex2) {
            throw new InstantiationException("Unable to instantiate fragment " + s + ": make sure class name exists, is public, and has an" + " empty constructor that is public", ex2);
        }
        catch (IllegalAccessException ex3) {
            throw new InstantiationException("Unable to instantiate fragment " + s + ": make sure class name exists, is public, and has an" + " empty constructor that is public", ex3);
        }
    }
    
    static boolean isSupportFragmentClass(final Context context, final String s) {
        try {
            Class<?> loadClass = (Class<?>)sClassMap.get(s);
            if (loadClass == null) {
                loadClass = context.getClassLoader().loadClass(s);
                sClassMap.put(s, loadClass);
            }
            return Fragment.class.isAssignableFrom(loadClass);
        }
        catch (ClassNotFoundException ex) {
            return false;
        }
    }
    
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        printWriter.print(s);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(mTag);
        printWriter.print(s);
        printWriter.print("mState=");
        printWriter.print(mState);
        printWriter.print(" mIndex=");
        printWriter.print(mIndex);
        printWriter.print(" mWho=");
        printWriter.print(mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(mBackStackNesting);
        printWriter.print(s);
        printWriter.print("mAdded=");
        printWriter.print(mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(mInLayout);
        printWriter.print(s);
        printWriter.print("mHidden=");
        printWriter.print(mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(mHasMenu);
        printWriter.print(s);
        printWriter.print("mRetainInstance=");
        printWriter.print(mRetainInstance);
        printWriter.print(" mRetaining=");
        printWriter.print(mRetaining);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(mUserVisibleHint);
        if (mFragmentManager != null) {
            printWriter.print(s);
            printWriter.print("mFragmentManager=");
            printWriter.println(mFragmentManager);
        }
        if (mHost != null) {
            printWriter.print(s);
            printWriter.print("mHost=");
            printWriter.println(mHost);
        }
        if (mParentFragment != null) {
            printWriter.print(s);
            printWriter.print("mParentFragment=");
            printWriter.println(mParentFragment);
        }
        if (mArguments != null) {
            printWriter.print(s);
            printWriter.print("mArguments=");
            printWriter.println(mArguments);
        }
        if (mSavedFragmentState != null) {
            printWriter.print(s);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(mSavedFragmentState);
        }
        if (mSavedViewState != null) {
            printWriter.print(s);
            printWriter.print("mSavedViewState=");
            printWriter.println(mSavedViewState);
        }
        if (mTarget != null) {
            printWriter.print(s);
            printWriter.print("mTarget=");
            printWriter.print(mTarget);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(mTargetRequestCode);
        }
        if (mNextAnim != 0) {
            printWriter.print(s);
            printWriter.print("mNextAnim=");
            printWriter.println(mNextAnim);
        }
        if (mContainer != null) {
            printWriter.print(s);
            printWriter.print("mContainer=");
            printWriter.println(mContainer);
        }
        if (mView != null) {
            printWriter.print(s);
            printWriter.print("mView=");
            printWriter.println(mView);
        }
        if (mInnerView != null) {
            printWriter.print(s);
            printWriter.print("mInnerView=");
            printWriter.println(mView);
        }
        if (mAnimatingAway != null) {
            printWriter.print(s);
            printWriter.print("mAnimatingAway=");
            printWriter.println(mAnimatingAway);
            printWriter.print(s);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(mStateAfterAnimating);
        }
        if (mLoaderManager != null) {
            printWriter.print(s);
            printWriter.println("Loader Manager:");
            mLoaderManager.dump(s + "  ", fileDescriptor, printWriter, array);
        }
        if (mChildFragmentManager != null) {
            printWriter.print(s);
            printWriter.println("Child " + mChildFragmentManager + ":");
            mChildFragmentManager.dump(s + "  ", fileDescriptor, printWriter, array);
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        return super.equals(o);
    }
    
    Fragment findFragmentByWho(final String s) {
        if (s.equals(mWho)) {
            return this;
        }
        if (mChildFragmentManager != null) {
            return mChildFragmentManager.findFragmentByWho(s);
        }
        return null;
    }
    
    public final FragmentActivity getActivity() {
        if (mHost == null) {
            return null;
        }
        return (FragmentActivity)mHost.getActivity();
    }
    
    public boolean getAllowEnterTransitionOverlap() {
        return mAllowEnterTransitionOverlap == null || mAllowEnterTransitionOverlap;
    }
    
    public boolean getAllowReturnTransitionOverlap() {
        return mAllowReturnTransitionOverlap == null || mAllowReturnTransitionOverlap;
    }
    
    public final Bundle getArguments() {
        return mArguments;
    }
    
    public final FragmentManager getChildFragmentManager() {
        if (mChildFragmentManager == null) {
            this.instantiateChildFragmentManager();
            if (mState >= 5) {
                mChildFragmentManager.dispatchResume();
            }
            else if (mState >= 4) {
                mChildFragmentManager.dispatchStart();
            }
            else if (mState >= 2) {
                mChildFragmentManager.dispatchActivityCreated();
            }
            else if (mState >= 1) {
                mChildFragmentManager.dispatchCreate();
            }
        }
        return mChildFragmentManager;
    }
    
    public Context getContext() {
        if (mHost == null) {
            return null;
        }
        return mHost.getContext();
    }
    
    public Object getEnterTransition() {
        return mEnterTransition;
    }
    
    public Object getExitTransition() {
        return mExitTransition;
    }
    
    public final FragmentManager getFragmentManager() {
        return mFragmentManager;
    }
    
    public final Object getHost() {
        if (mHost == null) {
            return null;
        }
        return mHost.onGetHost();
    }
    
    public final int getId() {
        return mFragmentId;
    }
    
    public LayoutInflater getLayoutInflater(final Bundle bundle) {
        final LayoutInflater onGetLayoutInflater = mHost.onGetLayoutInflater();
        this.getChildFragmentManager();
        LayoutInflaterCompat.setFactory(onGetLayoutInflater, mChildFragmentManager.getLayoutInflaterFactory());
        return onGetLayoutInflater;
    }
    
    public LoaderManager getLoaderManager() {
        if (mLoaderManager != null) {
            return mLoaderManager;
        }
        if (mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        mCheckedForLoaderManager = true;
        return mLoaderManager = mHost.getLoaderManager(mWho, mLoadersStarted, true);
    }
    
    public final Fragment getParentFragment() {
        return mParentFragment;
    }
    
    public Object getReenterTransition() {
        if (mReenterTransition == USE_DEFAULT_TRANSITION) {
            return this.getExitTransition();
        }
        return mReenterTransition;
    }
    
    public final Resources getResources() {
        if (mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        return mHost.getContext().getResources();
    }
    
    public final boolean getRetainInstance() {
        return mRetainInstance;
    }
    
    public Object getReturnTransition() {
        if (mReturnTransition == USE_DEFAULT_TRANSITION) {
            return this.getEnterTransition();
        }
        return mReturnTransition;
    }
    
    public Object getSharedElementEnterTransition() {
        return mSharedElementEnterTransition;
    }
    
    public Object getSharedElementReturnTransition() {
        if (mSharedElementReturnTransition == USE_DEFAULT_TRANSITION) {
            return this.getSharedElementEnterTransition();
        }
        return mSharedElementReturnTransition;
    }
    
    public final String getString(@StringRes final int n) {
        return this.getResources().getString(n);
    }
    
    public final String getString(@StringRes final int n, final Object... array) {
        return this.getResources().getString(n, array);
    }
    
    public final String getTag() {
        return mTag;
    }
    
    public final Fragment getTargetFragment() {
        return mTarget;
    }
    
    public final int getTargetRequestCode() {
        return mTargetRequestCode;
    }
    
    public final CharSequence getText(@StringRes final int n) {
        return this.getResources().getText(n);
    }
    
    public boolean getUserVisibleHint() {
        return mUserVisibleHint;
    }
    
    @Nullable
    public View getView() {
        return mView;
    }
    
    public final boolean hasOptionsMenu() {
        return mHasMenu;
    }
    
    @Override
    public final int hashCode() {
        return super.hashCode();
    }
    
    void initState() {
        mIndex = -1;
        mWho = null;
        mAdded = false;
        mRemoving = false;
        mFromLayout = false;
        mInLayout = false;
        mRestored = false;
        mBackStackNesting = 0;
        mFragmentManager = null;
        mChildFragmentManager = null;
        mHost = null;
        mFragmentId = 0;
        mContainerId = 0;
        mTag = null;
        mHidden = false;
        mDetached = false;
        mRetaining = false;
        mLoaderManager = null;
        mLoadersStarted = false;
        mCheckedForLoaderManager = false;
    }
    
    void instantiateChildFragmentManager() {
        (mChildFragmentManager = new FragmentManagerImpl()).attachController(mHost, new FragmentContainer() {
            final /* synthetic */ Fragment this$0;
            
            Fragment$1() {
                this$0 = this$0;
                super();
            }
            
            @Nullable
            @Override
            public View onFindViewById(final int n) {
                if (mView == null) {
                    throw new IllegalStateException("Fragment does not have a view");
                }
                return mView.findViewById(n);
            }
            
            @Override
            public boolean onHasView() {
                return mView != null;
            }
        }, this);
    }
    
    public final boolean isAdded() {
        return mHost != null && mAdded;
    }
    
    public final boolean isDetached() {
        return mDetached;
    }
    
    public final boolean isHidden() {
        return mHidden;
    }
    
    final boolean isInBackStack() {
        return mBackStackNesting > 0;
    }
    
    public final boolean isInLayout() {
        return mInLayout;
    }
    
    public final boolean isMenuVisible() {
        return mMenuVisible;
    }
    
    public final boolean isRemoving() {
        return mRemoving;
    }
    
    public final boolean isResumed() {
        return mState >= 5;
    }
    
    public final boolean isVisible() {
        return this.isAdded() && !this.isHidden() && mView != null && mView.getWindowToken() != null && mView.getVisibility() == 0;
    }
    
    public void onActivityCreated(@Nullable final Bundle bundle) {
        mCalled = true;
    }
    
    public void onActivityResult(final int n, final int n2, final Intent intent) {
    }
    
    @Deprecated
    public void onAttach(final Activity activity) {
        mCalled = true;
    }
    
    public void onAttach(final Context context) {
        mCalled = true;
        Activity activity;
        if (mHost == null) {
            activity = null;
        }
        else {
            activity = mHost.getActivity();
        }
        if (activity != null) {
            mCalled = false;
            this.onAttach(activity);
        }
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        mCalled = true;
    }
    
    public boolean onContextItemSelected(final MenuItem menuItem) {
        return false;
    }
    
    public void onCreate(@Nullable final Bundle bundle) {
        mCalled = true;
    }
    
    public Animation onCreateAnimation(final int n, final boolean b, final int n2) {
        return null;
    }
    
    public void onCreateContextMenu(final ContextMenu contextMenu, final View view, final ContextMenu$ContextMenuInfo contextMenu$ContextMenuInfo) {
        this.getActivity().onCreateContextMenu(contextMenu, view, contextMenu$ContextMenuInfo);
    }
    
    public void onCreateOptionsMenu(final Menu menu, final MenuInflater menuInflater) {
    }
    
    @Nullable
    public View onCreateView(final LayoutInflater layoutInflater, @Nullable final ViewGroup viewGroup, @Nullable final Bundle bundle) {
        return null;
    }
    
    public void onDestroy() {
        mCalled = true;
        if (!mCheckedForLoaderManager) {
            mCheckedForLoaderManager = true;
            mLoaderManager = mHost.getLoaderManager(mWho, mLoadersStarted, false);
        }
        if (mLoaderManager != null) {
            mLoaderManager.doDestroy();
        }
    }
    
    public void onDestroyOptionsMenu() {
    }
    
    public void onDestroyView() {
        mCalled = true;
    }
    
    public void onDetach() {
        mCalled = true;
    }
    
    public void onHiddenChanged(final boolean b) {
    }
    
    @Deprecated
    public void onInflate(final Activity activity, final AttributeSet set, final Bundle bundle) {
        mCalled = true;
    }
    
    public void onInflate(final Context context, final AttributeSet set, final Bundle bundle) {
        mCalled = true;
        Activity activity;
        if (mHost == null) {
            activity = null;
        }
        else {
            activity = mHost.getActivity();
        }
        if (activity != null) {
            mCalled = false;
            this.onInflate(activity, set, bundle);
        }
    }
    
    public void onLowMemory() {
        mCalled = true;
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        return false;
    }
    
    public void onOptionsMenuClosed(final Menu menu) {
    }
    
    public void onPause() {
        mCalled = true;
    }
    
    public void onPrepareOptionsMenu(final Menu menu) {
    }
    
    public void onRequestPermissionsResult(final int n, @NonNull final String[] array, @NonNull final int[] array2) {
    }
    
    public void onResume() {
        mCalled = true;
    }
    
    public void onSaveInstanceState(final Bundle bundle) {
    }
    
    public void onStart() {
        mCalled = true;
        if (!mLoadersStarted) {
            mLoadersStarted = true;
            if (!mCheckedForLoaderManager) {
                mCheckedForLoaderManager = true;
                mLoaderManager = mHost.getLoaderManager(mWho, mLoadersStarted, false);
            }
            if (mLoaderManager != null) {
                mLoaderManager.doStart();
            }
        }
    }
    
    public void onStop() {
        mCalled = true;
    }
    
    public void onViewCreated(final View view, @Nullable final Bundle bundle) {
    }
    
    public void onViewStateRestored(@Nullable final Bundle bundle) {
        mCalled = true;
    }
    
    void performActivityCreated(final Bundle bundle) {
        if (mChildFragmentManager != null) {
            mChildFragmentManager.noteStateNotSaved();
        }
        mState = 2;
        mCalled = false;
        this.onActivityCreated(bundle);
        if (!mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
        if (mChildFragmentManager != null) {
            mChildFragmentManager.dispatchActivityCreated();
        }
    }
    
    void performConfigurationChanged(final Configuration configuration) {
        this.onConfigurationChanged(configuration);
        if (mChildFragmentManager != null) {
            mChildFragmentManager.dispatchConfigurationChanged(configuration);
        }
    }
    
    boolean performContextItemSelected(final MenuItem menuItem) {
        return !mHidden && (this.onContextItemSelected(menuItem) || (mChildFragmentManager != null && mChildFragmentManager.dispatchContextItemSelected(menuItem)));
    }
    
    void performCreate(final Bundle bundle) {
        if (mChildFragmentManager != null) {
            mChildFragmentManager.noteStateNotSaved();
        }
        mState = 1;
        mCalled = false;
        this.onCreate(bundle);
        if (!mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
        }
        if (bundle != null) {
            final Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (mChildFragmentManager == null) {
                    this.instantiateChildFragmentManager();
                }
                mChildFragmentManager.restoreAllState(parcelable, null);
                mChildFragmentManager.dispatchCreate();
            }
        }
    }
    
    boolean performCreateOptionsMenu(final Menu menu, final MenuInflater menuInflater) {
        final boolean mHidden = this.mHidden;
        boolean b = false;
        if (!mHidden) {
            final boolean mHasMenu = this.mHasMenu;
            b = false;
            if (mHasMenu) {
                final boolean mMenuVisible = this.mMenuVisible;
                b = false;
                if (mMenuVisible) {
                    b = true;
                    this.onCreateOptionsMenu(menu, menuInflater);
                }
            }
            if (mChildFragmentManager != null) {
                b |= mChildFragmentManager.dispatchCreateOptionsMenu(menu, menuInflater);
            }
        }
        return b;
    }
    
    View performCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        if (mChildFragmentManager != null) {
            mChildFragmentManager.noteStateNotSaved();
        }
        return this.onCreateView(layoutInflater, viewGroup, bundle);
    }
    
    void performDestroy() {
        if (mChildFragmentManager != null) {
            mChildFragmentManager.dispatchDestroy();
        }
        mState = 0;
        mCalled = false;
        this.onDestroy();
        if (!mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }
    
    void performDestroyView() {
        if (mChildFragmentManager != null) {
            mChildFragmentManager.dispatchDestroyView();
        }
        mState = 1;
        mCalled = false;
        this.onDestroyView();
        if (!mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
        }
        if (mLoaderManager != null) {
            mLoaderManager.doReportNextStart();
        }
    }
    
    void performLowMemory() {
        this.onLowMemory();
        if (mChildFragmentManager != null) {
            mChildFragmentManager.dispatchLowMemory();
        }
    }
    
    boolean performOptionsItemSelected(final MenuItem menuItem) {
        return !mHidden && ((mHasMenu && mMenuVisible && this.onOptionsItemSelected(menuItem)) || (mChildFragmentManager != null && mChildFragmentManager.dispatchOptionsItemSelected(menuItem)));
    }
    
    void performOptionsMenuClosed(final Menu menu) {
        if (!mHidden) {
            if (mHasMenu && mMenuVisible) {
                this.onOptionsMenuClosed(menu);
            }
            if (mChildFragmentManager != null) {
                mChildFragmentManager.dispatchOptionsMenuClosed(menu);
            }
        }
    }
    
    void performPause() {
        if (mChildFragmentManager != null) {
            mChildFragmentManager.dispatchPause();
        }
        mState = 4;
        mCalled = false;
        this.onPause();
        if (!mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
        }
    }
    
    boolean performPrepareOptionsMenu(final Menu menu) {
        final boolean mHidden = this.mHidden;
        boolean b = false;
        if (!mHidden) {
            final boolean mHasMenu = this.mHasMenu;
            b = false;
            if (mHasMenu) {
                final boolean mMenuVisible = this.mMenuVisible;
                b = false;
                if (mMenuVisible) {
                    b = true;
                    this.onPrepareOptionsMenu(menu);
                }
            }
            if (mChildFragmentManager != null) {
                b |= mChildFragmentManager.dispatchPrepareOptionsMenu(menu);
            }
        }
        return b;
    }
    
    void performReallyStop() {
        if (mChildFragmentManager != null) {
            mChildFragmentManager.dispatchReallyStop();
        }
        mState = 2;
        if (mLoadersStarted) {
            mLoadersStarted = false;
            if (!mCheckedForLoaderManager) {
                mCheckedForLoaderManager = true;
                mLoaderManager = mHost.getLoaderManager(mWho, mLoadersStarted, false);
            }
            if (mLoaderManager != null) {
                if (!mHost.getRetainLoaders()) {
                    mLoaderManager.doStop();
                    return;
                }
                mLoaderManager.doRetain();
            }
        }
    }
    
    void performResume() {
        if (mChildFragmentManager != null) {
            mChildFragmentManager.noteStateNotSaved();
            mChildFragmentManager.execPendingActions();
        }
        mState = 5;
        mCalled = false;
        this.onResume();
        if (!mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
        }
        if (mChildFragmentManager != null) {
            mChildFragmentManager.dispatchResume();
            mChildFragmentManager.execPendingActions();
        }
    }
    
    void performSaveInstanceState(final Bundle bundle) {
        this.onSaveInstanceState(bundle);
        if (mChildFragmentManager != null) {
            final Parcelable saveAllState = mChildFragmentManager.saveAllState();
            if (saveAllState != null) {
                bundle.putParcelable("android:support:fragments", saveAllState);
            }
        }
    }
    
    void performStart() {
        if (mChildFragmentManager != null) {
            mChildFragmentManager.noteStateNotSaved();
            mChildFragmentManager.execPendingActions();
        }
        mState = 4;
        mCalled = false;
        this.onStart();
        if (!mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
        }
        if (mChildFragmentManager != null) {
            mChildFragmentManager.dispatchStart();
        }
        if (mLoaderManager != null) {
            mLoaderManager.doReportStart();
        }
    }
    
    void performStop() {
        if (mChildFragmentManager != null) {
            mChildFragmentManager.dispatchStop();
        }
        mState = 3;
        mCalled = false;
        this.onStop();
        if (!mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
        }
    }
    
    public void registerForContextMenu(final View view) {
        view.setOnCreateContextMenuListener((View$OnCreateContextMenuListener)this);
    }
    
    public final void requestPermissions(@NonNull final String[] array, final int n) {
        if (mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        mHost.onRequestPermissionsFromFragment(this, array, n);
    }
    
    final void restoreViewState(final Bundle bundle) {
        if (mSavedViewState != null) {
            mInnerView.restoreHierarchyState((SparseArray)mSavedViewState);
            mSavedViewState = null;
        }
        mCalled = false;
        this.onViewStateRestored(bundle);
        if (!mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }
    
    public void setAllowEnterTransitionOverlap(final boolean b) {
        mAllowEnterTransitionOverlap = b;
    }
    
    public void setAllowReturnTransitionOverlap(final boolean b) {
        mAllowReturnTransitionOverlap = b;
    }
    
    public void setArguments(final Bundle mArguments) {
        if (mIndex >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.mArguments = mArguments;
    }
    
    public void setEnterSharedElementCallback(final SharedElementCallback mEnterTransitionCallback) {
        this.mEnterTransitionCallback = mEnterTransitionCallback;
    }
    
    public void setEnterTransition(final Object mEnterTransition) {
        this.mEnterTransition = mEnterTransition;
    }
    
    public void setExitSharedElementCallback(final SharedElementCallback mExitTransitionCallback) {
        this.mExitTransitionCallback = mExitTransitionCallback;
    }
    
    public void setExitTransition(final Object mExitTransition) {
        this.mExitTransition = mExitTransition;
    }
    
    public void setHasOptionsMenu(final boolean mHasMenu) {
        if (this.mHasMenu != mHasMenu) {
            this.mHasMenu = mHasMenu;
            if (this.isAdded() && !this.isHidden()) {
                mHost.onSupportInvalidateOptionsMenu();
            }
        }
    }
    
    final void setIndex(final int mIndex, final Fragment fragment) {
        this.mIndex = mIndex;
        if (fragment != null) {
            mWho = mWho + ":" + this.mIndex;
            return;
        }
        mWho = "android:fragment:" + this.mIndex;
    }
    
    public void setInitialSavedState(final SavedState savedState) {
        if (mIndex >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        Bundle mState;
        if (savedState != null && savedState.mState != null) {
            mState = savedState.mState;
        }
        else {
            mState = null;
        }
        mSavedFragmentState = mState;
    }
    
    public void setMenuVisibility(final boolean mMenuVisible) {
        if (this.mMenuVisible != mMenuVisible) {
            this.mMenuVisible = mMenuVisible;
            if (mHasMenu && this.isAdded() && !this.isHidden()) {
                mHost.onSupportInvalidateOptionsMenu();
            }
        }
    }
    
    public void setReenterTransition(final Object mReenterTransition) {
        this.mReenterTransition = mReenterTransition;
    }
    
    public void setRetainInstance(final boolean mRetainInstance) {
        if (mRetainInstance && mParentFragment != null) {
            throw new IllegalStateException("Can't retain fragements that are nested in other fragments");
        }
        this.mRetainInstance = mRetainInstance;
    }
    
    public void setReturnTransition(final Object mReturnTransition) {
        this.mReturnTransition = mReturnTransition;
    }
    
    public void setSharedElementEnterTransition(final Object mSharedElementEnterTransition) {
        this.mSharedElementEnterTransition = mSharedElementEnterTransition;
    }
    
    public void setSharedElementReturnTransition(final Object mSharedElementReturnTransition) {
        this.mSharedElementReturnTransition = mSharedElementReturnTransition;
    }
    
    public void setTargetFragment(final Fragment mTarget, final int mTargetRequestCode) {
        this.mTarget = mTarget;
        this.mTargetRequestCode = mTargetRequestCode;
    }
    
    public void setUserVisibleHint(final boolean mUserVisibleHint) {
        if (!this.mUserVisibleHint && mUserVisibleHint && mState < 4) {
            mFragmentManager.performPendingDeferredStart(this);
        }
        mDeferStart = !(this.mUserVisibleHint = mUserVisibleHint);
    }
    
    public boolean shouldShowRequestPermissionRationale(@NonNull final String s) {
        return mHost != null && mHost.onShouldShowRequestPermissionRationale(s);
    }
    
    public void startActivity(final Intent intent) {
        this.startActivity(intent, null);
    }
    
    public void startActivity(final Intent intent, @Nullable final Bundle bundle) {
        if (mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        mHost.onStartActivityFromFragment(this, intent, -1, bundle);
    }
    
    public void startActivityForResult(final Intent intent, final int n) {
        this.startActivityForResult(intent, n, null);
    }
    
    public void startActivityForResult(final Intent intent, final int n, @Nullable final Bundle bundle) {
        if (mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        mHost.onStartActivityFromFragment(this, intent, n, bundle);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(128);
        DebugUtils.buildShortClassTag(this, sb);
        if (mIndex >= 0) {
            sb.append(" #");
            sb.append(mIndex);
        }
        if (mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(mFragmentId));
        }
        if (mTag != null) {
            sb.append(" ");
            sb.append(mTag);
        }
        sb.append('}');
        return sb.toString();
    }
    
    public void unregisterForContextMenu(final View view) {
        view.setOnCreateContextMenuListener((View$OnCreateContextMenuListener)null);
    }
}
