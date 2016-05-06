package android.support.v7.widget;

import android.view.View;
import android.support.v7.view.ActionMode;
import android.view.View$OnClickListener;

class ActionBarContextView$1 implements View$OnClickListener {
    final /* synthetic */ ActionBarContextView this$0;
    final /* synthetic */ ActionMode val$mode;
    
    ActionBarContextView$1(final ActionBarContextView this$0, final ActionMode val$mode) {
        this$0 = this$0;
        val$mode = val$mode;
        super();
    }
    
    public void onClick(final View view) {
        val$mode.finish();
    }
}