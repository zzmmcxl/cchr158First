/*
 * Decompiled with CFR 0_115.
 */
package xyz;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.a.u;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xyz.a;
import xyz.c;
import xyz.d;
import xyz.g;
import xyz.g10edb67;
import xyz.h;

public class lpsdt5r
extends u {
    private ArrayList m;
    private ArrayAdapter n;
    private ListView o;
    private g p;

    public boolean onContextItemSelected(MenuItem menuItem) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo)menuItem.getMenuInfo();
        String string = (String)this.n.getItem(adapterContextMenuInfo.position);
        String[] arrstring = string.split("\n");
        a a2 = new a(arrstring[0], arrstring[1]);
        int n2 = this.p.d(a2);
        switch (menuItem.getItemId()) {
            default: {
                return false;
            }
            case 2131558594: {
                a a3 = new a(n2);
                this.p.b(a3);
                this.n.remove((Object)string);
                return true;
            }
            case 2131558593: 
        }
        Intent intent = new Intent((Context)this, (Class)g10edb67.class);
        intent.putExtra(c.a("IPiWepEfrJlYCoZghsy/iA=="), arrstring[1]);
        this.startService(intent);
        a a4 = new a(n2);
        this.p.b(a4);
        this.n.remove((Object)string);
        return true;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968602);
        this.a((Toolbar)this.findViewById(2131558547));
        ((FloatingActionButton)this.findViewById(2131558548)).setOnClickListener((View.OnClickListener)new h(this));
        this.p = new g((Context)this);
        this.o = (ListView)this.findViewById(2131558549);
        this.m = new ArrayList();
        Iterator iterator = this.p.a().iterator();
        do {
            if (!iterator.hasNext()) {
                this.n = new ArrayAdapter((Context)this, 17367043, (List)this.m);
                this.o.setAdapter((ListAdapter)this.n);
                this.registerForContextMenu((View)this.o);
                if (android.support.v4.b.c.a((Context)this, "android.permission.ACCESS_FINE_LOCATION") == 0) return;
                android.support.v4.app.a.a(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 9);
                return;
            }
            d d2 = (d)iterator.next();
            this.m.add(d2.a() + "\n" + d2.b());
        } while (true);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        this.getMenuInflater().inflate(2131623936, (Menu)contextMenu);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(2131623937, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 2131558595) {
            return true;
        }
        try {
            throw new NullPointerException();
        }
        catch (NullPointerException var2_2) {
            return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override
    public void onRequestPermissionsResult(int n2, String[] arrstring, int[] arrn) {
        switch (n2) {
            default: {
                return;
            }
            case 9: 
        }
        if (arrn.length > 0) {
            if (arrn[0] == 0) return;
        }
        android.support.v4.app.a.a(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 9);
    }
}

