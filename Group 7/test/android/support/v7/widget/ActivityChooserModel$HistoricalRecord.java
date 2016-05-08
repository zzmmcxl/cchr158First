package android.support.v7.widget;

import android.content.ComponentName;
import java.math.BigDecimal;

public final class ActivityChooserModel$HistoricalRecord {
   public final ComponentName activity;
   public final long time;
   public final float weight;

   public ActivityChooserModel$HistoricalRecord(ComponentName var1, long var2, float var4) {
      this.activity = var1;
      this.time = var2;
      this.weight = var4;
   }

   public ActivityChooserModel$HistoricalRecord(String var1, long var2, float var4) {
      this(ComponentName.unflattenFromString(var1), var2, var4);
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 == null) {
            return false;
         }

         if(this.getClass() != var1.getClass()) {
            return false;
         }

         ActivityChooserModel$HistoricalRecord var2 = (ActivityChooserModel$HistoricalRecord)var1;
         if(this.activity == null) {
            if(var2.activity != null) {
               return false;
            }
         } else if(!this.activity.equals(var2.activity)) {
            return false;
         }

         if(this.time != var2.time) {
            return false;
         }

         if(Float.floatToIntBits(this.weight) != Float.floatToIntBits(var2.weight)) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      int var1;
      if(this.activity == null) {
         var1 = 0;
      } else {
         var1 = this.activity.hashCode();
      }

      return ((var1 + 31) * 31 + (int)(this.time ^ this.time >>> 32)) * 31 + Float.floatToIntBits(this.weight);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("[");
      var1.append("; activity:").append(this.activity);
      var1.append("; time:").append(this.time);
      var1.append("; weight:").append(new BigDecimal((double)this.weight));
      var1.append("]");
      return var1.toString();
   }
}
