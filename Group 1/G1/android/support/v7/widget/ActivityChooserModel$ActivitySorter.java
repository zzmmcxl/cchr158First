package android.support.v7.widget;

import java.util.List;
import android.content.Intent;

public interface ActivitySorter
{
    void sort(final Intent p0, final List<ActivityResolveInfo> p1, final List<HistoricalRecord> p2);
}
