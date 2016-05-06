package android.support.v7.widget;

import java.math.BigDecimal;
import android.content.ComponentName;

public static final class HistoricalRecord
{
    public final ComponentName activity;
    public final long time;
    public final float weight;
    
    public HistoricalRecord(final ComponentName activity, final long time, final float weight) {
        super();
        this.activity = activity;
        this.time = time;
        this.weight = weight;
    }
    
    public HistoricalRecord(final String s, final long n, final float n2) {
        this(ComponentName.unflattenFromString(s), n, n2);
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
            final HistoricalRecord historicalRecord = (HistoricalRecord)o;
            if (activity == null) {
                if (activity != null) {
                    return false;
                }
            }
            else if (!activity.equals((Object)activity)) {
                return false;
            }
            if (time != time) {
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
        int hashCode;
        if (activity == null) {
            hashCode = 0;
        }
        else {
            hashCode = activity.hashCode();
        }
        return 31 * (31 * (hashCode + 31) + (int)(time ^ time >>> 32)) + Float.floatToIntBits(weight);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("; activity:").append(activity);
        sb.append("; time:").append(time);
        sb.append("; weight:").append(new BigDecimal(weight));
        sb.append("]");
        return sb.toString();
    }
}
