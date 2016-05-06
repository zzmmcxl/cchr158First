package android.support.v4.app;

import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.Window;
import android.content.Context;
import android.view.LayoutInflater;
import android.support.annotation.Nullable;
import android.view.View;
import java.io.PrintWriter;
import java.io.FileDescriptor;

class HostCallbacks extends FragmentHostCallback<FragmentActivity>
{
    final /* synthetic */ FragmentActivity this$0;
    
    public HostCallbacks(final FragmentActivity this$0) {
        this$0 = this$0;
        super(this$0);
    }
    
    public void onAttachFragment(final Fragment fragment) {
        this$0.onAttachFragment(fragment);
    }
    
    @Override
    public void onDump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        this$0.dump(s, fileDescriptor, printWriter, array);
    }
    
    @Nullable
    @Override
    public View onFindViewById(final int n) {
        return this$0.findViewById(n);
    }
    
    @Override
    public FragmentActivity onGetHost() {
        return this$0;
    }
    
    @Override
    public /* bridge */ Object onGetHost() {
        return this.onGetHost();
    }
    
    @Override
    public LayoutInflater onGetLayoutInflater() {
        return this$0.getLayoutInflater().cloneInContext((Context)this$0);
    }
    
    @Override
    public int onGetWindowAnimations() {
        final Window window = this$0.getWindow();
        if (window == null) {
            return 0;
        }
        return window.getAttributes().windowAnimations;
    }
    
    @Override
    public boolean onHasView() {
        final Window window = this$0.getWindow();
        return window != null && window.peekDecorView() != null;
    }
    
    @Override
    public boolean onHasWindowAnimations() {
        return this$0.getWindow() != null;
    }
    
    @Override
    public void onRequestPermissionsFromFragment(@NonNull final Fragment fragment, @NonNull final String[] array, final int n) {
        FragmentActivity.access$000(this$0, fragment, array, n);
    }
    
    @Override
    public boolean onShouldSaveFragmentState(final Fragment fragment) {
        return !this$0.isFinishing();
    }
    
    @Override
    public boolean onShouldShowRequestPermissionRationale(@NonNull final String s) {
        return ActivityCompat.shouldShowRequestPermissionRationale(this$0, s);
    }
    
    @Override
    public void onStartActivityFromFragment(final Fragment fragment, final Intent intent, final int n) {
        this$0.startActivityFromFragment(fragment, intent, n);
    }
    
    @Override
    public void onStartActivityFromFragment(final Fragment fragment, final Intent intent, final int n, @Nullable final Bundle bundle) {
        this$0.startActivityFromFragment(fragment, intent, n, bundle);
    }
    
    @Override
    public void onSupportInvalidateOptionsMenu() {
        this$0.supportInvalidateOptionsMenu();
    }
}
