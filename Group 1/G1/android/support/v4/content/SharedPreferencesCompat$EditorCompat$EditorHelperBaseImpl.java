package android.support.v4.content;

import android.support.annotation.NonNull;
import android.content.SharedPreferences$Editor;

private static class EditorHelperBaseImpl implements Helper
{
    private EditorHelperBaseImpl() {
        super();
    }
    
    EditorHelperBaseImpl(final SharedPreferencesCompat$1 object) {
        this();
    }
    
    @Override
    public void apply(@NonNull final SharedPreferences$Editor sharedPreferences$Editor) {
        sharedPreferences$Editor.commit();
    }
}
