/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.mj;
import com.google.android.gms.b.mm;
import com.google.android.gms.b.mo;
import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class mi {
    private final ByteBuffer a;

    private mi(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        this.a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private mi(byte[] arrby, int n2, int n3) {
        this(ByteBuffer.wrap(arrby, n2, n3));
    }

    private static int a(CharSequence charSequence) {
        int n2 = charSequence.length();
        for (int i2 = 0; i2 < n2 && charSequence.charAt(i2) < '?'; ++i2) {
        }
        int n3 = n2;
        for (int i3 = i2; i3 < n2; ++i3) {
            char c2 = charSequence.charAt(i3);
            if (c2 < '\u0800') {
                int n4 = n3 + (127 - c2 >>> 31);
                n3 = n4;
                continue;
            }
            n3 += mi.a(charSequence, i3);
            break;
        }
        if (n3 >= n2) return n3;
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (0x100000000L + (long)n3));
    }

    private static int a(CharSequence charSequence, int n2) {
        int n3 = charSequence.length();
        int n4 = 0;
        int n5 = n2;
        while (n5 < n3) {
            char c2 = charSequence.charAt(n5);
            if (c2 < '\u0800') {
                n4 += 127 - c2 >>> 31;
            } else {
                n4 += 2;
                if ('\ud800' <= c2 && c2 <= '\udfff') {
                    if (Character.codePointAt(charSequence, n5) < 65536) {
                        throw new IllegalArgumentException("Unpaired surrogate at index " + n5);
                    }
                    ++n5;
                }
            }
            ++n5;
        }
        return n4;
    }

    private static int a(CharSequence charSequence, byte[] arrby, int n2, int n3) {
        char c2;
        int n4;
        int n5 = charSequence.length();
        int n6 = n2 + n3;
        for (n4 = 0; n4 < n5 && n4 + n2 < n6 && (c2 = charSequence.charAt(n4)) < '?'; ++n4) {
            arrby[n2 + n4] = (byte)c2;
        }
        if (n4 == n5) {
            return n2 + n5;
        }
        int n7 = n2 + n4;
        while (n4 < n5) {
            int n8;
            char c3 = charSequence.charAt(n4);
            if (c3 < '?' && n7 < n6) {
                n8 = n7 + 1;
                arrby[n7] = (byte)c3;
            } else if (c3 < '\u0800' && n7 <= n6 - 2) {
                int n9 = n7 + 1;
                arrby[n7] = (byte)(960 | c3 >>> 6);
                n8 = n9 + 1;
                arrby[n9] = (byte)(128 | c3 & 63);
            } else if ((c3 < '\ud800' || '\udfff' < c3) && n7 <= n6 - 3) {
                int n10 = n7 + 1;
                arrby[n7] = (byte)(480 | c3 >>> 12);
                int n11 = n10 + 1;
                arrby[n10] = (byte)(128 | 63 & c3 >>> 6);
                n8 = n11 + 1;
                arrby[n11] = (byte)(128 | c3 & 63);
            } else {
                char c4;
                if (n7 > n6 - 4) {
                    if ('\ud800' > c3) throw new ArrayIndexOutOfBoundsException("Failed writing " + c3 + " at index " + n7);
                    if (c3 > '\udfff') throw new ArrayIndexOutOfBoundsException("Failed writing " + c3 + " at index " + n7);
                    if (n4 + 1 == charSequence.length()) throw new IllegalArgumentException("Unpaired surrogate at index " + n4);
                    if (Character.isSurrogatePair(c3, charSequence.charAt(n4 + 1))) throw new ArrayIndexOutOfBoundsException("Failed writing " + c3 + " at index " + n7);
                    throw new IllegalArgumentException("Unpaired surrogate at index " + n4);
                }
                if (n4 + 1 == charSequence.length()) throw new IllegalArgumentException("Unpaired surrogate at index " + (n4 - 1));
                if (!Character.isSurrogatePair(c3, c4 = charSequence.charAt(++n4))) {
                    throw new IllegalArgumentException("Unpaired surrogate at index " + (n4 - 1));
                }
                int n12 = Character.toCodePoint(c3, c4);
                int n13 = n7 + 1;
                arrby[n7] = (byte)(240 | n12 >>> 18);
                int n14 = n13 + 1;
                arrby[n13] = (byte)(128 | 63 & n12 >>> 12);
                int n15 = n14 + 1;
                arrby[n14] = (byte)(128 | 63 & n12 >>> 6);
                n8 = n15 + 1;
                arrby[n15] = (byte)(128 | n12 & 63);
            }
            ++n4;
            n7 = n8;
        }
        return n7;
    }

    public static mi a(byte[] arrby) {
        return mi.a(arrby, 0, arrby.length);
    }

    public static mi a(byte[] arrby, int n2, int n3) {
        return new mi(arrby, n2, n3);
    }

    private static void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (!byteBuffer.hasArray()) {
            mi.b(charSequence, byteBuffer);
            return;
        }
        try {
            byteBuffer.position(mi.a(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            return;
        }
        catch (ArrayIndexOutOfBoundsException var2_2) {
            BufferOverflowException bufferOverflowException = new BufferOverflowException();
            bufferOverflowException.initCause(var2_2);
            throw bufferOverflowException;
        }
    }

    public static int b(float f2) {
        return 4;
    }

    public static int b(int n2) {
        if (n2 < 0) return 10;
        return mi.f(n2);
    }

    public static int b(int n2, float f2) {
        return mi.d(n2) + mi.b(f2);
    }

    public static int b(int n2, int n3) {
        return mi.d(n2) + mi.b(n3);
    }

    public static int b(int n2, mm mm2) {
        return mi.d(n2) + mi.b(mm2);
    }

    public static int b(int n2, String string) {
        return mi.d(n2) + mi.b(string);
    }

    public static int b(int n2, boolean bl2) {
        return mi.d(n2) + mi.b(bl2);
    }

    public static int b(mm mm2) {
        int n2 = mm2.e();
        return n2 + mi.f(n2);
    }

    public static int b(String string) {
        int n2 = mi.a(string);
        return n2 + mi.f(n2);
    }

    public static int b(boolean bl2) {
        return 1;
    }

    private static void b(CharSequence charSequence, ByteBuffer byteBuffer) {
        int n2 = charSequence.length();
        int n3 = 0;
        while (n3 < n2) {
            char c2 = charSequence.charAt(n3);
            if (c2 < '?') {
                byteBuffer.put((byte)c2);
            } else if (c2 < '\u0800') {
                byteBuffer.put((byte)(960 | c2 >>> 6));
                byteBuffer.put((byte)(128 | c2 & 63));
            } else if (c2 < '\ud800' || '\udfff' < c2) {
                byteBuffer.put((byte)(480 | c2 >>> 12));
                byteBuffer.put((byte)(128 | 63 & c2 >>> 6));
                byteBuffer.put((byte)(128 | c2 & 63));
            } else {
                char c3;
                if (n3 + 1 == charSequence.length()) throw new IllegalArgumentException("Unpaired surrogate at index " + (n3 - 1));
                if (!Character.isSurrogatePair(c2, c3 = charSequence.charAt(++n3))) {
                    throw new IllegalArgumentException("Unpaired surrogate at index " + (n3 - 1));
                }
                int n4 = Character.toCodePoint(c2, c3);
                byteBuffer.put((byte)(240 | n4 >>> 18));
                byteBuffer.put((byte)(128 | 63 & n4 >>> 12));
                byteBuffer.put((byte)(128 | 63 & n4 >>> 6));
                byteBuffer.put((byte)(128 | n4 & 63));
            }
            ++n3;
        }
    }

    public static int c(int n2, long l2) {
        return mi.d(n2) + mi.d(l2);
    }

    public static int c(long l2) {
        return mi.f(l2);
    }

    public static int d(int n2) {
        return mi.f(mo.a(n2, 0));
    }

    public static int d(long l2) {
        return mi.f(l2);
    }

    public static int f(int n2) {
        if ((n2 & -128) == 0) {
            return 1;
        }
        if ((n2 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & n2) == 0) {
            return 3;
        }
        if ((-268435456 & n2) != 0) return 5;
        return 4;
    }

    public static int f(long l2) {
        if ((-128 & l2) == 0) {
            return 1;
        }
        if ((-16384 & l2) == 0) {
            return 2;
        }
        if ((-2097152 & l2) == 0) {
            return 3;
        }
        if ((-268435456 & l2) == 0) {
            return 4;
        }
        if ((-34359738368L & l2) == 0) {
            return 5;
        }
        if ((-4398046511104L & l2) == 0) {
            return 6;
        }
        if ((-562949953421312L & l2) == 0) {
            return 7;
        }
        if ((-72057594037927936L & l2) == 0) {
            return 8;
        }
        if ((Long.MIN_VALUE & l2) != 0) return 10;
        return 9;
    }

    public int a() {
        return this.a.remaining();
    }

    public void a(byte by2) {
        if (!this.a.hasRemaining()) {
            throw new mj(this.a.position(), this.a.limit());
        }
        this.a.put(by2);
    }

    public void a(float f2) {
        this.g(Float.floatToIntBits(f2));
    }

    public void a(int n2) {
        if (n2 >= 0) {
            this.e(n2);
            return;
        }
        this.e((long)n2);
    }

    public void a(int n2, float f2) {
        this.c(n2, 5);
        this.a(f2);
    }

    public void a(int n2, int n3) {
        this.c(n2, 0);
        this.a(n3);
    }

    public void a(int n2, long l2) {
        this.c(n2, 0);
        this.a(l2);
    }

    public void a(int n2, mm mm2) {
        this.c(n2, 2);
        this.a(mm2);
    }

    public void a(int n2, String string) {
        this.c(n2, 2);
        this.a(string);
    }

    public void a(int n2, boolean bl2) {
        this.c(n2, 0);
        this.a(bl2);
    }

    public void a(long l2) {
        this.e(l2);
    }

    public void a(mm mm2) {
        this.e(mm2.d());
        mm2.a(this);
    }

    public void a(String string) {
        try {
            int n2 = mi.f(string.length());
            if (n2 == mi.f(3 * string.length())) {
                int n3 = this.a.position();
                if (this.a.remaining() < n2) {
                    throw new mj(n2 + n3, this.a.limit());
                }
                this.a.position(n3 + n2);
                mi.a((CharSequence)string, this.a);
                int n4 = this.a.position();
                this.a.position(n3);
                this.e(n4 - n3 - n2);
                this.a.position(n4);
                return;
            }
        }
        catch (BufferOverflowException var2_4) {
            mj mj2 = new mj(this.a.position(), this.a.limit());
            mj2.initCause(var2_4);
            throw mj2;
        }
        this.e(mi.a(string));
        mi.a((CharSequence)string, this.a);
    }

    public void a(boolean bl2) {
        int n2 = bl2 ? 1 : 0;
        this.c(n2);
    }

    public void b() {
        if (this.a() == 0) return;
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public void b(int n2, long l2) {
        this.c(n2, 0);
        this.b(l2);
    }

    public void b(long l2) {
        this.e(l2);
    }

    public void c(int n2) {
        this.a((byte)n2);
    }

    public void c(int n2, int n3) {
        this.e(mo.a(n2, n3));
    }

    public void e(int n2) {
        do {
            if ((n2 & -128) == 0) {
                this.c(n2);
                return;
            }
            this.c(128 | n2 & 127);
            n2 >>>= 7;
        } while (true);
    }

    public void e(long l2) {
        do {
            if ((-128 & l2) == 0) {
                this.c((int)l2);
                return;
            }
            this.c(128 | 127 & (int)l2);
            l2 >>>= 7;
        } while (true);
    }

    public void g(int n2) {
        if (this.a.remaining() < 4) {
            throw new mj(this.a.position(), this.a.limit());
        }
        this.a.putInt(n2);
    }
}

