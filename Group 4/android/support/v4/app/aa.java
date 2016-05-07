/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.a;
import android.support.v4.app.ab;
import android.support.v4.app.ac;
import android.support.v4.app.ad;
import android.support.v4.app.af;
import android.support.v4.app.ah;
import android.support.v4.app.bb;
import android.support.v4.app.c;
import android.support.v4.app.f;
import android.support.v4.app.g;
import android.support.v4.app.v;
import android.support.v4.app.x;
import android.support.v4.g.q;
import android.support.v4.g.r;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class aa
extends v
implements c,
f {
    final Handler a;
    final af b;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;
    boolean i;
    int j;
    boolean k;
    r l;

    public aa() {
        this.a = new ab(this);
        this.b = af.a(new ac(this));
    }

    /*
     * Exception decompiling
     */
    private static String a(View var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [7[CASE]], but top level block is 0[TRYBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    private void a(String string, PrintWriter printWriter, View view) {
        printWriter.print(string);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(aa.a(view));
        if (!(view instanceof ViewGroup)) return;
        ViewGroup viewGroup = (ViewGroup)view;
        int n2 = viewGroup.getChildCount();
        if (n2 <= 0) return;
        String string2 = string + "  ";
        int n3 = 0;
        while (n3 < n2) {
            this.a(string2, printWriter, viewGroup.getChildAt(n3));
            ++n3;
        }
    }

    private int b(x x2) {
        if (this.l.b() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        do {
            if (this.l.f(this.j) < 0) {
                int n2 = this.j;
                this.l.b(n2, x2.q);
                this.j = (1 + this.j) % 65534;
                return n2;
            }
            this.j = (1 + this.j) % 65534;
        } while (true);
    }

    @Override
    final View a(View view, String string, Context context, AttributeSet attributeSet) {
        return this.b.a(view, string, context, attributeSet);
    }

    public void a(x x2) {
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public void a(x var1_1, Intent var2_2, int var3_3, Bundle var4_4) {
        this.k = true;
        if (var3_3 == -1) {
            a.a(this, var2_2, -1, var4_4);
            return;
        }
        if ((-65536 & var3_3) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
        ** GOTO lbl14
        finally {
            this.k = false;
        }
lbl14: // 2 sources:
        a.a(this, var2_2, (1 + this.b(var1_1) << 16) + (65535 & var3_3), var4_4);
        this.k = false;
        return;
    }

    void a(boolean bl2) {
        if (this.f) return;
        this.f = true;
        this.g = bl2;
        this.a.removeMessages(1);
        this.e();
    }

    protected boolean a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public void a_() {
        a.b(this);
    }

    @Override
    public final void a_(int n2) {
        if (this.i) {
            this.i = false;
            return;
        }
        if ((n2 & -256) == 0) return;
        throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
    }

    protected void b() {
        this.b.j();
    }

    public Object c() {
        return null;
    }

    public void d() {
        if (Build.VERSION.SDK_INT >= 11) {
            g.a(this);
            return;
        }
        this.h = true;
    }

    public void dump(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        if (Build.VERSION.SDK_INT >= 11) {
            // empty if block
        }
        printWriter.print(string);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String string2 = string + "  ";
        printWriter.print(string2);
        printWriter.print("mCreated=");
        printWriter.print(this.c);
        printWriter.print("mResumed=");
        printWriter.print(this.d);
        printWriter.print(" mStopped=");
        printWriter.print(this.e);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.f);
        this.b.a(string2, fileDescriptor, printWriter, arrstring);
        this.b.a().a(string, fileDescriptor, printWriter, arrstring);
        printWriter.print(string);
        printWriter.println("View Hierarchy:");
        this.a(string + "  ", printWriter, this.getWindow().getDecorView());
    }

    void e() {
        this.b.a(this.g);
        this.b.m();
    }

    public ah f() {
        return this.b.a();
    }

    public bb g() {
        return this.b.b();
    }

    protected void onActivityResult(int n2, int n3, Intent intent) {
        this.b.d();
        int n4 = n2 >> 16;
        if (n4 == 0) {
            super.onActivityResult(n2, n3, intent);
            return;
        }
        int n5 = n4 - 1;
        String string = (String)this.l.a(n5);
        this.l.c(n5);
        if (string == null) {
            Log.w((String)"FragmentActivity", (String)"Activity result delivered for unknown Fragment.");
            return;
        }
        x x2 = this.b.a(string);
        if (x2 == null) {
            Log.w((String)"FragmentActivity", (String)("Activity result no fragment exists for who: " + string));
            return;
        }
        x2.a(65535 & n2, n3, intent);
    }

    public void onBackPressed() {
        if (this.b.a().c()) return;
        this.a_();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.b.a(configuration);
    }

    @Override
    protected void onCreate(Bundle bundle) {
        this.b.a((x)null);
        super.onCreate(bundle);
        ad ad2 = (ad)this.getLastNonConfigurationInstance();
        if (ad2 != null) {
            this.b.a(ad2.c);
        }
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            af af2 = this.b;
            List list = ad2 != null ? ad2.b : null;
            af2.a(parcelable, list);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.j = bundle.getInt("android:support:next_request_index");
                int[] arrn = bundle.getIntArray("android:support:request_indicies");
                String[] arrstring = bundle.getStringArray("android:support:request_fragment_who");
                if (arrn == null || arrstring == null || arrn.length != arrstring.length) {
                    Log.w((String)"FragmentActivity", (String)"Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.l = new r(arrn.length);
                    for (int i2 = 0; i2 < arrn.length; ++i2) {
                        this.l.b(arrn[i2], arrstring[i2]);
                    }
                }
            }
        }
        if (this.l == null) {
            this.l = new r();
            this.j = 0;
        }
        this.b.g();
    }

    public boolean onCreatePanelMenu(int n2, Menu menu) {
        if (n2 != 0) return super.onCreatePanelMenu(n2, menu);
        boolean bl2 = super.onCreatePanelMenu(n2, menu) | this.b.a(menu, this.getMenuInflater());
        if (Build.VERSION.SDK_INT < 11) return true;
        return bl2;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.a(false);
        this.b.n();
        this.b.r();
    }

    public boolean onKeyDown(int n2, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 5) return super.onKeyDown(n2, keyEvent);
        if (n2 != 4) return super.onKeyDown(n2, keyEvent);
        if (keyEvent.getRepeatCount() != 0) return super.onKeyDown(n2, keyEvent);
        this.onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.b.o();
    }

    public boolean onMenuItemSelected(int n2, MenuItem menuItem) {
        if (super.onMenuItemSelected(n2, menuItem)) {
            return true;
        }
        switch (n2) {
            default: {
                return false;
            }
            case 0: {
                return this.b.a(menuItem);
            }
            case 6: 
        }
        return this.b.b(menuItem);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.b.d();
    }

    public void onPanelClosed(int n2, Menu menu) {
        switch (n2) {
            default: {
                break;
            }
            case 0: {
                this.b.b(menu);
            }
        }
        super.onPanelClosed(n2, menu);
    }

    protected void onPause() {
        super.onPause();
        this.d = false;
        if (this.a.hasMessages(2)) {
            this.a.removeMessages(2);
            this.b();
        }
        this.b.k();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.a.removeMessages(2);
        this.b();
        this.b.p();
    }

    public boolean onPreparePanel(int n2, View view, Menu menu) {
        if (n2 != 0) return super.onPreparePanel(n2, view, menu);
        if (menu == null) return super.onPreparePanel(n2, view, menu);
        if (!this.h) return this.a(view, menu) | this.b.a(menu);
        this.h = false;
        menu.clear();
        this.onCreatePanelMenu(n2, menu);
        return this.a(view, menu) | this.b.a(menu);
    }

    @Override
    public void onRequestPermissionsResult(int n2, String[] arrstring, int[] arrn) {
        int n3 = 255 & n2 >> 8;
        if (n3 == 0) return;
        int n4 = n3 - 1;
        int n5 = this.b.c();
        if (n5 == 0 || n4 < 0 || n4 >= n5) {
            Log.w((String)"FragmentActivity", (String)("Activity result fragment index out of range: 0x" + Integer.toHexString(n2)));
            return;
        }
        x x2 = (x)this.b.a(new ArrayList(n5)).get(n4);
        if (x2 == null) {
            Log.w((String)"FragmentActivity", (String)("Activity result no fragment exists for index: 0x" + Integer.toHexString(n2)));
            return;
        }
        x2.a(n2 & 255, arrstring, arrn);
    }

    protected void onResume() {
        super.onResume();
        this.a.sendEmptyMessage(2);
        this.d = true;
        this.b.p();
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.e) {
            this.a(true);
        }
        Object object = this.c();
        List list = this.b.f();
        q q2 = this.b.t();
        if (list == null && q2 == null && object == null) {
            return null;
        }
        ad ad2 = new ad();
        ad2.a = object;
        ad2.b = list;
        ad2.c = q2;
        return ad2;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable parcelable = this.b.e();
        if (parcelable != null) {
            bundle.putParcelable("android:support:fragments", parcelable);
        }
        if (this.l.b() <= 0) return;
        bundle.putInt("android:support:next_request_index", this.j);
        int[] arrn = new int[this.l.b()];
        String[] arrstring = new String[this.l.b()];
        int n2 = 0;
        do {
            if (n2 >= this.l.b()) {
                bundle.putIntArray("android:support:request_indicies", arrn);
                bundle.putStringArray("android:support:request_fragment_who", arrstring);
                return;
            }
            arrn[n2] = this.l.d(n2);
            arrstring[n2] = (String)this.l.e(n2);
            ++n2;
        } while (true);
    }

    protected void onStart() {
        super.onStart();
        this.e = false;
        this.f = false;
        this.a.removeMessages(1);
        if (!this.c) {
            this.c = true;
            this.b.h();
        }
        this.b.d();
        this.b.p();
        this.b.q();
        this.b.i();
        this.b.s();
    }

    public void onStateNotSaved() {
        this.b.d();
    }

    protected void onStop() {
        super.onStop();
        this.e = true;
        this.a.sendEmptyMessage(1);
        this.b.l();
    }

    public void startActivityForResult(Intent intent, int n2) {
        if (!this.k && n2 != -1 && (-65536 & n2) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
        super.startActivityForResult(intent, n2);
    }
}

