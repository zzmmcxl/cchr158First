package android.support.v4.util;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import android.util.Log;
import java.io.Writer;

public class LogWriter extends Writer
{
    private StringBuilder mBuilder;
    private final String mTag;
    
    public LogWriter(final String mTag) {
        super();
        mBuilder = new StringBuilder(128);
        mTag = mTag;
    }
    
    private void flushBuilder() {
        if (mBuilder.length() > 0) {
            Log.d(mTag, mBuilder.toString());
            mBuilder.delete(0, mBuilder.length());
        }
    }
    
    @Override
    public void close() {
        this.flushBuilder();
    }
    
    @Override
    public void flush() {
        this.flushBuilder();
    }
    
    @Override
    public void write(final char[] array, final int n, final int n2) {
        for (int i = 0; i < n2; ++i) {
            final char c = array[n + i];
            if (c == '\n') {
                this.flushBuilder();
            }
            else {
                mBuilder.append(c);
            }
        }
    }
}
