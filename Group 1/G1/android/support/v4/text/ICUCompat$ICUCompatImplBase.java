package android.support.v4.text;

import java.util.Locale;

static class ICUCompatImplBase implements ICUCompatImpl
{
    ICUCompatImplBase() {
        super();
    }
    
    @Override
    public String maximizeAndGetScript(final Locale locale) {
        return null;
    }
}
