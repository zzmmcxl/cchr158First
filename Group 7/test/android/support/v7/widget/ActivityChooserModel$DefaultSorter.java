package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.widget.ActivityChooserModel;
import android.support.v7.widget.ActivityChooserModel$ActivityResolveInfo;
import android.support.v7.widget.ActivityChooserModel$ActivitySorter;
import android.support.v7.widget.ActivityChooserModel$HistoricalRecord;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class ActivityChooserModel$DefaultSorter implements ActivityChooserModel$ActivitySorter {
   private static final float WEIGHT_DECAY_COEFFICIENT = 0.95F;
   private final Map<ComponentName, ActivityChooserModel$ActivityResolveInfo> mPackageNameToActivityMap;

   private ActivityChooserModel$DefaultSorter(ActivityChooserModel var1) {
      this.this$0 = var1;
      this.mPackageNameToActivityMap = new HashMap();
   }

   public void sort(Intent var1, List<ActivityChooserModel$ActivityResolveInfo> var2, List<ActivityChooserModel$HistoricalRecord> var3) {
      Map var10 = this.mPackageNameToActivityMap;
      var10.clear();
      int var7 = var2.size();

      int var6;
      for(var6 = 0; var6 < var7; ++var6) {
         ActivityChooserModel$ActivityResolveInfo var8 = (ActivityChooserModel$ActivityResolveInfo)var2.get(var6);
         var8.weight = 0.0F;
         var10.put(new ComponentName(var8.resolveInfo.activityInfo.packageName, var8.resolveInfo.activityInfo.name), var8);
      }

      var6 = var3.size();
      float var4 = 1.0F;
      --var6;

      while(var6 >= 0) {
         ActivityChooserModel$HistoricalRecord var11 = (ActivityChooserModel$HistoricalRecord)var3.get(var6);
         ActivityChooserModel$ActivityResolveInfo var9 = (ActivityChooserModel$ActivityResolveInfo)var10.get(var11.activity);
         float var5 = var4;
         if(var9 != null) {
            var9.weight += var11.weight * var4;
            var5 = var4 * 0.95F;
         }

         --var6;
         var4 = var5;
      }

      Collections.sort(var2);
   }
}
