package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.auth.api.signin.zzd;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlf.zza;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class zzlh extends zzlg {
    public static final List<String> zzYf;
    private Class<?> zzYg;
    private Class<?> zzYh;
    private Object zzYi;
    private Object zzYj;

    /* renamed from: com.google.android.gms.internal.zzlh.1 */
    class C04721 implements InvocationHandler {
        final /* synthetic */ Class zzYk;
        final /* synthetic */ zzlh zzYl;

        C04721(zzlh com_google_android_gms_internal_zzlh, Class cls) {
            this.zzYl = com_google_android_gms_internal_zzlh;
            this.zzYk = cls;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Class cls = Class.forName("com.facebook.SessionState");
            Class[] parameterTypes = method.getParameterTypes();
            if (method.getName().equals(NotificationCompatApi21.CATEGORY_CALL) && parameterTypes.length == 3 && parameterTypes[0] == this.zzYk && parameterTypes[1] == cls && parameterTypes[2] == Exception.class) {
                if (((Boolean) this.zzYk.getDeclaredMethod("isOpened", new Class[0]).invoke(args[0], new Object[0])).booleanValue()) {
                    this.zzYl.zznt().zzk(this.zzYl.zza(IdpTokenType.zzXA, (String) this.zzYk.getDeclaredMethod("getAccessToken", new Class[0]).invoke(args[0], new Object[0]), this.zzYl.zznu()));
                }
                return null;
            }
            throw new ExceptionInInitializerError("Method not supported!");
        }
    }

    static {
        zzYf = Collections.singletonList(Scopes.EMAIL);
    }

    public zzlh(Activity activity, List<String> list) {
        super(activity, zzYf, list);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zzag(android.content.Context r5) throws java.lang.IllegalStateException {
        /*
        com.google.android.gms.common.internal.zzx.zzz(r5);
        r0 = "com.facebook.FacebookSdk";
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x006b }
        r1 = "sdkInitialize";
        r2 = 2;
        r2 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x00ab, InvocationTargetException -> 0x00ad }
        r3 = 0;
        r4 = android.content.Context.class;
        r2[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x00ab, InvocationTargetException -> 0x00ad }
        r3 = 1;
        r4 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x00ab, InvocationTargetException -> 0x00ad }
        r2[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x00ab, InvocationTargetException -> 0x00ad }
        r0 = r0.getDeclaredMethod(r1, r2);	 Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x00ab, InvocationTargetException -> 0x00ad }
        r1 = 0;
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x00ab, InvocationTargetException -> 0x00ad }
        r3 = 0;
        r4 = r5.getApplicationContext();	 Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x00ab, InvocationTargetException -> 0x00ad }
        r2[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x00ab, InvocationTargetException -> 0x00ad }
        r3 = 1;
        r4 = 64206; // 0xface float:8.9972E-41 double:3.1722E-319;
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x00ab, InvocationTargetException -> 0x00ad }
        r2[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x00ab, InvocationTargetException -> 0x00ad }
        r0.invoke(r1, r2);	 Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x00ab, InvocationTargetException -> 0x00ad }
        r0 = "com.facebook.login.LoginManager";
        r0 = java.lang.Class.forName(r0);	 Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x00ab, InvocationTargetException -> 0x00ad }
        r1 = "getInstance";
        r2 = 0;
        r2 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x00ab, InvocationTargetException -> 0x00ad }
        r1 = r0.getDeclaredMethod(r1, r2);	 Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x00ab, InvocationTargetException -> 0x00ad }
        r2 = 0;
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x00ab, InvocationTargetException -> 0x00ad }
        r1 = r1.invoke(r2, r3);	 Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x00ab, InvocationTargetException -> 0x00ad }
        r2 = "logOut";
        r3 = 0;
        r3 = new java.lang.Class[r3];	 Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x00ab, InvocationTargetException -> 0x00ad }
        r0 = r0.getDeclaredMethod(r2, r3);	 Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x00ab, InvocationTargetException -> 0x00ad }
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x00ab, InvocationTargetException -> 0x00ad }
        r0.invoke(r1, r2);	 Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x00ab, InvocationTargetException -> 0x00ad }
    L_0x005a:
        return;
    L_0x005b:
        r0 = move-exception;
    L_0x005c:
        r1 = "AuthSignInClient";
        r2 = "Facebook logout error.";
        android.util.Log.e(r1, r2, r0);	 Catch:{ ClassNotFoundException -> 0x006b }
        r0 = new java.lang.IllegalStateException;	 Catch:{ ClassNotFoundException -> 0x006b }
        r1 = "No supported Facebook SDK version found to use Facebook logout.";
        r0.<init>(r1);	 Catch:{ ClassNotFoundException -> 0x006b }
        throw r0;	 Catch:{ ClassNotFoundException -> 0x006b }
    L_0x006b:
        r0 = move-exception;
        r0 = "com.facebook.Session";
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0095, NoSuchMethodException -> 0x00a5, IllegalAccessException -> 0x00a7, InvocationTargetException -> 0x00a9 }
        r1 = "getActiveSession";
        r2 = 0;
        r2 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0095, NoSuchMethodException -> 0x00a5, IllegalAccessException -> 0x00a7, InvocationTargetException -> 0x00a9 }
        r1 = r0.getDeclaredMethod(r1, r2);	 Catch:{ ClassNotFoundException -> 0x0095, NoSuchMethodException -> 0x00a5, IllegalAccessException -> 0x00a7, InvocationTargetException -> 0x00a9 }
        r2 = 0;
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ ClassNotFoundException -> 0x0095, NoSuchMethodException -> 0x00a5, IllegalAccessException -> 0x00a7, InvocationTargetException -> 0x00a9 }
        r1 = r1.invoke(r2, r3);	 Catch:{ ClassNotFoundException -> 0x0095, NoSuchMethodException -> 0x00a5, IllegalAccessException -> 0x00a7, InvocationTargetException -> 0x00a9 }
        if (r1 == 0) goto L_0x005a;
    L_0x0085:
        r2 = "closeAndClearTokenInformation";
        r3 = 0;
        r3 = new java.lang.Class[r3];	 Catch:{ ClassNotFoundException -> 0x0095, NoSuchMethodException -> 0x00a5, IllegalAccessException -> 0x00a7, InvocationTargetException -> 0x00a9 }
        r0 = r0.getDeclaredMethod(r2, r3);	 Catch:{ ClassNotFoundException -> 0x0095, NoSuchMethodException -> 0x00a5, IllegalAccessException -> 0x00a7, InvocationTargetException -> 0x00a9 }
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ ClassNotFoundException -> 0x0095, NoSuchMethodException -> 0x00a5, IllegalAccessException -> 0x00a7, InvocationTargetException -> 0x00a9 }
        r0.invoke(r1, r2);	 Catch:{ ClassNotFoundException -> 0x0095, NoSuchMethodException -> 0x00a5, IllegalAccessException -> 0x00a7, InvocationTargetException -> 0x00a9 }
        goto L_0x005a;
    L_0x0095:
        r0 = move-exception;
    L_0x0096:
        r1 = "AuthSignInClient";
        r2 = "Facebook logout error.";
        android.util.Log.e(r1, r2, r0);
        r0 = new java.lang.IllegalStateException;
        r1 = "No supported Facebook SDK version found to use Facebook logout.";
        r0.<init>(r1);
        throw r0;
    L_0x00a5:
        r0 = move-exception;
        goto L_0x0096;
    L_0x00a7:
        r0 = move-exception;
        goto L_0x0096;
    L_0x00a9:
        r0 = move-exception;
        goto L_0x0096;
    L_0x00ab:
        r0 = move-exception;
        goto L_0x005c;
    L_0x00ad:
        r0 = move-exception;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzlh.zzag(android.content.Context):void");
    }

    private void zznv() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (this.zzYj != null) {
            Class.forName("com.facebook.login.LoginManager").getDeclaredMethod("logInWithReadPermissions", new Class[]{Activity.class, Collection.class}).invoke(this.zzYj, new Object[]{this.mActivity, new ArrayList(zzns())});
            return;
        }
        Class cls = Class.forName("com.facebook.Session$OpenRequest");
        Object newInstance = cls.getConstructor(new Class[]{Activity.class}).newInstance(new Object[]{this.mActivity});
        cls.getDeclaredMethod("setPermissions", new Class[]{List.class}).invoke(newInstance, new Object[]{new ArrayList(zzns())});
        cls.getDeclaredMethod("setRequestCode", new Class[]{Integer.TYPE}).invoke(newInstance, new Object[]{Integer.valueOf(64206)});
        Class cls2 = Class.forName("com.facebook.Session");
        cls.getDeclaredMethod("setCallback", new Class[]{Class.forName("com.facebook.Session$StatusCallback")}).invoke(newInstance, new Object[]{zznw()});
        Object newInstance2 = cls2.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.mActivity});
        cls2.getDeclaredMethod("setActiveSession", new Class[]{cls2}).invoke(null, new Object[]{newInstance2});
        cls2.getDeclaredMethod("openForRead", new Class[]{cls}).invoke(newInstance2, new Object[]{newInstance});
    }

    private Object zznw() throws ClassNotFoundException {
        Class cls = Class.forName("com.facebook.Session");
        return Proxy.newProxyInstance(Class.forName("com.facebook.Session$StatusCallback").getClassLoader(), new Class[]{r1}, new C04721(this, cls));
    }

    public void zza(zza com_google_android_gms_internal_zzlf_zza) {
        Throwable e;
        zzb(null, null, (zza) zzx.zzz(com_google_android_gms_internal_zzlf_zza));
        try {
            zznv();
        } catch (ClassNotFoundException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e3) {
            e = e3;
            throw new RuntimeException(e);
        } catch (IllegalAccessException e4) {
            e = e4;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new RuntimeException(e);
        } catch (InstantiationException e6) {
            e = e6;
            throw new RuntimeException(e);
        }
    }

    public void zza(String str, zza com_google_android_gms_internal_zzlf_zza) {
        Throwable e;
        zzb((String) zzx.zzz(str), null, (zza) zzx.zzz(com_google_android_gms_internal_zzlf_zza));
        try {
            zznv();
        } catch (ClassNotFoundException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e3) {
            e = e3;
            throw new RuntimeException(e);
        } catch (IllegalAccessException e4) {
            e = e4;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new RuntimeException(e);
        } catch (InstantiationException e6) {
            e = e6;
            throw new RuntimeException(e);
        }
    }

    public void zza(String str, String str2, zza com_google_android_gms_internal_zzlf_zza) {
        Throwable e;
        zzb((String) zzx.zzz(str), (String) zzx.zzz(str2), (zza) zzx.zzz(com_google_android_gms_internal_zzlf_zza));
        try {
            zznv();
        } catch (ClassNotFoundException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e3) {
            e = e3;
            throw new RuntimeException(e);
        } catch (IllegalAccessException e4) {
            e = e4;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new RuntimeException(e);
        } catch (InstantiationException e6) {
            e = e6;
            throw new RuntimeException(e);
        }
    }

    public boolean zza(int i, int i2, Intent intent, zza com_google_android_gms_internal_zzlf_zza) {
        Throwable e;
        zzb(com_google_android_gms_internal_zzlf_zza);
        if (i != 64206 && this.zzYg == null) {
            return false;
        }
        if (this.zzYg == null || this.zzYh == null || this.zzYi == null) {
            try {
                Class cls = Class.forName("com.facebook.Session");
                Object invoke = cls.getDeclaredMethod("getActiveSession", new Class[0]).invoke(null, new Object[0]);
                Method declaredMethod = cls.getDeclaredMethod("onActivityResult", new Class[]{Activity.class, Integer.TYPE, Integer.TYPE, Intent.class});
                if (invoke == null) {
                    return false;
                }
                return ((Boolean) declaredMethod.invoke(invoke, new Object[]{this.mActivity, Integer.valueOf(i), Integer.valueOf(i2), intent})).booleanValue();
            } catch (ClassNotFoundException e2) {
                e = e2;
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e3) {
                e = e3;
                throw new RuntimeException(e);
            } catch (IllegalAccessException e4) {
                e = e4;
                throw new RuntimeException(e);
            } catch (InvocationTargetException e5) {
                e = e5;
                throw new RuntimeException(e);
            }
        }
        try {
            if (!((Boolean) this.zzYg.getDeclaredMethod("isFacebookRequestCode", new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(i)})).booleanValue()) {
                return false;
            }
            return ((Boolean) this.zzYh.getDeclaredMethod("onActivityResult", new Class[]{Integer.TYPE, Integer.TYPE, Intent.class}).invoke(this.zzYi, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent})).booleanValue();
        } catch (NoSuchMethodException e6) {
            e = e6;
            throw new RuntimeException(e);
        } catch (IllegalAccessException e7) {
            e = e7;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e8) {
            e = e8;
            throw new RuntimeException(e);
        }
    }

    public zzd zzmU() {
        return zzd.FACEBOOK;
    }
}
