package android.support.v7.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class AppCompatActivity extends FragmentActivity implements AppCompatCallback, TaskStackBuilder.SupportParentable, ActionBarDrawerToggle.DelegateProvider {
   private AppCompatDelegate mDelegate;

   public void addContentView(View var1, LayoutParams var2) {
      this.getDelegate().addContentView(var1, var2);
   }

   public AppCompatDelegate getDelegate() {
      if(this.mDelegate == null) {
         this.mDelegate = AppCompatDelegate.create((Activity)this, this);
      }

      return this.mDelegate;
   }

   @Nullable
   public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
      return this.getDelegate().getDrawerToggleDelegate();
   }

   public MenuInflater getMenuInflater() {
      return this.getDelegate().getMenuInflater();
   }

   @Nullable
   public ActionBar getSupportActionBar() {
      return this.getDelegate().getSupportActionBar();
   }

   @Nullable
   public Intent getSupportParentActivityIntent() {
      return NavUtils.getParentActivityIntent(this);
   }

   public void invalidateOptionsMenu() {
      this.getDelegate().invalidateOptionsMenu();
   }

   public void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      this.getDelegate().onConfigurationChanged(var1);
   }

   public void onContentChanged() {
      this.onSupportContentChanged();
   }

   protected void onCreate(@Nullable Bundle var1) {
      this.getDelegate().installViewFactory();
      super.onCreate(var1);
      this.getDelegate().onCreate(var1);
   }

   public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder var1) {
      var1.addParentStack((Activity)this);
   }

   protected void onDestroy() {
      super.onDestroy();
      this.getDelegate().onDestroy();
   }

   public final boolean onMenuItemSelected(int var1, MenuItem var2) {
      if(super.onMenuItemSelected(var1, var2)) {
         return true;
      } else {
         ActionBar var3 = this.getSupportActionBar();
         return var2.getItemId() == 16908332 && var3 != null && (var3.getDisplayOptions() & 4) != 0?this.onSupportNavigateUp():false;
      }
   }

   protected void onPostCreate(@Nullable Bundle var1) {
      super.onPostCreate(var1);
      this.getDelegate().onPostCreate(var1);
   }

   protected void onPostResume() {
      super.onPostResume();
      this.getDelegate().onPostResume();
   }

   public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder var1) {
   }

   protected void onStop() {
      super.onStop();
      this.getDelegate().onStop();
   }

   public void onSupportActionModeFinished(ActionMode var1) {
   }

   public void onSupportActionModeStarted(ActionMode var1) {
   }

   @Deprecated
   public void onSupportContentChanged() {
   }

   public boolean onSupportNavigateUp() {
      Intent var1 = this.getSupportParentActivityIntent();
      if(var1 != null) {
         if(this.supportShouldUpRecreateTask(var1)) {
            TaskStackBuilder var3 = TaskStackBuilder.create(this);
            this.onCreateSupportNavigateUpTaskStack(var3);
            this.onPrepareSupportNavigateUpTaskStack(var3);
            var3.startActivities();

            try {
               ActivityCompat.finishAffinity(this);
            } catch (IllegalStateException var2) {
               this.finish();
            }
         } else {
            this.supportNavigateUpTo(var1);
         }

         return true;
      } else {
         return false;
      }
   }

   protected void onTitleChanged(CharSequence var1, int var2) {
      super.onTitleChanged(var1, var2);
      this.getDelegate().setTitle(var1);
   }

   @Nullable
   public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback var1) {
      return null;
   }

   public void setContentView(@LayoutRes int var1) {
      this.getDelegate().setContentView(var1);
   }

   public void setContentView(View var1) {
      this.getDelegate().setContentView(var1);
   }

   public void setContentView(View var1, LayoutParams var2) {
      this.getDelegate().setContentView(var1, var2);
   }

   public void setSupportActionBar(@Nullable Toolbar var1) {
      this.getDelegate().setSupportActionBar(var1);
   }

   @Deprecated
   public void setSupportProgress(int var1) {
   }

   @Deprecated
   public void setSupportProgressBarIndeterminate(boolean var1) {
   }

   @Deprecated
   public void setSupportProgressBarIndeterminateVisibility(boolean var1) {
   }

   @Deprecated
   public void setSupportProgressBarVisibility(boolean var1) {
   }

   public ActionMode startSupportActionMode(ActionMode.Callback var1) {
      return this.getDelegate().startSupportActionMode(var1);
   }

   public void supportInvalidateOptionsMenu() {
      this.getDelegate().invalidateOptionsMenu();
   }

   public void supportNavigateUpTo(Intent var1) {
      NavUtils.navigateUpTo(this, var1);
   }

   public boolean supportRequestWindowFeature(int var1) {
      return this.getDelegate().requestWindowFeature(var1);
   }

   public boolean supportShouldUpRecreateTask(Intent var1) {
      return NavUtils.shouldUpRecreateTask(this, var1);
   }
}
