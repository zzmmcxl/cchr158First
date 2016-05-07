/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.hy;
import com.google.android.gms.b.mx;
import com.google.android.gms.b.mz;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class mw
implements mz {
    protected final HttpClient a;

    public mw(HttpClient httpClient) {
        this.a = httpClient;
    }

    private static void a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, hy hy2) {
        byte[] arrby = hy2.o();
        if (arrby == null) return;
        httpEntityEnclosingRequestBase.setEntity((HttpEntity)new ByteArrayEntity(arrby));
    }

    private static void a(HttpUriRequest httpUriRequest, Map map) {
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            httpUriRequest.setHeader(string, (String)map.get(string));
        }
    }

    static HttpUriRequest b(hy hy2, Map map) {
        switch (hy2.b()) {
            default: {
                throw new IllegalStateException("Unknown request method.");
            }
            case -1: {
                byte[] arrby = hy2.k();
                if (arrby == null) return new HttpGet(hy2.d());
                HttpPost httpPost = new HttpPost(hy2.d());
                httpPost.addHeader("Content-Type", hy2.j());
                httpPost.setEntity((HttpEntity)new ByteArrayEntity(arrby));
                return httpPost;
            }
            case 0: {
                return new HttpGet(hy2.d());
            }
            case 3: {
                return new HttpDelete(hy2.d());
            }
            case 1: {
                HttpPost httpPost = new HttpPost(hy2.d());
                httpPost.addHeader("Content-Type", hy2.n());
                mw.a((HttpEntityEnclosingRequestBase)httpPost, hy2);
                return httpPost;
            }
            case 2: {
                HttpPut httpPut = new HttpPut(hy2.d());
                httpPut.addHeader("Content-Type", hy2.n());
                mw.a((HttpEntityEnclosingRequestBase)httpPut, hy2);
                return httpPut;
            }
            case 4: {
                return new HttpHead(hy2.d());
            }
            case 5: {
                return new HttpOptions(hy2.d());
            }
            case 6: {
                return new HttpTrace(hy2.d());
            }
            case 7: 
        }
        mx mx2 = new mx(hy2.d());
        mx2.addHeader("Content-Type", hy2.n());
        mw.a(mx2, hy2);
        return mx2;
    }

    @Override
    public HttpResponse a(hy hy2, Map map) {
        HttpUriRequest httpUriRequest = mw.b(hy2, map);
        mw.a(httpUriRequest, map);
        mw.a(httpUriRequest, hy2.a());
        this.a(httpUriRequest);
        HttpParams httpParams = httpUriRequest.getParams();
        int n2 = hy2.r();
        HttpConnectionParams.setConnectionTimeout((HttpParams)httpParams, (int)5000);
        HttpConnectionParams.setSoTimeout((HttpParams)httpParams, (int)n2);
        return this.a.execute(httpUriRequest);
    }

    protected void a(HttpUriRequest httpUriRequest) {
    }
}

