package android.support.v7.widget;

import android.content.pm.ResolveInfo;
import android.support.v7.widget.ActivityChooserModel;
import java.math.BigDecimal;

public final class ActivityChooserModel$ActivityResolveInfo implements Comparable<ActivityChooserModel$ActivityResolveInfo> {
   public final ResolveInfo resolveInfo;
   public float weight;

   public ActivityChooserModel$ActivityResolveInfo(ActivityChooserModel var1, ResolveInfo var2) {
      this.this$0 = var1;
      this.resolveInfo = var2;
   }

   public int compareTo(ActivityChooserModel$ActivityResolveInfo var1) {
      return Float.floatToIntBits(var1.weight) - Float.floatToIntBits(this.weight);
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 == null) {
            return false;
         }

         if(this.getClass() != var1.getClass()) {
            return false;
         }

         ActivityChooserModel$ActivityResolveInfo var2 = (ActivityChooserModel$ActivityResolveInfo)var1;
         if(Float.floatToIntBits(this.weight) != Float.floatToIntBits(var2.weight)) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      return Float.floatToIntBits(this.weight) + 31;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("[");
      var1.append("resolveInfo:").append(this.resolveInfo.toString());
      var1.append("; weight:").append(new BigDecimal((double)this.weight));
      var1.append("]");
      return var1.toString();
   }
}
