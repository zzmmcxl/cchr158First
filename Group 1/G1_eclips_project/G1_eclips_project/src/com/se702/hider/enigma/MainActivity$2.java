package com.se702.hider.enigma;

import android.support.v7.widget.Toolbar;

class MainActivity$2 implements Runnable {
    final /* synthetic */ MainActivity this$0;
    
    MainActivity$2(final MainActivity this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        this$0.setContentView(R.layout.activity_my);
        this$0.setSupportActionBar((Toolbar)this$0.findViewById(R.id.toolbar));
    }
}