package android.support.v4.media.routing;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.media.MediaRouter;
import android.os.Handler;
import android.os.Build.VERSION;
import android.support.v4.media.routing.MediaRouterJellybean;
import android.util.Log;
import android.view.Display;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class MediaRouterJellybeanMr1 extends MediaRouterJellybean {
   private static final String TAG = "MediaRouterJellybeanMr1";

   public static Object createCallback(MediaRouterJellybeanMr1.Callback var0) {
      return new MediaRouterJellybeanMr1.CallbackProxy(var0);
   }

   public static final class ActiveScanWorkaround implements Runnable {
      private static final int WIFI_DISPLAY_SCAN_INTERVAL = 15000;
      private boolean mActivelyScanningWifiDisplays;
      private final DisplayManager mDisplayManager;
      private final Handler mHandler;
      private Method mScanWifiDisplaysMethod;

      public ActiveScanWorkaround(Context var1, Handler var2) {
         if(VERSION.SDK_INT != 17) {
            throw new UnsupportedOperationException();
         } else {
            this.mDisplayManager = (DisplayManager)var1.getSystemService("display");
            this.mHandler = var2;

            try {
               this.mScanWifiDisplaysMethod = DisplayManager.class.getMethod("scanWifiDisplays", new Class[0]);
            } catch (NoSuchMethodException var3) {
               ;
            }
         }
      }

      public void run() {
         if(this.mActivelyScanningWifiDisplays) {
            try {
               this.mScanWifiDisplaysMethod.invoke(this.mDisplayManager, new Object[0]);
            } catch (IllegalAccessException var2) {
               Log.w("MediaRouterJellybeanMr1", "Cannot scan for wifi displays.", var2);
            } catch (InvocationTargetException var3) {
               Log.w("MediaRouterJellybeanMr1", "Cannot scan for wifi displays.", var3);
            }

            this.mHandler.postDelayed(this, 15000L);
         }

      }

      public void setActiveScanRouteTypes(int var1) {
         if((var1 & 2) != 0) {
            if(!this.mActivelyScanningWifiDisplays) {
               if(this.mScanWifiDisplaysMethod == null) {
                  Log.w("MediaRouterJellybeanMr1", "Cannot scan for wifi displays because the DisplayManager.scanWifiDisplays() method is not available on this device.");
                  return;
               }

               this.mActivelyScanningWifiDisplays = true;
               this.mHandler.post(this);
            }
         } else if(this.mActivelyScanningWifiDisplays) {
            this.mActivelyScanningWifiDisplays = false;
            this.mHandler.removeCallbacks(this);
            return;
         }

      }
   }

   public interface Callback extends MediaRouterJellybean.Callback {
      void onRoutePresentationDisplayChanged(Object var1);
   }

   static class CallbackProxy extends MediaRouterJellybean.CallbackProxy {
      public CallbackProxy(MediaRouterJellybeanMr1.Callback var1) {
         super(var1);
      }

      public void onRoutePresentationDisplayChanged(MediaRouter var1, android.media.MediaRouter.RouteInfo var2) {
         ((MediaRouterJellybeanMr1.Callback)this.mCallback).onRoutePresentationDisplayChanged(var2);
      }
   }

   public static final class IsConnectingWorkaround {
      private Method mGetStatusCodeMethod;
      private int mStatusConnecting;

      public IsConnectingWorkaround() {
         if(VERSION.SDK_INT != 17) {
            throw new UnsupportedOperationException();
         } else {
            try {
               this.mStatusConnecting = android.media.MediaRouter.RouteInfo.class.getField("STATUS_CONNECTING").getInt((Object)null);
               this.mGetStatusCodeMethod = android.media.MediaRouter.RouteInfo.class.getMethod("getStatusCode", new Class[0]);
            } catch (NoSuchFieldException var2) {
               ;
            } catch (NoSuchMethodException var3) {
               ;
            } catch (IllegalAccessException var4) {
               ;
            }
         }
      }

      public boolean isConnecting(Object var1) {
         android.media.MediaRouter.RouteInfo var6 = (android.media.MediaRouter.RouteInfo)var1;
         if(this.mGetStatusCodeMethod != null) {
            int var2;
            int var3;
            try {
               var2 = ((Integer)this.mGetStatusCodeMethod.invoke(var6, new Object[0])).intValue();
               var3 = this.mStatusConnecting;
            } catch (IllegalAccessException var4) {
               return false;
            } catch (InvocationTargetException var5) {
               return false;
            }

            if(var2 == var3) {
               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      }
   }

   public static final class RouteInfo {
      public static Display getPresentationDisplay(Object var0) {
         return ((android.media.MediaRouter.RouteInfo)var0).getPresentationDisplay();
      }

      public static boolean isEnabled(Object var0) {
         return ((android.media.MediaRouter.RouteInfo)var0).isEnabled();
      }
   }
}
