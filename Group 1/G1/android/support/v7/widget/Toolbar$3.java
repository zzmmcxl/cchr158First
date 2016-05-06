package android.support.v7.widget;

import android.view.View;
import android.view.View$OnClickListener;

class Toolbar$3 implements View$OnClickListener {
    final /* synthetic */ Toolbar this$0;
    
    Toolbar$3(final Toolbar this$0) {
        this$0 = this$0;
        super();
    }
    
    public void onClick(final View view) {
        this$0.collapseActionView();
    }
}