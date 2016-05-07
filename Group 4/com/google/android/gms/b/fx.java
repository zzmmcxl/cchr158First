/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.client.n;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.b.ad;
import com.google.android.gms.b.an;
import com.google.android.gms.b.f;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.fq;
import com.google.android.gms.b.fy;
import com.google.android.gms.b.gt;
import com.google.android.gms.b.hb;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.r;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@fi
public class fx {
    public static final Handler a = new fq(Looper.getMainLooper());
    private final Object b = new Object();
    private boolean c = true;
    private String d;
    private boolean e = false;

    static /* synthetic */ Object a(fx fx2) {
        return fx2.b;
    }

    static /* synthetic */ String a(fx fx2, String string) {
        fx2.d = string;
        return string;
    }

    private JSONArray a(Collection collection) {
        JSONArray jSONArray = new JSONArray();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.a(jSONArray, iterator.next());
        }
        return jSONArray;
    }

    private JSONObject a(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        Iterator iterator = bundle.keySet().iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            this.a(jSONObject, string, bundle.get(string));
        }
        return jSONObject;
    }

    public static void a(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
            return;
        }
        a.post(runnable);
    }

    private void a(JSONArray jSONArray, Object object) {
        if (object instanceof Bundle) {
            jSONArray.put((Object)this.a((Bundle)object));
            return;
        }
        if (object instanceof Map) {
            jSONArray.put((Object)this.a((Map)object));
            return;
        }
        if (object instanceof Collection) {
            jSONArray.put((Object)this.a((Collection)object));
            return;
        }
        if (object instanceof Object[]) {
            jSONArray.put((Object)this.a((Object[])object));
            return;
        }
        jSONArray.put(object);
    }

    private void a(JSONObject jSONObject, String string, Object object) {
        if (object instanceof Bundle) {
            jSONObject.put(string, (Object)this.a((Bundle)object));
            return;
        }
        if (object instanceof Map) {
            jSONObject.put(string, (Object)this.a((Map)object));
            return;
        }
        if (object instanceof Collection) {
            if (string == null) {
                string = "null";
            }
            jSONObject.put(string, (Object)this.a((Collection)object));
            return;
        }
        if (object instanceof Object[]) {
            jSONObject.put(string, (Object)this.a(Arrays.asList((Object[])object)));
            return;
        }
        jSONObject.put(string, object);
    }

    public int a(String string) {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException var2_3) {
            fp.d("Could not parse value:" + var2_3);
            return 0;
        }
    }

    public Bitmap a(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap((Bitmap)view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return bitmap;
    }

    public DisplayMetrics a(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public PopupWindow a(View view, int n2, int n3, boolean bl2) {
        return new PopupWindow(view, n2, n3, bl2);
    }

    String a() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("Mozilla/5.0 (Linux; U; Android");
        if (Build.VERSION.RELEASE != null) {
            stringBuffer.append(" ").append(Build.VERSION.RELEASE);
        }
        stringBuffer.append("; ").append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuffer.append("; ").append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuffer.append(" Build/").append(Build.DISPLAY);
            }
        }
        stringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuffer.toString();
    }

    protected String a(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    public String a(Context context, f f2, String string) {
        if (f2 == null) {
            return string;
        }
        try {
            Uri uri = Uri.parse((String)string);
            if (!f2.c(uri)) return uri.toString();
            uri = f2.a(uri, context);
            return uri.toString();
        }
        catch (Exception var4_6) {
            return string;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public String a(Context context, String string) {
        Object object = this.b;
        // MONITORENTER : object
        if (this.d != null) {
            String string2 = this.d;
            // MONITOREXIT : object
            return string2;
        }
        try {
            this.d = g.e().a(context);
        }
        catch (Exception var5_5) {}
        if (TextUtils.isEmpty((CharSequence)this.d)) {
            if (n.a().a()) {
                try {
                    this.d = this.a(context);
                }
                catch (Exception var7_9) {
                    this.d = this.a();
                }
            } else {
                String string3;
                this.d = null;
                a.post((Runnable)new fy(this, context));
                while ((string3 = this.d) == null) {
                    try {
                        this.b.wait();
                    }
                    catch (InterruptedException var10_7) {
                        this.d = this.a();
                        fp.d("Interrupted, use default user agent: " + this.d);
                    }
                }
            }
        }
        String string4 = this.d = this.d + " (Mobile; " + string + ")";
        // MONITOREXIT : object
        return string4;
    }

    public String a(hb hb2, String string) {
        return this.a(hb2.getContext(), hb2.m(), string);
    }

    public Map a(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        Iterator iterator = g.e().a(uri).iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            hashMap.put(string, uri.getQueryParameter(string));
        }
        return hashMap;
    }

    JSONArray a(Object[] arrobject) {
        JSONArray jSONArray = new JSONArray();
        int n2 = arrobject.length;
        int n3 = 0;
        while (n3 < n2) {
            this.a(jSONArray, arrobject[n3]);
            ++n3;
        }
        return jSONArray;
    }

    public JSONObject a(Map map) {
        try {
            JSONObject jSONObject = new JSONObject();
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String string = (String)iterator.next();
                this.a(jSONObject, string, map.get(string));
            }
            return jSONObject;
        }
        catch (ClassCastException var3_5) {
            throw new JSONException("Could not convert map to JSON: " + var3_5.getMessage());
        }
    }

    public void a(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window == null) return;
        if (window.getDecorView() == null) return;
        if (window.getDecorView().getViewTreeObserver() == null) return;
        window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public void a(Activity activity, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window == null) return;
        if (window.getDecorView() == null) return;
        if (window.getDecorView().getViewTreeObserver() == null) return;
        window.getDecorView().getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
    }

    public void a(Context context, Intent intent) {
        try {
            context.startActivity(intent);
            return;
        }
        catch (Throwable var3_3) {
            intent.addFlags(268435456);
            context.startActivity(intent);
            return;
        }
    }

    public void a(Context context, String string, WebSettings webSettings) {
        webSettings.setUserAgentString(this.a(context, string));
    }

    public void a(Context context, String string, String string2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(string2);
        this.a(context, string, arrayList);
    }

    public void a(Context context, String string, String string2, Bundle bundle, boolean bl2) {
        if (bl2) {
            Context context2 = context.getApplicationContext();
            if (context2 == null) {
                context2 = context;
            }
            bundle.putString("os", Build.VERSION.RELEASE);
            bundle.putString("api", String.valueOf(Build.VERSION.SDK_INT));
            bundle.putString("device", g.c().c());
            bundle.putString("appid", context2.getPackageName());
            bundle.putString("eids", TextUtils.join((CharSequence)",", (Iterable)an.a()));
            if (string != null) {
                bundle.putString("js", string);
            } else {
                bundle.putString("gmscore_version", Integer.toString(r.g(context)));
            }
        }
        Uri.Builder builder = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", string2);
        Iterator iterator = bundle.keySet().iterator();
        do {
            if (!iterator.hasNext()) {
                g.c().a(context, string, builder.toString());
                return;
            }
            String string3 = (String)iterator.next();
            builder.appendQueryParameter(string3, bundle.getString(string3));
        } while (true);
    }

    public void a(Context context, String string, List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            new gt(context, string, (String)iterator.next()).b();
        }
    }

    public void a(Context context, String string, List list, String string2) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            new gt(context, string, (String)iterator.next(), string2).b();
        }
    }

    public void a(Context context, String string, boolean bl2, HttpURLConnection httpURLConnection) {
        this.a(context, string, bl2, httpURLConnection, false);
    }

    public void a(Context context, String string, boolean bl2, HttpURLConnection httpURLConnection, String string2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(bl2);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", string2);
        httpURLConnection.setUseCaches(false);
    }

    public void a(Context context, String string, boolean bl2, HttpURLConnection httpURLConnection, boolean bl3) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(bl2);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", this.a(context, string));
        httpURLConnection.setUseCaches(bl3);
    }

    public boolean a(PackageManager packageManager, String string, String string2) {
        if (packageManager.checkPermission(string2, string) != 0) return false;
        return true;
    }

    public int[] a(Activity activity) {
        Window window = activity.getWindow();
        if (window == null) return this.d();
        View view = window.findViewById(16908290);
        if (view == null) return this.d();
        int[] arrn = new int[]{view.getWidth(), view.getHeight()};
        return arrn;
    }

    public AlertDialog.Builder b(Context context) {
        return new AlertDialog.Builder(context);
    }

    public Bitmap b(Context context, String string) {
        bf.c("getBackgroundImage must not be called on the main UI thread.");
        try {
            FileInputStream fileInputStream = context.openFileInput(string);
            Bitmap bitmap = BitmapFactory.decodeStream((InputStream)fileInputStream);
            fileInputStream.close();
            return bitmap;
        }
        catch (Exception var3_5) {
            fp.b("Fail to get background image");
            return null;
        }
    }

    public String b() {
        UUID uUID = UUID.randomUUID();
        byte[] arrby = BigInteger.valueOf(uUID.getLeastSignificantBits()).toByteArray();
        byte[] arrby2 = BigInteger.valueOf(uUID.getMostSignificantBits()).toByteArray();
        String string = new BigInteger(1, arrby).toString();
        int n2 = 0;
        while (n2 < 2) {
            try {
                String string2;
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(arrby);
                messageDigest.update(arrby2);
                byte[] arrby3 = new byte[8];
                System.arraycopy(messageDigest.digest(), 0, arrby3, 0, 8);
                string = string2 = new BigInteger(1, arrby3).toString();
            }
            catch (NoSuchAlgorithmException var6_6) {}
            ++n2;
        }
        return string;
    }

    public void b(Activity activity, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window == null) return;
        if (window.getDecorView() == null) return;
        if (window.getDecorView().getViewTreeObserver() == null) return;
        window.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
    }

    public boolean b(String string) {
        if (!TextUtils.isEmpty((CharSequence)string)) return string.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
        return false;
    }

    public int[] b(Activity activity) {
        int[] arrn = this.a(activity);
        int[] arrn2 = new int[]{n.a().b((Context)activity, arrn[0]), n.a().b((Context)activity, arrn[1])};
        return arrn2;
    }

    public ad c(Context context) {
        return new ad(context);
    }

    public String c() {
        String string = Build.MODEL;
        String string2 = Build.MANUFACTURER;
        if (!string.startsWith(string2)) return string2 + " " + string;
        return string;
    }

    public int[] c(Activity activity) {
        Window window = activity.getWindow();
        if (window == null) return this.d();
        View view = window.findViewById(16908290);
        if (view == null) return this.d();
        int[] arrn = new int[]{view.getTop(), view.getBottom()};
        return arrn;
    }

    protected int[] d() {
        return new int[]{0, 0};
    }

    public int[] d(Activity activity) {
        int[] arrn = this.c(activity);
        int[] arrn2 = new int[]{n.a().b((Context)activity, arrn[0]), n.a().b((Context)activity, arrn[1])};
        return arrn2;
    }
}

