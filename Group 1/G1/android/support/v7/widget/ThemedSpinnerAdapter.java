package android.support.v7.widget;

import android.support.v7.view.ContextThemeWrapper;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.content.Context;
import android.support.annotation.Nullable;
import android.content.res.Resources$Theme;
import android.widget.SpinnerAdapter;

public interface ThemedSpinnerAdapter extends SpinnerAdapter
{
    @Nullable
    Resources$Theme getDropDownViewTheme();
    
    void setDropDownViewTheme(@Nullable final Resources$Theme p0);
}
