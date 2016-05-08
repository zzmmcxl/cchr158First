package android.support.v4.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentHostCallback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class FragmentActivity$HostCallbacks extends FragmentHostCallback<FragmentActivity> {
   public FragmentActivity$HostCallbacks(FragmentActivity var1) {
      super(var1);
      this.this$0 = var1;
   }

   public void onAttachFragment(Fragment var1) {
      this.this$0.onAttachFragment(var1);
   }

   public void onDump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      this.this$0.dump(var1, var2, var3, var4);
   }

   @Nullable
   public View onFindViewById(int var1) {
      return this.this$0.findViewById(var1);
   }

   public FragmentActivity onGetHost() {
      return this.this$0;
   }

   public LayoutInflater onGetLayoutInflater() {
      return this.this$0.getLayoutInflater().cloneInContext(this.this$0);
   }

   public int onGetWindowAnimations() {
      Window var1 = this.this$0.getWindow();
      return var1 == null?0:var1.getAttributes().windowAnimations;
   }

   public boolean onHasView() {
      Window var1 = this.this$0.getWindow();
      return var1 != null && var1.peekDecorView() != null;
   }

   public boolean onHasWindowAnimations() {
      return this.this$0.getWindow() != null;
   }

   public void onRequestPermissionsFromFragment(@NonNull Fragment var1, @NonNull String[] var2, int var3) {
      FragmentActivity.access$000(this.this$0, var1, var2, var3);
   }

   public boolean onShouldSaveFragmentState(Fragment var1) {
      return !this.this$0.isFinishing();
   }

   public boolean onShouldShowRequestPermissionRationale(@NonNull String var1) {
      return ActivityCompat.shouldShowRequestPermissionRationale(this.this$0, var1);
   }

   public void onStartActivityFromFragment(Fragment var1, Intent var2, int var3) {
      this.this$0.startActivityFromFragment(var1, var2, var3);
   }

   public void onStartActivityFromFragment(Fragment var1, Intent var2, int var3, @Nullable Bundle var4) {
      this.this$0.startActivityFromFragment(var1, var2, var3, var4);
   }

   public void onSupportInvalidateOptionsMenu() {
      this.this$0.supportInvalidateOptionsMenu();
   }
}
