/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.hy;
import com.google.android.gms.b.mz;
import com.google.android.gms.b.nb;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class na
implements mz {
    private final nb a;
    private final SSLSocketFactory b;

    public na() {
        this(null);
    }

    public na(nb nb2) {
        this(nb2, null);
    }

    public na(nb nb2, SSLSocketFactory sSLSocketFactory) {
        this.a = nb2;
        this.b = sSLSocketFactory;
    }

    private HttpURLConnection a(URL uRL, hy hy2) {
        HttpURLConnection httpURLConnection = this.a(uRL);
        int n2 = hy2.r();
        httpURLConnection.setConnectTimeout(n2);
        httpURLConnection.setReadTimeout(n2);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        if (!"https".equals(uRL.getProtocol())) return httpURLConnection;
        if (this.b == null) return httpURLConnection;
        ((HttpsURLConnection)httpURLConnection).setSSLSocketFactory(this.b);
        return httpURLConnection;
    }

    private static HttpEntity a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            InputStream inputStream2;
            inputStream = inputStream2 = httpURLConnection.getInputStream();
        }
        catch (IOException var2_4) {
            inputStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(inputStream);
        basicHttpEntity.setContentLength((long)httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    static void a(HttpURLConnection httpURLConnection, hy hy2) {
        switch (hy2.b()) {
            default: {
                throw new IllegalStateException("Unknown method type.");
            }
            case -1: {
                byte[] arrby = hy2.k();
                if (arrby == null) return;
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.addRequestProperty("Content-Type", hy2.j());
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.write(arrby);
                dataOutputStream.close();
                return;
            }
            case 0: {
                httpURLConnection.setRequestMethod("GET");
                return;
            }
            case 3: {
                httpURLConnection.setRequestMethod("DELETE");
                return;
            }
            case 1: {
                httpURLConnection.setRequestMethod("POST");
                na.b(httpURLConnection, hy2);
                return;
            }
            case 2: {
                httpURLConnection.setRequestMethod("PUT");
                na.b(httpURLConnection, hy2);
                return;
            }
            case 4: {
                httpURLConnection.setRequestMethod("HEAD");
                return;
            }
            case 5: {
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            }
            case 6: {
                httpURLConnection.setRequestMethod("TRACE");
                return;
            }
            case 7: 
        }
        httpURLConnection.setRequestMethod("PATCH");
        na.b(httpURLConnection, hy2);
    }

    private static void b(HttpURLConnection httpURLConnection, hy hy2) {
        byte[] arrby = hy2.o();
        if (arrby == null) return;
        httpURLConnection.setDoOutput(true);
        httpURLConnection.addRequestProperty("Content-Type", hy2.n());
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(arrby);
        dataOutputStream.close();
    }

    protected HttpURLConnection a(URL uRL) {
        return (HttpURLConnection)uRL.openConnection();
    }

    @Override
    public HttpResponse a(hy hy2, Map map) {
        String string;
        String string2 = hy2.d();
        HashMap hashMap = new HashMap();
        hashMap.putAll(hy2.a());
        hashMap.putAll(map);
        if (this.a != null) {
            string = this.a.a(string2);
            if (string == null) {
                throw new IOException("URL blocked by rewriter: " + string2);
            }
        } else {
            string = string2;
        }
        HttpURLConnection httpURLConnection = this.a(new URL(string), hy2);
        for (String string3 : hashMap.keySet()) {
            httpURLConnection.addRequestProperty(string3, (String)hashMap.get(string3));
        }
        na.a(httpURLConnection, hy2);
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (httpURLConnection.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse((StatusLine)new BasicStatusLine(protocolVersion, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage()));
        basicHttpResponse.setEntity(na.a(httpURLConnection));
        Iterator<Map.Entry<String, List<String>>> iterator = httpURLConnection.getHeaderFields().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> entry = iterator.next();
            if (entry.getKey() == null) continue;
            basicHttpResponse.addHeader((Header)new BasicHeader(entry.getKey(), entry.getValue().get(0)));
        }
        return basicHttpResponse;
    }
}

