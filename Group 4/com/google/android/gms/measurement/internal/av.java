/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.aw;

public final class av {
    public static aw A;
    public static aw a;
    public static aw b;
    public static aw c;
    public static aw d;
    public static aw e;
    public static aw f;
    public static aw g;
    public static aw h;
    public static aw i;
    public static aw j;
    public static aw k;
    public static aw l;
    public static aw m;
    public static aw n;
    public static aw o;
    public static aw p;
    public static aw q;
    public static aw r;
    public static aw s;
    public static aw t;
    public static aw u;
    public static aw v;
    public static aw w;
    public static aw x;
    public static aw y;
    public static aw z;

    static {
        a = aw.a("measurement.service_enabled", true);
        b = aw.a("measurement.service_client_enabled", true);
        c = aw.a("measurement.log_tag", "GMPM", "GMPM-SVC");
        d = aw.a("measurement.ad_id_cache_time", 10000);
        e = aw.a("measurement.monitoring.sample_period_millis", 86400000);
        f = aw.a("measurement.config.cache_time", 86400000);
        g = aw.a("measurement.config.url_scheme", "https");
        h = aw.a("measurement.config.url_authority", "app-measurement.com");
        i = aw.a("measurement.upload.max_bundles", 100);
        j = aw.a("measurement.upload.max_batch_size", 65536);
        k = aw.a("measurement.upload.max_bundle_size", 65536);
        l = aw.a("measurement.upload.max_events_per_bundle", 1000);
        m = aw.a("measurement.upload.max_events_per_day", 100000);
        n = aw.a("measurement.upload.max_public_events_per_day", 50000);
        o = aw.a("measurement.upload.max_conversions_per_day", 500);
        p = aw.a("measurement.store.max_stored_events_per_app", 100000);
        q = aw.a("measurement.upload.url", "https://app-measurement.com/a");
        r = aw.a("measurement.upload.backoff_period", 43200000);
        s = aw.a("measurement.upload.window_interval", 3600000);
        t = aw.a("measurement.upload.interval", 3600000);
        u = aw.a("measurement.upload.stale_data_deletion_interval", 86400000);
        v = aw.a("measurement.upload.initial_upload_delay_time", 15000);
        w = aw.a("measurement.upload.retry_time", 1800000);
        x = aw.a("measurement.upload.retry_count", 6);
        y = aw.a("measurement.upload.max_queue_time", 2419200000L);
        z = aw.a("measurement.lifetimevalue.max_currency_tracked", 4);
        A = aw.a("measurement.service_client.idle_disconnect_millis", 5000);
    }
}

