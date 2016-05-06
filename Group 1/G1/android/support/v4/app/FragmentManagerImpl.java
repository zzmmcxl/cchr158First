package android.support.v4.app;

import android.support.annotation.CallSuper;
import android.graphics.Paint;
import android.support.v4.util.DebugUtils;
import android.os.Handler;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.os.Looper;
import java.util.Arrays;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.content.res.Configuration;
import java.io.FileDescriptor;
import java.io.Writer;
import java.io.PrintWriter;
import android.support.v4.util.LogWriter;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.animation.Animation$AnimationListener;
import android.view.View;
import java.util.List;
import android.view.animation.ScaleAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.content.Context;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import java.util.ArrayList;
import java.lang.reflect.Field;
import android.view.animation.Interpolator;
import android.support.v4.view.LayoutInflaterFactory;

final class FragmentManagerImpl extends FragmentManager implements LayoutInflaterFactory
{
    static final Interpolator ACCELERATE_CUBIC;
    static final Interpolator ACCELERATE_QUINT;
    static final int ANIM_DUR = 220;
    public static final int ANIM_STYLE_CLOSE_ENTER = 3;
    public static final int ANIM_STYLE_CLOSE_EXIT = 4;
    public static final int ANIM_STYLE_FADE_ENTER = 5;
    public static final int ANIM_STYLE_FADE_EXIT = 6;
    public static final int ANIM_STYLE_OPEN_ENTER = 1;
    public static final int ANIM_STYLE_OPEN_EXIT = 2;
    static boolean DEBUG = false;
    static final Interpolator DECELERATE_CUBIC;
    static final Interpolator DECELERATE_QUINT;
    static final boolean HONEYCOMB = false;
    static final String TAG = "FragmentManager";
    static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    static final String TARGET_STATE_TAG = "android:target_state";
    static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    static final String VIEW_STATE_TAG = "android:view_state";
    static Field sAnimationListenerField;
    ArrayList<Fragment> mActive;
    ArrayList<Fragment> mAdded;
    ArrayList<Integer> mAvailBackStackIndices;
    ArrayList<Integer> mAvailIndices;
    ArrayList<BackStackRecord> mBackStack;
    ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    ArrayList<BackStackRecord> mBackStackIndices;
    FragmentContainer mContainer;
    FragmentController mController;
    ArrayList<Fragment> mCreatedMenus;
    int mCurState;
    boolean mDestroyed;
    Runnable mExecCommit;
    boolean mExecutingActions;
    boolean mHavePendingDeferredStart;
    FragmentHostCallback mHost;
    boolean mNeedMenuInvalidate;
    String mNoTransactionsBecause;
    Fragment mParent;
    ArrayList<Runnable> mPendingActions;
    SparseArray<Parcelable> mStateArray;
    Bundle mStateBundle;
    boolean mStateSaved;
    Runnable[] mTmpActions;
    
    static {
        DEBUG = false;
        final int sdk_INT = Build$VERSION.SDK_INT;
        boolean honeycomb = false;
        if (sdk_INT >= 11) {
            honeycomb = true;
        }
        sAnimationListenerField = null;
        DECELERATE_QUINT = (Interpolator)new DecelerateInterpolator(2.5f);
        DECELERATE_CUBIC = (Interpolator)new DecelerateInterpolator(1.5f);
        ACCELERATE_QUINT = (Interpolator)new AccelerateInterpolator(2.5f);
        ACCELERATE_CUBIC = (Interpolator)new AccelerateInterpolator(1.5f);
    }
    
    FragmentManagerImpl() {
        super();
        mCurState = 0;
        mStateBundle = null;
        mStateArray = null;
        mExecCommit = new Runnable() {
            final /* synthetic */ FragmentManagerImpl this$0;
            
            FragmentManagerImpl$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                this$0.execPendingActions();
            }
        };
    }
    
    private void checkStateLoss() {
        if (mStateSaved) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (mNoTransactionsBecause != null) {
            throw new IllegalStateException("Can not perform this action inside of " + mNoTransactionsBecause);
        }
    }
    
    static Animation makeFadeAnimation(final Context context, final float n, final float n2) {
        final AlphaAnimation alphaAnimation = new AlphaAnimation(n, n2);
        alphaAnimation.setInterpolator(DECELERATE_CUBIC);
        alphaAnimation.setDuration(220L);
        return (Animation)alphaAnimation;
    }
    
    static Animation makeOpenCloseAnimation(final Context context, final float n, final float n2, final float n3, final float n4) {
        final AnimationSet set = new AnimationSet(false);
        final ScaleAnimation scaleAnimation = new ScaleAnimation(n, n2, n, n2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(DECELERATE_QUINT);
        scaleAnimation.setDuration(220L);
        set.addAnimation((Animation)scaleAnimation);
        final AlphaAnimation alphaAnimation = new AlphaAnimation(n3, n4);
        alphaAnimation.setInterpolator(DECELERATE_CUBIC);
        alphaAnimation.setDuration(220L);
        set.addAnimation((Animation)alphaAnimation);
        return (Animation)set;
    }
    
    static boolean modifiesAlpha(final Animation animation) {
        if (!(animation instanceof AlphaAnimation)) {
            if (animation instanceof AnimationSet) {
                final List animations = ((AnimationSet)animation).getAnimations();
                for (int i = 0; i < animations.size(); ++i) {
                    if (animations.get(i) instanceof AlphaAnimation) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
    
    public static int reverseTransit(final int n) {
        switch (n) {
            default:
                return 0;
            case 4097:
                return 8194;
            case 8194:
                return 4097;
            case 4099:
                return 4099;
        }
    }
    
    private void setHWLayerAnimListenerIfAlpha(final View view, final Animation animation) {
        if (view == null || animation == null || !shouldRunOnHWLayer(view, animation)) {
            return;
        }
        while (true) {
            try {
                if (sAnimationListenerField == null) {
                    (sAnimationListenerField = Animation.class.getDeclaredField("mListener")).setAccessible(true);
                }
                final Animation$AnimationListener animation$AnimationListener = (Animation$AnimationListener)sAnimationListenerField.get(animation);
                animation.setAnimationListener((Animation$AnimationListener)new AnimateOnHWLayerIfNeededListener(view, animation, animation$AnimationListener));
            }
            catch (NoSuchFieldException ex) {
                Log.e("FragmentManager", "No field with the name mListener is found in Animation class", (Throwable)ex);
                final Animation$AnimationListener animation$AnimationListener = null;
                continue;
            }
            catch (IllegalAccessException ex2) {
                Log.e("FragmentManager", "Cannot access Animation's mListener field", (Throwable)ex2);
                final Animation$AnimationListener animation$AnimationListener = null;
                continue;
            }
            break;
        }
    }
    
    static boolean shouldRunOnHWLayer(final View view, final Animation animation) {
        return Build$VERSION.SDK_INT >= 19 && ViewCompat.getLayerType(view) == 0 && ViewCompat.hasOverlappingRendering(view) && modifiesAlpha(animation);
    }
    
    private void throwException(final RuntimeException ex) {
        Log.e("FragmentManager", ex.getMessage());
        Log.e("FragmentManager", "Activity state:");
        final PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
        while (true) {
            Label_0079: {
                if (mHost == null) {
                    break Label_0079;
                }
                try {
                    mHost.onDump("  ", null, printWriter, new String[0]);
                    throw ex;
                }
                catch (Exception ex2) {
                    Log.e("FragmentManager", "Failed dumping state", (Throwable)ex2);
                    throw ex;
                }
                try {
                    this.dump("  ", null, printWriter, new String[0]);
                    continue;
                }
                catch (Exception ex3) {
                    Log.e("FragmentManager", "Failed dumping state", (Throwable)ex3);
                    continue;
                }
            }
            continue;
        }
    }
    
    public static int transitToStyleIndex(final int n, final boolean b) {
        switch (n) {
            default:
                return -1;
            case 4097:
                if (b) {
                    return 1;
                }
                return 2;
            case 8194:
                if (b) {
                    return 3;
                }
                return 4;
            case 4099:
                if (b) {
                    return 5;
                }
                return 6;
        }
    }
    
    void addBackStackState(final BackStackRecord backStackRecord) {
        if (mBackStack == null) {
            mBackStack = new ArrayList<BackStackRecord>();
        }
        mBackStack.add(backStackRecord);
        this.reportBackStackChanged();
    }
    
    public void addFragment(final Fragment fragment, final boolean b) {
        if (mAdded == null) {
            mAdded = new ArrayList<Fragment>();
        }
        if (DEBUG) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        this.makeActive(fragment);
        if (!fragment.mDetached) {
            if (mAdded.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            mAdded.add(fragment);
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                mNeedMenuInvalidate = true;
            }
            if (b) {
                this.moveToState(fragment);
            }
        }
    }
    
    @Override
    public void addOnBackStackChangedListener(final OnBackStackChangedListener onBackStackChangedListener) {
        if (mBackStackChangeListeners == null) {
            mBackStackChangeListeners = new ArrayList<OnBackStackChangedListener>();
        }
        mBackStackChangeListeners.add(onBackStackChangedListener);
    }
    
    public int allocBackStackIndex(final BackStackRecord backStackRecord) {
        synchronized (this) {
            if (mAvailBackStackIndices == null || mAvailBackStackIndices.size() <= 0) {
                if (mBackStackIndices == null) {
                    mBackStackIndices = new ArrayList<BackStackRecord>();
                }
                final int size = mBackStackIndices.size();
                if (DEBUG) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + backStackRecord);
                }
                mBackStackIndices.add(backStackRecord);
                return size;
            }
            final int intValue = (int)mAvailBackStackIndices.remove(-1 + mAvailBackStackIndices.size());
            if (DEBUG) {
                Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + backStackRecord);
            }
            mBackStackIndices.set(intValue, backStackRecord);
            return intValue;
        }
    }
    
    public void attachController(final FragmentHostCallback mHost, final FragmentContainer mContainer, final Fragment mParent) {
        if (this.mHost != null) {
            throw new IllegalStateException("Already attached");
        }
        this.mHost = mHost;
        this.mContainer = mContainer;
        this.mParent = mParent;
    }
    
    public void attachFragment(final Fragment fragment, final int n, final int n2) {
        if (DEBUG) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                if (mAdded == null) {
                    mAdded = new ArrayList<Fragment>();
                }
                if (mAdded.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (DEBUG) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                mAdded.add(fragment);
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    mNeedMenuInvalidate = true;
                }
                this.moveToState(fragment, mCurState, n, n2, false);
            }
        }
    }
    
    @Override
    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }
    
    public void detachFragment(final Fragment fragment, final int n, final int n2) {
        if (DEBUG) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (mAdded != null) {
                    if (DEBUG) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    mAdded.remove(fragment);
                }
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    mNeedMenuInvalidate = true;
                }
                this.moveToState(fragment, 1, n, n2, fragment.mAdded = false);
            }
        }
    }
    
    public void dispatchActivityCreated() {
        this.moveToState(2, mStateSaved = false);
    }
    
    public void dispatchConfigurationChanged(final Configuration configuration) {
        if (mAdded != null) {
            for (int i = 0; i < mAdded.size(); ++i) {
                final Fragment fragment = (Fragment)mAdded.get(i);
                if (fragment != null) {
                    fragment.performConfigurationChanged(configuration);
                }
            }
        }
    }
    
    public boolean dispatchContextItemSelected(final MenuItem menuItem) {
        if (mAdded != null) {
            for (int i = 0; i < mAdded.size(); ++i) {
                final Fragment fragment = (Fragment)mAdded.get(i);
                if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void dispatchCreate() {
        this.moveToState(1, mStateSaved = false);
    }
    
    public boolean dispatchCreateOptionsMenu(final Menu menu, final MenuInflater menuInflater) {
        final ArrayList<Fragment> mAdded = this.mAdded;
        ArrayList<Fragment> mCreatedMenus = null;
        boolean b = false;
        if (mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); ++i) {
                final Fragment fragment = (Fragment)this.mAdded.get(i);
                if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                    b = true;
                    if (mCreatedMenus == null) {
                        mCreatedMenus = new ArrayList<Fragment>();
                    }
                    mCreatedMenus.add(fragment);
                }
            }
        }
        if (this.mCreatedMenus != null) {
            for (int j = 0; j < this.mCreatedMenus.size(); ++j) {
                final Fragment fragment2 = (Fragment)this.mCreatedMenus.get(j);
                if (mCreatedMenus == null || !mCreatedMenus.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.mCreatedMenus = mCreatedMenus;
        return b;
    }
    
    public void dispatchDestroy() {
        mDestroyed = true;
        this.execPendingActions();
        this.moveToState(0, false);
        mHost = null;
        mContainer = null;
        mParent = null;
    }
    
    public void dispatchDestroyView() {
        this.moveToState(1, false);
    }
    
    public void dispatchLowMemory() {
        if (mAdded != null) {
            for (int i = 0; i < mAdded.size(); ++i) {
                final Fragment fragment = (Fragment)mAdded.get(i);
                if (fragment != null) {
                    fragment.performLowMemory();
                }
            }
        }
    }
    
    public boolean dispatchOptionsItemSelected(final MenuItem menuItem) {
        if (mAdded != null) {
            for (int i = 0; i < mAdded.size(); ++i) {
                final Fragment fragment = (Fragment)mAdded.get(i);
                if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void dispatchOptionsMenuClosed(final Menu menu) {
        if (mAdded != null) {
            for (int i = 0; i < mAdded.size(); ++i) {
                final Fragment fragment = (Fragment)mAdded.get(i);
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }
    
    public void dispatchPause() {
        this.moveToState(4, false);
    }
    
    public boolean dispatchPrepareOptionsMenu(final Menu menu) {
        final ArrayList<Fragment> mAdded = this.mAdded;
        boolean b = false;
        if (mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); ++i) {
                final Fragment fragment = (Fragment)this.mAdded.get(i);
                if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                    b = true;
                }
            }
        }
        return b;
    }
    
    public void dispatchReallyStop() {
        this.moveToState(2, false);
    }
    
    public void dispatchResume() {
        this.moveToState(5, mStateSaved = false);
    }
    
    public void dispatchStart() {
        this.moveToState(4, mStateSaved = false);
    }
    
    public void dispatchStop() {
        mStateSaved = true;
        this.moveToState(3, false);
    }
    
    @Override
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        final String string = s + "    ";
        if (mActive != null) {
            final int size = mActive.size();
            if (size > 0) {
                printWriter.print(s);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode((Object)this)));
                printWriter.println(":");
                for (int i = 0; i < size; ++i) {
                    final Fragment fragment = (Fragment)mActive.get(i);
                    printWriter.print(s);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.dump(string, fileDescriptor, printWriter, array);
                    }
                }
            }
        }
        if (mAdded != null) {
            final int size2 = mAdded.size();
            if (size2 > 0) {
                printWriter.print(s);
                printWriter.println("Added Fragments:");
                for (int j = 0; j < size2; ++j) {
                    final Fragment fragment2 = (Fragment)mAdded.get(j);
                    printWriter.print(s);
                    printWriter.print("  #");
                    printWriter.print(j);
                    printWriter.print(": ");
                    printWriter.println(fragment2.toString());
                }
            }
        }
        if (mCreatedMenus != null) {
            final int size3 = mCreatedMenus.size();
            if (size3 > 0) {
                printWriter.print(s);
                printWriter.println("Fragments Created Menus:");
                for (int k = 0; k < size3; ++k) {
                    final Fragment fragment3 = (Fragment)mCreatedMenus.get(k);
                    printWriter.print(s);
                    printWriter.print("  #");
                    printWriter.print(k);
                    printWriter.print(": ");
                    printWriter.println(fragment3.toString());
                }
            }
        }
        if (mBackStack != null) {
            final int size4 = mBackStack.size();
            if (size4 > 0) {
                printWriter.print(s);
                printWriter.println("Back Stack:");
                for (int l = 0; l < size4; ++l) {
                    final BackStackRecord backStackRecord = (BackStackRecord)mBackStack.get(l);
                    printWriter.print(s);
                    printWriter.print("  #");
                    printWriter.print(l);
                    printWriter.print(": ");
                    printWriter.println(backStackRecord.toString());
                    backStackRecord.dump(string, fileDescriptor, printWriter, array);
                }
            }
        }
        synchronized (this) {
            if (mBackStackIndices != null) {
                final int size5 = mBackStackIndices.size();
                if (size5 > 0) {
                    printWriter.print(s);
                    printWriter.println("Back Stack Indices:");
                    for (int n = 0; n < size5; ++n) {
                        final BackStackRecord backStackRecord2 = (BackStackRecord)mBackStackIndices.get(n);
                        printWriter.print(s);
                        printWriter.print("  #");
                        printWriter.print(n);
                        printWriter.print(": ");
                        printWriter.println(backStackRecord2);
                    }
                }
            }
            if (mAvailBackStackIndices != null && mAvailBackStackIndices.size() > 0) {
                printWriter.print(s);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(mAvailBackStackIndices.toArray()));
            }
            // monitorexit(this)
            if (mPendingActions != null) {
                final int size6 = mPendingActions.size();
                if (size6 > 0) {
                    printWriter.print(s);
                    printWriter.println("Pending Actions:");
                    for (int n2 = 0; n2 < size6; ++n2) {
                        final Runnable runnable = (Runnable)mPendingActions.get(n2);
                        printWriter.print(s);
                        printWriter.print("  #");
                        printWriter.print(n2);
                        printWriter.print(": ");
                        printWriter.println(runnable);
                    }
                }
            }
        }
        printWriter.print(s);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(s);
        printWriter.print("  mHost=");
        printWriter.println(mHost);
        printWriter.print(s);
        printWriter.print("  mContainer=");
        printWriter.println(mContainer);
        if (mParent != null) {
            printWriter.print(s);
            printWriter.print("  mParent=");
            printWriter.println(mParent);
        }
        printWriter.print(s);
        printWriter.print("  mCurState=");
        printWriter.print(mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(mStateSaved);
        printWriter.print(" mDestroyed=");
        printWriter.println(mDestroyed);
        if (mNeedMenuInvalidate) {
            printWriter.print(s);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(mNeedMenuInvalidate);
        }
        if (mNoTransactionsBecause != null) {
            printWriter.print(s);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(mNoTransactionsBecause);
        }
        if (mAvailIndices != null && mAvailIndices.size() > 0) {
            printWriter.print(s);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(mAvailIndices.toArray()));
        }
    }
    
    public void enqueueAction(final Runnable runnable, final boolean b) {
        if (!b) {
            this.checkStateLoss();
        }
        synchronized (this) {
            if (mDestroyed || mHost == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
        if (mPendingActions == null) {
            mPendingActions = new ArrayList<Runnable>();
        }
        mPendingActions.add(runnable);
        if (mPendingActions.size() == 1) {
            mHost.getHandler().removeCallbacks(mExecCommit);
            mHost.getHandler().post(mExecCommit);
        }
    }
    // monitorexit(this)
    
    public boolean execPendingActions() {
        if (mExecutingActions) {
            throw new IllegalStateException("Recursive entry to executePendingTransactions");
        }
        if (Looper.myLooper() != mHost.getHandler().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of process");
        }
        boolean b = false;
        while (true) {
            boolean b2 = false;
            Label_0262: {
                synchronized (this) {
                    if (mPendingActions == null || mPendingActions.size() == 0) {
                        // monitorexit(this)
                        if (mHavePendingDeferredStart) {
                            b2 = false;
                            for (int i = 0; i < mActive.size(); ++i) {
                                final Fragment fragment = (Fragment)mActive.get(i);
                                if (fragment != null && fragment.mLoaderManager != null) {
                                    b2 |= fragment.mLoaderManager.hasRunningLoaders();
                                }
                            }
                            break Label_0262;
                        }
                        break;
                    }
                    else {
                        final int size = mPendingActions.size();
                        if (mTmpActions == null || mTmpActions.length < size) {
                            mTmpActions = new Runnable[size];
                        }
                        mPendingActions.<Runnable>toArray(mTmpActions);
                        mPendingActions.clear();
                        mHost.getHandler().removeCallbacks(mExecCommit);
                        // monitorexit(this)
                        mExecutingActions = true;
                        for (int j = 0; j < size; ++j) {
                            mTmpActions[j].run();
                            mTmpActions[j] = null;
                        }
                    }
                }
                mExecutingActions = false;
                b = true;
                continue;
            }
            if (!b2) {
                mHavePendingDeferredStart = false;
                this.startPendingDeferredFragments();
                break;
            }
            break;
        }
        return b;
    }
    
    @Override
    public boolean executePendingTransactions() {
        return this.execPendingActions();
    }
    
    @Override
    public Fragment findFragmentById(final int n) {
        if (mAdded != null) {
            for (int i = -1 + mAdded.size(); i >= 0; --i) {
                final Fragment fragment = (Fragment)mAdded.get(i);
                if (fragment != null && fragment.mFragmentId == n) {
                    return fragment;
                }
            }
        }
        Label_0056: {
            break Label_0056;
        }
        if (mActive != null) {
            for (int j = -1 + mActive.size(); j >= 0; --j) {
                final Fragment fragment = (Fragment)mActive.get(j);
                if (fragment != null && fragment.mFragmentId == n) {
                    return fragment;
                }
            }
        }
        return null;
    }
    
    @Override
    public Fragment findFragmentByTag(final String s) {
        if (mAdded != null && s != null) {
            for (int i = -1 + mAdded.size(); i >= 0; --i) {
                final Fragment fragment = (Fragment)mAdded.get(i);
                if (fragment != null && s.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        Label_0063: {
            break Label_0063;
        }
        if (mActive != null && s != null) {
            for (int j = -1 + mActive.size(); j >= 0; --j) {
                final Fragment fragment = (Fragment)mActive.get(j);
                if (fragment != null && s.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        return null;
    }
    
    public Fragment findFragmentByWho(final String s) {
        if (mActive != null && s != null) {
            for (int i = -1 + mActive.size(); i >= 0; --i) {
                final Fragment fragment = (Fragment)mActive.get(i);
                if (fragment != null) {
                    final Fragment fragmentByWho = fragment.findFragmentByWho(s);
                    if (fragmentByWho != null) {
                        return fragmentByWho;
                    }
                }
            }
        }
        return null;
    }
    
    public void freeBackStackIndex(final int n) {
        synchronized (this) {
            mBackStackIndices.set(n, null);
            if (mAvailBackStackIndices == null) {
                mAvailBackStackIndices = new ArrayList<Integer>();
            }
            if (DEBUG) {
                Log.v("FragmentManager", "Freeing back stack index " + n);
            }
            mAvailBackStackIndices.add(n);
        }
    }
    
    @Override
    public BackStackEntry getBackStackEntryAt(final int n) {
        return mBackStack.get(n);
    }
    
    @Override
    public int getBackStackEntryCount() {
        if (mBackStack != null) {
            return mBackStack.size();
        }
        return 0;
    }
    
    @Override
    public Fragment getFragment(final Bundle bundle, final String s) {
        final int int1 = bundle.getInt(s, -1);
        Fragment fragment;
        if (int1 == -1) {
            fragment = null;
        }
        else {
            if (int1 >= mActive.size()) {
                this.throwException(new IllegalStateException("Fragment no longer exists for key " + s + ": index " + int1));
            }
            fragment = mActive.get(int1);
            if (fragment == null) {
                this.throwException(new IllegalStateException("Fragment no longer exists for key " + s + ": index " + int1));
                return fragment;
            }
        }
        return fragment;
    }
    
    @Override
    public List<Fragment> getFragments() {
        return mActive;
    }
    
    LayoutInflaterFactory getLayoutInflaterFactory() {
        return this;
    }
    
    public void hideFragment(final Fragment fragment, final int n, final int n2) {
        if (DEBUG) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            if (fragment.mView != null) {
                final Animation loadAnimation = this.loadAnimation(fragment, n, false, n2);
                if (loadAnimation != null) {
                    this.setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                    fragment.mView.startAnimation(loadAnimation);
                }
                fragment.mView.setVisibility(8);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                mNeedMenuInvalidate = true;
            }
            fragment.onHiddenChanged(true);
        }
    }
    
    @Override
    public boolean isDestroyed() {
        return mDestroyed;
    }
    
    Animation loadAnimation(final Fragment fragment, final int n, final boolean b, int onGetWindowAnimations) {
        final Animation onCreateAnimation = fragment.onCreateAnimation(n, b, fragment.mNextAnim);
        if (onCreateAnimation != null) {
            return onCreateAnimation;
        }
        if (fragment.mNextAnim != 0) {
            final Animation loadAnimation = AnimationUtils.loadAnimation(mHost.getContext(), fragment.mNextAnim);
            if (loadAnimation != null) {
                return loadAnimation;
            }
        }
        if (n == 0) {
            return null;
        }
        final int transitToStyleIndex = transitToStyleIndex(n, b);
        if (transitToStyleIndex < 0) {
            return null;
        }
        switch (transitToStyleIndex) {
            default:
                if (onGetWindowAnimations == 0 && mHost.onHasWindowAnimations()) {
                    onGetWindowAnimations = mHost.onGetWindowAnimations();
                }
                if (onGetWindowAnimations == 0) {
                    return null;
                }
                return null;
            case 1:
                return makeOpenCloseAnimation(mHost.getContext(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return makeOpenCloseAnimation(mHost.getContext(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return makeOpenCloseAnimation(mHost.getContext(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return makeOpenCloseAnimation(mHost.getContext(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return makeFadeAnimation(mHost.getContext(), 0.0f, 1.0f);
            case 6:
                return makeFadeAnimation(mHost.getContext(), 1.0f, 0.0f);
        }
    }
    
    void makeActive(final Fragment fragment) {
        if (fragment.mIndex < 0) {
            if (mAvailIndices == null || mAvailIndices.size() <= 0) {
                if (mActive == null) {
                    mActive = new ArrayList<Fragment>();
                }
                fragment.setIndex(mActive.size(), mParent);
                mActive.add(fragment);
            }
            else {
                fragment.setIndex(mAvailIndices.remove(-1 + mAvailIndices.size()), mParent);
                mActive.set(fragment.mIndex, fragment);
            }
            if (DEBUG) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }
    
    void makeInactive(final Fragment fragment) {
        if (fragment.mIndex < 0) {
            return;
        }
        if (DEBUG) {
            Log.v("FragmentManager", "Freeing fragment index " + fragment);
        }
        mActive.set(fragment.mIndex, null);
        if (mAvailIndices == null) {
            mAvailIndices = new ArrayList<Integer>();
        }
        mAvailIndices.add(fragment.mIndex);
        mHost.inactivateFragment(fragment.mWho);
        fragment.initState();
    }
    
    void moveToState(final int mCurState, final int n, final int n2, final boolean b) {
        if (mHost == null && mCurState != 0) {
            throw new IllegalStateException("No host");
        }
        if (b || this.mCurState != mCurState) {
            this.mCurState = mCurState;
            if (mActive != null) {
                boolean b2 = false;
                for (int i = 0; i < mActive.size(); ++i) {
                    final Fragment fragment = (Fragment)mActive.get(i);
                    if (fragment != null) {
                        this.moveToState(fragment, mCurState, n, n2, false);
                        if (fragment.mLoaderManager != null) {
                            b2 |= fragment.mLoaderManager.hasRunningLoaders();
                        }
                    }
                }
                if (!b2) {
                    this.startPendingDeferredFragments();
                }
                if (mNeedMenuInvalidate && mHost != null && this.mCurState == 5) {
                    mHost.onSupportInvalidateOptionsMenu();
                    mNeedMenuInvalidate = false;
                }
            }
        }
    }
    
    void moveToState(final int n, final boolean b) {
        this.moveToState(n, 0, 0, b);
    }
    
    void moveToState(final Fragment fragment) {
        this.moveToState(fragment, mCurState, 0, 0, false);
    }
    
    void moveToState(final Fragment fragment, int mState, final int n, final int n2, final boolean b) {
        if ((!fragment.mAdded || fragment.mDetached) && mState > 1) {
            mState = 1;
        }
        if (fragment.mRemoving && mState > fragment.mState) {
            mState = fragment.mState;
        }
        if (fragment.mDeferStart && fragment.mState < 4 && mState > 3) {
            mState = 3;
        }
        Label_0148: {
            if (fragment.mState < mState) {
                if (!fragment.mFromLayout || fragment.mInLayout) {
                    if (fragment.mAnimatingAway != null) {
                        fragment.mAnimatingAway = null;
                        this.moveToState(fragment, fragment.mStateAfterAnimating, 0, 0, true);
                    }
                    Label_0583: {
                        switch (fragment.mState) {
                            case 0: {
                                if (DEBUG) {
                                    Log.v("FragmentManager", "moveto CREATED: " + fragment);
                                }
                                if (fragment.mSavedFragmentState != null) {
                                    fragment.mSavedFragmentState.setClassLoader(mHost.getContext().getClassLoader());
                                    fragment.mSavedViewState = (SparseArray<Parcelable>)fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                                    fragment.mTarget = this.getFragment(fragment.mSavedFragmentState, "android:target_state");
                                    if (fragment.mTarget != null) {
                                        fragment.mTargetRequestCode = fragment.mSavedFragmentState.getInt("android:target_req_state", 0);
                                    }
                                    if (!(fragment.mUserVisibleHint = fragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true))) {
                                        fragment.mDeferStart = true;
                                        if (mState > 3) {
                                            mState = 3;
                                        }
                                    }
                                }
                                fragment.mHost = mHost;
                                fragment.mParentFragment = mParent;
                                FragmentManagerImpl mFragmentManager;
                                if (mParent != null) {
                                    mFragmentManager = mParent.mChildFragmentManager;
                                }
                                else {
                                    mFragmentManager = mHost.getFragmentManagerImpl();
                                }
                                fragment.mFragmentManager = mFragmentManager;
                                fragment.mCalled = false;
                                fragment.onAttach(mHost.getContext());
                                if (!fragment.mCalled) {
                                    throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onAttach()");
                                }
                                if (fragment.mParentFragment == null) {
                                    mHost.onAttachFragment(fragment);
                                }
                                if (!fragment.mRetaining) {
                                    fragment.performCreate(fragment.mSavedFragmentState);
                                }
                                fragment.mRetaining = false;
                                if (!fragment.mFromLayout) {
                                    break Label_0583;
                                }
                                fragment.mView = fragment.performCreateView(fragment.getLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
                                if (fragment.mView != null) {
                                    fragment.mInnerView = fragment.mView;
                                    if (Build$VERSION.SDK_INT >= 11) {
                                        ViewCompat.setSaveFromParentEnabled(fragment.mView, false);
                                    }
                                    else {
                                        fragment.mView = (View)NoSaveStateFrameLayout.wrap(fragment.mView);
                                    }
                                    if (fragment.mHidden) {
                                        fragment.mView.setVisibility(8);
                                    }
                                    fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                                    break Label_0583;
                                }
                                fragment.mInnerView = null;
                                break Label_0583;
                            }
                            case 1:
                                if (mState > 1) {
                                    if (DEBUG) {
                                        Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + fragment);
                                    }
                                    if (!fragment.mFromLayout) {
                                        final int mContainerId = fragment.mContainerId;
                                        ViewGroup mContainer = null;
                                        if (mContainerId != 0) {
                                            mContainer = (ViewGroup)this.mContainer.onFindViewById(fragment.mContainerId);
                                            if (mContainer == null && !fragment.mRestored) {
                                                this.throwException(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.mContainerId) + " (" + fragment.getResources().getResourceName(fragment.mContainerId) + ") for fragment " + fragment));
                                            }
                                        }
                                        fragment.mContainer = mContainer;
                                        fragment.mView = fragment.performCreateView(fragment.getLayoutInflater(fragment.mSavedFragmentState), mContainer, fragment.mSavedFragmentState);
                                        if (fragment.mView != null) {
                                            fragment.mInnerView = fragment.mView;
                                            if (Build$VERSION.SDK_INT >= 11) {
                                                ViewCompat.setSaveFromParentEnabled(fragment.mView, false);
                                            }
                                            else {
                                                fragment.mView = (View)NoSaveStateFrameLayout.wrap(fragment.mView);
                                            }
                                            if (mContainer != null) {
                                                final Animation loadAnimation = this.loadAnimation(fragment, n, true, n2);
                                                if (loadAnimation != null) {
                                                    this.setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                                                    fragment.mView.startAnimation(loadAnimation);
                                                }
                                                mContainer.addView(fragment.mView);
                                            }
                                            if (fragment.mHidden) {
                                                fragment.mView.setVisibility(8);
                                            }
                                            fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                                        }
                                        else {
                                            fragment.mInnerView = null;
                                        }
                                    }
                                    fragment.performActivityCreated(fragment.mSavedFragmentState);
                                    if (fragment.mView != null) {
                                        fragment.restoreViewState(fragment.mSavedFragmentState);
                                    }
                                    fragment.mSavedFragmentState = null;
                                }
                            case 2:
                            case 3:
                                if (mState > 3) {
                                    if (DEBUG) {
                                        Log.v("FragmentManager", "moveto STARTED: " + fragment);
                                    }
                                    fragment.performStart();
                                }
                            case 4:
                                if (mState > 4) {
                                    if (DEBUG) {
                                        Log.v("FragmentManager", "moveto RESUMED: " + fragment);
                                    }
                                    fragment.performResume();
                                    fragment.mSavedFragmentState = null;
                                    fragment.mSavedViewState = null;
                                }
                                break Label_0148;
                        }
                    }
                }
            }
            else {
                if (fragment.mState <= mState) {
                    break Label_0148;
                }
                switch (fragment.mState) {
                    default:
                        break Label_0148;
                    case 3:
                        if (mState < 3) {
                            if (DEBUG) {
                                Log.v("FragmentManager", "movefrom STOPPED: " + fragment);
                            }
                            fragment.performReallyStop();
                        }
                    case 2:
                        if (mState < 2) {
                            if (DEBUG) {
                                Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                            }
                            if (fragment.mView != null && mHost.onShouldSaveFragmentState(fragment) && fragment.mSavedViewState == null) {
                                this.saveFragmentViewState(fragment);
                            }
                            fragment.performDestroyView();
                            if (fragment.mView != null && fragment.mContainer != null) {
                                final int mCurState = this.mCurState;
                                Animation loadAnimation2 = null;
                                if (mCurState > 0) {
                                    final boolean mDestroyed = this.mDestroyed;
                                    loadAnimation2 = null;
                                    if (!mDestroyed) {
                                        loadAnimation2 = this.loadAnimation(fragment, n, false, n2);
                                    }
                                }
                                if (loadAnimation2 != null) {
                                    fragment.mAnimatingAway = fragment.mView;
                                    fragment.mStateAfterAnimating = mState;
                                    loadAnimation2.setAnimationListener((Animation$AnimationListener)new AnimateOnHWLayerIfNeededListener(fragment.mView, loadAnimation2) {
                                        final /* synthetic */ FragmentManagerImpl this$0;
                                        final /* synthetic */ Fragment val$fragment;
                                        
                                        FragmentManagerImpl$5(final View view, final Animation animation) {
                                            this$0 = this$0;
                                            super(view, animation);
                                        }
                                        
                                        @Override
                                        public void onAnimationEnd(final Animation animation) {
                                            super.onAnimationEnd(animation);
                                            if (fragment.mAnimatingAway != null) {
                                                fragment.mAnimatingAway = null;
                                                this$0.moveToState(fragment, fragment.mStateAfterAnimating, 0, 0, false);
                                            }
                                        }
                                    });
                                    fragment.mView.startAnimation(loadAnimation2);
                                }
                                fragment.mContainer.removeView(fragment.mView);
                            }
                            fragment.mContainer = null;
                            fragment.mView = null;
                            fragment.mInnerView = null;
                        }
                    case 1:
                        if (mState >= 1) {
                            break Label_0148;
                        }
                        if (mDestroyed && fragment.mAnimatingAway != null) {
                            final View mAnimatingAway = fragment.mAnimatingAway;
                            fragment.mAnimatingAway = null;
                            mAnimatingAway.clearAnimation();
                        }
                        if (fragment.mAnimatingAway != null) {
                            fragment.mStateAfterAnimating = mState;
                            mState = 1;
                            break Label_0148;
                        }
                        if (DEBUG) {
                            Log.v("FragmentManager", "movefrom CREATED: " + fragment);
                        }
                        if (!fragment.mRetaining) {
                            fragment.performDestroy();
                        }
                        else {
                            fragment.mState = 0;
                        }
                        fragment.mCalled = false;
                        fragment.onDetach();
                        if (!fragment.mCalled) {
                            throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onDetach()");
                        }
                        if (b) {
                            break Label_0148;
                        }
                        if (!fragment.mRetaining) {
                            this.makeInactive(fragment);
                            break Label_0148;
                        }
                        fragment.mHost = null;
                        fragment.mParentFragment = null;
                        fragment.mFragmentManager = null;
                        fragment.mChildFragmentManager = null;
                        break Label_0148;
                    case 5:
                        if (mState < 5) {
                            if (DEBUG) {
                                Log.v("FragmentManager", "movefrom RESUMED: " + fragment);
                            }
                            fragment.performPause();
                        }
                    case 4:
                        if (mState < 4) {
                            if (DEBUG) {
                                Log.v("FragmentManager", "movefrom STARTED: " + fragment);
                            }
                            fragment.performStop();
                        }
                }
            }
            return;
        }
        if (fragment.mState != mState) {
            Log.w("FragmentManager", "moveToState: Fragment state for " + fragment + " not updated inline; " + "expected state " + mState + " found " + fragment.mState);
            fragment.mState = mState;
        }
    }
    
    public void noteStateNotSaved() {
        mStateSaved = false;
    }
    
    @Override
    public View onCreateView(final View view, final String s, final Context context, final AttributeSet set) {
        if ("fragment".equals(s)) {
            String s2 = set.getAttributeValue((String)null, "class");
            final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, FragmentTag.Fragment);
            if (s2 == null) {
                s2 = obtainStyledAttributes.getString(0);
            }
            final int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            final String string = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            if (Fragment.isSupportFragmentClass(mHost.getContext(), s2)) {
                int id;
                if (view != null) {
                    id = view.getId();
                }
                else {
                    id = 0;
                }
                if (id == -1 && resourceId == -1 && string == null) {
                    throw new IllegalArgumentException(set.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + s2);
                }
                Fragment fragment;
                if (resourceId != -1) {
                    fragment = this.findFragmentById(resourceId);
                }
                else {
                    fragment = null;
                }
                if (fragment == null && string != null) {
                    fragment = this.findFragmentByTag(string);
                }
                if (fragment == null && id != -1) {
                    fragment = this.findFragmentById(id);
                }
                if (DEBUG) {
                    Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + s2 + " existing=" + fragment);
                }
                if (fragment == null) {
                    fragment = Fragment.instantiate(context, s2);
                    fragment.mFromLayout = true;
                    int mFragmentId;
                    if (resourceId != 0) {
                        mFragmentId = resourceId;
                    }
                    else {
                        mFragmentId = id;
                    }
                    fragment.mFragmentId = mFragmentId;
                    fragment.mContainerId = id;
                    fragment.mTag = string;
                    fragment.mInLayout = true;
                    fragment.mFragmentManager = this;
                    fragment.mHost = mHost;
                    fragment.onInflate(mHost.getContext(), set, fragment.mSavedFragmentState);
                    this.addFragment(fragment, true);
                }
                else {
                    if (fragment.mInLayout) {
                        throw new IllegalArgumentException(set.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + s2);
                    }
                    fragment.mInLayout = true;
                    fragment.mHost = mHost;
                    if (!fragment.mRetaining) {
                        fragment.onInflate(mHost.getContext(), set, fragment.mSavedFragmentState);
                    }
                }
                if (mCurState < 1 && fragment.mFromLayout) {
                    this.moveToState(fragment, 1, 0, 0, false);
                }
                else {
                    this.moveToState(fragment);
                }
                if (fragment.mView == null) {
                    throw new IllegalStateException("Fragment " + s2 + " did not create a view.");
                }
                if (resourceId != 0) {
                    fragment.mView.setId(resourceId);
                }
                if (fragment.mView.getTag() == null) {
                    fragment.mView.setTag((Object)string);
                }
                return fragment.mView;
            }
        }
        return null;
    }
    
    public void performPendingDeferredStart(final Fragment fragment) {
        if (fragment.mDeferStart) {
            if (!mExecutingActions) {
                fragment.mDeferStart = false;
                this.moveToState(fragment, mCurState, 0, 0, false);
                return;
            }
            mHavePendingDeferredStart = true;
        }
    }
    
    @Override
    public void popBackStack() {
        this.enqueueAction(new Runnable() {
            final /* synthetic */ FragmentManagerImpl this$0;
            
            FragmentManagerImpl$2() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                this$0.popBackStackState(mHost.getHandler(), null, -1, 0);
            }
        }, false);
    }
    
    @Override
    public void popBackStack(final int n, final int n2) {
        if (n < 0) {
            throw new IllegalArgumentException("Bad id: " + n);
        }
        this.enqueueAction(new Runnable() {
            final /* synthetic */ FragmentManagerImpl this$0;
            final /* synthetic */ int val$flags;
            final /* synthetic */ int val$id;
            
            FragmentManagerImpl$4() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                this$0.popBackStackState(mHost.getHandler(), null, n, n2);
            }
        }, false);
    }
    
    @Override
    public void popBackStack(final String s, final int n) {
        this.enqueueAction(new Runnable() {
            final /* synthetic */ FragmentManagerImpl this$0;
            final /* synthetic */ int val$flags;
            final /* synthetic */ String val$name;
            
            FragmentManagerImpl$3() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                this$0.popBackStackState(mHost.getHandler(), s, -1, n);
            }
        }, false);
    }
    
    @Override
    public boolean popBackStackImmediate() {
        this.checkStateLoss();
        this.executePendingTransactions();
        return this.popBackStackState(mHost.getHandler(), null, -1, 0);
    }
    
    @Override
    public boolean popBackStackImmediate(final int n, final int n2) {
        this.checkStateLoss();
        this.executePendingTransactions();
        if (n < 0) {
            throw new IllegalArgumentException("Bad id: " + n);
        }
        return this.popBackStackState(mHost.getHandler(), null, n, n2);
    }
    
    @Override
    public boolean popBackStackImmediate(final String s, final int n) {
        this.checkStateLoss();
        this.executePendingTransactions();
        return this.popBackStackState(mHost.getHandler(), s, -1, n);
    }
    
    boolean popBackStackState(final Handler handler, final String s, final int n, final int n2) {
        if (mBackStack == null) {
            return false;
        }
        if (s == null && n < 0 && (n2 & 0x1) == 0x0) {
            final int n3 = -1 + mBackStack.size();
            if (n3 < 0) {
                return false;
            }
            final BackStackRecord backStackRecord = (BackStackRecord)mBackStack.remove(n3);
            final SparseArray sparseArray = new SparseArray();
            final SparseArray sparseArray2 = new SparseArray();
            backStackRecord.calculateBackFragments((SparseArray<Fragment>)sparseArray, (SparseArray<Fragment>)sparseArray2);
            backStackRecord.popFromBackStack(true, null, (SparseArray<Fragment>)sparseArray, (SparseArray<Fragment>)sparseArray2);
            this.reportBackStackChanged();
        }
        else {
            int i = -1;
            if (s != null || n >= 0) {
                for (i = -1 + mBackStack.size(); i >= 0; --i) {
                    final BackStackRecord backStackRecord2 = (BackStackRecord)mBackStack.get(i);
                    if ((s != null && s.equals(backStackRecord2.getName())) || (n >= 0 && n == backStackRecord2.mIndex)) {
                        break;
                    }
                }
                if (i < 0) {
                    return false;
                }
                if ((n2 & 0x1) != 0x0) {
                    --i;
                    while (i >= 0) {
                        final BackStackRecord backStackRecord3 = (BackStackRecord)mBackStack.get(i);
                        if ((s == null || !s.equals(backStackRecord3.getName())) && (n < 0 || n != backStackRecord3.mIndex)) {
                            break;
                        }
                        --i;
                    }
                }
            }
            if (i == -1 + mBackStack.size()) {
                return false;
            }
            final ArrayList<BackStackRecord> list = new ArrayList<BackStackRecord>();
            for (int j = -1 + mBackStack.size(); j > i; --j) {
                list.add(mBackStack.remove(j));
            }
            final int n4 = -1 + list.size();
            final SparseArray sparseArray3 = new SparseArray();
            final SparseArray sparseArray4 = new SparseArray();
            for (int k = 0; k <= n4; ++k) {
                ((BackStackRecord)list.get(k)).calculateBackFragments((SparseArray<Fragment>)sparseArray3, (SparseArray<Fragment>)sparseArray4);
            }
            BackStackRecord.TransitionState popFromBackStack = null;
            for (int l = 0; l <= n4; ++l) {
                if (DEBUG) {
                    Log.v("FragmentManager", "Popping back stack state: " + list.get(l));
                }
                final BackStackRecord backStackRecord4 = (BackStackRecord)list.get(l);
                boolean b;
                if (l == n4) {
                    b = true;
                }
                else {
                    b = false;
                }
                popFromBackStack = backStackRecord4.popFromBackStack(b, popFromBackStack, (SparseArray<Fragment>)sparseArray3, (SparseArray<Fragment>)sparseArray4);
            }
            this.reportBackStackChanged();
        }
        return true;
    }
    
    @Override
    public void putFragment(final Bundle bundle, final String s, final Fragment fragment) {
        if (fragment.mIndex < 0) {
            this.throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(s, fragment.mIndex);
    }
    
    public void removeFragment(final Fragment fragment, final int n, final int n2) {
        if (DEBUG) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean b;
        if (!fragment.isInBackStack()) {
            b = true;
        }
        else {
            b = false;
        }
        if (!fragment.mDetached || b) {
            if (mAdded != null) {
                mAdded.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                mNeedMenuInvalidate = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
            int n3;
            if (b) {
                n3 = 0;
            }
            else {
                n3 = 1;
            }
            this.moveToState(fragment, n3, n, n2, false);
        }
    }
    
    @Override
    public void removeOnBackStackChangedListener(final OnBackStackChangedListener onBackStackChangedListener) {
        if (mBackStackChangeListeners != null) {
            mBackStackChangeListeners.remove(onBackStackChangedListener);
        }
    }
    
    void reportBackStackChanged() {
        if (mBackStackChangeListeners != null) {
            for (int i = 0; i < mBackStackChangeListeners.size(); ++i) {
                ((OnBackStackChangedListener)mBackStackChangeListeners.get(i)).onBackStackChanged();
            }
        }
    }
    
    void restoreAllState(final Parcelable parcelable, final List<Fragment> list) {
        if (parcelable != null) {
            final FragmentManagerState fragmentManagerState = (FragmentManagerState)parcelable;
            if (fragmentManagerState.mActive != null) {
                if (list != null) {
                    for (int i = 0; i < list.size(); ++i) {
                        final Fragment mInstance = (Fragment)list.get(i);
                        if (DEBUG) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + mInstance);
                        }
                        final FragmentState fragmentState = fragmentManagerState.mActive[mInstance.mIndex];
                        fragmentState.mInstance = mInstance;
                        mInstance.mSavedViewState = null;
                        mInstance.mBackStackNesting = 0;
                        mInstance.mInLayout = false;
                        mInstance.mAdded = false;
                        mInstance.mTarget = null;
                        if (fragmentState.mSavedFragmentState != null) {
                            fragmentState.mSavedFragmentState.setClassLoader(mHost.getContext().getClassLoader());
                            mInstance.mSavedViewState = (SparseArray<Parcelable>)fragmentState.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                            mInstance.mSavedFragmentState = fragmentState.mSavedFragmentState;
                        }
                    }
                }
                mActive = new ArrayList<Fragment>(fragmentManagerState.mActive.length);
                if (mAvailIndices != null) {
                    mAvailIndices.clear();
                }
                for (int j = 0; j < fragmentManagerState.mActive.length; ++j) {
                    final FragmentState fragmentState2 = fragmentManagerState.mActive[j];
                    if (fragmentState2 != null) {
                        final Fragment instantiate = fragmentState2.instantiate(mHost, mParent);
                        if (DEBUG) {
                            Log.v("FragmentManager", "restoreAllState: active #" + j + ": " + instantiate);
                        }
                        mActive.add(instantiate);
                        fragmentState2.mInstance = null;
                    }
                    else {
                        mActive.add(null);
                        if (mAvailIndices == null) {
                            mAvailIndices = new ArrayList<Integer>();
                        }
                        if (DEBUG) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + j);
                        }
                        mAvailIndices.add(j);
                    }
                }
                if (list != null) {
                    for (int k = 0; k < list.size(); ++k) {
                        final Fragment fragment = (Fragment)list.get(k);
                        if (fragment.mTargetIndex >= 0) {
                            if (fragment.mTargetIndex < mActive.size()) {
                                fragment.mTarget = mActive.get(fragment.mTargetIndex);
                            }
                            else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment + " target no longer exists: " + fragment.mTargetIndex);
                                fragment.mTarget = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.mAdded != null) {
                    mAdded = new ArrayList<Fragment>(fragmentManagerState.mAdded.length);
                    for (int l = 0; l < fragmentManagerState.mAdded.length; ++l) {
                        final Fragment fragment2 = (Fragment)mActive.get(fragmentManagerState.mAdded[l]);
                        if (fragment2 == null) {
                            this.throwException(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.mAdded[l]));
                        }
                        fragment2.mAdded = true;
                        if (DEBUG) {
                            Log.v("FragmentManager", "restoreAllState: added #" + l + ": " + fragment2);
                        }
                        if (mAdded.contains(fragment2)) {
                            throw new IllegalStateException("Already added!");
                        }
                        mAdded.add(fragment2);
                    }
                }
                else {
                    mAdded = null;
                }
                if (fragmentManagerState.mBackStack == null) {
                    mBackStack = null;
                    return;
                }
                mBackStack = new ArrayList<BackStackRecord>(fragmentManagerState.mBackStack.length);
                for (int n = 0; n < fragmentManagerState.mBackStack.length; ++n) {
                    final BackStackRecord instantiate2 = fragmentManagerState.mBackStack[n].instantiate(this);
                    if (DEBUG) {
                        Log.v("FragmentManager", "restoreAllState: back stack #" + n + " (index " + instantiate2.mIndex + "): " + instantiate2);
                        instantiate2.dump("  ", new PrintWriter((Writer)new LogWriter("FragmentManager")), false);
                    }
                    mBackStack.add(instantiate2);
                    if (instantiate2.mIndex >= 0) {
                        this.setBackStackIndex(instantiate2.mIndex, instantiate2);
                    }
                }
            }
        }
    }
    
    ArrayList<Fragment> retainNonConfig() {
        final ArrayList<Fragment> mActive = this.mActive;
        ArrayList<Fragment> list = null;
        if (mActive != null) {
            for (int i = 0; i < this.mActive.size(); ++i) {
                final Fragment fragment = (Fragment)this.mActive.get(i);
                if (fragment != null && fragment.mRetainInstance) {
                    if (list == null) {
                        list = new ArrayList<Fragment>();
                    }
                    list.add(fragment);
                    fragment.mRetaining = true;
                    int mIndex;
                    if (fragment.mTarget != null) {
                        mIndex = fragment.mTarget.mIndex;
                    }
                    else {
                        mIndex = -1;
                    }
                    fragment.mTargetIndex = mIndex;
                    if (DEBUG) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                    }
                }
            }
        }
        return list;
    }
    
    Parcelable saveAllState() {
        this.execPendingActions();
        if (HONEYCOMB) {
            mStateSaved = true;
        }
        if (mActive != null && mActive.size() > 0) {
            final int size = mActive.size();
            final FragmentState[] mActive = new FragmentState[size];
            boolean b = false;
            for (int i = 0; i < size; ++i) {
                final Fragment fragment = (Fragment)this.mActive.get(i);
                if (fragment != null) {
                    if (fragment.mIndex < 0) {
                        this.throwException(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.mIndex));
                    }
                    b = true;
                    final FragmentState fragmentState = new FragmentState(fragment);
                    mActive[i] = fragmentState;
                    if (fragment.mState > 0 && fragmentState.mSavedFragmentState == null) {
                        fragmentState.mSavedFragmentState = this.saveFragmentBasicState(fragment);
                        if (fragment.mTarget != null) {
                            if (fragment.mTarget.mIndex < 0) {
                                this.throwException(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.mTarget));
                            }
                            if (fragmentState.mSavedFragmentState == null) {
                                fragmentState.mSavedFragmentState = new Bundle();
                            }
                            this.putFragment(fragmentState.mSavedFragmentState, "android:target_state", fragment.mTarget);
                            if (fragment.mTargetRequestCode != 0) {
                                fragmentState.mSavedFragmentState.putInt("android:target_req_state", fragment.mTargetRequestCode);
                            }
                        }
                    }
                    else {
                        fragmentState.mSavedFragmentState = fragment.mSavedFragmentState;
                    }
                    if (DEBUG) {
                        Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.mSavedFragmentState);
                    }
                }
            }
            if (b) {
                final ArrayList<Fragment> mAdded = this.mAdded;
                int[] mAdded2 = null;
                if (mAdded != null) {
                    final int size2 = this.mAdded.size();
                    mAdded2 = null;
                    if (size2 > 0) {
                        mAdded2 = new int[size2];
                        for (int j = 0; j < size2; ++j) {
                            mAdded2[j] = ((Fragment)this.mAdded.get(j)).mIndex;
                            if (mAdded2[j] < 0) {
                                this.throwException(new IllegalStateException("Failure saving state: active " + this.mAdded.get(j) + " has cleared index: " + mAdded2[j]));
                            }
                            if (DEBUG) {
                                Log.v("FragmentManager", "saveAllState: adding fragment #" + j + ": " + this.mAdded.get(j));
                            }
                        }
                    }
                }
                final ArrayList<BackStackRecord> mBackStack = this.mBackStack;
                BackStackState[] mBackStack2 = null;
                if (mBackStack != null) {
                    final int size3 = this.mBackStack.size();
                    mBackStack2 = null;
                    if (size3 > 0) {
                        mBackStack2 = new BackStackState[size3];
                        for (int k = 0; k < size3; ++k) {
                            mBackStack2[k] = new BackStackState(this.mBackStack.get(k));
                            if (DEBUG) {
                                Log.v("FragmentManager", "saveAllState: adding back stack #" + k + ": " + this.mBackStack.get(k));
                            }
                        }
                    }
                }
                final FragmentManagerState fragmentManagerState = new FragmentManagerState();
                fragmentManagerState.mActive = mActive;
                fragmentManagerState.mAdded = mAdded2;
                fragmentManagerState.mBackStack = mBackStack2;
                return (Parcelable)fragmentManagerState;
            }
            if (DEBUG) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
                return null;
            }
        }
        return null;
    }
    
    Bundle saveFragmentBasicState(final Fragment fragment) {
        if (mStateBundle == null) {
            mStateBundle = new Bundle();
        }
        fragment.performSaveInstanceState(mStateBundle);
        final boolean empty = mStateBundle.isEmpty();
        Bundle mStateBundle = null;
        if (!empty) {
            mStateBundle = this.mStateBundle;
            this.mStateBundle = null;
        }
        if (fragment.mView != null) {
            this.saveFragmentViewState(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (mStateBundle == null) {
                mStateBundle = new Bundle();
            }
            mStateBundle.putSparseParcelableArray("android:view_state", (SparseArray)fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (mStateBundle == null) {
                mStateBundle = new Bundle();
            }
            mStateBundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return mStateBundle;
    }
    
    @Override
    public Fragment.SavedState saveFragmentInstanceState(final Fragment fragment) {
        if (fragment.mIndex < 0) {
            this.throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        final int mState = fragment.mState;
        Fragment.SavedState savedState = null;
        if (mState > 0) {
            final Bundle saveFragmentBasicState = this.saveFragmentBasicState(fragment);
            savedState = null;
            if (saveFragmentBasicState != null) {
                savedState = new Fragment.SavedState(saveFragmentBasicState);
            }
        }
        return savedState;
    }
    
    void saveFragmentViewState(final Fragment fragment) {
        if (fragment.mInnerView != null) {
            if (mStateArray == null) {
                mStateArray = (SparseArray<Parcelable>)new SparseArray();
            }
            else {
                mStateArray.clear();
            }
            fragment.mInnerView.saveHierarchyState((SparseArray)mStateArray);
            if (mStateArray.size() > 0) {
                fragment.mSavedViewState = mStateArray;
                mStateArray = null;
            }
        }
    }
    
    public void setBackStackIndex(final int n, final BackStackRecord backStackRecord) {
        synchronized (this) {
            if (mBackStackIndices == null) {
                mBackStackIndices = new ArrayList<BackStackRecord>();
            }
            int i = mBackStackIndices.size();
            if (n < i) {
                if (DEBUG) {
                    Log.v("FragmentManager", "Setting back stack index " + n + " to " + backStackRecord);
                }
                mBackStackIndices.set(n, backStackRecord);
            }
            else {
                while (i < n) {
                    mBackStackIndices.add(null);
                    if (mAvailBackStackIndices == null) {
                        mAvailBackStackIndices = new ArrayList<Integer>();
                    }
                    if (DEBUG) {
                        Log.v("FragmentManager", "Adding available back stack index " + i);
                    }
                    mAvailBackStackIndices.add(i);
                    ++i;
                }
                if (DEBUG) {
                    Log.v("FragmentManager", "Adding back stack index " + n + " with " + backStackRecord);
                }
                mBackStackIndices.add(backStackRecord);
            }
        }
    }
    
    public void showFragment(final Fragment fragment, final int n, final int n2) {
        if (DEBUG) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            if (fragment.mView != null) {
                final Animation loadAnimation = this.loadAnimation(fragment, n, true, n2);
                if (loadAnimation != null) {
                    this.setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                    fragment.mView.startAnimation(loadAnimation);
                }
                fragment.mView.setVisibility(0);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                mNeedMenuInvalidate = true;
            }
            fragment.onHiddenChanged(false);
        }
    }
    
    void startPendingDeferredFragments() {
        if (mActive != null) {
            for (int i = 0; i < mActive.size(); ++i) {
                final Fragment fragment = (Fragment)mActive.get(i);
                if (fragment != null) {
                    this.performPendingDeferredStart(fragment);
                }
            }
        }
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode((Object)this)));
        sb.append(" in ");
        if (mParent != null) {
            DebugUtils.buildShortClassTag(mParent, sb);
        }
        else {
            DebugUtils.buildShortClassTag(mHost, sb);
        }
        sb.append("}}");
        return sb.toString();
    }
}
