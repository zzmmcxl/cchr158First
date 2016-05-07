/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.annotation.TargetApi;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.v4.widget.m;
import android.support.v7.b.e;
import android.support.v7.view.d;
import android.support.v7.widget.SearchView$SavedState;
import android.support.v7.widget.SearchView$SearchAutoComplete;
import android.support.v7.widget.cz;
import android.support.v7.widget.fs;
import android.support.v7.widget.ft;
import android.support.v7.widget.fu;
import android.support.v7.widget.fv;
import android.support.v7.widget.gd;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import java.util.WeakHashMap;

public class SearchView
extends cz
implements d {
    static final fs a;
    private static final boolean b;
    private boolean A;
    private boolean B;
    private int C;
    private boolean D;
    private CharSequence E;
    private boolean F;
    private int G;
    private SearchableInfo H;
    private Bundle I;
    private Runnable J;
    private final Runnable K;
    private Runnable L;
    private final WeakHashMap M;
    private final SearchView$SearchAutoComplete c;
    private final View d;
    private final View e;
    private final ImageView f;
    private final ImageView g;
    private final ImageView h;
    private final ImageView i;
    private final ImageView j;
    private final Drawable k;
    private final int l;
    private final int m;
    private final Intent n;
    private final Intent o;
    private final CharSequence p;
    private fu q;
    private ft r;
    private View.OnFocusChangeListener s;
    private fv t;
    private View.OnClickListener u;
    private boolean v;
    private boolean w;
    private m x;
    private boolean y;
    private CharSequence z;

    static {
        boolean bl2 = Build.VERSION.SDK_INT >= 8;
        b = bl2;
        a = new fs();
    }

    private Intent a(String string, Uri uri, String string2, String string3, int n2, String string4) {
        Intent intent = new Intent(string);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.E);
        if (string3 != null) {
            intent.putExtra("query", string3);
        }
        if (string2 != null) {
            intent.putExtra("intent_extra_data_key", string2);
        }
        if (this.I != null) {
            intent.putExtra("app_data", this.I);
        }
        if (n2 != 0) {
            intent.putExtra("action_key", n2);
            intent.putExtra("action_msg", string4);
        }
        if (!b) return intent;
        intent.setComponent(this.H.getSearchActivity());
        return intent;
    }

    private void a(int n2, String string, String string2) {
        Intent intent = this.a("android.intent.action.SEARCH", null, null, string2, n2, string);
        this.getContext().startActivity(intent);
    }

    static /* synthetic */ void a(SearchView searchView, boolean bl2) {
        searchView.setImeVisibility(bl2);
    }

    private void a(boolean bl2) {
        boolean bl3 = true;
        int n2 = 8;
        this.w = bl2;
        int n3 = bl2 ? 0 : n2;
        boolean bl4 = !TextUtils.isEmpty((CharSequence)this.c.getText()) ? bl3 : false;
        this.f.setVisibility(n3);
        this.b(bl4);
        View view = this.d;
        int n4 = bl2 ? n2 : 0;
        view.setVisibility(n4);
        if (this.j.getDrawable() != null && !this.v) {
            n2 = 0;
        }
        this.j.setVisibility(n2);
        this.h();
        if (bl4) {
            bl3 = false;
        }
        this.c(bl3);
        this.g();
    }

    static boolean a(Context context) {
        if (context.getResources().getConfiguration().orientation != 2) return false;
        return true;
    }

    private CharSequence b(CharSequence charSequence) {
        if (!this.v) return charSequence;
        if (this.k == null) {
            return charSequence;
        }
        int n2 = (int)(1.25 * (double)this.c.getTextSize());
        this.k.setBounds(0, 0, n2, n2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)"   ");
        spannableStringBuilder.setSpan((Object)new ImageSpan(this.k), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void b(boolean bl2) {
        int n2 = 8;
        if (this.y && this.f() && this.hasFocus() && (bl2 || !this.D)) {
            n2 = 0;
        }
        this.g.setVisibility(n2);
    }

    private void c(boolean bl2) {
        int n2;
        if (this.D && !this.c() && bl2) {
            n2 = 0;
            this.g.setVisibility(8);
        } else {
            n2 = 8;
        }
        this.i.setVisibility(n2);
    }

    @TargetApi(value=8)
    private boolean e() {
        Intent intent;
        SearchableInfo searchableInfo = this.H;
        boolean bl2 = false;
        if (searchableInfo == null) return bl2;
        boolean bl3 = this.H.getVoiceSearchEnabled();
        bl2 = false;
        if (!bl3) return bl2;
        if (this.H.getVoiceSearchLaunchWebSearch()) {
            intent = this.n;
        } else {
            boolean bl4 = this.H.getVoiceSearchLaunchRecognizer();
            intent = null;
            if (bl4) {
                intent = this.o;
            }
        }
        bl2 = false;
        if (intent == null) return bl2;
        ResolveInfo resolveInfo = this.getContext().getPackageManager().resolveActivity(intent, 65536);
        bl2 = false;
        if (resolveInfo == null) return bl2;
        return true;
    }

    private boolean f() {
        if (!this.y) {
            if (!this.D) return false;
        }
        if (this.c()) return false;
        return true;
    }

    private void g() {
        int n2 = 8;
        if (this.f() && (this.g.getVisibility() == 0 || this.i.getVisibility() == 0)) {
            n2 = 0;
        }
        this.e.setVisibility(n2);
    }

    private int getPreferredWidth() {
        return this.getContext().getResources().getDimensionPixelSize(e.abc_search_view_preferred_width);
    }

    private void h() {
        boolean bl2 = true;
        boolean bl3 = !TextUtils.isEmpty((CharSequence)this.c.getText()) ? bl2 : false;
        if (!(bl3 || this.v && !this.F)) {
            bl2 = false;
        }
        ImageView imageView = this.h;
        int n2 = 0;
        if (!bl2) {
            n2 = 8;
        }
        imageView.setVisibility(n2);
        Drawable drawable = this.h.getDrawable();
        if (drawable == null) return;
        int[] arrn = bl3 ? ENABLED_STATE_SET : EMPTY_STATE_SET;
        drawable.setState(arrn);
    }

    private void i() {
        this.post(this.K);
    }

    private void k() {
        CharSequence charSequence = this.getQueryHint();
        SearchView$SearchAutoComplete searchView$SearchAutoComplete = this.c;
        if (charSequence == null) {
            charSequence = "";
        }
        searchView$SearchAutoComplete.setHint(this.b(charSequence));
    }

    @TargetApi(value=8)
    private void l() {
        int n2 = 1;
        this.c.setThreshold(this.H.getSuggestThreshold());
        this.c.setImeOptions(this.H.getImeOptions());
        int n3 = this.H.getInputType();
        if ((n3 & 15) == n2) {
            n3 &= -65537;
            if (this.H.getSuggestAuthority() != null) {
                n3 = 524288 | (n3 | 65536);
            }
        }
        this.c.setInputType(n3);
        if (this.x != null) {
            this.x.a((Cursor)null);
        }
        if (this.H.getSuggestAuthority() == null) return;
        this.x = new gd(this.getContext(), this, this.H, this.M);
        this.c.setAdapter((ListAdapter)this.x);
        gd gd2 = (gd)this.x;
        if (this.A) {
            n2 = 2;
        }
        gd2.a(n2);
    }

    private void m() {
        Editable editable = this.c.getText();
        if (editable == null) return;
        if (TextUtils.getTrimmedLength((CharSequence)editable) <= 0) return;
        if (this.q != null) {
            if (this.q.a(editable.toString())) return;
        }
        if (this.H != null) {
            this.a(0, null, editable.toString());
        }
        this.setImeVisibility(false);
        this.n();
    }

    private void n() {
        this.c.dismissDropDown();
    }

    private void o() {
        if (!TextUtils.isEmpty((CharSequence)this.c.getText())) {
            this.c.setText((CharSequence)"");
            this.c.requestFocus();
            this.setImeVisibility(true);
            return;
        }
        if (!this.v) return;
        if (this.r != null) {
            if (this.r.a()) return;
        }
        this.clearFocus();
        this.a(true);
    }

    private void p() {
        this.a(false);
        this.c.requestFocus();
        this.setImeVisibility(true);
        if (this.u == null) return;
        this.u.onClick((View)this);
    }

    private void q() {
        a.a(this.c);
        a.b(this.c);
    }

    private void setImeVisibility(boolean bl2) {
        if (bl2) {
            this.post(this.J);
            return;
        }
        this.removeCallbacks(this.J);
        InputMethodManager inputMethodManager = (InputMethodManager)this.getContext().getSystemService("input_method");
        if (inputMethodManager == null) return;
        inputMethodManager.hideSoftInputFromWindow(this.getWindowToken(), 0);
    }

    private void setQuery(CharSequence charSequence) {
        this.c.setText(charSequence);
        SearchView$SearchAutoComplete searchView$SearchAutoComplete = this.c;
        int n2 = TextUtils.isEmpty((CharSequence)charSequence) ? 0 : charSequence.length();
        searchView$SearchAutoComplete.setSelection(n2);
    }

    @Override
    public void a() {
        if (this.F) {
            return;
        }
        this.F = true;
        this.G = this.c.getImeOptions();
        this.c.setImeOptions(33554432 | this.G);
        this.c.setText((CharSequence)"");
        this.setIconified(false);
    }

    void a(CharSequence charSequence) {
        this.setQuery(charSequence);
    }

    public void a(CharSequence charSequence, boolean bl2) {
        this.c.setText(charSequence);
        if (charSequence != null) {
            this.c.setSelection(this.c.length());
            this.E = charSequence;
        }
        if (!bl2) return;
        if (TextUtils.isEmpty((CharSequence)charSequence)) return;
        this.m();
    }

    @Override
    public void b() {
        this.a("", false);
        this.clearFocus();
        this.a(true);
        this.c.setImeOptions(this.G);
        this.F = false;
    }

    public boolean c() {
        return this.w;
    }

    public void clearFocus() {
        this.B = true;
        this.setImeVisibility(false);
        super.clearFocus();
        this.c.clearFocus();
        this.B = false;
    }

    void d() {
        this.a(this.c());
        this.i();
        if (!this.c.hasFocus()) return;
        this.q();
    }

    public int getImeOptions() {
        return this.c.getImeOptions();
    }

    public int getInputType() {
        return this.c.getInputType();
    }

    public int getMaxWidth() {
        return this.C;
    }

    public CharSequence getQuery() {
        return this.c.getText();
    }

    public CharSequence getQueryHint() {
        if (this.z != null) {
            return this.z;
        }
        if (!b) return this.p;
        if (this.H == null) return this.p;
        if (this.H.getHintId() == 0) return this.p;
        return this.getContext().getText(this.H.getHintId());
    }

    int getSuggestionCommitIconResId() {
        return this.m;
    }

    int getSuggestionRowLayout() {
        return this.l;
    }

    public m getSuggestionsAdapter() {
        return this.x;
    }

    protected void onDetachedFromWindow() {
        this.removeCallbacks(this.K);
        this.post(this.L);
        super.onDetachedFromWindow();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    protected void onMeasure(int var1_1, int var2_2) {
        if (this.c()) {
            super.onMeasure(var1_1, var2_2);
            return;
        }
        var3_3 = View.MeasureSpec.getMode((int)var1_1);
        var4_4 = View.MeasureSpec.getSize((int)var1_1);
        switch (var3_3) {
            case Integer.MIN_VALUE: {
                if (this.C > 0) {
                    var4_4 = Math.min(this.C, var4_4);
                    ** break;
                }
                var4_4 = Math.min(this.getPreferredWidth(), var4_4);
                ** break;
            }
            case 1073741824: {
                if (this.C > 0) {
                    var4_4 = Math.min(this.C, var4_4);
                }
            }
lbl16: // 6 sources:
            default: {
                ** GOTO lbl20
            }
            case 0: 
        }
        var4_4 = this.C > 0 ? this.C : this.getPreferredWidth();
lbl20: // 2 sources:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int)var4_4, (int)1073741824), var2_2);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SearchView$SavedState searchView$SavedState = (SearchView$SavedState)parcelable;
        super.onRestoreInstanceState(searchView$SavedState.getSuperState());
        this.a(searchView$SavedState.a);
        this.requestLayout();
    }

    protected Parcelable onSaveInstanceState() {
        SearchView$SavedState searchView$SavedState = new SearchView$SavedState(super.onSaveInstanceState());
        searchView$SavedState.a = this.c();
        return searchView$SavedState;
    }

    public void onWindowFocusChanged(boolean bl2) {
        super.onWindowFocusChanged(bl2);
        this.i();
    }

    public boolean requestFocus(int n2, Rect rect) {
        if (this.B) {
            return false;
        }
        if (!this.isFocusable()) return false;
        if (this.c()) return super.requestFocus(n2, rect);
        boolean bl2 = this.c.requestFocus(n2, rect);
        if (!bl2) return bl2;
        this.a(false);
        return bl2;
    }

    public void setAppSearchData(Bundle bundle) {
        this.I = bundle;
    }

    public void setIconified(boolean bl2) {
        if (bl2) {
            this.o();
            return;
        }
        this.p();
    }

    public void setIconifiedByDefault(boolean bl2) {
        if (this.v == bl2) {
            return;
        }
        this.v = bl2;
        this.a(bl2);
        this.k();
    }

    public void setImeOptions(int n2) {
        this.c.setImeOptions(n2);
    }

    public void setInputType(int n2) {
        this.c.setInputType(n2);
    }

    public void setMaxWidth(int n2) {
        this.C = n2;
        this.requestLayout();
    }

    public void setOnCloseListener(ft ft2) {
        this.r = ft2;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.s = onFocusChangeListener;
    }

    public void setOnQueryTextListener(fu fu2) {
        this.q = fu2;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.u = onClickListener;
    }

    public void setOnSuggestionListener(fv fv2) {
        this.t = fv2;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.z = charSequence;
        this.k();
    }

    public void setQueryRefinementEnabled(boolean bl2) {
        this.A = bl2;
        if (!(this.x instanceof gd)) return;
        gd gd2 = (gd)this.x;
        int n2 = bl2 ? 2 : 1;
        gd2.a(n2);
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.H = searchableInfo;
        if (this.H != null) {
            if (b) {
                this.l();
            }
            this.k();
        }
        boolean bl2 = b && this.e();
        this.D = bl2;
        if (this.D) {
            this.c.setPrivateImeOptions("nm");
        }
        this.a(this.c());
    }

    public void setSubmitButtonEnabled(boolean bl2) {
        this.y = bl2;
        this.a(this.c());
    }

    public void setSuggestionsAdapter(m m2) {
        this.x = m2;
        this.c.setAdapter((ListAdapter)this.x);
    }
}

