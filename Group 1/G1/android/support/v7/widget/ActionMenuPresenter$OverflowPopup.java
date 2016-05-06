package android.support.v7.widget;

import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.appcompat.R;
import android.view.View;
import android.support.v7.view.menu.MenuBuilder;
import android.content.Context;
import android.support.v7.view.menu.MenuPopupHelper;

private class OverflowPopup extends MenuPopupHelper
{
    final /* synthetic */ ActionMenuPresenter this$0;
    
    public OverflowPopup(final ActionMenuPresenter this$0, final Context context, final MenuBuilder menuBuilder, final View view, final boolean b) {
        this$0 = this$0;
        super(context, menuBuilder, view, b, R.attr.actionOverflowMenuStyle);
        this.setGravity(8388613);
        this.setCallback(mPopupPresenterCallback);
    }
    
    @Override
    public void onDismiss() {
        super.onDismiss();
        if (ActionMenuPresenter.access$400(this$0) != null) {
            ActionMenuPresenter.access$500(this$0).close();
        }
        ActionMenuPresenter.access$202(this$0, null);
    }
}
