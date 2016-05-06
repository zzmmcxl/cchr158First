package android.support.v4.app;

import android.support.v4.util.SimpleArrayMap;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import android.support.annotation.Nullable;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.content.res.Configuration;

public class FragmentController
{
    private final FragmentHostCallback<?> mHost;
    
    private FragmentController(final FragmentHostCallback<?> mHost) {
        super();
        mHost = mHost;
    }
    
    public static final FragmentController createController(final FragmentHostCallback<?> fragmentHostCallback) {
        return new FragmentController(fragmentHostCallback);
    }
    
    public void attachHost(final Fragment fragment) {
        mHost.mFragmentManager.attachController(mHost, mHost, fragment);
    }
    
    public void dispatchActivityCreated() {
        mHost.mFragmentManager.dispatchActivityCreated();
    }
    
    public void dispatchConfigurationChanged(final Configuration configuration) {
        mHost.mFragmentManager.dispatchConfigurationChanged(configuration);
    }
    
    public boolean dispatchContextItemSelected(final MenuItem menuItem) {
        return mHost.mFragmentManager.dispatchContextItemSelected(menuItem);
    }
    
    public void dispatchCreate() {
        mHost.mFragmentManager.dispatchCreate();
    }
    
    public boolean dispatchCreateOptionsMenu(final Menu menu, final MenuInflater menuInflater) {
        return mHost.mFragmentManager.dispatchCreateOptionsMenu(menu, menuInflater);
    }
    
    public void dispatchDestroy() {
        mHost.mFragmentManager.dispatchDestroy();
    }
    
    public void dispatchDestroyView() {
        mHost.mFragmentManager.dispatchDestroyView();
    }
    
    public void dispatchLowMemory() {
        mHost.mFragmentManager.dispatchLowMemory();
    }
    
    public boolean dispatchOptionsItemSelected(final MenuItem menuItem) {
        return mHost.mFragmentManager.dispatchOptionsItemSelected(menuItem);
    }
    
    public void dispatchOptionsMenuClosed(final Menu menu) {
        mHost.mFragmentManager.dispatchOptionsMenuClosed(menu);
    }
    
    public void dispatchPause() {
        mHost.mFragmentManager.dispatchPause();
    }
    
    public boolean dispatchPrepareOptionsMenu(final Menu menu) {
        return mHost.mFragmentManager.dispatchPrepareOptionsMenu(menu);
    }
    
    public void dispatchReallyStop() {
        mHost.mFragmentManager.dispatchReallyStop();
    }
    
    public void dispatchResume() {
        mHost.mFragmentManager.dispatchResume();
    }
    
    public void dispatchStart() {
        mHost.mFragmentManager.dispatchStart();
    }
    
    public void dispatchStop() {
        mHost.mFragmentManager.dispatchStop();
    }
    
    public void doLoaderDestroy() {
        mHost.doLoaderDestroy();
    }
    
    public void doLoaderRetain() {
        mHost.doLoaderRetain();
    }
    
    public void doLoaderStart() {
        mHost.doLoaderStart();
    }
    
    public void doLoaderStop(final boolean b) {
        mHost.doLoaderStop(b);
    }
    
    public void dumpLoaders(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        mHost.dumpLoaders(s, fileDescriptor, printWriter, array);
    }
    
    public boolean execPendingActions() {
        return mHost.mFragmentManager.execPendingActions();
    }
    
    @Nullable
    Fragment findFragmentByWho(final String s) {
        return mHost.mFragmentManager.findFragmentByWho(s);
    }
    
    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (mHost.mFragmentManager.mActive == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<Object>(this.getActiveFragmentsCount());
        }
        list.addAll(mHost.mFragmentManager.mActive);
        return (List<Fragment>)list;
    }
    
    public int getActiveFragmentsCount() {
        final ArrayList<Fragment> mActive = mHost.mFragmentManager.mActive;
        if (mActive == null) {
            return 0;
        }
        return mActive.size();
    }
    
    public FragmentManager getSupportFragmentManager() {
        return mHost.getFragmentManagerImpl();
    }
    
    public LoaderManager getSupportLoaderManager() {
        return mHost.getLoaderManagerImpl();
    }
    
    public void noteStateNotSaved() {
        mHost.mFragmentManager.noteStateNotSaved();
    }
    
    public View onCreateView(final View view, final String s, final Context context, final AttributeSet set) {
        return mHost.mFragmentManager.onCreateView(view, s, context, set);
    }
    
    public void reportLoaderStart() {
        mHost.reportLoaderStart();
    }
    
    public void restoreAllState(final Parcelable parcelable, final List<Fragment> list) {
        mHost.mFragmentManager.restoreAllState(parcelable, list);
    }
    
    public void restoreLoaderNonConfig(final SimpleArrayMap<String, LoaderManager> simpleArrayMap) {
        mHost.restoreLoaderNonConfig(simpleArrayMap);
    }
    
    public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
        return mHost.retainLoaderNonConfig();
    }
    
    public List<Fragment> retainNonConfig() {
        return mHost.mFragmentManager.retainNonConfig();
    }
    
    public Parcelable saveAllState() {
        return mHost.mFragmentManager.saveAllState();
    }
}
