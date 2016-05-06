package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;

class AppCompatSpinner$DropdownPopup$1 implements AdapterView$OnItemClickListener {
    final /* synthetic */ DropdownPopup this$1;
    final /* synthetic */ AppCompatSpinner val$this$0;
    
    AppCompatSpinner$DropdownPopup$1(final DropdownPopup this$1, final AppCompatSpinner val$this$0) {
        this$1 = this$1;
        val$this$0 = val$this$0;
        super();
    }
    
    public void onItemClick(final AdapterView<?> adapterView, final View view, final int selection, final long n) {
        this$0.setSelection(selection);
        if (this$0.getOnItemClickListener() != null) {
            this$0.performItemClick(view, selection, DropdownPopup.access$200(this$1).getItemId(selection));
        }
        this$1.dismiss();
    }
}