package android.support.v4.text;

import java.util.Locale;

static class ICUCompatImplIcs implements ICUCompatImpl
{
    ICUCompatImplIcs() {
        super();
    }
    
    @Override
    public String maximizeAndGetScript(final Locale locale) {
        return ICUCompatIcs.maximizeAndGetScript(locale);
    }
}
