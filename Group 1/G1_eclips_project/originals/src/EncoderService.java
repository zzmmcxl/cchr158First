package com.se702.hider.enigma;

import android.content.Intent;
import android.net.Uri;
import java.io.OutputStream;
import android.graphics.Point;
import java.io.File;
import android.graphics.Bitmap;
import android.app.IntentService;

public class EncoderService extends IntentService
{
    public Bitmap IIIIIIIII;
    public String IIIIIIlIl;
    public char IIIIlIIII;
    public String IIIllIIlI;
    public RandomPointGenerator IIlIIlIIl;
    public StringBuilder IIllIIIIl;
    public File IlIIIIIll;
    public char IlIIIllII;
    public String lIIIIlIIl;
    public int lIIIlIlll;
    public File lIIlIIIII;
    public int lIIlIIlII;
    public Point lIIlIllIl;
    public Bitmap lIIllIIII;
    public File lIIlllIII;
    public OutputStream lIlIlIlIl;
    public Uri llIIIIlII;
    public int lllIIIIlI;
    public Intent lllIllIlI;
    public int llllIIIIl;
    public int lllllIIII;
    public Uri lllllIllI;
    public String llllllllI;
    
    public EncoderService() {
        super(EncoderService.class.getName());
        IIIIlIIII = "\u0002\u0002".charAt(0);
        IlIIIllII = "\u0003\t".charAt(0);
    }
    
    private char getCharForBits(final String s) {
        return (char)Integer.parseInt(s, 2);
    }
    
    public String getBitsForPos(final String s, final int n) {
        IIIllIlIll.l(this, s, n);
        return IIllIIIIl.toString();
    }
    
    public File getFileDestination() {
        llllIIIIlI.l(this);
        if (!IlIIIIIll.exists() && !IlIIIIIll.mkdirs()) {
            return null;
        }
        lIllIIIlIl.l(this);
        return lIIlIIIII;
    }
    
    public void hideText(final Bitmap bitmap, final String s) {
        lllIllIIll.l(this, bitmap, s);
    }
    
    protected void onHandleIntent(final Intent intent) {
        llllllllll.I(this, intent);
    }
}
