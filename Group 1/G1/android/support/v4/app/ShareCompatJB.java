package android.support.v4.app;

import android.text.Html;

class ShareCompatJB
{
    ShareCompatJB() {
        super();
    }
    
    public static String escapeHtml(final CharSequence charSequence) {
        return Html.escapeHtml(charSequence);
    }
}
