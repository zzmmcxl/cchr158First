package android.support.v7.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.TwilightCalculator;
import android.support.v7.app.TwilightManager$1;
import android.support.v7.app.TwilightManager$TwilightState;
import android.util.Log;
import java.util.Calendar;

class TwilightManager {
   private static final int SUNRISE = 6;
   private static final int SUNSET = 22;
   private static final String TAG = "TwilightManager";
   private static final TwilightManager$TwilightState sTwilightState = new TwilightManager$TwilightState((TwilightManager$1)null);
   private final Context mContext;
   private final LocationManager mLocationManager;

   TwilightManager(Context var1) {
      this.mContext = var1;
      this.mLocationManager = (LocationManager)var1.getSystemService("location");
   }

   private Location getLastKnownLocation() {
      Location var1 = null;
      Location var2 = null;
      if(PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
         var1 = this.getLastKnownLocationForProvider("network");
      }

      if(PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
         var2 = this.getLastKnownLocationForProvider("gps");
      }

      if(var2 != null && var1 != null) {
         if(var2.getTime() <= var1.getTime()) {
            return var1;
         }
      } else if(var2 == null) {
         return var1;
      }

      return var2;
   }

   private Location getLastKnownLocationForProvider(String var1) {
      if(this.mLocationManager != null) {
         try {
            if(this.mLocationManager.isProviderEnabled(var1)) {
               Location var3 = this.mLocationManager.getLastKnownLocation(var1);
               return var3;
            }
         } catch (Exception var2) {
            Log.d("TwilightManager", "Failed to get last known location", var2);
         }
      }

      return null;
   }

   private boolean isStateValid(TwilightManager$TwilightState var1) {
      return var1 != null && var1.nextUpdate > System.currentTimeMillis();
   }

   private void updateState(@NonNull Location var1) {
      TwilightManager$TwilightState var13 = sTwilightState;
      long var2 = System.currentTimeMillis();
      TwilightCalculator var14 = TwilightCalculator.getInstance();
      var14.calculateTwilight(var2 - 86400000L, var1.getLatitude(), var1.getLongitude());
      long var4 = var14.sunset;
      var14.calculateTwilight(var2, var1.getLatitude(), var1.getLongitude());
      boolean var12;
      if(var14.state == 1) {
         var12 = true;
      } else {
         var12 = false;
      }

      long var6 = var14.sunrise;
      long var8 = var14.sunset;
      var14.calculateTwilight(86400000L + var2, var1.getLatitude(), var1.getLongitude());
      long var10 = var14.sunrise;
      if(var6 != -1L && var8 != -1L) {
         if(var2 > var8) {
            var2 = 0L + var10;
         } else if(var2 > var6) {
            var2 = 0L + var8;
         } else {
            var2 = 0L + var6;
         }

         var2 += 60000L;
      } else {
         var2 += 43200000L;
      }

      var13.isNight = var12;
      var13.yesterdaySunset = var4;
      var13.todaySunrise = var6;
      var13.todaySunset = var8;
      var13.tomorrowSunrise = var10;
      var13.nextUpdate = var2;
   }

   boolean isNight() {
      TwilightManager$TwilightState var2 = sTwilightState;
      if(this.isStateValid(var2)) {
         return var2.isNight;
      } else {
         Location var3 = this.getLastKnownLocation();
         if(var3 != null) {
            this.updateState(var3);
            return var2.isNight;
         } else {
            Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
            int var1 = Calendar.getInstance().get(11);
            return var1 < 6 || var1 >= 22;
         }
      }
   }
}
