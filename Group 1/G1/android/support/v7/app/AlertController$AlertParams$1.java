package android.support.v7.app;

import android.view.ViewGroup;
import android.view.View;
import android.content.Context;
import android.widget.ListView;
import android.widget.ArrayAdapter;

class AlertController$AlertParams$1 extends ArrayAdapter<CharSequence> {
    final /* synthetic */ AlertParams this$0;
    final /* synthetic */ ListView val$listView;
    
    AlertController$AlertParams$1(final AlertParams this$0, final Context context, final int n, final int n2, final CharSequence[] array, final ListView val$listView) {
        this$0 = this$0;
        val$listView = val$listView;
        super(context, n, n2, (Object[])array);
    }
    
    public View getView(final int n, final View view, final ViewGroup viewGroup) {
        final View view2 = super.getView(n, view, viewGroup);
        if (mCheckedItems != null && mCheckedItems[n]) {
            val$listView.setItemChecked(n, true);
        }
        return view2;
    }
}