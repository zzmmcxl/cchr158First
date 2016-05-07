/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.ak;
import android.support.v7.widget.dv;
import java.util.List;

class du {
    final dv a;

    public du(dv dv2) {
        this.a = dv2;
    }

    private void a(List list, int n2, int n3) {
        ak ak2 = (ak)list.get(n2);
        ak ak3 = (ak)list.get(n3);
        switch (ak3.a) {
            default: {
                return;
            }
            case 2: {
                this.a(list, n2, ak2, n3, ak3);
                return;
            }
            case 1: {
                this.c(list, n2, ak2, n3, ak3);
                return;
            }
            case 4: 
        }
        this.b(list, n2, ak2, n3, ak3);
    }

    private int b(List list) {
        boolean bl2 = false;
        int n2 = -1 + list.size();
        while (n2 >= 0) {
            boolean bl3;
            if (((ak)list.get((int)n2)).a != 8) {
                bl3 = true;
            } else {
                if (bl2) {
                    return n2;
                }
                bl3 = bl2;
            }
            --n2;
            bl2 = bl3;
        }
        return -1;
    }

    private void c(List list, int n2, ak ak2, int n3, ak ak3) {
        int n4 = ak2.d;
        int n5 = ak3.b;
        int n6 = 0;
        if (n4 < n5) {
            n6 = -1;
        }
        if (ak2.b < ak3.b) {
            ++n6;
        }
        if (ak3.b <= ak2.b) {
            ak2.b += ak3.d;
        }
        if (ak3.b <= ak2.d) {
            ak2.d += ak3.d;
        }
        ak3.b = n6 + ak3.b;
        list.set(n2, ak3);
        list.set(n3, ak2);
    }

    void a(List list) {
        int n2;
        while ((n2 = this.b(list)) != -1) {
            this.a(list, n2, n2 + 1);
        }
    }

    void a(List list, int n2, ak ak2, int n3, ak ak3) {
        ak ak4;
        boolean bl2;
        boolean bl3 = false;
        if (ak2.b < ak2.d) {
            if (ak3.b == ak2.b && ak3.d == ak2.d - ak2.b) {
                bl2 = true;
            } else {
                bl3 = false;
                bl2 = false;
            }
        } else if (ak3.b == 1 + ak2.d && ak3.d == ak2.b - ak2.d) {
            bl3 = true;
            bl2 = true;
        } else {
            bl3 = true;
            bl2 = false;
        }
        if (ak2.d < ak3.b) {
            ak3.b = -1 + ak3.b;
        } else if (ak2.d < ak3.b + ak3.d) {
            ak3.d = -1 + ak3.d;
            ak2.a = 2;
            ak2.d = 1;
            if (ak3.d != 0) return;
            list.remove(n3);
            this.a.a(ak3);
            return;
        }
        if (ak2.b <= ak3.b) {
            ak3.b = 1 + ak3.b;
            ak4 = null;
        } else if (ak2.b < ak3.b + ak3.d) {
            int n4 = ak3.b + ak3.d - ak2.b;
            ak4 = this.a.a(2, 1 + ak2.b, n4, null);
            ak3.d = ak2.b - ak3.b;
        } else {
            ak4 = null;
        }
        if (bl2) {
            list.set(n2, ak3);
            list.remove(n3);
            this.a.a(ak2);
            return;
        }
        if (bl3) {
            if (ak4 != null) {
                if (ak2.b > ak4.b) {
                    ak2.b -= ak4.d;
                }
                if (ak2.d > ak4.b) {
                    ak2.d -= ak4.d;
                }
            }
            if (ak2.b > ak3.b) {
                ak2.b -= ak3.d;
            }
            if (ak2.d > ak3.b) {
                ak2.d -= ak3.d;
            }
        } else {
            if (ak4 != null) {
                if (ak2.b >= ak4.b) {
                    ak2.b -= ak4.d;
                }
                if (ak2.d >= ak4.b) {
                    ak2.d -= ak4.d;
                }
            }
            if (ak2.b >= ak3.b) {
                ak2.b -= ak3.d;
            }
            if (ak2.d >= ak3.b) {
                ak2.d -= ak3.d;
            }
        }
        list.set(n2, ak3);
        if (ak2.b != ak2.d) {
            list.set(n3, ak2);
        } else {
            list.remove(n3);
        }
        if (ak4 == null) return;
        list.add(n2, ak4);
    }

    void b(List list, int n2, ak ak2, int n3, ak ak3) {
        ak ak4;
        ak ak5 = null;
        if (ak2.d < ak3.b) {
            ak3.b = -1 + ak3.b;
            ak4 = null;
        } else if (ak2.d < ak3.b + ak3.d) {
            ak3.d = -1 + ak3.d;
            ak4 = this.a.a(4, ak2.b, 1, ak3.c);
        } else {
            ak4 = null;
        }
        if (ak2.b <= ak3.b) {
            ak3.b = 1 + ak3.b;
        } else {
            int n4 = ak2.b;
            int n5 = ak3.b + ak3.d;
            ak5 = null;
            if (n4 < n5) {
                int n6 = ak3.b + ak3.d - ak2.b;
                ak5 = this.a.a(4, 1 + ak2.b, n6, ak3.c);
                ak3.d -= n6;
            }
        }
        list.set(n3, ak2);
        if (ak3.d > 0) {
            list.set(n2, ak3);
        } else {
            list.remove(n2);
            this.a.a(ak3);
        }
        if (ak4 != null) {
            list.add(n2, ak4);
        }
        if (ak5 == null) return;
        list.add(n2, ak5);
    }
}

