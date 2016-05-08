package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.LoaderManager$LoaderCallbacks;
import android.support.v4.app.LoaderManagerImpl;
import android.support.v4.content.Loader;
import android.support.v4.content.Loader$OnLoadCanceledListener;
import android.support.v4.content.Loader$OnLoadCompleteListener;
import android.support.v4.util.DebugUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class LoaderManagerImpl$LoaderInfo implements Loader$OnLoadCompleteListener<Object>, Loader$OnLoadCanceledListener<Object> {
   final Bundle mArgs;
   LoaderManager$LoaderCallbacks<Object> mCallbacks;
   Object mData;
   boolean mDeliveredData;
   boolean mDestroyed;
   boolean mHaveData;
   final int mId;
   boolean mListenerRegistered;
   Loader<Object> mLoader;
   LoaderManagerImpl$LoaderInfo mPendingLoader;
   boolean mReportNextStart;
   boolean mRetaining;
   boolean mRetainingStarted;
   boolean mStarted;

   public LoaderManagerImpl$LoaderInfo(LoaderManagerImpl var1, int var2, Bundle var3, LoaderManager$LoaderCallbacks var4) {
      this.this$0 = var1;
      this.mId = var2;
      this.mArgs = var3;
      this.mCallbacks = var4;
   }

   void callOnLoadFinished(Loader<Object> var1, Object var2) {
      if(this.mCallbacks != null) {
         String var3 = null;
         if(LoaderManagerImpl.access$000(this.this$0) != null) {
            var3 = LoaderManagerImpl.access$000(this.this$0).mFragmentManager.mNoTransactionsBecause;
            LoaderManagerImpl.access$000(this.this$0).mFragmentManager.mNoTransactionsBecause = "onLoadFinished";
         }

         boolean var5 = false;

         try {
            var5 = true;
            if(LoaderManagerImpl.DEBUG) {
               Log.v("LoaderManager", "  onLoadFinished in " + var1 + ": " + var1.dataToString(var2));
            }

            this.mCallbacks.onLoadFinished(var1, var2);
            var5 = false;
         } finally {
            if(var5) {
               if(LoaderManagerImpl.access$000(this.this$0) != null) {
                  LoaderManagerImpl.access$000(this.this$0).mFragmentManager.mNoTransactionsBecause = var3;
               }

            }
         }

         if(LoaderManagerImpl.access$000(this.this$0) != null) {
            LoaderManagerImpl.access$000(this.this$0).mFragmentManager.mNoTransactionsBecause = var3;
         }

         this.mDeliveredData = true;
      }

   }

   void cancel() {
      if(LoaderManagerImpl.DEBUG) {
         Log.v("LoaderManager", "  Canceling: " + this);
      }

      if(this.mStarted && this.mLoader != null && this.mListenerRegistered && !this.mLoader.cancelLoad()) {
         this.onLoadCanceled(this.mLoader);
      }

   }

   void destroy() {
      if(LoaderManagerImpl.DEBUG) {
         Log.v("LoaderManager", "  Destroying: " + this);
      }

      this.mDestroyed = true;
      boolean var1 = this.mDeliveredData;
      this.mDeliveredData = false;
      if(this.mCallbacks != null && this.mLoader != null && this.mHaveData && var1) {
         if(LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "  Reseting: " + this);
         }

         String var2 = null;
         if(LoaderManagerImpl.access$000(this.this$0) != null) {
            var2 = LoaderManagerImpl.access$000(this.this$0).mFragmentManager.mNoTransactionsBecause;
            LoaderManagerImpl.access$000(this.this$0).mFragmentManager.mNoTransactionsBecause = "onLoaderReset";
         }

         boolean var5 = false;

         try {
            var5 = true;
            this.mCallbacks.onLoaderReset(this.mLoader);
            var5 = false;
         } finally {
            if(var5) {
               if(LoaderManagerImpl.access$000(this.this$0) != null) {
                  LoaderManagerImpl.access$000(this.this$0).mFragmentManager.mNoTransactionsBecause = var2;
               }

            }
         }

         if(LoaderManagerImpl.access$000(this.this$0) != null) {
            LoaderManagerImpl.access$000(this.this$0).mFragmentManager.mNoTransactionsBecause = var2;
         }
      }

      this.mCallbacks = null;
      this.mData = null;
      this.mHaveData = false;
      if(this.mLoader != null) {
         if(this.mListenerRegistered) {
            this.mListenerRegistered = false;
            this.mLoader.unregisterListener(this);
            this.mLoader.unregisterOnLoadCanceledListener(this);
         }

         this.mLoader.reset();
      }

      if(this.mPendingLoader != null) {
         this.mPendingLoader.destroy();
      }

   }

   public void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      var3.print(var1);
      var3.print("mId=");
      var3.print(this.mId);
      var3.print(" mArgs=");
      var3.println(this.mArgs);
      var3.print(var1);
      var3.print("mCallbacks=");
      var3.println(this.mCallbacks);
      var3.print(var1);
      var3.print("mLoader=");
      var3.println(this.mLoader);
      if(this.mLoader != null) {
         this.mLoader.dump(var1 + "  ", var2, var3, var4);
      }

      if(this.mHaveData || this.mDeliveredData) {
         var3.print(var1);
         var3.print("mHaveData=");
         var3.print(this.mHaveData);
         var3.print("  mDeliveredData=");
         var3.println(this.mDeliveredData);
         var3.print(var1);
         var3.print("mData=");
         var3.println(this.mData);
      }

      var3.print(var1);
      var3.print("mStarted=");
      var3.print(this.mStarted);
      var3.print(" mReportNextStart=");
      var3.print(this.mReportNextStart);
      var3.print(" mDestroyed=");
      var3.println(this.mDestroyed);
      var3.print(var1);
      var3.print("mRetaining=");
      var3.print(this.mRetaining);
      var3.print(" mRetainingStarted=");
      var3.print(this.mRetainingStarted);
      var3.print(" mListenerRegistered=");
      var3.println(this.mListenerRegistered);
      if(this.mPendingLoader != null) {
         var3.print(var1);
         var3.println("Pending Loader ");
         var3.print(this.mPendingLoader);
         var3.println(":");
         this.mPendingLoader.dump(var1 + "  ", var2, var3, var4);
      }

   }

   void finishRetain() {
      if(this.mRetaining) {
         if(LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "  Finished Retaining: " + this);
         }

         this.mRetaining = false;
         if(this.mStarted != this.mRetainingStarted && !this.mStarted) {
            this.stop();
         }
      }

      if(this.mStarted && this.mHaveData && !this.mReportNextStart) {
         this.callOnLoadFinished(this.mLoader, this.mData);
      }

   }

   public void onLoadCanceled(Loader<Object> var1) {
      if(LoaderManagerImpl.DEBUG) {
         Log.v("LoaderManager", "onLoadCanceled: " + this);
      }

      if(this.mDestroyed) {
         if(LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "  Ignoring load canceled -- destroyed");
         }
      } else if(this.this$0.mLoaders.get(this.mId) != this) {
         if(LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "  Ignoring load canceled -- not active");
            return;
         }
      } else {
         LoaderManagerImpl$LoaderInfo var2 = this.mPendingLoader;
         if(var2 != null) {
            if(LoaderManagerImpl.DEBUG) {
               Log.v("LoaderManager", "  Switching to pending loader: " + var2);
            }

            this.mPendingLoader = null;
            this.this$0.mLoaders.put(this.mId, (Object)null);
            this.destroy();
            this.this$0.installLoader(var2);
            return;
         }
      }

   }

   public void onLoadComplete(Loader<Object> var1, Object var2) {
      if(LoaderManagerImpl.DEBUG) {
         Log.v("LoaderManager", "onLoadComplete: " + this);
      }

      if(this.mDestroyed) {
         if(LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
         }
      } else if(this.this$0.mLoaders.get(this.mId) != this) {
         if(LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "  Ignoring load complete -- not active");
            return;
         }
      } else {
         LoaderManagerImpl$LoaderInfo var3 = this.mPendingLoader;
         if(var3 != null) {
            if(LoaderManagerImpl.DEBUG) {
               Log.v("LoaderManager", "  Switching to pending loader: " + var3);
            }

            this.mPendingLoader = null;
            this.this$0.mLoaders.put(this.mId, (Object)null);
            this.destroy();
            this.this$0.installLoader(var3);
            return;
         }

         if(this.mData != var2 || !this.mHaveData) {
            this.mData = var2;
            this.mHaveData = true;
            if(this.mStarted) {
               this.callOnLoadFinished(var1, var2);
            }
         }

         LoaderManagerImpl$LoaderInfo var4 = (LoaderManagerImpl$LoaderInfo)this.this$0.mInactiveLoaders.get(this.mId);
         if(var4 != null && var4 != this) {
            var4.mDeliveredData = false;
            var4.destroy();
            this.this$0.mInactiveLoaders.remove(this.mId);
         }

         if(LoaderManagerImpl.access$000(this.this$0) != null && !this.this$0.hasRunningLoaders()) {
            LoaderManagerImpl.access$000(this.this$0).mFragmentManager.startPendingDeferredFragments();
            return;
         }
      }

   }

   void reportStart() {
      if(this.mStarted && this.mReportNextStart) {
         this.mReportNextStart = false;
         if(this.mHaveData) {
            this.callOnLoadFinished(this.mLoader, this.mData);
         }
      }

   }

   void retain() {
      if(LoaderManagerImpl.DEBUG) {
         Log.v("LoaderManager", "  Retaining: " + this);
      }

      this.mRetaining = true;
      this.mRetainingStarted = this.mStarted;
      this.mStarted = false;
      this.mCallbacks = null;
   }

   void start() {
      if(this.mRetaining && this.mRetainingStarted) {
         this.mStarted = true;
      } else if(!this.mStarted) {
         this.mStarted = true;
         if(LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "  Starting: " + this);
         }

         if(this.mLoader == null && this.mCallbacks != null) {
            this.mLoader = this.mCallbacks.onCreateLoader(this.mId, this.mArgs);
         }

         if(this.mLoader != null) {
            if(this.mLoader.getClass().isMemberClass() && !Modifier.isStatic(this.mLoader.getClass().getModifiers())) {
               throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.mLoader);
            }

            if(!this.mListenerRegistered) {
               this.mLoader.registerListener(this.mId, this);
               this.mLoader.registerOnLoadCanceledListener(this);
               this.mListenerRegistered = true;
            }

            this.mLoader.startLoading();
            return;
         }
      }

   }

   void stop() {
      if(LoaderManagerImpl.DEBUG) {
         Log.v("LoaderManager", "  Stopping: " + this);
      }

      this.mStarted = false;
      if(!this.mRetaining && this.mLoader != null && this.mListenerRegistered) {
         this.mListenerRegistered = false;
         this.mLoader.unregisterListener(this);
         this.mLoader.unregisterOnLoadCanceledListener(this);
         this.mLoader.stopLoading();
      }

   }

   public String toString() {
      StringBuilder var1 = new StringBuilder(64);
      var1.append("LoaderInfo{");
      var1.append(Integer.toHexString(System.identityHashCode(this)));
      var1.append(" #");
      var1.append(this.mId);
      var1.append(" : ");
      DebugUtils.buildShortClassTag(this.mLoader, var1);
      var1.append("}}");
      return var1.toString();
   }
}
