package android.support.v4.app;

import android.view.Window;
import android.view.LayoutInflater;
import android.support.v4.util.SimpleArrayMap;
import java.util.ArrayList;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.KeyEvent;
import android.view.Menu;
import java.util.List;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.content.res.Configuration;
import android.util.Log;
import android.content.Intent;
import android.os.Build$VERSION;
import java.io.FileDescriptor;
import android.util.AttributeSet;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources$NotFoundException;
import android.app.Activity;
import android.view.ViewGroup;
import android.view.View;
import java.io.PrintWriter;
import android.os.Message;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.os.Handler;

public class FragmentActivity extends BaseFragmentActivityHoneycomb implements OnRequestPermissionsResultCallback, RequestPermissionsRequestCodeValidator
{
    static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    static final String FRAGMENTS_TAG = "android:support:fragments";
    private static final int HONEYCOMB = 11;
    static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    static final int MSG_REALLY_STOPPED = 1;
    static final int MSG_RESUME_PENDING = 2;
    static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    private static final String TAG = "FragmentActivity";
    boolean mCreated;
    final FragmentController mFragments;
    final Handler mHandler;
    MediaControllerCompat mMediaController;
    int mNextCandidateRequestIndex;
    boolean mOptionsMenuInvalidated;
    SparseArrayCompat<String> mPendingFragmentActivityResults;
    boolean mReallyStopped;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mRetaining;
    boolean mStartedActivityFromFragment;
    boolean mStopped;
    
    public FragmentActivity() {
        super();
        mHandler = new Handler() {
            final /* synthetic */ FragmentActivity this$0;
            
            FragmentActivity$1() {
                this$0 = this$0;
                super();
            }
            
            public void handleMessage(final Message message) {
                switch (message.what) {
                    default:
                        super.handleMessage(message);
                        break;
                    case 1:
                        if (mStopped) {
                            this$0.doReallyStop(false);
                            return;
                        }
                        break;
                    case 2:
                        this$0.onResumeFragments();
                        mFragments.execPendingActions();
                }
            }
        };
        mFragments = FragmentController.createController(new HostCallbacks());
    }
    
    static /* synthetic */ void access$000(final FragmentActivity fragmentActivity, final Fragment fragment, final String[] array, final int n) {
        fragmentActivity.requestPermissionsFromFragment(fragment, array, n);
    }
    
    private int allocateRequestIndex(final Fragment fragment) {
        if (mPendingFragmentActivityResults.size() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (mPendingFragmentActivityResults.indexOfKey(mNextCandidateRequestIndex) >= 0) {
            mNextCandidateRequestIndex = (1 + mNextCandidateRequestIndex) % 65534;
        }
        final int mNextCandidateRequestIndex = this.mNextCandidateRequestIndex;
        mPendingFragmentActivityResults.put(mNextCandidateRequestIndex, fragment.mWho);
        this.mNextCandidateRequestIndex = (1 + this.mNextCandidateRequestIndex) % 65534;
        return mNextCandidateRequestIndex;
    }
    
    private void dumpViewHierarchy(final String s, final PrintWriter printWriter, final View view) {
        printWriter.print(s);
        if (view == null) {
            printWriter.println("null");
        }
        else {
            printWriter.println(viewToString(view));
            if (view instanceof ViewGroup) {
                final ViewGroup viewGroup = (ViewGroup)view;
                final int childCount = viewGroup.getChildCount();
                if (childCount > 0) {
                    final String string = s + "  ";
                    for (int i = 0; i < childCount; ++i) {
                        this.dumpViewHierarchy(string, printWriter, viewGroup.getChildAt(i));
                    }
                }
            }
        }
    }
    
    private void requestPermissionsFromFragment(final Fragment fragment, final String[] array, final int n) {
        if (n == -1) {
            ActivityCompat.requestPermissions(this, array, n);
            return;
        }
        if ((n & 0xFFFFFF00) != 0x0) {
            throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
        }
        mRequestedPermissionsFromFragment = true;
        ActivityCompat.requestPermissions(this, array, (1 + fragment.mIndex << 8) + (n & 0xFF));
    }
    
    private static String viewToString(final View view) {
        char c = 'F';
        char c2 = '.';
        final StringBuilder sb = new StringBuilder(128);
        sb.append(view.getClass().getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode((Object)view)));
        sb.append(' ');
        Resources resources;
        int id = 0;
        String resourcePackageName;
        String resourceTypeName;
        String resourceEntryName;
        char c3 = '\0';
        char c4 = '\0';
        char c5 = '\0';
        char c6 = '\0';
        char c7 = '\0';
        char c8 = '\0';
        char c9 = '\0';
        char c10 = '\0';
        Label_0492_Outer:Label_0597_Outer:
        while (true) {
        Label_0589_Outer:
            while (true) {
                while (true) {
                    Label_0554_Outer:Label_0560_Outer:Label_0583_Outer:
                    while (true) {
                        Label_0253: {
                            Label_0572_Outer:Label_0578_Outer:
                            while (true) {
                            Label_0236:
                                while (true) {
                                    Label_0215: {
                                        while (true) {
                                            Label_0197: {
                                                while (true) {
                                                    Label_0179: {
                                                        while (true) {
                                                            Label_0161: {
                                                                while (true) {
                                                                    Label_0143: {
                                                                        while (true) {
                                                                            Label_0126: {
                                                                                while (true) {
                                                                                    Label_0108: {
                                                                                        while (true) {
                                                                                            while (true) {
                                                                                                while (true) {
                                                                                                    switch (view.getVisibility()) {
                                                                                                        default:
                                                                                                            sb.append(c2);
                                                                                                            break;
                                                                                                        case 0:
                                                                                                            Label_0505: {
                                                                                                                break Label_0505;
                                                                                                                try {
                                                                                                                    resourcePackageName = resources.getResourcePackageName(id);
                                                                                                                    while (true) {
                                                                                                                        resourceTypeName = resources.getResourceTypeName(id);
                                                                                                                        resourceEntryName = resources.getResourceEntryName(id);
                                                                                                                        sb.append(" ");
                                                                                                                        sb.append(resourcePackageName);
                                                                                                                        sb.append(":");
                                                                                                                        sb.append(resourceTypeName);
                                                                                                                        sb.append("/");
                                                                                                                        sb.append(resourceEntryName);
                                                                                                                        sb.append("}");
                                                                                                                        return sb.toString();
                                                                                                                        c3 = c2;
                                                                                                                        break Label_0161;
                                                                                                                        sb.append('V');
                                                                                                                        break;
                                                                                                                        c4 = c2;
                                                                                                                        break Label_0179;
                                                                                                                        c5 = c2;
                                                                                                                        break Label_0108;
                                                                                                                        c6 = c2;
                                                                                                                        break Label_0253;
                                                                                                                        c7 = c2;
                                                                                                                        break Label_0126;
                                                                                                                        resourcePackageName = "android";
                                                                                                                        continue Label_0492_Outer;
                                                                                                                        c8 = c2;
                                                                                                                        break Label_0197;
                                                                                                                        c9 = 'D';
                                                                                                                        break Label_0143;
                                                                                                                        sb.append('G');
                                                                                                                        break;
                                                                                                                        c10 = c2;
                                                                                                                        break Label_0215;
                                                                                                                        c = c2;
                                                                                                                        break Label_0236;
                                                                                                                        resourcePackageName = "app";
                                                                                                                        continue Label_0492_Outer;
                                                                                                                    }
                                                                                                                    sb.append('I');
                                                                                                                    break;
                                                                                                                }
                                                                                                                catch (Resources$NotFoundException ex) {
                                                                                                                    continue Label_0554_Outer;
                                                                                                                }
                                                                                                            }
                                                                                                            break;
                                                                                                        case 4:
                                                                                                            continue;
                                                                                                        case 8:
                                                                                                            continue Label_0572_Outer;
                                                                                                    }
                                                                                                    break;
                                                                                                }
                                                                                                break;
                                                                                            }
                                                                                            if (!view.isFocusable()) {
                                                                                                continue Label_0583_Outer;
                                                                                            }
                                                                                            break;
                                                                                        }
                                                                                        c5 = c;
                                                                                    }
                                                                                    sb.append(c5);
                                                                                    if (!view.isEnabled()) {
                                                                                        continue Label_0597_Outer;
                                                                                    }
                                                                                    break;
                                                                                }
                                                                                c7 = 'E';
                                                                            }
                                                                            sb.append(c7);
                                                                            if (!view.willNotDraw()) {
                                                                                continue Label_0572_Outer;
                                                                            }
                                                                            break;
                                                                        }
                                                                        c9 = c2;
                                                                    }
                                                                    sb.append(c9);
                                                                    if (!view.isHorizontalScrollBarEnabled()) {
                                                                        continue Label_0560_Outer;
                                                                    }
                                                                    break;
                                                                }
                                                                c3 = 'H';
                                                            }
                                                            sb.append(c3);
                                                            if (!view.isVerticalScrollBarEnabled()) {
                                                                continue Label_0583_Outer;
                                                            }
                                                            break;
                                                        }
                                                        c4 = 'V';
                                                    }
                                                    sb.append(c4);
                                                    if (!view.isClickable()) {
                                                        continue Label_0572_Outer;
                                                    }
                                                    break;
                                                }
                                                c8 = 'C';
                                            }
                                            sb.append(c8);
                                            if (!view.isLongClickable()) {
                                                continue Label_0578_Outer;
                                            }
                                            break;
                                        }
                                        c10 = 'L';
                                    }
                                    sb.append(c10);
                                    sb.append(' ');
                                    if (!view.isFocused()) {
                                        continue Label_0589_Outer;
                                    }
                                    break;
                                }
                                sb.append(c);
                                if (!view.isSelected()) {
                                    continue Label_0597_Outer;
                                }
                                break;
                            }
                            c6 = 'S';
                        }
                        sb.append(c6);
                        if (view.isPressed()) {
                            c2 = 'P';
                        }
                        sb.append(c2);
                        sb.append(' ');
                        sb.append(view.getLeft());
                        sb.append(',');
                        sb.append(view.getTop());
                        sb.append('-');
                        sb.append(view.getRight());
                        sb.append(',');
                        sb.append(view.getBottom());
                        id = view.getId();
                        if (id == -1) {
                            continue Label_0554_Outer;
                        }
                        sb.append(" #");
                        sb.append(Integer.toHexString(id));
                        resources = view.getResources();
                        if (id == 0 || resources == null) {
                            continue Label_0554_Outer;
                        }
                        break;
                    }
                    switch (0xFF000000 & id) {
                        default:
                            continue Label_0492_Outer;
                        case 2130706432:
                            continue;
                        case 16777216:
                            continue Label_0589_Outer;
                    }
                    break;
                }
                break;
            }
            break;
        }
    }
    
    @Override
    final View dispatchFragmentsOnCreateView(final View view, final String s, final Context context, final AttributeSet set) {
        return mFragments.onCreateView(view, s, context, set);
    }
    
    void doReallyStop(final boolean mRetaining) {
        if (!mReallyStopped) {
            mReallyStopped = true;
            this.mRetaining = mRetaining;
            mHandler.removeMessages(1);
            this.onReallyStop();
        }
    }
    
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        if (Build$VERSION.SDK_INT >= 11) {}
        printWriter.print(s);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode((Object)this)));
        printWriter.println(" State:");
        final String string = s + "  ";
        printWriter.print(string);
        printWriter.print("mCreated=");
        printWriter.print(mCreated);
        printWriter.print("mResumed=");
        printWriter.print(mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(mStopped);
        printWriter.print(" mReallyStopped=");
        printWriter.println(mReallyStopped);
        mFragments.dumpLoaders(string, fileDescriptor, printWriter, array);
        mFragments.getSupportFragmentManager().dump(s, fileDescriptor, printWriter, array);
        printWriter.print(s);
        printWriter.println("View Hierarchy:");
        this.dumpViewHierarchy(s + "  ", printWriter, this.getWindow().getDecorView());
    }
    
    public Object getLastCustomNonConfigurationInstance() {
        final NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances)this.getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            return nonConfigurationInstances.custom;
        }
        return null;
    }
    
    public FragmentManager getSupportFragmentManager() {
        return mFragments.getSupportFragmentManager();
    }
    
    public LoaderManager getSupportLoaderManager() {
        return mFragments.getSupportLoaderManager();
    }
    
    public final MediaControllerCompat getSupportMediaController() {
        return mMediaController;
    }
    
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        mFragments.noteStateNotSaved();
        final int n3 = n >> 16;
        if (n3 == 0) {
            super.onActivityResult(n, n2, intent);
            return;
        }
        final int n4 = n3 - 1;
        final String s = (String)mPendingFragmentActivityResults.get(n4);
        mPendingFragmentActivityResults.remove(n4);
        if (s == null) {
            Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
            return;
        }
        final Fragment fragmentByWho = mFragments.findFragmentByWho(s);
        if (fragmentByWho == null) {
            Log.w("FragmentActivity", "Activity result no fragment exists for who: " + s);
            return;
        }
        fragmentByWho.onActivityResult(0xFFFF & n, n2, intent);
    }
    
    public void onAttachFragment(final Fragment fragment) {
    }
    
    public void onBackPressed() {
        if (!mFragments.getSupportFragmentManager().popBackStackImmediate()) {
            this.supportFinishAfterTransition();
        }
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        mFragments.dispatchConfigurationChanged(configuration);
    }
    
    @Override
    protected void onCreate(@Nullable final Bundle bundle) {
        mFragments.attachHost(null);
        super.onCreate(bundle);
        final NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances)this.getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            mFragments.restoreLoaderNonConfig(nonConfigurationInstances.loaders);
        }
        if (bundle != null) {
            final Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            final FragmentController mFragments = this.mFragments;
            List<Fragment> fragments = null;
            if (nonConfigurationInstances != null) {
                fragments = nonConfigurationInstances.fragments;
            }
            mFragments.restoreAllState(parcelable, fragments);
            if (bundle.containsKey("android:support:next_request_index")) {
                mNextCandidateRequestIndex = bundle.getInt("android:support:next_request_index");
                final int[] intArray = bundle.getIntArray("android:support:request_indicies");
                final String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                }
                else {
                    mPendingFragmentActivityResults = new SparseArrayCompat<String>(intArray.length);
                    for (int i = 0; i < intArray.length; ++i) {
                        mPendingFragmentActivityResults.put(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (mPendingFragmentActivityResults == null) {
            mPendingFragmentActivityResults = new SparseArrayCompat<String>();
            mNextCandidateRequestIndex = 0;
        }
        mFragments.dispatchCreate();
    }
    
    public boolean onCreatePanelMenu(final int n, final Menu menu) {
        if (n == 0) {
            final boolean b = super.onCreatePanelMenu(n, menu) | mFragments.dispatchCreateOptionsMenu(menu, this.getMenuInflater());
            return Build$VERSION.SDK_INT < 11 || b;
        }
        return super.onCreatePanelMenu(n, menu);
    }
    
    @Override
    public /* bridge */ View onCreateView(final View view, final String s, final Context context, final AttributeSet set) {
        return super.onCreateView(view, s, context, set);
    }
    
    @Override
    public /* bridge */ View onCreateView(final String s, final Context context, final AttributeSet set) {
        return super.onCreateView(s, context, set);
    }
    
    protected void onDestroy() {
        super.onDestroy();
        this.doReallyStop(false);
        mFragments.dispatchDestroy();
        mFragments.doLoaderDestroy();
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        if (Build$VERSION.SDK_INT < 5 && n == 4 && keyEvent.getRepeatCount() == 0) {
            this.onBackPressed();
            return true;
        }
        return super.onKeyDown(n, keyEvent);
    }
    
    public void onLowMemory() {
        super.onLowMemory();
        mFragments.dispatchLowMemory();
    }
    
    public boolean onMenuItemSelected(final int n, final MenuItem menuItem) {
        if (super.onMenuItemSelected(n, menuItem)) {
            return true;
        }
        switch (n) {
            default:
                return false;
            case 0:
                return mFragments.dispatchOptionsItemSelected(menuItem);
            case 6:
                return mFragments.dispatchContextItemSelected(menuItem);
        }
    }
    
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        mFragments.noteStateNotSaved();
    }
    
    public void onPanelClosed(final int n, final Menu menu) {
        switch (n) {
            case 0:
                mFragments.dispatchOptionsMenuClosed(menu);
                break;
        }
        super.onPanelClosed(n, menu);
    }
    
    protected void onPause() {
        super.onPause();
        mResumed = false;
        if (mHandler.hasMessages(2)) {
            mHandler.removeMessages(2);
            this.onResumeFragments();
        }
        mFragments.dispatchPause();
    }
    
    protected void onPostResume() {
        super.onPostResume();
        mHandler.removeMessages(2);
        this.onResumeFragments();
        mFragments.execPendingActions();
    }
    
    protected boolean onPrepareOptionsPanel(final View view, final Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }
    
    public boolean onPreparePanel(final int n, final View view, final Menu menu) {
        if (n == 0 && menu != null) {
            if (mOptionsMenuInvalidated) {
                mOptionsMenuInvalidated = false;
                menu.clear();
                this.onCreatePanelMenu(n, menu);
            }
            return this.onPrepareOptionsPanel(view, menu) | mFragments.dispatchPrepareOptionsMenu(menu);
        }
        return super.onPreparePanel(n, view, menu);
    }
    
    void onReallyStop() {
        mFragments.doLoaderStop(mRetaining);
        mFragments.dispatchReallyStop();
    }
    
    @Override
    public void onRequestPermissionsResult(final int n, @NonNull final String[] array, @NonNull final int[] array2) {
        final int n2 = 0xFF & n >> 8;
        if (n2 != 0) {
            final int n3 = n2 - 1;
            final int activeFragmentsCount = mFragments.getActiveFragmentsCount();
            if (activeFragmentsCount == 0 || n3 < 0 || n3 >= activeFragmentsCount) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(n));
            }
            else {
                final Fragment fragment = (Fragment)mFragments.getActiveFragments(new ArrayList<Fragment>(activeFragmentsCount)).get(n3);
                if (fragment == null) {
                    Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(n));
                    return;
                }
                fragment.onRequestPermissionsResult(n & 0xFF, array, array2);
            }
        }
    }
    
    protected void onResume() {
        super.onResume();
        mHandler.sendEmptyMessage(2);
        mResumed = true;
        mFragments.execPendingActions();
    }
    
    protected void onResumeFragments() {
        mFragments.dispatchResume();
    }
    
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }
    
    public final Object onRetainNonConfigurationInstance() {
        if (mStopped) {
            this.doReallyStop(true);
        }
        final Object onRetainCustomNonConfigurationInstance = this.onRetainCustomNonConfigurationInstance();
        final List<Fragment> retainNonConfig = mFragments.retainNonConfig();
        final SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig = mFragments.retainLoaderNonConfig();
        if (retainNonConfig == null && retainLoaderNonConfig == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        final NonConfigurationInstances nonConfigurationInstances = new NonConfigurationInstances();
        nonConfigurationInstances.custom = onRetainCustomNonConfigurationInstance;
        nonConfigurationInstances.fragments = retainNonConfig;
        nonConfigurationInstances.loaders = retainLoaderNonConfig;
        return nonConfigurationInstances;
    }
    
    protected void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        final Parcelable saveAllState = mFragments.saveAllState();
        if (saveAllState != null) {
            bundle.putParcelable("android:support:fragments", saveAllState);
        }
        if (mPendingFragmentActivityResults.size() > 0) {
            bundle.putInt("android:support:next_request_index", mNextCandidateRequestIndex);
            final int[] array = new int[mPendingFragmentActivityResults.size()];
            final String[] array2 = new String[mPendingFragmentActivityResults.size()];
            for (int i = 0; i < mPendingFragmentActivityResults.size(); ++i) {
                array[i] = mPendingFragmentActivityResults.keyAt(i);
                array2[i] = mPendingFragmentActivityResults.valueAt(i);
            }
            bundle.putIntArray("android:support:request_indicies", array);
            bundle.putStringArray("android:support:request_fragment_who", array2);
        }
    }
    
    protected void onStart() {
        super.onStart();
        mStopped = false;
        mReallyStopped = false;
        mHandler.removeMessages(1);
        if (!mCreated) {
            mCreated = true;
            mFragments.dispatchActivityCreated();
        }
        mFragments.noteStateNotSaved();
        mFragments.execPendingActions();
        mFragments.doLoaderStart();
        mFragments.dispatchStart();
        mFragments.reportLoaderStart();
    }
    
    public void onStateNotSaved() {
        mFragments.noteStateNotSaved();
    }
    
    protected void onStop() {
        super.onStop();
        mStopped = true;
        mHandler.sendEmptyMessage(1);
        mFragments.dispatchStop();
    }
    
    public void setEnterSharedElementCallback(final SharedElementCallback sharedElementCallback) {
        ActivityCompat.setEnterSharedElementCallback(this, sharedElementCallback);
    }
    
    public void setExitSharedElementCallback(final SharedElementCallback sharedElementCallback) {
        ActivityCompat.setExitSharedElementCallback(this, sharedElementCallback);
    }
    
    public final void setSupportMediaController(final MediaControllerCompat mMediaController) {
        this.mMediaController = mMediaController;
        if (Build$VERSION.SDK_INT >= 21) {
            ActivityCompat21.setMediaController(this, mMediaController.getMediaController());
        }
    }
    
    public void startActivityForResult(final Intent intent, final int n) {
        if (!mStartedActivityFromFragment && n != -1 && (0xFFFF0000 & n) != 0x0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
        super.startActivityForResult(intent, n);
    }
    
    public void startActivityFromFragment(final Fragment fragment, final Intent intent, final int n) {
        this.startActivityFromFragment(fragment, intent, n, null);
    }
    
    public void startActivityFromFragment(final Fragment fragment, final Intent intent, final int n, @Nullable final Bundle bundle) {
        mStartedActivityFromFragment = true;
        while (true) {
            if (n == -1) {
                try {
                    ActivityCompat.startActivityForResult(this, intent, -1, bundle);
                    return;
                    // iftrue(Label_0053:, 0xFFFF0000 & n == 0x0)
                    throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
                }
                finally {
                    mStartedActivityFromFragment = false;
                }
                Label_0053: {
                    ActivityCompat.startActivityForResult(this, intent, (1 + this.allocateRequestIndex(fragment) << 16) + (0xFFFF & n), bundle);
                }
                mStartedActivityFromFragment = false;
                return;
            }
            continue;
        }
    }
    
    public void supportFinishAfterTransition() {
        ActivityCompat.finishAfterTransition(this);
    }
    
    public void supportInvalidateOptionsMenu() {
        if (Build$VERSION.SDK_INT >= 11) {
            ActivityCompatHoneycomb.invalidateOptionsMenu(this);
            return;
        }
        mOptionsMenuInvalidated = true;
    }
    
    public void supportPostponeEnterTransition() {
        ActivityCompat.postponeEnterTransition(this);
    }
    
    public void supportStartPostponedEnterTransition() {
        ActivityCompat.startPostponedEnterTransition(this);
    }
    
    @Override
    public final void validateRequestPermissionsRequestCode(final int n) {
        if (mRequestedPermissionsFromFragment) {
            mRequestedPermissionsFromFragment = false;
        }
        else if ((n & 0xFFFFFF00) != 0x0) {
            throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
        }
    }
}
