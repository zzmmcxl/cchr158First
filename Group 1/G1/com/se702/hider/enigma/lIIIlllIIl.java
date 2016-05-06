package com.se702.hider.enigma;

import android.graphics.Bitmap;

public class lIIIlllIIl
{
    public lIIIlllIIl() {
        super();
    }
    
    public static void l(final EncoderService encoderService, final Bitmap bitmap, final String s) {
        if (encoderService.lllIIIIlI % 2 == 1) {
            --encoderService.lllIIIIlI;
        }
        lllIlllIll.l(encoderService, bitmap, s);
    }
}
