package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentContainer;
import android.support.v4.app.FragmentManagerImpl;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManagerImpl;
import android.support.v4.util.SimpleArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class FragmentHostCallback<E> extends FragmentContainer {
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

   FragmentHostCallback(Activity var1, Context var2, Handler var3, int var4) {
      this.mFragmentManager = new FragmentManagerImpl();
      this.mActivity = var1;
      this.mContext = var2;
      this.mHandler = var3;
      this.mWindowAnimations = var4;
   }

   public FragmentHostCallback(Context var1, Handler var2, int var3) {
      this((Activity)null, var1, var2, var3);
   }

   FragmentHostCallback(FragmentActivity var1) {
      this(var1, var1, var1.mHandler, 0);
   }

   void doLoaderDestroy() {
      if(this.mLoaderManager != null) {
         this.mLoaderManager.doDestroy();
      }
   }

   void doLoaderRetain() {
      if(this.mLoaderManager != null) {
         this.mLoaderManager.doRetain();
      }
   }

   void doLoaderStart() {
      if(!this.mLoadersStarted) {
         this.mLoadersStarted = true;
         if(this.mLoaderManager != null) {
            this.mLoaderManager.doStart();
         } else if(!this.mCheckedForLoaderManager) {
            this.mLoaderManager = this.getLoaderManager("(root)", this.mLoadersStarted, false);
            if(this.mLoaderManager != null && !this.mLoaderManager.mStarted) {
               this.mLoaderManager.doStart();
            }
         }

         this.mCheckedForLoaderManager = true;
      }
   }

   void doLoaderStop(boolean var1) {
      this.mRetainLoaders = var1;
      if(this.mLoaderManager != null && this.mLoadersStarted) {
         this.mLoadersStarted = false;
         if(var1) {
            this.mLoaderManager.doRetain();
         } else {
            this.mLoaderManager.doStop();
         }
      }
   }

   void dumpLoaders(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      var3.print(var1);
      var3.print("mLoadersStarted=");
      var3.println(this.mLoadersStarted);
      if(this.mLoaderManager != null) {
         var3.print(var1);
         var3.print("Loader Manager ");
         var3.print(Integer.toHexString(System.identityHashCode(this.mLoaderManager)));
         var3.println(":");
         this.mLoaderManager.dump(var1 + "  ", var2, var3, var4);
      }

   }

   Activity getActivity() {
      return this.mActivity;
   }

   Context getContext() {
      return this.mContext;
   }

   FragmentManagerImpl getFragmentManagerImpl() {
      return this.mFragmentManager;
   }

   Handler getHandler() {
      return this.mHandler;
   }

   LoaderManagerImpl getLoaderManager(String var1, boolean var2, boolean var3) {
      if(this.mAllLoaderManagers == null) {
         this.mAllLoaderManagers = new SimpleArrayMap();
      }

      LoaderManagerImpl var4 = (LoaderManagerImpl)this.mAllLoaderManagers.get(var1);
      if(var4 == null) {
         if(var3) {
            var4 = new LoaderManagerImpl(var1, this, var2);
            this.mAllLoaderManagers.put(var1, var4);
         }

         return var4;
      } else {
         var4.updateHostController(this);
         return var4;
      }
   }

   LoaderManagerImpl getLoaderManagerImpl() {
      if(this.mLoaderManager != null) {
         return this.mLoaderManager;
      } else {
         this.mCheckedForLoaderManager = true;
         this.mLoaderManager = this.getLoaderManager("(root)", this.mLoadersStarted, true);
         return this.mLoaderManager;
      }
   }

   boolean getRetainLoaders() {
      return this.mRetainLoaders;
   }

   void inactivateFragment(String var1) {
      if(this.mAllLoaderManagers != null) {
         LoaderManagerImpl var2 = (LoaderManagerImpl)this.mAllLoaderManagers.get(var1);
         if(var2 != null && !var2.mRetaining) {
            var2.doDestroy();
            this.mAllLoaderManagers.remove(var1);
         }
      }

   }

   void onAttachFragment(Fragment var1) {
   }

   public void onDump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
   }

   @Nullable
   public View onFindViewById(int var1) {
      return null;
   }

   @Nullable
   public abstract E onGetHost();

   public LayoutInflater onGetLayoutInflater() {
      return (LayoutInflater)this.mContext.getSystemService("layout_inflater");
   }

   public int onGetWindowAnimations() {
      return this.mWindowAnimations;
   }

   public boolean onHasView() {
      return true;
   }

   public boolean onHasWindowAnimations() {
      return true;
   }

   public void onRequestPermissionsFromFragment(@NonNull Fragment var1, @NonNull String[] var2, int var3) {
   }

   public boolean onShouldSaveFragmentState(Fragment var1) {
      return true;
   }

   public boolean onShouldShowRequestPermissionRationale(@NonNull String var1) {
      return false;
   }

   public void onStartActivityFromFragment(Fragment var1, Intent var2, int var3) {
      this.onStartActivityFromFragment(var1, var2, var3, (Bundle)null);
   }

   public void onStartActivityFromFragment(Fragment var1, Intent var2, int var3, @Nullable Bundle var4) {
      if(var3 != -1) {
         throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
      } else {
         this.mContext.startActivity(var2);
      }
   }

   public void onSupportInvalidateOptionsMenu() {
   }

   void reportLoaderStart() {
      if(this.mAllLoaderManagers != null) {
         int var2 = this.mAllLoaderManagers.size();
         LoaderManagerImpl[] var3 = new LoaderManagerImpl[var2];

         int var1;
         for(var1 = var2 - 1; var1 >= 0; --var1) {
            var3[var1] = (LoaderManagerImpl)this.mAllLoaderManagers.valueAt(var1);
         }

         for(var1 = 0; var1 < var2; ++var1) {
            LoaderManagerImpl var4 = var3[var1];
            var4.finishRetain();
            var4.doReportStart();
         }
      }

   }

   void restoreLoaderNonConfig(SimpleArrayMap<String, LoaderManager> var1) {
      this.mAllLoaderManagers = var1;
   }

   SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
      boolean var3 = false;
      boolean var2 = false;
      if(this.mAllLoaderManagers != null) {
         int var4 = this.mAllLoaderManagers.size();
         LoaderManagerImpl[] var5 = new LoaderManagerImpl[var4];

         for(int var1 = var4 - 1; var1 >= 0; --var1) {
            var5[var1] = (LoaderManagerImpl)this.mAllLoaderManagers.valueAt(var1);
         }

         byte var9 = 0;
         boolean var7 = var2;
         int var8 = var9;

         while(true) {
            var3 = var7;
            if(var8 >= var4) {
               break;
            }

            LoaderManagerImpl var6 = var5[var8];
            if(var6.mRetaining) {
               var7 = true;
            } else {
               var6.doDestroy();
               this.mAllLoaderManagers.remove(var6.mWho);
            }

            ++var8;
         }
      }

      return var3?this.mAllLoaderManagers:null;
   }
}
