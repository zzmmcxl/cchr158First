package android.support.v4.text;

import java.util.Locale;

static class ICUCompatImplLollipop implements ICUCompatImpl
{
    ICUCompatImplLollipop() {
        super();
    }
    
    @Override
    public String maximizeAndGetScript(final Locale locale) {
        return ICUCompatApi23.maximizeAndGetScript(locale);
    }
}
