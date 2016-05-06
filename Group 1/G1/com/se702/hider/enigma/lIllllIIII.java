package com.se702.hider.enigma;

import android.provider.MediaStore$Images$Media;
import android.content.Intent;

public class lIllllIIII
{
    public lIllllIIII() {
        super();
    }
    
    public static void l(final DeencoderService deencoderService, final Intent intent) {
        try {
            deencoderService.IIIIlIIlI = MediaStore$Images$Media.getBitmap(deencoderService.getContentResolver(), deencoderService.lllIlIIIl);
        }
        catch (Exception ex) {}
    }
}
