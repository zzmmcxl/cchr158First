package android.support.v7.app;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;

class AlertController$AlertParams$3 implements AdapterView$OnItemClickListener {
    final /* synthetic */ AlertParams this$0;
    final /* synthetic */ AlertController val$dialog;
    
    AlertController$AlertParams$3(final AlertParams this$0, final AlertController val$dialog) {
        this$0 = this$0;
        val$dialog = val$dialog;
        super();
    }
    
    public void onItemClick(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
        mOnClickListener.onClick((DialogInterface)AlertController.access$600(val$dialog), n);
        if (!mIsSingleChoice) {
            AlertController.access$600(val$dialog).dismiss();
        }
    }
}