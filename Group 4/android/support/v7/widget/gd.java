/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.b.c;
import android.support.v4.widget.ar;
import android.support.v7.b.b;
import android.support.v7.b.g;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.ge;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

class gd
extends ar
implements View.OnClickListener {
    private final SearchManager j;
    private final SearchView k;
    private final SearchableInfo l;
    private final Context m;
    private final WeakHashMap n;
    private final int o;
    private boolean p = false;
    private int q = 1;
    private ColorStateList r;
    private int s = -1;
    private int t = -1;
    private int u = -1;
    private int v = -1;
    private int w = -1;
    private int x = -1;

    public gd(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.j = (SearchManager)this.d.getSystemService("search");
        this.k = searchView;
        this.l = searchableInfo;
        this.o = searchView.getSuggestionCommitIconResId();
        this.m = context;
        this.n = weakHashMap;
    }

    private Drawable a(ComponentName componentName) {
        String string = componentName.flattenToShortString();
        if (this.n.containsKey(string)) {
            Drawable.ConstantState constantState = (Drawable.ConstantState)this.n.get(string);
            if (constantState != null) return constantState.newDrawable(this.m.getResources());
            return null;
        }
        Drawable drawable = this.b(componentName);
        Drawable.ConstantState constantState = null;
        if (drawable != null) {
            constantState = drawable.getConstantState();
        }
        this.n.put(string, constantState);
        return drawable;
    }

    private Drawable a(String string) {
        Drawable drawable;
        if (string == null) return null;
        if (string.length() == 0) return null;
        if ("0".equals(string)) {
            return null;
        }
        try {
            int n2 = Integer.parseInt(string);
            String string2 = "android.resource://" + this.m.getPackageName() + "/" + n2;
            drawable = this.b(string2);
            if (drawable != null) return drawable;
            Drawable drawable2 = c.a(this.m, n2);
            this.a(string2, drawable2);
            return drawable2;
        }
        catch (NumberFormatException var5_6) {
            drawable = this.b(string);
            if (drawable != null) return drawable;
            Drawable drawable3 = this.b(Uri.parse((String)string));
            this.a(string, drawable3);
            return drawable3;
        }
        catch (Resources.NotFoundException var3_8) {
            Log.w((String)"SuggestionsAdapter", (String)("Icon resource not found: " + string));
            return null;
        }
    }

    private static String a(Cursor cursor, int n2) {
        if (n2 == -1) {
            return null;
        }
        try {
            return cursor.getString(n2);
        }
        catch (Exception var2_3) {
            Log.e((String)"SuggestionsAdapter", (String)"unexpected error retrieving valid column from cursor, did the remote process die?", (Throwable)var2_3);
            return null;
        }
    }

    public static String a(Cursor cursor, String string) {
        return gd.a(cursor, cursor.getColumnIndex(string));
    }

    private void a(ImageView imageView, Drawable drawable, int n2) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(n2);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty((CharSequence)charSequence)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
    }

    private void a(String string, Drawable drawable) {
        if (drawable == null) return;
        this.n.put(string, drawable.getConstantState());
    }

    private Drawable b(ComponentName componentName) {
        ActivityInfo activityInfo;
        PackageManager packageManager = this.d.getPackageManager();
        try {
            activityInfo = packageManager.getActivityInfo(componentName, 128);
        }
        catch (PackageManager.NameNotFoundException var3_5) {
            Log.w((String)"SuggestionsAdapter", (String)var3_5.toString());
            return null;
        }
        int n2 = activityInfo.getIconResource();
        if (n2 == 0) {
            return null;
        }
        Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), n2, activityInfo.applicationInfo);
        if (drawable != null) return drawable;
        Log.w((String)"SuggestionsAdapter", (String)("Invalid icon resource " + n2 + " for " + componentName.flattenToShortString()));
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private Drawable b(Uri var1_1) {
        block13 : {
            try {
                var4_2 = "android.resource".equals(var1_1.getScheme());
                if (var4_2) {
                    try {
                        return this.a(var1_1);
                    }
                    catch (Resources.NotFoundException var12_4) {
                        throw new FileNotFoundException("Resource does not exist: " + (Object)var1_1);
                    }
                }
                var5_6 = this.m.getContentResolver().openInputStream(var1_1);
                if (var5_6 != null) break block13;
                throw new FileNotFoundException("Failed to open " + (Object)var1_1);
            }
            catch (FileNotFoundException var2_5) {
                Log.w((String)"SuggestionsAdapter", (String)("Icon not found: " + (Object)var1_1 + ", " + var2_5.getMessage()));
                return null;
            }
        }
        try {
            var9_7 = Drawable.createFromStream((InputStream)var5_6, (String)null);
        }
        catch (Throwable var6_9) {
            try {
                var5_6.close();
            }
            catch (IOException var7_10) {
                Log.e((String)"SuggestionsAdapter", (String)("Error closing icon stream for " + (Object)var1_1), (Throwable)var7_10);
                throw var6_9;
            }
            throw var6_9;
        }
        ** try [egrp 5[TRYBLOCK] [7 : 153->158)] { 
lbl-1000: // 1 sources:
        {
            var5_6.close();
            return var9_7;
        }
lbl29: // 1 sources:
        catch (IOException var10_8) {
            Log.e((String)"SuggestionsAdapter", (String)("Error closing icon stream for " + (Object)var1_1), (Throwable)var10_8);
            return var9_7;
        }
    }

    private Drawable b(String string) {
        Drawable.ConstantState constantState = (Drawable.ConstantState)this.n.get(string);
        if (constantState != null) return constantState.newDrawable();
        return null;
    }

    private CharSequence b(CharSequence charSequence) {
        if (this.r == null) {
            TypedValue typedValue = new TypedValue();
            this.d.getTheme().resolveAttribute(b.textColorSearchUrl, typedValue, true);
            this.r = this.d.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan((Object)new TextAppearanceSpan(null, 0, 0, this.r, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private void d(Cursor cursor) {
        if (cursor == null) return;
        Bundle bundle = cursor.getExtras();
        if (bundle == null) return;
        if (!bundle.getBoolean("in_progress")) return;
    }

    private Drawable e(Cursor cursor) {
        if (this.v == -1) {
            return null;
        }
        Drawable drawable = this.a(cursor.getString(this.v));
        if (drawable != null) return drawable;
        return this.g(cursor);
    }

    private Drawable f(Cursor cursor) {
        if (this.w != -1) return this.a(cursor.getString(this.w));
        return null;
    }

    private Drawable g(Cursor cursor) {
        Drawable drawable = this.a(this.l.getSearchActivity());
        if (drawable == null) return this.d.getPackageManager().getDefaultActivityIcon();
        return drawable;
    }

    Cursor a(SearchableInfo searchableInfo, String string, int n2) {
        String[] arrstring;
        if (searchableInfo == null) {
            return null;
        }
        String string2 = searchableInfo.getSuggestAuthority();
        if (string2 == null) return null;
        Uri.Builder builder = new Uri.Builder().scheme("content").authority(string2).query("").fragment("");
        String string3 = searchableInfo.getSuggestPath();
        if (string3 != null) {
            builder.appendEncodedPath(string3);
        }
        builder.appendPath("search_suggest_query");
        String string4 = searchableInfo.getSuggestSelection();
        if (string4 != null) {
            arrstring = new String[]{string};
        } else {
            builder.appendPath(string);
            arrstring = null;
        }
        if (n2 > 0) {
            builder.appendQueryParameter("limit", String.valueOf(n2));
        }
        Uri uri = builder.build();
        return this.d.getContentResolver().query(uri, null, string4, arrstring, null);
    }

    @Override
    public Cursor a(CharSequence charSequence) {
        String string = charSequence == null ? "" : charSequence.toString();
        if (this.k.getVisibility() != 0) return null;
        if (this.k.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor cursor = this.a(this.l, string, 50);
            if (cursor == null) return null;
            cursor.getCount();
            return cursor;
        }
        catch (RuntimeException var3_4) {
            Log.w((String)"SuggestionsAdapter", (String)"Search suggestions query threw an exception.", (Throwable)var3_4);
        }
        return null;
    }

    Drawable a(Uri uri) {
        Resources resources;
        int n2;
        String string = uri.getAuthority();
        if (TextUtils.isEmpty((CharSequence)string)) {
            throw new FileNotFoundException("No authority: " + (Object)uri);
        }
        try {
            resources = this.d.getPackageManager().getResourcesForApplication(string);
        }
        catch (PackageManager.NameNotFoundException var3_5) {
            throw new FileNotFoundException("No package found for authority: " + (Object)uri);
        }
        List list = uri.getPathSegments();
        if (list == null) {
            throw new FileNotFoundException("No path: " + (Object)uri);
        }
        int n3 = list.size();
        if (n3 == 1) {
            try {
                int n4;
                n2 = n4 = Integer.parseInt((String)list.get(0));
            }
            catch (NumberFormatException var8_9) {
                throw new FileNotFoundException("Single path segment is not a resource ID: " + (Object)uri);
            }
        } else {
            if (n3 != 2) throw new FileNotFoundException("More than two path segments: " + (Object)uri);
            n2 = resources.getIdentifier((String)list.get(1), (String)list.get(0), string);
        }
        if (n2 != 0) return resources.getDrawable(n2);
        throw new FileNotFoundException("No resource found for: " + (Object)uri);
    }

    @Override
    public View a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View view = super.a(context, cursor, viewGroup);
        view.setTag((Object)new ge(view));
        ((ImageView)view.findViewById(g.edit_query)).setImageResource(this.o);
        return view;
    }

    public void a(int n2) {
        this.q = n2;
    }

    @Override
    public void a(Cursor cursor) {
        if (this.p) {
            Log.w((String)"SuggestionsAdapter", (String)"Tried to change cursor after adapter was closed.");
            if (cursor == null) return;
            cursor.close();
            return;
        }
        try {
            super.a(cursor);
            if (cursor == null) return;
            this.s = cursor.getColumnIndex("suggest_text_1");
            this.t = cursor.getColumnIndex("suggest_text_2");
            this.u = cursor.getColumnIndex("suggest_text_2_url");
            this.v = cursor.getColumnIndex("suggest_icon_1");
            this.w = cursor.getColumnIndex("suggest_icon_2");
            this.x = cursor.getColumnIndex("suggest_flags");
            return;
        }
        catch (Exception var2_2) {
            Log.e((String)"SuggestionsAdapter", (String)"error changing cursor and caching columns", (Throwable)var2_2);
            return;
        }
    }

    @Override
    public void a(View view, Context context, Cursor cursor) {
        ge ge2 = (ge)view.getTag();
        int n2 = this.x != -1 ? cursor.getInt(this.x) : 0;
        if (ge2.a != null) {
            String string = gd.a(cursor, this.s);
            this.a(ge2.a, string);
        }
        if (ge2.b != null) {
            String string = gd.a(cursor, this.u);
            CharSequence charSequence = string != null ? this.b((CharSequence)string) : gd.a(cursor, this.t);
            if (TextUtils.isEmpty((CharSequence)charSequence)) {
                if (ge2.a != null) {
                    ge2.a.setSingleLine(false);
                    ge2.a.setMaxLines(2);
                }
            } else if (ge2.a != null) {
                ge2.a.setSingleLine(true);
                ge2.a.setMaxLines(1);
            }
            this.a(ge2.b, charSequence);
        }
        if (ge2.c != null) {
            this.a(ge2.c, this.e(cursor), 4);
        }
        if (ge2.d != null) {
            this.a(ge2.d, this.f(cursor), 8);
        }
        if (this.q == 2 || this.q == 1 && (n2 & 1) != 0) {
            ge2.e.setVisibility(0);
            ge2.e.setTag((Object)ge2.a.getText());
            ge2.e.setOnClickListener((View.OnClickListener)this);
            return;
        }
        ge2.e.setVisibility(8);
    }

    @Override
    public CharSequence c(Cursor cursor) {
        String string;
        if (cursor == null) {
            return null;
        }
        String string2 = gd.a(cursor, "suggest_intent_query");
        if (string2 != null) {
            return string2;
        }
        if (this.l.shouldRewriteQueryFromData() && (string = gd.a(cursor, "suggest_intent_data")) != null) {
            return string;
        }
        if (!this.l.shouldRewriteQueryFromText()) return null;
        String string3 = gd.a(cursor, "suggest_text_1");
        if (string3 == null) return null;
        return string3;
    }

    @Override
    public View getView(int n2, View view, ViewGroup viewGroup) {
        try {
            return super.getView(n2, view, viewGroup);
        }
        catch (RuntimeException var4_5) {
            Log.w((String)"SuggestionsAdapter", (String)"Search suggestions cursor threw exception.", (Throwable)var4_5);
            View view2 = this.a(this.d, this.c, viewGroup);
            if (view2 == null) return view2;
            ((ge)view2.getTag()).a.setText((CharSequence)var4_5.toString());
            return view2;
        }
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.d(this.a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        this.d(this.a());
    }

    public void onClick(View view) {
        Object object = view.getTag();
        if (!(object instanceof CharSequence)) return;
        this.k.a((CharSequence)object);
    }
}

