package android.support.v4.content;

import android.support.annotation.NonNull;
import android.content.SharedPreferences$Editor;
import android.os.Build$VERSION;

public static final class EditorCompat
{
    private static EditorCompat sInstance;
    private final Helper mHelper;
    
    private EditorCompat() {
        super();
        if (Build$VERSION.SDK_INT >= 9) {
            this.mHelper = (Helper)new EditorHelperApi9Impl();
            return;
        }
        this.mHelper = (Helper)new EditorHelperBaseImpl();
    }
    
    public static EditorCompat getInstance() {
        if (sInstance == null) {
            sInstance = new EditorCompat();
        }
        return sInstance;
    }
    
    public void apply(@NonNull final SharedPreferences$Editor sharedPreferences$Editor) {
        mHelper.apply(sharedPreferences$Editor);
    }
}
