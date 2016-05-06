package android.support.v7.app;

import android.view.View;
import android.view.View$OnClickListener;

class ActionBarDrawerToggle$1 implements View$OnClickListener {
    final /* synthetic */ ActionBarDrawerToggle this$0;
    
    ActionBarDrawerToggle$1(final ActionBarDrawerToggle this$0) {
        this$0 = this$0;
        super();
    }
    
    public void onClick(final View view) {
        if (ActionBarDrawerToggle.access$000(this$0)) {
            ActionBarDrawerToggle.access$100(this$0);
        }
        else if (ActionBarDrawerToggle.access$200(this$0) != null) {
            ActionBarDrawerToggle.access$200(this$0).onClick(view);
        }
    }
}