package android.support.v7.app;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView$OnItemClickListener;

class AlertController$AlertParams$4 implements AdapterView$OnItemClickListener {
    final /* synthetic */ AlertParams this$0;
    final /* synthetic */ AlertController val$dialog;
    final /* synthetic */ ListView val$listView;
    
    AlertController$AlertParams$4(final AlertParams this$0, final ListView val$listView, final AlertController val$dialog) {
        this$0 = this$0;
        val$listView = val$listView;
        val$dialog = val$dialog;
        super();
    }
    
    public void onItemClick(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
        if (mCheckedItems != null) {
            mCheckedItems[n] = val$listView.isItemChecked(n);
        }
        mOnCheckboxClickListener.onClick((DialogInterface)AlertController.access$600(val$dialog), n, val$listView.isItemChecked(n));
    }
}