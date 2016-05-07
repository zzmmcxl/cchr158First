/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.os.ResultReceiver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

class fs {
    private Method a;
    private Method b;
    private Method c;
    private Method d;

    fs() {
        try {
            this.a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
            this.a.setAccessible(true);
        }
        catch (NoSuchMethodException var1_6) {}
        try {
            this.b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
            this.b.setAccessible(true);
        }
        catch (NoSuchMethodException var2_5) {}
        try {
            Class[] arrclass = new Class[]{Boolean.TYPE};
            this.c = AutoCompleteTextView.class.getMethod("ensureImeVisible", arrclass);
            this.c.setAccessible(true);
        }
        catch (NoSuchMethodException var3_4) {}
        try {
            Class[] arrclass = new Class[]{Integer.TYPE, ResultReceiver.class};
            this.d = InputMethodManager.class.getMethod("showSoftInputUnchecked", arrclass);
            this.d.setAccessible(true);
            return;
        }
        catch (NoSuchMethodException var4_3) {
            return;
        }
    }

    void a(AutoCompleteTextView autoCompleteTextView) {
        if (this.a == null) return;
        try {
            this.a.invoke((Object)autoCompleteTextView, new Object[0]);
            return;
        }
        catch (Exception var2_2) {
            return;
        }
    }

    void a(AutoCompleteTextView autoCompleteTextView, boolean bl2) {
        if (this.c == null) return;
        try {
            Method method = this.c;
            Object[] arrobject = new Object[]{bl2};
            method.invoke((Object)autoCompleteTextView, arrobject);
            return;
        }
        catch (Exception var3_5) {
            return;
        }
    }

    void b(AutoCompleteTextView autoCompleteTextView) {
        if (this.b == null) return;
        try {
            this.b.invoke((Object)autoCompleteTextView, new Object[0]);
            return;
        }
        catch (Exception var2_2) {
            return;
        }
    }
}

