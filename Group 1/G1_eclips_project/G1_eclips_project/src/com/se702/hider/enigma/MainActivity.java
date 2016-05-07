package com.se702.hider.enigma;

import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.view.MenuItem;
import android.view.Menu;
import android.support.v7.widget.Toolbar;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.EditText;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    protected static final int ACTION_DO_DECODE = 2;
    protected static final int ACTION_DO_ENCODE = 1;
    private BroadcastReceiver BReceiver;
    private int GALLERY_KITKAT_INTENT_CALLED;
    
    public MainActivity() {
        super();
        BReceiver = new BroadcastReceiver() {
//            final /*synthetic*/ MainActivity this$0;
//            
//            MainActivity$1() {
//                this$0 = this$0;
//                super();
//            }
            
            public void onReceive(final Context context, final Intent intent) {
                ((EditText)this$0.findViewById(R.id.editText)).setText((CharSequence)intent.getExtras().getString("output"));
                ((ImageView)this$0.findViewById(R.id.imageDisplay)).setImageURI(Uri.parse(intent.getStringExtra("imageURI")));
            }
        };
    }
    
    public void decodeMessage(final View view) {
        final Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        this.startActivityForResult(intent, 2);
    }
    
    public void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (n2 == -1 && intent != null) {
            final Uri data = intent.getData();
            if (n == 1) {
                final Intent intent2 = new Intent("android.intent.action.SYNC", (Uri)null, (Context)this, (Class)EncoderService.class);
                final String string = ((EditText)this.findViewById(R.id.edit_message)).getText().toString();
                intent2.putExtra("imageURI", data.toString());
                intent2.putExtra("message", string);
                this.startService(intent2);
                return;
            }
            if (n == 2) {
                final Intent intent3 = new Intent("android.intent.action.SYNC", (Uri)null, (Context)this, (Class)DeencoderService.class);
                intent3.putExtra("imageURI", data.toString());
                this.startService(intent3);
            }
        }
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.splash);
        new Handler().postDelayed((Runnable)new Runnable() {
//            final /* synthetic */ MainActivity this$0;
//            
//            MainActivity$2() {
//                this$0 = this$0;
//                super();
//            }
            
            @Override
            public void run() {
                this$0.setContentView(R.layout.activity_my);
                this$0.setSupportActionBar((Toolbar)this$0.findViewById(R.id.toolbar));
            }
        }, (long)5000);
    }
    
    public boolean onCreateOptionsMenu(final Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        return menuItem.getItemId() == R.id.action_settings || super.onOptionsItemSelected(menuItem);
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance((Context)this).unregisterReceiver(BReceiver);
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance((Context)this).registerReceiver(BReceiver, new IntentFilter("BReceivermessage"));
    }
    
    public void sendMessage(final View view) {
        final Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        this.startActivityForResult(intent, 1);
    }
}