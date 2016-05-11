package com.woop.tryreverseengineerthis;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.woop.tryreverseengineerthis.CourseList.courses;
import com.woop.tryreverseengineerthis.C0926A.C0590B;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.woop.tryreverseengineerthis.O */
public class C1126O extends AppCompatActivity implements OnNavigationItemSelectedListener, C0590B {
    String f28xacdab15c;
    private C0598M f29xee7b7a90;

    /* renamed from: com.woop.tryreverseengineerthis.O.1 */
    class C06011 implements OnClickListener {
        C06011() {
        }

        public void onClick(View o1o1o1o1o1o) {
            Snackbar.make(o1o1o1o1o1o, (CharSequence) "Hello", 0).setAction((CharSequence) "Action", null).show();
        }
    }

    /* renamed from: com.woop.tryreverseengineerthis.O.2 */
    class C06022 implements DialogInterface.OnClickListener {
        C06022() {
        }

        public void onClick(DialogInterface o1o1o1o1o1o1, int o1o1o1o1o1o1o) {
            C1126O.this.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 100);
        }
    }

    /* renamed from: com.woop.tryreverseengineerthis.O.3 */
    class C06033 implements DialogInterface.OnClickListener {
        C06033() {
        }

        public void onClick(DialogInterface o1o1o1o1o1o1, int o1o1o1o1o1o1o) {
        }
    }

    public C1126O() {
        this.f28xacdab15c = "-794361856";
    }

    protected void onCreate(Bundle o1o1o1o1o1) {
        super.onCreate(o1o1o1o1o1);
        C0597J.L1L1L1L1L1L1L1L1 = getApplicationContext();
        setContentView((int) R.layout.activity_landing);
        Toolbar l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1 = (Toolbar) findViewById(R.id.mainTB);
        setSupportActionBar(l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1);
        try {
            C0596I.m21xde12b279(getApplicationContext());
        } catch (NoSuchPaddingException e) {
        } catch (NoSuchAlgorithmException e2) {
        }
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new C06011());
        startService(new Intent(this, C0600N.class));
        DrawerLayout l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l, l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l.setDrawerListener(toggle);
        toggle.syncState();
        ((NavigationView) findViewById(R.id.nav_view)).setNavigationItemSelectedListener(this);
        LocationManager l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l = (LocationManager) getSystemService("location");
        boolean l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l = false;
        boolean l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1 = false;
        if (l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l == null) {
            l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l = (LocationManager) getSystemService("location");
        }
        try {
            l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l = l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l.isProviderEnabled("gps");
        } catch (Exception e3) {
        }
        try {
            l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1 = l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l.isProviderEnabled("network");
        } catch (Exception e4) {
        }
        if (l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l || l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1) {
            Log.d("NothingToSeeHere", "Downloading ram...");
        } else {
            Builder O = new Builder(this);
            O.setMessage((CharSequence) "Please turn on Location Service for the full experience");
            O.setPositiveButton((CharSequence) "Setting", new C06022());
            O.setNegativeButton((CharSequence) "Cancel", new C06033());
            O.show();
        }
        Log.d("NothingToSeeHere", "Downloading ram...");
    }

    public void onResume() {
        super.onResume();
        LocationManager l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l = (LocationManager) getSystemService("location");
        this.f29xee7b7a90 = new C0598M();
        try {
            l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l.requestLocationUpdates("network", 0, 0.0f, this.f29xee7b7a90);
            l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l.requestLocationUpdates("gps", 0, 0.0f, this.f29xee7b7a90);
            Log.d("NothingToSeeHere", "Downloading ram...");
        } catch (SecurityException e) {
            Log.d("NothingToSeeHere", "Downloading ram...");
        }
    }

    public void onBackPressed() {
        DrawerLayout l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l.isDrawerOpen((int) MediaRouterJellybean.ALL_ROUTE_TYPES)) {
            l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l1l.closeDrawer((int) MediaRouterJellybean.ALL_ROUTE_TYPES);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onCreateOptionsMenu(Menu o1o1o1o1o1o1o1o1) {
        getMenuInflater().inflate(R.menu.landing, o1o1o1o1o1o1o1o1);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem o1o1o1o1o1o1o1o1o) {
        if (o1o1o1o1o1o1o1o1o.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(o1o1o1o1o1o1o1o1o);
    }

    public boolean onNavigationItemSelected(MenuItem o1o1o1o1o1o1o1o1o) {
        int O1O1 = o1o1o1o1o1o1o1o1o.getItemId();
        FragmentManager O1O1O1 = getSupportFragmentManager();
        Fragment O1O1O1O = null;
        if (O1O1 == R.id.nav_classes) {
            O1O1O1O = new Fragment();
        } else if (O1O1 == R.id.nav_assignments) {
            O1O1O1O = new Fragment();
        } else if (O1O1 == R.id.nav_checkin) {
            O1O1O1O = new C0926A();
        } else if (O1O1 == R.id.nav_lectures) {
            O1O1O1O = new Fragment();
        } else if (O1O1 == R.id.nav_share) {
            O1O1O1O = new Fragment();
        } else if (O1O1 == R.id.nav_send) {
            O1O1O1O = new Fragment();
        }
        O1O1O1.beginTransaction().replace(R.id.main_fragment_container, O1O1O1O).commit();
        ((DrawerLayout) findViewById(R.id.drawer_layout)).closeDrawer((int) MediaRouterJellybean.ALL_ROUTE_TYPES);
        return true;
    }

    public void onListFragmentInteraction(courses o1o1o1o1o1o1o1o1o) {
        Log.d("NothingToSeeHere", "Downloading ram...");
        String O1O1O1O1O1O1O1O = o1o1o1o1o1o1o1o1o.f7x78affa3e;
        String O1O1O1O1O1O1O1O1O = "dj20jd02j0d2j0d2jd0";
        String O1O1O1O1O1O1O1O1O1 = "apsodjpo2jdopj1oassd";
        String O1O1O1O1O1O1O1O1O1O = "dasodj02jd02jd02d2";
        String O1O1O1O1O1O1O1O1O1O1 = "aspodjaopdjasodjasso";
        String O1O1O1O1O1O1O1O1O1O1O = "sojodsojdsjodsojsdjo11";
        try {
            String O1O1O1O1O1O1O1O1 = C0596I.m23xa430057e("apsojdojaspdjaspo");
            O1O1O1O1O1O1O1O1O = C0596I.m23xa430057e(O1O1O1O1O1O1O1O1O);
            O1O1O1O1O1O1O1O1O1 = C0596I.m23xa430057e(O1O1O1O1O1O1O1O1O1);
            O1O1O1O1O1O1O1O1O1O = C0596I.m23xa430057e(O1O1O1O1O1O1O1O1O1O);
            O1O1O1O1O1O1O1O1O1O1 = C0596I.m23xa430057e(O1O1O1O1O1O1O1O1O1O1);
            O1O1O1O1O1O1O1O1O1O1O = C0596I.m23xa430057e(O1O1O1O1O1O1O1O1O1O1O);
            if (o1o1o1o1o1o1o1o1o.f6xb9921053.equals("1")) {
                Location O1O1O1O1O1O1O1O1O1O1O1O1O1O1 = C0595H.m16x774cb2ff();
                if (O1O1O1O1O1O1O1O1O1O1O1O1O1O1 == null) {
                    Toast.makeText(getApplicationContext(), O1O1O1O1O1O1O1O1O, 0).show();
                    return;
                }
                double O1O1O1O1O1O1O1O1O1O1O1O1O1O1O = O1O1O1O1O1O1O1O1O1O1O1O1O1O1.getLongitude();
                double O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1 = O1O1O1O1O1O1O1O1O1O1O1O1O1O1.getLatitude();
                String O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1 = "sdD22d3daSd2==";
                String O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O = "asd202d0asD2==";
                String O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1 = "asdk22d2djiasd0";
                String O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O = "a2d0jdASd22ASd22j0";
                try {
                    double O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1 = Double.parseDouble(C0596I.m23xa430057e("d2jasaSD2dasd=="));
                    double O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O = Double.parseDouble(C0596I.m23xa430057e(O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1));
                    double O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1 = Double.parseDouble(C0596I.m23xa430057e(O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O));
                    double O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O = Double.parseDouble(C0596I.m23xa430057e(O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1));
                    O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O = C0596I.m23xa430057e(O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O);
                    if (O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1 < O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1 || O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1 > O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O) {
                        Toast.makeText(getApplicationContext(), O1O1O1O1O1O1O1O1O1, 0).show();
                        Log.d("NothingToSeeHere", "Downloading ram...");
                        return;
                    } else if (O1O1O1O1O1O1O1O1O1O1O1O1O1O1O < O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1 || O1O1O1O1O1O1O1O1O1O1O1O1O1O1O > O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O) {
                        Toast.makeText(getApplicationContext(), O1O1O1O1O1O1O1O1O1, 0).show();
                        Log.d("NothingToSeeHere", "Downloading ram...");
                        return;
                    } else {
                        Calendar O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O = Calendar.getInstance();
                        String O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O = new SimpleDateFormat("HH").format(O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O.getTime());
                        int O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1 = O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O.get(7);
                        Log.d("NothingToSeeHere", "Downloading ram...");
                        Log.d("NothingToSeeHere", "Downloading ram...");
                        if (O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O.contains(O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1 + BuildConfig.FLAVOR)) {
                            String O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O = "ajd202ASsd20L02";
                            try {
                                if (C0596I.m23xa430057e(O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O + O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1).equals(O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O)) {
                                    Toast.makeText(getApplicationContext(), O1O1O1O1O1O1O1O1O1O1, 0).show();
                                    return;
                                }
                                Toast.makeText(getApplicationContext(), O1O1O1O1O1O1O1O1O1O, 0).show();
                                return;
                            } catch (Exception e) {
                                Toast.makeText(getApplicationContext(), O1O1O1O1O1O1O1O1 + O1O1O1O1O1O1O1O, 0).show();
                                return;
                            }
                        }
                        Toast.makeText(getApplicationContext(), O1O1O1O1O1O1O1O1 + O1O1O1O1O1O1O1O, 0).show();
                        return;
                    }
                } catch (Exception e2) {
                    Log.d("NothingToSeeHere", "Downloading ram...");
                    return;
                }
            }
            Toast.makeText(getApplicationContext(), O1O1O1O1O1O1O1O1O1O1O, 0).show();
        } catch (Exception e3) {
            Log.d("NothingToSeeHere", "Downloading ram...");
        }
    }
}
