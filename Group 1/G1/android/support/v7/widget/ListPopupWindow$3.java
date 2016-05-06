package android.support.v7.widget;

import android.widget.ListView;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.os.Build$VERSION;
import android.util.AttributeSet;
import android.support.v7.appcompat.R;
import android.content.Context;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemSelectedListener;

class ListPopupWindow$3 implements AdapterView$OnItemSelectedListener {
    final /* synthetic */ ListPopupWindow this$0;
    
    ListPopupWindow$3(final ListPopupWindow this$0) {
        this$0 = this$0;
        super();
    }
    
    public void onItemSelected(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
        if (n != -1) {
            final DropDownListView access$600 = ListPopupWindow.access$600(this$0);
            if (access$600 != null) {
                access$600.mListSelectionHidden = false;
            }
        }
    }
    
    public void onNothingSelected(final AdapterView<?> adapterView) {
    }
}