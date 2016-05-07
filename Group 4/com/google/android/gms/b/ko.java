/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Binder;
import java.util.Iterator;
import java.util.List;

public class ko {
    public static String a(int n2, int n3) {
        StackTraceElement[] arrstackTraceElement = Thread.currentThread().getStackTrace();
        StringBuffer stringBuffer = new StringBuffer();
        int n4 = n3 + n2;
        while (n2 < n4) {
            stringBuffer.append(ko.a(arrstackTraceElement, n2)).append(" ");
            ++n2;
        }
        return stringBuffer.toString();
    }

    public static String a(Context context) {
        return ko.a(context, Binder.getCallingPid());
    }

    public static String a(Context context, int n2) {
        List list = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses();
        if (list == null) return null;
        Iterator iterator = list.iterator();
        do {
            if (!iterator.hasNext()) return null;
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)iterator.next();
        } while (runningAppProcessInfo.pid != n2);
        return runningAppProcessInfo.processName;
    }

    private static String a(StackTraceElement[] arrstackTraceElement, int n2) {
        if (n2 + 4 >= arrstackTraceElement.length) {
            return "<bottom of call stack>";
        }
        StackTraceElement stackTraceElement = arrstackTraceElement[n2 + 4];
        return stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber();
    }
}

