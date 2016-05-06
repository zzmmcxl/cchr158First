package android.support.v7.widget;

import java.math.BigDecimal;
import android.content.pm.ResolveInfo;

public final class ActivityResolveInfo implements Comparable<ActivityResolveInfo>
{
    public final ResolveInfo resolveInfo;
    final /* synthetic */ ActivityChooserModel this$0;
    public float weight;
    
    public ActivityResolveInfo(final ActivityChooserModel this$0, final ResolveInfo resolveInfo) {
        this$0 = this$0;
        super();
        resolveInfo = resolveInfo;
    }
    
    @Override
    public int compareTo(final ActivityResolveInfo activityResolveInfo) {
        return Float.floatToIntBits(weight) - Float.floatToIntBits(weight);
    }
    
    @Override
    public /* bridge */ int compareTo(final Object o) {
        return this.compareTo((ActivityResolveInfo)o);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o == null) {
                return false;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }
            if (Float.floatToIntBits(weight) != Float.floatToIntBits(weight)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return 31 + Float.floatToIntBits(weight);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("resolveInfo:").append(resolveInfo.toString());
        sb.append("; weight:").append(new BigDecimal(weight));
        sb.append("]");
        return sb.toString();
    }
}
