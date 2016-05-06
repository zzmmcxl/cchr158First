package android.support.v4.os;

import android.os.CancellationSignal;

class CancellationSignalCompatJellybean
{
    CancellationSignalCompatJellybean() {
        super();
    }
    
    public static void cancel(final Object o) {
        ((CancellationSignal)o).cancel();
    }
    
    public static Object create() {
        return new CancellationSignal();
    }
}
