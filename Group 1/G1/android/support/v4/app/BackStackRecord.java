package android.support.v4.app;

import android.support.v4.util.SimpleArrayMap;
import java.io.FileDescriptor;
import java.io.Writer;
import java.io.PrintWriter;
import android.support.v4.util.LogWriter;
import android.util.Log;
import android.view.ViewTreeObserver$OnPreDrawListener;
import android.view.ViewGroup;
import java.util.Map;
import java.util.List;
import java.util.Collection;
import android.util.SparseArray;
import android.view.View;
import android.support.v4.util.ArrayMap;
import android.os.Build$VERSION;
import java.util.ArrayList;

final class BackStackRecord extends FragmentTransaction implements BackStackEntry, Runnable
{
    static final int OP_ADD = 1;
    static final int OP_ATTACH = 7;
    static final int OP_DETACH = 6;
    static final int OP_HIDE = 4;
    static final int OP_NULL = 0;
    static final int OP_REMOVE = 3;
    static final int OP_REPLACE = 2;
    static final int OP_SHOW = 5;
    static final boolean SUPPORTS_TRANSITIONS = false;
    static final String TAG = "FragmentManager";
    boolean mAddToBackStack;
    boolean mAllowAddToBackStack;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    boolean mCommitted;
    int mEnterAnim;
    int mExitAnim;
    Op mHead;
    int mIndex;
    final FragmentManagerImpl mManager;
    String mName;
    int mNumOp;
    int mPopEnterAnim;
    int mPopExitAnim;
    ArrayList<String> mSharedElementSourceNames;
    ArrayList<String> mSharedElementTargetNames;
    Op mTail;
    int mTransition;
    int mTransitionStyle;
    
    public BackStackRecord(final FragmentManagerImpl mManager) {
        super();
        mAllowAddToBackStack = true;
        mIndex = -1;
        mManager = mManager;
    }
    
    static /* synthetic */ ArrayMap access$000(final BackStackRecord backStackRecord, final TransitionState transitionState, final boolean b, final Fragment fragment) {
        return backStackRecord.mapSharedElementsIn(transitionState, b, fragment);
    }
    
    static /* synthetic */ void access$100(final BackStackRecord backStackRecord, final ArrayMap arrayMap, final TransitionState transitionState) {
        backStackRecord.setEpicenterIn(arrayMap, transitionState);
    }
    
    static /* synthetic */ void access$200(final BackStackRecord backStackRecord, final TransitionState transitionState, final Fragment fragment, final Fragment fragment2, final boolean b, final ArrayMap arrayMap) {
        backStackRecord.callSharedElementEnd(transitionState, fragment, fragment2, b, arrayMap);
    }
    
    static /* synthetic */ void access$300(final BackStackRecord backStackRecord, final TransitionState transitionState, final int n, final Object o) {
        backStackRecord.excludeHiddenFragments(transitionState, n, o);
    }
    
    private TransitionState beginTransition(final SparseArray<Fragment> sparseArray, final SparseArray<Fragment> sparseArray2, final boolean b) {
        this.ensureFragmentsAreInitialized(sparseArray2);
        TransitionState transitionState = new TransitionState();
        transitionState.nonExistentView = new View(mManager.mHost.getContext());
        boolean b2 = false;
        for (int i = 0; i < sparseArray.size(); ++i) {
            if (this.configureTransitions(sparseArray.keyAt(i), transitionState, b, sparseArray, sparseArray2)) {
                b2 = true;
            }
        }
        for (int j = 0; j < sparseArray2.size(); ++j) {
            final int key = sparseArray2.keyAt(j);
            if (sparseArray.get(key) == null && this.configureTransitions(key, transitionState, b, sparseArray, sparseArray2)) {
                b2 = true;
            }
        }
        if (!b2) {
            transitionState = null;
        }
        return transitionState;
    }
    
    private void calculateFragments(final SparseArray<Fragment> sparseArray, final SparseArray<Fragment> sparseArray2) {
        if (mManager.mContainer.onHasView()) {
            for (Op op = mHead; op != null; op = op.next) {
                switch (op.cmd) {
                    case 1:
                        this.setLastIn(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 2: {
                        Fragment fragment = op.fragment;
                        if (mManager.mAdded != null) {
                            for (int i = 0; i < mManager.mAdded.size(); ++i) {
                                final Fragment fragment2 = (Fragment)mManager.mAdded.get(i);
                                if (fragment == null || fragment2.mContainerId == fragment.mContainerId) {
                                    if (fragment2 == fragment) {
                                        fragment = null;
                                        sparseArray2.remove(fragment2.mContainerId);
                                    }
                                    else {
                                        setFirstOut(sparseArray, sparseArray2, fragment2);
                                    }
                                }
                            }
                        }
                        this.setLastIn(sparseArray, sparseArray2, op.fragment);
                        break;
                    }
                    case 3:
                        setFirstOut(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 4:
                        setFirstOut(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 5:
                        this.setLastIn(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 6:
                        setFirstOut(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 7:
                        this.setLastIn(sparseArray, sparseArray2, op.fragment);
                        break;
                }
            }
        }
    }
    
    private void callSharedElementEnd(final TransitionState transitionState, final Fragment fragment, final Fragment fragment2, final boolean b, final ArrayMap<String, View> arrayMap) {
        SharedElementCallback sharedElementCallback;
        if (b) {
            sharedElementCallback = fragment2.mEnterTransitionCallback;
        }
        else {
            sharedElementCallback = fragment.mEnterTransitionCallback;
        }
        if (sharedElementCallback != null) {
            sharedElementCallback.onSharedElementEnd(new ArrayList<String>(arrayMap.keySet()), new ArrayList<View>(arrayMap.values()), null);
        }
    }
    
    private static Object captureExitingViews(Object captureExitingViews, final Fragment fragment, final ArrayList<View> list, final ArrayMap<String, View> arrayMap, final View view) {
        if (captureExitingViews != null) {
            captureExitingViews = FragmentTransitionCompat21.captureExitingViews(captureExitingViews, fragment.getView(), list, arrayMap, view);
        }
        return captureExitingViews;
    }
    
    private boolean configureTransitions(final int n, final TransitionState transitionState, final boolean b, final SparseArray<Fragment> sparseArray, final SparseArray<Fragment> sparseArray2) {
        final ViewGroup viewGroup = (ViewGroup)mManager.mContainer.onFindViewById(n);
        if (viewGroup == null) {
            return false;
        }
        final Fragment fragment = (Fragment)sparseArray2.get(n);
        final Fragment fragment2 = (Fragment)sparseArray.get(n);
        final Object enterTransition = getEnterTransition(fragment, b);
        Object sharedElementTransition = getSharedElementTransition(fragment, fragment2, b);
        final Object exitTransition = getExitTransition(fragment2, b);
        final ArrayList<View> list = new ArrayList<View>();
        Map<K, V> remapSharedElements = null;
        if (sharedElementTransition != null) {
            remapSharedElements = (Map<K, V>)this.remapSharedElements(transitionState, fragment2, b);
            if (((SimpleArrayMap)remapSharedElements).isEmpty()) {
                sharedElementTransition = null;
                remapSharedElements = null;
            }
            else {
                SharedElementCallback sharedElementCallback;
                if (b) {
                    sharedElementCallback = fragment2.mEnterTransitionCallback;
                }
                else {
                    sharedElementCallback = fragment.mEnterTransitionCallback;
                }
                if (sharedElementCallback != null) {
                    sharedElementCallback.onSharedElementStart(new ArrayList<String>(((ArrayMap<String, View>)remapSharedElements).keySet()), new ArrayList<View>((Collection<? extends View>)((ArrayMap<String, ?>)remapSharedElements).values()), null);
                }
                this.prepareSharedElementTransition(transitionState, (View)viewGroup, sharedElementTransition, fragment, fragment2, b, list);
            }
        }
        if (enterTransition == null && sharedElementTransition == null && exitTransition == null) {
            return false;
        }
        final ArrayList<View> list2 = new ArrayList<View>();
        final Object captureExitingViews = captureExitingViews(exitTransition, fragment2, list2, (ArrayMap<String, View>)remapSharedElements, transitionState.nonExistentView);
        if (mSharedElementTargetNames != null && remapSharedElements != null) {
            final View view = (View)((SimpleArrayMap<Object, View>)remapSharedElements).get(mSharedElementTargetNames.get(0));
            if (view != null) {
                if (captureExitingViews != null) {
                    FragmentTransitionCompat21.setEpicenter(captureExitingViews, view);
                }
                if (sharedElementTransition != null) {
                    FragmentTransitionCompat21.setEpicenter(sharedElementTransition, view);
                }
            }
        }
        final FragmentTransitionCompat21.ViewRetriever viewRetriever = new FragmentTransitionCompat21.ViewRetriever() {
            final /* synthetic */ BackStackRecord this$0;
            final /* synthetic */ Fragment val$inFragment;
            
            BackStackRecord$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public View getView() {
                return fragment.getView();
            }
        };
        final ArrayList<View> list3 = new ArrayList<View>();
        final ArrayMap<String, View> arrayMap = new ArrayMap<String, View>();
        boolean b2 = true;
        if (fragment != null) {
            if (b) {
                b2 = fragment.getAllowReturnTransitionOverlap();
            }
            else {
                b2 = fragment.getAllowEnterTransitionOverlap();
            }
        }
        final Object mergeTransitions = FragmentTransitionCompat21.mergeTransitions(enterTransition, captureExitingViews, sharedElementTransition, b2);
        if (mergeTransitions != null) {
            FragmentTransitionCompat21.addTransitionTargets(enterTransition, sharedElementTransition, viewGroup, (FragmentTransitionCompat21.ViewRetriever)viewRetriever, transitionState.nonExistentView, transitionState.enteringEpicenterView, (Map<String, String>)transitionState.nameOverrides, list3, (Map<String, View>)remapSharedElements, (Map<String, View>)arrayMap, list);
            this.excludeHiddenFragmentsAfterEnter((View)viewGroup, transitionState, n, mergeTransitions);
            FragmentTransitionCompat21.excludeTarget(mergeTransitions, transitionState.nonExistentView, true);
            this.excludeHiddenFragments(transitionState, n, mergeTransitions);
            FragmentTransitionCompat21.beginDelayedTransition(viewGroup, mergeTransitions);
            FragmentTransitionCompat21.cleanupTransitions(viewGroup, transitionState.nonExistentView, enterTransition, list3, captureExitingViews, list2, sharedElementTransition, list, mergeTransitions, transitionState.hiddenFragmentViews, (Map<String, View>)arrayMap);
        }
        return mergeTransitions != null;
    }
    
    private void doAddOp(final int n, final Fragment fragment, final String mTag, final int cmd) {
        fragment.mFragmentManager = mManager;
        if (mTag != null) {
            if (fragment.mTag != null && !mTag.equals(fragment.mTag)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + mTag);
            }
            fragment.mTag = mTag;
        }
        if (n != 0) {
            if (fragment.mFragmentId != 0 && fragment.mFragmentId != n) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + n);
            }
            fragment.mFragmentId = n;
            fragment.mContainerId = n;
        }
        final Op op = new Op();
        op.cmd = cmd;
        op.fragment = fragment;
        this.addOp(op);
    }
    
    private void ensureFragmentsAreInitialized(final SparseArray<Fragment> sparseArray) {
        for (int size = sparseArray.size(), i = 0; i < size; ++i) {
            final Fragment fragment = (Fragment)sparseArray.valueAt(i);
            if (fragment.mState < 1) {
                mManager.makeActive(fragment);
                mManager.moveToState(fragment, 1, 0, 0, false);
            }
        }
    }
    
    private void excludeHiddenFragments(final TransitionState transitionState, final int n, final Object o) {
        if (mManager.mAdded != null) {
            for (int i = 0; i < mManager.mAdded.size(); ++i) {
                final Fragment fragment = (Fragment)mManager.mAdded.get(i);
                if (fragment.mView != null && fragment.mContainer != null && fragment.mContainerId == n) {
                    if (fragment.mHidden) {
                        if (!transitionState.hiddenFragmentViews.contains(fragment.mView)) {
                            FragmentTransitionCompat21.excludeTarget(o, fragment.mView, true);
                            transitionState.hiddenFragmentViews.add(fragment.mView);
                        }
                    }
                    else {
                        FragmentTransitionCompat21.excludeTarget(o, fragment.mView, false);
                        transitionState.hiddenFragmentViews.remove(fragment.mView);
                    }
                }
            }
        }
    }
    
    private void excludeHiddenFragmentsAfterEnter(final View view, final TransitionState transitionState, final int n, final Object o) {
        view.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)new ViewTreeObserver$OnPreDrawListener() {
            final /* synthetic */ BackStackRecord this$0;
            final /* synthetic */ int val$containerId;
            final /* synthetic */ View val$sceneRoot;
            final /* synthetic */ TransitionState val$state;
            final /* synthetic */ Object val$transition;
            
            BackStackRecord$3() {
                this$0 = this$0;
                super();
            }
            
            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)this);
                this$0.excludeHiddenFragments(transitionState, n, o);
                return true;
            }
        });
    }
    
    private static Object getEnterTransition(final Fragment fragment, final boolean b) {
        if (fragment == null) {
            return null;
        }
        Object o;
        if (b) {
            o = fragment.getReenterTransition();
        }
        else {
            o = fragment.getEnterTransition();
        }
        return FragmentTransitionCompat21.cloneTransition(o);
    }
    
    private static Object getExitTransition(final Fragment fragment, final boolean b) {
        if (fragment == null) {
            return null;
        }
        Object o;
        if (b) {
            o = fragment.getReturnTransition();
        }
        else {
            o = fragment.getExitTransition();
        }
        return FragmentTransitionCompat21.cloneTransition(o);
    }
    
    private static Object getSharedElementTransition(final Fragment fragment, final Fragment fragment2, final boolean b) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        Object o;
        if (b) {
            o = fragment2.getSharedElementReturnTransition();
        }
        else {
            o = fragment.getSharedElementEnterTransition();
        }
        return FragmentTransitionCompat21.wrapSharedElementTransition(o);
    }
    
    private ArrayMap<String, View> mapEnteringSharedElements(final TransitionState transitionState, final Fragment fragment, final boolean b) {
        ArrayMap<String, View> remapNames = new ArrayMap<String, View>();
        final View view = fragment.getView();
        if (view != null && mSharedElementSourceNames != null) {
            FragmentTransitionCompat21.findNamedViews(remapNames, view);
            if (!b) {
                remapNames.retainAll(mSharedElementTargetNames);
                return remapNames;
            }
            remapNames = remapNames(mSharedElementSourceNames, mSharedElementTargetNames, remapNames);
        }
        return remapNames;
    }
    
    private ArrayMap<String, View> mapSharedElementsIn(final TransitionState transitionState, final boolean b, final Fragment fragment) {
        final ArrayMap<String, View> mapEnteringSharedElements = this.mapEnteringSharedElements(transitionState, fragment, b);
        if (b) {
            if (fragment.mExitTransitionCallback != null) {
                fragment.mExitTransitionCallback.onMapSharedElements(mSharedElementTargetNames, mapEnteringSharedElements);
            }
            this.setBackNameOverrides(transitionState, mapEnteringSharedElements, true);
            return mapEnteringSharedElements;
        }
        if (fragment.mEnterTransitionCallback != null) {
            fragment.mEnterTransitionCallback.onMapSharedElements(mSharedElementTargetNames, mapEnteringSharedElements);
        }
        this.setNameOverrides(transitionState, mapEnteringSharedElements, true);
        return mapEnteringSharedElements;
    }
    
    private void prepareSharedElementTransition(final TransitionState transitionState, final View view, final Object o, final Fragment fragment, final Fragment fragment2, final boolean b, final ArrayList<View> list) {
        view.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)new ViewTreeObserver$OnPreDrawListener() {
            final /* synthetic */ BackStackRecord this$0;
            final /* synthetic */ Fragment val$inFragment;
            final /* synthetic */ boolean val$isBack;
            final /* synthetic */ Fragment val$outFragment;
            final /* synthetic */ View val$sceneRoot;
            final /* synthetic */ ArrayList val$sharedElementTargets;
            final /* synthetic */ Object val$sharedElementTransition;
            final /* synthetic */ TransitionState val$state;
            
            BackStackRecord$2() {
                this$0 = this$0;
                super();
            }
            
            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)this);
                if (o != null) {
                    FragmentTransitionCompat21.removeTargets(o, list);
                    list.clear();
                    final ArrayMap access$000 = this$0.mapSharedElementsIn(transitionState, b, fragment);
                    FragmentTransitionCompat21.setSharedElementTargets(o, transitionState.nonExistentView, access$000, list);
                    this$0.setEpicenterIn(access$000, transitionState);
                    this$0.callSharedElementEnd(transitionState, fragment, fragment2, b, access$000);
                }
                return true;
            }
        });
    }
    
    private static ArrayMap<String, View> remapNames(final ArrayList<String> list, final ArrayList<String> list2, final ArrayMap<String, View> arrayMap) {
        if (arrayMap.isEmpty()) {
            return arrayMap;
        }
        final ArrayMap<String, View> arrayMap2 = new ArrayMap<String, View>();
        for (int size = list.size(), i = 0; i < size; ++i) {
            final View view = (View)arrayMap.get(list.get(i));
            if (view != null) {
                arrayMap2.put(list2.get(i), view);
            }
        }
        return arrayMap2;
    }
    
    private ArrayMap<String, View> remapSharedElements(final TransitionState transitionState, final Fragment fragment, final boolean b) {
        ArrayMap<String, View> remapNames = new ArrayMap<String, View>();
        if (mSharedElementSourceNames != null) {
            FragmentTransitionCompat21.findNamedViews(remapNames, fragment.getView());
            if (b) {
                remapNames.retainAll(mSharedElementTargetNames);
            }
            else {
                remapNames = remapNames(mSharedElementSourceNames, mSharedElementTargetNames, remapNames);
            }
        }
        if (b) {
            if (fragment.mEnterTransitionCallback != null) {
                fragment.mEnterTransitionCallback.onMapSharedElements(mSharedElementTargetNames, remapNames);
            }
            this.setBackNameOverrides(transitionState, remapNames, false);
            return remapNames;
        }
        if (fragment.mExitTransitionCallback != null) {
            fragment.mExitTransitionCallback.onMapSharedElements(mSharedElementTargetNames, remapNames);
        }
        this.setNameOverrides(transitionState, remapNames, false);
        return remapNames;
    }
    
    private void setBackNameOverrides(final TransitionState transitionState, final ArrayMap<String, View> arrayMap, final boolean b) {
        int size;
        if (mSharedElementTargetNames == null) {
            size = 0;
        }
        else {
            size = mSharedElementTargetNames.size();
        }
        for (int i = 0; i < size; ++i) {
            final String s = (String)mSharedElementSourceNames.get(i);
            final View view = (View)arrayMap.get(mSharedElementTargetNames.get(i));
            if (view != null) {
                final String transitionName = FragmentTransitionCompat21.getTransitionName(view);
                if (b) {
                    setNameOverride(transitionState.nameOverrides, s, transitionName);
                }
                else {
                    setNameOverride(transitionState.nameOverrides, transitionName, s);
                }
            }
        }
    }
    
    private void setEpicenterIn(final ArrayMap<String, View> arrayMap, final TransitionState transitionState) {
        if (mSharedElementTargetNames != null && !arrayMap.isEmpty()) {
            final View epicenter = (View)arrayMap.get(mSharedElementTargetNames.get(0));
            if (epicenter != null) {
                transitionState.enteringEpicenterView.epicenter = epicenter;
            }
        }
    }
    
    private static void setFirstOut(final SparseArray<Fragment> sparseArray, final SparseArray<Fragment> sparseArray2, final Fragment fragment) {
        if (fragment != null) {
            final int mContainerId = fragment.mContainerId;
            if (mContainerId != 0 && !fragment.isHidden()) {
                if (fragment.isAdded() && fragment.getView() != null && sparseArray.get(mContainerId) == null) {
                    sparseArray.put(mContainerId, (Object)fragment);
                }
                if (sparseArray2.get(mContainerId) == fragment) {
                    sparseArray2.remove(mContainerId);
                }
            }
        }
    }
    
    private void setLastIn(final SparseArray<Fragment> sparseArray, final SparseArray<Fragment> sparseArray2, final Fragment fragment) {
        if (fragment != null) {
            final int mContainerId = fragment.mContainerId;
            if (mContainerId != 0) {
                if (!fragment.isAdded()) {
                    sparseArray2.put(mContainerId, (Object)fragment);
                }
                if (sparseArray.get(mContainerId) == fragment) {
                    sparseArray.remove(mContainerId);
                }
            }
        }
    }
    
    private static void setNameOverride(final ArrayMap<String, String> arrayMap, final String s, final String s2) {
        if (s != null && s2 != null) {
            for (int i = 0; i < arrayMap.size(); ++i) {
                if (s.equals(arrayMap.valueAt(i))) {
                    arrayMap.setValueAt(i, s2);
                    return;
                }
            }
            arrayMap.put(s, s2);
        }
    }
    
    private void setNameOverrides(final TransitionState transitionState, final ArrayMap<String, View> arrayMap, final boolean b) {
        for (int size = arrayMap.size(), i = 0; i < size; ++i) {
            final String s = (String)arrayMap.keyAt(i);
            final String transitionName = FragmentTransitionCompat21.getTransitionName(arrayMap.valueAt(i));
            if (b) {
                setNameOverride(transitionState.nameOverrides, s, transitionName);
            }
            else {
                setNameOverride(transitionState.nameOverrides, transitionName, s);
            }
        }
    }
    
    private static void setNameOverrides(final TransitionState transitionState, final ArrayList<String> list, final ArrayList<String> list2) {
        if (list != null) {
            for (int i = 0; i < list.size(); ++i) {
                setNameOverride(transitionState.nameOverrides, list.get(i), list2.get(i));
            }
        }
    }
    
    @Override
    public FragmentTransaction add(final int n, final Fragment fragment) {
        this.doAddOp(n, fragment, null, 1);
        return this;
    }
    
    @Override
    public FragmentTransaction add(final int n, final Fragment fragment, final String s) {
        this.doAddOp(n, fragment, s, 1);
        return this;
    }
    
    @Override
    public FragmentTransaction add(final Fragment fragment, final String s) {
        this.doAddOp(0, fragment, s, 1);
        return this;
    }
    
    void addOp(final Op op) {
        if (mHead == null) {
            mTail = op;
            mHead = op;
        }
        else {
            op.prev = mTail;
            mTail.next = op;
            mTail = op;
        }
        op.enterAnim = mEnterAnim;
        op.exitAnim = mExitAnim;
        op.popEnterAnim = mPopEnterAnim;
        op.popExitAnim = mPopExitAnim;
        ++mNumOp;
    }
    
    @Override
    public FragmentTransaction addSharedElement(final View view, final String s) {
        if (SUPPORTS_TRANSITIONS) {
            final String transitionName = FragmentTransitionCompat21.getTransitionName(view);
            if (transitionName == null) {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
            if (mSharedElementSourceNames == null) {
                mSharedElementSourceNames = new ArrayList<String>();
                mSharedElementTargetNames = new ArrayList<String>();
            }
            mSharedElementSourceNames.add(transitionName);
            mSharedElementTargetNames.add(s);
        }
        return this;
    }
    
    @Override
    public FragmentTransaction addToBackStack(final String mName) {
        if (!mAllowAddToBackStack) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        mAddToBackStack = true;
        this.mName = mName;
        return this;
    }
    
    @Override
    public FragmentTransaction attach(final Fragment fragment) {
        final Op op = new Op();
        op.cmd = 7;
        op.fragment = fragment;
        this.addOp(op);
        return this;
    }
    
    void bumpBackStackNesting(final int n) {
        if (mAddToBackStack) {
            if (FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + n);
            }
            for (Op op = mHead; op != null; op = op.next) {
                if (op.fragment != null) {
                    final Fragment fragment = op.fragment;
                    fragment.mBackStackNesting += n;
                    if (FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "Bump nesting of " + op.fragment + " to " + op.fragment.mBackStackNesting);
                    }
                }
                if (op.removed != null) {
                    for (int i = -1 + op.removed.size(); i >= 0; --i) {
                        final Fragment fragment2 = (Fragment)op.removed.get(i);
                        fragment2.mBackStackNesting += n;
                        if (FragmentManagerImpl.DEBUG) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment2 + " to " + fragment2.mBackStackNesting);
                        }
                    }
                }
            }
        }
    }
    
    public void calculateBackFragments(final SparseArray<Fragment> sparseArray, final SparseArray<Fragment> sparseArray2) {
        if (mManager.mContainer.onHasView()) {
            for (Op op = mTail; op != null; op = op.prev) {
                switch (op.cmd) {
                    case 1:
                        setFirstOut(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 2:
                        if (op.removed != null) {
                            for (int i = -1 + op.removed.size(); i >= 0; --i) {
                                this.setLastIn(sparseArray, sparseArray2, op.removed.get(i));
                            }
                        }
                        setFirstOut(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 3:
                        this.setLastIn(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 4:
                        this.setLastIn(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 5:
                        setFirstOut(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 6:
                        this.setLastIn(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 7:
                        setFirstOut(sparseArray, sparseArray2, op.fragment);
                        break;
                }
            }
        }
    }
    
    @Override
    public int commit() {
        return this.commitInternal(false);
    }
    
    @Override
    public int commitAllowingStateLoss() {
        return this.commitInternal(true);
    }
    
    int commitInternal(final boolean b) {
        if (mCommitted) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "Commit: " + this);
            this.dump("  ", null, new PrintWriter(new LogWriter("FragmentManager")), null);
        }
        mCommitted = true;
        if (mAddToBackStack) {
            mIndex = mManager.allocBackStackIndex(this);
        }
        else {
            mIndex = -1;
        }
        mManager.enqueueAction(this, b);
        return mIndex;
    }
    
    @Override
    public FragmentTransaction detach(final Fragment fragment) {
        final Op op = new Op();
        op.cmd = 6;
        op.fragment = fragment;
        this.addOp(op);
        return this;
    }
    
    @Override
    public FragmentTransaction disallowAddToBackStack() {
        if (mAddToBackStack) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        mAllowAddToBackStack = false;
        return this;
    }
    
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        this.dump(s, printWriter, true);
    }
    
    public void dump(final String s, final PrintWriter printWriter, final boolean b) {
        if (b) {
            printWriter.print(s);
            printWriter.print("mName=");
            printWriter.print(mName);
            printWriter.print(" mIndex=");
            printWriter.print(mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(mCommitted);
            if (mTransition != 0) {
                printWriter.print(s);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(mTransition));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(mTransitionStyle));
            }
            if (mEnterAnim != 0 || mExitAnim != 0) {
                printWriter.print(s);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(mEnterAnim));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(mExitAnim));
            }
            if (mPopEnterAnim != 0 || mPopExitAnim != 0) {
                printWriter.print(s);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(mPopEnterAnim));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(mPopExitAnim));
            }
            if (mBreadCrumbTitleRes != 0 || mBreadCrumbTitleText != null) {
                printWriter.print(s);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(mBreadCrumbTitleRes));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(mBreadCrumbTitleText);
            }
            if (mBreadCrumbShortTitleRes != 0 || mBreadCrumbShortTitleText != null) {
                printWriter.print(s);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(mBreadCrumbShortTitleRes));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(mBreadCrumbShortTitleText);
            }
        }
        if (mHead != null) {
            printWriter.print(s);
            printWriter.println("Operations:");
            final String string = s + "    ";
            Op op = mHead;
            for (int n = 0; op != null; op = op.next, ++n) {
                String string2 = null;
                switch (op.cmd) {
                    default:
                        string2 = "cmd=" + op.cmd;
                        break;
                    case 0:
                        string2 = "NULL";
                        break;
                    case 1:
                        string2 = "ADD";
                        break;
                    case 2:
                        string2 = "REPLACE";
                        break;
                    case 3:
                        string2 = "REMOVE";
                        break;
                    case 4:
                        string2 = "HIDE";
                        break;
                    case 5:
                        string2 = "SHOW";
                        break;
                    case 6:
                        string2 = "DETACH";
                        break;
                    case 7:
                        string2 = "ATTACH";
                        break;
                }
                printWriter.print(s);
                printWriter.print("  Op #");
                printWriter.print(n);
                printWriter.print(": ");
                printWriter.print(string2);
                printWriter.print(" ");
                printWriter.println(op.fragment);
                if (b) {
                    if (op.enterAnim != 0 || op.exitAnim != 0) {
                        printWriter.print(s);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(op.enterAnim));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(op.exitAnim));
                    }
                    if (op.popEnterAnim != 0 || op.popExitAnim != 0) {
                        printWriter.print(s);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(op.popEnterAnim));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(op.popExitAnim));
                    }
                }
                if (op.removed != null && op.removed.size() > 0) {
                    for (int i = 0; i < op.removed.size(); ++i) {
                        printWriter.print(string);
                        if (op.removed.size() == 1) {
                            printWriter.print("Removed: ");
                        }
                        else {
                            if (i == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(string);
                            printWriter.print("  #");
                            printWriter.print(i);
                            printWriter.print(": ");
                        }
                        printWriter.println(op.removed.get(i));
                    }
                }
            }
        }
    }
    
    @Override
    public CharSequence getBreadCrumbShortTitle() {
        if (mBreadCrumbShortTitleRes != 0) {
            return mManager.mHost.getContext().getText(mBreadCrumbShortTitleRes);
        }
        return mBreadCrumbShortTitleText;
    }
    
    @Override
    public int getBreadCrumbShortTitleRes() {
        return mBreadCrumbShortTitleRes;
    }
    
    @Override
    public CharSequence getBreadCrumbTitle() {
        if (mBreadCrumbTitleRes != 0) {
            return mManager.mHost.getContext().getText(mBreadCrumbTitleRes);
        }
        return mBreadCrumbTitleText;
    }
    
    @Override
    public int getBreadCrumbTitleRes() {
        return mBreadCrumbTitleRes;
    }
    
    @Override
    public int getId() {
        return mIndex;
    }
    
    @Override
    public String getName() {
        return mName;
    }
    
    public int getTransition() {
        return mTransition;
    }
    
    public int getTransitionStyle() {
        return mTransitionStyle;
    }
    
    @Override
    public FragmentTransaction hide(final Fragment fragment) {
        final Op op = new Op();
        op.cmd = 4;
        op.fragment = fragment;
        this.addOp(op);
        return this;
    }
    
    @Override
    public boolean isAddToBackStackAllowed() {
        return mAllowAddToBackStack;
    }
    
    @Override
    public boolean isEmpty() {
        return mNumOp == 0;
    }
    
    public TransitionState popFromBackStack(final boolean b, TransitionState beginTransition, final SparseArray<Fragment> sparseArray, final SparseArray<Fragment> sparseArray2) {
        if (FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            this.dump("  ", null, new PrintWriter(new LogWriter("FragmentManager")), null);
        }
        if (SUPPORTS_TRANSITIONS) {
            if (beginTransition == null) {
                if (sparseArray.size() != 0 || sparseArray2.size() != 0) {
                    beginTransition = this.beginTransition(sparseArray, sparseArray2, true);
                }
            }
            else if (!b) {
                setNameOverrides(beginTransition, mSharedElementTargetNames, mSharedElementSourceNames);
            }
        }
        this.bumpBackStackNesting(-1);
        int mTransitionStyle;
        if (beginTransition != null) {
            mTransitionStyle = 0;
        }
        else {
            mTransitionStyle = this.mTransitionStyle;
        }
        int mTransition;
        if (beginTransition != null) {
            mTransition = 0;
        }
        else {
            mTransition = this.mTransition;
        }
        for (Op op = mTail; op != null; op = op.prev) {
            int popEnterAnim;
            if (beginTransition != null) {
                popEnterAnim = 0;
            }
            else {
                popEnterAnim = op.popEnterAnim;
            }
            int popExitAnim;
            if (beginTransition != null) {
                popExitAnim = 0;
            }
            else {
                popExitAnim = op.popExitAnim;
            }
            switch (op.cmd) {
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.cmd);
                case 1: {
                    final Fragment fragment = op.fragment;
                    fragment.mNextAnim = popExitAnim;
                    mManager.removeFragment(fragment, FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
                    break;
                }
                case 2: {
                    final Fragment fragment2 = op.fragment;
                    if (fragment2 != null) {
                        fragment2.mNextAnim = popExitAnim;
                        mManager.removeFragment(fragment2, FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
                    }
                    if (op.removed != null) {
                        for (int i = 0; i < op.removed.size(); ++i) {
                            final Fragment fragment3 = (Fragment)op.removed.get(i);
                            fragment3.mNextAnim = popEnterAnim;
                            mManager.addFragment(fragment3, false);
                        }
                        break;
                    }
                    break;
                }
                case 3: {
                    final Fragment fragment4 = op.fragment;
                    fragment4.mNextAnim = popEnterAnim;
                    mManager.addFragment(fragment4, false);
                    break;
                }
                case 4: {
                    final Fragment fragment5 = op.fragment;
                    fragment5.mNextAnim = popEnterAnim;
                    mManager.showFragment(fragment5, FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
                    break;
                }
                case 5: {
                    final Fragment fragment6 = op.fragment;
                    fragment6.mNextAnim = popExitAnim;
                    mManager.hideFragment(fragment6, FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
                    break;
                }
                case 6: {
                    final Fragment fragment7 = op.fragment;
                    fragment7.mNextAnim = popEnterAnim;
                    mManager.attachFragment(fragment7, FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
                    break;
                }
                case 7: {
                    final Fragment fragment8 = op.fragment;
                    fragment8.mNextAnim = popEnterAnim;
                    mManager.detachFragment(fragment8, FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
                    break;
                }
            }
        }
        if (b) {
            mManager.moveToState(mManager.mCurState, FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle, true);
            beginTransition = null;
        }
        if (mIndex >= 0) {
            mManager.freeBackStackIndex(mIndex);
            mIndex = -1;
        }
        return beginTransition;
    }
    
    @Override
    public FragmentTransaction remove(final Fragment fragment) {
        final Op op = new Op();
        op.cmd = 3;
        op.fragment = fragment;
        this.addOp(op);
        return this;
    }
    
    @Override
    public FragmentTransaction replace(final int n, final Fragment fragment) {
        return this.replace(n, fragment, null);
    }
    
    @Override
    public FragmentTransaction replace(final int n, final Fragment fragment, final String s) {
        if (n == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        this.doAddOp(n, fragment, s, 2);
        return this;
    }
    
    @Override
    public void run() {
        if (FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (mAddToBackStack && mIndex < 0) {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        this.bumpBackStackNesting(1);
        final boolean supports_TRANSITIONS = SUPPORTS_TRANSITIONS;
        TransitionState beginTransition = null;
        if (supports_TRANSITIONS) {
            final SparseArray sparseArray = new SparseArray();
            final SparseArray sparseArray2 = new SparseArray();
            this.calculateFragments((SparseArray<Fragment>)sparseArray, (SparseArray<Fragment>)sparseArray2);
            beginTransition = this.beginTransition((SparseArray<Fragment>)sparseArray, (SparseArray<Fragment>)sparseArray2, false);
        }
        int mTransitionStyle;
        if (beginTransition != null) {
            mTransitionStyle = 0;
        }
        else {
            mTransitionStyle = this.mTransitionStyle;
        }
        int mTransition;
        if (beginTransition != null) {
            mTransition = 0;
        }
        else {
            mTransition = this.mTransition;
        }
        for (Op op = mHead; op != null; op = op.next) {
            int enterAnim;
            if (beginTransition != null) {
                enterAnim = 0;
            }
            else {
                enterAnim = op.enterAnim;
            }
            int exitAnim;
            if (beginTransition != null) {
                exitAnim = 0;
            }
            else {
                exitAnim = op.exitAnim;
            }
            switch (op.cmd) {
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.cmd);
                case 1: {
                    final Fragment fragment = op.fragment;
                    fragment.mNextAnim = enterAnim;
                    mManager.addFragment(fragment, false);
                    break;
                }
                case 2: {
                    Fragment fragment2 = op.fragment;
                    final int mContainerId = fragment2.mContainerId;
                    if (mManager.mAdded != null) {
                        for (int i = -1 + mManager.mAdded.size(); i >= 0; --i) {
                            final Fragment fragment3 = (Fragment)mManager.mAdded.get(i);
                            if (FragmentManagerImpl.DEBUG) {
                                Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment2 + " old=" + fragment3);
                            }
                            if (fragment3.mContainerId == mContainerId) {
                                if (fragment3 == fragment2) {
                                    fragment2 = null;
                                    op.fragment = null;
                                }
                                else {
                                    if (op.removed == null) {
                                        op.removed = new ArrayList<Fragment>();
                                    }
                                    op.removed.add(fragment3);
                                    fragment3.mNextAnim = exitAnim;
                                    if (mAddToBackStack) {
                                        ++fragment3.mBackStackNesting;
                                        if (FragmentManagerImpl.DEBUG) {
                                            Log.v("FragmentManager", "Bump nesting of " + fragment3 + " to " + fragment3.mBackStackNesting);
                                        }
                                    }
                                    mManager.removeFragment(fragment3, mTransition, mTransitionStyle);
                                }
                            }
                        }
                    }
                    if (fragment2 != null) {
                        fragment2.mNextAnim = enterAnim;
                        mManager.addFragment(fragment2, false);
                        break;
                    }
                    break;
                }
                case 3: {
                    final Fragment fragment4 = op.fragment;
                    fragment4.mNextAnim = exitAnim;
                    mManager.removeFragment(fragment4, mTransition, mTransitionStyle);
                    break;
                }
                case 4: {
                    final Fragment fragment5 = op.fragment;
                    fragment5.mNextAnim = exitAnim;
                    mManager.hideFragment(fragment5, mTransition, mTransitionStyle);
                    break;
                }
                case 5: {
                    final Fragment fragment6 = op.fragment;
                    fragment6.mNextAnim = enterAnim;
                    mManager.showFragment(fragment6, mTransition, mTransitionStyle);
                    break;
                }
                case 6: {
                    final Fragment fragment7 = op.fragment;
                    fragment7.mNextAnim = exitAnim;
                    mManager.detachFragment(fragment7, mTransition, mTransitionStyle);
                    break;
                }
                case 7: {
                    final Fragment fragment8 = op.fragment;
                    fragment8.mNextAnim = enterAnim;
                    mManager.attachFragment(fragment8, mTransition, mTransitionStyle);
                    break;
                }
            }
        }
        mManager.moveToState(mManager.mCurState, mTransition, mTransitionStyle, true);
        if (mAddToBackStack) {
            mManager.addBackStackState(this);
        }
    }
    
    @Override
    public FragmentTransaction setBreadCrumbShortTitle(final int mBreadCrumbShortTitleRes) {
        this.mBreadCrumbShortTitleRes = mBreadCrumbShortTitleRes;
        mBreadCrumbShortTitleText = null;
        return this;
    }
    
    @Override
    public FragmentTransaction setBreadCrumbShortTitle(final CharSequence mBreadCrumbShortTitleText) {
        mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = mBreadCrumbShortTitleText;
        return this;
    }
    
    @Override
    public FragmentTransaction setBreadCrumbTitle(final int mBreadCrumbTitleRes) {
        this.mBreadCrumbTitleRes = mBreadCrumbTitleRes;
        mBreadCrumbTitleText = null;
        return this;
    }
    
    @Override
    public FragmentTransaction setBreadCrumbTitle(final CharSequence mBreadCrumbTitleText) {
        mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = mBreadCrumbTitleText;
        return this;
    }
    
    @Override
    public FragmentTransaction setCustomAnimations(final int n, final int n2) {
        return this.setCustomAnimations(n, n2, 0, 0);
    }
    
    @Override
    public FragmentTransaction setCustomAnimations(final int mEnterAnim, final int mExitAnim, final int mPopEnterAnim, final int mPopExitAnim) {
        this.mEnterAnim = mEnterAnim;
        this.mExitAnim = mExitAnim;
        this.mPopEnterAnim = mPopEnterAnim;
        this.mPopExitAnim = mPopExitAnim;
        return this;
    }
    
    @Override
    public FragmentTransaction setTransition(final int mTransition) {
        this.mTransition = mTransition;
        return this;
    }
    
    @Override
    public FragmentTransaction setTransitionStyle(final int mTransitionStyle) {
        this.mTransitionStyle = mTransitionStyle;
        return this;
    }
    
    @Override
    public FragmentTransaction show(final Fragment fragment) {
        final Op op = new Op();
        op.cmd = 5;
        op.fragment = fragment;
        this.addOp(op);
        return this;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode((Object)this)));
        if (mIndex >= 0) {
            sb.append(" #");
            sb.append(mIndex);
        }
        if (mName != null) {
            sb.append(" ");
            sb.append(mName);
        }
        sb.append("}");
        return sb.toString();
    }
}
