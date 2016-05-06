package android.support.v7.view;

import android.support.v4.view.ViewConfigurationCompat;
import android.view.ViewConfiguration;
import android.os.Build$VERSION;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.support.v7.appcompat.R;
import android.content.Context;

public class ActionBarPolicy
{
    private Context mContext;
    
    private ActionBarPolicy(final Context mContext) {
        super();
        mContext = mContext;
    }
    
    public static ActionBarPolicy get(final Context context) {
        return new ActionBarPolicy(context);
    }
    
    public boolean enableHomeButtonByDefault() {
        return mContext.getApplicationInfo().targetSdkVersion < 14;
    }
    
    public int getEmbeddedMenuWidthLimit() {
        return mContext.getResources().getDisplayMetrics().widthPixels / 2;
    }
    
    public int getMaxActionButtons() {
        return mContext.getResources().getInteger(R.integer.abc_max_action_buttons);
    }
    
    public int getStackedTabMaxWidth() {
        return mContext.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
    }
    
    public int getTabContainerHeight() {
        final TypedArray obtainStyledAttributes = mContext.obtainStyledAttributes((AttributeSet)null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        int n = obtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0);
        final Resources resources = mContext.getResources();
        if (!this.hasEmbeddedTabs()) {
            n = Math.min(n, resources.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return n;
    }
    
    public boolean hasEmbeddedTabs() {
        if (mContext.getApplicationInfo().targetSdkVersion >= 16) {
            return mContext.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
        }
        return mContext.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs_pre_jb);
    }
    
    public boolean showsOverflowMenuButton() {
        return Build$VERSION.SDK_INT >= 19 || !ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(mContext));
    }
}
