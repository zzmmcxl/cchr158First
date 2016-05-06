package android.support.v4.content;

import java.io.File;
import android.net.Uri;

interface PathStrategy
{
    File getFileForUri(final Uri p0);
    
    Uri getUriForFile(final File p0);
}
