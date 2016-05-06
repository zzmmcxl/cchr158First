package android.support.v7.view.menu;

import android.view.View;
import android.view.MenuItem;
import android.view.ActionProvider$VisibilityListener;
import android.view.ActionProvider;
import android.support.v4.internal.view.SupportMenuItem;
import android.content.Context;
import android.annotation.TargetApi;

@TargetApi(16)
class MenuItemWrapperJB extends MenuItemWrapperICS
{
    MenuItemWrapperJB(final Context context, final SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }
    
    @Override
    ActionProviderWrapper createActionProviderWrapper(final ActionProvider actionProvider) {
        return new ActionProviderWrapperJB(this.mContext, actionProvider);
    }
}
