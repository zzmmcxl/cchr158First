package android.support.v4.content;

import android.support.annotation.NonNull;
import android.content.SharedPreferences$Editor;

private static class EditorHelperApi9Impl implements Helper
{
    private EditorHelperApi9Impl() {
        super();
    }
    
    EditorHelperApi9Impl(final SharedPreferencesCompat$1 object) {
        this();
    }
    
    @Override
    public void apply(@NonNull final SharedPreferences$Editor sharedPreferences$Editor) {
        EditorCompatGingerbread.apply(sharedPreferences$Editor);
    }
}
