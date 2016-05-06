package android.support.v7.widget;

import android.widget.AdapterView;
import android.content.Intent;
import android.view.View;
import android.widget.PopupWindow$OnDismissListener;
import android.view.View$OnLongClickListener;
import android.view.View$OnClickListener;
import android.widget.AdapterView$OnItemClickListener;

private class Callbacks implements AdapterView$OnItemClickListener, View$OnClickListener, View$OnLongClickListener, PopupWindow$OnDismissListener
{
    final /* synthetic */ ActivityChooserView this$0;
    
    private Callbacks(final ActivityChooserView this$0) {
        this$0 = this$0;
        super();
    }
    
    Callbacks(final ActivityChooserView activityChooserView, final ActivityChooserView$1 dataSetObserver) {
        this(activityChooserView);
    }
    
    private void notifyOnDismissListener() {
        if (ActivityChooserView.access$1000(this$0) != null) {
            ActivityChooserView.access$1000(this$0).onDismiss();
        }
    }
    
    public void onClick(final View view) {
        if (view == ActivityChooserView.access$700(this$0)) {
            this$0.dismissPopup();
            final Intent chooseActivity = ActivityChooserView.access$000(this$0).getDataModel().chooseActivity(ActivityChooserView.access$000(this$0).getDataModel().getActivityIndex(ActivityChooserView.access$000(this$0).getDefaultActivity()));
            if (chooseActivity != null) {
                chooseActivity.addFlags(524288);
                this$0.getContext().startActivity(chooseActivity);
            }
            return;
        }
        if (view == ActivityChooserView.access$800(this$0)) {
            ActivityChooserView.access$602(this$0, false);
            ActivityChooserView.access$500(this$0, ActivityChooserView.access$900(this$0));
            return;
        }
        throw new IllegalArgumentException();
    }
    
    public void onDismiss() {
        this.notifyOnDismissListener();
        if (mProvider != null) {
            mProvider.subUiVisibilityChanged(false);
        }
    }
    
    public void onItemClick(final AdapterView<?> adapterView, final View view, int defaultActivity, final long n) {
        switch (((ActivityChooserViewAdapter)adapterView.getAdapter()).getItemViewType(defaultActivity)) {
            default:
                throw new IllegalArgumentException();
            case 1:
                ActivityChooserView.access$500(this$0, Integer.MAX_VALUE);
                break;
            case 0:
                this$0.dismissPopup();
                if (ActivityChooserView.access$600(this$0)) {
                    if (defaultActivity > 0) {
                        ActivityChooserView.access$000(this$0).getDataModel().setDefaultActivity(defaultActivity);
                        return;
                    }
                    break;
                }
                else {
                    if (!ActivityChooserView.access$000(this$0).getShowDefaultActivity()) {
                        ++defaultActivity;
                    }
                    final Intent chooseActivity = ActivityChooserView.access$000(this$0).getDataModel().chooseActivity(defaultActivity);
                    if (chooseActivity != null) {
                        chooseActivity.addFlags(524288);
                        this$0.getContext().startActivity(chooseActivity);
                        return;
                    }
                    break;
                }
                break;
        }
    }
    
    public boolean onLongClick(final View view) {
        if (view == ActivityChooserView.access$700(this$0)) {
            if (ActivityChooserView.access$000(this$0).getCount() > 0) {
                ActivityChooserView.access$602(this$0, true);
                ActivityChooserView.access$500(this$0, ActivityChooserView.access$900(this$0));
            }
            return true;
        }
        throw new IllegalArgumentException();
    }
}
