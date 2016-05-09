package com.se702.hider.enigma;

import android.net.Uri;
import android.widget.ImageView;
import android.widget.EditText;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

class MainActivity$1 extends BroadcastReceiver {
    final /* synthetic */ MainActivity this$0;
    
    MainActivity$1(final MainActivity this$0) {
        this$0 = this$0;
        super();
    }
    
    public void onReceive(final Context context, final Intent intent) {
        ((EditText)this$0.findViewById(R.id.editText)).setText((CharSequence)intent.getExtras().getString("output"));
        ((ImageView)this$0.findViewById(R.id.imageDisplay)).setImageURI(Uri.parse(intent.getStringExtra("imageURI")));
    }
}