package android.support.v4.widget;

import android.database.Cursor;
import android.view.View;

public interface ViewBinder
{
    boolean setViewValue(final View p0, final Cursor p1, final int p2);
}
