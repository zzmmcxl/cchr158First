package android.support.v7.widget;

import android.view.View;

private class OpenOverflowRunnable implements Runnable
{
    private OverflowPopup mPopup;
    final /* synthetic */ ActionMenuPresenter this$0;
    
    public OpenOverflowRunnable(final ActionMenuPresenter this$0, final OverflowPopup mPopup) {
        this$0 = this$0;
        super();
        mPopup = mPopup;
    }
    
    @Override
    public void run() {
        ActionMenuPresenter.access$900(this$0).changeMenuMode();
        final View view = (View)ActionMenuPresenter.access$1000(this$0);
        if (view != null && view.getWindowToken() != null && mPopup.tryShow()) {
            ActionMenuPresenter.access$202(this$0, mPopup);
        }
        ActionMenuPresenter.access$302(this$0, null);
    }
}
