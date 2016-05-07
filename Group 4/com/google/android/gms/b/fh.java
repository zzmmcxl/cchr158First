/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.ae;
import com.google.android.gms.b.an;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@fi
public class fh
implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler a;
    private Thread.UncaughtExceptionHandler b;
    private Context c;
    private VersionInfoParcel d;

    public fh(Context context, VersionInfoParcel versionInfoParcel, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread.UncaughtExceptionHandler uncaughtExceptionHandler2) {
        this.a = uncaughtExceptionHandler;
        this.b = uncaughtExceptionHandler2;
        this.c = context;
        this.d = versionInfoParcel;
    }

    private static boolean a(Context context) {
        return (Boolean)an.g.c();
    }

    private Throwable b(Throwable throwable) {
        if (((Boolean)an.h.c()).booleanValue()) {
            return throwable;
        }
        LinkedList<Throwable> linkedList = new LinkedList<Throwable>();
        while (throwable != null) {
            linkedList.push(throwable);
            throwable = throwable.getCause();
        }
        Throwable throwable2 = null;
        while (!linkedList.isEmpty()) {
            Throwable throwable3 = (Throwable)linkedList.pop();
            StackTraceElement[] arrstackTraceElement = throwable3.getStackTrace();
            ArrayList<StackTraceElement> arrayList = new ArrayList<StackTraceElement>();
            arrayList.add(new StackTraceElement(throwable3.getClass().getName(), "<filtered>", "<filtered>", 1));
            int n2 = arrstackTraceElement.length;
            boolean bl2 = false;
            for (int i2 = 0; i2 < n2; ++i2) {
                StackTraceElement stackTraceElement = arrstackTraceElement[i2];
                if (this.a(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    bl2 = true;
                    continue;
                }
                if (this.b(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    continue;
                }
                arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
            }
            Throwable throwable4 = throwable2;
            throwable2 = throwable4;
        }
        return throwable2;
    }

    String a(Class class_, Throwable throwable, boolean bl2) {
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        return new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT)).appendQueryParameter("device", g.c().c()).appendQueryParameter("js", this.d.b).appendQueryParameter("appid", this.c.getApplicationContext().getPackageName()).appendQueryParameter("exceptiontype", class_.getName()).appendQueryParameter("stacktrace", stringWriter.toString()).appendQueryParameter("eids", TextUtils.join((CharSequence)",", (Iterable)an.a())).appendQueryParameter("trapped", String.valueOf(bl2)).toString();
    }

    public void a(Throwable throwable, boolean bl2) {
        if (!fh.a(this.c)) {
            return;
        }
        Throwable throwable2 = this.b(throwable);
        if (throwable2 == null) return;
        Class class_ = throwable.getClass();
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(this.a(class_, throwable2, bl2));
        g.c().a(this.c, this.d.b, arrayList, g.f().b());
    }

    protected boolean a(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return false;
        }
        if (string.startsWith("com.google.android.gms.ads")) {
            return true;
        }
        if (string.startsWith("com.google.ads")) {
            return true;
        }
        try {
            return Class.forName(string).isAnnotationPresent(fi.class);
        }
        catch (Exception var2_3) {
            fp.a("Fail to check class type for class " + string, var2_3);
            return false;
        }
    }

    protected boolean a(Throwable throwable) {
        boolean bl2 = true;
        if (throwable == null) {
            return false;
        }
        boolean bl3 = false;
        boolean bl4 = false;
        while (throwable != null) {
            for (StackTraceElement stackTraceElement : throwable.getStackTrace()) {
                if (this.a(stackTraceElement.getClassName())) {
                    bl4 = bl2;
                }
                if (!this.getClass().getName().equals(stackTraceElement.getClassName())) continue;
                bl3 = bl2;
            }
            throwable = throwable.getCause();
        }
        if (!bl4) return false;
        if (bl3) return false;
        return bl2;
    }

    protected boolean b(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return false;
        }
        if (string.startsWith("android.")) return true;
        if (!string.startsWith("java.")) return false;
        return true;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        if (this.a(throwable)) {
            if (Looper.getMainLooper().getThread() != thread) {
                this.a(throwable, true);
                return;
            }
            this.a(throwable, false);
        }
        if (this.a != null) {
            this.a.uncaughtException(thread, throwable);
            return;
        }
        if (this.b == null) return;
        this.b.uncaughtException(thread, throwable);
    }
}

