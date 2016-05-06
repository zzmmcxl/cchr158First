package android.support.v4.content;

import android.support.annotation.NonNull;
import android.content.SharedPreferences$Editor;

class EditorCompatGingerbread
{
    EditorCompatGingerbread() {
        super();
    }
    
    public static void apply(@NonNull final SharedPreferences$Editor sharedPreferences$Editor) {
        try {
            sharedPreferences$Editor.apply();
        }
        catch (AbstractMethodError abstractMethodError) {
            sharedPreferences$Editor.commit();
        }
    }
}
