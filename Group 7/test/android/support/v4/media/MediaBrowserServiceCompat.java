package android.support.v4.media;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaBrowserCompatUtils;
import android.support.v4.media.MediaBrowserServiceCompat$1;
import android.support.v4.media.MediaBrowserServiceCompat$2;
import android.support.v4.media.MediaBrowserServiceCompat$3;
import android.support.v4.media.MediaBrowserServiceCompat$4;
import android.support.v4.media.MediaBrowserServiceCompat$BrowserRoot;
import android.support.v4.media.MediaBrowserServiceCompat$ConnectionRecord;
import android.support.v4.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl;
import android.support.v4.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21;
import android.support.v4.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi23;
import android.support.v4.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase;
import android.support.v4.media.MediaBrowserServiceCompat$Result;
import android.support.v4.media.MediaBrowserServiceCompat$ServiceHandler;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
   private static final boolean DBG = false;
   public static final String KEY_MEDIA_ITEM = "media_item";
   private static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
   public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
   private static final String TAG = "MediaBrowserServiceCompat";
   private final ArrayMap<IBinder, MediaBrowserServiceCompat$ConnectionRecord> mConnections = new ArrayMap();
   private final MediaBrowserServiceCompat$ServiceHandler mHandler = new MediaBrowserServiceCompat$ServiceHandler(this, (MediaBrowserServiceCompat$1)null);
   private MediaBrowserServiceCompat$MediaBrowserServiceImpl mImpl;
   MediaSessionCompat$Token mSession;

   private void addSubscription(String var1, MediaBrowserServiceCompat$ConnectionRecord var2, Bundle var3) {
      List var5 = (List)var2.subscriptions.get(var1);
      Object var4 = var5;
      if(var5 == null) {
         var4 = new ArrayList();
      }

      Iterator var6 = ((List)var4).iterator();

      do {
         if(!var6.hasNext()) {
            ((List)var4).add(var3);
            var2.subscriptions.put(var1, var4);
            this.performLoadChildren(var1, var2, var3);
            return;
         }
      } while(!MediaBrowserCompatUtils.areSameOptions(var3, (Bundle)var6.next()));

   }

   private List<MediaBrowserCompat$MediaItem> applyOptions(List<MediaBrowserCompat$MediaItem> var1, Bundle var2) {
      int var3 = var2.getInt("android.media.browse.extra.PAGE", -1);
      int var6 = var2.getInt("android.media.browse.extra.PAGE_SIZE", -1);
      if(var3 == -1 && var6 == -1) {
         return var1;
      } else {
         int var5 = var6 * (var3 - 1);
         int var4 = var5 + var6;
         if(var3 >= 1 && var6 >= 1 && var5 < var1.size()) {
            var3 = var4;
            if(var4 > var1.size()) {
               var3 = var1.size();
            }

            return var1.subList(var5, var3);
         } else {
            return Collections.emptyList();
         }
      }
   }

   private boolean isValidPackage(String var1, int var2) {
      if(var1 != null) {
         String[] var4 = this.getPackageManager().getPackagesForUid(var2);
         int var3 = var4.length;

         for(var2 = 0; var2 < var3; ++var2) {
            if(var4[var2].equals(var1)) {
               return true;
            }
         }
      }

      return false;
   }

   private void notifyChildrenChangedInternal(String var1, Bundle var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
      } else {
         this.mHandler.post(new MediaBrowserServiceCompat$2(this, var1, var2));
      }
   }

   private void performLoadChildren(String var1, MediaBrowserServiceCompat$ConnectionRecord var2, Bundle var3) {
      MediaBrowserServiceCompat$3 var4 = new MediaBrowserServiceCompat$3(this, var1, var2, var1, var3);
      if(var3 == null) {
         this.onLoadChildren(var1, var4);
      } else {
         this.onLoadChildren(var1, var4, var3);
      }

      if(!var4.isDone()) {
         throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + var2.pkg + " id=" + var1);
      }
   }

   private void performLoadItem(String var1, ResultReceiver var2) {
      MediaBrowserServiceCompat$4 var3 = new MediaBrowserServiceCompat$4(this, var1, var2);
      this.onLoadItem(var1, var3);
      if(!var3.isDone()) {
         throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + var1);
      }
   }

   private boolean removeSubscription(String var1, MediaBrowserServiceCompat$ConnectionRecord var2, Bundle var3) {
      boolean var5 = false;
      boolean var6 = false;
      List var7 = (List)var2.subscriptions.get(var1);
      if(var7 != null) {
         Iterator var8 = var7.iterator();

         boolean var4;
         while(true) {
            var4 = var6;
            if(!var8.hasNext()) {
               break;
            }

            Bundle var9 = (Bundle)var8.next();
            if(MediaBrowserCompatUtils.areSameOptions(var3, var9)) {
               var4 = true;
               var7.remove(var9);
               break;
            }
         }

         var5 = var4;
         if(var7.size() == 0) {
            var2.subscriptions.remove(var1);
            var5 = var4;
         }
      }

      return var5;
   }

   public void dump(FileDescriptor var1, PrintWriter var2, String[] var3) {
   }

   @Nullable
   public MediaSessionCompat$Token getSessionToken() {
      return this.mSession;
   }

   public void notifyChildrenChanged(@NonNull String var1) {
      this.notifyChildrenChangedInternal(var1, (Bundle)null);
   }

   public void notifyChildrenChanged(@NonNull String var1, @NonNull Bundle var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
      } else {
         this.notifyChildrenChangedInternal(var1, var2);
      }
   }

   public IBinder onBind(Intent var1) {
      return this.mImpl.onBind(var1);
   }

   public void onCreate() {
      super.onCreate();
      if(VERSION.SDK_INT >= 23) {
         this.mImpl = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi23(this);
      } else if(VERSION.SDK_INT >= 21) {
         this.mImpl = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi21(this);
      } else {
         this.mImpl = new MediaBrowserServiceCompat$MediaBrowserServiceImplBase(this);
      }

      this.mImpl.onCreate();
   }

   @Nullable
   public abstract MediaBrowserServiceCompat$BrowserRoot onGetRoot(@NonNull String var1, int var2, @Nullable Bundle var3);

   public abstract void onLoadChildren(@NonNull String var1, @NonNull MediaBrowserServiceCompat$Result<List<MediaBrowserCompat$MediaItem>> var2);

   public void onLoadChildren(@NonNull String var1, @NonNull MediaBrowserServiceCompat$Result<List<MediaBrowserCompat$MediaItem>> var2, @NonNull Bundle var3) {
      var2.setFlags(1);
      this.onLoadChildren(var1, var2);
   }

   public void onLoadItem(String var1, MediaBrowserServiceCompat$Result<MediaBrowserCompat$MediaItem> var2) {
      var2.sendResult((Object)null);
   }

   public void setSessionToken(MediaSessionCompat$Token var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Session token may not be null.");
      } else if(this.mSession != null) {
         throw new IllegalStateException("The session token has already been set.");
      } else {
         this.mSession = var1;
         this.mHandler.post(new MediaBrowserServiceCompat$1(this, var1));
      }
   }
}
